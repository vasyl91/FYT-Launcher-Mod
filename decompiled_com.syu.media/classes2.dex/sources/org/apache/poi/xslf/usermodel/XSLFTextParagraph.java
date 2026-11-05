package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTextParagraph implements TextParagraph<XSLFShape, XSLFTextParagraph, XSLFTextRun> {
    private final CTTextParagraph _p;
    private final List<XSLFTextRun> _runs = new ArrayList();
    private final XSLFTextShape _shape;

    XSLFTextParagraph(CTTextParagraph cTTextParagraph, XSLFTextShape xSLFTextShape) {
        this._p = cTTextParagraph;
        this._shape = xSLFTextShape;
        XmlCursor xmlCursorNewCursor = cTTextParagraph.newCursor();
        try {
            if (xmlCursorNewCursor.toFirstChild()) {
                do {
                    CTTextLineBreak object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTTextLineBreak) {
                        this._runs.add(new XSLFLineBreak(object, this));
                    } else if ((object instanceof CTRegularTextRun) || (object instanceof CTTextField)) {
                        this._runs.add(new XSLFTextRun(object, this));
                    }
                } while (xmlCursorNewCursor.toNextSibling());
            }
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFTextRun> it = this._runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getRawText());
        }
        return sb.toString();
    }

    String getRenderableText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFTextRun> it = this._runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getRenderableText());
        }
        return sb.toString();
    }

    @Internal
    public CTTextParagraph getXmlObject() {
        return this._p;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public XSLFTextShape getParentShape() {
        return this._shape;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public List<XSLFTextRun> getTextRuns() {
        return this._runs;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextRun> iterator() {
        return this._runs.iterator();
    }

    public XSLFTextRun addNewTextRun() {
        CTRegularTextRun cTRegularTextRunAddNewR = this._p.addNewR();
        cTRegularTextRunAddNewR.addNewRPr().setLang("en-US");
        XSLFTextRun xSLFTextRunNewTextRun = newTextRun(cTRegularTextRunAddNewR);
        this._runs.add(xSLFTextRunNewTextRun);
        return xSLFTextRunNewTextRun;
    }

    public XSLFTextRun addLineBreak() {
        XSLFLineBreak xSLFLineBreak = new XSLFLineBreak(this._p.addNewBr(), this);
        CTTextCharacterProperties rPr = xSLFLineBreak.getRPr(true);
        if (this._runs.size() > 0) {
            List<XSLFTextRun> list = this._runs;
            rPr.set(list.get(list.size() - 1).getRPr(true));
        }
        this._runs.add(xSLFLineBreak);
        return xSLFLineBreak;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public TextParagraph.TextAlign getTextAlign() {
        ParagraphPropertyFetcher<TextParagraph.TextAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextParagraph.TextAlign>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.1
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetAlgn()) {
                    return false;
                }
                setValue(TextParagraph.TextAlign.values()[cTTextParagraphProperties.getAlgn().intValue() - 1]);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setTextAlign(TextParagraph.TextAlign textAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (textAlign == null) {
            if (pPr.isSetAlgn()) {
                pPr.unsetAlgn();
                return;
            }
            return;
        }
        pPr.setAlgn(STTextAlignType.Enum.forInt(textAlign.ordinal() + 1));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public TextParagraph.FontAlign getFontAlign() {
        ParagraphPropertyFetcher<TextParagraph.FontAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextParagraph.FontAlign>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.2
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetFontAlgn()) {
                    return false;
                }
                setValue(TextParagraph.FontAlign.values()[cTTextParagraphProperties.getFontAlgn().intValue() - 1]);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setFontAlign(TextParagraph.FontAlign fontAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (fontAlign == null) {
            if (pPr.isSetFontAlgn()) {
                pPr.unsetFontAlgn();
                return;
            }
            return;
        }
        pPr.setFontAlgn(STTextFontAlignType.Enum.forInt(fontAlign.ordinal() + 1));
    }

    public String getBulletFont() {
        ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.3
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuFont()) {
                    return false;
                }
                setValue(cTTextParagraphProperties.getBuFont().getTypeface());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setBulletFont(String str) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuFont() ? pPr.getBuFont() : pPr.addNewBuFont()).setTypeface(str);
    }

    public String getBulletCharacter() {
        ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.4
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuChar()) {
                    return false;
                }
                setValue(cTTextParagraphProperties.getBuChar().getChar());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setBulletCharacter(String str) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuChar() ? pPr.getBuChar() : pPr.addNewBuChar()).setChar(str);
    }

    public PaintStyle getBulletFontColor() {
        final XSLFTheme theme = getParentShape().getSheet().getTheme();
        ParagraphPropertyFetcher<Color> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Color>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.5
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuClr()) {
                    return false;
                }
                setValue(new XSLFColor(cTTextParagraphProperties.getBuClr(), theme, null).getColor());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        Color value = paragraphPropertyFetcher.getValue();
        if (value == null) {
            return null;
        }
        return DrawPaint.createSolidPaint(value);
    }

    public void setBulletFontColor(Color color) {
        setBulletFontColor(DrawPaint.createSolidPaint(color));
    }

    public void setBulletFontColor(PaintStyle paintStyle) {
        if (!(paintStyle instanceof PaintStyle.SolidPaint)) {
            throw new IllegalArgumentException("Currently XSLF only supports SolidPaint");
        }
        Color colorApplyColorTransform = DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) paintStyle).getSolidColor());
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTColor buClr = pPr.isSetBuClr() ? pPr.getBuClr() : pPr.addNewBuClr();
        (buClr.isSetSrgbClr() ? buClr.getSrgbClr() : buClr.addNewSrgbClr()).setVal(new byte[]{(byte) colorApplyColorTransform.getRed(), (byte) colorApplyColorTransform.getGreen(), (byte) colorApplyColorTransform.getBlue()});
    }

    public Double getBulletFontSize() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.6
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (cTTextParagraphProperties.isSetBuSzPct()) {
                    setValue(Double.valueOf(((double) cTTextParagraphProperties.getBuSzPct().getVal()) * 0.001d));
                    return true;
                }
                if (!cTTextParagraphProperties.isSetBuSzPts()) {
                    return false;
                }
                setValue(Double.valueOf(((double) (-cTTextParagraphProperties.getBuSzPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setBulletFontSize(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d >= 0.0d) {
            (pPr.isSetBuSzPct() ? pPr.getBuSzPct() : pPr.addNewBuSzPct()).setVal((int) (d * 1000.0d));
            if (pPr.isSetBuSzPts()) {
                pPr.unsetBuSzPts();
                return;
            }
            return;
        }
        (pPr.isSetBuSzPts() ? pPr.getBuSzPts() : pPr.addNewBuSzPts()).setVal((int) ((-d) * 100.0d));
        if (pPr.isSetBuSzPct()) {
            pPr.unsetBuSzPct();
        }
    }

    public AutoNumberingScheme getAutoNumberingScheme() {
        ParagraphPropertyFetcher<AutoNumberingScheme> paragraphPropertyFetcher = new ParagraphPropertyFetcher<AutoNumberingScheme>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.7
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                AutoNumberingScheme autoNumberingSchemeForOoxmlID;
                if (!cTTextParagraphProperties.isSetBuAutoNum() || (autoNumberingSchemeForOoxmlID = AutoNumberingScheme.forOoxmlID(cTTextParagraphProperties.getBuAutoNum().getType().intValue())) == null) {
                    return false;
                }
                setValue(autoNumberingSchemeForOoxmlID);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public Integer getAutoNumberingStartAt() {
        ParagraphPropertyFetcher<Integer> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Integer>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.8
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuAutoNum() || !cTTextParagraphProperties.getBuAutoNum().isSetStartAt()) {
                    return false;
                }
                setValue(Integer.valueOf(cTTextParagraphProperties.getBuAutoNum().getStartAt()));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setIndent(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d == null) {
                if (pPr.isSetIndent()) {
                    pPr.unsetIndent();
                    return;
                }
                return;
            }
            pPr.setIndent(Units.toEMU(d.doubleValue()));
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getIndent() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.9
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetIndent()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getIndent())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setLeftMargin(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d == null) {
                if (pPr.isSetMarL()) {
                    pPr.unsetMarL();
                    return;
                }
                return;
            }
            pPr.setMarL(Units.toEMU(d.doubleValue()));
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getLeftMargin() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.10
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetMarL()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarL())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setRightMargin(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d == null) {
                if (pPr.isSetMarR()) {
                    pPr.unsetMarR();
                    return;
                }
                return;
            }
            pPr.setMarR(Units.toEMU(d.doubleValue()));
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getRightMargin() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.11
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetMarR()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarR())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getDefaultTabSize() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.12
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetDefTabSz()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getDefTabSz())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public double getTabStop(final int i) {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.13
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetTabLst()) {
                    return false;
                }
                CTTextTabStopList tabLst = cTTextParagraphProperties.getTabLst();
                if (i >= tabLst.sizeOfTabArray()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(tabLst.getTabArray(i).getPos())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public void addTabStop(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetTabLst() ? pPr.getTabLst() : pPr.addNewTabLst()).addNewTab().setPos(Units.toEMU(d));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setLineSpacing(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d == null) {
                if (pPr.isSetLnSpc()) {
                    pPr.unsetLnSpc();
                    return;
                }
                return;
            }
            CTTextSpacing lnSpc = pPr.isSetLnSpc() ? pPr.getLnSpc() : pPr.addNewLnSpc();
            if (d.doubleValue() >= 0.0d) {
                (lnSpc.isSetSpcPct() ? lnSpc.getSpcPct() : lnSpc.addNewSpcPct()).setVal((int) (d.doubleValue() * 1000.0d));
                if (lnSpc.isSetSpcPts()) {
                    lnSpc.unsetSpcPts();
                    return;
                }
                return;
            }
            (lnSpc.isSetSpcPts() ? lnSpc.getSpcPts() : lnSpc.addNewSpcPts()).setVal((int) ((-d.doubleValue()) * 100.0d));
            if (lnSpc.isSetSpcPct()) {
                lnSpc.unsetSpcPct();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getLineSpacing() {
        CTTextNormalAutofit normAutofit;
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.14
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetLnSpc()) {
                    return false;
                }
                CTTextSpacing lnSpc = cTTextParagraphProperties.getLnSpc();
                if (lnSpc.isSetSpcPct()) {
                    setValue(Double.valueOf(((double) lnSpc.getSpcPct().getVal()) * 0.001d));
                    return true;
                }
                if (!lnSpc.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf(((double) (-lnSpc.getSpcPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        Double value = paragraphPropertyFetcher.getValue();
        return (value == null || value.doubleValue() <= 0.0d || (normAutofit = getParentShape().getTextBodyPr().getNormAutofit()) == null) ? value : Double.valueOf(value.doubleValue() * (1.0d - (((double) normAutofit.getLnSpcReduction()) / 100000.0d)));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setSpaceBefore(Double d) {
        if (d != null || this._p.isSetPPr()) {
            if (d == null) {
                if (this._p.getPPr().isSetSpcBef()) {
                    this._p.getPPr().unsetSpcBef();
                }
            } else {
                CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
                CTTextSpacing cTTextSpacingNewInstance = CTTextSpacing.Factory.newInstance();
                if (d.doubleValue() >= 0.0d) {
                    cTTextSpacingNewInstance.addNewSpcPct().setVal((int) (d.doubleValue() * 1000.0d));
                } else {
                    cTTextSpacingNewInstance.addNewSpcPts().setVal((int) ((-d.doubleValue()) * 100.0d));
                }
                pPr.setSpcBef(cTTextSpacingNewInstance);
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getSpaceBefore() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.15
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetSpcBef()) {
                    return false;
                }
                CTTextSpacing spcBef = cTTextParagraphProperties.getSpcBef();
                if (spcBef.isSetSpcPct()) {
                    setValue(Double.valueOf(((double) spcBef.getSpcPct().getVal()) * 0.001d));
                    return true;
                }
                if (!spcBef.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf(((double) (-spcBef.getSpcPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setSpaceAfter(Double d) {
        if (d != null || this._p.isSetPPr()) {
            if (d == null) {
                if (this._p.getPPr().isSetSpcAft()) {
                    this._p.getPPr().unsetSpcAft();
                }
            } else {
                CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
                CTTextSpacing cTTextSpacingNewInstance = CTTextSpacing.Factory.newInstance();
                if (d.doubleValue() >= 0.0d) {
                    cTTextSpacingNewInstance.addNewSpcPct().setVal((int) (d.doubleValue() * 1000.0d));
                } else {
                    cTTextSpacingNewInstance.addNewSpcPts().setVal((int) ((-d.doubleValue()) * 100.0d));
                }
                pPr.setSpcAft(cTTextSpacingNewInstance);
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getSpaceAfter() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.16
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetSpcAft()) {
                    return false;
                }
                CTTextSpacing spcAft = cTTextParagraphProperties.getSpcAft();
                if (spcAft.isSetSpcPct()) {
                    setValue(Double.valueOf(((double) spcAft.getSpcPct().getVal()) * 0.001d));
                    return true;
                }
                if (!spcAft.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf(((double) (-spcAft.getSpcPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setIndentLevel(int i) {
        (this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr()).setLvl(i);
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public int getIndentLevel() {
        CTTextParagraphProperties pPr = this._p.getPPr();
        if (pPr == null || !pPr.isSetLvl()) {
            return 0;
        }
        return pPr.getLvl();
    }

    public boolean isBullet() {
        ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getIndentLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.17
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (cTTextParagraphProperties.isSetBuNone()) {
                    setValue(false);
                    return true;
                }
                if (!cTTextParagraphProperties.isSetBuFont() && !cTTextParagraphProperties.isSetBuChar()) {
                    return false;
                }
                setValue(true);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return false;
        }
        return paragraphPropertyFetcher.getValue().booleanValue();
    }

    public void setBullet(boolean z) {
        if (isBullet() == z) {
            return;
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (z) {
            pPr.addNewBuFont().setTypeface(HSSFFont.FONT_ARIAL);
            pPr.addNewBuChar().setChar("•");
            return;
        }
        if (pPr.isSetBuFont()) {
            pPr.unsetBuFont();
        }
        if (pPr.isSetBuChar()) {
            pPr.unsetBuChar();
        }
        if (pPr.isSetBuAutoNum()) {
            pPr.unsetBuAutoNum();
        }
        if (pPr.isSetBuBlip()) {
            pPr.unsetBuBlip();
        }
        if (pPr.isSetBuClr()) {
            pPr.unsetBuClr();
        }
        if (pPr.isSetBuClrTx()) {
            pPr.unsetBuClrTx();
        }
        if (pPr.isSetBuFont()) {
            pPr.unsetBuFont();
        }
        if (pPr.isSetBuFontTx()) {
            pPr.unsetBuFontTx();
        }
        if (pPr.isSetBuSzPct()) {
            pPr.unsetBuSzPct();
        }
        if (pPr.isSetBuSzPts()) {
            pPr.unsetBuSzPts();
        }
        if (pPr.isSetBuSzTx()) {
            pPr.unsetBuSzTx();
        }
        pPr.addNewBuNone();
    }

    public void setBulletAutoNumber(AutoNumberingScheme autoNumberingScheme, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Start Number must be greater or equal that 1");
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextAutonumberBullet buAutoNum = pPr.isSetBuAutoNum() ? pPr.getBuAutoNum() : pPr.addNewBuAutoNum();
        buAutoNum.setType(STTextAutonumberScheme.Enum.forInt(autoNumberingScheme.ooxmlId));
        buAutoNum.setStartAt(i);
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    CTTextParagraphProperties getDefaultMasterStyle() {
        String str;
        CTPlaceholder cTPlaceholder = this._shape.getCTPlaceholder();
        int iIntValue = cTPlaceholder == null ? -1 : cTPlaceholder.getType().intValue();
        if (iIntValue == -1) {
            str = "otherStyle";
        } else if (iIntValue == 1 || iIntValue == 3) {
            str = "titleStyle";
        } else if (iIntValue == 5 || iIntValue == 6 || iIntValue == 7) {
            str = "otherStyle";
        } else {
            str = "bodyStyle";
        }
        int indentLevel = getIndentLevel();
        for (XSLFSheet sheet = this._shape.getSheet(); sheet != null; sheet = (XSLFSheet) sheet.getMasterSheet()) {
            XmlCursor xmlCursorNewCursor = sheet.getXmlObject().newCursor();
            try {
                xmlCursorNewCursor.push();
                if ((xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/presentationml/2006/main", "txStyles") && xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/presentationml/2006/main", str)) || (xmlCursorNewCursor.pop() && xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/presentationml/2006/main", "notesStyle"))) {
                    while (indentLevel >= 0) {
                        xmlCursorNewCursor.push();
                        if (xmlCursorNewCursor.toChild(XSSFRelation.NS_DRAWINGML, "lvl" + (indentLevel + 1) + "pPr")) {
                            CTTextParagraphProperties object = xmlCursorNewCursor.getObject();
                            xmlCursorNewCursor.dispose();
                            return object;
                        }
                        xmlCursorNewCursor.pop();
                        indentLevel--;
                    }
                }
                xmlCursorNewCursor.dispose();
            } catch (Throwable th) {
                xmlCursorNewCursor.dispose();
                throw th;
            }
        }
        return null;
    }

    private <T> boolean fetchParagraphProperty(ParagraphPropertyFetcher<T> paragraphPropertyFetcher) {
        boolean zFetchShapeProperty;
        CTTextParagraphProperties defaultParagraphStyle;
        XSLFTextShape parentShape = getParentShape();
        XSLFSheet sheet = parentShape.getSheet();
        if ((this._p.isSetPPr() ? paragraphPropertyFetcher.fetch(this._p.getPPr()) : false) || (zFetchShapeProperty = parentShape.fetchShapeProperty(paragraphPropertyFetcher))) {
            return true;
        }
        if (parentShape.getCTPlaceholder() == null && (defaultParagraphStyle = sheet.getSlideShow().getDefaultParagraphStyle(getIndentLevel())) != null) {
            zFetchShapeProperty = paragraphPropertyFetcher.fetch(defaultParagraphStyle);
        }
        if (zFetchShapeProperty) {
            return true;
        }
        CTTextParagraphProperties defaultMasterStyle = getDefaultMasterStyle();
        if (defaultMasterStyle != null) {
            zFetchShapeProperty = paragraphPropertyFetcher.fetch(defaultMasterStyle);
        }
        return zFetchShapeProperty;
    }

    void copy(XSLFTextParagraph xSLFTextParagraph) {
        if (xSLFTextParagraph == this) {
            return;
        }
        CTTextParagraph xmlObject = getXmlObject();
        CTTextParagraph xmlObject2 = xSLFTextParagraph.getXmlObject();
        if (xmlObject.isSetPPr()) {
            xmlObject.unsetPPr();
        }
        if (xmlObject.isSetEndParaRPr()) {
            xmlObject.unsetEndParaRPr();
        }
        this._runs.clear();
        for (int iSizeOfBrArray = xmlObject.sizeOfBrArray(); iSizeOfBrArray > 0; iSizeOfBrArray--) {
            xmlObject.removeBr(iSizeOfBrArray - 1);
        }
        for (int iSizeOfRArray = xmlObject.sizeOfRArray(); iSizeOfRArray > 0; iSizeOfRArray--) {
            xmlObject.removeR(iSizeOfRArray - 1);
        }
        for (int iSizeOfFldArray = xmlObject.sizeOfFldArray(); iSizeOfFldArray > 0; iSizeOfFldArray--) {
            xmlObject.removeFld(iSizeOfFldArray - 1);
        }
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        xmlCursorNewCursor.toEndToken();
        XmlCursor xmlCursorNewCursor2 = xmlObject2.newCursor();
        xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
        xmlCursorNewCursor2.dispose();
        xmlCursorNewCursor.dispose();
        List<XSLFTextRun> textRuns = xSLFTextParagraph.getTextRuns();
        CTRegularTextRun[] rArray = xmlObject.getRArray();
        int length = rArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            XSLFTextRun xSLFTextRunNewTextRun = newTextRun(rArray[i]);
            xSLFTextRunNewTextRun.copy(textRuns.get(i2));
            this._runs.add(xSLFTextRunNewTextRun);
            i++;
            i2++;
        }
        TextParagraph.TextAlign textAlign = xSLFTextParagraph.getTextAlign();
        if (textAlign != getTextAlign()) {
            setTextAlign(textAlign);
        }
        boolean zIsBullet = xSLFTextParagraph.isBullet();
        if (zIsBullet != isBullet()) {
            setBullet(zIsBullet);
            if (zIsBullet) {
                String bulletFont = xSLFTextParagraph.getBulletFont();
                if (bulletFont != null && !bulletFont.equals(getBulletFont())) {
                    setBulletFont(bulletFont);
                }
                String bulletCharacter = xSLFTextParagraph.getBulletCharacter();
                if (bulletCharacter != null && !bulletCharacter.equals(getBulletCharacter())) {
                    setBulletCharacter(bulletCharacter);
                }
                PaintStyle bulletFontColor = xSLFTextParagraph.getBulletFontColor();
                if (bulletFontColor != null && !bulletFontColor.equals(getBulletFontColor())) {
                    setBulletFontColor(bulletFontColor);
                }
                Double bulletFontSize = xSLFTextParagraph.getBulletFontSize();
                if (!doubleEquals(bulletFontSize, getBulletFontSize())) {
                    setBulletFontSize(bulletFontSize.doubleValue());
                }
            }
        }
        Double leftMargin = xSLFTextParagraph.getLeftMargin();
        if (!doubleEquals(leftMargin, getLeftMargin())) {
            setLeftMargin(leftMargin);
        }
        Double indent = xSLFTextParagraph.getIndent();
        if (!doubleEquals(indent, getIndent())) {
            setIndent(indent);
        }
        Double spaceAfter = xSLFTextParagraph.getSpaceAfter();
        if (!doubleEquals(spaceAfter, getSpaceAfter())) {
            setSpaceAfter(spaceAfter);
        }
        Double spaceBefore = xSLFTextParagraph.getSpaceBefore();
        if (!doubleEquals(spaceBefore, getSpaceBefore())) {
            setSpaceBefore(spaceBefore);
        }
        Double lineSpacing = xSLFTextParagraph.getLineSpacing();
        if (doubleEquals(lineSpacing, getLineSpacing())) {
            return;
        }
        setLineSpacing(lineSpacing);
    }

    private static boolean doubleEquals(Double d, Double d2) {
        return d == d2 || (d != null && d.equals(d2));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getDefaultFontSize() {
        CTTextParagraphProperties defaultMasterStyle;
        CTTextCharacterProperties endParaRPr = this._p.getEndParaRPr();
        if ((endParaRPr == null || !endParaRPr.isSetSz()) && (defaultMasterStyle = getDefaultMasterStyle()) != null) {
            endParaRPr = defaultMasterStyle.getDefRPr();
        }
        return Double.valueOf((endParaRPr == null || !endParaRPr.isSetSz()) ? 12.0d : ((double) endParaRPr.getSz()) / 100.0d);
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public String getDefaultFontFamily() {
        return this._runs.isEmpty() ? HSSFFont.FONT_ARIAL : this._runs.get(0).getFontFamily();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public TextParagraph.BulletStyle getBulletStyle() {
        if (isBullet()) {
            return new TextParagraph.BulletStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.18
                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public String getBulletCharacter() {
                    return XSLFTextParagraph.this.getBulletCharacter();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public String getBulletFont() {
                    return XSLFTextParagraph.this.getBulletFont();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public Double getBulletFontSize() {
                    return XSLFTextParagraph.this.getBulletFontSize();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public PaintStyle getBulletFontColor() {
                    return XSLFTextParagraph.this.getBulletFontColor();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public void setBulletFontColor(Color color) {
                    setBulletFontColor(DrawPaint.createSolidPaint(color));
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public void setBulletFontColor(PaintStyle paintStyle) {
                    XSLFTextParagraph.this.setBulletFontColor(paintStyle);
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public AutoNumberingScheme getAutoNumberingScheme() {
                    return XSLFTextParagraph.this.getAutoNumberingScheme();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public Integer getAutoNumberingStartAt() {
                    return XSLFTextParagraph.this.getAutoNumberingStartAt();
                }
            };
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setBulletStyle(Object... objArr) {
        if (objArr.length == 0) {
            setBullet(false);
            return;
        }
        setBullet(true);
        for (Object obj : objArr) {
            if (obj instanceof Number) {
                setBulletFontSize(((Number) obj).doubleValue());
            } else if (obj instanceof Color) {
                setBulletFontColor((Color) obj);
            } else if (obj instanceof Character) {
                setBulletCharacter(obj.toString());
            } else if (obj instanceof String) {
                setBulletFont((String) obj);
            } else if (obj instanceof AutoNumberingScheme) {
                setBulletAutoNumber((AutoNumberingScheme) obj, 0);
            }
        }
    }

    void clearButKeepProperties() {
        CTTextParagraph xmlObject = getXmlObject();
        for (int iSizeOfBrArray = xmlObject.sizeOfBrArray(); iSizeOfBrArray > 0; iSizeOfBrArray--) {
            xmlObject.removeBr(iSizeOfBrArray - 1);
        }
        for (int iSizeOfFldArray = xmlObject.sizeOfFldArray(); iSizeOfFldArray > 0; iSizeOfFldArray--) {
            xmlObject.removeFld(iSizeOfFldArray - 1);
        }
        if (this._runs.isEmpty()) {
            return;
        }
        int size = this._runs.size();
        CTTextCharacterProperties rPr = this._runs.get(size - 1).getRPr(false);
        if (rPr != null) {
            if (xmlObject.isSetEndParaRPr()) {
                xmlObject.unsetEndParaRPr();
            }
            xmlObject.addNewEndParaRPr().set(rPr);
        }
        while (size > 0) {
            xmlObject.removeR(size - 1);
            size--;
        }
        this._runs.clear();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public boolean isHeaderOrFooter() {
        CTPlaceholder cTPlaceholder = this._shape.getCTPlaceholder();
        int iIntValue = cTPlaceholder == null ? -1 : cTPlaceholder.getType().intValue();
        return iIntValue == 5 || iIntValue == 6 || iIntValue == 7 || iIntValue == 8;
    }

    protected XSLFTextRun newTextRun(CTRegularTextRun cTRegularTextRun) {
        return new XSLFTextRun(cTRegularTextRun, this);
    }
}
