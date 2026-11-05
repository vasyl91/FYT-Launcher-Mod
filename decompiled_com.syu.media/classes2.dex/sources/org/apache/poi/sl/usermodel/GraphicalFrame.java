package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface GraphicalFrame<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Shape<S, P>, PlaceableShape<S, P> {
    PictureShape<S, P> getFallbackPicture();
}
