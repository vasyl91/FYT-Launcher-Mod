package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface FontInfo {
    FontCharset getCharset();

    FontFamily getFamily();

    Integer getIndex();

    FontPitch getPitch();

    String getTypeface();

    void setCharset(FontCharset fontCharset);

    void setFamily(FontFamily fontFamily);

    void setIndex(int i);

    void setPitch(FontPitch fontPitch);

    void setTypeface(String str);
}
