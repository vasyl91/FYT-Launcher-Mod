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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTableStyles extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestyles872ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyles newInstance() {
            return (CTTableStyles) POIXMLTypeLoader.newInstance(CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles newInstance(XmlOptions xmlOptions) {
            return (CTTableStyles) POIXMLTypeLoader.newInstance(CTTableStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyles.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(File file) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(file, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(file, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(inputStream, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(inputStream, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(reader, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(reader, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(String str) throws XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(str, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(str, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(URL url) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(url, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyles) POIXMLTypeLoader.parse(url, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyles.type, xmlOptions);
        }

        public static CTTableStyles parse(Node node) throws XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(node, CTTableStyles.type, (XmlOptions) null);
        }

        public static CTTableStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyles) POIXMLTypeLoader.parse(node, CTTableStyles.type, xmlOptions);
        }
    }

    CTTableStyle addNewTableStyle();

    long getCount();

    String getDefaultPivotStyle();

    String getDefaultTableStyle();

    CTTableStyle getTableStyleArray(int i);

    CTTableStyle[] getTableStyleArray();

    List<CTTableStyle> getTableStyleList();

    CTTableStyle insertNewTableStyle(int i);

    boolean isSetCount();

    boolean isSetDefaultPivotStyle();

    boolean isSetDefaultTableStyle();

    void removeTableStyle(int i);

    void setCount(long j);

    void setDefaultPivotStyle(String str);

    void setDefaultTableStyle(String str);

    void setTableStyleArray(int i, CTTableStyle cTTableStyle);

    void setTableStyleArray(CTTableStyle[] cTTableStyleArr);

    int sizeOfTableStyleArray();

    void unsetCount();

    void unsetDefaultPivotStyle();

    void unsetDefaultTableStyle();

    XmlUnsignedInt xgetCount();

    XmlString xgetDefaultPivotStyle();

    XmlString xgetDefaultTableStyle();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetDefaultPivotStyle(XmlString xmlString);

    void xsetDefaultTableStyle(XmlString xmlString);
}
