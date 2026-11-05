package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect;

    private final int mask = 1 << ordinal();

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static Feature[] valuesCustom() {
        Feature[] featureArrValuesCustom = values();
        int length = featureArrValuesCustom.length;
        Feature[] featureArr = new Feature[length];
        System.arraycopy(featureArrValuesCustom, 0, featureArr, 0, length);
        return featureArr;
    }

    Feature() {
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int features, Feature feature) {
        return (feature.getMask() & features) != 0;
    }

    public static int config(int features, Feature feature, boolean state) {
        if (state) {
            return features | feature.getMask();
        }
        return features & (feature.getMask() ^ (-1));
    }

    public static int of(Feature[] features) {
        if (features == null) {
            return 0;
        }
        int value = 0;
        for (Feature feature : features) {
            value |= feature.getMask();
        }
        return value;
    }
}
