package org.apache.poi.xssf.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum XSSFWorkbookType {
    XLSX(XSSFRelation.WORKBOOK.getContentType(), "xlsx"),
    XLSM(XSSFRelation.MACROS_WORKBOOK.getContentType(), "xlsm");

    private final String _contentType;
    private final String _extension;

    XSSFWorkbookType(String str, String str2) {
        this._contentType = str;
        this._extension = str2;
    }

    public String getContentType() {
        return this._contentType;
    }

    public String getExtension() {
        return this._extension;
    }
}
