package com.syu.util;

public class ToolkitMisc {
    public static boolean strEqual(String a, String b) {
        if (a == null) {
            return b == null;
        } else return a.equals(b);
    }

    public static boolean strsOk(String[] strs, int min) {
        return strs != null && strs.length >= min;
    }
}
