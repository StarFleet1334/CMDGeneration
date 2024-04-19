package com.pattern.learn.utility;

public class Utility {

    public static String toUpperCaseWithIndex(String arg,int index) {
        return Character.toUpperCase(arg.charAt(0)) + arg.substring(1);
    }
}
