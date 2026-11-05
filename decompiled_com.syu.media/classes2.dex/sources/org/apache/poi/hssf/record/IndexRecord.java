package org.apache.poi.hssf.record;

import org.apache.poi.util.IntList;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IndexRecord extends StandardRecord implements Cloneable {
    public static final short sid = 523;
    private int field_2_first_row;
    private int field_3_last_row_add1;
    private int field_4_zero;
    private IntList field_5_dbcells;

    public static int getRecordSizeForBlockCount(int i) {
        return (i * 4) + 20;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 523;
    }

    public IndexRecord() {
    }

    public IndexRecord(RecordInputStream recordInputStream) {
        int i = recordInputStream.readInt();
        if (i != 0) {
            throw new RecordFormatException("Expected zero for field 1 but got " + i);
        }
        this.field_2_first_row = recordInputStream.readInt();
        this.field_3_last_row_add1 = recordInputStream.readInt();
        this.field_4_zero = recordInputStream.readInt();
        int iRemaining = recordInputStream.remaining() / 4;
        this.field_5_dbcells = new IntList(iRemaining);
        for (int i2 = 0; i2 < iRemaining; i2++) {
            this.field_5_dbcells.add(recordInputStream.readInt());
        }
    }

    public void setFirstRow(int i) {
        this.field_2_first_row = i;
    }

    public void setLastRowAdd1(int i) {
        this.field_3_last_row_add1 = i;
    }

    public void addDbcell(int i) {
        if (this.field_5_dbcells == null) {
            this.field_5_dbcells = new IntList();
        }
        this.field_5_dbcells.add(i);
    }

    public void setDbcell(int i, int i2) {
        this.field_5_dbcells.set(i, i2);
    }

    public int getFirstRow() {
        return this.field_2_first_row;
    }

    public int getLastRowAdd1() {
        return this.field_3_last_row_add1;
    }

    public int getNumDbcells() {
        IntList intList = this.field_5_dbcells;
        if (intList == null) {
            return 0;
        }
        return intList.size();
    }

    public int getDbcellAt(int i) {
        return this.field_5_dbcells.get(i);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[INDEX]\n    .firstrow       = ");
        stringBuffer.append(Integer.toHexString(getFirstRow())).append("\n    .lastrowadd1    = ");
        stringBuffer.append(Integer.toHexString(getLastRowAdd1())).append("\n");
        for (int i = 0; i < getNumDbcells(); i++) {
            stringBuffer.append("    .dbcell_").append(i).append(" = ").append(Integer.toHexString(getDbcellAt(i))).append("\n");
        }
        stringBuffer.append("[/INDEX]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(0);
        littleEndianOutput.writeInt(getFirstRow());
        littleEndianOutput.writeInt(getLastRowAdd1());
        littleEndianOutput.writeInt(this.field_4_zero);
        for (int i = 0; i < getNumDbcells(); i++) {
            littleEndianOutput.writeInt(getDbcellAt(i));
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (getNumDbcells() * 4) + 16;
    }

    @Override // org.apache.poi.hssf.record.Record
    public IndexRecord clone() {
        IndexRecord indexRecord = new IndexRecord();
        indexRecord.field_2_first_row = this.field_2_first_row;
        indexRecord.field_3_last_row_add1 = this.field_3_last_row_add1;
        indexRecord.field_4_zero = this.field_4_zero;
        IntList intList = new IntList();
        indexRecord.field_5_dbcells = intList;
        intList.addAll(this.field_5_dbcells);
        return indexRecord;
    }
}
