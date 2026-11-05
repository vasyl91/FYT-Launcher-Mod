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
public interface CTTextBodyProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextBodyProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbodyproperties87ddtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBodyProperties newInstance() {
            return (CTTextBodyProperties) POIXMLTypeLoader.newInstance(CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties newInstance(XmlOptions xmlOptions) {
            return (CTTextBodyProperties) POIXMLTypeLoader.newInstance(CTTextBodyProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(File file) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(file, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(file, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(inputStream, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(inputStream, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(Reader reader) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(reader, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(reader, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(String str) throws XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(str, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(str, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(URL url) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(url, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(url, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(xMLInputStream, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(xMLInputStream, CTTextBodyProperties.type, xmlOptions);
        }

        public static CTTextBodyProperties parse(Node node) throws XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(node, CTTextBodyProperties.type, (XmlOptions) null);
        }

        public static CTTextBodyProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBodyProperties) POIXMLTypeLoader.parse(node, CTTextBodyProperties.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTFlatText addNewFlatTx();

    CTTextNoAutofit addNewNoAutofit();

    CTTextNormalAutofit addNewNormAutofit();

    CTPresetTextShape addNewPrstTxWarp();

    CTScene3D addNewScene3D();

    CTShape3D addNewSp3D();

    CTTextShapeAutofit addNewSpAutoFit();

    STTextAnchoringType.Enum getAnchor();

    boolean getAnchorCtr();

    int getBIns();

    boolean getCompatLnSpc();

    CTOfficeArtExtensionList getExtLst();

    CTFlatText getFlatTx();

    boolean getForceAA();

    boolean getFromWordArt();

    STTextHorzOverflowType.Enum getHorzOverflow();

    int getLIns();

    CTTextNoAutofit getNoAutofit();

    CTTextNormalAutofit getNormAutofit();

    int getNumCol();

    CTPresetTextShape getPrstTxWarp();

    int getRIns();

    int getRot();

    boolean getRtlCol();

    CTScene3D getScene3D();

    CTShape3D getSp3D();

    CTTextShapeAutofit getSpAutoFit();

    int getSpcCol();

    boolean getSpcFirstLastPara();

    int getTIns();

    boolean getUpright();

    STTextVerticalType.Enum getVert();

    STTextVertOverflowType.Enum getVertOverflow();

    STTextWrappingType.Enum getWrap();

    boolean isSetAnchor();

    boolean isSetAnchorCtr();

    boolean isSetBIns();

    boolean isSetCompatLnSpc();

    boolean isSetExtLst();

    boolean isSetFlatTx();

    boolean isSetForceAA();

    boolean isSetFromWordArt();

    boolean isSetHorzOverflow();

    boolean isSetLIns();

    boolean isSetNoAutofit();

    boolean isSetNormAutofit();

    boolean isSetNumCol();

    boolean isSetPrstTxWarp();

    boolean isSetRIns();

    boolean isSetRot();

    boolean isSetRtlCol();

    boolean isSetScene3D();

    boolean isSetSp3D();

    boolean isSetSpAutoFit();

    boolean isSetSpcCol();

    boolean isSetSpcFirstLastPara();

    boolean isSetTIns();

    boolean isSetUpright();

    boolean isSetVert();

    boolean isSetVertOverflow();

    boolean isSetWrap();

    void setAnchor(STTextAnchoringType.Enum r1);

    void setAnchorCtr(boolean z);

    void setBIns(int i);

    void setCompatLnSpc(boolean z);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFlatTx(CTFlatText cTFlatText);

    void setForceAA(boolean z);

    void setFromWordArt(boolean z);

    void setHorzOverflow(STTextHorzOverflowType.Enum r1);

    void setLIns(int i);

    void setNoAutofit(CTTextNoAutofit cTTextNoAutofit);

    void setNormAutofit(CTTextNormalAutofit cTTextNormalAutofit);

    void setNumCol(int i);

    void setPrstTxWarp(CTPresetTextShape cTPresetTextShape);

    void setRIns(int i);

    void setRot(int i);

    void setRtlCol(boolean z);

    void setScene3D(CTScene3D cTScene3D);

    void setSp3D(CTShape3D cTShape3D);

    void setSpAutoFit(CTTextShapeAutofit cTTextShapeAutofit);

    void setSpcCol(int i);

    void setSpcFirstLastPara(boolean z);

    void setTIns(int i);

    void setUpright(boolean z);

    void setVert(STTextVerticalType.Enum r1);

    void setVertOverflow(STTextVertOverflowType.Enum r1);

    void setWrap(STTextWrappingType.Enum r1);

    void unsetAnchor();

    void unsetAnchorCtr();

    void unsetBIns();

    void unsetCompatLnSpc();

    void unsetExtLst();

    void unsetFlatTx();

    void unsetForceAA();

    void unsetFromWordArt();

    void unsetHorzOverflow();

    void unsetLIns();

    void unsetNoAutofit();

    void unsetNormAutofit();

    void unsetNumCol();

    void unsetPrstTxWarp();

    void unsetRIns();

    void unsetRot();

    void unsetRtlCol();

    void unsetScene3D();

    void unsetSp3D();

    void unsetSpAutoFit();

    void unsetSpcCol();

    void unsetSpcFirstLastPara();

    void unsetTIns();

    void unsetUpright();

    void unsetVert();

    void unsetVertOverflow();

    void unsetWrap();

    STTextAnchoringType xgetAnchor();

    XmlBoolean xgetAnchorCtr();

    STCoordinate32 xgetBIns();

    XmlBoolean xgetCompatLnSpc();

    XmlBoolean xgetForceAA();

    XmlBoolean xgetFromWordArt();

    STTextHorzOverflowType xgetHorzOverflow();

    STCoordinate32 xgetLIns();

    STTextColumnCount xgetNumCol();

    STCoordinate32 xgetRIns();

    STAngle xgetRot();

    XmlBoolean xgetRtlCol();

    STPositiveCoordinate32 xgetSpcCol();

    XmlBoolean xgetSpcFirstLastPara();

    STCoordinate32 xgetTIns();

    XmlBoolean xgetUpright();

    STTextVerticalType xgetVert();

    STTextVertOverflowType xgetVertOverflow();

    STTextWrappingType xgetWrap();

    void xsetAnchor(STTextAnchoringType sTTextAnchoringType);

    void xsetAnchorCtr(XmlBoolean xmlBoolean);

    void xsetBIns(STCoordinate32 sTCoordinate32);

    void xsetCompatLnSpc(XmlBoolean xmlBoolean);

    void xsetForceAA(XmlBoolean xmlBoolean);

    void xsetFromWordArt(XmlBoolean xmlBoolean);

    void xsetHorzOverflow(STTextHorzOverflowType sTTextHorzOverflowType);

    void xsetLIns(STCoordinate32 sTCoordinate32);

    void xsetNumCol(STTextColumnCount sTTextColumnCount);

    void xsetRIns(STCoordinate32 sTCoordinate32);

    void xsetRot(STAngle sTAngle);

    void xsetRtlCol(XmlBoolean xmlBoolean);

    void xsetSpcCol(STPositiveCoordinate32 sTPositiveCoordinate32);

    void xsetSpcFirstLastPara(XmlBoolean xmlBoolean);

    void xsetTIns(STCoordinate32 sTCoordinate32);

    void xsetUpright(XmlBoolean xmlBoolean);

    void xsetVert(STTextVerticalType sTTextVerticalType);

    void xsetVertOverflow(STTextVertOverflowType sTTextVertOverflowType);

    void xsetWrap(STTextWrappingType sTTextWrappingType);
}
