package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class ParametricCurve extends Curve {
    protected abstract void eval(double[] dArr);

    public abstract int getSampleLimit();

    public ParametricCurve(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
    }
}
