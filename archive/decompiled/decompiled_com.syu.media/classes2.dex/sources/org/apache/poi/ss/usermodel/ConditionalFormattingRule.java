package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ConditionalFormattingRule extends DifferentialStyleProvider {
    BorderFormatting createBorderFormatting();

    FontFormatting createFontFormatting();

    PatternFormatting createPatternFormatting();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    BorderFormatting getBorderFormatting();

    ColorScaleFormatting getColorScaleFormatting();

    byte getComparisonOperation();

    ConditionFilterType getConditionFilterType();

    ConditionType getConditionType();

    DataBarFormatting getDataBarFormatting();

    ConditionFilterData getFilterConfiguration();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    FontFormatting getFontFormatting();

    String getFormula1();

    String getFormula2();

    IconMultiStateFormatting getMultiStateFormatting();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    ExcelNumberFormat getNumberFormat();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    PatternFormatting getPatternFormatting();

    int getPriority();

    boolean getStopIfTrue();
}
