package ccu.pllab.tcgen3.core.testscriptgen;

import java.util.ArrayList;
import java.util.List;
import ccu.pllab.tcgen3.core.testcasegen.CLGTestDatas;

public class TestMethodWriter {

  /**
   * Generates a JUnit 5 test method for the given test case data.
   * 
   * @param testData The test case data (containing class name, method name, inputs, expected
   *        result, etc.).
   * @return A string of Java code representing the JUnit test method.
   */
  public static String generateTestMethod(CLGTestDatas testData) {
    String className = testData.getClassName();
    String methodName = testData.getMethodName();
    String pathId = testData.getPathId();
    List<String> argValues = testData.getArgValues(); // list of argument values as strings
    String selfValue = testData.getSelfValue(); // initial "self" state if applicable
    String expectedValue = testData.getExpectedValue(); // expected result value or exception name

    // Compose method name and display name
    String testMethodName =
        "test" + (methodName.isEmpty() ? className : capitalize(methodName)) + "_" + pathId;
    String displayName = (methodName.isEmpty() ? className : methodName) + " - " + pathId;

    StringBuilder code = new StringBuilder();
    code.append("    @Test\n");
    code.append("    @DisplayName(\"").append(displayName).append("\")\n");
    code.append("    void ").append(testMethodName).append("() {\n");

    // 1. Setup: instantiate "self" object if needed
    if (selfValue != null && !selfValue.isEmpty()) {
      if (methodName.isEmpty()) {
        // No specific method (could be testing class invariants or constructor without explicit
        // expected result)
        DataParser.ValueRep selfRep = DataParser.parseValue(selfValue);
        code.append("        ").append(className).append(" obj = new ").append(className)
            .append("(").append(selfRep.code).append(");\n");
        code.append("        assertNotNull(obj);\n"); // ensure object was created successfully
        code.append("    }\n");
        return code.toString();
      } else {
        // Instance method: create the self object using provided state
        DataParser.ValueRep selfRep = DataParser.parseValue(selfValue);
        if (selfRep.isArray && "Object".equals(selfRep.type)) {
          // Heterogeneous array interpreted as composite object data
          // Build constructor call from components
          String selfArgs = extractObjectConstructorArgs(selfRep);
          code.append("        ").append(className).append(" selfObj = new ").append(className)
              .append("(").append(selfArgs).append(");\n");
        } else {
          // Uniform data (or single value) for self
          code.append("        ").append(className).append(" selfObj = new ").append(className)
              .append("(").append(selfRep.code).append(");\n");
        }
      }
    }

    // 2. Exercise: call the method or constructor under test
    String callCode = "";
    if (methodName.isEmpty() || methodName.equals(className)) {
      // Testing a constructor (methodName is class name or empty)
      // We'll create a new object as the "actual" result
      List<String> argCodeList = new ArrayList<>();
      for (String arg : argValues) {
        DataParser.ValueRep rep = DataParser.parseValue(arg);
        argCodeList.add(rep.code);
      }
      callCode = "new " + className + "(" + String.join(", ", argCodeList) + ")";
      code.append("        ").append(className).append(" actual = ").append(callCode).append(";\n");
    } else {
      // Calling an actual method
      // Determine if static or instance:
      String caller = (selfValue != null && !selfValue.isEmpty()) ? "selfObj" : className;
      // Build argument list code, handling possible object-construction for composite data
      List<String> argCodeList = new ArrayList<>();
      for (String arg : argValues) {
        DataParser.ValueRep rep = DataParser.parseValue(arg);
        if (rep.isArray && "Object".equals(rep.type)) {
          // This arg is given in a composite form, treat as object construction
          String argConstructorArgs = extractObjectConstructorArgs(rep);
          argCodeList.add("new " + className + "(" + argConstructorArgs + ")");
        } else {
          argCodeList.add(rep.code);
        }
      }
      callCode = caller + "." + methodName + "(" + String.join(", ", argCodeList) + ")";
      // Use 'var' for actual result to avoid having to determine exact type here
      code.append("        var actual = ").append(callCode).append(";\n");
    }

    // 3. Verify: assert the expected outcome
    if (expectedValue != null && !expectedValue.isEmpty()) {
      // Check if expected is an exception type
      if (expectedValue.endsWith("Exception") || expectedValue.endsWith("exception")) {
        // Expecting an exception to be thrown
        // Wrap the call in assertThrows
        String exceptionClass = capitalize(expectedValue);
        code.setLength(0); // reset code, we'll generate differently for exception case
        code.append("    @Test\n");
        code.append("    @DisplayName(\"").append(displayName).append("\")\n");
        code.append("    void ").append(testMethodName).append("() {\n");
        // Build the call expression (similar to above but inside a lambda)
        String lambdaCall;
        if (methodName.isEmpty() || methodName.equals(className)) {
          // constructor expected to throw
          List<String> argCodeList = new ArrayList<>();
          for (String arg : argValues) {
            DataParser.ValueRep rep = DataParser.parseValue(arg);
            argCodeList.add(rep.code);
          }
          lambdaCall = "new " + className + "(" + String.join(", ", argCodeList) + ")";
        } else {
          String caller = (selfValue != null && !selfValue.isEmpty())
              ? ("new " + className + "(" + DataParser.parseValue(selfValue).code + ")")
              : className;
          List<String> argCodeList = new ArrayList<>();
          for (String arg : argValues) {
            DataParser.ValueRep rep = DataParser.parseValue(arg);
            argCodeList.add(rep.code);
          }
          lambdaCall = caller + "." + methodName + "(" + String.join(", ", argCodeList) + ")";
        }
        code.append("        assertThrows(").append(exceptionClass).append(".class, () -> ")
            .append(lambdaCall).append(");\n");
        code.append("    }\n");
        return code.toString();
      }

      // Not an exception: handle return value comparison
      if (expectedValue.startsWith("[") && expectedValue.endsWith("]")) {
        // Expected value given in array form
        DataParser.ValueRep expRep = DataParser.parseValue(expectedValue);
        if (expRep.isArray && expRep.type != null && expRep.type.endsWith("[]")) {
          // It's an array expected result
          String expType = expRep.type; // e.g. "int[]" or "int[][]"
          // If actual was declared with 'var', replace with explicit type for clarity
          if (callCode.contains("var actual")) {
            // We can refine the actual declaration line
            code =
                new StringBuilder(code.toString().replaceFirst("var actual", expType + " actual"));
          }
          // Declare expected array
          code.append("        ").append(expType).append(" expected = ").append(expRep.code)
              .append(";\n");
          if (expType.endsWith("[]") && expType.indexOf("[]") != expType.lastIndexOf("[]")) {
            // Multi-dimensional array (e.g., "int[][]" or deeper)
            code.append("        assertTrue(Arrays.deepEquals(expected, actual));\n");
          } else {
            // One-dimensional array
            code.append("        assertArrayEquals(expected, actual);\n");
          }
        } else {
          // The expected "array" actually represents an object (composite values)
          DataParser.ValueRep expRepArr = DataParser.parseValue(expectedValue);
          if (expRepArr.isArray && "Object".equals(expRepArr.type)) {
            // Heterogeneous structure -> expected object construction
            String expArgs = extractObjectConstructorArgs(expRepArr);
            code.append("        ").append(className).append(" expected = new ").append(className)
                .append("(").append(expArgs).append(");\n");
          } else {
            // Uniform but not identified as array type (edge case), treat as object
            code.append("        ").append(className).append(" expected = new ").append(className)
                .append("(").append(expRepArr.code).append(");\n");
          }
          code.append("        assertEquals(expected, actual);\n");
        }
      } else {
        // Expected is a primitive or simple object
        DataParser.ValueRep expRep = DataParser.parseValue(expectedValue);
        String expectedType = (expRep.type != null ? expRep.type : className);
        code.append("        ").append(expectedType).append(" expected = ").append(expRep.code)
            .append(";\n");
        code.append("        assertEquals(expected, actual);\n");
      }
    }

    code.append("    }\n");
    return code.toString();
  }

