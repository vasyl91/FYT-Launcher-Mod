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
public interface CTNonVisualConnectorProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNonVisualConnectorProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualconnectorproperties6f8etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualConnectorProperties newInstance() {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.newInstance(CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.newInstance(CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(File file) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(file, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(file, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(Reader reader) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(reader, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(reader, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(String str) throws XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(str, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(str, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(URL url) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(url, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(url, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualConnectorProperties.type, xmlOptions);
        }

        public static CTNonVisualConnectorProperties parse(Node node) throws XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(node, CTNonVisualConnectorProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualConnectorProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNonVisualConnectorProperties) POIXMLTypeLoader.parse(node, CTNonVisualConnectorProperties.type, xmlOptions);
        }
    }

    CTConnectorLocking addNewCxnSpLocks();

    CTConnection addNewEndCxn();

    CTOfficeArtExtensionList addNewExtLst();

    CTConnection addNewStCxn();

    CTConnectorLocking getCxnSpLocks();

    CTConnection getEndCxn();

    CTOfficeArtExtensionList getExtLst();

    CTConnection getStCxn();

    boolean isSetCxnSpLocks();

    boolean isSetEndCxn();

    boolean isSetExtLst();

    boolean isSetStCxn();

    void setCxnSpLocks(CTConnectorLocking cTConnectorLocking);

    void setEndCxn(CTConnection cTConnection);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setStCxn(CTConnection cTConnection);

    void unsetCxnSpLocks();

    void unsetEndCxn();

    void unsetExtLst();

    void unsetStCxn();
}
