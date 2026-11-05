package org.apache.poi.hpsf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Variant {
    private static final Object[][] NUMBER_TO_NAME_LIST;
    public static final int VT_ARRAY = 8192;
    public static final int VT_BLOB = 65;
    public static final int VT_BLOB_OBJECT = 70;
    public static final int VT_BOOL = 11;
    public static final int VT_BSTR = 8;
    public static final int VT_BYREF = 16384;
    public static final int VT_CARRAY = 28;
    public static final int VT_CF = 71;
    public static final int VT_CLSID = 72;
    public static final int VT_CY = 6;
    public static final int VT_DATE = 7;
    public static final int VT_DECIMAL = 14;
    public static final int VT_DISPATCH = 9;
    public static final int VT_EMPTY = 0;
    public static final int VT_ERROR = 10;
    public static final int VT_FILETIME = 64;
    public static final int VT_HRESULT = 25;
    public static final int VT_I1 = 16;
    public static final int VT_I2 = 2;
    public static final int VT_I4 = 3;
    public static final int VT_I8 = 20;
    public static final int VT_ILLEGAL = 65535;
    public static final int VT_ILLEGALMASKED = 4095;
    public static final int VT_INT = 22;
    public static final int VT_LPSTR = 30;
    public static final int VT_LPWSTR = 31;
    public static final int VT_NULL = 1;
    public static final int VT_PTR = 26;
    public static final int VT_R4 = 4;
    public static final int VT_R8 = 5;
    public static final int VT_RESERVED = 32768;
    public static final int VT_SAFEARRAY = 27;
    public static final int VT_STORAGE = 67;
    public static final int VT_STORED_OBJECT = 69;
    public static final int VT_STREAM = 66;
    public static final int VT_STREAMED_OBJECT = 68;
    public static final int VT_TYPEMASK = 4095;
    public static final int VT_UI1 = 17;
    public static final int VT_UI2 = 18;
    public static final int VT_UI4 = 19;
    public static final int VT_UI8 = 21;
    public static final int VT_UINT = 23;
    public static final int VT_UNKNOWN = 13;
    public static final int VT_USERDEFINED = 29;
    public static final int VT_VARIANT = 12;
    public static final int VT_VECTOR = 4096;
    public static final int VT_VERSIONED_STREAM = 73;
    public static final int VT_VOID = 24;
    private static final Map<Long, Integer> numberToLength;
    private static final Map<Long, String> numberToName;
    public static final Integer LENGTH_UNKNOWN = -2;
    public static final Integer LENGTH_VARIABLE = -1;
    public static final Integer LENGTH_0 = 0;
    public static final Integer LENGTH_2 = 2;
    public static final Integer LENGTH_4 = 4;
    public static final Integer LENGTH_8 = 8;

    static {
        Object[][] objArr = {new Object[]{0L, "VT_EMPTY", 0}, new Object[]{1L, "VT_NULL", -2}, new Object[]{2L, "VT_I2", 2}, new Object[]{3L, "VT_I4", 4}, new Object[]{4L, "VT_R4", 4}, new Object[]{5L, "VT_R8", 8}, new Object[]{6L, "VT_CY", -2}, new Object[]{7L, "VT_DATE", -2}, new Object[]{8L, "VT_BSTR", -2}, new Object[]{9L, "VT_DISPATCH", -2}, new Object[]{10L, "VT_ERROR", -2}, new Object[]{11L, "VT_BOOL", -2}, new Object[]{12L, "VT_VARIANT", -2}, new Object[]{13L, "VT_UNKNOWN", -2}, new Object[]{14L, "VT_DECIMAL", -2}, new Object[]{16L, "VT_I1", -2}, new Object[]{17L, "VT_UI1", -2}, new Object[]{18L, "VT_UI2", -2}, new Object[]{19L, "VT_UI4", -2}, new Object[]{20L, "VT_I8", -2}, new Object[]{21L, "VT_UI8", -2}, new Object[]{22L, "VT_INT", -2}, new Object[]{23L, "VT_UINT", -2}, new Object[]{24L, "VT_VOID", -2}, new Object[]{25L, "VT_HRESULT", -2}, new Object[]{26L, "VT_PTR", -2}, new Object[]{27L, "VT_SAFEARRAY", -2}, new Object[]{28L, "VT_CARRAY", -2}, new Object[]{29L, "VT_USERDEFINED", -2}, new Object[]{30L, "VT_LPSTR", -1}, new Object[]{31L, "VT_LPWSTR", -2}, new Object[]{64L, "VT_FILETIME", 8}, new Object[]{65L, "VT_BLOB", -2}, new Object[]{66L, "VT_STREAM", -2}, new Object[]{67L, "VT_STORAGE", -2}, new Object[]{68L, "VT_STREAMED_OBJECT", -2}, new Object[]{69L, "VT_STORED_OBJECT", -2}, new Object[]{70L, "VT_BLOB_OBJECT", -2}, new Object[]{71L, "VT_CF", -2}, new Object[]{72L, "VT_CLSID", -2}};
        NUMBER_TO_NAME_LIST = objArr;
        HashMap map = new HashMap(objArr.length, 1.0f);
        HashMap map2 = new HashMap(objArr.length, 1.0f);
        for (Object[] objArr2 : objArr) {
            map.put((Long) objArr2[0], (String) objArr2[1]);
            map2.put((Long) objArr2[0], (Integer) objArr2[2]);
        }
        numberToName = Collections.unmodifiableMap(map);
        numberToLength = Collections.unmodifiableMap(map2);
    }

    public static String getVariantName(long j) {
        String str;
        if ((j & 4096) != 0) {
            j -= 4096;
            str = "Vector of ";
        } else if ((j & 8192) != 0) {
            j -= 8192;
            str = "Array of ";
        } else if ((j & 16384) != 0) {
            j -= 16384;
            str = "ByRef of ";
        } else {
            str = "";
        }
        String str2 = str + numberToName.get(Long.valueOf(j));
        return (str2 == null || "".equals(str2)) ? "unknown variant type" : str2;
    }

    public static int getVariantLength(long j) {
        Integer num = numberToLength.get(Long.valueOf(j));
        if (num == null) {
            num = LENGTH_UNKNOWN;
        }
        return num.intValue();
    }
}
