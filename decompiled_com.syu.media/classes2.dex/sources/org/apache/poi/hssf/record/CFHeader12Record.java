package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.record.common.FutureRecord;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CFHeader12Record extends CFHeaderBase implements FutureRecord, Cloneable {
    public static final short sid = 2169;
    private FtrHeader futureHeader;

    @Override // org.apache.poi.hssf.record.CFHeaderBase
    protected String getRecordName() {
        return "CFHEADER12";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public CFHeader12Record() {
        createEmpty();
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
    }

    public CFHeader12Record(CellRangeAddress[] cellRangeAddressArr, int i) {
        super(cellRangeAddressArr, i);
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
    }

    public CFHeader12Record(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        read(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return FtrHeader.getDataSize() + super.getDataSize();
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.setAssociatedRange(getEnclosingCellRange());
        this.futureHeader.serialize(littleEndianOutput);
        super.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public short getFutureRecordType() {
        return this.futureHeader.getRecordType();
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public FtrHeader getFutureHeader() {
        return this.futureHeader;
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public CellRangeAddress getAssociatedRange() {
        return this.futureHeader.getAssociatedRange();
    }

    @Override // org.apache.poi.hssf.record.CFHeaderBase, org.apache.poi.hssf.record.Record
    public CFHeader12Record clone() {
        CFHeader12Record cFHeader12Record = new CFHeader12Record();
        cFHeader12Record.futureHeader = (FtrHeader) this.futureHeader.clone();
        super.copyTo(cFHeader12Record);
        return cFHeader12Record;
    }
}
