package org.apache.poi.hssf.record.cf;

import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ColorGradientFormatting implements Cloneable {
    private ExtendedColor[] colors;
    private byte options;
    private ColorGradientThreshold[] thresholds;
    private static POILogger log = POILogFactory.getLogger((Class<?>) ColorGradientFormatting.class);
    private static BitField clamp = BitFieldFactory.getInstance(1);
    private static BitField background = BitFieldFactory.getInstance(2);

    public ColorGradientFormatting() {
        this.options = (byte) 3;
        this.thresholds = new ColorGradientThreshold[3];
        this.colors = new ExtendedColor[3];
    }

    public ColorGradientFormatting(LittleEndianInput littleEndianInput) {
        this.options = (byte) 0;
        littleEndianInput.readShort();
        littleEndianInput.readByte();
        int i = littleEndianInput.readByte();
        int i2 = littleEndianInput.readByte();
        if (i != i2) {
            log.log(5, "Inconsistent Color Gradient defintion, found " + i + " vs " + i2 + " entries");
        }
        this.options = littleEndianInput.readByte();
        this.thresholds = new ColorGradientThreshold[i];
        int i3 = 0;
        while (true) {
            ColorGradientThreshold[] colorGradientThresholdArr = this.thresholds;
            if (i3 >= colorGradientThresholdArr.length) {
                break;
            }
            colorGradientThresholdArr[i3] = new ColorGradientThreshold(littleEndianInput);
            i3++;
        }
        this.colors = new ExtendedColor[i2];
        for (int i4 = 0; i4 < this.colors.length; i4++) {
            littleEndianInput.readDouble();
            this.colors[i4] = new ExtendedColor(littleEndianInput);
        }
    }

    public int getNumControlPoints() {
        return this.thresholds.length;
    }

    public void setNumControlPoints(int i) {
        ColorGradientThreshold[] colorGradientThresholdArr = this.thresholds;
        if (i != colorGradientThresholdArr.length) {
            ColorGradientThreshold[] colorGradientThresholdArr2 = new ColorGradientThreshold[i];
            ExtendedColor[] extendedColorArr = new ExtendedColor[i];
            int iMin = Math.min(colorGradientThresholdArr.length, i);
            System.arraycopy(this.thresholds, 0, colorGradientThresholdArr2, 0, iMin);
            System.arraycopy(this.colors, 0, extendedColorArr, 0, iMin);
            this.thresholds = colorGradientThresholdArr2;
            this.colors = extendedColorArr;
            updateThresholdPositions();
        }
    }

    public ColorGradientThreshold[] getThresholds() {
        return this.thresholds;
    }

    public void setThresholds(ColorGradientThreshold[] colorGradientThresholdArr) {
        this.thresholds = colorGradientThresholdArr == null ? null : (ColorGradientThreshold[]) colorGradientThresholdArr.clone();
        updateThresholdPositions();
    }

    public ExtendedColor[] getColors() {
        return this.colors;
    }

    public void setColors(ExtendedColor[] extendedColorArr) {
        this.colors = extendedColorArr == null ? null : (ExtendedColor[]) extendedColorArr.clone();
    }

    public boolean isClampToCurve() {
        return getOptionFlag(clamp);
    }

    public boolean isAppliesToBackground() {
        return getOptionFlag(background);
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.getValue(this.options) != 0;
    }

    private void updateThresholdPositions() {
        double length = 1.0d / ((double) (this.thresholds.length - 1));
        int i = 0;
        while (true) {
            ColorGradientThreshold[] colorGradientThresholdArr = this.thresholds;
            if (i >= colorGradientThresholdArr.length) {
                return;
            }
            colorGradientThresholdArr[i].setPosition(((double) i) * length);
            i++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("    [Color Gradient Formatting]\n          .clamp     = ");
        stringBuffer.append(isClampToCurve()).append("\n          .background= ");
        stringBuffer.append(isAppliesToBackground()).append("\n");
        for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
            stringBuffer.append(colorGradientThreshold);
        }
        for (ExtendedColor extendedColor : this.colors) {
            stringBuffer.append(extendedColor);
        }
        stringBuffer.append("    [/Color Gradient Formatting]\n");
        return stringBuffer.toString();
    }

    public Object clone() {
        ColorGradientFormatting colorGradientFormatting = new ColorGradientFormatting();
        colorGradientFormatting.options = this.options;
        ColorGradientThreshold[] colorGradientThresholdArr = new ColorGradientThreshold[this.thresholds.length];
        colorGradientFormatting.thresholds = colorGradientThresholdArr;
        colorGradientFormatting.colors = new ExtendedColor[this.colors.length];
        ColorGradientThreshold[] colorGradientThresholdArr2 = this.thresholds;
        System.arraycopy(colorGradientThresholdArr2, 0, colorGradientThresholdArr, 0, colorGradientThresholdArr2.length);
        ExtendedColor[] extendedColorArr = this.colors;
        System.arraycopy(extendedColorArr, 0, colorGradientFormatting.colors, 0, extendedColorArr.length);
        return colorGradientFormatting;
    }

    public int getDataLength() {
        int dataLength = 6;
        for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
            dataLength += colorGradientThreshold.getDataLength();
        }
        for (ExtendedColor extendedColor : this.colors) {
            dataLength = dataLength + extendedColor.getDataLength() + 8;
        }
        return dataLength;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.writeByte(this.thresholds.length);
        littleEndianOutput.writeByte(this.thresholds.length);
        littleEndianOutput.writeByte(this.options);
        for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
            colorGradientThreshold.serialize(littleEndianOutput);
        }
        double length = 1.0d / ((double) (this.colors.length - 1));
        for (int i = 0; i < this.colors.length; i++) {
            littleEndianOutput.writeDouble(((double) i) * length);
            this.colors[i].serialize(littleEndianOutput);
        }
    }
}
