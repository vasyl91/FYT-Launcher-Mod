package org.apache.poi.hssf.record.aggregates;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class RecordAggregate extends RecordBase {

    public interface RecordVisitor {
        void visitRecord(Record record);
    }

    public abstract void visitContainedRecords(RecordVisitor recordVisitor);

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i, byte[] bArr) {
        SerializingRecordVisitor serializingRecordVisitor = new SerializingRecordVisitor(bArr, i);
        visitContainedRecords(serializingRecordVisitor);
        return serializingRecordVisitor.countBytesWritten();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        RecordSizingVisitor recordSizingVisitor = new RecordSizingVisitor();
        visitContainedRecords(recordSizingVisitor);
        return recordSizingVisitor.getTotalSize();
    }

    private static final class SerializingRecordVisitor implements RecordVisitor {
        private int _countBytesWritten = 0;
        private final byte[] _data;
        private final int _startOffset;

        public SerializingRecordVisitor(byte[] bArr, int i) {
            this._data = bArr;
            this._startOffset = i;
        }

        public int countBytesWritten() {
            return this._countBytesWritten;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            int i = this._startOffset;
            int i2 = this._countBytesWritten;
            this._countBytesWritten = i2 + record.serialize(i + i2, this._data);
        }
    }

    private static final class RecordSizingVisitor implements RecordVisitor {
        private int _totalSize = 0;

        public int getTotalSize() {
            return this._totalSize;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._totalSize += record.getRecordSize();
        }
    }

    public static final class PositionTrackingVisitor implements RecordVisitor {
        private int _position;
        private final RecordVisitor _rv;

        public PositionTrackingVisitor(RecordVisitor recordVisitor, int i) {
            this._rv = recordVisitor;
            this._position = i;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._position += record.getRecordSize();
            this._rv.visitRecord(record);
        }

        public void setPosition(int i) {
            this._position = i;
        }

        public int getPosition() {
            return this._position;
        }
    }
}
