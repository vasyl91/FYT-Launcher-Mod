package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTableStyles extends POIXMLDocumentPart implements Iterable<XSLFTableStyle> {
    private List<XSLFTableStyle> _styles;
    private CTTableStyleList _tblStyleLst;

    public XSLFTableStyles() {
    }

    public XSLFTableStyles(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        InputStream inputStream = getPackagePart().getInputStream();
        TblStyleLstDocument tblStyleLstDocument = TblStyleLstDocument.Factory.parse(inputStream);
        inputStream.close();
        CTTableStyleList tblStyleLst = tblStyleLstDocument.getTblStyleLst();
        this._tblStyleLst = tblStyleLst;
        CTTableStyle[] tblStyleArray = tblStyleLst.getTblStyleArray();
        this._styles = new ArrayList(tblStyleArray.length);
        for (CTTableStyle cTTableStyle : tblStyleArray) {
            this._styles.add(new XSLFTableStyle(cTTableStyle));
        }
    }

    public CTTableStyleList getXmlObject() {
        return this._tblStyleLst;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableStyle> iterator() {
        return this._styles.iterator();
    }

    public List<XSLFTableStyle> getStyles() {
        return Collections.unmodifiableList(this._styles);
    }
}
