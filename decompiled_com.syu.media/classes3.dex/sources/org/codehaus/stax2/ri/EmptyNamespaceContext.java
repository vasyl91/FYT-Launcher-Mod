package org.codehaus.stax2.ri;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EmptyNamespaceContext implements NamespaceContext {
    static final EmptyNamespaceContext sInstance = new EmptyNamespaceContext();

    private EmptyNamespaceContext() {
    }

    public static EmptyNamespaceContext getInstance() {
        return sInstance;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        if (str.length() <= 0) {
            return null;
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
            throw new IllegalArgumentException("Illegal to pass null/empty URI as argument.");
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
        if (str.equals(XMLValidationSchema.SCHEMA_ID_DTD)) {
            return SingletonIterator.create(Sax2Dom.XML_PREFIX);
        }
        if (str.equals(Sax2Dom.XMLNS_URI)) {
            return SingletonIterator.create(Sax2Dom.XMLNS_PREFIX);
        }
        return EmptyIterator.getInstance();
    }
}
