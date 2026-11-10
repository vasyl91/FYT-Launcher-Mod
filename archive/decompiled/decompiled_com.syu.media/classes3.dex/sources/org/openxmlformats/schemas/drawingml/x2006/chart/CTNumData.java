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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTNumData extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNumData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumdata4f16type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumData newInstance() {
            return (CTNumData) POIXMLTypeLoader.newInstance(CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData newInstance(XmlOptions xmlOptions) {
            return (CTNumData) POIXMLTypeLoader.newInstance(CTNumData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumData.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(File file) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(file, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(file, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(inputStream, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(inputStream, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(Reader reader) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(reader, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(reader, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(String str) throws XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(str, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(str, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(URL url) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(url, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumData) POIXMLTypeLoader.parse(url, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(xMLStreamReader, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(xMLStreamReader, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(xMLInputStream, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(xMLInputStream, CTNumData.type, xmlOptions);
        }

        public static CTNumData parse(Node node) throws XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(node, CTNumData.type, (XmlOptions) null);
        }

        public static CTNumData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumData) POIXMLTypeLoader.parse(node, CTNumData.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTNumVal addNewPt();

    CTUnsignedInt addNewPtCount();

    CTExtensionList getExtLst();

    String getFormatCode();

    CTNumVal getPtArray(int i);

    CTNumVal[] getPtArray();

    CTUnsignedInt getPtCount();

    List<CTNumVal> getPtList();

    CTNumVal insertNewPt(int i);

    boolean isSetExtLst();

    boolean isSetFormatCode();

    boolean isSetPtCount();

    void removePt(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFormatCode(String str);

    void setPtArray(int i, CTNumVal cTNumVal);

    void setPtArray(CTNumVal[] cTNumValArr);

    void setPtCount(CTUnsignedInt cTUnsignedInt);

    int sizeOfPtArray();

    void unsetExtLst();

    void unsetFormatCode();

    void unsetPtCount();

    STXstring xgetFormatCode();

    void xsetFormatCode(STXstring sTXstring);
}
