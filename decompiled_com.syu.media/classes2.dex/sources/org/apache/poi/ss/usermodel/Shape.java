package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Shape {
    ChildAnchor getAnchor();

    Shape getParent();

    String getShapeName();

    boolean isNoFill();

    void setFillColor(int i, int i2, int i3);

    void setLineStyleColor(int i, int i2, int i3);

    void setNoFill(boolean z);
}
