package com.fasterxml.aalto.dom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.NamespaceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class BijectiveNsMap {
    static final int DEFAULT_ARRAY_SIZE = 32;
    String[] _nsStrings;
    int _scopeEnd;
    final int _scopeStart;

    private BijectiveNsMap(int i, String[] strArr) {
        this._scopeEnd = i;
        this._scopeStart = i;
        this._nsStrings = strArr;
    }

    public static BijectiveNsMap createEmpty() {
        String[] strArr = new String[32];
        strArr[0] = "xml";
        strArr[1] = "http://www.w3.org/XML/1998/namespace";
        strArr[2] = "xmlns";
        strArr[3] = "http://www.w3.org/2000/xmlns/";
        return new BijectiveNsMap(4, strArr);
    }

    public BijectiveNsMap createChild() {
        return new BijectiveNsMap(this._scopeEnd, this._nsStrings);
    }

    public String findUriByPrefix(String str) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        for (int i = this._scopeEnd - 2; i >= 0; i -= 2) {
            String str2 = strArr[i];
            if (str2 == str || (str2.hashCode() == iHashCode && str2.equals(str))) {
                return strArr[i + 1];
            }
        }
        return null;
    }

    public String findPrefixByUri(String str) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        for (int i = this._scopeEnd - 1; i > 0; i -= 2) {
            String str2 = strArr[i];
            if (str2 == str || (str2.hashCode() == iHashCode && str2.equals(str))) {
                int i2 = i - 1;
                String str3 = strArr[i2];
                if (i < this._scopeStart) {
                    int iHashCode2 = str3.hashCode();
                    int i3 = this._scopeEnd;
                    while (i2 < i3) {
                        String str4 = strArr[i];
                        if (str4 != str3 && (str4.hashCode() != iHashCode2 || !str4.equals(str3))) {
                            i2 += 2;
                        }
                    }
                }
                return str3;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    public List<String> getPrefixesBoundToUri(String str, List<String> list) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        for (int i = this._scopeEnd - 1; i > 0; i -= 2) {
            String str2 = strArr[i];
            if (str2 == str || (str2.hashCode() == iHashCode && str2.equals(str))) {
                int i2 = i - 1;
                String str3 = strArr[i2];
                if (i < this._scopeStart) {
                    int iHashCode2 = str3.hashCode();
                    int i3 = this._scopeEnd;
                    while (true) {
                        if (i2 < i3) {
                            String str4 = strArr[i];
                            if (str4 != str3 && (str4.hashCode() != iHashCode2 || !str4.equals(str3))) {
                                i2 += 2;
                            }
                        } else {
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.add(str3);
                        }
                    }
                } else {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(str3);
                }
            }
        }
        return list;
    }

    public int size() {
        return this._scopeEnd >> 1;
    }

    public int localSize() {
        return (this._scopeEnd - this._scopeStart) >> 1;
    }

    public String addMapping(String str, String str2) {
        String[] strArr = this._nsStrings;
        int iHashCode = str.hashCode();
        int i = this._scopeEnd;
        for (int i2 = this._scopeStart; i2 < i; i2 += 2) {
            String str3 = strArr[i2];
            if (str3 == str || (str3.hashCode() == iHashCode && str3.equals(str))) {
                int i3 = i2 + 1;
                String str4 = strArr[i3];
                strArr[i3] = str2;
                return str4;
            }
        }
        if (this._scopeEnd >= strArr.length) {
            strArr = (String[]) Arrays.copyOf(strArr, strArr.length << 1);
            this._nsStrings = strArr;
        }
        int i4 = this._scopeEnd;
        int i5 = i4 + 1;
        strArr[i4] = str;
        this._scopeEnd = i5 + 1;
        strArr[i5] = str2;
        return null;
    }

    public String addGeneratedMapping(String str, NamespaceContext namespaceContext, String str2, int[] iArr) {
        String strIntern;
        String[] strArr = this._nsStrings;
        int i = iArr[0];
        while (true) {
            strIntern = (str + i).intern();
            i++;
            int iHashCode = strIntern.hashCode();
            int i2 = this._scopeEnd - 2;
            while (true) {
                if (i2 >= 0) {
                    String str3 = strArr[i2];
                    if (str3 == strIntern || (str3.hashCode() == iHashCode && str3.equals(strIntern))) {
                        break;
                    }
                    i2 -= 2;
                } else {
                    if (namespaceContext != null && namespaceContext.getNamespaceURI(strIntern) != null) {
                        break;
                    }
                    break;
                }
            }
        }
        iArr[0] = i;
        if (this._scopeEnd >= strArr.length) {
            strArr = (String[]) Arrays.copyOf(strArr, strArr.length << 1);
            this._nsStrings = strArr;
        }
        int i3 = this._scopeEnd;
        int i4 = i3 + 1;
        strArr[i3] = strIntern;
        this._scopeEnd = i4 + 1;
        strArr[i4] = str2;
        return strIntern;
    }
}
