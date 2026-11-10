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
public interface CTPageBreak extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPageBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagebreakeb4ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageBreak newInstance() {
            return (CTPageBreak) POIXMLTypeLoader.newInstance(CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak newInstance(XmlOptions xmlOptions) {
            return (CTPageBreak) POIXMLTypeLoader.newInstance(CTPageBreak.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageBreak.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(File file) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(file, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(file, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(inputStream, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(inputStream, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(Reader reader) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(reader, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(reader, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(String str) throws XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(str, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(str, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(URL url) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(url, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) POIXMLTypeLoader.parse(url, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(xMLStreamReader, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(xMLStreamReader, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(xMLInputStream, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(xMLInputStream, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(Node node) throws XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(node, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageBreak) POIXMLTypeLoader.parse(node, CTPageBreak.type, xmlOptions);
        }
    }

    CTBreak addNewBrk();

    CTBreak getBrkArray(int i);

    CTBreak[] getBrkArray();

    List<CTBreak> getBrkList();

    long getCount();

    long getManualBreakCount();

    CTBreak insertNewBrk(int i);

    boolean isSetCount();

    boolean isSetManualBreakCount();

    void removeBrk(int i);

    void setBrkArray(int i, CTBreak cTBreak);

    void setBrkArray(CTBreak[] cTBreakArr);

    void setCount(long j);

    void setManualBreakCount(long j);

    int sizeOfBrkArray();

    void unsetCount();

    void unsetManualBreakCount();

    XmlUnsignedInt xgetCount();

    XmlUnsignedInt xgetManualBreakCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetManualBreakCount(XmlUnsignedInt xmlUnsignedInt);
}
