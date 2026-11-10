package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.usermodel.shape.ShapeRenderer;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
import org.apache.poi.xdgf.usermodel.shape.exceptions.StopVisiting;
import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFBaseContents extends XDGFXMLDocumentPart {
    protected List<XDGFConnection> _connections;
    protected PageContentsType _pageContents;
    protected Map<Long, XDGFShape> _shapes;
    protected List<XDGFShape> _toplevelShapes;

    public XDGFBaseContents(PackagePart packagePart, XDGFDocument xDGFDocument) {
        super(packagePart, xDGFDocument);
        this._toplevelShapes = new ArrayList();
        this._shapes = new HashMap();
        this._connections = new ArrayList();
    }

    @Internal
    public PageContentsType getXmlObject() {
        return this._pageContents;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() {
        if (this._pageContents.isSetShapes()) {
            for (ShapeSheetType shapeSheetType : this._pageContents.getShapes().getShapeArray()) {
                XDGFShape xDGFShape = new XDGFShape(shapeSheetType, this, this._document);
                this._toplevelShapes.add(xDGFShape);
                addToShapeIndex(xDGFShape);
            }
        }
        if (this._pageContents.isSetConnects()) {
            for (ConnectType connectType : this._pageContents.getConnects().getConnectArray()) {
                XDGFShape xDGFShape2 = this._shapes.get(Long.valueOf(connectType.getFromSheet()));
                XDGFShape xDGFShape3 = this._shapes.get(Long.valueOf(connectType.getToSheet()));
                if (xDGFShape2 == null) {
                    throw new POIXMLException(this + "; Connect; Invalid from id: " + connectType.getFromSheet());
                }
                if (xDGFShape3 == null) {
                    throw new POIXMLException(this + "; Connect; Invalid to id: " + connectType.getToSheet());
                }
                this._connections.add(new XDGFConnection(connectType, xDGFShape2, xDGFShape3));
            }
        }
    }

    protected void addToShapeIndex(XDGFShape xDGFShape) {
        this._shapes.put(Long.valueOf(xDGFShape.getID()), xDGFShape);
        List<XDGFShape> shapes = xDGFShape.getShapes();
        if (shapes == null) {
            return;
        }
        Iterator<XDGFShape> it = shapes.iterator();
        while (it.hasNext()) {
            addToShapeIndex(it.next());
        }
    }

    public void draw(Graphics2D graphics2D) {
        visitShapes(new ShapeRenderer(graphics2D));
    }

    public XDGFShape getShapeById(long j) {
        return this._shapes.get(Long.valueOf(j));
    }

    public Map<Long, XDGFShape> getShapesMap() {
        return Collections.unmodifiableMap(this._shapes);
    }

    public Collection<XDGFShape> getShapes() {
        return this._shapes.values();
    }

    public List<XDGFShape> getTopLevelShapes() {
        return Collections.unmodifiableList(this._toplevelShapes);
    }

    public List<XDGFConnection> getConnections() {
        return Collections.unmodifiableList(this._connections);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public String toString() {
        return getPackagePart().getPartName().toString();
    }

    public void visitShapes(ShapeVisitor shapeVisitor) {
        try {
            Iterator<XDGFShape> it = this._toplevelShapes.iterator();
            while (it.hasNext()) {
                it.next().visitShapes(shapeVisitor, new AffineTransform(), 0);
            }
        } catch (POIXMLException e) {
            throw XDGFException.wrap(this, e);
        } catch (StopVisiting unused) {
        }
    }
}
