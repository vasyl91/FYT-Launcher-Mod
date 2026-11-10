package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.Notes;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.NotImplemented;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSLFSlide extends XSLFSheet implements Slide<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private XSLFComments _comments;
    private XSLFSlideLayout _layout;
    private XSLFNotes _notes;
    private final CTSlide _slide;

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getDisplayPlaceholder(Placeholder placeholder) {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getFollowMasterBackground() {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getFollowMasterColourScheme() {
        return false;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "sld";
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    @NotImplemented
    public void setNotes(Notes<XSLFShape, XSLFTextParagraph> notes) {
    }

    XSLFSlide() {
        CTSlide cTSlidePrototype = prototype();
        this._slide = cTSlidePrototype;
        setCommonSlideData(cTSlidePrototype.getCSld());
    }

    XSLFSlide(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        try {
            CTSlide sld = SldDocument.Factory.parse(DocumentHelper.readDocument(getPackagePart().getInputStream()), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSld();
            this._slide = sld;
            setCommonSlideData(sld.getCSld());
        } catch (SAXException e) {
            throw new IOException(e);
        }
    }

    private static CTSlide prototype() {
        CTSlide cTSlideNewInstance = CTSlide.Factory.newInstance();
        CTGroupShape cTGroupShapeAddNewSpTree = cTSlideNewInstance.addNewCSld().addNewSpTree();
        CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeAddNewSpTree.addNewNvGrpSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
        cTNonVisualDrawingPropsAddNewCNvPr.setName("");
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvGrpSpPr();
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewNvPr();
        CTGroupTransform2D cTGroupTransform2DAddNewXfrm = cTGroupShapeAddNewSpTree.addNewGrpSpPr().addNewXfrm();
        CTPoint2D cTPoint2DAddNewOff = cTGroupTransform2DAddNewXfrm.addNewOff();
        cTPoint2DAddNewOff.setX(0L);
        cTPoint2DAddNewOff.setY(0L);
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTGroupTransform2DAddNewXfrm.addNewExt();
        cTPositiveSize2DAddNewExt.setCx(0L);
        cTPositiveSize2DAddNewExt.setCy(0L);
        CTPoint2D cTPoint2DAddNewChOff = cTGroupTransform2DAddNewXfrm.addNewChOff();
        cTPoint2DAddNewChOff.setX(0L);
        cTPoint2DAddNewChOff.setY(0L);
        CTPositiveSize2D cTPositiveSize2DAddNewChExt = cTGroupTransform2DAddNewXfrm.addNewChExt();
        cTPositiveSize2DAddNewChExt.setCx(0L);
        cTPositiveSize2DAddNewChExt.setCy(0L);
        cTSlideNewInstance.addNewClrMapOvr().addNewMasterClrMapping();
        return cTSlideNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTSlide getXmlObject() {
        return this._slide;
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFSlideLayout getMasterSheet() {
        return getSlideLayout();
    }

    public XSLFSlideLayout getSlideLayout() {
        if (this._layout == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                    this._layout = (XSLFSlideLayout) pOIXMLDocumentPart;
                }
            }
        }
        XSLFSlideLayout xSLFSlideLayout = this._layout;
        if (xSLFSlideLayout != null) {
            return xSLFSlideLayout;
        }
        throw new IllegalArgumentException("SlideLayout was not found for " + this);
    }

    public XSLFSlideMaster getSlideMaster() {
        return getSlideLayout().getSlideMaster();
    }

    public XSLFComments getComments() {
        if (this._comments == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFComments) {
                    this._comments = (XSLFComments) pOIXMLDocumentPart;
                }
            }
        }
        XSLFComments xSLFComments = this._comments;
        if (xSLFComments == null) {
            return null;
        }
        return xSLFComments;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public XSLFNotes getNotes() {
        if (this._notes == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFNotes) {
                    this._notes = (XSLFNotes) pOIXMLDocumentPart;
                }
            }
        }
        XSLFNotes xSLFNotes = this._notes;
        if (xSLFNotes == null) {
            return null;
        }
        return xSLFNotes;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public String getTitle() {
        XSLFTextShape textShapeByType = getTextShapeByType(Placeholder.TITLE);
        if (textShapeByType == null) {
            return null;
        }
        return textShapeByType.getText();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getSlideLayout().getSlideMaster().getTheme();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._slide.getCSld().getBg();
        if (bg != null) {
            return new XSLFBackground(bg, this);
        }
        return getMasterSheet().getBackground();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public boolean getFollowMasterGraphics() {
        return this._slide.getShowMasterSp();
    }

    public void setFollowMasterGraphics(boolean z) {
        this._slide.setShowMasterSp(z);
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getFollowMasterObjects() {
        return getFollowMasterGraphics();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public void setFollowMasterObjects(boolean z) {
        setFollowMasterGraphics(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFSlide importContent(XSLFSheet xSLFSheet) {
        CTBackground bg;
        super.importContent(xSLFSheet);
        if (!(xSLFSheet instanceof XSLFSlide) || (bg = ((XSLFSlide) xSLFSheet)._slide.getCSld().getBg()) == null) {
            return this;
        }
        CTBackground bg2 = this._slide.getCSld().getBg();
        if (bg2 != null) {
            if (bg2.isSetBgPr() && bg2.getBgPr().isSetBlipFill()) {
                removeRelation(getRelationById(bg2.getBgPr().getBlipFill().getBlip().getEmbed()));
            }
            this._slide.getCSld().unsetBg();
        }
        CTBackground cTBackground = this._slide.getCSld().addNewBg().set(bg);
        if (bg.isSetBgPr() && bg.getBgPr().isSetBlipFill()) {
            cTBackground.getBgPr().getBlipFill().getBlip().setEmbed(importBlip(bg.getBgPr().getBlipFill().getBlip().getEmbed(), xSLFSheet.getPackagePart()));
        }
        return this;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    @NotImplemented
    public void setFollowMasterBackground(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    @NotImplemented
    public void setFollowMasterColourScheme(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public int getSlideNumber() {
        int iIndexOf = getSlideShow().getSlides().indexOf(this);
        return iIndexOf == -1 ? iIndexOf : iIndexOf + 1;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public void draw(Graphics2D graphics2D) {
        DrawFactory.getInstance(graphics2D).getDrawable((Slide<?, ?>) this).draw(graphics2D);
    }
}
