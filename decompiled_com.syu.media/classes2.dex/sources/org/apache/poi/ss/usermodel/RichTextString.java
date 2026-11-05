package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface RichTextString {
    void applyFont(int i, int i2, Font font);

    void applyFont(int i, int i2, short s);

    void applyFont(Font font);

    void applyFont(short s);

    void clearFormatting();

    int getIndexOfFormattingRun(int i);

    String getString();

    int length();

    int numFormattingRuns();
}
