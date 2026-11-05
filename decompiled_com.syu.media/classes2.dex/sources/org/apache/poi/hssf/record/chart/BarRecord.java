package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BarRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4119;
    private short field_1_barSpace;
    private short field_2_categorySpace;
    private short field_3_formatFlags;
    private static final BitField horizontal = BitFieldFactory.getInstance(1);
    private static final BitField stacked = BitFieldFactory.getInstance(2);
    private static final BitField displayAsPercentage = BitFieldFactory.getInstance(4);
    private static final BitField shadow = BitFieldFactory.getInstance(8);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public BarRecord() {
    }

    public BarRecord(RecordInputStream recordInputStream) {
        this.field_1_barSpace = recordInputStream.readShort();
        this.field_2_categorySpace = recordInputStream.readShort();
        this.field_3_formatFlags = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[BAR]\n    .barSpace             = 0x");
        stringBuffer.append(HexDump.toHex(getBarSpace())).append(" (").append((int) getBarSpace()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .categorySpace        = 0x").append(HexDump.toHex(getCategorySpace())).append(" (").append((int) getCategorySpace()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .formatFlags          = 0x").append(HexDump.toHex(getFormatFlags())).append(" (").append((int) getFormatFlags()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .horizontal               = ").append(isHorizontal()).append("\n         .stacked                  = ");
        stringBuffer.append(isStacked()).append("\n         .displayAsPercentage      = ");
        stringBuffer.append(isDisplayAsPercentage()).append("\n         .shadow                   = ");
        stringBuffer.append(isShadow()).append("\n[/BAR]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_barSpace);
        littleEndianOutput.writeShort(this.field_2_categorySpace);
        littleEndianOutput.writeShort(this.field_3_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public BarRecord clone() {
        BarRecord barRecord = new BarRecord();
        barRecord.field_1_barSpace = this.field_1_barSpace;
        barRecord.field_2_categorySpace = this.field_2_categorySpace;
        barRecord.field_3_formatFlags = this.field_3_formatFlags;
        return barRecord;
    }

    public short getBarSpace() {
        return this.field_1_barSpace;
    }

    public void setBarSpace(short s) {
        this.field_1_barSpace = s;
    }

    public short getCategorySpace() {
        return this.field_2_categorySpace;
    }

    public void setCategorySpace(short s) {
        this.field_2_categorySpace = s;
    }

    public short getFormatFlags() {
        return this.field_3_formatFlags;
    }

    public void setFormatFlags(short s) {
        this.field_3_formatFlags = s;
    }

    public void setHorizontal(boolean z) {
        this.field_3_formatFlags = horizontal.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isHorizontal() {
        return horizontal.isSet(this.field_3_formatFlags);
    }

    public void setStacked(boolean z) {
        this.field_3_formatFlags = stacked.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_3_formatFlags);
    }

    public void setDisplayAsPercentage(boolean z) {
        this.field_3_formatFlags = displayAsPercentage.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_3_formatFlags);
    }

    public void setShadow(boolean z) {
        this.field_3_formatFlags = shadow.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_3_formatFlags);
    }
}
