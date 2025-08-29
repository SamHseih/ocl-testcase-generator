package ccu.pllab.tcgen3.core.testscriptgen.stringtemplate;

import java.nio.file.Path;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class DemoStringTemplate {
  public static void main(String[] args) {

    Path projectpath = Path.of(System.getProperty("user.dir"));
    Path testScriptPath = projectpath.resolve("src").resolve("ccu").resolve("pllab")
        .resolve("tcgen3").resolve("core").resolve("testscriptgen").resolve("stg");
    Path testScriptFile = testScriptPath.resolve("testscript.stg");
    // System.out.println(testScriptFile.toString());

    STGroup group = new STGroupFile(testScriptFile.toString());
    ST template = group.getInstanceOf("testcase");

    template.add("sys_decl", "1");
    template.add("target_obj", "2");
    System.out.println(template.render());
  }
}
