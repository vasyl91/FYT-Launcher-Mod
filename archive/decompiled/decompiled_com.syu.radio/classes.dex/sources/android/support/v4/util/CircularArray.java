package android.support.v4.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    private void doubleCapacity() {
        int length = this.mElements.length;
        int i = length - this.mHead;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Too big");
        }
        Object[] objArr = new Object[i2];
        System.arraycopy(this.mElements, this.mHead, objArr, 0, i);
        System.arraycopy(this.mElements, 0, objArr, i, this.mHead);
        this.mElements = (E[]) objArr;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        int iHighestOneBit = Integer.bitCount(i) != 1 ? 1 << (Integer.highestOneBit(i) + 1) : i;
        this.mCapacityBitmask = iHighestOneBit - 1;
        this.mElements = (E[]) new Object[iHighestOneBit];
    }

    public final void addFirst(E e) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        this.mElements[this.mHead] = e;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        this.mElements[this.mTail] = e;
        this.mTail = (this.mTail + 1) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public final E popFirst() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E result = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = (this.mHead + 1) & this.mCapacityBitmask;
        return result;
    }

    public final E popLast() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int t = (this.mTail - 1) & this.mCapacityBitmask;
        E result = this.mElements[t];
        this.mElements[t] = null;
        this.mTail = t;
        return result;
    }

    public final E getFirst() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mHead];
    }

    public final E getLast() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[(this.mTail - 1) & this.mCapacityBitmask];
    }

    public final E get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int p = (this.mHead + i) & this.mCapacityBitmask;
        return this.mElements[p];
    }

    public final int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public final boolean isEmpty() {
        return this.mHead == this.mTail;
    }
}
