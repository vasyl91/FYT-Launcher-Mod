package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SeriesChartGroupIndexRecord extends StandardRecord {
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

    public SeriesChartGroupIndexRecord() {
    }

    public SeriesChartGroupIndexRecord(RecordInputStream recordInputStream) {
        this.field_1_chartGroupIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SERTOCRT]\n    .chartGroupIndex      = 0x");
        stringBuffer.append(HexDump.toHex(getChartGroupIndex())).append(" (").append((int) getChartGroupIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/SERTOCRT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_chartGroupIndex);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SeriesChartGroupIndexRecord seriesChartGroupIndexRecord = new SeriesChartGroupIndexRecord();
        seriesChartGroupIndexRecord.field_1_chartGroupIndex = this.field_1_chartGroupIndex;
        return seriesChartGroupIndexRecord;
    }

    public short getChartGroupIndex() {
        return this.field_1_chartGroupIndex;
    }

    public void setChartGroupIndex(short s) {
        this.field_1_chartGroupIndex = s;
    }
}
