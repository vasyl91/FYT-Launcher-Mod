package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.RowType;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.util.ObjectFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GeometryRowFactory {
    static final ObjectFactory<GeometryRow, RowType> _rowTypes;

    static {
        ObjectFactory<GeometryRow, RowType> objectFactory = new ObjectFactory<>();
        _rowTypes = objectFactory;
        try {
            objectFactory.put("ArcTo", ArcTo.class, RowType.class);
            objectFactory.put("Ellipse", Ellipse.class, RowType.class);
            objectFactory.put("EllipticalArcTo", EllipticalArcTo.class, RowType.class);
            objectFactory.put("InfiniteLine", InfiniteLine.class, RowType.class);
            objectFactory.put("LineTo", LineTo.class, RowType.class);
            objectFactory.put("MoveTo", MoveTo.class, RowType.class);
            objectFactory.put("NURBSTo", NURBSTo.class, RowType.class);
            objectFactory.put("PolylineTo", PolyLineTo.class, RowType.class);
            objectFactory.put("PolyLineTo", PolyLineTo.class, RowType.class);
            objectFactory.put("RelCubBezTo", RelCubBezTo.class, RowType.class);
            objectFactory.put("RelEllipticalArcTo", RelEllipticalArcTo.class, RowType.class);
            objectFactory.put("RelLineTo", RelLineTo.class, RowType.class);
            objectFactory.put("RelMoveTo", RelMoveTo.class, RowType.class);
            objectFactory.put("RelQuadBezTo", RelQuadBezTo.class, RowType.class);
            objectFactory.put("SplineKnot", SplineKnot.class, RowType.class);
            objectFactory.put("SplineStart", SplineStart.class, RowType.class);
        } catch (NoSuchMethodException e) {
            throw new POIXMLException("Internal error", e);
        } catch (SecurityException e2) {
            throw new POIXMLException("Internal error", e2);
        }
    }

    public static GeometryRow load(RowType rowType) {
        return _rowTypes.load(rowType.getT(), rowType);
    }
}
