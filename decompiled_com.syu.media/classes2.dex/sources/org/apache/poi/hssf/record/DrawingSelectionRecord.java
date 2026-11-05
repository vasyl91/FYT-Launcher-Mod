package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DrawingSelectionRecord extends StandardRecord implements Cloneable {
    public static final short sid = 237;
    private int _cpsp;
    private int _dgslk;
    private OfficeArtRecordHeader _header;
    private int[] _shapeIds;
    private int _spidFocus;

    @Override // org.apache.poi.hssf.record.Record
    public DrawingSelectionRecord clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private static final class OfficeArtRecordHeader {
        public static final int ENCODED_SIZE = 8;
        private final int _length;
        private final int _type;
        private final int _verAndInstance;

        public OfficeArtRecordHeader(LittleEndianInput littleEndianInput) {
            this._verAndInstance = littleEndianInput.readUShort();
            this._type = littleEndianInput.readUShort();
            this._length = littleEndianInput.readInt();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._verAndInstance);
            littleEndianOutput.writeShort(this._type);
            littleEndianOutput.writeInt(this._length);
        }

        public String debugFormatAsString() {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append("ver+inst=").append(HexDump.shortToHex(this._verAndInstance));
            stringBuffer.append(" type=").append(HexDump.shortToHex(this._type));
            stringBuffer.append(" len=").append(HexDump.intToHex(this._length));
            return stringBuffer.toString();
        }
    }

    public DrawingSelectionRecord(RecordInputStream recordInputStream) {
        this._header = new OfficeArtRecordHeader(recordInputStream);
        this._cpsp = recordInputStream.readInt();
        this._dgslk = recordInputStream.readInt();
        this._spidFocus = recordInputStream.readInt();
        int iAvailable = recordInputStream.available() / 4;
        int[] iArr = new int[iAvailable];
        for (int i = 0; i < iAvailable; i++) {
            iArr[i] = recordInputStream.readInt();
        }
        this._shapeIds = iArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._shapeIds.length * 4) + 20;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this._header.serialize(littleEndianOutput);
        littleEndianOutput.writeInt(this._cpsp);
        littleEndianOutput.writeInt(this._dgslk);
        littleEndianOutput.writeInt(this._spidFocus);
        int i = 0;
        while (true) {
            int[] iArr = this._shapeIds;
            if (i >= iArr.length) {
                return;
            }
            littleEndianOutput.writeInt(iArr[i]);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[MSODRAWINGSELECTION]\n    .rh       =(");
        stringBuffer.append(this._header.debugFormatAsString()).append(")\n    .cpsp     =");
        stringBuffer.append(HexDump.intToHex(this._cpsp)).append("\n    .dgslk    =");
        stringBuffer.append(HexDump.intToHex(this._dgslk)).append("\n    .spidFocus=");
        stringBuffer.append(HexDump.intToHex(this._spidFocus)).append("\n    .shapeIds =(");
        for (int i = 0; i < this._shapeIds.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(HexDump.intToHex(this._shapeIds[i]));
        }
        stringBuffer.append(")\n[/MSODRAWINGSELECTION]\n");
        return stringBuffer.toString();
    }
}
