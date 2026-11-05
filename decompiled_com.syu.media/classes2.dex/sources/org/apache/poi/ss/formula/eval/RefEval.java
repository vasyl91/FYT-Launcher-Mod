package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface RefEval extends ValueEval, SheetRange {
    int getColumn();

    @Override // org.apache.poi.ss.formula.SheetRange
    int getFirstSheetIndex();

    ValueEval getInnerValueEval(int i);

    @Override // org.apache.poi.ss.formula.SheetRange
    int getLastSheetIndex();

    int getNumberOfSheets();

    int getRow();

    AreaEval offset(int i, int i2, int i3, int i4);
}
