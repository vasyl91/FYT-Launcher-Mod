package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class UnsupportedVariantTypeException extends VariantTypeException {
    public UnsupportedVariantTypeException(long j, Object obj) {
        super(j, obj, "HPSF does not yet support the variant type " + j + " (" + Variant.getVariantName(j) + ", " + HexDump.toHex(j) + "). If you want support for this variant type in one of the next POI releases please submit a request for enhancement (RFE) to <http://issues.apache.org/bugzilla/>! Thank you!");
    }
}
