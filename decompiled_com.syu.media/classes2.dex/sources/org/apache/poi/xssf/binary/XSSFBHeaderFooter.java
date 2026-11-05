package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSSFBHeaderFooter {
    private static final HeaderFooterHelper HEADER_FOOTER_HELPER = new HeaderFooterHelper();
    private final String headerFooterTypeLabel;
    private final boolean isHeader;
    private String rawString;

    XSSFBHeaderFooter(String str, boolean z) {
        this.headerFooterTypeLabel = str;
        this.isHeader = z;
    }

    String getHeaderFooterTypeLabel() {
        return this.headerFooterTypeLabel;
    }

    String getRawString() {
        return this.rawString;
    }

    String getString() {
        StringBuilder sb = new StringBuilder();
        HeaderFooterHelper headerFooterHelper = HEADER_FOOTER_HELPER;
        String leftSection = headerFooterHelper.getLeftSection(this.rawString);
        String centerSection = headerFooterHelper.getCenterSection(this.rawString);
        String rightSection = headerFooterHelper.getRightSection(this.rawString);
        if (leftSection != null && leftSection.length() > 0) {
            sb.append(leftSection);
        }
        if (centerSection != null && centerSection.length() > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(centerSection);
        }
        if (rightSection != null && rightSection.length() > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(rightSection);
        }
        return sb.toString();
    }

    void setRawString(String str) {
        this.rawString = str;
    }

    boolean isHeader() {
        return this.isHeader;
    }
}
