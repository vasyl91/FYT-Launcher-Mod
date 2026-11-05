package org.apache.poi.xdgf.usermodel.section;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CombinedIterable<T> implements Iterable<T> {
    final SortedMap<Long, T> _baseItems;
    final SortedMap<Long, T> _masterItems;

    public CombinedIterable(SortedMap<Long, T> sortedMap, SortedMap<Long, T> sortedMap2) {
        this._baseItems = sortedMap;
        this._masterItems = sortedMap2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator<Map.Entry<Long, T>> it;
        SortedMap<Long, T> sortedMap = this._masterItems;
        if (sortedMap != null) {
            it = sortedMap.entrySet().iterator();
        } else {
            it = Collections.emptySet().iterator();
        }
        return new Iterator<T>(it) { // from class: org.apache.poi.xdgf.usermodel.section.CombinedIterable.1
            Iterator<Map.Entry<Long, T>> baseI;
            Iterator<Map.Entry<Long, T>> masterI;
            final /* synthetic */ Iterator val$vmasterI;
            Long lastI = Long.MIN_VALUE;
            Map.Entry<Long, T> currentBase = null;
            Map.Entry<Long, T> currentMaster = null;

            {
                this.val$vmasterI = it;
                this.baseI = CombinedIterable.this._baseItems.entrySet().iterator();
                this.masterI = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.currentBase != null || this.currentMaster != null || this.baseI.hasNext() || this.masterI.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                long jLongValue;
                Map.Entry<Long, T> entry = this.currentBase;
                long jLongValue2 = LongCompanionObject.MAX_VALUE;
                if (entry == null) {
                    while (true) {
                        if (!this.baseI.hasNext()) {
                            jLongValue = Long.MAX_VALUE;
                            break;
                        }
                        Map.Entry<Long, T> next = this.baseI.next();
                        this.currentBase = next;
                        if (next.getKey().longValue() > this.lastI.longValue()) {
                            jLongValue = this.currentBase.getKey().longValue();
                            break;
                        }
                    }
                } else {
                    jLongValue = entry.getKey().longValue();
                }
                Map.Entry<Long, T> entry2 = this.currentMaster;
                if (entry2 == null) {
                    while (this.masterI.hasNext()) {
                        Map.Entry<Long, T> next2 = this.masterI.next();
                        this.currentMaster = next2;
                        if (next2.getKey().longValue() > this.lastI.longValue()) {
                            jLongValue2 = this.currentMaster.getKey().longValue();
                            break;
                        }
                    }
                } else {
                    jLongValue2 = entry2.getKey().longValue();
                }
                if (this.currentBase == null) {
                    Map.Entry<Long, T> entry3 = this.currentMaster;
                    if (entry3 != null) {
                        this.lastI = entry3.getKey();
                        T value = this.currentMaster.getValue();
                        this.currentMaster = null;
                        return value;
                    }
                    throw new NoSuchElementException();
                }
                if (jLongValue <= jLongValue2) {
                    this.lastI = Long.valueOf(jLongValue);
                    T value2 = this.currentBase.getValue();
                    if (jLongValue2 == jLongValue) {
                        this.currentMaster = null;
                    }
                    this.currentBase = null;
                    return value2;
                }
                this.lastI = Long.valueOf(jLongValue2);
                Map.Entry<Long, T> entry4 = this.currentMaster;
                T value3 = entry4 != null ? entry4.getValue() : null;
                this.currentMaster = null;
                return value3;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
