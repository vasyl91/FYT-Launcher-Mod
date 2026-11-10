package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTheme extends POIXMLDocumentPart {
    private Map<String, CTColor> _schemeColors;
    private CTOfficeStyleSheet _theme;

    XSLFTheme() {
        this._theme = CTOfficeStyleSheet.Factory.newInstance();
    }

    public XSLFTheme(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        this._theme = ThemeDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getTheme();
        initialize();
    }

    public void importTheme(XSLFTheme xSLFTheme) {
        this._theme = xSLFTheme.getXmlObject();
        this._schemeColors = xSLFTheme._schemeColors;
    }

    private void initialize() {
        CTColorScheme clrScheme = this._theme.getThemeElements().getClrScheme();
        this._schemeColors = new HashMap(12);
        for (CTColor cTColor : clrScheme.selectPath("*")) {
            this._schemeColors.put(cTColor.getDomNode().getLocalName(), cTColor);
        }
    }

    void initColorMap(CTColorMapping cTColorMapping) {
        Map<String, CTColor> map = this._schemeColors;
        map.put("bg1", map.get(cTColorMapping.getBg1().toString()));
        Map<String, CTColor> map2 = this._schemeColors;
        map2.put("bg2", map2.get(cTColorMapping.getBg2().toString()));
        Map<String, CTColor> map3 = this._schemeColors;
        map3.put("tx1", map3.get(cTColorMapping.getTx1().toString()));
        Map<String, CTColor> map4 = this._schemeColors;
        map4.put("tx2", map4.get(cTColorMapping.getTx2().toString()));
    }

    public String getName() {
        return this._theme.getName();
    }

    public void setName(String str) {
        this._theme.setName(str);
    }

    CTColor getCTColor(String str) {
        return this._schemeColors.get(str);
    }

    @Internal
    public CTOfficeStyleSheet getXmlObject() {
        return this._theme;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(XSSFRelation.NS_DRAWINGML, "theme"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        getXmlObject().save(outputStream, xmlOptions);
        outputStream.close();
    }

    public String getMajorFont() {
        return this._theme.getThemeElements().getFontScheme().getMajorFont().getLatin().getTypeface();
    }

    public String getMinorFont() {
        return this._theme.getThemeElements().getFontScheme().getMinorFont().getLatin().getTypeface();
    }

    CTTextParagraphProperties getDefaultParagraphStyle() {
        CTTextParagraphProperties[] cTTextParagraphPropertiesArrSelectPath = this._theme.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:objectDefaults/a:spDef/a:lstStyle/a:defPPr");
        if (cTTextParagraphPropertiesArrSelectPath.length == 1) {
            return cTTextParagraphPropertiesArrSelectPath[0];
        }
        return null;
    }
}
