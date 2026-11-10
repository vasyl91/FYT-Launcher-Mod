package org.apache.poi.xslf.usermodel;

import java.awt.Insets;
import java.net.URI;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFPictureShape extends XSLFSimpleShape implements PictureShape<XSLFShape, XSLFTextParagraph> {
    private XSLFPictureData _data;

    XSLFPictureShape(CTPicture cTPicture, XSLFSheet xSLFSheet) {
        super(cTPicture, xSLFSheet);
    }

    static CTPicture prototype(int i, String str) {
        CTPicture cTPictureNewInstance = CTPicture.Factory.newInstance();
        CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPictureNewInstance.addNewNvPicPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
        cTPictureNonVisualAddNewNvPicPr.addNewNvPr();
        CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPictureNewInstance.addNewBlipFill();
        cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(str);
        cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTPictureNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        return cTPictureNewInstance;
    }

    public boolean isExternalLinkedPicture() {
        return getBlipId() == null && getBlipLink() != null;
    }

    @Override // org.apache.poi.sl.usermodel.PictureShape
    public XSLFPictureData getPictureData() {
        if (this._data == null) {
            String blipId = getBlipId();
            if (blipId == null) {
                return null;
            }
            PackagePart packagePart = getSheet().getPackagePart();
            PackageRelationship relationship = packagePart.getRelationship(blipId);
            if (relationship != null) {
                try {
                    this._data = new XSLFPictureData(packagePart.getRelatedPart(relationship));
                } catch (Exception e) {
                    throw new POIXMLException(e);
                }
            }
        }
        return this._data;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        super.setPlaceholder(placeholder);
    }

    public URI getPictureLink() {
        String blipLink;
        PackageRelationship relationship;
        if (getBlipId() != null || (blipLink = getBlipLink()) == null || (relationship = getSheet().getPackagePart().getRelationship(blipLink)) == null) {
            return null;
        }
        return relationship.getTargetURI();
    }

    protected CTBlipFillProperties getBlipFill() {
        CTBlipFillProperties blipFill = getXmlObject().getBlipFill();
        if (blipFill != null) {
            return blipFill;
        }
        try {
            return CTPicture.Factory.parse(selectProperty(XmlObject.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main'; declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' .//mc:Fallback/p:blipFill").getDomNode()).getBlipFill();
        } catch (XmlException unused) {
            return null;
        }
    }

    protected CTBlip getBlip() {
        return getBlipFill().getBlip();
    }

    protected String getBlipLink() {
        String link = getBlip().getLink();
        if (link.isEmpty()) {
            return null;
        }
        return link;
    }

    protected String getBlipId() {
        String embed = getBlip().getEmbed();
        if (embed.isEmpty()) {
            return null;
        }
        return embed;
    }

    @Override // org.apache.poi.sl.usermodel.PictureShape
    public Insets getClipping() {
        CTRelativeRect srcRect = getBlipFill().getSrcRect();
        if (srcRect == null) {
            return null;
        }
        return new Insets(srcRect.getT(), srcRect.getL(), srcRect.getB(), srcRect.getR());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFPictureShape xSLFPictureShape = (XSLFPictureShape) xSLFShape;
        String strImportBlip = getSheet().importBlip(xSLFPictureShape.getBlipId(), xSLFPictureShape.getSheet().getPackagePart());
        CTPicture xmlObject = getXmlObject();
        CTBlip blip = getBlipFill().getBlip();
        blip.setEmbed(strImportBlip);
        CTApplicationNonVisualDrawingProps nvPr = xmlObject.getNvPicPr().getNvPr();
        if (nvPr.isSetCustDataLst()) {
            nvPr.unsetCustDataLst();
        }
        if (blip.isSetExtLst()) {
            for (CTOfficeArtExtension cTOfficeArtExtension : blip.getExtLst().getExtArray()) {
                XmlObject[] xmlObjectArrSelectPath = cTOfficeArtExtension.selectPath("declare namespace a14='http://schemas.microsoft.com/office/drawing/2010/main' $this//a14:imgProps/a14:imgLayer");
                if (xmlObjectArrSelectPath != null && xmlObjectArrSelectPath.length == 1) {
                    XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
                    xmlCursorNewCursor.setAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "embed"), getSheet().importBlip(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "embed")), xSLFPictureShape.getSheet().getPackagePart()));
                    xmlCursorNewCursor.dispose();
                }
            }
        }
    }
}
