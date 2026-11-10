package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum FontPitch {
    DEFAULT(0),
    FIXED(1),
    VARIABLE(2);

    private int nativeId;

    FontPitch(int i) {
        this.nativeId = i;
    }

    public int getNativeId() {
        return this.nativeId;
    }

    public static FontPitch valueOf(int i) {
        for (FontPitch fontPitch : values()) {
            if (fontPitch.nativeId == i) {
                return fontPitch;
            }
        }
        return null;
    }

    public static byte getNativeId(FontPitch fontPitch, FontFamily fontFamily) {
        return (byte) (fontPitch.getNativeId() | (fontFamily.getFlag() << 4));
    }

    public static FontPitch valueOfPitchFamily(byte b) {
        return valueOf(b & 3);
    }
}
