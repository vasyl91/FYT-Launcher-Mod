package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AreaPtg extends Area2DPtgBase {
    public static final short sid = 37;

    @Override // org.apache.poi.ss.formula.ptg.Area2DPtgBase
    protected byte getSid() {
        return (byte) 37;
    }

    public AreaPtg(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(i, i2, i3, i4, z, z2, z3, z4);
    }

    public AreaPtg(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }

    @Removal(version = "3.19")
    @Deprecated
    public AreaPtg(String str) {
        this(new AreaReference(str, SpreadsheetVersion.EXCEL97));
    }

    public AreaPtg(AreaReference areaReference) {
        super(areaReference);
    }
}
