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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTLineProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLineProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinepropertiesd5e2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineProperties newInstance() {
            return (CTLineProperties) POIXMLTypeLoader.newInstance(CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties newInstance(XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.newInstance(CTLineProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(File file) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(file, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(file, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(inputStream, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(inputStream, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(Reader reader) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(reader, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(reader, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(String str) throws XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(str, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(str, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(URL url) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(url, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineProperties) POIXMLTypeLoader.parse(url, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(Node node) throws XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(node, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineProperties) POIXMLTypeLoader.parse(node, CTLineProperties.type, xmlOptions);
        }
    }

    CTLineJoinBevel addNewBevel();

    CTDashStopList addNewCustDash();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTLineEndProperties addNewHeadEnd();

    CTLineJoinMiterProperties addNewMiter();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTPresetLineDashProperties addNewPrstDash();

    CTLineJoinRound addNewRound();

    CTSolidColorFillProperties addNewSolidFill();

    CTLineEndProperties addNewTailEnd();

    STPenAlignment.Enum getAlgn();

    CTLineJoinBevel getBevel();

    STLineCap.Enum getCap();

    STCompoundLine.Enum getCmpd();

    CTDashStopList getCustDash();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTLineEndProperties getHeadEnd();

    CTLineJoinMiterProperties getMiter();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTPresetLineDashProperties getPrstDash();

    CTLineJoinRound getRound();

    CTSolidColorFillProperties getSolidFill();

    CTLineEndProperties getTailEnd();

    int getW();

    boolean isSetAlgn();

    boolean isSetBevel();

    boolean isSetCap();

    boolean isSetCmpd();

    boolean isSetCustDash();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetHeadEnd();

    boolean isSetMiter();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetPrstDash();

    boolean isSetRound();

    boolean isSetSolidFill();

    boolean isSetTailEnd();

    boolean isSetW();

    void setAlgn(STPenAlignment.Enum r1);

    void setBevel(CTLineJoinBevel cTLineJoinBevel);

    void setCap(STLineCap.Enum r1);

    void setCmpd(STCompoundLine.Enum r1);

    void setCustDash(CTDashStopList cTDashStopList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setHeadEnd(CTLineEndProperties cTLineEndProperties);

    void setMiter(CTLineJoinMiterProperties cTLineJoinMiterProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setPrstDash(CTPresetLineDashProperties cTPresetLineDashProperties);

    void setRound(CTLineJoinRound cTLineJoinRound);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setTailEnd(CTLineEndProperties cTLineEndProperties);

    void setW(int i);

    void unsetAlgn();

    void unsetBevel();

    void unsetCap();

    void unsetCmpd();

    void unsetCustDash();

    void unsetExtLst();

    void unsetGradFill();

    void unsetHeadEnd();

    void unsetMiter();

    void unsetNoFill();

    void unsetPattFill();

    void unsetPrstDash();

    void unsetRound();

    void unsetSolidFill();

    void unsetTailEnd();

    void unsetW();

    STPenAlignment xgetAlgn();

    STLineCap xgetCap();

    STCompoundLine xgetCmpd();

    STLineWidth xgetW();

    void xsetAlgn(STPenAlignment sTPenAlignment);

    void xsetCap(STLineCap sTLineCap);

    void xsetCmpd(STCompoundLine sTCompoundLine);

    void xsetW(STLineWidth sTLineWidth);
}
