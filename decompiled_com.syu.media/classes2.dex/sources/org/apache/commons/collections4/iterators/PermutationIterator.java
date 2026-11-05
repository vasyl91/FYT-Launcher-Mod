package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PermutationIterator<E> implements Iterator<List<E>> {
    private boolean[] direction;
    private int[] keys;
    private List<E> nextPermutation;
    private Map<Integer, E> objectMap;

    public PermutationIterator(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        this.objectMap = new HashMap();
        Iterator<? extends E> it = collection.iterator();
        int i = 1;
        while (it.hasNext()) {
            this.objectMap.put(Integer.valueOf(i), it.next());
            this.keys[i - 1] = i;
            i++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    @Override // java.util.Iterator
    public List<E> next() {
        int[] iArr;
        int i;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            iArr = this.keys;
            if (i3 >= iArr.length) {
                break;
            }
            boolean z = this.direction[i3];
            if (((z && i3 < iArr.length - 1 && iArr[i3] > iArr[i3 + 1]) || (!z && i3 > 0 && iArr[i3] > iArr[i3 - 1])) && (i = iArr[i3]) > i4) {
                i5 = i3;
                i4 = i;
            }
            i3++;
        }
        if (i4 == -1) {
            List<E> list = this.nextPermutation;
            this.nextPermutation = null;
            return list;
        }
        boolean[] zArr = this.direction;
        boolean z2 = zArr[i5];
        int i6 = z2 ? 1 : -1;
        int i7 = iArr[i5];
        int i8 = i6 + i5;
        iArr[i5] = iArr[i8];
        iArr[i8] = i7;
        zArr[i5] = zArr[i8];
        zArr[i8] = z2;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr2 = this.keys;
            if (i2 < iArr2.length) {
                int i9 = iArr2[i2];
                if (i9 > i4) {
                    boolean[] zArr2 = this.direction;
                    zArr2[i2] = !zArr2[i2];
                }
                arrayList.add(this.objectMap.get(Integer.valueOf(i9)));
                i2++;
            } else {
                List<E> list2 = this.nextPermutation;
                this.nextPermutation = arrayList;
                return list2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
