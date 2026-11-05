package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ProtectRecord extends StandardRecord {
    private static final BitField protectFlag = BitFieldFactory.getInstance(1);
    public static final short sid = 18;
    private int _options;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 18;
    }

    private ProtectRecord(int i) {
        this._options = i;
    }

    public ProtectRecord(boolean z) {
        this(0);
        setProtect(z);
    }

    public ProtectRecord(RecordInputStream recordInputStream) {
        this(recordInputStream.readShort());
    }

    public void setProtect(boolean z) {
        this._options = protectFlag.setBoolean(this._options, z);
    }

    public boolean getProtect() {
        return protectFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PROTECT]\n    .options = ");
        stringBuffer.append(HexDump.shortToHex(this._options)).append("\n[/PROTECT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new ProtectRecord(this._options);
    }
}
