package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTGraphicalObjectFrameLocking extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrameLocking.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectframelocking42adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrameLocking newInstance() {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(String str) throws XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(Node node) throws XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getNoChangeAspect();

    boolean getNoDrilldown();

    boolean getNoGrp();

    boolean getNoMove();

    boolean getNoResize();

    boolean getNoSelect();

    boolean isSetExtLst();

    boolean isSetNoChangeAspect();

    boolean isSetNoDrilldown();

    boolean isSetNoGrp();

    boolean isSetNoMove();

    boolean isSetNoResize();

    boolean isSetNoSelect();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setNoChangeAspect(boolean z);

    void setNoDrilldown(boolean z);

    void setNoGrp(boolean z);

    void setNoMove(boolean z);

    void setNoResize(boolean z);

    void setNoSelect(boolean z);

    void unsetExtLst();

    void unsetNoChangeAspect();

    void unsetNoDrilldown();

    void unsetNoGrp();

    void unsetNoMove();

    void unsetNoResize();

    void unsetNoSelect();

    XmlBoolean xgetNoChangeAspect();

    XmlBoolean xgetNoDrilldown();

    XmlBoolean xgetNoGrp();

    XmlBoolean xgetNoMove();

    XmlBoolean xgetNoResize();

    XmlBoolean xgetNoSelect();

    void xsetNoChangeAspect(XmlBoolean xmlBoolean);

    void xsetNoDrilldown(XmlBoolean xmlBoolean);

    void xsetNoGrp(XmlBoolean xmlBoolean);

    void xsetNoMove(XmlBoolean xmlBoolean);

    void xsetNoResize(XmlBoolean xmlBoolean);

    void xsetNoSelect(XmlBoolean xmlBoolean);
}
