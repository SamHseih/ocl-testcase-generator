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
    boolean isThrows, // �O�_ assertThrows
    String lambdaCall, // �ҥ~ case: "new Date(-1, -1, -1)"
    String exceptionClass // ex: "Date.DateErrorException"
) {
}


public class DemoDateJunitTestCaseGen {
  public static void main(String[] args) {
    System.out.println("DemoTcgen");

    Path stgpath = Path.of(System.getProperty("user.dir")).resolve("example");
    Path stgpath2 = stgpath.resolve("TcGen.stg");

    /*
     * 1) �إ߼ҪO�s�� �Y�� STGroupString(...)�A�Ѽƭn��u�ҪO���e�v�����A���O�ɮ׸��|�C �Y�n���ɮ׸��|���J�ҪO�A��� STGroupFile(...)�C
     */
    STGroup group = new STGroupFile(stgpath2.toString());

    // 2) �ǳƳo�����O�n���X�����դ�k�]���I�Gmethods �o���ܼƦ��ŧi�]����ȡI�^
    List<MethodVM> methods = new ArrayList<>();


    // ���`�רҡGDate.next()�ASelf = (1,12,31) �� ���G (2,1,1)
    methods.add(new MethodVM("next - 1_1", // displayName
        "Next", // methodName�]�Ω� test ��k�W�A���r�j�g�^
        "1_1", // pathId
        "Date self = new Date(1, 12, 31);", // selfDecl
        "var actual = self.next();", // callStmt
        "int y=2, m=1, d=1;", // expectedDecl
        // assertion �i�@����h��A�ҪO���|��
        """
            assertEquals(y, actual.getYear());
            assertEquals(m, actual.getMonth());
            assertEquals(d, actual.getDay());
            """, false, // isThrows
        null, // exceptionClass
        null // lambdaCall
    ));

    // ���`�רҡGDate.next()�ASelf = (1,12,20) �� ���G (1,12,21)
    methods.add(new MethodVM("next - 1_2", // displayName
        "Next", // methodName�]�Ω� test ��k�W�A���r�j�g�^
        "1_2", // pathId
        "Date self = new Date(1, 12, 20);", // selfDecl
        "var actual = self.next();", // callStmt
        "int y=1, m=12, d=21;", // expectedDecl
        // assertion �i�@����h��A�ҪO���|��
        """
            assertEquals(y, actual.getYear());
            assertEquals(m, actual.getMonth());
            assertEquals(d, actual.getDay());
            """, false, // isThrows
        null, // exceptionClass
        null // lambdaCall
    ));

    // ��ҥ~�רҡGnew Date(-1,-1,-1) ���� Date.DateErrorException
    methods.add(new MethodVM("Date - 1_1", // displayName
        "Date", // methodName�]�غc�l�N�����O�W�^
        "1_1", // pathId
        null, // selfDecl�]��ҥ~���ݭn�^
        null, // callStmt�]��ҥ~���ݭn�^
        null, // expectedDecl
        null, // assertion
        true, // isThrows
        "new Date(-1, -1, -1)", // lambdaCall
        "Date.DateErrorException" // exceptionClass

    ));

    // 3) ����C�@�Ӥ�k�ι����ҪO��V�� ST ����]�Ϊ����r��]�i�^
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

    // 4) �մ������O
    String className = "Date"; // �o�ӥܽd�u�� DateTest�A�@�뱡�p�A�i���N�h�����O
    ST imports = group.getInstanceOf("imports");
    ST cls = group.getInstanceOf("testClass");
    cls.add("className", className);
    cls.add("imports", List.of(imports)); // �� ST �Φr�곣�i
    cls.add("methods", methodTemplates); // �� �o�̴N�O methods ���ӷ�

    String code = cls.render();

    // 5) �g��
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

    System.out.println("�w��X�G" + outDir.resolve(className + "DateTest.java").toAbsolutePath());
  }

  /** �� pathId �M���u�t�r���Ʀr�P���u�A�קK�ͦ�����k�W���X�k */
  private static String safeId(String s) {
    return s.replaceAll("[^0-9A-Za-z_]", "_");
  }
}
