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
public interface CTPivotCacheRecords extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPivotCacheRecords.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotcacherecords5be1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotCacheRecords newInstance() {
            return (CTPivotCacheRecords) POIXMLTypeLoader.newInstance(CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords newInstance(XmlOptions xmlOptions) {
            return (CTPivotCacheRecords) POIXMLTypeLoader.newInstance(CTPivotCacheRecords.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(File file) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(file, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(file, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(inputStream, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(inputStream, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(Reader reader) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(reader, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(reader, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(String str) throws XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(str, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(str, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(URL url) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(url, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(url, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(xMLInputStream, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(xMLInputStream, CTPivotCacheRecords.type, xmlOptions);
        }

        public static CTPivotCacheRecords parse(Node node) throws XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(node, CTPivotCacheRecords.type, (XmlOptions) null);
        }

        public static CTPivotCacheRecords parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotCacheRecords) POIXMLTypeLoader.parse(node, CTPivotCacheRecords.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTRecord addNewR();

    long getCount();

    CTExtensionList getExtLst();

    CTRecord getRArray(int i);

    CTRecord[] getRArray();

    List<CTRecord> getRList();

    CTRecord insertNewR(int i);

    boolean isSetCount();

    boolean isSetExtLst();

    void removeR(int i);

    void setCount(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setRArray(int i, CTRecord cTRecord);

    void setRArray(CTRecord[] cTRecordArr);

    int sizeOfRArray();

    void unsetCount();

    void unsetExtLst();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
