package com.syu.media.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import chip.FinalChip;
import com.syu.media.dao.MediaDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/syu/media/database/MediaDatabase;", "Landroidx/room/RoomDatabase;", "()V", "mediaDao", "Lcom/syu/media/dao/MediaDao;", "Companion", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MediaDatabase extends RoomDatabase {
    public static MediaDatabase a;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final MediaDatabase$Companion$MIGRATE_1_2$1 b = new Migration() { // from class: com.syu.media.database.MediaDatabase$Companion$MIGRATE_1_2$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS PlaylistRadioCrossRef (playlist_id int NOT NULL, _id int NOT NULL, PRIMARY KEY (playlist_id, _id),CONSTRAINT list FOREIGN KEY (playlist_id) REFERENCES list(playlist_id) ON DELETE CASCADE ON UPDATE CASCADE,CONSTRAINT radio FOREIGN KEY (_id) REFERENCES radio(_id) ON DELETE CASCADE ON UPDATE CASCADE)");
        }
    };

    @Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004*\u0001\r\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/syu/media/database/MediaDatabase$Companion;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/database/MediaDatabase;", "requireDatabase", "Landroid/content/Context;", "context", "getDatabase", "instance", "Lcom/syu/media/database/MediaDatabase;", "getInstance", "()Lcom/syu/media/database/MediaDatabase;", "setInstance", "(Lcom/syu/media/database/MediaDatabase;)V", "com/syu/media/database/MediaDatabase$Companion$MIGRATE_1_2$1", "MIGRATE_1_2", "Lcom/syu/media/database/MediaDatabase$Companion$MIGRATE_1_2$1;", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaDatabase getDatabase(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            MediaDatabase companion = getInstance();
            if (companion == null) {
                synchronized (this) {
                    Companion companion2 = MediaDatabase.INSTANCE;
                    companion2.setInstance((MediaDatabase) Room.databaseBuilder(context, MediaDatabase.class, "media_database.db").addMigrations(MediaDatabase.b).build());
                    companion = companion2.getInstance();
                    Intrinsics.checkNotNull(companion);
                }
            }
            return companion;
        }

        public final MediaDatabase getInstance() {
            return MediaDatabase.a;
        }

        public final MediaDatabase requireDatabase() {
            if (getInstance() == null) {
                throw new IllegalStateException("MediaDatabase instance not be created!!");
            }
            MediaDatabase companion = getInstance();
            Intrinsics.checkNotNull(companion);
            return companion;
        }

        public final void setInstance(MediaDatabase mediaDatabase) {
            MediaDatabase.a = mediaDatabase;
        }
    }

    public abstract MediaDao mediaDao();
}
