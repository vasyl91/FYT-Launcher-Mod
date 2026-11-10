package com.microsoft.schemas.vml.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTComplex;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STBWMode$Enum;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STConnectorType$Enum;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STHrAlign$Enum;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse$Enum;
import com.microsoft.schemas.office.office.STTrueFalseBlank;
import com.microsoft.schemas.office.office.STTrueFalseBlank$Enum;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STTrueFalse;
import com.syu.media.provider.Media;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTShapetypeImpl extends XmlComplexContentImpl implements CTShapetype {
    private static final QName PATH$0 = new QName("urn:schemas-microsoft-com:vml", Media.PATH);
    private static final QName FORMULAS$2 = new QName("urn:schemas-microsoft-com:vml", "formulas");
    private static final QName HANDLES$4 = new QName("urn:schemas-microsoft-com:vml", "handles");
    private static final QName FILL$6 = new QName("urn:schemas-microsoft-com:vml", "fill");
    private static final QName STROKE$8 = new QName("urn:schemas-microsoft-com:vml", "stroke");
    private static final QName SHADOW$10 = new QName("urn:schemas-microsoft-com:vml", "shadow");
    private static final QName TEXTBOX$12 = new QName("urn:schemas-microsoft-com:vml", "textbox");
    private static final QName TEXTPATH$14 = new QName("urn:schemas-microsoft-com:vml", "textpath");
    private static final QName IMAGEDATA$16 = new QName("urn:schemas-microsoft-com:vml", "imagedata");
    private static final QName SKEW$18 = new QName("urn:schemas-microsoft-com:office:office", "skew");
    private static final QName EXTRUSION$20 = new QName("urn:schemas-microsoft-com:office:office", "extrusion");
    private static final QName CALLOUT$22 = new QName("urn:schemas-microsoft-com:office:office", "callout");
    private static final QName LOCK$24 = new QName("urn:schemas-microsoft-com:office:office", "lock");
    private static final QName CLIPPATH$26 = new QName("urn:schemas-microsoft-com:office:office", "clippath");
    private static final QName SIGNATURELINE$28 = new QName("urn:schemas-microsoft-com:office:office", "signatureline");
    private static final QName WRAP$30 = new QName("urn:schemas-microsoft-com:office:word", "wrap");
    private static final QName ANCHORLOCK$32 = new QName("urn:schemas-microsoft-com:office:word", "anchorlock");
    private static final QName BORDERTOP$34 = new QName("urn:schemas-microsoft-com:office:word", "bordertop");
    private static final QName BORDERBOTTOM$36 = new QName("urn:schemas-microsoft-com:office:word", "borderbottom");
    private static final QName BORDERLEFT$38 = new QName("urn:schemas-microsoft-com:office:word", "borderleft");
    private static final QName BORDERRIGHT$40 = new QName("urn:schemas-microsoft-com:office:word", "borderright");
    private static final QName CLIENTDATA$42 = new QName("urn:schemas-microsoft-com:office:excel", "ClientData");
    private static final QName TEXTDATA$44 = new QName("urn:schemas-microsoft-com:office:powerpoint", "textdata");
    private static final QName COMPLEX$46 = new QName("urn:schemas-microsoft-com:office:office", "complex");
    private static final QName ID$48 = new QName(FinalChip.BSP_PLATFORM_Null, "id");
    private static final QName STYLE$50 = new QName(FinalChip.BSP_PLATFORM_Null, "style");
    private static final QName HREF$52 = new QName(FinalChip.BSP_PLATFORM_Null, "href");
    private static final QName TARGET$54 = new QName(FinalChip.BSP_PLATFORM_Null, "target");
    private static final QName CLASS1$56 = new QName(FinalChip.BSP_PLATFORM_Null, "class");
    private static final QName TITLE$58 = new QName(FinalChip.BSP_PLATFORM_Null, "title");
    private static final QName ALT$60 = new QName(FinalChip.BSP_PLATFORM_Null, "alt");
    private static final QName COORDSIZE$62 = new QName(FinalChip.BSP_PLATFORM_Null, "coordsize");
    private static final QName COORDORIGIN$64 = new QName(FinalChip.BSP_PLATFORM_Null, "coordorigin");
    private static final QName WRAPCOORDS$66 = new QName(FinalChip.BSP_PLATFORM_Null, "wrapcoords");
    private static final QName PRINT$68 = new QName(FinalChip.BSP_PLATFORM_Null, "print");
    private static final QName SPID$70 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$72 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$74 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$76 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$78 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$80 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$82 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$84 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$86 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$88 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$90 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$92 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$94 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$96 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$98 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$100 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$102 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$104 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$106 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$108 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$110 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$112 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$114 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName CHROMAKEY$116 = new QName(FinalChip.BSP_PLATFORM_Null, "chromakey");
    private static final QName FILLED$118 = new QName(FinalChip.BSP_PLATFORM_Null, "filled");
    private static final QName FILLCOLOR$120 = new QName(FinalChip.BSP_PLATFORM_Null, "fillcolor");
    private static final QName OPACITY$122 = new QName(FinalChip.BSP_PLATFORM_Null, "opacity");
    private static final QName STROKED$124 = new QName(FinalChip.BSP_PLATFORM_Null, "stroked");
    private static final QName STROKECOLOR$126 = new QName(FinalChip.BSP_PLATFORM_Null, "strokecolor");
    private static final QName STROKEWEIGHT$128 = new QName(FinalChip.BSP_PLATFORM_Null, "strokeweight");
    private static final QName INSETPEN$130 = new QName(FinalChip.BSP_PLATFORM_Null, "insetpen");
    private static final QName SPT$132 = new QName("urn:schemas-microsoft-com:office:office", "spt");
    private static final QName CONNECTORTYPE$134 = new QName("urn:schemas-microsoft-com:office:office", "connectortype");
    private static final QName BWMODE$136 = new QName("urn:schemas-microsoft-com:office:office", "bwmode");
    private static final QName BWPURE$138 = new QName("urn:schemas-microsoft-com:office:office", "bwpure");
    private static final QName BWNORMAL$140 = new QName("urn:schemas-microsoft-com:office:office", "bwnormal");
    private static final QName FORCEDASH$142 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName OLEICON$144 = new QName("urn:schemas-microsoft-com:office:office", "oleicon");
    private static final QName OLE$146 = new QName("urn:schemas-microsoft-com:office:office", "ole");
    private static final QName PREFERRELATIVE$148 = new QName("urn:schemas-microsoft-com:office:office", "preferrelative");
    private static final QName CLIPTOWRAP$150 = new QName("urn:schemas-microsoft-com:office:office", "cliptowrap");
    private static final QName CLIP$152 = new QName("urn:schemas-microsoft-com:office:office", "clip");
    private static final QName ADJ$154 = new QName(FinalChip.BSP_PLATFORM_Null, "adj");
    private static final QName PATH2$156 = new QName(FinalChip.BSP_PLATFORM_Null, Media.PATH);
    private static final QName MASTER$158 = new QName("urn:schemas-microsoft-com:office:office", "master");

    public CTShapetypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock cTAnchorLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockAdd_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return cTAnchorLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBorderbottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBorderleft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBorderright() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder addNewBordertop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTCallout addNewCallout() {
        CTCallout cTCalloutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutAdd_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return cTCalloutAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClientData addNewClientData() {
        CTClientData cTClientDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataAdd_element_user = get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClipPath addNewClippath() {
        CTClipPath cTClipPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathAdd_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return cTClipPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTComplex addNewComplex() {
        CTComplex cTComplexAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTComplexAdd_element_user = get_store().add_element_user(COMPLEX$46);
        }
        return cTComplexAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTExtrusion addNewExtrusion() {
        CTExtrusion cTExtrusionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionAdd_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return cTExtrusionAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFill addNewFill() {
        CTFill cTFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillAdd_element_user = get_store().add_element_user(FILL$6);
        }
        return cTFillAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulasAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasAdd_element_user = get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulasAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTHandles addNewHandles() {
        CTHandles cTHandlesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesAdd_element_user = get_store().add_element_user(HANDLES$4);
        }
        return cTHandlesAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTImageData addNewImagedata() {
        CTImageData cTImageDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataAdd_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return cTImageDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTLock addNewLock() {
        CTLock cTLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockAdd_element_user = get_store().add_element_user(LOCK$24);
        }
        return cTLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTPath addNewPath() {
        CTPath cTPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathAdd_element_user = get_store().add_element_user(PATH$0);
        }
        return cTPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTShadow addNewShadow() {
        CTShadow cTShadowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowAdd_element_user = get_store().add_element_user(SHADOW$10);
        }
        return cTShadowAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine cTSignatureLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineAdd_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return cTSignatureLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSkew addNewSkew() {
        CTSkew cTSkewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewAdd_element_user = get_store().add_element_user(SKEW$18);
        }
        return cTSkewAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTStroke addNewStroke() {
        CTStroke cTStrokeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeAdd_element_user = get_store().add_element_user(STROKE$8);
        }
        return cTStrokeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextboxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxAdd_element_user = get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextboxAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTRel addNewTextdata() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return cTRelAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathAdd_element_user = get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTWrap addNewWrap() {
        CTWrap cTWrapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapAdd_element_user = get_store().add_element_user(WRAP$30);
        }
        return cTWrapAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getAdj() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ADJ$154);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$94);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$96);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALT$60);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTAnchorLock getAnchorlockArray(int i) {
        CTAnchorLock cTAnchorLockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockFind_element_user = get_store().find_element_user(ANCHORLOCK$32, i);
            if (cTAnchorLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAnchorLockFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTAnchorLock[] getAnchorlockArray() {
        CTAnchorLock[] cTAnchorLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHORLOCK$32, arrayList);
            cTAnchorLockArr = new CTAnchorLock[arrayList.size()];
            arrayList.toArray(cTAnchorLockArr);
        }
        return cTAnchorLockArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTAnchorLock> getAnchorlockList() {
        1AnchorlockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorlockList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder getBorderbottomArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERBOTTOM$36, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder[] getBorderbottomArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOTTOM$36, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBorderbottomList() {
        1BorderbottomList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderbottomList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder getBorderleftArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERLEFT$38, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder[] getBorderleftArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERLEFT$38, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBorderleftList() {
        1BorderleftList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderleftList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$102);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder getBorderrightArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERRIGHT$40, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder[] getBorderrightArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERRIGHT$40, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBorderrightList() {
        1BorderrightList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderrightList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$106);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder getBordertopArray(int i) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderFind_element_user = get_store().find_element_user(BORDERTOP$34, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder[] getBordertopArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERTOP$34, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTBorder> getBordertopList() {
        1BordertopList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BordertopList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$100);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BULLET$82);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BUTTON$78);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode$Enum getBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWMODE$136);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode$Enum getBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWNORMAL$140);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode$Enum getBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BWPURE$138);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTCallout getCalloutArray(int i) {
        CTCallout cTCalloutFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutFind_element_user = get_store().find_element_user(CALLOUT$22, i);
            if (cTCalloutFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCalloutFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTCallout[] getCalloutArray() {
        CTCallout[] cTCalloutArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CALLOUT$22, arrayList);
            cTCalloutArr = new CTCallout[arrayList.size()];
            arrayList.toArray(cTCalloutArr);
        }
        return cTCalloutArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTCallout> getCalloutList() {
        1CalloutList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalloutList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$116);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLASS1$56);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClientData getClientDataArray(int i) {
        CTClientData cTClientDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataFind_element_user = get_store().find_element_user(CLIENTDATA$42, i);
            if (cTClientDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTClientDataFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClientData[] getClientDataArray() {
        CTClientData[] cTClientDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLIENTDATA$42, arrayList);
            cTClientDataArr = new CTClientData[arrayList.size()];
            arrayList.toArray(cTClientDataArr);
        }
        return cTClientDataArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTClientData> getClientDataList() {
        1ClientDataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClientDataList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getClip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIP$152);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClipPath getClippathArray(int i) {
        CTClipPath cTClipPathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathFind_element_user = get_store().find_element_user(CLIPPATH$26, i);
            if (cTClipPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTClipPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClipPath[] getClippathArray() {
        CTClipPath[] cTClipPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLIPPATH$26, arrayList);
            cTClipPathArr = new CTClipPath[arrayList.size()];
            arrayList.toArray(cTClipPathArr);
        }
        return cTClipPathArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTClipPath> getClippathList() {
        1ClippathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClippathList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$150);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTComplex getComplex() {
        synchronized (monitor()) {
            check_orphaned();
            CTComplex cTComplexFind_element_user = get_store().find_element_user(COMPLEX$46, 0);
            if (cTComplexFind_element_user == null) {
                return null;
            }
            return cTComplexFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STConnectorType$Enum getConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STConnectorType$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$64);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDSIZE$62);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$108);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$112);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$110);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTExtrusion getExtrusionArray(int i) {
        CTExtrusion cTExtrusionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionFind_element_user = get_store().find_element_user(EXTRUSION$20, i);
            if (cTExtrusionFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExtrusionFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTExtrusion[] getExtrusionArray() {
        CTExtrusion[] cTExtrusionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXTRUSION$20, arrayList);
            cTExtrusionArr = new CTExtrusion[arrayList.size()];
            arrayList.toArray(cTExtrusionArr);
        }
        return cTExtrusionArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTExtrusion> getExtrusionList() {
        1ExtrusionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtrusionList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFill getFillArray(int i) {
        CTFill cTFillFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillFind_element_user = get_store().find_element_user(FILL$6, i);
            if (cTFillFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFillFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFill[] getFillArray() {
        CTFill[] cTFillArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILL$6, arrayList);
            cTFillArr = new CTFill[arrayList.size()];
            arrayList.toArray(cTFillArr);
        }
        return cTFillArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTFill> getFillList() {
        1FillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FillList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$120);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLED$118);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORCEDASH$142);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFormulas getFormulasArray(int i) {
        CTFormulas cTFormulasFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasFind_element_user = get_store().find_element_user(FORMULAS$2, i);
            if (cTFormulasFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFormulasFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFormulas[] getFormulasArray() {
        CTFormulas[] cTFormulasArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FORMULAS$2, arrayList);
            cTFormulasArr = new CTFormulas[arrayList.size()];
            arrayList.toArray(cTFormulasArr);
        }
        return cTFormulasArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTFormulas> getFormulasList() {
        1FormulasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FormulasList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTHandles getHandlesArray(int i) {
        CTHandles cTHandlesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesFind_element_user = get_store().find_element_user(HANDLES$4, i);
            if (cTHandlesFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHandlesFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTHandles[] getHandlesArray() {
        CTHandles[] cTHandlesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HANDLES$4, arrayList);
            cTHandlesArr = new CTHandles[arrayList.size()];
            arrayList.toArray(cTHandlesArr);
        }
        return cTHandlesArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTHandles> getHandlesList() {
        1HandlesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HandlesList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HR$84);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STHrAlign$Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STHrAlign$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HREF$52);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$88);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRPCT$90);
            if (simpleValueFind_attribute_user == null) {
                return 0.0f;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRSTD$86);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$48);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTImageData getImagedataArray(int i) {
        CTImageData cTImageDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataFind_element_user = get_store().find_element_user(IMAGEDATA$16, i);
            if (cTImageDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTImageDataFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTImageData[] getImagedataArray() {
        CTImageData[] cTImageDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(IMAGEDATA$16, arrayList);
            cTImageDataArr = new CTImageData[arrayList.size()];
            arrayList.toArray(cTImageDataArr);
        }
        return cTImageDataArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTImageData> getImagedataList() {
        1ImagedataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImagedataList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STInsetMode.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(INSETPEN$130);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTLock getLockArray(int i) {
        CTLock cTLockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockFind_element_user = get_store().find_element_user(LOCK$24, i);
            if (cTLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLockFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTLock[] getLockArray() {
        CTLock[] cTLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCK$24, arrayList);
            cTLockArr = new CTLock[arrayList.size()];
            arrayList.toArray(cTLockArr);
        }
        return cTLockArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getMaster() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MASTER$158);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalseBlank$Enum getOle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLE$146);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalseBlank$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OLEICON$144);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ONED$72);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OPACITY$122);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getPath2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PATH2$156);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTPath getPathArray(int i) {
        CTPath cTPathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathFind_element_user = get_store().find_element_user(PATH$0, i);
            if (cTPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTPath[] getPathArray() {
        CTPath[] cTPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PATH$0, arrayList);
            cTPathArr = new CTPath[arrayList.size()];
            arrayList.toArray(cTPathArr);
        }
        return cTPathArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTPath> getPathList() {
        1PathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PathList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$148);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PRINT$68);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REGROUPID$74);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTShadow getShadowArray(int i) {
        CTShadow cTShadowFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowFind_element_user = get_store().find_element_user(SHADOW$10, i);
            if (cTShadowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShadowFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTShadow[] getShadowArray() {
        CTShadow[] cTShadowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHADOW$10, arrayList);
            cTShadowArr = new CTShadow[arrayList.size()];
            arrayList.toArray(cTShadowArr);
        }
        return cTShadowArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTShadow> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSignatureLine getSignaturelineArray(int i) {
        CTSignatureLine cTSignatureLineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineFind_element_user = get_store().find_element_user(SIGNATURELINE$28, i);
            if (cTSignatureLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSignatureLineFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSignatureLine[] getSignaturelineArray() {
        CTSignatureLine[] cTSignatureLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIGNATURELINE$28, arrayList);
            cTSignatureLineArr = new CTSignatureLine[arrayList.size()];
            arrayList.toArray(cTSignatureLineArr);
        }
        return cTSignatureLineArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTSignatureLine> getSignaturelineList() {
        1SignaturelineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SignaturelineList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSkew getSkewArray(int i) {
        CTSkew cTSkewFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewFind_element_user = get_store().find_element_user(SKEW$18, i);
            if (cTSkewFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSkewFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSkew[] getSkewArray() {
        CTSkew[] cTSkewArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SKEW$18, arrayList);
            cTSkewArr = new CTSkew[arrayList.size()];
            arrayList.toArray(cTSkewArr);
        }
        return cTSkewArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTSkew> getSkewList() {
        1SkewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SkewList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPID$70);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public float getSpt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPT$132);
            if (simpleValueFind_attribute_user == null) {
                return 0.0f;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTStroke getStrokeArray(int i) {
        CTStroke cTStrokeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeFind_element_user = get_store().find_element_user(STROKE$8, i);
            if (cTStrokeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStrokeFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTStroke[] getStrokeArray() {
        CTStroke[] cTStrokeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STROKE$8, arrayList);
            cTStrokeArr = new CTStroke[arrayList.size()];
            arrayList.toArray(cTStrokeArr);
        }
        return cTStrokeArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTStroke> getStrokeList() {
        1StrokeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrokeList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$126);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse.Enum getStroked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKED$124);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$128);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLE$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGET$54);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextbox getTextboxArray(int i) {
        CTTextbox cTTextboxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxFind_element_user = get_store().find_element_user(TEXTBOX$12, i);
            if (cTTextboxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextboxFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextbox[] getTextboxArray() {
        CTTextbox[] cTTextboxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTBOX$12, arrayList);
            cTTextboxArr = new CTTextbox[arrayList.size()];
            arrayList.toArray(cTTextboxArr);
        }
        return cTTextboxArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTTextbox> getTextboxList() {
        1TextboxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextboxList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTRel getTextdataArray(int i) {
        CTRel cTRelFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelFind_element_user = get_store().find_element_user(TEXTDATA$44, i);
            if (cTRelFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRelFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTRel[] getTextdataArray() {
        CTRel[] cTRelArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTDATA$44, arrayList);
            cTRelArr = new CTRel[arrayList.size()];
            arrayList.toArray(cTRelArr);
        }
        return cTRelArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTRel> getTextdataList() {
        1TextdataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextdataList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextPath getTextpathArray(int i) {
        CTTextPath cTTextPathFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathFind_element_user = get_store().find_element_user(TEXTPATH$14, i);
            if (cTTextPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextPath[] getTextpathArray() {
        CTTextPath[] cTTextPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTPATH$14, arrayList);
            cTTextPathArr = new CTTextPath[arrayList.size()];
            arrayList.toArray(cTTextPathArr);
        }
        return cTTextPathArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTTextPath> getTextpathList() {
        1TextpathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextpathList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TITLE$58);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERDRAWN$98);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse$Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$80);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTWrap getWrapArray(int i) {
        CTWrap cTWrapFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapFind_element_user = get_store().find_element_user(WRAP$30, i);
            if (cTWrapFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTWrapFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTWrap[] getWrapArray() {
        CTWrap[] cTWrapArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WRAP$30, arrayList);
            cTWrapArr = new CTWrap[arrayList.size()];
            arrayList.toArray(cTWrapArr);
        }
        return cTWrapArr;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public List<CTWrap> getWrapList() {
        1WrapList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WrapList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$66);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock cTAnchorLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockInsert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return cTAnchorLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBorderleft(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBorderright(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTBorder insertNewBordertop(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTCallout insertNewCallout(int i) {
        CTCallout cTCalloutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutInsert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return cTCalloutInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataInsert_element_user = get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTClipPath insertNewClippath(int i) {
        CTClipPath cTClipPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathInsert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return cTClipPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion cTExtrusionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionInsert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return cTExtrusionInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFill insertNewFill(int i) {
        CTFill cTFillInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillInsert_element_user = get_store().insert_element_user(FILL$6, i);
        }
        return cTFillInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulasInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasInsert_element_user = get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulasInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandlesInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesInsert_element_user = get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandlesInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTImageData insertNewImagedata(int i) {
        CTImageData cTImageDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataInsert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return cTImageDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTLock insertNewLock(int i) {
        CTLock cTLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockInsert_element_user = get_store().insert_element_user(LOCK$24, i);
        }
        return cTLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTPath insertNewPath(int i) {
        CTPath cTPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathInsert_element_user = get_store().insert_element_user(PATH$0, i);
        }
        return cTPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowInsert_element_user = get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadowInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine cTSignatureLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineInsert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return cTSignatureLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTSkew insertNewSkew(int i) {
        CTSkew cTSkewInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewInsert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return cTSkewInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStrokeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeInsert_element_user = get_store().insert_element_user(STROKE$8, i);
        }
        return cTStrokeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextboxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxInsert_element_user = get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextboxInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTRel insertNewTextdata(int i) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return cTRelInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathInsert_element_user = get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public CTWrap insertNewWrap(int i) {
        CTWrap cTWrapInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapInsert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return cTWrapInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAdj() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJ$154) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$94) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$96) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$60) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$102) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$106) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$100) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$82) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$78) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBwmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$136) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBwnormal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWNORMAL$140) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetBwpure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWPURE$138) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetChromakey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHROMAKEY$116) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$56) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetClip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIP$152) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetCliptowrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIPTOWRAP$150) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetComplex() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPLEX$46) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetConnectortype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTORTYPE$134) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$64) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$62) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$108) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$112) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$110) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$120) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$118) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$142) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$84) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$92) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$52) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$88) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$90) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$86) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$48) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$114) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$130) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetMaster() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MASTER$158) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLE$146) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOleicon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLEICON$144) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$72) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$122) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetPath2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATH2$156) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetPreferrelative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVE$148) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$68) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$74) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$70) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetSpt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPT$132) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStrokecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKECOLOR$126) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStroked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKED$124) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStrokeweight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEWEIGHT$128) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$50) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$54) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$58) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$98) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$80) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$66) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAdj(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$154;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAllowincell(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$94;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAllowoverlap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$96;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$60;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock) {
        synchronized (monitor()) {
            check_orphaned();
            CTAnchorLock cTAnchorLockFind_element_user = get_store().find_element_user(ANCHORLOCK$32, i);
            if (cTAnchorLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAnchorLockFind_element_user.set(cTAnchorLock);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAnchorLockArr, ANCHORLOCK$32);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderbottomArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(BORDERBOTTOM$36, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERBOTTOM$36);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$104;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderleftArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(BORDERLEFT$38, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERLEFT$38);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$102;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderrightArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(BORDERRIGHT$40, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERRIGHT$40);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$106;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBordertopArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorderFind_element_user = get_store().find_element_user(BORDERTOP$34, i);
            if (cTBorderFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBorderFind_element_user.set(cTBorder);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERTOP$34);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$100;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBullet(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$82;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setButton(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$78;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBwmode(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$136;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBwnormal(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$140;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setBwpure(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$138;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCalloutArray(int i, CTCallout cTCallout) {
        synchronized (monitor()) {
            check_orphaned();
            CTCallout cTCalloutFind_element_user = get_store().find_element_user(CALLOUT$22, i);
            if (cTCalloutFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCalloutFind_element_user.set(cTCallout);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCalloutArr, CALLOUT$22);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setChromakey(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$116;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClientDataArray(int i, CTClientData cTClientData) {
        synchronized (monitor()) {
            check_orphaned();
            CTClientData cTClientDataFind_element_user = get_store().find_element_user(CLIENTDATA$42, i);
            if (cTClientDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTClientDataFind_element_user.set(cTClientData);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClip(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$152;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClippathArray(int i, CTClipPath cTClipPath) {
        synchronized (monitor()) {
            check_orphaned();
            CTClipPath cTClipPathFind_element_user = get_store().find_element_user(CLIPPATH$26, i);
            if (cTClipPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTClipPathFind_element_user.set(cTClipPath);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClipPathArr, CLIPPATH$26);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCliptowrap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$150;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setComplex(CTComplex cTComplex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPLEX$46;
            CTComplex cTComplexFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTComplexFind_element_user == null) {
                cTComplexFind_element_user = (CTComplex) get_store().add_element_user(qName);
            }
            cTComplexFind_element_user.set(cTComplex);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setConnectortype(STConnectorType$Enum sTConnectorType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTConnectorType$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$64;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$62;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$108;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$112;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$110;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setDoubleclicknotify(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$76;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setExtrusionArray(int i, CTExtrusion cTExtrusion) {
        synchronized (monitor()) {
            check_orphaned();
            CTExtrusion cTExtrusionFind_element_user = get_store().find_element_user(EXTRUSION$20, i);
            if (cTExtrusionFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTExtrusionFind_element_user.set(cTExtrusion);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTExtrusionArr, EXTRUSION$20);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFillArray(int i, CTFill cTFill) {
        synchronized (monitor()) {
            check_orphaned();
            CTFill cTFillFind_element_user = get_store().find_element_user(FILL$6, i);
            if (cTFillFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFillFind_element_user.set(cTFill);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFillArray(CTFill[] cTFillArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFillArr, FILL$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$120;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFilled(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$118;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setForcedash(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$142;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFormulasArray(int i, CTFormulas cTFormulas) {
        synchronized (monitor()) {
            check_orphaned();
            CTFormulas cTFormulasFind_element_user = get_store().find_element_user(FORMULAS$2, i);
            if (cTFormulasFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFormulasFind_element_user.set(cTFormulas);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFormulasArr, FORMULAS$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHandlesArray(int i, CTHandles cTHandles) {
        synchronized (monitor()) {
            check_orphaned();
            CTHandles cTHandlesFind_element_user = get_store().find_element_user(HANDLES$4, i);
            if (cTHandlesFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHandlesFind_element_user.set(cTHandles);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHandlesArr, HANDLES$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHr(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$84;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHralign(STHrAlign$Enum sTHrAlign$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTHrAlign$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHrnoshade(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$88;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$90;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setHrstd(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$86;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setImagedataArray(int i, CTImageData cTImageData) {
        synchronized (monitor()) {
            check_orphaned();
            CTImageData cTImageDataFind_element_user = get_store().find_element_user(IMAGEDATA$16, i);
            if (cTImageDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTImageDataFind_element_user.set(cTImageData);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTImageDataArr, IMAGEDATA$16);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setInsetpen(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$130;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setLockArray(int i, CTLock cTLock) {
        synchronized (monitor()) {
            check_orphaned();
            CTLock cTLockFind_element_user = get_store().find_element_user(LOCK$24, i);
            if (cTLockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLockFind_element_user.set(cTLock);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLockArr, LOCK$24);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setMaster(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTER$158;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOle(STTrueFalseBlank$Enum sTTrueFalseBlank$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$146;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalseBlank$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOleicon(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$144;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOned(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$72;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$122;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPath2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$156;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPathArray(int i, CTPath cTPath) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath cTPathFind_element_user = get_store().find_element_user(PATH$0, i);
            if (cTPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPathFind_element_user.set(cTPath);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPathArray(CTPath[] cTPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPathArr, PATH$0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPreferrelative(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$148;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setPrint(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$68;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$74;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setShadowArray(int i, CTShadow cTShadow) {
        synchronized (monitor()) {
            check_orphaned();
            CTShadow cTShadowFind_element_user = get_store().find_element_user(SHADOW$10, i);
            if (cTShadowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShadowFind_element_user.set(cTShadow);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setShadowArray(CTShadow[] cTShadowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShadowArr, SHADOW$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine) {
        synchronized (monitor()) {
            check_orphaned();
            CTSignatureLine cTSignatureLineFind_element_user = get_store().find_element_user(SIGNATURELINE$28, i);
            if (cTSignatureLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSignatureLineFind_element_user.set(cTSignatureLine);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSignatureLineArr, SIGNATURELINE$28);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSkewArray(int i, CTSkew cTSkew) {
        synchronized (monitor()) {
            check_orphaned();
            CTSkew cTSkewFind_element_user = get_store().find_element_user(SKEW$18, i);
            if (cTSkewFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSkewFind_element_user.set(cTSkew);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSkewArray(CTSkew[] cTSkewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSkewArr, SKEW$18);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setSpt(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$132;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokeArray(int i, CTStroke cTStroke) {
        synchronized (monitor()) {
            check_orphaned();
            CTStroke cTStrokeFind_element_user = get_store().find_element_user(STROKE$8, i);
            if (cTStrokeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStrokeFind_element_user.set(cTStroke);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStrokeArr, STROKE$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokecolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$126;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStroked(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$124;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStrokeweight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$128;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextboxArray(int i, CTTextbox cTTextbox) {
        synchronized (monitor()) {
            check_orphaned();
            CTTextbox cTTextboxFind_element_user = get_store().find_element_user(TEXTBOX$12, i);
            if (cTTextboxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextboxFind_element_user.set(cTTextbox);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextboxArr, TEXTBOX$12);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextdataArray(int i, CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            CTRel cTRelFind_element_user = get_store().find_element_user(TEXTDATA$44, i);
            if (cTRelFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRelFind_element_user.set(cTRel);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextdataArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRelArr, TEXTDATA$44);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextpathArray(int i, CTTextPath cTTextPath) {
        synchronized (monitor()) {
            check_orphaned();
            CTTextPath cTTextPathFind_element_user = get_store().find_element_user(TEXTPATH$14, i);
            if (cTTextPathFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextPathFind_element_user.set(cTTextPath);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextPathArr, TEXTPATH$14);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$58;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setUserdrawn(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$98;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setUserhidden(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$80;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setWrapArray(int i, CTWrap cTWrap) {
        synchronized (monitor()) {
            check_orphaned();
            CTWrap cTWrapFind_element_user = get_store().find_element_user(WRAP$30, i);
            if (cTWrapFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTWrapFind_element_user.set(cTWrap);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setWrapArray(CTWrap[] cTWrapArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTWrapArr, WRAP$30);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$66;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfAnchorlockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBorderbottomArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBorderleftArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBorderrightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfBordertopArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERTOP$34);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfCalloutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CALLOUT$22);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfClientDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfClippathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIPPATH$26);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfExtrusionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXTRUSION$20);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILL$6);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfFormulasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FORMULAS$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfHandlesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HANDLES$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfImagedataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LOCK$24);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATH$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADOW$10);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfSignaturelineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfSkewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SKEW$18);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfStrokeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STROKE$8);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfTextboxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTBOX$12);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfTextdataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTDATA$44);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfTextpathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTPATH$14);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public int sizeOfWrapArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WRAP$30);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAdj() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJ$154);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$94);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$96);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$60);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$104);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$102);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$106);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$100);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$82);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$78);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$136);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWNORMAL$140);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWPURE$138);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHROMAKEY$116);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$56);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetClip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIP$152);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIPTOWRAP$150);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetComplex() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLEX$46, 0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTORTYPE$134);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$64);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$62);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$108);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$112);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$110);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$76);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$120);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$118);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$142);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$84);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$92);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$52);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$88);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$90);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$86);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$48);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$114);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$130);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetMaster() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MASTER$158);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLE$146);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLEICON$144);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$72);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$122);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetPath2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATH2$156);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVE$148);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$68);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$74);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$70);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetSpt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPT$132);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKECOLOR$126);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStroked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKED$124);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEWEIGHT$128);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$50);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$54);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$58);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$98);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$80);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$66);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetAdj() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ADJ$154);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetAllowincell() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$94);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetAllowoverlap() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$96);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetAlt() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ALT$60);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBorderleftcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$102);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBorderrightcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$106);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetBordertopcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$100);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetBullet() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BULLET$82);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetButton() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BUTTON$78);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode xgetBwmode() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWMODE$136);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode xgetBwnormal() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWNORMAL$140);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STBWMode xgetBwpure() {
        STBWMode sTBWModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBWModeFind_attribute_user = get_store().find_attribute_user(BWPURE$138);
        }
        return sTBWModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STColorType xgetChromakey() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(CHROMAKEY$116);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetClass1() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(CLASS1$56);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetClip() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIP$152);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetCliptowrap() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$150);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STConnectorType xgetConnectortype() {
        STConnectorType sTConnectorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_default_attribute_value(qName);
            }
        }
        return sTConnectorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetCoordorigin() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$64);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetCoordsize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDSIZE$62);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$108);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$112);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$110);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetDoubleclicknotify() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STColorType xgetFillcolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$120);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetFilled() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FILLED$118);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetForcedash() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FORCEDASH$142);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetHr() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HR$84);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STHrAlign xgetHralign() {
        STHrAlign sTHrAlignFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return sTHrAlignFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetHref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(HREF$52);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetHrnoshade() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$88);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(HRPCT$90);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetHrstd() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRSTD$86);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$48);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetInsetpen() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(INSETPEN$130);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetMaster() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(MASTER$158);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalseBlank xgetOle() {
        STTrueFalseBlank sTTrueFalseBlankFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlankFind_attribute_user = get_store().find_attribute_user(OLE$146);
        }
        return sTTrueFalseBlankFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetOleicon() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(OLEICON$144);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetOned() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ONED$72);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetOpacity() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(OPACITY$122);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetPath2() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(PATH2$156);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetPreferrelative() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$148);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetPrint() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PRINT$68);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(REGROUPID$74);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetSpid() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SPID$70);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlFloat xgetSpt() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(SPT$132);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STColorType xgetStrokecolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(STROKECOLOR$126);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public STTrueFalse xgetStroked() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(STROKED$124);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetStrokeweight() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STROKEWEIGHT$128);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLE$50);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetTarget() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TARGET$54);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetTitle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TITLE$58);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetUserdrawn() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERDRAWN$98);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public com.microsoft.schemas.office.office.STTrueFalse xgetUserhidden() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$80);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public XmlString xgetWrapcoords() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$66);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAdj(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$154;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAllowincell(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$94;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAllowoverlap(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$96;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$60;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$104;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$102;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$106;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$100;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBullet(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$82;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetButton(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$78;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBwmode(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$136;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBwnormal(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$140;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetBwpure(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$138;
            STBWMode sTBWModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBWModeFind_attribute_user == null) {
                sTBWModeFind_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            sTBWModeFind_attribute_user.set(sTBWMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetChromakey(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$116;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$56;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetClip(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$152;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetCliptowrap(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$150;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetConnectortype(STConnectorType sTConnectorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            STConnectorType sTConnectorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTConnectorTypeFind_attribute_user == null) {
                sTConnectorTypeFind_attribute_user = (STConnectorType) get_store().add_attribute_user(qName);
            }
            sTConnectorTypeFind_attribute_user.set(sTConnectorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$64;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$62;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$108;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$112;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$110;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetDoubleclicknotify(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$76;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$120;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetFilled(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$118;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetForcedash(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$142;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHr(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$84;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            STHrAlign sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            sTHrAlignFind_attribute_user.set(sTHrAlign);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$52;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHrnoshade(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$88;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$90;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetHrstd(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$86;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$48;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            STInsetMode sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetModeFind_attribute_user.set((XmlObject) sTInsetMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetInsetpen(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$130;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetMaster(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTER$158;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOle(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$146;
            STTrueFalseBlank sTTrueFalseBlankFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseBlankFind_attribute_user == null) {
                sTTrueFalseBlankFind_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            sTTrueFalseBlankFind_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOleicon(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$144;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOned(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$72;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$122;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetPath2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$156;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetPreferrelative(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$148;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetPrint(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$68;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$74;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$70;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetSpt(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$132;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStrokecolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$126;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStroked(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$124;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStrokeweight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$128;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$50;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$54;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$58;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetUserdrawn(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$98;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetUserhidden(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$80;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShapetype
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$66;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
