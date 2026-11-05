package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ConditionalFormatting {
    void addRule(ConditionalFormattingRule conditionalFormattingRule);

    CellRangeAddress[] getFormattingRanges();

    int getNumberOfRules();

    ConditionalFormattingRule getRule(int i);

    void setFormattingRanges(CellRangeAddress[] cellRangeAddressArr);

    void setRule(int i, ConditionalFormattingRule conditionalFormattingRule);
}
