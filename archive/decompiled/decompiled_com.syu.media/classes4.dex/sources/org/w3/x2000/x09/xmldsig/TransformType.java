package org.w3.x2000.x09.xmldsig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface TransformType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TransformType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("transformtype550btype");

    public static final class Factory {
        private Factory() {
        }

        public static TransformType newInstance() {
            return (TransformType) POIXMLTypeLoader.newInstance(TransformType.type, (XmlOptions) null);
        }

        public static TransformType newInstance(XmlOptions xmlOptions) {
            return (TransformType) POIXMLTypeLoader.newInstance(TransformType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TransformType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TransformType.type, xmlOptions);
        }

        public static TransformType parse(File file) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(file, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(file, TransformType.type, xmlOptions);
        }

        public static TransformType parse(InputStream inputStream) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(inputStream, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(inputStream, TransformType.type, xmlOptions);
        }

        public static TransformType parse(Reader reader) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(reader, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(reader, TransformType.type, xmlOptions);
        }

        public static TransformType parse(String str) throws XmlException {
            return (TransformType) POIXMLTypeLoader.parse(str, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TransformType) POIXMLTypeLoader.parse(str, TransformType.type, xmlOptions);
        }

        public static TransformType parse(URL url) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(url, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformType) POIXMLTypeLoader.parse(url, TransformType.type, xmlOptions);
        }

        public static TransformType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TransformType) POIXMLTypeLoader.parse(xMLStreamReader, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TransformType) POIXMLTypeLoader.parse(xMLStreamReader, TransformType.type, xmlOptions);
        }

        public static TransformType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TransformType) POIXMLTypeLoader.parse(xMLInputStream, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TransformType) POIXMLTypeLoader.parse(xMLInputStream, TransformType.type, xmlOptions);
        }

        public static TransformType parse(Node node) throws XmlException {
            return (TransformType) POIXMLTypeLoader.parse(node, TransformType.type, (XmlOptions) null);
        }

        public static TransformType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TransformType) POIXMLTypeLoader.parse(node, TransformType.type, xmlOptions);
        }
    }

    XmlString addNewXPath();

    void addXPath(String str);

    String getAlgorithm();

    String getXPathArray(int i);

    String[] getXPathArray();

    List<String> getXPathList();

    XmlString insertNewXPath(int i);

    void insertXPath(int i, String str);

    void removeXPath(int i);

    void setAlgorithm(String str);

    void setXPathArray(int i, String str);

    void setXPathArray(String[] strArr);

    int sizeOfXPathArray();

    XmlAnyURI xgetAlgorithm();

    XmlString xgetXPathArray(int i);

    XmlString[] xgetXPathArray();

    List<XmlString> xgetXPathList();

    void xsetAlgorithm(XmlAnyURI xmlAnyURI);

    void xsetXPathArray(int i, XmlString xmlString);

    void xsetXPathArray(XmlString[] xmlStringArr);
}
