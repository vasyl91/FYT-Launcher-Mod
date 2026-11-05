package org.apache.poi.xdgf.usermodel.shape;

import java.awt.geom.AffineTransform;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ShapeVisitor {
    protected ShapeVisitorAcceptor _acceptor = getAcceptor();

    public abstract void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i);

    protected ShapeVisitorAcceptor getAcceptor() {
        return new ShapeVisitorAcceptor() { // from class: org.apache.poi.xdgf.usermodel.shape.ShapeVisitor.1
            @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor
            public boolean accept(XDGFShape xDGFShape) {
                return !xDGFShape.isDeleted();
            }
        };
    }

    public void setAcceptor(ShapeVisitorAcceptor shapeVisitorAcceptor) {
        this._acceptor = shapeVisitorAcceptor;
    }

    public boolean accept(XDGFShape xDGFShape) {
        return this._acceptor.accept(xDGFShape);
    }
}
