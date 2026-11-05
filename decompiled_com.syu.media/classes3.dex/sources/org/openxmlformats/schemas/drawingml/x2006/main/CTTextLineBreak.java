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
public interface CTTextLineBreak extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextLineBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextlinebreak932ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextLineBreak newInstance() {
            return (CTTextLineBreak) POIXMLTypeLoader.newInstance(CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak newInstance(XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.newInstance(CTTextLineBreak.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(File file) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(file, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(file, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(inputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(inputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(Reader reader) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(reader, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(reader, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(String str) throws XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(str, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(str, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(URL url) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(url, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(url, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLStreamReader, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLStreamReader, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLInputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLInputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(Node node) throws XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(node, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(node, CTTextLineBreak.type, xmlOptions);
        }
    }

    CTTextCharacterProperties addNewRPr();

    CTTextCharacterProperties getRPr();

    boolean isSetRPr();

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void unsetRPr();
}
