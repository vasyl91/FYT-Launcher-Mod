package org.apache.poi.xslf.extractor;

import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFCommentAuthors;
import org.apache.poi.xslf.usermodel.XSLFComments;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFShapeContainer;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFPowerPointExtractor extends POIXMLTextExtractor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final XSLFRelation[] SUPPORTED_TYPES = {XSLFRelation.MAIN, XSLFRelation.MACRO, XSLFRelation.MACRO_TEMPLATE, XSLFRelation.PRESENTATIONML, XSLFRelation.PRESENTATIONML_TEMPLATE, XSLFRelation.PRESENTATION_MACRO};
    private boolean masterByDefault;
    private boolean notesByDefault;
    private boolean slidesByDefault;
    private XMLSlideShow slideshow;

    public XSLFPowerPointExtractor(XMLSlideShow xMLSlideShow) {
        super(xMLSlideShow);
        this.slidesByDefault = true;
        this.notesByDefault = false;
        this.masterByDefault = false;
        this.slideshow = xMLSlideShow;
    }

    public XSLFPowerPointExtractor(XSLFSlideShow xSLFSlideShow) throws XmlException, IOException {
        this(new XMLSlideShow(xSLFSlideShow.getPackage()));
    }

    public XSLFPowerPointExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        this(new XSLFSlideShow(oPCPackage));
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSLFPowerPointExtractor <filename.pptx>");
            System.exit(1);
        }
        XSLFPowerPointExtractor xSLFPowerPointExtractor = new XSLFPowerPointExtractor(new XSLFSlideShow(strArr[0]));
        System.out.println(xSLFPowerPointExtractor.getText());
        xSLFPowerPointExtractor.close();
    }

    public void setSlidesByDefault(boolean z) {
        this.slidesByDefault = z;
    }

    public void setNotesByDefault(boolean z) {
        this.notesByDefault = z;
    }

    public void setMasterByDefault(boolean z) {
        this.masterByDefault = z;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        return getText(this.slidesByDefault, this.notesByDefault);
    }

    public String getText(boolean z, boolean z2) {
        return getText(z, z2, this.masterByDefault);
    }

    public String getText(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFSlide> it = this.slideshow.getSlides().iterator();
        while (it.hasNext()) {
            sb.append(getText(it.next(), z, z2, z3));
        }
        return sb.toString();
    }

    public static String getText(XSLFSlide xSLFSlide, boolean z, boolean z2, boolean z3) {
        CTCommentAuthor authorById;
        StringBuilder sb = new StringBuilder();
        XSLFCommentAuthors commentAuthors = xSLFSlide.getSlideShow().getCommentAuthors();
        XSLFNotes notes = xSLFSlide.getNotes();
        XSLFComments comments = xSLFSlide.getComments();
        XSLFSlideLayout slideLayout = xSLFSlide.getSlideLayout();
        XSLFSlideMaster slideMaster = slideLayout.getSlideMaster();
        if (z) {
            extractText(xSLFSlide, false, sb);
            if (z3) {
                extractText(slideLayout, true, sb);
                extractText(slideMaster, true, sb);
            }
            if (comments != null) {
                for (CTComment cTComment : comments.getCTCommentsList().getCmArray()) {
                    if (commentAuthors != null && (authorById = commentAuthors.getAuthorById(cTComment.getAuthorId())) != null) {
                        sb.append(authorById.getName() + ": ");
                    }
                    sb.append(cTComment.getText());
                    sb.append("\n");
                }
            }
        }
        if (z2 && notes != null) {
            extractText(notes, false, sb);
        }
        return sb.toString();
    }

    private static void extractText(XSLFShapeContainer xSLFShapeContainer, boolean z, StringBuilder sb) {
        Iterator it = xSLFShapeContainer.iterator();
        while (it.hasNext()) {
            Shape shape = (XSLFShape) it.next();
            if (shape instanceof XSLFShapeContainer) {
                extractText((XSLFShapeContainer) shape, z, sb);
            } else if (shape instanceof XSLFTextShape) {
                XSLFTextShape xSLFTextShape = (XSLFTextShape) shape;
                if (!z || !xSLFTextShape.isPlaceholder()) {
                    sb.append(xSLFTextShape.getText());
                    sb.append("\n");
                }
            } else if (shape instanceof XSLFTable) {
                Iterator<XSLFTableRow> it2 = ((XSLFTable) shape).iterator();
                while (it2.hasNext()) {
                    Iterator<XSLFTableCell> it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        sb.append(it3.next().getText());
                        sb.append("\t");
                    }
                    sb.append("\n");
                }
            }
        }
    }
}
