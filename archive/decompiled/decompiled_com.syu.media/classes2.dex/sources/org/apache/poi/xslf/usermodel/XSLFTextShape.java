package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.TextBodyPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XSLFTextShape extends XSLFSimpleShape implements TextShape<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<XSLFTextParagraph> _paragraphs;

    protected abstract CTTextBody getTextBody(boolean z);

    XSLFTextShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        super(xmlObject, xSLFSheet);
        this._paragraphs = new ArrayList();
        CTTextBody textBody = getTextBody(false);
        if (textBody != null) {
            for (CTTextParagraph cTTextParagraph : textBody.getPArray()) {
                this._paragraphs.add(newTextParagraph(cTTextParagraph));
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextParagraph> iterator() {
        return getTextParagraphs().iterator();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (XSLFTextParagraph xSLFTextParagraph : this._paragraphs) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(xSLFTextParagraph.getText());
        }
        return sb.toString();
    }

    public void clearText() {
        this._paragraphs.clear();
        getTextBody(true).setPArray((CTTextParagraph[]) null);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public XSLFTextRun setText(String str) {
        if (!this._paragraphs.isEmpty()) {
            CTTextBody textBody = getTextBody(false);
            for (int iSizeOfPArray = textBody.sizeOfPArray(); iSizeOfPArray > 1; iSizeOfPArray--) {
                int i = iSizeOfPArray - 1;
                textBody.removeP(i);
                this._paragraphs.remove(i);
            }
            this._paragraphs.get(0).clearButKeepProperties();
        }
        return appendText(str, false);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public XSLFTextRun appendText(String str, boolean z) {
        boolean z2;
        XSLFTextParagraph xSLFTextParagraph;
        CTTextParagraphProperties pPr;
        XmlObject rPr;
        CTTextParagraph xmlObject;
        XmlObject endParaRPr;
        XSLFTextRun xSLFTextRun = null;
        if (str == null) {
            return null;
        }
        if (this._paragraphs.isEmpty()) {
            xSLFTextParagraph = null;
            pPr = null;
            rPr = null;
            z2 = false;
        } else {
            z2 = !z;
            List<XSLFTextParagraph> list = this._paragraphs;
            xSLFTextParagraph = list.get(list.size() - 1);
            CTTextParagraph xmlObject2 = xSLFTextParagraph.getXmlObject();
            pPr = xmlObject2.getPPr();
            List<XSLFTextRun> textRuns = xSLFTextParagraph.getTextRuns();
            if (textRuns.isEmpty()) {
                rPr = null;
            } else {
                rPr = textRuns.get(textRuns.size() - 1).getRPr(false);
                if (rPr == null) {
                    rPr = xmlObject2.getEndParaRPr();
                }
            }
        }
        String[] strArrSplit = str.split("\\r\\n?|\\n");
        int length = strArrSplit.length;
        int i = 0;
        while (i < length) {
            String str2 = strArrSplit[i];
            if (!z2) {
                if (xSLFTextParagraph != null && (endParaRPr = (xmlObject = xSLFTextParagraph.getXmlObject()).getEndParaRPr()) != null && endParaRPr != rPr) {
                    xmlObject.unsetEndParaRPr();
                }
                XSLFTextParagraph xSLFTextParagraphAddNewTextParagraph = addNewTextParagraph();
                if (pPr != null) {
                    xSLFTextParagraphAddNewTextParagraph.getXmlObject().setPPr(pPr);
                }
                xSLFTextParagraph = xSLFTextParagraphAddNewTextParagraph;
            }
            String[] strArrSplit2 = str2.split("[\u000b]");
            int length2 = strArrSplit2.length;
            int i2 = 0;
            boolean z3 = true;
            while (i2 < length2) {
                String str3 = strArrSplit2[i2];
                if (!z3) {
                    xSLFTextParagraph.addLineBreak();
                }
                XSLFTextRun xSLFTextRunAddNewTextRun = xSLFTextParagraph.addNewTextRun();
                xSLFTextRunAddNewTextRun.setText(str3);
                if (rPr != null) {
                    xSLFTextRunAddNewTextRun.getRPr(true).set(rPr);
                }
                i2++;
                xSLFTextRun = xSLFTextRunAddNewTextRun;
                z3 = false;
            }
            i++;
            z2 = false;
        }
        return xSLFTextRun;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public List<XSLFTextParagraph> getTextParagraphs() {
        return this._paragraphs;
    }

    public XSLFTextParagraph addNewTextParagraph() {
        CTTextParagraph cTTextParagraphAddNewP;
        CTTextBody textBody = getTextBody(false);
        if (textBody == null) {
            cTTextParagraphAddNewP = getTextBody(true).getPArray(0);
            cTTextParagraphAddNewP.removeR(0);
        } else {
            cTTextParagraphAddNewP = textBody.addNewP();
        }
        XSLFTextParagraph xSLFTextParagraphNewTextParagraph = newTextParagraph(cTTextParagraphAddNewP);
        this._paragraphs.add(xSLFTextParagraphNewTextParagraph);
        return xSLFTextParagraphNewTextParagraph;
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (verticalAlignment == null) {
                if (textBodyPr.isSetAnchor()) {
                    textBodyPr.unsetAnchor();
                    return;
                }
                return;
            }
            textBodyPr.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
        }
    }

    public VerticalAlignment getVerticalAlignment() {
        TextBodyPropertyFetcher<VerticalAlignment> textBodyPropertyFetcher = new TextBodyPropertyFetcher<VerticalAlignment>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.1
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetAnchor()) {
                    return false;
                }
                setValue(VerticalAlignment.values()[cTTextBodyProperties.getAnchor().intValue() - 1]);
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        return textBodyPropertyFetcher.getValue() == null ? VerticalAlignment.TOP : textBodyPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setHorizontalCentered(Boolean bool) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (bool == null) {
                if (textBodyPr.isSetAnchorCtr()) {
                    textBodyPr.unsetAnchorCtr();
                    return;
                }
                return;
            }
            textBodyPr.setAnchorCtr(bool.booleanValue());
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public boolean isHorizontalCentered() {
        TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.2
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetAnchorCtr()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextBodyProperties.getAnchorCtr()));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return false;
        }
        return textBodyPropertyFetcher.getValue().booleanValue();
    }

    public void setTextDirection(TextShape.TextDirection textDirection) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (textDirection == null) {
                if (textBodyPr.isSetVert()) {
                    textBodyPr.unsetVert();
                    return;
                }
                return;
            }
            textBodyPr.setVert(STTextVerticalType.Enum.forInt(textDirection.ordinal() + 1));
        }
    }

    public TextShape.TextDirection getTextDirection() {
        STTextVerticalType.Enum vert;
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null && (vert = textBodyPr.getVert()) != null) {
            switch (vert.intValue()) {
                case 2:
                case 5:
                case 6:
                    return TextShape.TextDirection.VERTICAL;
                case 3:
                    return TextShape.TextDirection.VERTICAL_270;
                case 4:
                case 7:
                    return TextShape.TextDirection.STACKED;
                default:
                    return TextShape.TextDirection.HORIZONTAL;
            }
        }
        return TextShape.TextDirection.HORIZONTAL;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Double getTextRotation() {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr == null || !textBodyPr.isSetRot()) {
            return null;
        }
        return Double.valueOf(((double) textBodyPr.getRot()) / 60000.0d);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setTextRotation(Double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            textBodyPr.setRot((int) (d.doubleValue() * 60000.0d));
        }
    }

    public double getBottomInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.3
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetBIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getBIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 3.6d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getLeftInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.4
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetLIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getLIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 7.2d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getRightInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.5
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetRIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getRIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 7.2d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getTopInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.6
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetTIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getTIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 3.6d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public void setBottomInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetBIns();
            } else {
                textBodyPr.setBIns(Units.toEMU(d));
            }
        }
    }

    public void setLeftInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetLIns();
            } else {
                textBodyPr.setLIns(Units.toEMU(d));
            }
        }
    }

    public void setRightInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetRIns();
            } else {
                textBodyPr.setRIns(Units.toEMU(d));
            }
        }
    }

    public void setTopInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetTIns();
            } else {
                textBodyPr.setTIns(Units.toEMU(d));
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Insets2D getInsets() {
        return new Insets2D(getTopInset(), getLeftInset(), getBottomInset(), getRightInset());
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setInsets(Insets2D insets2D) {
        setTopInset(insets2D.top);
        setLeftInset(insets2D.left);
        setBottomInset(insets2D.bottom);
        setRightInset(insets2D.right);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public boolean getWordWrap() {
        TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.7
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetWrap()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextBodyProperties.getWrap() == STTextWrappingType.SQUARE));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return true;
        }
        return textBodyPropertyFetcher.getValue().booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setWordWrap(boolean z) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            textBodyPr.setWrap(z ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
        }
    }

    public void setTextAutofit(TextShape.TextAutofit textAutofit) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (textBodyPr.isSetSpAutoFit()) {
                textBodyPr.unsetSpAutoFit();
            }
            if (textBodyPr.isSetNoAutofit()) {
                textBodyPr.unsetNoAutofit();
            }
            if (textBodyPr.isSetNormAutofit()) {
                textBodyPr.unsetNormAutofit();
            }
            int i = AnonymousClass8.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit[textAutofit.ordinal()];
            if (i == 1) {
                textBodyPr.addNewNoAutofit();
            } else if (i == 2) {
                textBodyPr.addNewNormAutofit();
            } else {
                if (i != 3) {
                    return;
                }
                textBodyPr.addNewSpAutoFit();
            }
        }
    }

    public TextShape.TextAutofit getTextAutofit() {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (textBodyPr.isSetNoAutofit()) {
                return TextShape.TextAutofit.NONE;
            }
            if (textBodyPr.isSetNormAutofit()) {
                return TextShape.TextAutofit.NORMAL;
            }
            if (textBodyPr.isSetSpAutoFit()) {
                return TextShape.TextAutofit.SHAPE;
            }
        }
        return TextShape.TextAutofit.NORMAL;
    }

    protected CTTextBodyProperties getTextBodyPr() {
        return getTextBodyPr(false);
    }

    protected CTTextBodyProperties getTextBodyPr(boolean z) {
        CTTextBody textBody = getTextBody(z);
        if (textBody == null) {
            return null;
        }
        CTTextBodyProperties bodyPr = textBody.getBodyPr();
        return (bodyPr == null && z) ? textBody.addNewBodyPr() : bodyPr;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        super.setPlaceholder(placeholder);
    }

    public Placeholder getTextType() {
        CTPlaceholder cTPlaceholder = getCTPlaceholder();
        if (cTPlaceholder == null) {
            return null;
        }
        return Placeholder.lookupOoxml(cTPlaceholder.getType().intValue());
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public double getTextHeight() {
        return getTextHeight(null);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public double getTextHeight(Graphics2D graphics2D) {
        return DrawFactory.getInstance(graphics2D).getDrawable((TextShape<?, ?>) this).getTextHeight(graphics2D);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Rectangle2D resizeToFitText() {
        return resizeToFitText(null);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Rectangle2D resizeToFitText(Graphics2D graphics2D) {
        Rectangle2D anchor = getAnchor();
        if (anchor.getWidth() == 0.0d) {
            throw new POIXMLException("Anchor of the shape was not set.");
        }
        double textHeight = getTextHeight(graphics2D) + 1.0d;
        Insets2D insets = getInsets();
        anchor.setRect(anchor.getX(), anchor.getY(), anchor.getWidth(), insets.bottom + textHeight + insets.top);
        setAnchor(anchor);
        return anchor;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
        CTTextBody textBody = xSLFTextShape.getTextBody(false);
        CTTextBody textBody2 = getTextBody(true);
        if (textBody == null) {
            return;
        }
        textBody2.setBodyPr(textBody.getBodyPr().copy());
        if (textBody2.isSetLstStyle()) {
            textBody2.unsetLstStyle();
        }
        if (textBody.isSetLstStyle()) {
            textBody2.setLstStyle(textBody.getLstStyle().copy());
        }
        boolean wordWrap = xSLFTextShape.getWordWrap();
        if (wordWrap != getWordWrap()) {
            setWordWrap(wordWrap);
        }
        double leftInset = xSLFTextShape.getLeftInset();
        if (leftInset != getLeftInset()) {
            setLeftInset(leftInset);
        }
        double rightInset = xSLFTextShape.getRightInset();
        if (rightInset != getRightInset()) {
            setRightInset(rightInset);
        }
        double topInset = xSLFTextShape.getTopInset();
        if (topInset != getTopInset()) {
            setTopInset(topInset);
        }
        double bottomInset = xSLFTextShape.getBottomInset();
        if (bottomInset != getBottomInset()) {
            setBottomInset(bottomInset);
        }
        VerticalAlignment verticalAlignment = xSLFTextShape.getVerticalAlignment();
        if (verticalAlignment != getVerticalAlignment()) {
            setVerticalAlignment(verticalAlignment);
        }
        clearText();
        Iterator<XSLFTextParagraph> it = xSLFTextShape.getTextParagraphs().iterator();
        while (it.hasNext()) {
            addNewTextParagraph().copy(it.next());
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setTextPlaceholder(TextShape.TextPlaceholder textPlaceholder) {
        int i = AnonymousClass8.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[textPlaceholder.ordinal()];
        if (i == 5) {
            setPlaceholder(Placeholder.TITLE);
            return;
        }
        if (i == 6) {
            setPlaceholder(Placeholder.BODY);
            setHorizontalCentered(true);
        } else if (i == 7) {
            setPlaceholder(Placeholder.CENTERED_TITLE);
        } else if (i != 8) {
            setPlaceholder(Placeholder.BODY);
        } else {
            setPlaceholder(Placeholder.CONTENT);
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public TextShape.TextPlaceholder getTextPlaceholder() {
        Placeholder textType = getTextType();
        if (textType == null) {
            return TextShape.TextPlaceholder.BODY;
        }
        int i = AnonymousClass8.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[textType.ordinal()];
        if (i == 1) {
            return TextShape.TextPlaceholder.BODY;
        }
        if (i == 2) {
            return TextShape.TextPlaceholder.TITLE;
        }
        if (i == 3) {
            return TextShape.TextPlaceholder.CENTER_TITLE;
        }
        return TextShape.TextPlaceholder.OTHER;
    }

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTextShape$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.CENTERED_TITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TextShape.TextPlaceholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder = iArr2;
            try {
                iArr2[TextShape.TextPlaceholder.NOTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.HALF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.QUARTER_BODY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.CENTER_BODY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.CENTER_TITLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[TextShape.TextAutofit.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit = iArr3;
            try {
                iArr3[TextShape.TextAutofit.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit[TextShape.TextAutofit.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit[TextShape.TextAutofit.SHAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    protected XSLFTextParagraph newTextParagraph(CTTextParagraph cTTextParagraph) {
        return new XSLFTextParagraph(cTTextParagraph, this);
    }
}
