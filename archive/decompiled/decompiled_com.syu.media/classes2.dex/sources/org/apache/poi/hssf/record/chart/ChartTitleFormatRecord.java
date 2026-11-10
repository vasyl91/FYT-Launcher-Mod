package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ChartTitleFormatRecord extends StandardRecord {
    public static final short sid = 4176;
    private CTFormat[] _formats;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private static final class CTFormat {
        public static final int ENCODED_SIZE = 4;
        private int _fontIndex;
        private int _offset;

        public CTFormat(RecordInputStream recordInputStream) {
            this._offset = recordInputStream.readShort();
            this._fontIndex = recordInputStream.readShort();
        }

        public int getOffset() {
            return this._offset;
        }

        public void setOffset(int i) {
            this._offset = i;
        }

        public int getFontIndex() {
            return this._fontIndex;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._offset);
            littleEndianOutput.writeShort(this._fontIndex);
        }
    }

    public ChartTitleFormatRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        this._formats = new CTFormat[uShort];
        for (int i = 0; i < uShort; i++) {
            this._formats[i] = new CTFormat(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._formats.length);
        int i = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i >= cTFormatArr.length) {
                return;
            }
            cTFormatArr[i].serialize(littleEndianOutput);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._formats.length * 4) + 2;
    }

    public int getFormatCount() {
        return this._formats.length;
    }

    public void modifyFormatRun(short s, short s2) {
        int i = 0;
        int offset = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i >= cTFormatArr.length) {
                return;
            }
            CTFormat cTFormat = cTFormatArr[i];
            if (offset != 0) {
                cTFormat.setOffset(cTFormat.getOffset() + offset);
            } else if (s == cTFormat.getOffset()) {
                CTFormat[] cTFormatArr2 = this._formats;
                if (i < cTFormatArr2.length - 1) {
                    offset = s2 - (cTFormatArr2[i + 1].getOffset() - cTFormat.getOffset());
                }
            }
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[CHARTTITLEFORMAT]\n    .format_runs       = ");
        stringBuffer.append(this._formats.length).append("\n");
        int i = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i < cTFormatArr.length) {
                CTFormat cTFormat = cTFormatArr[i];
                stringBuffer.append("       .char_offset= ").append(cTFormat.getOffset());
                stringBuffer.append(",.fontidx= ").append(cTFormat.getFontIndex());
                stringBuffer.append("\n");
                i++;
            } else {
                stringBuffer.append("[/CHARTTITLEFORMAT]\n");
                return stringBuffer.toString();
            }
        }
    }
}
