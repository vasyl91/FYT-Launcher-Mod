package org.apache.poi.xssf.usermodel;

import java.awt.Color;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFColor extends ExtendedColor {
    private final CTColor ctColor;
    private final IndexedColorMap indexedColorMap;

    @Removal(version = "3.19")
    @Deprecated
    public XSSFColor(CTColor cTColor) {
        this(cTColor, new DefaultIndexedColorMap());
    }

    public XSSFColor(CTColor cTColor, IndexedColorMap indexedColorMap) {
        this.ctColor = cTColor;
        this.indexedColorMap = indexedColorMap;
    }

    public XSSFColor() {
        this(CTColor.Factory.newInstance(), (IndexedColorMap) null);
    }

    public XSSFColor(Color color) {
        this();
        setColor(color);
    }

    public XSSFColor(byte[] bArr, IndexedColorMap indexedColorMap) {
        this(CTColor.Factory.newInstance(), indexedColorMap);
        this.ctColor.setRgb(bArr);
    }

    public XSSFColor(IndexedColors indexedColors, IndexedColorMap indexedColorMap) {
        this(CTColor.Factory.newInstance(), indexedColorMap);
        this.ctColor.setIndexed(indexedColors.index);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isAuto() {
        return this.ctColor.getAuto();
    }

    public void setAuto(boolean z) {
        this.ctColor.setAuto(z);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isIndexed() {
        return this.ctColor.isSetIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isRGB() {
        return this.ctColor.isSetRgb();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isThemed() {
        return this.ctColor.isSetTheme();
    }

    public boolean hasAlpha() {
        return this.ctColor.isSetRgb() && this.ctColor.getRgb().length == 4;
    }

    public boolean hasTint() {
        return this.ctColor.isSetTint() && this.ctColor.getTint() != 0.0d;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public short getIndex() {
        return (short) this.ctColor.getIndexed();
    }

    public short getIndexed() {
        return getIndex();
    }

    public void setIndexed(int i) {
        this.ctColor.setIndexed(i);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getRGB() {
        byte[] rGBOrARGB = getRGBOrARGB();
        if (rGBOrARGB == null) {
            return null;
        }
        if (rGBOrARGB.length != 4) {
            return rGBOrARGB;
        }
        byte[] bArr = new byte[3];
        System.arraycopy(rGBOrARGB, 1, bArr, 0, 3);
        return bArr;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getARGB() {
        byte[] rGBOrARGB = getRGBOrARGB();
        if (rGBOrARGB == null) {
            return null;
        }
        if (rGBOrARGB.length != 3) {
            return rGBOrARGB;
        }
        byte[] bArr = new byte[4];
        bArr[0] = -1;
        System.arraycopy(rGBOrARGB, 0, bArr, 1, 3);
        return bArr;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    protected byte[] getStoredRBG() {
        return this.ctColor.getRgb();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    protected byte[] getIndexedRGB() {
        if (!isIndexed()) {
            return null;
        }
        IndexedColorMap indexedColorMap = this.indexedColorMap;
        return indexedColorMap != null ? indexedColorMap.getRGB(getIndex()) : DefaultIndexedColorMap.getDefaultRGB(getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public void setRGB(byte[] bArr) {
        this.ctColor.setRgb(bArr);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public int getTheme() {
        return (int) this.ctColor.getTheme();
    }

    public void setTheme(int i) {
        this.ctColor.setTheme(i);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public double getTint() {
        return this.ctColor.getTint();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public void setTint(double d) {
        this.ctColor.setTint(d);
    }

    @Internal
    public CTColor getCTColor() {
        return this.ctColor;
    }

    public static XSSFColor toXSSFColor(org.apache.poi.ss.usermodel.Color color) {
        if (color != null && !(color instanceof XSSFColor)) {
            throw new IllegalArgumentException("Only XSSFColor objects are supported");
        }
        return (XSSFColor) color;
    }

    public int hashCode() {
        return this.ctColor.toString().hashCode();
    }

    private boolean sameIndexed(XSSFColor xSSFColor) {
        if (isIndexed() == xSSFColor.isIndexed()) {
            return !isIndexed() || getIndexed() == xSSFColor.getIndexed();
        }
        return false;
    }

    private boolean sameARGB(XSSFColor xSSFColor) {
        if (isRGB() != xSSFColor.isRGB()) {
            return false;
        }
        if (isRGB()) {
            return Arrays.equals(getARGB(), xSSFColor.getARGB());
        }
        return true;
    }

    private boolean sameTheme(XSSFColor xSSFColor) {
        if (isThemed() == xSSFColor.isThemed()) {
            return !isThemed() || getTheme() == xSSFColor.getTheme();
        }
        return false;
    }

    private boolean sameTint(XSSFColor xSSFColor) {
        if (hasTint() == xSSFColor.hasTint()) {
            return !hasTint() || getTint() == xSSFColor.getTint();
        }
        return false;
    }

    private boolean sameAuto(XSSFColor xSSFColor) {
        return isAuto() == xSSFColor.isAuto();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFColor)) {
            return false;
        }
        XSSFColor xSSFColor = (XSSFColor) obj;
        return sameARGB(xSSFColor) && sameTheme(xSSFColor) && sameIndexed(xSSFColor) && sameTint(xSSFColor) && sameAuto(xSSFColor);
    }
}
