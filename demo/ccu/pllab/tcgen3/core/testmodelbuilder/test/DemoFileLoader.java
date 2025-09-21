package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class DemoFileLoader {
  // Main for test
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Run Configuration -> Argument Block -> Programing arguments..");
      System.out.println("Enter arg1: <Papyrus WorkSpace Directory> to find Project.");
      System.out.print("Enter arg2: <ProjectName> to find ProjectName.uml.");
      System.exit(1);
    }

    // Use Path.of() to ensure platform-independent software
    Path projectPath = Path.of(args[0], args[1]);
    Path umlfilePath = Path.of(args[0], args[1], args[1] + ".uml");// 自動拼接檔案名稱
    Path oclfilePath = Path.of(args[0], args[1], args[1] + ".ocl");// 自動拼接檔案名稱
    System.out.println("Spec Dir: " + projectPath);
    System.out.println("umlfilePath: " + umlfilePath + "\nFileName: " + umlfilePath.getFileName());
    System.out.println("oclfilePath: " + oclfilePath + "\nFileName: " + oclfilePath.getFileName());


    // 讀取檔案內容
    System.out.println("UML Content:");
    try (BufferedReader reader = new BufferedReader(new FileReader(umlfilePath.toFile()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("檔案讀取失敗: " + e.getMessage());
    }
  }
}
