package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SeriesIndexRecord extends StandardRecord {
    public static final short sid = 4197;
    private short field_1_index;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public SeriesIndexRecord() {
    }

    public SeriesIndexRecord(RecordInputStream recordInputStream) {
        this.field_1_index = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SINDEX]\n    .index                = 0x");
        stringBuffer.append(HexDump.toHex(getIndex())).append(" (").append((int) getIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/SINDEX]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_index);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SeriesIndexRecord seriesIndexRecord = new SeriesIndexRecord();
        seriesIndexRecord.field_1_index = this.field_1_index;
        return seriesIndexRecord;
    }

    public short getIndex() {
        return this.field_1_index;
    }

    public void setIndex(short s) {
        this.field_1_index = s;
    }
}
