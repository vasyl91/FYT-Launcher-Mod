package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class XBLogger {
    public static final int DEBUG = 1;
    public static final int ERROR = 7;
    public static final int FATAL = 9;
    public static final int INFO = 3;
    public static final int WARN = 5;
    protected static final String[] LEVEL_STRINGS_SHORT = {"?", "D", "?", "I", "?", "W", "?", "E", "?", "F", "?"};
    protected static final String[] LEVEL_STRINGS = {"?0?", "DEBUG", "?2?", "INFO", "?4?", "WARN", "?6?", "ERROR", "?8?", "FATAL", "?10+?"};

    protected abstract void _log(int i, Object obj);

    protected abstract void _log(int i, Object obj, Throwable th);

    public abstract boolean check(int i);

    public abstract void initialize(String str);

    XBLogger() {
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    public void log(int i, Object... objArr) {
        if (check(i)) {
            StringBuilder sb = new StringBuilder(32);
            Throwable th = null;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                if (i2 == objArr.length - 1) {
                    Object obj = objArr[i2];
                    if (obj instanceof Throwable) {
                        th = (Throwable) obj;
                    } else {
                        sb.append(objArr[i2]);
                    }
                } else {
                    sb.append(objArr[i2]);
                }
            }
            String strReplaceAll = sb.toString().replaceAll("[\r\n]+", " ");
            if (th == null) {
                _log(i, strReplaceAll);
            } else {
                _log(i, strReplaceAll, th);
            }
        }
    }
}
