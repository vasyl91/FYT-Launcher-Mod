package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import kotlin.UByte;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.ColorStyle;
import org.apache.poi.sl.usermodel.PresetColor;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSLFColor {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) XSLFColor.class);
    private Color _color;
    private CTSchemeColor _phClr;
    private XmlObject _xmlObject;

    public XSLFColor(XmlObject xmlObject, XSLFTheme xSLFTheme, CTSchemeColor cTSchemeColor) {
        this._xmlObject = xmlObject;
        this._phClr = cTSchemeColor;
        this._color = toColor(xmlObject, xSLFTheme);
    }

    @Internal
    public XmlObject getXmlObject() {
        return this._xmlObject;
    }

    public Color getColor() {
        return DrawPaint.applyColorTransform(getColorStyle());
    }

    public ColorStyle getColorStyle() {
        return new ColorStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFColor.1
            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public Color getColor() {
                return XSLFColor.this._color;
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getAlpha() {
                return XSLFColor.this.getRawValue("alpha");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getHueOff() {
                return XSLFColor.this.getRawValue("hueOff");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getHueMod() {
                return XSLFColor.this.getRawValue("hueMod");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getSatOff() {
                return XSLFColor.this.getRawValue("satOff");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getSatMod() {
                return XSLFColor.this.getRawValue("satMod");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getLumOff() {
                return XSLFColor.this.getRawValue("lumOff");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getLumMod() {
                return XSLFColor.this.getRawValue("lumMod");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getShade() {
                return XSLFColor.this.getRawValue("shade");
            }

            @Override // org.apache.poi.sl.usermodel.ColorStyle
            public int getTint() {
                return XSLFColor.this.getRawValue("tint");
            }
        };
    }

    Color toColor(XmlObject xmlObject, XSLFTheme xSLFTheme) {
        Color color;
        Color color2 = null;
        for (CTHslColor cTHslColor : xmlObject.selectPath("*")) {
            if (cTHslColor instanceof CTHslColor) {
                CTHslColor cTHslColor2 = cTHslColor;
                color2 = DrawPaint.HSL2RGB(((double) cTHslColor2.getHue2()) / 60000.0d, ((double) cTHslColor2.getSat2()) / 1000.0d, ((double) cTHslColor2.getLum2()) / 1000.0d, 1.0d);
            } else {
                if (cTHslColor instanceof CTPresetColor) {
                    PresetColor presetColorValueOfOoxmlId = PresetColor.valueOfOoxmlId(((CTPresetColor) cTHslColor).getVal().toString());
                    if (presetColorValueOfOoxmlId != null) {
                        color2 = presetColorValueOfOoxmlId.color;
                    }
                } else if (cTHslColor instanceof CTSchemeColor) {
                    String string = ((CTSchemeColor) cTHslColor).getVal().toString();
                    CTSchemeColor cTSchemeColor = this._phClr;
                    if (cTSchemeColor != null) {
                        string = cTSchemeColor.getVal().toString();
                    }
                    CTColor cTColor = xSLFTheme.getCTColor(string);
                    if (cTColor != null) {
                        color2 = toColor(cTColor, null);
                    }
                } else if (cTHslColor instanceof CTScRgbColor) {
                    CTScRgbColor cTScRgbColor = (CTScRgbColor) cTHslColor;
                    color2 = new Color(DrawPaint.lin2srgb(cTScRgbColor.getR()), DrawPaint.lin2srgb(cTScRgbColor.getG()), DrawPaint.lin2srgb(cTScRgbColor.getB()));
                } else {
                    if (cTHslColor instanceof CTSRgbColor) {
                        byte[] val = ((CTSRgbColor) cTHslColor).getVal();
                        color = new Color(val[0] & UByte.MAX_VALUE, val[1] & UByte.MAX_VALUE, val[2] & UByte.MAX_VALUE);
                    } else if (cTHslColor instanceof CTSystemColor) {
                        CTSystemColor cTSystemColor = (CTSystemColor) cTHslColor;
                        if (cTSystemColor.isSetLastClr()) {
                            byte[] lastClr = cTSystemColor.getLastClr();
                            color = new Color(lastClr[0] & UByte.MAX_VALUE, lastClr[1] & UByte.MAX_VALUE, lastClr[2] & UByte.MAX_VALUE);
                        } else {
                            PresetColor presetColorValueOfOoxmlId2 = PresetColor.valueOfOoxmlId(cTSystemColor.getVal().toString());
                            if (presetColorValueOfOoxmlId2 != null) {
                                color2 = presetColorValueOfOoxmlId2.color;
                            }
                            if (color2 == null) {
                                color2 = Color.black;
                            }
                        }
                    } else if (!(cTHslColor instanceof CTFontReference)) {
                        throw new IllegalArgumentException("Unexpected color choice: " + cTHslColor.getClass());
                    }
                    color2 = color;
                }
            }
        }
        return color2;
    }

    @Internal
    protected void setColor(Color color) {
        CTSolidColorFillProperties cTSolidColorFillProperties = this._xmlObject;
        if (!(cTSolidColorFillProperties instanceof CTSolidColorFillProperties)) {
            LOGGER.log(7, "XSLFColor.setColor currently only supports CTSolidColorFillProperties");
            return;
        }
        CTSolidColorFillProperties cTSolidColorFillProperties2 = cTSolidColorFillProperties;
        if (cTSolidColorFillProperties2.isSetSrgbClr()) {
            cTSolidColorFillProperties2.unsetSrgbClr();
        }
        if (cTSolidColorFillProperties2.isSetScrgbClr()) {
            cTSolidColorFillProperties2.unsetScrgbClr();
        }
        if (cTSolidColorFillProperties2.isSetHslClr()) {
            cTSolidColorFillProperties2.unsetHslClr();
        }
        if (cTSolidColorFillProperties2.isSetPrstClr()) {
            cTSolidColorFillProperties2.unsetPrstClr();
        }
        if (cTSolidColorFillProperties2.isSetSchemeClr()) {
            cTSolidColorFillProperties2.unsetSchemeClr();
        }
        if (cTSolidColorFillProperties2.isSetSysClr()) {
            cTSolidColorFillProperties2.unsetSysClr();
        }
        CTPositiveFixedPercentage cTPositiveFixedPercentageAddNewAlpha = null;
        float[] rGBComponents = color.getRGBComponents((float[]) null);
        boolean z = rGBComponents.length == 4 && rGBComponents[3] < 1.0f;
        if (isInt(rGBComponents[0]) && isInt(rGBComponents[1]) && isInt(rGBComponents[2])) {
            CTSRgbColor cTSRgbColorAddNewSrgbClr = cTSolidColorFillProperties2.addNewSrgbClr();
            cTSRgbColorAddNewSrgbClr.setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
            if (z) {
                cTPositiveFixedPercentageAddNewAlpha = cTSRgbColorAddNewSrgbClr.addNewAlpha();
            }
        } else {
            CTScRgbColor cTScRgbColorAddNewScrgbClr = cTSolidColorFillProperties2.addNewScrgbClr();
            cTScRgbColorAddNewScrgbClr.setR(DrawPaint.srgb2lin(rGBComponents[0]));
            cTScRgbColorAddNewScrgbClr.setG(DrawPaint.srgb2lin(rGBComponents[1]));
            cTScRgbColorAddNewScrgbClr.setB(DrawPaint.srgb2lin(rGBComponents[2]));
            if (z) {
                cTPositiveFixedPercentageAddNewAlpha = cTScRgbColorAddNewScrgbClr.addNewAlpha();
            }
        }
        if (cTPositiveFixedPercentageAddNewAlpha != null) {
            cTPositiveFixedPercentageAddNewAlpha.setVal((int) (rGBComponents[3] * 100000.0f));
        }
    }

    private static boolean isInt(float f) {
        double d = f * 255.0f;
        return Math.abs(d - Math.rint(d)) < 9.999999747378752E-6d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRawValue(String str) {
        Node namedItem;
        Node namedItem2;
        String str2 = "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' $this//a:" + str;
        CTSchemeColor cTSchemeColor = this._phClr;
        if (cTSchemeColor != null) {
            XmlObject[] xmlObjectArrSelectPath = cTSchemeColor.selectPath(str2);
            if (xmlObjectArrSelectPath.length == 1 && (namedItem2 = xmlObjectArrSelectPath[0].getDomNode().getAttributes().getNamedItem("val")) != null) {
                return Integer.parseInt(namedItem2.getNodeValue());
            }
        }
        XmlObject[] xmlObjectArrSelectPath2 = this._xmlObject.selectPath(str2);
        if (xmlObjectArrSelectPath2.length != 1 || (namedItem = xmlObjectArrSelectPath2[0].getDomNode().getAttributes().getNamedItem("val")) == null) {
            return -1;
        }
        return Integer.parseInt(namedItem.getNodeValue());
    }

    private int getPercentageValue(String str) {
        int rawValue = getRawValue(str);
        return rawValue == -1 ? rawValue : rawValue / 1000;
    }

    private int getAngleValue(String str) {
        int rawValue = getRawValue(str);
        return rawValue == -1 ? rawValue : rawValue / 60000;
    }

    int getAlpha() {
        return getPercentageValue("alpha");
    }

    int getAlphaMod() {
        return getPercentageValue("alphaMod");
    }

    int getAlphaOff() {
        return getPercentageValue("alphaOff");
    }

    int getHue() {
        return getAngleValue("hue");
    }

    int getHueMod() {
        return getPercentageValue("hueMod");
    }

    int getHueOff() {
        return getPercentageValue("hueOff");
    }

    int getLum() {
        return getPercentageValue("lum");
    }

    int getLumMod() {
        return getPercentageValue("lumMod");
    }

    int getLumOff() {
        return getPercentageValue("lumOff");
    }

    int getSat() {
        return getPercentageValue("sat");
    }

    int getSatMod() {
        return getPercentageValue("satMod");
    }

    int getSatOff() {
        return getPercentageValue("satOff");
    }

    int getRed() {
        return getPercentageValue("red");
    }

    int getRedMod() {
        return getPercentageValue("redMod");
    }

    int getRedOff() {
        return getPercentageValue("redOff");
    }

    int getGreen() {
        return getPercentageValue("green");
    }

    int getGreenMod() {
        return getPercentageValue("greenMod");
    }

    int getGreenOff() {
        return getPercentageValue("greenOff");
    }

    int getBlue() {
        return getPercentageValue("blue");
    }

    int getBlueMod() {
        return getPercentageValue("blueMod");
    }

    int getBlueOff() {
        return getPercentageValue("blueOff");
    }

    public int getShade() {
        return getPercentageValue("shade");
    }

    public int getTint() {
        return getPercentageValue("tint");
    }
}
