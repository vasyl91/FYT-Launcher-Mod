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
public interface SettingsDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SettingsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("settings9dd1doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SettingsDocument newInstance() {
            return (SettingsDocument) POIXMLTypeLoader.newInstance(SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument newInstance(XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.newInstance(SettingsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(File file) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(file, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(file, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(inputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(inputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(Reader reader) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(reader, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(reader, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(String str) throws XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(str, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(str, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(URL url) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(url, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SettingsDocument) POIXMLTypeLoader.parse(url, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLStreamReader, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLStreamReader, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLInputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLInputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(Node node) throws XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(node, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SettingsDocument) POIXMLTypeLoader.parse(node, SettingsDocument.type, xmlOptions);
        }
    }

    CTSettings addNewSettings();

    CTSettings getSettings();

    void setSettings(CTSettings cTSettings);
}
