package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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
public interface CTTableStyleInfo extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableStyleInfo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestyleinfo499atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyleInfo newInstance() {
            return (CTTableStyleInfo) POIXMLTypeLoader.newInstance(CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo newInstance(XmlOptions xmlOptions) {
            return (CTTableStyleInfo) POIXMLTypeLoader.newInstance(CTTableStyleInfo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(File file) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(file, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(file, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(inputStream, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(inputStream, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(reader, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(reader, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(String str) throws XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(str, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(str, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(URL url) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(url, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(url, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleInfo.type, xmlOptions);
        }

        public static CTTableStyleInfo parse(Node node) throws XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(node, CTTableStyleInfo.type, (XmlOptions) null);
        }

        public static CTTableStyleInfo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleInfo) POIXMLTypeLoader.parse(node, CTTableStyleInfo.type, xmlOptions);
        }
    }

    String getName();

    boolean getShowColumnStripes();

    boolean getShowFirstColumn();

    boolean getShowLastColumn();

    boolean getShowRowStripes();

    boolean isSetName();

    boolean isSetShowColumnStripes();

    boolean isSetShowFirstColumn();

    boolean isSetShowLastColumn();

    boolean isSetShowRowStripes();

    void setName(String str);

    void setShowColumnStripes(boolean z);

    void setShowFirstColumn(boolean z);

    void setShowLastColumn(boolean z);

    void setShowRowStripes(boolean z);

    void unsetName();

    void unsetShowColumnStripes();

    void unsetShowFirstColumn();

    void unsetShowLastColumn();

    void unsetShowRowStripes();

    STXstring xgetName();

    XmlBoolean xgetShowColumnStripes();

    XmlBoolean xgetShowFirstColumn();

    XmlBoolean xgetShowLastColumn();

    XmlBoolean xgetShowRowStripes();

    void xsetName(STXstring sTXstring);

    void xsetShowColumnStripes(XmlBoolean xmlBoolean);

    void xsetShowFirstColumn(XmlBoolean xmlBoolean);

    void xsetShowLastColumn(XmlBoolean xmlBoolean);

    void xsetShowRowStripes(XmlBoolean xmlBoolean);
}
