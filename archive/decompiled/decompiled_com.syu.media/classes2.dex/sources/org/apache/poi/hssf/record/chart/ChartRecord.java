package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ChartRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4098;
    private int field_1_x;
    private int field_2_y;
    private int field_3_width;
    private int field_4_height;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ChartRecord() {
    }

    public ChartRecord(RecordInputStream recordInputStream) {
        this.field_1_x = recordInputStream.readInt();
        this.field_2_y = recordInputStream.readInt();
        this.field_3_width = recordInputStream.readInt();
        this.field_4_height = recordInputStream.readInt();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CHART]\n    .x     = ");
        stringBuffer.append(getX()).append("\n    .y     = ");
        stringBuffer.append(getY()).append("\n    .width = ");
        stringBuffer.append(getWidth()).append("\n    .height= ");
        stringBuffer.append(getHeight()).append("\n[/CHART]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_x);
        littleEndianOutput.writeInt(this.field_2_y);
        littleEndianOutput.writeInt(this.field_3_width);
        littleEndianOutput.writeInt(this.field_4_height);
    }

    @Override // org.apache.poi.hssf.record.Record
    public ChartRecord clone() {
        ChartRecord chartRecord = new ChartRecord();
        chartRecord.field_1_x = this.field_1_x;
        chartRecord.field_2_y = this.field_2_y;
        chartRecord.field_3_width = this.field_3_width;
        chartRecord.field_4_height = this.field_4_height;
        return chartRecord;
    }

    public int getX() {
        return this.field_1_x;
    }

    public void setX(int i) {
        this.field_1_x = i;
    }

    public int getY() {
        return this.field_2_y;
    }

    public void setY(int i) {
        this.field_2_y = i;
    }

    public int getWidth() {
        return this.field_3_width;
    }

    public void setWidth(int i) {
        this.field_3_width = i;
    }

    public int getHeight() {
        return this.field_4_height;
    }

    public void setHeight(int i) {
        this.field_4_height = i;
    }
}
