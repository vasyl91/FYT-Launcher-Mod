package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class InterfaceEndRecord extends StandardRecord {
    public static final InterfaceEndRecord instance = new InterfaceEndRecord();
    public static final short sid = 226;

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
        return "[INTERFACEEND/]\n";
    }

    private InterfaceEndRecord() {
    }

    public static Record create(RecordInputStream recordInputStream) {
        int iRemaining = recordInputStream.remaining();
        if (iRemaining == 0) {
            return instance;
        }
        if (iRemaining == 2) {
            return new InterfaceHdrRecord(recordInputStream);
        }
        throw new RecordFormatException("Invalid record data size: " + recordInputStream.remaining());
    }
}
