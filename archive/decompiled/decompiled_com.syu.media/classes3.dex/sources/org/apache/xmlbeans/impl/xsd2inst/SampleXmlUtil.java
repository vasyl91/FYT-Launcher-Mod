package org.apache.xmlbeans.impl.xsd2inst;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationBuilder;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDuration;
import org.apache.xmlbeans.XmlGDay;
import org.apache.xmlbeans.XmlGMonth;
import org.apache.xmlbeans.XmlGMonthDay;
import org.apache.xmlbeans.XmlGYear;
import org.apache.xmlbeans.XmlGYearMonth;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlTime;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.Base64;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SampleXmlUtil {
    private static final QName ENC_ARRAYTYPE;
    private static final QName ENC_OFFSET;
    private static final QName HREF;
    private static final QName ID;
    private static final int MAX_ELEMENTS = 1000;
    private static final Set SKIPPED_SOAP_ATTRS;
    private static final QName XSI_TYPE;
    private int _nElements;
    private boolean _soapEnc;
    public static final String[] WORDS = {"ipsa", "iovis", "rapidum", "iaculata", "e", "nubibus", "ignem", "disiecitque", "rates", "evertitque", "aequora", "ventis", "illum", "exspirantem", "transfixo", "pectore", "flammas", "turbine", "corripuit", "scopuloque", "infixit", "acuto", "ast", "ego", "quae", "divum", "incedo", "regina", "iovisque", "et", "soror", "et", "coniunx", "una", "cum", "gente", "tot", "annos", "bella", "gero", "et", "quisquam", "numen", "iunonis", "adorat", "praeterea", "aut", "supplex", "aris", "imponet", "honorem", "talia", "flammato", "secum", "dea", "corde", "volutans", "nimborum", "in", "patriam", "loca", "feta", "furentibus", "austris", "aeoliam", "venit", "hic", "vasto", "rex", "aeolus", "antro", "luctantis", "ventos", "tempestatesque", "sonoras", "imperio", "premit", "ac", "vinclis", "et", "carcere", "frenat", "illi", "indignantes", "magno", "cum", "murmure", "montis", "circum", "claustra", "fremunt", "celsa", "sedet", "aeolus", "arce", "sceptra", "tenens", "mollitque", "animos", "et", "temperat", "iras", "ni", "faciat", "maria", "ac", "terras", "caelumque", "profundum", "quippe", "ferant", "rapidi", "secum", "verrantque", "per", "auras", "sed", "pater", "omnipotens", "speluncis", "abdidit", "atris", "hoc", "metuens", "molemque", "et", "montis", "insuper", "altos", "imposuit", "regemque", "dedit", "qui", "foedere", "certo", "et", "premere", "et", "laxas", "sciret", "dare", "iussus", "habenas"};
    private static final String[] DNS1 = {"corp", "your", "my", "sample", "company", "test", "any"};
    private static final String[] DNS2 = {"com", "org", "com", "gov", "org", "com", "org", "com", "edu"};
    Random _picker = new Random(1);
    private ArrayList _typeStack = new ArrayList();

    private SampleXmlUtil(boolean z) {
        this._soapEnc = z;
    }

    public static String createSampleForType(SchemaType schemaType) {
        XmlObject xmlObjectNewInstance = XmlObject.Factory.newInstance();
        XmlCursor xmlCursorNewCursor = xmlObjectNewInstance.newCursor();
        xmlCursorNewCursor.toNextToken();
        new SampleXmlUtil(false).createSampleForType(schemaType, xmlCursorNewCursor);
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.put("SAVE_PRETTY_PRINT");
        xmlOptions.put("SAVE_PRETTY_PRINT_INDENT", 2);
        xmlOptions.put("SAVE_AGGRESSIVE_NAMESPACES");
        return xmlObjectNewInstance.xmlText(xmlOptions);
    }

    private void createSampleForType(SchemaType schemaType, XmlCursor xmlCursor) {
        if (this._typeStack.contains(schemaType)) {
            return;
        }
        this._typeStack.add(schemaType);
        try {
            if (!schemaType.isSimpleType() && !schemaType.isURType()) {
                processAttributes(schemaType, xmlCursor);
                int contentType = schemaType.getContentType();
                if (contentType == 2) {
                    processSimpleType(schemaType, xmlCursor);
                } else if (contentType != 3) {
                    if (contentType == 4) {
                        StringBuilder sb = new StringBuilder();
                        String[] strArr = WORDS;
                        xmlCursor.insertChars(sb.append(pick(strArr)).append(" ").toString());
                        if (schemaType.getContentModel() != null) {
                            processParticle(schemaType.getContentModel(), xmlCursor, true);
                        }
                        xmlCursor.insertChars(pick(strArr));
                    }
                } else if (schemaType.getContentModel() != null) {
                    processParticle(schemaType.getContentModel(), xmlCursor, false);
                }
                return;
            }
            processSimpleType(schemaType, xmlCursor);
        } finally {
            ArrayList arrayList = this._typeStack;
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private void processSimpleType(SchemaType schemaType, XmlCursor xmlCursor) {
        xmlCursor.insertChars(sampleDataForSimpleType(schemaType));
    }

    private String sampleDataForSimpleType(SchemaType schemaType) {
        if (XmlObject.type.equals(schemaType)) {
            return "anyType";
        }
        if (XmlAnySimpleType.type.equals(schemaType)) {
            return "anySimpleType";
        }
        if (schemaType.getSimpleVariety() == 3) {
            SchemaType listItemType = schemaType.getListItemType();
            StringBuffer stringBuffer = new StringBuffer();
            int iPickLength = pickLength(schemaType);
            if (iPickLength > 0) {
                stringBuffer.append(sampleDataForSimpleType(listItemType));
            }
            for (int i = 1; i < iPickLength; i++) {
                stringBuffer.append(' ');
                stringBuffer.append(sampleDataForSimpleType(listItemType));
            }
            return stringBuffer.toString();
        }
        if (schemaType.getSimpleVariety() == 2) {
            SchemaType[] unionConstituentTypes = schemaType.getUnionConstituentTypes();
            return unionConstituentTypes.length == 0 ? "" : sampleDataForSimpleType(unionConstituentTypes[pick(unionConstituentTypes.length)]);
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null && enumerationValues.length > 0) {
            return enumerationValues[pick(enumerationValues.length)].getStringValue();
        }
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 1:
            case 2:
                return "anything";
            case 3:
                return pick(2) == 0 ? "true" : "false";
            case 4:
                try {
                    return new String(Base64.encode(formatToLength(pick(WORDS), schemaType).getBytes("utf-8")));
                } catch (UnsupportedEncodingException unused) {
                    return null;
                }
            case 5:
                return HexBin.encode(formatToLength(pick(WORDS), schemaType));
            case 6:
                StringBuilder sbAppend = new StringBuilder("http://www.").append(pick(DNS1)).append(".").append(pick(DNS2)).append("/");
                String[] strArr = WORDS;
                return formatToLength(sbAppend.append(pick(strArr)).append("/").append(pick(strArr)).toString(), schemaType);
            case 7:
                return formatToLength("qname", schemaType);
            case 8:
                return formatToLength("notation", schemaType);
            case 9:
                return "1.5E2";
            case 10:
                return "1.051732E7";
            case 11:
                switch (closestBuiltin(schemaType).getBuiltinTypeCode()) {
                    case 22:
                        return formatDecimal("100", schemaType);
                    case 23:
                        return formatDecimal("10", schemaType);
                    case 24:
                        return formatDecimal("3", schemaType);
                    case 25:
                        return formatDecimal("1", schemaType);
                    case 26:
                        return formatDecimal("2", schemaType);
                    case 27:
                        return formatDecimal("-200", schemaType);
                    case 28:
                        return formatDecimal("-201", schemaType);
                    case 29:
                        return formatDecimal("200", schemaType);
                    case 30:
                        return formatDecimal("201", schemaType);
                    case 31:
                        return formatDecimal("11", schemaType);
                    case 32:
                        return formatDecimal("7", schemaType);
                    case 33:
                        return formatDecimal("5", schemaType);
                    case 34:
                        return formatDecimal("6", schemaType);
                    default:
                        return formatDecimal("1000.00", schemaType);
                }
            case 12:
                int builtinTypeCode = closestBuiltin(schemaType).getBuiltinTypeCode();
                String str = "string";
                if (builtinTypeCode != 12 && builtinTypeCode != 35 && builtinTypeCode == 36) {
                    str = "token";
                }
                return formatToLength(str, schemaType);
            case 13:
                return formatDuration(schemaType);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return formatDate(schemaType);
            default:
                return "";
        }
    }

    static {
        QName qName = new QName("href");
        HREF = qName;
        QName qName2 = new QName("id");
        ID = qName2;
        XSI_TYPE = new QName("http://www.w3.org/2001/XMLSchema-instance", JamXmlElements.TYPE);
        ENC_ARRAYTYPE = new QName("http://schemas.xmlsoap.org/soap/encoding/", SoapEncSchemaTypeSystem.ARRAY_TYPE);
        QName qName3 = new QName("http://schemas.xmlsoap.org/soap/encoding/", "offset");
        ENC_OFFSET = qName3;
        SKIPPED_SOAP_ATTRS = new HashSet(Arrays.asList(qName, qName2, qName3));
    }

    private int pick(int i) {
        return this._picker.nextInt(i);
    }

    private String pick(String[] strArr) {
        return strArr[pick(strArr.length)];
    }

    private String pick(String[] strArr, int i) {
        if (i <= 0) {
            return "";
        }
        int iPick = pick(strArr.length);
        StringBuffer stringBuffer = new StringBuffer(strArr[iPick]);
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                iPick++;
                if (iPick >= strArr.length) {
                    iPick = 0;
                }
                stringBuffer.append(' ');
                stringBuffer.append(strArr[iPick]);
                i = i2;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    private String pickDigits(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                stringBuffer.append(Integer.toString(pick(10)));
                i = i2;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    private int pickLength(SchemaType schemaType) {
        XmlInteger facet = schemaType.getFacet(0);
        if (facet != null) {
            return facet.getBigIntegerValue().intValue();
        }
        XmlInteger facet2 = schemaType.getFacet(1);
        XmlInteger facet3 = schemaType.getFacet(2);
        int iIntValue = facet2 != null ? facet2.getBigIntegerValue().intValue() : 0;
        int iIntValue2 = facet3 == null ? Integer.MAX_VALUE : facet3.getBigIntegerValue().intValue();
        int i = (iIntValue != 0 || iIntValue2 < 1) ? iIntValue : 1;
        int i2 = i + 2;
        if (iIntValue2 > i2) {
            iIntValue2 = i2;
        }
        if (iIntValue2 < i) {
            iIntValue2 = i;
        }
        return i + pick(iIntValue2 - i);
    }

    private String formatToLength(String str, SchemaType schemaType) {
        int intValue;
        try {
            SimpleValue facet = schemaType.getFacet(0);
            if (facet == null) {
                facet = (SimpleValue) schemaType.getFacet(1);
            }
            if (facet != null) {
                while (str.length() < facet.getIntValue()) {
                    str = str + str;
                }
            }
            SimpleValue facet2 = schemaType.getFacet(0);
            if (facet2 == null) {
                facet2 = (SimpleValue) schemaType.getFacet(2);
            }
            return (facet2 == null || str.length() <= (intValue = facet2.getIntValue())) ? str : str.substring(0, intValue);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    private String formatDecimal(String str, SchemaType schemaType) {
        boolean z;
        boolean z2;
        int iIntValue;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(str);
        XmlDecimal facet = schemaType.getFacet(4);
        BigDecimal bigDecimalValue = facet != null ? facet.getBigDecimalValue() : null;
        XmlDecimal facet2 = schemaType.getFacet(5);
        BigDecimal bigDecimalValue2 = facet2 != null ? facet2.getBigDecimalValue() : null;
        XmlDecimal facet3 = schemaType.getFacet(3);
        if (facet3 != null) {
            BigDecimal bigDecimalValue3 = facet3.getBigDecimalValue();
            if (bigDecimalValue == null || bigDecimalValue.compareTo(bigDecimalValue3) < 0) {
                bigDecimalValue = bigDecimalValue3;
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        XmlDecimal facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            BigDecimal bigDecimalValue4 = facet4.getBigDecimalValue();
            if (bigDecimalValue2 == null || bigDecimalValue2.compareTo(bigDecimalValue4) > 0) {
                bigDecimalValue2 = bigDecimalValue4;
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        XmlDecimal facet5 = schemaType.getFacet(7);
        int iIntValue2 = -1;
        if (facet5 != null) {
            iIntValue = facet5.getBigDecimalValue().intValue();
            StringBuffer stringBuffer = new StringBuffer(iIntValue);
            for (int i = 0; i < iIntValue; i++) {
                stringBuffer.append('9');
            }
            BigDecimal bigDecimal3 = new BigDecimal(stringBuffer.toString());
            if (bigDecimalValue2 != null && bigDecimalValue2.compareTo(bigDecimal3) > 0) {
                z2 = true;
                bigDecimalValue2 = bigDecimal3;
            }
            BigDecimal bigDecimalNegate = bigDecimal3.negate();
            if (bigDecimalValue != null && bigDecimalValue.compareTo(bigDecimalNegate) < 0) {
                z = true;
                bigDecimalValue = bigDecimalNegate;
            }
        } else {
            iIntValue = -1;
        }
        int iCompareTo = bigDecimalValue == null ? 1 : bigDecimal2.compareTo(bigDecimalValue);
        int iCompareTo2 = bigDecimalValue2 == null ? -1 : bigDecimal2.compareTo(bigDecimalValue2);
        boolean z3 = iCompareTo > 0 || (iCompareTo == 0 && z);
        boolean z4 = iCompareTo2 < 0 || (iCompareTo2 == 0 && z2);
        XmlDecimal facet6 = schemaType.getFacet(8);
        if (facet6 == null) {
            bigDecimal = new BigDecimal(1);
        } else {
            iIntValue2 = facet6.getBigDecimalValue().intValue();
            if (iIntValue2 > 0) {
                StringBuffer stringBuffer2 = new StringBuffer("0.");
                for (int i2 = 1; i2 < iIntValue2; i2++) {
                    stringBuffer2.append('0');
                }
                stringBuffer2.append('1');
                bigDecimal = new BigDecimal(stringBuffer2.toString());
            } else {
                bigDecimal = new BigDecimal(1.0d);
            }
        }
        if (!z3 || !z4) {
            if (z3 && !z4) {
                bigDecimal2 = z2 ? bigDecimalValue2 : bigDecimalValue2.subtract(bigDecimal);
            } else if (!z3 && z4) {
                bigDecimal2 = z ? bigDecimalValue : bigDecimalValue.add(bigDecimal);
            }
        }
        BigDecimal bigDecimal4 = new BigDecimal(BigInteger.ONE);
        BigDecimal bigDecimalMovePointLeft = bigDecimal2;
        int i3 = 0;
        while (bigDecimalMovePointLeft.abs().compareTo(bigDecimal4) >= 0) {
            bigDecimalMovePointLeft = bigDecimalMovePointLeft.movePointLeft(1);
            i3++;
        }
        if (iIntValue2 > 0) {
            if (iIntValue >= 0) {
                bigDecimal2 = bigDecimal2.setScale(Math.max(iIntValue2, iIntValue - i3));
            } else {
                bigDecimal2 = bigDecimal2.setScale(iIntValue2);
            }
        } else if (iIntValue2 == 0) {
            bigDecimal2 = bigDecimal2.setScale(0);
        }
        return bigDecimal2.toString();
    }

    private String formatDuration(SchemaType schemaType) {
        XmlDuration facet = schemaType.getFacet(4);
        GDuration gDurationValue = facet != null ? facet.getGDurationValue() : null;
        XmlDuration facet2 = schemaType.getFacet(5);
        GDuration gDurationValue2 = facet2 != null ? facet2.getGDurationValue() : null;
        XmlDuration facet3 = schemaType.getFacet(3);
        GDuration gDurationValue3 = facet3 != null ? facet3.getGDurationValue() : null;
        XmlDuration facet4 = schemaType.getFacet(6);
        GDuration gDurationValue4 = facet4 != null ? facet4.getGDurationValue() : null;
        GDurationBuilder gDurationBuilder = new GDurationBuilder();
        gDurationBuilder.setSecond(pick(800000));
        gDurationBuilder.setMonth(pick(20));
        if (gDurationValue != null) {
            if (gDurationBuilder.getYear() < gDurationValue.getYear()) {
                gDurationBuilder.setYear(gDurationValue.getYear());
            }
            if (gDurationBuilder.getMonth() < gDurationValue.getMonth()) {
                gDurationBuilder.setMonth(gDurationValue.getMonth());
            }
            if (gDurationBuilder.getDay() < gDurationValue.getDay()) {
                gDurationBuilder.setDay(gDurationValue.getDay());
            }
            if (gDurationBuilder.getHour() < gDurationValue.getHour()) {
                gDurationBuilder.setHour(gDurationValue.getHour());
            }
            if (gDurationBuilder.getMinute() < gDurationValue.getMinute()) {
                gDurationBuilder.setMinute(gDurationValue.getMinute());
            }
            if (gDurationBuilder.getSecond() < gDurationValue.getSecond()) {
                gDurationBuilder.setSecond(gDurationValue.getSecond());
            }
            if (gDurationBuilder.getFraction().compareTo(gDurationValue.getFraction()) < 0) {
                gDurationBuilder.setFraction(gDurationValue.getFraction());
            }
        }
        if (gDurationValue2 != null) {
            if (gDurationBuilder.getYear() > gDurationValue2.getYear()) {
                gDurationBuilder.setYear(gDurationValue2.getYear());
            }
            if (gDurationBuilder.getMonth() > gDurationValue2.getMonth()) {
                gDurationBuilder.setMonth(gDurationValue2.getMonth());
            }
            if (gDurationBuilder.getDay() > gDurationValue2.getDay()) {
                gDurationBuilder.setDay(gDurationValue2.getDay());
            }
            if (gDurationBuilder.getHour() > gDurationValue2.getHour()) {
                gDurationBuilder.setHour(gDurationValue2.getHour());
            }
            if (gDurationBuilder.getMinute() > gDurationValue2.getMinute()) {
                gDurationBuilder.setMinute(gDurationValue2.getMinute());
            }
            if (gDurationBuilder.getSecond() > gDurationValue2.getSecond()) {
                gDurationBuilder.setSecond(gDurationValue2.getSecond());
            }
            if (gDurationBuilder.getFraction().compareTo(gDurationValue2.getFraction()) > 0) {
                gDurationBuilder.setFraction(gDurationValue2.getFraction());
            }
        }
        if (gDurationValue3 != null) {
            if (gDurationBuilder.getYear() <= gDurationValue3.getYear()) {
                gDurationBuilder.setYear(gDurationValue3.getYear() + 1);
            }
            if (gDurationBuilder.getMonth() <= gDurationValue3.getMonth()) {
                gDurationBuilder.setMonth(gDurationValue3.getMonth() + 1);
            }
            if (gDurationBuilder.getDay() <= gDurationValue3.getDay()) {
                gDurationBuilder.setDay(gDurationValue3.getDay() + 1);
            }
            if (gDurationBuilder.getHour() <= gDurationValue3.getHour()) {
                gDurationBuilder.setHour(gDurationValue3.getHour() + 1);
            }
            if (gDurationBuilder.getMinute() <= gDurationValue3.getMinute()) {
                gDurationBuilder.setMinute(gDurationValue3.getMinute() + 1);
            }
            if (gDurationBuilder.getSecond() <= gDurationValue3.getSecond()) {
                gDurationBuilder.setSecond(gDurationValue3.getSecond() + 1);
            }
            if (gDurationBuilder.getFraction().compareTo(gDurationValue3.getFraction()) <= 0) {
                gDurationBuilder.setFraction(gDurationValue3.getFraction().add(new BigDecimal(0.001d)));
            }
        }
        if (gDurationValue4 != null) {
            if (gDurationBuilder.getYear() > gDurationValue4.getYear()) {
                gDurationBuilder.setYear(gDurationValue4.getYear());
            }
            if (gDurationBuilder.getMonth() > gDurationValue4.getMonth()) {
                gDurationBuilder.setMonth(gDurationValue4.getMonth());
            }
            if (gDurationBuilder.getDay() > gDurationValue4.getDay()) {
                gDurationBuilder.setDay(gDurationValue4.getDay());
            }
            if (gDurationBuilder.getHour() > gDurationValue4.getHour()) {
                gDurationBuilder.setHour(gDurationValue4.getHour());
            }
            if (gDurationBuilder.getMinute() > gDurationValue4.getMinute()) {
                gDurationBuilder.setMinute(gDurationValue4.getMinute());
            }
            if (gDurationBuilder.getSecond() > gDurationValue4.getSecond()) {
                gDurationBuilder.setSecond(gDurationValue4.getSecond());
            }
            if (gDurationBuilder.getFraction().compareTo(gDurationValue4.getFraction()) > 0) {
                gDurationBuilder.setFraction(gDurationValue4.getFraction());
            }
        }
        gDurationBuilder.normalize();
        return gDurationBuilder.toString();
    }

    private String formatDate(SchemaType schemaType) {
        GDate gDateValue;
        GDate gDate;
        GDateBuilder gDateBuilder;
        GDateBuilder gDateBuilder2 = new GDateBuilder(new Date((((long) pick(31536000)) * 1000) + ((((long) pick(20)) + 30) * 365 * 24 * 60 * 60 * 1000)));
        GDate gDateValue2 = null;
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 14:
                XmlDateTime facet = schemaType.getFacet(4);
                gDateValue = facet != null ? facet.getGDateValue() : null;
                XmlDateTime facet2 = schemaType.getFacet(3);
                if (facet2 != null && (gDateValue == null || gDateValue.compareToGDate(facet2.getGDateValue()) <= 0)) {
                    gDateValue = facet2.getGDateValue();
                }
                XmlDateTime facet3 = schemaType.getFacet(5);
                gDateValue2 = facet3 != null ? facet3.getGDateValue() : null;
                XmlDateTime facet4 = schemaType.getFacet(6);
                if (facet4 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet4.getGDateValue()) >= 0)) {
                    gDateValue2 = facet4.getGDateValue();
                }
                GDate gDate2 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate2;
                break;
            case 15:
                XmlTime facet5 = schemaType.getFacet(4);
                gDateValue = facet5 != null ? facet5.getGDateValue() : null;
                XmlTime facet6 = schemaType.getFacet(3);
                if (facet6 != null && (gDateValue == null || gDateValue.compareToGDate(facet6.getGDateValue()) <= 0)) {
                    gDateValue = facet6.getGDateValue();
                }
                XmlTime facet7 = schemaType.getFacet(5);
                gDateValue2 = facet7 != null ? facet7.getGDateValue() : null;
                XmlTime facet8 = schemaType.getFacet(6);
                if (facet8 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet8.getGDateValue()) >= 0)) {
                    gDateValue2 = facet8.getGDateValue();
                }
                GDate gDate3 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate3;
                break;
            case 16:
                XmlDate facet9 = schemaType.getFacet(4);
                gDateValue = facet9 != null ? facet9.getGDateValue() : null;
                XmlDate facet10 = schemaType.getFacet(3);
                if (facet10 != null && (gDateValue == null || gDateValue.compareToGDate(facet10.getGDateValue()) <= 0)) {
                    gDateValue = facet10.getGDateValue();
                }
                XmlDate facet11 = schemaType.getFacet(5);
                gDateValue2 = facet11 != null ? facet11.getGDateValue() : null;
                XmlDate facet12 = schemaType.getFacet(6);
                if (facet12 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet12.getGDateValue()) >= 0)) {
                    gDateValue2 = facet12.getGDateValue();
                }
                GDate gDate4 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate4;
                break;
            case 17:
                XmlGYearMonth facet13 = schemaType.getFacet(4);
                gDateValue = facet13 != null ? facet13.getGDateValue() : null;
                XmlGYearMonth facet14 = schemaType.getFacet(3);
                if (facet14 != null && (gDateValue == null || gDateValue.compareToGDate(facet14.getGDateValue()) <= 0)) {
                    gDateValue = facet14.getGDateValue();
                }
                XmlGYearMonth facet15 = schemaType.getFacet(5);
                gDateValue2 = facet15 != null ? facet15.getGDateValue() : null;
                XmlGYearMonth facet16 = schemaType.getFacet(6);
                if (facet16 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet16.getGDateValue()) >= 0)) {
                    gDateValue2 = facet16.getGDateValue();
                }
                GDate gDate5 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate5;
                break;
            case 18:
                XmlGYear facet17 = schemaType.getFacet(4);
                gDateValue = facet17 != null ? facet17.getGDateValue() : null;
                XmlGYear facet18 = schemaType.getFacet(3);
                if (facet18 != null && (gDateValue == null || gDateValue.compareToGDate(facet18.getGDateValue()) <= 0)) {
                    gDateValue = facet18.getGDateValue();
                }
                XmlGYear facet19 = schemaType.getFacet(5);
                gDateValue2 = facet19 != null ? facet19.getGDateValue() : null;
                XmlGYear facet20 = schemaType.getFacet(6);
                if (facet20 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet20.getGDateValue()) >= 0)) {
                    gDateValue2 = facet20.getGDateValue();
                }
                GDate gDate6 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate6;
                break;
            case 19:
                XmlGMonthDay facet21 = schemaType.getFacet(4);
                gDateValue = facet21 != null ? facet21.getGDateValue() : null;
                XmlGMonthDay facet22 = schemaType.getFacet(3);
                if (facet22 != null && (gDateValue == null || gDateValue.compareToGDate(facet22.getGDateValue()) <= 0)) {
                    gDateValue = facet22.getGDateValue();
                }
                XmlGMonthDay facet23 = schemaType.getFacet(5);
                gDateValue2 = facet23 != null ? facet23.getGDateValue() : null;
                XmlGMonthDay facet24 = schemaType.getFacet(6);
                if (facet24 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet24.getGDateValue()) >= 0)) {
                    gDateValue2 = facet24.getGDateValue();
                }
                GDate gDate7 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate7;
                break;
            case 20:
                XmlGDay facet25 = schemaType.getFacet(4);
                gDateValue = facet25 != null ? facet25.getGDateValue() : null;
                XmlGDay facet26 = schemaType.getFacet(3);
                if (facet26 != null && (gDateValue == null || gDateValue.compareToGDate(facet26.getGDateValue()) <= 0)) {
                    gDateValue = facet26.getGDateValue();
                }
                XmlGDay facet27 = schemaType.getFacet(5);
                gDateValue2 = facet27 != null ? facet27.getGDateValue() : null;
                XmlGDay facet28 = schemaType.getFacet(6);
                if (facet28 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet28.getGDateValue()) >= 0)) {
                    gDateValue2 = facet28.getGDateValue();
                }
                GDate gDate8 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate8;
                break;
            case 21:
                XmlGMonth facet29 = schemaType.getFacet(4);
                gDateValue = facet29 != null ? facet29.getGDateValue() : null;
                XmlGMonth facet30 = schemaType.getFacet(3);
                if (facet30 != null && (gDateValue == null || gDateValue.compareToGDate(facet30.getGDateValue()) <= 0)) {
                    gDateValue = facet30.getGDateValue();
                }
                XmlGMonth facet31 = schemaType.getFacet(5);
                gDateValue2 = facet31 != null ? facet31.getGDateValue() : null;
                XmlGMonth facet32 = schemaType.getFacet(6);
                if (facet32 != null && (gDateValue2 == null || gDateValue2.compareToGDate(facet32.getGDateValue()) >= 0)) {
                    gDateValue2 = facet32.getGDateValue();
                }
                GDate gDate9 = gDateValue2;
                gDateValue2 = gDateValue;
                gDate = gDate9;
                break;
            default:
                gDate = null;
                break;
        }
        if (gDateValue2 == null || gDate != null) {
            if (gDateValue2 == null && gDate != null) {
                if (gDate.compareToGDate(gDateBuilder2) <= 0) {
                    XmlCalendar calendar = gDateBuilder2.getCalendar();
                    calendar.add(11, 0 - pick(8));
                    gDateBuilder = new GDateBuilder(calendar);
                    gDateBuilder2 = gDateBuilder;
                }
            } else if (gDateValue2 != null && gDate != null && (gDateValue2.compareToGDate(gDateBuilder2) >= 0 || gDate.compareToGDate(gDateBuilder2) <= 0)) {
                XmlCalendar calendar2 = gDateValue2.getCalendar();
                XmlCalendar calendar3 = gDate.getCalendar();
                calendar2.add(11, 1);
                if (calendar2.after(calendar3)) {
                    calendar2.add(11, -1);
                    calendar2.add(12, 1);
                    if (calendar2.after(calendar3)) {
                        calendar2.add(12, -1);
                        calendar2.add(13, 1);
                        if (calendar2.after(calendar3)) {
                            calendar2.add(13, -1);
                            calendar2.add(14, 1);
                            if (calendar2.after(calendar3)) {
                                calendar2.add(14, -1);
                            }
                        }
                    }
                }
                gDateBuilder = new GDateBuilder(calendar2);
                gDateBuilder2 = gDateBuilder;
            }
        } else if (gDateValue2.compareToGDate(gDateBuilder2) >= 0) {
            XmlCalendar calendar4 = gDateBuilder2.getCalendar();
            calendar4.add(11, pick(8));
            gDateBuilder = new GDateBuilder(calendar4);
            gDateBuilder2 = gDateBuilder;
        }
        gDateBuilder2.setBuiltinTypeCode(schemaType.getPrimitiveType().getBuiltinTypeCode());
        if (pick(2) == 0) {
            gDateBuilder2.clearTimeZone();
        }
        return gDateBuilder2.toString();
    }

    private SchemaType closestBuiltin(SchemaType schemaType) {
        while (!schemaType.isBuiltinType()) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    public static QName crackQName(String str) {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(58);
        if (iLastIndexOf >= 0) {
            strSubstring = str.substring(0, iLastIndexOf);
            str = str.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "";
        }
        return new QName(strSubstring, str);
    }

    private void processParticle(SchemaParticle schemaParticle, XmlCursor xmlCursor, boolean z) {
        int iDetermineMinMaxForSample = determineMinMaxForSample(schemaParticle, xmlCursor);
        while (true) {
            int i = iDetermineMinMaxForSample - 1;
            if (iDetermineMinMaxForSample <= 0) {
                return;
            }
            int particleType = schemaParticle.getParticleType();
            if (particleType == 1) {
                processAll(schemaParticle, xmlCursor, z);
            } else if (particleType == 2) {
                processChoice(schemaParticle, xmlCursor, z);
            } else if (particleType == 3) {
                processSequence(schemaParticle, xmlCursor, z);
            } else if (particleType == 4) {
                processElement(schemaParticle, xmlCursor, z);
            } else if (particleType == 5) {
                processWildCard(schemaParticle, xmlCursor, z);
            }
            iDetermineMinMaxForSample = i;
        }
    }

    private int determineMinMaxForSample(SchemaParticle schemaParticle, XmlCursor xmlCursor) {
        int intMinOccurs = schemaParticle.getIntMinOccurs();
        if (intMinOccurs == schemaParticle.getIntMaxOccurs()) {
            return intMinOccurs;
        }
        int i = (intMinOccurs != 0 || this._nElements >= MAX_ELEMENTS) ? intMinOccurs : 1;
        if (schemaParticle.getParticleType() != 4) {
            return i;
        }
        if (schemaParticle.getMaxOccurs() == null) {
            if (intMinOccurs == 0) {
                xmlCursor.insertComment("Zero or more repetitions:");
            } else {
                xmlCursor.insertComment(intMinOccurs + " or more repetitions:");
            }
        } else if (schemaParticle.getIntMaxOccurs() > 1) {
            xmlCursor.insertComment(intMinOccurs + " to " + String.valueOf(schemaParticle.getMaxOccurs()) + " repetitions:");
        } else {
            xmlCursor.insertComment("Optional:");
        }
        return i;
    }

    private String getItemNameOrType(SchemaParticle schemaParticle, XmlCursor xmlCursor) {
        if (schemaParticle.getParticleType() == 4) {
            return "Element (" + schemaParticle.getName().getLocalPart() + ")";
        }
        return printParticleType(schemaParticle.getParticleType());
    }

    private void processElement(SchemaParticle schemaParticle, XmlCursor xmlCursor, boolean z) {
        SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaParticle;
        if (this._soapEnc) {
            xmlCursor.insertElement(schemaLocalElement.getName().getLocalPart());
        } else {
            xmlCursor.insertElement(schemaLocalElement.getName().getLocalPart(), schemaLocalElement.getName().getNamespaceURI());
        }
        this._nElements++;
        xmlCursor.toPrevToken();
        createSampleForType(schemaLocalElement.getType(), xmlCursor);
        xmlCursor.toNextToken();
    }

    private void moveToken(int i, XmlCursor xmlCursor) {
        for (int i2 = 0; i2 < Math.abs(i); i2++) {
            if (i < 0) {
                xmlCursor.toPrevToken();
            } else {
                xmlCursor.toNextToken();
            }
        }
    }

    private static final String formatQName(XmlCursor xmlCursor, QName qName) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursorNewCursor.toParent();
        String strPrefixForNamespace = xmlCursorNewCursor.prefixForNamespace(qName.getNamespaceURI());
        xmlCursorNewCursor.dispose();
        if (strPrefixForNamespace == null || strPrefixForNamespace.length() == 0) {
            return qName.getLocalPart();
        }
        return strPrefixForNamespace + ":" + qName.getLocalPart();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0073  */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    private void processAttributes(SchemaType schemaType, XmlCursor xmlCursor) {
        String defaultText;
        QName name;
        if (this._soapEnc && (name = schemaType.getName()) != null) {
            xmlCursor.insertAttributeWithValue(XSI_TYPE, formatQName(xmlCursor, name));
        }
        for (SchemaProperty schemaProperty : schemaType.getAttributeProperties()) {
            if (this._soapEnc) {
                if (!SKIPPED_SOAP_ATTRS.contains(schemaProperty.getName())) {
                    if (ENC_ARRAYTYPE.equals(schemaProperty.getName())) {
                        SOAPArrayType wSDLArrayType = schemaType.getAttributeModel().getAttribute(schemaProperty.getName()).getWSDLArrayType();
                        if (wSDLArrayType != null) {
                            xmlCursor.insertAttributeWithValue(schemaProperty.getName(), formatQName(xmlCursor, wSDLArrayType.getQName()) + wSDLArrayType.soap11DimensionString());
                        }
                    } else {
                        defaultText = schemaProperty.getDefaultText();
                        QName name2 = schemaProperty.getName();
                        if (defaultText == null) {
                            defaultText = sampleDataForSimpleType(schemaProperty.getType());
                        }
                        xmlCursor.insertAttributeWithValue(name2, defaultText);
                    }
                }
            } else {
                defaultText = schemaProperty.getDefaultText();
                QName name3 = schemaProperty.getName();
                if (defaultText == null) {
                    defaultText = sampleDataForSimpleType(schemaProperty.getType());
                }
                xmlCursor.insertAttributeWithValue(name3, defaultText);
            }
        }
    }

    private void processSequence(SchemaParticle schemaParticle, XmlCursor xmlCursor, boolean z) {
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        for (int i = 0; i < particleChildren.length; i++) {
            processParticle(particleChildren[i], xmlCursor, z);
            if (z && i < particleChildren.length - 1) {
                xmlCursor.insertChars(pick(WORDS));
            }
        }
    }

    private void processChoice(SchemaParticle schemaParticle, XmlCursor xmlCursor, boolean z) {
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        xmlCursor.insertComment("You have a CHOICE of the next " + String.valueOf(particleChildren.length) + " items at this level");
        for (SchemaParticle schemaParticle2 : particleChildren) {
            processParticle(schemaParticle2, xmlCursor, z);
        }
    }

    private void processAll(SchemaParticle schemaParticle, XmlCursor xmlCursor, boolean z) {
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        for (int i = 0; i < particleChildren.length; i++) {
            processParticle(particleChildren[i], xmlCursor, z);
            if (z && i < particleChildren.length - 1) {
                xmlCursor.insertChars(pick(WORDS));
            }
        }
    }

    private void processWildCard(SchemaParticle schemaParticle, XmlCursor xmlCursor, boolean z) {
        xmlCursor.insertComment("You may enter ANY elements at this point");
        xmlCursor.insertElement("AnyElement");
    }

    private static QName getClosestName(SchemaType schemaType) {
        while (schemaType.getName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType.getName();
    }

    private String printParticleType(int i) {
        StringBuffer stringBuffer = new StringBuffer("Schema Particle Type: ");
        if (i == 1) {
            stringBuffer.append("ALL\n");
        } else if (i == 2) {
            stringBuffer.append("CHOICE\n");
        } else if (i == 3) {
            stringBuffer.append("SEQUENCE\n");
        } else if (i == 4) {
            stringBuffer.append("ELEMENT\n");
        } else if (i == 5) {
            stringBuffer.append("WILDCARD\n");
        } else {
            stringBuffer.append("Schema Particle Type Unknown");
        }
        return stringBuffer.toString();
    }
}
