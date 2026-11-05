package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FastBlur {
    public static Bitmap blur(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
        int i = radius;
        Bitmap bitmapCopy = canReuseInBitmap ? sentBitmap : sentBitmap.copy(sentBitmap.getConfig(), true);
        if (i < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i + 1;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int i8 = i7 * 256;
        int[] iArr6 = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            iArr6[i9] = i9 / i7;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5, 3);
        int i10 = i + 1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < height) {
            Bitmap bitmap = bitmapCopy;
            int i14 = height;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = -i;
            int i24 = 0;
            while (i23 <= i) {
                int i25 = i4;
                int[] iArr8 = iArr5;
                int i26 = iArr[i12 + Math.min(i3, Math.max(i23, 0))];
                int[] iArr9 = iArr7[i23 + i];
                iArr9[0] = (i26 & 16711680) >> 16;
                iArr9[1] = (i26 & 65280) >> 8;
                iArr9[2] = i26 & 255;
                int iAbs = i10 - Math.abs(i23);
                int i27 = iArr9[0];
                i24 += i27 * iAbs;
                int i28 = iArr9[1];
                i15 += i28 * iAbs;
                int i29 = iArr9[2];
                i16 += iAbs * i29;
                if (i23 > 0) {
                    i20 += i27;
                    i21 += i28;
                    i22 += i29;
                } else {
                    i17 += i27;
                    i18 += i28;
                    i19 += i29;
                }
                i23++;
                i4 = i25;
                iArr5 = iArr8;
            }
            int i30 = i4;
            int[] iArr10 = iArr5;
            int i31 = i;
            int i32 = i24;
            int i33 = 0;
            while (i33 < width) {
                iArr2[i12] = iArr6[i32];
                iArr3[i12] = iArr6[i15];
                iArr4[i12] = iArr6[i16];
                int i34 = i32 - i17;
                int i35 = i15 - i18;
                int i36 = i16 - i19;
                int[] iArr11 = iArr7[((i31 - i) + i5) % i5];
                int i37 = i17 - iArr11[0];
                int i38 = i18 - iArr11[1];
                int i39 = i19 - iArr11[2];
                if (i11 == 0) {
                    iArr10[i33] = Math.min(i33 + i + 1, i3);
                }
                int i40 = iArr[i13 + iArr10[i33]];
                int i41 = (i40 & 16711680) >> 16;
                iArr11[0] = i41;
                int i42 = (i40 & 65280) >> 8;
                iArr11[1] = i42;
                int i43 = i40 & 255;
                iArr11[2] = i43;
                int i44 = i20 + i41;
                int i45 = i21 + i42;
                int i46 = i22 + i43;
                i32 = i34 + i44;
                i15 = i35 + i45;
                i16 = i36 + i46;
                i31 = (i31 + 1) % i5;
                int[] iArr12 = iArr7[i31 % i5];
                int i47 = iArr12[0];
                i17 = i37 + i47;
                int i48 = iArr12[1];
                i18 = i38 + i48;
                int i49 = iArr12[2];
                i19 = i39 + i49;
                i20 = i44 - i47;
                i21 = i45 - i48;
                i22 = i46 - i49;
                i12++;
                i33++;
                iArr6 = iArr6;
            }
            i13 += width;
            i11++;
            bitmapCopy = bitmap;
            height = i14;
            i4 = i30;
            iArr5 = iArr10;
        }
        Bitmap bitmap2 = bitmapCopy;
        int i50 = i4;
        int[] iArr13 = iArr5;
        int i51 = height;
        int[] iArr14 = iArr6;
        int i52 = 0;
        while (i52 < width) {
            int i53 = -i;
            int i54 = i5;
            int[] iArr15 = iArr;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = i53;
            int i63 = i53 * width;
            int i64 = 0;
            int i65 = 0;
            while (i62 <= i) {
                int i66 = width;
                int iMax = Math.max(0, i63) + i52;
                int[] iArr16 = iArr7[i62 + i];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr4[iMax];
                int iAbs2 = i10 - Math.abs(i62);
                i64 += iArr2[iMax] * iAbs2;
                i65 += iArr3[iMax] * iAbs2;
                i55 += iArr4[iMax] * iAbs2;
                if (i62 > 0) {
                    i59 += iArr16[0];
                    i60 += iArr16[1];
                    i61 += iArr16[2];
                } else {
                    i56 += iArr16[0];
                    i57 += iArr16[1];
                    i58 += iArr16[2];
                }
                int i67 = i50;
                if (i62 < i67) {
                    i63 += i66;
                }
                i62++;
                i50 = i67;
                width = i66;
            }
            int i68 = width;
            int i69 = i50;
            int i70 = i;
            int i71 = i52;
            int i72 = i51;
            int i73 = 0;
            while (i73 < i72) {
                iArr15[i71] = (iArr15[i71] & (-16777216)) | (iArr14[i64] << 16) | (iArr14[i65] << 8) | iArr14[i55];
                int i74 = i64 - i56;
                int i75 = i65 - i57;
                int i76 = i55 - i58;
                int[] iArr17 = iArr7[((i70 - i) + i54) % i54];
                int i77 = i56 - iArr17[0];
                int i78 = i57 - iArr17[1];
                int i79 = i58 - iArr17[2];
                if (i52 == 0) {
                    iArr13[i73] = Math.min(i73 + i10, i69) * i68;
                }
                int i80 = iArr13[i73] + i52;
                int i81 = iArr2[i80];
                iArr17[0] = i81;
                int i82 = iArr3[i80];
                iArr17[1] = i82;
                int i83 = iArr4[i80];
                iArr17[2] = i83;
                int i84 = i59 + i81;
                int i85 = i60 + i82;
                int i86 = i61 + i83;
                i64 = i74 + i84;
                i65 = i75 + i85;
                i55 = i76 + i86;
                i70 = (i70 + 1) % i54;
                int[] iArr18 = iArr7[i70];
                int i87 = iArr18[0];
                i56 = i77 + i87;
                int i88 = iArr18[1];
                i57 = i78 + i88;
                int i89 = iArr18[2];
                i58 = i79 + i89;
                i59 = i84 - i87;
                i60 = i85 - i88;
                i61 = i86 - i89;
                i71 += i68;
                i73++;
                i = radius;
            }
            i52++;
            i = radius;
            i50 = i69;
            i51 = i72;
            i5 = i54;
            iArr = iArr15;
            width = i68;
        }
        int i90 = width;
        bitmap2.setPixels(iArr, 0, i90, 0, 0, i90, i51);
        return bitmap2;
    }
}
