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
public interface CTColorMappingOverride extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTColorMappingOverride.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolormappingoverridea2b2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColorMappingOverride newInstance() {
            return (CTColorMappingOverride) POIXMLTypeLoader.newInstance(CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride newInstance(XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.newInstance(CTColorMappingOverride.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(File file) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(file, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(file, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(inputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(inputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(Reader reader) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(reader, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(reader, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(String str) throws XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(str, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(str, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(URL url) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(url, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(url, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLStreamReader, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLStreamReader, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLInputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLInputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(Node node) throws XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(node, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(node, CTColorMappingOverride.type, xmlOptions);
        }
    }

    CTEmptyElement addNewMasterClrMapping();

    CTColorMapping addNewOverrideClrMapping();

    CTEmptyElement getMasterClrMapping();

    CTColorMapping getOverrideClrMapping();

    boolean isSetMasterClrMapping();

    boolean isSetOverrideClrMapping();

    void setMasterClrMapping(CTEmptyElement cTEmptyElement);

    void setOverrideClrMapping(CTColorMapping cTColorMapping);

    void unsetMasterClrMapping();

    void unsetOverrideClrMapping();
}
