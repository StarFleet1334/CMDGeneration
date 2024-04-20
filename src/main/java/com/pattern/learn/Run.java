package com.pattern.learn;

import com.pattern.learn.class_creation.ClassCreator;
import com.pattern.learn.enum_creation.EnumCreator;
import com.pattern.learn.interface_creation.InterfaceCreator;
import com.pattern.learn.utility.DirectoryLister;
import java.util.Scanner;

public class Run {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ClassCreator CLASS_CREATOR = new ClassCreator();
    private static final EnumCreator ENUM_CREATOR = new EnumCreator();
    private static final InterfaceCreator INTERFACE_CREATOR = new InterfaceCreator();

    private static final String TXT = """
    List of options you can create:
        1. Class -> Press '1'
        2. Interface -> Press '2'
        3. Enum -> Press '3'
    
    """;

    public static void main(String[] args) {
        System.out.println(TXT);
        int number = scanner.nextInt();
        System.out.println("List of Directories: ");
        for (int i = 0; i < DirectoryLister.getDirectories().size(); i++) {
            System.out.println("Index: " + i + ", " + DirectoryLister.getDirectories().get(i));
        }
        if (number == 1) {
            // Class Name
            System.out.println("Provide Index of directory: ");
            int index = scanner.nextInt();
            CLASS_CREATOR.createJavaClass(DirectoryLister.getDirectories().get(index));
        }
        if (number == 3) {
            System.out.println("Provide Index of directory: ");
            int index = scanner.nextInt();
            ENUM_CREATOR.creatEnum(DirectoryLister.getDirectories().get(index));
        }

        if (number == 2) {
            System.out.println("Provide Index of directory: ");
            int index = scanner.nextInt();
            INTERFACE_CREATOR.createInterface(DirectoryLister.getDirectories().get(index));
        }
    }
}
