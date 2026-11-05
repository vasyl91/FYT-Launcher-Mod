package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPageSetup extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPageSetup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagesetupdb38type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageSetup newInstance() {
            return (CTPageSetup) POIXMLTypeLoader.newInstance(CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup newInstance(XmlOptions xmlOptions) {
            return (CTPageSetup) POIXMLTypeLoader.newInstance(CTPageSetup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageSetup.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(File file) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(file, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(file, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(inputStream, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(inputStream, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(Reader reader) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(reader, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(reader, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(String str) throws XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(str, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(str, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(URL url) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(url, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) POIXMLTypeLoader.parse(url, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(xMLStreamReader, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(xMLStreamReader, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(xMLInputStream, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(xMLInputStream, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(Node node) throws XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(node, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetup) POIXMLTypeLoader.parse(node, CTPageSetup.type, xmlOptions);
        }
    }

    boolean getBlackAndWhite();

    long getCopies();

    boolean getDraft();

    long getFirstPageNumber();

    int getHorizontalDpi();

    STPageSetupOrientation$Enum getOrientation();

    long getPaperSize();

    boolean getUseFirstPageNumber();

    int getVerticalDpi();

    boolean isSetBlackAndWhite();

    boolean isSetCopies();

    boolean isSetDraft();

    boolean isSetFirstPageNumber();

    boolean isSetHorizontalDpi();

    boolean isSetOrientation();

    boolean isSetPaperSize();

    boolean isSetUseFirstPageNumber();

    boolean isSetVerticalDpi();

    void setBlackAndWhite(boolean z);

    void setCopies(long j);

    void setDraft(boolean z);

    void setFirstPageNumber(long j);

    void setHorizontalDpi(int i);

    void setOrientation(STPageSetupOrientation$Enum sTPageSetupOrientation$Enum);

    void setPaperSize(long j);

    void setUseFirstPageNumber(boolean z);

    void setVerticalDpi(int i);

    void unsetBlackAndWhite();

    void unsetCopies();

    void unsetDraft();

    void unsetFirstPageNumber();

    void unsetHorizontalDpi();

    void unsetOrientation();

    void unsetPaperSize();

    void unsetUseFirstPageNumber();

    void unsetVerticalDpi();

    XmlBoolean xgetBlackAndWhite();

    XmlUnsignedInt xgetCopies();

    XmlBoolean xgetDraft();

    XmlUnsignedInt xgetFirstPageNumber();

    XmlInt xgetHorizontalDpi();

    STPageSetupOrientation xgetOrientation();

    XmlUnsignedInt xgetPaperSize();

    XmlBoolean xgetUseFirstPageNumber();

    XmlInt xgetVerticalDpi();

    void xsetBlackAndWhite(XmlBoolean xmlBoolean);

    void xsetCopies(XmlUnsignedInt xmlUnsignedInt);

    void xsetDraft(XmlBoolean xmlBoolean);

    void xsetFirstPageNumber(XmlUnsignedInt xmlUnsignedInt);

    void xsetHorizontalDpi(XmlInt xmlInt);

    void xsetOrientation(STPageSetupOrientation sTPageSetupOrientation);

    void xsetPaperSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetUseFirstPageNumber(XmlBoolean xmlBoolean);

    void xsetVerticalDpi(XmlInt xmlInt);
}
