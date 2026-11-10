package com.fasterxml.aalto.out;

import chip.FinalChip;
import com.fasterxml.aalto.util.EmptyIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class OutputElement {
    static final byte BYTE_GT = 62;
    static final byte BYTE_LT = 60;
    static final byte BYTE_SLASH = 47;
    String _defaultNsURI;
    WName _name;
    NsBinder _nsBinder;
    OutputElement _parent;
    String _uri;

    public enum PrefixState {
        UNBOUND,
        OK,
        MISBOUND
    }

    private OutputElement() {
        this._parent = null;
        this._name = null;
        this._uri = null;
        this._nsBinder = null;
        this._defaultNsURI = FinalChip.BSP_PLATFORM_Null;
    }

    private OutputElement(OutputElement outputElement, WName wName, String str, NsBinder nsBinder) {
        this._defaultNsURI = FinalChip.BSP_PLATFORM_Null;
        this._parent = outputElement;
        this._name = wName;
        this._uri = str;
        this._nsBinder = nsBinder;
        this._defaultNsURI = outputElement._defaultNsURI;
    }

    protected static OutputElement createRoot() {
        return new OutputElement();
    }

    protected OutputElement createChild(WName wName) {
        return new OutputElement(this, wName, this._defaultNsURI, this._nsBinder);
    }

    protected OutputElement createChild(WName wName, String str) {
        return new OutputElement(this, wName, str, this._nsBinder);
    }

    protected OutputElement reuseAsChild(OutputElement outputElement, WName wName) {
        OutputElement outputElement2 = this._parent;
        relink(outputElement, wName, this._defaultNsURI);
        return outputElement2;
    }

    protected OutputElement reuseAsChild(OutputElement outputElement, WName wName, String str) {
        OutputElement outputElement2 = this._parent;
        relink(outputElement, wName, str);
        return outputElement2;
    }

    public void relink(OutputElement outputElement) {
        this._parent = outputElement;
        this._nsBinder = outputElement._nsBinder;
        this._defaultNsURI = outputElement._defaultNsURI;
    }

    private void relink(OutputElement outputElement, WName wName, String str) {
        this._parent = outputElement;
        this._name = wName;
        this._uri = str;
        this._nsBinder = outputElement._nsBinder;
        this._defaultNsURI = outputElement._defaultNsURI;
    }

    protected void addToPool(OutputElement outputElement) {
        this._parent = outputElement;
    }

    public OutputElement getParent() {
        return this._parent;
    }

    public boolean isRoot() {
        return this._parent == null;
    }

    public WName getName() {
        return this._name;
    }

    public String getLocalName() {
        return this._name.getLocalName();
    }

    public String getNonNullPrefix() {
        if (this._name.getPrefix() == null) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        return null;
    }

    public boolean hasPrefix() {
        return this._name.hasPrefix();
    }

    public String getNameDesc() {
        return this._name.toString();
    }

    public String getNamespaceURI() {
        return this._uri;
    }

    public String getNonNullNamespaceURI() {
        String str = this._uri;
        return str == null ? FinalChip.BSP_PLATFORM_Null : str;
    }

    public String getDefaultNsURI() {
        return this._defaultNsURI;
    }

    public boolean hasEmptyDefaultNs() {
        String str = this._defaultNsURI;
        return str == null || str.length() == 0;
    }

    public QName getQName() {
        return new QName(this._uri, this._name.getLocalName(), this._name.getPrefix());
    }

    public void setDefaultNsURI(String str) {
        this._defaultNsURI = str;
    }

    public String generatePrefix(NamespaceContext namespaceContext, String str, int[] iArr) {
        if (this._nsBinder == null) {
            this._nsBinder = NsBinder.createEmpty();
        }
        return this._nsBinder.generatePrefix(str, namespaceContext, iArr);
    }

    public void addPrefix(String str, String str2) {
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder == null) {
            this._nsBinder = NsBinder.createEmpty();
        } else {
            OutputElement outputElement = this._parent;
            if (outputElement != null && outputElement._nsBinder == nsBinder) {
                this._nsBinder = nsBinder.createChild();
            }
        }
        this._nsBinder.addMapping(str, str2);
    }

    public String getNamespaceURI(String str) {
        String strFindUriByPrefix;
        if (str.length() == 0) {
            return this._defaultNsURI;
        }
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder == null || (strFindUriByPrefix = nsBinder.findUriByPrefix(str)) == null) {
            return null;
        }
        return strFindUriByPrefix;
    }

    public String getPrefix(String str) {
        String strFindPrefixByUri;
        if (this._defaultNsURI.equals(str)) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder == null || (strFindPrefixByUri = nsBinder.findPrefixByUri(str)) == null) {
            return null;
        }
        return strFindPrefixByUri;
    }

    public Iterator<String> getPrefixes(String str, NamespaceContext namespaceContext) {
        List<String> arrayList;
        if (this._defaultNsURI.equals(str)) {
            arrayList = new ArrayList<>();
            arrayList.add(FinalChip.BSP_PLATFORM_Null);
        } else {
            arrayList = null;
        }
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder != null) {
            arrayList = nsBinder.getPrefixesBoundToUri(str, arrayList);
        }
        if (namespaceContext != null) {
            Iterator prefixes = namespaceContext.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (str2.length() != 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    } else if (arrayList.contains(str2)) {
                    }
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList == null) {
            return EmptyIterator.getInstance();
        }
        return arrayList.iterator();
    }

    public String getExplicitPrefix(String str, NamespaceContext namespaceContext) {
        String prefix;
        String strFindPrefixByUri;
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder != null && (strFindPrefixByUri = nsBinder.findPrefixByUri(str)) != null) {
            return strFindPrefixByUri;
        }
        if (namespaceContext == null || (prefix = namespaceContext.getPrefix(str)) == null || prefix.length() <= 0) {
            return null;
        }
        return prefix;
    }

    public PrefixState checkPrefixValidity(String str, String str2, NamespaceContext namespaceContext) {
        if (str.equals("xml")) {
            return str2.equals("http://www.w3.org/XML/1998/namespace") ? PrefixState.OK : PrefixState.MISBOUND;
        }
        NsBinder nsBinder = this._nsBinder;
        String strFindUriByPrefix = nsBinder == null ? null : nsBinder.findUriByPrefix(str);
        if (strFindUriByPrefix == null && namespaceContext != null) {
            strFindUriByPrefix = namespaceContext.getNamespaceURI(str);
        }
        if (strFindUriByPrefix == null) {
            return PrefixState.UNBOUND;
        }
        return (strFindUriByPrefix == str2 || strFindUriByPrefix.equals(str2)) ? PrefixState.OK : PrefixState.MISBOUND;
    }

    public boolean isPrefixBoundTo(String str, String str2, NamespaceContext namespaceContext) {
        if (str == null || str.length() == 0) {
            return this._defaultNsURI.equals(str2);
        }
        if ("xml".equals(str)) {
            return str2.equals("http://www.w3.org/XML/1998/namespace");
        }
        NsBinder nsBinder = this._nsBinder;
        String strFindUriByPrefix = nsBinder == null ? null : nsBinder.findUriByPrefix(str);
        if (strFindUriByPrefix == null && namespaceContext != null) {
            strFindUriByPrefix = namespaceContext.getNamespaceURI(str);
        }
        return strFindUriByPrefix != null && (strFindUriByPrefix == str2 || strFindUriByPrefix.equals(str2));
    }

    public boolean isPrefixUnbound(String str, NamespaceContext namespaceContext) {
        String namespaceURI;
        NsBinder nsBinder = this._nsBinder;
        String strFindUriByPrefix = nsBinder == null ? null : nsBinder.findUriByPrefix(str);
        if ((strFindUriByPrefix == null || strFindUriByPrefix.length() == 0) && !str.equals("xml")) {
            return namespaceContext == null || (namespaceURI = namespaceContext.getNamespaceURI(str)) == null || namespaceURI.length() == 0;
        }
        return false;
    }

    public int hashCode() {
        return this._name.hashCode();
    }
}
