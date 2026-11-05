package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ProtectionRev4Record extends StandardRecord {
    private static final BitField protectedFlag = BitFieldFactory.getInstance(1);
    public static final short sid = 431;
    private int _options;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private ProtectionRev4Record(int i) {
        this._options = i;
    }

    public ProtectionRev4Record(boolean z) {
        this(0);
        setProtect(z);
    }

    public ProtectionRev4Record(RecordInputStream recordInputStream) {
        this(recordInputStream.readUShort());
    }

    public void setProtect(boolean z) {
        this._options = protectedFlag.setBoolean(this._options, z);
    }

    public boolean getProtect() {
        return protectedFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PROT4REV]\n    .options = ");
        stringBuffer.append(HexDump.shortToHex(this._options)).append("\n[/PROT4REV]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
    }
}
