package org.apache.poi.xdgf.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Util {
    public static int countLines(String str) {
        int iIndexOf = 0;
        int i = 1;
        while (true) {
            iIndexOf = str.indexOf("\n", iIndexOf) + 1;
            if (iIndexOf == 0) {
                return i;
            }
            i++;
        }
    }

    public static String sanitizeFilename(String str) {
        return str.replaceAll("[:\\\\/*\"?|<>]", "_");
    }
}
