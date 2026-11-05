package org.apache.poi.hssf.record.cf;

import java.util.Arrays;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Threshold {
    private Formula formula;
    private byte type;
    private Double value;

    protected Threshold() {
        this.type = (byte) ConditionalFormattingThreshold.RangeType.NUMBER.id;
        this.formula = Formula.create(null);
        this.value = Double.valueOf(0.0d);
    }

    protected Threshold(LittleEndianInput littleEndianInput) {
        this.type = littleEndianInput.readByte();
        short s = littleEndianInput.readShort();
        if (s > 0) {
            this.formula = Formula.read(s, littleEndianInput);
        } else {
            this.formula = Formula.create(null);
        }
        if (s != 0 || this.type == ConditionalFormattingThreshold.RangeType.MIN.id || this.type == ConditionalFormattingThreshold.RangeType.MAX.id) {
            return;
        }
        this.value = Double.valueOf(littleEndianInput.readDouble());
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
        if (b == ConditionalFormattingThreshold.RangeType.MIN.id || b == ConditionalFormattingThreshold.RangeType.MAX.id || b == ConditionalFormattingThreshold.RangeType.FORMULA.id) {
            this.value = null;
        } else if (this.value == null) {
            this.value = Double.valueOf(0.0d);
        }
    }

    public void setType(int i) {
        this.type = (byte) i;
    }

    protected Formula getFormula() {
        return this.formula;
    }

    public Ptg[] getParsedExpression() {
        return this.formula.getTokens();
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        this.formula = Formula.create(ptgArr);
        if (ptgArr.length > 0) {
            this.value = null;
        }
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double d) {
        this.value = d;
    }

    public int getDataLength() {
        int encodedSize = this.formula.getEncodedSize() + 1;
        return this.value != null ? encodedSize + 8 : encodedSize;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("    [CF Threshold]\n          .type    = ");
        stringBuffer.append(Integer.toHexString(this.type)).append("\n          .formula = ");
        stringBuffer.append(Arrays.toString(this.formula.getTokens())).append("\n          .value   = ");
        stringBuffer.append(this.value).append("\n    [/CF Threshold]\n");
        return stringBuffer.toString();
    }

    public void copyTo(Threshold threshold) {
        threshold.type = this.type;
        threshold.formula = this.formula;
        threshold.value = this.value;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.type);
        if (this.formula.getTokens().length == 0) {
            littleEndianOutput.writeShort(0);
        } else {
            this.formula.serialize(littleEndianOutput);
        }
        Double d = this.value;
        if (d != null) {
            littleEndianOutput.writeDouble(d.doubleValue());
        }
    }
}
