package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;
import org.apache.poi.sl.draw.binding.CTAdjPoint2D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class QuadToCommand implements PathCommand {
    private String arg1;
    private String arg2;
    private String arg3;
    private String arg4;

    QuadToCommand(CTAdjPoint2D cTAdjPoint2D, CTAdjPoint2D cTAdjPoint2D2) {
        this.arg1 = cTAdjPoint2D.getX();
        this.arg2 = cTAdjPoint2D.getY();
        this.arg3 = cTAdjPoint2D2.getX();
        this.arg4 = cTAdjPoint2D2.getY();
    }

    @Override // org.apache.poi.sl.draw.geom.PathCommand
    public void execute(Path2D.Double r11, Context context) {
        r11.quadTo(context.getValue(this.arg1), context.getValue(this.arg2), context.getValue(this.arg3), context.getValue(this.arg4));
    }
}
