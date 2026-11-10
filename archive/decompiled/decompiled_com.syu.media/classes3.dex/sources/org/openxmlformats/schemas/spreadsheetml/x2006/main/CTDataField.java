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
public interface CTDataField extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDataField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatafield6f0ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataField newInstance() {
            return (CTDataField) POIXMLTypeLoader.newInstance(CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField newInstance(XmlOptions xmlOptions) {
            return (CTDataField) POIXMLTypeLoader.newInstance(CTDataField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDataField.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(File file) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(file, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(file, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(inputStream, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(inputStream, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(Reader reader) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(reader, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(reader, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(String str) throws XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(str, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(str, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(URL url) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(url, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataField) POIXMLTypeLoader.parse(url, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(xMLStreamReader, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(xMLStreamReader, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(xMLInputStream, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(xMLInputStream, CTDataField.type, xmlOptions);
        }

        public static CTDataField parse(Node node) throws XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(node, CTDataField.type, (XmlOptions) null);
        }

        public static CTDataField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataField) POIXMLTypeLoader.parse(node, CTDataField.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    int getBaseField();

    long getBaseItem();

    CTExtensionList getExtLst();

    long getFld();

    String getName();

    long getNumFmtId();

    STShowDataAs$Enum getShowDataAs();

    STDataConsolidateFunction.Enum getSubtotal();

    boolean isSetBaseField();

    boolean isSetBaseItem();

    boolean isSetExtLst();

    boolean isSetName();

    boolean isSetNumFmtId();

    boolean isSetShowDataAs();

    boolean isSetSubtotal();

    void setBaseField(int i);

    void setBaseItem(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFld(long j);

    void setName(String str);

    void setNumFmtId(long j);

    void setShowDataAs(STShowDataAs$Enum sTShowDataAs$Enum);

    void setSubtotal(STDataConsolidateFunction.Enum r1);

    void unsetBaseField();

    void unsetBaseItem();

    void unsetExtLst();

    void unsetName();

    void unsetNumFmtId();

    void unsetShowDataAs();

    void unsetSubtotal();

    XmlInt xgetBaseField();

    XmlUnsignedInt xgetBaseItem();

    XmlUnsignedInt xgetFld();

    STXstring xgetName();

    STNumFmtId xgetNumFmtId();

    STShowDataAs xgetShowDataAs();

    STDataConsolidateFunction xgetSubtotal();

    void xsetBaseField(XmlInt xmlInt);

    void xsetBaseItem(XmlUnsignedInt xmlUnsignedInt);

    void xsetFld(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetShowDataAs(STShowDataAs sTShowDataAs);

    void xsetSubtotal(STDataConsolidateFunction sTDataConsolidateFunction);
}
