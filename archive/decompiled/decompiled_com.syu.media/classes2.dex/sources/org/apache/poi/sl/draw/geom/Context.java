package org.apache.poi.sl.draw.geom;

import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Context {
    final Rectangle2D _anchor;
    final Map<String, Double> _ctx = new HashMap();
    final IAdjustableShape _props;

    public Context(CustomGeometry customGeometry, Rectangle2D rectangle2D, IAdjustableShape iAdjustableShape) {
        this._props = iAdjustableShape;
        this._anchor = rectangle2D;
        Iterator<Guide> it = customGeometry.adjusts.iterator();
        while (it.hasNext()) {
            evaluate(it.next());
        }
        Iterator<Guide> it2 = customGeometry.guides.iterator();
        while (it2.hasNext()) {
            evaluate(it2.next());
        }
    }

    public Rectangle2D getShapeAnchor() {
        return this._anchor;
    }

    public Guide getAdjustValue(String str) {
        return this._props.getAdjustValue(str);
    }

    public double getValue(String str) {
        if (str.matches("(\\+|-)?\\d+")) {
            return Double.parseDouble(str);
        }
        Double d = this._ctx.get(str);
        return d != null ? d.doubleValue() : evaluate(BuiltInGuide.valueOf("_" + str));
    }

    public double evaluate(Formula formula) {
        String name;
        double dEvaluate = formula.evaluate(this);
        if ((formula instanceof Guide) && (name = ((Guide) formula).getName()) != null) {
            this._ctx.put(name, Double.valueOf(dEvaluate));
        }
        return dEvaluate;
    }
}
