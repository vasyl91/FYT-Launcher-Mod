package org.apache.poi.ss.formula;

import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public enum FormulaType {
    CELL(true),
    SHARED(true),
    ARRAY(false),
    CONDFORMAT(true),
    NAMEDRANGE(false),
    DATAVALIDATION_LIST(false);

    private final boolean isSingleValue;

    FormulaType(boolean z) {
        this.isSingleValue = z;
    }

    public boolean isSingleValue() {
        return this.isSingleValue;
    }

    public static FormulaType forInt(int i) {
        if (i >= 0 && i < values().length) {
            return values()[i];
        }
        throw new IllegalArgumentException("Invalid FormulaType code: " + i);
    }
}
