package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFBackground extends XSLFSimpleShape implements Background<XSLFShape, XSLFTextParagraph> {
    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    protected CTTransform2D getXfrm(boolean z) {
        return null;
    }

    XSLFBackground(CTBackground cTBackground, XSLFSheet xSLFSheet) {
        super(cTBackground, xSLFSheet);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        Dimension pageSize = getSheet().getSlideShow().getPageSize();
        return new Rectangle2D.Double(0.0d, 0.0d, pageSize.getWidth(), pageSize.getHeight());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        throw new POIXMLException("Can't set a placeholder for a background");
    }

    protected CTBackgroundProperties getBgPr(boolean z) {
        CTBackground xmlObject = getXmlObject();
        if (!xmlObject.isSetBgPr() && z) {
            if (xmlObject.isSetBgRef()) {
                xmlObject.unsetBgRef();
            }
            return xmlObject.addNewBgPr();
        }
        return xmlObject.getBgPr();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setFillColor(Color color) {
        CTBackgroundProperties bgPr = getBgPr(true);
        if (color == null) {
            if (bgPr.isSetSolidFill()) {
                bgPr.unsetSolidFill();
            }
            if (bgPr.isSetNoFill()) {
                return;
            }
            bgPr.addNewNoFill();
            return;
        }
        if (bgPr.isSetNoFill()) {
            bgPr.unsetNoFill();
        }
        CTSolidColorFillProperties solidFill = bgPr.isSetSolidFill() ? bgPr.getSolidFill() : bgPr.addNewSolidFill();
        new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr()).setColor(color);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    protected XmlObject getShapeProperties() {
        CTBackground xmlObject = getXmlObject();
        if (xmlObject.isSetBgPr()) {
            return xmlObject.getBgPr();
        }
        if (xmlObject.isSetBgRef()) {
            return xmlObject.getBgRef();
        }
        return null;
    }
}
