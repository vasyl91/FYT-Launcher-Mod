package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.ColorScaleFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFColorScaleFormatting implements ColorScaleFormatting {
    private final CFRule12Record cfRule12Record;
    private final ColorGradientFormatting colorFormatting;
    private final HSSFSheet sheet;

    protected HSSFColorScaleFormatting(CFRule12Record cFRule12Record, HSSFSheet hSSFSheet) {
        this.sheet = hSSFSheet;
        this.cfRule12Record = cFRule12Record;
        this.colorFormatting = cFRule12Record.getColorGradientFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public int getNumControlPoints() {
        return this.colorFormatting.getNumControlPoints();
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setNumControlPoints(int i) {
        this.colorFormatting.setNumControlPoints(i);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public HSSFExtendedColor[] getColors() {
        ExtendedColor[] colors = this.colorFormatting.getColors();
        HSSFExtendedColor[] hSSFExtendedColorArr = new HSSFExtendedColor[colors.length];
        for (int i = 0; i < colors.length; i++) {
            hSSFExtendedColorArr[i] = new HSSFExtendedColor(colors[i]);
        }
        return hSSFExtendedColorArr;
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setColors(Color[] colorArr) {
        ExtendedColor[] extendedColorArr = new ExtendedColor[colorArr.length];
        for (int i = 0; i < colorArr.length; i++) {
            extendedColorArr[i] = ((HSSFExtendedColor) colorArr[i]).getExtendedColor();
        }
        this.colorFormatting.setColors(extendedColorArr);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public HSSFConditionalFormattingThreshold[] getThresholds() {
        ColorGradientThreshold[] thresholds = this.colorFormatting.getThresholds();
        HSSFConditionalFormattingThreshold[] hSSFConditionalFormattingThresholdArr = new HSSFConditionalFormattingThreshold[thresholds.length];
        for (int i = 0; i < thresholds.length; i++) {
            hSSFConditionalFormattingThresholdArr[i] = new HSSFConditionalFormattingThreshold(thresholds[i], this.sheet);
        }
        return hSSFConditionalFormattingThresholdArr;
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        int length = conditionalFormattingThresholdArr.length;
        ColorGradientThreshold[] colorGradientThresholdArr = new ColorGradientThreshold[length];
        for (int i = 0; i < length; i++) {
            colorGradientThresholdArr[i] = (ColorGradientThreshold) ((HSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i]).getThreshold();
        }
        this.colorFormatting.setThresholds(colorGradientThresholdArr);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public HSSFConditionalFormattingThreshold createThreshold() {
        return new HSSFConditionalFormattingThreshold(new ColorGradientThreshold(), this.sheet);
    }
}
