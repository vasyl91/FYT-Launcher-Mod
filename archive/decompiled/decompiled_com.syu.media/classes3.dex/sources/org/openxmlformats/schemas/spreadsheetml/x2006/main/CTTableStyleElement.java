package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTableStyleElement extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableStyleElement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestyleelementa658type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyleElement newInstance() {
            return (CTTableStyleElement) POIXMLTypeLoader.newInstance(CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement newInstance(XmlOptions xmlOptions) {
            return (CTTableStyleElement) POIXMLTypeLoader.newInstance(CTTableStyleElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(File file) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(file, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(file, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(inputStream, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(inputStream, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(reader, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(reader, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(String str) throws XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(str, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(str, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(URL url) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(url, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(url, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleElement.type, xmlOptions);
        }

        public static CTTableStyleElement parse(Node node) throws XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(node, CTTableStyleElement.type, (XmlOptions) null);
        }

        public static CTTableStyleElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleElement) POIXMLTypeLoader.parse(node, CTTableStyleElement.type, xmlOptions);
        }
    }

    long getDxfId();

    long getSize();

    STTableStyleType.Enum getType();

    boolean isSetDxfId();

    boolean isSetSize();

    void setDxfId(long j);

    void setSize(long j);

    void setType(STTableStyleType.Enum r1);

    void unsetDxfId();

    void unsetSize();

    STDxfId xgetDxfId();

    XmlUnsignedInt xgetSize();

    STTableStyleType xgetType();

    void xsetDxfId(STDxfId sTDxfId);

    void xsetSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetType(STTableStyleType sTTableStyleType);
}
