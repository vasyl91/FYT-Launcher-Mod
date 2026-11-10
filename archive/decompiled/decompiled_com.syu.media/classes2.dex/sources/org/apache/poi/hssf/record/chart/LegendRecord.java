package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LegendRecord extends StandardRecord implements Cloneable {
    public static final byte SPACING_CLOSE = 0;
    public static final byte SPACING_MEDIUM = 1;
    public static final byte SPACING_OPEN = 2;
    public static final byte TYPE_BOTTOM = 0;
    public static final byte TYPE_CORNER = 1;
    public static final byte TYPE_LEFT = 4;
    public static final byte TYPE_RIGHT = 3;
    public static final byte TYPE_TOP = 2;
    public static final byte TYPE_UNDOCKED = 7;
    public static final short sid = 4117;
    private int field_1_xAxisUpperLeft;
    private int field_2_yAxisUpperLeft;
    private int field_3_xSize;
    private int field_4_ySize;
    private byte field_5_type;
    private byte field_6_spacing;
    private short field_7_options;
    private static final BitField autoPosition = BitFieldFactory.getInstance(1);
    private static final BitField autoSeries = BitFieldFactory.getInstance(2);
    private static final BitField autoXPositioning = BitFieldFactory.getInstance(4);
    private static final BitField autoYPositioning = BitFieldFactory.getInstance(8);
    private static final BitField vertical = BitFieldFactory.getInstance(16);
    private static final BitField dataTable = BitFieldFactory.getInstance(32);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 20;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public LegendRecord() {
    }

    public LegendRecord(RecordInputStream recordInputStream) {
        this.field_1_xAxisUpperLeft = recordInputStream.readInt();
        this.field_2_yAxisUpperLeft = recordInputStream.readInt();
        this.field_3_xSize = recordInputStream.readInt();
        this.field_4_ySize = recordInputStream.readInt();
        this.field_5_type = recordInputStream.readByte();
        this.field_6_spacing = recordInputStream.readByte();
        this.field_7_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LEGEND]\n    .xAxisUpperLeft       = 0x");
        stringBuffer.append(HexDump.toHex(getXAxisUpperLeft())).append(" (").append(getXAxisUpperLeft()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .yAxisUpperLeft       = 0x").append(HexDump.toHex(getYAxisUpperLeft())).append(" (").append(getYAxisUpperLeft()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .xSize                = 0x").append(HexDump.toHex(getXSize())).append(" (").append(getXSize()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .ySize                = 0x").append(HexDump.toHex(getYSize())).append(" (").append(getYSize()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .type                 = 0x").append(HexDump.toHex(getType())).append(" (").append((int) getType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .spacing              = 0x").append(HexDump.toHex(getSpacing())).append(" (").append((int) getSpacing()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .options              = 0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .autoPosition             = ").append(isAutoPosition()).append("\n         .autoSeries               = ");
        stringBuffer.append(isAutoSeries()).append("\n         .autoXPositioning         = ");
        stringBuffer.append(isAutoXPositioning()).append("\n         .autoYPositioning         = ");
        stringBuffer.append(isAutoYPositioning()).append("\n         .vertical                 = ");
        stringBuffer.append(isVertical()).append("\n         .dataTable                = ");
        stringBuffer.append(isDataTable()).append("\n[/LEGEND]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_xAxisUpperLeft);
        littleEndianOutput.writeInt(this.field_2_yAxisUpperLeft);
        littleEndianOutput.writeInt(this.field_3_xSize);
        littleEndianOutput.writeInt(this.field_4_ySize);
        littleEndianOutput.writeByte(this.field_5_type);
        littleEndianOutput.writeByte(this.field_6_spacing);
        littleEndianOutput.writeShort(this.field_7_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public LegendRecord clone() {
        LegendRecord legendRecord = new LegendRecord();
        legendRecord.field_1_xAxisUpperLeft = this.field_1_xAxisUpperLeft;
        legendRecord.field_2_yAxisUpperLeft = this.field_2_yAxisUpperLeft;
        legendRecord.field_3_xSize = this.field_3_xSize;
        legendRecord.field_4_ySize = this.field_4_ySize;
        legendRecord.field_5_type = this.field_5_type;
        legendRecord.field_6_spacing = this.field_6_spacing;
        legendRecord.field_7_options = this.field_7_options;
        return legendRecord;
    }

    public int getXAxisUpperLeft() {
        return this.field_1_xAxisUpperLeft;
    }

    public void setXAxisUpperLeft(int i) {
        this.field_1_xAxisUpperLeft = i;
    }

    public int getYAxisUpperLeft() {
        return this.field_2_yAxisUpperLeft;
    }

    public void setYAxisUpperLeft(int i) {
        this.field_2_yAxisUpperLeft = i;
    }

    public int getXSize() {
        return this.field_3_xSize;
    }

    public void setXSize(int i) {
        this.field_3_xSize = i;
    }

    public int getYSize() {
        return this.field_4_ySize;
    }

    public void setYSize(int i) {
        this.field_4_ySize = i;
    }

    public byte getType() {
        return this.field_5_type;
    }

    public void setType(byte b) {
        this.field_5_type = b;
    }

    public byte getSpacing() {
        return this.field_6_spacing;
    }

    public void setSpacing(byte b) {
        this.field_6_spacing = b;
    }

    public short getOptions() {
        return this.field_7_options;
    }

    public void setOptions(short s) {
        this.field_7_options = s;
    }

    public void setAutoPosition(boolean z) {
        this.field_7_options = autoPosition.setShortBoolean(this.field_7_options, z);
    }

    public boolean isAutoPosition() {
        return autoPosition.isSet(this.field_7_options);
    }

    public void setAutoSeries(boolean z) {
        this.field_7_options = autoSeries.setShortBoolean(this.field_7_options, z);
    }

    public boolean isAutoSeries() {
        return autoSeries.isSet(this.field_7_options);
    }

    public void setAutoXPositioning(boolean z) {
        this.field_7_options = autoXPositioning.setShortBoolean(this.field_7_options, z);
    }

    public boolean isAutoXPositioning() {
        return autoXPositioning.isSet(this.field_7_options);
    }

    public void setAutoYPositioning(boolean z) {
        this.field_7_options = autoYPositioning.setShortBoolean(this.field_7_options, z);
    }

    public boolean isAutoYPositioning() {
        return autoYPositioning.isSet(this.field_7_options);
    }

    public void setVertical(boolean z) {
        this.field_7_options = vertical.setShortBoolean(this.field_7_options, z);
    }

    public boolean isVertical() {
        return vertical.isSet(this.field_7_options);
    }

    public void setDataTable(boolean z) {
        this.field_7_options = dataTable.setShortBoolean(this.field_7_options, z);
    }

    public boolean isDataTable() {
        return dataTable.isSet(this.field_7_options);
    }
}
