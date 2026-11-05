package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class VariantBool {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) VariantBool.class);
    static final int SIZE = 2;
    private boolean _value;

    VariantBool() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        short s = littleEndianByteArrayInputStream.readShort();
        if (s == -1) {
            this._value = true;
        } else if (s == 0) {
            this._value = false;
        } else {
            LOG.log(5, "VARIANT_BOOL value '" + ((int) s) + "' is incorrect");
            this._value = true;
        }
    }

    boolean getValue() {
        return this._value;
    }

    void setValue(boolean z) {
        this._value = z;
    }
}
