package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTNumRef extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNumRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumref062ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumRef newInstance() {
            return (CTNumRef) POIXMLTypeLoader.newInstance(CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef newInstance(XmlOptions xmlOptions) {
            return (CTNumRef) POIXMLTypeLoader.newInstance(CTNumRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumRef.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(File file) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(file, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(file, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(inputStream, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(inputStream, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(Reader reader) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(reader, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(reader, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(String str) throws XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(str, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(str, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(URL url) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(url, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) POIXMLTypeLoader.parse(url, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(xMLStreamReader, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(xMLStreamReader, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(xMLInputStream, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(xMLInputStream, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(Node node) throws XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(node, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumRef) POIXMLTypeLoader.parse(node, CTNumRef.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTNumData addNewNumCache();

    CTExtensionList getExtLst();

    String getF();

    CTNumData getNumCache();

    boolean isSetExtLst();

    boolean isSetNumCache();

    void setExtLst(CTExtensionList cTExtensionList);

    void setF(String str);

    void setNumCache(CTNumData cTNumData);

    void unsetExtLst();

    void unsetNumCache();

    XmlString xgetF();

    void xsetF(XmlString xmlString);
}
