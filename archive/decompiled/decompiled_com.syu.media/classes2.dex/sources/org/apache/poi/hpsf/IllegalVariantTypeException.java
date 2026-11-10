package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IllegalVariantTypeException extends VariantTypeException {
    public IllegalVariantTypeException(long j, Object obj, String str) {
        super(j, obj, str);
    }

    public IllegalVariantTypeException(long j, Object obj) {
        this(j, obj, "The variant type " + j + " (" + Variant.getVariantName(j) + ", " + HexDump.toHex(j) + ") is illegal in this context.");
    }
}
