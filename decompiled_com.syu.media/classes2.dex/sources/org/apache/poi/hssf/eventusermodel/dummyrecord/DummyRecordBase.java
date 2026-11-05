package org.apache.poi.hssf.eventusermodel.dummyrecord;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class DummyRecordBase extends Record {
    @Override // org.apache.poi.hssf.record.Record
    public final short getSid() {
        return (short) -1;
    }

    protected DummyRecordBase() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        throw new RecordFormatException("Cannot serialize a dummy record");
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        throw new RecordFormatException("Cannot serialize a dummy record");
    }
}
