package org.apache.poi.sl.draw;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Map;
import org.apache.poi.common.usermodel.fonts.FontInfo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawFontManagerDefault implements DrawFontManager {
    @Override // org.apache.poi.sl.draw.DrawFontManager
    public FontInfo getMappedFont(Graphics2D graphics2D, FontInfo fontInfo) {
        return getFontWithFallback(graphics2D, Drawable.FONT_MAP, fontInfo);
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public FontInfo getFallbackFont(Graphics2D graphics2D, FontInfo fontInfo) {
        FontInfo fontWithFallback = getFontWithFallback(graphics2D, Drawable.FONT_FALLBACK, fontInfo);
        return fontWithFallback == null ? new DrawFontInfo("SansSerif") : fontWithFallback;
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public String mapFontCharset(Graphics2D graphics2D, FontInfo fontInfo, String str) {
        if (fontInfo == null || !"Wingdings".equalsIgnoreCase(fontInfo.getTypeface())) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ((' ' <= c && c <= 127) || (160 <= c && c <= 255)) {
                charArray[i] = (char) (61440 | c);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    @Override // org.apache.poi.sl.draw.DrawFontManager
    public Font createAWTFont(Graphics2D graphics2D, FontInfo fontInfo, double d, boolean z, boolean z2) {
        int i = (z2 ? 2 : 0) | (z ? 1 : 0);
        Font font = new Font(fontInfo.getTypeface(), i, 12);
        if ("Dialog".equals(font.getFamily())) {
            font = new Font("SansSerif", i, 12);
        }
        return font.deriveFont((float) d);
    }

    private FontInfo getFontWithFallback(Graphics2D graphics2D, Drawable.DrawableHint drawableHint, FontInfo fontInfo) {
        Map map = (Map) graphics2D.getRenderingHint(drawableHint);
        if (map == null) {
            return fontInfo;
        }
        String str = null;
        String typeface = fontInfo != null ? fontInfo.getTypeface() : null;
        if (map.containsKey(typeface)) {
            str = (String) map.get(typeface);
        } else if (map.containsKey("*")) {
            str = (String) map.get("*");
        }
        return str != null ? new DrawFontInfo(str) : fontInfo;
    }
}
