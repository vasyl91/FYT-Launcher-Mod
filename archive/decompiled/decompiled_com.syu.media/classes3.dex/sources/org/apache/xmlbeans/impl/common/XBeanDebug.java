package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XBeanDebug {
    public static final int TRACE_SCHEMA_LOADING = 1;
    static PrintStream _err = null;
    public static final String defaultProp = "";
    public static final String traceProp = "org.apache.xmlbeans.impl.debug";
    private static int _enabled = initializeBitsFromProperty();
    private static int _indent = 0;
    private static String _indentspace = "                                                                                ";

    private static int initializeBitsFromProperty() {
        return SystemProperties.getProperty(traceProp, "").indexOf("TRACE_SCHEMA_LOADING") >= 0 ? 1 : 0;
    }

    public static void enable(int i) {
        _enabled = i | _enabled;
    }

    public static void disable(int i) {
        _enabled = (~i) & _enabled;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0014  */
    /* JADX WARN: Code duplicated, block: B:11:0x0017 A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:7:0x000b, B:8:0x0010, B:15:0x002b, B:17:0x005b, B:18:0x0060, B:11:0x0017, B:13:0x001f, B:14:0x0022), top: B:24:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:13:0x001f A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:7:0x000b, B:8:0x0010, B:15:0x002b, B:17:0x005b, B:18:0x0060, B:11:0x0017, B:13:0x001f, B:14:0x0022), top: B:24:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0022 A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:7:0x000b, B:8:0x0010, B:15:0x002b, B:17:0x005b, B:18:0x0060, B:11:0x0017, B:13:0x001f, B:14:0x0022), top: B:24:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:17:0x005b A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:7:0x000b, B:8:0x0010, B:15:0x002b, B:17:0x005b, B:18:0x0060, B:11:0x0017, B:13:0x001f, B:14:0x0022), top: B:24:0x000b }] */
    public static void trace(int i, String str, int i2) {
        int i3;
        String strSubstring;
        if (test(i)) {
            synchronized (XBeanDebug.class) {
                if (i2 < 0) {
                    _indent += i2;
                    i3 = _indent;
                    if (i3 < 0) {
                        strSubstring = "";
                    } else if (i3 > _indentspace.length()) {
                        strSubstring = _indentspace;
                    } else {
                        strSubstring = _indentspace.substring(0, _indent);
                    }
                    System.err.print(Thread.currentThread().getName() + ": " + strSubstring + str + "\n");
                    if (i2 > 0) {
                        _indent += i2;
                    }
                } else {
                    i3 = _indent;
                    if (i3 < 0) {
                        strSubstring = "";
                    } else if (i3 > _indentspace.length()) {
                        strSubstring = _indentspace;
                    } else {
                        strSubstring = _indentspace.substring(0, _indent);
                    }
                    System.err.print(Thread.currentThread().getName() + ": " + strSubstring + str + "\n");
                    if (i2 > 0) {
                        _indent += i2;
                    }
                }
                throw th;
            }
        }
    }

    public static boolean test(int i) {
        return (i & _enabled) != 0;
    }

    public static String log(String str) {
        log(str, null);
        return str;
    }

    public static String logStackTrace(String str) {
        log(str, new Throwable());
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003b A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x0034, B:11:0x003b, B:8:0x0030), top: B:17:0x0005, inners: #1 }] */
    private static synchronized String log(String str, Throwable th) {
        if (_err == null) {
            try {
                File fileCreateTempFile = File.createTempFile("xmlbeandebug", ".log");
                _err = new PrintStream(new FileOutputStream(fileCreateTempFile));
                System.err.println("Diagnostic XML Bean debug log file created: " + fileCreateTempFile);
            } catch (IOException unused) {
                _err = System.err;
            }
            _err.println(str);
            if (th != null) {
                th.printStackTrace(_err);
            }
        } else {
            _err.println(str);
            if (th != null) {
                th.printStackTrace(_err);
            }
        }
        throw th;
        return str;
    }

    public static Throwable logException(Throwable th) {
        log(th.getMessage(), th);
        return th;
    }
}
