package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    InvalidationLiveDataContainer(RoomDatabase database) {
        this.mDatabase = database;
    }

    <T> LiveData<T> create(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        return new RoomTrackingLiveData(this.mDatabase, this, inTransaction, computeFunction, tableNames);
    }

    void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
