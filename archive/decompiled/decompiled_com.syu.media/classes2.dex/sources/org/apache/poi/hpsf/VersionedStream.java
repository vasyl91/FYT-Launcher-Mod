package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class VersionedStream {
    private final GUID _versionGuid = new GUID();
    private final IndirectPropertyName _streamName = new IndirectPropertyName();

    VersionedStream() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._versionGuid.read(littleEndianByteArrayInputStream);
        this._streamName.read(littleEndianByteArrayInputStream);
    }
}
