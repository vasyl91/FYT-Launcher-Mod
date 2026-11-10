package org.apache.poi.xdgf.usermodel.shape;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XDGFText;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ShapeRenderer extends ShapeVisitor {
    protected Graphics2D _graphics;

    public ShapeRenderer() {
        this._graphics = null;
    }

    public ShapeRenderer(Graphics2D graphics2D) {
        this._graphics = graphics2D;
    }

    public void setGraphics(Graphics2D graphics2D) {
        this._graphics = graphics2D;
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
    public void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i) {
        AffineTransform transform = this._graphics.getTransform();
        this._graphics.transform(affineTransform);
        drawPath(xDGFShape);
        drawText(xDGFShape);
        this._graphics.setTransform(transform);
    }

    protected Path2D drawPath(XDGFShape xDGFShape) {
        Path2D.Double path = xDGFShape.getPath();
        if (path != null) {
            this._graphics.setColor(xDGFShape.getLineColor());
            this._graphics.setStroke(xDGFShape.getStroke());
            this._graphics.draw(path);
        }
        return path;
    }

    protected void drawText(XDGFShape xDGFShape) {
        XDGFText text = xDGFShape.getText();
        if (text != null) {
            if (text.getTextContent().equals("Header")) {
                text.getTextBounds();
            }
            Font font = this._graphics.getFont();
            this._graphics.setFont(font.deriveFont(xDGFShape.getFontSize().floatValue()));
            this._graphics.setColor(xDGFShape.getFontColor());
            text.draw(this._graphics);
            this._graphics.setFont(font);
        }
    }
}
