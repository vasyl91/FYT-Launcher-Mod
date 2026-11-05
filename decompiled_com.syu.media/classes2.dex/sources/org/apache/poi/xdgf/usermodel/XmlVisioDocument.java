package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.util.PackageHelper;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlVisioDocument extends POIXMLDocument {
    protected XDGFDocument _document;
    protected XDGFMasters _masters;
    protected XDGFPages _pages;

    public XmlVisioDocument(OPCPackage oPCPackage) throws IOException {
        super(oPCPackage, PackageRelationshipTypes.VISIO_CORE_DOCUMENT);
        try {
            this._document = new XDGFDocument(VisioDocumentDocument1.Factory.parse(getPackagePart().getInputStream()).getVisioDocument());
            load(new XDGFFactory(this._document));
        } catch (IOException e) {
            throw new POIXMLException(e);
        } catch (XmlException e2) {
            throw new POIXMLException(e2);
        }
    }

    public XmlVisioDocument(InputStream inputStream) throws IOException {
        this(PackageHelper.open(inputStream));
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XDGFPages) {
                this._pages = (XDGFPages) pOIXMLDocumentPart;
            } else if (pOIXMLDocumentPart instanceof XDGFMasters) {
                this._masters = (XDGFMasters) pOIXMLDocumentPart;
            }
        }
        XDGFMasters xDGFMasters = this._masters;
        if (xDGFMasters != null) {
            xDGFMasters.onDocumentRead();
        }
        this._pages.onDocumentRead();
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        return new ArrayList();
    }

    public Collection<XDGFPage> getPages() {
        return this._pages.getPageList();
    }

    public XDGFStyleSheet getStyleById(long j) {
        return this._document.getStyleById(j);
    }
}
