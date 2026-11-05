package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MemFuncPtg extends OperandPtg {
    public static final byte sid = 41;
    private final int field_1_len_ref_subexpression;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 3;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return "";
    }

    public MemFuncPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readUShort());
    }

    public MemFuncPtg(int i) {
        this.field_1_len_ref_subexpression = i;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeShort(this.field_1_len_ref_subexpression);
    }

    public int getNumberOfOperands() {
        return this.field_1_len_ref_subexpression;
    }

    public int getLenRefSubexpression() {
        return this.field_1_len_ref_subexpression;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [len=");
        stringBuffer.append(this.field_1_len_ref_subexpression);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
