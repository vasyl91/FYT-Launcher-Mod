package com.syu.util;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ConcurrentSparseArray<E> implements Cloneable {
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;
    private static final int[] EMPTY_INTS = new int[0];
    private static final Object[] EMPTY_OBJECTS = new Object[0];
    private static final Object DELETED = new Object();

    public ConcurrentSparseArray() {
        this(10);
    }

    public ConcurrentSparseArray(int initialCapacity) {
        this.mGarbage = false;
        if (initialCapacity == 0) {
            this.mKeys = EMPTY_INTS;
            this.mValues = EMPTY_OBJECTS;
        } else {
            int initialCapacity2 = idealIntArraySize(initialCapacity);
            this.mKeys = new int[initialCapacity2];
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

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized ConcurrentSparseArray<E> m0clone() {
        ConcurrentSparseArray<E> clone;
        clone = null;
        try {
            clone = (ConcurrentSparseArray) super.clone();
            clone.mKeys = (int[]) this.mKeys.clone();
            clone.mValues = (Object[]) this.mValues.clone();
        } catch (CloneNotSupportedException e) {
        }
        return clone;
    }

    public E get(int key) {
        return get(key, null);
    }

    public synchronized E get(int i, E e) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0 && this.mValues[binarySearch] != DELETED) {
            e = (E) this.mValues[binarySearch];
        }
        return e;
    }

    private int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else {
                if (midVal <= value) {
                    return mid;
                }
                hi = mid - 1;
            }
        }
        return lo ^ (-1);
    }

    public synchronized void delete(int key) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0 && this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(int key) {
        delete(key);
    }

    public synchronized void removeAt(int index) {
        if (this.mValues[index] != DELETED) {
            this.mValues[index] = DELETED;
            this.mGarbage = true;
        }
    }

    public synchronized void removeAtRange(int index, int size) {
        int end = Math.min(this.mSize, index + size);
        for (int i = index; i < end; i++) {
            removeAt(i);
        }
    }

    private void gc() {
        int n = this.mSize;
        int o = 0;
        int[] keys = this.mKeys;
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

    public synchronized void put(int key, E value) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0) {
            this.mValues[i] = value;
        } else {
            int i2 = i ^ (-1);
            if (i2 < this.mSize && this.mValues[i2] == DELETED) {
                this.mKeys[i2] = key;
                this.mValues[i2] = value;
            } else {
                if (this.mGarbage && this.mSize >= this.mKeys.length) {
                    gc();
                    i2 = binarySearch(this.mKeys, this.mSize, key) ^ (-1);
                }
                if (this.mSize >= this.mKeys.length) {
                    int n = idealIntArraySize(this.mSize + 1);
                    int[] nkeys = new int[n];
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
        }
    }

    public synchronized int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public synchronized int keyAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[index];
    }

    public synchronized E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i];
    }

    public synchronized void setValueAt(int index, E value) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[index] = value;
    }

    public synchronized int indexOfKey(int key) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, this.mSize, key);
    }

    public synchronized int indexOfValue(E value) {
        int i;
        if (this.mGarbage) {
            gc();
        }
        i = 0;
        while (true) {
            if (i < this.mSize) {
                if (this.mValues[i] == value) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        return i;
    }

    public synchronized void clear() {
        int n = this.mSize;
        Object[] values = this.mValues;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public synchronized void append(int key, E value) {
        if (this.mSize != 0 && key <= this.mKeys[this.mSize - 1]) {
            put(key, value);
        } else {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int pos = this.mSize;
            if (pos >= this.mKeys.length) {
                int n = idealIntArraySize(pos + 1);
                int[] nkeys = new int[n];
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
    }

    public synchronized String toString() {
        String sb;
        if (size() <= 0) {
            sb = "{}";
        } else {
            StringBuilder buffer = new StringBuilder(this.mSize * 28);
            buffer.append('{');
            for (int i = 0; i < this.mSize; i++) {
                if (i > 0) {
                    buffer.append(", ");
                }
                int key = keyAt(i);
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
            sb = buffer.toString();
        }
        return sb;
    }
}
