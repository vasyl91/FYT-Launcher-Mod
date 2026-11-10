package org.apache.poi.sl.draw;

import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class DrawFontInfo implements FontInfo {
    private final String typeface;

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public Integer getIndex() {
        return null;
    }

    DrawFontInfo(String str) {
        this.typeface = str;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setIndex(int i) {
        throw new UnsupportedOperationException("DrawFontManagers FontInfo can't be changed.");
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public String getTypeface() {
        return this.typeface;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setTypeface(String str) {
        throw new UnsupportedOperationException("DrawFontManagers FontInfo can't be changed.");
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontCharset getCharset() {
        return FontCharset.ANSI;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setCharset(FontCharset fontCharset) {
        throw new UnsupportedOperationException("DrawFontManagers FontInfo can't be changed.");
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontFamily getFamily() {
        return FontFamily.FF_SWISS;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setFamily(FontFamily fontFamily) {
        throw new UnsupportedOperationException("DrawFontManagers FontInfo can't be changed.");
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public FontPitch getPitch() {
        return FontPitch.VARIABLE;
    }

    @Override // org.apache.poi.common.usermodel.fonts.FontInfo
    public void setPitch(FontPitch fontPitch) {
        throw new UnsupportedOperationException("DrawFontManagers FontInfo can't be changed.");
    }
}
