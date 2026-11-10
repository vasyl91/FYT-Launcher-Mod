package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class Date {
    private static final int SIZE = 8;
    private final byte[] _value = new byte[8];

    Date() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        littleEndianByteArrayInputStream.readFully(this._value);
    }
}
