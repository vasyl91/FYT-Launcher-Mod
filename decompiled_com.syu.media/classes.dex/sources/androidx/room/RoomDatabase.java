package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.util.Function;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private AutoCloser mAutoCloser;

    @Deprecated
    protected List<Callback> mCallbacks;

    @Deprecated
    protected volatile SupportSQLiteDatabase mDatabase;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private final Map<String, Object> mBackingFieldMap = Collections.synchronizedMap(new HashMap());
    private final InvalidationTracker mInvalidationTracker = createInvalidationTracker();
    private final Map<Class<?>, Object> mTypeConverters = new HashMap();

    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase db) {
        }

        public void onDestructiveMigration(SupportSQLiteDatabase db) {
        }

        public void onOpen(SupportSQLiteDatabase db) {
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase db) {
        }
    }

    public interface QueryCallback {
        void onQuery(String sqlQuery, List<Object> bindArgs);
    }

    public abstract void clearAllTables();

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config);

    Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        return (T) this.mTypeConverters.get(cls);
    }

    public void init(DatabaseConfiguration configuration) {
        SupportSQLiteOpenHelper supportSQLiteOpenHelperCreateOpenHelper = createOpenHelper(configuration);
        this.mOpenHelper = supportSQLiteOpenHelperCreateOpenHelper;
        SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, supportSQLiteOpenHelperCreateOpenHelper);
        if (sQLiteCopyOpenHelper != null) {
            sQLiteCopyOpenHelper.setDatabaseConfiguration(configuration);
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.mOpenHelper);
        if (autoClosingRoomOpenHelper != null) {
            AutoCloser autoCloser = autoClosingRoomOpenHelper.getAutoCloser();
            this.mAutoCloser = autoCloser;
            this.mInvalidationTracker.setAutoCloser(autoCloser);
        }
        boolean z = configuration.journalMode == JournalMode.WRITE_AHEAD_LOGGING;
        this.mOpenHelper.setWriteAheadLoggingEnabled(z);
        this.mCallbacks = configuration.callbacks;
        this.mQueryExecutor = configuration.queryExecutor;
        this.mTransactionExecutor = new TransactionExecutor(configuration.transactionExecutor);
        this.mAllowMainThreadQueries = configuration.allowMainThreadQueries;
        this.mWriteAheadLoggingEnabled = z;
        if (configuration.multiInstanceInvalidation) {
            this.mInvalidationTracker.startMultiInstanceInvalidation(configuration.context, configuration.name);
        }
        Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
        BitSet bitSet = new BitSet();
        for (Map.Entry<Class<?>, List<Class<?>>> entry : requiredTypeConverters.entrySet()) {
            Class<?> key = entry.getKey();
            for (Class<?> cls : entry.getValue()) {
                int size = configuration.typeConverters.size() - 1;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    } else {
                        if (cls.isAssignableFrom(configuration.typeConverters.get(size).getClass())) {
                            bitSet.set(size);
                            break;
                        }
                        size--;
                    }
                }
                if (size < 0) {
                    throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                }
                this.mTypeConverters.put(cls, configuration.typeConverters.get(size));
            }
        }
        for (int size2 = configuration.typeConverters.size() - 1; size2 >= 0; size2--) {
            if (!bitSet.get(size2)) {
                throw new IllegalArgumentException("Unexpected type converter " + configuration.typeConverters.get(size2) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return (T) unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
    }

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                this.mInvalidationTracker.stopMultiInstanceInvalidation();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public Cursor query(String query, Object[] args) {
        return this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(query, args));
    }

    public Cursor query(SupportSQLiteQuery query) {
        return query(query, (CancellationSignal) null);
    }

    public Cursor query(SupportSQLiteQuery query, CancellationSignal signal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (signal != null) {
            return this.mOpenHelper.getWritableDatabase().query(query, signal);
        }
        return this.mOpenHelper.getWritableDatabase().query(query);
    }

    public SupportSQLiteStatement compileStatement(String sql) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(sql);
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.m55lambda$beginTransaction$0$androidxroomRoomDatabase((SupportSQLiteDatabase) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$beginTransaction$0$androidx-room-RoomDatabase, reason: not valid java name */
    /* synthetic */ Object m55lambda$beginTransaction$0$androidxroomRoomDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalBeginTransaction();
        return null;
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    @Deprecated
    public void endTransaction() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.m56lambda$endTransaction$1$androidxroomRoomDatabase((SupportSQLiteDatabase) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$endTransaction$1$androidx-room-RoomDatabase, reason: not valid java name */
    /* synthetic */ Object m56lambda$endTransaction$1$androidxroomRoomDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalEndTransaction();
        return null;
    }

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        this.mInvalidationTracker.refreshVersionsAsync();
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    public void runInTransaction(Runnable body) {
        beginTransaction();
        try {
            body.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public <V> V runInTransaction(Callable<V> body) {
        beginTransaction();
        try {
            try {
                V vCall = body.call();
                setTransactionSuccessful();
                endTransaction();
                return vCall;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                SneakyThrow.reThrow(e2);
                endTransaction();
                return null;
            }
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase db) {
        this.mInvalidationTracker.internalInit(db);
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        JournalMode resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }
    }

    public static class Builder<T extends RoomDatabase> {
        private boolean mAllowDestructiveMigrationOnDowngrade;
        private boolean mAllowMainThreadQueries;
        private TimeUnit mAutoCloseTimeUnit;
        private ArrayList<Callback> mCallbacks;
        private final Context mContext;
        private String mCopyFromAssetPath;
        private File mCopyFromFile;
        private Callable<InputStream> mCopyFromInputStream;
        private final Class<T> mDatabaseClass;
        private SupportSQLiteOpenHelper.Factory mFactory;
        private Set<Integer> mMigrationStartAndEndVersions;
        private Set<Integer> mMigrationsNotRequiredFrom;
        private boolean mMultiInstanceInvalidation;
        private final String mName;
        private PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
        private QueryCallback mQueryCallback;
        private Executor mQueryCallbackExecutor;
        private Executor mQueryExecutor;
        private Executor mTransactionExecutor;
        private List<Object> mTypeConverters;
        private long mAutoCloseTimeout = -1;
        private JournalMode mJournalMode = JournalMode.AUTOMATIC;
        private boolean mRequireMigration = true;
        private final MigrationContainer mMigrationContainer = new MigrationContainer();

        Builder(Context context, Class<T> klass, String name) {
            this.mContext = context;
            this.mDatabaseClass = klass;
            this.mName = name;
        }

        public Builder<T> createFromAsset(String databaseFilePath) {
            this.mCopyFromAssetPath = databaseFilePath;
            return this;
        }

        public Builder<T> createFromAsset(String databaseFilePath, PrepackagedDatabaseCallback callback) {
            this.mPrepackagedDatabaseCallback = callback;
            this.mCopyFromAssetPath = databaseFilePath;
            return this;
        }

        public Builder<T> createFromFile(File databaseFile) {
            this.mCopyFromFile = databaseFile;
            return this;
        }

        public Builder<T> createFromFile(File databaseFile, PrepackagedDatabaseCallback callback) {
            this.mPrepackagedDatabaseCallback = callback;
            this.mCopyFromFile = databaseFile;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> inputStreamCallable) {
            this.mCopyFromInputStream = inputStreamCallable;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> inputStreamCallable, PrepackagedDatabaseCallback callback) {
            this.mPrepackagedDatabaseCallback = callback;
            this.mCopyFromInputStream = inputStreamCallable;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory) {
            this.mFactory = factory;
            return this;
        }

        public Builder<T> addMigrations(Migration... migrations) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrations) {
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.mMigrationContainer.addMigrations(migrations);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode journalMode) {
            this.mJournalMode = journalMode;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            this.mQueryExecutor = executor;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            this.mTransactionExecutor = executor;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            this.mMultiInstanceInvalidation = this.mName != null;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.mRequireMigration = false;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.mRequireMigration = true;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... startVersions) {
            if (this.mMigrationsNotRequiredFrom == null) {
                this.mMigrationsNotRequiredFrom = new HashSet(startVersions.length);
            }
            for (int i : startVersions) {
                this.mMigrationsNotRequiredFrom.add(Integer.valueOf(i));
            }
            return this;
        }

        public Builder<T> addCallback(Callback callback) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new ArrayList<>();
            }
            this.mCallbacks.add(callback);
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback, Executor executor) {
            this.mQueryCallback = queryCallback;
            this.mQueryCallbackExecutor = executor;
            return this;
        }

        public Builder<T> addTypeConverter(Object typeConverter) {
            if (this.mTypeConverters == null) {
                this.mTypeConverters = new ArrayList();
            }
            this.mTypeConverters.add(typeConverter);
            return this;
        }

        public Builder<T> setAutoCloseTimeout(long autoCloseTimeout, TimeUnit autoCloseTimeUnit) {
            if (autoCloseTimeout < 0) {
                throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
            }
            this.mAutoCloseTimeout = autoCloseTimeout;
            this.mAutoCloseTimeUnit = autoCloseTimeUnit;
            return this;
        }

        public T build() {
            Executor executor;
            if (this.mContext == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.mDatabaseClass == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            Executor executor2 = this.mQueryExecutor;
            if (executor2 == null && this.mTransactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.mTransactionExecutor = iOThreadExecutor;
                this.mQueryExecutor = iOThreadExecutor;
            } else if (executor2 != null && this.mTransactionExecutor == null) {
                this.mTransactionExecutor = executor2;
            } else if (executor2 == null && (executor = this.mTransactionExecutor) != null) {
                this.mQueryExecutor = executor;
            }
            Set<Integer> set = this.mMigrationStartAndEndVersions;
            if (set != null && this.mMigrationsNotRequiredFrom != null) {
                for (Integer num : set) {
                    if (this.mMigrationsNotRequiredFrom.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            SupportSQLiteOpenHelper.Factory sQLiteCopyOpenHelperFactory = this.mFactory;
            if (sQLiteCopyOpenHelperFactory == null) {
                sQLiteCopyOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            }
            if (this.mAutoCloseTimeout > 0) {
                if (this.mName == null) {
                    throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                }
                sQLiteCopyOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(sQLiteCopyOpenHelperFactory, new AutoCloser(this.mAutoCloseTimeout, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
            }
            String str = this.mCopyFromAssetPath;
            if (str != null || this.mCopyFromFile != null || this.mCopyFromInputStream != null) {
                if (this.mName == null) {
                    throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                if ((str == null ? 0 : 1) + (this.mCopyFromFile == null ? 0 : 1) + (this.mCopyFromInputStream != null ? 1 : 0) != 1) {
                    throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                }
                sQLiteCopyOpenHelperFactory = new SQLiteCopyOpenHelperFactory(this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, sQLiteCopyOpenHelperFactory);
            }
            SupportSQLiteOpenHelper.Factory queryInterceptorOpenHelperFactory = this.mQueryCallback != null ? new QueryInterceptorOpenHelperFactory(sQLiteCopyOpenHelperFactory, this.mQueryCallback, this.mQueryCallbackExecutor) : sQLiteCopyOpenHelperFactory;
            Context context = this.mContext;
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.mName, queryInterceptorOpenHelperFactory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(context), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidation, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters);
            T t = (T) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
            t.init(databaseConfiguration);
            return t;
        }
    }

    public static class MigrationContainer {
        private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();

        public void addMigrations(Migration... migrations) {
            for (Migration migration : migrations) {
                addMigration(migration);
            }
        }

        private void addMigration(Migration migration) {
            int i = migration.startVersion;
            int i2 = migration.endVersion;
            TreeMap<Integer, Migration> treeMap = this.mMigrations.get(Integer.valueOf(i));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.mMigrations.put(Integer.valueOf(i), treeMap);
            }
            Migration migration2 = treeMap.get(Integer.valueOf(i2));
            if (migration2 != null) {
                Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
            }
            treeMap.put(Integer.valueOf(i2), migration);
        }

        public List<Migration> findMigrationPath(int start, int end) {
            if (start == end) {
                return Collections.emptyList();
            }
            return findUpMigrationPath(new ArrayList(), end > start, start, end);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0019  */
        /* JADX WARN: Code duplicated, block: B:11:0x001e  */
        /* JADX WARN: Code duplicated, block: B:15:0x002d  */
        /* JADX WARN: Code duplicated, block: B:17:0x003a  */
        /* JADX WARN: Code duplicated, block: B:19:0x003e  */
        /* JADX WARN: Code duplicated, block: B:20:0x0040  */
        /* JADX WARN: Code duplicated, block: B:30:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:33:0x0056 A[EDGE_INSN: B:33:0x0056->B:25:0x0056 BREAK  A[LOOP:1: B:13:0x0026->B:41:?], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:35:0x0047 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:41:? A[LOOP:1: B:13:0x0026->B:41:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:9:0x0017 A[DONT_INVERT] */
        private List<Migration> findUpMigrationPath(List<Migration> result, boolean upgrade, int start, int end) {
            TreeMap<Integer, Migration> treeMap;
            Set<Integer> setKeySet;
            Iterator<Integer> it;
            boolean z;
            int iIntValue;
            do {
                if (upgrade) {
                    if (start >= end) {
                        return result;
                    }
                    treeMap = this.mMigrations.get(Integer.valueOf(start));
                    if (treeMap == null) {
                        if (upgrade) {
                            setKeySet = treeMap.descendingKeySet();
                        } else {
                            setKeySet = treeMap.keySet();
                        }
                        it = setKeySet.iterator();
                        while (true) {
                            z = false;
                            if (it.hasNext()) {
                                break;
                            }
                            iIntValue = it.next().intValue();
                            if (upgrade) {
                                if (iIntValue > end && iIntValue > start) {
                                    z = true;
                                }
                            } else if (iIntValue < end && iIntValue < start) {
                                z = true;
                            }
                            if (z) {
                                result.add(treeMap.get(Integer.valueOf(iIntValue)));
                                start = iIntValue;
                                z = true;
                                break;
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (start <= end) {
                        return result;
                    }
                    treeMap = this.mMigrations.get(Integer.valueOf(start));
                    if (treeMap == null) {
                        if (upgrade) {
                            setKeySet = treeMap.descendingKeySet();
                        } else {
                            setKeySet = treeMap.keySet();
                        }
                        it = setKeySet.iterator();
                        while (true) {
                            z = false;
                            if (it.hasNext()) {
                                break;
                                break;
                            }
                            iIntValue = it.next().intValue();
                            if (upgrade) {
                                if (iIntValue > end) {
                                }
                            } else if (iIntValue < end) {
                            }
                            if (z) {
                                result.add(treeMap.get(Integer.valueOf(iIntValue)));
                                start = iIntValue;
                                z = true;
                                break;
                                break;
                            }
                        }
                    } else {
                        return null;
                    }
                }
            } while (z);
            return null;
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
