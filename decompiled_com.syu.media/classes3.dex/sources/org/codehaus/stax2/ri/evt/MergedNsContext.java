package org.codehaus.stax2.ri.evt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.events.Namespace;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MergedNsContext implements NamespaceContext {
    final List<Namespace> _namespaces;
    final NamespaceContext _parentCtxt;

    protected MergedNsContext(NamespaceContext namespaceContext, List<Namespace> list) {
        this._parentCtxt = namespaceContext;
        this._namespaces = list == null ? Collections.emptyList() : list;
    }

    public static MergedNsContext construct(NamespaceContext namespaceContext, List<Namespace> list) {
        return new MergedNsContext(namespaceContext, list);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        String namespaceURI;
        if (str == null) {
            throw new IllegalArgumentException("Illegal to pass null prefix");
        }
        int size = this._namespaces.size();
        for (int i = 0; i < size; i++) {
            Namespace namespace = this._namespaces.get(i);
            if (str.equals(namespace.getPrefix())) {
                return namespace.getNamespaceURI();
            }
        }
        NamespaceContext namespaceContext = this._parentCtxt;
        if (namespaceContext != null && (namespaceURI = namespaceContext.getNamespaceURI(str)) != null) {
            return namespaceURI;
        }
        if (str.equals(Sax2Dom.XML_PREFIX)) {
            return XMLValidationSchema.SCHEMA_ID_DTD;
        }
        if (str.equals(Sax2Dom.XMLNS_PREFIX)) {
            return Sax2Dom.XMLNS_URI;
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        int size = this._namespaces.size();
        for (int i = 0; i < size; i++) {
            Namespace namespace = this._namespaces.get(i);
            if (str.equals(namespace.getNamespaceURI())) {
                return namespace.getPrefix();
            }
        }
        NamespaceContext namespaceContext = this._parentCtxt;
        if (namespaceContext != null) {
            String prefix = namespaceContext.getPrefix(str);
            if (prefix != null && getNamespaceURI(prefix).equals(str)) {
                return prefix;
            }
            Iterator prefixes = this._parentCtxt.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (!str2.equals(prefix) && getNamespaceURI(str2).equals(str)) {
                    return str2;
                }
            }
        }
        if (str.equals(XMLValidationSchema.SCHEMA_ID_DTD)) {
            return Sax2Dom.XML_PREFIX;
        }
        if (str.equals(Sax2Dom.XMLNS_URI)) {
            return Sax2Dom.XMLNS_PREFIX;
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        int size = this._namespaces.size();
        ArrayList arrayListAddToList = null;
        for (int i = 0; i < size; i++) {
            Namespace namespace = this._namespaces.get(i);
            if (str.equals(namespace.getNamespaceURI())) {
                arrayListAddToList = addToList(arrayListAddToList, namespace.getPrefix());
            }
        }
        NamespaceContext namespaceContext = this._parentCtxt;
        if (namespaceContext != null) {
            Iterator prefixes = namespaceContext.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (getNamespaceURI(str2).equals(str)) {
                    arrayListAddToList = addToList(arrayListAddToList, str2);
                }
            }
        }
        if (str.equals(XMLValidationSchema.SCHEMA_ID_DTD)) {
            arrayListAddToList = addToList(arrayListAddToList, Sax2Dom.XML_PREFIX);
        }
        if (str.equals(Sax2Dom.XMLNS_URI)) {
            addToList(arrayListAddToList, Sax2Dom.XMLNS_PREFIX);
        }
        return null;
    }

    protected <T> ArrayList<T> addToList(ArrayList<T> arrayList, T t) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(t);
        return arrayList;
    }
}
