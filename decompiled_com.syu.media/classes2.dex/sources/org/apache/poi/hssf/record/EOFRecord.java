package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EOFRecord extends StandardRecord implements Cloneable {
    public static final int ENCODED_SIZE = 4;
    public static final EOFRecord instance = new EOFRecord();
    public static final short sid = 10;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 10;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[EOF]\n[/EOF]\n";
    }

    private EOFRecord() {
    }

    public EOFRecord(RecordInputStream recordInputStream) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public EOFRecord clone() {
        return instance;
    }
}
