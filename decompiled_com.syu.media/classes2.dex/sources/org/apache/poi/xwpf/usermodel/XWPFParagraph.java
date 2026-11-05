package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.poi.wp.usermodel.Paragraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFParagraph implements IBodyElement, IRunBody, ISDTContents, Paragraph {
    protected XWPFDocument document;
    private StringBuffer footnoteText = new StringBuffer();
    protected List<IRunElement> iruns;
    private final CTP paragraph;
    protected IBody part;
    protected List<XWPFRun> runs;

    public XWPFParagraph(CTP ctp, IBody iBody) {
        this.paragraph = ctp;
        this.part = iBody;
        XWPFDocument xWPFDocument = iBody.getXWPFDocument();
        this.document = xWPFDocument;
        xWPFDocument.getClass();
        this.runs = new ArrayList();
        this.iruns = new ArrayList();
        buildRunsInOrderFromXml(ctp);
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            XmlCursor xmlCursorNewCursor = it.next().getCTR().newCursor();
            xmlCursorNewCursor.selectPath("child::*");
            while (xmlCursorNewCursor.toNextSelection()) {
                CTFtnEdnRef object = xmlCursorNewCursor.getObject();
                if (object instanceof CTFtnEdnRef) {
                    CTFtnEdnRef cTFtnEdnRef = object;
                    this.footnoteText.append(" [").append(cTFtnEdnRef.getId()).append(": ");
                    boolean z = true;
                    for (XWPFParagraph xWPFParagraph : (cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? this.document.getFootnoteByID(cTFtnEdnRef.getId().intValue()) : this.document.getEndnoteByID(cTFtnEdnRef.getId().intValue())).getParagraphs()) {
                        if (!z) {
                            this.footnoteText.append("\n");
                        }
                        this.footnoteText.append(xWPFParagraph.getText());
                        z = false;
                    }
                    this.footnoteText.append("] ");
                }
            }
            xmlCursorNewCursor.dispose();
        }
    }

    private void buildRunsInOrderFromXml(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        xmlCursorNewCursor.selectPath("child::*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTR object = xmlCursorNewCursor.getObject();
            if (object instanceof CTR) {
                XWPFRun xWPFRun = new XWPFRun(object, this);
                this.runs.add(xWPFRun);
                this.iruns.add(xWPFRun);
            }
            if (object instanceof CTHyperlink) {
                CTHyperlink cTHyperlink = (CTHyperlink) object;
                for (CTR ctr : cTHyperlink.getRArray()) {
                    XWPFHyperlinkRun xWPFHyperlinkRun = new XWPFHyperlinkRun(cTHyperlink, ctr, this);
                    this.runs.add(xWPFHyperlinkRun);
                    this.iruns.add(xWPFHyperlinkRun);
                }
            }
            if (object instanceof CTSimpleField) {
                CTSimpleField cTSimpleField = (CTSimpleField) object;
                for (CTR ctr2 : cTSimpleField.getRArray()) {
                    XWPFFieldRun xWPFFieldRun = new XWPFFieldRun(cTSimpleField, ctr2, this);
                    this.runs.add(xWPFFieldRun);
                    this.iruns.add(xWPFFieldRun);
                }
            }
            if (object instanceof CTSdtBlock) {
                this.iruns.add(new XWPFSDT((CTSdtBlock) object, this.part));
            }
            if (object instanceof CTSdtRun) {
                this.iruns.add(new XWPFSDT((CTSdtRun) object, this.part));
            }
            if (object instanceof CTRunTrackChange) {
                for (CTR ctr3 : ((CTRunTrackChange) object).getRArray()) {
                    XWPFRun xWPFRun2 = new XWPFRun(ctr3, this);
                    this.runs.add(xWPFRun2);
                    this.iruns.add(xWPFRun2);
                }
            }
            if (object instanceof CTSmartTagRun) {
                buildRunsInOrderFromXml(object);
            }
        }
        xmlCursorNewCursor.dispose();
    }

    @Internal
    public CTP getCTP() {
        return this.paragraph;
    }

    public List<XWPFRun> getRuns() {
        return Collections.unmodifiableList(this.runs);
    }

    public List<IRunElement> getIRuns() {
        return Collections.unmodifiableList(this.iruns);
    }

    public boolean isEmpty() {
        return !this.paragraph.getDomNode().hasChildNodes();
    }

    @Override // org.apache.poi.xwpf.usermodel.IRunBody
    public XWPFDocument getDocument() {
        return this.document;
    }

    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        for (IRunElement iRunElement : this.iruns) {
            if (iRunElement instanceof XWPFRun) {
                XWPFRun xWPFRun = (XWPFRun) iRunElement;
                if (!xWPFRun.getCTR().isSetRsidDel()) {
                    stringBuffer.append(xWPFRun);
                }
            } else if (iRunElement instanceof XWPFSDT) {
                stringBuffer.append(((XWPFSDT) iRunElement).getContent().getText());
            } else {
                stringBuffer.append(iRunElement);
            }
        }
        stringBuffer.append(this.footnoteText);
        return stringBuffer.toString();
    }

    public String getStyleID() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getPStyle() == null || this.paragraph.getPPr().getPStyle().getVal() == null) {
            return null;
        }
        return this.paragraph.getPPr().getPStyle().getVal();
    }

    public BigInteger getNumID() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getNumPr() == null || this.paragraph.getPPr().getNumPr().getNumId() == null) {
            return null;
        }
        return this.paragraph.getPPr().getNumPr().getNumId().getVal();
    }

    public void setNumID(BigInteger bigInteger) {
        if (this.paragraph.getPPr() == null) {
            this.paragraph.addNewPPr();
        }
        if (this.paragraph.getPPr().getNumPr() == null) {
            this.paragraph.getPPr().addNewNumPr();
        }
        if (this.paragraph.getPPr().getNumPr().getNumId() == null) {
            this.paragraph.getPPr().getNumPr().addNewNumId();
        }
        this.paragraph.getPPr().getNumPr().getNumId().setVal(bigInteger);
    }

    public BigInteger getNumIlvl() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getNumPr() == null || this.paragraph.getPPr().getNumPr().getIlvl() == null) {
            return null;
        }
        return this.paragraph.getPPr().getNumPr().getIlvl().getVal();
    }

    public String getNumFmt() {
        XWPFNum num;
        CTLvl lvlArray;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID != null && numbering != null && (num = numbering.getNum(numID)) != null) {
            BigInteger numIlvl = getNumIlvl();
            CTAbstractNum abstractNum = numbering.getAbstractNum(num.getCTNum().getAbstractNumId().getVal()).getAbstractNum();
            int i = 0;
            while (true) {
                if (i >= abstractNum.sizeOfLvlArray()) {
                    lvlArray = null;
                    break;
                }
                lvlArray = abstractNum.getLvlArray(i);
                if (lvlArray.getIlvl().equals(numIlvl)) {
                    break;
                }
                i++;
            }
            if (lvlArray != null && lvlArray.getNumFmt() != null && lvlArray.getNumFmt().getVal() != null) {
                return lvlArray.getNumFmt().getVal().toString();
            }
        }
        return null;
    }

    public String getNumLevelText() {
        XWPFNum num;
        CTDecimalNumber abstractNumId;
        BigInteger val;
        XWPFAbstractNum abstractNum;
        CTAbstractNum cTAbstractNum;
        CTLvl lvlArray;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID != null && numbering != null && (num = numbering.getNum(numID)) != null) {
            BigInteger numIlvl = getNumIlvl();
            CTNum cTNum = num.getCTNum();
            if (cTNum == null || (abstractNumId = cTNum.getAbstractNumId()) == null || (val = abstractNumId.getVal()) == null || (abstractNum = numbering.getAbstractNum(val)) == null || (cTAbstractNum = abstractNum.getCTAbstractNum()) == null) {
                return null;
            }
            int i = 0;
            while (true) {
                if (i >= cTAbstractNum.sizeOfLvlArray()) {
                    lvlArray = null;
                    break;
                }
                lvlArray = cTAbstractNum.getLvlArray(i);
                if (lvlArray != null && lvlArray.getIlvl() != null && lvlArray.getIlvl().equals(numIlvl)) {
                    break;
                }
                i++;
            }
            if (lvlArray != null && lvlArray.getLvlText() != null && lvlArray.getLvlText().getVal() != null) {
                return lvlArray.getLvlText().getVal().toString();
            }
        }
        return null;
    }

    public BigInteger getNumStartOverride() {
        XWPFNum num;
        CTNum cTNum;
        CTNumLvl lvlOverrideArray;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID == null || numbering == null || (num = numbering.getNum(numID)) == null || (cTNum = num.getCTNum()) == null) {
            return null;
        }
        BigInteger numIlvl = getNumIlvl();
        int i = 0;
        while (true) {
            if (i >= cTNum.sizeOfLvlOverrideArray()) {
                lvlOverrideArray = null;
                break;
            }
            lvlOverrideArray = cTNum.getLvlOverrideArray(i);
            if (lvlOverrideArray != null && lvlOverrideArray.getIlvl() != null && lvlOverrideArray.getIlvl().equals(numIlvl)) {
                break;
            }
            i++;
        }
        if (lvlOverrideArray != null && lvlOverrideArray.getStartOverride() != null) {
            return lvlOverrideArray.getStartOverride().getVal();
        }
        return null;
    }

    public String getParagraphText() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    public String getPictureText() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getPictureText());
        }
        return stringBuffer.toString();
    }

    public String getFootnoteText() {
        return this.footnoteText.toString();
    }

    public ParagraphAlignment getAlignment() {
        CTPPr cTPPr = getCTPPr();
        return (cTPPr == null || !cTPPr.isSetJc()) ? ParagraphAlignment.LEFT : ParagraphAlignment.valueOf(cTPPr.getJc().getVal().intValue());
    }

    public void setAlignment(ParagraphAlignment paragraphAlignment) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetJc() ? cTPPr.getJc() : cTPPr.addNewJc()).setVal(STJc.Enum.forInt(paragraphAlignment.getValue()));
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getFontAlignment() {
        return getAlignment().getValue();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setFontAlignment(int i) {
        setAlignment(ParagraphAlignment.valueOf(i));
    }

    public TextAlignment getVerticalAlignment() {
        CTPPr cTPPr = getCTPPr();
        return (cTPPr == null || !cTPPr.isSetTextAlignment()) ? TextAlignment.AUTO : TextAlignment.valueOf(cTPPr.getTextAlignment().getVal().intValue());
    }

    public void setVerticalAlignment(TextAlignment textAlignment) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetTextAlignment() ? cTPPr.getTextAlignment() : cTPPr.addNewTextAlignment()).setVal(STTextAlignment.Enum.forInt(textAlignment.getValue()));
    }

    public Borders getBorderTop() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder top = cTPBrd != null ? cTPBrd.getTop() : null;
        return Borders.valueOf((top != null ? top.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderTop(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        if (cTPBrd == null) {
            throw new RuntimeException("invalid paragraph state");
        }
        CTBorder top = cTPBrd.isSetTop() ? cTPBrd.getTop() : cTPBrd.addNewTop();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetTop();
        } else {
            top.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderBottom() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder bottom = cTPBrd != null ? cTPBrd.getBottom() : null;
        return Borders.valueOf((bottom != null ? bottom.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderBottom(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder bottom = cTPBrd.isSetBottom() ? cTPBrd.getBottom() : cTPBrd.addNewBottom();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetBottom();
        } else {
            bottom.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderLeft() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder left = cTPBrd != null ? cTPBrd.getLeft() : null;
        return Borders.valueOf((left != null ? left.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderLeft(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder left = cTPBrd.isSetLeft() ? cTPBrd.getLeft() : cTPBrd.addNewLeft();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetLeft();
        } else {
            left.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderRight() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder right = cTPBrd != null ? cTPBrd.getRight() : null;
        return Borders.valueOf((right != null ? right.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderRight(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder right = cTPBrd.isSetRight() ? cTPBrd.getRight() : cTPBrd.addNewRight();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetRight();
        } else {
            right.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderBetween() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder between = cTPBrd != null ? cTPBrd.getBetween() : null;
        return Borders.valueOf((between != null ? between.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderBetween(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder between = cTPBrd.isSetBetween() ? cTPBrd.getBetween() : cTPBrd.addNewBetween();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetBetween();
        } else {
            between.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public boolean isPageBreak() {
        CTPPr cTPPr = getCTPPr();
        CTOnOff pageBreakBefore = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : null;
        if (pageBreakBefore == null) {
            return false;
        }
        return isTruelike(pageBreakBefore.getVal(), false);
    }

    private static boolean isTruelike(STOnOff.Enum r0, boolean z) {
        if (r0 == null) {
            return z;
        }
        switch (r0.intValue()) {
            case 1:
            case 3:
            case 6:
                return true;
            case 2:
            case 4:
            case 5:
                return false;
            default:
                return z;
        }
    }

    public void setPageBreak(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTOnOff pageBreakBefore = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : cTPPr.addNewPageBreakBefore();
        if (z) {
            pageBreakBefore.setVal(STOnOff.TRUE);
        } else {
            pageBreakBefore.setVal(STOnOff.FALSE);
        }
    }

    public int getSpacingAfter() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetAfter()) {
            return -1;
        }
        return cTSpacing.getAfter().intValue();
    }

    public void setSpacingAfter(int i) {
        CTSpacing cTSpacing = getCTSpacing(true);
        if (cTSpacing != null) {
            cTSpacing.setAfter(new BigInteger("" + i));
        }
    }

    public int getSpacingAfterLines() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetAfterLines()) {
            return -1;
        }
        return cTSpacing.getAfterLines().intValue();
    }

    public void setSpacingAfterLines(int i) {
        getCTSpacing(true).setAfterLines(new BigInteger("" + i));
    }

    public int getSpacingBefore() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetBefore()) {
            return -1;
        }
        return cTSpacing.getBefore().intValue();
    }

    public void setSpacingBefore(int i) {
        getCTSpacing(true).setBefore(new BigInteger("" + i));
    }

    public int getSpacingBeforeLines() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetBeforeLines()) {
            return -1;
        }
        return cTSpacing.getBeforeLines().intValue();
    }

    public void setSpacingBeforeLines(int i) {
        getCTSpacing(true).setBeforeLines(new BigInteger("" + i));
    }

    public LineSpacingRule getSpacingLineRule() {
        CTSpacing cTSpacing = getCTSpacing(false);
        return (cTSpacing == null || !cTSpacing.isSetLineRule()) ? LineSpacingRule.AUTO : LineSpacingRule.valueOf(cTSpacing.getLineRule().intValue());
    }

    public void setSpacingLineRule(LineSpacingRule lineSpacingRule) {
        getCTSpacing(true).setLineRule(STLineSpacingRule.Enum.forInt(lineSpacingRule.getValue()));
    }

    public double getSpacingBetween() {
        double dDoubleValue;
        double dDoubleValue2;
        double d;
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetLine()) {
            return -1.0d;
        }
        if (cTSpacing.getLineRule() == null || cTSpacing.getLineRule() == STLineSpacingRule.AUTO) {
            BigInteger[] bigIntegerArrDivideAndRemainder = cTSpacing.getLine().divideAndRemainder(BigInteger.valueOf(240L));
            dDoubleValue = bigIntegerArrDivideAndRemainder[0].doubleValue();
            dDoubleValue2 = bigIntegerArrDivideAndRemainder[1].doubleValue();
            d = 240.0d;
        } else {
            BigInteger[] bigIntegerArrDivideAndRemainder2 = cTSpacing.getLine().divideAndRemainder(BigInteger.valueOf(20L));
            dDoubleValue = bigIntegerArrDivideAndRemainder2[0].doubleValue();
            dDoubleValue2 = bigIntegerArrDivideAndRemainder2[1].doubleValue();
            d = 20.0d;
        }
        return dDoubleValue + (dDoubleValue2 / d);
    }

    /* JADX INFO: renamed from: org.apache.poi.xwpf.usermodel.XWPFParagraph$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xwpf$usermodel$LineSpacingRule;

        static {
            int[] iArr = new int[LineSpacingRule.values().length];
            $SwitchMap$org$apache$poi$xwpf$usermodel$LineSpacingRule = iArr;
            try {
                iArr[LineSpacingRule.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void setSpacingBetween(double d, LineSpacingRule lineSpacingRule) {
        CTSpacing cTSpacing = getCTSpacing(true);
        if (AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$LineSpacingRule[lineSpacingRule.ordinal()] == 1) {
            cTSpacing.setLine(new BigInteger(String.valueOf(Math.round(d * 240.0d))));
        } else {
            cTSpacing.setLine(new BigInteger(String.valueOf(Math.round(d * 20.0d))));
        }
        cTSpacing.setLineRule(STLineSpacingRule.Enum.forInt(lineSpacingRule.getValue()));
    }

    public void setSpacingBetween(double d) {
        setSpacingBetween(d, LineSpacingRule.AUTO);
    }

    public int getIndentationLeft() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetLeft()) {
            return -1;
        }
        return cTInd.getLeft().intValue();
    }

    public void setIndentationLeft(int i) {
        getCTInd(true).setLeft(new BigInteger("" + i));
    }

    public int getIndentationRight() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetRight()) {
            return -1;
        }
        return cTInd.getRight().intValue();
    }

    public void setIndentationRight(int i) {
        getCTInd(true).setRight(new BigInteger("" + i));
    }

    public int getIndentationHanging() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetHanging()) {
            return -1;
        }
        return cTInd.getHanging().intValue();
    }

    public void setIndentationHanging(int i) {
        getCTInd(true).setHanging(new BigInteger("" + i));
    }

    public int getIndentationFirstLine() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetFirstLine()) {
            return -1;
        }
        return cTInd.getFirstLine().intValue();
    }

    public void setIndentationFirstLine(int i) {
        getCTInd(true).setFirstLine(new BigInteger("" + i));
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getIndentFromLeft() {
        return getIndentationLeft();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setIndentFromLeft(int i) {
        setIndentationLeft(i);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getIndentFromRight() {
        return getIndentationRight();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setIndentFromRight(int i) {
        setIndentationRight(i);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getFirstLineIndent() {
        return getIndentationFirstLine();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setFirstLineIndent(int i) {
        setIndentationFirstLine(i);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public boolean isWordWrapped() {
        CTOnOff wordWrap = getCTPPr().isSetWordWrap() ? getCTPPr().getWordWrap() : null;
        if (wordWrap != null) {
            return wordWrap.getVal() == STOnOff.ON || wordWrap.getVal() == STOnOff.TRUE || wordWrap.getVal() == STOnOff.X_1;
        }
        return false;
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setWordWrapped(boolean z) {
        CTOnOff wordWrap = getCTPPr().isSetWordWrap() ? getCTPPr().getWordWrap() : getCTPPr().addNewWordWrap();
        if (z) {
            wordWrap.setVal(STOnOff.TRUE);
        } else {
            wordWrap.unsetVal();
        }
    }

    public boolean isWordWrap() {
        return isWordWrapped();
    }

    @Deprecated
    public void setWordWrap(boolean z) {
        setWordWrapped(z);
    }

    public String getStyle() {
        CTPPr cTPPr = getCTPPr();
        CTString pStyle = cTPPr.isSetPStyle() ? cTPPr.getPStyle() : null;
        if (pStyle != null) {
            return pStyle.getVal();
        }
        return null;
    }

    public void setStyle(String str) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.getPStyle() != null ? cTPPr.getPStyle() : cTPPr.addNewPStyle()).setVal(str);
    }

    private CTPBdr getCTPBrd(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTPBdr pBdr = cTPPr.isSetPBdr() ? cTPPr.getPBdr() : null;
        return (z && pBdr == null) ? cTPPr.addNewPBdr() : pBdr;
    }

    private CTSpacing getCTSpacing(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTSpacing spacing = cTPPr.getSpacing() == null ? null : cTPPr.getSpacing();
        return (z && spacing == null) ? cTPPr.addNewSpacing() : spacing;
    }

    private CTInd getCTInd(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTInd ind = cTPPr.getInd() == null ? null : cTPPr.getInd();
        return (z && ind == null) ? cTPPr.addNewInd() : ind;
    }

    private CTPPr getCTPPr() {
        return this.paragraph.getPPr() == null ? this.paragraph.addNewPPr() : this.paragraph.getPPr();
    }

    protected void addRun(CTR ctr) {
        int iSizeOfRArray = this.paragraph.sizeOfRArray();
        this.paragraph.addNewR();
        this.paragraph.setRArray(iSizeOfRArray, ctr);
    }

    public XWPFRun createRun() {
        XWPFRun xWPFRun = new XWPFRun(this.paragraph.addNewR(), (IRunBody) this);
        this.runs.add(xWPFRun);
        this.iruns.add(xWPFRun);
        return xWPFRun;
    }

    public XWPFRun insertNewRun(int i) {
        if (i < 0 || i > this.runs.size()) {
            return null;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            XWPFRun xWPFRun = this.runs.get(i3);
            if (!(xWPFRun instanceof XWPFHyperlinkRun) && !(xWPFRun instanceof XWPFFieldRun)) {
                i2++;
            }
        }
        XWPFRun xWPFRun2 = new XWPFRun(this.paragraph.insertNewR(i2), (IRunBody) this);
        int size = this.iruns.size();
        if (i < this.runs.size()) {
            int iIndexOf = this.iruns.indexOf(this.runs.get(i));
            if (iIndexOf != -1) {
                size = iIndexOf;
            }
        }
        this.iruns.add(size, xWPFRun2);
        this.runs.add(i, xWPFRun2);
        return xWPFRun2;
    }

    public TextSegement searchText(String str, PositionInParagraph positionInParagraph) {
        int i;
        int i2;
        int run = positionInParagraph.getRun();
        int text = positionInParagraph.getText();
        int i3 = positionInParagraph.getChar();
        CTR[] rArray = this.paragraph.getRArray();
        int i4 = run;
        int i5 = 0;
        boolean z = false;
        int i6 = 0;
        while (i4 < rArray.length) {
            XmlCursor xmlCursorNewCursor = rArray[i4].newCursor();
            xmlCursorNewCursor.selectPath("./*");
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (xmlCursorNewCursor.toNextSelection()) {
                try {
                    CTText object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTText) {
                        if (i7 >= text) {
                            String stringValue = object.getStringValue();
                            int i10 = i4 == run ? i3 : 0;
                            while (i10 < stringValue.length()) {
                                int i11 = text;
                                int i12 = i3;
                                if (stringValue.charAt(i10) == str.charAt(0) && i5 == 0) {
                                    z = true;
                                    i6 = i4;
                                    i8 = i7;
                                    i9 = i10;
                                }
                                if (stringValue.charAt(i10) == str.charAt(i5)) {
                                    int i13 = i5 + 1;
                                    if (i13 < str.length()) {
                                        i5 = i13;
                                    } else if (z) {
                                        TextSegement textSegement = new TextSegement();
                                        textSegement.setBeginRun(i6);
                                        textSegement.setBeginText(i8);
                                        textSegement.setBeginChar(i9);
                                        textSegement.setEndRun(i4);
                                        textSegement.setEndText(i7);
                                        textSegement.setEndChar(i10);
                                        xmlCursorNewCursor.dispose();
                                        return textSegement;
                                    }
                                } else {
                                    i5 = 0;
                                }
                                i10++;
                                i3 = i12;
                                text = i11;
                            }
                        } else {
                            run = run;
                        }
                        i = text;
                        i2 = i3;
                        i7++;
                    } else {
                        run = run;
                        i = text;
                        i2 = i3;
                        if (object instanceof CTProofErr) {
                            xmlCursorNewCursor.removeXml();
                        } else if (!(object instanceof CTRPr)) {
                            i5 = 0;
                        }
                    }
                    i3 = i2;
                    run = run;
                    text = i;
                } catch (Throwable th) {
                    xmlCursorNewCursor.dispose();
                    throw th;
                }
            }
            xmlCursorNewCursor.dispose();
            i4++;
            i3 = i3;
            run = run;
            text = text;
        }
        return null;
    }

    public String getText(TextSegement textSegement) {
        int beginRun = textSegement.getBeginRun();
        int beginText = textSegement.getBeginText();
        int beginChar = textSegement.getBeginChar();
        int endRun = textSegement.getEndRun();
        int endText = textSegement.getEndText();
        int endChar = textSegement.getEndChar();
        StringBuilder sb = new StringBuilder();
        CTR[] rArray = this.paragraph.getRArray();
        int i = beginRun;
        while (i <= endRun) {
            CTText[] tArray = rArray[i].getTArray();
            int length = tArray.length - 1;
            int i2 = i == beginRun ? beginText : 0;
            if (i == endRun) {
                length = endText;
            }
            while (i2 <= length) {
                String stringValue = tArray[i2].getStringValue();
                int length2 = stringValue.length() - 1;
                int i3 = (i2 == beginText && i == beginRun) ? beginChar : 0;
                if (i2 == endText && i == endRun) {
                    length2 = endChar;
                }
                sb.append(stringValue.substring(i3, length2 + 1));
                i2++;
            }
            i++;
        }
        return sb.toString();
    }

    public boolean removeRun(int i) {
        if (i < 0 || i >= this.runs.size()) {
            return false;
        }
        XWPFRun xWPFRun = this.runs.get(i);
        if ((xWPFRun instanceof XWPFHyperlinkRun) || (xWPFRun instanceof XWPFFieldRun)) {
            throw new IllegalArgumentException("Removing Field or Hyperlink runs not yet supported");
        }
        this.runs.remove(i);
        this.iruns.remove(xWPFRun);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            XWPFRun xWPFRun2 = this.runs.get(i3);
            if (!(xWPFRun2 instanceof XWPFHyperlinkRun) && !(xWPFRun2 instanceof XWPFFieldRun)) {
                i2++;
            }
        }
        getCTP().removeR(i2);
        return true;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyElementType getElementType() {
        return BodyElementType.PARAGRAPH;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public IBody getBody() {
        return this.part;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement, org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody iBody = this.part;
        if (iBody != null) {
            return iBody.getPart();
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyType getPartType() {
        return this.part.getPartType();
    }

    public void addRun(XWPFRun xWPFRun) {
        if (this.runs.contains(xWPFRun)) {
            return;
        }
        this.runs.add(xWPFRun);
    }

    public XWPFRun getRun(CTR ctr) {
        for (int i = 0; i < getRuns().size(); i++) {
            if (getRuns().get(i).getCTR() == ctr) {
                return getRuns().get(i);
            }
        }
        return null;
    }
}
