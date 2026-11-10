package com.graphbuilder.curve;

import com.graphbuilder.struc.Bag;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ControlPath {
    private Bag curveBag = new Bag();
    private Bag pointBag = new Bag();

    public void addCurve(Curve curve) {
        if (curve == null) {
            throw new IllegalArgumentException("Curve cannot be null.");
        }
        this.curveBag.add(curve);
    }

    public void addPoint(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }
        this.pointBag.add(point);
    }

    public void insertCurve(Curve curve, int i) {
        if (curve == null) {
            throw new IllegalArgumentException("Curve cannot be null.");
        }
        this.curveBag.insert(curve, i);
    }

    public void insertPoint(Point point, int i) {
        if (point == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }
        this.pointBag.insert(point, i);
    }

    public Curve setCurve(Curve curve, int i) {
        if (curve == null) {
            throw new IllegalArgumentException("Curve cannot be null.");
        }
        return (Curve) this.curveBag.set(curve, i);
    }

    public Point setPoint(Point point, int i) {
        if (point == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }
        return (Point) this.pointBag.set(point, i);
    }

    public Curve getCurve(int i) {
        return (Curve) this.curveBag.get(i);
    }

    public Point getPoint(int i) {
        return (Point) this.pointBag.get(i);
    }

    public int numCurves() {
        return this.curveBag.size();
    }

    public int numPoints() {
        return this.pointBag.size();
    }

    public void removeCurve(Curve curve) {
        this.curveBag.remove(curve);
    }

    public void removePoint(Point point) {
        this.pointBag.remove(point);
    }

    public void removeCurve(int i) {
        this.curveBag.remove(i);
    }

    public void removePoint(int i) {
        this.pointBag.remove(i);
    }

    public void ensureCurveCapacity(int i) {
        this.curveBag.ensureCapacity(i);
    }

    public void ensurePointCapacity(int i) {
        this.pointBag.ensureCapacity(i);
    }

    public void trimCurveArray() {
        this.curveBag.trimArray();
    }

    public void trimPointArray() {
        this.pointBag.trimArray();
    }
}
