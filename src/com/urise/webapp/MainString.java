package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1", "2", "3", "4", "5"};
       // String result = "";
        StringBuilder sb = new StringBuilder();
        for (String str : strArray){
            sb.append(str).append(", ");
        }
        System.out.println(sb.toString());
    }
}
