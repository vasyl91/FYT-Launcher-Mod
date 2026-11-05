package org.apache.poi.sl.draw.binding;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlRegistry
public class ObjectFactory {
    private static final QName _CTSRgbColorAlpha_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "alpha");
    private static final QName _CTSRgbColorLum_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "lum");
    private static final QName _CTSRgbColorGamma_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "gamma");
    private static final QName _CTSRgbColorInvGamma_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "invGamma");
    private static final QName _CTSRgbColorRedOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "redOff");
    private static final QName _CTSRgbColorAlphaMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "alphaMod");
    private static final QName _CTSRgbColorAlphaOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "alphaOff");
    private static final QName _CTSRgbColorGreenOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "greenOff");
    private static final QName _CTSRgbColorRedMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "redMod");
    private static final QName _CTSRgbColorHue_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "hue");
    private static final QName _CTSRgbColorSatOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "satOff");
    private static final QName _CTSRgbColorGreenMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "greenMod");
    private static final QName _CTSRgbColorSat_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "sat");
    private static final QName _CTSRgbColorBlue_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "blue");
    private static final QName _CTSRgbColorRed_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "red");
    private static final QName _CTSRgbColorSatMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "satMod");
    private static final QName _CTSRgbColorHueOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "hueOff");
    private static final QName _CTSRgbColorBlueMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "blueMod");
    private static final QName _CTSRgbColorShade_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "shade");
    private static final QName _CTSRgbColorLumMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "lumMod");
    private static final QName _CTSRgbColorInv_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "inv");
    private static final QName _CTSRgbColorLumOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "lumOff");
    private static final QName _CTSRgbColorTint_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "tint");
    private static final QName _CTSRgbColorGreen_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "green");
    private static final QName _CTSRgbColorComp_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "comp");
    private static final QName _CTSRgbColorBlueOff_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "blueOff");
    private static final QName _CTSRgbColorHueMod_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "hueMod");
    private static final QName _CTSRgbColorGray_QNAME = new QName(XSSFRelation.NS_DRAWINGML, "gray");

    public CTPositiveSize2D createCTPositiveSize2D() {
        return new CTPositiveSize2D();
    }

    public CTSphereCoords createCTSphereCoords() {
        return new CTSphereCoords();
    }

    public CTPositivePercentage createCTPositivePercentage() {
        return new CTPositivePercentage();
    }

    public CTAdjPoint2D createCTAdjPoint2D() {
        return new CTAdjPoint2D();
    }

    public CTPath2DCubicBezierTo createCTPath2DCubicBezierTo() {
        return new CTPath2DCubicBezierTo();
    }

    public CTEmbeddedWAVAudioFile createCTEmbeddedWAVAudioFile() {
        return new CTEmbeddedWAVAudioFile();
    }

    public CTPresetGeometry2D createCTPresetGeometry2D() {
        return new CTPresetGeometry2D();
    }

    public CTSchemeColor createCTSchemeColor() {
        return new CTSchemeColor();
    }

    public CTInverseTransform createCTInverseTransform() {
        return new CTInverseTransform();
    }

    public CTScRgbColor createCTScRgbColor() {
        return new CTScRgbColor();
    }

    public CTPositiveFixedAngle createCTPositiveFixedAngle() {
        return new CTPositiveFixedAngle();
    }

    public CTInverseGammaTransform createCTInverseGammaTransform() {
        return new CTInverseGammaTransform();
    }

    public CTColorMRU createCTColorMRU() {
        return new CTColorMRU();
    }

    public CTPath2DArcTo createCTPath2DArcTo() {
        return new CTPath2DArcTo();
    }

    public CTSystemColor createCTSystemColor() {
        return new CTSystemColor();
    }

    public CTGroupTransform2D createCTGroupTransform2D() {
        return new CTGroupTransform2D();
    }

    public CTPoint2D createCTPoint2D() {
        return new CTPoint2D();
    }

    public CTGeomRect createCTGeomRect() {
        return new CTGeomRect();
    }

    public CTScale2D createCTScale2D() {
        return new CTScale2D();
    }

    public CTGeomGuide createCTGeomGuide() {
        return new CTGeomGuide();
    }

    public CTXYAdjustHandle createCTXYAdjustHandle() {
        return new CTXYAdjustHandle();
    }

    public CTCustomGeometry2D createCTCustomGeometry2D() {
        return new CTCustomGeometry2D();
    }

    public CTOfficeArtExtension createCTOfficeArtExtension() {
        return new CTOfficeArtExtension();
    }

    public CTGrayscaleTransform createCTGrayscaleTransform() {
        return new CTGrayscaleTransform();
    }

    public CTPath2DClose createCTPath2DClose() {
        return new CTPath2DClose();
    }

    public CTComplementTransform createCTComplementTransform() {
        return new CTComplementTransform();
    }

    public CTPoint3D createCTPoint3D() {
        return new CTPoint3D();
    }

    public CTPositiveFixedPercentage createCTPositiveFixedPercentage() {
        return new CTPositiveFixedPercentage();
    }

    public CTPath2D createCTPath2D() {
        return new CTPath2D();
    }

    public CTAdjustHandleList createCTAdjustHandleList() {
        return new CTAdjustHandleList();
    }

    public CTConnectionSiteList createCTConnectionSiteList() {
        return new CTConnectionSiteList();
    }

    public CTPresetTextShape createCTPresetTextShape() {
        return new CTPresetTextShape();
    }

    public CTSRgbColor createCTSRgbColor() {
        return new CTSRgbColor();
    }

    public CTPath2DMoveTo createCTPath2DMoveTo() {
        return new CTPath2DMoveTo();
    }

    public CTRelativeRect createCTRelativeRect() {
        return new CTRelativeRect();
    }

    public CTPath2DList createCTPath2DList() {
        return new CTPath2DList();
    }

    public CTPolarAdjustHandle createCTPolarAdjustHandle() {
        return new CTPolarAdjustHandle();
    }

    public CTPercentage createCTPercentage() {
        return new CTPercentage();
    }

    public CTHslColor createCTHslColor() {
        return new CTHslColor();
    }

    public CTRatio createCTRatio() {
        return new CTRatio();
    }

    public CTGeomGuideList createCTGeomGuideList() {
        return new CTGeomGuideList();
    }

    public CTTransform2D createCTTransform2D() {
        return new CTTransform2D();
    }

    public CTGammaTransform createCTGammaTransform() {
        return new CTGammaTransform();
    }

    public CTPath2DQuadBezierTo createCTPath2DQuadBezierTo() {
        return new CTPath2DQuadBezierTo();
    }

    public CTAngle createCTAngle() {
        return new CTAngle();
    }

    public CTConnectionSite createCTConnectionSite() {
        return new CTConnectionSite();
    }

    public CTHyperlink createCTHyperlink() {
        return new CTHyperlink();
    }

    public CTFixedPercentage createCTFixedPercentage() {
        return new CTFixedPercentage();
    }

    public CTPath2DLineTo createCTPath2DLineTo() {
        return new CTPath2DLineTo();
    }

    public CTColor createCTColor() {
        return new CTColor();
    }

    public CTPresetColor createCTPresetColor() {
        return new CTPresetColor();
    }

    public CTVector3D createCTVector3D() {
        return new CTVector3D();
    }

    public CTOfficeArtExtensionList createCTOfficeArtExtensionList() {
        return new CTOfficeArtExtensionList();
    }

    public CTConnection createCTConnection() {
        return new CTConnection();
    }

    @XmlElementDecl(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSRgbColorAlpha(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTSRgbColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorLum(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTGammaTransform> createCTSRgbColorGamma(CTGammaTransform cTGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTSRgbColor.class, cTGammaTransform);
    }

    @XmlElementDecl(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTInverseGammaTransform> createCTSRgbColorInvGamma(CTInverseGammaTransform cTInverseGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTSRgbColor.class, cTInverseGammaTransform);
    }

    @XmlElementDecl(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorRedOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPositivePercentage> createCTSRgbColorAlphaMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTSRgbColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTFixedPercentage> createCTSRgbColorAlphaOff(CTFixedPercentage cTFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTSRgbColor.class, cTFixedPercentage);
    }

    @XmlElementDecl(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorGreenOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorRedMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPositiveFixedAngle> createCTSRgbColorHue(CTPositiveFixedAngle cTPositiveFixedAngle) {
        return new JAXBElement<>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTSRgbColor.class, cTPositiveFixedAngle);
    }

    @XmlElementDecl(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorSatOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorGreenMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorSat(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorBlue(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "red", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorRed(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorSatMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTAngle> createCTSRgbColorHueOff(CTAngle cTAngle) {
        return new JAXBElement<>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTSRgbColor.class, cTAngle);
    }

    @XmlElementDecl(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorBlueMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSRgbColorShade(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTSRgbColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorLumMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTInverseTransform> createCTSRgbColorInv(CTInverseTransform cTInverseTransform) {
        return new JAXBElement<>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTSRgbColor.class, cTInverseTransform);
    }

    @XmlElementDecl(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorLumOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSRgbColorTint(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTSRgbColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "green", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorGreen(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTComplementTransform> createCTSRgbColorComp(CTComplementTransform cTComplementTransform) {
        return new JAXBElement<>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTSRgbColor.class, cTComplementTransform);
    }

    @XmlElementDecl(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPercentage> createCTSRgbColorBlueOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTSRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTPositivePercentage> createCTSRgbColorHueMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTSRgbColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSRgbColor.class)
    public JAXBElement<CTGrayscaleTransform> createCTSRgbColorGray(CTGrayscaleTransform cTGrayscaleTransform) {
        return new JAXBElement<>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTSRgbColor.class, cTGrayscaleTransform);
    }

    @XmlElementDecl(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorLum(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSystemColorAlpha(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTSystemColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTGammaTransform> createCTSystemColorGamma(CTGammaTransform cTGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTSystemColor.class, cTGammaTransform);
    }

    @XmlElementDecl(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTInverseGammaTransform> createCTSystemColorInvGamma(CTInverseGammaTransform cTInverseGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTSystemColor.class, cTInverseGammaTransform);
    }

    @XmlElementDecl(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPositivePercentage> createCTSystemColorAlphaMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTSystemColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorRedOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTFixedPercentage> createCTSystemColorAlphaOff(CTFixedPercentage cTFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTSystemColor.class, cTFixedPercentage);
    }

    @XmlElementDecl(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorGreenOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorRedMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPositiveFixedAngle> createCTSystemColorHue(CTPositiveFixedAngle cTPositiveFixedAngle) {
        return new JAXBElement<>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTSystemColor.class, cTPositiveFixedAngle);
    }

    @XmlElementDecl(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorSatOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorGreenMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorBlue(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorSat(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "red", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorRed(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorSatMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorBlueMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTAngle> createCTSystemColorHueOff(CTAngle cTAngle) {
        return new JAXBElement<>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTSystemColor.class, cTAngle);
    }

    @XmlElementDecl(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSystemColorShade(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTSystemColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorLumMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTInverseTransform> createCTSystemColorInv(CTInverseTransform cTInverseTransform) {
        return new JAXBElement<>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTSystemColor.class, cTInverseTransform);
    }

    @XmlElementDecl(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorLumOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSystemColorTint(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTSystemColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "green", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorGreen(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTComplementTransform> createCTSystemColorComp(CTComplementTransform cTComplementTransform) {
        return new JAXBElement<>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTSystemColor.class, cTComplementTransform);
    }

    @XmlElementDecl(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPercentage> createCTSystemColorBlueOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTSystemColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTPositivePercentage> createCTSystemColorHueMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTSystemColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSystemColor.class)
    public JAXBElement<CTGrayscaleTransform> createCTSystemColorGray(CTGrayscaleTransform cTGrayscaleTransform) {
        return new JAXBElement<>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTSystemColor.class, cTGrayscaleTransform);
    }

    @XmlElementDecl(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorLum(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSchemeColorAlpha(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTSchemeColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTGammaTransform> createCTSchemeColorGamma(CTGammaTransform cTGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTSchemeColor.class, cTGammaTransform);
    }

    @XmlElementDecl(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTInverseGammaTransform> createCTSchemeColorInvGamma(CTInverseGammaTransform cTInverseGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTSchemeColor.class, cTInverseGammaTransform);
    }

    @XmlElementDecl(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorRedOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPositivePercentage> createCTSchemeColorAlphaMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTSchemeColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTFixedPercentage> createCTSchemeColorAlphaOff(CTFixedPercentage cTFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTSchemeColor.class, cTFixedPercentage);
    }

    @XmlElementDecl(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorGreenOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPositiveFixedAngle> createCTSchemeColorHue(CTPositiveFixedAngle cTPositiveFixedAngle) {
        return new JAXBElement<>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTSchemeColor.class, cTPositiveFixedAngle);
    }

    @XmlElementDecl(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorRedMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorSatOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorGreenMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorBlue(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorSat(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "red", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorRed(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorSatMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTAngle> createCTSchemeColorHueOff(CTAngle cTAngle) {
        return new JAXBElement<>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTSchemeColor.class, cTAngle);
    }

    @XmlElementDecl(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorBlueMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSchemeColorShade(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTSchemeColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorLumMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTInverseTransform> createCTSchemeColorInv(CTInverseTransform cTInverseTransform) {
        return new JAXBElement<>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTSchemeColor.class, cTInverseTransform);
    }

    @XmlElementDecl(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorLumOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTSchemeColorTint(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTSchemeColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "green", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorGreen(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTComplementTransform> createCTSchemeColorComp(CTComplementTransform cTComplementTransform) {
        return new JAXBElement<>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTSchemeColor.class, cTComplementTransform);
    }

    @XmlElementDecl(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPercentage> createCTSchemeColorBlueOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTSchemeColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTPositivePercentage> createCTSchemeColorHueMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTSchemeColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, scope = CTSchemeColor.class)
    public JAXBElement<CTGrayscaleTransform> createCTSchemeColorGray(CTGrayscaleTransform cTGrayscaleTransform) {
        return new JAXBElement<>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTSchemeColor.class, cTGrayscaleTransform);
    }

    @XmlElementDecl(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorLum(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTScRgbColorAlpha(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTScRgbColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTGammaTransform> createCTScRgbColorGamma(CTGammaTransform cTGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTScRgbColor.class, cTGammaTransform);
    }

    @XmlElementDecl(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTInverseGammaTransform> createCTScRgbColorInvGamma(CTInverseGammaTransform cTInverseGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTScRgbColor.class, cTInverseGammaTransform);
    }

    @XmlElementDecl(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorRedOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPositivePercentage> createCTScRgbColorAlphaMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTScRgbColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTFixedPercentage> createCTScRgbColorAlphaOff(CTFixedPercentage cTFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTScRgbColor.class, cTFixedPercentage);
    }

    @XmlElementDecl(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorGreenOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPositiveFixedAngle> createCTScRgbColorHue(CTPositiveFixedAngle cTPositiveFixedAngle) {
        return new JAXBElement<>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTScRgbColor.class, cTPositiveFixedAngle);
    }

    @XmlElementDecl(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorRedMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorSatOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorGreenMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorSat(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorBlue(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "red", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorRed(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorSatMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTAngle> createCTScRgbColorHueOff(CTAngle cTAngle) {
        return new JAXBElement<>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTScRgbColor.class, cTAngle);
    }

    @XmlElementDecl(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorBlueMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTScRgbColorShade(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTScRgbColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorLumMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTInverseTransform> createCTScRgbColorInv(CTInverseTransform cTInverseTransform) {
        return new JAXBElement<>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTScRgbColor.class, cTInverseTransform);
    }

    @XmlElementDecl(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorLumOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTScRgbColorTint(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTScRgbColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "green", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorGreen(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTComplementTransform> createCTScRgbColorComp(CTComplementTransform cTComplementTransform) {
        return new JAXBElement<>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTScRgbColor.class, cTComplementTransform);
    }

    @XmlElementDecl(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPercentage> createCTScRgbColorBlueOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTScRgbColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTPositivePercentage> createCTScRgbColorHueMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTScRgbColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, scope = CTScRgbColor.class)
    public JAXBElement<CTGrayscaleTransform> createCTScRgbColorGray(CTGrayscaleTransform cTGrayscaleTransform) {
        return new JAXBElement<>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTScRgbColor.class, cTGrayscaleTransform);
    }

    @XmlElementDecl(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTHslColorAlpha(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTHslColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorLum(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTGammaTransform> createCTHslColorGamma(CTGammaTransform cTGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTHslColor.class, cTGammaTransform);
    }

    @XmlElementDecl(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTInverseGammaTransform> createCTHslColorInvGamma(CTInverseGammaTransform cTInverseGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTHslColor.class, cTInverseGammaTransform);
    }

    @XmlElementDecl(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPositivePercentage> createCTHslColorAlphaMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTHslColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorRedOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTFixedPercentage> createCTHslColorAlphaOff(CTFixedPercentage cTFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTHslColor.class, cTFixedPercentage);
    }

    @XmlElementDecl(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorGreenOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPositiveFixedAngle> createCTHslColorHue(CTPositiveFixedAngle cTPositiveFixedAngle) {
        return new JAXBElement<>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTHslColor.class, cTPositiveFixedAngle);
    }

    @XmlElementDecl(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorRedMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorSatOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorGreenMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorBlue(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorSat(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "red", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorRed(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorSatMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorBlueMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTAngle> createCTHslColorHueOff(CTAngle cTAngle) {
        return new JAXBElement<>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTHslColor.class, cTAngle);
    }

    @XmlElementDecl(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTHslColorShade(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTHslColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorLumMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTInverseTransform> createCTHslColorInv(CTInverseTransform cTInverseTransform) {
        return new JAXBElement<>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTHslColor.class, cTInverseTransform);
    }

    @XmlElementDecl(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorLumOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTHslColorTint(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTHslColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "green", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorGreen(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTComplementTransform> createCTHslColorComp(CTComplementTransform cTComplementTransform) {
        return new JAXBElement<>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTHslColor.class, cTComplementTransform);
    }

    @XmlElementDecl(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPercentage> createCTHslColorBlueOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTHslColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTPositivePercentage> createCTHslColorHueMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTHslColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, scope = CTHslColor.class)
    public JAXBElement<CTGrayscaleTransform> createCTHslColorGray(CTGrayscaleTransform cTGrayscaleTransform) {
        return new JAXBElement<>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTHslColor.class, cTGrayscaleTransform);
    }

    @XmlElementDecl(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorLum(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLum_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTPresetColorAlpha(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlpha_QNAME, CTPositiveFixedPercentage.class, CTPresetColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTGammaTransform> createCTPresetColorGamma(CTGammaTransform cTGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorGamma_QNAME, CTGammaTransform.class, CTPresetColor.class, cTGammaTransform);
    }

    @XmlElementDecl(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTInverseGammaTransform> createCTPresetColorInvGamma(CTInverseGammaTransform cTInverseGammaTransform) {
        return new JAXBElement<>(_CTSRgbColorInvGamma_QNAME, CTInverseGammaTransform.class, CTPresetColor.class, cTInverseGammaTransform);
    }

    @XmlElementDecl(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorRedOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedOff_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPositivePercentage> createCTPresetColorAlphaMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaMod_QNAME, CTPositivePercentage.class, CTPresetColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTFixedPercentage> createCTPresetColorAlphaOff(CTFixedPercentage cTFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorAlphaOff_QNAME, CTFixedPercentage.class, CTPresetColor.class, cTFixedPercentage);
    }

    @XmlElementDecl(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorGreenOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenOff_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPositiveFixedAngle> createCTPresetColorHue(CTPositiveFixedAngle cTPositiveFixedAngle) {
        return new JAXBElement<>(_CTSRgbColorHue_QNAME, CTPositiveFixedAngle.class, CTPresetColor.class, cTPositiveFixedAngle);
    }

    @XmlElementDecl(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorRedMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRedMod_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorSatOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatOff_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorGreenMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreenMod_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorBlue(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlue_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorSat(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSat_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "red", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorRed(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorRed_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorSatMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorSatMod_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorBlueMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueMod_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTAngle> createCTPresetColorHueOff(CTAngle cTAngle) {
        return new JAXBElement<>(_CTSRgbColorHueOff_QNAME, CTAngle.class, CTPresetColor.class, cTAngle);
    }

    @XmlElementDecl(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTPresetColorShade(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorShade_QNAME, CTPositiveFixedPercentage.class, CTPresetColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorLumMod(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumMod_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTInverseTransform> createCTPresetColorInv(CTInverseTransform cTInverseTransform) {
        return new JAXBElement<>(_CTSRgbColorInv_QNAME, CTInverseTransform.class, CTPresetColor.class, cTInverseTransform);
    }

    @XmlElementDecl(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorLumOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorLumOff_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPositiveFixedPercentage> createCTPresetColorTint(CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        return new JAXBElement<>(_CTSRgbColorTint_QNAME, CTPositiveFixedPercentage.class, CTPresetColor.class, cTPositiveFixedPercentage);
    }

    @XmlElementDecl(name = "green", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorGreen(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorGreen_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTComplementTransform> createCTPresetColorComp(CTComplementTransform cTComplementTransform) {
        return new JAXBElement<>(_CTSRgbColorComp_QNAME, CTComplementTransform.class, CTPresetColor.class, cTComplementTransform);
    }

    @XmlElementDecl(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPercentage> createCTPresetColorBlueOff(CTPercentage cTPercentage) {
        return new JAXBElement<>(_CTSRgbColorBlueOff_QNAME, CTPercentage.class, CTPresetColor.class, cTPercentage);
    }

    @XmlElementDecl(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTPositivePercentage> createCTPresetColorHueMod(CTPositivePercentage cTPositivePercentage) {
        return new JAXBElement<>(_CTSRgbColorHueMod_QNAME, CTPositivePercentage.class, CTPresetColor.class, cTPositivePercentage);
    }

    @XmlElementDecl(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, scope = CTPresetColor.class)
    public JAXBElement<CTGrayscaleTransform> createCTPresetColorGray(CTGrayscaleTransform cTGrayscaleTransform) {
        return new JAXBElement<>(_CTSRgbColorGray_QNAME, CTGrayscaleTransform.class, CTPresetColor.class, cTGrayscaleTransform);
    }
}
