package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NameIdentifier {
    private final boolean _isQuoted;
    private final String _name;

    public NameIdentifier(String str, boolean z) {
        this._name = str;
        this._isQuoted = z;
    }

    public String getName() {
        return this._name;
    }

    public boolean isQuoted() {
        return this._isQuoted;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        if (this._isQuoted) {
            stringBuffer.append("'").append(this._name).append("'");
        } else {
            stringBuffer.append(this._name);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
