package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class InterfaceHdrRecord extends StandardRecord {
    public static final int CODEPAGE = 1200;
    public static final short sid = 225;
    private final int _codepage;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public InterfaceHdrRecord(int i) {
        this._codepage = i;
    }

    public InterfaceHdrRecord(RecordInputStream recordInputStream) {
        this._codepage = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[INTERFACEHDR]\n    .codepage = ");
        stringBuffer.append(HexDump.shortToHex(this._codepage)).append("\n[/INTERFACEHDR]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._codepage);
    }
}
