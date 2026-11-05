package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTAbsoluteAnchor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAbsoluteAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctabsoluteanchore360type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAbsoluteAnchor newInstance() {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.newInstance(CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor newInstance(XmlOptions xmlOptions) {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.newInstance(CTAbsoluteAnchor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(File file) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(file, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(file, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(inputStream, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(inputStream, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(Reader reader) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(reader, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(reader, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(String str) throws XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(str, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(str, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(URL url) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(url, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(url, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTAbsoluteAnchor.type, xmlOptions);
        }

        public static CTAbsoluteAnchor parse(Node node) throws XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(node, CTAbsoluteAnchor.type, (XmlOptions) null);
        }

        public static CTAbsoluteAnchor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAbsoluteAnchor) POIXMLTypeLoader.parse(node, CTAbsoluteAnchor.type, xmlOptions);
        }
    }

    CTAnchorClientData addNewClientData();

    CTConnector addNewCxnSp();

    CTPositiveSize2D addNewExt();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTPicture addNewPic();

    CTPoint2D addNewPos();

    CTShape addNewSp();

    CTAnchorClientData getClientData();

    CTConnector getCxnSp();

    CTPositiveSize2D getExt();

    CTGraphicalObjectFrame getGraphicFrame();

    CTGroupShape getGrpSp();

    CTPicture getPic();

    CTPoint2D getPos();

    CTShape getSp();

    boolean isSetCxnSp();

    boolean isSetGraphicFrame();

    boolean isSetGrpSp();

    boolean isSetPic();

    boolean isSetSp();

    void setClientData(CTAnchorClientData cTAnchorClientData);

    void setCxnSp(CTConnector cTConnector);

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGrpSp(CTGroupShape cTGroupShape);

    void setPic(CTPicture cTPicture);

    void setPos(CTPoint2D cTPoint2D);

    void setSp(CTShape cTShape);

    void unsetCxnSp();

    void unsetGraphicFrame();

    void unsetGrpSp();

    void unsetPic();

    void unsetSp();
}
