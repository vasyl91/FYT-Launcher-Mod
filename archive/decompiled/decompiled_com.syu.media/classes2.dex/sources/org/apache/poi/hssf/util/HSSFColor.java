package org.apache.poi.hssf.util;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import module.canbus.FinalCanbus;
import org.apache.poi.hpsf.Variant;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFColor implements Color {
    private static Map<HSSFColorPredefined, HSSFColor> enumList;
    private static Map<Integer, HSSFColor> indexHash;
    private java.awt.Color color;
    private int index;
    private int index2;

    public enum HSSFColorPredefined {
        BLACK(8, -1, 0),
        BROWN(60, -1, 10040064),
        OLIVE_GREEN(59, -1, 3355392),
        DARK_GREEN(58, -1, 13056),
        DARK_TEAL(56, -1, 13158),
        DARK_BLUE(18, 32, 128),
        INDIGO(62, -1, 3355545),
        GREY_80_PERCENT(63, -1, 3355443),
        ORANGE(53, -1, 16737792),
        DARK_YELLOW(19, -1, 8421376),
        GREEN(17, -1, 32768),
        TEAL(21, 38, 32896),
        BLUE(12, 39, 255),
        BLUE_GREY(54, -1, 6710937),
        GREY_50_PERCENT(23, -1, 8421504),
        RED(10, -1, 16711680),
        LIGHT_ORANGE(52, -1, 16750848),
        LIME(50, -1, 10079232),
        SEA_GREEN(57, -1, 3381606),
        AQUA(49, -1, 3394764),
        LIGHT_BLUE(48, -1, 3368703),
        VIOLET(20, 36, 8388736),
        GREY_40_PERCENT(55, -1, 9868950),
        PINK(14, 33, 16711935),
        GOLD(51, -1, 16763904),
        YELLOW(13, 34, 16776960),
        BRIGHT_GREEN(11, -1, 65280),
        TURQUOISE(15, 35, Variant.VT_ILLEGAL),
        DARK_RED(16, 37, 8388608),
        SKY_BLUE(40, -1, 52479),
        PLUM(61, 25, 10040166),
        GREY_25_PERCENT(22, -1, 12632256),
        ROSE(45, -1, 16751052),
        LIGHT_YELLOW(43, -1, 16777113),
        LIGHT_GREEN(42, -1, 13434828),
        LIGHT_TURQUOISE(41, 27, 13434879),
        PALE_BLUE(44, -1, 10079487),
        LAVENDER(46, -1, 13408767),
        WHITE(9, -1, 16777215),
        CORNFLOWER_BLUE(24, -1, 10066431),
        LEMON_CHIFFON(26, -1, 16777164),
        MAROON(25, -1, 8323072),
        ORCHID(28, -1, 6684774),
        CORAL(29, -1, 16744576),
        ROYAL_BLUE(30, -1, 26316),
        LIGHT_CORNFLOWER_BLUE(31, -1, 13421823),
        TAN(47, -1, 16764057),
        AUTOMATIC(64, -1, 0);

        private HSSFColor color;

        HSSFColorPredefined(int i, int i2, int i3) {
            this.color = new HSSFColor(i, i2, new java.awt.Color(i3));
        }

        public short getIndex() {
            return this.color.getIndex();
        }

        public short getIndex2() {
            return this.color.getIndex2();
        }

        public short[] getTriplet() {
            return this.color.getTriplet();
        }

        public String getHexString() {
            return this.color.getHexString();
        }

        public HSSFColor getColor() {
            return new HSSFColor(getIndex(), getIndex2(), this.color.color);
        }
    }

    public HSSFColor() {
        this(64, -1, java.awt.Color.BLACK);
    }

    public HSSFColor(int i, int i2, java.awt.Color color) {
        this.index = i;
        this.index2 = i2;
        this.color = color;
    }

    public static final synchronized Map<Integer, HSSFColor> getIndexHash() {
        if (indexHash == null) {
            indexHash = Collections.unmodifiableMap(createColorsByIndexMap());
        }
        return indexHash;
    }

    public static final Map<Integer, HSSFColor> getMutableIndexHash() {
        return createColorsByIndexMap();
    }

    private static Map<Integer, HSSFColor> createColorsByIndexMap() {
        Map<HSSFColorPredefined, HSSFColor> mapMapEnumToColorClass = mapEnumToColorClass();
        HashMap map = new HashMap((mapMapEnumToColorClass.size() * 3) / 2);
        for (Map.Entry<HSSFColorPredefined, HSSFColor> entry : mapMapEnumToColorClass.entrySet()) {
            Integer numValueOf = Integer.valueOf(entry.getKey().getIndex());
            if (!map.containsKey(numValueOf)) {
                map.put(numValueOf, entry.getValue());
            }
            Integer numValueOf2 = Integer.valueOf(entry.getKey().getIndex2());
            if (numValueOf2.intValue() != -1 && !map.containsKey(numValueOf2)) {
                map.put(numValueOf2, entry.getValue());
            }
        }
        return map;
    }

    public static Map<String, HSSFColor> getTripletHash() {
        return createColorsByHexStringMap();
    }

    private static Map<String, HSSFColor> createColorsByHexStringMap() {
        Map<HSSFColorPredefined, HSSFColor> mapMapEnumToColorClass = mapEnumToColorClass();
        HashMap map = new HashMap(mapMapEnumToColorClass.size());
        for (Map.Entry<HSSFColorPredefined, HSSFColor> entry : mapMapEnumToColorClass.entrySet()) {
            String hexString = entry.getKey().getHexString();
            if (!map.containsKey(hexString)) {
                map.put(hexString, entry.getValue());
            }
        }
        return map;
    }

    @Removal(version = "3.18")
    @Deprecated
    private static synchronized Map<HSSFColorPredefined, HSSFColor> mapEnumToColorClass() {
        if (enumList == null) {
            EnumMap enumMap = new EnumMap(HSSFColorPredefined.class);
            enumList = enumMap;
            enumMap.put(HSSFColorPredefined.BLACK, new BLACK());
            enumList.put(HSSFColorPredefined.BROWN, new BROWN());
            enumList.put(HSSFColorPredefined.OLIVE_GREEN, new OLIVE_GREEN());
            enumList.put(HSSFColorPredefined.DARK_GREEN, new DARK_GREEN());
            enumList.put(HSSFColorPredefined.DARK_TEAL, new DARK_TEAL());
            enumList.put(HSSFColorPredefined.DARK_BLUE, new DARK_BLUE());
            enumList.put(HSSFColorPredefined.INDIGO, new INDIGO());
            enumList.put(HSSFColorPredefined.GREY_80_PERCENT, new GREY_80_PERCENT());
            enumList.put(HSSFColorPredefined.ORANGE, new ORANGE());
            enumList.put(HSSFColorPredefined.DARK_YELLOW, new DARK_YELLOW());
            enumList.put(HSSFColorPredefined.GREEN, new GREEN());
            enumList.put(HSSFColorPredefined.TEAL, new TEAL());
            enumList.put(HSSFColorPredefined.BLUE, new BLUE());
            enumList.put(HSSFColorPredefined.BLUE_GREY, new BLUE_GREY());
            enumList.put(HSSFColorPredefined.GREY_50_PERCENT, new GREY_50_PERCENT());
            enumList.put(HSSFColorPredefined.RED, new RED());
            enumList.put(HSSFColorPredefined.LIGHT_ORANGE, new LIGHT_ORANGE());
            enumList.put(HSSFColorPredefined.LIME, new LIME());
            enumList.put(HSSFColorPredefined.SEA_GREEN, new SEA_GREEN());
            enumList.put(HSSFColorPredefined.AQUA, new AQUA());
            enumList.put(HSSFColorPredefined.LIGHT_BLUE, new LIGHT_BLUE());
            enumList.put(HSSFColorPredefined.VIOLET, new VIOLET());
            enumList.put(HSSFColorPredefined.GREY_40_PERCENT, new GREY_40_PERCENT());
            enumList.put(HSSFColorPredefined.PINK, new PINK());
            enumList.put(HSSFColorPredefined.GOLD, new GOLD());
            enumList.put(HSSFColorPredefined.YELLOW, new YELLOW());
            enumList.put(HSSFColorPredefined.BRIGHT_GREEN, new BRIGHT_GREEN());
            enumList.put(HSSFColorPredefined.TURQUOISE, new TURQUOISE());
            enumList.put(HSSFColorPredefined.DARK_RED, new DARK_RED());
            enumList.put(HSSFColorPredefined.SKY_BLUE, new SKY_BLUE());
            enumList.put(HSSFColorPredefined.PLUM, new PLUM());
            enumList.put(HSSFColorPredefined.GREY_25_PERCENT, new GREY_25_PERCENT());
            enumList.put(HSSFColorPredefined.ROSE, new ROSE());
            enumList.put(HSSFColorPredefined.LIGHT_YELLOW, new LIGHT_YELLOW());
            enumList.put(HSSFColorPredefined.LIGHT_GREEN, new LIGHT_GREEN());
            enumList.put(HSSFColorPredefined.LIGHT_TURQUOISE, new LIGHT_TURQUOISE());
            enumList.put(HSSFColorPredefined.PALE_BLUE, new PALE_BLUE());
            enumList.put(HSSFColorPredefined.LAVENDER, new LAVENDER());
            enumList.put(HSSFColorPredefined.WHITE, new WHITE());
            enumList.put(HSSFColorPredefined.CORNFLOWER_BLUE, new CORNFLOWER_BLUE());
            enumList.put(HSSFColorPredefined.LEMON_CHIFFON, new LEMON_CHIFFON());
            enumList.put(HSSFColorPredefined.MAROON, new MAROON());
            enumList.put(HSSFColorPredefined.ORCHID, new ORCHID());
            enumList.put(HSSFColorPredefined.CORAL, new CORAL());
            enumList.put(HSSFColorPredefined.ROYAL_BLUE, new ROYAL_BLUE());
            enumList.put(HSSFColorPredefined.LIGHT_CORNFLOWER_BLUE, new LIGHT_CORNFLOWER_BLUE());
            enumList.put(HSSFColorPredefined.TAN, new TAN());
        }
        return enumList;
    }

    public short getIndex() {
        return (short) this.index;
    }

    public short getIndex2() {
        return (short) this.index2;
    }

    public short[] getTriplet() {
        return new short[]{(short) this.color.getRed(), (short) this.color.getGreen(), (short) this.color.getBlue()};
    }

    public String getHexString() {
        return (Integer.toHexString(this.color.getRed() * FinalCanbus.CAR_DJ_ChuanQiGA6) + ":" + Integer.toHexString(this.color.getGreen() * FinalCanbus.CAR_DJ_ChuanQiGA6) + ":" + Integer.toHexString(this.color.getBlue() * FinalCanbus.CAR_DJ_ChuanQiGA6)).toUpperCase(Locale.ROOT);
    }

    public static HSSFColor toHSSFColor(Color color) {
        if (color != null && !(color instanceof HSSFColor)) {
            throw new IllegalArgumentException("Only HSSFColor objects are supported");
        }
        return (HSSFColor) color;
    }

    @Removal(version = "3.18")
    @Deprecated
    private static class HSSFColorRef extends HSSFColor {
        HSSFColorRef(HSSFColorPredefined hSSFColorPredefined) {
            super(hSSFColorPredefined.getIndex(), hSSFColorPredefined.getIndex2(), hSSFColorPredefined.color.color);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class BLACK extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.BLACK;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public BLACK() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class BROWN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.BROWN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public BROWN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class OLIVE_GREEN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.OLIVE_GREEN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public OLIVE_GREEN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class DARK_GREEN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.DARK_GREEN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public DARK_GREEN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class DARK_TEAL extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.DARK_TEAL;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public DARK_TEAL() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class DARK_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.DARK_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public DARK_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class INDIGO extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.INDIGO;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public INDIGO() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class GREY_80_PERCENT extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.GREY_80_PERCENT;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public GREY_80_PERCENT() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class DARK_RED extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.DARK_RED;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public DARK_RED() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class ORANGE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.ORANGE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public ORANGE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class DARK_YELLOW extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.DARK_YELLOW;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public DARK_YELLOW() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class GREEN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.GREEN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public GREEN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class TEAL extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.TEAL;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public TEAL() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class BLUE_GREY extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.BLUE_GREY;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public BLUE_GREY() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class GREY_50_PERCENT extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.GREY_50_PERCENT;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public GREY_50_PERCENT() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class RED extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.RED;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public RED() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIGHT_ORANGE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIGHT_ORANGE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIGHT_ORANGE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIME extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIME;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIME() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class SEA_GREEN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.SEA_GREEN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public SEA_GREEN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class AQUA extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.AQUA;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public AQUA() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIGHT_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIGHT_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIGHT_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class VIOLET extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.VIOLET;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public VIOLET() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class GREY_40_PERCENT extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.GREY_40_PERCENT;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public GREY_40_PERCENT() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class PINK extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.PINK;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public PINK() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class GOLD extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.GOLD;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public GOLD() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class YELLOW extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.YELLOW;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public YELLOW() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class BRIGHT_GREEN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.BRIGHT_GREEN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public BRIGHT_GREEN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class TURQUOISE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.TURQUOISE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public TURQUOISE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class SKY_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.SKY_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public SKY_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class PLUM extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.PLUM;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public PLUM() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class GREY_25_PERCENT extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.GREY_25_PERCENT;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public GREY_25_PERCENT() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class ROSE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.ROSE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public ROSE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class TAN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.TAN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public TAN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIGHT_YELLOW extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIGHT_YELLOW;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIGHT_YELLOW() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIGHT_GREEN extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIGHT_GREEN;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIGHT_GREEN() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIGHT_TURQUOISE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIGHT_TURQUOISE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIGHT_TURQUOISE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class PALE_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.PALE_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public PALE_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LAVENDER extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LAVENDER;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LAVENDER() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class WHITE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.WHITE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public WHITE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class CORNFLOWER_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.CORNFLOWER_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public CORNFLOWER_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LEMON_CHIFFON extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LEMON_CHIFFON;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LEMON_CHIFFON() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class MAROON extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.MAROON;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public MAROON() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class ORCHID extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.ORCHID;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public ORCHID() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class CORAL extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.CORAL;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public CORAL() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class ROYAL_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.ROYAL_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public ROYAL_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class LIGHT_CORNFLOWER_BLUE extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.LIGHT_CORNFLOWER_BLUE;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public LIGHT_CORNFLOWER_BLUE() {
            super(ref);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static class AUTOMATIC extends HSSFColorRef {
        public static final String hexString;
        public static final short index;
        public static final int index2;
        private static final HSSFColorPredefined ref;
        public static final short[] triplet;

        static {
            HSSFColorPredefined hSSFColorPredefined = HSSFColorPredefined.AUTOMATIC;
            ref = hSSFColorPredefined;
            index = hSSFColorPredefined.getIndex();
            index2 = hSSFColorPredefined.getIndex2();
            triplet = hSSFColorPredefined.getTriplet();
            hexString = hSSFColorPredefined.getHexString();
        }

        public AUTOMATIC() {
            super(ref);
        }

        public static HSSFColor getInstance() {
            return ref.color;
        }
    }
}
