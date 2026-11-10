package org.apache.poi.wp.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface CharacterRun {
    int getCharacterSpacing();

    String getFontName();

    int getFontSize();

    int getKerning();

    boolean isBold();

    boolean isCapitalized();

    boolean isDoubleStrikeThrough();

    boolean isEmbossed();

    boolean isHighlighted();

    boolean isImprinted();

    boolean isItalic();

    boolean isShadowed();

    boolean isSmallCaps();

    boolean isStrikeThrough();

    void setBold(boolean z);

    void setCapitalized(boolean z);

    void setCharacterSpacing(int i);

    void setDoubleStrikethrough(boolean z);

    void setEmbossed(boolean z);

    void setFontSize(int i);

    void setImprinted(boolean z);

    void setItalic(boolean z);

    void setKerning(int i);

    void setShadow(boolean z);

    void setSmallCaps(boolean z);

    void setStrikeThrough(boolean z);

    String text();
}
