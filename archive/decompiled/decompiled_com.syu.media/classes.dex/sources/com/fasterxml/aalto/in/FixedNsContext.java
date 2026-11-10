package com.fasterxml.aalto.in;

import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import org.codehaus.stax2.ri.EmptyIterator;
import org.codehaus.stax2.ri.SingletonIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class FixedNsContext implements NamespaceContext {
    public static final FixedNsContext EMPTY_CONTEXT = new FixedNsContext(null, new String[0]);
    protected final String[] _declarationData;
    protected final NsDeclaration _lastDeclaration;
    protected ArrayList<String> _tmpDecl = null;

    private FixedNsContext(NsDeclaration nsDeclaration, String[] strArr) {
        this._lastDeclaration = nsDeclaration;
        this._declarationData = strArr;
    }

    public FixedNsContext reuseOrCreate(NsDeclaration nsDeclaration) {
        if (nsDeclaration == this._lastDeclaration) {
            return this;
        }
        if (this == EMPTY_CONTEXT) {
            ArrayList arrayList = new ArrayList();
            for (NsDeclaration prev = nsDeclaration; prev != null; prev = prev.getPrev()) {
                arrayList.add(prev.getPrefix());
                arrayList.add(prev.getCurrNsURI());
            }
            return new FixedNsContext(nsDeclaration, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        ArrayList<String> arrayList2 = this._tmpDecl;
        if (arrayList2 == null) {
            this._tmpDecl = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        for (NsDeclaration prev2 = nsDeclaration; prev2 != null; prev2 = prev2.getPrev()) {
            this._tmpDecl.add(prev2.getPrefix());
            this._tmpDecl.add(prev2.getCurrNsURI());
        }
        ArrayList<String> arrayList3 = this._tmpDecl;
        return new FixedNsContext(nsDeclaration, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null prefix not allowed");
        }
        if (str.length() > 0) {
            if (str.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            if (str.equals("xmlns")) {
                return "http://www.w3.org/2000/xmlns/";
            }
        }
        String[] strArr = this._declarationData;
        int length = strArr.length;
        for (int i = 0; i < length; i += 2) {
            if (str.equals(strArr[i])) {
                return strArr[i + 1];
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getPrefix(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        if (str.equals("http://www.w3.org/XML/1998/namespace")) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        String[] strArr = this._declarationData;
        int length = strArr.length;
        for (int i = 1; i < length; i += 2) {
            if (str.equals(strArr[i])) {
                int i2 = i - 1;
                String str2 = strArr[i2];
                for (int i3 = i + 1; i3 < length; i3 += 2) {
                    if (strArr[i3] != str2) {
                    }
                }
                return strArr[i2];
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final Iterator<String> getPrefixes(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        if (str.equals("http://www.w3.org/XML/1998/namespace")) {
            return SingletonIterator.create("xml");
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return SingletonIterator.create("xmlns");
        }
        String[] strArr = this._declarationData;
        int length = strArr.length;
        ArrayList arrayList = null;
        String str2 = null;
        for (int i = 1; i < length; i += 2) {
            String str3 = strArr[i];
            if (str3 == str || str3.equals(str)) {
                String str4 = strArr[i - 1];
                int i2 = i + 1;
                while (true) {
                    if (i2 >= length) {
                        if (str2 != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayList.add(str2);
                            }
                            arrayList.add(str4);
                            break;
                        }
                        str2 = str4;
                        break;
                    }
                    if (strArr[i2] == str4) {
                        break;
                    }
                    i2 += 2;
                }
            }
        }
        if (arrayList != null) {
            return arrayList.iterator();
        }
        if (str2 != null) {
            return SingletonIterator.create(str2);
        }
        return EmptyIterator.getInstance();
    }

    public String toString() {
        if (this == EMPTY_CONTEXT) {
            return "[EMPTY non-transient NsContext]";
        }
        StringBuilder sb = new StringBuilder("[");
        int length = this._declarationData.length;
        for (int i = 0; i < length; i += 2) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append('\"').append(this._declarationData[i]).append("\"->\"");
            sb.append(this._declarationData[i + 1]).append('\"');
        }
        sb.append(']');
        return sb.toString();
    }
}
