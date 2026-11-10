package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface AutoMigrationCallback {
    default void onPostMigrate(SupportSQLiteDatabase db) {
    }
}
