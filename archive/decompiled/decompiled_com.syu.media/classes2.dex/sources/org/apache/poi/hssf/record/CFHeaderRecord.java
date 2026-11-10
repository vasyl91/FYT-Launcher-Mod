package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CFHeaderRecord extends CFHeaderBase implements Cloneable {
    public static final short sid = 432;

    @Override // org.apache.poi.hssf.record.CFHeaderBase
    protected String getRecordName() {
        return "CFHEADER";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public CFHeaderRecord() {
        createEmpty();
    }

    public CFHeaderRecord(CellRangeAddress[] cellRangeAddressArr, int i) {
        super(cellRangeAddressArr, i);
    }

    public CFHeaderRecord(RecordInputStream recordInputStream) {
        read(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.hssf.record.Record
    public CFHeaderRecord clone() {
        CFHeaderRecord cFHeaderRecord = new CFHeaderRecord();
        super.copyTo(cFHeaderRecord);
        return cFHeaderRecord;
    }
}
