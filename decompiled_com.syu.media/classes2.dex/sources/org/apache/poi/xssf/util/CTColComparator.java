package org.apache.poi.xssf.util;

import java.util.Comparator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CTColComparator {
    public static final Comparator<CTCol> BY_MAX = new Comparator<CTCol>() { // from class: org.apache.poi.xssf.util.CTColComparator.1
        @Override // java.util.Comparator
        public int compare(CTCol cTCol, CTCol cTCol2) {
            long max = cTCol.getMax();
            long max2 = cTCol2.getMax();
            if (max < max2) {
                return -1;
            }
            return max > max2 ? 1 : 0;
        }
    };
    public static final Comparator<CTCol> BY_MIN_MAX = new Comparator<CTCol>() { // from class: org.apache.poi.xssf.util.CTColComparator.2
        @Override // java.util.Comparator
        public int compare(CTCol cTCol, CTCol cTCol2) {
            long min = cTCol.getMin();
            long min2 = cTCol2.getMin();
            if (min < min2) {
                return -1;
            }
            if (min > min2) {
                return 1;
            }
            return CTColComparator.BY_MAX.compare(cTCol, cTCol2);
        }
    };

    private CTColComparator() {
    }
}
