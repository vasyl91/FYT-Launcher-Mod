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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMathPr;
import org.openxmlformats.schemas.schemaLibrary.x2006.main.CTSchemaLibrary;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTSettings extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSettings.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsettingsd6a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSettings newInstance() {
            return (CTSettings) POIXMLTypeLoader.newInstance(CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings newInstance(XmlOptions xmlOptions) {
            return (CTSettings) POIXMLTypeLoader.newInstance(CTSettings.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSettings.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(File file) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(file, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(file, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(inputStream, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(inputStream, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(Reader reader) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(reader, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(reader, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(String str) throws XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(str, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(str, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(URL url) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(url, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSettings) POIXMLTypeLoader.parse(url, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(xMLStreamReader, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(xMLStreamReader, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(xMLInputStream, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(xMLInputStream, CTSettings.type, xmlOptions);
        }

        public static CTSettings parse(Node node) throws XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(node, CTSettings.type, (XmlOptions) null);
        }

        public static CTSettings parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSettings) POIXMLTypeLoader.parse(node, CTSettings.type, xmlOptions);
        }
    }

    CTWritingStyle addNewActiveWritingStyle();

    CTOnOff addNewAlignBordersAndEdges();

    CTOnOff addNewAlwaysMergeEmptyNamespace();

    CTOnOff addNewAlwaysShowPlaceholderText();

    CTString addNewAttachedSchema();

    CTRel addNewAttachedTemplate();

    CTOnOff addNewAutoFormatOverride();

    CTOnOff addNewAutoHyphenation();

    CTOnOff addNewBookFoldPrinting();

    CTDecimalNumber addNewBookFoldPrintingSheets();

    CTOnOff addNewBookFoldRevPrinting();

    CTOnOff addNewBordersDoNotSurroundFooter();

    CTOnOff addNewBordersDoNotSurroundHeader();

    CTCaptions addNewCaptions();

    CTCharacterSpacing addNewCharacterSpacingControl();

    CTString addNewClickAndTypeStyle();

    CTColorSchemeMapping addNewClrSchemeMapping();

    CTCompat addNewCompat();

    CTDecimalNumber addNewConsecutiveHyphenLimit();

    CTString addNewDecimalSymbol();

    CTTwipsMeasure addNewDefaultTabStop();

    CTString addNewDefaultTableStyle();

    CTOnOff addNewDisplayBackgroundShape();

    CTDecimalNumber addNewDisplayHorizontalDrawingGridEvery();

    CTDecimalNumber addNewDisplayVerticalDrawingGridEvery();

    CTOnOff addNewDoNotAutoCompressPictures();

    CTOnOff addNewDoNotDemarcateInvalidXml();

    CTOnOff addNewDoNotDisplayPageBoundaries();

    CTOnOff addNewDoNotEmbedSmartTags();

    CTOnOff addNewDoNotHyphenateCaps();

    CTOnOff addNewDoNotIncludeSubdocsInStats();

    CTOnOff addNewDoNotShadeFormData();

    CTOnOff addNewDoNotTrackFormatting();

    CTOnOff addNewDoNotTrackMoves();

    CTOnOff addNewDoNotUseMarginsForDrawingGridOrigin();

    CTOnOff addNewDoNotValidateAgainstSchema();

    CTDocVars addNewDocVars();

    CTDocProtect addNewDocumentProtection();

    CTDocType addNewDocumentType();

    CTTwipsMeasure addNewDrawingGridHorizontalOrigin();

    CTTwipsMeasure addNewDrawingGridHorizontalSpacing();

    CTTwipsMeasure addNewDrawingGridVerticalOrigin();

    CTTwipsMeasure addNewDrawingGridVerticalSpacing();

    CTOnOff addNewEmbedSystemFonts();

    CTOnOff addNewEmbedTrueTypeFonts();

    CTEdnDocProps addNewEndnotePr();

    CTOnOff addNewEvenAndOddHeaders();

    CTFtnDocProps addNewFootnotePr();

    CTEmpty addNewForceUpgrade();

    CTOnOff addNewFormsDesign();

    CTOnOff addNewGutterAtTop();

    CTShapeDefaults addNewHdrShapeDefaults();

    CTOnOff addNewHideGrammaticalErrors();

    CTOnOff addNewHideSpellingErrors();

    CTTwipsMeasure addNewHyphenationZone();

    CTOnOff addNewIgnoreMixedContent();

    CTOnOff addNewLinkStyles();

    CTString addNewListSeparator();

    CTMailMerge addNewMailMerge();

    CTMathPr addNewMathPr();

    CTOnOff addNewMirrorMargins();

    CTKinsoku addNewNoLineBreaksAfter();

    CTKinsoku addNewNoLineBreaksBefore();

    CTOnOff addNewNoPunctuationKerning();

    CTOnOff addNewPrintFormsData();

    CTOnOff addNewPrintFractionalCharacterWidth();

    CTOnOff addNewPrintPostScriptOverText();

    CTOnOff addNewPrintTwoOnOne();

    CTProof addNewProofState();

    CTReadingModeInkLockDown addNewReadModeInkLockDown();

    CTOnOff addNewRemoveDateAndTime();

    CTOnOff addNewRemovePersonalInformation();

    CTTrackChangesView addNewRevisionView();

    CTDocRsids addNewRsids();

    CTOnOff addNewSaveFormsData();

    CTOnOff addNewSaveInvalidXml();

    CTOnOff addNewSavePreviewPicture();

    CTOnOff addNewSaveSubsetFonts();

    CTSaveThroughXslt addNewSaveThroughXslt();

    CTOnOff addNewSaveXmlDataOnly();

    CTSchemaLibrary addNewSchemaLibrary();

    CTShapeDefaults addNewShapeDefaults();

    CTOnOff addNewShowEnvelope();

    CTOnOff addNewShowXMLTags();

    CTSmartTagType addNewSmartTagType();

    CTOnOff addNewStrictFirstAndLastChars();

    CTOnOff addNewStyleLockQFSet();

    CTOnOff addNewStyleLockTheme();

    CTShortHexNumber addNewStylePaneFormatFilter();

    CTShortHexNumber addNewStylePaneSortMethod();

    CTDecimalNumber addNewSummaryLength();

    CTLanguage addNewThemeFontLang();

    CTOnOff addNewTrackRevisions();

    CTOnOff addNewUiCompat97To2003();

    CTOnOff addNewUpdateFields();

    CTOnOff addNewUseXSLTWhenSaving();

    CTView addNewView();

    CTWriteProtection addNewWriteProtection();

    CTZoom addNewZoom();

    CTWritingStyle getActiveWritingStyleArray(int i);

    CTWritingStyle[] getActiveWritingStyleArray();

    List<CTWritingStyle> getActiveWritingStyleList();

    CTOnOff getAlignBordersAndEdges();

    CTOnOff getAlwaysMergeEmptyNamespace();

    CTOnOff getAlwaysShowPlaceholderText();

    CTString getAttachedSchemaArray(int i);

    CTString[] getAttachedSchemaArray();

    List<CTString> getAttachedSchemaList();

    CTRel getAttachedTemplate();

    CTOnOff getAutoFormatOverride();

    CTOnOff getAutoHyphenation();

    CTOnOff getBookFoldPrinting();

    CTDecimalNumber getBookFoldPrintingSheets();

    CTOnOff getBookFoldRevPrinting();

    CTOnOff getBordersDoNotSurroundFooter();

    CTOnOff getBordersDoNotSurroundHeader();

    CTCaptions getCaptions();

    CTCharacterSpacing getCharacterSpacingControl();

    CTString getClickAndTypeStyle();

    CTColorSchemeMapping getClrSchemeMapping();

    CTCompat getCompat();

    CTDecimalNumber getConsecutiveHyphenLimit();

    CTString getDecimalSymbol();

    CTTwipsMeasure getDefaultTabStop();

    CTString getDefaultTableStyle();

    CTOnOff getDisplayBackgroundShape();

    CTDecimalNumber getDisplayHorizontalDrawingGridEvery();

    CTDecimalNumber getDisplayVerticalDrawingGridEvery();

    CTOnOff getDoNotAutoCompressPictures();

    CTOnOff getDoNotDemarcateInvalidXml();

    CTOnOff getDoNotDisplayPageBoundaries();

    CTOnOff getDoNotEmbedSmartTags();

    CTOnOff getDoNotHyphenateCaps();

    CTOnOff getDoNotIncludeSubdocsInStats();

    CTOnOff getDoNotShadeFormData();

    CTOnOff getDoNotTrackFormatting();

    CTOnOff getDoNotTrackMoves();

    CTOnOff getDoNotUseMarginsForDrawingGridOrigin();

    CTOnOff getDoNotValidateAgainstSchema();

    CTDocVars getDocVars();

    CTDocProtect getDocumentProtection();

    CTDocType getDocumentType();

    CTTwipsMeasure getDrawingGridHorizontalOrigin();

    CTTwipsMeasure getDrawingGridHorizontalSpacing();

    CTTwipsMeasure getDrawingGridVerticalOrigin();

    CTTwipsMeasure getDrawingGridVerticalSpacing();

    CTOnOff getEmbedSystemFonts();

    CTOnOff getEmbedTrueTypeFonts();

    CTEdnDocProps getEndnotePr();

    CTOnOff getEvenAndOddHeaders();

    CTFtnDocProps getFootnotePr();

    CTEmpty getForceUpgrade();

    CTOnOff getFormsDesign();

    CTOnOff getGutterAtTop();

    CTShapeDefaults getHdrShapeDefaults();

    CTOnOff getHideGrammaticalErrors();

    CTOnOff getHideSpellingErrors();

    CTTwipsMeasure getHyphenationZone();

    CTOnOff getIgnoreMixedContent();

    CTOnOff getLinkStyles();

    CTString getListSeparator();

    CTMailMerge getMailMerge();

    CTMathPr getMathPr();

    CTOnOff getMirrorMargins();

    CTKinsoku getNoLineBreaksAfter();

    CTKinsoku getNoLineBreaksBefore();

    CTOnOff getNoPunctuationKerning();

    CTOnOff getPrintFormsData();

    CTOnOff getPrintFractionalCharacterWidth();

    CTOnOff getPrintPostScriptOverText();

    CTOnOff getPrintTwoOnOne();

    CTProof getProofState();

    CTReadingModeInkLockDown getReadModeInkLockDown();

    CTOnOff getRemoveDateAndTime();

    CTOnOff getRemovePersonalInformation();

    CTTrackChangesView getRevisionView();

    CTDocRsids getRsids();

    CTOnOff getSaveFormsData();

    CTOnOff getSaveInvalidXml();

    CTOnOff getSavePreviewPicture();

    CTOnOff getSaveSubsetFonts();

    CTSaveThroughXslt getSaveThroughXslt();

    CTOnOff getSaveXmlDataOnly();

    CTSchemaLibrary getSchemaLibrary();

    CTShapeDefaults getShapeDefaults();

    CTOnOff getShowEnvelope();

    CTOnOff getShowXMLTags();

    CTSmartTagType getSmartTagTypeArray(int i);

    CTSmartTagType[] getSmartTagTypeArray();

    List<CTSmartTagType> getSmartTagTypeList();

    CTOnOff getStrictFirstAndLastChars();

    CTOnOff getStyleLockQFSet();

    CTOnOff getStyleLockTheme();

    CTShortHexNumber getStylePaneFormatFilter();

    CTShortHexNumber getStylePaneSortMethod();

    CTDecimalNumber getSummaryLength();

    CTLanguage getThemeFontLang();

    CTOnOff getTrackRevisions();

    CTOnOff getUiCompat97To2003();

    CTOnOff getUpdateFields();

    CTOnOff getUseXSLTWhenSaving();

    CTView getView();

    CTWriteProtection getWriteProtection();

    CTZoom getZoom();

    CTWritingStyle insertNewActiveWritingStyle(int i);

    CTString insertNewAttachedSchema(int i);

    CTSmartTagType insertNewSmartTagType(int i);

    boolean isSetAlignBordersAndEdges();

    boolean isSetAlwaysMergeEmptyNamespace();

    boolean isSetAlwaysShowPlaceholderText();

    boolean isSetAttachedTemplate();

    boolean isSetAutoFormatOverride();

    boolean isSetAutoHyphenation();

    boolean isSetBookFoldPrinting();

    boolean isSetBookFoldPrintingSheets();

    boolean isSetBookFoldRevPrinting();

    boolean isSetBordersDoNotSurroundFooter();

    boolean isSetBordersDoNotSurroundHeader();

    boolean isSetCaptions();

    boolean isSetCharacterSpacingControl();

    boolean isSetClickAndTypeStyle();

    boolean isSetClrSchemeMapping();

    boolean isSetCompat();

    boolean isSetConsecutiveHyphenLimit();

    boolean isSetDecimalSymbol();

    boolean isSetDefaultTabStop();

    boolean isSetDefaultTableStyle();

    boolean isSetDisplayBackgroundShape();

    boolean isSetDisplayHorizontalDrawingGridEvery();

    boolean isSetDisplayVerticalDrawingGridEvery();

    boolean isSetDoNotAutoCompressPictures();

    boolean isSetDoNotDemarcateInvalidXml();

    boolean isSetDoNotDisplayPageBoundaries();

    boolean isSetDoNotEmbedSmartTags();

    boolean isSetDoNotHyphenateCaps();

    boolean isSetDoNotIncludeSubdocsInStats();

    boolean isSetDoNotShadeFormData();

    boolean isSetDoNotTrackFormatting();

    boolean isSetDoNotTrackMoves();

    boolean isSetDoNotUseMarginsForDrawingGridOrigin();

    boolean isSetDoNotValidateAgainstSchema();

    boolean isSetDocVars();

    boolean isSetDocumentProtection();

    boolean isSetDocumentType();

    boolean isSetDrawingGridHorizontalOrigin();

    boolean isSetDrawingGridHorizontalSpacing();

    boolean isSetDrawingGridVerticalOrigin();

    boolean isSetDrawingGridVerticalSpacing();

    boolean isSetEmbedSystemFonts();

    boolean isSetEmbedTrueTypeFonts();

    boolean isSetEndnotePr();

    boolean isSetEvenAndOddHeaders();

    boolean isSetFootnotePr();

    boolean isSetForceUpgrade();

    boolean isSetFormsDesign();

    boolean isSetGutterAtTop();

    boolean isSetHdrShapeDefaults();

    boolean isSetHideGrammaticalErrors();

    boolean isSetHideSpellingErrors();

    boolean isSetHyphenationZone();

    boolean isSetIgnoreMixedContent();

    boolean isSetLinkStyles();

    boolean isSetListSeparator();

    boolean isSetMailMerge();

    boolean isSetMathPr();

    boolean isSetMirrorMargins();

    boolean isSetNoLineBreaksAfter();

    boolean isSetNoLineBreaksBefore();

    boolean isSetNoPunctuationKerning();

    boolean isSetPrintFormsData();

    boolean isSetPrintFractionalCharacterWidth();

    boolean isSetPrintPostScriptOverText();

    boolean isSetPrintTwoOnOne();

    boolean isSetProofState();

    boolean isSetReadModeInkLockDown();

    boolean isSetRemoveDateAndTime();

    boolean isSetRemovePersonalInformation();

    boolean isSetRevisionView();

    boolean isSetRsids();

    boolean isSetSaveFormsData();

    boolean isSetSaveInvalidXml();

    boolean isSetSavePreviewPicture();

    boolean isSetSaveSubsetFonts();

    boolean isSetSaveThroughXslt();

    boolean isSetSaveXmlDataOnly();

    boolean isSetSchemaLibrary();

    boolean isSetShapeDefaults();

    boolean isSetShowEnvelope();

    boolean isSetShowXMLTags();

    boolean isSetStrictFirstAndLastChars();

    boolean isSetStyleLockQFSet();

    boolean isSetStyleLockTheme();

    boolean isSetStylePaneFormatFilter();

    boolean isSetStylePaneSortMethod();

    boolean isSetSummaryLength();

    boolean isSetThemeFontLang();

    boolean isSetTrackRevisions();

    boolean isSetUiCompat97To2003();

    boolean isSetUpdateFields();

    boolean isSetUseXSLTWhenSaving();

    boolean isSetView();

    boolean isSetWriteProtection();

    boolean isSetZoom();

    void removeActiveWritingStyle(int i);

    void removeAttachedSchema(int i);

    void removeSmartTagType(int i);

    void setActiveWritingStyleArray(int i, CTWritingStyle cTWritingStyle);

    void setActiveWritingStyleArray(CTWritingStyle[] cTWritingStyleArr);

    void setAlignBordersAndEdges(CTOnOff cTOnOff);

    void setAlwaysMergeEmptyNamespace(CTOnOff cTOnOff);

    void setAlwaysShowPlaceholderText(CTOnOff cTOnOff);

    void setAttachedSchemaArray(int i, CTString cTString);

    void setAttachedSchemaArray(CTString[] cTStringArr);

    void setAttachedTemplate(CTRel cTRel);

    void setAutoFormatOverride(CTOnOff cTOnOff);

    void setAutoHyphenation(CTOnOff cTOnOff);

    void setBookFoldPrinting(CTOnOff cTOnOff);

    void setBookFoldPrintingSheets(CTDecimalNumber cTDecimalNumber);

    void setBookFoldRevPrinting(CTOnOff cTOnOff);

    void setBordersDoNotSurroundFooter(CTOnOff cTOnOff);

    void setBordersDoNotSurroundHeader(CTOnOff cTOnOff);

    void setCaptions(CTCaptions cTCaptions);

    void setCharacterSpacingControl(CTCharacterSpacing cTCharacterSpacing);

    void setClickAndTypeStyle(CTString cTString);

    void setClrSchemeMapping(CTColorSchemeMapping cTColorSchemeMapping);

    void setCompat(CTCompat cTCompat);

    void setConsecutiveHyphenLimit(CTDecimalNumber cTDecimalNumber);

    void setDecimalSymbol(CTString cTString);

    void setDefaultTabStop(CTTwipsMeasure cTTwipsMeasure);

    void setDefaultTableStyle(CTString cTString);

    void setDisplayBackgroundShape(CTOnOff cTOnOff);

    void setDisplayHorizontalDrawingGridEvery(CTDecimalNumber cTDecimalNumber);

    void setDisplayVerticalDrawingGridEvery(CTDecimalNumber cTDecimalNumber);

    void setDoNotAutoCompressPictures(CTOnOff cTOnOff);

    void setDoNotDemarcateInvalidXml(CTOnOff cTOnOff);

    void setDoNotDisplayPageBoundaries(CTOnOff cTOnOff);

    void setDoNotEmbedSmartTags(CTOnOff cTOnOff);

    void setDoNotHyphenateCaps(CTOnOff cTOnOff);

    void setDoNotIncludeSubdocsInStats(CTOnOff cTOnOff);

    void setDoNotShadeFormData(CTOnOff cTOnOff);

    void setDoNotTrackFormatting(CTOnOff cTOnOff);

    void setDoNotTrackMoves(CTOnOff cTOnOff);

    void setDoNotUseMarginsForDrawingGridOrigin(CTOnOff cTOnOff);

    void setDoNotValidateAgainstSchema(CTOnOff cTOnOff);

    void setDocVars(CTDocVars cTDocVars);

    void setDocumentProtection(CTDocProtect cTDocProtect);

    void setDocumentType(CTDocType cTDocType);

    void setDrawingGridHorizontalOrigin(CTTwipsMeasure cTTwipsMeasure);

    void setDrawingGridHorizontalSpacing(CTTwipsMeasure cTTwipsMeasure);

    void setDrawingGridVerticalOrigin(CTTwipsMeasure cTTwipsMeasure);

    void setDrawingGridVerticalSpacing(CTTwipsMeasure cTTwipsMeasure);

    void setEmbedSystemFonts(CTOnOff cTOnOff);

    void setEmbedTrueTypeFonts(CTOnOff cTOnOff);

    void setEndnotePr(CTEdnDocProps cTEdnDocProps);

    void setEvenAndOddHeaders(CTOnOff cTOnOff);

    void setFootnotePr(CTFtnDocProps cTFtnDocProps);

    void setForceUpgrade(CTEmpty cTEmpty);

    void setFormsDesign(CTOnOff cTOnOff);

    void setGutterAtTop(CTOnOff cTOnOff);

    void setHdrShapeDefaults(CTShapeDefaults cTShapeDefaults);

    void setHideGrammaticalErrors(CTOnOff cTOnOff);

    void setHideSpellingErrors(CTOnOff cTOnOff);

    void setHyphenationZone(CTTwipsMeasure cTTwipsMeasure);

    void setIgnoreMixedContent(CTOnOff cTOnOff);

    void setLinkStyles(CTOnOff cTOnOff);

    void setListSeparator(CTString cTString);

    void setMailMerge(CTMailMerge cTMailMerge);

    void setMathPr(CTMathPr cTMathPr);

    void setMirrorMargins(CTOnOff cTOnOff);

    void setNoLineBreaksAfter(CTKinsoku cTKinsoku);

    void setNoLineBreaksBefore(CTKinsoku cTKinsoku);

    void setNoPunctuationKerning(CTOnOff cTOnOff);

    void setPrintFormsData(CTOnOff cTOnOff);

    void setPrintFractionalCharacterWidth(CTOnOff cTOnOff);

    void setPrintPostScriptOverText(CTOnOff cTOnOff);

    void setPrintTwoOnOne(CTOnOff cTOnOff);

    void setProofState(CTProof cTProof);

    void setReadModeInkLockDown(CTReadingModeInkLockDown cTReadingModeInkLockDown);

    void setRemoveDateAndTime(CTOnOff cTOnOff);

    void setRemovePersonalInformation(CTOnOff cTOnOff);

    void setRevisionView(CTTrackChangesView cTTrackChangesView);

    void setRsids(CTDocRsids cTDocRsids);

    void setSaveFormsData(CTOnOff cTOnOff);

    void setSaveInvalidXml(CTOnOff cTOnOff);

    void setSavePreviewPicture(CTOnOff cTOnOff);

    void setSaveSubsetFonts(CTOnOff cTOnOff);

    void setSaveThroughXslt(CTSaveThroughXslt cTSaveThroughXslt);

    void setSaveXmlDataOnly(CTOnOff cTOnOff);

    void setSchemaLibrary(CTSchemaLibrary cTSchemaLibrary);

    void setShapeDefaults(CTShapeDefaults cTShapeDefaults);

    void setShowEnvelope(CTOnOff cTOnOff);

    void setShowXMLTags(CTOnOff cTOnOff);

    void setSmartTagTypeArray(int i, CTSmartTagType cTSmartTagType);

    void setSmartTagTypeArray(CTSmartTagType[] cTSmartTagTypeArr);

    void setStrictFirstAndLastChars(CTOnOff cTOnOff);

    void setStyleLockQFSet(CTOnOff cTOnOff);

    void setStyleLockTheme(CTOnOff cTOnOff);

    void setStylePaneFormatFilter(CTShortHexNumber cTShortHexNumber);

    void setStylePaneSortMethod(CTShortHexNumber cTShortHexNumber);

    void setSummaryLength(CTDecimalNumber cTDecimalNumber);

    void setThemeFontLang(CTLanguage cTLanguage);

    void setTrackRevisions(CTOnOff cTOnOff);

    void setUiCompat97To2003(CTOnOff cTOnOff);

    void setUpdateFields(CTOnOff cTOnOff);

    void setUseXSLTWhenSaving(CTOnOff cTOnOff);

    void setView(CTView cTView);

    void setWriteProtection(CTWriteProtection cTWriteProtection);

    void setZoom(CTZoom cTZoom);

    int sizeOfActiveWritingStyleArray();

    int sizeOfAttachedSchemaArray();

    int sizeOfSmartTagTypeArray();

    void unsetAlignBordersAndEdges();

    void unsetAlwaysMergeEmptyNamespace();

    void unsetAlwaysShowPlaceholderText();

    void unsetAttachedTemplate();

    void unsetAutoFormatOverride();

    void unsetAutoHyphenation();

    void unsetBookFoldPrinting();

    void unsetBookFoldPrintingSheets();

    void unsetBookFoldRevPrinting();

    void unsetBordersDoNotSurroundFooter();

    void unsetBordersDoNotSurroundHeader();

    void unsetCaptions();

    void unsetCharacterSpacingControl();

    void unsetClickAndTypeStyle();

    void unsetClrSchemeMapping();

    void unsetCompat();

    void unsetConsecutiveHyphenLimit();

    void unsetDecimalSymbol();

    void unsetDefaultTabStop();

    void unsetDefaultTableStyle();

    void unsetDisplayBackgroundShape();

    void unsetDisplayHorizontalDrawingGridEvery();

    void unsetDisplayVerticalDrawingGridEvery();

    void unsetDoNotAutoCompressPictures();

    void unsetDoNotDemarcateInvalidXml();

    void unsetDoNotDisplayPageBoundaries();

    void unsetDoNotEmbedSmartTags();

    void unsetDoNotHyphenateCaps();

    void unsetDoNotIncludeSubdocsInStats();

    void unsetDoNotShadeFormData();

    void unsetDoNotTrackFormatting();

    void unsetDoNotTrackMoves();

    void unsetDoNotUseMarginsForDrawingGridOrigin();

    void unsetDoNotValidateAgainstSchema();

    void unsetDocVars();

    void unsetDocumentProtection();

    void unsetDocumentType();

    void unsetDrawingGridHorizontalOrigin();

    void unsetDrawingGridHorizontalSpacing();

    void unsetDrawingGridVerticalOrigin();

    void unsetDrawingGridVerticalSpacing();

    void unsetEmbedSystemFonts();

    void unsetEmbedTrueTypeFonts();

    void unsetEndnotePr();

    void unsetEvenAndOddHeaders();

    void unsetFootnotePr();

    void unsetForceUpgrade();

    void unsetFormsDesign();

    void unsetGutterAtTop();

    void unsetHdrShapeDefaults();

    void unsetHideGrammaticalErrors();

    void unsetHideSpellingErrors();

    void unsetHyphenationZone();

    void unsetIgnoreMixedContent();

    void unsetLinkStyles();

    void unsetListSeparator();

    void unsetMailMerge();

    void unsetMathPr();

    void unsetMirrorMargins();

    void unsetNoLineBreaksAfter();

    void unsetNoLineBreaksBefore();

    void unsetNoPunctuationKerning();

    void unsetPrintFormsData();

    void unsetPrintFractionalCharacterWidth();

    void unsetPrintPostScriptOverText();

    void unsetPrintTwoOnOne();

    void unsetProofState();

    void unsetReadModeInkLockDown();

    void unsetRemoveDateAndTime();

    void unsetRemovePersonalInformation();

    void unsetRevisionView();

    void unsetRsids();

    void unsetSaveFormsData();

    void unsetSaveInvalidXml();

    void unsetSavePreviewPicture();

    void unsetSaveSubsetFonts();

    void unsetSaveThroughXslt();

    void unsetSaveXmlDataOnly();

    void unsetSchemaLibrary();

    void unsetShapeDefaults();

    void unsetShowEnvelope();

    void unsetShowXMLTags();

    void unsetStrictFirstAndLastChars();

    void unsetStyleLockQFSet();

    void unsetStyleLockTheme();

    void unsetStylePaneFormatFilter();

    void unsetStylePaneSortMethod();

    void unsetSummaryLength();

    void unsetThemeFontLang();

    void unsetTrackRevisions();

    void unsetUiCompat97To2003();

    void unsetUpdateFields();

    void unsetUseXSLTWhenSaving();

    void unsetView();

    void unsetWriteProtection();

    void unsetZoom();
}
