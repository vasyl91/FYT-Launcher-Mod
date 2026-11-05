package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTPPr extends CTPPrBase {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctppr01c0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPPr newInstance() {
            return (CTPPr) POIXMLTypeLoader.newInstance(CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr newInstance(XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.newInstance(CTPPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(File file) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(file, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(file, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(inputStream, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(inputStream, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(Reader reader) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(reader, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(reader, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(String str) throws XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(str, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(str, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(URL url) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(url, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPr) POIXMLTypeLoader.parse(url, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(xMLStreamReader, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(xMLStreamReader, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(xMLInputStream, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(xMLInputStream, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(Node node) throws XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(node, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPPr) POIXMLTypeLoader.parse(node, CTPPr.type, xmlOptions);
        }
    }

    CTPPrChange addNewPPrChange();

    CTParaRPr addNewRPr();

    CTSectPr addNewSectPr();

    CTPPrChange getPPrChange();

    CTParaRPr getRPr();

    CTSectPr getSectPr();

    boolean isSetPPrChange();

    boolean isSetRPr();

    boolean isSetSectPr();

    void setPPrChange(CTPPrChange cTPPrChange);

    void setRPr(CTParaRPr cTParaRPr);

    void setSectPr(CTSectPr cTSectPr);

    void unsetPPrChange();

    void unsetRPr();

    void unsetSectPr();
}
