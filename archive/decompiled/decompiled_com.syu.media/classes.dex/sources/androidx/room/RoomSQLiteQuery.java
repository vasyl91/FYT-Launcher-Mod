package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap<>();
    int mArgCount;
    private final int[] mBindingTypes;
    final byte[][] mBlobBindings;
    final int mCapacity;
    final double[] mDoubleBindings;
    final long[] mLongBindings;
    private volatile String mQuery;
    final String[] mStringBindings;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindNull(int index) {
                RoomSQLiteQuery.this.bindNull(index);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindLong(int index, long value) {
                RoomSQLiteQuery.this.bindLong(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindDouble(int index, double value) {
                RoomSQLiteQuery.this.bindDouble(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindString(int index, String value) {
                RoomSQLiteQuery.this.bindString(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindBlob(int index, byte[] value) {
                RoomSQLiteQuery.this.bindBlob(index, value);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void clearBindings() {
                RoomSQLiteQuery.this.clearBindings();
            }
        });
        return roomSQLiteQueryAcquire;
    }

    public static RoomSQLiteQuery acquire(String query, int argumentCount) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(argumentCount));
            if (entryCeilingEntry != null) {
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery value = entryCeilingEntry.getValue();
                value.init(query, argumentCount);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(argumentCount);
            roomSQLiteQuery.init(query, argumentCount);
            return roomSQLiteQuery;
        }
    }

    private RoomSQLiteQuery(int capacity) {
        this.mCapacity = capacity;
        int i = capacity + 1;
        this.mBindingTypes = new int[i];
        this.mLongBindings = new long[i];
        this.mDoubleBindings = new double[i];
        this.mStringBindings = new String[i];
        this.mBlobBindings = new byte[i][];
    }

    void init(String query, int argCount) {
        this.mQuery = query;
        this.mArgCount = argCount;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.mCapacity), this);
            prunePoolLocked();
        }
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram program) {
        for (int i = 1; i <= this.mArgCount; i++) {
            int i2 = this.mBindingTypes[i];
            if (i2 == 1) {
                program.bindNull(i);
            } else if (i2 == 2) {
                program.bindLong(i, this.mLongBindings[i]);
            } else if (i2 == 3) {
                program.bindDouble(i, this.mDoubleBindings[i]);
            } else if (i2 == 4) {
                program.bindString(i, this.mStringBindings[i]);
            } else if (i2 == 5) {
                program.bindBlob(i, this.mBlobBindings[i]);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        this.mBindingTypes[index] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        this.mBindingTypes[index] = 2;
        this.mLongBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        this.mBindingTypes[index] = 3;
        this.mDoubleBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        this.mBindingTypes[index] = 4;
        this.mStringBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        this.mBindingTypes[index] = 5;
        this.mBlobBindings[index] = value;
    }

    public void copyArgumentsFrom(RoomSQLiteQuery other) {
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
        System.arraycopy(other.mLongBindings, 0, this.mLongBindings, 0, argCount);
        System.arraycopy(other.mStringBindings, 0, this.mStringBindings, 0, argCount);
        System.arraycopy(other.mBlobBindings, 0, this.mBlobBindings, 0, argCount);
        System.arraycopy(other.mDoubleBindings, 0, this.mDoubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, (Object) null);
        Arrays.fill(this.mBlobBindings, (Object) null);
        this.mQuery = null;
    }
}
