package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;
import org.apache.poi.sl.draw.binding.CTAdjPoint2D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LineToCommand implements PathCommand {
    private String arg1;
    private String arg2;

    LineToCommand(CTAdjPoint2D cTAdjPoint2D) {
        this.arg1 = cTAdjPoint2D.getX();
        this.arg2 = cTAdjPoint2D.getY();
    }

    LineToCommand(String str, String str2) {
        this.arg1 = str;
        this.arg2 = str2;
    }

    @Override // org.apache.poi.sl.draw.geom.PathCommand
    public void execute(Path2D.Double r5, Context context) {
        r5.lineTo(context.getValue(this.arg1), context.getValue(this.arg2));
    }
}
