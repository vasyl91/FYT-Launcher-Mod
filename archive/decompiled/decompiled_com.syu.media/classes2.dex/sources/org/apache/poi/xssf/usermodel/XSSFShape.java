package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XSSFShape implements Shape {

    @Removal(version = "3.19")
    public static final int EMU_PER_PIXEL = 9525;

    @Removal(version = "3.19")
    public static final int EMU_PER_POINT = 12700;

    @Removal(version = "3.19")
    public static final int PIXEL_DPI = 96;

    @Removal(version = "3.19")
    public static final int POINT_DPI = 72;
    protected XSSFAnchor anchor;
    protected XSSFDrawing drawing;
    protected XSSFShapeGroup parent;

    protected abstract CTShapeProperties getShapeProperties();

    public XSSFDrawing getDrawing() {
        return this.drawing;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public XSSFShapeGroup getParent() {
        return this.parent;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public XSSFAnchor getAnchor() {
        return this.anchor;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public boolean isNoFill() {
        return getShapeProperties().isSetNoFill();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setNoFill(boolean z) {
        CTShapeProperties shapeProperties = getShapeProperties();
        if (shapeProperties.isSetPattFill()) {
            shapeProperties.unsetPattFill();
        }
        if (shapeProperties.isSetSolidFill()) {
            shapeProperties.unsetSolidFill();
        }
        shapeProperties.setNoFill(CTNoFillProperties.Factory.newInstance());
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setFillColor(int i, int i2, int i3) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTSolidColorFillProperties solidFill = shapeProperties.isSetSolidFill() ? shapeProperties.getSolidFill() : shapeProperties.addNewSolidFill();
        CTSRgbColor cTSRgbColorNewInstance = CTSRgbColor.Factory.newInstance();
        cTSRgbColorNewInstance.setVal(new byte[]{(byte) i, (byte) i2, (byte) i3});
        solidFill.setSrgbClr(cTSRgbColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setLineStyleColor(int i, int i2, int i3) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTLineProperties ln = shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn();
        CTSolidColorFillProperties solidFill = ln.isSetSolidFill() ? ln.getSolidFill() : ln.addNewSolidFill();
        CTSRgbColor cTSRgbColorNewInstance = CTSRgbColor.Factory.newInstance();
        cTSRgbColorNewInstance.setVal(new byte[]{(byte) i, (byte) i2, (byte) i3});
        solidFill.setSrgbClr(cTSRgbColorNewInstance);
    }

    public void setLineWidth(double d) {
        CTShapeProperties shapeProperties = getShapeProperties();
        (shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn()).setW((int) (d * 12700.0d));
    }

    public void setLineStyle(int i) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTLineProperties ln = shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn();
        CTPresetLineDashProperties cTPresetLineDashPropertiesNewInstance = CTPresetLineDashProperties.Factory.newInstance();
        cTPresetLineDashPropertiesNewInstance.setVal(STPresetLineDashVal.Enum.forInt(i + 1));
        ln.setPrstDash(cTPresetLineDashPropertiesNewInstance);
    }
}
