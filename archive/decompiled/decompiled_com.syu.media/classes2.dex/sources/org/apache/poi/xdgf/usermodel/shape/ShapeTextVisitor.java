package org.apache.poi.xdgf.usermodel.shape;

import java.awt.geom.AffineTransform;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ShapeTextVisitor extends ShapeVisitor {
    protected StringBuilder text = new StringBuilder();

    public static class TextAcceptor implements ShapeVisitorAcceptor {
        @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor
        public boolean accept(XDGFShape xDGFShape) {
            return xDGFShape.hasText();
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
    protected ShapeVisitorAcceptor getAcceptor() {
        return new TextAcceptor();
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
    public void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i) {
        this.text.append(xDGFShape.getText().getTextContent().trim());
        this.text.append('\n');
    }

    public String getText() {
        return this.text.toString();
    }
}
