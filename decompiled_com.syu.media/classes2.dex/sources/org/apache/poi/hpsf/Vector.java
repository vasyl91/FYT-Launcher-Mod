package org.apache.poi.hpsf;

import java.util.ArrayList;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class Vector {
    private final short _type;
    private TypedPropertyValue[] _values;

    Vector(short s) {
        this._type = s;
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        long uInt = littleEndianByteArrayInputStream.readUInt();
        if (uInt > 2147483647L) {
            throw new UnsupportedOperationException("Vector is too long -- " + uInt);
        }
        int i = (int) uInt;
        ArrayList arrayList = new ArrayList();
        short s = this._type;
        if (s == 12) {
            s = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            TypedPropertyValue typedPropertyValue = new TypedPropertyValue(s, null);
            if (s == 0) {
                typedPropertyValue.read(littleEndianByteArrayInputStream);
            } else {
                typedPropertyValue.readValue(littleEndianByteArrayInputStream);
            }
            arrayList.add(typedPropertyValue);
        }
        this._values = (TypedPropertyValue[]) arrayList.toArray(new TypedPropertyValue[arrayList.size()]);
    }

    TypedPropertyValue[] getValues() {
        return this._values;
    }
}
