package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSlide extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSlide.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslided7betype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlide newInstance() {
            return (CTSlide) POIXMLTypeLoader.newInstance(CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide newInstance(XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.newInstance(CTSlide.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlide.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(File file) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(file, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(file, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(inputStream, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(inputStream, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(Reader reader) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(reader, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(reader, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(String str) throws XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(str, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(str, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(URL url) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(url, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlide) POIXMLTypeLoader.parse(url, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(xMLStreamReader, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(xMLStreamReader, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(xMLInputStream, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(xMLInputStream, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(Node node) throws XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(node, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlide) POIXMLTypeLoader.parse(node, CTSlide.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMappingOverride addNewClrMapOvr();

    CTExtensionListModify addNewExtLst();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTCommonSlideData getCSld();

    CTColorMappingOverride getClrMapOvr();

    CTExtensionListModify getExtLst();

    boolean getShow();

    boolean getShowMasterPhAnim();

    boolean getShowMasterSp();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    boolean isSetClrMapOvr();

    boolean isSetExtLst();

    boolean isSetShow();

    boolean isSetShowMasterPhAnim();

    boolean isSetShowMasterSp();

    boolean isSetTiming();

    boolean isSetTransition();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setShow(boolean z);

    void setShowMasterPhAnim(boolean z);

    void setShowMasterSp(boolean z);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void unsetClrMapOvr();

    void unsetExtLst();

    void unsetShow();

    void unsetShowMasterPhAnim();

    void unsetShowMasterSp();

    void unsetTiming();

    void unsetTransition();

    XmlBoolean xgetShow();

    XmlBoolean xgetShowMasterPhAnim();

    XmlBoolean xgetShowMasterSp();

    void xsetShow(XmlBoolean xmlBoolean);

    void xsetShowMasterPhAnim(XmlBoolean xmlBoolean);

    void xsetShowMasterSp(XmlBoolean xmlBoolean);
}
