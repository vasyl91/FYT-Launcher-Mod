package com.google.android.material.shape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean forceIntersection() {
        return true;
    }

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float fSqrt = (float) ((((double) this.radius) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(fSqrt, 2.0d));
        shapePath.reset(f2 - fSqrt, ((float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius)))) + fSqrt2);
        shapePath.lineTo(f2, (float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius))));
        shapePath.lineTo(f2 + fSqrt, ((float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius)))) + fSqrt2);
    }
}
