package org.apache.poi.xdgf.geom;

import com.graphbuilder.curve.ControlPath;
import com.graphbuilder.curve.ValueVector;
import com.graphbuilder.geom.PointFactory;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SplineCollector {
    ArrayList<SplineKnot> _knots = new ArrayList<>();
    SplineStart _start;

    public SplineCollector(SplineStart splineStart) {
        this._start = splineStart;
    }

    public void addKnot(SplineKnot splineKnot) {
        if (splineKnot.getDel()) {
            return;
        }
        this._knots.add(splineKnot);
    }

    public void addToPath(Path2D.Double r10, XDGFShape xDGFShape) {
        Point2D currentPoint = r10.getCurrentPoint();
        ControlPath controlPath = new ControlPath();
        ValueVector valueVector = new ValueVector(this._knots.size() + 3);
        double dDoubleValue = this._start.getB().doubleValue();
        double dDoubleValue2 = this._start.getC().doubleValue();
        int iIntValue = this._start.getD().intValue();
        valueVector.add(dDoubleValue);
        valueVector.add(this._start.getA().doubleValue());
        controlPath.addPoint(PointFactory.create(currentPoint.getX(), currentPoint.getY()));
        controlPath.addPoint(PointFactory.create(this._start.getX().doubleValue(), this._start.getY().doubleValue()));
        for (SplineKnot splineKnot : this._knots) {
            valueVector.add(splineKnot.getA().doubleValue());
            controlPath.addPoint(PointFactory.create(splineKnot.getX().doubleValue(), splineKnot.getY().doubleValue()));
        }
        valueVector.add(dDoubleValue2);
        r10.append(SplineRenderer.createNurbsSpline(controlPath, valueVector, null, iIntValue), true);
    }
}
