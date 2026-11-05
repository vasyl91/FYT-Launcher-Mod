package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.Shape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawGroupShape extends DrawShape {
    public DrawGroupShape(GroupShape<?, ?> groupShape) {
        super(groupShape);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Rectangle2D interiorAnchor = getShape().getInteriorAnchor();
        Rectangle2D anchor = getShape().getAnchor();
        AffineTransform affineTransform = (AffineTransform) graphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
        AffineTransform affineTransform2 = new AffineTransform(affineTransform);
        double width = interiorAnchor.getWidth() == 0.0d ? 1.0d : anchor.getWidth() / interiorAnchor.getWidth();
        double height = interiorAnchor.getHeight() != 0.0d ? anchor.getHeight() / interiorAnchor.getHeight() : 1.0d;
        affineTransform.translate(anchor.getX(), anchor.getY());
        affineTransform.scale(width, height);
        affineTransform.translate(-interiorAnchor.getX(), -interiorAnchor.getY());
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        AffineTransform transform = graphics2D.getTransform();
        Iterator it = getShape().iterator();
        while (it.hasNext()) {
            Shape<?, ?> shape = (Shape) it.next();
            AffineTransform transform2 = graphics2D.getTransform();
            graphics2D.setRenderingHint(Drawable.GSAVE, true);
            Drawable drawable = drawFactory.getDrawable(shape);
            drawable.applyTransform(graphics2D);
            drawable.draw(graphics2D);
            graphics2D.setTransform(transform2);
            graphics2D.setRenderingHint(Drawable.GRESTORE, true);
        }
        graphics2D.setTransform(transform);
        graphics2D.setRenderingHint(Drawable.GROUP_TRANSFORM, affineTransform2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawShape
    public GroupShape<?, ?> getShape() {
        return (GroupShape) this.shape;
    }
}
