package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface DataBarFormatting {
    Color getColor();

    ConditionalFormattingThreshold getMaxThreshold();

    ConditionalFormattingThreshold getMinThreshold();

    int getWidthMax();

    int getWidthMin();

    boolean isIconOnly();

    boolean isLeftToRight();

    void setColor(Color color);

    void setIconOnly(boolean z);

    void setLeftToRight(boolean z);

    void setWidthMax(int i);

    void setWidthMin(int i);
}
