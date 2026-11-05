package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.RowType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import java.awt.geom.Path2D;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.geom.SplineCollector;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XDGFSheet;
import org.apache.poi.xdgf.usermodel.section.geometry.Ellipse;
import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;
import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRowFactory;
import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GeometrySection extends XDGFSection {
    GeometrySection _master;
    SortedMap<Long, GeometryRow> _rows;

    public GeometrySection(SectionType sectionType, XDGFSheet xDGFSheet) {
        super(sectionType, xDGFSheet);
        this._master = null;
        this._rows = new TreeMap();
        for (RowType rowType : sectionType.getRowArray()) {
            if (this._rows.containsKey(Long.valueOf(rowType.getIX()))) {
                throw new POIXMLException("Index element '" + rowType.getIX() + "' already exists");
            }
            this._rows.put(Long.valueOf(rowType.getIX()), GeometryRowFactory.load(rowType));
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.XDGFSection
    public void setupMaster(XDGFSection xDGFSection) {
        this._master = (GeometrySection) xDGFSection;
        for (Map.Entry<Long, GeometryRow> entry : this._rows.entrySet()) {
            GeometryRow geometryRow = this._master._rows.get(entry.getKey());
            if (geometryRow != null) {
                try {
                    entry.getValue().setupMaster(geometryRow);
                } catch (ClassCastException unused) {
                }
            }
        }
    }

    public Boolean getNoShow() {
        Boolean boolMaybeGetBoolean = XDGFCell.maybeGetBoolean(this._cells, "NoShow");
        if (boolMaybeGetBoolean != null) {
            return boolMaybeGetBoolean;
        }
        GeometrySection geometrySection = this._master;
        if (geometrySection != null) {
            return geometrySection.getNoShow();
        }
        return false;
    }

    public Iterable<GeometryRow> getCombinedRows() {
        SortedMap<Long, GeometryRow> sortedMap = this._rows;
        GeometrySection geometrySection = this._master;
        return new CombinedIterable(sortedMap, geometrySection == null ? null : geometrySection._rows);
    }

    public Path2D.Double getPath(XDGFShape xDGFShape) {
        GeometryRow geometryRow;
        Iterator<GeometryRow> it = getCombinedRows().iterator();
        GeometryRow next = it.next();
        if (next instanceof Ellipse) {
            return ((Ellipse) next).getPath();
        }
        if (next instanceof InfiniteLine) {
            return ((InfiniteLine) next).getPath();
        }
        if (next instanceof SplineStart) {
            throw new POIXMLException("SplineStart must be preceded by another type");
        }
        Path2D.Double r2 = new Path2D.Double();
        SplineCollector splineCollector = null;
        while (true) {
            if (next != null) {
                geometryRow = null;
            } else {
                if (!it.hasNext()) {
                    if (splineCollector != null) {
                        splineCollector.addToPath(r2, xDGFShape);
                    }
                    return r2;
                }
                geometryRow = next;
                next = it.next();
            }
            if (next instanceof SplineStart) {
                if (splineCollector != null) {
                    throw new POIXMLException("SplineStart found multiple times!");
                }
                splineCollector = new SplineCollector((SplineStart) next);
            } else if (!(next instanceof SplineKnot)) {
                if (splineCollector != null) {
                    splineCollector.addToPath(r2, xDGFShape);
                    splineCollector = null;
                }
                next.addToPath(r2, xDGFShape);
            } else {
                if (splineCollector == null) {
                    throw new POIXMLException("SplineKnot found without SplineStart!");
                }
                splineCollector.addKnot((SplineKnot) next);
            }
            next = geometryRow;
        }
    }
}
