package org.apache.poi.hssf.eventusermodel.dummyrecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MissingCellDummyRecord extends DummyRecordBase {
    private int column;
    private int row;

    @Override // org.apache.poi.hssf.eventusermodel.dummyrecord.DummyRecordBase, org.apache.poi.hssf.record.RecordBase
    public /* bridge */ /* synthetic */ int serialize(int i, byte[] bArr) {
        return super.serialize(i, bArr);
    }

    public MissingCellDummyRecord(int i, int i2) {
        this.row = i;
        this.column = i2;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
