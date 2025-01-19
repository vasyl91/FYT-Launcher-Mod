package com.syu.util;

public class ConcurrentSparseIntArray implements Cloneable {
    private static final int[] EMPTY_INTS = new int[0];
    private int[] mKeys;
    private int mSize;
    private int[] mValues;

    public ConcurrentSparseIntArray() {
        this(10);
    }

    public ConcurrentSparseIntArray(int initialCapacity) {
        if (initialCapacity == 0) {
            this.mKeys = EMPTY_INTS;
            this.mValues = EMPTY_INTS;
        } else {
            int initialCapacity2 = idealIntArraySize(initialCapacity);
            this.mKeys = new int[initialCapacity2];
            this.mValues = new int[initialCapacity2];
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
    public synchronized ConcurrentSparseIntArray m1clone() {
        ConcurrentSparseIntArray clone;
        clone = null;
        try {
            clone = (ConcurrentSparseIntArray) super.clone();
            clone.mKeys = this.mKeys.clone();
            clone.mValues = this.mValues.clone();
        } catch (CloneNotSupportedException e) {
        }
        return clone;
    }

    public synchronized int get(int key) {
        return get(key, 0);
    }

    public synchronized int get(int key, int valueIfKeyNotFound) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0) {
            valueIfKeyNotFound = this.mValues[i];
        }
        return valueIfKeyNotFound;
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
        if (i >= 0) {
            removeAt(i);
        }
    }

    public synchronized void removeAt(int index) {
        System.arraycopy(this.mKeys, index + 1, this.mKeys, index, this.mSize - (index + 1));
        System.arraycopy(this.mValues, index + 1, this.mValues, index, this.mSize - (index + 1));
        this.mSize--;
    }

    public synchronized void put(int key, int value) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0) {
            this.mValues[i] = value;
        } else {
            int i2 = i ^ (-1);
            if (this.mSize >= this.mKeys.length) {
                int n = idealIntArraySize(this.mSize + 1);
                int[] nkeys = new int[n];
                int[] nvalues = new int[n];
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

    public synchronized int size() {
        return this.mSize;
    }

    public synchronized int keyAt(int index) {
        return this.mKeys[index];
    }

    public synchronized int valueAt(int index) {
        return this.mValues[index];
    }

    public synchronized int indexOfKey(int key) {
        return binarySearch(this.mKeys, this.mSize, key);
    }

    public synchronized int indexOfValue(int value) {
        int i;
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
        this.mSize = 0;
    }

    public synchronized void append(int key, int value) {
        if (this.mSize != 0 && key <= this.mKeys[this.mSize - 1]) {
            put(key, value);
        } else {
            int pos = this.mSize;
            if (pos >= this.mKeys.length) {
                int n = idealIntArraySize(pos + 1);
                int[] nkeys = new int[n];
                int[] nvalues = new int[n];
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
                int value = valueAt(i);
                buffer.append(value);
            }
            buffer.append('}');
            sb = buffer.toString();
        }
        return sb;
    }
}
