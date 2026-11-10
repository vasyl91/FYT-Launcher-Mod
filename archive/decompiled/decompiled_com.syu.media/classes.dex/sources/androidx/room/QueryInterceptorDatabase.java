package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, RoomDatabase.QueryCallback queryCallback, Executor queryCallbackExecutor) {
        this.mDelegate = supportSQLiteDatabase;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = queryCallbackExecutor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String sql) {
        return new QueryInterceptorStatement(this.mDelegate.compileStatement(sql), this.mQueryCallback, sql, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m38lambda$beginTransaction$0$androidxroomQueryInterceptorDatabase();
            }
        });
        this.mDelegate.beginTransaction();
    }

    /* JADX INFO: renamed from: lambda$beginTransaction$0$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m38lambda$beginTransaction$0$androidxroomQueryInterceptorDatabase() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m39lambda$beginTransactionNonExclusive$1$androidxroomQueryInterceptorDatabase();
            }
        });
        this.mDelegate.beginTransactionNonExclusive();
    }

    /* JADX INFO: renamed from: lambda$beginTransactionNonExclusive$1$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m39lambda$beginTransactionNonExclusive$1$androidxroomQueryInterceptorDatabase() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m40lambda$beginTransactionWithListener$2$androidxroomQueryInterceptorDatabase();
            }
        });
        this.mDelegate.beginTransactionWithListener(transactionListener);
    }

    /* JADX INFO: renamed from: lambda$beginTransactionWithListener$2$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m40lambda$beginTransactionWithListener$2$androidxroomQueryInterceptorDatabase() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m41lambda$beginTransactionWithListenerNonExclusive$3$androidxroomQueryInterceptorDatabase();
            }
        });
        this.mDelegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    /* JADX INFO: renamed from: lambda$beginTransactionWithListenerNonExclusive$3$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m41lambda$beginTransactionWithListenerNonExclusive$3$androidxroomQueryInterceptorDatabase() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m42lambda$endTransaction$4$androidxroomQueryInterceptorDatabase();
            }
        });
        this.mDelegate.endTransaction();
    }

    /* JADX INFO: renamed from: lambda$endTransaction$4$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m42lambda$endTransaction$4$androidxroomQueryInterceptorDatabase() {
        this.mQueryCallback.onQuery("END TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: renamed from: lambda$setTransactionSuccessful$5$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m49lambda$setTransactionSuccessful$5$androidxroomQueryInterceptorDatabase() {
        this.mQueryCallback.onQuery("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m49lambda$setTransactionSuccessful$5$androidxroomQueryInterceptorDatabase();
            }
        });
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        return this.mDelegate.yieldIfContendedSafely(sleepAfterYieldDelay);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int version) {
        this.mDelegate.setVersion(version);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long numBytes) {
        return this.mDelegate.setMaximumSize(numBytes);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long numBytes) {
        this.mDelegate.setPageSize(numBytes);
    }

    /* JADX INFO: renamed from: lambda$query$6$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m45lambda$query$6$androidxroomQueryInterceptorDatabase(String str) {
        this.mQueryCallback.onQuery(str, Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String query) {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m45lambda$query$6$androidxroomQueryInterceptorDatabase(query);
            }
        });
        return this.mDelegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String query, Object[] bindArgs) {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(bindArgs));
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m46lambda$query$7$androidxroomQueryInterceptorDatabase(query, arrayList);
            }
        });
        return this.mDelegate.query(query, bindArgs);
    }

    /* JADX INFO: renamed from: lambda$query$7$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m46lambda$query$7$androidxroomQueryInterceptorDatabase(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery query) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m47lambda$query$8$androidxroomQueryInterceptorDatabase(query, queryInterceptorProgram);
            }
        });
        return this.mDelegate.query(query);
    }

    /* JADX INFO: renamed from: lambda$query$8$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m47lambda$query$8$androidxroomQueryInterceptorDatabase(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgs());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m48lambda$query$9$androidxroomQueryInterceptorDatabase(query, queryInterceptorProgram);
            }
        });
        return this.mDelegate.query(query);
    }

    /* JADX INFO: renamed from: lambda$query$9$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m48lambda$query$9$androidxroomQueryInterceptorDatabase(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgs());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String table, int conflictAlgorithm, ContentValues values) throws SQLException {
        return this.mDelegate.insert(table, conflictAlgorithm, values);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String table, String whereClause, Object[] whereArgs) {
        return this.mDelegate.delete(table, whereClause, whereArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String table, int conflictAlgorithm, ContentValues values, String whereClause, Object[] whereArgs) {
        return this.mDelegate.update(table, conflictAlgorithm, values, whereClause, whereArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String sql) throws SQLException {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m43lambda$execSQL$10$androidxroomQueryInterceptorDatabase(sql);
            }
        });
        this.mDelegate.execSQL(sql);
    }

    /* JADX INFO: renamed from: lambda$execSQL$10$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m43lambda$execSQL$10$androidxroomQueryInterceptorDatabase(String str) {
        this.mQueryCallback.onQuery(str, new ArrayList(0));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String sql, Object[] bindArgs) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(bindArgs));
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m44lambda$execSQL$11$androidxroomQueryInterceptorDatabase(sql, arrayList);
            }
        });
        this.mDelegate.execSQL(sql, arrayList.toArray());
    }

    /* JADX INFO: renamed from: lambda$execSQL$11$androidx-room-QueryInterceptorDatabase, reason: not valid java name */
    /* synthetic */ void m44lambda$execSQL$11$androidxroomQueryInterceptorDatabase(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int newVersion) {
        return this.mDelegate.needUpgrade(newVersion);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int cacheSize) {
        this.mDelegate.setMaxSqlCacheSize(cacheSize);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean enable) {
        this.mDelegate.setForeignKeyConstraintsEnabled(enable);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }
}
