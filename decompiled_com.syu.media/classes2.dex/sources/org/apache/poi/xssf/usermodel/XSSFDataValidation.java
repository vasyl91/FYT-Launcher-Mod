package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFDataValidation implements DataValidation {
    private static final int MAX_TEXT_LENGTH = 255;
    static Map<Integer, STDataValidationErrorStyle.Enum> errorStyleMappings;
    static Map<Integer, STDataValidationOperator.Enum> operatorTypeMappings = new HashMap();
    static Map<STDataValidationOperator.Enum, Integer> operatorTypeReverseMappings = new HashMap();
    static Map<Integer, STDataValidationType.Enum> validationTypeMappings = new HashMap();
    static Map<STDataValidationType.Enum, Integer> validationTypeReverseMappings = new HashMap();
    private CTDataValidation ctDdataValidation;
    private CellRangeAddressList regions;
    private XSSFDataValidationConstraint validationConstraint;

    static {
        HashMap map = new HashMap();
        errorStyleMappings = map;
        map.put(2, STDataValidationErrorStyle.INFORMATION);
        errorStyleMappings.put(0, STDataValidationErrorStyle.STOP);
        errorStyleMappings.put(1, STDataValidationErrorStyle.WARNING);
        operatorTypeMappings.put(0, STDataValidationOperator.BETWEEN);
        operatorTypeMappings.put(1, STDataValidationOperator.NOT_BETWEEN);
        operatorTypeMappings.put(2, STDataValidationOperator.EQUAL);
        operatorTypeMappings.put(3, STDataValidationOperator.NOT_EQUAL);
        operatorTypeMappings.put(4, STDataValidationOperator.GREATER_THAN);
        operatorTypeMappings.put(6, STDataValidationOperator.GREATER_THAN_OR_EQUAL);
        operatorTypeMappings.put(5, STDataValidationOperator.LESS_THAN);
        operatorTypeMappings.put(7, STDataValidationOperator.LESS_THAN_OR_EQUAL);
        for (Map.Entry<Integer, STDataValidationOperator.Enum> entry : operatorTypeMappings.entrySet()) {
            operatorTypeReverseMappings.put(entry.getValue(), entry.getKey());
        }
        validationTypeMappings.put(7, STDataValidationType.CUSTOM);
        validationTypeMappings.put(4, STDataValidationType.DATE);
        validationTypeMappings.put(2, STDataValidationType.DECIMAL);
        validationTypeMappings.put(3, STDataValidationType.LIST);
        validationTypeMappings.put(0, STDataValidationType.NONE);
        validationTypeMappings.put(6, STDataValidationType.TEXT_LENGTH);
        validationTypeMappings.put(5, STDataValidationType.TIME);
        validationTypeMappings.put(1, STDataValidationType.WHOLE);
        for (Map.Entry<Integer, STDataValidationType.Enum> entry2 : validationTypeMappings.entrySet()) {
            validationTypeReverseMappings.put(entry2.getValue(), entry2.getKey());
        }
    }

    XSSFDataValidation(CellRangeAddressList cellRangeAddressList, CTDataValidation cTDataValidation) {
        this(getConstraint(cTDataValidation), cellRangeAddressList, cTDataValidation);
    }

    public XSSFDataValidation(XSSFDataValidationConstraint xSSFDataValidationConstraint, CellRangeAddressList cellRangeAddressList, CTDataValidation cTDataValidation) {
        this.validationConstraint = xSSFDataValidationConstraint;
        this.ctDdataValidation = cTDataValidation;
        this.regions = cellRangeAddressList;
    }

    CTDataValidation getCtDdataValidation() {
        return this.ctDdataValidation;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void createErrorBox(String str, String str2) {
        if (str != null && str.length() > 255) {
            throw new IllegalStateException("Error-title cannot be longer than 32 characters, but had: " + str);
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Error-text cannot be longer than 255 characters, but had: " + str2);
        }
        this.ctDdataValidation.setErrorTitle(encodeUtf(str));
        this.ctDdataValidation.setError(encodeUtf(str2));
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void createPromptBox(String str, String str2) {
        if (str != null && str.length() > 255) {
            throw new IllegalStateException("Error-title cannot be longer than 32 characters, but had: " + str);
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Error-text cannot be longer than 255 characters, but had: " + str2);
        }
        this.ctDdataValidation.setPromptTitle(encodeUtf(str));
        this.ctDdataValidation.setPrompt(encodeUtf(str2));
    }

    private String encodeUtf(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c < ' ') {
                sb.append("_x").append(c < 16 ? "000" : "00").append(Integer.toHexString(c)).append("_");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getEmptyCellAllowed() {
        return this.ctDdataValidation.getAllowBlank();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getErrorBoxText() {
        return this.ctDdataValidation.getError();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getErrorBoxTitle() {
        return this.ctDdataValidation.getErrorTitle();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public int getErrorStyle() {
        return this.ctDdataValidation.getErrorStyle().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getPromptBoxText() {
        return this.ctDdataValidation.getPrompt();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getPromptBoxTitle() {
        return this.ctDdataValidation.getPromptTitle();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getShowErrorBox() {
        return this.ctDdataValidation.getShowErrorMessage();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getShowPromptBox() {
        return this.ctDdataValidation.getShowInputMessage();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getSuppressDropDownArrow() {
        return !this.ctDdataValidation.getShowDropDown();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public DataValidationConstraint getValidationConstraint() {
        return this.validationConstraint;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setEmptyCellAllowed(boolean z) {
        this.ctDdataValidation.setAllowBlank(z);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setErrorStyle(int i) {
        this.ctDdataValidation.setErrorStyle(errorStyleMappings.get(Integer.valueOf(i)));
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setShowErrorBox(boolean z) {
        this.ctDdataValidation.setShowErrorMessage(z);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setShowPromptBox(boolean z) {
        this.ctDdataValidation.setShowInputMessage(z);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setSuppressDropDownArrow(boolean z) {
        if (this.validationConstraint.getValidationType() == 3) {
            this.ctDdataValidation.setShowDropDown(!z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public CellRangeAddressList getRegions() {
        return this.regions;
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        for (CellRangeAddress cellRangeAddress : this.regions.getCellRangeAddresses()) {
            sb.append(cellRangeAddress.formatAsString());
        }
        sb.append(" => ");
        sb.append(this.validationConstraint.prettyPrint());
        return sb.toString();
    }

    private static XSSFDataValidationConstraint getConstraint(CTDataValidation cTDataValidation) {
        String formula1 = cTDataValidation.getFormula1();
        String formula2 = cTDataValidation.getFormula2();
        STDataValidationOperator.Enum operator = cTDataValidation.getOperator();
        return new XSSFDataValidationConstraint(validationTypeReverseMappings.get(cTDataValidation.getType()).intValue(), operatorTypeReverseMappings.get(operator).intValue(), formula1, formula2);
    }
}
