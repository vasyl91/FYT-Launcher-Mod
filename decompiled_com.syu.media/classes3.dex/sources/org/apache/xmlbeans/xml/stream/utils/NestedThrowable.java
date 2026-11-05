package org.apache.xmlbeans.xml.stream.utils;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface NestedThrowable {
    Throwable getNested();

    void superPrintStackTrace(PrintStream printStream);

    void superPrintStackTrace(PrintWriter printWriter);

    String superToString();

    public static class Util {
        private static String EOL = System.getProperty("line.separator");

        public static String toString(NestedThrowable nestedThrowable) {
            Throwable nested = nestedThrowable.getNested();
            if (nested == null) {
                return nestedThrowable.superToString();
            }
            return nestedThrowable.superToString() + " - with nested exception:" + EOL + "[" + nestedToString(nested) + "]";
        }

        private static String nestedToString(Throwable th) {
            if (th instanceof InvocationTargetException) {
                return th.toString() + " - with target exception:" + EOL + "[" + ((InvocationTargetException) th).getTargetException().toString() + "]";
            }
            return th.toString();
        }

        public static void printStackTrace(NestedThrowable nestedThrowable, PrintStream printStream) {
            Throwable nested = nestedThrowable.getNested();
            if (nested != null) {
                nested.printStackTrace(printStream);
                printStream.println("--------------- nested within: ------------------");
            }
            nestedThrowable.superPrintStackTrace(printStream);
        }

        public static void printStackTrace(NestedThrowable nestedThrowable, PrintWriter printWriter) {
            Throwable nested = nestedThrowable.getNested();
            if (nested != null) {
                nested.printStackTrace(printWriter);
                printWriter.println("--------------- nested within: ------------------");
            }
            nestedThrowable.superPrintStackTrace(printWriter);
        }
    }
}
