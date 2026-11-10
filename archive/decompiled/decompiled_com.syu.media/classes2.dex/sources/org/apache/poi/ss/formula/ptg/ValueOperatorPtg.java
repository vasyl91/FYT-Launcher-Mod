package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ValueOperatorPtg extends OperationPtg {
    @Override // org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.ss.formula.ptg.Ptg
    public final byte getDefaultOperandClass() {
        return (byte) 32;
    }

    protected abstract byte getSid();

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final int getSize() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getSid());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        throw new RuntimeException("toFormulaString(String[] operands) should be used for subclasses of OperationPtgs");
    }
}
