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
public interface CTPivotFields extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPivotFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotfields12batype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotFields newInstance() {
            return (CTPivotFields) POIXMLTypeLoader.newInstance(CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields newInstance(XmlOptions xmlOptions) {
            return (CTPivotFields) POIXMLTypeLoader.newInstance(CTPivotFields.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotFields.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(File file) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(file, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(file, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(inputStream, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(inputStream, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(Reader reader) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(reader, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(reader, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(String str) throws XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(str, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(str, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(URL url) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(url, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotFields) POIXMLTypeLoader.parse(url, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(xMLInputStream, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(xMLInputStream, CTPivotFields.type, xmlOptions);
        }

        public static CTPivotFields parse(Node node) throws XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(node, CTPivotFields.type, (XmlOptions) null);
        }

        public static CTPivotFields parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotFields) POIXMLTypeLoader.parse(node, CTPivotFields.type, xmlOptions);
        }
    }

    CTPivotField addNewPivotField();

    long getCount();

    CTPivotField getPivotFieldArray(int i);

    CTPivotField[] getPivotFieldArray();

    List<CTPivotField> getPivotFieldList();

    CTPivotField insertNewPivotField(int i);

    boolean isSetCount();

    void removePivotField(int i);

    void setCount(long j);

    void setPivotFieldArray(int i, CTPivotField cTPivotField);

    void setPivotFieldArray(CTPivotField[] cTPivotFieldArr);

    int sizeOfPivotFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
