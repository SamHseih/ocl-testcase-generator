package ccu.pllab.tcgen3.core.testscriptgen;

import ccu.pllab.tcgen3.core.testcasegen.CLGTestDatas;

public class TestClassWriter {
  /**
   * Generates the complete test class code for the given set of test data.
   * 
   * @param testDatas A container holding all test cases for a particular class.
   * @return A string of the Java source code for the JUnit test class.
   */
  public static String generateTestClass(CLGTestDatas testDatas) {
    String className = testDatas.getClassName();
    String testClassName = className + "Test";
    StringBuilder code = new StringBuilder();

    // Package declaration (if needed, not provided in this context)
    // code.append("package ...;\n\n");

    // Import statements for JUnit 5 and utilities
    code.append("import static org.junit.jupiter.api.Assertions.*;\n");
    code.append("import org.junit.jupiter.api.DisplayName;\n");
    code.append("import org.junit.jupiter.api.Test;\n");
    code.append("import java.util.Arrays;\n\n");

    // Class declaration
    code.append("public class ").append(testClassName).append(" {\n\n");

    // Generate each test method
    for (CLGTestDatas testData : testDatas.getTestDatas()) {
      String methodCode = TestMethodWriter.generateTestMethod(testData);
      code.append(methodCode).append("\n");
    }

    code.append("}\n");
    return code.toString();
  }
}
