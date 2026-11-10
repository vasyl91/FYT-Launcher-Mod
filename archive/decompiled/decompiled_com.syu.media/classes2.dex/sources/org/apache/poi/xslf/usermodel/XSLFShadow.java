package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.Shadow;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFShadow extends XSLFShape implements Shadow<XSLFShape, XSLFTextParagraph> {
    private XSLFSimpleShape _parent;

    XSLFShadow(CTOuterShadowEffect cTOuterShadowEffect, XSLFSimpleShape xSLFSimpleShape) {
        super(cTOuterShadowEffect, xSLFSimpleShape.getSheet());
        this._parent = xSLFSimpleShape;
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public XSLFSimpleShape getShadowParent() {
        return this._parent;
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        return this._parent.getAnchor();
    }

    public void setAnchor(Rectangle2D rectangle2D) {
        throw new IllegalStateException("You can't set anchor of a shadow");
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public double getDistance() {
        CTOuterShadowEffect xmlObject = getXmlObject();
        if (xmlObject.isSetDist()) {
            return Units.toPoints(xmlObject.getDist());
        }
        return 0.0d;
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public double getAngle() {
        CTOuterShadowEffect xmlObject = getXmlObject();
        if (xmlObject.isSetDir()) {
            return ((double) xmlObject.getDir()) / 60000.0d;
        }
        return 0.0d;
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public double getBlur() {
        CTOuterShadowEffect xmlObject = getXmlObject();
        if (xmlObject.isSetBlurRad()) {
            return Units.toPoints(xmlObject.getBlurRad());
        }
        return 0.0d;
    }

    public Color getFillColor() {
        PaintStyle.SolidPaint fillStyle = getFillStyle();
        if (fillStyle == null) {
            return null;
        }
        return DrawPaint.applyColorTransform(fillStyle.getSolidColor());
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public PaintStyle.SolidPaint getFillStyle() {
        XSLFTheme theme = getSheet().getTheme();
        CTOuterShadowEffect xmlObject = getXmlObject();
        if (xmlObject == null) {
            return null;
        }
        return DrawPaint.createSolidPaint(new XSLFColor(xmlObject, theme, xmlObject.getSchemeClr()).getColorStyle());
    }
}
