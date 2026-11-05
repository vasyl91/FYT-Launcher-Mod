package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DimensionsRecord extends StandardRecord implements Cloneable {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) DimensionsRecord.class);
    public static final short sid = 512;
    private int field_1_first_row;
    private int field_2_last_row;
    private short field_3_first_col;
    private short field_4_last_col;
    private short field_5_zero;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 14;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 512;
    }

    public DimensionsRecord() {
    }

    public DimensionsRecord(RecordInputStream recordInputStream) {
        this.field_1_first_row = recordInputStream.readInt();
        this.field_2_last_row = recordInputStream.readInt();
        this.field_3_first_col = recordInputStream.readShort();
        this.field_4_last_col = recordInputStream.readShort();
        this.field_5_zero = recordInputStream.readShort();
        if (recordInputStream.available() == 2) {
            logger.log(3, "DimensionsRecord has extra 2 bytes.");
            recordInputStream.readShort();
        }
    }

    public void setFirstRow(int i) {
        this.field_1_first_row = i;
    }

    public void setLastRow(int i) {
        this.field_2_last_row = i;
    }

    public void setFirstCol(short s) {
        this.field_3_first_col = s;
    }

    public void setLastCol(short s) {
        this.field_4_last_col = s;
    }

    public int getFirstRow() {
        return this.field_1_first_row;
    }

    public int getLastRow() {
        return this.field_2_last_row;
    }

    public short getFirstCol() {
        return this.field_3_first_col;
    }

    public short getLastCol() {
        return this.field_4_last_col;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DIMENSIONS]\n    .firstrow       = ");
        stringBuffer.append(Integer.toHexString(getFirstRow())).append("\n    .lastrow        = ");
        stringBuffer.append(Integer.toHexString(getLastRow())).append("\n    .firstcol       = ");
        stringBuffer.append(Integer.toHexString(getFirstCol())).append("\n    .lastcol        = ");
        stringBuffer.append(Integer.toHexString(getLastCol())).append("\n    .zero           = ");
        stringBuffer.append(Integer.toHexString(this.field_5_zero)).append("\n[/DIMENSIONS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getFirstRow());
        littleEndianOutput.writeInt(getLastRow());
        littleEndianOutput.writeShort(getFirstCol());
        littleEndianOutput.writeShort(getLastCol());
        littleEndianOutput.writeShort(0);
    }

    @Override // org.apache.poi.hssf.record.Record
    public DimensionsRecord clone() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.field_1_first_row = this.field_1_first_row;
        dimensionsRecord.field_2_last_row = this.field_2_last_row;
        dimensionsRecord.field_3_first_col = this.field_3_first_col;
        dimensionsRecord.field_4_last_col = this.field_4_last_col;
        dimensionsRecord.field_5_zero = this.field_5_zero;
        return dimensionsRecord;
    }
}
