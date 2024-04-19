package com.pattern.learn.enum_creation;

import com.pattern.learn.utility.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnumCreator {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void creatEnum(String directory) {
       String enumName = enumPreNameCreation();
       List<String> variableClasses = enumPreVariablesCreation();

       try {
           int packageNameIndex = directory.indexOf("com");
           String packagePath = directory.substring(packageNameIndex).replace("/", ".");
           StringBuilder enumContent = new StringBuilder("package " + packagePath + ";\n\n");
           enumContent.append("public enum ").append(enumName).append(" {\n");


           for (int i = 0; i < variableClasses.size()-1; i++) {
               enumContent.append(variableClasses.get(i)).append(",");
           }
           enumContent.append(variableClasses.get(variableClasses.size()-1));
           enumContent.append("\n");
           enumContent.append("}\n");




           // Ensure directory ends with separator and exists
           if (!directory.endsWith(File.separator)) {
               directory += File.separator;
           }
           File dir = new File(directory);
           if (!dir.exists()) {
               dir.mkdirs();
           }

           // Write to the file
           try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + enumName + ".java"))) {
               writer.write(enumContent.toString());
               System.out.println("Class " + enumContent + ".java has been created successfully in " + directory);
           }

       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           SCANNER.close();
       }
    }

    private List<String> enumPreVariablesCreation() {
        List<String> variables = new ArrayList<>();
        // Class Variables
        try {
            while (true) {
                System.out.print("Enter variable/class name: ");
                String variableName = SCANNER.next();
                variables.add(variableName.toUpperCase());
                System.out.print("Add another variable? (yes/no): ");
                String answer = SCANNER.next();
                if (!answer.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return variables;
    }

    private String enumPreNameCreation() {
        System.out.println("Provide EnumName: ");
        String enumName = SCANNER.next();
        while (enumName.isEmpty()) {
            enumName = SCANNER.next();
        }
        enumName = Utility.toUpperCaseWithIndex(enumName, 0);
        return enumName;
    }

}
