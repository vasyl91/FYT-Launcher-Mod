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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTDataFields extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDataFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatafields52cctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataFields newInstance() {
            return (CTDataFields) POIXMLTypeLoader.newInstance(CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields newInstance(XmlOptions xmlOptions) {
            return (CTDataFields) POIXMLTypeLoader.newInstance(CTDataFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDataFields.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(File file) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(file, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(file, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(inputStream, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(inputStream, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(Reader reader) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(reader, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(reader, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(String str) throws XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(str, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(str, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(URL url) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(url, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataFields) POIXMLTypeLoader.parse(url, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(xMLStreamReader, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(xMLStreamReader, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(xMLInputStream, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(xMLInputStream, CTDataFields.type, xmlOptions);
        }

        public static CTDataFields parse(Node node) throws XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(node, CTDataFields.type, (XmlOptions) null);
        }

        public static CTDataFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataFields) POIXMLTypeLoader.parse(node, CTDataFields.type, xmlOptions);
        }
    }

    CTDataField addNewDataField();

    long getCount();

    CTDataField getDataFieldArray(int i);

    CTDataField[] getDataFieldArray();

    List<CTDataField> getDataFieldList();

    CTDataField insertNewDataField(int i);

    boolean isSetCount();

    void removeDataField(int i);

    void setCount(long j);

    void setDataFieldArray(int i, CTDataField cTDataField);

    void setDataFieldArray(CTDataField[] cTDataFieldArr);

    int sizeOfDataFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
