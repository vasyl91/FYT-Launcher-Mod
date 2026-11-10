package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CustomViewSettingsRecordAggregate extends RecordAggregate {
    private final Record _begin;
    private final Record _end;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _recs;

    public static boolean isBeginRecord(int i) {
        return i == 426;
    }

    public CustomViewSettingsRecordAggregate(RecordStream recordStream) {
        Record next = recordStream.getNext();
        this._begin = next;
        if (next.getSid() != 426) {
            throw new IllegalStateException("Bad begin record");
        }
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextSid() != 427) {
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
        Record next2 = recordStream.getNext();
        this._end = next2;
        if (next2.getSid() != 427) {
            throw new IllegalStateException("Bad custom view settings end record");
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        if (this._recs.isEmpty()) {
            return;
        }
        recordVisitor.visitRecord(this._begin);
        for (int i = 0; i < this._recs.size(); i++) {
            RecordBase recordBase = this._recs.get(i);
            if (recordBase instanceof RecordAggregate) {
                ((RecordAggregate) recordBase).visitContainedRecords(recordVisitor);
            } else {
                recordVisitor.visitRecord((Record) recordBase);
            }
        }
        recordVisitor.visitRecord(this._end);
    }

    public void append(RecordBase recordBase) {
        this._recs.add(recordBase);
    }
}
