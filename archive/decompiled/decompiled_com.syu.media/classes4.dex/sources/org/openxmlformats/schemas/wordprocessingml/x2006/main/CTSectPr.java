package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTSectPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSectPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsectpr1123type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSectPr newInstance() {
            return (CTSectPr) POIXMLTypeLoader.newInstance(CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr newInstance(XmlOptions xmlOptions) {
            return (CTSectPr) POIXMLTypeLoader.newInstance(CTSectPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSectPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(File file) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(file, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(file, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(inputStream, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(inputStream, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(Reader reader) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(reader, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(reader, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(String str) throws XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(str, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(str, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(URL url) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(url, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSectPr) POIXMLTypeLoader.parse(url, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(xMLStreamReader, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(xMLInputStream, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(xMLInputStream, CTSectPr.type, xmlOptions);
        }

        public static CTSectPr parse(Node node) throws XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(node, CTSectPr.type, (XmlOptions) null);
        }

        public static CTSectPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSectPr) POIXMLTypeLoader.parse(node, CTSectPr.type, xmlOptions);
        }
    }

    CTOnOff addNewBidi();

    CTColumns addNewCols();

    CTDocGrid addNewDocGrid();

    CTEdnProps addNewEndnotePr();

    CTHdrFtrRef addNewFooterReference();

    CTFtnProps addNewFootnotePr();

    CTOnOff addNewFormProt();

    CTHdrFtrRef addNewHeaderReference();

    CTLineNumber addNewLnNumType();

    CTOnOff addNewNoEndnote();

    CTPaperSource addNewPaperSrc();

    CTPageBorders addNewPgBorders();

    CTPageMar addNewPgMar();

    CTPageNumber addNewPgNumType();

    CTPageSz addNewPgSz();

    CTRel addNewPrinterSettings();

    CTOnOff addNewRtlGutter();

    CTSectPrChange addNewSectPrChange();

    CTTextDirection addNewTextDirection();

    CTOnOff addNewTitlePg();

    CTSectType addNewType();

    CTVerticalJc addNewVAlign();

    CTOnOff getBidi();

    CTColumns getCols();

    CTDocGrid getDocGrid();

    CTEdnProps getEndnotePr();

    CTHdrFtrRef getFooterReferenceArray(int i);

    CTHdrFtrRef[] getFooterReferenceArray();

    List<CTHdrFtrRef> getFooterReferenceList();

    CTFtnProps getFootnotePr();

    CTOnOff getFormProt();

    CTHdrFtrRef getHeaderReferenceArray(int i);

    CTHdrFtrRef[] getHeaderReferenceArray();

    List<CTHdrFtrRef> getHeaderReferenceList();

    CTLineNumber getLnNumType();

    CTOnOff getNoEndnote();

    CTPaperSource getPaperSrc();

    CTPageBorders getPgBorders();

    CTPageMar getPgMar();

    CTPageNumber getPgNumType();

    CTPageSz getPgSz();

    CTRel getPrinterSettings();

    byte[] getRsidDel();

    byte[] getRsidR();

    byte[] getRsidRPr();

    byte[] getRsidSect();

    CTOnOff getRtlGutter();

    CTSectPrChange getSectPrChange();

    CTTextDirection getTextDirection();

    CTOnOff getTitlePg();

    CTSectType getType();

    CTVerticalJc getVAlign();

    CTHdrFtrRef insertNewFooterReference(int i);

    CTHdrFtrRef insertNewHeaderReference(int i);

    boolean isSetBidi();

    boolean isSetCols();

    boolean isSetDocGrid();

    boolean isSetEndnotePr();

    boolean isSetFootnotePr();

    boolean isSetFormProt();

    boolean isSetLnNumType();

    boolean isSetNoEndnote();

    boolean isSetPaperSrc();

    boolean isSetPgBorders();

    boolean isSetPgMar();

    boolean isSetPgNumType();

    boolean isSetPgSz();

    boolean isSetPrinterSettings();

    boolean isSetRsidDel();

    boolean isSetRsidR();

    boolean isSetRsidRPr();

    boolean isSetRsidSect();

    boolean isSetRtlGutter();

    boolean isSetSectPrChange();

    boolean isSetTextDirection();

    boolean isSetTitlePg();

    boolean isSetType();

    boolean isSetVAlign();

    void removeFooterReference(int i);

    void removeHeaderReference(int i);

    void setBidi(CTOnOff cTOnOff);

    void setCols(CTColumns cTColumns);

    void setDocGrid(CTDocGrid cTDocGrid);

    void setEndnotePr(CTEdnProps cTEdnProps);

    void setFooterReferenceArray(int i, CTHdrFtrRef cTHdrFtrRef);

    void setFooterReferenceArray(CTHdrFtrRef[] cTHdrFtrRefArr);

    void setFootnotePr(CTFtnProps cTFtnProps);

    void setFormProt(CTOnOff cTOnOff);

    void setHeaderReferenceArray(int i, CTHdrFtrRef cTHdrFtrRef);

    void setHeaderReferenceArray(CTHdrFtrRef[] cTHdrFtrRefArr);

    void setLnNumType(CTLineNumber cTLineNumber);

    void setNoEndnote(CTOnOff cTOnOff);

    void setPaperSrc(CTPaperSource cTPaperSource);

    void setPgBorders(CTPageBorders cTPageBorders);

    void setPgMar(CTPageMar cTPageMar);

    void setPgNumType(CTPageNumber cTPageNumber);

    void setPgSz(CTPageSz cTPageSz);

    void setPrinterSettings(CTRel cTRel);

    void setRsidDel(byte[] bArr);

    void setRsidR(byte[] bArr);

    void setRsidRPr(byte[] bArr);

    void setRsidSect(byte[] bArr);

    void setRtlGutter(CTOnOff cTOnOff);

    void setSectPrChange(CTSectPrChange cTSectPrChange);

    void setTextDirection(CTTextDirection cTTextDirection);

    void setTitlePg(CTOnOff cTOnOff);

    void setType(CTSectType cTSectType);

    void setVAlign(CTVerticalJc cTVerticalJc);

    int sizeOfFooterReferenceArray();

    int sizeOfHeaderReferenceArray();

    void unsetBidi();

    void unsetCols();

    void unsetDocGrid();

    void unsetEndnotePr();

    void unsetFootnotePr();

    void unsetFormProt();

    void unsetLnNumType();

    void unsetNoEndnote();

    void unsetPaperSrc();

    void unsetPgBorders();

    void unsetPgMar();

    void unsetPgNumType();

    void unsetPgSz();

    void unsetPrinterSettings();

    void unsetRsidDel();

    void unsetRsidR();

    void unsetRsidRPr();

    void unsetRsidSect();

    void unsetRtlGutter();

    void unsetSectPrChange();

    void unsetTextDirection();

    void unsetTitlePg();

    void unsetType();

    void unsetVAlign();

    STLongHexNumber xgetRsidDel();

    STLongHexNumber xgetRsidR();

    STLongHexNumber xgetRsidRPr();

    STLongHexNumber xgetRsidSect();

    void xsetRsidDel(STLongHexNumber sTLongHexNumber);

    void xsetRsidR(STLongHexNumber sTLongHexNumber);

    void xsetRsidRPr(STLongHexNumber sTLongHexNumber);

    void xsetRsidSect(STLongHexNumber sTLongHexNumber);
}
