package org.apache.poi.hssf.eventusermodel.dummyrecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MissingRowDummyRecord extends DummyRecordBase {
    private int rowNumber;

    @Override // org.apache.poi.hssf.eventusermodel.dummyrecord.DummyRecordBase, org.apache.poi.hssf.record.RecordBase
    public /* bridge */ /* synthetic */ int serialize(int i, byte[] bArr) {
        return super.serialize(i, bArr);
    }

    public MissingRowDummyRecord(int i) {
        this.rowNumber = i;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }
}
