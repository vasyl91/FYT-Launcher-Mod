package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ColorScaleFormatting {
    ConditionalFormattingThreshold createThreshold();

    Color[] getColors();

    int getNumControlPoints();

    ConditionalFormattingThreshold[] getThresholds();

    void setColors(Color[] colorArr);

    void setNumControlPoints(int i);

    void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr);
}
