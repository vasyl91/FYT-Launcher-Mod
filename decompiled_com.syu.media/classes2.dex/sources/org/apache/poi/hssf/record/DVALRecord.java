package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DVALRecord extends StandardRecord implements Cloneable {
    public static final short sid = 434;
    private short field_1_options;
    private int field_2_horiz_pos;
    private int field_3_vert_pos;
    private int field_5_dv_no;
    private int field_cbo_id;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DVALRecord() {
        this.field_cbo_id = -1;
        this.field_5_dv_no = 0;
    }

    public DVALRecord(RecordInputStream recordInputStream) {
        this.field_1_options = recordInputStream.readShort();
        this.field_2_horiz_pos = recordInputStream.readInt();
        this.field_3_vert_pos = recordInputStream.readInt();
        this.field_cbo_id = recordInputStream.readInt();
        this.field_5_dv_no = recordInputStream.readInt();
    }

    public void setOptions(short s) {
        this.field_1_options = s;
    }

    public void setHorizontalPos(int i) {
        this.field_2_horiz_pos = i;
    }

    public void setVerticalPos(int i) {
        this.field_3_vert_pos = i;
    }

    public void setObjectID(int i) {
        this.field_cbo_id = i;
    }

    public void setDVRecNo(int i) {
        this.field_5_dv_no = i;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    public int getHorizontalPos() {
        return this.field_2_horiz_pos;
    }

    public int getVerticalPos() {
        return this.field_3_vert_pos;
    }

    public int getObjectID() {
        return this.field_cbo_id;
    }

    public int getDVRecNo() {
        return this.field_5_dv_no;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DVAL]\n    .options      = ");
        stringBuffer.append((int) getOptions()).append("\n    .horizPos     = ");
        stringBuffer.append(getHorizontalPos()).append("\n    .vertPos      = ");
        stringBuffer.append(getVerticalPos()).append("\n    .comboObjectID   = ");
        stringBuffer.append(Integer.toHexString(getObjectID())).append("\n    .DVRecordsNumber = ");
        stringBuffer.append(Integer.toHexString(getDVRecNo())).append("\n[/DVAL]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeInt(getHorizontalPos());
        littleEndianOutput.writeInt(getVerticalPos());
        littleEndianOutput.writeInt(getObjectID());
        littleEndianOutput.writeInt(getDVRecNo());
    }

    @Override // org.apache.poi.hssf.record.Record
    public DVALRecord clone() {
        DVALRecord dVALRecord = new DVALRecord();
        dVALRecord.field_1_options = this.field_1_options;
        dVALRecord.field_2_horiz_pos = this.field_2_horiz_pos;
        dVALRecord.field_3_vert_pos = this.field_3_vert_pos;
        dVALRecord.field_cbo_id = this.field_cbo_id;
        dVALRecord.field_5_dv_no = this.field_5_dv_no;
        return dVALRecord;
    }
}
