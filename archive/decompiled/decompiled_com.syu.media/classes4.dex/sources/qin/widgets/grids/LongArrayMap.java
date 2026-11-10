package qin.widgets.grids;

import android.util.LongSparseArray;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class LongArrayMap<E> extends LongSparseArray<E> implements Iterable<E> {

    public class ValueIterator implements Iterator<E> {
        public int a = 0;

        public ValueIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < LongArrayMap.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            LongArrayMap longArrayMap = LongArrayMap.this;
            int i = this.a;
            this.a = i + 1;
            return longArrayMap.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public boolean containsKey(long j) {
        return indexOfKey(j) >= 0;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new ValueIterator();
    }

    @Override // android.util.LongSparseArray
    public LongArrayMap<E> clone() {
        return (LongArrayMap) super.clone();
    }
}
