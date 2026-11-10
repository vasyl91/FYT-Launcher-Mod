package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final AutoCloser mAutoCloser;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory factory, AutoCloser autoCloser) {
        this.mDelegate = factory;
        this.mAutoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new AutoClosingRoomOpenHelper(this.mDelegate.create(configuration), this.mAutoCloser);
    }
}
