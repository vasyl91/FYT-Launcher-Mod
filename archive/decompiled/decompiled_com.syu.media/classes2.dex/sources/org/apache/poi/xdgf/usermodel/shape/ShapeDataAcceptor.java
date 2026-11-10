package org.apache.poi.xdgf.usermodel.shape;

import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ShapeDataAcceptor implements ShapeVisitorAcceptor {
    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor
    public boolean accept(XDGFShape xDGFShape) {
        if (xDGFShape.isDeleted()) {
            return false;
        }
        if ((xDGFShape.hasText() && xDGFShape.getTextAsString().length() != 0) || xDGFShape.isShape1D()) {
            return true;
        }
        if (!xDGFShape.hasMaster() && !xDGFShape.hasMasterShape()) {
            return true;
        }
        if (!xDGFShape.hasMaster() || xDGFShape.hasMasterShape()) {
            return xDGFShape.hasMasterShape() && xDGFShape.getMasterShape().isTopmost();
        }
        return true;
    }
}
