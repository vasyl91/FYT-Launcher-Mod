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
public interface CTFldChar extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFldChar.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfldchare83etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFldChar newInstance() {
            return (CTFldChar) POIXMLTypeLoader.newInstance(CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar newInstance(XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.newInstance(CTFldChar.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(File file) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(file, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(file, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(inputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(inputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(Reader reader) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(reader, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(reader, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(String str) throws XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(str, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(str, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(URL url) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(url, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) POIXMLTypeLoader.parse(url, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLStreamReader, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLStreamReader, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLInputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLInputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(Node node) throws XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(node, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFldChar) POIXMLTypeLoader.parse(node, CTFldChar.type, xmlOptions);
        }
    }

    CTFFData addNewFfData();

    CTText addNewFldData();

    CTTrackChangeNumbering addNewNumberingChange();

    STOnOff.Enum getDirty();

    CTFFData getFfData();

    STFldCharType.Enum getFldCharType();

    CTText getFldData();

    STOnOff.Enum getFldLock();

    CTTrackChangeNumbering getNumberingChange();

    boolean isSetDirty();

    boolean isSetFfData();

    boolean isSetFldData();

    boolean isSetFldLock();

    boolean isSetNumberingChange();

    void setDirty(STOnOff.Enum r1);

    void setFfData(CTFFData cTFFData);

    void setFldCharType(STFldCharType.Enum r1);

    void setFldData(CTText cTText);

    void setFldLock(STOnOff.Enum r1);

    void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering);

    void unsetDirty();

    void unsetFfData();

    void unsetFldData();

    void unsetFldLock();

    void unsetNumberingChange();

    STOnOff xgetDirty();

    STFldCharType xgetFldCharType();

    STOnOff xgetFldLock();

    void xsetDirty(STOnOff sTOnOff);

    void xsetFldCharType(STFldCharType sTFldCharType);

    void xsetFldLock(STOnOff sTOnOff);
}
