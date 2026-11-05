package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AxisParentRecord extends StandardRecord implements Cloneable {
    public static final short AXIS_TYPE_MAIN = 0;
    public static final short AXIS_TYPE_SECONDARY = 1;
    public static final short sid = 4161;
    private short field_1_axisType;
    private int field_2_x;
    private int field_3_y;
    private int field_4_width;
    private int field_5_height;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AxisParentRecord() {
    }

    public AxisParentRecord(RecordInputStream recordInputStream) {
        this.field_1_axisType = recordInputStream.readShort();
        this.field_2_x = recordInputStream.readInt();
        this.field_3_y = recordInputStream.readInt();
        this.field_4_width = recordInputStream.readInt();
        this.field_5_height = recordInputStream.readInt();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[AXISPARENT]\n    .axisType             = 0x");
        stringBuffer.append(HexDump.toHex(getAxisType())).append(" (").append((int) getAxisType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .x                    = 0x").append(HexDump.toHex(getX())).append(" (").append(getX()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .y                    = 0x").append(HexDump.toHex(getY())).append(" (").append(getY()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .width                = 0x").append(HexDump.toHex(getWidth())).append(" (").append(getWidth()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .height               = 0x").append(HexDump.toHex(getHeight())).append(" (").append(getHeight()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/AXISPARENT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_axisType);
        littleEndianOutput.writeInt(this.field_2_x);
        littleEndianOutput.writeInt(this.field_3_y);
        littleEndianOutput.writeInt(this.field_4_width);
        littleEndianOutput.writeInt(this.field_5_height);
    }

    @Override // org.apache.poi.hssf.record.Record
    public AxisParentRecord clone() {
        AxisParentRecord axisParentRecord = new AxisParentRecord();
        axisParentRecord.field_1_axisType = this.field_1_axisType;
        axisParentRecord.field_2_x = this.field_2_x;
        axisParentRecord.field_3_y = this.field_3_y;
        axisParentRecord.field_4_width = this.field_4_width;
        axisParentRecord.field_5_height = this.field_5_height;
        return axisParentRecord;
    }

    public short getAxisType() {
        return this.field_1_axisType;
    }

    public void setAxisType(short s) {
        this.field_1_axisType = s;
    }

    public int getX() {
        return this.field_2_x;
    }

    public void setX(int i) {
        this.field_2_x = i;
    }

    public int getY() {
        return this.field_3_y;
    }

    public void setY(int i) {
        this.field_3_y = i;
    }

    public int getWidth() {
        return this.field_4_width;
    }

    public void setWidth(int i) {
        this.field_4_width = i;
    }

    public int getHeight() {
        return this.field_5_height;
    }

    public void setHeight(int i) {
        this.field_5_height = i;
    }
}
