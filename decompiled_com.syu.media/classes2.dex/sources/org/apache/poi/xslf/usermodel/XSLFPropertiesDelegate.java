package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSLFPropertiesDelegate {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSLFPropertiesDelegate.class);

    public interface XSLFEffectProperties {
        CTEffectContainer addNewEffectDag();

        CTEffectList addNewEffectLst();

        CTEffectContainer getEffectDag();

        CTEffectList getEffectLst();

        boolean isSetEffectDag();

        boolean isSetEffectLst();

        void setEffectDag(CTEffectContainer cTEffectContainer);

        void setEffectLst(CTEffectList cTEffectList);

        void unsetEffectDag();

        void unsetEffectLst();
    }

    public interface XSLFFillProperties {
        CTBlipFillProperties addNewBlipFill();

        CTGradientFillProperties addNewGradFill();

        CTGroupFillProperties addNewGrpFill();

        CTNoFillProperties addNewNoFill();

        CTPatternFillProperties addNewPattFill();

        CTSolidColorFillProperties addNewSolidFill();

        CTBlipFillProperties getBlipFill();

        CTGradientFillProperties getGradFill();

        CTGroupFillProperties getGrpFill();

        CTStyleMatrixReference getMatrixStyle();

        CTNoFillProperties getNoFill();

        CTPatternFillProperties getPattFill();

        CTSolidColorFillProperties getSolidFill();

        boolean isLineStyle();

        boolean isSetBlipFill();

        boolean isSetGradFill();

        boolean isSetGrpFill();

        boolean isSetMatrixStyle();

        boolean isSetNoFill();

        boolean isSetPattFill();

        boolean isSetSolidFill();

        void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

        void setGradFill(CTGradientFillProperties cTGradientFillProperties);

        void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

        void setNoFill(CTNoFillProperties cTNoFillProperties);

        void setPattFill(CTPatternFillProperties cTPatternFillProperties);

        void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

        void unsetBlipFill();

        void unsetGradFill();

        void unsetGrpFill();

        void unsetNoFill();

        void unsetPattFill();

        void unsetSolidFill();
    }

    public interface XSLFGeometryProperties {
        CTCustomGeometry2D addNewCustGeom();

        CTPresetGeometry2D addNewPrstGeom();

        CTCustomGeometry2D getCustGeom();

        CTPresetGeometry2D getPrstGeom();

        boolean isSetCustGeom();

        boolean isSetPrstGeom();

        void setCustGeom(CTCustomGeometry2D cTCustomGeometry2D);

        void setPrstGeom(CTPresetGeometry2D cTPresetGeometry2D);

        void unsetCustGeom();

        void unsetPrstGeom();
    }

    XSLFPropertiesDelegate() {
    }

    public static XSLFFillProperties getFillDelegate(XmlObject xmlObject) {
        return (XSLFFillProperties) getDelegate(XSLFFillProperties.class, xmlObject);
    }

    public static XSLFGeometryProperties getGeometryDelegate(XmlObject xmlObject) {
        return (XSLFGeometryProperties) getDelegate(XSLFGeometryProperties.class, xmlObject);
    }

    public static XSLFEffectProperties getEffectDelegate(XmlObject xmlObject) {
        return (XSLFEffectProperties) getDelegate(XSLFEffectProperties.class, xmlObject);
    }

    private static class ShapeDelegate implements XSLFFillProperties, XSLFGeometryProperties, XSLFEffectProperties {
        final CTShapeProperties props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        ShapeDelegate(CTShapeProperties cTShapeProperties) {
            this.props = cTShapeProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTCustomGeometry2D getCustGeom() {
            return this.props.getCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public boolean isSetCustGeom() {
            return this.props.isSetCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void setCustGeom(CTCustomGeometry2D cTCustomGeometry2D) {
            this.props.setCustGeom(cTCustomGeometry2D);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTCustomGeometry2D addNewCustGeom() {
            return this.props.addNewCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void unsetCustGeom() {
            this.props.unsetCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTPresetGeometry2D getPrstGeom() {
            return this.props.getPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public boolean isSetPrstGeom() {
            return this.props.isSetPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void setPrstGeom(CTPresetGeometry2D cTPresetGeometry2D) {
            this.props.setPrstGeom(cTPresetGeometry2D);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTPresetGeometry2D addNewPrstGeom() {
            return this.props.addNewPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void unsetPrstGeom() {
            this.props.unsetPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList getEffectLst() {
            return this.props.getEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectLst() {
            return this.props.isSetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectLst(CTEffectList cTEffectList) {
            this.props.setEffectLst(cTEffectList);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList addNewEffectLst() {
            return this.props.addNewEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectLst() {
            this.props.unsetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer getEffectDag() {
            return this.props.getEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectDag() {
            return this.props.isSetEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectDag(CTEffectContainer cTEffectContainer) {
            this.props.setEffectDag(cTEffectContainer);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer addNewEffectDag() {
            return this.props.addNewEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectDag() {
            this.props.unsetEffectDag();
        }
    }

    private static class BackgroundDelegate implements XSLFFillProperties, XSLFEffectProperties {
        final CTBackgroundProperties props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        BackgroundDelegate(CTBackgroundProperties cTBackgroundProperties) {
            this.props = cTBackgroundProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList getEffectLst() {
            return this.props.getEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectLst() {
            return this.props.isSetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectLst(CTEffectList cTEffectList) {
            this.props.setEffectLst(cTEffectList);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList addNewEffectLst() {
            return this.props.addNewEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectLst() {
            this.props.unsetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer getEffectDag() {
            return this.props.getEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectDag() {
            return this.props.isSetEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectDag(CTEffectContainer cTEffectContainer) {
            this.props.setEffectDag(cTEffectContainer);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer addNewEffectDag() {
            return this.props.addNewEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectDag() {
            this.props.unsetEffectDag();
        }
    }

    private static class TableCellDelegate implements XSLFFillProperties {
        final CTTableCellProperties props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        TableCellDelegate(CTTableCellProperties cTTableCellProperties) {
            this.props = cTTableCellProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }
    }

    private static class StyleMatrixDelegate implements XSLFFillProperties {
        final CTStyleMatrixReference props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return true;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
        }

        StyleMatrixDelegate(CTStyleMatrixReference cTStyleMatrixReference) {
            this.props = cTStyleMatrixReference;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return this.props;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            XmlCursor xmlCursorNewCursor = this.props.newCursor();
            String localPart = xmlCursorNewCursor.getName().getLocalPart();
            xmlCursorNewCursor.dispose();
            return "lnRef".equals(localPart);
        }
    }

    private static class FillDelegate implements XSLFFillProperties {
        final CTFillProperties props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        FillDelegate(CTFillProperties cTFillProperties) {
            this.props = cTFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }
    }

    private static class FillPartDelegate implements XSLFFillProperties {
        final XmlObject props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
        }

        FillPartDelegate(XmlObject xmlObject) {
            this.props = xmlObject;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            if (isSetNoFill()) {
                return this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props instanceof CTNoFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            if (isSetSolidFill()) {
                return this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props instanceof CTSolidColorFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            if (isSetGradFill()) {
                return this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props instanceof CTGradientFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            if (isSetBlipFill()) {
                return this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props instanceof CTBlipFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            if (isSetPattFill()) {
                return this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props instanceof CTPatternFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            if (isSetGrpFill()) {
                return this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props instanceof CTGroupFillProperties;
        }
    }

    private static class LineStyleDelegate implements XSLFFillProperties {
        final CTLineProperties props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return true;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
        }

        LineStyleDelegate(CTLineProperties cTLineProperties) {
            this.props = cTLineProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }
    }

    private static class TextCharDelegate implements XSLFFillProperties {
        final CTTextCharacterProperties props;

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        TextCharDelegate(CTTextCharacterProperties cTTextCharacterProperties) {
            this.props = cTTextCharacterProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }
    }

    private static <T> T getDelegate(Class<T> cls, XmlObject xmlObject) {
        T t;
        if (xmlObject == null) {
            return null;
        }
        if (xmlObject instanceof CTShapeProperties) {
            t = (T) new ShapeDelegate((CTShapeProperties) xmlObject);
        } else if (xmlObject instanceof CTBackgroundProperties) {
            t = (T) new BackgroundDelegate((CTBackgroundProperties) xmlObject);
        } else if (xmlObject instanceof CTStyleMatrixReference) {
            t = (T) new StyleMatrixDelegate((CTStyleMatrixReference) xmlObject);
        } else if (xmlObject instanceof CTTableCellProperties) {
            t = (T) new TableCellDelegate((CTTableCellProperties) xmlObject);
        } else if ((xmlObject instanceof CTNoFillProperties) || (xmlObject instanceof CTSolidColorFillProperties) || (xmlObject instanceof CTGradientFillProperties) || (xmlObject instanceof CTBlipFillProperties) || (xmlObject instanceof CTPatternFillProperties) || (xmlObject instanceof CTGroupFillProperties)) {
            t = (T) new FillPartDelegate(xmlObject);
        } else if (xmlObject instanceof CTFillProperties) {
            t = (T) new FillDelegate((CTFillProperties) xmlObject);
        } else if (xmlObject instanceof CTLineProperties) {
            t = (T) new LineStyleDelegate((CTLineProperties) xmlObject);
        } else if (xmlObject instanceof CTTextCharacterProperties) {
            t = (T) new TextCharDelegate((CTTextCharacterProperties) xmlObject);
        } else {
            LOG.log(7, xmlObject.getClass() + " is an unknown properties type");
            return null;
        }
        if (cls.isInstance(t)) {
            return t;
        }
        LOG.log(5, t.getClass() + " doesn't implement " + cls);
        return null;
    }
}
