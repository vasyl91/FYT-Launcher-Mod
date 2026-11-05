package org.intellij.lang.annotations;

/* JADX INFO: compiled from: PrintFormat.java */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class PrintFormatPattern {
    private static final String ARG_INDEX = "(?:\\d+\\$)?";
    private static final String CONVERSION = "(?:[tT])?(?:[a-zA-Z%])";
    private static final String FLAGS = "(?:[-#+ 0,(<]*)?";
    private static final String PRECISION = "(?:\\.\\d+)?";
    static final String PRINT_FORMAT = "(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*";
    private static final String TEXT = "[^%]|%%";
    private static final String WIDTH = "(?:\\d+)?";

    PrintFormatPattern() {
    }
}
