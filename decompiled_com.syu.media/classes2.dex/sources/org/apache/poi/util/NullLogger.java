package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class NullLogger extends POILogger {
    @Override // org.apache.poi.util.POILogger
    protected void _log(int i, Object obj) {
    }

    @Override // org.apache.poi.util.POILogger
    protected void _log(int i, Object obj, Throwable th) {
    }

    @Override // org.apache.poi.util.POILogger
    public boolean check(int i) {
        return false;
    }

    @Override // org.apache.poi.util.POILogger
    public void initialize(String str) {
    }

    @Override // org.apache.poi.util.POILogger
    public void log(int i, Object... objArr) {
    }
}
