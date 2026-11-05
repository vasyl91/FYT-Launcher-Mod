package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ContinueRecord extends StandardRecord implements Cloneable {
    public static final short sid = 60;
    private byte[] _data;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 60;
    }

    public ContinueRecord(byte[] bArr) {
        this._data = bArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this._data.length;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this._data);
    }

    public byte[] getData() {
        return this._data;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CONTINUE RECORD]\n    .data = ");
        stringBuffer.append(HexDump.toHex(this._data)).append("\n[/CONTINUE RECORD]\n");
        return stringBuffer.toString();
    }

    public ContinueRecord(RecordInputStream recordInputStream) {
        this._data = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.Record
    public ContinueRecord clone() {
        return new ContinueRecord(this._data);
    }
}
