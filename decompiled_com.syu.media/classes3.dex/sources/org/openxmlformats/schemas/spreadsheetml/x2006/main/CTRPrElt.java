package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTRPrElt extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRPrElt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrpreltecc2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRPrElt newInstance() {
            return (CTRPrElt) POIXMLTypeLoader.newInstance(CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt newInstance(XmlOptions xmlOptions) {
            return (CTRPrElt) POIXMLTypeLoader.newInstance(CTRPrElt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRPrElt.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(File file) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(file, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(file, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(inputStream, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(inputStream, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(Reader reader) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(reader, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(reader, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(String str) throws XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(str, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(str, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(URL url) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(url, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRPrElt) POIXMLTypeLoader.parse(url, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(xMLStreamReader, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(xMLStreamReader, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(xMLInputStream, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(xMLInputStream, CTRPrElt.type, xmlOptions);
        }

        public static CTRPrElt parse(Node node) throws XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(node, CTRPrElt.type, (XmlOptions) null);
        }

        public static CTRPrElt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRPrElt) POIXMLTypeLoader.parse(node, CTRPrElt.type, xmlOptions);
        }
    }

    CTBooleanProperty addNewB();

    CTIntProperty addNewCharset();

    CTColor addNewColor();

    CTBooleanProperty addNewCondense();

    CTBooleanProperty addNewExtend();

    CTIntProperty addNewFamily();

    CTBooleanProperty addNewI();

    CTBooleanProperty addNewOutline();

    CTFontName addNewRFont();

    CTFontScheme addNewScheme();

    CTBooleanProperty addNewShadow();

    CTBooleanProperty addNewStrike();

    CTFontSize addNewSz();

    CTUnderlineProperty addNewU();

    CTVerticalAlignFontProperty addNewVertAlign();

    CTBooleanProperty getBArray(int i);

    CTBooleanProperty[] getBArray();

    List<CTBooleanProperty> getBList();

    CTIntProperty getCharsetArray(int i);

    CTIntProperty[] getCharsetArray();

    List<CTIntProperty> getCharsetList();

    CTColor getColorArray(int i);

    CTColor[] getColorArray();

    List<CTColor> getColorList();

    CTBooleanProperty getCondenseArray(int i);

    CTBooleanProperty[] getCondenseArray();

    List<CTBooleanProperty> getCondenseList();

    CTBooleanProperty getExtendArray(int i);

    CTBooleanProperty[] getExtendArray();

    List<CTBooleanProperty> getExtendList();

    CTIntProperty getFamilyArray(int i);

    CTIntProperty[] getFamilyArray();

    List<CTIntProperty> getFamilyList();

    CTBooleanProperty getIArray(int i);

    CTBooleanProperty[] getIArray();

    List<CTBooleanProperty> getIList();

    CTBooleanProperty getOutlineArray(int i);

    CTBooleanProperty[] getOutlineArray();

    List<CTBooleanProperty> getOutlineList();

    CTFontName getRFontArray(int i);

    CTFontName[] getRFontArray();

    List<CTFontName> getRFontList();

    CTFontScheme getSchemeArray(int i);

    CTFontScheme[] getSchemeArray();

    List<CTFontScheme> getSchemeList();

    CTBooleanProperty getShadowArray(int i);

    CTBooleanProperty[] getShadowArray();

    List<CTBooleanProperty> getShadowList();

    CTBooleanProperty getStrikeArray(int i);

    CTBooleanProperty[] getStrikeArray();

    List<CTBooleanProperty> getStrikeList();

    CTFontSize getSzArray(int i);

    CTFontSize[] getSzArray();

    List<CTFontSize> getSzList();

    CTUnderlineProperty getUArray(int i);

    CTUnderlineProperty[] getUArray();

    List<CTUnderlineProperty> getUList();

    CTVerticalAlignFontProperty getVertAlignArray(int i);

    CTVerticalAlignFontProperty[] getVertAlignArray();

    List<CTVerticalAlignFontProperty> getVertAlignList();

    CTBooleanProperty insertNewB(int i);

    CTIntProperty insertNewCharset(int i);

    CTColor insertNewColor(int i);

    CTBooleanProperty insertNewCondense(int i);

    CTBooleanProperty insertNewExtend(int i);

    CTIntProperty insertNewFamily(int i);

    CTBooleanProperty insertNewI(int i);

    CTBooleanProperty insertNewOutline(int i);

    CTFontName insertNewRFont(int i);

    CTFontScheme insertNewScheme(int i);

    CTBooleanProperty insertNewShadow(int i);

    CTBooleanProperty insertNewStrike(int i);

    CTFontSize insertNewSz(int i);

    CTUnderlineProperty insertNewU(int i);

    CTVerticalAlignFontProperty insertNewVertAlign(int i);

    void removeB(int i);

    void removeCharset(int i);

    void removeColor(int i);

    void removeCondense(int i);

    void removeExtend(int i);

    void removeFamily(int i);

    void removeI(int i);

    void removeOutline(int i);

    void removeRFont(int i);

    void removeScheme(int i);

    void removeShadow(int i);

    void removeStrike(int i);

    void removeSz(int i);

    void removeU(int i);

    void removeVertAlign(int i);

    void setBArray(int i, CTBooleanProperty cTBooleanProperty);

    void setBArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setCharsetArray(int i, CTIntProperty cTIntProperty);

    void setCharsetArray(CTIntProperty[] cTIntPropertyArr);

    void setColorArray(int i, CTColor cTColor);

    void setColorArray(CTColor[] cTColorArr);

    void setCondenseArray(int i, CTBooleanProperty cTBooleanProperty);

    void setCondenseArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setExtendArray(int i, CTBooleanProperty cTBooleanProperty);

    void setExtendArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setFamilyArray(int i, CTIntProperty cTIntProperty);

    void setFamilyArray(CTIntProperty[] cTIntPropertyArr);

    void setIArray(int i, CTBooleanProperty cTBooleanProperty);

    void setIArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setOutlineArray(int i, CTBooleanProperty cTBooleanProperty);

    void setOutlineArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setRFontArray(int i, CTFontName cTFontName);

    void setRFontArray(CTFontName[] cTFontNameArr);

    void setSchemeArray(int i, CTFontScheme cTFontScheme);

    void setSchemeArray(CTFontScheme[] cTFontSchemeArr);

    void setShadowArray(int i, CTBooleanProperty cTBooleanProperty);

    void setShadowArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setStrikeArray(int i, CTBooleanProperty cTBooleanProperty);

    void setStrikeArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setSzArray(int i, CTFontSize cTFontSize);

    void setSzArray(CTFontSize[] cTFontSizeArr);

    void setUArray(int i, CTUnderlineProperty cTUnderlineProperty);

    void setUArray(CTUnderlineProperty[] cTUnderlinePropertyArr);

    void setVertAlignArray(int i, CTVerticalAlignFontProperty cTVerticalAlignFontProperty);

    void setVertAlignArray(CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr);

    int sizeOfBArray();

    int sizeOfCharsetArray();

    int sizeOfColorArray();

    int sizeOfCondenseArray();

    int sizeOfExtendArray();

    int sizeOfFamilyArray();

    int sizeOfIArray();

    int sizeOfOutlineArray();

    int sizeOfRFontArray();

    int sizeOfSchemeArray();

    int sizeOfShadowArray();

    int sizeOfStrikeArray();

    int sizeOfSzArray();

    int sizeOfUArray();

    int sizeOfVertAlignArray();
}
