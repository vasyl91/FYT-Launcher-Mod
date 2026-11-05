package org.apache.poi.sl.usermodel;

import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Notes<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Sheet<S, P> {
    List<? extends List<P>> getTextParagraphs();
}
