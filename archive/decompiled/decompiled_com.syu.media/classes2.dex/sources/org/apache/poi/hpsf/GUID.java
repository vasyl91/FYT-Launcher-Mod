package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class GUID {
    private int _data1;
    private short _data2;
    private short _data3;
    private long _data4;

    GUID() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._data1 = littleEndianByteArrayInputStream.readInt();
        this._data2 = littleEndianByteArrayInputStream.readShort();
        this._data3 = littleEndianByteArrayInputStream.readShort();
        this._data4 = littleEndianByteArrayInputStream.readLong();
    }
}
