package com.syu.util;

public class JTools {
    public static boolean check(int[] vals, int len) {
        return vals != null && vals.length != 0 && vals.length >= len;
    }

    public static boolean check(String[] vals, int len) {
        return vals != null && vals.length != 0 && vals.length >= len;
    }

    public static boolean check(float[] vals, int len) {
        return vals != null && vals.length != 0 && vals.length >= len;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean equals(String str, String other) {
        if (str == null || other == null) {
            return false;
        }
        return str.equals(other);
    }

    public static boolean equalsIgnoreCase(String str, String other) {
        if (str == null || other == null) {
            return false;
        }
        return str.equalsIgnoreCase(other);
    }
}
