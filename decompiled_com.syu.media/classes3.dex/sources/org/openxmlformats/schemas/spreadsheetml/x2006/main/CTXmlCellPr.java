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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTXmlCellPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTXmlCellPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctxmlcellprf1datype");

    public static final class Factory {
        private Factory() {
        }

        public static CTXmlCellPr newInstance() {
            return (CTXmlCellPr) POIXMLTypeLoader.newInstance(CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr newInstance(XmlOptions xmlOptions) {
            return (CTXmlCellPr) POIXMLTypeLoader.newInstance(CTXmlCellPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(File file) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(file, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(file, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(inputStream, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(inputStream, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(Reader reader) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(reader, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(reader, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(String str) throws XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(str, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(str, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(URL url) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(url, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(url, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(xMLStreamReader, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(xMLStreamReader, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(xMLInputStream, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(xMLInputStream, CTXmlCellPr.type, xmlOptions);
        }

        public static CTXmlCellPr parse(Node node) throws XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(node, CTXmlCellPr.type, (XmlOptions) null);
        }

        public static CTXmlCellPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTXmlCellPr) POIXMLTypeLoader.parse(node, CTXmlCellPr.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTXmlPr addNewXmlPr();

    CTExtensionList getExtLst();

    long getId();

    String getUniqueName();

    CTXmlPr getXmlPr();

    boolean isSetExtLst();

    boolean isSetUniqueName();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setUniqueName(String str);

    void setXmlPr(CTXmlPr cTXmlPr);

    void unsetExtLst();

    void unsetUniqueName();

    XmlUnsignedInt xgetId();

    STXstring xgetUniqueName();

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetUniqueName(STXstring sTXstring);
}
