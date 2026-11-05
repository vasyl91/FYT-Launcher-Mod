package org.apache.poi.sl.usermodel;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Sheet<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends ShapeContainer<S, P> {
    void draw(Graphics2D graphics2D);

    Background<S, P> getBackground();

    boolean getFollowMasterGraphics();

    MasterSheet<S, P> getMasterSheet();

    SlideShow<S, P> getSlideShow();
}
