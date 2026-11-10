package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfvoType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFConditionalFormattingRule implements ConditionalFormattingRule {
    private final CTCfRule _cfRule;
    private XSSFSheet _sh;
    private static Map<STCfType.Enum, ConditionType> typeLookup = new HashMap();
    private static Map<STCfType.Enum, ConditionFilterType> filterTypeLookup = new HashMap();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return 0;
    }

    static {
        typeLookup.put(STCfType.CELL_IS, ConditionType.CELL_VALUE_IS);
        typeLookup.put(STCfType.EXPRESSION, ConditionType.FORMULA);
        typeLookup.put(STCfType.COLOR_SCALE, ConditionType.COLOR_SCALE);
        typeLookup.put(STCfType.DATA_BAR, ConditionType.DATA_BAR);
        typeLookup.put(STCfType.ICON_SET, ConditionType.ICON_SET);
        typeLookup.put(STCfType.TOP_10, ConditionType.FILTER);
        typeLookup.put(STCfType.UNIQUE_VALUES, ConditionType.FILTER);
        typeLookup.put(STCfType.DUPLICATE_VALUES, ConditionType.FILTER);
        typeLookup.put(STCfType.CONTAINS_TEXT, ConditionType.FILTER);
        typeLookup.put(STCfType.NOT_CONTAINS_TEXT, ConditionType.FILTER);
        typeLookup.put(STCfType.BEGINS_WITH, ConditionType.FILTER);
        typeLookup.put(STCfType.ENDS_WITH, ConditionType.FILTER);
        typeLookup.put(STCfType.CONTAINS_BLANKS, ConditionType.FILTER);
        typeLookup.put(STCfType.NOT_CONTAINS_BLANKS, ConditionType.FILTER);
        typeLookup.put(STCfType.CONTAINS_ERRORS, ConditionType.FILTER);
        typeLookup.put(STCfType.NOT_CONTAINS_ERRORS, ConditionType.FILTER);
        typeLookup.put(STCfType.TIME_PERIOD, ConditionType.FILTER);
        typeLookup.put(STCfType.ABOVE_AVERAGE, ConditionType.FILTER);
        filterTypeLookup.put(STCfType.TOP_10, ConditionFilterType.TOP_10);
        filterTypeLookup.put(STCfType.UNIQUE_VALUES, ConditionFilterType.UNIQUE_VALUES);
        filterTypeLookup.put(STCfType.DUPLICATE_VALUES, ConditionFilterType.DUPLICATE_VALUES);
        filterTypeLookup.put(STCfType.CONTAINS_TEXT, ConditionFilterType.CONTAINS_TEXT);
        filterTypeLookup.put(STCfType.NOT_CONTAINS_TEXT, ConditionFilterType.NOT_CONTAINS_TEXT);
        filterTypeLookup.put(STCfType.BEGINS_WITH, ConditionFilterType.BEGINS_WITH);
        filterTypeLookup.put(STCfType.ENDS_WITH, ConditionFilterType.ENDS_WITH);
        filterTypeLookup.put(STCfType.CONTAINS_BLANKS, ConditionFilterType.CONTAINS_BLANKS);
        filterTypeLookup.put(STCfType.NOT_CONTAINS_BLANKS, ConditionFilterType.NOT_CONTAINS_BLANKS);
        filterTypeLookup.put(STCfType.CONTAINS_ERRORS, ConditionFilterType.CONTAINS_ERRORS);
        filterTypeLookup.put(STCfType.NOT_CONTAINS_ERRORS, ConditionFilterType.NOT_CONTAINS_ERRORS);
        filterTypeLookup.put(STCfType.TIME_PERIOD, ConditionFilterType.TIME_PERIOD);
        filterTypeLookup.put(STCfType.ABOVE_AVERAGE, ConditionFilterType.ABOVE_AVERAGE);
    }

    XSSFConditionalFormattingRule(XSSFSheet xSSFSheet) {
        this._cfRule = CTCfRule.Factory.newInstance();
        this._sh = xSSFSheet;
    }

    XSSFConditionalFormattingRule(XSSFSheet xSSFSheet, CTCfRule cTCfRule) {
        this._cfRule = cTCfRule;
        this._sh = xSSFSheet;
    }

    CTCfRule getCTCfRule() {
        return this._cfRule;
    }

    CTDxf getDxf(boolean z) {
        StylesTable stylesSource = this._sh.getWorkbook().getStylesSource();
        CTDxf dxfAt = (stylesSource._getDXfsSize() <= 0 || !this._cfRule.isSetDxfId()) ? null : stylesSource.getDxfAt((int) this._cfRule.getDxfId());
        if (!z || dxfAt != null) {
            return dxfAt;
        }
        CTDxf cTDxfNewInstance = CTDxf.Factory.newInstance();
        this._cfRule.setDxfId(stylesSource.putDxf(cTDxfNewInstance) - 1);
        return cTDxfNewInstance;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public int getPriority() {
        int priority = this._cfRule.getPriority();
        if (priority >= 1) {
            return priority;
        }
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public boolean getStopIfTrue() {
        return this._cfRule.getStopIfTrue();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFBorderFormatting createBorderFormatting() {
        CTBorder border;
        CTDxf dxf = getDxf(true);
        if (!dxf.isSetBorder()) {
            border = dxf.addNewBorder();
        } else {
            border = dxf.getBorder();
        }
        return new XSSFBorderFormatting(border, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public XSSFBorderFormatting getBorderFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetBorder()) {
            return null;
        }
        return new XSSFBorderFormatting(dxf.getBorder(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFFontFormatting createFontFormatting() {
        CTFont font;
        CTDxf dxf = getDxf(true);
        if (!dxf.isSetFont()) {
            font = dxf.addNewFont();
        } else {
            font = dxf.getFont();
        }
        return new XSSFFontFormatting(font, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public XSSFFontFormatting getFontFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetFont()) {
            return null;
        }
        return new XSSFFontFormatting(dxf.getFont(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFPatternFormatting createPatternFormatting() {
        CTFill fill;
        CTDxf dxf = getDxf(true);
        if (!dxf.isSetFill()) {
            fill = dxf.addNewFill();
        } else {
            fill = dxf.getFill();
        }
        return new XSSFPatternFormatting(fill, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public XSSFPatternFormatting getPatternFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetFill()) {
            return null;
        }
        return new XSSFPatternFormatting(dxf.getFill(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    public XSSFDataBarFormatting createDataBarFormatting(XSSFColor xSSFColor) {
        CTDataBar cTDataBarAddNewDataBar;
        if (this._cfRule.isSetDataBar() && this._cfRule.getType() == STCfType.DATA_BAR) {
            return getDataBarFormatting();
        }
        this._cfRule.setType(STCfType.DATA_BAR);
        if (this._cfRule.isSetDataBar()) {
            cTDataBarAddNewDataBar = this._cfRule.getDataBar();
        } else {
            cTDataBarAddNewDataBar = this._cfRule.addNewDataBar();
        }
        cTDataBarAddNewDataBar.setColor(xSSFColor.getCTColor());
        cTDataBarAddNewDataBar.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MIN.name));
        cTDataBarAddNewDataBar.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MAX.name));
        return new XSSFDataBarFormatting(cTDataBarAddNewDataBar, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFDataBarFormatting getDataBarFormatting() {
        if (this._cfRule.isSetDataBar()) {
            return new XSSFDataBarFormatting(this._cfRule.getDataBar(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
        }
        return null;
    }

    public XSSFIconMultiStateFormatting createMultiStateFormatting(IconMultiStateFormatting.IconSet iconSet) {
        CTIconSet cTIconSetAddNewIconSet;
        if (this._cfRule.isSetIconSet() && this._cfRule.getType() == STCfType.ICON_SET) {
            return getMultiStateFormatting();
        }
        this._cfRule.setType(STCfType.ICON_SET);
        if (this._cfRule.isSetIconSet()) {
            cTIconSetAddNewIconSet = this._cfRule.getIconSet();
        } else {
            cTIconSetAddNewIconSet = this._cfRule.addNewIconSet();
        }
        if (iconSet.name != null) {
            cTIconSetAddNewIconSet.setIconSet(STIconSetType.Enum.forString(iconSet.name));
        }
        int i = 100 / iconSet.num;
        STCfvoType.Enum enumForString = STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.PERCENT.name);
        for (int i2 = 0; i2 < iconSet.num; i2++) {
            CTCfvo cTCfvoAddNewCfvo = cTIconSetAddNewIconSet.addNewCfvo();
            cTCfvoAddNewCfvo.setType(enumForString);
            cTCfvoAddNewCfvo.setVal(Integer.toString(i2 * i));
        }
        return new XSSFIconMultiStateFormatting(cTIconSetAddNewIconSet);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFIconMultiStateFormatting getMultiStateFormatting() {
        if (this._cfRule.isSetIconSet()) {
            return new XSSFIconMultiStateFormatting(this._cfRule.getIconSet());
        }
        return null;
    }

    public XSSFColorScaleFormatting createColorScaleFormatting() {
        CTColorScale cTColorScaleAddNewColorScale;
        if (this._cfRule.isSetColorScale() && this._cfRule.getType() == STCfType.COLOR_SCALE) {
            return getColorScaleFormatting();
        }
        this._cfRule.setType(STCfType.COLOR_SCALE);
        if (this._cfRule.isSetColorScale()) {
            cTColorScaleAddNewColorScale = this._cfRule.getColorScale();
        } else {
            cTColorScaleAddNewColorScale = this._cfRule.addNewColorScale();
        }
        if (cTColorScaleAddNewColorScale.sizeOfCfvoArray() == 0) {
            cTColorScaleAddNewColorScale.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MIN.name));
            CTCfvo cTCfvoAddNewCfvo = cTColorScaleAddNewColorScale.addNewCfvo();
            cTCfvoAddNewCfvo.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.PERCENTILE.name));
            cTCfvoAddNewCfvo.setVal("50");
            cTColorScaleAddNewColorScale.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MAX.name));
            for (int i = 0; i < 3; i++) {
                cTColorScaleAddNewColorScale.addNewColor();
            }
        }
        return new XSSFColorScaleFormatting(cTColorScaleAddNewColorScale, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFColorScaleFormatting getColorScaleFormatting() {
        if (this._cfRule.isSetColorScale()) {
            return new XSSFColorScaleFormatting(this._cfRule.getColorScale(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public ExcelNumberFormat getNumberFormat() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetNumFmt()) {
            return null;
        }
        CTNumFmt numFmt = dxf.getNumFmt();
        return new ExcelNumberFormat((int) numFmt.getNumFmtId(), numFmt.getFormatCode());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionType getConditionType() {
        return typeLookup.get(this._cfRule.getType());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterType getConditionFilterType() {
        return filterTypeLookup.get(this._cfRule.getType());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterData getFilterConfiguration() {
        return new XSSFConditionFilterData(this._cfRule);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getComparisonOperation() {
        STConditionalFormattingOperator.Enum operator = this._cfRule.getOperator();
        if (operator == null) {
            return (byte) 0;
        }
        switch (operator.intValue()) {
            case 1:
                return (byte) 6;
            case 2:
                return (byte) 8;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 4;
            case 5:
                return (byte) 7;
            case 6:
                return (byte) 5;
            case 7:
                return (byte) 1;
            case 8:
                return (byte) 2;
            default:
                return (byte) 0;
        }
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula1() {
        if (this._cfRule.sizeOfFormulaArray() > 0) {
            return this._cfRule.getFormulaArray(0);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula2() {
        if (this._cfRule.sizeOfFormulaArray() == 2) {
            return this._cfRule.getFormulaArray(1);
        }
        return null;
    }
}
