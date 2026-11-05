package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PaneRecord extends StandardRecord {
    public static final short ACTIVE_PANE_LOWER_LEFT = 2;
    public static final short ACTIVE_PANE_LOWER_RIGHT = 0;
    public static final short ACTIVE_PANE_UPPER_LEFT = 3;
    public static final short ACTIVE_PANE_UPPER_RIGHT = 1;
    public static final short sid = 65;
    private short field_1_x;
    private short field_2_y;
    private short field_3_topRow;
    private short field_4_leftColumn;
    private short field_5_activePane;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 10;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 65;
    }

    public PaneRecord() {
    }

    public PaneRecord(RecordInputStream recordInputStream) {
        this.field_1_x = recordInputStream.readShort();
        this.field_2_y = recordInputStream.readShort();
        this.field_3_topRow = recordInputStream.readShort();
        this.field_4_leftColumn = recordInputStream.readShort();
        this.field_5_activePane = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PANE]\n    .x                    = 0x");
        stringBuffer.append(HexDump.toHex(getX())).append(" (").append((int) getX()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .y                    = 0x").append(HexDump.toHex(getY())).append(" (").append((int) getY()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .topRow               = 0x").append(HexDump.toHex(getTopRow())).append(" (").append((int) getTopRow()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .leftColumn           = 0x").append(HexDump.toHex(getLeftColumn())).append(" (").append((int) getLeftColumn()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .activePane           = 0x").append(HexDump.toHex(getActivePane())).append(" (").append((int) getActivePane()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/PANE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_x);
        littleEndianOutput.writeShort(this.field_2_y);
        littleEndianOutput.writeShort(this.field_3_topRow);
        littleEndianOutput.writeShort(this.field_4_leftColumn);
        littleEndianOutput.writeShort(this.field_5_activePane);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        PaneRecord paneRecord = new PaneRecord();
        paneRecord.field_1_x = this.field_1_x;
        paneRecord.field_2_y = this.field_2_y;
        paneRecord.field_3_topRow = this.field_3_topRow;
        paneRecord.field_4_leftColumn = this.field_4_leftColumn;
        paneRecord.field_5_activePane = this.field_5_activePane;
        return paneRecord;
    }

    public short getX() {
        return this.field_1_x;
    }

    public void setX(short s) {
        this.field_1_x = s;
    }

    public short getY() {
        return this.field_2_y;
    }

    public void setY(short s) {
        this.field_2_y = s;
    }

    public short getTopRow() {
        return this.field_3_topRow;
    }

    public void setTopRow(short s) {
        this.field_3_topRow = s;
    }

    public short getLeftColumn() {
        return this.field_4_leftColumn;
    }

    public void setLeftColumn(short s) {
        this.field_4_leftColumn = s;
    }

    public short getActivePane() {
        return this.field_5_activePane;
    }

    public void setActivePane(short s) {
        this.field_5_activePane = s;
    }
}
