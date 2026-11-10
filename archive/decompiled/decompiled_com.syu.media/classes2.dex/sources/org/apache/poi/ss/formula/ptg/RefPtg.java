package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RefPtg extends Ref2DPtgBase {
    public static final byte sid = 36;

    @Override // org.apache.poi.ss.formula.ptg.Ref2DPtgBase
    protected byte getSid() {
        return sid;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ref2DPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public /* bridge */ /* synthetic */ void write(LittleEndianOutput littleEndianOutput) {
        super.write(littleEndianOutput);
    }

    public RefPtg(String str) {
        super(new CellReference(str));
    }

    public RefPtg(int i, int i2, boolean z, boolean z2) {
        super(i, i2, z, z2);
    }

    public RefPtg(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }

    public RefPtg(CellReference cellReference) {
        super(cellReference);
    }
}
