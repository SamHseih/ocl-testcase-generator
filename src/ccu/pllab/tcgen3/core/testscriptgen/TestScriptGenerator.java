package ccu.pllab.tcgen3.core.testscriptgen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import ccu.pllab.tcgen3.core.testcasegen.CLGTestDatas;

public class TestScriptGenerator {

  /**
   * Generates JUnit test classes for all entries in the given map and writes them to .java files.
   * 
   * @param testDataMap Map from clg name to CLGTestDatas containing test cases for that class.
   * @param outputDir Directory path where test files should be written.
   * @throws IOException if file writing fails.
   */
  public static void generateAllTests(Map<String, CLGTestDatas> testDataMap, Path outputDir)
      throws IOException {
    for (CLGTestDatas classTests : testDataMap.values()) {
      String testClassCode = TestClassWriter.generateTestClass(classTests);

      Files.write(outputDir, testClassCode.getBytes(StandardCharsets.UTF_8));
    }
  }
}
