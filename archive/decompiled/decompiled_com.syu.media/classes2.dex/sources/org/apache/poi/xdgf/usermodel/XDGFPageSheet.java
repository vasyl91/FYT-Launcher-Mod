package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFPageSheet extends XDGFSheet {
    PageSheetType _pageSheet;

    public XDGFPageSheet(PageSheetType pageSheetType, XDGFDocument xDGFDocument) {
        super(pageSheetType, xDGFDocument);
        this._pageSheet = pageSheetType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    /* JADX INFO: renamed from: getXmlObject, reason: merged with bridge method [inline-methods] */
    public PageSheetType mo1575getXmlObject() {
        return this._pageSheet;
    }
}
