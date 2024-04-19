package com.pattern.learn.interface_creation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InterfaceCreator {

    public void createInterface(String directory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your command:");
        String input = scanner.nextLine();

        if (input.toLowerCase().startsWith("create interface ")) {
            String className = input.substring(17).trim();  // Extract class name
            if (!className.isEmpty()) {
                scanner.close();
                int packageNameIndex = directory.indexOf("com");
                String classContent = "package " + directory.substring(packageNameIndex).replace("/",".") + ";" + "\n" +
                        "public interface " + className + " {\n"
                        + "}\n";

                if (!directory.endsWith(File.separator)) {
                    directory += File.separator;
                }

                // Create the directory if it does not exist
                File dir = new File(directory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + className + ".java"))) {
                    writer.write(classContent);
                    System.out.println("Interface " + className + ".java has been created successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while creating the interface file.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("No class name provided.");
            }
        } else {
            System.out.println("Invalid command. Please use the format 'Create Interface InterfaceName'.");
        }


    }
}
