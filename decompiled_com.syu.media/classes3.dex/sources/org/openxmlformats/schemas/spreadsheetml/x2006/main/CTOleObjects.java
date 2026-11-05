package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTOleObjects extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOleObjects.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctoleobjects1455type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOleObjects newInstance() {
            return (CTOleObjects) POIXMLTypeLoader.newInstance(CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects newInstance(XmlOptions xmlOptions) {
            return (CTOleObjects) POIXMLTypeLoader.newInstance(CTOleObjects.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOleObjects.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(File file) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(file, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(file, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(inputStream, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(inputStream, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(Reader reader) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(reader, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(reader, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(String str) throws XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(str, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(str, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(URL url) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(url, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObjects) POIXMLTypeLoader.parse(url, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(xMLStreamReader, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(xMLStreamReader, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(xMLInputStream, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(xMLInputStream, CTOleObjects.type, xmlOptions);
        }

        public static CTOleObjects parse(Node node) throws XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(node, CTOleObjects.type, (XmlOptions) null);
        }

        public static CTOleObjects parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOleObjects) POIXMLTypeLoader.parse(node, CTOleObjects.type, xmlOptions);
        }
    }

    CTOleObject addNewOleObject();

    CTOleObject getOleObjectArray(int i);

    CTOleObject[] getOleObjectArray();

    List<CTOleObject> getOleObjectList();

    CTOleObject insertNewOleObject(int i);

    void removeOleObject(int i);

    void setOleObjectArray(int i, CTOleObject cTOleObject);

    void setOleObjectArray(CTOleObject[] cTOleObjectArr);

    int sizeOfOleObjectArray();
}
