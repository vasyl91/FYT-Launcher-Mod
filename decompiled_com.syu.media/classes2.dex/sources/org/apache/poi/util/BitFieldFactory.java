package org.apache.poi.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BitFieldFactory {
    private static Map<Integer, BitField> instances = new HashMap();

    public static BitField getInstance(int i) {
        BitField bitField = instances.get(Integer.valueOf(i));
        if (bitField != null) {
            return bitField;
        }
        BitField bitField2 = new BitField(i);
        instances.put(Integer.valueOf(i), bitField2);
        return bitField2;
    }
}
