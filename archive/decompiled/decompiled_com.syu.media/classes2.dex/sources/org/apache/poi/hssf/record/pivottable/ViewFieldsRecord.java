package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ViewFieldsRecord extends StandardRecord {
    private static final int BASE_SIZE = 10;
    private static final int STRING_NOT_PRESENT_LEN = 65535;
    public static final short sid = 177;
    private int _cItm;
    private int _cSub;
    private int _grbitSub;
    private String _name;
    private int _sxaxis;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 177;
    }

    private static final class Axis {
        public static final int COLUMN = 2;
        public static final int DATA = 8;
        public static final int NO_AXIS = 0;
        public static final int PAGE = 4;
        public static final int ROW = 1;

        private Axis() {
        }
    }

    public ViewFieldsRecord(RecordInputStream recordInputStream) {
        this._sxaxis = recordInputStream.readShort();
        this._cSub = recordInputStream.readShort();
        this._grbitSub = recordInputStream.readShort();
        this._cItm = recordInputStream.readShort();
        int uShort = recordInputStream.readUShort();
        if (uShort != 65535) {
            if ((recordInputStream.readByte() & 1) != 0) {
                this._name = recordInputStream.readUnicodeLEString(uShort);
            } else {
                this._name = recordInputStream.readCompressedUnicode(uShort);
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._sxaxis);
        littleEndianOutput.writeShort(this._cSub);
        littleEndianOutput.writeShort(this._grbitSub);
        littleEndianOutput.writeShort(this._cItm);
        String str = this._name;
        if (str != null) {
            StringUtil.writeUnicodeString(littleEndianOutput, str);
        } else {
            littleEndianOutput.writeShort(65535);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        String str = this._name;
        if (str == null) {
            return 10;
        }
        return (str.length() * (StringUtil.hasMultibyte(this._name) ? 2 : 1)) + 11;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SXVD]\n    .sxaxis    = ");
        stringBuffer.append(HexDump.shortToHex(this._sxaxis)).append("\n    .cSub      = ");
        stringBuffer.append(HexDump.shortToHex(this._cSub)).append("\n    .grbitSub  = ");
        stringBuffer.append(HexDump.shortToHex(this._grbitSub)).append("\n    .cItm      = ");
        stringBuffer.append(HexDump.shortToHex(this._cItm)).append("\n    .name      = ");
        stringBuffer.append(this._name).append("\n[/SXVD]\n");
        return stringBuffer.toString();
    }
}
