package com.fasterxml.aalto.util;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class DataUtil {
    static final char[] EMPTY_CHAR_ARRAY = new char[0];

    private DataUtil() {
    }

    public static char[] getEmptyCharArray() {
        return EMPTY_CHAR_ARRAY;
    }

    public static String[] growArrayBy(String[] strArr, int i) {
        if (strArr == null) {
            return new String[i];
        }
        int length = strArr.length;
        String[] strArr2 = new String[i + length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    public static int[] growArrayBy(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[i + length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public static char[] growArrayBy(char[] cArr, int i) {
        if (cArr == null) {
            return new char[i];
        }
        int length = cArr.length;
        char[] cArr2 = new char[i + length];
        System.arraycopy(cArr, 0, cArr2, 0, length);
        return cArr2;
    }

    public static Object growAnyArrayBy(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("Null array");
        }
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i + length);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }
}
