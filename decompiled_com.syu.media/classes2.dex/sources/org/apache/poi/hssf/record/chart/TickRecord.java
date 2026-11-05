package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TickRecord extends StandardRecord {
    public static final short sid = 4126;
    private short field_10_options;
    private short field_11_tickColor;
    private short field_12_zero5;
    private byte field_1_majorTickType;
    private byte field_2_minorTickType;
    private byte field_3_labelPosition;
    private byte field_4_background;
    private int field_5_labelColorRgb;
    private int field_6_zero1;
    private int field_7_zero2;
    private int field_8_zero3;
    private int field_9_zero4;
    private static final BitField autoTextColor = BitFieldFactory.getInstance(1);
    private static final BitField autoTextBackground = BitFieldFactory.getInstance(2);
    private static final BitField rotation = BitFieldFactory.getInstance(28);
    private static final BitField autorotate = BitFieldFactory.getInstance(32);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 30;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public TickRecord() {
    }

    public TickRecord(RecordInputStream recordInputStream) {
        this.field_1_majorTickType = recordInputStream.readByte();
        this.field_2_minorTickType = recordInputStream.readByte();
        this.field_3_labelPosition = recordInputStream.readByte();
        this.field_4_background = recordInputStream.readByte();
        this.field_5_labelColorRgb = recordInputStream.readInt();
        this.field_6_zero1 = recordInputStream.readInt();
        this.field_7_zero2 = recordInputStream.readInt();
        this.field_8_zero3 = recordInputStream.readInt();
        this.field_9_zero4 = recordInputStream.readInt();
        this.field_10_options = recordInputStream.readShort();
        this.field_11_tickColor = recordInputStream.readShort();
        this.field_12_zero5 = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[TICK]\n    .majorTickType        = 0x");
        stringBuffer.append(HexDump.toHex(getMajorTickType())).append(" (").append((int) getMajorTickType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .minorTickType        = 0x").append(HexDump.toHex(getMinorTickType())).append(" (").append((int) getMinorTickType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .labelPosition        = 0x").append(HexDump.toHex(getLabelPosition())).append(" (").append((int) getLabelPosition()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .background           = 0x").append(HexDump.toHex(getBackground())).append(" (").append((int) getBackground()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .labelColorRgb        = 0x").append(HexDump.toHex(getLabelColorRgb())).append(" (").append(getLabelColorRgb()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .zero1                = 0x").append(HexDump.toHex(getZero1())).append(" (").append(getZero1()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .zero2                = 0x").append(HexDump.toHex(getZero2())).append(" (").append(getZero2()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .options              = 0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .autoTextColor            = ").append(isAutoTextColor()).append("\n         .autoTextBackground       = ");
        stringBuffer.append(isAutoTextBackground()).append("\n         .rotation                 = ");
        stringBuffer.append((int) getRotation()).append("\n         .autorotate               = ");
        stringBuffer.append(isAutorotate()).append("\n    .tickColor            = 0x");
        stringBuffer.append(HexDump.toHex(getTickColor())).append(" (").append((int) getTickColor()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .zero3                = 0x").append(HexDump.toHex(getZero3())).append(" (").append((int) getZero3()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/TICK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_1_majorTickType);
        littleEndianOutput.writeByte(this.field_2_minorTickType);
        littleEndianOutput.writeByte(this.field_3_labelPosition);
        littleEndianOutput.writeByte(this.field_4_background);
        littleEndianOutput.writeInt(this.field_5_labelColorRgb);
        littleEndianOutput.writeInt(this.field_6_zero1);
        littleEndianOutput.writeInt(this.field_7_zero2);
        littleEndianOutput.writeInt(this.field_8_zero3);
        littleEndianOutput.writeInt(this.field_9_zero4);
        littleEndianOutput.writeShort(this.field_10_options);
        littleEndianOutput.writeShort(this.field_11_tickColor);
        littleEndianOutput.writeShort(this.field_12_zero5);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        TickRecord tickRecord = new TickRecord();
        tickRecord.field_1_majorTickType = this.field_1_majorTickType;
        tickRecord.field_2_minorTickType = this.field_2_minorTickType;
        tickRecord.field_3_labelPosition = this.field_3_labelPosition;
        tickRecord.field_4_background = this.field_4_background;
        tickRecord.field_5_labelColorRgb = this.field_5_labelColorRgb;
        tickRecord.field_6_zero1 = this.field_6_zero1;
        tickRecord.field_7_zero2 = this.field_7_zero2;
        tickRecord.field_8_zero3 = this.field_8_zero3;
        tickRecord.field_9_zero4 = this.field_9_zero4;
        tickRecord.field_10_options = this.field_10_options;
        tickRecord.field_11_tickColor = this.field_11_tickColor;
        tickRecord.field_12_zero5 = this.field_12_zero5;
        return tickRecord;
    }

    public byte getMajorTickType() {
        return this.field_1_majorTickType;
    }

    public void setMajorTickType(byte b) {
        this.field_1_majorTickType = b;
    }

    public byte getMinorTickType() {
        return this.field_2_minorTickType;
    }

    public void setMinorTickType(byte b) {
        this.field_2_minorTickType = b;
    }

    public byte getLabelPosition() {
        return this.field_3_labelPosition;
    }

    public void setLabelPosition(byte b) {
        this.field_3_labelPosition = b;
    }

    public byte getBackground() {
        return this.field_4_background;
    }

    public void setBackground(byte b) {
        this.field_4_background = b;
    }

    public int getLabelColorRgb() {
        return this.field_5_labelColorRgb;
    }

    public void setLabelColorRgb(int i) {
        this.field_5_labelColorRgb = i;
    }

    public int getZero1() {
        return this.field_6_zero1;
    }

    public void setZero1(int i) {
        this.field_6_zero1 = i;
    }

    public int getZero2() {
        return this.field_7_zero2;
    }

    public void setZero2(int i) {
        this.field_7_zero2 = i;
    }

    public short getOptions() {
        return this.field_10_options;
    }

    public void setOptions(short s) {
        this.field_10_options = s;
    }

    public short getTickColor() {
        return this.field_11_tickColor;
    }

    public void setTickColor(short s) {
        this.field_11_tickColor = s;
    }

    public short getZero3() {
        return this.field_12_zero5;
    }

    public void setZero3(short s) {
        this.field_12_zero5 = s;
    }

    public void setAutoTextColor(boolean z) {
        this.field_10_options = autoTextColor.setShortBoolean(this.field_10_options, z);
    }

    public boolean isAutoTextColor() {
        return autoTextColor.isSet(this.field_10_options);
    }

    public void setAutoTextBackground(boolean z) {
        this.field_10_options = autoTextBackground.setShortBoolean(this.field_10_options, z);
    }

    public boolean isAutoTextBackground() {
        return autoTextBackground.isSet(this.field_10_options);
    }

    public void setRotation(short s) {
        this.field_10_options = rotation.setShortValue(this.field_10_options, s);
    }

    public short getRotation() {
        return rotation.getShortValue(this.field_10_options);
    }

    public void setAutorotate(boolean z) {
        this.field_10_options = autorotate.setShortBoolean(this.field_10_options, z);
    }

    public boolean isAutorotate() {
        return autorotate.isSet(this.field_10_options);
    }
}
