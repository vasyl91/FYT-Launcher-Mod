package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeUtil;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFSheetConditionalFormatting implements SheetConditionalFormatting {
    protected static final String CF_EXT_2009_NS_X14 = "http://schemas.microsoft.com/office/spreadsheetml/2009/9/main";
    private final XSSFSheet _sheet;

    XSSFSheetConditionalFormatting(XSSFSheet xSSFSheet) {
        this._sheet = xSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2) {
        STConditionalFormattingOperator.Enum r3;
        XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
        CTCfRule cTCfRule = xSSFConditionalFormattingRule.getCTCfRule();
        cTCfRule.addFormula(str);
        if (str2 != null) {
            cTCfRule.addFormula(str2);
        }
        cTCfRule.setType(STCfType.CELL_IS);
        switch (b) {
            case 1:
                r3 = STConditionalFormattingOperator.BETWEEN;
                break;
            case 2:
                r3 = STConditionalFormattingOperator.NOT_BETWEEN;
                break;
            case 3:
                r3 = STConditionalFormattingOperator.EQUAL;
                break;
            case 4:
                r3 = STConditionalFormattingOperator.NOT_EQUAL;
                break;
            case 5:
                r3 = STConditionalFormattingOperator.GREATER_THAN;
                break;
            case 6:
                r3 = STConditionalFormattingOperator.LESS_THAN;
                break;
            case 7:
                r3 = STConditionalFormattingOperator.GREATER_THAN_OR_EQUAL;
                break;
            case 8:
                r3 = STConditionalFormattingOperator.LESS_THAN_OR_EQUAL;
                break;
            default:
                throw new IllegalArgumentException("Unknown comparison operator: " + ((int) b));
        }
        cTCfRule.setOperator(r3);
        return xSSFConditionalFormattingRule;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str) {
        return createConditionalFormattingRule(b, str, (String) null);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormattingRule createConditionalFormattingRule(String str) {
        XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
        CTCfRule cTCfRule = xSSFConditionalFormattingRule.getCTCfRule();
        cTCfRule.addFormula(str);
        cTCfRule.setType(STCfType.EXPRESSION);
        return xSSFConditionalFormattingRule;
    }

    public XSSFConditionalFormattingRule createConditionalFormattingRule(XSSFColor xSSFColor) {
        XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
        xSSFConditionalFormattingRule.createDataBarFormatting(xSSFColor);
        return xSSFConditionalFormattingRule;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormattingRule createConditionalFormattingRule(ExtendedColor extendedColor) {
        return createConditionalFormattingRule((XSSFColor) extendedColor);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet iconSet) {
        XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
        xSSFConditionalFormattingRule.createMultiStateFormatting(iconSet);
        return xSSFConditionalFormattingRule;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormattingRule createConditionalFormattingColorScaleRule() {
        XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
        xSSFConditionalFormattingRule.createColorScaleFormatting();
        return xSSFConditionalFormattingRule;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule[] conditionalFormattingRuleArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("regions must not be null");
        }
        int i = 0;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
        }
        if (conditionalFormattingRuleArr == null) {
            throw new IllegalArgumentException("cfRules must not be null");
        }
        if (conditionalFormattingRuleArr.length == 0) {
            throw new IllegalArgumentException("cfRules must not be empty");
        }
        if (conditionalFormattingRuleArr.length > 3) {
            throw new IllegalArgumentException("Number of rules must not exceed 3");
        }
        CellRangeAddress[] cellRangeAddressArrMergeCellRanges = CellRangeUtil.mergeCellRanges(cellRangeAddressArr);
        CTConditionalFormatting cTConditionalFormattingAddNewConditionalFormatting = this._sheet.getCTWorksheet().addNewConditionalFormatting();
        ArrayList arrayList = new ArrayList();
        for (CellRangeAddress cellRangeAddress2 : cellRangeAddressArrMergeCellRanges) {
            arrayList.add(cellRangeAddress2.formatAsString());
        }
        cTConditionalFormattingAddNewConditionalFormatting.setSqref(arrayList);
        int iSizeOfCfRuleArray = 1;
        for (CTConditionalFormatting cTConditionalFormatting : this._sheet.getCTWorksheet().getConditionalFormattingArray()) {
            iSizeOfCfRuleArray += cTConditionalFormatting.sizeOfCfRuleArray();
        }
        int length = conditionalFormattingRuleArr.length;
        while (i < length) {
            XSSFConditionalFormattingRule xSSFConditionalFormattingRule = (XSSFConditionalFormattingRule) conditionalFormattingRuleArr[i];
            xSSFConditionalFormattingRule.getCTCfRule().setPriority(iSizeOfCfRuleArray);
            cTConditionalFormattingAddNewConditionalFormatting.addNewCfRule().set(xSSFConditionalFormattingRule.getCTCfRule());
            i++;
            iSizeOfCfRuleArray++;
        }
        return this._sheet.getCTWorksheet().sizeOfConditionalFormattingArray() - 1;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule) {
        return addConditionalFormatting(cellRangeAddressArr, conditionalFormattingRule == null ? null : new XSSFConditionalFormattingRule[]{(XSSFConditionalFormattingRule) conditionalFormattingRule});
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule, ConditionalFormattingRule conditionalFormattingRule2) {
        return addConditionalFormatting(cellRangeAddressArr, conditionalFormattingRule == null ? null : new XSSFConditionalFormattingRule[]{(XSSFConditionalFormattingRule) conditionalFormattingRule, (XSSFConditionalFormattingRule) conditionalFormattingRule2});
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int addConditionalFormatting(ConditionalFormatting conditionalFormatting) {
        CTWorksheet cTWorksheet = this._sheet.getCTWorksheet();
        cTWorksheet.addNewConditionalFormatting().set(((XSSFConditionalFormatting) conditionalFormatting).getCTConditionalFormatting().copy());
        return cTWorksheet.sizeOfConditionalFormattingArray() - 1;
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormatting getConditionalFormattingAt(int i) {
        checkIndex(i);
        return new XSSFConditionalFormatting(this._sheet, this._sheet.getCTWorksheet().getConditionalFormattingArray(i));
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int getNumConditionalFormattings() {
        return this._sheet.getCTWorksheet().sizeOfConditionalFormattingArray();
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public void removeConditionalFormatting(int i) {
        checkIndex(i);
        this._sheet.getCTWorksheet().removeConditionalFormatting(i);
    }

    private void checkIndex(int i) {
        int numConditionalFormattings = getNumConditionalFormattings();
        if (i < 0 || i >= numConditionalFormattings) {
            throw new IllegalArgumentException("Specified CF index " + i + " is outside the allowable range (0.." + (numConditionalFormattings - 1) + ")");
        }
    }
}
