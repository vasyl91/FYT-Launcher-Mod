package org.apache.poi.xslf.model;

import org.apache.poi.xslf.usermodel.XSLFShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class TextBodyPropertyFetcher<T> extends PropertyFetcher<T> {
    public abstract boolean fetch(CTTextBodyProperties cTTextBodyProperties);

    @Override // org.apache.poi.xslf.model.PropertyFetcher
    public boolean fetch(XSLFShape xSLFShape) {
        CTTextBodyProperties[] cTTextBodyPropertiesArrSelectPath = xSLFShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:bodyPr");
        if (cTTextBodyPropertiesArrSelectPath.length == 1) {
            return fetch(cTTextBodyPropertiesArrSelectPath[0]);
        }
        return false;
    }
}
