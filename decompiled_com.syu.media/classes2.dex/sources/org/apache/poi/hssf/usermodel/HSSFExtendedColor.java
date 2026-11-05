package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ExtendedColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFExtendedColor extends ExtendedColor {
    private org.apache.poi.hssf.record.common.ExtendedColor color;

    public HSSFExtendedColor(org.apache.poi.hssf.record.common.ExtendedColor extendedColor) {
        this.color = extendedColor;
    }

    protected org.apache.poi.hssf.record.common.ExtendedColor getExtendedColor() {
        return this.color;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isAuto() {
        return this.color.getType() == 0;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isIndexed() {
        return this.color.getType() == 1;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isRGB() {
        return this.color.getType() == 2;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isThemed() {
        return this.color.getType() == 3;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public short getIndex() {
        return (short) this.color.getColorIndex();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public int getTheme() {
        return this.color.getThemeIndex();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getRGB() {
        byte[] bArr = new byte[3];
        byte[] rgba = this.color.getRGBA();
        if (rgba == null) {
            return null;
        }
        System.arraycopy(rgba, 0, bArr, 0, 3);
        return bArr;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getARGB() {
        byte[] bArr = new byte[4];
        byte[] rgba = this.color.getRGBA();
        if (rgba == null) {
            return null;
        }
        System.arraycopy(rgba, 0, bArr, 1, 3);
        bArr[0] = rgba[3];
        return bArr;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    protected byte[] getStoredRBG() {
        return getARGB();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public void setRGB(byte[] bArr) {
        if (bArr.length == 3) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 3);
            bArr2[3] = -1;
        } else {
            byte b = bArr[0];
            bArr[0] = bArr[1];
            bArr[1] = bArr[2];
            bArr[2] = bArr[3];
            bArr[3] = b;
            this.color.setRGBA(bArr);
        }
        this.color.setType(2);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public double getTint() {
        return this.color.getTint();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public void setTint(double d) {
        this.color.setTint(d);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    protected byte[] getIndexedRGB() {
        HSSFColor hSSFColor;
        if (!isIndexed() || getIndex() <= 0 || (hSSFColor = HSSFColor.getIndexHash().get(Integer.valueOf(getIndex()))) == null) {
            return null;
        }
        return new byte[]{(byte) hSSFColor.getTriplet()[0], (byte) hSSFColor.getTriplet()[1], (byte) hSSFColor.getTriplet()[2]};
    }
}
