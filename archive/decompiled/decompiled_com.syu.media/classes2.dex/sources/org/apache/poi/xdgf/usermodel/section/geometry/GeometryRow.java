package org.apache.poi.xdgf.usermodel.section.geometry;

import java.awt.geom.Path2D;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface GeometryRow {
    void addToPath(Path2D.Double r1, XDGFShape xDGFShape);

    void setupMaster(GeometryRow geometryRow);
}
