package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ConditionalFormattingThreshold {
    String getFormula();

    RangeType getRangeType();

    Double getValue();

    void setFormula(String str);

    void setRangeType(RangeType rangeType);

    void setValue(Double d);

    public enum RangeType {
        NUMBER(1, "num"),
        MIN(2, "min"),
        MAX(3, "max"),
        PERCENT(4, "percent"),
        PERCENTILE(5, "percentile"),
        UNALLOCATED(6, null),
        FORMULA(7, "formula");

        public final int id;
        public final String name;

        @Override // java.lang.Enum
        public String toString() {
            return this.id + " - " + this.name;
        }

        public static RangeType byId(int i) {
            return values()[i - 1];
        }

        public static RangeType byName(String str) {
            for (RangeType rangeType : values()) {
                if (rangeType.name.equals(str)) {
                    return rangeType;
                }
            }
            return null;
        }

        RangeType(int i, String str) {
            this.id = i;
            this.name = str;
        }
    }
}
