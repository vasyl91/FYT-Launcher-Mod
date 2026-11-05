package org.apache.poi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class IntMapper<T> {
    private static final int _default_size = 10;
    private List<T> elements;
    private Map<T, Integer> valueKeyMap;

    public IntMapper() {
        this(10);
    }

    public IntMapper(int i) {
        this.elements = new ArrayList(i);
        this.valueKeyMap = new HashMap(i);
    }

    public boolean add(T t) {
        int size = this.elements.size();
        this.elements.add(t);
        this.valueKeyMap.put(t, Integer.valueOf(size));
        return true;
    }

    public int size() {
        return this.elements.size();
    }

    public T get(int i) {
        return this.elements.get(i);
    }

    public int getIndex(T t) {
        Integer num = this.valueKeyMap.get(t);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Iterator<T> iterator() {
        return this.elements.iterator();
    }
}
