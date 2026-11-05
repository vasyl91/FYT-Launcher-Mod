package org.apache.poi.hssf.util;

import org.apache.poi.ss.SpreadsheetVersion;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Deprecated
public final class AreaReference extends org.apache.poi.ss.util.AreaReference {
    public AreaReference(String str) {
        super(str, SpreadsheetVersion.EXCEL97);
    }

    public AreaReference(CellReference cellReference, CellReference cellReference2) {
        super(cellReference, cellReference2);
    }
}
