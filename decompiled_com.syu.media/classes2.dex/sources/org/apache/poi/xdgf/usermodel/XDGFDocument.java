package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFDocument {
    long _defaultFillStyle;
    long _defaultGuideStyle;
    long _defaultLineStyle;
    long _defaultTextStyle;
    protected VisioDocumentType _document;
    Map<Long, XDGFStyleSheet> _styleSheets = new HashMap();

    public XDGFDocument(VisioDocumentType visioDocumentType) {
        this._defaultFillStyle = 0L;
        this._defaultGuideStyle = 0L;
        this._defaultLineStyle = 0L;
        this._defaultTextStyle = 0L;
        this._document = visioDocumentType;
        if (!visioDocumentType.isSetDocumentSettings()) {
            throw new POIXMLException("Document settings not found");
        }
        DocumentSettingsType documentSettings = this._document.getDocumentSettings();
        if (documentSettings.isSetDefaultFillStyle()) {
            this._defaultFillStyle = documentSettings.getDefaultFillStyle();
        }
        if (documentSettings.isSetDefaultGuideStyle()) {
            this._defaultGuideStyle = documentSettings.getDefaultGuideStyle();
        }
        if (documentSettings.isSetDefaultLineStyle()) {
            this._defaultLineStyle = documentSettings.getDefaultLineStyle();
        }
        if (documentSettings.isSetDefaultTextStyle()) {
            this._defaultTextStyle = documentSettings.getDefaultTextStyle();
        }
        if (this._document.isSetStyleSheets()) {
            for (StyleSheetType styleSheetType : this._document.getStyleSheets().getStyleSheetArray()) {
                this._styleSheets.put(Long.valueOf(styleSheetType.getID()), new XDGFStyleSheet(styleSheetType, this));
            }
        }
    }

    @Internal
    public VisioDocumentType getXmlObject() {
        return this._document;
    }

    public XDGFStyleSheet getStyleById(long j) {
        return this._styleSheets.get(Long.valueOf(j));
    }

    public XDGFStyleSheet getDefaultFillStyle() {
        XDGFStyleSheet styleById = getStyleById(this._defaultFillStyle);
        if (styleById != null) {
            return styleById;
        }
        throw new POIXMLException("No default fill style found!");
    }

    public XDGFStyleSheet getDefaultGuideStyle() {
        XDGFStyleSheet styleById = getStyleById(this._defaultGuideStyle);
        if (styleById != null) {
            return styleById;
        }
        throw new POIXMLException("No default guide style found!");
    }

    public XDGFStyleSheet getDefaultLineStyle() {
        XDGFStyleSheet styleById = getStyleById(this._defaultLineStyle);
        if (styleById != null) {
            return styleById;
        }
        throw new POIXMLException("No default line style found!");
    }

    public XDGFStyleSheet getDefaultTextStyle() {
        XDGFStyleSheet styleById = getStyleById(this._defaultTextStyle);
        if (styleById != null) {
            return styleById;
        }
        throw new POIXMLException("No default text style found!");
    }
}
