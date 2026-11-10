package org.apache.poi.hssf.record;

import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ExternalNameRecord extends StandardRecord {
    private static final int OPT_AUTOMATIC_LINK = 2;
    private static final int OPT_BUILTIN_NAME = 1;
    private static final int OPT_ICONIFIED_PICTURE_LINK = 32768;
    private static final int OPT_OLE_LINK = 16;
    private static final int OPT_PICTURE_LINK = 4;
    private static final int OPT_STD_DOCUMENT_NAME = 8;
    public static final short sid = 35;
    private Object[] _ddeValues;
    private int _nColumns;
    private int _nRows;
    private short field_1_option_flag;
    private short field_2_ixals;
    private short field_3_not_used;
    private String field_4_name;
    private Formula field_5_name_definition;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 35;
    }

    public boolean isBuiltInName() {
        return (this.field_1_option_flag & 1) != 0;
    }

    public boolean isAutomaticLink() {
        return (this.field_1_option_flag & 2) != 0;
    }

    public boolean isPicureLink() {
        return (this.field_1_option_flag & 4) != 0;
    }

    public boolean isStdDocumentNameIdentifier() {
        return (this.field_1_option_flag & 8) != 0;
    }

    public boolean isOLELink() {
        return (this.field_1_option_flag & 16) != 0;
    }

    public boolean isIconifiedPictureLink() {
        return (this.field_1_option_flag & ShortCompanionObject.MIN_VALUE) != 0;
    }

    public String getText() {
        return this.field_4_name;
    }

    public void setText(String str) {
        this.field_4_name = str;
    }

    public short getIx() {
        return this.field_2_ixals;
    }

    public void setIx(short s) {
        this.field_2_ixals = s;
    }

    public Ptg[] getParsedExpression() {
        return Formula.getTokens(this.field_5_name_definition);
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        this.field_5_name_definition = Formula.create(ptgArr);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        int encodedSize;
        int encodedSize2 = (StringUtil.getEncodedSize(this.field_4_name) - 1) + 6;
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return encodedSize2;
        }
        if (isAutomaticLink()) {
            Object[] objArr = this._ddeValues;
            if (objArr == null) {
                return encodedSize2;
            }
            encodedSize2 += 3;
            encodedSize = ConstantValueParser.getEncodedSize(objArr);
        } else {
            encodedSize = this.field_5_name_definition.getEncodedSize();
        }
        return encodedSize2 + encodedSize;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_option_flag);
        littleEndianOutput.writeShort(this.field_2_ixals);
        littleEndianOutput.writeShort(this.field_3_not_used);
        littleEndianOutput.writeByte(this.field_4_name.length());
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.field_4_name);
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return;
        }
        if (isAutomaticLink()) {
            if (this._ddeValues != null) {
                littleEndianOutput.writeByte(this._nColumns - 1);
                littleEndianOutput.writeShort(this._nRows - 1);
                ConstantValueParser.encode(littleEndianOutput, this._ddeValues);
                return;
            }
            return;
        }
        this.field_5_name_definition.serialize(littleEndianOutput);
    }

    public ExternalNameRecord() {
        this.field_2_ixals = (short) 0;
    }

    public ExternalNameRecord(RecordInputStream recordInputStream) {
        this.field_1_option_flag = recordInputStream.readShort();
        this.field_2_ixals = recordInputStream.readShort();
        this.field_3_not_used = recordInputStream.readShort();
        this.field_4_name = StringUtil.readUnicodeString(recordInputStream, recordInputStream.readUByte());
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return;
        }
        if (isAutomaticLink()) {
            if (recordInputStream.available() > 0) {
                int uByte = recordInputStream.readUByte() + 1;
                int i = recordInputStream.readShort() + 1;
                this._ddeValues = ConstantValueParser.parse(recordInputStream, i * uByte);
                this._nColumns = uByte;
                this._nRows = i;
                return;
            }
            return;
        }
        this.field_5_name_definition = Formula.read(recordInputStream.readUShort(), recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuilder sb = new StringBuilder("[EXTERNALNAME]\n    .options = ");
        sb.append((int) this.field_1_option_flag).append("\n    .ix      = ");
        sb.append((int) this.field_2_ixals).append("\n    .name    = ");
        sb.append(this.field_4_name).append("\n");
        Formula formula = this.field_5_name_definition;
        if (formula != null) {
            for (Ptg ptg : formula.getTokens()) {
                sb.append("    .namedef = ").append(ptg).append(ptg.getRVAType()).append("\n");
            }
        }
        sb.append("[/EXTERNALNAME]\n");
        return sb.toString();
    }
}
