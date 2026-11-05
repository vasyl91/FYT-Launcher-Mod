package org.apache.poi.xssf.usermodel.helpers;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HeaderFooterHelper {
    private static final String HeaderFooterEntity_C = "&C";
    public static final String HeaderFooterEntity_Date = "&D";
    public static final String HeaderFooterEntity_File = "&F";
    private static final String HeaderFooterEntity_L = "&L";
    private static final String HeaderFooterEntity_R = "&R";
    public static final String HeaderFooterEntity_Time = "&T";

    public String getLeftSection(String str) {
        return getParts(str)[0];
    }

    public String getCenterSection(String str) {
        return getParts(str)[1];
    }

    public String getRightSection(String str) {
        return getParts(str)[2];
    }

    public String setLeftSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[0] = str2;
        return joinParts(parts);
    }

    public String setCenterSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[1] = str2;
        return joinParts(parts);
    }

    public String setRightSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[2] = str2;
        return joinParts(parts);
    }

    private String[] getParts(String str) {
        int iIndexOf;
        int iIndexOf2;
        String[] strArr = {"", "", ""};
        if (str == null) {
            return strArr;
        }
        while (true) {
            int iIndexOf3 = str.indexOf(HeaderFooterEntity_L);
            if (iIndexOf3 <= -2 || (iIndexOf = str.indexOf(HeaderFooterEntity_C)) <= -2 || (iIndexOf2 = str.indexOf(HeaderFooterEntity_R)) <= -2 || (iIndexOf3 <= -1 && iIndexOf <= -1 && iIndexOf2 <= -1)) {
                break;
            }
            if (iIndexOf2 > iIndexOf && iIndexOf2 > iIndexOf3) {
                strArr[2] = str.substring(iIndexOf2 + 2);
                str = str.substring(0, iIndexOf2);
            } else if (iIndexOf > iIndexOf2 && iIndexOf > iIndexOf3) {
                strArr[1] = str.substring(iIndexOf + 2);
                str = str.substring(0, iIndexOf);
            } else {
                strArr[0] = str.substring(iIndexOf3 + 2);
                str = str.substring(0, iIndexOf3);
            }
        }
        return strArr;
    }

    private String joinParts(String[] strArr) {
        return joinParts(strArr[0], strArr[1], strArr[2]);
    }

    private String joinParts(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str2.length() > 0) {
            stringBuffer.append(HeaderFooterEntity_C);
            stringBuffer.append(str2);
        }
        if (str.length() > 0) {
            stringBuffer.append(HeaderFooterEntity_L);
            stringBuffer.append(str);
        }
        if (str3.length() > 0) {
            stringBuffer.append(HeaderFooterEntity_R);
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }
}
