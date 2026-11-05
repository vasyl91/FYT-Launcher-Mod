package org.apache.poi.hssf.record.cont;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ContinuableRecord extends Record {
    protected abstract void serialize(ContinuableRecordOutput continuableRecordOutput);

    protected ContinuableRecord() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        ContinuableRecordOutput continuableRecordOutputCreateForCountingOnly = ContinuableRecordOutput.createForCountingOnly();
        serialize(continuableRecordOutputCreateForCountingOnly);
        continuableRecordOutputCreateForCountingOnly.terminate();
        return continuableRecordOutputCreateForCountingOnly.getTotalSize();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i, byte[] bArr) {
        ContinuableRecordOutput continuableRecordOutput = new ContinuableRecordOutput(new LittleEndianByteArrayOutputStream(bArr, i), getSid());
        serialize(continuableRecordOutput);
        continuableRecordOutput.terminate();
        return continuableRecordOutput.getTotalSize();
    }
}
