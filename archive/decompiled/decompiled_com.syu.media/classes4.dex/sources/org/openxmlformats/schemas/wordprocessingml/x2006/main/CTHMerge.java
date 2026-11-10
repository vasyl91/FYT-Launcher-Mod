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
public interface CTHMerge extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTHMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthmerge1bf8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHMerge newInstance() {
            return (CTHMerge) POIXMLTypeLoader.newInstance(CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge newInstance(XmlOptions xmlOptions) {
            return (CTHMerge) POIXMLTypeLoader.newInstance(CTHMerge.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHMerge.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(File file) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(file, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(file, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(inputStream, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(inputStream, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(Reader reader) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(reader, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(reader, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(String str) throws XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(str, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(str, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(URL url) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(url, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) POIXMLTypeLoader.parse(url, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(xMLStreamReader, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(xMLStreamReader, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(xMLInputStream, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(xMLInputStream, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(Node node) throws XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(node, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHMerge) POIXMLTypeLoader.parse(node, CTHMerge.type, xmlOptions);
        }
    }

    STMerge.Enum getVal();

    boolean isSetVal();

    void setVal(STMerge.Enum r1);

    void unsetVal();

    STMerge xgetVal();

    void xsetVal(STMerge sTMerge);
}
