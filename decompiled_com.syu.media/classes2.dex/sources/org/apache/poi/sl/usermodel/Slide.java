package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Slide<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Sheet<S, P> {
    boolean getDisplayPlaceholder(Placeholder placeholder);

    boolean getFollowMasterBackground();

    boolean getFollowMasterColourScheme();

    boolean getFollowMasterObjects();

    Notes<S, P> getNotes();

    int getSlideNumber();

    String getTitle();

    void setFollowMasterBackground(boolean z);

    void setFollowMasterColourScheme(boolean z);

    void setFollowMasterObjects(boolean z);

    void setNotes(Notes<S, P> notes);
}
