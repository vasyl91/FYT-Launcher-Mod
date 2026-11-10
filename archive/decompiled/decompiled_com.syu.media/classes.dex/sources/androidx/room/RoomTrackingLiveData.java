package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class RoomTrackingLiveData<T> extends LiveData<T> {
    final Callable<T> mComputeFunction;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final InvalidationTracker.Observer mObserver;
    final AtomicBoolean mInvalid = new AtomicBoolean(true);
    final AtomicBoolean mComputing = new AtomicBoolean(false);
    final AtomicBoolean mRegisteredObserver = new AtomicBoolean(false);
    final Runnable mRefreshRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.1
        /* JADX WARN: Bottom block not found for handler: all -> 0x0053 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.mRegisteredObserver
                r1 = 0
                r2 = 1
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L1b
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                androidx.room.RoomDatabase r0 = r0.mDatabase
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.RoomTrackingLiveData r3 = androidx.room.RoomTrackingLiveData.this
                androidx.room.InvalidationTracker$Observer r3 = r3.mObserver
                r0.addWeakObserver(r3)
            L1b:
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.mComputing
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L5c
                r0 = 0
                r3 = r1
            L27:
                androidx.room.RoomTrackingLiveData r4 = androidx.room.RoomTrackingLiveData.this     // Catch: java.lang.Throwable -> L53
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.mInvalid     // Catch: java.lang.Throwable -> L53
                boolean r4 = r4.compareAndSet(r2, r1)     // Catch: java.lang.Throwable -> L53
                if (r4 == 0) goto L44
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L53
                java.util.concurrent.Callable<T> r0 = r0.mComputeFunction     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L53
                java.lang.Object r0 = r0.call()     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L53
                r3 = r2
                goto L27
            L3b:
                r0 = move-exception
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L53
                java.lang.String r3 = "Exception while computing database live data."
                r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L53
                throw r2     // Catch: java.lang.Throwable -> L53
            L44:
                if (r3 == 0) goto L4b
                androidx.room.RoomTrackingLiveData r4 = androidx.room.RoomTrackingLiveData.this     // Catch: java.lang.Throwable -> L53
                androidx.room.RoomTrackingLiveData.access$000(r4, r0)     // Catch: java.lang.Throwable -> L53
            L4b:
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.mComputing
                r0.set(r1)
                goto L5d
            L53:
                r0 = move-exception
                androidx.room.RoomTrackingLiveData r2 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.mComputing
                r2.set(r1)
                throw r0
            L5c:
                r3 = r1
            L5d:
                if (r3 == 0) goto L69
                androidx.room.RoomTrackingLiveData r0 = androidx.room.RoomTrackingLiveData.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.mInvalid
                boolean r0 = r0.get()
                if (r0 != 0) goto L1b
            L69:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.AnonymousClass1.run():void");
        }
    };
    final Runnable mInvalidationRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.2
        @Override // java.lang.Runnable
        public void run() {
            boolean zHasActiveObservers = RoomTrackingLiveData.this.hasActiveObservers();
            if (RoomTrackingLiveData.this.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
                RoomTrackingLiveData.this.getQueryExecutor().execute(RoomTrackingLiveData.this.mRefreshRunnable);
            }
        }
    };

    RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean inTransaction, Callable<T> computeFunction, String[] tableNames) {
        this.mDatabase = database;
        this.mInTransaction = inTransaction;
        this.mComputeFunction = computeFunction;
        this.mContainer = container;
        this.mObserver = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData.3
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(Set<String> tables) {
                ArchTaskExecutor.getInstance().executeOnMainThread(RoomTrackingLiveData.this.mInvalidationRunnable);
            }
        };
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }

    Executor getQueryExecutor() {
        if (this.mInTransaction) {
            return this.mDatabase.getTransactionExecutor();
        }
        return this.mDatabase.getQueryExecutor();
    }
}
