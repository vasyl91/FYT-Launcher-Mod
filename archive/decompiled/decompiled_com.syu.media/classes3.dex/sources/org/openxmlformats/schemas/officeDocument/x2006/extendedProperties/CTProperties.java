package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctproperties3f10type");

    public static final class Factory {
        private Factory() {
        }

        public static CTProperties newInstance() {
            return (CTProperties) POIXMLTypeLoader.newInstance(CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties newInstance(XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.newInstance(CTProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(File file) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(file, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(file, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(inputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(inputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Reader reader) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(reader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(reader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(String str) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(str, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(str, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(URL url) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(url, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTProperties) POIXMLTypeLoader.parse(url, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLInputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Node node) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(node, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTProperties) POIXMLTypeLoader.parse(node, CTProperties.type, xmlOptions);
        }
    }

    CTDigSigBlob addNewDigSig();

    CTVectorVariant addNewHLinks();

    CTVectorVariant addNewHeadingPairs();

    CTVectorLpstr addNewTitlesOfParts();

    String getAppVersion();

    String getApplication();

    int getCharacters();

    int getCharactersWithSpaces();

    String getCompany();

    CTDigSigBlob getDigSig();

    int getDocSecurity();

    CTVectorVariant getHLinks();

    CTVectorVariant getHeadingPairs();

    int getHiddenSlides();

    String getHyperlinkBase();

    boolean getHyperlinksChanged();

    int getLines();

    boolean getLinksUpToDate();

    int getMMClips();

    String getManager();

    int getNotes();

    int getPages();

    int getParagraphs();

    String getPresentationFormat();

    boolean getScaleCrop();

    boolean getSharedDoc();

    int getSlides();

    String getTemplate();

    CTVectorLpstr getTitlesOfParts();

    int getTotalTime();

    int getWords();

    boolean isSetAppVersion();

    boolean isSetApplication();

    boolean isSetCharacters();

    boolean isSetCharactersWithSpaces();

    boolean isSetCompany();

    boolean isSetDigSig();

    boolean isSetDocSecurity();

    boolean isSetHLinks();

    boolean isSetHeadingPairs();

    boolean isSetHiddenSlides();

    boolean isSetHyperlinkBase();

    boolean isSetHyperlinksChanged();

    boolean isSetLines();

    boolean isSetLinksUpToDate();

    boolean isSetMMClips();

    boolean isSetManager();

    boolean isSetNotes();

    boolean isSetPages();

    boolean isSetParagraphs();

    boolean isSetPresentationFormat();

    boolean isSetScaleCrop();

    boolean isSetSharedDoc();

    boolean isSetSlides();

    boolean isSetTemplate();

    boolean isSetTitlesOfParts();

    boolean isSetTotalTime();

    boolean isSetWords();

    void setAppVersion(String str);

    void setApplication(String str);

    void setCharacters(int i);

    void setCharactersWithSpaces(int i);

    void setCompany(String str);

    void setDigSig(CTDigSigBlob cTDigSigBlob);

    void setDocSecurity(int i);

    void setHLinks(CTVectorVariant cTVectorVariant);

    void setHeadingPairs(CTVectorVariant cTVectorVariant);

    void setHiddenSlides(int i);

    void setHyperlinkBase(String str);

    void setHyperlinksChanged(boolean z);

    void setLines(int i);

    void setLinksUpToDate(boolean z);

    void setMMClips(int i);

    void setManager(String str);

    void setNotes(int i);

    void setPages(int i);

    void setParagraphs(int i);

    void setPresentationFormat(String str);

    void setScaleCrop(boolean z);

    void setSharedDoc(boolean z);

    void setSlides(int i);

    void setTemplate(String str);

    void setTitlesOfParts(CTVectorLpstr cTVectorLpstr);

    void setTotalTime(int i);

    void setWords(int i);

    void unsetAppVersion();

    void unsetApplication();

    void unsetCharacters();

    void unsetCharactersWithSpaces();

    void unsetCompany();

    void unsetDigSig();

    void unsetDocSecurity();

    void unsetHLinks();

    void unsetHeadingPairs();

    void unsetHiddenSlides();

    void unsetHyperlinkBase();

    void unsetHyperlinksChanged();

    void unsetLines();

    void unsetLinksUpToDate();

    void unsetMMClips();

    void unsetManager();

    void unsetNotes();

    void unsetPages();

    void unsetParagraphs();

    void unsetPresentationFormat();

    void unsetScaleCrop();

    void unsetSharedDoc();

    void unsetSlides();

    void unsetTemplate();

    void unsetTitlesOfParts();

    void unsetTotalTime();

    void unsetWords();

    XmlString xgetAppVersion();

    XmlString xgetApplication();

    XmlInt xgetCharacters();

    XmlInt xgetCharactersWithSpaces();

    XmlString xgetCompany();

    XmlInt xgetDocSecurity();

    XmlInt xgetHiddenSlides();

    XmlString xgetHyperlinkBase();

    XmlBoolean xgetHyperlinksChanged();

    XmlInt xgetLines();

    XmlBoolean xgetLinksUpToDate();

    XmlInt xgetMMClips();

    XmlString xgetManager();

    XmlInt xgetNotes();

    XmlInt xgetPages();

    XmlInt xgetParagraphs();

    XmlString xgetPresentationFormat();

    XmlBoolean xgetScaleCrop();

    XmlBoolean xgetSharedDoc();

    XmlInt xgetSlides();

    XmlString xgetTemplate();

    XmlInt xgetTotalTime();

    XmlInt xgetWords();

    void xsetAppVersion(XmlString xmlString);

    void xsetApplication(XmlString xmlString);

    void xsetCharacters(XmlInt xmlInt);

    void xsetCharactersWithSpaces(XmlInt xmlInt);

    void xsetCompany(XmlString xmlString);

    void xsetDocSecurity(XmlInt xmlInt);

    void xsetHiddenSlides(XmlInt xmlInt);

    void xsetHyperlinkBase(XmlString xmlString);

    void xsetHyperlinksChanged(XmlBoolean xmlBoolean);

    void xsetLines(XmlInt xmlInt);

    void xsetLinksUpToDate(XmlBoolean xmlBoolean);

    void xsetMMClips(XmlInt xmlInt);

    void xsetManager(XmlString xmlString);

    void xsetNotes(XmlInt xmlInt);

    void xsetPages(XmlInt xmlInt);

    void xsetParagraphs(XmlInt xmlInt);

    void xsetPresentationFormat(XmlString xmlString);

    void xsetScaleCrop(XmlBoolean xmlBoolean);

    void xsetSharedDoc(XmlBoolean xmlBoolean);

    void xsetSlides(XmlInt xmlInt);

    void xsetTemplate(XmlString xmlString);

    void xsetTotalTime(XmlInt xmlInt);

    void xsetWords(XmlInt xmlInt);
}
