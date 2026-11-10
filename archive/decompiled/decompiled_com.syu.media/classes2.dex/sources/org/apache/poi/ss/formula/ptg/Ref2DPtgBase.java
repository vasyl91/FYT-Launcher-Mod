package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class Ref2DPtgBase extends RefPtgBase {
    private static final int SIZE = 5;

    protected abstract byte getSid();

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final int getSize() {
        return 5;
    }

    protected Ref2DPtgBase(int i, int i2, boolean z, boolean z2) {
        setRow(i);
        setColumn(i2);
        setRowRelative(z);
        setColRelative(z2);
    }

    protected Ref2DPtgBase(LittleEndianInput littleEndianInput) {
        readCoordinates(littleEndianInput);
    }

    protected Ref2DPtgBase(CellReference cellReference) {
        super(cellReference);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getSid() + getPtgClass());
        writeCoordinates(littleEndianOutput);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
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
