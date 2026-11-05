package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LabelSSTRecord extends CellRecord implements Cloneable {
    public static final short sid = 253;
    private int field_4_sst_index;

    @Override // org.apache.poi.hssf.record.CellRecord
    protected String getRecordName() {
        return "LABELSST";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 253;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected int getValueDataSize() {
        return 4;
    }

    public LabelSSTRecord() {
    }

    public LabelSSTRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_4_sst_index = recordInputStream.readInt();
    }

    public void setSSTIndex(int i) {
        this.field_4_sst_index = i;
    }

    public int getSSTIndex() {
        return this.field_4_sst_index;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void appendValueText(StringBuilder sb) {
        sb.append("  .sstIndex = ");
        sb.append(HexDump.shortToHex(getSSTIndex()));
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getSSTIndex());
    }

    @Override // org.apache.poi.hssf.record.Record
    public LabelSSTRecord clone() {
        LabelSSTRecord labelSSTRecord = new LabelSSTRecord();
        copyBaseFields(labelSSTRecord);
        labelSSTRecord.field_4_sst_index = this.field_4_sst_index;
        return labelSSTRecord;
    }
}
