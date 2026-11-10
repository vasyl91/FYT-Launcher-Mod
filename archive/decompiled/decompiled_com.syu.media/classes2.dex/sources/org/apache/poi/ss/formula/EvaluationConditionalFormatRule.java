package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EvaluationConditionalFormatRule implements Comparable<EvaluationConditionalFormatRule> {
    private final ConditionalFormatting formatting;
    private final int formattingIndex;
    private final String formula1;
    private final String formula2;
    private final Map<CellRangeAddress, Set<ValueAndFormat>> meaningfulRegionValues = new HashMap();
    private final ExcelNumberFormat numberFormat;
    private final OperatorEnum operator;
    private final int priority;
    private final CellRangeAddress[] regions;
    private final ConditionalFormattingRule rule;
    private final int ruleIndex;
    private final Sheet sheet;
    private final ConditionType type;
    private final WorkbookEvaluator workbookEvaluator;

    public enum OperatorEnum {
        NO_COMPARISON { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.1
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return false;
            }
        },
        BETWEEN { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.2
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return c.compareTo(c2) >= 0 && c.compareTo(c3) <= 0;
            }
        },
        NOT_BETWEEN { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.3
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return c.compareTo(c2) < 0 || c.compareTo(c3) > 0;
            }
        },
        EQUAL { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.4
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                if (c.getClass() == String.class) {
                    return c.toString().compareToIgnoreCase(c2.toString()) == 0;
                }
                return c.compareTo(c2) == 0;
            }
        },
        NOT_EQUAL { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.5
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                if (c.getClass() == String.class) {
                    return c.toString().compareToIgnoreCase(c2.toString()) == 0;
                }
                return c.compareTo(c2) != 0;
            }
        },
        GREATER_THAN { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.6
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return c.compareTo(c2) > 0;
            }
        },
        LESS_THAN { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.7
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return c.compareTo(c2) < 0;
            }
        },
        GREATER_OR_EQUAL { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.8
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return c.compareTo(c2) >= 0;
            }
        },
        LESS_OR_EQUAL { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum.9
            @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.OperatorEnum
            public <C extends Comparable<C>> boolean isValid(C c, C c2, C c3) {
                return c.compareTo(c2) <= 0;
            }
        };

        public abstract <C extends Comparable<C>> boolean isValid(C c, C c2, C c3);
    }

    protected interface ValueFunction {
        Set<ValueAndFormat> evaluate(List<ValueAndFormat> list);
    }

    public EvaluationConditionalFormatRule(WorkbookEvaluator workbookEvaluator, Sheet sheet, ConditionalFormatting conditionalFormatting, int i, ConditionalFormattingRule conditionalFormattingRule, int i2, CellRangeAddress[] cellRangeAddressArr) {
        this.workbookEvaluator = workbookEvaluator;
        this.sheet = sheet;
        this.formatting = conditionalFormatting;
        this.rule = conditionalFormattingRule;
        this.formattingIndex = i;
        this.ruleIndex = i2;
        this.priority = conditionalFormattingRule.getPriority();
        this.regions = cellRangeAddressArr;
        this.formula1 = conditionalFormattingRule.getFormula1();
        this.formula2 = conditionalFormattingRule.getFormula2();
        this.numberFormat = conditionalFormattingRule.getNumberFormat();
        this.operator = OperatorEnum.values()[conditionalFormattingRule.getComparisonOperation()];
        this.type = conditionalFormattingRule.getConditionType();
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    public ConditionalFormatting getFormatting() {
        return this.formatting;
    }

    public int getFormattingIndex() {
        return this.formattingIndex;
    }

    public ExcelNumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    public ConditionalFormattingRule getRule() {
        return this.rule;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public CellRangeAddress[] getRegions() {
        return this.regions;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getFormula1() {
        return this.formula1;
    }

    public String getFormula2() {
        return this.formula2;
    }

    public OperatorEnum getOperator() {
        return this.operator;
    }

    public ConditionType getType() {
        return this.type;
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        EvaluationConditionalFormatRule evaluationConditionalFormatRule = (EvaluationConditionalFormatRule) obj;
        return getSheet().getSheetName().equalsIgnoreCase(evaluationConditionalFormatRule.getSheet().getSheetName()) && getFormattingIndex() == evaluationConditionalFormatRule.getFormattingIndex() && getRuleIndex() == evaluationConditionalFormatRule.getRuleIndex();
    }

    @Override // java.lang.Comparable
    public int compareTo(EvaluationConditionalFormatRule evaluationConditionalFormatRule) {
        int i;
        int iCompareToIgnoreCase = getSheet().getSheetName().compareToIgnoreCase(evaluationConditionalFormatRule.getSheet().getSheetName());
        if (iCompareToIgnoreCase != 0) {
            return iCompareToIgnoreCase;
        }
        int priority = getPriority();
        int priority2 = evaluationConditionalFormatRule.getPriority();
        if (priority < priority2) {
            i = -1;
        } else {
            i = priority == priority2 ? 0 : 1;
        }
        if (i != 0) {
            return i;
        }
        int iCompareTo = new Integer(getFormattingIndex()).compareTo(new Integer(evaluationConditionalFormatRule.getFormattingIndex()));
        return iCompareTo != 0 ? iCompareTo : new Integer(getRuleIndex()).compareTo(new Integer(evaluationConditionalFormatRule.getRuleIndex()));
    }

    public int hashCode() {
        return (((this.sheet.getSheetName().hashCode() * 31) + this.formattingIndex) * 31) + this.ruleIndex;
    }

    boolean matches(CellReference cellReference) {
        CellRangeAddress cellRangeAddress;
        CellRangeAddress[] cellRangeAddressArr = this.regions;
        int length = cellRangeAddressArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                cellRangeAddress = null;
                break;
            }
            cellRangeAddress = cellRangeAddressArr[i];
            if (cellRangeAddress.isInRange(cellReference)) {
                break;
            }
            i++;
        }
        if (cellRangeAddress == null) {
            return false;
        }
        ConditionType conditionType = getRule().getConditionType();
        if (conditionType.equals(ConditionType.COLOR_SCALE) || conditionType.equals(ConditionType.DATA_BAR) || conditionType.equals(ConditionType.ICON_SET)) {
            return true;
        }
        Row row = this.sheet.getRow(cellReference.getRow());
        Cell cell = row != null ? row.getCell(cellReference.getCol()) : null;
        if (conditionType.equals(ConditionType.CELL_VALUE_IS)) {
            if (cell == null) {
                return false;
            }
            return checkValue(cell, cellRangeAddress);
        }
        if (conditionType.equals(ConditionType.FORMULA)) {
            return checkFormula(cellReference, cellRangeAddress);
        }
        if (conditionType.equals(ConditionType.FILTER)) {
            return checkFilter(cell, cellReference, cellRangeAddress);
        }
        return false;
    }

    private boolean checkValue(Cell cell, CellRangeAddress cellRangeAddress) {
        if (cell != null && !DataValidationEvaluator.isType(cell, CellType.BLANK) && !DataValidationEvaluator.isType(cell, CellType.ERROR) && (!DataValidationEvaluator.isType(cell, CellType.STRING) || (cell.getStringCellValue() != null && !cell.getStringCellValue().isEmpty()))) {
            ValueEval valueEvalUnwrapEval = unwrapEval(this.workbookEvaluator.evaluate(this.rule.getFormula1(), ConditionalFormattingEvaluator.getRef(cell), cellRangeAddress));
            String formula2 = this.rule.getFormula2();
            ValueEval valueEvalUnwrapEval2 = (formula2 == null || formula2.length() <= 0) ? null : unwrapEval(this.workbookEvaluator.evaluate(formula2, ConditionalFormattingEvaluator.getRef(cell), cellRangeAddress));
            if (DataValidationEvaluator.isType(cell, CellType.BOOLEAN)) {
                if ((valueEvalUnwrapEval instanceof BoolEval) && (valueEvalUnwrapEval2 == null || (valueEvalUnwrapEval2 instanceof BoolEval))) {
                    return this.operator.isValid(Boolean.valueOf(cell.getBooleanCellValue()), Boolean.valueOf(((BoolEval) valueEvalUnwrapEval).getBooleanValue()), valueEvalUnwrapEval2 != null ? Boolean.valueOf(((BoolEval) valueEvalUnwrapEval2).getBooleanValue()) : null);
                }
                return false;
            }
            if (DataValidationEvaluator.isType(cell, CellType.NUMERIC)) {
                if ((valueEvalUnwrapEval instanceof NumberEval) && (valueEvalUnwrapEval2 == null || (valueEvalUnwrapEval2 instanceof NumberEval))) {
                    return this.operator.isValid(Double.valueOf(cell.getNumericCellValue()), Double.valueOf(((NumberEval) valueEvalUnwrapEval).getNumberValue()), valueEvalUnwrapEval2 != null ? Double.valueOf(((NumberEval) valueEvalUnwrapEval2).getNumberValue()) : null);
                }
                return false;
            }
            if (DataValidationEvaluator.isType(cell, CellType.STRING) && (valueEvalUnwrapEval instanceof StringEval) && (valueEvalUnwrapEval2 == null || (valueEvalUnwrapEval2 instanceof StringEval))) {
                return this.operator.isValid(cell.getStringCellValue(), ((StringEval) valueEvalUnwrapEval).getStringValue(), valueEvalUnwrapEval2 != null ? ((StringEval) valueEvalUnwrapEval2).getStringValue() : null);
            }
        }
        return false;
    }

    private ValueEval unwrapEval(ValueEval valueEval) {
        while (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
        }
        return valueEval;
    }

    private boolean checkFormula(CellReference cellReference, CellRangeAddress cellRangeAddress) {
        ValueEval valueEvalUnwrapEval = unwrapEval(this.workbookEvaluator.evaluate(this.rule.getFormula1(), cellReference, cellRangeAddress));
        if (valueEvalUnwrapEval instanceof BlankEval) {
            return true;
        }
        if (valueEvalUnwrapEval instanceof ErrorEval) {
            return false;
        }
        if (valueEvalUnwrapEval instanceof BoolEval) {
            return ((BoolEval) valueEvalUnwrapEval).getBooleanValue();
        }
        return (valueEvalUnwrapEval instanceof NumberEval) && ((NumberEval) valueEvalUnwrapEval).getNumberValue() != 0.0d;
    }

    private boolean checkFilter(Cell cell, CellReference cellReference, CellRangeAddress cellRangeAddress) {
        OperatorEnum operatorEnum;
        ConditionFilterType conditionFilterType = this.rule.getConditionFilterType();
        if (conditionFilterType == null) {
            return false;
        }
        ValueAndFormat cellValue = getCellValue(cell);
        switch (conditionFilterType) {
            case TOP_10:
                if (cellValue.isNumber()) {
                    return getMeaningfulValues(cellRangeAddress, false, new ValueFunction() { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.1
                        @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.ValueFunction
                        public Set<ValueAndFormat> evaluate(List<ValueAndFormat> list) {
                            ConditionFilterData filterConfiguration = EvaluationConditionalFormatRule.this.rule.getFilterConfiguration();
                            if (!filterConfiguration.getBottom()) {
                                Collections.sort(list, Collections.reverseOrder());
                            } else {
                                Collections.sort(list);
                            }
                            int rank = (int) filterConfiguration.getRank();
                            if (filterConfiguration.getPercent()) {
                                rank = (list.size() * rank) / 100;
                            }
                            if (list.size() <= rank) {
                                return new HashSet(list);
                            }
                            return new HashSet(list.subList(0, rank));
                        }
                    }).contains(cellValue);
                }
                return false;
            case UNIQUE_VALUES:
                return getMeaningfulValues(cellRangeAddress, true, new ValueFunction() { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.2
                    @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.ValueFunction
                    public Set<ValueAndFormat> evaluate(List<ValueAndFormat> list) {
                        Collections.sort(list);
                        HashSet hashSet = new HashSet();
                        int i = 0;
                        while (i < list.size()) {
                            ValueAndFormat valueAndFormat = list.get(i);
                            if ((i >= list.size() - 1 || !valueAndFormat.equals(list.get(i + 1))) && !(i > 0 && i == list.size() - 1 && valueAndFormat.equals(list.get(i - 1)))) {
                                hashSet.add(valueAndFormat);
                            } else {
                                i++;
                            }
                            i++;
                        }
                        return hashSet;
                    }
                }).contains(cellValue);
            case DUPLICATE_VALUES:
                return getMeaningfulValues(cellRangeAddress, true, new ValueFunction() { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.3
                    @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.ValueFunction
                    public Set<ValueAndFormat> evaluate(List<ValueAndFormat> list) {
                        Collections.sort(list);
                        HashSet hashSet = new HashSet();
                        int i = 0;
                        while (i < list.size()) {
                            ValueAndFormat valueAndFormat = list.get(i);
                            if ((i < list.size() - 1 && valueAndFormat.equals(list.get(i + 1))) || (i > 0 && i == list.size() - 1 && valueAndFormat.equals(list.get(i - 1)))) {
                                hashSet.add(valueAndFormat);
                                i++;
                            }
                            i++;
                        }
                        return hashSet;
                    }
                }).contains(cellValue);
            case ABOVE_AVERAGE:
                ConditionFilterData filterConfiguration = this.rule.getFilterConfiguration();
                ArrayList arrayList = new ArrayList(getMeaningfulValues(cellRangeAddress, false, new ValueFunction() { // from class: org.apache.poi.ss.formula.EvaluationConditionalFormatRule.4
                    @Override // org.apache.poi.ss.formula.EvaluationConditionalFormatRule.ValueFunction
                    public Set<ValueAndFormat> evaluate(List<ValueAndFormat> list) {
                        ValueEval[] valueEvalArr = new ValueEval[list.size()];
                        double dDoubleValue = 0.0d;
                        for (int i = 0; i < list.size(); i++) {
                            ValueAndFormat valueAndFormat = list.get(i);
                            dDoubleValue += valueAndFormat.value.doubleValue();
                            valueEvalArr[i] = new NumberEval(valueAndFormat.value.doubleValue());
                        }
                        LinkedHashSet linkedHashSet = new LinkedHashSet(1);
                        linkedHashSet.add(new ValueAndFormat(new Double(list.size() == 0 ? 0.0d : dDoubleValue / ((double) list.size())), (String) null));
                        linkedHashSet.add(new ValueAndFormat(new Double(list.size() > 1 ? ((NumberEval) AggregateFunction.STDEV.evaluate(valueEvalArr, 0, 0)).getNumberValue() : 0.0d), (String) null));
                        return linkedHashSet;
                    }
                }));
                Double value = cellValue.isNumber() ? cellValue.getValue() : null;
                if (value == null) {
                    return false;
                }
                double dDoubleValue = ((ValueAndFormat) arrayList.get(0)).value.doubleValue();
                double dDoubleValue2 = ((ValueAndFormat) arrayList.get(1)).value.doubleValue();
                if (filterConfiguration.getStdDev() > 0) {
                    dDoubleValue += ((double) (filterConfiguration.getAboveAverage() ? 1 : -1)) * dDoubleValue2 * ((double) filterConfiguration.getStdDev());
                }
                Double d = new Double(dDoubleValue);
                if (filterConfiguration.getAboveAverage()) {
                    if (filterConfiguration.getEqualAverage()) {
                        operatorEnum = OperatorEnum.GREATER_OR_EQUAL;
                    } else {
                        operatorEnum = OperatorEnum.GREATER_THAN;
                    }
                } else if (filterConfiguration.getEqualAverage()) {
                    operatorEnum = OperatorEnum.LESS_OR_EQUAL;
                } else {
                    operatorEnum = OperatorEnum.LESS_THAN;
                }
                return operatorEnum != null && operatorEnum.isValid(value, d, null);
            case CONTAINS_TEXT:
                return checkFormula(cellReference, cellRangeAddress);
            case NOT_CONTAINS_TEXT:
                return checkFormula(cellReference, cellRangeAddress);
            case BEGINS_WITH:
                return checkFormula(cellReference, cellRangeAddress);
            case ENDS_WITH:
                return checkFormula(cellReference, cellRangeAddress);
            case CONTAINS_BLANKS:
                try {
                    String string = cellValue.getString();
                    return string == null || string.trim().length() == 0;
                } catch (Exception unused) {
                    return false;
                }
            case NOT_CONTAINS_BLANKS:
                try {
                    String string2 = cellValue.getString();
                    return string2 != null && string2.trim().length() > 0;
                } catch (Exception unused2) {
                    return true;
                }
            case CONTAINS_ERRORS:
                return cell != null && DataValidationEvaluator.isType(cell, CellType.ERROR);
            case NOT_CONTAINS_ERRORS:
                return cell == null || !DataValidationEvaluator.isType(cell, CellType.ERROR);
            case TIME_PERIOD:
                return checkFormula(cellReference, cellRangeAddress);
            default:
                return false;
        }
    }

    private Set<ValueAndFormat> getMeaningfulValues(CellRangeAddress cellRangeAddress, boolean z, ValueFunction valueFunction) {
        Set<ValueAndFormat> set = this.meaningfulRegionValues.get(cellRangeAddress);
        if (set != null) {
            return set;
        }
        ArrayList arrayList = new ArrayList(((cellRangeAddress.getLastColumn() - cellRangeAddress.getFirstColumn()) + 1) * ((cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow()) + 1));
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            Row row = this.sheet.getRow(firstRow);
            if (row != null) {
                for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                    ValueAndFormat cellValue = getCellValue(row.getCell(firstColumn));
                    if (cellValue != null && (z || cellValue.isNumber())) {
                        arrayList.add(cellValue);
                    }
                }
            }
        }
        Set<ValueAndFormat> setEvaluate = valueFunction.evaluate(arrayList);
        this.meaningfulRegionValues.put(cellRangeAddress, setEvaluate);
        return setEvaluate;
    }

    private ValueAndFormat getCellValue(Cell cell) {
        if (cell != null) {
            CellType cellTypeEnum = cell.getCellTypeEnum();
            if (cellTypeEnum == CellType.NUMERIC || (cellTypeEnum == CellType.FORMULA && cell.getCachedFormulaResultTypeEnum() == CellType.NUMERIC)) {
                return new ValueAndFormat(new Double(cell.getNumericCellValue()), cell.getCellStyle().getDataFormatString());
            }
            if (cellTypeEnum == CellType.STRING || (cellTypeEnum == CellType.FORMULA && cell.getCachedFormulaResultTypeEnum() == CellType.STRING)) {
                return new ValueAndFormat(cell.getStringCellValue(), cell.getCellStyle().getDataFormatString());
            }
            if (cellTypeEnum == CellType.BOOLEAN || (cellTypeEnum == CellType.FORMULA && cell.getCachedFormulaResultTypeEnum() == CellType.BOOLEAN)) {
                return new ValueAndFormat(cell.getStringCellValue(), cell.getCellStyle().getDataFormatString());
            }
        }
        return new ValueAndFormat("", "");
    }

    protected static class ValueAndFormat implements Comparable<ValueAndFormat> {
        private final String format;
        private final String string;
        private final Double value;

        public ValueAndFormat(Double d, String str) {
            this.value = d;
            this.format = str;
            this.string = null;
        }

        public ValueAndFormat(String str, String str2) {
            this.value = null;
            this.format = str2;
            this.string = str;
        }

        public boolean isNumber() {
            return this.value != null;
        }

        public Double getValue() {
            return this.value;
        }

        public String getString() {
            return this.string;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ValueAndFormat)) {
                return false;
            }
            ValueAndFormat valueAndFormat = (ValueAndFormat) obj;
            Double d = this.value;
            Double d2 = valueAndFormat.value;
            if (d != d2 && !d.equals(d2)) {
                return false;
            }
            String str = this.format;
            String str2 = valueAndFormat.format;
            if (str != str2 && !str.equals(str2)) {
                return false;
            }
            String str3 = this.string;
            String str4 = valueAndFormat.string;
            return str3 == str4 || str3.equals(str4);
        }

        @Override // java.lang.Comparable
        public int compareTo(ValueAndFormat valueAndFormat) {
            Double d = this.value;
            if (d == null && valueAndFormat.value != null) {
                return 1;
            }
            Double d2 = valueAndFormat.value;
            if (d2 == null && d != null) {
                return -1;
            }
            int iCompareTo = d == null ? 0 : d.compareTo(d2);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            String str = this.string;
            if (str == null && valueAndFormat.string != null) {
                return 1;
            }
            String str2 = valueAndFormat.string;
            if (str2 == null && str != null) {
                return -1;
            }
            if (str == null) {
                return 0;
            }
            return str.compareTo(str2);
        }

        public int hashCode() {
            String str = this.string;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 37 * 37;
            Double d = this.value;
            int iHashCode2 = iHashCode + ((d == null ? 0 : d.hashCode()) * 37);
            String str2 = this.format;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }
    }
}
