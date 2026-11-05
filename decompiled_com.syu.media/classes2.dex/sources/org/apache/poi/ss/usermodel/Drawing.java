package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.usermodel.Shape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Drawing<T extends Shape> extends ShapeContainer<T> {
    ClientAnchor createAnchor(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    Comment createCellComment(ClientAnchor clientAnchor);

    Chart createChart(ClientAnchor clientAnchor);

    ObjectData createObjectData(ClientAnchor clientAnchor, int i, int i2);

    Picture createPicture(ClientAnchor clientAnchor, int i);
}
