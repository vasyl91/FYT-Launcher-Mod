package org.apache.poi.xslf.model;

import org.apache.poi.xslf.usermodel.XSLFShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ParagraphPropertyFetcher<T> extends PropertyFetcher<T> {
    int _level;

    public abstract boolean fetch(CTTextParagraphProperties cTTextParagraphProperties);

    public ParagraphPropertyFetcher(int i) {
        this._level = i;
    }

    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFShape xSLFShape) {
        CTTextParagraphProperties[] cTTextParagraphPropertiesArrSelectPath = xSLFShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (cTTextParagraphPropertiesArrSelectPath.length == 1) {
            return fetch(cTTextParagraphPropertiesArrSelectPath[0]);
        }
        return false;
    }
}
