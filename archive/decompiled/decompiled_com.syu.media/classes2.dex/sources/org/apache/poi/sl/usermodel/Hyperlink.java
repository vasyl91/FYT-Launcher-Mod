package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Hyperlink<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends org.apache.poi.common.usermodel.Hyperlink {
    void linkToEmail(String str);

    void linkToFirstSlide();

    void linkToLastSlide();

    void linkToNextSlide();

    void linkToPreviousSlide();

    void linkToSlide(Slide<S, P> slide);

    void linkToUrl(String str);
}
