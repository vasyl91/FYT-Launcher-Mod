package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTLanguage extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLanguage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlanguage7b90type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLanguage newInstance() {
            return (CTLanguage) POIXMLTypeLoader.newInstance(CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage newInstance(XmlOptions xmlOptions) {
            return (CTLanguage) POIXMLTypeLoader.newInstance(CTLanguage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLanguage.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(File file) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(file, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(file, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(inputStream, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(inputStream, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(Reader reader) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(reader, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(reader, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(String str) throws XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(str, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(str, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(URL url) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(url, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLanguage) POIXMLTypeLoader.parse(url, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(xMLStreamReader, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(xMLStreamReader, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(xMLInputStream, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(xMLInputStream, CTLanguage.type, xmlOptions);
        }

        public static CTLanguage parse(Node node) throws XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(node, CTLanguage.type, (XmlOptions) null);
        }

        public static CTLanguage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLanguage) POIXMLTypeLoader.parse(node, CTLanguage.type, xmlOptions);
        }
    }

    Object getBidi();

    Object getEastAsia();

    Object getVal();

    boolean isSetBidi();

    boolean isSetEastAsia();

    boolean isSetVal();

    void setBidi(Object obj);

    void setEastAsia(Object obj);

    void setVal(Object obj);

    void unsetBidi();

    void unsetEastAsia();

    void unsetVal();

    STLang xgetBidi();

    STLang xgetEastAsia();

    STLang xgetVal();

    void xsetBidi(STLang sTLang);

    void xsetEastAsia(STLang sTLang);

    void xsetVal(STLang sTLang);
}
