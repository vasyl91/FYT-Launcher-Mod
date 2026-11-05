package org.apache.xmlbeans;

import javax.xml.namespace.QName;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlSaxHandler {
    void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

    void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark);

    ContentHandler getContentHandler();

    LexicalHandler getLexicalHandler();

    XmlObject getObject() throws XmlException;
}
