package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class StyleRecord extends StandardRecord {
    public static final short sid = 659;
    private int field_1_xf_index;
    private int field_2_builtin_style;
    private int field_3_outline_style_level;
    private boolean field_3_stringHasMultibyte;
    private String field_4_name;
    private static final BitField styleIndexMask = BitFieldFactory.getInstance(4095);
    private static final BitField isBuiltinFlag = BitFieldFactory.getInstance(32768);

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public StyleRecord() {
        this.field_1_xf_index = isBuiltinFlag.set(0);
    }

    public StyleRecord(RecordInputStream recordInputStream) {
        this.field_1_xf_index = recordInputStream.readShort();
        if (isBuiltin()) {
            this.field_2_builtin_style = recordInputStream.readByte();
            this.field_3_outline_style_level = recordInputStream.readByte();
            return;
        }
        short s = recordInputStream.readShort();
        if (recordInputStream.remaining() < 1) {
            if (s != 0) {
                throw new RecordFormatException("Ran out of data reading style record");
            }
            this.field_4_name = "";
        } else {
            boolean z = recordInputStream.readByte() != 0;
            this.field_3_stringHasMultibyte = z;
            if (z) {
                this.field_4_name = StringUtil.readUnicodeLE(recordInputStream, s);
            } else {
                this.field_4_name = StringUtil.readCompressedUnicode(recordInputStream, s);
            }
        }
    }

    public void setXFIndex(int i) {
        this.field_1_xf_index = styleIndexMask.setValue(this.field_1_xf_index, i);
    }

    public int getXFIndex() {
        return styleIndexMask.getValue(this.field_1_xf_index);
    }

    public void setName(String str) {
        this.field_4_name = str;
        this.field_3_stringHasMultibyte = StringUtil.hasMultibyte(str);
        this.field_1_xf_index = isBuiltinFlag.clear(this.field_1_xf_index);
    }

    public void setBuiltinStyle(int i) {
        this.field_1_xf_index = isBuiltinFlag.set(this.field_1_xf_index);
        this.field_2_builtin_style = i;
    }

    public void setOutlineStyleLevel(int i) {
        this.field_3_outline_style_level = i & 255;
    }

    public boolean isBuiltin() {
        return isBuiltinFlag.isSet(this.field_1_xf_index);
    }

    public String getName() {
        return this.field_4_name;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuilder sb = new StringBuilder("[STYLE]\n    .xf_index_raw =");
        sb.append(HexDump.shortToHex(this.field_1_xf_index)).append("\n        .type     =");
        sb.append(isBuiltin() ? "built-in" : "user-defined").append("\n        .xf_index =");
        sb.append(HexDump.shortToHex(getXFIndex())).append("\n");
        if (isBuiltin()) {
            sb.append("    .builtin_style=").append(HexDump.byteToHex(this.field_2_builtin_style)).append("\n    .outline_level=");
            sb.append(HexDump.byteToHex(this.field_3_outline_style_level)).append("\n");
        } else {
            sb.append("    .name        =").append(getName()).append("\n");
        }
        sb.append("[/STYLE]\n");
        return sb.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        if (isBuiltin()) {
            return 4;
        }
        return (this.field_4_name.length() * (this.field_3_stringHasMultibyte ? 2 : 1)) + 5;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_xf_index);
        if (isBuiltin()) {
            littleEndianOutput.writeByte(this.field_2_builtin_style);
            littleEndianOutput.writeByte(this.field_3_outline_style_level);
            return;
        }
        littleEndianOutput.writeShort(this.field_4_name.length());
        littleEndianOutput.writeByte(this.field_3_stringHasMultibyte ? 1 : 0);
        if (this.field_3_stringHasMultibyte) {
            StringUtil.putUnicodeLE(getName(), littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(getName(), littleEndianOutput);
        }
    }
}
