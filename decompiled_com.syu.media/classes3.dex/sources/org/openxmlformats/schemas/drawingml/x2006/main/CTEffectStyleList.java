package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTEffectStyleList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTEffectStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cteffectstylelistc50ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEffectStyleList newInstance() {
            return (CTEffectStyleList) POIXMLTypeLoader.newInstance(CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList newInstance(XmlOptions xmlOptions) {
            return (CTEffectStyleList) POIXMLTypeLoader.newInstance(CTEffectStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(File file) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(file, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(file, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(inputStream, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(inputStream, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(Reader reader) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(reader, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(reader, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(String str) throws XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(str, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(str, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(URL url) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(url, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(url, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(Node node) throws XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(node, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleList) POIXMLTypeLoader.parse(node, CTEffectStyleList.type, xmlOptions);
        }
    }

    CTEffectStyleItem addNewEffectStyle();

    CTEffectStyleItem getEffectStyleArray(int i);

    CTEffectStyleItem[] getEffectStyleArray();

    List<CTEffectStyleItem> getEffectStyleList();

    CTEffectStyleItem insertNewEffectStyle(int i);

    void removeEffectStyle(int i);

    void setEffectStyleArray(int i, CTEffectStyleItem cTEffectStyleItem);

    void setEffectStyleArray(CTEffectStyleItem[] cTEffectStyleItemArr);

    int sizeOfEffectStyleArray();
}
