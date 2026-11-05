package org.apache.poi.hpsf;

import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class ClipboardData {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ClipboardData.class);
    private int _format = 0;
    private byte[] _value;

    ClipboardData() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        int i = littleEndianByteArrayInputStream.readInt();
        if (i < 4) {
            LOG.log(5, "ClipboardData at offset " + readIndex + " size less than 4 bytes (doesn't even have format field!). Setting to format == 0 and hope for the best");
            this._format = 0;
            this._value = new byte[0];
            return;
        }
        this._format = littleEndianByteArrayInputStream.readInt();
        byte[] bArr = new byte[i - 4];
        this._value = bArr;
        littleEndianByteArrayInputStream.readFully(bArr);
    }

    byte[] getValue() {
        return this._value;
    }

    byte[] toByteArray() {
        byte[] bArr = new byte[this._value.length + 8];
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
        try {
            littleEndianByteArrayOutputStream.writeInt(this._value.length + 4);
            littleEndianByteArrayOutputStream.writeInt(this._format);
            littleEndianByteArrayOutputStream.write(this._value);
            return bArr;
        } finally {
            IOUtils.closeQuietly(littleEndianByteArrayOutputStream);
        }
    }

    void setValue(byte[] bArr) {
        this._value = (byte[]) bArr.clone();
    }
}
