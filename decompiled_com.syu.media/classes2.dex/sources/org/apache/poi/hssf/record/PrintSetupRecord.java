package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PrintSetupRecord extends StandardRecord {
    public static final short sid = 161;
    private double field_10_footermargin;
    private short field_11_copies;
    private short field_1_paper_size;
    private short field_2_scale;
    private short field_3_page_start;
    private short field_4_fit_width;
    private short field_5_fit_height;
    private short field_6_options;
    private short field_7_hresolution;
    private short field_8_vresolution;
    private double field_9_headermargin;
    private static final BitField lefttoright = BitFieldFactory.getInstance(1);
    private static final BitField landscape = BitFieldFactory.getInstance(2);
    private static final BitField validsettings = BitFieldFactory.getInstance(4);
    private static final BitField nocolor = BitFieldFactory.getInstance(8);
    private static final BitField draft = BitFieldFactory.getInstance(16);
    private static final BitField notes = BitFieldFactory.getInstance(32);
    private static final BitField noOrientation = BitFieldFactory.getInstance(64);
    private static final BitField usepage = BitFieldFactory.getInstance(128);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 34;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 161;
    }

    public PrintSetupRecord() {
    }

    public PrintSetupRecord(RecordInputStream recordInputStream) {
        this.field_1_paper_size = recordInputStream.readShort();
        this.field_2_scale = recordInputStream.readShort();
        this.field_3_page_start = recordInputStream.readShort();
        this.field_4_fit_width = recordInputStream.readShort();
        this.field_5_fit_height = recordInputStream.readShort();
        this.field_6_options = recordInputStream.readShort();
        this.field_7_hresolution = recordInputStream.readShort();
        this.field_8_vresolution = recordInputStream.readShort();
        this.field_9_headermargin = recordInputStream.readDouble();
        this.field_10_footermargin = recordInputStream.readDouble();
        this.field_11_copies = recordInputStream.readShort();
    }

    public void setPaperSize(short s) {
        this.field_1_paper_size = s;
    }

    public void setScale(short s) {
        this.field_2_scale = s;
    }

    public void setPageStart(short s) {
        this.field_3_page_start = s;
    }

    public void setFitWidth(short s) {
        this.field_4_fit_width = s;
    }

    public void setFitHeight(short s) {
        this.field_5_fit_height = s;
    }

    public void setOptions(short s) {
        this.field_6_options = s;
    }

    public void setLeftToRight(boolean z) {
        this.field_6_options = lefttoright.setShortBoolean(this.field_6_options, z);
    }

    public void setLandscape(boolean z) {
        this.field_6_options = landscape.setShortBoolean(this.field_6_options, z);
    }

    public void setValidSettings(boolean z) {
        this.field_6_options = validsettings.setShortBoolean(this.field_6_options, z);
    }

    public void setNoColor(boolean z) {
        this.field_6_options = nocolor.setShortBoolean(this.field_6_options, z);
    }

    public void setDraft(boolean z) {
        this.field_6_options = draft.setShortBoolean(this.field_6_options, z);
    }

    public void setNotes(boolean z) {
        this.field_6_options = notes.setShortBoolean(this.field_6_options, z);
    }

    public void setNoOrientation(boolean z) {
        this.field_6_options = noOrientation.setShortBoolean(this.field_6_options, z);
    }

    public void setUsePage(boolean z) {
        this.field_6_options = usepage.setShortBoolean(this.field_6_options, z);
    }

    public void setHResolution(short s) {
        this.field_7_hresolution = s;
    }

    public void setVResolution(short s) {
        this.field_8_vresolution = s;
    }

    public void setHeaderMargin(double d) {
        this.field_9_headermargin = d;
    }

    public void setFooterMargin(double d) {
        this.field_10_footermargin = d;
    }

    public void setCopies(short s) {
        this.field_11_copies = s;
    }

    public short getPaperSize() {
        return this.field_1_paper_size;
    }

    public short getScale() {
        return this.field_2_scale;
    }

    public short getPageStart() {
        return this.field_3_page_start;
    }

    public short getFitWidth() {
        return this.field_4_fit_width;
    }

    public short getFitHeight() {
        return this.field_5_fit_height;
    }

    public short getOptions() {
        return this.field_6_options;
    }

    public boolean getLeftToRight() {
        return lefttoright.isSet(this.field_6_options);
    }

    public boolean getLandscape() {
        return landscape.isSet(this.field_6_options);
    }

    public boolean getValidSettings() {
        return validsettings.isSet(this.field_6_options);
    }

    public boolean getNoColor() {
        return nocolor.isSet(this.field_6_options);
    }

    public boolean getDraft() {
        return draft.isSet(this.field_6_options);
    }

    public boolean getNotes() {
        return notes.isSet(this.field_6_options);
    }

    public boolean getNoOrientation() {
        return noOrientation.isSet(this.field_6_options);
    }

    public boolean getUsePage() {
        return usepage.isSet(this.field_6_options);
    }

    public short getHResolution() {
        return this.field_7_hresolution;
    }

    public short getVResolution() {
        return this.field_8_vresolution;
    }

    public double getHeaderMargin() {
        return this.field_9_headermargin;
    }

    public double getFooterMargin() {
        return this.field_10_footermargin;
    }

    public short getCopies() {
        return this.field_11_copies;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PRINTSETUP]\n    .papersize      = ");
        stringBuffer.append((int) getPaperSize()).append("\n    .scale          = ");
        stringBuffer.append((int) getScale()).append("\n    .pagestart      = ");
        stringBuffer.append((int) getPageStart()).append("\n    .fitwidth       = ");
        stringBuffer.append((int) getFitWidth()).append("\n    .fitheight      = ");
        stringBuffer.append((int) getFitHeight()).append("\n    .options        = ");
        stringBuffer.append((int) getOptions()).append("\n        .ltor       = ");
        stringBuffer.append(getLeftToRight()).append("\n        .landscape  = ");
        stringBuffer.append(getLandscape()).append("\n        .valid      = ");
        stringBuffer.append(getValidSettings()).append("\n        .mono       = ");
        stringBuffer.append(getNoColor()).append("\n        .draft      = ");
        stringBuffer.append(getDraft()).append("\n        .notes      = ");
        stringBuffer.append(getNotes()).append("\n        .noOrientat = ");
        stringBuffer.append(getNoOrientation()).append("\n        .usepage    = ");
        stringBuffer.append(getUsePage()).append("\n    .hresolution    = ");
        stringBuffer.append((int) getHResolution()).append("\n    .vresolution    = ");
        stringBuffer.append((int) getVResolution()).append("\n    .headermargin   = ");
        stringBuffer.append(getHeaderMargin()).append("\n    .footermargin   = ");
        stringBuffer.append(getFooterMargin()).append("\n    .copies         = ");
        stringBuffer.append((int) getCopies()).append("\n[/PRINTSETUP]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getPaperSize());
        littleEndianOutput.writeShort(getScale());
        littleEndianOutput.writeShort(getPageStart());
        littleEndianOutput.writeShort(getFitWidth());
        littleEndianOutput.writeShort(getFitHeight());
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeShort(getHResolution());
        littleEndianOutput.writeShort(getVResolution());
        littleEndianOutput.writeDouble(getHeaderMargin());
        littleEndianOutput.writeDouble(getFooterMargin());
        littleEndianOutput.writeShort(getCopies());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        PrintSetupRecord printSetupRecord = new PrintSetupRecord();
        printSetupRecord.field_1_paper_size = this.field_1_paper_size;
        printSetupRecord.field_2_scale = this.field_2_scale;
        printSetupRecord.field_3_page_start = this.field_3_page_start;
        printSetupRecord.field_4_fit_width = this.field_4_fit_width;
        printSetupRecord.field_5_fit_height = this.field_5_fit_height;
        printSetupRecord.field_6_options = this.field_6_options;
        printSetupRecord.field_7_hresolution = this.field_7_hresolution;
        printSetupRecord.field_8_vresolution = this.field_8_vresolution;
        printSetupRecord.field_9_headermargin = this.field_9_headermargin;
        printSetupRecord.field_10_footermargin = this.field_10_footermargin;
        printSetupRecord.field_11_copies = this.field_11_copies;
        return printSetupRecord;
    }
}
