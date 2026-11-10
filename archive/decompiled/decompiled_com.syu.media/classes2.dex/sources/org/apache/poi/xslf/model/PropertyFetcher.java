package org.apache.poi.xslf.model;

import org.apache.poi.util.Internal;
import org.apache.poi.xslf.usermodel.XSLFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public abstract class PropertyFetcher<T> {
    private T _value;

    public abstract boolean fetch(XSLFShape xSLFShape);

    public T getValue() {
        return this._value;
    }

    public void setValue(T t) {
        this._value = t;
    }
}
