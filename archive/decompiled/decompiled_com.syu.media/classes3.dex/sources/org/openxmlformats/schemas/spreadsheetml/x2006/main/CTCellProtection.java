package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCellProtection extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCellProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellprotectionf524type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellProtection newInstance() {
            return (CTCellProtection) POIXMLTypeLoader.newInstance(CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection newInstance(XmlOptions xmlOptions) {
            return (CTCellProtection) POIXMLTypeLoader.newInstance(CTCellProtection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellProtection.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(File file) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(file, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(file, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(inputStream, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(inputStream, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(Reader reader) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(reader, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(reader, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(String str) throws XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(str, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(str, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(URL url) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(url, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellProtection) POIXMLTypeLoader.parse(url, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(xMLStreamReader, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(xMLStreamReader, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(xMLInputStream, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(xMLInputStream, CTCellProtection.type, xmlOptions);
        }

        public static CTCellProtection parse(Node node) throws XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(node, CTCellProtection.type, (XmlOptions) null);
        }

        public static CTCellProtection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCellProtection) POIXMLTypeLoader.parse(node, CTCellProtection.type, xmlOptions);
        }
    }

    boolean getHidden();

    boolean getLocked();

    boolean isSetHidden();

    boolean isSetLocked();

    void setHidden(boolean z);

    void setLocked(boolean z);

    void unsetHidden();

    void unsetLocked();

    XmlBoolean xgetHidden();

    XmlBoolean xgetLocked();

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetLocked(XmlBoolean xmlBoolean);
}
