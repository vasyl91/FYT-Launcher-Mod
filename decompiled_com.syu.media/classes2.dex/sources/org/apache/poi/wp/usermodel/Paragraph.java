package org.apache.poi.wp.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Paragraph {
    int getFirstLineIndent();

    int getFontAlignment();

    int getIndentFromLeft();

    int getIndentFromRight();

    boolean isWordWrapped();

    void setFirstLineIndent(int i);

    void setFontAlignment(int i);

    void setIndentFromLeft(int i);

    void setIndentFromRight(int i);

    void setWordWrapped(boolean z);
}
