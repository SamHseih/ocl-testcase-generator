package ccu.pllab.tcgen3.core.testscriptgen.stringtemplate;

import java.util.List;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class StringTemloop {
  public static void main(String[] args) {

    String projectPath = System.getProperty("user.dir");

    // import org.stringtemplate.v4.STGroup;
    // import org.stringtemplate.v4.STGroupFile;
    STGroup group = new STGroupFile(projectPath
        + "\\test\\ccu\\pllab\\tcgen3\\core\\testscriptgen\\stringtemplate\\looptest.stg");
    ST tmpl = group.getInstanceOf("listHTML");

    tmpl.add("items", List.of("Apple", "Banana", "Cherry"));

    System.out.println(tmpl.render());
  }
}
