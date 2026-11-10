package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final SupportSQLiteOpenHelper mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, RoomDatabase.QueryCallback queryCallback, Executor queryCallbackExecutor) {
        this.mDelegate = supportSQLiteOpenHelper;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = queryCallbackExecutor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.mDelegate.setWriteAheadLoggingEnabled(enabled);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getWritableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getReadableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }
}
