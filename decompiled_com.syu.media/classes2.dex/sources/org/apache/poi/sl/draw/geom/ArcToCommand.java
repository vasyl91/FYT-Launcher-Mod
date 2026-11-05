package org.apache.poi.sl.draw.geom;

import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import org.apache.poi.sl.draw.binding.CTPath2DArcTo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ArcToCommand implements PathCommand {
    private String hr;
    private String stAng;
    private String swAng;
    private String wr;

    ArcToCommand(CTPath2DArcTo cTPath2DArcTo) {
        this.hr = cTPath2DArcTo.getHR();
        this.wr = cTPath2DArcTo.getWR();
        this.stAng = cTPath2DArcTo.getStAng();
        this.swAng = cTPath2DArcTo.getSwAng();
    }

    @Override // org.apache.poi.sl.draw.geom.PathCommand
    public void execute(Path2D.Double r31, Context context) {
        double value = context.getValue(this.wr);
        double value2 = context.getValue(this.hr);
        double value3 = context.getValue(this.stAng) / 60000.0d;
        double value4 = context.getValue(this.swAng) / 60000.0d;
        double dConvertOoxml2AwtAngle = convertOoxml2AwtAngle(value3, value, value2);
        double dConvertOoxml2AwtAngle2 = convertOoxml2AwtAngle(value3 + value4, value, value2) - dConvertOoxml2AwtAngle;
        double radians = Math.toRadians(value3);
        double dAtan2 = Math.atan2(Math.sin(radians) * value, Math.cos(radians) * value2);
        Point2D currentPoint = r31.getCurrentPoint();
        r31.append(new Arc2D.Double((currentPoint.getX() - (Math.cos(dAtan2) * value)) - value, (currentPoint.getY() - (Math.sin(dAtan2) * value2)) - value2, value * 2.0d, value2 * 2.0d, dConvertOoxml2AwtAngle, dConvertOoxml2AwtAngle2, 0), true);
    }

    private double convertOoxml2AwtAngle(double d, double d2, double d3) {
        double d4 = d3 / d2;
        double d5 = -d;
        double d6 = d5 % 360.0d;
        double d7 = d5 - d6;
        int i = (int) (d6 / 90.0d);
        if (i == -3) {
            d7 -= 360.0d;
            d6 += 360.0d;
        } else if (i == -2 || i == -1) {
            d7 -= 180.0d;
            d6 += 180.0d;
        } else if (i == 1 || i == 2) {
            d7 += 180.0d;
            d6 -= 180.0d;
        } else if (i == 3) {
            d7 += 360.0d;
            d6 -= 360.0d;
        }
        return Math.toDegrees(Math.atan2(Math.tan(Math.toRadians(d6)), d4)) + d7;
    }
}
