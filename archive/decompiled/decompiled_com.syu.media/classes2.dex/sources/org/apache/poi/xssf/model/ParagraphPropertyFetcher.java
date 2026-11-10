package org.apache.poi.xssf.model;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public abstract class ParagraphPropertyFetcher<T> {
    private int _level;
    private T _value;

    public abstract boolean fetch(CTTextParagraphProperties cTTextParagraphProperties);

    public T getValue() {
        return this._value;
    }

    public void setValue(T t) {
        this._value = t;
    }

    public ParagraphPropertyFetcher(int i) {
        this._level = i;
    }

    public boolean fetch(CTShape cTShape) {
        CTTextParagraphProperties[] cTTextParagraphPropertiesArrSelectPath = cTShape.selectPath("declare namespace xdr='http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//xdr:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (cTTextParagraphPropertiesArrSelectPath.length == 1) {
            return fetch(cTTextParagraphPropertiesArrSelectPath[0]);
        }
        return false;
    }
}
