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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTPTab extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPTab.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctptaba283type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPTab newInstance() {
            return (CTPTab) POIXMLTypeLoader.newInstance(CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab newInstance(XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.newInstance(CTPTab.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPTab.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(File file) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(file, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(file, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(inputStream, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(inputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(Reader reader) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(reader, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(reader, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(String str) throws XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(str, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(str, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(URL url) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(url, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPTab) POIXMLTypeLoader.parse(url, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(xMLStreamReader, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(xMLStreamReader, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(xMLInputStream, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(xMLInputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(Node node) throws XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(node, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPTab) POIXMLTypeLoader.parse(node, CTPTab.type, xmlOptions);
        }
    }

    STPTabAlignment$Enum getAlignment();

    STPTabLeader$Enum getLeader();

    STPTabRelativeTo$Enum getRelativeTo();

    void setAlignment(STPTabAlignment$Enum sTPTabAlignment$Enum);

    void setLeader(STPTabLeader$Enum sTPTabLeader$Enum);

    void setRelativeTo(STPTabRelativeTo$Enum sTPTabRelativeTo$Enum);

    STPTabAlignment xgetAlignment();

    STPTabLeader xgetLeader();

    STPTabRelativeTo xgetRelativeTo();

    void xsetAlignment(STPTabAlignment sTPTabAlignment);

    void xsetLeader(STPTabLeader sTPTabLeader);

    void xsetRelativeTo(STPTabRelativeTo sTPTabRelativeTo);
}
