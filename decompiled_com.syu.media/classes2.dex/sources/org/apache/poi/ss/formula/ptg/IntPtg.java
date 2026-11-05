package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IntPtg extends ScalarConstantPtg {
    private static final int MAX_VALUE = 65535;
    private static final int MIN_VALUE = 0;
    public static final int SIZE = 3;
    public static final byte sid = 30;
    private final int field_1_value;

    public static boolean isInRange(int i) {
        return i >= 0 && i <= 65535;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 3;
    }

    public IntPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readUShort());
    }

    public IntPtg(int i) {
        if (!isInRange(i)) {
            throw new IllegalArgumentException("value is out of range: " + i);
        }
        this.field_1_value = i;
    }

    public int getValue() {
        return this.field_1_value;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeShort(getValue());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return String.valueOf(getValue());
    }
}
