package org.apache.poi.xdgf.geom;

import com.graphbuilder.curve.ControlPath;
import com.graphbuilder.curve.GroupIterator;
import com.graphbuilder.curve.NURBSpline;
import com.graphbuilder.curve.ShapeMultiPath;
import com.graphbuilder.curve.ValueVector;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SplineRenderer {
    public static ShapeMultiPath createNurbsSpline(ControlPath controlPath, ValueVector valueVector, ValueVector valueVector2, int i) {
        double d = valueVector.get(0);
        int size = valueVector.size();
        double d2 = valueVector.get(size - 1);
        for (int i2 = 0; i2 < size; i2++) {
            valueVector.set((valueVector.get(i2) - d) / d2, i2);
        }
        int iNumPoints = controlPath.numPoints() + i + 1;
        while (size < iNumPoints) {
            valueVector.add(1.0d);
            size++;
        }
        NURBSpline nURBSpline = new NURBSpline(controlPath, new GroupIterator("0:n-1", controlPath.numPoints()));
        nURBSpline.setDegree(i);
        nURBSpline.setKnotVectorType(2);
        nURBSpline.setKnotVector(valueVector);
        if (valueVector2 == null) {
            nURBSpline.setUseWeightVector(false);
        } else {
            nURBSpline.setWeightVector(valueVector2);
        }
        ShapeMultiPath shapeMultiPath = new ShapeMultiPath();
        shapeMultiPath.setFlatness(0.01d);
        nURBSpline.appendTo(shapeMultiPath);
        return shapeMultiPath;
    }
}
