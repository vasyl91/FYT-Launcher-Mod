package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ChartFormatRecord extends StandardRecord {
    public static final short sid = 4116;
    private static final BitField varyDisplayPattern = BitFieldFactory.getInstance(1);
    private int field1_x_position;
    private int field2_y_position;
    private int field3_width;
    private int field4_height;
    private int field5_grbit;
    private int field6_unknown;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 20;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ChartFormatRecord() {
    }

    public ChartFormatRecord(RecordInputStream recordInputStream) {
        this.field1_x_position = recordInputStream.readInt();
        this.field2_y_position = recordInputStream.readInt();
        this.field3_width = recordInputStream.readInt();
        this.field4_height = recordInputStream.readInt();
        this.field5_grbit = recordInputStream.readUShort();
        this.field6_unknown = recordInputStream.readUShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CHARTFORMAT]\n    .xPosition       = ");
        stringBuffer.append(getXPosition()).append("\n    .yPosition       = ");
        stringBuffer.append(getYPosition()).append("\n    .width           = ");
        stringBuffer.append(getWidth()).append("\n    .height          = ");
        stringBuffer.append(getHeight()).append("\n    .grBit           = ");
        stringBuffer.append(HexDump.intToHex(this.field5_grbit)).append("\n[/CHARTFORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getXPosition());
        littleEndianOutput.writeInt(getYPosition());
        littleEndianOutput.writeInt(getWidth());
        littleEndianOutput.writeInt(getHeight());
        littleEndianOutput.writeShort(this.field5_grbit);
        littleEndianOutput.writeShort(this.field6_unknown);
    }

    public int getXPosition() {
        return this.field1_x_position;
    }

    public void setXPosition(int i) {
        this.field1_x_position = i;
    }

    public int getYPosition() {
        return this.field2_y_position;
    }

    public void setYPosition(int i) {
        this.field2_y_position = i;
    }

    public int getWidth() {
        return this.field3_width;
    }

    public void setWidth(int i) {
        this.field3_width = i;
    }

    public int getHeight() {
        return this.field4_height;
    }

    public void setHeight(int i) {
        this.field4_height = i;
    }

    public boolean getVaryDisplayPattern() {
        return varyDisplayPattern.isSet(this.field5_grbit);
    }

    public void setVaryDisplayPattern(boolean z) {
        this.field5_grbit = varyDisplayPattern.setBoolean(this.field5_grbit, z);
    }
}
