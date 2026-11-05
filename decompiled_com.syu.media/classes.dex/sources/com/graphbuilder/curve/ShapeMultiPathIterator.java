package com.graphbuilder.curve;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class ShapeMultiPathIterator implements PathIterator {
    private final int ai0;
    private final int ai1;
    private final AffineTransform at;
    private int n = 0;
    private final ShapeMultiPath smp;
    private final int windingRule;

    ShapeMultiPathIterator(ShapeMultiPath shapeMultiPath, AffineTransform affineTransform) {
        this.smp = shapeMultiPath;
        int[] basisVectors = shapeMultiPath.getBasisVectors();
        this.ai0 = basisVectors[0];
        this.ai1 = basisVectors[1];
        this.at = affineTransform;
        this.windingRule = shapeMultiPath.getWindingRule();
    }

    public int getWindingRule() {
        return this.windingRule;
    }

    public boolean isDone() {
        return this.n >= this.smp.getNumPoints();
    }

    public void next() {
        this.n++;
    }

    public int currentSegment(float[] fArr) {
        double[] dArr = this.smp.get(this.n);
        fArr[0] = (float) dArr[this.ai0];
        fArr[1] = (float) dArr[this.ai1];
        if (this.n > 0 && dArr == this.smp.get(0)) {
            return 4;
        }
        AffineTransform affineTransform = this.at;
        if (affineTransform != null) {
            affineTransform.transform(fArr, 0, fArr, 0, 1);
        }
        return this.smp.getType(this.n) == MultiPath.MOVE_TO ? 0 : 1;
    }

    public int currentSegment(double[] dArr) {
        double[] dArr2 = this.smp.get(this.n);
        dArr[0] = dArr2[this.ai0];
        dArr[1] = dArr2[this.ai1];
        if (this.n > 0 && dArr2 == this.smp.get(0)) {
            return 4;
        }
        AffineTransform affineTransform = this.at;
        if (affineTransform != null) {
            affineTransform.transform(dArr, 0, dArr, 0, 1);
        }
        return this.smp.getType(this.n) == MultiPath.MOVE_TO ? 0 : 1;
    }
}
