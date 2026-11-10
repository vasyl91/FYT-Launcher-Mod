package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PageItemRecord extends StandardRecord {
    public static final short sid = 182;
    private final FieldInfo[] _fieldInfos;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 182;
    }

    private static final class FieldInfo {
        public static final int ENCODED_SIZE = 6;
        private int _idObj;
        private int _isxvd;
        private int _isxvi;

        public FieldInfo(RecordInputStream recordInputStream) {
            this._isxvi = recordInputStream.readShort();
            this._isxvd = recordInputStream.readShort();
            this._idObj = recordInputStream.readShort();
        }

        protected void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._isxvi);
            littleEndianOutput.writeShort(this._isxvd);
            littleEndianOutput.writeShort(this._idObj);
        }

        public void appendDebugInfo(StringBuffer stringBuffer) {
            stringBuffer.append('(');
            stringBuffer.append("isxvi=").append(HexDump.shortToHex(this._isxvi));
            stringBuffer.append(" isxvd=").append(HexDump.shortToHex(this._isxvd));
            stringBuffer.append(" idObj=").append(HexDump.shortToHex(this._idObj));
            stringBuffer.append(')');
        }
    }

    public PageItemRecord(RecordInputStream recordInputStream) {
        int iRemaining = recordInputStream.remaining();
        if (iRemaining % 6 != 0) {
            throw new RecordFormatException("Bad data size " + iRemaining);
        }
        int i = iRemaining / 6;
        FieldInfo[] fieldInfoArr = new FieldInfo[i];
        for (int i2 = 0; i2 < i; i2++) {
            fieldInfoArr[i2] = new FieldInfo(recordInputStream);
        }
        this._fieldInfos = fieldInfoArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        int i = 0;
        while (true) {
            FieldInfo[] fieldInfoArr = this._fieldInfos;
            if (i >= fieldInfoArr.length) {
                return;
            }
            fieldInfoArr[i].serialize(littleEndianOutput);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this._fieldInfos.length * 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SXPI]\n");
        for (int i = 0; i < this._fieldInfos.length; i++) {
            stringBuffer.append("    item[").append(i).append("]=");
            this._fieldInfos[i].appendDebugInfo(stringBuffer);
            stringBuffer.append('\n');
        }
        stringBuffer.append("[/SXPI]\n");
        return stringBuffer.toString();
    }
}
