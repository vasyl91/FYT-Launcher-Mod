package org.etsi.uri.x01903.v13;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CRLValuesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CRLValuesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("crlvaluestype0ebbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CRLValuesType newInstance() {
            return (CRLValuesType) POIXMLTypeLoader.newInstance(CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType newInstance(XmlOptions xmlOptions) {
            return (CRLValuesType) POIXMLTypeLoader.newInstance(CRLValuesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CRLValuesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(File file) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(file, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(file, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(InputStream inputStream) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(inputStream, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(inputStream, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(Reader reader) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(reader, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(reader, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(String str) throws XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(str, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(str, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(URL url) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(url, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) POIXMLTypeLoader.parse(url, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(xMLStreamReader, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(xMLStreamReader, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(xMLInputStream, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(xMLInputStream, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(Node node) throws XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(node, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CRLValuesType) POIXMLTypeLoader.parse(node, CRLValuesType.type, xmlOptions);
        }
    }

    EncapsulatedPKIDataType addNewEncapsulatedCRLValue();

    EncapsulatedPKIDataType getEncapsulatedCRLValueArray(int i);

    EncapsulatedPKIDataType[] getEncapsulatedCRLValueArray();

    List<EncapsulatedPKIDataType> getEncapsulatedCRLValueList();

    EncapsulatedPKIDataType insertNewEncapsulatedCRLValue(int i);

    void removeEncapsulatedCRLValue(int i);

    void setEncapsulatedCRLValueArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType);

    void setEncapsulatedCRLValueArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr);

    int sizeOfEncapsulatedCRLValueArray();
}
