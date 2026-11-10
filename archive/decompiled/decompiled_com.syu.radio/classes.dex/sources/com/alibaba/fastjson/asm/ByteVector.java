package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    public ByteVector(int initialSize) {
        this.data = new byte[initialSize];
    }

    public ByteVector putByte(int b) {
        int length = this.length;
        if (length + 1 > this.data.length) {
            enlarge(1);
        }
        this.data[length] = (byte) b;
        this.length = length + 1;
        return this;
    }

    ByteVector put11(int b1, int b2) {
        int length = this.length;
        if (length + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) b1;
        data[length2] = (byte) b2;
        this.length = length2 + 1;
        return this;
    }

    public ByteVector putShort(int s) {
        int length = this.length;
        if (length + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) (s >>> 8);
        data[length2] = (byte) s;
        this.length = length2 + 1;
        return this;
    }

    ByteVector put12(int b, int s) {
        int length = this.length;
        if (length + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) b;
        int length3 = length2 + 1;
        data[length2] = (byte) (s >>> 8);
        data[length3] = (byte) s;
        this.length = length3 + 1;
        return this;
    }

    public ByteVector putInt(int i) {
        int length = this.length;
        if (length + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] data = this.data;
        int length2 = length + 1;
        data[length] = (byte) (i >>> 24);
        int length3 = length2 + 1;
        data[length2] = (byte) (i >>> 16);
        int length4 = length3 + 1;
        data[length3] = (byte) (i >>> 8);
        data[length4] = (byte) i;
        this.length = length4 + 1;
        return this;
    }

    public ByteVector putUTF8(String s) {
        int charLength = s.length();
        int len = this.length;
        if (len + 2 + charLength > this.data.length) {
            enlarge(charLength + 2);
        }
        byte[] data = this.data;
        int len2 = len + 1;
        data[len] = (byte) (charLength >>> 8);
        data[len2] = (byte) charLength;
        int i = 0;
        int len3 = len2 + 1;
        while (i < charLength) {
            char c = s.charAt(i);
            if (c >= 1 && c <= 127) {
                data[len3] = (byte) c;
                i++;
                len3++;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        this.length = len3;
        return this;
    }

    public ByteVector putByteArray(byte[] b, int off, int len) {
        if (this.length + len > this.data.length) {
            enlarge(len);
        }
        if (b != null) {
            System.arraycopy(b, off, this.data, this.length, len);
        }
        this.length += len;
        return this;
    }

    private void enlarge(int size) {
        int length1 = this.data.length * 2;
        int length2 = this.length + size;
        if (length1 <= length2) {
            length1 = length2;
        }
        byte[] newData = new byte[length1];
        System.arraycopy(this.data, 0, newData, 0, this.length);
        this.data = newData;
    }
}
