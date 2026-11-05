package org.apache.poi.hssf.record.cf;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ColorGradientThreshold extends Threshold implements Cloneable {
    private double position;

    public ColorGradientThreshold() {
        this.position = 0.0d;
    }

    public ColorGradientThreshold(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
        this.position = littleEndianInput.readDouble();
    }

    public double getPosition() {
        return this.position;
    }

    public void setPosition(double d) {
        this.position = d;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public int getDataLength() {
        return super.getDataLength() + 8;
    }

    public ColorGradientThreshold clone() {
        ColorGradientThreshold colorGradientThreshold = new ColorGradientThreshold();
        super.copyTo(colorGradientThreshold);
        colorGradientThreshold.position = this.position;
        return colorGradientThreshold;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public void serialize(LittleEndianOutput littleEndianOutput) {
        super.serialize(littleEndianOutput);
        littleEndianOutput.writeDouble(this.position);
    }
}
