package com.example.demo.Util;

public class Function {
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
//        System.out.println(original);
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
}
