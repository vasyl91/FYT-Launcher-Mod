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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTRst extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRst.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrsta472type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRst newInstance() {
            return (CTRst) POIXMLTypeLoader.newInstance(CTRst.type, (XmlOptions) null);
        }

        public static CTRst newInstance(XmlOptions xmlOptions) {
            return (CTRst) POIXMLTypeLoader.newInstance(CTRst.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRst.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRst.type, xmlOptions);
        }

        public static CTRst parse(File file) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(file, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(file, CTRst.type, xmlOptions);
        }

        public static CTRst parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(inputStream, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(inputStream, CTRst.type, xmlOptions);
        }

        public static CTRst parse(Reader reader) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(reader, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(reader, CTRst.type, xmlOptions);
        }

        public static CTRst parse(String str) throws XmlException {
            return (CTRst) POIXMLTypeLoader.parse(str, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRst) POIXMLTypeLoader.parse(str, CTRst.type, xmlOptions);
        }

        public static CTRst parse(URL url) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(url, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRst) POIXMLTypeLoader.parse(url, CTRst.type, xmlOptions);
        }

        public static CTRst parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRst) POIXMLTypeLoader.parse(xMLStreamReader, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRst) POIXMLTypeLoader.parse(xMLStreamReader, CTRst.type, xmlOptions);
        }

        public static CTRst parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRst) POIXMLTypeLoader.parse(xMLInputStream, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRst) POIXMLTypeLoader.parse(xMLInputStream, CTRst.type, xmlOptions);
        }

        public static CTRst parse(Node node) throws XmlException {
            return (CTRst) POIXMLTypeLoader.parse(node, CTRst.type, (XmlOptions) null);
        }

        public static CTRst parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRst) POIXMLTypeLoader.parse(node, CTRst.type, xmlOptions);
        }
    }

    CTPhoneticPr addNewPhoneticPr();

    CTRElt addNewR();

    CTPhoneticRun addNewRPh();

    CTPhoneticPr getPhoneticPr();

    CTRElt getRArray(int i);

    CTRElt[] getRArray();

    List<CTRElt> getRList();

    CTPhoneticRun getRPhArray(int i);

    CTPhoneticRun[] getRPhArray();

    List<CTPhoneticRun> getRPhList();

    String getT();

    CTRElt insertNewR(int i);

    CTPhoneticRun insertNewRPh(int i);

    boolean isSetPhoneticPr();

    boolean isSetT();

    void removeR(int i);

    void removeRPh(int i);

    void setPhoneticPr(CTPhoneticPr cTPhoneticPr);

    void setRArray(int i, CTRElt cTRElt);

    void setRArray(CTRElt[] cTREltArr);

    void setRPhArray(int i, CTPhoneticRun cTPhoneticRun);

    void setRPhArray(CTPhoneticRun[] cTPhoneticRunArr);

    void setT(String str);

    int sizeOfRArray();

    int sizeOfRPhArray();

    void unsetPhoneticPr();

    void unsetT();

    STXstring xgetT();

    void xsetT(STXstring sTXstring);
}
