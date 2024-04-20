package com.pattern.learn.interface_creation;

import com.pattern.learn.utility.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceCreator {
    private static final Scanner SCANNER = new Scanner(System.in);


    public void createInterface(String directory) {
        String interfaceName = interfacePreNameCreation();
        List<String> interfaceVariables = interfacePreVariablesCreation();
        List<String> interfaceMethods = interfacePreMethodsCreation();
        System.out.println(interfaceVariables);
        System.out.println();
        System.out.println(interfaceMethods);



        try {
            // Construct the content of the class
            int packageNameIndex = directory.indexOf("com");
            String packagePath = directory.substring(packageNameIndex).replace("/", ".");
            StringBuilder classContent = new StringBuilder("package " + packagePath + ";\n\n");
            classContent.append("public interface ").append(interfaceName).append(" {\n");



            for (String variable : interfaceVariables) {
                String[] parts = variable.split(" ");
                String varName = parts[0];
                String varType = parts[1];



                String varAccess = parts[2];
                String varDefault = parts.length > 3 ? parts[3] : null;
                classContent.append("    ")
                        .append(varAccess)
                        .append(" ")
                        .append(varType)
                        .append(" ")
                        .append(varName);
                if (varDefault != null) {
                    classContent.append(" = ");

                    // Here we need to check its type

                    // In case if it is boolean or any Number, we do not need it ""

                    // In case if it is String, we do need it "";


                    if (varType.equalsIgnoreCase("String")) {
                        classContent.append(varDefault.equals("null") ? "" : "\"" + varDefault + "\"");
                    }
                    if (
                            varType.equalsIgnoreCase("int") ||
                                    varType.equalsIgnoreCase("double") ||
                                    varType.equalsIgnoreCase("float")  ||
                                    varType.equalsIgnoreCase("boolean")
                    ) {
                        classContent.append(varDefault);
                    }
                }
                classContent.append(";\n");
            }

            // Append methods
            for (String method : interfaceMethods) {
                String[] parts = method.split(" ");
                String methodName = parts[0];
                String methodReturnType = parts[1];
                String methodAccess = parts[2];
                String params = method.substring(method.indexOf('[') + 1, method.indexOf(']'));

                classContent.append("    ")
                        .append(methodAccess)
                        .append(" ")
                        .append(methodReturnType)
                        .append(" ")
                        .append(methodName)
                        .append("(")
                        .append(params.replace(", ", ","))
                        .append(");\n");
            }

            classContent.append("}\n");

            // Ensure directory ends with separator and exists
            if (!directory.endsWith(File.separator)) {
                directory += File.separator;
            }
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Write to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + interfaceName + ".java"))) {
                writer.write(classContent.toString());
                System.out.println("Interface " + interfaceName + ".java has been created successfully in " + directory);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while creating the interface file.");
            e.printStackTrace();
        } finally {
            SCANNER.close();
        }


    }

    private List<String> interfacePreMethodsCreation() {
        // Class Methods
        List<String> methods = new ArrayList<>();

        while (true) {
            System.out.print("Enter method name: ");
            String methodName = SCANNER.next();

            System.out.print("Enter method return type: ");
            String methodReturnType = SCANNER.next();

            List<String> parameters = new ArrayList<>();
            while (true) {
                System.out.print("Enter parameter name (enter stop -  if no more parameters): ");
                String paramName = SCANNER.next();
                if (paramName.equalsIgnoreCase("STOP")) {
                    break;
                }

                System.out.print("Enter parameter type: ");
                String paramType = SCANNER.next();

                parameters.add(paramName + " " + paramType);
            }
            String parametersString = String.join(", ", parameters);
            methods.add(methodName + " " + methodReturnType + " "  + " [" + parametersString + "]");
            System.out.print("Add another method? (yes/no): ");
            String answer = SCANNER.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }

//        System.out.println("\nMethods Form:");
//        methods.forEach(method -> System.out.println(" * " + method));
        return methods;
    }

    private List<String> interfacePreVariablesCreation() {
        List<String> variables = new ArrayList<>();
        // Class Variables
        try {
            while (true) {
                System.out.print("Enter variable name: ");
                String variableName = SCANNER.next();

                System.out.print("Enter variable type: ");
                String variableType = SCANNER.next();


                System.out.print("Enter variable value: ");
                String value = SCANNER.next();


                // Format and add the variable to the list
                variables.add(variableName + " " + variableType + " " + " " + value);
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
    private String interfacePreNameCreation() {
        System.out.println("Provide Interface Name: ");
        String interfaceName = SCANNER.next();
        while (interfaceName.isEmpty()) {
            interfaceName = SCANNER.next();
        }
        interfaceName = Utility.toUpperCaseWithIndex(interfaceName, 0);
        return interfaceName;
    }
}
