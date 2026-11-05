package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class StandardRecord extends Record {
    protected abstract int getDataSize();

    protected abstract void serialize(LittleEndianOutput littleEndianOutput);

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        return getDataSize() + 4;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i, byte[] bArr) {
        int dataSize = getDataSize();
        int i2 = dataSize + 4;
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i, i2);
        littleEndianByteArrayOutputStream.writeShort(getSid());
        littleEndianByteArrayOutputStream.writeShort(dataSize);
        serialize(littleEndianByteArrayOutputStream);
        if (littleEndianByteArrayOutputStream.getWriteIndex() - i == i2) {
            return i2;
        }
        throw new IllegalStateException("Error in serialization of (" + getClass().getName() + "): Incorrect number of bytes written - expected " + i2 + " but got " + (littleEndianByteArrayOutputStream.getWriteIndex() - i));
    }
}
