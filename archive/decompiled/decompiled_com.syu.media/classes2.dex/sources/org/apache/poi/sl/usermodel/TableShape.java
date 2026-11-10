package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface TableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Shape<S, P>, PlaceableShape<S, P> {
    TableCell<S, P> getCell(int i, int i2);

    double getColumnWidth(int i);

    int getNumberOfColumns();

    int getNumberOfRows();

    double getRowHeight(int i);

    void setColumnWidth(int i, double d);

    void setRowHeight(int i, double d);
}
