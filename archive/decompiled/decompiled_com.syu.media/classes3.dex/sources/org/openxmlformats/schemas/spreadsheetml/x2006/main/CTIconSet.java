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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTIconSet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTIconSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cticonset2648type");

    public static final class Factory {
        private Factory() {
        }

        public static CTIconSet newInstance() {
            return (CTIconSet) POIXMLTypeLoader.newInstance(CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet newInstance(XmlOptions xmlOptions) {
            return (CTIconSet) POIXMLTypeLoader.newInstance(CTIconSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIconSet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(File file) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(file, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(file, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(inputStream, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(inputStream, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(Reader reader) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(reader, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(reader, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(String str) throws XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(str, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(str, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(URL url) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(url, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIconSet) POIXMLTypeLoader.parse(url, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(xMLStreamReader, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(xMLStreamReader, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(xMLInputStream, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(xMLInputStream, CTIconSet.type, xmlOptions);
        }

        public static CTIconSet parse(Node node) throws XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(node, CTIconSet.type, (XmlOptions) null);
        }

        public static CTIconSet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIconSet) POIXMLTypeLoader.parse(node, CTIconSet.type, xmlOptions);
        }
    }

    CTCfvo addNewCfvo();

    CTCfvo getCfvoArray(int i);

    CTCfvo[] getCfvoArray();

    List<CTCfvo> getCfvoList();

    STIconSetType.Enum getIconSet();

    boolean getPercent();

    boolean getReverse();

    boolean getShowValue();

    CTCfvo insertNewCfvo(int i);

    boolean isSetIconSet();

    boolean isSetPercent();

    boolean isSetReverse();

    boolean isSetShowValue();

    void removeCfvo(int i);

    void setCfvoArray(int i, CTCfvo cTCfvo);

    void setCfvoArray(CTCfvo[] cTCfvoArr);

    void setIconSet(STIconSetType.Enum r1);

    void setPercent(boolean z);

    void setReverse(boolean z);

    void setShowValue(boolean z);

    int sizeOfCfvoArray();

    void unsetIconSet();

    void unsetPercent();

    void unsetReverse();

    void unsetShowValue();

    STIconSetType xgetIconSet();

    XmlBoolean xgetPercent();

    XmlBoolean xgetReverse();

    XmlBoolean xgetShowValue();

    void xsetIconSet(STIconSetType sTIconSetType);

    void xsetPercent(XmlBoolean xmlBoolean);

    void xsetReverse(XmlBoolean xmlBoolean);

    void xsetShowValue(XmlBoolean xmlBoolean);
}
