package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ViewDefinitionRecord extends StandardRecord {
    public static final short sid = 176;
    private int cCol;
    private int cDim;
    private int cDimCol;
    private int cDimData;
    private int cDimPg;
    private int cDimRw;
    private int cRw;
    private int colFirst;
    private int colFirstData;
    private int colLast;
    private String dataField;
    private int grbit;
    private int iCache;
    private int ipos4Data;
    private int itblAutoFmt;
    private String name;
    private int reserved;
    private int rwFirst;
    private int rwFirstData;
    private int rwFirstHead;
    private int rwLast;
    private int sxaxis4Data;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 176;
    }

    public ViewDefinitionRecord(RecordInputStream recordInputStream) {
        this.rwFirst = recordInputStream.readUShort();
        this.rwLast = recordInputStream.readUShort();
        this.colFirst = recordInputStream.readUShort();
        this.colLast = recordInputStream.readUShort();
        this.rwFirstHead = recordInputStream.readUShort();
        this.rwFirstData = recordInputStream.readUShort();
        this.colFirstData = recordInputStream.readUShort();
        this.iCache = recordInputStream.readUShort();
        this.reserved = recordInputStream.readUShort();
        this.sxaxis4Data = recordInputStream.readUShort();
        this.ipos4Data = recordInputStream.readUShort();
        this.cDim = recordInputStream.readUShort();
        this.cDimRw = recordInputStream.readUShort();
        this.cDimCol = recordInputStream.readUShort();
        this.cDimPg = recordInputStream.readUShort();
        this.cDimData = recordInputStream.readUShort();
        this.cRw = recordInputStream.readUShort();
        this.cCol = recordInputStream.readUShort();
        this.grbit = recordInputStream.readUShort();
        this.itblAutoFmt = recordInputStream.readUShort();
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        this.name = StringUtil.readUnicodeString(recordInputStream, uShort);
        this.dataField = StringUtil.readUnicodeString(recordInputStream, uShort2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rwFirst);
        littleEndianOutput.writeShort(this.rwLast);
        littleEndianOutput.writeShort(this.colFirst);
        littleEndianOutput.writeShort(this.colLast);
        littleEndianOutput.writeShort(this.rwFirstHead);
        littleEndianOutput.writeShort(this.rwFirstData);
        littleEndianOutput.writeShort(this.colFirstData);
        littleEndianOutput.writeShort(this.iCache);
        littleEndianOutput.writeShort(this.reserved);
        littleEndianOutput.writeShort(this.sxaxis4Data);
        littleEndianOutput.writeShort(this.ipos4Data);
        littleEndianOutput.writeShort(this.cDim);
        littleEndianOutput.writeShort(this.cDimRw);
        littleEndianOutput.writeShort(this.cDimCol);
        littleEndianOutput.writeShort(this.cDimPg);
        littleEndianOutput.writeShort(this.cDimData);
        littleEndianOutput.writeShort(this.cRw);
        littleEndianOutput.writeShort(this.cCol);
        littleEndianOutput.writeShort(this.grbit);
        littleEndianOutput.writeShort(this.itblAutoFmt);
        littleEndianOutput.writeShort(this.name.length());
        littleEndianOutput.writeShort(this.dataField.length());
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.name);
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.dataField);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return StringUtil.getEncodedSize(this.name) + 40 + StringUtil.getEncodedSize(this.dataField);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SXVIEW]\n    .rwFirst      =");
        stringBuffer.append(HexDump.shortToHex(this.rwFirst)).append("\n    .rwLast       =");
        stringBuffer.append(HexDump.shortToHex(this.rwLast)).append("\n    .colFirst     =");
        stringBuffer.append(HexDump.shortToHex(this.colFirst)).append("\n    .colLast      =");
        stringBuffer.append(HexDump.shortToHex(this.colLast)).append("\n    .rwFirstHead  =");
        stringBuffer.append(HexDump.shortToHex(this.rwFirstHead)).append("\n    .rwFirstData  =");
        stringBuffer.append(HexDump.shortToHex(this.rwFirstData)).append("\n    .colFirstData =");
        stringBuffer.append(HexDump.shortToHex(this.colFirstData)).append("\n    .iCache       =");
        stringBuffer.append(HexDump.shortToHex(this.iCache)).append("\n    .reserved     =");
        stringBuffer.append(HexDump.shortToHex(this.reserved)).append("\n    .sxaxis4Data  =");
        stringBuffer.append(HexDump.shortToHex(this.sxaxis4Data)).append("\n    .ipos4Data    =");
        stringBuffer.append(HexDump.shortToHex(this.ipos4Data)).append("\n    .cDim         =");
        stringBuffer.append(HexDump.shortToHex(this.cDim)).append("\n    .cDimRw       =");
        stringBuffer.append(HexDump.shortToHex(this.cDimRw)).append("\n    .cDimCol      =");
        stringBuffer.append(HexDump.shortToHex(this.cDimCol)).append("\n    .cDimPg       =");
        stringBuffer.append(HexDump.shortToHex(this.cDimPg)).append("\n    .cDimData     =");
        stringBuffer.append(HexDump.shortToHex(this.cDimData)).append("\n    .cRw          =");
        stringBuffer.append(HexDump.shortToHex(this.cRw)).append("\n    .cCol         =");
        stringBuffer.append(HexDump.shortToHex(this.cCol)).append("\n    .grbit        =");
        stringBuffer.append(HexDump.shortToHex(this.grbit)).append("\n    .itblAutoFmt  =");
        stringBuffer.append(HexDump.shortToHex(this.itblAutoFmt)).append("\n    .name         =");
        stringBuffer.append(this.name).append("\n    .dataField    =");
        stringBuffer.append(this.dataField).append("\n[/SXVIEW]\n");
        return stringBuffer.toString();
    }
}
