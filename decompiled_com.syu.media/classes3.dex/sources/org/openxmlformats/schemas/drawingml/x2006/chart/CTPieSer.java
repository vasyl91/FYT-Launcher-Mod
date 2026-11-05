package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPieSer extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPieSer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpieser5248type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPieSer newInstance() {
            return (CTPieSer) POIXMLTypeLoader.newInstance(CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer newInstance(XmlOptions xmlOptions) {
            return (CTPieSer) POIXMLTypeLoader.newInstance(CTPieSer.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPieSer.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(File file) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(file, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(file, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(inputStream, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(inputStream, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(Reader reader) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(reader, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(reader, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(String str) throws XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(str, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(str, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(URL url) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(url, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPieSer) POIXMLTypeLoader.parse(url, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(xMLStreamReader, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(xMLStreamReader, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(xMLInputStream, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(xMLInputStream, CTPieSer.type, xmlOptions);
        }

        public static CTPieSer parse(Node node) throws XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(node, CTPieSer.type, (XmlOptions) null);
        }

        public static CTPieSer parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPieSer) POIXMLTypeLoader.parse(node, CTPieSer.type, xmlOptions);
        }
    }

    CTAxDataSource addNewCat();

    CTDLbls addNewDLbls();

    CTDPt addNewDPt();

    CTUnsignedInt addNewExplosion();

    CTExtensionList addNewExtLst();

    CTUnsignedInt addNewIdx();

    CTUnsignedInt addNewOrder();

    CTShapeProperties addNewSpPr();

    CTSerTx addNewTx();

    CTNumDataSource addNewVal();

    CTAxDataSource getCat();

    CTDLbls getDLbls();

    CTDPt getDPtArray(int i);

    CTDPt[] getDPtArray();

    List<CTDPt> getDPtList();

    CTUnsignedInt getExplosion();

    CTExtensionList getExtLst();

    CTUnsignedInt getIdx();

    CTUnsignedInt getOrder();

    CTShapeProperties getSpPr();

    CTSerTx getTx();

    CTNumDataSource getVal();

    CTDPt insertNewDPt(int i);

    boolean isSetCat();

    boolean isSetDLbls();

    boolean isSetExplosion();

    boolean isSetExtLst();

    boolean isSetSpPr();

    boolean isSetTx();

    boolean isSetVal();

    void removeDPt(int i);

    void setCat(CTAxDataSource cTAxDataSource);

    void setDLbls(CTDLbls cTDLbls);

    void setDPtArray(int i, CTDPt cTDPt);

    void setDPtArray(CTDPt[] cTDPtArr);

    void setExplosion(CTUnsignedInt cTUnsignedInt);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIdx(CTUnsignedInt cTUnsignedInt);

    void setOrder(CTUnsignedInt cTUnsignedInt);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTx(CTSerTx cTSerTx);

    void setVal(CTNumDataSource cTNumDataSource);

    int sizeOfDPtArray();

    void unsetCat();

    void unsetDLbls();

    void unsetExplosion();

    void unsetExtLst();

    void unsetSpPr();

    void unsetTx();

    void unsetVal();
}
