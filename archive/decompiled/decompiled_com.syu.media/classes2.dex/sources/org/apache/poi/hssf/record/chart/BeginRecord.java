package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BeginRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4147;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[BEGIN]\n[/BEGIN]\n";
    }

    public BeginRecord() {
    }

    public BeginRecord(RecordInputStream recordInputStream) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public BeginRecord clone() {
        return new BeginRecord();
    }
}
