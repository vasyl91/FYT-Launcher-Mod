package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AreaFormatRecord extends StandardRecord implements Cloneable {
    private static final BitField automatic = BitFieldFactory.getInstance(1);
    private static final BitField invert = BitFieldFactory.getInstance(2);
    public static final short sid = 4106;
    private int field_1_foregroundColor;
    private int field_2_backgroundColor;
    private short field_3_pattern;
    private short field_4_formatFlags;
    private short field_5_forecolorIndex;
    private short field_6_backcolorIndex;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AreaFormatRecord() {
    }

    public AreaFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_foregroundColor = recordInputStream.readInt();
        this.field_2_backgroundColor = recordInputStream.readInt();
        this.field_3_pattern = recordInputStream.readShort();
        this.field_4_formatFlags = recordInputStream.readShort();
        this.field_5_forecolorIndex = recordInputStream.readShort();
        this.field_6_backcolorIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[AREAFORMAT]\n    .foregroundColor      = 0x");
        stringBuffer.append(HexDump.toHex(getForegroundColor())).append(" (").append(getForegroundColor()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .backgroundColor      = 0x").append(HexDump.toHex(getBackgroundColor())).append(" (").append(getBackgroundColor()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .pattern              = 0x").append(HexDump.toHex(getPattern())).append(" (").append((int) getPattern()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .formatFlags          = 0x").append(HexDump.toHex(getFormatFlags())).append(" (").append((int) getFormatFlags()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .automatic                = ").append(isAutomatic()).append("\n         .invert                   = ");
        stringBuffer.append(isInvert()).append("\n    .forecolorIndex       = 0x");
        stringBuffer.append(HexDump.toHex(getForecolorIndex())).append(" (").append((int) getForecolorIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .backcolorIndex       = 0x").append(HexDump.toHex(getBackcolorIndex())).append(" (").append((int) getBackcolorIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/AREAFORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_foregroundColor);
        littleEndianOutput.writeInt(this.field_2_backgroundColor);
        littleEndianOutput.writeShort(this.field_3_pattern);
        littleEndianOutput.writeShort(this.field_4_formatFlags);
        littleEndianOutput.writeShort(this.field_5_forecolorIndex);
        littleEndianOutput.writeShort(this.field_6_backcolorIndex);
    }

    @Override // org.apache.poi.hssf.record.Record
    public AreaFormatRecord clone() {
        AreaFormatRecord areaFormatRecord = new AreaFormatRecord();
        areaFormatRecord.field_1_foregroundColor = this.field_1_foregroundColor;
        areaFormatRecord.field_2_backgroundColor = this.field_2_backgroundColor;
        areaFormatRecord.field_3_pattern = this.field_3_pattern;
        areaFormatRecord.field_4_formatFlags = this.field_4_formatFlags;
        areaFormatRecord.field_5_forecolorIndex = this.field_5_forecolorIndex;
        areaFormatRecord.field_6_backcolorIndex = this.field_6_backcolorIndex;
        return areaFormatRecord;
    }

    public int getForegroundColor() {
        return this.field_1_foregroundColor;
    }

    public void setForegroundColor(int i) {
        this.field_1_foregroundColor = i;
    }

    public int getBackgroundColor() {
        return this.field_2_backgroundColor;
    }

    public void setBackgroundColor(int i) {
        this.field_2_backgroundColor = i;
    }

    public short getPattern() {
        return this.field_3_pattern;
    }

    public void setPattern(short s) {
        this.field_3_pattern = s;
    }

    public short getFormatFlags() {
        return this.field_4_formatFlags;
    }

    public void setFormatFlags(short s) {
        this.field_4_formatFlags = s;
    }

    public short getForecolorIndex() {
        return this.field_5_forecolorIndex;
    }

    public void setForecolorIndex(short s) {
        this.field_5_forecolorIndex = s;
    }

    public short getBackcolorIndex() {
        return this.field_6_backcolorIndex;
    }

    public void setBackcolorIndex(short s) {
        this.field_6_backcolorIndex = s;
    }

    public void setAutomatic(boolean z) {
        this.field_4_formatFlags = automatic.setShortBoolean(this.field_4_formatFlags, z);
    }

    public boolean isAutomatic() {
        return automatic.isSet(this.field_4_formatFlags);
    }

    public void setInvert(boolean z) {
        this.field_4_formatFlags = invert.setShortBoolean(this.field_4_formatFlags, z);
    }

    public boolean isInvert() {
        return invert.isSet(this.field_4_formatFlags);
    }
}
