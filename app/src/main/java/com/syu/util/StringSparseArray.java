package com.syu.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StringSparseArray<E> implements Cloneable {
    private boolean mGarbage;
    private String[] mKeys;
    private int mSize;
    private Object[] mValues;
    private static final String[] EMPTY_STRINGS = new String[0];
    private static final Object[] EMPTY_OBJECTS = new Object[0];
    private static final Object DELETED = new Object();

    public StringSparseArray() {
        this(10);
    }

    public StringSparseArray(int initialCapacity) {
        this.mGarbage = false;
        if (initialCapacity == 0) {
            this.mKeys = EMPTY_STRINGS;
            this.mValues = EMPTY_OBJECTS;
        } else {
            int initialCapacity2 = idealIntArraySize(initialCapacity);
            this.mKeys = new String[initialCapacity2];
            this.mValues = new Object[initialCapacity2];
        }
        this.mSize = 0;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need << 2) >> 2;
    }

    @NonNull
    @Override
    public StringSparseArray<E> clone() {
        try {
            @SuppressWarnings("unchecked")
            StringSparseArray<E> cloned = (StringSparseArray<E>) super.clone();
            cloned.mKeys = this.mKeys.clone();
            cloned.mValues = this.mValues.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            // This should not happen as StringSparseArray implements Cloneable
            throw new AssertionError(e);
        }
    }

    @Nullable
    public E get(String key) {
        return get(key, null);
    }

    @Nullable
    public E get(String str, @Nullable E e) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, str);
        if (binarySearch < 0 || this.mValues[binarySearch] == DELETED) {
            return e;
        }
        @SuppressWarnings("unchecked")
        E value = (E) this.mValues[binarySearch];
        return value;
    }

    private int binarySearch(String[] array, int size, String value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            String midVal = array[mid];
            if (midVal == null) {
                return mid;
            }
            int result = midVal.compareTo(value);
            if (result < 0) {
                lo = mid + 1;
            } else {
                if (result <= 0) {
                    return mid;
                }
                hi = mid - 1;
            }
        }
        return lo ^ (-1);
    }

    public void delete(String key) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0 && this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(String key) {
        delete(key);
    }

    public void removeAt(int index) {
        if (index >= 0 && index < this.mSize && this.mValues[index] != DELETED) {
            this.mValues[index] = DELETED;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int index, int size) {
        int end = Math.min(this.mSize, index + size);
        for (int i = index; i < end; i++) {
            removeAt(i);
        }
    }

    private void gc() {
        int n = this.mSize;
        int o = 0;
        String[] keys = this.mKeys;
        Object[] values = this.mValues;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != DELETED) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.mGarbage = false;
        this.mSize = o;
    }

    public void put(String key, E value) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0) {
            this.mValues[i] = value;
            return;
        }
        int i2 = i ^ (-1);
        if (i2 < this.mSize && this.mValues[i2] == DELETED) {
            this.mKeys[i2] = key;
            this.mValues[i2] = value;
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
            i2 = binarySearch(this.mKeys, this.mSize, key) ^ (-1);
        }
        if (this.mSize >= this.mKeys.length) {
            int n = idealIntArraySize(this.mSize + 1);
            String[] nkeys = new String[n];
            Object[] nvalues = new Object[n];
            System.arraycopy(this.mKeys, 0, nkeys, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, nvalues, 0, this.mValues.length);
            this.mKeys = nkeys;
            this.mValues = nvalues;
        }
        if (this.mSize - i2 != 0) {
            System.arraycopy(this.mKeys, i2, this.mKeys, i2 + 1, this.mSize - i2);
            System.arraycopy(this.mValues, i2, this.mValues, i2 + 1, this.mSize - i2);
        }
        this.mKeys[i2] = key;
        this.mValues[i2] = value;
        this.mSize++;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String keyAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        if (index < 0 || index >= this.mSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.mKeys[index];
    }

    public E valueAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        if (index < 0 || index >= this.mSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        @SuppressWarnings("unchecked")
        E value = (E) this.mValues[index];
        return value;
    }

    public void setValueAt(int index, E value) {
        if (this.mGarbage) {
            gc();
        }
        if (index < 0 || index >= this.mSize) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        this.mValues[index] = value;
    }

    public int indexOfKey(String key) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, this.mSize, key);
    }

    public int indexOfValue(E value) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == value) { // Intentional identity comparison as in original
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int n = this.mSize;
        Object[] values = this.mValues;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    private boolean StringGreater(String left, String right) {
        return left != null && left.compareTo(right) > 0;
    }

    public void append(String key, E value) {
        if (this.mSize != 0 && !StringGreater(key, this.mKeys[this.mSize - 1])) {
            put(key, value);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
        }
        int pos = this.mSize;
        if (pos >= this.mKeys.length) {
            int n = idealIntArraySize(pos + 1);
            String[] nkeys = new String[n];
            Object[] nvalues = new Object[n];
            System.arraycopy(this.mKeys, 0, nkeys, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, nvalues, 0, this.mValues.length);
            this.mKeys = nkeys;
            this.mValues = nvalues;
        }
        this.mKeys[pos] = key;
        this.mValues[pos] = value;
        this.mSize = pos + 1;
    }

    @NonNull
    @Override
    public String toString() {
        int size = size(); // Call size() to ensure garbage collection if needed
        if (size <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(size * 28);
        buffer.append('{');
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            String key = keyAt(i);
            buffer.append(key);
            buffer.append('=');
            Object value = valueAt(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
