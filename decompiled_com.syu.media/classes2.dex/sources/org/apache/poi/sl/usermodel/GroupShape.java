package org.apache.poi.sl.usermodel;

import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface GroupShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Shape<S, P>, ShapeContainer<S, P>, PlaceableShape<S, P> {
    Rectangle2D getInteriorAnchor();

    void setInteriorAnchor(Rectangle2D rectangle2D);
}
