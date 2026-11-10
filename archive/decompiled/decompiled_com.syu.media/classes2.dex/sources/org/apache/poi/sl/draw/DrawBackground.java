package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.Sheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawBackground extends DrawShape {
    public DrawBackground(Background<?, ?> background) {
        super(background);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Dimension pageSize = this.shape.getSheet().getSlideShow().getPageSize();
        final Rectangle2D.Double r10 = new Rectangle2D.Double(0.0d, 0.0d, pageSize.getWidth(), pageSize.getHeight());
        Paint paint = DrawFactory.getInstance(graphics2D).getPaint(new PlaceableShape() { // from class: org.apache.poi.sl.draw.DrawBackground.1
            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public boolean getFlipHorizontal() {
                return false;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public boolean getFlipVertical() {
                return false;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public ShapeContainer<?, ?> getParent() {
                return null;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public double getRotation() {
                return 0.0d;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setAnchor(Rectangle2D rectangle2D) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setFlipHorizontal(boolean z) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setFlipVertical(boolean z) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setRotation(double d) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public Rectangle2D getAnchor() {
                return r10;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public Sheet<?, ?> getSheet() {
                return DrawBackground.this.shape.getSheet();
            }
        }).getPaint(graphics2D, getShape().getFillStyle().getPaint());
        Rectangle2D anchor = getAnchor(graphics2D, (Rectangle2D) r10);
        if (paint != null) {
            graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, r10);
            graphics2D.setPaint(paint);
            graphics2D.fill(anchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawShape
    public Background<?, ?> getShape() {
        return (Background) this.shape;
    }
}
