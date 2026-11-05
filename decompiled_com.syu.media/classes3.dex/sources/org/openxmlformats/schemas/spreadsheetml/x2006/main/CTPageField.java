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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPageField extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPageField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagefield338atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageField newInstance() {
            return (CTPageField) POIXMLTypeLoader.newInstance(CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField newInstance(XmlOptions xmlOptions) {
            return (CTPageField) POIXMLTypeLoader.newInstance(CTPageField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageField.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(File file) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(file, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(file, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(inputStream, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(inputStream, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(Reader reader) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(reader, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(reader, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(String str) throws XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(str, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(str, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(URL url) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(url, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) POIXMLTypeLoader.parse(url, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(xMLStreamReader, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(xMLStreamReader, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(xMLInputStream, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(xMLInputStream, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(Node node) throws XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(node, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageField) POIXMLTypeLoader.parse(node, CTPageField.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    String getCap();

    CTExtensionList getExtLst();

    int getFld();

    int getHier();

    long getItem();

    String getName();

    boolean isSetCap();

    boolean isSetExtLst();

    boolean isSetHier();

    boolean isSetItem();

    boolean isSetName();

    void setCap(String str);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFld(int i);

    void setHier(int i);

    void setItem(long j);

    void setName(String str);

    void unsetCap();

    void unsetExtLst();

    void unsetHier();

    void unsetItem();

    void unsetName();

    STXstring xgetCap();

    XmlInt xgetFld();

    XmlInt xgetHier();

    XmlUnsignedInt xgetItem();

    STXstring xgetName();

    void xsetCap(STXstring sTXstring);

    void xsetFld(XmlInt xmlInt);

    void xsetHier(XmlInt xmlInt);

    void xsetItem(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);
}
