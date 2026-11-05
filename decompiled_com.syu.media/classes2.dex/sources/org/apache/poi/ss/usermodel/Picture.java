package org.apache.poi.ss.usermodel;

import java.awt.Dimension;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Picture extends Shape {
    ClientAnchor getClientAnchor();

    Dimension getImageDimension();

    PictureData getPictureData();

    ClientAnchor getPreferredSize();

    ClientAnchor getPreferredSize(double d, double d2);

    Sheet getSheet();

    void resize();

    void resize(double d);

    void resize(double d, double d2);
}
