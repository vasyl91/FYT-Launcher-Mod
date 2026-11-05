package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.Shape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawNothing implements Drawable {
    protected final Shape<?, ?> shape;

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }

    public DrawNothing(Shape<?, ?> shape) {
        this.shape = shape;
    }
}
