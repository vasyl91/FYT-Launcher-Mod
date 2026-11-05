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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSlideLayout extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSlideLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidelayouteb34type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideLayout newInstance() {
            return (CTSlideLayout) POIXMLTypeLoader.newInstance(CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout newInstance(XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.newInstance(CTSlideLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(File file) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(file, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(file, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(inputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(inputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(Reader reader) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(reader, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(reader, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(String str) throws XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(str, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(str, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(URL url) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(url, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(url, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLInputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLInputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(Node node) throws XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(node, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideLayout) POIXMLTypeLoader.parse(node, CTSlideLayout.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMappingOverride addNewClrMapOvr();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTCommonSlideData getCSld();

    CTColorMappingOverride getClrMapOvr();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    String getMatchingName();

    boolean getPreserve();

    boolean getShowMasterPhAnim();

    boolean getShowMasterSp();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    STSlideLayoutType.Enum getType();

    boolean getUserDrawn();

    boolean isSetClrMapOvr();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetMatchingName();

    boolean isSetPreserve();

    boolean isSetShowMasterPhAnim();

    boolean isSetShowMasterSp();

    boolean isSetTiming();

    boolean isSetTransition();

    boolean isSetType();

    boolean isSetUserDrawn();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setMatchingName(String str);

    void setPreserve(boolean z);

    void setShowMasterPhAnim(boolean z);

    void setShowMasterSp(boolean z);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void setType(STSlideLayoutType.Enum r1);

    void setUserDrawn(boolean z);

    void unsetClrMapOvr();

    void unsetExtLst();

    void unsetHf();

    void unsetMatchingName();

    void unsetPreserve();

    void unsetShowMasterPhAnim();

    void unsetShowMasterSp();

    void unsetTiming();

    void unsetTransition();

    void unsetType();

    void unsetUserDrawn();

    XmlString xgetMatchingName();

    XmlBoolean xgetPreserve();

    XmlBoolean xgetShowMasterPhAnim();

    XmlBoolean xgetShowMasterSp();

    STSlideLayoutType xgetType();

    XmlBoolean xgetUserDrawn();

    void xsetMatchingName(XmlString xmlString);

    void xsetPreserve(XmlBoolean xmlBoolean);

    void xsetShowMasterPhAnim(XmlBoolean xmlBoolean);

    void xsetShowMasterSp(XmlBoolean xmlBoolean);

    void xsetType(STSlideLayoutType sTSlideLayoutType);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
