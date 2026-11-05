package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFFont implements Font {
    static final short BOLDWEIGHT_BOLD = 700;
    static final short BOLDWEIGHT_NORMAL = 400;
    public static final String FONT_ARIAL = "Arial";
    private FontRecord font;
    private short index;

    protected HSSFFont(short s, FontRecord fontRecord) {
        this.font = fontRecord;
        this.index = s;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontName(String str) {
        this.font.setFontName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public String getFontName() {
        return this.font.getFontName();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getIndex() {
        return this.index;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeight(short s) {
        this.font.setFontHeight(s);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeightInPoints(short s) {
        this.font.setFontHeight((short) (s * 20));
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeight() {
        return this.font.getFontHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeightInPoints() {
        return (short) (this.font.getFontHeight() / 20);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setItalic(boolean z) {
        this.font.setItalic(z);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getItalic() {
        return this.font.isItalic();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setStrikeout(boolean z) {
        this.font.setStrikeout(z);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getStrikeout() {
        return this.font.isStruckout();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setColor(short s) {
        this.font.setColorPaletteIndex(s);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getColor() {
        return this.font.getColorPaletteIndex();
    }

    public HSSFColor getHSSFColor(HSSFWorkbook hSSFWorkbook) {
        return hSSFWorkbook.getCustomPalette().getColor(getColor());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setBold(boolean z) {
        if (z) {
            this.font.setBoldWeight((short) 700);
        } else {
            this.font.setBoldWeight((short) 400);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getBold() {
        return this.font.getBoldWeight() == 700;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setTypeOffset(short s) {
        this.font.setSuperSubScript(s);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getTypeOffset() {
        return this.font.getSuperSubScript();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setUnderline(byte b) {
        this.font.setUnderline(b);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public byte getUnderline() {
        return this.font.getUnderline();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public int getCharSet() {
        byte charset = this.font.getCharset();
        return charset >= 0 ? charset : charset + 256;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(int i) {
        byte b = (byte) i;
        if (i > 127) {
            b = (byte) (i - 256);
        }
        setCharSet(b);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(byte b) {
        this.font.setCharset(b);
    }

    public String toString() {
        return "org.apache.poi.hssf.usermodel.HSSFFont{" + this.font + "}";
    }

    public int hashCode() {
        FontRecord fontRecord = this.font;
        return (((fontRecord == null ? 0 : fontRecord.hashCode()) + 31) * 31) + this.index;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HSSFFont)) {
            return false;
        }
        HSSFFont hSSFFont = (HSSFFont) obj;
        FontRecord fontRecord = this.font;
        if (fontRecord == null) {
            if (hSSFFont.font != null) {
                return false;
            }
        } else if (!fontRecord.equals(hSSFFont.font)) {
            return false;
        }
        return this.index == hSSFFont.index;
    }
}
