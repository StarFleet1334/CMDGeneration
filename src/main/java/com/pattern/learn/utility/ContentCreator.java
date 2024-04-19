package com.pattern.learn.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 *
 *  List<String> variables Form:
 *      <variableName> <variableType> <variableAccessIdentifier> <variableDefaultValue>
 *          last option can be null
 *
 *
 *  List<String> methods
 *      <methodName> <methodReturnType> <MethodAccessIdentifier>
 *
 *
 */

public class ContentCreator {

//    private static final Scanner SCANNER = new Scanner(System.in);
//
//    public String createContent(String name) {
//
//
//
//    }
//    private String NameCreation(String name) {
//        System.out.println("Provide " + name + ": ");
//        String className = SCANNER.next();
//        while (className.isEmpty()) {
//            className = SCANNER.next();
//        }
//        className = Utility.toUpperCaseWithIndex(className, 0);
//        return className;
//    }
//
//    private List<String> VariablesCreation() {
//        List<String> variables = new ArrayList<>();
//        // Class Variables
//        try {
//            while (true) {
//                System.out.print("Enter variable name: ");
//                String variableName = SCANNER.next();
//
//                System.out.print("Enter variable type: ");
//                String variableType = SCANNER.next();
//
//                System.out.print("Enter variable access identifier (e.g., private, public): ");
//                String variableAccess = SCANNER.next();
//
//                System.out.print("Enter variable default value (press enter if none): ");
//                String defaultValue = SCANNER.next();
//                if (defaultValue.isEmpty()) {
//                    defaultValue = "null";
//                }
//
//                // Format and add the variable to the list
//                variables.add(variableName + " " + variableType + " " + variableAccess + " " + defaultValue);
//
//                System.out.print("Add another variable? (yes/no): ");
//                String answer = SCANNER.next();
//                if (!answer.equalsIgnoreCase("yes")) {
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return variables;
//    }
}
