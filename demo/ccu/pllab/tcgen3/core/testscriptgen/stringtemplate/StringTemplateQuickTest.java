package ccu.pllab.tcgen3.core.testscriptgen.stringtemplate;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class StringTemplateQuickTest {

  // Simple test
  // public static void main(String[] args) {
  // ST hello = new ST("Hello, <name>");
  // hello.add("name", "World");
  // System.out.println(hello.render());
  // }

  public static void main(String[] args) {

    String projectPath = System.getProperty("user.dir");

    // load file name
    STGroup stg = new STGroupFile(
        projectPath + "\\test\\ccu\\pllab\\tcgen3\\core\\testscriptgen\\stringtemplate\\test.stg");

    // 獲取模板實例
    ST template1 = stg.getInstanceOf("testscript");
    ST template2 = stg.getInstanceOf("greeting");

    // 添加動態內容
    template1.add("name", "World");
    template2.add("greetee", "World");

    // 渲染並輸出結果
    System.out.println(template1.render()); // 輸出: Hello, World!
    System.out.println(template2.render());
  }

}
