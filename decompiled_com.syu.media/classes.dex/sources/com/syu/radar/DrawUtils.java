package com.syu.radar;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DrawUtils {
    public int blendj(int i, int i2, int i3, int i4) {
        int i5 = (int) ((i3 * 256) / i4);
        int i6 = 255 - i5;
        return (((((i & 255) * i6) + ((i2 & 255) * i5)) / 256) & 255) | (((((((i >> 24) & 255) * i6) + (((i2 >> 24) & 255) * i5)) / 256) & 255) << 24) | (((((((i >> 16) & 255) * i6) + (((i2 >> 16) & 255) * i5)) / 256) & 255) << 16) | (((((((i >> 8) & 255) * i6) + (((i2 >> 8) & 255) * i5)) / 256) & 255) << 8);
    }
}
