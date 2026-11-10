package org.apache.xmlbeans.soap;

import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class SOAPArrayType {
    private static int[] EMPTY_INT_ARRAY = new int[0];
    private int[] _dimensions;
    private int[] _ranks;
    private QName _type;

    public boolean isSameRankAs(SOAPArrayType sOAPArrayType) {
        if (this._ranks.length != sOAPArrayType._ranks.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this._ranks;
            if (i >= iArr.length) {
                return this._dimensions.length == sOAPArrayType._dimensions.length;
            }
            if (iArr[i] != sOAPArrayType._ranks[i]) {
                return false;
            }
            i++;
        }
    }

    public static int[] parseSoap11Index(String str) {
        String strCollapse = XmlWhitespace.collapse(str, 3);
        if (!strCollapse.startsWith("[") || !strCollapse.endsWith("]")) {
            throw new IllegalArgumentException("Misformed SOAP 1.1 index: must be contained in braces []");
        }
        return internalParseCommaIntString(strCollapse.substring(1, strCollapse.length() - 1));
    }

    private static int[] internalParseCommaIntString(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf < 0) {
                break;
            }
            arrayList.add(str.substring(i2, iIndexOf));
            i2 = iIndexOf + 1;
        }
        arrayList.add(str.substring(i2));
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strCollapse = XmlWhitespace.collapse((String) it.next(), 3);
            if (strCollapse.equals("*") || strCollapse.equals("")) {
                iArr[i] = -1;
            } else {
                try {
                    iArr[i] = Integer.parseInt(strCollapse);
                } catch (Exception unused) {
                    throw new XmlValueOutOfRangeException("Malformed integer in SOAP array index");
                }
            }
            i++;
        }
        return iArr;
    }

    public SOAPArrayType(String str, PrefixResolver prefixResolver) {
        int iIndexOf = str.indexOf(91);
        if (iIndexOf < 0) {
            throw new XmlValueOutOfRangeException();
        }
        String strCollapse = XmlWhitespace.collapse(str.substring(0, iIndexOf), 3);
        int iIndexOf2 = strCollapse.indexOf(58);
        String namespaceForPrefix = prefixResolver.getNamespaceForPrefix(iIndexOf2 >= 0 ? strCollapse.substring(0, iIndexOf2) : "");
        if (namespaceForPrefix == null) {
            throw new XmlValueOutOfRangeException();
        }
        this._type = QNameHelper.forLNS(strCollapse.substring(iIndexOf2 + 1), namespaceForPrefix);
        initDimensions(str, iIndexOf);
    }

    public SOAPArrayType(QName qName, String str) {
        int iIndexOf = str.indexOf(91);
        if (iIndexOf < 0) {
            this._type = qName;
            this._ranks = EMPTY_INT_ARRAY;
            String[] strArrSplit = XmlWhitespace.collapse(str, 3).split(" ");
            for (int i = 0; i < strArrSplit.length; i++) {
                if (strArrSplit[i].equals("*")) {
                    this._dimensions[i] = -1;
                } else {
                    try {
                        this._dimensions[i] = Integer.parseInt(strArrSplit[i]);
                    } catch (Exception unused) {
                        throw new XmlValueOutOfRangeException();
                    }
                }
            }
            return;
        }
        this._type = qName;
        initDimensions(str, iIndexOf);
    }

    public SOAPArrayType(SOAPArrayType sOAPArrayType, int[] iArr) {
        this._type = sOAPArrayType._type;
        int[] iArr2 = new int[sOAPArrayType._ranks.length + 1];
        this._ranks = iArr2;
        int[] iArr3 = sOAPArrayType._ranks;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        int[] iArr4 = this._ranks;
        iArr4[iArr4.length - 1] = sOAPArrayType._dimensions.length;
        int[] iArr5 = new int[iArr.length];
        this._dimensions = iArr5;
        System.arraycopy(iArr, 0, iArr5, 0, iArr.length);
    }

    private void initDimensions(String str, int i) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = -1;
        while (i >= 0) {
            iIndexOf = str.indexOf(93, i);
            if (iIndexOf < 0) {
                throw new XmlValueOutOfRangeException();
            }
            arrayList.add(str.substring(i + 1, iIndexOf));
            i = str.indexOf(91, iIndexOf);
        }
        if (!XmlWhitespace.isAllSpace(str.substring(iIndexOf + 1))) {
            throw new XmlValueOutOfRangeException();
        }
        this._ranks = new int[arrayList.size() - 1];
        for (int i2 = 0; i2 < this._ranks.length; i2++) {
            String str2 = (String) arrayList.get(i2);
            int i3 = 0;
            for (int i4 = 0; i4 < str2.length(); i4++) {
                char cCharAt = str2.charAt(i4);
                if (cCharAt == ',') {
                    i3++;
                } else if (!XmlWhitespace.isSpace(cCharAt)) {
                    throw new XmlValueOutOfRangeException();
                }
            }
            this._ranks[i2] = i3 + 1;
        }
        this._dimensions = internalParseCommaIntString((String) arrayList.get(arrayList.size() - 1));
    }

    public QName getQName() {
        return this._type;
    }

    public int[] getRanks() {
        int[] iArr = this._ranks;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public int[] getDimensions() {
        int[] iArr = this._dimensions;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public boolean containsNestedArrays() {
        return this._ranks.length > 0;
    }

    public String soap11DimensionString() {
        return soap11DimensionString(this._dimensions);
    }

    public String soap11DimensionString(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this._ranks.length; i++) {
            stringBuffer.append('[');
            for (int i2 = 1; i2 < this._ranks[i]; i2++) {
                stringBuffer.append(',');
            }
            stringBuffer.append(']');
        }
        stringBuffer.append('[');
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(',');
            }
            int i4 = iArr[i3];
            if (i4 >= 0) {
                stringBuffer.append(i4);
            }
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    private SOAPArrayType() {
    }

    public static SOAPArrayType newSoap12Array(QName qName, String str) {
        int[] iArr = EMPTY_INT_ARRAY;
        String[] strArrSplit = XmlWhitespace.collapse(str, 3).split(" ");
        int[] iArr2 = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (i == 0 && str2.equals("*")) {
                iArr2[i] = -1;
            } else {
                try {
                    iArr2[i] = Integer.parseInt(strArrSplit[i]);
                } catch (Exception unused) {
                    throw new XmlValueOutOfRangeException();
                }
            }
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._ranks = iArr;
        sOAPArrayType._type = qName;
        sOAPArrayType._dimensions = iArr2;
        return sOAPArrayType;
    }

    public String soap12DimensionString(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(' ');
            }
            int i2 = iArr[i];
            if (i2 >= 0) {
                stringBuffer.append(i2);
            }
        }
        return stringBuffer.toString();
    }

    public SOAPArrayType nestedArrayType() {
        if (!containsNestedArrays()) {
            throw new IllegalStateException();
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._type = this._type;
        int[] iArr = new int[this._ranks.length - 1];
        sOAPArrayType._ranks = iArr;
        int i = 0;
        System.arraycopy(this._ranks, 0, iArr, 0, iArr.length);
        int[] iArr2 = this._ranks;
        sOAPArrayType._dimensions = new int[iArr2[iArr2.length - 1]];
        while (true) {
            int[] iArr3 = sOAPArrayType._dimensions;
            if (i >= iArr3.length) {
                return sOAPArrayType;
            }
            iArr3[i] = -1;
            i++;
        }
    }

    public int hashCode() {
        int iHashCode = this._type.hashCode();
        int[] iArr = this._dimensions;
        return iHashCode + iArr.length + this._ranks.length + (iArr.length != 0 ? iArr[0] : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        SOAPArrayType sOAPArrayType = (SOAPArrayType) obj;
        if (!this._type.equals(sOAPArrayType._type) || this._ranks.length != sOAPArrayType._ranks.length || this._dimensions.length != sOAPArrayType._dimensions.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this._ranks;
            if (i >= iArr.length) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this._dimensions;
                    if (i2 >= iArr2.length) {
                        return true;
                    }
                    if (iArr2[i2] != sOAPArrayType._dimensions[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (iArr[i] != sOAPArrayType._ranks[i]) {
                    return false;
                }
                i++;
            }
        }
    }
}
