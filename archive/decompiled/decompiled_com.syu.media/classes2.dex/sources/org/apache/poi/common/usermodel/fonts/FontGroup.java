package org.apache.poi.common.usermodel.fonts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum FontGroup {
    LATIN,
    EAST_ASIAN,
    SYMBOL,
    COMPLEX_SCRIPT;

    private static NavigableMap<Integer, Range> UCS_RANGES;

    static {
        FontGroup fontGroup = LATIN;
        FontGroup fontGroup2 = EAST_ASIAN;
        FontGroup fontGroup3 = SYMBOL;
        FontGroup fontGroup4 = COMPLEX_SCRIPT;
        TreeMap treeMap = new TreeMap();
        UCS_RANGES = treeMap;
        treeMap.put(0, new Range(127, fontGroup));
        UCS_RANGES.put(128, new Range(166, fontGroup));
        UCS_RANGES.put(169, new Range(175, fontGroup));
        UCS_RANGES.put(178, new Range(179, fontGroup));
        UCS_RANGES.put(181, new Range(FinalCanbus.CAR_RZC_XP1_14Prado_L, fontGroup));
        UCS_RANGES.put(Integer.valueOf(FinalCanbus.CAR_RZC_XP1_BeiQiShenBaoD60), new Range(FinalCanbus.CAR_WC2_14BaoJun730, fontGroup));
        UCS_RANGES.put(Integer.valueOf(FinalCanbus.CAR_RZC2_ZhongHuaV5), new Range(1423, fontGroup));
        UCS_RANGES.put(1424, new Range(1871, fontGroup4));
        UCS_RANGES.put(1920, new Range(1983, fontGroup4));
        UCS_RANGES.put(2304, new Range(4255, fontGroup4));
        UCS_RANGES.put(4256, new Range(4351, fontGroup));
        UCS_RANGES.put(4608, new Range(4991, fontGroup));
        UCS_RANGES.put(5024, new Range(6015, fontGroup));
        UCS_RANGES.put(7424, new Range(7551, fontGroup));
        UCS_RANGES.put(7680, new Range(8191, fontGroup));
        UCS_RANGES.put(6016, new Range(6319, fontGroup4));
        UCS_RANGES.put(8192, new Range(8203, fontGroup));
        UCS_RANGES.put(8204, new Range(8207, fontGroup4));
        UCS_RANGES.put(8208, new Range(8233, fontGroup));
        UCS_RANGES.put(8234, new Range(8239, fontGroup4));
        UCS_RANGES.put(8240, new Range(8262, fontGroup));
        UCS_RANGES.put(8266, new Range(9311, fontGroup));
        UCS_RANGES.put(9840, new Range(9841, fontGroup4));
        UCS_RANGES.put(10176, new Range(11263, fontGroup));
        UCS_RANGES.put(12441, new Range(12442, fontGroup2));
        UCS_RANGES.put(55349, new Range(55349, fontGroup));
        UCS_RANGES.put(Integer.valueOf(FinalCanbus.CAR_F000_XiaoMaYi), new Range(61695, fontGroup3));
        UCS_RANGES.put(64256, new Range(64279, fontGroup));
        UCS_RANGES.put(64285, new Range(64335, fontGroup4));
        UCS_RANGES.put(65104, new Range(65135, fontGroup));
    }

    public static class FontGroupRange {
        private FontGroup fontGroup;
        private int len;

        static /* synthetic */ int access$112(FontGroupRange fontGroupRange, int i) {
            int i2 = fontGroupRange.len + i;
            fontGroupRange.len = i2;
            return i2;
        }

        public int getLength() {
            return this.len;
        }

        public FontGroup getFontGroup() {
            return this.fontGroup;
        }
    }

    private static class Range {
        FontGroup fontGroup;
        int upper;

        Range(int i, FontGroup fontGroup) {
            this.upper = i;
            this.fontGroup = fontGroup;
        }
    }

    public static List<FontGroupRange> getFontGroupRanges(String str) {
        FontGroup fontGroupLookup;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int length = str != null ? str.length() : 0;
        FontGroupRange fontGroupRange = null;
        while (i < length) {
            int iCodePointAt = str.codePointAt(i);
            int iCharCount = Character.charCount(iCodePointAt);
            if (fontGroupRange != null && " \n\r".indexOf(iCodePointAt) > -1) {
                fontGroupLookup = fontGroupRange.fontGroup;
            } else {
                fontGroupLookup = lookup(iCodePointAt);
            }
            if (fontGroupRange == null || fontGroupRange.fontGroup != fontGroupLookup) {
                fontGroupRange = new FontGroupRange();
                fontGroupRange.fontGroup = fontGroupLookup;
                arrayList.add(fontGroupRange);
            }
            FontGroupRange.access$112(fontGroupRange, iCharCount);
            i += iCharCount;
        }
        return arrayList;
    }

    public static FontGroup getFontGroupFirst(String str) {
        return (str == null || str.isEmpty()) ? LATIN : lookup(str.codePointAt(0));
    }

    private static FontGroup lookup(int i) {
        Map.Entry<Integer, Range> entryFloorEntry = UCS_RANGES.floorEntry(Integer.valueOf(i));
        Range value = entryFloorEntry != null ? entryFloorEntry.getValue() : null;
        return (value == null || i > value.upper) ? EAST_ASIAN : value.fontGroup;
    }
}
