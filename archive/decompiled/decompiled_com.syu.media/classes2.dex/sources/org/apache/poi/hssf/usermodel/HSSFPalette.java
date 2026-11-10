package org.apache.poi.hssf.usermodel;

import java.util.Locale;
import kotlin.UByte;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.util.HSSFColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFPalette {
    private PaletteRecord _palette;

    private int unsignedInt(byte b) {
        return b & UByte.MAX_VALUE;
    }

    protected HSSFPalette(PaletteRecord paletteRecord) {
        this._palette = paletteRecord;
    }

    public HSSFColor getColor(short s) {
        if (s == HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex()) {
            return HSSFColor.HSSFColorPredefined.AUTOMATIC.getColor();
        }
        byte[] color = this._palette.getColor(s);
        if (color == null) {
            return null;
        }
        return new CustomColor(s, color);
    }

    public HSSFColor getColor(int i) {
        return getColor((short) i);
    }

    public HSSFColor findColor(byte b, byte b2, byte b3) {
        short s = 8;
        byte[] color = this._palette.getColor(8);
        while (color != null) {
            if (color[0] != b || color[1] != b2 || color[2] != b3) {
                s = (short) (s + 1);
                color = this._palette.getColor(s);
            } else {
                return new CustomColor(s, color);
            }
        }
        return null;
    }

    public HSSFColor findSimilarColor(byte b, byte b2, byte b3) {
        return findSimilarColor(unsignedInt(b), unsignedInt(b2), unsignedInt(b3));
    }

    public HSSFColor findSimilarColor(int i, int i2, int i3) {
        short s = 8;
        byte[] color = this._palette.getColor(8);
        HSSFColor color2 = null;
        int i4 = Integer.MAX_VALUE;
        while (color != null) {
            int iAbs = Math.abs(i - unsignedInt(color[0])) + Math.abs(i2 - unsignedInt(color[1])) + Math.abs(i3 - unsignedInt(color[2]));
            if (iAbs < i4) {
                color2 = getColor(s);
                i4 = iAbs;
            }
            s = (short) (s + 1);
            color = this._palette.getColor(s);
        }
        return color2;
    }

    public void setColorAtIndex(short s, byte b, byte b2, byte b3) {
        this._palette.setColor(s, b, b2, b3);
    }

    public HSSFColor addColor(byte b, byte b2, byte b3) {
        short s = 8;
        byte[] color = this._palette.getColor(8);
        while (s < 64) {
            if (color != null) {
                s = (short) (s + 1);
                color = this._palette.getColor(s);
            } else {
                setColorAtIndex(s, b, b2, b3);
                return getColor(s);
            }
        }
        throw new RuntimeException("Could not find free color index");
    }

    private static final class CustomColor extends HSSFColor {
        private byte _blue;
        private short _byteOffset;
        private byte _green;
        private byte _red;

        public CustomColor(short s, byte[] bArr) {
            this(s, bArr[0], bArr[1], bArr[2]);
        }

        private CustomColor(short s, byte b, byte b2, byte b3) {
            this._byteOffset = s;
            this._red = b;
            this._green = b2;
            this._blue = b3;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return this._byteOffset;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return new short[]{(short) (this._red & UByte.MAX_VALUE), (short) (this._green & UByte.MAX_VALUE), (short) (this._blue & UByte.MAX_VALUE)};
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getGnumericPart(this._red));
            stringBuffer.append(':');
            stringBuffer.append(getGnumericPart(this._green));
            stringBuffer.append(':');
            stringBuffer.append(getGnumericPart(this._blue));
            return stringBuffer.toString();
        }

        private String getGnumericPart(byte b) {
            if (b == 0) {
                return "0";
            }
            int i = b & UByte.MAX_VALUE;
            String upperCase = Integer.toHexString(i | (i << 8)).toUpperCase(Locale.ROOT);
            while (upperCase.length() < 4) {
                upperCase = "0" + upperCase;
            }
            return upperCase;
        }
    }
}