  /** Capitalizes the first letter of a string (for method to TestMethod conversion). */
  private static String capitalize(String name) {
    if (name == null || name.isEmpty())
      return name;
    return Character.toUpperCase(name.charAt(0)) + name.substring(1);
  }

  /**
   * Helper to construct argument list code from a ValueRep that contains composite object data.
   * This assumes the ValueRep is an array of heterogeneous elements meant to be passed to the
   * constructor.
   */
  private static String extractObjectConstructorArgs(DataParser.ValueRep compositeRep) {
    // compositeRep is expected to be an array type ValueRep with child components
    if (compositeRep == null || !compositeRep.isArray)
      return "";
    List<String> argCodes = new ArrayList<>();
    for (int i = 0; i < compositeRepElements(compositeRep).size(); i++) {
      DataParser.ValueRep child = compositeRepElements(compositeRep).get(i);
      argCodes.add(child.code);
    }
    return String.join(", ", argCodes);
  }

  // In a real implementation, DataParser.ValueRep would expose its children.
  // Here we assume a method compositeRepElements(ValueRep) that returns child ValueRep list for
  // arrays.
  private static List<DataParser.ValueRep> compositeRepElements(DataParser.ValueRep compositeRep) {
    // This is conceptual; actual implementation might differ based on DataParser design.
    // For this pseudocode, assume we can retrieve children from ValueRep if needed.
    throw new UnsupportedOperationException("Not implemented in pseudocode");
  }
}
