package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SheetConditionalFormatting {
    int addConditionalFormatting(ConditionalFormatting conditionalFormatting);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule, ConditionalFormattingRule conditionalFormattingRule2);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule[] conditionalFormattingRuleArr);

    ConditionalFormattingRule createConditionalFormattingColorScaleRule();

    ConditionalFormattingRule createConditionalFormattingRule(byte b, String str);

    ConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2);

    ConditionalFormattingRule createConditionalFormattingRule(String str);

    ConditionalFormattingRule createConditionalFormattingRule(ExtendedColor extendedColor);

    ConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet iconSet);

    ConditionalFormatting getConditionalFormattingAt(int i);

    int getNumConditionalFormattings();

    void removeConditionalFormatting(int i);
}
