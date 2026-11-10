package org.apache.poi.xssf.usermodel.helpers;

import org.apache.poi.xssf.usermodel.XSSFTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFXmlColumnPr {
    private CTTableColumn ctTableColumn;
    private CTXmlColumnPr ctXmlColumnPr;
    private XSSFTable table;

    public XSSFXmlColumnPr(XSSFTable xSSFTable, CTTableColumn cTTableColumn, CTXmlColumnPr cTXmlColumnPr) {
        this.table = xSSFTable;
        this.ctTableColumn = cTTableColumn;
        this.ctXmlColumnPr = cTXmlColumnPr;
    }

    public long getMapId() {
        return this.ctXmlColumnPr.getMapId();
    }

    public String getXPath() {
        return this.ctXmlColumnPr.getXpath();
    }

    public long getId() {
        return this.ctTableColumn.getId();
    }

    public String getLocalXPath() {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = this.ctXmlColumnPr.getXpath().split("/");
        for (int length = this.table.getCommonXpath().split("/").length - 1; length < strArrSplit.length; length++) {
            sb.append("/" + strArrSplit[length]);
        }
        return sb.toString();
    }

    public STXmlDataType.Enum getXmlDataType() {
        return this.ctXmlColumnPr.getXmlDataType();
    }
}
