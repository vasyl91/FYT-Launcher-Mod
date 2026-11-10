package org.etsi.uri.x01903.v13;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ResponderIDType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ResponderIDType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("responderidtype55b9type");

    public static final class Factory {
        private Factory() {
        }

        public static ResponderIDType newInstance() {
            return (ResponderIDType) POIXMLTypeLoader.newInstance(ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType newInstance(XmlOptions xmlOptions) {
            return (ResponderIDType) POIXMLTypeLoader.newInstance(ResponderIDType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ResponderIDType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(File file) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(file, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(file, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(InputStream inputStream) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(inputStream, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(inputStream, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(Reader reader) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(reader, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(reader, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(String str) throws XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(str, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(str, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(URL url) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(url, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) POIXMLTypeLoader.parse(url, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(xMLStreamReader, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(xMLStreamReader, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(xMLInputStream, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(xMLInputStream, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(Node node) throws XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(node, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ResponderIDType) POIXMLTypeLoader.parse(node, ResponderIDType.type, xmlOptions);
        }
    }

    byte[] getByKey();

    String getByName();

    boolean isSetByKey();

    boolean isSetByName();

    void setByKey(byte[] bArr);

    void setByName(String str);

    void unsetByKey();

    void unsetByName();

    XmlBase64Binary xgetByKey();

    XmlString xgetByName();

    void xsetByKey(XmlBase64Binary xmlBase64Binary);

    void xsetByName(XmlString xmlString);
}
