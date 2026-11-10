package org.apache.poi.sl.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Iterator;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.Sheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawSheet implements Drawable {
    protected final Sheet<?, ?> sheet;

    @Override // org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
    }

    protected boolean canDraw(Graphics2D graphics2D, Shape<?, ?> shape) {
        return true;
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
    }

    public DrawSheet(Sheet<?, ?> sheet) {
        this.sheet = sheet;
    }

    @Override // org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Dimension pageSize = this.sheet.getSlideShow().getPageSize();
        graphics2D.setColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        graphics2D.fillRect(0, 0, (int) pageSize.getWidth(), (int) pageSize.getHeight());
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        MasterSheet<?, ?> masterSheet = this.sheet.getMasterSheet();
        if (this.sheet.getFollowMasterGraphics() && masterSheet != null) {
            drawFactory.getDrawable(masterSheet).draw(graphics2D);
        }
        graphics2D.setRenderingHint(Drawable.GROUP_TRANSFORM, new AffineTransform());
        Iterator<?> it = this.sheet.getShapes().iterator();
        while (it.hasNext()) {
            Shape<?, ?> shape = (Shape) it.next();
            if (canDraw(graphics2D, shape)) {
                AffineTransform transform = graphics2D.getTransform();
                graphics2D.setRenderingHint(Drawable.GSAVE, true);
                Drawable drawable = drawFactory.getDrawable(shape);
                drawable.applyTransform(graphics2D);
                drawable.draw(graphics2D);
                graphics2D.setTransform(transform);
                graphics2D.setRenderingHint(Drawable.GRESTORE, true);
            }
        }
    }
}
