package com.syu.util;

public class ConcurrentStringSparseIntArray implements Cloneable {
    private final int DELETED;
    private boolean mGarbage;
    private String[] mKeys;
    private int mSize;
    private int[] mValues;
    private static final String[] EMPTY_STRS = new String[0];
    private static final int[] EMPTY_INTS = new int[0];

    public ConcurrentStringSparseIntArray(int deleted) {
        this(10, deleted);
    }

    public ConcurrentStringSparseIntArray(int initialCapacity, int deleted) {
        this.mGarbage = false;
        this.DELETED = deleted;
        if (initialCapacity == 0) {
            this.mKeys = EMPTY_STRS;
            this.mValues = EMPTY_INTS;
        } else {
            int initialCapacity2 = idealIntArraySize(initialCapacity);
            this.mKeys = new String[initialCapacity2];
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
    public synchronized ConcurrentStringSparseIntArray m3clone() {
        ConcurrentStringSparseIntArray clone;
        clone = null;
        try {
            clone = (ConcurrentStringSparseIntArray) super.clone();
            clone.mKeys = this.mKeys.clone();
            clone.mValues = this.mValues.clone();
        } catch (CloneNotSupportedException e) {
        }
        return clone;
    }

    public int get(String key) {
        return get(key, 0);
    }

    public synchronized int get(String key, int valueIfKeyNotFound) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0 && this.mValues[i] != this.DELETED) {
            valueIfKeyNotFound = this.mValues[i];
        }
        return valueIfKeyNotFound;
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

    public synchronized void delete(String key) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0 && this.mValues[i] != this.DELETED) {
            this.mValues[i] = this.DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(String key) {
        delete(key);
    }

    public synchronized void removeAt(int index) {
        if (this.mValues[index] != this.DELETED) {
            this.mValues[index] = this.DELETED;
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
        String[] keys = this.mKeys;
        int[] values = this.mValues;
        for (int i = 0; i < n; i++) {
            int val = values[i];
            if (val != this.DELETED) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                }
                o++;
            }
        }
        this.mGarbage = false;
        this.mSize = o;
    }

    public synchronized void put(String key, int value) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0) {
            this.mValues[i] = value;
        } else {
            int i2 = i ^ (-1);
            if (i2 < this.mSize && this.mValues[i2] == this.DELETED) {
                this.mKeys[i2] = key;
                this.mValues[i2] = value;
            } else {
                if (this.mGarbage && this.mSize >= this.mKeys.length) {
                    gc();
                    i2 = binarySearch(this.mKeys, this.mSize, key) ^ (-1);
                }
                if (this.mSize >= this.mKeys.length) {
                    int n = idealIntArraySize(this.mSize + 1);
                    String[] nkeys = new String[n];
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
    }

    public synchronized int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public synchronized String keyAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[index];
    }

    public synchronized int valueAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[index];
    }

    public synchronized void setValueAt(int index, int value) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[index] = value;
    }

    public synchronized int indexOfKey(String key) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, this.mSize, key);
    }

    public synchronized int indexOfValue(int value) {
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
        this.mSize = 0;
    }

    private boolean StringGreater(String left, String right) {
        return left != null && left.compareTo(right) > 0;
    }

    public synchronized void append(String key, int value) {
        if (this.mSize != 0 && !StringGreater(key, this.mKeys[this.mSize - 1])) {
            put(key, value);
        } else {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int pos = this.mSize;
            if (pos >= this.mKeys.length) {
                int n = idealIntArraySize(pos + 1);
                String[] nkeys = new String[n];
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
                String key = keyAt(i);
                buffer.append(key);
                buffer.append('=');
                Integer value = Integer.valueOf(valueAt(i));
                if (value != this.mSize) {
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
