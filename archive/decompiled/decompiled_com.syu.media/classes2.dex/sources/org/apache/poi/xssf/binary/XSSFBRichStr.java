package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSSFBRichStr {
    private final String phoneticString;
    private final String string;

    public static XSSFBRichStr build(byte[] bArr, int i) throws XSSFBParseException {
        byte b = bArr[i];
        StringBuilder sb = new StringBuilder();
        XSSFBUtils.readXLWideString(bArr, i + 1, sb);
        return new XSSFBRichStr(sb.toString(), "");
    }

    XSSFBRichStr(String str, String str2) {
        this.string = str;
        this.phoneticString = str2;
    }

    public String getString() {
        return this.string;
    }
}
