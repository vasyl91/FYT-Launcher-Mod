package org.apache.poi.xssf.usermodel.helpers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.xml.bind.DatatypeConverter;
import javax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal(since = "3.15 beta 3")
public final class XSSFPasswordHelper {
    private XSSFPasswordHelper() {
    }

    public static void setPassword(XmlObject xmlObject, String str, HashAlgorithm hashAlgorithm, String str2) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        if (str == null) {
            xmlCursorNewCursor.removeAttribute(getAttrName(str2, "password"));
            xmlCursorNewCursor.removeAttribute(getAttrName(str2, "algorithmName"));
            xmlCursorNewCursor.removeAttribute(getAttrName(str2, "hashValue"));
            xmlCursorNewCursor.removeAttribute(getAttrName(str2, "saltValue"));
            xmlCursorNewCursor.removeAttribute(getAttrName(str2, "spinCount"));
            return;
        }
        xmlCursorNewCursor.toFirstContentToken();
        if (hashAlgorithm == null) {
            xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "password"), String.format(Locale.ROOT, "%04X", Integer.valueOf(CryptoFunctions.createXorVerifier1(str))).toUpperCase(Locale.ROOT));
        } else {
            byte[] bArrGenerateSeed = new SecureRandom().generateSeed(16);
            byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, hashAlgorithm, bArrGenerateSeed, 100000, false);
            xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "algorithmName"), hashAlgorithm.jceId);
            xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "hashValue"), DatatypeConverter.printBase64Binary(bArrHashPassword));
            xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "saltValue"), DatatypeConverter.printBase64Binary(bArrGenerateSeed));
            xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "spinCount"), "100000");
        }
        xmlCursorNewCursor.dispose();
    }

    public static boolean validatePassword(XmlObject xmlObject, String str, String str2) {
        if (str == null) {
            return false;
        }
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        String attributeText = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "password"));
        String attributeText2 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "algorithmName"));
        String attributeText3 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "hashValue"));
        String attributeText4 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "saltValue"));
        String attributeText5 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "spinCount"));
        xmlCursorNewCursor.dispose();
        if (attributeText != null) {
            return Integer.parseInt(attributeText, 16) == CryptoFunctions.createXorVerifier1(str);
        }
        if (attributeText3 == null || attributeText2 == null || attributeText4 == null || attributeText5 == null) {
            return false;
        }
        return Arrays.equals(DatatypeConverter.parseBase64Binary(attributeText3), CryptoFunctions.hashPassword(str, HashAlgorithm.fromString(attributeText2), DatatypeConverter.parseBase64Binary(attributeText4), Integer.parseInt(attributeText5), false));
    }

    private static QName getAttrName(String str, String str2) {
        if (str == null || "".equals(str)) {
            return new QName(str2);
        }
        return new QName(str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1));
    }
}
