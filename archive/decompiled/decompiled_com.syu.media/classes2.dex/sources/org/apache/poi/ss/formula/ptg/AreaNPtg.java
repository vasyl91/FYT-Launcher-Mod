package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AreaNPtg extends Area2DPtgBase {
    public static final short sid = 45;

    @Override // org.apache.poi.ss.formula.ptg.Area2DPtgBase
    protected byte getSid() {
        return (byte) 45;
    }

    public AreaNPtg(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }
}
