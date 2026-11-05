package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ClosePathCommand implements PathCommand {
    ClosePathCommand() {
    }

    @Override // org.apache.poi.sl.draw.geom.PathCommand
    public void execute(Path2D.Double r1, Context context) {
        r1.closePath();
    }
}
