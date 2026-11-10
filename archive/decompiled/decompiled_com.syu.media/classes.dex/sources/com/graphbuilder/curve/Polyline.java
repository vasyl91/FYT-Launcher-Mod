package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Polyline extends Curve {
    public Polyline(ControlPath controlPath, GroupIterator groupIterator) {
        super(controlPath, groupIterator);
    }

    @Override // com.graphbuilder.curve.Curve
    public void appendTo(MultiPath multiPath) {
        if (!this.gi.isInRange(0, this.cp.numPoints())) {
            throw new IllegalArgumentException("Group iterator not in range");
        }
        this.gi.set(0, 0);
        if (this.connect) {
            multiPath.lineTo(this.cp.getPoint(this.gi.next()).getLocation());
        } else {
            multiPath.moveTo(this.cp.getPoint(this.gi.next()).getLocation());
        }
        while (this.gi.hasNext()) {
            multiPath.lineTo(this.cp.getPoint(this.gi.next()).getLocation());
        }
    }
}
