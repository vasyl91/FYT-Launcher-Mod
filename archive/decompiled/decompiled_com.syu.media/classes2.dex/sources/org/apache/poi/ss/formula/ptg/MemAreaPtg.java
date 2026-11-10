package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MemAreaPtg extends OperandPtg {
    private static final int SIZE = 7;
    public static final short sid = 38;
    private final int field_1_reserved;
    private final int field_2_subex_len;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 7;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return "";
    }

    public MemAreaPtg(int i) {
        this.field_1_reserved = 0;
        this.field_2_subex_len = i;
    }

    public MemAreaPtg(LittleEndianInput littleEndianInput) {
        this.field_1_reserved = littleEndianInput.readInt();
        this.field_2_subex_len = littleEndianInput.readShort();
    }

    public int getLenRefSubexpression() {
        return this.field_2_subex_len;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 38);
        littleEndianOutput.writeInt(this.field_1_reserved);
        littleEndianOutput.writeShort(this.field_2_subex_len);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [len=");
        stringBuffer.append(this.field_2_subex_len);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
