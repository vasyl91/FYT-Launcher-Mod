package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class JSONSerializerContext {
    public static final int DEFAULT_TABLE_SIZE = 128;
    private final Entry[] buckets;
    private final int indexMask;

    public JSONSerializerContext() {
        this(128);
    }

    public JSONSerializerContext(int tableSize) {
        this.indexMask = tableSize - 1;
        this.buckets = new Entry[tableSize];
    }

    public final boolean put(Object o) {
        int hash = System.identityHashCode(o);
        int bucket = hash & this.indexMask;
        for (Entry entry = this.buckets[bucket]; entry != null; entry = entry.next) {
            if (o == entry.object) {
                return true;
            }
        }
        Entry entry2 = new Entry(o, hash, this.buckets[bucket]);
        this.buckets[bucket] = entry2;
        return false;
    }

    protected static final class Entry {
        public final int hashCode;
        public Entry next;
        public final Object object;

        public Entry(Object object, int hash, Entry next) {
            this.object = object;
            this.next = next;
            this.hashCode = hash;
        }
    }
}
