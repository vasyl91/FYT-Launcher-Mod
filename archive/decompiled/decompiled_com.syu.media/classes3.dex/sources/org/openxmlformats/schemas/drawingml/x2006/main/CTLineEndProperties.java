package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTLineEndProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLineEndProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlineendproperties8acbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineEndProperties newInstance() {
            return (CTLineEndProperties) POIXMLTypeLoader.newInstance(CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties newInstance(XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.newInstance(CTLineEndProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(File file) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(file, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(file, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(inputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(inputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(Reader reader) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(reader, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(reader, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(String str) throws XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(str, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(str, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(URL url) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(url, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(url, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(Node node) throws XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(node, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(node, CTLineEndProperties.type, xmlOptions);
        }
    }

    STLineEndLength.Enum getLen();

    STLineEndType.Enum getType();

    STLineEndWidth.Enum getW();

    boolean isSetLen();

    boolean isSetType();

    boolean isSetW();

    void setLen(STLineEndLength.Enum r1);

    void setType(STLineEndType.Enum r1);

    void setW(STLineEndWidth.Enum r1);

    void unsetLen();

    void unsetType();

    void unsetW();

    STLineEndLength xgetLen();

    STLineEndType xgetType();

    STLineEndWidth xgetW();

    void xsetLen(STLineEndLength sTLineEndLength);

    void xsetType(STLineEndType sTLineEndType);

    void xsetW(STLineEndWidth sTLineEndWidth);
}
