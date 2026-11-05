package qin.widgets.grids;

import android.graphics.Rect;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class GridOccupancy {
    public final int a;
    public final int b;
    public final boolean[][] cells;

    public GridOccupancy(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.cells = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i, i2);
    }

    public void clear() {
        markCells(0, 0, this.a, this.b, false);
    }

    public void copyTo(GridOccupancy gridOccupancy) {
        for (int i = 0; i < this.a; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                gridOccupancy.cells[i][i2] = this.cells[i][i2];
            }
        }
    }

    public boolean findVacantCell(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3 + i2;
            if (i4 > this.b) {
                return false;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + i;
                if (i6 <= this.a) {
                    boolean z = !this.cells[i5][i3];
                    for (int i7 = i5; i7 < i6; i7++) {
                        for (int i8 = i3; i8 < i4; i8++) {
                            z = z && !this.cells[i7][i8];
                            if (!z) {
                                break;
                            }
                        }
                    }
                    if (z) {
                        iArr[0] = i5;
                        iArr[1] = i3;
                        return true;
                    }
                    i5++;
                }
            }
            i3++;
        }
    }

    public boolean isRegionVacant(int i, int i2, int i3, int i4) {
        int i5 = (i3 + i) - 1;
        int i6 = (i4 + i2) - 1;
        if (i < 0 || i2 < 0 || i5 >= this.a || i6 >= this.b) {
            return false;
        }
        while (i <= i5) {
            for (int i7 = i2; i7 <= i6; i7++) {
                if (this.cells[i][i7]) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public void markCells(int i, int i2, int i3, int i4, boolean z) {
        if (i < 0 || i2 < 0) {
            return;
        }
        for (int i5 = i; i5 < i + i3 && i5 < this.a; i5++) {
            for (int i6 = i2; i6 < i2 + i4 && i6 < this.b; i6++) {
                this.cells[i5][i6] = z;
            }
        }
    }

    public void markCells(Rect rect, boolean z) {
        markCells(rect.left, rect.top, rect.width(), rect.height(), z);
    }
}
