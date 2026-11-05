package org.apache.poi.hssf.record;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class VerticalPageBreakRecord extends PageBreakRecord {
    public static final short sid = 26;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 26;
    }

    public VerticalPageBreakRecord() {
    }

    public VerticalPageBreakRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        VerticalPageBreakRecord verticalPageBreakRecord = new VerticalPageBreakRecord();
        Iterator<PageBreakRecord.Break> breaksIterator = getBreaksIterator();
        while (breaksIterator.hasNext()) {
            PageBreakRecord.Break next = breaksIterator.next();
            verticalPageBreakRecord.addBreak(next.main, next.subFrom, next.subTo);
        }
        return verticalPageBreakRecord;
    }
}
