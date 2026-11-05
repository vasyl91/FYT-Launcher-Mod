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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class CodePageString {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) CodePageString.class);
    private byte[] _value;

    CodePageString() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        int i = littleEndianByteArrayInputStream.readInt();
        byte[] bArr = new byte[i];
        this._value = bArr;
        if (i == 0) {
            return;
        }
        littleEndianByteArrayInputStream.readFully(bArr);
        if (this._value[i - 1] != 0) {
            LOG.log(5, "CodePageString started at offset #" + readIndex + " is not NULL-terminated");
        }
        TypedPropertyValue.skipPadding(littleEndianByteArrayInputStream);
    }

    String getJavaValue(int i) throws UnsupportedEncodingException {
        if (i == -1) {
            i = 1252;
        }
        String stringFromCodePage = CodePageUtil.getStringFromCodePage(this._value, i);
        int iIndexOf = stringFromCodePage.indexOf(0);
        if (iIndexOf == -1) {
            LOG.log(5, "String terminator (\\0) for CodePageString property value not found.Continue without trimming and hope for the best.");
            return stringFromCodePage;
        }
        if (iIndexOf != stringFromCodePage.length() - 1) {
            LOG.log(5, "String terminator (\\0) for CodePageString property value occured before the end of string. Trimming and hope for the best.");
        }
        return stringFromCodePage.substring(0, iIndexOf);
    }

    int getSize() {
        return this._value.length + 4;
    }

    void setJavaValue(String str, int i) throws UnsupportedEncodingException {
        if (i == -1) {
            i = 1252;
        }
        this._value = CodePageUtil.getBytesInCodePage(str + "\u0000", i);
    }

    int write(OutputStream outputStream) throws IOException {
        LittleEndian.putUInt(this._value.length, outputStream);
        outputStream.write(this._value);
        return this._value.length + 4;
    }
}
