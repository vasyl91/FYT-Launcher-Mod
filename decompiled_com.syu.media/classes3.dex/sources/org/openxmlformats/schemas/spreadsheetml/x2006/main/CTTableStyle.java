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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTableStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestylea24ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyle newInstance() {
            return (CTTableStyle) POIXMLTypeLoader.newInstance(CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle newInstance(XmlOptions xmlOptions) {
            return (CTTableStyle) POIXMLTypeLoader.newInstance(CTTableStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(File file) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(file, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(file, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(inputStream, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(inputStream, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(reader, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(reader, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(String str) throws XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(str, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(str, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(URL url) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(url, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) POIXMLTypeLoader.parse(url, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(Node node) throws XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(node, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyle) POIXMLTypeLoader.parse(node, CTTableStyle.type, xmlOptions);
        }
    }

    CTTableStyleElement addNewTableStyleElement();

    long getCount();

    String getName();

    boolean getPivot();

    boolean getTable();

    CTTableStyleElement getTableStyleElementArray(int i);

    CTTableStyleElement[] getTableStyleElementArray();

    List<CTTableStyleElement> getTableStyleElementList();

    CTTableStyleElement insertNewTableStyleElement(int i);

    boolean isSetCount();

    boolean isSetPivot();

    boolean isSetTable();

    void removeTableStyleElement(int i);

    void setCount(long j);

    void setName(String str);

    void setPivot(boolean z);

    void setTable(boolean z);

    void setTableStyleElementArray(int i, CTTableStyleElement cTTableStyleElement);

    void setTableStyleElementArray(CTTableStyleElement[] cTTableStyleElementArr);

    int sizeOfTableStyleElementArray();

    void unsetCount();

    void unsetPivot();

    void unsetTable();

    XmlUnsignedInt xgetCount();

    XmlString xgetName();

    XmlBoolean xgetPivot();

    XmlBoolean xgetTable();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(XmlString xmlString);

    void xsetPivot(XmlBoolean xmlBoolean);

    void xsetTable(XmlBoolean xmlBoolean);
}
