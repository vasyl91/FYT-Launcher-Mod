package com.fasterxml.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class WName {
    protected final String _localName;
    protected final String _prefix;

    public abstract int appendBytes(byte[] bArr, int i);

    public abstract int appendChars(char[] cArr, int i);

    public abstract int serializedLength();

    public abstract void writeBytes(OutputStream outputStream) throws IOException;

    public abstract void writeChars(Writer writer) throws IOException;

    protected WName(String str) {
        this._prefix = null;
        this._localName = str;
    }

    protected WName(String str, String str2) {
        this._prefix = str;
        this._localName = str2;
    }

    public final String getPrefix() {
        return this._prefix;
    }

    public final String getPrefixedName() {
        if (this._prefix == null) {
            return this._localName;
        }
        return this._prefix + ":" + this._localName;
    }

    public final String getLocalName() {
        return this._localName;
    }

    public final boolean hasPrefix() {
        return this._prefix != null;
    }

    public String toString() {
        if (this._prefix == null) {
            return this._localName;
        }
        return this._prefix + ":" + this._localName;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass() && !(obj instanceof WName)) {
            return false;
        }
        WName wName = (WName) obj;
        if (!wName._localName.equals(this._localName)) {
            return false;
        }
        String str = this._prefix;
        if (str == null) {
            return wName._prefix == null;
        }
        return str.equals(wName._prefix);
    }

    public int hashCode() {
        int iHashCode = this._localName.hashCode();
        String str = this._prefix;
        return str != null ? iHashCode ^ str.hashCode() : iHashCode;
    }

    public final boolean hasName(String str) {
        if (this._prefix != null) {
            return false;
        }
        return this._localName.equals(str);
    }

    public final boolean hasName(String str, String str2) {
        String str3 = this._localName;
        if (str3 == str2) {
            if (str == null) {
                return this._prefix == null;
            }
            return str.equals(this._prefix);
        }
        if (str3.hashCode() != str2.hashCode()) {
            return false;
        }
        if (str == null) {
            if (this._prefix != null) {
                return false;
            }
        } else if (!str.equals(this._prefix)) {
            return false;
        }
        return this._localName.equals(str2);
    }
}
