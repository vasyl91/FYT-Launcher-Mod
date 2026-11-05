package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.HexRead;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HyperlinkRecord extends StandardRecord implements Cloneable {
    private static final byte[] FILE_TAIL;
    static final int HLINK_ABS = 2;
    static final int HLINK_LABEL = 20;
    static final int HLINK_PLACE = 8;
    private static final int HLINK_TARGET_FRAME = 128;
    private static final int HLINK_UNC_PATH = 256;
    static final int HLINK_URL = 1;
    private static final int TAIL_SIZE;
    public static final short sid = 440;
    private String _address;
    private int _fileOpts;
    private GUID _guid;
    private String _label;
    private int _linkOpts;
    private GUID _moniker;
    private CellRangeAddress _range;
    private String _shortFilename;
    private String _targetFrame;
    private String _textMark;
    private byte[] _uninterpretedTail;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) HyperlinkRecord.class);
    static final GUID STD_MONIKER = GUID.parse("79EAC9D0-BAF9-11CE-8C82-00AA004BA90B");
    static final GUID URL_MONIKER = GUID.parse("79EAC9E0-BAF9-11CE-8C82-00AA004BA90B");
    static final GUID FILE_MONIKER = GUID.parse("00000303-0000-0000-C000-000000000046");
    private static final byte[] URL_TAIL = HexRead.readFromString("79 58 81 F4  3B 1D 7F 48   AF 2C 82 5D  C4 85 27 63   00 00 00 00  A5 AB 00 00");

    public int getLabelOptions() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    static {
        byte[] fromString = HexRead.readFromString("FF FF AD DE  00 00 00 00   00 00 00 00  00 00 00 00   00 00 00 00  00 00 00 00");
        FILE_TAIL = fromString;
        TAIL_SIZE = fromString.length;
    }

    static final class GUID {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int ENCODED_SIZE = 16;
        private static final int TEXT_FORMAT_LENGTH = 36;
        private final int _d1;
        private final int _d2;
        private final int _d3;
        private final long _d4;

        public int hashCode() {
            return 42;
        }

        public GUID(LittleEndianInput littleEndianInput) {
            this(littleEndianInput.readInt(), littleEndianInput.readUShort(), littleEndianInput.readUShort(), littleEndianInput.readLong());
        }

        public GUID(int i, int i2, int i3, long j) {
            this._d1 = i;
            this._d2 = i2;
            this._d3 = i3;
            this._d4 = j;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeInt(this._d1);
            littleEndianOutput.writeShort(this._d2);
            littleEndianOutput.writeShort(this._d3);
            littleEndianOutput.writeLong(this._d4);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GUID)) {
                return false;
            }
            GUID guid = (GUID) obj;
            return this._d1 == guid._d1 && this._d2 == guid._d2 && this._d3 == guid._d3 && this._d4 == guid._d4;
        }

        public int getD1() {
            return this._d1;
        }

        public int getD2() {
            return this._d2;
        }

        public int getD3() {
            return this._d3;
        }

        public long getD4() {
            byte[] bArr = new byte[8];
            long j = this._d4;
            for (int i = 7; i >= 0; i--) {
                bArr[i] = (byte) (255 & j);
                j >>= 8;
            }
            return LittleEndian.getLong(bArr, 0);
        }

        public String formatAsString() {
            StringBuilder sb = new StringBuilder(36);
            sb.append(HexDump.intToHex(this._d1).substring(2));
            sb.append("-");
            sb.append(HexDump.shortToHex(this._d2).substring(2));
            sb.append("-");
            sb.append(HexDump.shortToHex(this._d3).substring(2));
            sb.append("-");
            String strLongToHex = HexDump.longToHex(getD4());
            sb.append(strLongToHex.substring(2, 6));
            sb.append("-");
            sb.append(strLongToHex.substring(6));
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append(getClass().getName()).append(" [");
            sb.append(formatAsString());
            sb.append("]");
            return sb.toString();
        }

        public static GUID parse(String str) {
            char[] charArray = str.toCharArray();
            if (charArray.length != 36) {
                throw new RecordFormatException("supplied text is the wrong length for a GUID");
            }
            int i = (parseShort(charArray, 0) << 16) + (parseShort(charArray, 4) << 0);
            int i2 = parseShort(charArray, 9);
            int i3 = parseShort(charArray, 14);
            for (int i4 = 23; i4 > 19; i4--) {
                charArray[i4] = charArray[i4 - 1];
            }
            return new GUID(i, i2, i3, parseLELong(charArray, 20));
        }

        private static long parseLELong(char[] cArr, int i) {
            long hexChar = 0;
            for (int i2 = i + 14; i2 >= i; i2 -= 2) {
                hexChar = (((hexChar << 4) + ((long) parseHexChar(cArr[i2 + 0]))) << 4) + ((long) parseHexChar(cArr[i2 + 1]));
            }
            return hexChar;
        }

        private static int parseShort(char[] cArr, int i) {
            int hexChar = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                hexChar = (hexChar << 4) + parseHexChar(cArr[i + i2]);
            }
            return hexChar;
        }

        private static int parseHexChar(char c) {
            if (c >= '0' && c <= '9') {
                return c - '0';
            }
            char c2 = 'A';
            if (c < 'A' || c > 'F') {
                c2 = 'a';
                if (c < 'a' || c > 'f') {
                    throw new RecordFormatException("Bad hex char '" + c + "'");
                }
            }
            return (c - c2) + 10;
        }
    }

    public HyperlinkRecord() {
    }

    public int getFirstColumn() {
        return this._range.getFirstColumn();
    }

    public void setFirstColumn(int i) {
        this._range.setFirstColumn(i);
    }

    public int getLastColumn() {
        return this._range.getLastColumn();
    }

    public void setLastColumn(int i) {
        this._range.setLastColumn(i);
    }

    public int getFirstRow() {
        return this._range.getFirstRow();
    }

    public void setFirstRow(int i) {
        this._range.setFirstRow(i);
    }

    public int getLastRow() {
        return this._range.getLastRow();
    }

    public void setLastRow(int i) {
        this._range.setLastRow(i);
    }

    GUID getGuid() {
        return this._guid;
    }

    GUID getMoniker() {
        return this._moniker;
    }

    private static String cleanString(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(0);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    private static String appendNullTerm(String str) {
        if (str == null) {
            return null;
        }
        return str + (char) 0;
    }

    public String getLabel() {
        return cleanString(this._label);
    }

    public void setLabel(String str) {
        this._label = appendNullTerm(str);
    }

    public String getTargetFrame() {
        return cleanString(this._targetFrame);
    }

    public String getAddress() {
        if ((this._linkOpts & 1) != 0 && FILE_MONIKER.equals(this._moniker)) {
            String str = this._address;
            if (str == null) {
                str = this._shortFilename;
            }
            return cleanString(str);
        }
        if ((this._linkOpts & 8) != 0) {
            return cleanString(this._textMark);
        }
        return cleanString(this._address);
    }

    public void setAddress(String str) {
        if ((this._linkOpts & 1) != 0 && FILE_MONIKER.equals(this._moniker)) {
            this._shortFilename = appendNullTerm(str);
        } else if ((this._linkOpts & 8) != 0) {
            this._textMark = appendNullTerm(str);
        } else {
            this._address = appendNullTerm(str);
        }
    }

    public String getShortFilename() {
        return cleanString(this._shortFilename);
    }

    public void setShortFilename(String str) {
        this._shortFilename = appendNullTerm(str);
    }

    public String getTextMark() {
        return cleanString(this._textMark);
    }

    public void setTextMark(String str) {
        this._textMark = appendNullTerm(str);
    }

    int getLinkOptions() {
        return this._linkOpts;
    }

    public int getFileOptions() {
        return this._fileOpts;
    }

    public HyperlinkRecord(RecordInputStream recordInputStream) {
        this._range = new CellRangeAddress(recordInputStream);
        this._guid = new GUID(recordInputStream);
        int i = recordInputStream.readInt();
        if (i != 2) {
            throw new RecordFormatException("Stream Version must be 0x2 but found " + i);
        }
        int i2 = recordInputStream.readInt();
        this._linkOpts = i2;
        if ((i2 & 20) != 0) {
            this._label = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
        }
        if ((this._linkOpts & 128) != 0) {
            this._targetFrame = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
        }
        int i3 = this._linkOpts;
        if ((i3 & 1) != 0 && (i3 & 256) != 0) {
            this._moniker = null;
            this._address = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
        }
        int i4 = this._linkOpts;
        if ((i4 & 1) != 0 && (i4 & 256) == 0) {
            GUID guid = new GUID(recordInputStream);
            this._moniker = guid;
            if (URL_MONIKER.equals(guid)) {
                int i5 = recordInputStream.readInt();
                if (i5 == recordInputStream.remaining()) {
                    this._address = recordInputStream.readUnicodeLEString(i5 / 2);
                } else {
                    this._address = recordInputStream.readUnicodeLEString((i5 - TAIL_SIZE) / 2);
                    this._uninterpretedTail = readTail(URL_TAIL, recordInputStream);
                }
            } else if (FILE_MONIKER.equals(this._moniker)) {
                this._fileOpts = recordInputStream.readShort();
                this._shortFilename = StringUtil.readCompressedUnicode(recordInputStream, recordInputStream.readInt());
                this._uninterpretedTail = readTail(FILE_TAIL, recordInputStream);
                if (recordInputStream.readInt() > 0) {
                    int i6 = recordInputStream.readInt();
                    recordInputStream.readUShort();
                    this._address = StringUtil.readUnicodeLE(recordInputStream, i6 / 2);
                } else {
                    this._address = null;
                }
            } else if (STD_MONIKER.equals(this._moniker)) {
                this._fileOpts = recordInputStream.readShort();
                byte[] bArr = new byte[recordInputStream.readInt()];
                recordInputStream.readFully(bArr);
                this._address = new String(bArr, StringUtil.UTF8);
            }
        }
        if ((this._linkOpts & 8) != 0) {
            this._textMark = recordInputStream.readUnicodeLEString(recordInputStream.readInt());
        }
        if (recordInputStream.remaining() > 0) {
            logger.log(5, "Hyperlink data remains: " + recordInputStream.remaining() + " : " + HexDump.toHex(recordInputStream.readRemainder()));
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this._range.serialize(littleEndianOutput);
        this._guid.serialize(littleEndianOutput);
        littleEndianOutput.writeInt(2);
        littleEndianOutput.writeInt(this._linkOpts);
        if ((this._linkOpts & 20) != 0) {
            littleEndianOutput.writeInt(this._label.length());
            StringUtil.putUnicodeLE(this._label, littleEndianOutput);
        }
        if ((this._linkOpts & 128) != 0) {
            littleEndianOutput.writeInt(this._targetFrame.length());
            StringUtil.putUnicodeLE(this._targetFrame, littleEndianOutput);
        }
        int i = this._linkOpts;
        if ((i & 1) != 0 && (i & 256) != 0) {
            littleEndianOutput.writeInt(this._address.length());
            StringUtil.putUnicodeLE(this._address, littleEndianOutput);
        }
        int i2 = this._linkOpts;
        if ((i2 & 1) != 0 && (i2 & 256) == 0) {
            this._moniker.serialize(littleEndianOutput);
            if (URL_MONIKER.equals(this._moniker)) {
                if (this._uninterpretedTail == null) {
                    littleEndianOutput.writeInt(this._address.length() * 2);
                    StringUtil.putUnicodeLE(this._address, littleEndianOutput);
                } else {
                    littleEndianOutput.writeInt((this._address.length() * 2) + TAIL_SIZE);
                    StringUtil.putUnicodeLE(this._address, littleEndianOutput);
                    writeTail(this._uninterpretedTail, littleEndianOutput);
                }
            } else if (FILE_MONIKER.equals(this._moniker)) {
                littleEndianOutput.writeShort(this._fileOpts);
                littleEndianOutput.writeInt(this._shortFilename.length());
                StringUtil.putCompressedUnicode(this._shortFilename, littleEndianOutput);
                writeTail(this._uninterpretedTail, littleEndianOutput);
                String str = this._address;
                if (str == null) {
                    littleEndianOutput.writeInt(0);
                } else {
                    int length = str.length() * 2;
                    littleEndianOutput.writeInt(length + 6);
                    littleEndianOutput.writeInt(length);
                    littleEndianOutput.writeShort(3);
                    StringUtil.putUnicodeLE(this._address, littleEndianOutput);
                }
            }
        }
        if ((this._linkOpts & 8) != 0) {
            littleEndianOutput.writeInt(this._textMark.length());
            StringUtil.putUnicodeLE(this._textMark, littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        int length;
        int length2 = (this._linkOpts & 20) != 0 ? 36 + (this._label.length() * 2) : 32;
        if ((this._linkOpts & 128) != 0) {
            length2 = length2 + 4 + (this._targetFrame.length() * 2);
        }
        int i = this._linkOpts;
        if ((i & 1) != 0 && (i & 256) != 0) {
            length2 = length2 + 4 + (this._address.length() * 2);
        }
        int i2 = this._linkOpts;
        if ((i2 & 1) != 0 && (i2 & 256) == 0) {
            length2 += 16;
            if (URL_MONIKER.equals(this._moniker)) {
                length2 = length2 + 4 + (this._address.length() * 2);
                if (this._uninterpretedTail != null) {
                    length = TAIL_SIZE;
                    length2 += length;
                }
            } else if (FILE_MONIKER.equals(this._moniker)) {
                length2 = length2 + 2 + 4 + this._shortFilename.length() + TAIL_SIZE + 4;
                String str = this._address;
                if (str != null) {
                    length2 += 6;
                    length = str.length() * 2;
                    length2 += length;
                }
            }
        }
        return (this._linkOpts & 8) != 0 ? length2 + 4 + (this._textMark.length() * 2) : length2;
    }

    private static byte[] readTail(byte[] bArr, LittleEndianInput littleEndianInput) {
        byte[] bArr2 = new byte[TAIL_SIZE];
        littleEndianInput.readFully(bArr2);
        return bArr2;
    }

    private static void writeTail(byte[] bArr, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(bArr);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[HYPERLINK RECORD]\n    .range   = ");
        stringBuffer.append(this._range.formatAsString()).append("\n    .guid    = ");
        stringBuffer.append(this._guid.formatAsString()).append("\n    .linkOpts= ");
        stringBuffer.append(HexDump.intToHex(this._linkOpts)).append("\n    .label   = ");
        stringBuffer.append(getLabel()).append("\n");
        if ((this._linkOpts & 128) != 0) {
            stringBuffer.append("    .targetFrame= ").append(getTargetFrame()).append("\n");
        }
        if ((this._linkOpts & 1) != 0 && this._moniker != null) {
            stringBuffer.append("    .moniker   = ").append(this._moniker.formatAsString()).append("\n");
        }
        if ((this._linkOpts & 8) != 0) {
            stringBuffer.append("    .textMark= ").append(getTextMark()).append("\n");
        }
        stringBuffer.append("    .address   = ").append(getAddress()).append("\n[/HYPERLINK RECORD]\n");
        return stringBuffer.toString();
    }

    public boolean isUrlLink() {
        int i = this._linkOpts;
        return (i & 1) > 0 && (i & 2) > 0;
    }

    public boolean isFileLink() {
        int i = this._linkOpts;
        return (i & 1) > 0 && (i & 2) == 0;
    }

    public boolean isDocumentLink() {
        return (this._linkOpts & 8) > 0;
    }

    public void newUrlLink() {
        this._range = new CellRangeAddress(0, 0, 0, 0);
        this._guid = STD_MONIKER;
        this._linkOpts = 23;
        setLabel("");
        this._moniker = URL_MONIKER;
        setAddress("");
        this._uninterpretedTail = URL_TAIL;
    }

    public void newFileLink() {
        this._range = new CellRangeAddress(0, 0, 0, 0);
        this._guid = STD_MONIKER;
        this._linkOpts = 21;
        this._fileOpts = 0;
        setLabel("");
        this._moniker = FILE_MONIKER;
        setAddress(null);
        setShortFilename("");
        this._uninterpretedTail = FILE_TAIL;
    }

    public void newDocumentLink() {
        this._range = new CellRangeAddress(0, 0, 0, 0);
        this._guid = STD_MONIKER;
        this._linkOpts = 28;
        setLabel("");
        this._moniker = FILE_MONIKER;
        setAddress("");
        setTextMark("");
    }

    @Override // org.apache.poi.hssf.record.Record
    public HyperlinkRecord clone() {
        HyperlinkRecord hyperlinkRecord = new HyperlinkRecord();
        hyperlinkRecord._range = this._range.copy();
        hyperlinkRecord._guid = this._guid;
        hyperlinkRecord._linkOpts = this._linkOpts;
        hyperlinkRecord._fileOpts = this._fileOpts;
        hyperlinkRecord._label = this._label;
        hyperlinkRecord._address = this._address;
        hyperlinkRecord._moniker = this._moniker;
        hyperlinkRecord._shortFilename = this._shortFilename;
        hyperlinkRecord._targetFrame = this._targetFrame;
        hyperlinkRecord._textMark = this._textMark;
        hyperlinkRecord._uninterpretedTail = this._uninterpretedTail;
        return hyperlinkRecord;
    }
}
