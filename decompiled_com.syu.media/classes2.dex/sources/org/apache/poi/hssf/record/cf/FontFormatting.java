package org.apache.poi.hssf.record.cf;

import java.util.Locale;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FontFormatting implements Cloneable {
    public static final int FONT_CELL_HEIGHT_PRESERVED = -1;
    private static final short FONT_WEIGHT_BOLD = 700;
    private static final short FONT_WEIGHT_NORMAL = 400;
    private static final int OFFSET_ESCAPEMENT_TYPE = 74;
    private static final int OFFSET_ESCAPEMENT_TYPE_MODIFIED = 92;
    private static final int OFFSET_FONT_COLOR_INDEX = 80;
    private static final int OFFSET_FONT_FORMATING_END = 116;
    private static final int OFFSET_FONT_HEIGHT = 64;
    private static final int OFFSET_FONT_NAME = 0;
    private static final int OFFSET_FONT_OPTIONS = 68;
    private static final int OFFSET_FONT_WEIGHT = 72;
    private static final int OFFSET_FONT_WEIGHT_MODIFIED = 100;
    private static final int OFFSET_NOT_USED1 = 104;
    private static final int OFFSET_NOT_USED2 = 108;
    private static final int OFFSET_NOT_USED3 = 112;
    private static final int OFFSET_OPTION_FLAGS = 88;
    private static final int OFFSET_UNDERLINE_TYPE = 76;
    private static final int OFFSET_UNDERLINE_TYPE_MODIFIED = 96;
    private static final int RAW_DATA_SIZE = 118;
    public static final short SS_NONE = 0;
    public static final short SS_SUB = 2;
    public static final short SS_SUPER = 1;
    public static final byte U_DOUBLE = 2;
    public static final byte U_DOUBLE_ACCOUNTING = 34;
    public static final byte U_NONE = 0;
    public static final byte U_SINGLE = 1;
    public static final byte U_SINGLE_ACCOUNTING = 33;
    private final byte[] _rawData;
    private static final BitField posture = BitFieldFactory.getInstance(2);
    private static final BitField outline = BitFieldFactory.getInstance(8);
    private static final BitField shadow = BitFieldFactory.getInstance(16);
    private static final BitField cancellation = BitFieldFactory.getInstance(128);
    private static final BitField styleModified = BitFieldFactory.getInstance(2);
    private static final BitField outlineModified = BitFieldFactory.getInstance(8);
    private static final BitField shadowModified = BitFieldFactory.getInstance(16);
    private static final BitField cancellationModified = BitFieldFactory.getInstance(128);

    public int getDataLength() {
        return 118;
    }

    public FontFormatting() {
        this._rawData = new byte[118];
        setFontHeight(-1);
        setItalic(false);
        setFontWieghtModified(false);
        setOutline(false);
        setShadow(false);
        setStrikeout(false);
        setEscapementType((short) 0);
        setUnderlineType((short) 0);
        setFontColorIndex((short) -1);
        setFontStyleModified(false);
        setFontOutlineModified(false);
        setFontShadowModified(false);
        setFontCancellationModified(false);
        setEscapementTypeModified(false);
        setUnderlineTypeModified(false);
        setShort(0, 0);
        setInt(104, 1);
        setInt(108, 0);
        setInt(112, Integer.MAX_VALUE);
        setShort(116, 1);
    }

    public FontFormatting(RecordInputStream recordInputStream) {
        this._rawData = new byte[118];
        int i = 0;
        while (true) {
            byte[] bArr = this._rawData;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = recordInputStream.readByte();
            i++;
        }
    }

    private short getShort(int i) {
        return LittleEndian.getShort(this._rawData, i);
    }

    private void setShort(int i, int i2) {
        LittleEndian.putShort(this._rawData, i, (short) i2);
    }

    private int getInt(int i) {
        return LittleEndian.getInt(this._rawData, i);
    }

    private void setInt(int i, int i2) {
        LittleEndian.putInt(this._rawData, i, i2);
    }

    public byte[] getRawRecord() {
        return this._rawData;
    }

    public void setFontHeight(int i) {
        setInt(64, i);
    }

    public int getFontHeight() {
        return getInt(64);
    }

    private void setFontOption(boolean z, BitField bitField) {
        setInt(68, bitField.setBoolean(getInt(68), z));
    }

    private boolean getFontOption(BitField bitField) {
        return bitField.isSet(getInt(68));
    }

    public void setItalic(boolean z) {
        setFontOption(z, posture);
    }

    public boolean isItalic() {
        return getFontOption(posture);
    }

    public void setOutline(boolean z) {
        setFontOption(z, outline);
    }

    public boolean isOutlineOn() {
        return getFontOption(outline);
    }

    public void setShadow(boolean z) {
        setFontOption(z, shadow);
    }

    public boolean isShadowOn() {
        return getFontOption(shadow);
    }

    public void setStrikeout(boolean z) {
        setFontOption(z, cancellation);
    }

    public boolean isStruckout() {
        return getFontOption(cancellation);
    }

    private void setFontWeight(short s) {
        if (s < 100) {
            s = 100;
        }
        if (s > 1000) {
            s = 1000;
        }
        setShort(72, s);
    }

    public void setBold(boolean z) {
        setFontWeight(z ? (short) 700 : (short) 400);
    }

    public short getFontWeight() {
        return getShort(72);
    }

    public boolean isBold() {
        return getFontWeight() == 700;
    }

    public short getEscapementType() {
        return getShort(74);
    }

    public void setEscapementType(short s) {
        setShort(74, s);
    }

    public short getUnderlineType() {
        return getShort(76);
    }

    public void setUnderlineType(short s) {
        setShort(76, s);
    }

    public short getFontColorIndex() {
        return (short) getInt(80);
    }

    public void setFontColorIndex(short s) {
        setInt(80, s);
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.getValue(getInt(88)) == 0;
    }

    private void setOptionFlag(boolean z, BitField bitField) {
        setInt(88, bitField.setValue(getInt(88), !z ? 1 : 0));
    }

    public boolean isFontStyleModified() {
        return getOptionFlag(styleModified);
    }

    public void setFontStyleModified(boolean z) {
        setOptionFlag(z, styleModified);
    }

    public boolean isFontOutlineModified() {
        return getOptionFlag(outlineModified);
    }

    public void setFontOutlineModified(boolean z) {
        setOptionFlag(z, outlineModified);
    }

    public boolean isFontShadowModified() {
        return getOptionFlag(shadowModified);
    }

    public void setFontShadowModified(boolean z) {
        setOptionFlag(z, shadowModified);
    }

    public void setFontCancellationModified(boolean z) {
        setOptionFlag(z, cancellationModified);
    }

    public boolean isFontCancellationModified() {
        return getOptionFlag(cancellationModified);
    }

    public void setEscapementTypeModified(boolean z) {
        setInt(92, !z ? 1 : 0);
    }

    public boolean isEscapementTypeModified() {
        return getInt(92) == 0;
    }

    public void setUnderlineTypeModified(boolean z) {
        setInt(96, !z ? 1 : 0);
    }

    public boolean isUnderlineTypeModified() {
        return getInt(96) == 0;
    }

    public void setFontWieghtModified(boolean z) {
        setInt(100, !z ? 1 : 0);
    }

    public boolean isFontWeightModified() {
        return getInt(100) == 0;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer("    [Font Formatting]\n\t.font height = ");
        stringBuffer.append(getFontHeight()).append(" twips\n");
        if (isFontStyleModified()) {
            stringBuffer.append("\t.font posture = ").append(isItalic() ? "Italic" : "Normal").append("\n");
        } else {
            stringBuffer.append("\t.font posture = ]not modified]\n");
        }
        if (isFontOutlineModified()) {
            stringBuffer.append("\t.font outline = ").append(isOutlineOn()).append("\n");
        } else {
            stringBuffer.append("\t.font outline is not modified\n");
        }
        if (isFontShadowModified()) {
            stringBuffer.append("\t.font shadow = ").append(isShadowOn()).append("\n");
        } else {
            stringBuffer.append("\t.font shadow is not modified\n");
        }
        if (isFontCancellationModified()) {
            stringBuffer.append("\t.font strikeout = ").append(isStruckout()).append("\n");
        } else {
            stringBuffer.append("\t.font strikeout is not modified\n");
        }
        if (isFontStyleModified()) {
            StringBuffer stringBufferAppend = stringBuffer.append("\t.font weight = ").append((int) getFontWeight());
            if (getFontWeight() == 400) {
                str = "(Normal)";
            } else {
                str = getFontWeight() == 700 ? "(Bold)" : "0x" + Integer.toHexString(getFontWeight());
            }
            stringBufferAppend.append(str).append("\n");
        } else {
            stringBuffer.append("\t.font weight = ]not modified]\n");
        }
        if (isEscapementTypeModified()) {
            stringBuffer.append("\t.escapement type = ").append((int) getEscapementType()).append("\n");
        } else {
            stringBuffer.append("\t.escapement type is not modified\n");
        }
        if (isUnderlineTypeModified()) {
            stringBuffer.append("\t.underline type = ").append((int) getUnderlineType()).append("\n");
        } else {
            stringBuffer.append("\t.underline type is not modified\n");
        }
        stringBuffer.append("\t.color index = ").append("0x" + Integer.toHexString(getFontColorIndex()).toUpperCase(Locale.ROOT)).append("\n    [/Font Formatting]\n");
        return stringBuffer.toString();
    }

    public FontFormatting clone() {
        FontFormatting fontFormatting = new FontFormatting();
        byte[] bArr = this._rawData;
        System.arraycopy(bArr, 0, fontFormatting._rawData, 0, bArr.length);
        return fontFormatting;
    }
}
