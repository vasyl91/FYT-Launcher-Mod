package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSSFBHeaderFooters {
    private XSSFBHeaderFooter footer;
    private XSSFBHeaderFooter footerEven;
    private XSSFBHeaderFooter footerFirst;
    private XSSFBHeaderFooter header;
    private XSSFBHeaderFooter headerEven;
    private XSSFBHeaderFooter headerFirst;

    XSSFBHeaderFooters() {
    }

    public static XSSFBHeaderFooters parse(byte[] bArr) {
        XSSFBHeaderFooters xSSFBHeaderFooters = new XSSFBHeaderFooters();
        xSSFBHeaderFooters.header = new XSSFBHeaderFooter("header", true);
        xSSFBHeaderFooters.footer = new XSSFBHeaderFooter("footer", false);
        xSSFBHeaderFooters.headerEven = new XSSFBHeaderFooter("evenHeader", true);
        xSSFBHeaderFooters.footerEven = new XSSFBHeaderFooter("evenFooter", false);
        xSSFBHeaderFooters.headerFirst = new XSSFBHeaderFooter("firstHeader", true);
        xSSFBHeaderFooters.footerFirst = new XSSFBHeaderFooter("firstFooter", false);
        int headerFooter = readHeaderFooter(bArr, 2, xSSFBHeaderFooters.header) + 2;
        int headerFooter2 = headerFooter + readHeaderFooter(bArr, headerFooter, xSSFBHeaderFooters.footer);
        int headerFooter3 = headerFooter2 + readHeaderFooter(bArr, headerFooter2, xSSFBHeaderFooters.headerEven);
        int headerFooter4 = headerFooter3 + readHeaderFooter(bArr, headerFooter3, xSSFBHeaderFooters.footerEven);
        readHeaderFooter(bArr, headerFooter4 + readHeaderFooter(bArr, headerFooter4, xSSFBHeaderFooters.headerFirst), xSSFBHeaderFooters.footerFirst);
        return xSSFBHeaderFooters;
    }

    private static int readHeaderFooter(byte[] bArr, int i, XSSFBHeaderFooter xSSFBHeaderFooter) {
        if (i + 4 >= bArr.length) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int xLNullableWideString = XSSFBUtils.readXLNullableWideString(bArr, i, sb);
        xSSFBHeaderFooter.setRawString(sb.toString());
        return xLNullableWideString;
    }

    public XSSFBHeaderFooter getHeader() {
        return this.header;
    }

    public XSSFBHeaderFooter getFooter() {
        return this.footer;
    }

    public XSSFBHeaderFooter getHeaderEven() {
        return this.headerEven;
    }

    public XSSFBHeaderFooter getFooterEven() {
        return this.footerEven;
    }

    public XSSFBHeaderFooter getHeaderFirst() {
        return this.headerFirst;
    }

    public XSSFBHeaderFooter getFooterFirst() {
        return this.footerFirst;
    }
}
