package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AutoFilterInfoRecord extends StandardRecord implements Cloneable {
    public static final short sid = 157;
    private short _cEntries;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 157;
    }

    public AutoFilterInfoRecord() {
    }

    public AutoFilterInfoRecord(RecordInputStream recordInputStream) {
        this._cEntries = recordInputStream.readShort();
    }

    public void setNumEntries(short s) {
        this._cEntries = s;
    }

    public short getNumEntries() {
        return this._cEntries;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[AUTOFILTERINFO]\n    .numEntries          = ");
        stringBuffer.append((int) this._cEntries).append("\n[/AUTOFILTERINFO]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._cEntries);
    }

    @Override // org.apache.poi.hssf.record.Record
    public AutoFilterInfoRecord clone() {
        return (AutoFilterInfoRecord) cloneViaReserialise();
    }
}
