package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.DVALRecord;
import org.apache.poi.hssf.record.DVRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataValidityTable extends RecordAggregate {
    private final DVALRecord _headerRec;
    private final List<DVRecord> _validationList;

    public DataValidityTable(RecordStream recordStream) {
        this._headerRec = (DVALRecord) recordStream.getNext();
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextClass() == DVRecord.class) {
            arrayList.add((DVRecord) recordStream.getNext());
        }
        this._validationList = arrayList;
    }

    public DataValidityTable() {
        this._headerRec = new DVALRecord();
        this._validationList = new ArrayList();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        if (this._validationList.isEmpty()) {
            return;
        }
        recordVisitor.visitRecord(this._headerRec);
        for (int i = 0; i < this._validationList.size(); i++) {
            recordVisitor.visitRecord(this._validationList.get(i));
        }
    }

    public void addDataValidation(DVRecord dVRecord) {
        this._validationList.add(dVRecord);
        this._headerRec.setDVRecNo(this._validationList.size());
    }
}
