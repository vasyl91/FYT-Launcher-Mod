package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter;

    private final int mask = 1 << ordinal();

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static SerializerFeature[] valuesCustom() {
        SerializerFeature[] serializerFeatureArrValuesCustom = values();
        int length = serializerFeatureArrValuesCustom.length;
        SerializerFeature[] serializerFeatureArr = new SerializerFeature[length];
        System.arraycopy(serializerFeatureArrValuesCustom, 0, serializerFeatureArr, 0, length);
        return serializerFeatureArr;
    }

    SerializerFeature() {
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int features, SerializerFeature feature) {
        return (feature.getMask() & features) != 0;
    }

    public static boolean isEnabled(int features, int fieaturesB, SerializerFeature feature) {
        int mask = feature.getMask();
        return ((features & mask) == 0 && (fieaturesB & mask) == 0) ? false : true;
    }

    public static int config(int features, SerializerFeature feature, boolean state) {
        if (state) {
            return features | feature.getMask();
        }
        return features & (feature.getMask() ^ (-1));
    }

    public static int of(SerializerFeature[] features) {
        if (features == null) {
            return 0;
        }
        int value = 0;
        for (SerializerFeature feature : features) {
            value |= feature.getMask();
        }
        return value;
    }
}
