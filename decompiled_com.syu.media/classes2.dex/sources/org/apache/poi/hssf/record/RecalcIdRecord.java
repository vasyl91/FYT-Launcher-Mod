package org.apache.poi.hssf.record;

import module.canbus.FinalCanbus;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RecalcIdRecord extends StandardRecord {
    public static final short sid = 449;
    private int _engineId;
    private final int _reserved0;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 449;
    }

    public boolean isNeeded() {
        return true;
    }

    public RecalcIdRecord() {
        this._reserved0 = 0;
        this._engineId = 0;
    }

    public RecalcIdRecord(RecordInputStream recordInputStream) {
        recordInputStream.readUShort();
        this._reserved0 = recordInputStream.readUShort();
        this._engineId = recordInputStream.readInt();
    }

    public void setEngineId(int i) {
        this._engineId = i;
    }

    public int getEngineId() {
        return this._engineId;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[RECALCID]\n    .reserved = ");
        stringBuffer.append(HexDump.shortToHex(this._reserved0)).append("\n    .engineId = ");
        stringBuffer.append(HexDump.intToHex(this._engineId)).append("\n[/RECALCID]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(FinalCanbus.CAR_449_Kequan_Toyota_AVM);
        littleEndianOutput.writeShort(this._reserved0);
        littleEndianOutput.writeInt(this._engineId);
    }
}
