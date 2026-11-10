package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomShowList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHandoutMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTKinsoku;
import org.openxmlformats.schemas.presentationml.x2006.main.CTModifyVerifier;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPhotoAlbum;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSmartTags;
import org.openxmlformats.schemas.presentationml.x2006.main.STBookmarkIdSeed;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPresentationImpl extends XmlComplexContentImpl implements CTPresentation {
    private static final QName SLDMASTERIDLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMasterIdLst");
    private static final QName NOTESMASTERIDLST$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMasterIdLst");
    private static final QName HANDOUTMASTERIDLST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "handoutMasterIdLst");
    private static final QName SLDIDLST$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldIdLst");
    private static final QName SLDSZ$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldSz");
    private static final QName NOTESSZ$10 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesSz");
    private static final QName SMARTTAGS$12 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "smartTags");
    private static final QName EMBEDDEDFONTLST$14 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "embeddedFontLst");
    private static final QName CUSTSHOWLST$16 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custShowLst");
    private static final QName PHOTOALBUM$18 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "photoAlbum");
    private static final QName CUSTDATALST$20 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
    private static final QName KINSOKU$22 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "kinsoku");
    private static final QName DEFAULTTEXTSTYLE$24 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "defaultTextStyle");
    private static final QName MODIFYVERIFIER$26 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "modifyVerifier");
    private static final QName EXTLST$28 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName SERVERZOOM$30 = new QName("", "serverZoom");
    private static final QName FIRSTSLIDENUM$32 = new QName("", "firstSlideNum");
    private static final QName SHOWSPECIALPLSONTITLESLD$34 = new QName("", "showSpecialPlsOnTitleSld");
    private static final QName RTL$36 = new QName("", "rtl");
    private static final QName REMOVEPERSONALINFOONSAVE$38 = new QName("", "removePersonalInfoOnSave");
    private static final QName COMPATMODE$40 = new QName("", "compatMode");
    private static final QName STRICTFIRSTANDLASTCHARS$42 = new QName("", "strictFirstAndLastChars");
    private static final QName EMBEDTRUETYPEFONTS$44 = new QName("", "embedTrueTypeFonts");
    private static final QName SAVESUBSETFONTS$46 = new QName("", "saveSubsetFonts");
    private static final QName AUTOCOMPRESSPICTURES$48 = new QName("", "autoCompressPictures");
    private static final QName BOOKMARKIDSEED$50 = new QName("", "bookmarkIdSeed");

    public CTPresentationImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomerDataList addNewCustDataLst() {
        CTCustomerDataList cTCustomerDataList;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataList = (CTCustomerDataList) get_store().add_element_user(CUSTDATALST$20);
        }
        return cTCustomerDataList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomShowList addNewCustShowLst() {
        CTCustomShowList cTCustomShowListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomShowListAdd_element_user = get_store().add_element_user(CUSTSHOWLST$16);
        }
        return cTCustomShowListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTTextListStyle addNewDefaultTextStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(DEFAULTTEXTSTYLE$24);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTEmbeddedFontList addNewEmbeddedFontLst() {
        CTEmbeddedFontList cTEmbeddedFontListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontListAdd_element_user = get_store().add_element_user(EMBEDDEDFONTLST$14);
        }
        return cTEmbeddedFontListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$28);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTHandoutMasterIdList addNewHandoutMasterIdLst() {
        CTHandoutMasterIdList cTHandoutMasterIdListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandoutMasterIdListAdd_element_user = get_store().add_element_user(HANDOUTMASTERIDLST$4);
        }
        return cTHandoutMasterIdListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTKinsoku addNewKinsoku() {
        CTKinsoku cTKinsokuAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKinsokuAdd_element_user = get_store().add_element_user(KINSOKU$22);
        }
        return cTKinsokuAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTModifyVerifier addNewModifyVerifier() {
        CTModifyVerifier cTModifyVerifierAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTModifyVerifierAdd_element_user = get_store().add_element_user(MODIFYVERIFIER$26);
        }
        return cTModifyVerifierAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTNotesMasterIdList addNewNotesMasterIdLst() {
        CTNotesMasterIdList cTNotesMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMasterIdList = (CTNotesMasterIdList) get_store().add_element_user(NOTESMASTERIDLST$2);
        }
        return cTNotesMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPositiveSize2D addNewNotesSz() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().add_element_user(NOTESSZ$10);
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPhotoAlbum addNewPhotoAlbum() {
        CTPhotoAlbum cTPhotoAlbumAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhotoAlbumAdd_element_user = get_store().add_element_user(PHOTOALBUM$18);
        }
        return cTPhotoAlbumAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideIdList addNewSldIdLst() {
        CTSlideIdList cTSlideIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdList = (CTSlideIdList) get_store().add_element_user(SLDIDLST$6);
        }
        return cTSlideIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideMasterIdList addNewSldMasterIdLst() {
        CTSlideMasterIdList cTSlideMasterIdList;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdList = (CTSlideMasterIdList) get_store().add_element_user(SLDMASTERIDLST$0);
        }
        return cTSlideMasterIdList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideSize addNewSldSz() {
        CTSlideSize cTSlideSize;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideSize = (CTSlideSize) get_store().add_element_user(SLDSZ$8);
        }
        return cTSlideSize;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSmartTags addNewSmartTags() {
        CTSmartTags cTSmartTagsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagsAdd_element_user = get_store().add_element_user(SMARTTAGS$12);
        }
        return cTSmartTagsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getAutoCompressPictures() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOCOMPRESSPICTURES$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public long getBookmarkIdSeed() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKMARKIDSEED$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getCompatMode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPATMODE$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomerDataList getCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomerDataList cTCustomerDataList = (CTCustomerDataList) get_store().find_element_user(CUSTDATALST$20, 0);
            if (cTCustomerDataList == null) {
                return null;
            }
            return cTCustomerDataList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTCustomShowList getCustShowLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomShowList cTCustomShowListFind_element_user = get_store().find_element_user(CUSTSHOWLST$16, 0);
            if (cTCustomShowListFind_element_user == null) {
                return null;
            }
            return cTCustomShowListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTTextListStyle getDefaultTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextListStyle cTTextListStyle = (CTTextListStyle) get_store().find_element_user(DEFAULTTEXTSTYLE$24, 0);
            if (cTTextListStyle == null) {
                return null;
            }
            return cTTextListStyle;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getEmbedTrueTypeFonts() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDTRUETYPEFONTS$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTEmbeddedFontList getEmbeddedFontLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmbeddedFontList cTEmbeddedFontListFind_element_user = get_store().find_element_user(EMBEDDEDFONTLST$14, 0);
            if (cTEmbeddedFontListFind_element_user == null) {
                return null;
            }
            return cTEmbeddedFontListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$28, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public int getFirstSlideNum() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSLIDENUM$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTHandoutMasterIdList getHandoutMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTHandoutMasterIdList cTHandoutMasterIdListFind_element_user = get_store().find_element_user(HANDOUTMASTERIDLST$4, 0);
            if (cTHandoutMasterIdListFind_element_user == null) {
                return null;
            }
            return cTHandoutMasterIdListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTKinsoku getKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            CTKinsoku cTKinsokuFind_element_user = get_store().find_element_user(KINSOKU$22, 0);
            if (cTKinsokuFind_element_user == null) {
                return null;
            }
            return cTKinsokuFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTModifyVerifier getModifyVerifier() {
        synchronized (monitor()) {
            check_orphaned();
            CTModifyVerifier cTModifyVerifierFind_element_user = get_store().find_element_user(MODIFYVERIFIER$26, 0);
            if (cTModifyVerifierFind_element_user == null) {
                return null;
            }
            return cTModifyVerifierFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTNotesMasterIdList getNotesMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTNotesMasterIdList cTNotesMasterIdList = (CTNotesMasterIdList) get_store().find_element_user(NOTESMASTERIDLST$2, 0);
            if (cTNotesMasterIdList == null) {
                return null;
            }
            return cTNotesMasterIdList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPositiveSize2D getNotesSz() {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveSize2D cTPositiveSize2D = (CTPositiveSize2D) get_store().find_element_user(NOTESSZ$10, 0);
            if (cTPositiveSize2D == null) {
                return null;
            }
            return cTPositiveSize2D;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTPhotoAlbum getPhotoAlbum() {
        synchronized (monitor()) {
            check_orphaned();
            CTPhotoAlbum cTPhotoAlbumFind_element_user = get_store().find_element_user(PHOTOALBUM$18, 0);
            if (cTPhotoAlbumFind_element_user == null) {
                return null;
            }
            return cTPhotoAlbumFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getRemovePersonalInfoOnSave() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REMOVEPERSONALINFOONSAVE$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getRtl() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getSaveSubsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVESUBSETFONTS$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public int getServerZoom() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SERVERZOOM$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getShowSpecialPlsOnTitleSld() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSPECIALPLSONTITLESLD$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideIdList getSldIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideIdList cTSlideIdList = (CTSlideIdList) get_store().find_element_user(SLDIDLST$6, 0);
            if (cTSlideIdList == null) {
                return null;
            }
            return cTSlideIdList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideMasterIdList getSldMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideMasterIdList cTSlideMasterIdList = (CTSlideMasterIdList) get_store().find_element_user(SLDMASTERIDLST$0, 0);
            if (cTSlideMasterIdList == null) {
                return null;
            }
            return cTSlideMasterIdList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSlideSize getSldSz() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideSize cTSlideSize = (CTSlideSize) get_store().find_element_user(SLDSZ$8, 0);
            if (cTSlideSize == null) {
                return null;
            }
            return cTSlideSize;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public CTSmartTags getSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTags cTSmartTagsFind_element_user = get_store().find_element_user(SMARTTAGS$12, 0);
            if (cTSmartTagsFind_element_user == null) {
                return null;
            }
            return cTSmartTagsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean getStrictFirstAndLastChars() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRICTFIRSTANDLASTCHARS$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetAutoCompressPictures() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AUTOCOMPRESSPICTURES$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetBookmarkIdSeed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BOOKMARKIDSEED$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetCompatMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COMPATMODE$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetCustDataLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTDATALST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetCustShowLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTSHOWLST$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetDefaultTextStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFAULTTEXTSTYLE$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetEmbedTrueTypeFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EMBEDTRUETYPEFONTS$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetEmbeddedFontLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMBEDDEDFONTLST$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetFirstSlideNum() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTSLIDENUM$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetHandoutMasterIdLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HANDOUTMASTERIDLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetKinsoku() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KINSOKU$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetModifyVerifier() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MODIFYVERIFIER$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetNotesMasterIdLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOTESMASTERIDLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetPhotoAlbum() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PHOTOALBUM$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetRemovePersonalInfoOnSave() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REMOVEPERSONALINFOONSAVE$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetRtl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RTL$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSaveSubsetFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SAVESUBSETFONTS$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetServerZoom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SERVERZOOM$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetShowSpecialPlsOnTitleSld() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWSPECIALPLSONTITLESLD$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSldIdLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SLDIDLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSldMasterIdLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SLDMASTERIDLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSldSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SLDSZ$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetSmartTags() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMARTTAGS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public boolean isSetStrictFirstAndLastChars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STRICTFIRSTANDLASTCHARS$42) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setAutoCompressPictures(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOCOMPRESSPICTURES$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setBookmarkIdSeed(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKMARKIDSEED$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setCompatMode(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPATMODE$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setCustDataLst(CTCustomerDataList cTCustomerDataList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTDATALST$20;
            CTCustomerDataList cTCustomerDataList2 = (CTCustomerDataList) typeStore.find_element_user(qName, 0);
            if (cTCustomerDataList2 == null) {
                cTCustomerDataList2 = (CTCustomerDataList) get_store().add_element_user(qName);
            }
            cTCustomerDataList2.set(cTCustomerDataList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setCustShowLst(CTCustomShowList cTCustomShowList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTSHOWLST$16;
            CTCustomShowList cTCustomShowListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCustomShowListFind_element_user == null) {
                cTCustomShowListFind_element_user = (CTCustomShowList) get_store().add_element_user(qName);
            }
            cTCustomShowListFind_element_user.set(cTCustomShowList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setDefaultTextStyle(CTTextListStyle cTTextListStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTEXTSTYLE$24;
            CTTextListStyle cTTextListStyle2 = (CTTextListStyle) typeStore.find_element_user(qName, 0);
            if (cTTextListStyle2 == null) {
                cTTextListStyle2 = (CTTextListStyle) get_store().add_element_user(qName);
            }
            cTTextListStyle2.set(cTTextListStyle);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setEmbedTrueTypeFonts(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDTRUETYPEFONTS$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setEmbeddedFontLst(CTEmbeddedFontList cTEmbeddedFontList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDDEDFONTLST$14;
            CTEmbeddedFontList cTEmbeddedFontListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEmbeddedFontListFind_element_user == null) {
                cTEmbeddedFontListFind_element_user = (CTEmbeddedFontList) get_store().add_element_user(qName);
            }
            cTEmbeddedFontListFind_element_user.set(cTEmbeddedFontList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$28;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setFirstSlideNum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSLIDENUM$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setHandoutMasterIdLst(CTHandoutMasterIdList cTHandoutMasterIdList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANDOUTMASTERIDLST$4;
            CTHandoutMasterIdList cTHandoutMasterIdListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHandoutMasterIdListFind_element_user == null) {
                cTHandoutMasterIdListFind_element_user = (CTHandoutMasterIdList) get_store().add_element_user(qName);
            }
            cTHandoutMasterIdListFind_element_user.set(cTHandoutMasterIdList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setKinsoku(CTKinsoku cTKinsoku) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KINSOKU$22;
            CTKinsoku cTKinsokuFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTKinsokuFind_element_user == null) {
                cTKinsokuFind_element_user = (CTKinsoku) get_store().add_element_user(qName);
            }
            cTKinsokuFind_element_user.set(cTKinsoku);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setModifyVerifier(CTModifyVerifier cTModifyVerifier) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MODIFYVERIFIER$26;
            CTModifyVerifier cTModifyVerifierFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTModifyVerifierFind_element_user == null) {
                cTModifyVerifierFind_element_user = (CTModifyVerifier) get_store().add_element_user(qName);
            }
            cTModifyVerifierFind_element_user.set(cTModifyVerifier);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setNotesMasterIdLst(CTNotesMasterIdList cTNotesMasterIdList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTESMASTERIDLST$2;
            CTNotesMasterIdList cTNotesMasterIdList2 = (CTNotesMasterIdList) typeStore.find_element_user(qName, 0);
            if (cTNotesMasterIdList2 == null) {
                cTNotesMasterIdList2 = (CTNotesMasterIdList) get_store().add_element_user(qName);
            }
            cTNotesMasterIdList2.set(cTNotesMasterIdList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setNotesSz(CTPositiveSize2D cTPositiveSize2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTESSZ$10;
            CTPositiveSize2D cTPositiveSize2D2 = (CTPositiveSize2D) typeStore.find_element_user(qName, 0);
            if (cTPositiveSize2D2 == null) {
                cTPositiveSize2D2 = (CTPositiveSize2D) get_store().add_element_user(qName);
            }
            cTPositiveSize2D2.set(cTPositiveSize2D);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setPhotoAlbum(CTPhotoAlbum cTPhotoAlbum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PHOTOALBUM$18;
            CTPhotoAlbum cTPhotoAlbumFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPhotoAlbumFind_element_user == null) {
                cTPhotoAlbumFind_element_user = (CTPhotoAlbum) get_store().add_element_user(qName);
            }
            cTPhotoAlbumFind_element_user.set(cTPhotoAlbum);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setRemovePersonalInfoOnSave(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REMOVEPERSONALINFOONSAVE$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setRtl(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSaveSubsetFonts(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVESUBSETFONTS$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setServerZoom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SERVERZOOM$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setShowSpecialPlsOnTitleSld(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSPECIALPLSONTITLESLD$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSldIdLst(CTSlideIdList cTSlideIdList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLDIDLST$6;
            CTSlideIdList cTSlideIdList2 = (CTSlideIdList) typeStore.find_element_user(qName, 0);
            if (cTSlideIdList2 == null) {
                cTSlideIdList2 = (CTSlideIdList) get_store().add_element_user(qName);
            }
            cTSlideIdList2.set(cTSlideIdList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSldMasterIdLst(CTSlideMasterIdList cTSlideMasterIdList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLDMASTERIDLST$0;
            CTSlideMasterIdList cTSlideMasterIdList2 = (CTSlideMasterIdList) typeStore.find_element_user(qName, 0);
            if (cTSlideMasterIdList2 == null) {
                cTSlideMasterIdList2 = (CTSlideMasterIdList) get_store().add_element_user(qName);
            }
            cTSlideMasterIdList2.set(cTSlideMasterIdList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSldSz(CTSlideSize cTSlideSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLDSZ$8;
            CTSlideSize cTSlideSize2 = (CTSlideSize) typeStore.find_element_user(qName, 0);
            if (cTSlideSize2 == null) {
                cTSlideSize2 = (CTSlideSize) get_store().add_element_user(qName);
            }
            cTSlideSize2.set(cTSlideSize);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setSmartTags(CTSmartTags cTSmartTags) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMARTTAGS$12;
            CTSmartTags cTSmartTagsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSmartTagsFind_element_user == null) {
                cTSmartTagsFind_element_user = (CTSmartTags) get_store().add_element_user(qName);
            }
            cTSmartTagsFind_element_user.set(cTSmartTags);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void setStrictFirstAndLastChars(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRICTFIRSTANDLASTCHARS$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetAutoCompressPictures() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AUTOCOMPRESSPICTURES$48);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetBookmarkIdSeed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BOOKMARKIDSEED$50);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetCompatMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COMPATMODE$40);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTDATALST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetCustShowLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTSHOWLST$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetDefaultTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULTTEXTSTYLE$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetEmbedTrueTypeFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EMBEDTRUETYPEFONTS$44);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetEmbeddedFontLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMBEDDEDFONTLST$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetFirstSlideNum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTSLIDENUM$32);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetHandoutMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDOUTMASTERIDLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KINSOKU$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetModifyVerifier() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MODIFYVERIFIER$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetNotesMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOTESMASTERIDLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetPhotoAlbum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHOTOALBUM$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetRemovePersonalInfoOnSave() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REMOVEPERSONALINFOONSAVE$38);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RTL$36);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSaveSubsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SAVESUBSETFONTS$46);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetServerZoom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SERVERZOOM$30);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetShowSpecialPlsOnTitleSld() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWSPECIALPLSONTITLESLD$34);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSldIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDIDLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSldMasterIdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDMASTERIDLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSldSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDSZ$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAGS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void unsetStrictFirstAndLastChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STRICTFIRSTANDLASTCHARS$42);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetAutoCompressPictures() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOCOMPRESSPICTURES$48;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public STBookmarkIdSeed xgetBookmarkIdSeed() {
        STBookmarkIdSeed sTBookmarkIdSeedFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKMARKIDSEED$50;
            sTBookmarkIdSeedFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBookmarkIdSeedFind_attribute_user == null) {
                sTBookmarkIdSeedFind_attribute_user = (STBookmarkIdSeed) get_default_attribute_value(qName);
            }
        }
        return sTBookmarkIdSeedFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetCompatMode() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPATMODE$40;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetEmbedTrueTypeFonts() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDTRUETYPEFONTS$44;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlInt xgetFirstSlideNum() {
        XmlInt xmlIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSLIDENUM$32;
            xmlIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntFind_attribute_user == null) {
                xmlIntFind_attribute_user = (XmlInt) get_default_attribute_value(qName);
            }
        }
        return xmlIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetRemovePersonalInfoOnSave() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REMOVEPERSONALINFOONSAVE$38;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetRtl() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$36;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetSaveSubsetFonts() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVESUBSETFONTS$46;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public STPercentage xgetServerZoom() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SERVERZOOM$30;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetShowSpecialPlsOnTitleSld() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSPECIALPLSONTITLESLD$34;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public XmlBoolean xgetStrictFirstAndLastChars() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRICTFIRSTANDLASTCHARS$42;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetAutoCompressPictures(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOCOMPRESSPICTURES$48;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetBookmarkIdSeed(STBookmarkIdSeed sTBookmarkIdSeed) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKMARKIDSEED$50;
            STBookmarkIdSeed sTBookmarkIdSeedFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBookmarkIdSeedFind_attribute_user == null) {
                sTBookmarkIdSeedFind_attribute_user = (STBookmarkIdSeed) get_store().add_attribute_user(qName);
            }
            sTBookmarkIdSeedFind_attribute_user.set(sTBookmarkIdSeed);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetCompatMode(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPATMODE$40;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetEmbedTrueTypeFonts(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBEDTRUETYPEFONTS$44;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetFirstSlideNum(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTSLIDENUM$32;
            XmlInt xmlIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntFind_attribute_user == null) {
                xmlIntFind_attribute_user = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlIntFind_attribute_user.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetRemovePersonalInfoOnSave(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REMOVEPERSONALINFOONSAVE$38;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetRtl(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$36;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetSaveSubsetFonts(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVESUBSETFONTS$46;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetServerZoom(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SERVERZOOM$30;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetShowSpecialPlsOnTitleSld(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWSPECIALPLSONTITLESLD$34;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation
    public void xsetStrictFirstAndLastChars(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRICTFIRSTANDLASTCHARS$42;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
