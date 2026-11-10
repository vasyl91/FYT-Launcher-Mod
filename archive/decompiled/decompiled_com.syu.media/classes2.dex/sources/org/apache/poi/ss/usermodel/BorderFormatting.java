package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface BorderFormatting {
    short getBorderBottom();

    BorderStyle getBorderBottomEnum();

    short getBorderDiagonal();

    BorderStyle getBorderDiagonalEnum();

    BorderStyle getBorderHorizontalEnum();

    short getBorderLeft();

    BorderStyle getBorderLeftEnum();

    short getBorderRight();

    BorderStyle getBorderRightEnum();

    short getBorderTop();

    BorderStyle getBorderTopEnum();

    BorderStyle getBorderVerticalEnum();

    short getBottomBorderColor();

    Color getBottomBorderColorColor();

    short getDiagonalBorderColor();

    Color getDiagonalBorderColorColor();

    short getHorizontalBorderColor();

    Color getHorizontalBorderColorColor();

    short getLeftBorderColor();

    Color getLeftBorderColorColor();

    short getRightBorderColor();

    Color getRightBorderColorColor();

    short getTopBorderColor();

    Color getTopBorderColorColor();

    short getVerticalBorderColor();

    Color getVerticalBorderColorColor();

    void setBorderBottom(BorderStyle borderStyle);

    void setBorderBottom(short s);

    void setBorderDiagonal(BorderStyle borderStyle);

    void setBorderDiagonal(short s);

    void setBorderHorizontal(BorderStyle borderStyle);

    void setBorderLeft(BorderStyle borderStyle);

    void setBorderLeft(short s);

    void setBorderRight(BorderStyle borderStyle);

    void setBorderRight(short s);

    void setBorderTop(BorderStyle borderStyle);

    void setBorderTop(short s);

    void setBorderVertical(BorderStyle borderStyle);

    void setBottomBorderColor(Color color);

    void setBottomBorderColor(short s);

    void setDiagonalBorderColor(Color color);

    void setDiagonalBorderColor(short s);

    void setHorizontalBorderColor(Color color);

    void setHorizontalBorderColor(short s);

    void setLeftBorderColor(Color color);

    void setLeftBorderColor(short s);

    void setRightBorderColor(Color color);

    void setRightBorderColor(short s);

    void setTopBorderColor(Color color);

    void setTopBorderColor(short s);

    void setVerticalBorderColor(Color color);

    void setVerticalBorderColor(short s);
}
