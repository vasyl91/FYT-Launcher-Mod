package org.apache.poi.hssf.record;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HorizontalPageBreakRecord extends PageBreakRecord implements Cloneable {
    public static final short sid = 27;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 27;
    }

    public HorizontalPageBreakRecord() {
    }

    public HorizontalPageBreakRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public PageBreakRecord clone() {
        HorizontalPageBreakRecord horizontalPageBreakRecord = new HorizontalPageBreakRecord();
        Iterator<PageBreakRecord.Break> breaksIterator = getBreaksIterator();
        while (breaksIterator.hasNext()) {
            PageBreakRecord.Break next = breaksIterator.next();
            horizontalPageBreakRecord.addBreak(next.main, next.subFrom, next.subTo);
        }
        return horizontalPageBreakRecord;
    }
}
