package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class Array {
    private final ArrayHeader _header = new ArrayHeader();
    private TypedPropertyValue[] _values;

    static class ArrayDimension {
        private int _indexOffset;
        private long _size;

        ArrayDimension() {
        }

        void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
            this._size = littleEndianByteArrayInputStream.readUInt();
            this._indexOffset = littleEndianByteArrayInputStream.readInt();
        }
    }

    static class ArrayHeader {
        private ArrayDimension[] _dimensions;
        private int _type;

        ArrayHeader() {
        }

        void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
            this._type = littleEndianByteArrayInputStream.readInt();
            long uInt = littleEndianByteArrayInputStream.readUInt();
            if (1 > uInt || uInt > 31) {
                throw new IllegalPropertySetDataException("Array dimension number " + uInt + " is not in [1; 31] range");
            }
            int i = (int) uInt;
            this._dimensions = new ArrayDimension[i];
            for (int i2 = 0; i2 < i; i2++) {
                ArrayDimension arrayDimension = new ArrayDimension();
                arrayDimension.read(littleEndianByteArrayInputStream);
                this._dimensions[i2] = arrayDimension;
            }
        }

        long getNumberOfScalarValues() {
            long j = 1;
            for (ArrayDimension arrayDimension : this._dimensions) {
                j *= arrayDimension._size;
            }
            return j;
        }

        int getType() {
            return this._type;
        }
    }

    Array() {
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._header.read(littleEndianByteArrayInputStream);
        long numberOfScalarValues = this._header.getNumberOfScalarValues();
        if (numberOfScalarValues > 2147483647L) {
            throw new UnsupportedOperationException("Sorry, but POI can't store array of properties with size of " + numberOfScalarValues + " in memory");
        }
        int i = (int) numberOfScalarValues;
        this._values = new TypedPropertyValue[i];
        int i2 = this._header._type == 12 ? 0 : this._header._type;
        for (int i3 = 0; i3 < i; i3++) {
            TypedPropertyValue typedPropertyValue = new TypedPropertyValue(i2, null);
            typedPropertyValue.read(littleEndianByteArrayInputStream);
            this._values[i3] = typedPropertyValue;
            if (i2 != 0) {
                TypedPropertyValue.skipPadding(littleEndianByteArrayInputStream);
            }
        }
    }

    TypedPropertyValue[] getValues() {
        return this._values;
    }
}
