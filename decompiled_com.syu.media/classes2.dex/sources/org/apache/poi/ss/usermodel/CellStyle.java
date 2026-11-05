package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface CellStyle {
    void cloneStyleFrom(CellStyle cellStyle);

    short getAlignment();

    HorizontalAlignment getAlignmentEnum();

    short getBorderBottom();

    BorderStyle getBorderBottomEnum();

    short getBorderLeft();

    BorderStyle getBorderLeftEnum();

    short getBorderRight();

    BorderStyle getBorderRightEnum();

    short getBorderTop();

    BorderStyle getBorderTopEnum();

    short getBottomBorderColor();

    short getDataFormat();

    String getDataFormatString();

    short getFillBackgroundColor();

    Color getFillBackgroundColorColor();

    short getFillForegroundColor();

    Color getFillForegroundColorColor();

    short getFillPattern();

    FillPatternType getFillPatternEnum();

    short getFontIndex();

    boolean getHidden();

    short getIndention();

    short getIndex();

    short getLeftBorderColor();

    boolean getLocked();

    boolean getQuotePrefixed();

    short getRightBorderColor();

    short getRotation();

    boolean getShrinkToFit();

    short getTopBorderColor();

    short getVerticalAlignment();

    VerticalAlignment getVerticalAlignmentEnum();

    boolean getWrapText();

    void setAlignment(HorizontalAlignment horizontalAlignment);

    void setBorderBottom(BorderStyle borderStyle);

    void setBorderLeft(BorderStyle borderStyle);

    void setBorderRight(BorderStyle borderStyle);

    void setBorderTop(BorderStyle borderStyle);

    void setBottomBorderColor(short s);

    void setDataFormat(short s);

    void setFillBackgroundColor(short s);

    void setFillForegroundColor(short s);

    void setFillPattern(FillPatternType fillPatternType);

    void setFont(Font font);

    void setHidden(boolean z);

    void setIndention(short s);

    void setLeftBorderColor(short s);

    void setLocked(boolean z);

    void setQuotePrefixed(boolean z);

    void setRightBorderColor(short s);

    void setRotation(short s);

    void setShrinkToFit(boolean z);

    void setTopBorderColor(short s);

    void setVerticalAlignment(VerticalAlignment verticalAlignment);

    void setWrapText(boolean z);
}
