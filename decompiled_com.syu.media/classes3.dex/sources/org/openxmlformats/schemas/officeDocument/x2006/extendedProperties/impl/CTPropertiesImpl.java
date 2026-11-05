package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorLpstr;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorVariant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPropertiesImpl extends XmlComplexContentImpl implements CTProperties {
    private static final QName TEMPLATE$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Template");
    private static final QName MANAGER$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Manager");
    private static final QName COMPANY$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Company");
    private static final QName PAGES$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Pages");
    private static final QName WORDS$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Words");
    private static final QName CHARACTERS$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Characters");
    private static final QName PRESENTATIONFORMAT$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "PresentationFormat");
    private static final QName LINES$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Lines");
    private static final QName PARAGRAPHS$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Paragraphs");
    private static final QName SLIDES$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Slides");
    private static final QName NOTES$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Notes");
    private static final QName TOTALTIME$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "TotalTime");
    private static final QName HIDDENSLIDES$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HiddenSlides");
    private static final QName MMCLIPS$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "MMClips");
    private static final QName SCALECROP$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "ScaleCrop");
    private static final QName HEADINGPAIRS$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HeadingPairs");
    private static final QName TITLESOFPARTS$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "TitlesOfParts");
    private static final QName LINKSUPTODATE$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "LinksUpToDate");
    private static final QName CHARACTERSWITHSPACES$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "CharactersWithSpaces");
    private static final QName SHAREDDOC$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "SharedDoc");
    private static final QName HYPERLINKBASE$40 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HyperlinkBase");
    private static final QName HLINKS$42 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HLinks");
    private static final QName HYPERLINKSCHANGED$44 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HyperlinksChanged");
    private static final QName DIGSIG$46 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "DigSig");
    private static final QName APPLICATION$48 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Application");
    private static final QName APPVERSION$50 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "AppVersion");
    private static final QName DOCSECURITY$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "DocSecurity");

    public CTPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTDigSigBlob addNewDigSig() {
        CTDigSigBlob cTDigSigBlob;
        synchronized (monitor()) {
            check_orphaned();
            cTDigSigBlob = (CTDigSigBlob) get_store().add_element_user(DIGSIG$46);
        }
        return cTDigSigBlob;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTVectorVariant addNewHLinks() {
        CTVectorVariant cTVectorVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVectorVariant = (CTVectorVariant) get_store().add_element_user(HLINKS$42);
        }
        return cTVectorVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTVectorVariant addNewHeadingPairs() {
        CTVectorVariant cTVectorVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVectorVariant = (CTVectorVariant) get_store().add_element_user(HEADINGPAIRS$30);
        }
        return cTVectorVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTVectorLpstr addNewTitlesOfParts() {
        CTVectorLpstr cTVectorLpstr;
        synchronized (monitor()) {
            check_orphaned();
            cTVectorLpstr = (CTVectorLpstr) get_store().add_element_user(TITLESOFPARTS$32);
        }
        return cTVectorLpstr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getAppVersion() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(APPVERSION$50, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getApplication() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(APPLICATION$48, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getCharacters() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(CHARACTERS$10, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getCharactersWithSpaces() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(CHARACTERSWITHSPACES$36, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getCompany() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(COMPANY$4, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTDigSigBlob getDigSig() {
        synchronized (monitor()) {
            check_orphaned();
            CTDigSigBlob cTDigSigBlob = (CTDigSigBlob) get_store().find_element_user(DIGSIG$46, 0);
            if (cTDigSigBlob == null) {
                return null;
            }
            return cTDigSigBlob;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getDocSecurity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DOCSECURITY$52, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTVectorVariant getHLinks() {
        synchronized (monitor()) {
            check_orphaned();
            CTVectorVariant cTVectorVariant = (CTVectorVariant) get_store().find_element_user(HLINKS$42, 0);
            if (cTVectorVariant == null) {
                return null;
            }
            return cTVectorVariant;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTVectorVariant getHeadingPairs() {
        synchronized (monitor()) {
            check_orphaned();
            CTVectorVariant cTVectorVariant = (CTVectorVariant) get_store().find_element_user(HEADINGPAIRS$30, 0);
            if (cTVectorVariant == null) {
                return null;
            }
            return cTVectorVariant;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getHiddenSlides() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(HIDDENSLIDES$24, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getHyperlinkBase() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(HYPERLINKBASE$40, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean getHyperlinksChanged() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(HYPERLINKSCHANGED$44, 0);
            if (simpleValueFind_element_user == null) {
                return false;
            }
            return simpleValueFind_element_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getLines() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(LINES$14, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean getLinksUpToDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(LINKSUPTODATE$34, 0);
            if (simpleValueFind_element_user == null) {
                return false;
            }
            return simpleValueFind_element_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getMMClips() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(MMCLIPS$26, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getManager() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(MANAGER$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getNotes() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(NOTES$20, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getPages() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(PAGES$6, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getParagraphs() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(PARAGRAPHS$16, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getPresentationFormat() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(PRESENTATIONFORMAT$12, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean getScaleCrop() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SCALECROP$28, 0);
            if (simpleValueFind_element_user == null) {
                return false;
            }
            return simpleValueFind_element_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean getSharedDoc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SHAREDDOC$38, 0);
            if (simpleValueFind_element_user == null) {
                return false;
            }
            return simpleValueFind_element_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getSlides() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SLIDES$18, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public String getTemplate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(TEMPLATE$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public CTVectorLpstr getTitlesOfParts() {
        synchronized (monitor()) {
            check_orphaned();
            CTVectorLpstr cTVectorLpstr = (CTVectorLpstr) get_store().find_element_user(TITLESOFPARTS$32, 0);
            if (cTVectorLpstr == null) {
                return null;
            }
            return cTVectorLpstr;
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getTotalTime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(TOTALTIME$22, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public int getWords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(WORDS$8, 0);
            if (simpleValueFind_element_user == null) {
                return 0;
            }
            return simpleValueFind_element_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetAppVersion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(APPVERSION$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetApplication() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(APPLICATION$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetCharacters() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHARACTERS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetCharactersWithSpaces() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHARACTERSWITHSPACES$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetCompany() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPANY$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetDigSig() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIGSIG$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetDocSecurity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCSECURITY$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetHLinks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HLINKS$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetHeadingPairs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADINGPAIRS$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetHiddenSlides() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIDDENSLIDES$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetHyperlinkBase() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HYPERLINKBASE$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetHyperlinksChanged() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HYPERLINKSCHANGED$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LINES$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetLinksUpToDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LINKSUPTODATE$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetMMClips() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MMCLIPS$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetManager() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MANAGER$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetNotes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOTES$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetPages() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGES$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetParagraphs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PARAGRAPHS$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetPresentationFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRESENTATIONFORMAT$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetScaleCrop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCALECROP$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetSharedDoc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHAREDDOC$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetSlides() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SLIDES$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetTemplate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEMPLATE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetTitlesOfParts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLESOFPARTS$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetTotalTime() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOTALTIME$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public boolean isSetWords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WORDS$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setAppVersion(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPVERSION$50;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setApplication(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLICATION$48;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setCharacters(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARACTERS$10;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setCharactersWithSpaces(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARACTERSWITHSPACES$36;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setCompany(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPANY$4;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setDigSig(CTDigSigBlob cTDigSigBlob) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGSIG$46;
            CTDigSigBlob cTDigSigBlob2 = (CTDigSigBlob) typeStore.find_element_user(qName, 0);
            if (cTDigSigBlob2 == null) {
                cTDigSigBlob2 = (CTDigSigBlob) get_store().add_element_user(qName);
            }
            cTDigSigBlob2.set(cTDigSigBlob);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setDocSecurity(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCSECURITY$52;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setHLinks(CTVectorVariant cTVectorVariant) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINKS$42;
            CTVectorVariant cTVectorVariant2 = (CTVectorVariant) typeStore.find_element_user(qName, 0);
            if (cTVectorVariant2 == null) {
                cTVectorVariant2 = (CTVectorVariant) get_store().add_element_user(qName);
            }
            cTVectorVariant2.set(cTVectorVariant);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setHeadingPairs(CTVectorVariant cTVectorVariant) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADINGPAIRS$30;
            CTVectorVariant cTVectorVariant2 = (CTVectorVariant) typeStore.find_element_user(qName, 0);
            if (cTVectorVariant2 == null) {
                cTVectorVariant2 = (CTVectorVariant) get_store().add_element_user(qName);
            }
            cTVectorVariant2.set(cTVectorVariant);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setHiddenSlides(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDENSLIDES$24;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setHyperlinkBase(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HYPERLINKBASE$40;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setHyperlinksChanged(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HYPERLINKSCHANGED$44;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setLines(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINES$14;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setLinksUpToDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKSUPTODATE$34;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setMMClips(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MMCLIPS$26;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setManager(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANAGER$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setNotes(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTES$20;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setPages(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGES$6;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setParagraphs(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PARAGRAPHS$16;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setPresentationFormat(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESENTATIONFORMAT$12;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setScaleCrop(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALECROP$28;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setSharedDoc(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAREDDOC$38;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setSlides(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLIDES$18;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setTemplate(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEMPLATE$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setTitlesOfParts(CTVectorLpstr cTVectorLpstr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLESOFPARTS$32;
            CTVectorLpstr cTVectorLpstr2 = (CTVectorLpstr) typeStore.find_element_user(qName, 0);
            if (cTVectorLpstr2 == null) {
                cTVectorLpstr2 = (CTVectorLpstr) get_store().add_element_user(qName);
            }
            cTVectorLpstr2.set(cTVectorLpstr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setTotalTime(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALTIME$22;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void setWords(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORDS$8;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetAppVersion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(APPVERSION$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetApplication() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(APPLICATION$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetCharacters() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHARACTERS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetCharactersWithSpaces() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHARACTERSWITHSPACES$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetCompany() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPANY$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetDigSig() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIGSIG$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetDocSecurity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCSECURITY$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetHLinks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HLINKS$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetHeadingPairs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADINGPAIRS$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetHiddenSlides() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDDENSLIDES$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetHyperlinkBase() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPERLINKBASE$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetHyperlinksChanged() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPERLINKSCHANGED$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINES$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetLinksUpToDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINKSUPTODATE$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetMMClips() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MMCLIPS$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetManager() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MANAGER$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetNotes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOTES$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetPages() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGES$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetParagraphs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PARAGRAPHS$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetPresentationFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRESENTATIONFORMAT$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetScaleCrop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCALECROP$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetSharedDoc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAREDDOC$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetSlides() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLIDES$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetTemplate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEMPLATE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetTitlesOfParts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLESOFPARTS$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetTotalTime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOTALTIME$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void unsetWords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORDS$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetAppVersion() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(APPVERSION$50, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetApplication() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(APPLICATION$48, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetCharacters() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(CHARACTERS$10, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetCharactersWithSpaces() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(CHARACTERSWITHSPACES$36, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetCompany() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(COMPANY$4, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetDocSecurity() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(DOCSECURITY$52, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetHiddenSlides() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(HIDDENSLIDES$24, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetHyperlinkBase() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(HYPERLINKBASE$40, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlBoolean xgetHyperlinksChanged() {
        XmlBoolean xmlBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_element_user = get_store().find_element_user(HYPERLINKSCHANGED$44, 0);
        }
        return xmlBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetLines() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(LINES$14, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlBoolean xgetLinksUpToDate() {
        XmlBoolean xmlBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_element_user = get_store().find_element_user(LINKSUPTODATE$34, 0);
        }
        return xmlBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetMMClips() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(MMCLIPS$26, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetManager() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(MANAGER$2, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetNotes() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(NOTES$20, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetPages() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(PAGES$6, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetParagraphs() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(PARAGRAPHS$16, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetPresentationFormat() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(PRESENTATIONFORMAT$12, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlBoolean xgetScaleCrop() {
        XmlBoolean xmlBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_element_user = get_store().find_element_user(SCALECROP$28, 0);
        }
        return xmlBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlBoolean xgetSharedDoc() {
        XmlBoolean xmlBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_element_user = get_store().find_element_user(SHAREDDOC$38, 0);
        }
        return xmlBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetSlides() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(SLIDES$18, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlString xgetTemplate() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(TEMPLATE$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetTotalTime() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(TOTALTIME$22, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public XmlInt xgetWords() {
        XmlInt xmlIntFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_element_user = get_store().find_element_user(WORDS$8, 0);
        }
        return xmlIntFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetAppVersion(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPVERSION$50;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetApplication(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLICATION$48;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetCharacters(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARACTERS$10;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetCharactersWithSpaces(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARACTERSWITHSPACES$36;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetCompany(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPANY$4;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetDocSecurity(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCSECURITY$52;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetHiddenSlides(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDENSLIDES$24;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetHyperlinkBase(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HYPERLINKBASE$40;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetHyperlinksChanged(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HYPERLINKSCHANGED$44;
            XmlBoolean xmlBooleanFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBooleanFind_element_user == null) {
                xmlBooleanFind_element_user = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBooleanFind_element_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetLines(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINES$14;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetLinksUpToDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINKSUPTODATE$34;
            XmlBoolean xmlBooleanFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBooleanFind_element_user == null) {
                xmlBooleanFind_element_user = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBooleanFind_element_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetMMClips(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MMCLIPS$26;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetManager(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MANAGER$2;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetNotes(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTES$20;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetPages(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGES$6;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetParagraphs(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PARAGRAPHS$16;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetPresentationFormat(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESENTATIONFORMAT$12;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetScaleCrop(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALECROP$28;
            XmlBoolean xmlBooleanFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBooleanFind_element_user == null) {
                xmlBooleanFind_element_user = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBooleanFind_element_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetSharedDoc(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAREDDOC$38;
            XmlBoolean xmlBooleanFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBooleanFind_element_user == null) {
                xmlBooleanFind_element_user = (XmlBoolean) get_store().add_element_user(qName);
            }
            xmlBooleanFind_element_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetSlides(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLIDES$18;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetTemplate(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEMPLATE$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetTotalTime(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALTIME$22;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties
    public void xsetWords(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORDS$8;
            XmlInt xmlIntFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntFind_element_user == null) {
                xmlIntFind_element_user = (XmlInt) get_store().add_element_user(qName);
            }
            xmlIntFind_element_user.set(xmlInt);
        }
    }
}
