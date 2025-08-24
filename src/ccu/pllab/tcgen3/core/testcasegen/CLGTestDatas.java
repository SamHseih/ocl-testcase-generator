package ccu.pllab.tcgen3.core.testcasegen;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CLGTestDatas {

  String classname;
  String methodname;
  int testCaseNum; // record the number of test cases generated
  boolean isBVA;

  // <pathNum + BVA pathNum , <Predicate Variable,test data String >>
  // Array add Ex. <path=1_1 , test data map(predicate Variables)>
  // test data map-> entry 1 = <Selg, [1,2,3]>
  // test data map-> entry 2 = <Arg, [5,4,3]>
  // test data map-> entry 3 = <Result, [6,6,6]>
  Map<String, Map<String, String>> testDatas;

  CLGTestDatas(String classname, String methodname, boolean BVA) {
    this.classname = classname;
    this.methodname = methodname;
    testDatas = new LinkedHashMap<>();
    testCaseNum = 0; // Initialize test case number
    this.isBVA = BVA;
  }

  public void setTestDatas(String fesiablepathid, Map<String, String> testData) {
    Objects.requireNonNull(testData, "testData must not be null");
    testDatas.put(fesiablepathid, testData);
    testCaseNum++;
  }

  public Map<String, Map<String, String>> getTestDatas() {
    return testDatas;
  }


  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder().append("Class: ").append(classname).append(", Method: ")
        .append(methodname).append(", Test Case Number: ").append(testCaseNum).append('\n');

    final String BoundaraypathStr = "Boundaray";

    testDatas.forEach((idx, data) -> {
      if (isBVA)
        sb.append(BoundaraypathStr + " ");
      sb.append("Feasiable Path").append(idx).append(":\n");
      if (data == null || data.isEmpty()) {
        sb.append("(no data)\n");
      } else {
        data.forEach((k, v) -> sb.append(k).append(" = ").append(v).append('\n'));
      }
      sb.append("\n");
    });
    return sb.toString();
  }

  public int getTestCaseNum() {
    return testCaseNum;
  }

  public String getClassName() {
    return classname;
  }

  public String getMethodName() {
    return methodname;
  }


}
