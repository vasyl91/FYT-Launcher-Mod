package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FontRecord extends StandardRecord {
    public static final short SS_NONE = 0;
    public static final short SS_SUB = 2;
    public static final short SS_SUPER = 1;
    public static final byte U_DOUBLE = 2;
    public static final byte U_DOUBLE_ACCOUNTING = 34;
    public static final byte U_NONE = 0;
    public static final byte U_SINGLE = 1;
    public static final byte U_SINGLE_ACCOUNTING = 33;
    public static final short sid = 49;
    private String field_11_font_name;
    private short field_1_font_height;
    private short field_2_attributes;
    private short field_3_color_palette_index;
    private short field_4_bold_weight;
    private short field_5_super_sub_script;
    private byte field_6_underline;
    private byte field_7_family;
    private byte field_8_charset;
    private byte field_9_zero;
    private static final BitField italic = BitFieldFactory.getInstance(2);
    private static final BitField strikeout = BitFieldFactory.getInstance(8);
    private static final BitField macoutline = BitFieldFactory.getInstance(16);
    private static final BitField macshadow = BitFieldFactory.getInstance(32);

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 49;
    }

    public FontRecord() {
        this.field_9_zero = (byte) 0;
    }

    public FontRecord(RecordInputStream recordInputStream) {
        this.field_9_zero = (byte) 0;
        this.field_1_font_height = recordInputStream.readShort();
        this.field_2_attributes = recordInputStream.readShort();
        this.field_3_color_palette_index = recordInputStream.readShort();
        this.field_4_bold_weight = recordInputStream.readShort();
        this.field_5_super_sub_script = recordInputStream.readShort();
        this.field_6_underline = recordInputStream.readByte();
        this.field_7_family = recordInputStream.readByte();
        this.field_8_charset = recordInputStream.readByte();
        this.field_9_zero = recordInputStream.readByte();
        int uByte = recordInputStream.readUByte();
        int uByte2 = recordInputStream.readUByte();
        if (uByte <= 0) {
            this.field_11_font_name = "";
        } else if (uByte2 == 0) {
            this.field_11_font_name = recordInputStream.readCompressedUnicode(uByte);
        } else {
            this.field_11_font_name = recordInputStream.readUnicodeLEString(uByte);
        }
    }

    public void setFontHeight(short s) {
        this.field_1_font_height = s;
    }

    public void setAttributes(short s) {
        this.field_2_attributes = s;
    }

    public void setItalic(boolean z) {
        this.field_2_attributes = italic.setShortBoolean(this.field_2_attributes, z);
    }

    public void setStrikeout(boolean z) {
        this.field_2_attributes = strikeout.setShortBoolean(this.field_2_attributes, z);
    }

    public void setMacoutline(boolean z) {
        this.field_2_attributes = macoutline.setShortBoolean(this.field_2_attributes, z);
    }

    public void setMacshadow(boolean z) {
        this.field_2_attributes = macshadow.setShortBoolean(this.field_2_attributes, z);
    }

    public void setColorPaletteIndex(short s) {
        this.field_3_color_palette_index = s;
    }

    public void setBoldWeight(short s) {
        this.field_4_bold_weight = s;
    }

    public void setSuperSubScript(short s) {
        this.field_5_super_sub_script = s;
    }

    public void setUnderline(byte b) {
        this.field_6_underline = b;
    }

    public void setFamily(byte b) {
        this.field_7_family = b;
    }

    public void setCharset(byte b) {
        this.field_8_charset = b;
    }

    public void setFontName(String str) {
        this.field_11_font_name = str;
    }

    public short getFontHeight() {
        return this.field_1_font_height;
    }

    public short getAttributes() {
        return this.field_2_attributes;
    }

    public boolean isItalic() {
        return italic.isSet(this.field_2_attributes);
    }

    public boolean isStruckout() {
        return strikeout.isSet(this.field_2_attributes);
    }

    public boolean isMacoutlined() {
        return macoutline.isSet(this.field_2_attributes);
    }

    public boolean isMacshadowed() {
        return macshadow.isSet(this.field_2_attributes);
    }

    public short getColorPaletteIndex() {
        return this.field_3_color_palette_index;
    }

    public short getBoldWeight() {
        return this.field_4_bold_weight;
    }

    public short getSuperSubScript() {
        return this.field_5_super_sub_script;
    }

    public byte getUnderline() {
        return this.field_6_underline;
    }

    public byte getFamily() {
        return this.field_7_family;
    }

    public byte getCharset() {
        return this.field_8_charset;
    }

    public String getFontName() {
        return this.field_11_font_name;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FONT]\n    .fontheight    = ");
        stringBuffer.append(HexDump.shortToHex(getFontHeight())).append("\n    .attributes    = ");
        stringBuffer.append(HexDump.shortToHex(getAttributes())).append("\n       .italic     = ");
        stringBuffer.append(isItalic()).append("\n       .strikout   = ");
        stringBuffer.append(isStruckout()).append("\n       .macoutlined= ");
        stringBuffer.append(isMacoutlined()).append("\n       .macshadowed= ");
        stringBuffer.append(isMacshadowed()).append("\n    .colorpalette  = ");
        stringBuffer.append(HexDump.shortToHex(getColorPaletteIndex())).append("\n    .boldweight    = ");
        stringBuffer.append(HexDump.shortToHex(getBoldWeight())).append("\n    .supersubscript= ");
        stringBuffer.append(HexDump.shortToHex(getSuperSubScript())).append("\n    .underline     = ");
        stringBuffer.append(HexDump.byteToHex(getUnderline())).append("\n    .family        = ");
        stringBuffer.append(HexDump.byteToHex(getFamily())).append("\n    .charset       = ");
        stringBuffer.append(HexDump.byteToHex(getCharset())).append("\n    .fontname      = ");
        stringBuffer.append(getFontName()).append("\n[/FONT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFontHeight());
        littleEndianOutput.writeShort(getAttributes());
        littleEndianOutput.writeShort(getColorPaletteIndex());
        littleEndianOutput.writeShort(getBoldWeight());
        littleEndianOutput.writeShort(getSuperSubScript());
        littleEndianOutput.writeByte(getUnderline());
        littleEndianOutput.writeByte(getFamily());
        littleEndianOutput.writeByte(getCharset());
        littleEndianOutput.writeByte(this.field_9_zero);
        int length = this.field_11_font_name.length();
        littleEndianOutput.writeByte(length);
        boolean zHasMultibyte = StringUtil.hasMultibyte(this.field_11_font_name);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (length > 0) {
            if (zHasMultibyte) {
                StringUtil.putUnicodeLE(this.field_11_font_name, littleEndianOutput);
            } else {
                StringUtil.putCompressedUnicode(this.field_11_font_name, littleEndianOutput);
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        int length = this.field_11_font_name.length();
        if (length < 1) {
            return 16;
        }
        return (length * (StringUtil.hasMultibyte(this.field_11_font_name) ? 2 : 1)) + 16;
    }

    public void cloneStyleFrom(FontRecord fontRecord) {
        this.field_1_font_height = fontRecord.field_1_font_height;
        this.field_2_attributes = fontRecord.field_2_attributes;
        this.field_3_color_palette_index = fontRecord.field_3_color_palette_index;
        this.field_4_bold_weight = fontRecord.field_4_bold_weight;
        this.field_5_super_sub_script = fontRecord.field_5_super_sub_script;
        this.field_6_underline = fontRecord.field_6_underline;
        this.field_7_family = fontRecord.field_7_family;
        this.field_8_charset = fontRecord.field_8_charset;
        this.field_9_zero = fontRecord.field_9_zero;
        this.field_11_font_name = fontRecord.field_11_font_name;
    }

    public int hashCode() {
        String str = this.field_11_font_name;
        return (((((((((((((((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.field_1_font_height) * 31) + this.field_2_attributes) * 31) + this.field_3_color_palette_index) * 31) + this.field_4_bold_weight) * 31) + this.field_5_super_sub_script) * 31) + this.field_6_underline) * 31) + this.field_7_family) * 31) + this.field_8_charset) * 31) + this.field_9_zero;
    }

    public boolean sameProperties(FontRecord fontRecord) {
        return this.field_1_font_height == fontRecord.field_1_font_height && this.field_2_attributes == fontRecord.field_2_attributes && this.field_3_color_palette_index == fontRecord.field_3_color_palette_index && this.field_4_bold_weight == fontRecord.field_4_bold_weight && this.field_5_super_sub_script == fontRecord.field_5_super_sub_script && this.field_6_underline == fontRecord.field_6_underline && this.field_7_family == fontRecord.field_7_family && this.field_8_charset == fontRecord.field_8_charset && this.field_9_zero == fontRecord.field_9_zero && stringEquals(this.field_11_font_name, fontRecord.field_11_font_name);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FontRecord) {
            return sameProperties((FontRecord) obj);
        }
        return false;
    }

    private static boolean stringEquals(String str, String str2) {
        return str == str2 || (str != null && str.equals(str2));
    }
}
