package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFSheetConditionalFormatting implements SheetConditionalFormatting {
    private final ConditionalFormattingTable _conditionalFormattingTable;
    private final HSSFSheet _sheet;

    HSSFSheetConditionalFormatting(HSSFSheet hSSFSheet) {
        this._sheet = hSSFSheet;
        this._conditionalFormattingTable = hSSFSheet.getSheet().getConditionalFormattingTable();
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRuleRecord.create(this._sheet, b, str, str2));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRuleRecord.create(this._sheet, b, str, null));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(String str) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRuleRecord.create(this._sheet, str));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet iconSet) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRule12Record.create(this._sheet, iconSet));
    }

    public HSSFConditionalFormattingRule createConditionalFormattingRule(HSSFExtendedColor hSSFExtendedColor) {
        return new HSSFConditionalFormattingRule(this._sheet, CFRule12Record.create(this._sheet, hSSFExtendedColor.getExtendedColor()));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingRule(ExtendedColor extendedColor) {
        return createConditionalFormattingRule((HSSFExtendedColor) extendedColor);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormattingRule createConditionalFormattingColorScaleRule() {
        return new HSSFConditionalFormattingRule(this._sheet, CFRule12Record.createColorScale(this._sheet));
    }

    public int addConditionalFormatting(HSSFConditionalFormatting hSSFConditionalFormatting) {
        return this._conditionalFormattingTable.add(hSSFConditionalFormatting.getCFRecordsAggregate().cloneCFAggregate());
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(ConditionalFormatting conditionalFormatting) {
        return addConditionalFormatting((HSSFConditionalFormatting) conditionalFormatting);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("regions must not be null");
        }
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            cellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
        }
        if (hSSFConditionalFormattingRuleArr == null) {
            throw new IllegalArgumentException("cfRules must not be null");
        }
        if (hSSFConditionalFormattingRuleArr.length == 0) {
            throw new IllegalArgumentException("cfRules must not be empty");
        }
        if (hSSFConditionalFormattingRuleArr.length > 3) {
            throw new IllegalArgumentException("Number of rules must not exceed 3");
        }
        CFRuleBase[] cFRuleBaseArr = new CFRuleBase[hSSFConditionalFormattingRuleArr.length];
        for (int i = 0; i != hSSFConditionalFormattingRuleArr.length; i++) {
            cFRuleBaseArr[i] = hSSFConditionalFormattingRuleArr[i].getCfRuleRecord();
        }
        return this._conditionalFormattingTable.add(new CFRecordsAggregate(cellRangeAddressArr, cFRuleBaseArr));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule[] conditionalFormattingRuleArr) {
        HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr;
        if (conditionalFormattingRuleArr instanceof HSSFConditionalFormattingRule[]) {
            hSSFConditionalFormattingRuleArr = (HSSFConditionalFormattingRule[]) conditionalFormattingRuleArr;
        } else {
            int length = conditionalFormattingRuleArr.length;
            HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr2 = new HSSFConditionalFormattingRule[length];
            System.arraycopy(conditionalFormattingRuleArr, 0, hSSFConditionalFormattingRuleArr2, 0, length);
            hSSFConditionalFormattingRuleArr = hSSFConditionalFormattingRuleArr2;
        }
        return addConditionalFormatting(cellRangeAddressArr, hSSFConditionalFormattingRuleArr);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        return addConditionalFormatting(cellRangeAddressArr, hSSFConditionalFormattingRule == null ? null : new HSSFConditionalFormattingRule[]{hSSFConditionalFormattingRule});
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule) {
        return addConditionalFormatting(cellRangeAddressArr, (HSSFConditionalFormattingRule) conditionalFormattingRule);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule hSSFConditionalFormattingRule, HSSFConditionalFormattingRule hSSFConditionalFormattingRule2) {
        return addConditionalFormatting(cellRangeAddressArr, new HSSFConditionalFormattingRule[]{hSSFConditionalFormattingRule, hSSFConditionalFormattingRule2});
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule, ConditionalFormattingRule conditionalFormattingRule2) {
        return addConditionalFormatting(cellRangeAddressArr, (HSSFConditionalFormattingRule) conditionalFormattingRule, (HSSFConditionalFormattingRule) conditionalFormattingRule2);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormatting getConditionalFormattingAt(int i) {
        CFRecordsAggregate cFRecordsAggregate = this._conditionalFormattingTable.get(i);
        if (cFRecordsAggregate == null) {
            return null;
        }
        return new HSSFConditionalFormatting(this._sheet, cFRecordsAggregate);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int getNumConditionalFormattings() {
        return this._conditionalFormattingTable.size();
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public void removeConditionalFormatting(int i) {
        this._conditionalFormattingTable.remove(i);
    }
}
