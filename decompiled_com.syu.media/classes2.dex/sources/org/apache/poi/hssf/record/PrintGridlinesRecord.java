package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PrintGridlinesRecord extends StandardRecord {
    public static final short sid = 43;
    private short field_1_print_gridlines;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 43;
    }

    public PrintGridlinesRecord() {
    }

    public PrintGridlinesRecord(RecordInputStream recordInputStream) {
        this.field_1_print_gridlines = recordInputStream.readShort();
    }

    public void setPrintGridlines(boolean z) {
        if (z) {
            this.field_1_print_gridlines = (short) 1;
        } else {
            this.field_1_print_gridlines = (short) 0;
        }
    }

    public boolean getPrintGridlines() {
        return this.field_1_print_gridlines == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PRINTGRIDLINES]\n    .printgridlines = ");
        stringBuffer.append(getPrintGridlines()).append("\n[/PRINTGRIDLINES]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_print_gridlines);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        PrintGridlinesRecord printGridlinesRecord = new PrintGridlinesRecord();
        printGridlinesRecord.field_1_print_gridlines = this.field_1_print_gridlines;
        return printGridlinesRecord;
    }
}
