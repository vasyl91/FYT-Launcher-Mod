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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTwoCellAnchor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTwoCellAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttwocellanchor1e8dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTwoCellAnchor newInstance() {
            return (CTTwoCellAnchor) POIXMLTypeLoader.newInstance(CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor newInstance(XmlOptions xmlOptions) {
            return (CTTwoCellAnchor) POIXMLTypeLoader.newInstance(CTTwoCellAnchor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(File file) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(file, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(file, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(inputStream, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(inputStream, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(Reader reader) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(reader, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(reader, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(String str) throws XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(str, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(str, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(URL url) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(url, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(url, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(xMLStreamReader, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(xMLInputStream, CTTwoCellAnchor.type, xmlOptions);
        }

        public static CTTwoCellAnchor parse(Node node) throws XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(node, CTTwoCellAnchor.type, (XmlOptions) null);
        }

        public static CTTwoCellAnchor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTwoCellAnchor) POIXMLTypeLoader.parse(node, CTTwoCellAnchor.type, xmlOptions);
        }
    }

    CTAnchorClientData addNewClientData();

    CTConnector addNewCxnSp();

    CTMarker addNewFrom();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTPicture addNewPic();

    CTShape addNewSp();

    CTMarker addNewTo();

    CTAnchorClientData getClientData();

    CTConnector getCxnSp();

    STEditAs.Enum getEditAs();

    CTMarker getFrom();

    CTGraphicalObjectFrame getGraphicFrame();

    CTGroupShape getGrpSp();

    CTPicture getPic();

    CTShape getSp();

    CTMarker getTo();

    boolean isSetCxnSp();

    boolean isSetEditAs();

    boolean isSetGraphicFrame();

    boolean isSetGrpSp();

    boolean isSetPic();

    boolean isSetSp();

    void setClientData(CTAnchorClientData cTAnchorClientData);

    void setCxnSp(CTConnector cTConnector);

    void setEditAs(STEditAs.Enum r1);

    void setFrom(CTMarker cTMarker);

    void setGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGrpSp(CTGroupShape cTGroupShape);

    void setPic(CTPicture cTPicture);

    void setSp(CTShape cTShape);

    void setTo(CTMarker cTMarker);

    void unsetCxnSp();

    void unsetEditAs();

    void unsetGraphicFrame();

    void unsetGrpSp();

    void unsetPic();

    void unsetSp();

    STEditAs xgetEditAs();

    void xsetEditAs(STEditAs sTEditAs);
}
