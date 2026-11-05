package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Area2DPtgBase extends AreaPtgBase {
    private static final int SIZE = 9;

    protected abstract byte getSid();

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final int getSize() {
        return 9;
    }

    protected Area2DPtgBase(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(i, i2, i3, i4, z, z2, z3, z4);
    }

    protected Area2DPtgBase(AreaReference areaReference) {
        super(areaReference);
    }

    protected Area2DPtgBase(LittleEndianInput littleEndianInput) {
        readCoordinates(littleEndianInput);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getSid() + getPtgClass());
        writeCoordinates(littleEndianOutput);
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        stringBuffer.append(formatReferenceAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
