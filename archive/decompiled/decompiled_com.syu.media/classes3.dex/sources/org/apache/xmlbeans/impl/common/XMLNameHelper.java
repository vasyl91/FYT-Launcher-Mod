package org.apache.xmlbeans.impl.common;

import java.io.UnsupportedEncodingException;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.xml.stream.XMLName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XMLNameHelper {
    private static final char[] hexdigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static boolean isSafe(int i) {
        if (i >= 97 && i <= 122) {
            return true;
        }
        if (i < 65 || i > 90) {
            return i >= 48 && i <= 57;
        }
        return true;
    }

    public static QName getQName(XMLName xMLName) {
        if (xMLName == null) {
            return null;
        }
        return QNameHelper.forLNS(xMLName.getLocalName(), xMLName.getNamespaceUri());
    }

    public static XMLName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new XmlNameImpl(str2, str);
    }

    public static XMLName forLN(String str) {
        return new XmlNameImpl("", str);
    }

    public static XMLName forPretty(String str, int i) {
        int iIndexOf = str.indexOf(64, i);
        if (iIndexOf < 0) {
            return new XmlNameImpl("", str.substring(i));
        }
        return new XmlNameImpl(str.substring(iIndexOf + 1), str.substring(i, iIndexOf));
    }

    public static String pretty(XMLName xMLName) {
        if (xMLName == null) {
            return "null";
        }
        if (xMLName.getNamespaceUri() == null || xMLName.getNamespaceUri().length() == 0) {
            return xMLName.getLocalName();
        }
        return xMLName.getLocalName() + "@" + xMLName.getNamespaceUri();
    }

    public static String hexsafe(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (isSafe(cCharAt)) {
                stringBuffer.append(cCharAt);
            } else {
                try {
                    byte[] bytes = str.substring(i, i + 1).getBytes("UTF-8");
                    for (int i2 = 0; i2 < bytes.length; i2++) {
                        stringBuffer.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        stringBuffer.append(cArr[(bytes[i2] >> 4) & 15]);
                        stringBuffer.append(cArr[bytes[i2] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    stringBuffer.append("_BAD_UTF8_CHAR");
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String hexsafedir(XMLName xMLName) {
        if (xMLName.getNamespaceUri() == null || xMLName.getNamespaceUri().length() == 0) {
            return "_nons/" + hexsafe(xMLName.getLocalName());
        }
        return hexsafe(xMLName.getNamespaceUri()) + "/" + hexsafe(xMLName.getLocalName());
    }
}
