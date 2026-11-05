package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AxisRecord extends StandardRecord implements Cloneable {
    public static final short AXIS_TYPE_CATEGORY_OR_X_AXIS = 0;
    public static final short AXIS_TYPE_SERIES_AXIS = 2;
    public static final short AXIS_TYPE_VALUE_AXIS = 1;
    public static final short sid = 4125;
    private short field_1_axisType;
    private int field_2_reserved1;
    private int field_3_reserved2;
    private int field_4_reserved3;
    private int field_5_reserved4;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AxisRecord() {
    }

    public AxisRecord(RecordInputStream recordInputStream) {
        this.field_1_axisType = recordInputStream.readShort();
        this.field_2_reserved1 = recordInputStream.readInt();
        this.field_3_reserved2 = recordInputStream.readInt();
        this.field_4_reserved3 = recordInputStream.readInt();
        this.field_5_reserved4 = recordInputStream.readInt();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[AXIS]\n    .axisType             = 0x");
        stringBuffer.append(HexDump.toHex(getAxisType())).append(" (").append((int) getAxisType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .reserved1            = 0x").append(HexDump.toHex(getReserved1())).append(" (").append(getReserved1()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .reserved2            = 0x").append(HexDump.toHex(getReserved2())).append(" (").append(getReserved2()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .reserved3            = 0x").append(HexDump.toHex(getReserved3())).append(" (").append(getReserved3()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .reserved4            = 0x").append(HexDump.toHex(getReserved4())).append(" (").append(getReserved4()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/AXIS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_axisType);
        littleEndianOutput.writeInt(this.field_2_reserved1);
        littleEndianOutput.writeInt(this.field_3_reserved2);
        littleEndianOutput.writeInt(this.field_4_reserved3);
        littleEndianOutput.writeInt(this.field_5_reserved4);
    }

    @Override // org.apache.poi.hssf.record.Record
    public AxisRecord clone() {
        AxisRecord axisRecord = new AxisRecord();
        axisRecord.field_1_axisType = this.field_1_axisType;
        axisRecord.field_2_reserved1 = this.field_2_reserved1;
        axisRecord.field_3_reserved2 = this.field_3_reserved2;
        axisRecord.field_4_reserved3 = this.field_4_reserved3;
        axisRecord.field_5_reserved4 = this.field_5_reserved4;
        return axisRecord;
    }

    public short getAxisType() {
        return this.field_1_axisType;
    }

    public void setAxisType(short s) {
        this.field_1_axisType = s;
    }

    public int getReserved1() {
        return this.field_2_reserved1;
    }

    public void setReserved1(int i) {
        this.field_2_reserved1 = i;
    }

    public int getReserved2() {
        return this.field_3_reserved2;
    }

    public void setReserved2(int i) {
        this.field_3_reserved2 = i;
    }

    public int getReserved3() {
        return this.field_4_reserved3;
    }

    public void setReserved3(int i) {
        this.field_4_reserved3 = i;
    }

    public int getReserved4() {
        return this.field_5_reserved4;
    }

    public void setReserved4(int i) {
        this.field_5_reserved4 = i;
    }
}
