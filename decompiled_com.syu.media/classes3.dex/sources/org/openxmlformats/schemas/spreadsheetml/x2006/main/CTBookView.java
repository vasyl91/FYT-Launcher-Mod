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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTBookView extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBookView.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbookviewf677type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookView newInstance() {
            return (CTBookView) POIXMLTypeLoader.newInstance(CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView newInstance(XmlOptions xmlOptions) {
            return (CTBookView) POIXMLTypeLoader.newInstance(CTBookView.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookView.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(File file) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(file, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(file, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(inputStream, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(inputStream, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(Reader reader) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(reader, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(reader, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(String str) throws XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(str, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(str, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(URL url) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(url, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookView) POIXMLTypeLoader.parse(url, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(xMLStreamReader, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(xMLStreamReader, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(xMLInputStream, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(xMLInputStream, CTBookView.type, xmlOptions);
        }

        public static CTBookView parse(Node node) throws XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(node, CTBookView.type, (XmlOptions) null);
        }

        public static CTBookView parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBookView) POIXMLTypeLoader.parse(node, CTBookView.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    long getActiveTab();

    boolean getAutoFilterDateGrouping();

    CTExtensionList getExtLst();

    long getFirstSheet();

    boolean getMinimized();

    boolean getShowHorizontalScroll();

    boolean getShowSheetTabs();

    boolean getShowVerticalScroll();

    long getTabRatio();

    STVisibility$Enum getVisibility();

    long getWindowHeight();

    long getWindowWidth();

    int getXWindow();

    int getYWindow();

    boolean isSetActiveTab();

    boolean isSetAutoFilterDateGrouping();

    boolean isSetExtLst();

    boolean isSetFirstSheet();

    boolean isSetMinimized();

    boolean isSetShowHorizontalScroll();

    boolean isSetShowSheetTabs();

    boolean isSetShowVerticalScroll();

    boolean isSetTabRatio();

    boolean isSetVisibility();

    boolean isSetWindowHeight();

    boolean isSetWindowWidth();

    boolean isSetXWindow();

    boolean isSetYWindow();

    void setActiveTab(long j);

    void setAutoFilterDateGrouping(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFirstSheet(long j);

    void setMinimized(boolean z);

    void setShowHorizontalScroll(boolean z);

    void setShowSheetTabs(boolean z);

    void setShowVerticalScroll(boolean z);

    void setTabRatio(long j);

    void setVisibility(STVisibility$Enum sTVisibility$Enum);

    void setWindowHeight(long j);

    void setWindowWidth(long j);

    void setXWindow(int i);

    void setYWindow(int i);

    void unsetActiveTab();

    void unsetAutoFilterDateGrouping();

    void unsetExtLst();

    void unsetFirstSheet();

    void unsetMinimized();

    void unsetShowHorizontalScroll();

    void unsetShowSheetTabs();

    void unsetShowVerticalScroll();

    void unsetTabRatio();

    void unsetVisibility();

    void unsetWindowHeight();

    void unsetWindowWidth();

    void unsetXWindow();

    void unsetYWindow();

    XmlUnsignedInt xgetActiveTab();

    XmlBoolean xgetAutoFilterDateGrouping();

    XmlUnsignedInt xgetFirstSheet();

    XmlBoolean xgetMinimized();

    XmlBoolean xgetShowHorizontalScroll();

    XmlBoolean xgetShowSheetTabs();

    XmlBoolean xgetShowVerticalScroll();

    XmlUnsignedInt xgetTabRatio();

    STVisibility xgetVisibility();

    XmlUnsignedInt xgetWindowHeight();

    XmlUnsignedInt xgetWindowWidth();

    XmlInt xgetXWindow();

    XmlInt xgetYWindow();

    void xsetActiveTab(XmlUnsignedInt xmlUnsignedInt);

    void xsetAutoFilterDateGrouping(XmlBoolean xmlBoolean);

    void xsetFirstSheet(XmlUnsignedInt xmlUnsignedInt);

    void xsetMinimized(XmlBoolean xmlBoolean);

    void xsetShowHorizontalScroll(XmlBoolean xmlBoolean);

    void xsetShowSheetTabs(XmlBoolean xmlBoolean);

    void xsetShowVerticalScroll(XmlBoolean xmlBoolean);

    void xsetTabRatio(XmlUnsignedInt xmlUnsignedInt);

    void xsetVisibility(STVisibility sTVisibility);

    void xsetWindowHeight(XmlUnsignedInt xmlUnsignedInt);

    void xsetWindowWidth(XmlUnsignedInt xmlUnsignedInt);

    void xsetXWindow(XmlInt xmlInt);

    void xsetYWindow(XmlInt xmlInt);
}
