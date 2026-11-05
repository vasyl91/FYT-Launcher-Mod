package org.apache.poi.xdgf.xml;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xdgf.usermodel.XDGFDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFXMLDocumentPart extends POIXMLDocumentPart {
    protected XDGFDocument _document;

    public XDGFXMLDocumentPart(PackagePart packagePart, XDGFDocument xDGFDocument) {
        super(packagePart);
        this._document = xDGFDocument;
    }
}
