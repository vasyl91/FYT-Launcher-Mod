package com.microsoft.schemas.vml.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTDiagram;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STHrAlign$Enum;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse$Enum;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTArc;
import com.microsoft.schemas.vml.CTCurve;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImage;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTLine;
import com.microsoft.schemas.vml.CTOval;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTPolyLine;
import com.microsoft.schemas.vml.CTRect;
import com.microsoft.schemas.vml.CTRoundRect;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STEditAs;
import com.microsoft.schemas.vml.STEditAs$Enum;
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
public class CTGroupImpl extends XmlComplexContentImpl implements CTGroup {
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
    private static final QName GROUP$46 = new QName("urn:schemas-microsoft-com:vml", "group");
    private static final QName SHAPE$48 = new QName("urn:schemas-microsoft-com:vml", "shape");
    private static final QName SHAPETYPE$50 = new QName("urn:schemas-microsoft-com:vml", "shapetype");
    private static final QName ARC$52 = new QName("urn:schemas-microsoft-com:vml", "arc");
    private static final QName CURVE$54 = new QName("urn:schemas-microsoft-com:vml", "curve");
    private static final QName IMAGE$56 = new QName("urn:schemas-microsoft-com:vml", "image");
    private static final QName LINE$58 = new QName("urn:schemas-microsoft-com:vml", "line");
    private static final QName OVAL$60 = new QName("urn:schemas-microsoft-com:vml", "oval");
    private static final QName POLYLINE$62 = new QName("urn:schemas-microsoft-com:vml", "polyline");
    private static final QName RECT$64 = new QName("urn:schemas-microsoft-com:vml", "rect");
    private static final QName ROUNDRECT$66 = new QName("urn:schemas-microsoft-com:vml", "roundrect");
    private static final QName DIAGRAM$68 = new QName("urn:schemas-microsoft-com:office:office", "diagram");
    private static final QName ID$70 = new QName(FinalChip.BSP_PLATFORM_Null, "id");
    private static final QName STYLE$72 = new QName(FinalChip.BSP_PLATFORM_Null, "style");
    private static final QName HREF$74 = new QName(FinalChip.BSP_PLATFORM_Null, "href");
    private static final QName TARGET$76 = new QName(FinalChip.BSP_PLATFORM_Null, "target");
    private static final QName CLASS1$78 = new QName(FinalChip.BSP_PLATFORM_Null, "class");
    private static final QName TITLE$80 = new QName(FinalChip.BSP_PLATFORM_Null, "title");
    private static final QName ALT$82 = new QName(FinalChip.BSP_PLATFORM_Null, "alt");
    private static final QName COORDSIZE$84 = new QName(FinalChip.BSP_PLATFORM_Null, "coordsize");
    private static final QName COORDORIGIN$86 = new QName(FinalChip.BSP_PLATFORM_Null, "coordorigin");
    private static final QName WRAPCOORDS$88 = new QName(FinalChip.BSP_PLATFORM_Null, "wrapcoords");
    private static final QName PRINT$90 = new QName(FinalChip.BSP_PLATFORM_Null, "print");
    private static final QName SPID$92 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$94 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$96 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$98 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$100 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$102 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$104 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$106 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$108 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$110 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$112 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$114 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$116 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$118 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$120 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$122 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$124 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$126 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$128 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$130 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$132 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$134 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$136 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName FILLED$138 = new QName(FinalChip.BSP_PLATFORM_Null, "filled");
    private static final QName FILLCOLOR$140 = new QName(FinalChip.BSP_PLATFORM_Null, "fillcolor");
    private static final QName EDITAS$142 = new QName(FinalChip.BSP_PLATFORM_Null, "editas");
    private static final QName TABLEPROPERTIES$144 = new QName("urn:schemas-microsoft-com:office:office", "tableproperties");
    private static final QName TABLELIMITS$146 = new QName("urn:schemas-microsoft-com:office:office", "tablelimits");

