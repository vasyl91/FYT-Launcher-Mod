package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class StringRecord extends ContinuableRecord {
    public static final short sid = 519;
    private boolean _is16bitUnicode;
    private String _text;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 519;
    }

    public StringRecord() {
    }

    public StringRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        boolean z = recordInputStream.readByte() != 0;
        this._is16bitUnicode = z;
        if (z) {
            this._text = recordInputStream.readUnicodeLEString(uShort);
        } else {
            this._text = recordInputStream.readCompressedUnicode(uShort);
        }
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    protected void serialize(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeShort(this._text.length());
        continuableRecordOutput.writeStringData(this._text);
    }

    public String getString() {
        return this._text;
    }

    public void setString(String str) {
        this._text = str;
        this._is16bitUnicode = StringUtil.hasMultibyte(str);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[STRING]\n    .string            = ");
        stringBuffer.append(this._text).append("\n[/STRING]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        StringRecord stringRecord = new StringRecord();
        stringRecord._is16bitUnicode = this._is16bitUnicode;
        stringRecord._text = this._text;
        return stringRecord;
    }
}
