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
public interface CTBr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbr7dd8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBr newInstance() {
            return (CTBr) POIXMLTypeLoader.newInstance(CTBr.type, (XmlOptions) null);
        }

        public static CTBr newInstance(XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.newInstance(CTBr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(File file) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(file, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(file, CTBr.type, xmlOptions);
        }

        public static CTBr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(inputStream, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(inputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(Reader reader) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(reader, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(reader, CTBr.type, xmlOptions);
        }

        public static CTBr parse(String str) throws XmlException {
            return (CTBr) POIXMLTypeLoader.parse(str, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBr) POIXMLTypeLoader.parse(str, CTBr.type, xmlOptions);
        }

        public static CTBr parse(URL url) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(url, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) POIXMLTypeLoader.parse(url, CTBr.type, xmlOptions);
        }

        public static CTBr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBr) POIXMLTypeLoader.parse(xMLStreamReader, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBr) POIXMLTypeLoader.parse(xMLStreamReader, CTBr.type, xmlOptions);
        }

        public static CTBr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBr) POIXMLTypeLoader.parse(xMLInputStream, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBr) POIXMLTypeLoader.parse(xMLInputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(Node node) throws XmlException {
            return (CTBr) POIXMLTypeLoader.parse(node, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBr) POIXMLTypeLoader.parse(node, CTBr.type, xmlOptions);
        }
    }

    STBrClear.Enum getClear();

    STBrType.Enum getType();

    boolean isSetClear();

    boolean isSetType();

    void setClear(STBrClear.Enum r1);

    void setType(STBrType.Enum r1);

    void unsetClear();

    void unsetType();

    STBrClear xgetClear();

    STBrType xgetType();

    void xsetClear(STBrClear sTBrClear);

    void xsetType(STBrType sTBrType);
}
