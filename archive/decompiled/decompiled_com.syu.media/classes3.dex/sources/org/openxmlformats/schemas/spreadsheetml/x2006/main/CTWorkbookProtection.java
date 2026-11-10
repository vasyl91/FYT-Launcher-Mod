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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTWorkbookProtection extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTWorkbookProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworkbookprotection56bctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTWorkbookProtection newInstance() {
            return (CTWorkbookProtection) POIXMLTypeLoader.newInstance(CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection newInstance(XmlOptions xmlOptions) {
            return (CTWorkbookProtection) POIXMLTypeLoader.newInstance(CTWorkbookProtection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(File file) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(file, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(file, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(inputStream, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(inputStream, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(Reader reader) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(reader, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(reader, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(String str) throws XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(str, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(str, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(URL url) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(url, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(url, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(xMLStreamReader, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(xMLStreamReader, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(xMLInputStream, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(xMLInputStream, CTWorkbookProtection.type, xmlOptions);
        }

        public static CTWorkbookProtection parse(Node node) throws XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(node, CTWorkbookProtection.type, (XmlOptions) null);
        }

        public static CTWorkbookProtection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookProtection) POIXMLTypeLoader.parse(node, CTWorkbookProtection.type, xmlOptions);
        }
    }

    boolean getLockRevision();

    boolean getLockStructure();

    boolean getLockWindows();

    byte[] getRevisionsPassword();

    byte[] getWorkbookPassword();

    boolean isSetLockRevision();

    boolean isSetLockStructure();

    boolean isSetLockWindows();

    boolean isSetRevisionsPassword();

    boolean isSetWorkbookPassword();

    void setLockRevision(boolean z);

    void setLockStructure(boolean z);

    void setLockWindows(boolean z);

    void setRevisionsPassword(byte[] bArr);

    void setWorkbookPassword(byte[] bArr);

    void unsetLockRevision();

    void unsetLockStructure();

    void unsetLockWindows();

    void unsetRevisionsPassword();

    void unsetWorkbookPassword();

    XmlBoolean xgetLockRevision();

    XmlBoolean xgetLockStructure();

    XmlBoolean xgetLockWindows();

    STUnsignedShortHex xgetRevisionsPassword();

    STUnsignedShortHex xgetWorkbookPassword();

    void xsetLockRevision(XmlBoolean xmlBoolean);

    void xsetLockStructure(XmlBoolean xmlBoolean);

    void xsetLockWindows(XmlBoolean xmlBoolean);

    void xsetRevisionsPassword(STUnsignedShortHex sTUnsignedShortHex);

    void xsetWorkbookPassword(STUnsignedShortHex sTUnsignedShortHex);
}
