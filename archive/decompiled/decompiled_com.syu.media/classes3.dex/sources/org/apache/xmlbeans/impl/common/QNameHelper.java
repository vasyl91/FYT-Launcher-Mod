package org.apache.xmlbeans.impl.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.soap.SOAPConstants;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class QNameHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_NAME_LENGTH = 64;
    public static final String URI_SHA1_PREFIX = "URI_SHA_1_";
    private static final Map WELL_KNOWN_PREFIXES = buildWKP();
    private static final char[] hexdigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static boolean isSafe(int i) {
        if (i >= 97 && i <= 122) {
            return true;
        }
        if (i >= 65 && i <= 90) {
            return true;
        }
        if (i < 48 || i > 57) {
            return $assertionsDisabled;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return $assertionsDisabled;
    }

    public static XMLName getXMLName(QName qName) {
        if (qName == null) {
            return null;
        }
        return XMLNameHelper.forLNS(qName.getLocalPart(), qName.getNamespaceURI());
    }

    public static QName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new QName(str2, str);
    }

    public static QName forLN(String str) {
        return new QName("", str);
    }

    public static QName forPretty(String str, int i) {
        int iIndexOf = str.indexOf(64, i);
        if (iIndexOf < 0) {
            return new QName("", str.substring(i));
        }
        return new QName(str.substring(iIndexOf + 1), str.substring(i, iIndexOf));
    }

    public static String pretty(QName qName) {
        if (qName == null) {
            return "null";
        }
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        return qName.getLocalPart() + "@" + qName.getNamespaceURI();
    }

    public static String hexsafe(String str) {
        byte[] bytes;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (isSafe(cCharAt)) {
                stringBuffer.append(cCharAt);
            } else {
                try {
                    byte[] bytes2 = str.substring(i, i + 1).getBytes("UTF-8");
                    for (int i2 = 0; i2 < bytes2.length; i2++) {
                        stringBuffer.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        stringBuffer.append(cArr[(bytes2[i2] >> 4) & 15]);
                        stringBuffer.append(cArr[bytes2[i2] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    stringBuffer.append("_BAD_UTF8_CHAR");
                }
            }
        }
        if (stringBuffer.length() <= 64) {
            return stringBuffer.toString();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                bytes = new byte[0];
            }
            byte[] bArrDigest = messageDigest.digest(bytes);
            StringBuffer stringBuffer2 = new StringBuffer(URI_SHA1_PREFIX);
            for (int i3 = 0; i3 < bArrDigest.length; i3++) {
                char[] cArr2 = hexdigits;
                stringBuffer2.append(cArr2[(bArrDigest[i3] >> 4) & 15]);
                stringBuffer2.append(cArr2[bArrDigest[i3] & 15]);
            }
            return stringBuffer2.toString();
        } catch (NoSuchAlgorithmException unused3) {
            throw new IllegalStateException("Using in a JDK without an SHA implementation");
        }
    }

    public static String hexsafedir(QName qName) {
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return "_nons/" + hexsafe(qName.getLocalPart());
        }
        return hexsafe(qName.getNamespaceURI()) + "/" + hexsafe(qName.getLocalPart());
    }

    private static Map buildWKP() {
        HashMap map = new HashMap();
        map.put(XMLValidationSchema.SCHEMA_ID_DTD, Sax2Dom.XML_PREFIX);
        map.put(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "xs");
        map.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        map.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
        map.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
        map.put(SOAPConstants.URI_NS_SOAP_ENVELOPE, "soapenv");
        return Collections.unmodifiableMap(map);
    }

    public static String readable(SchemaType schemaType) {
        return readable(schemaType, WELL_KNOWN_PREFIXES);
    }

    public static String readable(SchemaType schemaType, Map map) {
        if (schemaType.getName() != null) {
            return readable(schemaType.getName(), map);
        }
        if (schemaType.isAttributeType()) {
            return "attribute type " + readable(schemaType.getAttributeTypeAttributeName(), map);
        }
        if (schemaType.isDocumentType()) {
            return "document type " + readable(schemaType.getDocumentElementName(), map);
        }
        if (schemaType.isNoType() || schemaType.getOuterType() == null) {
            return "invalid type";
        }
        SchemaType outerType = schemaType.getOuterType();
        SchemaField containerField = schemaType.getContainerField();
        if (outerType.isAttributeType()) {
            return "type of attribute " + readable(containerField.getName(), map);
        }
        if (outerType.isDocumentType()) {
            return "type of element " + readable(containerField.getName(), map);
        }
        if (containerField != null) {
            if (containerField.isAttribute()) {
                return "type of " + containerField.getName().getLocalPart() + " attribute in " + readable(outerType, map);
            }
            return "type of " + containerField.getName().getLocalPart() + " element in " + readable(outerType, map);
        }
        if (outerType.getBaseType() == schemaType) {
            return "base type of " + readable(outerType, map);
        }
        if (outerType.getSimpleVariety() == 3) {
            return "item type of " + readable(outerType, map);
        }
        if (outerType.getSimpleVariety() == 2) {
            return "member type " + schemaType.getAnonymousUnionMemberOrdinal() + " of " + readable(outerType, map);
        }
        return "inner type in " + readable(outerType, map);
    }

    public static String readable(QName qName) {
        return readable(qName, WELL_KNOWN_PREFIXES);
    }

    public static String readable(QName qName, Map map) {
        if (qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        String str = (String) map.get(qName.getNamespaceURI());
        if (str != null) {
            return str + ":" + qName.getLocalPart();
        }
        return qName.getLocalPart() + " in namespace " + qName.getNamespaceURI();
    }

    public static String suggestPrefix(String str) {
        String str2 = (String) WELL_KNOWN_PREFIXES.get(str);
        if (str2 != null) {
            return str2;
        }
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf > 0 && iLastIndexOf == str.length() - 1) {
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
            length = iLastIndexOf;
        }
        int i = iLastIndexOf + 1;
        if (str.startsWith("www.", i)) {
            i += 4;
        }
        while (i < length && !XMLChar.isNCNameStart(str.charAt(i))) {
            i++;
        }
        for (int i2 = i + 1; i2 < length; i2++) {
            if (!XMLChar.isNCName(str.charAt(i2)) || !Character.isLetterOrDigit(str.charAt(i2))) {
                length = i2;
                break;
            }
        }
        int i3 = i + 3;
        if (str.length() >= i3 && startsWithXml(str, i)) {
            return str.length() >= i + 4 ? "x" + Character.toLowerCase(str.charAt(i3)) : "ns";
        }
        if (length - i > 4) {
            length = (!isVowel(str.charAt(i + 2)) || isVowel(str.charAt(i3))) ? i3 : i + 4;
        }
        return length - i == 0 ? "ns" : str.substring(i, length).toLowerCase();
    }

    private static boolean startsWithXml(String str, int i) {
        if (str.length() < i + 3) {
            return $assertionsDisabled;
        }
        if (str.charAt(i) != 'X' && str.charAt(i) != 'x') {
            return $assertionsDisabled;
        }
        int i2 = i + 1;
        if (str.charAt(i2) != 'M' && str.charAt(i2) != 'm') {
            return $assertionsDisabled;
        }
        int i3 = i + 2;
        if (str.charAt(i3) == 'L' || str.charAt(i3) == 'l') {
            return true;
        }
        return $assertionsDisabled;
    }

    public static String namespace(SchemaType schemaType) {
        while (schemaType != null) {
            if (schemaType.getName() != null) {
                return schemaType.getName().getNamespaceURI();
            }
            if (schemaType.getContainerField() != null && schemaType.getContainerField().getName().getNamespaceURI().length() > 0) {
                return schemaType.getContainerField().getName().getNamespaceURI();
            }
            schemaType = schemaType.getOuterType();
        }
        return "";
    }

    public static String getLocalPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public static String getPrefixPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : "";
    }
}
