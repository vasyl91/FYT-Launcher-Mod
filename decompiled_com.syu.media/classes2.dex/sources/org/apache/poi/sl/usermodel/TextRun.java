package org.apache.poi.sl.usermodel;

import java.awt.Color;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface TextRun {

    public enum FieldType {
        SLIDE_NUMBER,
        DATE_TIME
    }

    public enum TextCap {
        NONE,
        SMALL,
        ALL
    }

    Hyperlink<?, ?> createHyperlink();

    @Internal
    FieldType getFieldType();

    PaintStyle getFontColor();

    String getFontFamily();

    String getFontFamily(FontGroup fontGroup);

    FontInfo getFontInfo(FontGroup fontGroup);

    Double getFontSize();

    Hyperlink<?, ?> getHyperlink();

    byte getPitchAndFamily();

    String getRawText();

    TextCap getTextCap();

    boolean isBold();

    boolean isItalic();

    boolean isStrikethrough();

    boolean isSubscript();

    boolean isSuperscript();

    boolean isUnderlined();

    void setBold(boolean z);

    void setFontColor(Color color);

    void setFontColor(PaintStyle paintStyle);

    void setFontFamily(String str);

    void setFontFamily(String str, FontGroup fontGroup);

    void setFontInfo(FontInfo fontInfo, FontGroup fontGroup);

    void setFontSize(Double d);

    void setItalic(boolean z);

    void setStrikethrough(boolean z);

    void setText(String str);

    void setUnderlined(boolean z);
}
