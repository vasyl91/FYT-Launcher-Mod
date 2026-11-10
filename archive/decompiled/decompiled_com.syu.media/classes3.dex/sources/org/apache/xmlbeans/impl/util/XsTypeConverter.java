package org.apache.xmlbeans.impl.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class XsTypeConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EMPTY_PREFIX = "";
    private static final char NAMESPACE_SEP = ':';
    private static final String NAN_LEX = "NaN";
    private static final String NEG_INF_LEX = "-INF";
    private static final String POS_INF_LEX = "INF";
    private static final BigDecimal DECIMAL__ZERO = new BigDecimal(0.0d);
    private static final String[] URI_CHARS_TO_BE_REPLACED = {" ", "{", "}", "|", "\\", "^", "[", "]", "`"};
    private static final String[] URI_CHARS_REPLACED_WITH = {"%20", "%7b", "%7d", "%7c", "%5c", "%5e", "%5b", "%5d", "%60"};
    private static final char[] CH_ZEROS = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};

    public static CharSequence printAnyURI(CharSequence charSequence) {
        return charSequence;
    }

    public static String printBoolean(boolean z) {
        return z ? "true" : "false";
    }

    public static String printString(String str) {
        return str;
    }

    public static float lexFloat(CharSequence charSequence) throws NumberFormatException {
        char cCharAt;
        String string = charSequence.toString();
        try {
            if (charSequence.length() > 0 && (((cCharAt = charSequence.charAt(charSequence.length() - 1)) == 'f' || cCharAt == 'F') && charSequence.charAt(charSequence.length() - 2) != 'N')) {
                throw new NumberFormatException("Invalid char '" + cCharAt + "' in float.");
            }
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            if (string.equals(POS_INF_LEX)) {
                return Float.POSITIVE_INFINITY;
            }
            if (string.equals(NEG_INF_LEX)) {
                return Float.NEGATIVE_INFINITY;
            }
            if (string.equals(NAN_LEX)) {
                return Float.NaN;
            }
            throw e;
        }
    }

    public static float lexFloat(CharSequence charSequence, Collection collection) {
        try {
            return lexFloat(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid float: " + ((Object) charSequence)));
            return Float.NaN;
        }
    }

    public static String printFloat(float f) {
        if (f == Float.POSITIVE_INFINITY) {
            return POS_INF_LEX;
        }
        if (f == Float.NEGATIVE_INFINITY) {
            return NEG_INF_LEX;
        }
        return Float.isNaN(f) ? NAN_LEX : Float.toString(f);
    }

    public static double lexDouble(CharSequence charSequence) throws NumberFormatException {
        char cCharAt;
        String string = charSequence.toString();
        try {
            if (charSequence.length() > 0 && ((cCharAt = charSequence.charAt(charSequence.length() - 1)) == 'd' || cCharAt == 'D')) {
                throw new NumberFormatException("Invalid char '" + cCharAt + "' in double.");
            }
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            if (string.equals(POS_INF_LEX)) {
                return Double.POSITIVE_INFINITY;
            }
            if (string.equals(NEG_INF_LEX)) {
                return Double.NEGATIVE_INFINITY;
            }
            if (string.equals(NAN_LEX)) {
                return Double.NaN;
            }
            throw e;
        }
    }

    public static double lexDouble(CharSequence charSequence, Collection collection) {
        try {
            return lexDouble(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid double: " + ((Object) charSequence)));
            return Double.NaN;
        }
    }

    public static String printDouble(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return POS_INF_LEX;
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return NEG_INF_LEX;
        }
        return Double.isNaN(d) ? NAN_LEX : Double.toString(d);
    }

    public static BigDecimal lexDecimal(CharSequence charSequence) throws NumberFormatException {
        return new BigDecimal(trimTrailingZeros(charSequence.toString()));
    }

    public static BigDecimal lexDecimal(CharSequence charSequence, Collection collection) {
        try {
            return lexDecimal(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid long: " + ((Object) charSequence)));
            return DECIMAL__ZERO;
        }
    }

    public static String printDecimal(BigDecimal bigDecimal) {
        char[] cArr;
        char[] cArr2;
        String string = bigDecimal.unscaledValue().toString();
        int iScale = bigDecimal.scale();
        if (iScale == 0 || (bigDecimal.longValue() == 0 && iScale < 0)) {
            return string;
        }
        int i = bigDecimal.signum() < 0 ? 1 : 0;
        StringBuffer stringBuffer = new StringBuffer(string.length() + 1 + Math.abs(iScale));
        if (i == 1) {
            stringBuffer.append(NameUtil.HYPHEN);
        }
        if (iScale > 0) {
            int length = iScale - (string.length() - i);
            if (length >= 0) {
                stringBuffer.append("0.");
                while (true) {
                    cArr2 = CH_ZEROS;
                    if (length <= cArr2.length) {
                        break;
                    }
                    stringBuffer.append(cArr2);
                    length -= cArr2.length;
                }
                stringBuffer.append(cArr2, 0, length);
                stringBuffer.append(string.substring(i));
            } else {
                int i2 = i - length;
                stringBuffer.append(string.substring(i, i2));
                stringBuffer.append(NameUtil.PERIOD);
                stringBuffer.append(string.substring(i2));
            }
        } else {
            stringBuffer.append(string.substring(i));
            while (true) {
                cArr = CH_ZEROS;
                if (iScale >= (-cArr.length)) {
                    break;
                }
                stringBuffer.append(cArr);
                iScale += cArr.length;
            }
            stringBuffer.append(cArr, 0, -iScale);
        }
        return stringBuffer.toString();
    }

    public static BigInteger lexInteger(CharSequence charSequence) throws NumberFormatException {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '+' && charSequence.charAt(1) == '-') {
            throw new NumberFormatException("Illegal char sequence '+-'");
        }
        return new BigInteger(trimInitialPlus(charSequence.toString()));
    }

    public static BigInteger lexInteger(CharSequence charSequence, Collection collection) {
        try {
            return lexInteger(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid long: " + ((Object) charSequence)));
            return BigInteger.ZERO;
        }
    }

    public static String printInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    public static long lexLong(CharSequence charSequence) throws NumberFormatException {
        return Long.parseLong(trimInitialPlus(charSequence.toString()));
    }

    public static long lexLong(CharSequence charSequence, Collection collection) {
        try {
            return lexLong(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid long: " + ((Object) charSequence)));
            return 0L;
        }
    }

    public static String printLong(long j) {
        return Long.toString(j);
    }

    public static short lexShort(CharSequence charSequence) throws NumberFormatException {
        return parseShort(charSequence);
    }

    public static short lexShort(CharSequence charSequence, Collection collection) {
        try {
            return lexShort(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid short: " + ((Object) charSequence)));
            return (short) 0;
        }
    }

    public static String printShort(short s) {
        return Short.toString(s);
    }

    public static int lexInt(CharSequence charSequence) throws NumberFormatException {
        return parseInt(charSequence);
    }

    public static int lexInt(CharSequence charSequence, Collection collection) {
        try {
            return lexInt(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid int:" + ((Object) charSequence)));
            return 0;
        }
    }

    public static String printInt(int i) {
        return Integer.toString(i);
    }

    public static byte lexByte(CharSequence charSequence) throws NumberFormatException {
        return parseByte(charSequence);
    }

    public static byte lexByte(CharSequence charSequence, Collection collection) {
        try {
            return lexByte(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid byte: " + ((Object) charSequence)));
            return (byte) 0;
        }
    }

    public static String printByte(byte b) {
        return Byte.toString(b);
    }

    public static boolean lexBoolean(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            if ('0' == cCharAt) {
                return $assertionsDisabled;
            }
            if ('1' == cCharAt) {
                return true;
            }
        } else if (length == 4) {
            if ('t' == charSequence.charAt(0) && 'r' == charSequence.charAt(1) && 'u' == charSequence.charAt(2) && 'e' == charSequence.charAt(3)) {
                return true;
            }
        } else if (length == 5 && 'f' == charSequence.charAt(0) && 'a' == charSequence.charAt(1) && 'l' == charSequence.charAt(2) && 's' == charSequence.charAt(3) && 'e' == charSequence.charAt(4)) {
            return $assertionsDisabled;
        }
        throw new InvalidLexicalValueException("invalid boolean: " + ((Object) charSequence));
    }

    public static boolean lexBoolean(CharSequence charSequence, Collection collection) {
        try {
            return lexBoolean(charSequence);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return $assertionsDisabled;
        }
    }

    public static String lexString(CharSequence charSequence, Collection collection) {
        return charSequence.toString();
    }

    public static String lexString(CharSequence charSequence) {
        return charSequence.toString();
    }

    public static QName lexQName(CharSequence charSequence, NamespaceContext namespaceContext) {
        boolean z;
        String string;
        String string2;
        int i = 0;
        while (true) {
            if (i >= charSequence.length()) {
                z = false;
                break;
            }
            if (charSequence.charAt(i) == ':') {
                z = true;
                break;
            }
            i++;
        }
        String str = "";
        if (z) {
            string2 = charSequence.subSequence(0, i).toString();
            string = charSequence.subSequence(i + 1, charSequence.length()).toString();
            if (i == 0) {
                throw new InvalidLexicalValueException("invalid xsd:QName '" + charSequence.toString() + "'");
            }
        } else {
            string = charSequence.toString();
            string2 = "";
        }
        String namespaceURI = namespaceContext.getNamespaceURI(string2);
        if (namespaceURI != null) {
            str = namespaceURI;
        } else if (string2 != null && string2.length() > 0) {
            throw new InvalidLexicalValueException("Can't resolve prefix: " + string2);
        }
        return new QName(str, string);
    }

    public static QName lexQName(String str, Collection collection, NamespaceContext namespaceContext) {
        try {
            return lexQName(str, namespaceContext);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new QName(null, str.substring(str.indexOf(58)));
        }
    }

    public static String printQName(QName qName, NamespaceContext namespaceContext, Collection collection) {
        String prefix;
        String namespaceURI = qName.getNamespaceURI();
        if (namespaceURI.length() > 0) {
            prefix = namespaceContext.getPrefix(namespaceURI);
            if (prefix == null) {
                collection.add(XmlError.forMessage("NamespaceContext does not provide prefix for namespaceURI " + namespaceURI));
            }
        } else {
            prefix = null;
        }
        return getQNameString(namespaceURI, qName.getLocalPart(), prefix);
    }

    public static String getQNameString(String str, String str2, String str3) {
        return (str3 == null || str == null || str.length() <= 0 || str3.length() <= 0) ? str2 : str3 + ':' + str2;
    }

    public static GDate lexGDate(CharSequence charSequence) {
        return new GDate(charSequence);
    }

    public static GDate lexGDate(String str, Collection collection) {
        try {
            return lexGDate(str);
        } catch (IllegalArgumentException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new GDateBuilder().toGDate();
        }
    }

    public static String printGDate(GDate gDate, Collection collection) {
        return gDate.toString();
    }

    public static XmlCalendar lexDateTime(CharSequence charSequence) {
        return getGDateValue(charSequence, 14).getCalendar();
    }

    public static String printDateTime(Calendar calendar) {
        return printDateTime(calendar, 14);
    }

    public static String printTime(Calendar calendar) {
        return printDateTime(calendar, 15);
    }

    public static String printDate(Calendar calendar) {
        return printDateTime(calendar, 16);
    }

    public static String printDate(Date date) {
        return getGDateValue(date, 16).toString();
    }

    public static String printDateTime(Calendar calendar, int i) {
        return getGDateValue(calendar, i).toString();
    }

    public static String printDateTime(Date date) {
        return getGDateValue(date, 14).toString();
    }

    public static CharSequence printHexBinary(byte[] bArr) {
        return HexBin.bytesToString(bArr);
    }

    public static byte[] lexHexBinary(CharSequence charSequence) {
        byte[] bArrDecode = HexBin.decode(charSequence.toString().getBytes());
        if (bArrDecode != null) {
            return bArrDecode;
        }
        throw new InvalidLexicalValueException("invalid hexBinary value");
    }

    public static CharSequence printBase64Binary(byte[] bArr) {
        return new String(Base64.encode(bArr));
    }

    public static byte[] lexBase64Binary(CharSequence charSequence) {
        byte[] bArrDecode = Base64.decode(charSequence.toString().getBytes());
        if (bArrDecode != null) {
            return bArrDecode;
        }
        throw new InvalidLexicalValueException("invalid base64Binary value");
    }

    public static GDateSpecification getGDateValue(Date date, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(date);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static GDateSpecification getGDateValue(Calendar calendar, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(calendar);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static GDateSpecification getGDateValue(CharSequence charSequence, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(charSequence);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    private static String trimInitialPlus(String str) {
        return (str.length() <= 0 || str.charAt(0) != '+') ? str : str.substring(1);
    }

    private static String trimTrailingZeros(String str) {
        int iLastIndexOf;
        int length = str.length() - 1;
        if (str.charAt(length) != '0' || (iLastIndexOf = str.lastIndexOf(46)) < 0) {
            return str;
        }
        while (length > iLastIndexOf) {
            if (str.charAt(length) != '0') {
                return str.substring(0, length + 1);
            }
            length--;
        }
        return str.substring(0, iLastIndexOf);
    }

    private static int parseInt(CharSequence charSequence) {
        return parseIntXsdNumber(charSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static short parseShort(CharSequence charSequence) {
        return (short) parseIntXsdNumber(charSequence, -32768, 32767);
    }

    private static byte parseByte(CharSequence charSequence) {
        return (byte) parseIntXsdNumber(charSequence, -128, 127);
    }

    private static int parseIntXsdNumber(CharSequence charSequence, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int length = charSequence.length();
        int i8 = 1;
        if (length < 1) {
            throw new NumberFormatException("For input string: \"" + charSequence.toString() + "\"");
        }
        char cCharAt = charSequence.charAt(0);
        if (cCharAt == '-') {
            i6 = i / 10;
            i7 = -(i % 10);
            i5 = 1;
        } else {
            if (cCharAt == '+') {
                i3 = -(i2 / 10);
                i4 = i2 % 10;
                i5 = 1;
            } else {
                i3 = -(i2 / 10);
                i4 = i2 % 10;
                i5 = 0;
            }
            i8 = -1;
            int i9 = i4;
            i6 = i3;
            i7 = i9;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < length - i5; i11++) {
            int iDigit = Character.digit(charSequence.charAt(i11 + i5), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("For input string: \"" + charSequence.toString() + "\"");
            }
            if (i10 < i6 || (i10 == i6 && iDigit > i7)) {
                throw new NumberFormatException("For input string: \"" + charSequence.toString() + "\"");
            }
            i10 = (i10 * 10) - iDigit;
        }
        return i8 * i10;
    }

    public static CharSequence lexAnyURI(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer(charSequence.toString());
        for (int i = 0; i < URI_CHARS_TO_BE_REPLACED.length; i++) {
            int i2 = 0;
            while (true) {
                int iIndexOf = stringBuffer.indexOf(URI_CHARS_TO_BE_REPLACED[i], i2);
                if (iIndexOf >= 0) {
                    stringBuffer.replace(iIndexOf, iIndexOf + 1, URI_CHARS_REPLACED_WITH[i]);
                    i2 = iIndexOf + 3;
                }
            }
        }
        try {
            URI.create(stringBuffer.toString());
            return charSequence;
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException("invalid anyURI value: " + ((Object) charSequence), e);
        }
    }
}
