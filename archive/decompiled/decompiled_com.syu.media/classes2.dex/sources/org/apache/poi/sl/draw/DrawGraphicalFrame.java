package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.GraphicalFrame;
import org.apache.poi.sl.usermodel.PictureShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawGraphicalFrame extends DrawShape {
    public DrawGraphicalFrame(GraphicalFrame<?, ?> graphicalFrame) {
        super(graphicalFrame);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        PictureShape<?, ?> fallbackPicture = ((GraphicalFrame) getShape()).getFallbackPicture();
        if (fallbackPicture == null) {
            return;
        }
        DrawFactory.getInstance(graphics2D).getDrawable(fallbackPicture).draw(graphics2D);
    }
}
