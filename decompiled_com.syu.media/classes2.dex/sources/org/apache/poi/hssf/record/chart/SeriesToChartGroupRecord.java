package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SeriesToChartGroupRecord extends StandardRecord {
    public static final short sid = 4165;
    private short field_1_chartGroupIndex;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 4165;
    }

    public SeriesToChartGroupRecord() {
    }

    public SeriesToChartGroupRecord(RecordInputStream recordInputStream) {
        this.field_1_chartGroupIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SeriesToChartGroup]\n    .chartGroupIndex      = 0x");
        stringBuffer.append(HexDump.toHex(getChartGroupIndex())).append(" (").append((int) getChartGroupIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/SeriesToChartGroup]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_chartGroupIndex);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SeriesToChartGroupRecord seriesToChartGroupRecord = new SeriesToChartGroupRecord();
        seriesToChartGroupRecord.field_1_chartGroupIndex = this.field_1_chartGroupIndex;
        return seriesToChartGroupRecord;
    }

    public short getChartGroupIndex() {
        return this.field_1_chartGroupIndex;
    }

    public void setChartGroupIndex(short s) {
        this.field_1_chartGroupIndex = s;
    }
}
