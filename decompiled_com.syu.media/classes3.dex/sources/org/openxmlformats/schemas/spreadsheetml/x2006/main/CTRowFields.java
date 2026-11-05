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
public interface CTRowFields extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRowFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrowfields0312type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRowFields newInstance() {
            return (CTRowFields) POIXMLTypeLoader.newInstance(CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields newInstance(XmlOptions xmlOptions) {
            return (CTRowFields) POIXMLTypeLoader.newInstance(CTRowFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRowFields.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(File file) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(file, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(file, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(inputStream, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(inputStream, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(Reader reader) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(reader, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(reader, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(String str) throws XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(str, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(str, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(URL url) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(url, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRowFields) POIXMLTypeLoader.parse(url, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(xMLStreamReader, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(xMLStreamReader, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(xMLInputStream, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(xMLInputStream, CTRowFields.type, xmlOptions);
        }

        public static CTRowFields parse(Node node) throws XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(node, CTRowFields.type, (XmlOptions) null);
        }

        public static CTRowFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRowFields) POIXMLTypeLoader.parse(node, CTRowFields.type, xmlOptions);
        }
    }

    CTField addNewField();

    long getCount();

    CTField getFieldArray(int i);

    CTField[] getFieldArray();

    List<CTField> getFieldList();

    CTField insertNewField(int i);

    boolean isSetCount();

    void removeField(int i);

    void setCount(long j);

    void setFieldArray(int i, CTField cTField);

    void setFieldArray(CTField[] cTFieldArr);

    int sizeOfFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
