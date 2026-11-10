package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class GroupMarkerSubRecord extends SubRecord implements Cloneable {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final short sid = 6;
    private byte[] reserved;

    public short getSid() {
        return (short) 6;
    }

    public GroupMarkerSubRecord() {
        this.reserved = EMPTY_BYTE_ARRAY;
    }

    public GroupMarkerSubRecord(LittleEndianInput littleEndianInput, int i) {
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        this.reserved = bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("[ftGmo]" + property);
        stringBuffer.append("  reserved = ").append(HexDump.toHex(this.reserved)).append(property);
        stringBuffer.append("[/ftGmo]" + property);
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(6);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return this.reserved.length;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    /* JADX INFO: renamed from: clone */
    public GroupMarkerSubRecord mo1560clone() {
        GroupMarkerSubRecord groupMarkerSubRecord = new GroupMarkerSubRecord();
        groupMarkerSubRecord.reserved = new byte[this.reserved.length];
        int i = 0;
        while (true) {
            byte[] bArr = this.reserved;
            if (i >= bArr.length) {
                return groupMarkerSubRecord;
            }
            groupMarkerSubRecord.reserved[i] = bArr[i];
            i++;
        }
    }
}
