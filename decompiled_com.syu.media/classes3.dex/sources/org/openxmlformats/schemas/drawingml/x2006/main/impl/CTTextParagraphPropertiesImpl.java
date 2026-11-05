package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletColorFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizeFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePoint;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletTypefaceFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNoBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextIndent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextIndentLevelType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextMargin;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextParagraphPropertiesImpl extends XmlComplexContentImpl implements CTTextParagraphProperties {
    private static final QName LNSPC$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnSpc");
    private static final QName SPCBEF$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spcBef");
    private static final QName SPCAFT$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spcAft");
    private static final QName BUCLRTX$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buClrTx");
    private static final QName BUCLR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buClr");
    private static final QName BUSZTX$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buSzTx");
    private static final QName BUSZPCT$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buSzPct");
    private static final QName BUSZPTS$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buSzPts");
    private static final QName BUFONTTX$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buFontTx");
    private static final QName BUFONT$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buFont");
    private static final QName BUNONE$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buNone");
    private static final QName BUAUTONUM$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buAutoNum");
    private static final QName BUCHAR$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buChar");
    private static final QName BUBLIP$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "buBlip");
    private static final QName TABLST$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tabLst");
    private static final QName DEFRPR$30 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "defRPr");
    private static final QName EXTLST$32 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName MARL$34 = new QName("", "marL");
    private static final QName MARR$36 = new QName("", "marR");
    private static final QName LVL$38 = new QName("", "lvl");
    private static final QName INDENT$40 = new QName("", "indent");
    private static final QName ALGN$42 = new QName("", "algn");
    private static final QName DEFTABSZ$44 = new QName("", "defTabSz");
    private static final QName RTL$46 = new QName("", "rtl");
    private static final QName EALNBRK$48 = new QName("", "eaLnBrk");
    private static final QName FONTALGN$50 = new QName("", "fontAlgn");
    private static final QName LATINLNBRK$52 = new QName("", "latinLnBrk");
    private static final QName HANGINGPUNCT$54 = new QName("", "hangingPunct");

    public CTTextParagraphPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextAutonumberBullet addNewBuAutoNum() {
        CTTextAutonumberBullet cTTextAutonumberBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAutonumberBullet = (CTTextAutonumberBullet) get_store().add_element_user(BUAUTONUM$22);
        }
        return cTTextAutonumberBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBlipBullet addNewBuBlip() {
        CTTextBlipBullet cTTextBlipBulletAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBlipBulletAdd_element_user = get_store().add_element_user(BUBLIP$26);
        }
        return cTTextBlipBulletAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharBullet addNewBuChar() {
        CTTextCharBullet cTTextCharBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharBullet = (CTTextCharBullet) get_store().add_element_user(BUCHAR$24);
        }
        return cTTextCharBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTColor addNewBuClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(BUCLR$8);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletColorFollowText addNewBuClrTx() {
        CTTextBulletColorFollowText cTTextBulletColorFollowTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletColorFollowTextAdd_element_user = get_store().add_element_user(BUCLRTX$6);
        }
        return cTTextBulletColorFollowTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextFont addNewBuFont() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(BUFONT$18);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletTypefaceFollowText addNewBuFontTx() {
        CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletTypefaceFollowTextAdd_element_user = get_store().add_element_user(BUFONTTX$16);
        }
        return cTTextBulletTypefaceFollowTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextNoBullet addNewBuNone() {
        CTTextNoBullet cTTextNoBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextNoBullet = (CTTextNoBullet) get_store().add_element_user(BUNONE$20);
        }
        return cTTextNoBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePercent addNewBuSzPct() {
        CTTextBulletSizePercent cTTextBulletSizePercent;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizePercent = (CTTextBulletSizePercent) get_store().add_element_user(BUSZPCT$12);
        }
        return cTTextBulletSizePercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePoint addNewBuSzPts() {
        CTTextBulletSizePoint cTTextBulletSizePoint;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizePoint = (CTTextBulletSizePoint) get_store().add_element_user(BUSZPTS$14);
        }
        return cTTextBulletSizePoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizeFollowText addNewBuSzTx() {
        CTTextBulletSizeFollowText cTTextBulletSizeFollowTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizeFollowTextAdd_element_user = get_store().add_element_user(BUSZTX$10);
        }
        return cTTextBulletSizeFollowTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharacterProperties addNewDefRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(DEFRPR$30);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$32);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing addNewLnSpc() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().add_element_user(LNSPC$0);
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing addNewSpcAft() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().add_element_user(SPCAFT$4);
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing addNewSpcBef() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().add_element_user(SPCBEF$2);
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextTabStopList addNewTabLst() {
        CTTextTabStopList cTTextTabStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStopList = (CTTextTabStopList) get_store().add_element_user(TABLST$28);
        }
        return cTTextTabStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextAlignType.Enum getAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALGN$42);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextAlignType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextAutonumberBullet getBuAutoNum() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextAutonumberBullet cTTextAutonumberBullet = (CTTextAutonumberBullet) get_store().find_element_user(BUAUTONUM$22, 0);
            if (cTTextAutonumberBullet == null) {
                return null;
            }
            return cTTextAutonumberBullet;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBlipBullet getBuBlip() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBlipBullet cTTextBlipBulletFind_element_user = get_store().find_element_user(BUBLIP$26, 0);
            if (cTTextBlipBulletFind_element_user == null) {
                return null;
            }
            return cTTextBlipBulletFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharBullet getBuChar() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextCharBullet cTTextCharBullet = (CTTextCharBullet) get_store().find_element_user(BUCHAR$24, 0);
            if (cTTextCharBullet == null) {
                return null;
            }
            return cTTextCharBullet;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTColor getBuClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(BUCLR$8, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletColorFollowText getBuClrTx() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBulletColorFollowText cTTextBulletColorFollowTextFind_element_user = get_store().find_element_user(BUCLRTX$6, 0);
            if (cTTextBulletColorFollowTextFind_element_user == null) {
                return null;
            }
            return cTTextBulletColorFollowTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextFont getBuFont() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextFont cTTextFont = (CTTextFont) get_store().find_element_user(BUFONT$18, 0);
            if (cTTextFont == null) {
                return null;
            }
            return cTTextFont;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletTypefaceFollowText getBuFontTx() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowTextFind_element_user = get_store().find_element_user(BUFONTTX$16, 0);
            if (cTTextBulletTypefaceFollowTextFind_element_user == null) {
                return null;
            }
            return cTTextBulletTypefaceFollowTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextNoBullet getBuNone() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextNoBullet cTTextNoBullet = (CTTextNoBullet) get_store().find_element_user(BUNONE$20, 0);
            if (cTTextNoBullet == null) {
                return null;
            }
            return cTTextNoBullet;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePercent getBuSzPct() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBulletSizePercent cTTextBulletSizePercent = (CTTextBulletSizePercent) get_store().find_element_user(BUSZPCT$12, 0);
            if (cTTextBulletSizePercent == null) {
                return null;
            }
            return cTTextBulletSizePercent;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePoint getBuSzPts() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBulletSizePoint cTTextBulletSizePoint = (CTTextBulletSizePoint) get_store().find_element_user(BUSZPTS$14, 0);
            if (cTTextBulletSizePoint == null) {
                return null;
            }
            return cTTextBulletSizePoint;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizeFollowText getBuSzTx() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBulletSizeFollowText cTTextBulletSizeFollowTextFind_element_user = get_store().find_element_user(BUSZTX$10, 0);
            if (cTTextBulletSizeFollowTextFind_element_user == null) {
                return null;
            }
            return cTTextBulletSizeFollowTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharacterProperties getDefRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextCharacterProperties cTTextCharacterProperties = (CTTextCharacterProperties) get_store().find_element_user(DEFRPR$30, 0);
            if (cTTextCharacterProperties == null) {
                return null;
            }
            return cTTextCharacterProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getDefTabSz() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFTABSZ$44);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getEaLnBrk() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EALNBRK$48);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$32, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextFontAlignType.Enum getFontAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FONTALGN$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextFontAlignType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getHangingPunct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HANGINGPUNCT$54);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getIndent() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(INDENT$40);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getLatinLnBrk() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LATINLNBRK$52);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing getLnSpc() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextSpacing cTTextSpacing = (CTTextSpacing) get_store().find_element_user(LNSPC$0, 0);
            if (cTTextSpacing == null) {
                return null;
            }
            return cTTextSpacing;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getLvl() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LVL$38);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getMarL() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MARL$34);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getMarR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MARR$36);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getRtl() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RTL$46);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing getSpcAft() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextSpacing cTTextSpacing = (CTTextSpacing) get_store().find_element_user(SPCAFT$4, 0);
            if (cTTextSpacing == null) {
                return null;
            }
            return cTTextSpacing;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing getSpcBef() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextSpacing cTTextSpacing = (CTTextSpacing) get_store().find_element_user(SPCBEF$2, 0);
            if (cTTextSpacing == null) {
                return null;
            }
            return cTTextSpacing;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextTabStopList getTabLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextTabStopList cTTextTabStopList = (CTTextTabStopList) get_store().find_element_user(TABLST$28, 0);
            if (cTTextTabStopList == null) {
                return null;
            }
            return cTTextTabStopList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetAlgn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGN$42) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuAutoNum() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUAUTONUM$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuBlip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUBLIP$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuChar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUCHAR$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUCLR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuClrTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUCLRTX$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuFont() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUFONT$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuFontTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUFONTTX$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuNone() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUNONE$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuSzPct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUSZPCT$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuSzPts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUSZPTS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuSzTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BUSZTX$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetDefRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFRPR$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetDefTabSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFTABSZ$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetEaLnBrk() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EALNBRK$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetFontAlgn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FONTALGN$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetHangingPunct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HANGINGPUNCT$54) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetIndent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INDENT$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetLatinLnBrk() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LATINLNBRK$52) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetLnSpc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNSPC$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetLvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LVL$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetMarL() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MARL$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetMarR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MARR$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetRtl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RTL$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetSpcAft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPCAFT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetSpcBef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPCBEF$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetTabLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABLST$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setAlgn(STTextAlignType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuAutoNum(CTTextAutonumberBullet cTTextAutonumberBullet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUAUTONUM$22;
            CTTextAutonumberBullet cTTextAutonumberBullet2 = (CTTextAutonumberBullet) typeStore.find_element_user(qName, 0);
            if (cTTextAutonumberBullet2 == null) {
                cTTextAutonumberBullet2 = (CTTextAutonumberBullet) get_store().add_element_user(qName);
            }
            cTTextAutonumberBullet2.set(cTTextAutonumberBullet);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuBlip(CTTextBlipBullet cTTextBlipBullet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUBLIP$26;
            CTTextBlipBullet cTTextBlipBulletFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextBlipBulletFind_element_user == null) {
                cTTextBlipBulletFind_element_user = (CTTextBlipBullet) get_store().add_element_user(qName);
            }
            cTTextBlipBulletFind_element_user.set(cTTextBlipBullet);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuChar(CTTextCharBullet cTTextCharBullet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUCHAR$24;
            CTTextCharBullet cTTextCharBullet2 = (CTTextCharBullet) typeStore.find_element_user(qName, 0);
            if (cTTextCharBullet2 == null) {
                cTTextCharBullet2 = (CTTextCharBullet) get_store().add_element_user(qName);
            }
            cTTextCharBullet2.set(cTTextCharBullet);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuClr(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUCLR$8;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuClrTx(CTTextBulletColorFollowText cTTextBulletColorFollowText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUCLRTX$6;
            CTTextBulletColorFollowText cTTextBulletColorFollowTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextBulletColorFollowTextFind_element_user == null) {
                cTTextBulletColorFollowTextFind_element_user = (CTTextBulletColorFollowText) get_store().add_element_user(qName);
            }
            cTTextBulletColorFollowTextFind_element_user.set(cTTextBulletColorFollowText);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuFont(CTTextFont cTTextFont) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUFONT$18;
            CTTextFont cTTextFont2 = (CTTextFont) typeStore.find_element_user(qName, 0);
            if (cTTextFont2 == null) {
                cTTextFont2 = (CTTextFont) get_store().add_element_user(qName);
            }
            cTTextFont2.set(cTTextFont);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuFontTx(CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUFONTTX$16;
            CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextBulletTypefaceFollowTextFind_element_user == null) {
                cTTextBulletTypefaceFollowTextFind_element_user = (CTTextBulletTypefaceFollowText) get_store().add_element_user(qName);
            }
            cTTextBulletTypefaceFollowTextFind_element_user.set(cTTextBulletTypefaceFollowText);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuNone(CTTextNoBullet cTTextNoBullet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUNONE$20;
            CTTextNoBullet cTTextNoBullet2 = (CTTextNoBullet) typeStore.find_element_user(qName, 0);
            if (cTTextNoBullet2 == null) {
                cTTextNoBullet2 = (CTTextNoBullet) get_store().add_element_user(qName);
            }
            cTTextNoBullet2.set(cTTextNoBullet);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuSzPct(CTTextBulletSizePercent cTTextBulletSizePercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUSZPCT$12;
            CTTextBulletSizePercent cTTextBulletSizePercent2 = (CTTextBulletSizePercent) typeStore.find_element_user(qName, 0);
            if (cTTextBulletSizePercent2 == null) {
                cTTextBulletSizePercent2 = (CTTextBulletSizePercent) get_store().add_element_user(qName);
            }
            cTTextBulletSizePercent2.set(cTTextBulletSizePercent);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuSzPts(CTTextBulletSizePoint cTTextBulletSizePoint) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUSZPTS$14;
            CTTextBulletSizePoint cTTextBulletSizePoint2 = (CTTextBulletSizePoint) typeStore.find_element_user(qName, 0);
            if (cTTextBulletSizePoint2 == null) {
                cTTextBulletSizePoint2 = (CTTextBulletSizePoint) get_store().add_element_user(qName);
            }
            cTTextBulletSizePoint2.set(cTTextBulletSizePoint);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuSzTx(CTTextBulletSizeFollowText cTTextBulletSizeFollowText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUSZTX$10;
            CTTextBulletSizeFollowText cTTextBulletSizeFollowTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextBulletSizeFollowTextFind_element_user == null) {
                cTTextBulletSizeFollowTextFind_element_user = (CTTextBulletSizeFollowText) get_store().add_element_user(qName);
            }
            cTTextBulletSizeFollowTextFind_element_user.set(cTTextBulletSizeFollowText);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setDefRPr(CTTextCharacterProperties cTTextCharacterProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFRPR$30;
            CTTextCharacterProperties cTTextCharacterProperties2 = (CTTextCharacterProperties) typeStore.find_element_user(qName, 0);
            if (cTTextCharacterProperties2 == null) {
                cTTextCharacterProperties2 = (CTTextCharacterProperties) get_store().add_element_user(qName);
            }
            cTTextCharacterProperties2.set(cTTextCharacterProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setDefTabSz(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFTABSZ$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setEaLnBrk(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EALNBRK$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$32;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setFontAlgn(STTextFontAlignType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTALGN$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setHangingPunct(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANGINGPUNCT$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setIndent(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INDENT$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setLatinLnBrk(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LATINLNBRK$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setLnSpc(CTTextSpacing cTTextSpacing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNSPC$0;
            CTTextSpacing cTTextSpacing2 = (CTTextSpacing) typeStore.find_element_user(qName, 0);
            if (cTTextSpacing2 == null) {
                cTTextSpacing2 = (CTTextSpacing) get_store().add_element_user(qName);
            }
            cTTextSpacing2.set(cTTextSpacing);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setLvl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setMarL(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARL$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setMarR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARR$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setRtl(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setSpcAft(CTTextSpacing cTTextSpacing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCAFT$4;
            CTTextSpacing cTTextSpacing2 = (CTTextSpacing) typeStore.find_element_user(qName, 0);
            if (cTTextSpacing2 == null) {
                cTTextSpacing2 = (CTTextSpacing) get_store().add_element_user(qName);
            }
            cTTextSpacing2.set(cTTextSpacing);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setSpcBef(CTTextSpacing cTTextSpacing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCBEF$2;
            CTTextSpacing cTTextSpacing2 = (CTTextSpacing) typeStore.find_element_user(qName, 0);
            if (cTTextSpacing2 == null) {
                cTTextSpacing2 = (CTTextSpacing) get_store().add_element_user(qName);
            }
            cTTextSpacing2.set(cTTextSpacing);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setTabLst(CTTextTabStopList cTTextTabStopList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLST$28;
            CTTextTabStopList cTTextTabStopList2 = (CTTextTabStopList) typeStore.find_element_user(qName, 0);
            if (cTTextTabStopList2 == null) {
                cTTextTabStopList2 = (CTTextTabStopList) get_store().add_element_user(qName);
            }
            cTTextTabStopList2.set(cTTextTabStopList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGN$42);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuAutoNum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUAUTONUM$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuBlip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUBLIP$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuChar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUCHAR$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUCLR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuClrTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUCLRTX$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUFONT$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuFontTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUFONTTX$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuNone() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUNONE$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuSzPct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUSZPCT$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuSzPts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUSZPTS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuSzTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BUSZTX$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetDefRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFRPR$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetDefTabSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFTABSZ$44);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetEaLnBrk() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EALNBRK$48);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetFontAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FONTALGN$50);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetHangingPunct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HANGINGPUNCT$54);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetIndent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INDENT$40);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetLatinLnBrk() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LATINLNBRK$52);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetLnSpc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNSPC$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LVL$38);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetMarL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MARL$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetMarR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MARR$36);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RTL$46);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetSpcAft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPCAFT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetSpcBef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPCBEF$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetTabLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLST$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextAlignType xgetAlgn() {
        STTextAlignType sTTextAlignType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextAlignType = (STTextAlignType) get_store().find_attribute_user(ALGN$42);
        }
        return sTTextAlignType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STCoordinate32 xgetDefTabSz() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(DEFTABSZ$44);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetEaLnBrk() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(EALNBRK$48);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextFontAlignType xgetFontAlgn() {
        STTextFontAlignType sTTextFontAlignType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextFontAlignType = (STTextFontAlignType) get_store().find_attribute_user(FONTALGN$50);
        }
        return sTTextFontAlignType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetHangingPunct() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(HANGINGPUNCT$54);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextIndent xgetIndent() {
        STTextIndent sTTextIndent;
        synchronized (monitor()) {
            check_orphaned();
            sTTextIndent = (STTextIndent) get_store().find_attribute_user(INDENT$40);
        }
        return sTTextIndent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetLatinLnBrk() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(LATINLNBRK$52);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextIndentLevelType xgetLvl() {
        STTextIndentLevelType sTTextIndentLevelType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextIndentLevelType = (STTextIndentLevelType) get_store().find_attribute_user(LVL$38);
        }
        return sTTextIndentLevelType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextMargin xgetMarL() {
        STTextMargin sTTextMargin;
        synchronized (monitor()) {
            check_orphaned();
            sTTextMargin = (STTextMargin) get_store().find_attribute_user(MARL$34);
        }
        return sTTextMargin;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextMargin xgetMarR() {
        STTextMargin sTTextMargin;
        synchronized (monitor()) {
            check_orphaned();
            sTTextMargin = (STTextMargin) get_store().find_attribute_user(MARR$36);
        }
        return sTTextMargin;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetRtl() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(RTL$46);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetAlgn(STTextAlignType sTTextAlignType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$42;
            STTextAlignType sTTextAlignType2 = (STTextAlignType) typeStore.find_attribute_user(qName);
            if (sTTextAlignType2 == null) {
                sTTextAlignType2 = (STTextAlignType) get_store().add_attribute_user(qName);
            }
            sTTextAlignType2.set((XmlObject) sTTextAlignType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetDefTabSz(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFTABSZ$44;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetEaLnBrk(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EALNBRK$48;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetFontAlgn(STTextFontAlignType sTTextFontAlignType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTALGN$50;
            STTextFontAlignType sTTextFontAlignType2 = (STTextFontAlignType) typeStore.find_attribute_user(qName);
            if (sTTextFontAlignType2 == null) {
                sTTextFontAlignType2 = (STTextFontAlignType) get_store().add_attribute_user(qName);
            }
            sTTextFontAlignType2.set((XmlObject) sTTextFontAlignType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetHangingPunct(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANGINGPUNCT$54;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetIndent(STTextIndent sTTextIndent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INDENT$40;
            STTextIndent sTTextIndent2 = (STTextIndent) typeStore.find_attribute_user(qName);
            if (sTTextIndent2 == null) {
                sTTextIndent2 = (STTextIndent) get_store().add_attribute_user(qName);
            }
            sTTextIndent2.set(sTTextIndent);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetLatinLnBrk(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LATINLNBRK$52;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetLvl(STTextIndentLevelType sTTextIndentLevelType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVL$38;
            STTextIndentLevelType sTTextIndentLevelType2 = (STTextIndentLevelType) typeStore.find_attribute_user(qName);
            if (sTTextIndentLevelType2 == null) {
                sTTextIndentLevelType2 = (STTextIndentLevelType) get_store().add_attribute_user(qName);
            }
            sTTextIndentLevelType2.set(sTTextIndentLevelType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetMarL(STTextMargin sTTextMargin) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARL$34;
            STTextMargin sTTextMargin2 = (STTextMargin) typeStore.find_attribute_user(qName);
            if (sTTextMargin2 == null) {
                sTTextMargin2 = (STTextMargin) get_store().add_attribute_user(qName);
            }
            sTTextMargin2.set(sTTextMargin);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetMarR(STTextMargin sTTextMargin) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARR$36;
            STTextMargin sTTextMargin2 = (STTextMargin) typeStore.find_attribute_user(qName);
            if (sTTextMargin2 == null) {
                sTTextMargin2 = (STTextMargin) get_store().add_attribute_user(qName);
            }
            sTTextMargin2.set(sTTextMargin);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetRtl(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$46;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
