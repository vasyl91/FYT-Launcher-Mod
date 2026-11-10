package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface CellRange<C extends Cell> extends Iterable<C> {
    C getCell(int i, int i2);

    C[][] getCells();

    C[] getFlattenedCells();

    int getHeight();

    String getReferenceText();

    C getTopLeftCell();

    int getWidth();

    @Override // java.lang.Iterable
    Iterator<C> iterator();

    int size();
}
