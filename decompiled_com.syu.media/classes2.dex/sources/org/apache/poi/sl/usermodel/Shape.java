package org.apache.poi.sl.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Shape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> {
    void draw(Graphics2D graphics2D, Rectangle2D rectangle2D);

    Rectangle2D getAnchor();

    ShapeContainer<S, P> getParent();

    Sheet<S, P> getSheet();
}
