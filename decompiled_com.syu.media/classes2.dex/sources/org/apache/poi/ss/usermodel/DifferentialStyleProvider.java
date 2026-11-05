package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface DifferentialStyleProvider {
    BorderFormatting getBorderFormatting();

    FontFormatting getFontFormatting();

    ExcelNumberFormat getNumberFormat();

    PatternFormatting getPatternFormatting();

    int getStripeSize();
}
