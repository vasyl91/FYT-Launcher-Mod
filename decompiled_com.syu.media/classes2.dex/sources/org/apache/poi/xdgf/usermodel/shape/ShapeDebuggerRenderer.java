package org.apache.poi.xdgf.usermodel.shape;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ShapeDebuggerRenderer extends ShapeRenderer {
    ShapeVisitorAcceptor _debugAcceptor;

    public ShapeDebuggerRenderer() {
        this._debugAcceptor = null;
    }

    public ShapeDebuggerRenderer(Graphics2D graphics2D) {
        super(graphics2D);
        this._debugAcceptor = null;
    }

    public void setDebugAcceptor(ShapeVisitorAcceptor shapeVisitorAcceptor) {
        this._debugAcceptor = shapeVisitorAcceptor;
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeRenderer
    protected Path2D drawPath(XDGFShape xDGFShape) {
        float f;
        Path2D path2DDrawPath = super.drawPath(xDGFShape);
        ShapeVisitorAcceptor shapeVisitorAcceptor = this._debugAcceptor;
        if (shapeVisitorAcceptor == null || shapeVisitorAcceptor.accept(xDGFShape)) {
            Font font = this._graphics.getFont();
            this._graphics.scale(1.0d, -1.0d);
            this._graphics.setFont(font.deriveFont(0.05f));
            String str = "" + xDGFShape.getID();
            if (xDGFShape.hasMasterShape()) {
                str = str + " MS:" + xDGFShape.getMasterShape().getID();
                f = -0.25f;
            } else {
                f = -0.1f;
            }
            this._graphics.drawString(str, f, 0.0f);
            this._graphics.setFont(font);
            this._graphics.scale(1.0d, -1.0d);
        }
        return path2DDrawPath;
    }
}
