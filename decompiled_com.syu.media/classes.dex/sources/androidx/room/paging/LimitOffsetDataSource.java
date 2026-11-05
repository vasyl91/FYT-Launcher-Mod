package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    protected abstract List<T> convertRows(Cursor cursor);

    protected LimitOffsetDataSource(RoomDatabase db, SupportSQLiteQuery query, boolean inTransaction, String... tables) {
        this(db, RoomSQLiteQuery.copyFrom(query), inTransaction, tables);
    }

    protected LimitOffsetDataSource(RoomDatabase db, SupportSQLiteQuery query, boolean inTransaction, boolean registerObserverImmediately, String... tables) {
        this(db, RoomSQLiteQuery.copyFrom(query), inTransaction, registerObserverImmediately, tables);
    }

    protected LimitOffsetDataSource(RoomDatabase db, RoomSQLiteQuery query, boolean inTransaction, String... tables) {
        this(db, query, inTransaction, true, tables);
    }

    protected LimitOffsetDataSource(RoomDatabase db, RoomSQLiteQuery query, boolean inTransaction, boolean registerObserverImmediately, String... tables) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = db;
        this.mSourceQuery = query;
        this.mInTransaction = inTransaction;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + query.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + query.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new InvalidationTracker.Observer(tables) { // from class: androidx.room.paging.LimitOffsetDataSource.1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> tables2) {
                LimitOffsetDataSource.this.invalidate();
            }
        };
        if (registerObserverImmediately) {
            registerObserverIfNecessary();
        }
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true)) {
            this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        }
    }

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        roomSQLiteQueryAcquire.copyArgumentsFrom(this.mSourceQuery);
        Cursor cursorQuery = this.mDb.query(roomSQLiteQueryAcquire);
        try {
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getInt(0);
            }
            return 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams params, PositionalDataSource.LoadInitialCallback<T> callback) throws Throwable {
        RoomSQLiteQuery sQLiteQuery;
        int i;
        RoomSQLiteQuery roomSQLiteQuery;
        registerObserverIfNecessary();
        List<T> listEmptyList = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor cursorQuery = null;
        try {
            int iCountItems = countItems();
            if (iCountItems != 0) {
                int iComputeInitialLoadPosition = computeInitialLoadPosition(params, iCountItems);
                sQLiteQuery = getSQLiteQuery(iComputeInitialLoadPosition, computeInitialLoadSize(params, iComputeInitialLoadPosition, iCountItems));
                try {
                    cursorQuery = this.mDb.query(sQLiteQuery);
                    List<T> listConvertRows = convertRows(cursorQuery);
                    this.mDb.setTransactionSuccessful();
                    roomSQLiteQuery = sQLiteQuery;
                    i = iComputeInitialLoadPosition;
                    listEmptyList = listConvertRows;
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    this.mDb.endTransaction();
                    if (sQLiteQuery != null) {
                        sQLiteQuery.release();
                    }
                    throw th;
                }
            } else {
                i = 0;
                roomSQLiteQuery = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            this.mDb.endTransaction();
            if (roomSQLiteQuery != null) {
                roomSQLiteQuery.release();
            }
            callback.onResult(listEmptyList, i, iCountItems);
        } catch (Throwable th2) {
            th = th2;
            sQLiteQuery = null;
        }
    }

    public void loadRange(PositionalDataSource.LoadRangeParams params, PositionalDataSource.LoadRangeCallback<T> callback) {
        callback.onResult(loadRange(params.startPosition, params.loadSize));
    }

    public List<T> loadRange(int startPosition, int loadCount) {
        RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(startPosition, loadCount);
        if (this.mInTransaction) {
            this.mDb.beginTransaction();
            Cursor cursorQuery = null;
            try {
                cursorQuery = this.mDb.query(sQLiteQuery);
                List<T> listConvertRows = convertRows(cursorQuery);
                this.mDb.setTransactionSuccessful();
                return listConvertRows;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                this.mDb.endTransaction();
                sQLiteQuery.release();
            }
        }
        Cursor cursorQuery2 = this.mDb.query(sQLiteQuery);
        try {
            return convertRows(cursorQuery2);
        } finally {
            cursorQuery2.close();
            sQLiteQuery.release();
        }
    }

    private RoomSQLiteQuery getSQLiteQuery(int startPosition, int loadCount) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        roomSQLiteQueryAcquire.copyArgumentsFrom(this.mSourceQuery);
        roomSQLiteQueryAcquire.bindLong(roomSQLiteQueryAcquire.getArgCount() - 1, loadCount);
        roomSQLiteQueryAcquire.bindLong(roomSQLiteQueryAcquire.getArgCount(), startPosition);
        return roomSQLiteQueryAcquire;
    }
}
