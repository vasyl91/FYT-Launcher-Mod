package com.microsoft.schemas.office.visio.x2012.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CellType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CellType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("celltyped857type");

    public static final class Factory {
        private Factory() {
        }

        public static CellType newInstance() {
            return (CellType) POIXMLTypeLoader.newInstance(CellType.type, (XmlOptions) null);
        }

        public static CellType newInstance(XmlOptions xmlOptions) {
            return (CellType) POIXMLTypeLoader.newInstance(CellType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CellType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CellType.type, xmlOptions);
        }

        public static CellType parse(File file) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(file, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(file, CellType.type, xmlOptions);
        }

        public static CellType parse(InputStream inputStream) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(inputStream, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(inputStream, CellType.type, xmlOptions);
        }

        public static CellType parse(Reader reader) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(reader, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(reader, CellType.type, xmlOptions);
        }

        public static CellType parse(String str) throws XmlException {
            return (CellType) POIXMLTypeLoader.parse(str, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CellType) POIXMLTypeLoader.parse(str, CellType.type, xmlOptions);
        }

        public static CellType parse(URL url) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(url, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CellType) POIXMLTypeLoader.parse(url, CellType.type, xmlOptions);
        }

        public static CellType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CellType) POIXMLTypeLoader.parse(xMLStreamReader, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CellType) POIXMLTypeLoader.parse(xMLStreamReader, CellType.type, xmlOptions);
        }

        public static CellType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CellType) POIXMLTypeLoader.parse(xMLInputStream, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CellType) POIXMLTypeLoader.parse(xMLInputStream, CellType.type, xmlOptions);
        }

        public static CellType parse(Node node) throws XmlException {
            return (CellType) POIXMLTypeLoader.parse(node, CellType.type, (XmlOptions) null);
        }

        public static CellType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CellType) POIXMLTypeLoader.parse(node, CellType.type, xmlOptions);
        }
    }

    RefByType addNewRefBy();

    String getE();

    String getF();

    String getN();

    RefByType getRefByArray(int i);

    RefByType[] getRefByArray();

    List<RefByType> getRefByList();

    String getU();

    String getV();

    RefByType insertNewRefBy(int i);

    boolean isSetE();

    boolean isSetF();

    boolean isSetU();

    boolean isSetV();

    void removeRefBy(int i);

    void setE(String str);

    void setF(String str);

    void setN(String str);

    void setRefByArray(int i, RefByType refByType);

    void setRefByArray(RefByType[] refByTypeArr);

    void setU(String str);

    void setV(String str);

    int sizeOfRefByArray();

    void unsetE();

    void unsetF();

    void unsetU();

    void unsetV();

    XmlString xgetE();

    XmlString xgetF();

    XmlString xgetN();

    XmlString xgetU();

    XmlString xgetV();

    void xsetE(XmlString xmlString);

    void xsetF(XmlString xmlString);

    void xsetN(XmlString xmlString);

    void xsetU(XmlString xmlString);

    void xsetV(XmlString xmlString);
}
