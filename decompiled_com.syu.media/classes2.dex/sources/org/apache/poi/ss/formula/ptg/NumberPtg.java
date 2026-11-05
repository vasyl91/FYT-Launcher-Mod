package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NumberPtg extends ScalarConstantPtg {
    public static final int SIZE = 9;
    public static final byte sid = 31;
    private final double field_1_value;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 9;
    }

    public NumberPtg(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readDouble());
    }

    public NumberPtg(String str) {
        this(Double.parseDouble(str));
    }

    public NumberPtg(double d) {
        this.field_1_value = d;
    }

    public double getValue() {
        return this.field_1_value;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeDouble(getValue());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return NumberToTextConverter.toText(this.field_1_value);
    }
}
