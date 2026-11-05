package com.microsoft.schemas.office.visio.x2012.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ConnectsType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ConnectsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("connectstype8750type");

    public static final class Factory {
        private Factory() {
        }

        public static ConnectsType newInstance() {
            return (ConnectsType) POIXMLTypeLoader.newInstance(ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType newInstance(XmlOptions xmlOptions) {
            return (ConnectsType) POIXMLTypeLoader.newInstance(ConnectsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ConnectsType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(File file) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(file, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(file, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(InputStream inputStream) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(inputStream, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(inputStream, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(Reader reader) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(reader, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(reader, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(String str) throws XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(str, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(str, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(URL url) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(url, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConnectsType) POIXMLTypeLoader.parse(url, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(xMLStreamReader, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(xMLStreamReader, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(xMLInputStream, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(xMLInputStream, ConnectsType.type, xmlOptions);
        }

        public static ConnectsType parse(Node node) throws XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(node, ConnectsType.type, (XmlOptions) null);
        }

        public static ConnectsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ConnectsType) POIXMLTypeLoader.parse(node, ConnectsType.type, xmlOptions);
        }
    }

    ConnectType addNewConnect();

    ConnectType getConnectArray(int i);

    ConnectType[] getConnectArray();

    List<ConnectType> getConnectList();

    ConnectType insertNewConnect(int i);

    void removeConnect(int i);

    void setConnectArray(int i, ConnectType connectType);

    void setConnectArray(ConnectType[] connectTypeArr);

    int sizeOfConnectArray();
}
