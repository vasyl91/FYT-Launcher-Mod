package org.apache.poi.hssf.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CellReference extends org.apache.poi.ss.util.CellReference {
    public CellReference(String str) {
        super(str);
    }

    public CellReference(int i, int i2) {
        super(i, i2, true, true);
    }

    public CellReference(int i, int i2, boolean z, boolean z2) {
        super(null, i, i2, z, z2);
    }

    public CellReference(String str, int i, int i2, boolean z, boolean z2) {
        super(str, i, i2, z, z2);
    }
}
