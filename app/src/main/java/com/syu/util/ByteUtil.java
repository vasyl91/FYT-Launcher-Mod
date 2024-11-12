package com.syu.util;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ByteUtil {
    public static int indexOf(byte[] tag, byte[] src, int len) {
        int tagLen = tag.length;
        if (len <= src.length) {
            for (int j = 0; j < (len - tagLen) + 1; j++) {
                for (int i = 0; i < tagLen && src[j + i] == tag[i]; i++) {
                    if (i == tagLen - 1) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public static int lastIndexOf(byte[] tag, byte[] src, int len) {
        if (len <= src.length) {
            int tagLen = tag.length;
            for (int j = len - tagLen; j >= 0; j--) {
                for (int i = 0; i < tagLen && src[j + i] == tag[i]; i++) {
                    if (i == tagLen - 1) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public static byte[] cutBytes(int start, int end, byte[] src) {
        byte[] tmp = null;
        if (start < 0 || end > src.length) {
            return null;
        }
        int len = end - start;
        if (len > 0) {
            tmp = new byte[len];
            for (int i = 0; i < len; i++) {
                tmp[i] = src[start + i];
            }
        }
        return tmp;
    }
}
