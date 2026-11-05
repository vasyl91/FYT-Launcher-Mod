package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class UnicodeString {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) UnicodeString.class);
    private byte[] _value;

    UnicodeString() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int i = littleEndianByteArrayInputStream.readInt();
        int i2 = i * 2;
        this._value = new byte[i2];
        if (i == 0) {
            return;
        }
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        littleEndianByteArrayInputStream.readFully(this._value);
        byte[] bArr = this._value;
        if (bArr[i2 - 2] != 0 || bArr[i2 - 1] != 0) {
            throw new IllegalPropertySetDataException("UnicodeString started at offset #" + readIndex + " is not NULL-terminated");
        }
        TypedPropertyValue.skipPadding(littleEndianByteArrayInputStream);
    }

    byte[] getValue() {
        return this._value;
    }

    String toJavaString() {
        byte[] bArr = this._value;
        if (bArr.length == 0) {
            return null;
        }
        String fromUnicodeLE = StringUtil.getFromUnicodeLE(bArr, 0, bArr.length >> 1);
        int iIndexOf = fromUnicodeLE.indexOf(0);
        if (iIndexOf == -1) {
            LOG.log(5, "String terminator (\\0) for UnicodeString property value not found.Continue without trimming and hope for the best.");
            return fromUnicodeLE;
        }
        if (iIndexOf != fromUnicodeLE.length() - 1) {
            LOG.log(5, "String terminator (\\0) for UnicodeString property value occured before the end of string. Trimming and hope for the best.");
        }
        return fromUnicodeLE.substring(0, iIndexOf);
    }

    void setJavaValue(String str) throws UnsupportedEncodingException {
        this._value = CodePageUtil.getBytesInCodePage(str + "\u0000", 1200);
    }

    int write(OutputStream outputStream) throws IOException {
        LittleEndian.putUInt(this._value.length / 2, outputStream);
        outputStream.write(this._value);
        return this._value.length + 4;
    }
}
