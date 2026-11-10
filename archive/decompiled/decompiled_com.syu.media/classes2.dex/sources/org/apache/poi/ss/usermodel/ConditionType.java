package org.apache.poi.ss.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ConditionType {
    public final byte id;
    public final String type;
    private static Map<Integer, ConditionType> lookup = new HashMap();
    public static final ConditionType CELL_VALUE_IS = new ConditionType(1, "cellIs");
    public static final ConditionType FORMULA = new ConditionType(2, "expression");
    public static final ConditionType COLOR_SCALE = new ConditionType(3, "colorScale");
    public static final ConditionType DATA_BAR = new ConditionType(4, "dataBar");
    public static final ConditionType FILTER = new ConditionType(5, null);
    public static final ConditionType ICON_SET = new ConditionType(6, "iconSet");

    public String toString() {
        return ((int) this.id) + " - " + this.type;
    }

    public static ConditionType forId(byte b) {
        return forId((int) b);
    }

    public static ConditionType forId(int i) {
        return lookup.get(Integer.valueOf(i));
    }

    private ConditionType(int i, String str) {
        this.id = (byte) i;
        this.type = str;
        lookup.put(Integer.valueOf(i), this);
    }
}
