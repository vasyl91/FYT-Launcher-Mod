package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.poi.sl.draw.geom.Outline;
import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.sl.usermodel.FreeformShape;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.TextShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawFreeformShape extends DrawAutoShape {
    public DrawFreeformShape(FreeformShape<?, ?> freeformShape) {
        super(freeformShape);
    }

    @Override // org.apache.poi.sl.draw.DrawSimpleShape
    protected Collection<Outline> computeOutlines(Graphics2D graphics2D) {
        ArrayList arrayList = new ArrayList();
        FreeformShape freeformShape = (FreeformShape) getShape();
        Path2D.Double path = freeformShape.getPath();
        AffineTransform affineTransform = (AffineTransform) graphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
        if (affineTransform == null) {
            affineTransform = new AffineTransform();
        }
        arrayList.add(new Outline(affineTransform.createTransformedShape(path), new Path(freeformShape.getFillStyle() != null, freeformShape.getStrokeStyle() != null)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawTextShape, org.apache.poi.sl.draw.DrawSimpleShape, org.apache.poi.sl.draw.DrawShape
    public TextShape<?, ? extends TextParagraph<?, ?, ? extends TextRun>> getShape() {
        return (TextShape) this.shape;
    }
}
