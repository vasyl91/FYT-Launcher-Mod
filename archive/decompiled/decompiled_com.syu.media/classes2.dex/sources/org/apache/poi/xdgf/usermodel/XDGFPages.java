package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFPages extends XDGFXMLDocumentPart {
    List<XDGFPage> _pages;
    PagesType _pagesObject;

    public XDGFPages(PackagePart packagePart, XDGFDocument xDGFDocument) {
        super(packagePart, xDGFDocument);
        this._pages = new ArrayList();
    }

    @Internal
    PagesType getXmlObject() {
        return this._pagesObject;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() {
        try {
            try {
                PagesType pages = PagesDocument.Factory.parse(getPackagePart().getInputStream()).getPages();
                this._pagesObject = pages;
                for (PageType pageType : pages.getPageArray()) {
                    String id = pageType.getRel().getId();
                    POIXMLDocumentPart relationById = getRelationById(id);
                    if (relationById == null) {
                        throw new POIXMLException("PageSettings relationship for " + id + " not found");
                    }
                    if (!(relationById instanceof XDGFPageContents)) {
                        throw new POIXMLException("Unexpected pages relationship for " + id + ": " + relationById);
                    }
                    XDGFPageContents xDGFPageContents = (XDGFPageContents) relationById;
                    XDGFPage xDGFPage = new XDGFPage(pageType, xDGFPageContents, this._document, this);
                    xDGFPageContents.onDocumentRead();
                    this._pages.add(xDGFPage);
                }
            } catch (IOException e) {
                throw new POIXMLException(e);
            } catch (XmlException e2) {
                throw new POIXMLException(e2);
            }
        } catch (POIXMLException e3) {
            throw XDGFException.wrap(this, e3);
        }
    }

    public List<XDGFPage> getPageList() {
        return Collections.unmodifiableList(this._pages);
    }
}
