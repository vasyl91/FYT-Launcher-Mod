package org.apache.poi.sl.usermodel;

import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PlaceableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
    Rectangle2D getAnchor();

    boolean getFlipHorizontal();

    boolean getFlipVertical();

    ShapeContainer<S, P> getParent();

    double getRotation();

    Sheet<S, P> getSheet();

    void setAnchor(Rectangle2D rectangle2D);

    void setFlipHorizontal(boolean z);

    void setFlipVertical(boolean z);

    void setRotation(double d);
}
