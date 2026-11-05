package org.etsi.uri.x01903.v13;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface OCSPIdentifierType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(OCSPIdentifierType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ocspidentifiertype3968type");

    public static final class Factory {
        private Factory() {
        }

        public static OCSPIdentifierType newInstance() {
            return (OCSPIdentifierType) POIXMLTypeLoader.newInstance(OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType newInstance(XmlOptions xmlOptions) {
            return (OCSPIdentifierType) POIXMLTypeLoader.newInstance(OCSPIdentifierType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(File file) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(file, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(file, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(InputStream inputStream) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(inputStream, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(inputStream, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(Reader reader) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(reader, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(reader, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(String str) throws XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(str, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(str, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(URL url) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(url, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(url, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(xMLStreamReader, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(xMLStreamReader, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(xMLInputStream, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(xMLInputStream, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(Node node) throws XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(node, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (OCSPIdentifierType) POIXMLTypeLoader.parse(node, OCSPIdentifierType.type, xmlOptions);
        }
    }

    ResponderIDType addNewResponderID();

    Calendar getProducedAt();

    ResponderIDType getResponderID();

    String getURI();

    boolean isSetURI();

    void setProducedAt(Calendar calendar);

    void setResponderID(ResponderIDType responderIDType);

    void setURI(String str);

    void unsetURI();

    XmlDateTime xgetProducedAt();

    XmlAnyURI xgetURI();

    void xsetProducedAt(XmlDateTime xmlDateTime);

    void xsetURI(XmlAnyURI xmlAnyURI);
}
