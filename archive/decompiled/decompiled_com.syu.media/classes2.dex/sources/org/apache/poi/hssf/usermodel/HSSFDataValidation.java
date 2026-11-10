package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.DVRecord;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFDataValidation implements DataValidation {
    private DVConstraint _constraint;
    private String _error_text;
    private String _error_title;
    private String _prompt_text;
    private String _prompt_title;
    private CellRangeAddressList _regions;
    private int _errorStyle = 0;
    private boolean _emptyCellAllowed = true;
    private boolean _suppress_dropdown_arrow = false;
    private boolean _showPromptBox = true;
    private boolean _showErrorBox = true;

    public HSSFDataValidation(CellRangeAddressList cellRangeAddressList, DataValidationConstraint dataValidationConstraint) {
        this._regions = cellRangeAddressList;
        this._constraint = (DVConstraint) dataValidationConstraint;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public DataValidationConstraint getValidationConstraint() {
        return this._constraint;
    }

    public DVConstraint getConstraint() {
        return this._constraint;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public CellRangeAddressList getRegions() {
        return this._regions;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setErrorStyle(int i) {
        this._errorStyle = i;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public int getErrorStyle() {
        return this._errorStyle;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setEmptyCellAllowed(boolean z) {
        this._emptyCellAllowed = z;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getEmptyCellAllowed() {
        return this._emptyCellAllowed;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setSuppressDropDownArrow(boolean z) {
        this._suppress_dropdown_arrow = z;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getSuppressDropDownArrow() {
        if (this._constraint.getValidationType() == 3) {
            return this._suppress_dropdown_arrow;
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setShowPromptBox(boolean z) {
        this._showPromptBox = z;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getShowPromptBox() {
        return this._showPromptBox;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setShowErrorBox(boolean z) {
        this._showErrorBox = z;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getShowErrorBox() {
        return this._showErrorBox;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void createPromptBox(String str, String str2) {
        if (str != null && str.length() > 32) {
            throw new IllegalStateException("Prompt-title cannot be longer than 32 characters, but had: " + str);
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Prompt-text cannot be longer than 255 characters, but had: " + str2);
        }
        this._prompt_title = str;
        this._prompt_text = str2;
        setShowPromptBox(true);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getPromptBoxTitle() {
        return this._prompt_title;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getPromptBoxText() {
        return this._prompt_text;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void createErrorBox(String str, String str2) {
        if (str != null && str.length() > 32) {
            throw new IllegalStateException("Error-title cannot be longer than 32 characters, but had: " + str);
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Error-text cannot be longer than 255 characters, but had: " + str2);
        }
        this._error_title = str;
        this._error_text = str2;
        setShowErrorBox(true);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getErrorBoxTitle() {
        return this._error_title;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getErrorBoxText() {
        return this._error_text;
    }

    public DVRecord createDVRecord(HSSFSheet hSSFSheet) {
        DVConstraint.FormulaPair formulaPairCreateFormulas = this._constraint.createFormulas(hSSFSheet);
        return new DVRecord(this._constraint.getValidationType(), this._constraint.getOperator(), this._errorStyle, this._emptyCellAllowed, getSuppressDropDownArrow(), this._constraint.getValidationType() == 3 && this._constraint.getExplicitListValues() != null, this._showPromptBox, this._prompt_title, this._prompt_text, this._showErrorBox, this._error_title, this._error_text, formulaPairCreateFormulas.getFormula1(), formulaPairCreateFormulas.getFormula2(), this._regions);
    }
}
