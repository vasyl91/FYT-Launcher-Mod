package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.geom.Dimension2dDouble;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFPage {
    protected XDGFPageContents _content;
    private PageType _page;
    protected XDGFSheet _pageSheet;
    protected XDGFPages _pages;

    public XDGFPage(PageType pageType, XDGFPageContents xDGFPageContents, XDGFDocument xDGFDocument, XDGFPages xDGFPages) {
        this._pageSheet = null;
        this._page = pageType;
        this._content = xDGFPageContents;
        this._pages = xDGFPages;
        xDGFPageContents.setPage(this);
        if (pageType.isSetPageSheet()) {
            this._pageSheet = new XDGFPageSheet(pageType.getPageSheet(), xDGFDocument);
        }
    }

    @Internal
    protected PageType getXmlObject() {
        return this._page;
    }

    public long getID() {
        return this._page.getID();
    }

    public String getName() {
        return this._page.getName();
    }

    public XDGFPageContents getContent() {
        return this._content;
    }

    public XDGFSheet getPageSheet() {
        return this._pageSheet;
    }

    public long getPageNumber() {
        return this._pages.getPageList().indexOf(this) + 1;
    }

    public Dimension2dDouble getPageSize() {
        XDGFCell cell = this._pageSheet.getCell("PageWidth");
        XDGFCell cell2 = this._pageSheet.getCell("PageHeight");
        if (cell == null || cell2 == null) {
            throw new POIXMLException("Cannot determine page size");
        }
        return new Dimension2dDouble(Double.parseDouble(cell.getValue()), Double.parseDouble(cell2.getValue()));
    }

    public Point2D.Double getPageOffset() {
        XDGFCell cell = this._pageSheet.getCell("XRulerOrigin");
        return new Point2D.Double(cell != null ? Double.parseDouble(cell.getValue()) : 0.0d, cell != null ? Double.parseDouble(this._pageSheet.getCell("YRulerOrigin").getValue()) : 0.0d);
    }

    public Rectangle2D getBoundingBox() {
        Dimension2dDouble pageSize = getPageSize();
        Point2D.Double pageOffset = getPageOffset();
        return new Rectangle2D.Double(-pageOffset.getX(), -pageOffset.getY(), pageSize.getWidth(), pageSize.getHeight());
    }
}
