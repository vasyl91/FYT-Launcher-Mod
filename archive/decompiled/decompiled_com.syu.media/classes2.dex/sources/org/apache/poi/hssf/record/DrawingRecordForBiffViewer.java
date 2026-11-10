package org.apache.poi.hssf.record;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DrawingRecordForBiffViewer extends AbstractEscherHolderRecord {
    public static final short sid = 236;

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord
    protected String getRecordName() {
        return "MSODRAWING";
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 236;
    }

    public DrawingRecordForBiffViewer() {
    }

    public DrawingRecordForBiffViewer(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    public DrawingRecordForBiffViewer(DrawingRecord drawingRecord) {
        super(convertToInputStream(drawingRecord));
        convertRawBytesToEscherRecords();
    }

    private static RecordInputStream convertToInputStream(DrawingRecord drawingRecord) {
        RecordInputStream recordInputStream = new RecordInputStream(new ByteArrayInputStream(drawingRecord.serialize()));
        recordInputStream.nextRecord();
        return recordInputStream;
    }
}
