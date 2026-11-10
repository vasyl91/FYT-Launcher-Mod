package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AxisUsedRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4166;
    private short field_1_numAxis;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AxisUsedRecord() {
    }

    public AxisUsedRecord(RecordInputStream recordInputStream) {
        this.field_1_numAxis = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[AXISUSED]\n    .numAxis              = 0x");
        stringBuffer.append(HexDump.toHex(getNumAxis())).append(" (").append((int) getNumAxis()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/AXISUSED]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numAxis);
    }

    @Override // org.apache.poi.hssf.record.Record
    public AxisUsedRecord clone() {
        AxisUsedRecord axisUsedRecord = new AxisUsedRecord();
        axisUsedRecord.field_1_numAxis = this.field_1_numAxis;
        return axisUsedRecord;
    }

    public short getNumAxis() {
        return this.field_1_numAxis;
    }

    public void setNumAxis(short s) {
        this.field_1_numAxis = s;
    }
}