    public CTGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock cTAnchorLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockAdd_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return cTAnchorLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc addNewArc() {
        CTArc cTArcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArcAdd_element_user = get_store().add_element_user(ARC$52);
        }
        return cTArcAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBorderbottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBorderleft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBorderright() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBordertop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCallout addNewCallout() {
        CTCallout cTCalloutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutAdd_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return cTCalloutAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClientData addNewClientData() {
        CTClientData cTClientDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataAdd_element_user = get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClipPath addNewClippath() {
        CTClipPath cTClipPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathAdd_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return cTClipPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve addNewCurve() {
        CTCurve cTCurveAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCurveAdd_element_user = get_store().add_element_user(CURVE$54);
        }
        return cTCurveAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram addNewDiagram() {
        CTDiagram cTDiagramAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDiagramAdd_element_user = get_store().add_element_user(DIAGRAM$68);
        }
        return cTDiagramAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTExtrusion addNewExtrusion() {
        CTExtrusion cTExtrusionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionAdd_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return cTExtrusionAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFill addNewFill() {
        CTFill cTFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillAdd_element_user = get_store().add_element_user(FILL$6);
        }
        return cTFillAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulasAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasAdd_element_user = get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulasAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup addNewGroup() {
        CTGroup cTGroupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupAdd_element_user = get_store().add_element_user(GROUP$46);
        }
        return cTGroupAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTHandles addNewHandles() {
        CTHandles cTHandlesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesAdd_element_user = get_store().add_element_user(HANDLES$4);
        }
        return cTHandlesAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage addNewImage() {
        CTImage cTImageAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageAdd_element_user = get_store().add_element_user(IMAGE$56);
        }
        return cTImageAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImageData addNewImagedata() {
        CTImageData cTImageDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataAdd_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return cTImageDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine addNewLine() {
        CTLine cTLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineAdd_element_user = get_store().add_element_user(LINE$58);
        }
        return cTLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLock addNewLock() {
        CTLock cTLockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockAdd_element_user = get_store().add_element_user(LOCK$24);
        }
        return cTLockAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval addNewOval() {
        CTOval cTOvalAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOvalAdd_element_user = get_store().add_element_user(OVAL$60);
        }
        return cTOvalAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPath addNewPath() {
        CTPath cTPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathAdd_element_user = get_store().add_element_user(PATH$0);
        }
        return cTPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine addNewPolyline() {
        CTPolyLine cTPolyLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolyLineAdd_element_user = get_store().add_element_user(POLYLINE$62);
        }
        return cTPolyLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect addNewRect() {
        CTRect cTRectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRectAdd_element_user = get_store().add_element_user(RECT$64);
        }
        return cTRectAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect addNewRoundrect() {
        CTRoundRect cTRoundRectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRoundRectAdd_element_user = get_store().add_element_user(ROUNDRECT$66);
        }
        return cTRoundRectAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShadow addNewShadow() {
        CTShadow cTShadowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowAdd_element_user = get_store().add_element_user(SHADOW$10);
        }
        return cTShadowAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape addNewShape() {
        CTShape cTShapeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeAdd_element_user = get_store().add_element_user(SHAPE$48);
        }
        return cTShapeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype addNewShapetype() {
        CTShapetype cTShapetypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetypeAdd_element_user = get_store().add_element_user(SHAPETYPE$50);
        }
        return cTShapetypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine cTSignatureLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineAdd_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return cTSignatureLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSkew addNewSkew() {
        CTSkew cTSkewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewAdd_element_user = get_store().add_element_user(SKEW$18);
        }
        return cTSkewAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTStroke addNewStroke() {
        CTStroke cTStrokeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeAdd_element_user = get_store().add_element_user(STROKE$8);
        }
        return cTStrokeAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextboxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxAdd_element_user = get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextboxAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRel addNewTextdata() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return cTRelAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathAdd_element_user = get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTWrap addNewWrap() {
        CTWrap cTWrapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapAdd_element_user = get_store().add_element_user(WRAP$30);
        }
        return cTWrapAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$116);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$118);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALT$82);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTAnchorLock> getAnchorlockList() {
        1AnchorlockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorlockList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc getArcArray(int i) {
        CTArc cTArcFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArcFind_element_user = get_store().find_element_user(ARC$52, i);
            if (cTArcFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTArcFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc[] getArcArray() {
        CTArc[] cTArcArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ARC$52, arrayList);
            cTArcArr = new CTArc[arrayList.size()];
            arrayList.toArray(cTArcArr);
        }
        return cTArcArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTArc> getArcList() {
        1ArcList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ArcList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBorderbottomList() {
        1BorderbottomList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderbottomList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBorderleftList() {
        1BorderleftList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderleftList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$124);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBorderrightList() {
        1BorderrightList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderrightList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBordertopList() {
        1BordertopList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BordertopList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$122);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BULLET$104);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BUTTON$100);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTCallout> getCalloutList() {
        1CalloutList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalloutList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CLASS1$78);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTClientData> getClientDataList() {
        1ClientDataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClientDataList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTClipPath> getClippathList() {
        1ClippathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClippathList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$86);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COORDSIZE$84);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve getCurveArray(int i) {
        CTCurve cTCurveFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCurveFind_element_user = get_store().find_element_user(CURVE$54, i);
            if (cTCurveFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCurveFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve[] getCurveArray() {
        CTCurve[] cTCurveArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CURVE$54, arrayList);
            cTCurveArr = new CTCurve[arrayList.size()];
            arrayList.toArray(cTCurveArr);
        }
        return cTCurveArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTCurve> getCurveList() {
        1CurveList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CurveList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$130);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$134);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$132);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram getDiagramArray(int i) {
        CTDiagram cTDiagramFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDiagramFind_element_user = get_store().find_element_user(DIAGRAM$68, i);
            if (cTDiagramFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDiagramFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram[] getDiagramArray() {
        CTDiagram[] cTDiagramArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DIAGRAM$68, arrayList);
            cTDiagramArr = new CTDiagram[arrayList.size()];
            arrayList.toArray(cTDiagramArr);
        }
        return cTDiagramArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTDiagram> getDiagramList() {
        1DiagramList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DiagramList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STEditAs$Enum getEditas() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EDITAS$142);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STEditAs$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTExtrusion> getExtrusionList() {
        1ExtrusionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtrusionList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTFill> getFillList() {
        1FillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FillList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$140);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLED$138);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTFormulas> getFormulasList() {
        1FormulasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FormulasList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup getGroupArray(int i) {
        CTGroup cTGroupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFind_element_user = get_store().find_element_user(GROUP$46, i);
            if (cTGroupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGroupFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup[] getGroupArray() {
        CTGroup[] cTGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUP$46, arrayList);
            cTGroupArr = new CTGroup[arrayList.size()];
            arrayList.toArray(cTGroupArr);
        }
        return cTGroupArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTGroup> getGroupList() {
        1GroupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GroupList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTHandles> getHandlesList() {
        1HandlesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HandlesList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HR$106);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STHrAlign$Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HREF$74);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$110);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRPCT$112);
            if (simpleValueFind_attribute_user == null) {
                return 0.0f;
            }
            return simpleValueFind_attribute_user.getFloatValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HRSTD$108);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$70);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage getImageArray(int i) {
        CTImage cTImageFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageFind_element_user = get_store().find_element_user(IMAGE$56, i);
            if (cTImageFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTImageFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage[] getImageArray() {
        CTImage[] cTImageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(IMAGE$56, arrayList);
            cTImageArr = new CTImage[arrayList.size()];
            arrayList.toArray(cTImageArr);
        }
        return cTImageArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTImage> getImageList() {
        1ImageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImageList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTImageData> getImagedataList() {
        1ImagedataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImagedataList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine getLineArray(int i) {
        CTLine cTLineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineFind_element_user = get_store().find_element_user(LINE$58, i);
            if (cTLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLineFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine[] getLineArray() {
        CTLine[] cTLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LINE$58, arrayList);
            cTLineArr = new CTLine[arrayList.size()];
            arrayList.toArray(cTLineArr);
        }
        return cTLineArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTLine> getLineList() {
        1LineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LineList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ONED$94);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval getOvalArray(int i) {
        CTOval cTOvalFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOvalFind_element_user = get_store().find_element_user(OVAL$60, i);
            if (cTOvalFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOvalFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval[] getOvalArray() {
        CTOval[] cTOvalArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OVAL$60, arrayList);
            cTOvalArr = new CTOval[arrayList.size()];
            arrayList.toArray(cTOvalArr);
        }
        return cTOvalArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTOval> getOvalList() {
        1OvalList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OvalList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTPath> getPathList() {
        1PathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PathList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine getPolylineArray(int i) {
        CTPolyLine cTPolyLineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolyLineFind_element_user = get_store().find_element_user(POLYLINE$62, i);
            if (cTPolyLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPolyLineFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine[] getPolylineArray() {
        CTPolyLine[] cTPolyLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(POLYLINE$62, arrayList);
            cTPolyLineArr = new CTPolyLine[arrayList.size()];
            arrayList.toArray(cTPolyLineArr);
        }
        return cTPolyLineArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTPolyLine> getPolylineList() {
        1PolylineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PolylineList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PRINT$90);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect getRectArray(int i) {
        CTRect cTRectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRectFind_element_user = get_store().find_element_user(RECT$64, i);
            if (cTRectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRectFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect[] getRectArray() {
        CTRect[] cTRectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RECT$64, arrayList);
            cTRectArr = new CTRect[arrayList.size()];
            arrayList.toArray(cTRectArr);
        }
        return cTRectArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTRect> getRectList() {
        1RectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RectList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REGROUPID$96);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect getRoundrectArray(int i) {
        CTRoundRect cTRoundRectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRoundRectFind_element_user = get_store().find_element_user(ROUNDRECT$66, i);
            if (cTRoundRectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRoundRectFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect[] getRoundrectArray() {
        CTRoundRect[] cTRoundRectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROUNDRECT$66, arrayList);
            cTRoundRectArr = new CTRoundRect[arrayList.size()];
            arrayList.toArray(cTRoundRectArr);
        }
        return cTRoundRectArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTRoundRect> getRoundrectList() {
        1RoundrectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RoundrectList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTShadow> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape getShapeArray(int i) {
        CTShape cTShapeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeFind_element_user = get_store().find_element_user(SHAPE$48, i);
            if (cTShapeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShapeFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape[] getShapeArray() {
        CTShape[] cTShapeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHAPE$48, arrayList);
            cTShapeArr = new CTShape[arrayList.size()];
            arrayList.toArray(cTShapeArr);
        }
        return cTShapeArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTShape> getShapeList() {
        1ShapeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShapeList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype getShapetypeArray(int i) {
        CTShapetype cTShapetypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetypeFind_element_user = get_store().find_element_user(SHAPETYPE$50, i);
            if (cTShapetypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShapetypeFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype[] getShapetypeArray() {
        CTShapetype[] cTShapetypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHAPETYPE$50, arrayList);
            cTShapetypeArr = new CTShapetype[arrayList.size()];
            arrayList.toArray(cTShapetypeArr);
        }
        return cTShapetypeArr;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTShapetype> getShapetypeList() {
        1ShapetypeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShapetypeList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTSignatureLine> getSignaturelineList() {
        1SignaturelineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SignaturelineList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTSkew> getSkewList() {
        1SkewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SkewList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPID$92);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTStroke> getStrokeList() {
        1StrokeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrokeList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLE$72);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTablelimits() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TABLELIMITS$146);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTableproperties() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TABLEPROPERTIES$144);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGET$76);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTTextbox> getTextboxList() {
        1TextboxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextboxList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTRel> getTextdataList() {
        1TextdataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextdataList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTTextPath> getTextpathList() {
        1TextpathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextpathList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TITLE$80);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERDRAWN$120);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse$Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$102);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTWrap> getWrapList() {
        1WrapList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WrapList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$88);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock cTAnchorLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLockInsert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return cTAnchorLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc insertNewArc(int i) {
        CTArc cTArcInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArcInsert_element_user = get_store().insert_element_user(ARC$52, i);
        }
        return cTArcInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBorderleft(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBorderright(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBordertop(int i) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCallout insertNewCallout(int i) {
        CTCallout cTCalloutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutInsert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return cTCalloutInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClientDataInsert_element_user = get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClipPath insertNewClippath(int i) {
        CTClipPath cTClipPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathInsert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return cTClipPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve insertNewCurve(int i) {
        CTCurve cTCurveInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCurveInsert_element_user = get_store().insert_element_user(CURVE$54, i);
        }
        return cTCurveInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram insertNewDiagram(int i) {
        CTDiagram cTDiagramInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDiagramInsert_element_user = get_store().insert_element_user(DIAGRAM$68, i);
        }
        return cTDiagramInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion cTExtrusionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionInsert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return cTExtrusionInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFill insertNewFill(int i) {
        CTFill cTFillInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillInsert_element_user = get_store().insert_element_user(FILL$6, i);
        }
        return cTFillInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulasInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulasInsert_element_user = get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulasInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup insertNewGroup(int i) {
        CTGroup cTGroupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupInsert_element_user = get_store().insert_element_user(GROUP$46, i);
        }
        return cTGroupInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandlesInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHandlesInsert_element_user = get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandlesInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage insertNewImage(int i) {
        CTImage cTImageInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageInsert_element_user = get_store().insert_element_user(IMAGE$56, i);
        }
        return cTImageInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImageData insertNewImagedata(int i) {
        CTImageData cTImageDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageDataInsert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return cTImageDataInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine insertNewLine(int i) {
        CTLine cTLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineInsert_element_user = get_store().insert_element_user(LINE$58, i);
        }
        return cTLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLock insertNewLock(int i) {
        CTLock cTLockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLockInsert_element_user = get_store().insert_element_user(LOCK$24, i);
        }
        return cTLockInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval insertNewOval(int i) {
        CTOval cTOvalInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOvalInsert_element_user = get_store().insert_element_user(OVAL$60, i);
        }
        return cTOvalInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPath insertNewPath(int i) {
        CTPath cTPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPathInsert_element_user = get_store().insert_element_user(PATH$0, i);
        }
        return cTPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine insertNewPolyline(int i) {
        CTPolyLine cTPolyLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolyLineInsert_element_user = get_store().insert_element_user(POLYLINE$62, i);
        }
        return cTPolyLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect insertNewRect(int i) {
        CTRect cTRectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRectInsert_element_user = get_store().insert_element_user(RECT$64, i);
        }
        return cTRectInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect insertNewRoundrect(int i) {
        CTRoundRect cTRoundRectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRoundRectInsert_element_user = get_store().insert_element_user(ROUNDRECT$66, i);
        }
        return cTRoundRectInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShadowInsert_element_user = get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadowInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape insertNewShape(int i) {
        CTShape cTShapeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeInsert_element_user = get_store().insert_element_user(SHAPE$48, i);
        }
        return cTShapeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype insertNewShapetype(int i) {
        CTShapetype cTShapetypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetypeInsert_element_user = get_store().insert_element_user(SHAPETYPE$50, i);
        }
        return cTShapetypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine cTSignatureLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLineInsert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return cTSignatureLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSkew insertNewSkew(int i) {
        CTSkew cTSkewInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewInsert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return cTSkewInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStrokeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStrokeInsert_element_user = get_store().insert_element_user(STROKE$8, i);
        }
        return cTStrokeInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextboxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextboxInsert_element_user = get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextboxInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRel insertNewTextdata(int i) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return cTRelInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPathInsert_element_user = get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTWrap insertNewWrap(int i) {
        CTWrap cTWrapInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapInsert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return cTWrapInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$116) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$118) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$82) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$126) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$124) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$128) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$122) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$104) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$100) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$78) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$86) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$84) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$130) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$134) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$132) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$98) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetEditas() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EDITAS$142) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$140) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$138) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$106) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$114) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$74) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$110) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$112) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$108) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$70) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$136) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$94) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$90) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$96) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$92) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$72) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTablelimits() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TABLELIMITS$146) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTableproperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TABLEPROPERTIES$144) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$76) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$80) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$120) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$102) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$88) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeArc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARC$52, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeCurve(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CURVE$54, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeDiagram(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIAGRAM$68, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$46, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeImage(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGE$56, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeLine(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINE$58, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeOval(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVAL$60, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removePolyline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(POLYLINE$62, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeRect(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RECT$64, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeRoundrect(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROUNDRECT$66, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeShape(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAPE$48, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeShapetype(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAPETYPE$50, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAllowincell(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$116;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAllowoverlap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$118;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$82;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAnchorLockArr, ANCHORLOCK$32);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setArcArray(int i, CTArc cTArc) {
        synchronized (monitor()) {
            check_orphaned();
            CTArc cTArcFind_element_user = get_store().find_element_user(ARC$52, i);
            if (cTArcFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTArcFind_element_user.set(cTArc);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setArcArray(CTArc[] cTArcArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTArcArr, ARC$52);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERBOTTOM$36);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$126;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERLEFT$38);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$124;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERRIGHT$40);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$128;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderArr, BORDERTOP$34);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$122;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBullet(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$104;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setButton(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$100;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCalloutArr, CALLOUT$22);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$78;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClipPathArr, CLIPPATH$26);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$86;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$84;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCurveArray(int i, CTCurve cTCurve) {
        synchronized (monitor()) {
            check_orphaned();
            CTCurve cTCurveFind_element_user = get_store().find_element_user(CURVE$54, i);
            if (cTCurveFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCurveFind_element_user.set(cTCurve);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCurveArray(CTCurve[] cTCurveArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCurveArr, CURVE$54);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$130;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$134;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$132;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDiagramArray(int i, CTDiagram cTDiagram) {
        synchronized (monitor()) {
            check_orphaned();
            CTDiagram cTDiagramFind_element_user = get_store().find_element_user(DIAGRAM$68, i);
            if (cTDiagramFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDiagramFind_element_user.set(cTDiagram);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDiagramArray(CTDiagram[] cTDiagramArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDiagramArr, DIAGRAM$68);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDoubleclicknotify(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$98;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setEditas(STEditAs$Enum sTEditAs$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$142;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTEditAs$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTExtrusionArr, EXTRUSION$20);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFillArray(CTFill[] cTFillArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFillArr, FILL$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$140;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFilled(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$138;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFormulasArr, FORMULAS$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setGroupArray(int i, CTGroup cTGroup) {
        synchronized (monitor()) {
            check_orphaned();
            CTGroup cTGroupFind_element_user = get_store().find_element_user(GROUP$46, i);
            if (cTGroupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGroupFind_element_user.set(cTGroup);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setGroupArray(CTGroup[] cTGroupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGroupArr, GROUP$46);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHandlesArr, HANDLES$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHr(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$106;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHralign(STHrAlign$Enum sTHrAlign$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTHrAlign$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$74;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHrnoshade(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$110;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$112;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setFloatValue(f);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHrstd(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$108;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$70;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImageArray(int i, CTImage cTImage) {
        synchronized (monitor()) {
            check_orphaned();
            CTImage cTImageFind_element_user = get_store().find_element_user(IMAGE$56, i);
            if (cTImageFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTImageFind_element_user.set(cTImage);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImageArray(CTImage[] cTImageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTImageArr, IMAGE$56);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTImageDataArr, IMAGEDATA$16);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLineArray(int i, CTLine cTLine) {
        synchronized (monitor()) {
            check_orphaned();
            CTLine cTLineFind_element_user = get_store().find_element_user(LINE$58, i);
            if (cTLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLineFind_element_user.set(cTLine);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLineArray(CTLine[] cTLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLineArr, LINE$58);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLockArr, LOCK$24);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setOned(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$94;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setOvalArray(int i, CTOval cTOval) {
        synchronized (monitor()) {
            check_orphaned();
            CTOval cTOvalFind_element_user = get_store().find_element_user(OVAL$60, i);
            if (cTOvalFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOvalFind_element_user.set(cTOval);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setOvalArray(CTOval[] cTOvalArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOvalArr, OVAL$60);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPathArray(CTPath[] cTPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPathArr, PATH$0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPolylineArray(int i, CTPolyLine cTPolyLine) {
        synchronized (monitor()) {
            check_orphaned();
            CTPolyLine cTPolyLineFind_element_user = get_store().find_element_user(POLYLINE$62, i);
            if (cTPolyLineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPolyLineFind_element_user.set(cTPolyLine);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPolylineArray(CTPolyLine[] cTPolyLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPolyLineArr, POLYLINE$62);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPrint(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$90;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRectArray(int i, CTRect cTRect) {
        synchronized (monitor()) {
            check_orphaned();
            CTRect cTRectFind_element_user = get_store().find_element_user(RECT$64, i);
            if (cTRectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRectFind_element_user.set(cTRect);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRectArray(CTRect[] cTRectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRectArr, RECT$64);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$96;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRoundrectArray(int i, CTRoundRect cTRoundRect) {
        synchronized (monitor()) {
            check_orphaned();
            CTRoundRect cTRoundRectFind_element_user = get_store().find_element_user(ROUNDRECT$66, i);
            if (cTRoundRectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRoundRectFind_element_user.set(cTRoundRect);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRoundrectArray(CTRoundRect[] cTRoundRectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRoundRectArr, ROUNDRECT$66);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShadowArray(CTShadow[] cTShadowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShadowArr, SHADOW$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapeArray(int i, CTShape cTShape) {
        synchronized (monitor()) {
            check_orphaned();
            CTShape cTShapeFind_element_user = get_store().find_element_user(SHAPE$48, i);
            if (cTShapeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShapeFind_element_user.set(cTShape);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapeArray(CTShape[] cTShapeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShapeArr, SHAPE$48);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapetypeArray(int i, CTShapetype cTShapetype) {
        synchronized (monitor()) {
            check_orphaned();
            CTShapetype cTShapetypeFind_element_user = get_store().find_element_user(SHAPETYPE$50, i);
            if (cTShapetypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShapetypeFind_element_user.set(cTShapetype);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapetypeArray(CTShapetype[] cTShapetypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShapetypeArr, SHAPETYPE$50);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSignatureLineArr, SIGNATURELINE$28);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSkewArray(CTSkew[] cTSkewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSkewArr, SKEW$18);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$92;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStrokeArr, STROKE$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$72;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTablelimits(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLELIMITS$146;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTableproperties(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLEPROPERTIES$144;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$76;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextboxArr, TEXTBOX$12);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextdataArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRelArr, TEXTDATA$44);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextPathArr, TEXTPATH$14);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$80;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setUserdrawn(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$120;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setUserhidden(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$102;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
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

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setWrapArray(CTWrap[] cTWrapArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTWrapArr, WRAP$30);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$88;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfAnchorlockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfArcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ARC$52);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBorderbottomArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBorderleftArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBorderrightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBordertopArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERTOP$34);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfCalloutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CALLOUT$22);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfClientDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfClippathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLIPPATH$26);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfCurveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CURVE$54);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfDiagramArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DIAGRAM$68);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfExtrusionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXTRUSION$20);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILL$6);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfFormulasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FORMULAS$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GROUP$46);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfHandlesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HANDLES$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfImageArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IMAGE$56);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfImagedataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfLineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LINE$58);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LOCK$24);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfOvalArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OVAL$60);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATH$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfPolylineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(POLYLINE$62);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfRectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RECT$64);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfRoundrectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ROUNDRECT$66);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADOW$10);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfShapeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHAPE$48);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfShapetypeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHAPETYPE$50);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfSignaturelineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfSkewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SKEW$18);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfStrokeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STROKE$8);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfTextboxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTBOX$12);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfTextdataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTDATA$44);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfTextpathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTPATH$14);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfWrapArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(WRAP$30);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$116);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$118);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$82);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$126);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$124);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$128);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$122);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$104);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$100);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$78);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$86);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$84);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$130);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$134);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$132);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$98);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetEditas() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EDITAS$142);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$140);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$138);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$106);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$114);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$74);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$110);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$112);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$108);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$70);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$136);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$94);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$90);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$96);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$92);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$72);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTablelimits() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TABLELIMITS$146);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTableproperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TABLEPROPERTIES$144);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$76);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$80);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$120);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$102);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$88);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetAllowincell() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWINCELL$116);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetAllowoverlap() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$118);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetAlt() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ALT$82);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBorderleftcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERLEFTCOLOR$124);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBorderrightcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBordertopcolor() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BORDERTOPCOLOR$122);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetBullet() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BULLET$104);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetButton() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(BUTTON$100);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetClass1() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(CLASS1$78);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetCoordorigin() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDORIGIN$86);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetCoordsize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COORDSIZE$84);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUT$130);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMLAYOUTMRU$134);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(DGMNODEKIND$132);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetDoubleclicknotify() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STEditAs xgetEditas() {
        STEditAs sTEditAsFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTEditAsFind_attribute_user = get_store().find_attribute_user(EDITAS$142);
        }
        return sTEditAsFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STColorType xgetFillcolor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(FILLCOLOR$140);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetFilled() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FILLED$138);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetHr() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HR$106);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STHrAlign xgetHralign() {
        STHrAlign sTHrAlignFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return sTHrAlignFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetHref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(HREF$74);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetHrnoshade() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRNOSHADE$110);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloatFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloatFind_attribute_user = get_store().find_attribute_user(HRPCT$112);
        }
        return xmlFloatFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetHrstd() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(HRSTD$108);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$70);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetOned() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ONED$94);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetPrint() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(PRINT$90);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_attribute_user = get_store().find_attribute_user(REGROUPID$96);
        }
        return xmlIntegerFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetSpid() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SPID$92);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLE$72);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTablelimits() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TABLELIMITS$146);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTableproperties() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TABLEPROPERTIES$144);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTarget() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TARGET$76);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTitle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TITLE$80);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetUserdrawn() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERDRAWN$120);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public com.microsoft.schemas.office.office.STTrueFalse xgetUserhidden() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(USERHIDDEN$102);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetWrapcoords() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(WRAPCOORDS$88);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetAllowincell(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$116;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetAllowoverlap(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$118;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$82;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$126;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$124;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$128;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$122;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBullet(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$104;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetButton(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$100;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$78;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$86;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$84;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$130;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$134;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$132;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDoubleclicknotify(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$98;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetEditas(STEditAs sTEditAs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$142;
            STEditAs sTEditAsFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTEditAsFind_attribute_user == null) {
                sTEditAsFind_attribute_user = (STEditAs) get_store().add_attribute_user(qName);
            }
            sTEditAsFind_attribute_user.set(sTEditAs);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$140;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetFilled(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$138;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHr(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$106;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            STHrAlign sTHrAlignFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHrAlignFind_attribute_user == null) {
                sTHrAlignFind_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            sTHrAlignFind_attribute_user.set(sTHrAlign);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$74;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHrnoshade(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$110;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$112;
            XmlFloat xmlFloatFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlFloatFind_attribute_user == null) {
                xmlFloatFind_attribute_user = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloatFind_attribute_user.set(xmlFloat);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHrstd(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$108;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$70;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            STInsetMode sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTInsetModeFind_attribute_user == null) {
                sTInsetModeFind_attribute_user = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetModeFind_attribute_user.set((XmlObject) sTInsetMode);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetOned(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$94;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetPrint(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$90;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$96;
            XmlInteger xmlIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntegerFind_attribute_user == null) {
                xmlIntegerFind_attribute_user = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlIntegerFind_attribute_user.set(xmlInteger);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$92;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$72;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTablelimits(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLELIMITS$146;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTableproperties(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLEPROPERTIES$144;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$76;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$80;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetUserdrawn(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$120;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetUserhidden(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$102;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$88;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
