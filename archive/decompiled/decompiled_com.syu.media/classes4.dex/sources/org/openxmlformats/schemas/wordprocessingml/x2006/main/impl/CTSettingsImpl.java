package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMathPr;
import org.openxmlformats.schemas.schemaLibrary.x2006.main.CTSchemaLibrary;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCaptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCharacterSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColorSchemeMapping;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCompat;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocRsids;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocVars;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEdnDocProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnDocProps;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTKinsoku;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMailMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProof;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTReadingModeInkLockDown;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSaveThroughXslt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShapeDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangesView;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTView;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTWriteProtection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTWritingStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSettingsImpl extends XmlComplexContentImpl implements CTSettings {
    private static final QName WRITEPROTECTION$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "writeProtection");
    private static final QName VIEW$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "view");
    private static final QName ZOOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "zoom");
    private static final QName REMOVEPERSONALINFORMATION$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "removePersonalInformation");
    private static final QName REMOVEDATEANDTIME$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "removeDateAndTime");
    private static final QName DONOTDISPLAYPAGEBOUNDARIES$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotDisplayPageBoundaries");
    private static final QName DISPLAYBACKGROUNDSHAPE$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displayBackgroundShape");
    private static final QName PRINTPOSTSCRIPTOVERTEXT$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printPostScriptOverText");
    private static final QName PRINTFRACTIONALCHARACTERWIDTH$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printFractionalCharacterWidth");
    private static final QName PRINTFORMSDATA$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printFormsData");
    private static final QName EMBEDTRUETYPEFONTS$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "embedTrueTypeFonts");
    private static final QName EMBEDSYSTEMFONTS$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "embedSystemFonts");
    private static final QName SAVESUBSETFONTS$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveSubsetFonts");
    private static final QName SAVEFORMSDATA$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveFormsData");
    private static final QName MIRRORMARGINS$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mirrorMargins");
    private static final QName ALIGNBORDERSANDEDGES$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alignBordersAndEdges");
    private static final QName BORDERSDONOTSURROUNDHEADER$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bordersDoNotSurroundHeader");
    private static final QName BORDERSDONOTSURROUNDFOOTER$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bordersDoNotSurroundFooter");
    private static final QName GUTTERATTOP$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gutterAtTop");
    private static final QName HIDESPELLINGERRORS$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideSpellingErrors");
    private static final QName HIDEGRAMMATICALERRORS$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideGrammaticalErrors");
    private static final QName ACTIVEWRITINGSTYLE$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "activeWritingStyle");
    private static final QName PROOFSTATE$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofState");
    private static final QName FORMSDESIGN$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formsDesign");
    private static final QName ATTACHEDTEMPLATE$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attachedTemplate");
    private static final QName LINKSTYLES$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "linkStyles");
    private static final QName STYLEPANEFORMATFILTER$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "stylePaneFormatFilter");
    private static final QName STYLEPANESORTMETHOD$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "stylePaneSortMethod");
    private static final QName DOCUMENTTYPE$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "documentType");
    private static final QName MAILMERGE$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mailMerge");
    private static final QName REVISIONVIEW$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "revisionView");
    private static final QName TRACKREVISIONS$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trackRevisions");
    private static final QName DONOTTRACKMOVES$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotTrackMoves");
    private static final QName DONOTTRACKFORMATTING$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotTrackFormatting");
    private static final QName DOCUMENTPROTECTION$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "documentProtection");
    private static final QName AUTOFORMATOVERRIDE$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoFormatOverride");
    private static final QName STYLELOCKTHEME$72 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLockTheme");
    private static final QName STYLELOCKQFSET$74 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLockQFSet");
    private static final QName DEFAULTTABSTOP$76 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defaultTabStop");
    private static final QName AUTOHYPHENATION$78 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoHyphenation");
    private static final QName CONSECUTIVEHYPHENLIMIT$80 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "consecutiveHyphenLimit");
    private static final QName HYPHENATIONZONE$82 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hyphenationZone");
    private static final QName DONOTHYPHENATECAPS$84 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotHyphenateCaps");
    private static final QName SHOWENVELOPE$86 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showEnvelope");
    private static final QName SUMMARYLENGTH$88 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "summaryLength");
    private static final QName CLICKANDTYPESTYLE$90 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clickAndTypeStyle");
    private static final QName DEFAULTTABLESTYLE$92 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defaultTableStyle");
    private static final QName EVENANDODDHEADERS$94 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "evenAndOddHeaders");
    private static final QName BOOKFOLDREVPRINTING$96 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookFoldRevPrinting");
    private static final QName BOOKFOLDPRINTING$98 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookFoldPrinting");
    private static final QName BOOKFOLDPRINTINGSHEETS$100 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookFoldPrintingSheets");
    private static final QName DRAWINGGRIDHORIZONTALSPACING$102 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridHorizontalSpacing");
    private static final QName DRAWINGGRIDVERTICALSPACING$104 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridVerticalSpacing");
    private static final QName DISPLAYHORIZONTALDRAWINGGRIDEVERY$106 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displayHorizontalDrawingGridEvery");
    private static final QName DISPLAYVERTICALDRAWINGGRIDEVERY$108 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displayVerticalDrawingGridEvery");
    private static final QName DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotUseMarginsForDrawingGridOrigin");
    private static final QName DRAWINGGRIDHORIZONTALORIGIN$112 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridHorizontalOrigin");
    private static final QName DRAWINGGRIDVERTICALORIGIN$114 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawingGridVerticalOrigin");
    private static final QName DONOTSHADEFORMDATA$116 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotShadeFormData");
    private static final QName NOPUNCTUATIONKERNING$118 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noPunctuationKerning");
    private static final QName CHARACTERSPACINGCONTROL$120 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "characterSpacingControl");
    private static final QName PRINTTWOONONE$122 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "printTwoOnOne");
    private static final QName STRICTFIRSTANDLASTCHARS$124 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strictFirstAndLastChars");
    private static final QName NOLINEBREAKSAFTER$126 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noLineBreaksAfter");
    private static final QName NOLINEBREAKSBEFORE$128 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noLineBreaksBefore");
    private static final QName SAVEPREVIEWPICTURE$130 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "savePreviewPicture");
    private static final QName DONOTVALIDATEAGAINSTSCHEMA$132 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotValidateAgainstSchema");
    private static final QName SAVEINVALIDXML$134 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveInvalidXml");
    private static final QName IGNOREMIXEDCONTENT$136 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ignoreMixedContent");
    private static final QName ALWAYSSHOWPLACEHOLDERTEXT$138 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alwaysShowPlaceholderText");
    private static final QName DONOTDEMARCATEINVALIDXML$140 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotDemarcateInvalidXml");
    private static final QName SAVEXMLDATAONLY$142 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveXmlDataOnly");
    private static final QName USEXSLTWHENSAVING$144 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "useXSLTWhenSaving");
    private static final QName SAVETHROUGHXSLT$146 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "saveThroughXslt");
    private static final QName SHOWXMLTAGS$148 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "showXMLTags");
    private static final QName ALWAYSMERGEEMPTYNAMESPACE$150 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alwaysMergeEmptyNamespace");
    private static final QName UPDATEFIELDS$152 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "updateFields");
    private static final QName HDRSHAPEDEFAULTS$154 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hdrShapeDefaults");
    private static final QName FOOTNOTEPR$156 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnotePr");
    private static final QName ENDNOTEPR$158 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotePr");
    private static final QName COMPAT$160 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "compat");
    private static final QName DOCVARS$162 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docVars");
    private static final QName RSIDS$164 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsids");
    private static final QName MATHPR$166 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mathPr");
    private static final QName UICOMPAT97TO2003$168 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiCompat97To2003");
    private static final QName ATTACHEDSCHEMA$170 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attachedSchema");
    private static final QName THEMEFONTLANG$172 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeFontLang");
    private static final QName CLRSCHEMEMAPPING$174 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clrSchemeMapping");
    private static final QName DONOTINCLUDESUBDOCSINSTATS$176 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotIncludeSubdocsInStats");
    private static final QName DONOTAUTOCOMPRESSPICTURES$178 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotAutoCompressPictures");
    private static final QName FORCEUPGRADE$180 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "forceUpgrade");
    private static final QName CAPTIONS$182 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "captions");
    private static final QName READMODEINKLOCKDOWN$184 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "readModeInkLockDown");
    private static final QName SMARTTAGTYPE$186 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTagType");
    private static final QName SCHEMALIBRARY$188 = new QName("http://schemas.openxmlformats.org/schemaLibrary/2006/main", "schemaLibrary");
    private static final QName SHAPEDEFAULTS$190 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shapeDefaults");
    private static final QName DONOTEMBEDSMARTTAGS$192 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "doNotEmbedSmartTags");
    private static final QName DECIMALSYMBOL$194 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "decimalSymbol");
    private static final QName LISTSEPARATOR$196 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "listSeparator");

    public CTSettingsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle addNewActiveWritingStyle() {
        CTWritingStyle cTWritingStyleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWritingStyleAdd_element_user = get_store().add_element_user(ACTIVEWRITINGSTYLE$42);
        }
        return cTWritingStyleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAlignBordersAndEdges() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ALIGNBORDERSANDEDGES$30);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAlwaysMergeEmptyNamespace() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ALWAYSMERGEEMPTYNAMESPACE$150);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAlwaysShowPlaceholderText() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ALWAYSSHOWPLACEHOLDERTEXT$138);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewAttachedSchema() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(ATTACHEDSCHEMA$170);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTRel addNewAttachedTemplate() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(ATTACHEDTEMPLATE$48);
        }
        return cTRelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAutoFormatOverride() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(AUTOFORMATOVERRIDE$70);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewAutoHyphenation() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(AUTOHYPHENATION$78);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBookFoldPrinting() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BOOKFOLDPRINTING$98);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewBookFoldPrintingSheets() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(BOOKFOLDPRINTINGSHEETS$100);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBookFoldRevPrinting() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BOOKFOLDREVPRINTING$96);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBordersDoNotSurroundFooter() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BORDERSDONOTSURROUNDFOOTER$34);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewBordersDoNotSurroundHeader() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BORDERSDONOTSURROUNDHEADER$32);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCaptions addNewCaptions() {
        CTCaptions cTCaptionsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCaptionsAdd_element_user = get_store().add_element_user(CAPTIONS$182);
        }
        return cTCaptionsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCharacterSpacing addNewCharacterSpacingControl() {
        CTCharacterSpacing cTCharacterSpacingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCharacterSpacingAdd_element_user = get_store().add_element_user(CHARACTERSPACINGCONTROL$120);
        }
        return cTCharacterSpacingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewClickAndTypeStyle() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(CLICKANDTYPESTYLE$90);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTColorSchemeMapping addNewClrSchemeMapping() {
        CTColorSchemeMapping cTColorSchemeMappingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorSchemeMappingAdd_element_user = get_store().add_element_user(CLRSCHEMEMAPPING$174);
        }
        return cTColorSchemeMappingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCompat addNewCompat() {
        CTCompat cTCompatAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCompatAdd_element_user = get_store().add_element_user(COMPAT$160);
        }
        return cTCompatAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewConsecutiveHyphenLimit() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(CONSECUTIVEHYPHENLIMIT$80);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewDecimalSymbol() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(DECIMALSYMBOL$194);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDefaultTabStop() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(DEFAULTTABSTOP$76);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewDefaultTableStyle() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(DEFAULTTABLESTYLE$92);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDisplayBackgroundShape() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DISPLAYBACKGROUNDSHAPE$12);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewDisplayHorizontalDrawingGridEvery() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewDisplayVerticalDrawingGridEvery() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(DISPLAYVERTICALDRAWINGGRIDEVERY$108);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotAutoCompressPictures() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTAUTOCOMPRESSPICTURES$178);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotDemarcateInvalidXml() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTDEMARCATEINVALIDXML$140);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotDisplayPageBoundaries() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTDISPLAYPAGEBOUNDARIES$10);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotEmbedSmartTags() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTEMBEDSMARTTAGS$192);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotHyphenateCaps() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTHYPHENATECAPS$84);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotIncludeSubdocsInStats() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTINCLUDESUBDOCSINSTATS$176);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotShadeFormData() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTSHADEFORMDATA$116);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotTrackFormatting() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTTRACKFORMATTING$66);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotTrackMoves() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTTRACKMOVES$64);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotUseMarginsForDrawingGridOrigin() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewDoNotValidateAgainstSchema() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DONOTVALIDATEAGAINSTSCHEMA$132);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocVars addNewDocVars() {
        CTDocVars cTDocVarsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocVarsAdd_element_user = get_store().add_element_user(DOCVARS$162);
        }
        return cTDocVarsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocProtect addNewDocumentProtection() {
        CTDocProtect cTDocProtectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocProtectAdd_element_user = get_store().add_element_user(DOCUMENTPROTECTION$68);
        }
        return cTDocProtectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocType addNewDocumentType() {
        CTDocType cTDocTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocTypeAdd_element_user = get_store().add_element_user(DOCUMENTTYPE$56);
        }
        return cTDocTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridHorizontalOrigin() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(DRAWINGGRIDHORIZONTALORIGIN$112);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridHorizontalSpacing() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(DRAWINGGRIDHORIZONTALSPACING$102);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridVerticalOrigin() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(DRAWINGGRIDVERTICALORIGIN$114);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewDrawingGridVerticalSpacing() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(DRAWINGGRIDVERTICALSPACING$104);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewEmbedSystemFonts() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(EMBEDSYSTEMFONTS$22);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewEmbedTrueTypeFonts() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(EMBEDTRUETYPEFONTS$20);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEdnDocProps addNewEndnotePr() {
        CTEdnDocProps cTEdnDocPropsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEdnDocPropsAdd_element_user = get_store().add_element_user(ENDNOTEPR$158);
        }
        return cTEdnDocPropsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewEvenAndOddHeaders() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(EVENANDODDHEADERS$94);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTFtnDocProps addNewFootnotePr() {
        CTFtnDocProps cTFtnDocPropsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnDocPropsAdd_element_user = get_store().add_element_user(FOOTNOTEPR$156);
        }
        return cTFtnDocPropsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEmpty addNewForceUpgrade() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(FORCEUPGRADE$180);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewFormsDesign() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(FORMSDESIGN$46);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewGutterAtTop() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(GUTTERATTOP$36);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults addNewHdrShapeDefaults() {
        CTShapeDefaults cTShapeDefaultsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeDefaultsAdd_element_user = get_store().add_element_user(HDRSHAPEDEFAULTS$154);
        }
        return cTShapeDefaultsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewHideGrammaticalErrors() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(HIDEGRAMMATICALERRORS$40);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewHideSpellingErrors() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(HIDESPELLINGERRORS$38);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure addNewHyphenationZone() {
        CTTwipsMeasure cTTwipsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTwipsMeasureAdd_element_user = get_store().add_element_user(HYPHENATIONZONE$82);
        }
        return cTTwipsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewIgnoreMixedContent() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(IGNOREMIXEDCONTENT$136);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewLinkStyles() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(LINKSTYLES$50);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString addNewListSeparator() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(LISTSEPARATOR$196);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMailMerge addNewMailMerge() {
        CTMailMerge cTMailMergeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMailMergeAdd_element_user = get_store().add_element_user(MAILMERGE$58);
        }
        return cTMailMergeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMathPr addNewMathPr() {
        CTMathPr cTMathPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMathPrAdd_element_user = get_store().add_element_user(MATHPR$166);
        }
        return cTMathPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewMirrorMargins() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(MIRRORMARGINS$28);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku addNewNoLineBreaksAfter() {
        CTKinsoku cTKinsokuAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuAdd_element_user = get_store().add_element_user(NOLINEBREAKSAFTER$126);
        }
        return cTKinsokuAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku addNewNoLineBreaksBefore() {
        CTKinsoku cTKinsokuAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuAdd_element_user = get_store().add_element_user(NOLINEBREAKSBEFORE$128);
        }
        return cTKinsokuAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewNoPunctuationKerning() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(NOPUNCTUATIONKERNING$118);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintFormsData() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(PRINTFORMSDATA$18);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintFractionalCharacterWidth() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(PRINTFRACTIONALCHARACTERWIDTH$16);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintPostScriptOverText() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(PRINTPOSTSCRIPTOVERTEXT$14);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewPrintTwoOnOne() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(PRINTTWOONONE$122);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTProof addNewProofState() {
        CTProof cTProofAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofAdd_element_user = get_store().add_element_user(PROOFSTATE$44);
        }
        return cTProofAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTReadingModeInkLockDown addNewReadModeInkLockDown() {
        CTReadingModeInkLockDown cTReadingModeInkLockDownAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReadingModeInkLockDownAdd_element_user = get_store().add_element_user(READMODEINKLOCKDOWN$184);
        }
        return cTReadingModeInkLockDownAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewRemoveDateAndTime() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(REMOVEDATEANDTIME$8);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewRemovePersonalInformation() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(REMOVEPERSONALINFORMATION$6);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTrackChangesView addNewRevisionView() {
        CTTrackChangesView cTTrackChangesViewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangesViewAdd_element_user = get_store().add_element_user(REVISIONVIEW$60);
        }
        return cTTrackChangesViewAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocRsids addNewRsids() {
        CTDocRsids cTDocRsidsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocRsidsAdd_element_user = get_store().add_element_user(RSIDS$164);
        }
        return cTDocRsidsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveFormsData() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SAVEFORMSDATA$26);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveInvalidXml() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SAVEINVALIDXML$134);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSavePreviewPicture() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SAVEPREVIEWPICTURE$130);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveSubsetFonts() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SAVESUBSETFONTS$24);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSaveThroughXslt addNewSaveThroughXslt() {
        CTSaveThroughXslt cTSaveThroughXsltAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSaveThroughXsltAdd_element_user = get_store().add_element_user(SAVETHROUGHXSLT$146);
        }
        return cTSaveThroughXsltAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewSaveXmlDataOnly() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SAVEXMLDATAONLY$142);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSchemaLibrary addNewSchemaLibrary() {
        CTSchemaLibrary cTSchemaLibraryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemaLibraryAdd_element_user = get_store().add_element_user(SCHEMALIBRARY$188);
        }
        return cTSchemaLibraryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults addNewShapeDefaults() {
        CTShapeDefaults cTShapeDefaultsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeDefaultsAdd_element_user = get_store().add_element_user(SHAPEDEFAULTS$190);
        }
        return cTShapeDefaultsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewShowEnvelope() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SHOWENVELOPE$86);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewShowXMLTags() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SHOWXMLTAGS$148);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType addNewSmartTagType() {
        CTSmartTagType cTSmartTagTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypeAdd_element_user = get_store().add_element_user(SMARTTAGTYPE$186);
        }
        return cTSmartTagTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewStrictFirstAndLastChars() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(STRICTFIRSTANDLASTCHARS$124);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewStyleLockQFSet() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(STYLELOCKQFSET$74);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewStyleLockTheme() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(STYLELOCKTHEME$72);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShortHexNumber addNewStylePaneFormatFilter() {
        CTShortHexNumber cTShortHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShortHexNumberAdd_element_user = get_store().add_element_user(STYLEPANEFORMATFILTER$52);
        }
        return cTShortHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShortHexNumber addNewStylePaneSortMethod() {
        CTShortHexNumber cTShortHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShortHexNumberAdd_element_user = get_store().add_element_user(STYLEPANESORTMETHOD$54);
        }
        return cTShortHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber addNewSummaryLength() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(SUMMARYLENGTH$88);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTLanguage addNewThemeFontLang() {
        CTLanguage cTLanguageAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguageAdd_element_user = get_store().add_element_user(THEMEFONTLANG$172);
        }
        return cTLanguageAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewTrackRevisions() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(TRACKREVISIONS$62);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewUiCompat97To2003() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(UICOMPAT97TO2003$168);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewUpdateFields() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(UPDATEFIELDS$152);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff addNewUseXSLTWhenSaving() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(USEXSLTWHENSAVING$144);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTView addNewView() {
        CTView cTViewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTViewAdd_element_user = get_store().add_element_user(VIEW$2);
        }
        return cTViewAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWriteProtection addNewWriteProtection() {
        CTWriteProtection cTWriteProtectionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWriteProtectionAdd_element_user = get_store().add_element_user(WRITEPROTECTION$0);
        }
        return cTWriteProtectionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTZoom addNewZoom() {
        CTZoom cTZoomAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTZoomAdd_element_user = get_store().add_element_user(ZOOM$4);
        }
        return cTZoomAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle getActiveWritingStyleArray(int i) {
        CTWritingStyle cTWritingStyleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWritingStyleFind_element_user = get_store().find_element_user(ACTIVEWRITINGSTYLE$42, i);
            if (cTWritingStyleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTWritingStyleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle[] getActiveWritingStyleArray() {
        CTWritingStyle[] cTWritingStyleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACTIVEWRITINGSTYLE$42, arrayList);
            cTWritingStyleArr = new CTWritingStyle[arrayList.size()];
            arrayList.toArray(cTWritingStyleArr);
        }
        return cTWritingStyleArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public List<CTWritingStyle> getActiveWritingStyleList() {
        1ActiveWritingStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ActiveWritingStyleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAlignBordersAndEdges() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ALIGNBORDERSANDEDGES$30, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAlwaysMergeEmptyNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ALWAYSMERGEEMPTYNAMESPACE$150, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAlwaysShowPlaceholderText() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ALWAYSSHOWPLACEHOLDERTEXT$138, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getAttachedSchemaArray(int i) {
        CTString cTStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringFind_element_user = get_store().find_element_user(ATTACHEDSCHEMA$170, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString[] getAttachedSchemaArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTACHEDSCHEMA$170, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public List<CTString> getAttachedSchemaList() {
        1AttachedSchemaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttachedSchemaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTRel getAttachedTemplate() {
        synchronized (monitor()) {
            check_orphaned();
            CTRel cTRelFind_element_user = get_store().find_element_user(ATTACHEDTEMPLATE$48, 0);
            if (cTRelFind_element_user == null) {
                return null;
            }
            return cTRelFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAutoFormatOverride() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(AUTOFORMATOVERRIDE$70, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getAutoHyphenation() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(AUTOHYPHENATION$78, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBookFoldPrinting() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BOOKFOLDPRINTING$98, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getBookFoldPrintingSheets() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(BOOKFOLDPRINTINGSHEETS$100, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBookFoldRevPrinting() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BOOKFOLDREVPRINTING$96, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBordersDoNotSurroundFooter() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BORDERSDONOTSURROUNDFOOTER$34, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getBordersDoNotSurroundHeader() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BORDERSDONOTSURROUNDHEADER$32, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCaptions getCaptions() {
        synchronized (monitor()) {
            check_orphaned();
            CTCaptions cTCaptionsFind_element_user = get_store().find_element_user(CAPTIONS$182, 0);
            if (cTCaptionsFind_element_user == null) {
                return null;
            }
            return cTCaptionsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCharacterSpacing getCharacterSpacingControl() {
        synchronized (monitor()) {
            check_orphaned();
            CTCharacterSpacing cTCharacterSpacingFind_element_user = get_store().find_element_user(CHARACTERSPACINGCONTROL$120, 0);
            if (cTCharacterSpacingFind_element_user == null) {
                return null;
            }
            return cTCharacterSpacingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getClickAndTypeStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(CLICKANDTYPESTYLE$90, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTColorSchemeMapping getClrSchemeMapping() {
        synchronized (monitor()) {
            check_orphaned();
            CTColorSchemeMapping cTColorSchemeMappingFind_element_user = get_store().find_element_user(CLRSCHEMEMAPPING$174, 0);
            if (cTColorSchemeMappingFind_element_user == null) {
                return null;
            }
            return cTColorSchemeMappingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTCompat getCompat() {
        synchronized (monitor()) {
            check_orphaned();
            CTCompat cTCompatFind_element_user = get_store().find_element_user(COMPAT$160, 0);
            if (cTCompatFind_element_user == null) {
                return null;
            }
            return cTCompatFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getConsecutiveHyphenLimit() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(CONSECUTIVEHYPHENLIMIT$80, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getDecimalSymbol() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(DECIMALSYMBOL$194, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDefaultTabStop() {
        synchronized (monitor()) {
            check_orphaned();
            CTTwipsMeasure cTTwipsMeasureFind_element_user = get_store().find_element_user(DEFAULTTABSTOP$76, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getDefaultTableStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(DEFAULTTABLESTYLE$92, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDisplayBackgroundShape() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DISPLAYBACKGROUNDSHAPE$12, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getDisplayHorizontalDrawingGridEvery() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getDisplayVerticalDrawingGridEvery() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(DISPLAYVERTICALDRAWINGGRIDEVERY$108, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotAutoCompressPictures() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTAUTOCOMPRESSPICTURES$178, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotDemarcateInvalidXml() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTDEMARCATEINVALIDXML$140, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotDisplayPageBoundaries() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTDISPLAYPAGEBOUNDARIES$10, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotEmbedSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTEMBEDSMARTTAGS$192, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotHyphenateCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTHYPHENATECAPS$84, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotIncludeSubdocsInStats() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTINCLUDESUBDOCSINSTATS$176, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotShadeFormData() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTSHADEFORMDATA$116, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotTrackFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTTRACKFORMATTING$66, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotTrackMoves() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTTRACKMOVES$64, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotUseMarginsForDrawingGridOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getDoNotValidateAgainstSchema() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DONOTVALIDATEAGAINSTSCHEMA$132, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocVars getDocVars() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocVars cTDocVarsFind_element_user = get_store().find_element_user(DOCVARS$162, 0);
            if (cTDocVarsFind_element_user == null) {
                return null;
            }
            return cTDocVarsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocProtect getDocumentProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocProtect cTDocProtectFind_element_user = get_store().find_element_user(DOCUMENTPROTECTION$68, 0);
            if (cTDocProtectFind_element_user == null) {
                return null;
            }
            return cTDocProtectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocType getDocumentType() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocType cTDocTypeFind_element_user = get_store().find_element_user(DOCUMENTTYPE$56, 0);
            if (cTDocTypeFind_element_user == null) {
                return null;
            }
            return cTDocTypeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridHorizontalOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            CTTwipsMeasure cTTwipsMeasureFind_element_user = get_store().find_element_user(DRAWINGGRIDHORIZONTALORIGIN$112, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridHorizontalSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTTwipsMeasure cTTwipsMeasureFind_element_user = get_store().find_element_user(DRAWINGGRIDHORIZONTALSPACING$102, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridVerticalOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            CTTwipsMeasure cTTwipsMeasureFind_element_user = get_store().find_element_user(DRAWINGGRIDVERTICALORIGIN$114, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getDrawingGridVerticalSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTTwipsMeasure cTTwipsMeasureFind_element_user = get_store().find_element_user(DRAWINGGRIDVERTICALSPACING$104, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getEmbedSystemFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(EMBEDSYSTEMFONTS$22, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getEmbedTrueTypeFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(EMBEDTRUETYPEFONTS$20, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEdnDocProps getEndnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTEdnDocProps cTEdnDocPropsFind_element_user = get_store().find_element_user(ENDNOTEPR$158, 0);
            if (cTEdnDocPropsFind_element_user == null) {
                return null;
            }
            return cTEdnDocPropsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getEvenAndOddHeaders() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(EVENANDODDHEADERS$94, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTFtnDocProps getFootnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTFtnDocProps cTFtnDocPropsFind_element_user = get_store().find_element_user(FOOTNOTEPR$156, 0);
            if (cTFtnDocPropsFind_element_user == null) {
                return null;
            }
            return cTFtnDocPropsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTEmpty getForceUpgrade() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty cTEmptyFind_element_user = get_store().find_element_user(FORCEUPGRADE$180, 0);
            if (cTEmptyFind_element_user == null) {
                return null;
            }
            return cTEmptyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getFormsDesign() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(FORMSDESIGN$46, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getGutterAtTop() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(GUTTERATTOP$36, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults getHdrShapeDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeDefaults cTShapeDefaultsFind_element_user = get_store().find_element_user(HDRSHAPEDEFAULTS$154, 0);
            if (cTShapeDefaultsFind_element_user == null) {
                return null;
            }
            return cTShapeDefaultsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getHideGrammaticalErrors() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(HIDEGRAMMATICALERRORS$40, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getHideSpellingErrors() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(HIDESPELLINGERRORS$38, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTwipsMeasure getHyphenationZone() {
        synchronized (monitor()) {
            check_orphaned();
            CTTwipsMeasure cTTwipsMeasureFind_element_user = get_store().find_element_user(HYPHENATIONZONE$82, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                return null;
            }
            return cTTwipsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getIgnoreMixedContent() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(IGNOREMIXEDCONTENT$136, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getLinkStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(LINKSTYLES$50, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString getListSeparator() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(LISTSEPARATOR$196, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMailMerge getMailMerge() {
        synchronized (monitor()) {
            check_orphaned();
            CTMailMerge cTMailMergeFind_element_user = get_store().find_element_user(MAILMERGE$58, 0);
            if (cTMailMergeFind_element_user == null) {
                return null;
            }
            return cTMailMergeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTMathPr getMathPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTMathPr cTMathPrFind_element_user = get_store().find_element_user(MATHPR$166, 0);
            if (cTMathPrFind_element_user == null) {
                return null;
            }
            return cTMathPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getMirrorMargins() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(MIRRORMARGINS$28, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku getNoLineBreaksAfter() {
        synchronized (monitor()) {
            check_orphaned();
            CTKinsoku cTKinsokuFind_element_user = get_store().find_element_user(NOLINEBREAKSAFTER$126, 0);
            if (cTKinsokuFind_element_user == null) {
                return null;
            }
            return cTKinsokuFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTKinsoku getNoLineBreaksBefore() {
        synchronized (monitor()) {
            check_orphaned();
            CTKinsoku cTKinsokuFind_element_user = get_store().find_element_user(NOLINEBREAKSBEFORE$128, 0);
            if (cTKinsokuFind_element_user == null) {
                return null;
            }
            return cTKinsokuFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getNoPunctuationKerning() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(NOPUNCTUATIONKERNING$118, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintFormsData() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(PRINTFORMSDATA$18, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintFractionalCharacterWidth() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(PRINTFRACTIONALCHARACTERWIDTH$16, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintPostScriptOverText() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(PRINTPOSTSCRIPTOVERTEXT$14, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getPrintTwoOnOne() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(PRINTTWOONONE$122, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTProof getProofState() {
        synchronized (monitor()) {
            check_orphaned();
            CTProof cTProofFind_element_user = get_store().find_element_user(PROOFSTATE$44, 0);
            if (cTProofFind_element_user == null) {
                return null;
            }
            return cTProofFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTReadingModeInkLockDown getReadModeInkLockDown() {
        synchronized (monitor()) {
            check_orphaned();
            CTReadingModeInkLockDown cTReadingModeInkLockDownFind_element_user = get_store().find_element_user(READMODEINKLOCKDOWN$184, 0);
            if (cTReadingModeInkLockDownFind_element_user == null) {
                return null;
            }
            return cTReadingModeInkLockDownFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getRemoveDateAndTime() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(REMOVEDATEANDTIME$8, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getRemovePersonalInformation() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(REMOVEPERSONALINFORMATION$6, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTTrackChangesView getRevisionView() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChangesView cTTrackChangesViewFind_element_user = get_store().find_element_user(REVISIONVIEW$60, 0);
            if (cTTrackChangesViewFind_element_user == null) {
                return null;
            }
            return cTTrackChangesViewFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDocRsids getRsids() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocRsids cTDocRsidsFind_element_user = get_store().find_element_user(RSIDS$164, 0);
            if (cTDocRsidsFind_element_user == null) {
                return null;
            }
            return cTDocRsidsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveFormsData() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SAVEFORMSDATA$26, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveInvalidXml() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SAVEINVALIDXML$134, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSavePreviewPicture() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SAVEPREVIEWPICTURE$130, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveSubsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SAVESUBSETFONTS$24, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSaveThroughXslt getSaveThroughXslt() {
        synchronized (monitor()) {
            check_orphaned();
            CTSaveThroughXslt cTSaveThroughXsltFind_element_user = get_store().find_element_user(SAVETHROUGHXSLT$146, 0);
            if (cTSaveThroughXsltFind_element_user == null) {
                return null;
            }
            return cTSaveThroughXsltFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getSaveXmlDataOnly() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SAVEXMLDATAONLY$142, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSchemaLibrary getSchemaLibrary() {
        synchronized (monitor()) {
            check_orphaned();
            CTSchemaLibrary cTSchemaLibraryFind_element_user = get_store().find_element_user(SCHEMALIBRARY$188, 0);
            if (cTSchemaLibraryFind_element_user == null) {
                return null;
            }
            return cTSchemaLibraryFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShapeDefaults getShapeDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeDefaults cTShapeDefaultsFind_element_user = get_store().find_element_user(SHAPEDEFAULTS$190, 0);
            if (cTShapeDefaultsFind_element_user == null) {
                return null;
            }
            return cTShapeDefaultsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getShowEnvelope() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SHOWENVELOPE$86, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getShowXMLTags() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SHOWXMLTAGS$148, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType getSmartTagTypeArray(int i) {
        CTSmartTagType cTSmartTagTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypeFind_element_user = get_store().find_element_user(SMARTTAGTYPE$186, i);
            if (cTSmartTagTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSmartTagTypeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType[] getSmartTagTypeArray() {
        CTSmartTagType[] cTSmartTagTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SMARTTAGTYPE$186, arrayList);
            cTSmartTagTypeArr = new CTSmartTagType[arrayList.size()];
            arrayList.toArray(cTSmartTagTypeArr);
        }
        return cTSmartTagTypeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public List<CTSmartTagType> getSmartTagTypeList() {
        1SmartTagTypeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SmartTagTypeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getStrictFirstAndLastChars() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(STRICTFIRSTANDLASTCHARS$124, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getStyleLockQFSet() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(STYLELOCKQFSET$74, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getStyleLockTheme() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(STYLELOCKTHEME$72, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShortHexNumber getStylePaneFormatFilter() {
        synchronized (monitor()) {
            check_orphaned();
            CTShortHexNumber cTShortHexNumberFind_element_user = get_store().find_element_user(STYLEPANEFORMATFILTER$52, 0);
            if (cTShortHexNumberFind_element_user == null) {
                return null;
            }
            return cTShortHexNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTShortHexNumber getStylePaneSortMethod() {
        synchronized (monitor()) {
            check_orphaned();
            CTShortHexNumber cTShortHexNumberFind_element_user = get_store().find_element_user(STYLEPANESORTMETHOD$54, 0);
            if (cTShortHexNumberFind_element_user == null) {
                return null;
            }
            return cTShortHexNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTDecimalNumber getSummaryLength() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(SUMMARYLENGTH$88, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTLanguage getThemeFontLang() {
        synchronized (monitor()) {
            check_orphaned();
            CTLanguage cTLanguageFind_element_user = get_store().find_element_user(THEMEFONTLANG$172, 0);
            if (cTLanguageFind_element_user == null) {
                return null;
            }
            return cTLanguageFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getTrackRevisions() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(TRACKREVISIONS$62, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getUiCompat97To2003() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(UICOMPAT97TO2003$168, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getUpdateFields() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(UPDATEFIELDS$152, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTOnOff getUseXSLTWhenSaving() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(USEXSLTWHENSAVING$144, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTView getView() {
        synchronized (monitor()) {
            check_orphaned();
            CTView cTViewFind_element_user = get_store().find_element_user(VIEW$2, 0);
            if (cTViewFind_element_user == null) {
                return null;
            }
            return cTViewFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWriteProtection getWriteProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTWriteProtection cTWriteProtectionFind_element_user = get_store().find_element_user(WRITEPROTECTION$0, 0);
            if (cTWriteProtectionFind_element_user == null) {
                return null;
            }
            return cTWriteProtectionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTZoom getZoom() {
        synchronized (monitor()) {
            check_orphaned();
            CTZoom cTZoomFind_element_user = get_store().find_element_user(ZOOM$4, 0);
            if (cTZoomFind_element_user == null) {
                return null;
            }
            return cTZoomFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTWritingStyle insertNewActiveWritingStyle(int i) {
        CTWritingStyle cTWritingStyleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWritingStyleInsert_element_user = get_store().insert_element_user(ACTIVEWRITINGSTYLE$42, i);
        }
        return cTWritingStyleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTString insertNewAttachedSchema(int i) {
        CTString cTStringInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringInsert_element_user = get_store().insert_element_user(ATTACHEDSCHEMA$170, i);
        }
        return cTStringInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public CTSmartTagType insertNewSmartTagType(int i) {
        CTSmartTagType cTSmartTagTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypeInsert_element_user = get_store().insert_element_user(SMARTTAGTYPE$186, i);
        }
        return cTSmartTagTypeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAlignBordersAndEdges() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALIGNBORDERSANDEDGES$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAlwaysMergeEmptyNamespace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALWAYSMERGEEMPTYNAMESPACE$150) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAlwaysShowPlaceholderText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALWAYSSHOWPLACEHOLDERTEXT$138) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAttachedTemplate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ATTACHEDTEMPLATE$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAutoFormatOverride() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOFORMATOVERRIDE$70) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetAutoHyphenation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOHYPHENATION$78) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBookFoldPrinting() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOKFOLDPRINTING$98) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBookFoldPrintingSheets() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOKFOLDPRINTINGSHEETS$100) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBookFoldRevPrinting() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOKFOLDREVPRINTING$96) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBordersDoNotSurroundFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BORDERSDONOTSURROUNDFOOTER$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetBordersDoNotSurroundHeader() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BORDERSDONOTSURROUNDHEADER$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetCaptions() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CAPTIONS$182) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetCharacterSpacingControl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHARACTERSPACINGCONTROL$120) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetClickAndTypeStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLICKANDTYPESTYLE$90) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetClrSchemeMapping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLRSCHEMEMAPPING$174) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetCompat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPAT$160) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetConsecutiveHyphenLimit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONSECUTIVEHYPHENLIMIT$80) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDecimalSymbol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DECIMALSYMBOL$194) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDefaultTabStop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFAULTTABSTOP$76) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDefaultTableStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFAULTTABLESTYLE$92) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDisplayBackgroundShape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DISPLAYBACKGROUNDSHAPE$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDisplayHorizontalDrawingGridEvery() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDisplayVerticalDrawingGridEvery() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DISPLAYVERTICALDRAWINGGRIDEVERY$108) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotAutoCompressPictures() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTAUTOCOMPRESSPICTURES$178) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotDemarcateInvalidXml() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTDEMARCATEINVALIDXML$140) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotDisplayPageBoundaries() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTDISPLAYPAGEBOUNDARIES$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotEmbedSmartTags() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTEMBEDSMARTTAGS$192) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotHyphenateCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTHYPHENATECAPS$84) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotIncludeSubdocsInStats() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTINCLUDESUBDOCSINSTATS$176) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotShadeFormData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTSHADEFORMDATA$116) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotTrackFormatting() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTTRACKFORMATTING$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotTrackMoves() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTTRACKMOVES$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotUseMarginsForDrawingGridOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDoNotValidateAgainstSchema() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DONOTVALIDATEAGAINSTSCHEMA$132) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDocVars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCVARS$162) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDocumentProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCUMENTPROTECTION$68) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDocumentType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCUMENTTYPE$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridHorizontalOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DRAWINGGRIDHORIZONTALORIGIN$112) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridHorizontalSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DRAWINGGRIDHORIZONTALSPACING$102) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridVerticalOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DRAWINGGRIDVERTICALORIGIN$114) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetDrawingGridVerticalSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DRAWINGGRIDVERTICALSPACING$104) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEmbedSystemFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMBEDSYSTEMFONTS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEmbedTrueTypeFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMBEDTRUETYPEFONTS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEndnotePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENDNOTEPR$158) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetEvenAndOddHeaders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EVENANDODDHEADERS$94) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetFootnotePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FOOTNOTEPR$156) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetForceUpgrade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FORCEUPGRADE$180) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetFormsDesign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FORMSDESIGN$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetGutterAtTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GUTTERATTOP$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHdrShapeDefaults() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HDRSHAPEDEFAULTS$154) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHideGrammaticalErrors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIDEGRAMMATICALERRORS$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHideSpellingErrors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIDESPELLINGERRORS$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetHyphenationZone() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HYPHENATIONZONE$82) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetIgnoreMixedContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IGNOREMIXEDCONTENT$136) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetLinkStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LINKSTYLES$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetListSeparator() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LISTSEPARATOR$196) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetMailMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAILMERGE$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetMathPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MATHPR$166) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetMirrorMargins() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MIRRORMARGINS$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetNoLineBreaksAfter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOLINEBREAKSAFTER$126) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetNoLineBreaksBefore() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOLINEBREAKSBEFORE$128) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetNoPunctuationKerning() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOPUNCTUATIONKERNING$118) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintFormsData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTFORMSDATA$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintFractionalCharacterWidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTFRACTIONALCHARACTERWIDTH$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintPostScriptOverText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTPOSTSCRIPTOVERTEXT$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetPrintTwoOnOne() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTTWOONONE$122) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetProofState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROOFSTATE$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetReadModeInkLockDown() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(READMODEINKLOCKDOWN$184) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRemoveDateAndTime() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(REMOVEDATEANDTIME$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRemovePersonalInformation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(REMOVEPERSONALINFORMATION$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRevisionView() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(REVISIONVIEW$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetRsids() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RSIDS$164) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveFormsData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SAVEFORMSDATA$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveInvalidXml() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SAVEINVALIDXML$134) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSavePreviewPicture() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SAVEPREVIEWPICTURE$130) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveSubsetFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SAVESUBSETFONTS$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveThroughXslt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SAVETHROUGHXSLT$146) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSaveXmlDataOnly() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SAVEXMLDATAONLY$142) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSchemaLibrary() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCHEMALIBRARY$188) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetShapeDefaults() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHAPEDEFAULTS$190) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetShowEnvelope() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHOWENVELOPE$86) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetShowXMLTags() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHOWXMLTAGS$148) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStrictFirstAndLastChars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRICTFIRSTANDLASTCHARS$124) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStyleLockQFSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLELOCKQFSET$74) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStyleLockTheme() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLELOCKTHEME$72) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStylePaneFormatFilter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLEPANEFORMATFILTER$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetStylePaneSortMethod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLEPANESORTMETHOD$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetSummaryLength() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUMMARYLENGTH$88) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetThemeFontLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(THEMEFONTLANG$172) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetTrackRevisions() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRACKREVISIONS$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetUiCompat97To2003() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UICOMPAT97TO2003$168) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetUpdateFields() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UPDATEFIELDS$152) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetUseXSLTWhenSaving() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(USEXSLTWHENSAVING$144) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetView() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VIEW$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetWriteProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WRITEPROTECTION$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public boolean isSetZoom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ZOOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void removeActiveWritingStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACTIVEWRITINGSTYLE$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void removeAttachedSchema(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTACHEDSCHEMA$170, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void removeSmartTagType(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAGTYPE$186, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setActiveWritingStyleArray(int i, CTWritingStyle cTWritingStyle) {
        synchronized (monitor()) {
            check_orphaned();
            CTWritingStyle cTWritingStyleFind_element_user = get_store().find_element_user(ACTIVEWRITINGSTYLE$42, i);
            if (cTWritingStyleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTWritingStyleFind_element_user.set(cTWritingStyle);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setActiveWritingStyleArray(CTWritingStyle[] cTWritingStyleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTWritingStyleArr, ACTIVEWRITINGSTYLE$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAlignBordersAndEdges(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNBORDERSANDEDGES$30;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAlwaysMergeEmptyNamespace(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALWAYSMERGEEMPTYNAMESPACE$150;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAlwaysShowPlaceholderText(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALWAYSSHOWPLACEHOLDERTEXT$138;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAttachedSchemaArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(ATTACHEDSCHEMA$170, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAttachedSchemaArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStringArr, ATTACHEDSCHEMA$170);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAttachedTemplate(CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ATTACHEDTEMPLATE$48;
            CTRel cTRelFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRelFind_element_user == null) {
                cTRelFind_element_user = (CTRel) get_store().add_element_user(qName);
            }
            cTRelFind_element_user.set(cTRel);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAutoFormatOverride(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOFORMATOVERRIDE$70;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setAutoHyphenation(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOHYPHENATION$78;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBookFoldPrinting(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKFOLDPRINTING$98;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBookFoldPrintingSheets(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKFOLDPRINTINGSHEETS$100;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBookFoldRevPrinting(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKFOLDREVPRINTING$96;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBordersDoNotSurroundFooter(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERSDONOTSURROUNDFOOTER$34;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setBordersDoNotSurroundHeader(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERSDONOTSURROUNDHEADER$32;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setCaptions(CTCaptions cTCaptions) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAPTIONS$182;
            CTCaptions cTCaptionsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCaptionsFind_element_user == null) {
                cTCaptionsFind_element_user = (CTCaptions) get_store().add_element_user(qName);
            }
            cTCaptionsFind_element_user.set(cTCaptions);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setCharacterSpacingControl(CTCharacterSpacing cTCharacterSpacing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARACTERSPACINGCONTROL$120;
            CTCharacterSpacing cTCharacterSpacingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCharacterSpacingFind_element_user == null) {
                cTCharacterSpacingFind_element_user = (CTCharacterSpacing) get_store().add_element_user(qName);
            }
            cTCharacterSpacingFind_element_user.set(cTCharacterSpacing);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setClickAndTypeStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLICKANDTYPESTYLE$90;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setClrSchemeMapping(CTColorSchemeMapping cTColorSchemeMapping) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLRSCHEMEMAPPING$174;
            CTColorSchemeMapping cTColorSchemeMappingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTColorSchemeMappingFind_element_user == null) {
                cTColorSchemeMappingFind_element_user = (CTColorSchemeMapping) get_store().add_element_user(qName);
            }
            cTColorSchemeMappingFind_element_user.set(cTColorSchemeMapping);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setCompat(CTCompat cTCompat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPAT$160;
            CTCompat cTCompatFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCompatFind_element_user == null) {
                cTCompatFind_element_user = (CTCompat) get_store().add_element_user(qName);
            }
            cTCompatFind_element_user.set(cTCompat);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setConsecutiveHyphenLimit(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONSECUTIVEHYPHENLIMIT$80;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDecimalSymbol(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DECIMALSYMBOL$194;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDefaultTabStop(CTTwipsMeasure cTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTABSTOP$76;
            CTTwipsMeasure cTTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = (CTTwipsMeasure) get_store().add_element_user(qName);
            }
            cTTwipsMeasureFind_element_user.set(cTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDefaultTableStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTABLESTYLE$92;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDisplayBackgroundShape(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISPLAYBACKGROUNDSHAPE$12;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDisplayHorizontalDrawingGridEvery(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISPLAYHORIZONTALDRAWINGGRIDEVERY$106;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDisplayVerticalDrawingGridEvery(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISPLAYVERTICALDRAWINGGRIDEVERY$108;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotAutoCompressPictures(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTAUTOCOMPRESSPICTURES$178;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotDemarcateInvalidXml(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTDEMARCATEINVALIDXML$140;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotDisplayPageBoundaries(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTDISPLAYPAGEBOUNDARIES$10;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotEmbedSmartTags(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTEMBEDSMARTTAGS$192;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotHyphenateCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTHYPHENATECAPS$84;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotIncludeSubdocsInStats(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTINCLUDESUBDOCSINSTATS$176;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotShadeFormData(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTSHADEFORMDATA$116;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotTrackFormatting(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTTRACKFORMATTING$66;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotTrackMoves(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTTRACKMOVES$64;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotUseMarginsForDrawingGridOrigin(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDoNotValidateAgainstSchema(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DONOTVALIDATEAGAINSTSCHEMA$132;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDocVars(CTDocVars cTDocVars) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCVARS$162;
            CTDocVars cTDocVarsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDocVarsFind_element_user == null) {
                cTDocVarsFind_element_user = (CTDocVars) get_store().add_element_user(qName);
            }
            cTDocVarsFind_element_user.set(cTDocVars);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDocumentProtection(CTDocProtect cTDocProtect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCUMENTPROTECTION$68;
            CTDocProtect cTDocProtectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDocProtectFind_element_user == null) {
                cTDocProtectFind_element_user = (CTDocProtect) get_store().add_element_user(qName);
            }
            cTDocProtectFind_element_user.set(cTDocProtect);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDocumentType(CTDocType cTDocType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCUMENTTYPE$56;
            CTDocType cTDocTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDocTypeFind_element_user == null) {
                cTDocTypeFind_element_user = (CTDocType) get_store().add_element_user(qName);
            }
            cTDocTypeFind_element_user.set(cTDocType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridHorizontalOrigin(CTTwipsMeasure cTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWINGGRIDHORIZONTALORIGIN$112;
            CTTwipsMeasure cTTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = (CTTwipsMeasure) get_store().add_element_user(qName);
            }
            cTTwipsMeasureFind_element_user.set(cTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridHorizontalSpacing(CTTwipsMeasure cTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWINGGRIDHORIZONTALSPACING$102;
            CTTwipsMeasure cTTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = (CTTwipsMeasure) get_store().add_element_user(qName);
            }
            cTTwipsMeasureFind_element_user.set(cTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridVerticalOrigin(CTTwipsMeasure cTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWINGGRIDVERTICALORIGIN$114;
            CTTwipsMeasure cTTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = (CTTwipsMeasure) get_store().add_element_user(qName);
            }
            cTTwipsMeasureFind_element_user.set(cTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setDrawingGridVerticalSpacing(CTTwipsMeasure cTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWINGGRIDVERTICALSPACING$104;
            CTTwipsMeasure cTTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = (CTTwipsMeasure) get_store().add_element_user(qName);
            }
            cTTwipsMeasureFind_element_user.set(cTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEmbedSystemFonts(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDSYSTEMFONTS$22;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEmbedTrueTypeFonts(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDTRUETYPEFONTS$20;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEndnotePr(CTEdnDocProps cTEdnDocProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDNOTEPR$158;
            CTEdnDocProps cTEdnDocPropsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEdnDocPropsFind_element_user == null) {
                cTEdnDocPropsFind_element_user = (CTEdnDocProps) get_store().add_element_user(qName);
            }
            cTEdnDocPropsFind_element_user.set(cTEdnDocProps);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setEvenAndOddHeaders(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EVENANDODDHEADERS$94;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setFootnotePr(CTFtnDocProps cTFtnDocProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOOTNOTEPR$156;
            CTFtnDocProps cTFtnDocPropsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFtnDocPropsFind_element_user == null) {
                cTFtnDocPropsFind_element_user = (CTFtnDocProps) get_store().add_element_user(qName);
            }
            cTFtnDocPropsFind_element_user.set(cTFtnDocProps);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setForceUpgrade(CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEUPGRADE$180;
            CTEmpty cTEmptyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEmptyFind_element_user == null) {
                cTEmptyFind_element_user = (CTEmpty) get_store().add_element_user(qName);
            }
            cTEmptyFind_element_user.set(cTEmpty);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setFormsDesign(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMSDESIGN$46;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setGutterAtTop(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GUTTERATTOP$36;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHdrShapeDefaults(CTShapeDefaults cTShapeDefaults) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HDRSHAPEDEFAULTS$154;
            CTShapeDefaults cTShapeDefaultsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShapeDefaultsFind_element_user == null) {
                cTShapeDefaultsFind_element_user = (CTShapeDefaults) get_store().add_element_user(qName);
            }
            cTShapeDefaultsFind_element_user.set(cTShapeDefaults);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHideGrammaticalErrors(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDEGRAMMATICALERRORS$40;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHideSpellingErrors(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDESPELLINGERRORS$38;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setHyphenationZone(CTTwipsMeasure cTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HYPHENATIONZONE$82;
            CTTwipsMeasure cTTwipsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTwipsMeasureFind_element_user == null) {
                cTTwipsMeasureFind_element_user = (CTTwipsMeasure) get_store().add_element_user(qName);
            }
            cTTwipsMeasureFind_element_user.set(cTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setIgnoreMixedContent(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IGNOREMIXEDCONTENT$136;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setLinkStyles(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKSTYLES$50;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setListSeparator(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LISTSEPARATOR$196;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setMailMerge(CTMailMerge cTMailMerge) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAILMERGE$58;
            CTMailMerge cTMailMergeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMailMergeFind_element_user == null) {
                cTMailMergeFind_element_user = (CTMailMerge) get_store().add_element_user(qName);
            }
            cTMailMergeFind_element_user.set(cTMailMerge);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setMathPr(CTMathPr cTMathPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATHPR$166;
            CTMathPr cTMathPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMathPrFind_element_user == null) {
                cTMathPrFind_element_user = (CTMathPr) get_store().add_element_user(qName);
            }
            cTMathPrFind_element_user.set(cTMathPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setMirrorMargins(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIRRORMARGINS$28;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setNoLineBreaksAfter(CTKinsoku cTKinsoku) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOLINEBREAKSAFTER$126;
            CTKinsoku cTKinsokuFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTKinsokuFind_element_user == null) {
                cTKinsokuFind_element_user = (CTKinsoku) get_store().add_element_user(qName);
            }
            cTKinsokuFind_element_user.set(cTKinsoku);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setNoLineBreaksBefore(CTKinsoku cTKinsoku) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOLINEBREAKSBEFORE$128;
            CTKinsoku cTKinsokuFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTKinsokuFind_element_user == null) {
                cTKinsokuFind_element_user = (CTKinsoku) get_store().add_element_user(qName);
            }
            cTKinsokuFind_element_user.set(cTKinsoku);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setNoPunctuationKerning(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOPUNCTUATIONKERNING$118;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintFormsData(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTFORMSDATA$18;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintFractionalCharacterWidth(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTFRACTIONALCHARACTERWIDTH$16;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintPostScriptOverText(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTPOSTSCRIPTOVERTEXT$14;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setPrintTwoOnOne(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTTWOONONE$122;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setProofState(CTProof cTProof) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROOFSTATE$44;
            CTProof cTProofFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTProofFind_element_user == null) {
                cTProofFind_element_user = (CTProof) get_store().add_element_user(qName);
            }
            cTProofFind_element_user.set(cTProof);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setReadModeInkLockDown(CTReadingModeInkLockDown cTReadingModeInkLockDown) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = READMODEINKLOCKDOWN$184;
            CTReadingModeInkLockDown cTReadingModeInkLockDownFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTReadingModeInkLockDownFind_element_user == null) {
                cTReadingModeInkLockDownFind_element_user = (CTReadingModeInkLockDown) get_store().add_element_user(qName);
            }
            cTReadingModeInkLockDownFind_element_user.set(cTReadingModeInkLockDown);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRemoveDateAndTime(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REMOVEDATEANDTIME$8;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRemovePersonalInformation(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REMOVEPERSONALINFORMATION$6;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRevisionView(CTTrackChangesView cTTrackChangesView) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVISIONVIEW$60;
            CTTrackChangesView cTTrackChangesViewFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangesViewFind_element_user == null) {
                cTTrackChangesViewFind_element_user = (CTTrackChangesView) get_store().add_element_user(qName);
            }
            cTTrackChangesViewFind_element_user.set(cTTrackChangesView);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setRsids(CTDocRsids cTDocRsids) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSIDS$164;
            CTDocRsids cTDocRsidsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDocRsidsFind_element_user == null) {
                cTDocRsidsFind_element_user = (CTDocRsids) get_store().add_element_user(qName);
            }
            cTDocRsidsFind_element_user.set(cTDocRsids);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveFormsData(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEFORMSDATA$26;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveInvalidXml(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEINVALIDXML$134;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSavePreviewPicture(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEPREVIEWPICTURE$130;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveSubsetFonts(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVESUBSETFONTS$24;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveThroughXslt(CTSaveThroughXslt cTSaveThroughXslt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVETHROUGHXSLT$146;
            CTSaveThroughXslt cTSaveThroughXsltFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSaveThroughXsltFind_element_user == null) {
                cTSaveThroughXsltFind_element_user = (CTSaveThroughXslt) get_store().add_element_user(qName);
            }
            cTSaveThroughXsltFind_element_user.set(cTSaveThroughXslt);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSaveXmlDataOnly(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEXMLDATAONLY$142;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSchemaLibrary(CTSchemaLibrary cTSchemaLibrary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCHEMALIBRARY$188;
            CTSchemaLibrary cTSchemaLibraryFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSchemaLibraryFind_element_user == null) {
                cTSchemaLibraryFind_element_user = (CTSchemaLibrary) get_store().add_element_user(qName);
            }
            cTSchemaLibraryFind_element_user.set(cTSchemaLibrary);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setShapeDefaults(CTShapeDefaults cTShapeDefaults) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAPEDEFAULTS$190;
            CTShapeDefaults cTShapeDefaultsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShapeDefaultsFind_element_user == null) {
                cTShapeDefaultsFind_element_user = (CTShapeDefaults) get_store().add_element_user(qName);
            }
            cTShapeDefaultsFind_element_user.set(cTShapeDefaults);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setShowEnvelope(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWENVELOPE$86;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setShowXMLTags(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWXMLTAGS$148;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSmartTagTypeArray(int i, CTSmartTagType cTSmartTagType) {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagType cTSmartTagTypeFind_element_user = get_store().find_element_user(SMARTTAGTYPE$186, i);
            if (cTSmartTagTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSmartTagTypeFind_element_user.set(cTSmartTagType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSmartTagTypeArray(CTSmartTagType[] cTSmartTagTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSmartTagTypeArr, SMARTTAGTYPE$186);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStrictFirstAndLastChars(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRICTFIRSTANDLASTCHARS$124;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStyleLockQFSet(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLELOCKQFSET$74;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStyleLockTheme(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLELOCKTHEME$72;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStylePaneFormatFilter(CTShortHexNumber cTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEPANEFORMATFILTER$52;
            CTShortHexNumber cTShortHexNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShortHexNumberFind_element_user == null) {
                cTShortHexNumberFind_element_user = (CTShortHexNumber) get_store().add_element_user(qName);
            }
            cTShortHexNumberFind_element_user.set(cTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setStylePaneSortMethod(CTShortHexNumber cTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEPANESORTMETHOD$54;
            CTShortHexNumber cTShortHexNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShortHexNumberFind_element_user == null) {
                cTShortHexNumberFind_element_user = (CTShortHexNumber) get_store().add_element_user(qName);
            }
            cTShortHexNumberFind_element_user.set(cTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setSummaryLength(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYLENGTH$88;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setThemeFontLang(CTLanguage cTLanguage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = THEMEFONTLANG$172;
            CTLanguage cTLanguageFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLanguageFind_element_user == null) {
                cTLanguageFind_element_user = (CTLanguage) get_store().add_element_user(qName);
            }
            cTLanguageFind_element_user.set(cTLanguage);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setTrackRevisions(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRACKREVISIONS$62;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setUiCompat97To2003(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UICOMPAT97TO2003$168;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setUpdateFields(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPDATEFIELDS$152;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setUseXSLTWhenSaving(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEXSLTWHENSAVING$144;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setView(CTView cTView) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEW$2;
            CTView cTViewFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTViewFind_element_user == null) {
                cTViewFind_element_user = (CTView) get_store().add_element_user(qName);
            }
            cTViewFind_element_user.set(cTView);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setWriteProtection(CTWriteProtection cTWriteProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRITEPROTECTION$0;
            CTWriteProtection cTWriteProtectionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWriteProtectionFind_element_user == null) {
                cTWriteProtectionFind_element_user = (CTWriteProtection) get_store().add_element_user(qName);
            }
            cTWriteProtectionFind_element_user.set(cTWriteProtection);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void setZoom(CTZoom cTZoom) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ZOOM$4;
            CTZoom cTZoomFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTZoomFind_element_user == null) {
                cTZoomFind_element_user = (CTZoom) get_store().add_element_user(qName);
            }
            cTZoomFind_element_user.set(cTZoom);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public int sizeOfActiveWritingStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ACTIVEWRITINGSTYLE$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public int sizeOfAttachedSchemaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTACHEDSCHEMA$170);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public int sizeOfSmartTagTypeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SMARTTAGTYPE$186);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAlignBordersAndEdges() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALIGNBORDERSANDEDGES$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAlwaysMergeEmptyNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALWAYSMERGEEMPTYNAMESPACE$150, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAlwaysShowPlaceholderText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALWAYSSHOWPLACEHOLDERTEXT$138, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAttachedTemplate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTACHEDTEMPLATE$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAutoFormatOverride() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOFORMATOVERRIDE$70, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetAutoHyphenation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOHYPHENATION$78, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBookFoldPrinting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKFOLDPRINTING$98, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBookFoldPrintingSheets() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKFOLDPRINTINGSHEETS$100, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBookFoldRevPrinting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKFOLDREVPRINTING$96, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBordersDoNotSurroundFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERSDONOTSURROUNDFOOTER$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetBordersDoNotSurroundHeader() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERSDONOTSURROUNDHEADER$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetCaptions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CAPTIONS$182, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetCharacterSpacingControl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHARACTERSPACINGCONTROL$120, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetClickAndTypeStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLICKANDTYPESTYLE$90, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetClrSchemeMapping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLRSCHEMEMAPPING$174, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetCompat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPAT$160, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetConsecutiveHyphenLimit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONSECUTIVEHYPHENLIMIT$80, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDecimalSymbol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DECIMALSYMBOL$194, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDefaultTabStop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULTTABSTOP$76, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDefaultTableStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULTTABLESTYLE$92, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDisplayBackgroundShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISPLAYBACKGROUNDSHAPE$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDisplayHorizontalDrawingGridEvery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISPLAYHORIZONTALDRAWINGGRIDEVERY$106, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDisplayVerticalDrawingGridEvery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISPLAYVERTICALDRAWINGGRIDEVERY$108, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotAutoCompressPictures() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTAUTOCOMPRESSPICTURES$178, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotDemarcateInvalidXml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTDEMARCATEINVALIDXML$140, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotDisplayPageBoundaries() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTDISPLAYPAGEBOUNDARIES$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotEmbedSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTEMBEDSMARTTAGS$192, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotHyphenateCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTHYPHENATECAPS$84, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotIncludeSubdocsInStats() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTINCLUDESUBDOCSINSTATS$176, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotShadeFormData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTSHADEFORMDATA$116, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotTrackFormatting() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTTRACKFORMATTING$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotTrackMoves() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTTRACKMOVES$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotUseMarginsForDrawingGridOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTUSEMARGINSFORDRAWINGGRIDORIGIN$110, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDoNotValidateAgainstSchema() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DONOTVALIDATEAGAINSTSCHEMA$132, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDocVars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCVARS$162, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDocumentProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCUMENTPROTECTION$68, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDocumentType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCUMENTTYPE$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridHorizontalOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWINGGRIDHORIZONTALORIGIN$112, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridHorizontalSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWINGGRIDHORIZONTALSPACING$102, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridVerticalOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWINGGRIDVERTICALORIGIN$114, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetDrawingGridVerticalSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWINGGRIDVERTICALSPACING$104, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEmbedSystemFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMBEDSYSTEMFONTS$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEmbedTrueTypeFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMBEDTRUETYPEFONTS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEndnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDNOTEPR$158, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetEvenAndOddHeaders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EVENANDODDHEADERS$94, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetFootnotePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FOOTNOTEPR$156, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetForceUpgrade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORCEUPGRADE$180, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetFormsDesign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMSDESIGN$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetGutterAtTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GUTTERATTOP$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHdrShapeDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HDRSHAPEDEFAULTS$154, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHideGrammaticalErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDEGRAMMATICALERRORS$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHideSpellingErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDESPELLINGERRORS$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetHyphenationZone() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPHENATIONZONE$82, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetIgnoreMixedContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IGNOREMIXEDCONTENT$136, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetLinkStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINKSTYLES$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetListSeparator() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LISTSEPARATOR$196, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetMailMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAILMERGE$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetMathPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MATHPR$166, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetMirrorMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MIRRORMARGINS$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetNoLineBreaksAfter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOLINEBREAKSAFTER$126, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetNoLineBreaksBefore() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOLINEBREAKSBEFORE$128, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetNoPunctuationKerning() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOPUNCTUATIONKERNING$118, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintFormsData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTFORMSDATA$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintFractionalCharacterWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTFRACTIONALCHARACTERWIDTH$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintPostScriptOverText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTPOSTSCRIPTOVERTEXT$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetPrintTwoOnOne() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTTWOONONE$122, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetProofState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFSTATE$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetReadModeInkLockDown() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(READMODEINKLOCKDOWN$184, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRemoveDateAndTime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REMOVEDATEANDTIME$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRemovePersonalInformation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REMOVEPERSONALINFORMATION$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRevisionView() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REVISIONVIEW$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetRsids() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RSIDS$164, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveFormsData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAVEFORMSDATA$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveInvalidXml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAVEINVALIDXML$134, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSavePreviewPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAVEPREVIEWPICTURE$130, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveSubsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAVESUBSETFONTS$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveThroughXslt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAVETHROUGHXSLT$146, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSaveXmlDataOnly() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAVEXMLDATAONLY$142, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSchemaLibrary() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEMALIBRARY$188, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetShapeDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAPEDEFAULTS$190, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetShowEnvelope() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHOWENVELOPE$86, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetShowXMLTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHOWXMLTAGS$148, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStrictFirstAndLastChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRICTFIRSTANDLASTCHARS$124, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStyleLockQFSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLELOCKQFSET$74, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStyleLockTheme() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLELOCKTHEME$72, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStylePaneFormatFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLEPANEFORMATFILTER$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetStylePaneSortMethod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLEPANESORTMETHOD$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetSummaryLength() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUMMARYLENGTH$88, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetThemeFontLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(THEMEFONTLANG$172, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetTrackRevisions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRACKREVISIONS$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetUiCompat97To2003() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UICOMPAT97TO2003$168, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetUpdateFields() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UPDATEFIELDS$152, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetUseXSLTWhenSaving() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(USEXSLTWHENSAVING$144, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetView() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VIEW$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetWriteProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRITEPROTECTION$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings
    public void unsetZoom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ZOOM$4, 0);
        }
    }
}
