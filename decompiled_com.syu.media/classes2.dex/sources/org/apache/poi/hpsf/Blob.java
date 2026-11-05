package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class Blob {
    private byte[] _value;

    Blob() {
    }

    void read(LittleEndianInput littleEndianInput) {
        int i = littleEndianInput.readInt();
        byte[] bArr = new byte[i];
        this._value = bArr;
        if (i > 0) {
            littleEndianInput.readFully(bArr);
        }
    }
}
