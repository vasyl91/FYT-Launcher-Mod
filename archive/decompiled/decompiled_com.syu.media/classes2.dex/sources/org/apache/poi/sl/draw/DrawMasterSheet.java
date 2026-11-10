package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.sl.usermodel.Slide;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawMasterSheet extends DrawSheet {
    public DrawMasterSheet(MasterSheet<?, ?> masterSheet) {
        super(masterSheet);
    }

    @Override // org.apache.poi.sl.draw.DrawSheet
    protected boolean canDraw(Graphics2D graphics2D, Shape<?, ?> shape) {
        Placeholder placeholder;
        Slide slide = (Slide) graphics2D.getRenderingHint(Drawable.CURRENT_SLIDE);
        if ((shape instanceof SimpleShape) && (placeholder = ((SimpleShape) shape).getPlaceholder()) != null) {
            return slide.getDisplayPlaceholder(placeholder);
        }
        return slide.getFollowMasterGraphics();
    }
}
