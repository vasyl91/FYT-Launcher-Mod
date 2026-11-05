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
public interface CTSst extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSst.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsst44f3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSst newInstance() {
            return (CTSst) POIXMLTypeLoader.newInstance(CTSst.type, (XmlOptions) null);
        }

        public static CTSst newInstance(XmlOptions xmlOptions) {
            return (CTSst) POIXMLTypeLoader.newInstance(CTSst.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSst.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSst.type, xmlOptions);
        }

        public static CTSst parse(File file) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(file, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(file, CTSst.type, xmlOptions);
        }

        public static CTSst parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(inputStream, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(inputStream, CTSst.type, xmlOptions);
        }

        public static CTSst parse(Reader reader) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(reader, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(reader, CTSst.type, xmlOptions);
        }

        public static CTSst parse(String str) throws XmlException {
            return (CTSst) POIXMLTypeLoader.parse(str, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSst) POIXMLTypeLoader.parse(str, CTSst.type, xmlOptions);
        }

        public static CTSst parse(URL url) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(url, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) POIXMLTypeLoader.parse(url, CTSst.type, xmlOptions);
        }

        public static CTSst parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSst) POIXMLTypeLoader.parse(xMLStreamReader, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSst) POIXMLTypeLoader.parse(xMLStreamReader, CTSst.type, xmlOptions);
        }

        public static CTSst parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSst) POIXMLTypeLoader.parse(xMLInputStream, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSst) POIXMLTypeLoader.parse(xMLInputStream, CTSst.type, xmlOptions);
        }

        public static CTSst parse(Node node) throws XmlException {
            return (CTSst) POIXMLTypeLoader.parse(node, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSst) POIXMLTypeLoader.parse(node, CTSst.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTRst addNewSi();

    long getCount();

    CTExtensionList getExtLst();

    CTRst getSiArray(int i);

    CTRst[] getSiArray();

    List<CTRst> getSiList();

    long getUniqueCount();

    CTRst insertNewSi(int i);

    boolean isSetCount();

    boolean isSetExtLst();

    boolean isSetUniqueCount();

    void removeSi(int i);

    void setCount(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSiArray(int i, CTRst cTRst);

    void setSiArray(CTRst[] cTRstArr);

    void setUniqueCount(long j);

    int sizeOfSiArray();

    void unsetCount();

    void unsetExtLst();

    void unsetUniqueCount();

    XmlUnsignedInt xgetCount();

    XmlUnsignedInt xgetUniqueCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetUniqueCount(XmlUnsignedInt xmlUnsignedInt);
}
