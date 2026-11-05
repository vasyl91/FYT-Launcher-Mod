package org.apache.poi.xssf.usermodel;

import java.lang.reflect.Array;
import java.util.List;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CustomIndexedColorMap implements IndexedColorMap {
    private final byte[][] colorIndex;

    private CustomIndexedColorMap(byte[][] bArr) {
        this.colorIndex = bArr;
    }

    @Override // org.apache.poi.xssf.usermodel.IndexedColorMap
    public byte[] getRGB(int i) {
        byte[][] bArr = this.colorIndex;
        if (bArr == null || i < 0 || i >= bArr.length) {
            return null;
        }
        return bArr[i];
    }

    public static CustomIndexedColorMap fromColors(CTColors cTColors) {
        if (cTColors == null || !cTColors.isSetIndexedColors()) {
            return null;
        }
        List rgbColorList = cTColors.getIndexedColors().getRgbColorList();
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, rgbColorList.size(), 3);
        for (int i = 0; i < rgbColorList.size(); i++) {
            bArr[i] = ((CTRgbColor) rgbColorList.get(i)).getRgb();
        }
        return new CustomIndexedColorMap(bArr);
    }
}
