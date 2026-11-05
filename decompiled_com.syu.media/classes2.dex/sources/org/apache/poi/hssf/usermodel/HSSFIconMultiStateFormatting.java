package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.cf.IconMultiStateThreshold;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFIconMultiStateFormatting implements IconMultiStateFormatting {
    private final CFRule12Record cfRule12Record;
    private final org.apache.poi.hssf.record.cf.IconMultiStateFormatting iconFormatting;
    private final HSSFSheet sheet;

    protected HSSFIconMultiStateFormatting(CFRule12Record cFRule12Record, HSSFSheet hSSFSheet) {
        this.sheet = hSSFSheet;
        this.cfRule12Record = cFRule12Record;
        this.iconFormatting = cFRule12Record.getMultiStateFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public IconMultiStateFormatting.IconSet getIconSet() {
        return this.iconFormatting.getIconSet();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconSet(IconMultiStateFormatting.IconSet iconSet) {
        this.iconFormatting.setIconSet(iconSet);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isIconOnly() {
        return this.iconFormatting.isIconOnly();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconOnly(boolean z) {
        this.iconFormatting.setIconOnly(z);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isReversed() {
        return this.iconFormatting.isReversed();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setReversed(boolean z) {
        this.iconFormatting.setReversed(z);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public HSSFConditionalFormattingThreshold[] getThresholds() {
        Threshold[] thresholds = this.iconFormatting.getThresholds();
        HSSFConditionalFormattingThreshold[] hSSFConditionalFormattingThresholdArr = new HSSFConditionalFormattingThreshold[thresholds.length];
        for (int i = 0; i < thresholds.length; i++) {
            hSSFConditionalFormattingThresholdArr[i] = new HSSFConditionalFormattingThreshold(thresholds[i], this.sheet);
        }
        return hSSFConditionalFormattingThresholdArr;
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        int length = conditionalFormattingThresholdArr.length;
        Threshold[] thresholdArr = new Threshold[length];
        for (int i = 0; i < length; i++) {
            thresholdArr[i] = ((HSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i]).getThreshold();
        }
        this.iconFormatting.setThresholds(thresholdArr);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public HSSFConditionalFormattingThreshold createThreshold() {
        return new HSSFConditionalFormattingThreshold(new IconMultiStateThreshold(), this.sheet);
    }
}
