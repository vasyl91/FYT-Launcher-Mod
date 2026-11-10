package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LineFormatRecord extends StandardRecord implements Cloneable {
    public static final short LINE_PATTERN_DARK_GRAY_PATTERN = 6;
    public static final short LINE_PATTERN_DASH = 1;
    public static final short LINE_PATTERN_DASH_DOT = 3;
    public static final short LINE_PATTERN_DASH_DOT_DOT = 4;
    public static final short LINE_PATTERN_DOT = 2;
    public static final short LINE_PATTERN_LIGHT_GRAY_PATTERN = 8;
    public static final short LINE_PATTERN_MEDIUM_GRAY_PATTERN = 7;
    public static final short LINE_PATTERN_NONE = 5;
    public static final short LINE_PATTERN_SOLID = 0;
    public static final short WEIGHT_HAIRLINE = -1;
    public static final short WEIGHT_MEDIUM = 1;
    public static final short WEIGHT_NARROW = 0;
    public static final short WEIGHT_WIDE = 2;
    public static final short sid = 4103;
    private int field_1_lineColor;
    private short field_2_linePattern;
    private short field_3_weight;
    private short field_4_format;
    private short field_5_colourPaletteIndex;
    private static final BitField auto = BitFieldFactory.getInstance(1);
    private static final BitField drawTicks = BitFieldFactory.getInstance(4);
    private static final BitField unknown = BitFieldFactory.getInstance(4);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public LineFormatRecord() {
    }

    public LineFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_lineColor = recordInputStream.readInt();
        this.field_2_linePattern = recordInputStream.readShort();
        this.field_3_weight = recordInputStream.readShort();
        this.field_4_format = recordInputStream.readShort();
        this.field_5_colourPaletteIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LINEFORMAT]\n    .lineColor            = 0x");
        stringBuffer.append(HexDump.toHex(getLineColor())).append(" (").append(getLineColor()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .linePattern          = 0x").append(HexDump.toHex(getLinePattern())).append(" (").append((int) getLinePattern()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .weight               = 0x").append(HexDump.toHex(getWeight())).append(" (").append((int) getWeight()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .format               = 0x").append(HexDump.toHex(getFormat())).append(" (").append((int) getFormat()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .auto                     = ").append(isAuto()).append("\n         .drawTicks                = ");
        stringBuffer.append(isDrawTicks()).append("\n         .unknown                  = ");
        stringBuffer.append(isUnknown()).append("\n    .colourPaletteIndex   = 0x");
        stringBuffer.append(HexDump.toHex(getColourPaletteIndex())).append(" (").append((int) getColourPaletteIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/LINEFORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_lineColor);
        littleEndianOutput.writeShort(this.field_2_linePattern);
        littleEndianOutput.writeShort(this.field_3_weight);
        littleEndianOutput.writeShort(this.field_4_format);
        littleEndianOutput.writeShort(this.field_5_colourPaletteIndex);
    }

    @Override // org.apache.poi.hssf.record.Record
    public LineFormatRecord clone() {
        LineFormatRecord lineFormatRecord = new LineFormatRecord();
        lineFormatRecord.field_1_lineColor = this.field_1_lineColor;
        lineFormatRecord.field_2_linePattern = this.field_2_linePattern;
        lineFormatRecord.field_3_weight = this.field_3_weight;
        lineFormatRecord.field_4_format = this.field_4_format;
        lineFormatRecord.field_5_colourPaletteIndex = this.field_5_colourPaletteIndex;
        return lineFormatRecord;
    }

    public int getLineColor() {
        return this.field_1_lineColor;
    }

    public void setLineColor(int i) {
        this.field_1_lineColor = i;
    }

    public short getLinePattern() {
        return this.field_2_linePattern;
    }

    public void setLinePattern(short s) {
        this.field_2_linePattern = s;
    }

    public short getWeight() {
        return this.field_3_weight;
    }

    public void setWeight(short s) {
        this.field_3_weight = s;
    }

    public short getFormat() {
        return this.field_4_format;
    }

    public void setFormat(short s) {
        this.field_4_format = s;
    }

    public short getColourPaletteIndex() {
        return this.field_5_colourPaletteIndex;
    }

    public void setColourPaletteIndex(short s) {
        this.field_5_colourPaletteIndex = s;
    }

    public void setAuto(boolean z) {
        this.field_4_format = auto.setShortBoolean(this.field_4_format, z);
    }

    public boolean isAuto() {
        return auto.isSet(this.field_4_format);
    }

    public void setDrawTicks(boolean z) {
        this.field_4_format = drawTicks.setShortBoolean(this.field_4_format, z);
    }

    public boolean isDrawTicks() {
        return drawTicks.isSet(this.field_4_format);
    }

    public void setUnknown(boolean z) {
        this.field_4_format = unknown.setShortBoolean(this.field_4_format, z);
    }

    public boolean isUnknown() {
        return unknown.isSet(this.field_4_format);
    }
}
