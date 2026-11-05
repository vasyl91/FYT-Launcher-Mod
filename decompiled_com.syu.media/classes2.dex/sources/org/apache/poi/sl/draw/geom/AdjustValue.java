package org.apache.poi.sl.draw.geom;

import org.apache.poi.sl.draw.binding.CTGeomGuide;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AdjustValue extends Guide {
    public AdjustValue(CTGeomGuide cTGeomGuide) {
        super(cTGeomGuide.getName(), cTGeomGuide.getFmla());
    }

    @Override // org.apache.poi.sl.draw.geom.Guide, org.apache.poi.sl.draw.geom.Formula
    public double evaluate(Context context) {
        Guide adjustValue = context.getAdjustValue(getName());
        return adjustValue != null ? adjustValue.evaluate(context) : super.evaluate(context);
    }
}
