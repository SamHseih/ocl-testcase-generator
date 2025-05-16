package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Antlr4Exe {
    public static void main(String[] args) {
        try {
            // �إ� ProcessBuilder �ë��w���O
        	String antlrjarpath= "C:\\Javalib\\antlr-4.13.2-complete.jar org.antlr.v4.Tool";
        	String g4FilePath = System.getProperty("user.dir")+"\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\Ocl.g4";
        	String outpath = System.getProperty("user.dir")+"\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\antlrgen";
        	ProcessBuilder builder = new ProcessBuilder(List.of("powershell.exe", "-Command", 
            		"java -cp" + " " + antlrjarpath +" "+ g4FilePath +" -o "+ outpath + " -visitor"));
            builder.redirectErrorStream(true); // �X�ּзǿ�X�P���~��X
            Process process = builder.start();

            // Ū����X
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // ���ݫ��O���槹��
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
