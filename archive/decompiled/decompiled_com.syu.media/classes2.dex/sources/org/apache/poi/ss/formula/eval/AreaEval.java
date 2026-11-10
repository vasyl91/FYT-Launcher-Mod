package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface AreaEval extends TwoDEval, ThreeDEval {
    boolean contains(int i, int i2);

    boolean containsColumn(int i);

    boolean containsRow(int i);

    ValueEval getAbsoluteValue(int i, int i2);

    int getFirstColumn();

    int getFirstRow();

    @Override // org.apache.poi.ss.formula.TwoDEval
    int getHeight();

    int getLastColumn();

    int getLastRow();

    ValueEval getRelativeValue(int i, int i2);

    @Override // org.apache.poi.ss.formula.TwoDEval
    int getWidth();

    AreaEval offset(int i, int i2, int i3, int i4);
}
