package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExpPtg extends ControlPtg {
    private static final int SIZE = 5;
    public static final short sid = 1;
    private final int field_1_first_row;
    private final int field_2_first_col;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 5;
    }

    public ExpPtg(LittleEndianInput littleEndianInput) {
        this.field_1_first_row = littleEndianInput.readShort();
        this.field_2_first_col = littleEndianInput.readShort();
    }

    public ExpPtg(int i, int i2) {
        this.field_1_first_row = i;
        this.field_2_first_col = i2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 1);
        littleEndianOutput.writeShort(this.field_1_first_row);
        littleEndianOutput.writeShort(this.field_2_first_col);
    }

    public int getRow() {
        return this.field_1_first_row;
    }

    public int getColumn() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("Coding Error: Expected ExpPtg to be converted from Shared to Non-Shared Formula by ValueRecordsAggregate, but it wasn't");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[Array Formula or Shared Formula]\nrow = ");
        stringBuffer.append(getRow()).append("\ncol = ");
        stringBuffer.append(getColumn()).append("\n");
        return stringBuffer.toString();
    }
}
