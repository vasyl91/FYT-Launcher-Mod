package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ChartSubstreamRecordAggregate extends RecordAggregate {
    private final BOFRecord _bofRec;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _recs;

    public ChartSubstreamRecordAggregate(RecordStream recordStream) {
        this._bofRec = (BOFRecord) recordStream.getNext();
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextClass() != EOFRecord.class) {
            if (PageSettingsBlock.isComponentRecord(recordStream.peekNextSid())) {
                if (this._psBlock != null) {
                    if (recordStream.peekNextSid() == 2204) {
                        this._psBlock.addLateHeaderFooter((HeaderFooterRecord) recordStream.getNext());
                    } else {
                        throw new IllegalStateException("Found more than one PageSettingsBlock in chart sub-stream, had sid: " + recordStream.peekNextSid());
                    }
                } else {
                    PageSettingsBlock pageSettingsBlock = new PageSettingsBlock(recordStream);
                    this._psBlock = pageSettingsBlock;
                    arrayList.add(pageSettingsBlock);
                }
            } else {
                arrayList.add(recordStream.getNext());
            }
        }
        this._recs = arrayList;
        if (!(recordStream.getNext() instanceof EOFRecord)) {
            throw new IllegalStateException("Bad chart EOF");
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        if (this._recs.isEmpty()) {
            return;
        }
        recordVisitor.visitRecord(this._bofRec);
        for (int i = 0; i < this._recs.size(); i++) {
            RecordBase recordBase = this._recs.get(i);
            if (recordBase instanceof RecordAggregate) {
                ((RecordAggregate) recordBase).visitContainedRecords(recordVisitor);
            } else {
                recordVisitor.visitRecord((Record) recordBase);
            }
        }
        recordVisitor.visitRecord(EOFRecord.instance);
    }
}
