package org.apache.poi.xssf.binary;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFHyperlinkRecord {
    private final CellRangeAddress cellRangeAddress;
    private String display;
    private String location;
    private final String relId;
    private String toolTip;

    XSSFHyperlinkRecord(CellRangeAddress cellRangeAddress, String str, String str2, String str3, String str4) {
        this.cellRangeAddress = cellRangeAddress;
        this.relId = str;
        this.location = str2;
        this.toolTip = str3;
        this.display = str4;
    }

    void setLocation(String str) {
        this.location = str;
    }

    void setToolTip(String str) {
        this.toolTip = str;
    }

    void setDisplay(String str) {
        this.display = str;
    }

    CellRangeAddress getCellRangeAddress() {
        return this.cellRangeAddress;
    }

    public String getRelId() {
        return this.relId;
    }

    public String getLocation() {
        return this.location;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public String getDisplay() {
        return this.display;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XSSFHyperlinkRecord xSSFHyperlinkRecord = (XSSFHyperlinkRecord) obj;
        CellRangeAddress cellRangeAddress = this.cellRangeAddress;
        if (cellRangeAddress == null ? xSSFHyperlinkRecord.cellRangeAddress != null : !cellRangeAddress.equals(xSSFHyperlinkRecord.cellRangeAddress)) {
            return false;
        }
        String str = this.relId;
        if (str == null ? xSSFHyperlinkRecord.relId != null : !str.equals(xSSFHyperlinkRecord.relId)) {
            return false;
        }
        String str2 = this.location;
        if (str2 == null ? xSSFHyperlinkRecord.location != null : !str2.equals(xSSFHyperlinkRecord.location)) {
            return false;
        }
        String str3 = this.toolTip;
        if (str3 == null ? xSSFHyperlinkRecord.toolTip != null : !str3.equals(xSSFHyperlinkRecord.toolTip)) {
            return false;
        }
        String str4 = this.display;
        String str5 = xSSFHyperlinkRecord.display;
        if (str4 != null) {
            return str4.equals(str5);
        }
        return str5 == null;
    }

    public int hashCode() {
        CellRangeAddress cellRangeAddress = this.cellRangeAddress;
        int iHashCode = (cellRangeAddress != null ? cellRangeAddress.hashCode() : 0) * 31;
        String str = this.relId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.location;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.toolTip;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.display;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "XSSFHyperlinkRecord{cellRangeAddress=" + this.cellRangeAddress + ", relId='" + this.relId + "', location='" + this.location + "', toolTip='" + this.toolTip + "', display='" + this.display + "'}";
    }
}
