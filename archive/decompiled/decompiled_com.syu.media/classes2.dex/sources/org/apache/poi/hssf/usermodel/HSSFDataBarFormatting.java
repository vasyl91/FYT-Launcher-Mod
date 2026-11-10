package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.cf.DataBarThreshold;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DataBarFormatting;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFDataBarFormatting implements DataBarFormatting {
    private final CFRule12Record cfRule12Record;
    private final org.apache.poi.hssf.record.cf.DataBarFormatting databarFormatting;
    private final HSSFSheet sheet;

    protected HSSFDataBarFormatting(CFRule12Record cFRule12Record, HSSFSheet hSSFSheet) {
        this.sheet = hSSFSheet;
        this.cfRule12Record = cFRule12Record;
        this.databarFormatting = cFRule12Record.getDataBarFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public boolean isLeftToRight() {
        return !this.databarFormatting.isReversed();
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public void setLeftToRight(boolean z) {
        this.databarFormatting.setReversed(!z);
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public int getWidthMin() {
        return this.databarFormatting.getPercentMin();
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public void setWidthMin(int i) {
        this.databarFormatting.setPercentMin((byte) i);
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public int getWidthMax() {
        return this.databarFormatting.getPercentMax();
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public void setWidthMax(int i) {
        this.databarFormatting.setPercentMax((byte) i);
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public HSSFExtendedColor getColor() {
        return new HSSFExtendedColor(this.databarFormatting.getColor());
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public void setColor(Color color) {
        this.databarFormatting.setColor(((HSSFExtendedColor) color).getExtendedColor());
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public HSSFConditionalFormattingThreshold getMinThreshold() {
        return new HSSFConditionalFormattingThreshold(this.databarFormatting.getThresholdMin(), this.sheet);
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public HSSFConditionalFormattingThreshold getMaxThreshold() {
        return new HSSFConditionalFormattingThreshold(this.databarFormatting.getThresholdMax(), this.sheet);
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public boolean isIconOnly() {
        return this.databarFormatting.isIconOnly();
    }

    @Override // org.apache.poi.ss.usermodel.DataBarFormatting
    public void setIconOnly(boolean z) {
        this.databarFormatting.setIconOnly(z);
    }

    public HSSFConditionalFormattingThreshold createThreshold() {
        return new HSSFConditionalFormattingThreshold(new DataBarThreshold(), this.sheet);
    }
}
