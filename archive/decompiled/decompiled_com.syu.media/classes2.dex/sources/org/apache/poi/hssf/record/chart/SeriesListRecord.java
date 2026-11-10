package org.apache.poi.hssf.record.chart;

import java.util.Arrays;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SeriesListRecord extends StandardRecord {
    public static final short sid = 4118;
    private short[] field_1_seriesNumbers;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public SeriesListRecord(short[] sArr) {
        this.field_1_seriesNumbers = sArr == null ? null : (short[]) sArr.clone();
    }

    public SeriesListRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        short[] sArr = new short[uShort];
        for (int i = 0; i < uShort; i++) {
            sArr[i] = recordInputStream.readShort();
        }
        this.field_1_seriesNumbers = sArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SERIESLIST]\n    .seriesNumbers=  (");
        stringBuffer.append(Arrays.toString(getSeriesNumbers())).append(" )\n[/SERIESLIST]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_1_seriesNumbers.length;
        littleEndianOutput.writeShort(length);
        for (int i = 0; i < length; i++) {
            littleEndianOutput.writeShort(this.field_1_seriesNumbers[i]);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.field_1_seriesNumbers.length * 2) + 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new SeriesListRecord(this.field_1_seriesNumbers);
    }

    public short[] getSeriesNumbers() {
        return this.field_1_seriesNumbers;
    }
}
