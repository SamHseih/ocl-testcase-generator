package ccu.pllab.tcgen3.core.testscriptgen.stringtemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

record MethodVM(String displayName, // ex: "next - 1_1"
    String methodName, // ex: "next"
    String pathId, // ex: "1_1"
    String selfDecl, // ex: "Date self = new Date(1,12,31);"
    String callStmt, // ex: "var actual = self.next();"
    String expectedDecl, // ex: "int[] expected = new int[]{1,2,3};"
    String assertion, // ex: "assertArrayEquals(expected, actual);"
    boolean isThrows, // 是否 assertThrows
    String lambdaCall, // 例外 case: "new Date(-1, -1, -1)"
    String exceptionClass // ex: "Date.DateErrorException"
) {
}


public class DemoDateJunitTestCaseGen {
  public static void main(String[] args) {
    System.out.println("DemoTcgen");

    Path stgpath = Path.of(System.getProperty("user.dir")).resolve("example");
    Path stgpath2 = stgpath.resolve("TcGen.stg");

    /*
     * 1) 建立模板群組 若用 STGroupString(...)，參數要放「模板內容」本身，不是檔案路徑。 若要用檔案路徑載入模板，改用 STGroupFile(...)。
     */
    STGroup group = new STGroupFile(stgpath2.toString());

    // 2) 準備這個類別要產出的測試方法（重點：methods 這個變數有宣告也有賦值！）
    List<MethodVM> methods = new ArrayList<>();


    // 正常案例：Date.next()，Self = (1,12,31) → 結果 (2,1,1)
    methods.add(new MethodVM("next - 1_1", // displayName
        "Next", // methodName（用於 test 方法名，首字大寫）
        "1_1", // pathId
        "Date self = new Date(1, 12, 31);", // selfDecl
        "var actual = self.next();", // callStmt
        "int y=2, m=1, d=1;", // expectedDecl
        // assertion 可一次放多行，模板不會擋
        """
            assertEquals(y, actual.getYear());
            assertEquals(m, actual.getMonth());
            assertEquals(d, actual.getDay());
            """, false, // isThrows
        null, // exceptionClass
        null // lambdaCall
    ));

    // 正常案例：Date.next()，Self = (1,12,20) → 結果 (1,12,21)
    methods.add(new MethodVM("next - 1_2", // displayName
        "Next", // methodName（用於 test 方法名，首字大寫）
        "1_2", // pathId
        "Date self = new Date(1, 12, 20);", // selfDecl
        "var actual = self.next();", // callStmt
        "int y=1, m=12, d=21;", // expectedDecl
        // assertion 可一次放多行，模板不會擋
        """
            assertEquals(y, actual.getYear());
            assertEquals(m, actual.getMonth());
            assertEquals(d, actual.getDay());
            """, false, // isThrows
        null, // exceptionClass
        null // lambdaCall
    ));

    // 丟例外案例：new Date(-1,-1,-1) 期待 Date.DateErrorException
    methods.add(new MethodVM("Date - 1_1", // displayName
        "Date", // methodName（建構子就用類別名）
        "1_1", // pathId
        null, // selfDecl（丟例外不需要）
        null, // callStmt（丟例外不需要）
        null, // expectedDecl
        null, // assertion
        true, // isThrows
        "new Date(-1, -1, -1)", // lambdaCall
        "Date.DateErrorException" // exceptionClass

    ));

    // 3) 先把每一個方法用對應模板渲染成 ST 物件（或直接字串也可）
    List<ST> methodTemplates = new ArrayList<>();
    for (MethodVM m : methods) {
      if (m.isThrows()) {
        ST t = group.getInstanceOf("methodThrows");
        t.add("displayName", m.displayName());
        t.add("methodName", m.methodName());
        t.add("pathId", safeId(m.pathId()));
        t.add("exceptionClass", m.exceptionClass());
        t.add("lambdaCall", m.lambdaCall());
        methodTemplates.add(t);
      } else {
        ST t = group.getInstanceOf("methodNormal");
        t.add("displayName", m.displayName());
        t.add("methodName", m.methodName());
        t.add("pathId", safeId(m.pathId()));
        t.add("selfDecl", m.selfDecl());
        t.add("callStmt", m.callStmt());
        t.add("expectedDecl", m.expectedDecl());
        t.add("assertion", m.assertion());
        methodTemplates.add(t);
      }
    }

    // 4) 組測試類別
    String className = "Date"; // 這個示範只產 DateTest，一般情況你可迭代多個類別
    ST imports = group.getInstanceOf("imports");
    ST cls = group.getInstanceOf("testClass");
    cls.add("className", className);
    cls.add("imports", List.of(imports)); // 傳 ST 或字串都可
    cls.add("methods", methodTemplates); // ★ 這裡就是 methods 的來源

    String code = cls.render();

    // 5) 寫檔
    Path outDir = stgpath.resolve("tcgen3");
    try {
      Files.createDirectories(outDir);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      Files.write(outDir.resolve(outDir + "\\DateTest.java"),
          code.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("已輸出：" + outDir.resolve(className + "DateTest.java").toAbsolutePath());
  }

  /** 把 pathId 清成只含字母數字與底線，避免生成的方法名不合法 */
  private static String safeId(String s) {
    return s.replaceAll("[^0-9A-Za-z_]", "_");
  }
}
