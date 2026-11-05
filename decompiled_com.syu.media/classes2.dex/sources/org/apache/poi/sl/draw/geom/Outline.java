package org.apache.poi.sl.draw.geom;

import java.awt.Shape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Outline {
    private Path path;
    private Shape shape;

    public Outline(Shape shape, Path path) {
        this.shape = shape;
        this.path = path;
    }

    public Path getPath() {
        return this.path;
    }

    public Shape getOutline() {
        return this.shape;
    }
}
