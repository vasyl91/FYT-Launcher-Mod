package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SystemOutLogger extends POILogger {
    private String _cat;

    @Override // org.apache.poi.util.POILogger
    public void initialize(String str) {
        this._cat = str;
    }

    @Override // org.apache.poi.util.POILogger
    protected void _log(int i, Object obj) {
        _log(i, obj, null);
    }

    @Override // org.apache.poi.util.POILogger
    protected void _log(int i, Object obj, Throwable th) {
        if (check(i)) {
            System.out.println("[" + this._cat + "]" + LEVEL_STRINGS_SHORT[Math.min(LEVEL_STRINGS_SHORT.length - 1, i)] + " " + obj);
            if (th != null) {
                th.printStackTrace(System.out);
            }
        }
    }

    @Override // org.apache.poi.util.POILogger
    public boolean check(int i) {
        int i2;
        try {
            i2 = Integer.parseInt(System.getProperty("poi.log.level", "5"));
        } catch (SecurityException unused) {
            i2 = 1;
        }
        return i >= i2;
    }
}
