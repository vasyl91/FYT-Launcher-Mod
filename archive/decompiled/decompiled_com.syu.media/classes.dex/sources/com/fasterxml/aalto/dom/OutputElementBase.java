package com.fasterxml.aalto.dom;

import chip.FinalChip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.ri.EmptyIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class OutputElementBase implements NamespaceContext {
    public static final int PREFIX_MISBOUND = 2;
    public static final int PREFIX_OK = 1;
    public static final int PREFIX_UNBOUND = 0;
    protected String _defaultNsURI;
    protected boolean _nsMapShared;
    protected BijectiveNsMap _nsMapping;
    protected NamespaceContext _rootNsContext;

    public abstract String getNameDesc();

    public abstract boolean isRoot();

    public abstract void setDefaultNsUri(String str);

    protected abstract void setRootNsContext(NamespaceContext namespaceContext);

    protected OutputElementBase() {
        this._nsMapping = null;
        this._nsMapShared = false;
        this._defaultNsURI = FinalChip.BSP_PLATFORM_Null;
        this._rootNsContext = null;
    }

    protected OutputElementBase(OutputElementBase outputElementBase, BijectiveNsMap bijectiveNsMap) {
        this._nsMapping = bijectiveNsMap;
        this._nsMapShared = bijectiveNsMap != null;
        this._defaultNsURI = outputElementBase._defaultNsURI;
        this._rootNsContext = outputElementBase._rootNsContext;
    }

    protected void relink(OutputElementBase outputElementBase) {
        BijectiveNsMap bijectiveNsMap = outputElementBase._nsMapping;
        this._nsMapping = bijectiveNsMap;
        this._nsMapShared = bijectiveNsMap != null;
        this._defaultNsURI = outputElementBase._defaultNsURI;
        this._rootNsContext = outputElementBase._rootNsContext;
    }

    public final String getDefaultNsUri() {
        return this._defaultNsURI;
    }

    public final String getExplicitPrefix(String str) {
        String prefix;
        String strFindPrefixByUri;
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        if (bijectiveNsMap != null && (strFindPrefixByUri = bijectiveNsMap.findPrefixByUri(str)) != null) {
            return strFindPrefixByUri;
        }
        NamespaceContext namespaceContext = this._rootNsContext;
        if (namespaceContext == null || (prefix = namespaceContext.getPrefix(str)) == null || prefix.length() <= 0) {
            return null;
        }
        return prefix;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final int isPrefixValid(String str, String str2, boolean z) throws XMLStreamException {
        NamespaceContext namespaceContext;
        if (str2 == null) {
            str2 = FinalChip.BSP_PLATFORM_Null;
        }
        if (str == null || str.length() == 0) {
            if (z) {
                String str3 = this._defaultNsURI;
                if (str2 == str3 || str2.equals(str3)) {
                    return 1;
                }
            } else if (str2.length() == 0) {
                return 1;
            }
            return 2;
        }
        if ("xml".equals(str)) {
            if (!str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throwOutputError("Namespace prefix 'xml' can not be bound to non-default namespace ('" + str2 + "'); has to be the default 'http://www.w3.org/XML/1998/namespace'");
            }
            return 1;
        }
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        String strFindUriByPrefix = bijectiveNsMap != null ? bijectiveNsMap.findUriByPrefix(str) : null;
        if (strFindUriByPrefix == null && (namespaceContext = this._rootNsContext) != null) {
            strFindUriByPrefix = namespaceContext.getNamespaceURI(str);
        }
        if (strFindUriByPrefix == null) {
            return 0;
        }
        return (strFindUriByPrefix == str2 || strFindUriByPrefix.equals(str2)) ? 1 : 2;
    }

    public final String generateMapping(String str, String str2, int[] iArr) {
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        if (bijectiveNsMap == null) {
            this._nsMapping = BijectiveNsMap.createEmpty();
        } else if (this._nsMapShared) {
            this._nsMapping = bijectiveNsMap.createChild();
            this._nsMapShared = false;
        }
        return this._nsMapping.addGeneratedMapping(str, this._rootNsContext, str2, iArr);
    }

    public final void addPrefix(String str, String str2) {
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        if (bijectiveNsMap == null) {
            this._nsMapping = BijectiveNsMap.createEmpty();
        } else if (this._nsMapShared) {
            this._nsMapping = bijectiveNsMap.createChild();
            this._nsMapShared = false;
        }
        this._nsMapping.addMapping(str, str2);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String str) {
        String strFindUriByPrefix;
        if (str.length() == 0) {
            return this._defaultNsURI;
        }
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        if (bijectiveNsMap != null && (strFindUriByPrefix = bijectiveNsMap.findUriByPrefix(str)) != null) {
            return strFindUriByPrefix;
        }
        NamespaceContext namespaceContext = this._rootNsContext;
        if (namespaceContext != null) {
            return namespaceContext.getNamespaceURI(str);
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getPrefix(String str) {
        String strFindPrefixByUri;
        if (this._defaultNsURI.equals(str)) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        if (bijectiveNsMap != null && (strFindPrefixByUri = bijectiveNsMap.findPrefixByUri(str)) != null) {
            return strFindPrefixByUri;
        }
        NamespaceContext namespaceContext = this._rootNsContext;
        if (namespaceContext != null) {
            return namespaceContext.getPrefix(str);
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final Iterator<String> getPrefixes(String str) {
        List<String> arrayList;
        if (this._defaultNsURI.equals(str)) {
            arrayList = new ArrayList<>();
            arrayList.add(FinalChip.BSP_PLATFORM_Null);
        } else {
            arrayList = null;
        }
        BijectiveNsMap bijectiveNsMap = this._nsMapping;
        if (bijectiveNsMap != null) {
            arrayList = bijectiveNsMap.getPrefixesBoundToUri(str, arrayList);
        }
        NamespaceContext namespaceContext = this._rootNsContext;
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void throwOutputError(String str) throws XMLStreamException {
        throw new XMLStreamException(str);
    }
}
