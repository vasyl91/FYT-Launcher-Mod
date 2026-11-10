package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.sl.usermodel.Slide;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawSlide extends DrawSheet {
    public DrawSlide(Slide<?, ?> slide) {
        super(slide);
    }

    @Override // org.apache.poi.sl.draw.DrawSheet, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(Drawable.CURRENT_SLIDE, this.sheet);
        Background<S, P> background = this.sheet.getBackground();
        if (background != 0) {
            DrawFactory.getInstance(graphics2D).getDrawable((Background<?, ?>) background).draw(graphics2D);
        }
        super.draw(graphics2D);
        graphics2D.setRenderingHint(Drawable.CURRENT_SLIDE, (Object) null);
    }
}
