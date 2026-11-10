package org.apache.poi.xssf.usermodel;

import org.apache.poi.hssf.util.HSSFColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultIndexedColorMap implements IndexedColorMap {
    @Override // org.apache.poi.xssf.usermodel.IndexedColorMap
    public byte[] getRGB(int i) {
        return getDefaultRGB(i);
    }

    public static byte[] getDefaultRGB(int i) {
        HSSFColor hSSFColor = HSSFColor.getIndexHash().get(Integer.valueOf(i));
        if (hSSFColor == null) {
            return null;
        }
        short[] triplet = hSSFColor.getTriplet();
        return new byte[]{(byte) triplet[0], (byte) triplet[1], (byte) triplet[2]};
    }
}
