package com.fasterxml.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class CharWName extends WName {
    final char[] _chars;

    public CharWName(String str) {
        super(str);
        this._chars = str.toCharArray();
    }

    public CharWName(String str, String str2) {
        super(str, str2);
        int length = str.length();
        int length2 = str2.length();
        int i = length + 1;
        char[] cArr = new char[i + length2];
        this._chars = cArr;
        str.getChars(0, length, cArr, 0);
        cArr[length] = ':';
        str2.getChars(0, length2, cArr, i);
    }

    @Override // com.fasterxml.aalto.out.WName
    public final int serializedLength() {
        return this._chars.length;
    }

    @Override // com.fasterxml.aalto.out.WName
    public int appendBytes(byte[] bArr, int i) {
        throw new RuntimeException("Internal error: appendBytes() should never be called");
    }

    @Override // com.fasterxml.aalto.out.WName
    public void writeBytes(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Internal error: writeBytes() should never be called");
    }

    @Override // com.fasterxml.aalto.out.WName
    public int appendChars(char[] cArr, int i) {
        char[] cArr2 = this._chars;
        int length = cArr2.length;
        System.arraycopy(cArr2, 0, cArr, i, length);
        return length;
    }

    @Override // com.fasterxml.aalto.out.WName
    public void writeChars(Writer writer) throws IOException {
        writer.write(this._chars);
    }

    @Override // com.fasterxml.aalto.out.WName
    public String toString() {
        if (this._prefix != null) {
            return new String(this._chars);
        }
        return this._localName;
    }
}
