package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFStyleSheet extends XDGFSheet {
    public XDGFStyleSheet(StyleSheetType styleSheetType, XDGFDocument xDGFDocument) {
        super(styleSheetType, xDGFDocument);
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    @Internal
    /* JADX INFO: renamed from: getXmlObject, reason: merged with bridge method [inline-methods] */
    public StyleSheetType mo1575getXmlObject() {
        return this._sheet;
    }
}
