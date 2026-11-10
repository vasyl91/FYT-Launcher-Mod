package com.syu.media.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.syu.media.dao.MediaDao;
import com.syu.media.dao.MediaDao_Impl;
import com.syu.media.provider.Media;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MediaDatabase_Impl extends MediaDatabase {
    public volatile MediaDao_Impl c;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        try {
            beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `song`");
            writableDatabase.execSQL("DELETE FROM `video`");
            writableDatabase.execSQL("DELETE FROM `radio`");
            writableDatabase.execSQL("DELETE FROM `list`");
            writableDatabase.execSQL("DELETE FROM `PlaylistAudioCrossRef`");
            writableDatabase.execSQL("DELETE FROM `PlaylistVideoCrossRef`");
            writableDatabase.execSQL("DELETE FROM `PlaylistRadioCrossRef`");
            setTransactionSuccessful();
        } finally {
            endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), Media.SONG_TABLE, Media.VIDEO_TABLE, Media.ONLINE_TABLE, Media.LIST_TABLE, "PlaylistAudioCrossRef", "PlaylistVideoCrossRef", "PlaylistRadioCrossRef");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate() { // from class: com.syu.media.database.MediaDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `song` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT, `displayName` TEXT, `artist` TEXT, `album` TEXT, `path` TEXT NOT NULL, `folder` TEXT NOT NULL, `duration` INTEGER NOT NULL, `favorite` INTEGER NOT NULL, `length` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_song_path` ON `song` (`path`)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_song__id` ON `song` (`_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `video` (`width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT, `displayName` TEXT, `artist` TEXT, `album` TEXT, `path` TEXT NOT NULL, `folder` TEXT NOT NULL, `duration` INTEGER NOT NULL, `favorite` INTEGER NOT NULL, `length` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_video_path` ON `video` (`path`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `radio` (`type` TEXT NOT NULL, `country` TEXT NOT NULL, `local` TEXT NOT NULL, `freq` TEXT NOT NULL, `icon` TEXT NOT NULL, `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT, `displayName` TEXT, `artist` TEXT, `album` TEXT, `path` TEXT NOT NULL, `folder` TEXT NOT NULL, `duration` INTEGER NOT NULL, `favorite` INTEGER NOT NULL, `length` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_radio_path` ON `radio` (`path`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `list` (`playlist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playlist_title` TEXT NOT NULL, `playlist_favorite` INTEGER NOT NULL, `playlist_creation` INTEGER NOT NULL, `playlist_playing_index` INTEGER NOT NULL, `playlist_update` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_list_playlist_title` ON `list` (`playlist_title`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PlaylistAudioCrossRef` (`playlist_id` INTEGER NOT NULL, `_id` INTEGER NOT NULL, PRIMARY KEY(`playlist_id`, `_id`), FOREIGN KEY(`playlist_id`) REFERENCES `list`(`playlist_id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`_id`) REFERENCES `song`(`_id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_PlaylistAudioCrossRef__id` ON `PlaylistAudioCrossRef` (`_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PlaylistVideoCrossRef` (`playlist_id` INTEGER NOT NULL, `_id` INTEGER NOT NULL, PRIMARY KEY(`playlist_id`, `_id`), FOREIGN KEY(`playlist_id`) REFERENCES `list`(`playlist_id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`_id`) REFERENCES `video`(`_id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_PlaylistVideoCrossRef__id` ON `PlaylistVideoCrossRef` (`_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PlaylistRadioCrossRef` (`playlist_id` INTEGER NOT NULL, `_id` INTEGER NOT NULL, PRIMARY KEY(`playlist_id`, `_id`), FOREIGN KEY(`playlist_id`) REFERENCES `list`(`playlist_id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`_id`) REFERENCES `radio`(`_id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_PlaylistRadioCrossRef__id` ON `PlaylistRadioCrossRef` (`_id`)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e771f737653f44e9835945876e54dab1')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `song`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `video`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `radio`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `list`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PlaylistAudioCrossRef`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PlaylistVideoCrossRef`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PlaylistRadioCrossRef`");
                if (((RoomDatabase) MediaDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) MediaDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) MediaDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) MediaDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) MediaDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) MediaDatabase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) MediaDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                MediaDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) MediaDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) MediaDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) MediaDatabase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(10);
                map.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map.put(Media.DISPLAY_NAME, new TableInfo.Column(Media.DISPLAY_NAME, "TEXT", false, 0, null, 1));
                map.put(Media.ARTIST, new TableInfo.Column(Media.ARTIST, "TEXT", false, 0, null, 1));
                map.put(Media.ALBUM, new TableInfo.Column(Media.ALBUM, "TEXT", false, 0, null, 1));
                map.put(Media.PATH, new TableInfo.Column(Media.PATH, "TEXT", true, 0, null, 1));
                map.put(Media.FOLDER, new TableInfo.Column(Media.FOLDER, "TEXT", true, 0, null, 1));
                map.put(Media.DURATION, new TableInfo.Column(Media.DURATION, "INTEGER", true, 0, null, 1));
                map.put("favorite", new TableInfo.Column("favorite", "INTEGER", true, 0, null, 1));
                map.put(Media.LENGTH, new TableInfo.Column(Media.LENGTH, "INTEGER", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_song_path", true, Arrays.asList(Media.PATH)));
                hashSet2.add(new TableInfo.Index("index_song__id", true, Arrays.asList("_id")));
                TableInfo tableInfo = new TableInfo(Media.SONG_TABLE, map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, Media.SONG_TABLE);
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "song(com.syu.media.entities.AudioSource).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(12);
                map2.put(Media.VIDEO_WIDTH, new TableInfo.Column(Media.VIDEO_WIDTH, "INTEGER", true, 0, null, 1));
                map2.put(Media.VIDEO_HEIGHT, new TableInfo.Column(Media.VIDEO_HEIGHT, "INTEGER", true, 0, null, 1));
                map2.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map2.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map2.put(Media.DISPLAY_NAME, new TableInfo.Column(Media.DISPLAY_NAME, "TEXT", false, 0, null, 1));
                map2.put(Media.ARTIST, new TableInfo.Column(Media.ARTIST, "TEXT", false, 0, null, 1));
                map2.put(Media.ALBUM, new TableInfo.Column(Media.ALBUM, "TEXT", false, 0, null, 1));
                map2.put(Media.PATH, new TableInfo.Column(Media.PATH, "TEXT", true, 0, null, 1));
                map2.put(Media.FOLDER, new TableInfo.Column(Media.FOLDER, "TEXT", true, 0, null, 1));
                map2.put(Media.DURATION, new TableInfo.Column(Media.DURATION, "INTEGER", true, 0, null, 1));
                map2.put("favorite", new TableInfo.Column("favorite", "INTEGER", true, 0, null, 1));
                map2.put(Media.LENGTH, new TableInfo.Column(Media.LENGTH, "INTEGER", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_video_path", true, Arrays.asList(Media.PATH)));
                TableInfo tableInfo3 = new TableInfo(Media.VIDEO_TABLE, map2, hashSet3, hashSet4);
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, Media.VIDEO_TABLE);
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "video(com.syu.media.entities.VideoSource).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(15);
                map3.put(Media.TYPE, new TableInfo.Column(Media.TYPE, "TEXT", true, 0, null, 1));
                map3.put(Media.COUNTRY, new TableInfo.Column(Media.COUNTRY, "TEXT", true, 0, null, 1));
                map3.put(Media.LOCAL, new TableInfo.Column(Media.LOCAL, "TEXT", true, 0, null, 1));
                map3.put("freq", new TableInfo.Column("freq", "TEXT", true, 0, null, 1));
                map3.put(Media.ICON, new TableInfo.Column(Media.ICON, "TEXT", true, 0, null, 1));
                map3.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map3.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map3.put(Media.DISPLAY_NAME, new TableInfo.Column(Media.DISPLAY_NAME, "TEXT", false, 0, null, 1));
                map3.put(Media.ARTIST, new TableInfo.Column(Media.ARTIST, "TEXT", false, 0, null, 1));
                map3.put(Media.ALBUM, new TableInfo.Column(Media.ALBUM, "TEXT", false, 0, null, 1));
                map3.put(Media.PATH, new TableInfo.Column(Media.PATH, "TEXT", true, 0, null, 1));
                map3.put(Media.FOLDER, new TableInfo.Column(Media.FOLDER, "TEXT", true, 0, null, 1));
                map3.put(Media.DURATION, new TableInfo.Column(Media.DURATION, "INTEGER", true, 0, null, 1));
                map3.put("favorite", new TableInfo.Column("favorite", "INTEGER", true, 0, null, 1));
                map3.put(Media.LENGTH, new TableInfo.Column(Media.LENGTH, "INTEGER", true, 0, null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_radio_path", true, Arrays.asList(Media.PATH)));
                TableInfo tableInfo5 = new TableInfo(Media.ONLINE_TABLE, map3, hashSet5, hashSet6);
                TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, Media.ONLINE_TABLE);
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "radio(com.syu.media.entities.RadioSource).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(6);
                map4.put("playlist_id", new TableInfo.Column("playlist_id", "INTEGER", true, 1, null, 1));
                map4.put("playlist_title", new TableInfo.Column("playlist_title", "TEXT", true, 0, null, 1));
                map4.put("playlist_favorite", new TableInfo.Column("playlist_favorite", "INTEGER", true, 0, null, 1));
                map4.put("playlist_creation", new TableInfo.Column("playlist_creation", "INTEGER", true, 0, null, 1));
                map4.put("playlist_playing_index", new TableInfo.Column("playlist_playing_index", "INTEGER", true, 0, null, 1));
                map4.put("playlist_update", new TableInfo.Column("playlist_update", "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.Index("index_list_playlist_title", true, Arrays.asList("playlist_title")));
                TableInfo tableInfo7 = new TableInfo(Media.LIST_TABLE, map4, hashSet7, hashSet8);
                TableInfo tableInfo8 = TableInfo.read(supportSQLiteDatabase, Media.LIST_TABLE);
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "list(com.syu.media.entities.PlayList).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(2);
                map5.put("playlist_id", new TableInfo.Column("playlist_id", "INTEGER", true, 1, null, 1));
                map5.put("_id", new TableInfo.Column("_id", "INTEGER", true, 2, null, 1));
                HashSet hashSet9 = new HashSet(2);
                hashSet9.add(new TableInfo.ForeignKey(Media.LIST_TABLE, "CASCADE", "CASCADE", Arrays.asList("playlist_id"), Arrays.asList("playlist_id")));
                hashSet9.add(new TableInfo.ForeignKey(Media.SONG_TABLE, "CASCADE", "CASCADE", Arrays.asList("_id"), Arrays.asList("_id")));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.Index("index_PlaylistAudioCrossRef__id", false, Arrays.asList("_id")));
                TableInfo tableInfo9 = new TableInfo("PlaylistAudioCrossRef", map5, hashSet9, hashSet10);
                TableInfo tableInfo10 = TableInfo.read(supportSQLiteDatabase, "PlaylistAudioCrossRef");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "PlaylistAudioCrossRef(com.syu.media.entities.PlaylistAudioCrossRef).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(2);
                map6.put("playlist_id", new TableInfo.Column("playlist_id", "INTEGER", true, 1, null, 1));
                map6.put("_id", new TableInfo.Column("_id", "INTEGER", true, 2, null, 1));
                HashSet hashSet11 = new HashSet(2);
                hashSet11.add(new TableInfo.ForeignKey(Media.LIST_TABLE, "CASCADE", "CASCADE", Arrays.asList("playlist_id"), Arrays.asList("playlist_id")));
                hashSet11.add(new TableInfo.ForeignKey(Media.VIDEO_TABLE, "CASCADE", "CASCADE", Arrays.asList("_id"), Arrays.asList("_id")));
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new TableInfo.Index("index_PlaylistVideoCrossRef__id", false, Arrays.asList("_id")));
                TableInfo tableInfo11 = new TableInfo("PlaylistVideoCrossRef", map6, hashSet11, hashSet12);
                TableInfo tableInfo12 = TableInfo.read(supportSQLiteDatabase, "PlaylistVideoCrossRef");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "PlaylistVideoCrossRef(com.syu.media.entities.PlaylistVideoCrossRef).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(2);
                map7.put("playlist_id", new TableInfo.Column("playlist_id", "INTEGER", true, 1, null, 1));
                map7.put("_id", new TableInfo.Column("_id", "INTEGER", true, 2, null, 1));
                HashSet hashSet13 = new HashSet(2);
                hashSet13.add(new TableInfo.ForeignKey(Media.LIST_TABLE, "CASCADE", "CASCADE", Arrays.asList("playlist_id"), Arrays.asList("playlist_id")));
                hashSet13.add(new TableInfo.ForeignKey(Media.ONLINE_TABLE, "CASCADE", "CASCADE", Arrays.asList("_id"), Arrays.asList("_id")));
                HashSet hashSet14 = new HashSet(1);
                hashSet14.add(new TableInfo.Index("index_PlaylistRadioCrossRef__id", false, Arrays.asList("_id")));
                TableInfo tableInfo13 = new TableInfo("PlaylistRadioCrossRef", map7, hashSet13, hashSet14);
                TableInfo tableInfo14 = TableInfo.read(supportSQLiteDatabase, "PlaylistRadioCrossRef");
                return !tableInfo13.equals(tableInfo14) ? new RoomOpenHelper.ValidationResult(false, "PlaylistRadioCrossRef(com.syu.media.entities.PlaylistRadioCrossRef).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14) : new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "e771f737653f44e9835945876e54dab1", "92a24f3babd4d357fcdb32c1b90b5876")).build());
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(MediaDao.class, MediaDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // com.syu.media.database.MediaDatabase
    public MediaDao mediaDao() {
        MediaDao_Impl mediaDao_Impl;
        if (this.c != null) {
            return this.c;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new MediaDao_Impl(this);
            }
            mediaDao_Impl = this.c;
        }
        return mediaDao_Impl;
    }
}
