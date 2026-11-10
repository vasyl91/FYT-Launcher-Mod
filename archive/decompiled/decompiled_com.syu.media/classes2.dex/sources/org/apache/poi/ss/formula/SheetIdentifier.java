package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SheetIdentifier {
    public String _bookName;
    public NameIdentifier _sheetIdentifier;

    public SheetIdentifier(String str, NameIdentifier nameIdentifier) {
        this._bookName = str;
        this._sheetIdentifier = nameIdentifier;
    }

    public String getBookName() {
        return this._bookName;
    }

    public NameIdentifier getSheetIdentifier() {
        return this._sheetIdentifier;
    }

    protected void asFormulaString(StringBuffer stringBuffer) {
        if (this._bookName != null) {
            stringBuffer.append(" [").append(this._sheetIdentifier.getName()).append("]");
        }
        if (this._sheetIdentifier.isQuoted()) {
            stringBuffer.append("'").append(this._sheetIdentifier.getName()).append("'");
        } else {
            stringBuffer.append(this._sheetIdentifier.getName());
        }
    }

    public String asFormulaString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        asFormulaString(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        asFormulaString(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
