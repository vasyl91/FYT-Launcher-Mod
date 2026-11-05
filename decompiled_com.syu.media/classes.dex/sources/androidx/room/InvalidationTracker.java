package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
    static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    AutoCloser mAutoCloser;
    volatile SupportSQLiteStatement mCleanupStatement;
    final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private ObservedTableTracker mObservedTableTracker;
    final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    AtomicBoolean mPendingRefresh;
    Runnable mRefreshRunnable;
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;
    private Map<String, Set<String>> mViewTables;

    public InvalidationTracker(RoomDatabase database, String... tableNames) {
        this(database, new HashMap(), Collections.emptyMap(), tableNames);
    }

    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        this.mAutoCloser = null;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap<>();
        this.mRefreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Lock closeLock = InvalidationTracker.this.mDatabase.getCloseLock();
                closeLock.lock();
                Set<Integer> setCheckUpdatedTable = null;
                try {
                    try {
                        if (!InvalidationTracker.this.ensureInitialization()) {
                            closeLock.unlock();
                            if (InvalidationTracker.this.mAutoCloser != null) {
                                InvalidationTracker.this.mAutoCloser.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        if (!InvalidationTracker.this.mPendingRefresh.compareAndSet(true, false)) {
                            closeLock.unlock();
                            if (InvalidationTracker.this.mAutoCloser != null) {
                                InvalidationTracker.this.mAutoCloser.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        if (InvalidationTracker.this.mDatabase.inTransaction()) {
                            closeLock.unlock();
                            if (InvalidationTracker.this.mAutoCloser != null) {
                                InvalidationTracker.this.mAutoCloser.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        if (InvalidationTracker.this.mDatabase.mWriteAheadLoggingEnabled) {
                            SupportSQLiteDatabase writableDatabase = InvalidationTracker.this.mDatabase.getOpenHelper().getWritableDatabase();
                            writableDatabase.beginTransactionNonExclusive();
                            try {
                                setCheckUpdatedTable = checkUpdatedTable();
                                writableDatabase.setTransactionSuccessful();
                                writableDatabase.endTransaction();
                            } catch (Throwable th) {
                                writableDatabase.endTransaction();
                                throw th;
                            }
                        } else {
                            setCheckUpdatedTable = checkUpdatedTable();
                        }
                        closeLock.unlock();
                        if (InvalidationTracker.this.mAutoCloser != null) {
                            InvalidationTracker.this.mAutoCloser.decrementCountAndScheduleClose();
                        }
                        if (setCheckUpdatedTable == null || setCheckUpdatedTable.isEmpty()) {
                            return;
                        }
                        synchronized (InvalidationTracker.this.mObserverMap) {
                            Iterator<Map.Entry<Observer, ObserverWrapper>> it = InvalidationTracker.this.mObserverMap.iterator();
                            while (it.hasNext()) {
                                it.next().getValue().notifyByTableInvalidStatus(setCheckUpdatedTable);
                            }
                        }
                    } catch (Throwable th2) {
                        closeLock.unlock();
                        if (InvalidationTracker.this.mAutoCloser != null) {
                            InvalidationTracker.this.mAutoCloser.decrementCountAndScheduleClose();
                        }
                        throw th2;
                    }
                } catch (SQLiteException | IllegalStateException e) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                    closeLock.unlock();
                    if (InvalidationTracker.this.mAutoCloser != null) {
                    }
                }
            }

            private Set<Integer> checkUpdatedTable() {
                HashSet hashSet = new HashSet();
                Cursor cursorQuery = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL));
                while (cursorQuery.moveToNext()) {
                    try {
                        hashSet.add(Integer.valueOf(cursorQuery.getInt(0)));
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
                if (!hashSet.isEmpty()) {
                    InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
                }
                return hashSet;
            }
        };
        this.mDatabase = database;
        this.mObservedTableTracker = new ObservedTableTracker(tableNames.length);
        this.mTableIdLookup = new HashMap<>();
        this.mViewTables = viewTables;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        int length = tableNames.length;
        this.mTableNames = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = tableNames[i].toLowerCase(Locale.US);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str = shadowTablesMap.get(tableNames[i]);
            if (str != null) {
                this.mTableNames[i] = str.toLowerCase(Locale.US);
            } else {
                this.mTableNames[i] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : shadowTablesMap.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                HashMap<String, Integer> map = this.mTableIdLookup;
                map.put(lowerCase3, map.get(lowerCase2));
            }
        }
    }

    void setAutoCloser(AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: androidx.room.InvalidationTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onAutoCloseCallback();
            }
        });
    }

    void internalInit(SupportSQLiteDatabase database) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers(database);
            this.mCleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.mInitialized = true;
        }
    }

    void onAutoCloseCallback() {
        synchronized (this) {
            this.mInitialized = false;
            this.mObservedTableTracker.resetTriggerState();
        }
    }

    void startMultiInstanceInvalidation(Context context, String name) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, this, this.mDatabase.getQueryExecutor());
    }

    void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    private static void appendTriggerName(StringBuilder builder, String tableName, String triggerType) {
        builder.append("`").append("room_table_modification_trigger_").append(tableName).append("_").append(triggerType).append("`");
    }

    private void stopTrackingTable(SupportSQLiteDatabase writableDb, int tableId) {
        String str = this.mTableNames[tableId];
        StringBuilder sb = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb, str, str2);
            writableDb.execSQL(sb.toString());
        }
    }

    private void startTrackingTable(SupportSQLiteDatabase writableDb, int tableId) {
        writableDb.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + tableId + ", 0)");
        String str = this.mTableNames[tableId];
        StringBuilder sb = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb, str, str2);
            sb.append(" AFTER ").append(str2).append(" ON `").append(str).append("` BEGIN UPDATE ").append(UPDATE_TABLE_NAME).append(" SET ").append(INVALIDATED_COLUMN_NAME).append(" = 1").append(" WHERE ").append(TABLE_ID_COLUMN_NAME).append(" = ").append(tableId).append(" AND ").append(INVALIDATED_COLUMN_NAME).append(" = 0").append("; END");
            writableDb.execSQL(sb.toString());
        }
    }

    public void addObserver(Observer observer) {
        ObserverWrapper observerWrapperPutIfAbsent;
        String[] strArrResolveViews = resolveViews(observer.mTables);
        int[] iArr = new int[strArrResolveViews.length];
        int length = strArrResolveViews.length;
        for (int i = 0; i < length; i++) {
            Integer num = this.mTableIdLookup.get(strArrResolveViews[i].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + strArrResolveViews[i]);
            }
            iArr[i] = num.intValue();
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArrResolveViews);
        synchronized (this.mObserverMap) {
            observerWrapperPutIfAbsent = this.mObserverMap.putIfAbsent(observer, observerWrapper);
        }
        if (observerWrapperPutIfAbsent == null && this.mObservedTableTracker.onAdded(iArr)) {
            syncTriggers();
        }
    }

    private String[] validateAndResolveTableNames(String[] tableNames) {
        String[] strArrResolveViews = resolveViews(tableNames);
        for (String str : strArrResolveViews) {
            if (!this.mTableIdLookup.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return strArrResolveViews;
    }

    private String[] resolveViews(String[] names) {
        HashSet hashSet = new HashSet();
        for (String str : names) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase database) {
        if (database.isWriteAheadLoggingEnabled()) {
            database.beginTransactionNonExclusive();
        } else {
            database.beginTransaction();
        }
    }

    public void addWeakObserver(Observer observer) {
        addObserver(new WeakObserver(this, observer));
    }

    public void removeObserver(final Observer observer) {
        ObserverWrapper observerWrapperRemove;
        synchronized (this.mObserverMap) {
            observerWrapperRemove = this.mObserverMap.remove(observer);
        }
        if (observerWrapperRemove == null || !this.mObservedTableTracker.onRemoved(observerWrapperRemove.mTableIds)) {
            return;
        }
        syncTriggers();
    }

    boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.getOpenHelper().getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.mAutoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    public void notifyObserversByTableNames(String... tables) {
        synchronized (this.mObserverMap) {
            for (Map.Entry<Observer, ObserverWrapper> entry : this.mObserverMap) {
                if (!entry.getKey().isRemote()) {
                    entry.getValue().notifyByTableNames(tables);
                }
            }
        }
    }

    void syncTriggers(SupportSQLiteDatabase database) {
        if (database.inTransaction()) {
            return;
        }
        while (true) {
            try {
                Lock closeLock = this.mDatabase.getCloseLock();
                closeLock.lock();
                try {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync != null) {
                        int length = tablesToSync.length;
                        beginTransactionInternal(database);
                        for (int i = 0; i < length; i++) {
                            try {
                                int i2 = tablesToSync[i];
                                if (i2 == 1) {
                                    startTrackingTable(database, i);
                                } else if (i2 == 2) {
                                    stopTrackingTable(database, i);
                                }
                            } catch (Throwable th) {
                                database.endTransaction();
                                throw th;
                            }
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        this.mObservedTableTracker.onSyncCompleted();
                        closeLock.unlock();
                    } else {
                        closeLock.unlock();
                        return;
                    }
                } catch (Throwable th2) {
                    closeLock.unlock();
                    throw th2;
                }
            } catch (SQLiteException | IllegalStateException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }

    void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }

    @Deprecated
    public <T> LiveData<T> createLiveData(String[] tableNames, Callable<T> computeFunction) {
        return createLiveData(tableNames, false, computeFunction);
    }

    public <T> LiveData<T> createLiveData(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), inTransaction, computeFunction);
    }

    static class ObserverWrapper {
        final Observer mObserver;
        private final Set<String> mSingleTableSet;
        final int[] mTableIds;
        private final String[] mTableNames;

        ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            this.mObserver = observer;
            this.mTableIds = tableIds;
            this.mTableNames = tableNames;
            if (tableIds.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(tableNames[0]);
                this.mSingleTableSet = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.mSingleTableSet = null;
        }

        void notifyByTableInvalidStatus(Set<Integer> invalidatedTablesIds) {
            int length = this.mTableIds.length;
            Set<String> hashSet = null;
            for (int i = 0; i < length; i++) {
                if (invalidatedTablesIds.contains(Integer.valueOf(this.mTableIds[i]))) {
                    if (length == 1) {
                        hashSet = this.mSingleTableSet;
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet<>(length);
                        }
                        hashSet.add(this.mTableNames[i]);
                    }
                }
            }
            if (hashSet != null) {
                this.mObserver.onInvalidated(hashSet);
            }
        }

        void notifyByTableNames(String[] tables) {
            Set<String> set = null;
            if (this.mTableNames.length == 1) {
                for (String str : tables) {
                    if (str.equalsIgnoreCase(this.mTableNames[0])) {
                        set = this.mSingleTableSet;
                        break;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str2 : tables) {
                    for (String str3 : this.mTableNames) {
                        if (str3.equalsIgnoreCase(str2)) {
                            hashSet.add(str3);
                            break;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.mObserver.onInvalidated(set);
            }
        }
    }

    public static abstract class Observer {
        final String[] mTables;

        boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(Set<String> tables);

        protected Observer(String firstTable, String... rest) {
            String[] strArr = (String[]) Arrays.copyOf(rest, rest.length + 1);
            this.mTables = strArr;
            strArr[rest.length] = firstTable;
        }

        public Observer(String[] tables) {
            this.mTables = (String[]) Arrays.copyOf(tables, tables.length);
        }
    }

    static class ObservedTableTracker {
        static final int ADD = 1;
        static final int NO_OP = 0;
        static final int REMOVE = 2;
        boolean mNeedsSync;
        boolean mPendingSync;
        final long[] mTableObservers;
        final int[] mTriggerStateChanges;
        final boolean[] mTriggerStates;

        ObservedTableTracker(int tableCount) {
            long[] jArr = new long[tableCount];
            this.mTableObservers = jArr;
            boolean[] zArr = new boolean[tableCount];
            this.mTriggerStates = zArr;
            this.mTriggerStateChanges = new int[tableCount];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        boolean onAdded(int... tableIds) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : tableIds) {
                    long[] jArr = this.mTableObservers;
                    long j = jArr[i];
                    jArr[i] = 1 + j;
                    if (j == 0) {
                        z = true;
                        this.mNeedsSync = true;
                    }
                }
            }
            return z;
        }

        boolean onRemoved(int... tableIds) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : tableIds) {
                    long[] jArr = this.mTableObservers;
                    long j = jArr[i];
                    jArr[i] = j - 1;
                    if (j == 1) {
                        z = true;
                        this.mNeedsSync = true;
                    }
                }
            }
            return z;
        }

        void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.mTriggerStates, false);
                this.mNeedsSync = true;
            }
        }

        int[] getTablesToSync() {
            synchronized (this) {
                if (this.mNeedsSync && !this.mPendingSync) {
                    int length = this.mTableObservers.length;
                    int i = 0;
                    while (true) {
                        int i2 = 1;
                        if (i < length) {
                            boolean z = this.mTableObservers[i] > 0;
                            boolean[] zArr = this.mTriggerStates;
                            if (z != zArr[i]) {
                                int[] iArr = this.mTriggerStateChanges;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[i] = i2;
                            } else {
                                this.mTriggerStateChanges[i] = 0;
                            }
                            zArr[i] = z;
                            i++;
                        } else {
                            this.mPendingSync = true;
                            this.mNeedsSync = false;
                            return this.mTriggerStateChanges;
                        }
                    }
                }
                return null;
            }
        }

        void onSyncCompleted() {
            synchronized (this) {
                this.mPendingSync = false;
            }
        }
    }

    static class WeakObserver extends Observer {
        final WeakReference<Observer> mDelegateRef;
        final InvalidationTracker mTracker;

        WeakObserver(InvalidationTracker tracker, Observer delegate) {
            super(delegate.mTables);
            this.mTracker = tracker;
            this.mDelegateRef = new WeakReference<>(delegate);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> tables) {
            Observer observer = this.mDelegateRef.get();
            if (observer == null) {
                this.mTracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }
}
