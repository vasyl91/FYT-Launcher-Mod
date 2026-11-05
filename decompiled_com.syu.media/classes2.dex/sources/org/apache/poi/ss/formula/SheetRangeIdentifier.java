package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SheetRangeIdentifier extends SheetIdentifier {
    public NameIdentifier _lastSheetIdentifier;

    public SheetRangeIdentifier(String str, NameIdentifier nameIdentifier, NameIdentifier nameIdentifier2) {
        super(str, nameIdentifier);
        this._lastSheetIdentifier = nameIdentifier2;
    }

    public NameIdentifier getFirstSheetIdentifier() {
        return super.getSheetIdentifier();
    }

    public NameIdentifier getLastSheetIdentifier() {
        return this._lastSheetIdentifier;
    }

    @Override // org.apache.poi.ss.formula.SheetIdentifier
    protected void asFormulaString(StringBuffer stringBuffer) {
        super.asFormulaString(stringBuffer);
        stringBuffer.append(':');
        if (this._lastSheetIdentifier.isQuoted()) {
            stringBuffer.append("'").append(this._lastSheetIdentifier.getName()).append("'");
        } else {
            stringBuffer.append(this._lastSheetIdentifier.getName());
        }
    }
}
