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
public interface CTStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstyle41c1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyle newInstance() {
            return (CTStyle) POIXMLTypeLoader.newInstance(CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle newInstance(XmlOptions xmlOptions) {
            return (CTStyle) POIXMLTypeLoader.newInstance(CTStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(File file) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(file, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(file, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(inputStream, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(inputStream, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(Reader reader) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(reader, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(reader, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(String str) throws XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(str, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(str, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(URL url) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(url, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyle) POIXMLTypeLoader.parse(url, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(xMLInputStream, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(xMLInputStream, CTStyle.type, xmlOptions);
        }

        public static CTStyle parse(Node node) throws XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(node, CTStyle.type, (XmlOptions) null);
        }

        public static CTStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyle) POIXMLTypeLoader.parse(node, CTStyle.type, xmlOptions);
        }
    }

    CTString addNewAliases();

    CTOnOff addNewAutoRedefine();

    CTString addNewBasedOn();

    CTOnOff addNewHidden();

    CTString addNewLink();

    CTOnOff addNewLocked();

    CTString addNewName();

    CTString addNewNext();

    CTPPr addNewPPr();

    CTOnOff addNewPersonal();

    CTOnOff addNewPersonalCompose();

    CTOnOff addNewPersonalReply();

    CTOnOff addNewQFormat();

    CTRPr addNewRPr();

    CTLongHexNumber addNewRsid();

    CTOnOff addNewSemiHidden();

    CTTblPrBase addNewTblPr();

    CTTblStylePr addNewTblStylePr();

    CTTcPr addNewTcPr();

    CTTrPr addNewTrPr();

    CTDecimalNumber addNewUiPriority();

    CTOnOff addNewUnhideWhenUsed();

    CTString getAliases();

    CTOnOff getAutoRedefine();

    CTString getBasedOn();

    STOnOff.Enum getCustomStyle();

    STOnOff.Enum getDefault();

    CTOnOff getHidden();

    CTString getLink();

    CTOnOff getLocked();

    CTString getName();

    CTString getNext();

    CTPPr getPPr();

    CTOnOff getPersonal();

    CTOnOff getPersonalCompose();

    CTOnOff getPersonalReply();

    CTOnOff getQFormat();

    CTRPr getRPr();

    CTLongHexNumber getRsid();

    CTOnOff getSemiHidden();

    String getStyleId();

    CTTblPrBase getTblPr();

    CTTblStylePr getTblStylePrArray(int i);

    CTTblStylePr[] getTblStylePrArray();

    List<CTTblStylePr> getTblStylePrList();

    CTTcPr getTcPr();

    CTTrPr getTrPr();

    STStyleType.Enum getType();

    CTDecimalNumber getUiPriority();

    CTOnOff getUnhideWhenUsed();

    CTTblStylePr insertNewTblStylePr(int i);

    boolean isSetAliases();

    boolean isSetAutoRedefine();

    boolean isSetBasedOn();

    boolean isSetCustomStyle();

    boolean isSetDefault();

    boolean isSetHidden();

    boolean isSetLink();

    boolean isSetLocked();

    boolean isSetName();

    boolean isSetNext();

    boolean isSetPPr();

    boolean isSetPersonal();

    boolean isSetPersonalCompose();

    boolean isSetPersonalReply();

    boolean isSetQFormat();

    boolean isSetRPr();

    boolean isSetRsid();

    boolean isSetSemiHidden();

    boolean isSetStyleId();

    boolean isSetTblPr();

    boolean isSetTcPr();

    boolean isSetTrPr();

    boolean isSetType();

    boolean isSetUiPriority();

    boolean isSetUnhideWhenUsed();

    void removeTblStylePr(int i);

    void setAliases(CTString cTString);

    void setAutoRedefine(CTOnOff cTOnOff);

    void setBasedOn(CTString cTString);

    void setCustomStyle(STOnOff.Enum r1);

    void setDefault(STOnOff.Enum r1);

    void setHidden(CTOnOff cTOnOff);

    void setLink(CTString cTString);

    void setLocked(CTOnOff cTOnOff);

    void setName(CTString cTString);

    void setNext(CTString cTString);

    void setPPr(CTPPr cTPPr);

    void setPersonal(CTOnOff cTOnOff);

    void setPersonalCompose(CTOnOff cTOnOff);

    void setPersonalReply(CTOnOff cTOnOff);

    void setQFormat(CTOnOff cTOnOff);

    void setRPr(CTRPr cTRPr);

    void setRsid(CTLongHexNumber cTLongHexNumber);

    void setSemiHidden(CTOnOff cTOnOff);

    void setStyleId(String str);

    void setTblPr(CTTblPrBase cTTblPrBase);

    void setTblStylePrArray(int i, CTTblStylePr cTTblStylePr);

    void setTblStylePrArray(CTTblStylePr[] cTTblStylePrArr);

    void setTcPr(CTTcPr cTTcPr);

    void setTrPr(CTTrPr cTTrPr);

    void setType(STStyleType.Enum r1);

    void setUiPriority(CTDecimalNumber cTDecimalNumber);

    void setUnhideWhenUsed(CTOnOff cTOnOff);

    int sizeOfTblStylePrArray();

    void unsetAliases();

    void unsetAutoRedefine();

    void unsetBasedOn();

    void unsetCustomStyle();

    void unsetDefault();

    void unsetHidden();

    void unsetLink();

    void unsetLocked();

    void unsetName();

    void unsetNext();

    void unsetPPr();

    void unsetPersonal();

    void unsetPersonalCompose();

    void unsetPersonalReply();

    void unsetQFormat();

    void unsetRPr();

    void unsetRsid();

    void unsetSemiHidden();

    void unsetStyleId();

    void unsetTblPr();

    void unsetTcPr();

    void unsetTrPr();

    void unsetType();

    void unsetUiPriority();

    void unsetUnhideWhenUsed();

    STOnOff xgetCustomStyle();

    STOnOff xgetDefault();

    STString xgetStyleId();

    STStyleType xgetType();

    void xsetCustomStyle(STOnOff sTOnOff);

    void xsetDefault(STOnOff sTOnOff);

    void xsetStyleId(STString sTString);

    void xsetType(STStyleType sTStyleType);
}
