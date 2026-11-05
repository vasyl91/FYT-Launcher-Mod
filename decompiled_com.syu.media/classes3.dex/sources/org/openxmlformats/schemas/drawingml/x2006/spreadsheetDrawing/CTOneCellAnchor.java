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
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTOneCellAnchor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOneCellAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctonecellanchor0527type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOneCellAnchor newInstance() {
            return (CTOneCellAnchor) POIXMLTypeLoader.newInstance(CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor newInstance(XmlOptions xmlOptions) {
            return (CTOneCellAnchor) POIXMLTypeLoader.newInstance(CTOneCellAnchor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(File file) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(file, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(file, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(inputStream, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(inputStream, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(Reader reader) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(reader, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(reader, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(String str) throws XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(str, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(str, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(URL url) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(url, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(url, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTOneCellAnchor.type, xmlOptions);
        }

        public static CTOneCellAnchor parse(Node node) throws XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(node, CTOneCellAnchor.type, (XmlOptions) null);
        }

        public static CTOneCellAnchor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOneCellAnchor) POIXMLTypeLoader.parse(node, CTOneCellAnchor.type, xmlOptions);
        }
    }

    CTAnchorClientData addNewClientData();

    CTConnector addNewCxnSp();

    CTPositiveSize2D addNewExt();

    CTMarker addNewFrom();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTPicture addNewPic();

    CTShape addNewSp();

    CTAnchorClientData getClientData();

    CTConnector getCxnSp();

    CTPositiveSize2D getExt();

    CTMarker getFrom();

    CTGraphicalObjectFrame getGraphicFrame();

    CTGroupShape getGrpSp();

    CTPicture getPic();

    CTShape getSp();

    boolean isSetCxnSp();

    boolean isSetGraphicFrame();

    boolean isSetGrpSp();

    boolean isSetPic();

    boolean isSetSp();

    void setClientData(CTAnchorClientData cTAnchorClientData);

    void setCxnSp(CTConnector cTConnector);

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setFrom(CTMarker cTMarker);

    void setGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGrpSp(CTGroupShape cTGroupShape);

    void setPic(CTPicture cTPicture);

    void setSp(CTShape cTShape);

    void unsetCxnSp();

    void unsetGraphicFrame();

    void unsetGrpSp();

    void unsetPic();

    void unsetSp();
}
