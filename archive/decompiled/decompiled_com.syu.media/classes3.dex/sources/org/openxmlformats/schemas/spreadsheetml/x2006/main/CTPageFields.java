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
public interface CTPageFields extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPageFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagefields1db1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageFields newInstance() {
            return (CTPageFields) POIXMLTypeLoader.newInstance(CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields newInstance(XmlOptions xmlOptions) {
            return (CTPageFields) POIXMLTypeLoader.newInstance(CTPageFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageFields.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(File file) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(file, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(file, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(inputStream, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(inputStream, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(Reader reader) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(reader, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(reader, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(String str) throws XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(str, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(str, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(URL url) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(url, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageFields) POIXMLTypeLoader.parse(url, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(xMLStreamReader, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(xMLStreamReader, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(xMLInputStream, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(xMLInputStream, CTPageFields.type, xmlOptions);
        }

        public static CTPageFields parse(Node node) throws XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(node, CTPageFields.type, (XmlOptions) null);
        }

        public static CTPageFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageFields) POIXMLTypeLoader.parse(node, CTPageFields.type, xmlOptions);
        }
    }

    CTPageField addNewPageField();

    long getCount();

    CTPageField getPageFieldArray(int i);

    CTPageField[] getPageFieldArray();

    List<CTPageField> getPageFieldList();

    CTPageField insertNewPageField(int i);

    boolean isSetCount();

    void removePageField(int i);

    void setCount(long j);

    void setPageFieldArray(int i, CTPageField cTPageField);

    void setPageFieldArray(CTPageField[] cTPageFieldArr);

    int sizeOfPageFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
