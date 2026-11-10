package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import module.canbus.FinalCanbus;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.SimpleShape;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVertOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFSimpleShape extends XSSFShape implements Iterable<XSSFTextParagraph>, SimpleShape {
    private static CTShape prototype;
    private final List<XSSFTextParagraph> _paragraphs;
    private CTShape ctShape;
    private static String[] _romanChars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] _romanAlphaValues = {1000, 900, 500, FinalCanbus.CAR_FYTA_JILI_XiongMiao, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    protected XSSFSimpleShape(XSSFDrawing xSSFDrawing, CTShape cTShape) {
        this.drawing = xSSFDrawing;
        this.ctShape = cTShape;
        this._paragraphs = new ArrayList();
        CTTextBody txBody = cTShape.getTxBody();
        if (txBody != null) {
            for (int i = 0; i < txBody.sizeOfPArray(); i++) {
                this._paragraphs.add(new XSSFTextParagraph(txBody.getPArray(i), cTShape));
            }
        }
    }

    protected static CTShape prototype() {
        if (prototype == null) {
            CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
            CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Shape 1");
            cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTShapeNewInstance.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            CTTextBody cTTextBodyAddNewTxBody = cTShapeNewInstance.addNewTxBody();
            CTTextBodyProperties cTTextBodyPropertiesAddNewBodyPr = cTTextBodyAddNewTxBody.addNewBodyPr();
            cTTextBodyPropertiesAddNewBodyPr.setAnchor(STTextAnchoringType.T);
            cTTextBodyPropertiesAddNewBodyPr.setRtlCol(false);
            CTTextParagraph cTTextParagraphAddNewP = cTTextBodyAddNewTxBody.addNewP();
            cTTextParagraphAddNewP.addNewPPr().setAlgn(STTextAlignType.L);
            CTTextCharacterProperties cTTextCharacterPropertiesAddNewEndParaRPr = cTTextParagraphAddNewP.addNewEndParaRPr();
            cTTextCharacterPropertiesAddNewEndParaRPr.setLang("en-US");
            cTTextCharacterPropertiesAddNewEndParaRPr.setSz(1100);
            cTTextCharacterPropertiesAddNewEndParaRPr.addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, 0});
            cTTextBodyAddNewTxBody.addNewLstStyle();
            prototype = cTShapeNewInstance;
        }
        return prototype;
    }

    @Internal
    public CTShape getCTShape() {
        return this.ctShape;
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFTextParagraph> iterator() {
        return this._paragraphs.iterator();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(9);
        for (int i = 0; i < 9; i++) {
            arrayList.add(0);
        }
        int iProcessAutoNumGroup = 0;
        while (iProcessAutoNumGroup < this._paragraphs.size()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            XSSFTextParagraph xSSFTextParagraph = this._paragraphs.get(iProcessAutoNumGroup);
            if (xSSFTextParagraph.isBullet() && xSSFTextParagraph.getText().length() > 0) {
                int iMin = Math.min(xSSFTextParagraph.getLevel(), 8);
                if (xSSFTextParagraph.isBulletAutoNumber()) {
                    iProcessAutoNumGroup = processAutoNumGroup(iProcessAutoNumGroup, iMin, arrayList, sb);
                } else {
                    for (int i2 = 0; i2 < iMin; i2++) {
                        sb.append('\t');
                    }
                    String bulletCharacter = xSSFTextParagraph.getBulletCharacter();
                    sb.append(bulletCharacter.length() > 0 ? bulletCharacter + " " : "- ");
                    sb.append(xSSFTextParagraph.getText());
                }
            } else {
                sb.append(xSSFTextParagraph.getText());
                for (int i3 = 0; i3 < 9; i3++) {
                    arrayList.set(i3, 0);
                }
            }
            iProcessAutoNumGroup++;
        }
        return sb.toString();
    }

    private int processAutoNumGroup(int i, int i2, List<Integer> list, StringBuilder sb) {
        XSSFTextParagraph xSSFTextParagraph = this._paragraphs.get(i);
        int bulletAutoNumberStart = xSSFTextParagraph.getBulletAutoNumberStart();
        ListAutoNumber bulletAutoNumberScheme = xSSFTextParagraph.getBulletAutoNumberScheme();
        if (list.get(i2).intValue() == 0) {
            list.set(i2, Integer.valueOf(bulletAutoNumberStart == 0 ? 1 : bulletAutoNumberStart));
        }
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append('\t');
        }
        if (xSSFTextParagraph.getText().length() > 0) {
            sb.append(getBulletPrefix(bulletAutoNumberScheme, list.get(i2).intValue()));
            sb.append(xSSFTextParagraph.getText());
        }
        while (true) {
            int i4 = i + 1;
            XSSFTextParagraph xSSFTextParagraph2 = i4 == this._paragraphs.size() ? null : this._paragraphs.get(i4);
            if (xSSFTextParagraph2 == null || !xSSFTextParagraph2.isBullet() || !xSSFTextParagraph.isBulletAutoNumber()) {
                break;
            }
            if (xSSFTextParagraph2.getLevel() > i2) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                i = processAutoNumGroup(i4, xSSFTextParagraph2.getLevel(), list, sb);
            } else {
                if (xSSFTextParagraph2.getLevel() < i2) {
                    break;
                }
                ListAutoNumber bulletAutoNumberScheme2 = xSSFTextParagraph2.getBulletAutoNumberScheme();
                int bulletAutoNumberStart2 = xSSFTextParagraph2.getBulletAutoNumberStart();
                if (bulletAutoNumberScheme2 != bulletAutoNumberScheme || bulletAutoNumberStart2 != bulletAutoNumberStart) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                for (int i5 = 0; i5 < i2; i5++) {
                    sb.append('\t');
                }
                if (xSSFTextParagraph2.getText().length() > 0) {
                    list.set(i2, Integer.valueOf(list.get(i2).intValue() + 1));
                    sb.append(getBulletPrefix(bulletAutoNumberScheme2, list.get(i2).intValue()));
                    sb.append(xSSFTextParagraph2.getText());
                }
                i = i4;
            }
        }
        list.set(i2, 0);
        return i;
    }

    private String getBulletPrefix(ListAutoNumber listAutoNumber, int i) {
        StringBuilder sb = new StringBuilder();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[listAutoNumber.ordinal()]) {
            case 1:
            case 2:
                if (listAutoNumber == ListAutoNumber.ALPHA_LC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToAlpha(i).toLowerCase(Locale.ROOT));
                sb.append(')');
                break;
            case 3:
            case 4:
                if (listAutoNumber == ListAutoNumber.ALPHA_UC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToAlpha(i));
                sb.append(')');
                break;
            case 5:
                sb.append(valueToAlpha(i).toLowerCase(Locale.ROOT));
                sb.append('.');
                break;
            case 6:
                sb.append(valueToAlpha(i));
                sb.append('.');
                break;
            case 7:
            case 8:
                if (listAutoNumber == ListAutoNumber.ARABIC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(i);
                sb.append(')');
                break;
            case 9:
                sb.append(i);
                sb.append('.');
                break;
            case 10:
                sb.append(i);
                break;
            case 11:
            case 12:
                if (listAutoNumber == ListAutoNumber.ROMAN_LC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToRoman(i).toLowerCase(Locale.ROOT));
                sb.append(')');
                break;
            case 13:
            case 14:
                if (listAutoNumber == ListAutoNumber.ROMAN_UC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToRoman(i));
                sb.append(')');
                break;
            case 15:
                sb.append(valueToRoman(i).toLowerCase(Locale.ROOT));
                sb.append('.');
                break;
            case 16:
                sb.append(valueToRoman(i));
                sb.append('.');
                break;
            default:
                sb.append(Typography.bullet);
                break;
        }
        sb.append(" ");
        return sb.toString();
    }

    private String valueToAlpha(int i) {
        String str = "";
        while (i > 0) {
            int i2 = (i - 1) % 26;
            str = ((char) (i2 + 65)) + str;
            i = (i - i2) / 26;
        }
        return str;
    }

    private String valueToRoman(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i > 0 && i2 < _romanChars.length; i2++) {
            while (_romanAlphaValues[i2] <= i) {
                sb.append(_romanChars[i2]);
                i -= _romanAlphaValues[i2];
            }
        }
        return sb.toString();
    }

    public void clearText() {
        this._paragraphs.clear();
        this.ctShape.getTxBody().setPArray((CTTextParagraph[]) null);
    }

    public void setText(String str) {
        clearText();
        addNewTextParagraph().addNewTextRun().setText(str);
    }

    public void setText(XSSFRichTextString xSSFRichTextString) {
        xSSFRichTextString.setStylesTableReference(((XSSFWorkbook) getDrawing().getParent().getParent()).getStylesSource());
        CTTextParagraph cTTextParagraphNewInstance = CTTextParagraph.Factory.newInstance();
        if (xSSFRichTextString.numFormattingRuns() == 0) {
            CTRegularTextRun cTRegularTextRunAddNewR = cTTextParagraphNewInstance.addNewR();
            CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr = cTRegularTextRunAddNewR.addNewRPr();
            cTTextCharacterPropertiesAddNewRPr.setLang("en-US");
            cTTextCharacterPropertiesAddNewRPr.setSz(1100);
            cTRegularTextRunAddNewR.setT(xSSFRichTextString.getString());
        } else {
            for (int i = 0; i < xSSFRichTextString.getCTRst().sizeOfRArray(); i++) {
                CTRElt rArray = xSSFRichTextString.getCTRst().getRArray(i);
                CTRPrElt rPr = rArray.getRPr();
                if (rPr == null) {
                    rPr = rArray.addNewRPr();
                }
                CTRegularTextRun cTRegularTextRunAddNewR2 = cTTextParagraphNewInstance.addNewR();
                CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr2 = cTRegularTextRunAddNewR2.addNewRPr();
                cTTextCharacterPropertiesAddNewRPr2.setLang("en-US");
                applyAttributes(rPr, cTTextCharacterPropertiesAddNewRPr2);
                cTRegularTextRunAddNewR2.setT(rArray.getT());
            }
        }
        clearText();
        this.ctShape.getTxBody().setPArray(new CTTextParagraph[]{cTTextParagraphNewInstance});
        this._paragraphs.add(new XSSFTextParagraph(this.ctShape.getTxBody().getPArray(0), this.ctShape));
    }

    public List<XSSFTextParagraph> getTextParagraphs() {
        return this._paragraphs;
    }

    public XSSFTextParagraph addNewTextParagraph() {
        XSSFTextParagraph xSSFTextParagraph = new XSSFTextParagraph(this.ctShape.getTxBody().addNewP(), this.ctShape);
        this._paragraphs.add(xSSFTextParagraph);
        return xSSFTextParagraph;
    }

    public XSSFTextParagraph addNewTextParagraph(String str) {
        XSSFTextParagraph xSSFTextParagraphAddNewTextParagraph = addNewTextParagraph();
        xSSFTextParagraphAddNewTextParagraph.addNewTextRun().setText(str);
        return xSSFTextParagraphAddNewTextParagraph;
    }

    public XSSFTextParagraph addNewTextParagraph(XSSFRichTextString xSSFRichTextString) {
        CTTextParagraph cTTextParagraphAddNewP = this.ctShape.getTxBody().addNewP();
        if (xSSFRichTextString.numFormattingRuns() == 0) {
            CTRegularTextRun cTRegularTextRunAddNewR = cTTextParagraphAddNewP.addNewR();
            CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr = cTRegularTextRunAddNewR.addNewRPr();
            cTTextCharacterPropertiesAddNewRPr.setLang("en-US");
            cTTextCharacterPropertiesAddNewRPr.setSz(1100);
            cTRegularTextRunAddNewR.setT(xSSFRichTextString.getString());
        } else {
            for (int i = 0; i < xSSFRichTextString.getCTRst().sizeOfRArray(); i++) {
                CTRElt rArray = xSSFRichTextString.getCTRst().getRArray(i);
                CTRPrElt rPr = rArray.getRPr();
                if (rPr == null) {
                    rPr = rArray.addNewRPr();
                }
                CTRegularTextRun cTRegularTextRunAddNewR2 = cTTextParagraphAddNewP.addNewR();
                CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr2 = cTRegularTextRunAddNewR2.addNewRPr();
                cTTextCharacterPropertiesAddNewRPr2.setLang("en-US");
                applyAttributes(rPr, cTTextCharacterPropertiesAddNewRPr2);
                cTRegularTextRunAddNewR2.setT(rArray.getT());
            }
        }
        XSSFTextParagraph xSSFTextParagraph = new XSSFTextParagraph(cTTextParagraphAddNewP, this.ctShape);
        this._paragraphs.add(xSSFTextParagraph);
        return xSSFTextParagraph;
    }

    public void setTextHorizontalOverflow(TextHorizontalOverflow textHorizontalOverflow) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (textHorizontalOverflow == null) {
                if (bodyPr.isSetHorzOverflow()) {
                    bodyPr.unsetHorzOverflow();
                    return;
                }
                return;
            }
            bodyPr.setHorzOverflow(STTextHorzOverflowType.Enum.forInt(textHorizontalOverflow.ordinal() + 1));
        }
    }

    public TextHorizontalOverflow getTextHorizontalOverflow() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null && bodyPr.isSetHorzOverflow()) {
            return TextHorizontalOverflow.values()[bodyPr.getHorzOverflow().intValue() - 1];
        }
        return TextHorizontalOverflow.OVERFLOW;
    }

    public void setTextVerticalOverflow(TextVerticalOverflow textVerticalOverflow) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (textVerticalOverflow == null) {
                if (bodyPr.isSetVertOverflow()) {
                    bodyPr.unsetVertOverflow();
                    return;
                }
                return;
            }
            bodyPr.setVertOverflow(STTextVertOverflowType.Enum.forInt(textVerticalOverflow.ordinal() + 1));
        }
    }

    public TextVerticalOverflow getTextVerticalOverflow() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null && bodyPr.isSetVertOverflow()) {
            return TextVerticalOverflow.values()[bodyPr.getVertOverflow().intValue() - 1];
        }
        return TextVerticalOverflow.OVERFLOW;
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (verticalAlignment == null) {
                if (bodyPr.isSetAnchor()) {
                    bodyPr.unsetAnchor();
                    return;
                }
                return;
            }
            bodyPr.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
        }
    }

    public VerticalAlignment getVerticalAlignment() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null && bodyPr.isSetAnchor()) {
            return VerticalAlignment.values()[bodyPr.getAnchor().intValue() - 1];
        }
        return VerticalAlignment.TOP;
    }

    public void setTextDirection(TextDirection textDirection) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (textDirection == null) {
                if (bodyPr.isSetVert()) {
                    bodyPr.unsetVert();
                    return;
                }
                return;
            }
            bodyPr.setVert(STTextVerticalType.Enum.forInt(textDirection.ordinal() + 1));
        }
    }

    public TextDirection getTextDirection() {
        STTextVerticalType.Enum vert;
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null && (vert = bodyPr.getVert()) != null) {
            return TextDirection.values()[vert.intValue() - 1];
        }
        return TextDirection.HORIZONTAL;
    }

    public double getBottomInset() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr == null || !bodyPr.isSetBIns()) {
            return 3.6d;
        }
        return Units.toPoints(bodyPr.getBIns());
    }

    public double getLeftInset() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr == null || !bodyPr.isSetLIns()) {
            return 3.6d;
        }
        return Units.toPoints(bodyPr.getLIns());
    }

    public double getRightInset() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr == null || !bodyPr.isSetRIns()) {
            return 3.6d;
        }
        return Units.toPoints(bodyPr.getRIns());
    }

    public double getTopInset() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr == null || !bodyPr.isSetTIns()) {
            return 3.6d;
        }
        return Units.toPoints(bodyPr.getTIns());
    }

    public void setBottomInset(double d) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (d == -1.0d) {
                if (bodyPr.isSetBIns()) {
                    bodyPr.unsetBIns();
                    return;
                }
                return;
            }
            bodyPr.setBIns(Units.toEMU(d));
        }
    }

    public void setLeftInset(double d) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (d == -1.0d) {
                if (bodyPr.isSetLIns()) {
                    bodyPr.unsetLIns();
                    return;
                }
                return;
            }
            bodyPr.setLIns(Units.toEMU(d));
        }
    }

    public void setRightInset(double d) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (d == -1.0d) {
                if (bodyPr.isSetRIns()) {
                    bodyPr.unsetRIns();
                    return;
                }
                return;
            }
            bodyPr.setRIns(Units.toEMU(d));
        }
    }

    public void setTopInset(double d) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (d == -1.0d) {
                if (bodyPr.isSetTIns()) {
                    bodyPr.unsetTIns();
                    return;
                }
                return;
            }
            bodyPr.setTIns(Units.toEMU(d));
        }
    }

    public boolean getWordWrap() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        return bodyPr == null || !bodyPr.isSetWrap() || bodyPr.getWrap() == STTextWrappingType.SQUARE;
    }

    public void setWordWrap(boolean z) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            bodyPr.setWrap(z ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
        }
    }

    public void setTextAutofit(TextAutofit textAutofit) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (bodyPr.isSetSpAutoFit()) {
                bodyPr.unsetSpAutoFit();
            }
            if (bodyPr.isSetNoAutofit()) {
                bodyPr.unsetNoAutofit();
            }
            if (bodyPr.isSetNormAutofit()) {
                bodyPr.unsetNormAutofit();
            }
            int i = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[textAutofit.ordinal()];
            if (i == 1) {
                bodyPr.addNewNoAutofit();
            } else if (i == 2) {
                bodyPr.addNewNormAutofit();
            } else {
                if (i != 3) {
                    return;
                }
                bodyPr.addNewSpAutoFit();
            }
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFSimpleShape$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit;

        static {
            int[] iArr = new int[TextAutofit.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit = iArr;
            try {
                iArr[TextAutofit.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[TextAutofit.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[TextAutofit.SHAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ListAutoNumber.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber = iArr2;
            try {
                iArr2[ListAutoNumber.ALPHA_LC_PARENT_BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_LC_PARENT_R.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PARENT_BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PARENT_R.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_LC_PERIOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PERIOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PARENT_BOTH.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PARENT_R.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PERIOD.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PLAIN.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PARENT_BOTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PARENT_R.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PARENT_BOTH.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PARENT_R.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PERIOD.ordinal()] = 15;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PERIOD.ordinal()] = 16;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public TextAutofit getTextAutofit() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (bodyPr.isSetNoAutofit()) {
                return TextAutofit.NONE;
            }
            if (bodyPr.isSetNormAutofit()) {
                return TextAutofit.NORMAL;
            }
            if (bodyPr.isSetSpAutoFit()) {
                return TextAutofit.SHAPE;
            }
        }
        return TextAutofit.NORMAL;
    }

    public int getShapeType() {
        return this.ctShape.getSpPr().getPrstGeom().getPrst().intValue();
    }

    public void setShapeType(int i) {
        this.ctShape.getSpPr().getPrstGeom().setPrst(STShapeType.Enum.forInt(i));
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    protected CTShapeProperties getShapeProperties() {
        return this.ctShape.getSpPr();
    }

    private static void applyAttributes(CTRPrElt cTRPrElt, CTTextCharacterProperties cTTextCharacterProperties) {
        HSSFColor hSSFColor;
        if (cTRPrElt.sizeOfBArray() > 0) {
            cTTextCharacterProperties.setB(cTRPrElt.getBArray(0).getVal());
        }
        if (cTRPrElt.sizeOfUArray() > 0) {
            STUnderlineValues.Enum val = cTRPrElt.getUArray(0).getVal();
            if (val == STUnderlineValues.SINGLE) {
                cTTextCharacterProperties.setU(STTextUnderlineType.SNG);
            } else if (val == STUnderlineValues.DOUBLE) {
                cTTextCharacterProperties.setU(STTextUnderlineType.DBL);
            } else if (val == STUnderlineValues.NONE) {
                cTTextCharacterProperties.setU(STTextUnderlineType.NONE);
            }
        }
        if (cTRPrElt.sizeOfIArray() > 0) {
            cTTextCharacterProperties.setI(cTRPrElt.getIArray(0).getVal());
        }
        if (cTRPrElt.sizeOfRFontArray() > 0) {
            (cTTextCharacterProperties.isSetLatin() ? cTTextCharacterProperties.getLatin() : cTTextCharacterProperties.addNewLatin()).setTypeface(cTRPrElt.getRFontArray(0).getVal());
        }
        if (cTRPrElt.sizeOfSzArray() > 0) {
            cTTextCharacterProperties.setSz((int) (cTRPrElt.getSzArray(0).getVal() * 100.0d));
        }
        if (cTRPrElt.sizeOfColorArray() > 0) {
            CTSolidColorFillProperties solidFill = cTTextCharacterProperties.isSetSolidFill() ? cTTextCharacterProperties.getSolidFill() : cTTextCharacterProperties.addNewSolidFill();
            CTColor colorArray = cTRPrElt.getColorArray(0);
            if (colorArray.isSetRgb()) {
                (solidFill.isSetSrgbClr() ? solidFill.getSrgbClr() : solidFill.addNewSrgbClr()).setVal(colorArray.getRgb());
            } else {
                if (!colorArray.isSetIndexed() || (hSSFColor = HSSFColor.getIndexHash().get(Integer.valueOf((int) colorArray.getIndexed()))) == null) {
                    return;
                }
                (solidFill.isSetSrgbClr() ? solidFill.getSrgbClr() : solidFill.addNewSrgbClr()).setVal(new byte[]{(byte) hSSFColor.getTriplet()[0], (byte) hSSFColor.getTriplet()[1], (byte) hSSFColor.getTriplet()[2]});
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.ctShape.getNvSpPr().getCNvPr().getName();
    }

    @Override // org.apache.poi.ss.usermodel.SimpleShape
    public int getShapeId() {
        return (int) this.ctShape.getNvSpPr().getCNvPr().getId();
    }
}
