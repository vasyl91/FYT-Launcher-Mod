package com.syu.radio.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.syu.radio.Radio;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.dao.RadioDao_Impl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioDatabase_Impl extends RadioDatabase {
    public volatile RadioDao_Impl b;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        try {
            beginTransaction();
            writableDatabase.execSQL("DELETE FROM `city_station`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), Radio.TABLE);
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate() { // from class: com.syu.radio.database.RadioDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `city_station` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT, `freq` INTEGER, `city` TEXT NOT NULL, `cover_path` TEXT, `url` TEXT, `online` INTEGER NOT NULL, `favorite` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1262ee1a71091bbf42ccbba1288249f8')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `city_station`");
                if (((RoomDatabase) RadioDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RadioDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RadioDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) RadioDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RadioDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RadioDatabase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) RadioDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                RadioDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) RadioDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RadioDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RadioDatabase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
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
                HashMap map = new HashMap(8);
                map.put("_id", new TableInfo.Column("_id", "INTEGER", false, 1, null, 1));
                map.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map.put("freq", new TableInfo.Column("freq", "INTEGER", false, 0, null, 1));
                map.put(Radio.CITY, new TableInfo.Column(Radio.CITY, "TEXT", true, 0, null, 1));
                map.put(Radio.COVER, new TableInfo.Column(Radio.COVER, "TEXT", false, 0, null, 1));
                map.put(Radio.URL, new TableInfo.Column(Radio.URL, "TEXT", false, 0, null, 1));
                map.put(Radio.ONLINE, new TableInfo.Column(Radio.ONLINE, "INTEGER", true, 0, null, 1));
                map.put("favorite", new TableInfo.Column("favorite", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo(Radio.TABLE, map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, Radio.TABLE);
                return !tableInfo.equals(tableInfo2) ? new RoomOpenHelper.ValidationResult(false, "city_station(com.syu.radio.entities.RadioStation).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2) : new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "1262ee1a71091bbf42ccbba1288249f8", "44d3e4c6c5cdd9d6929358edbce884a3")).build());
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(RadioDao.class, RadioDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // com.syu.radio.database.RadioDatabase
    public RadioDao radioDao() {
        RadioDao_Impl radioDao_Impl;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = new RadioDao_Impl(this);
            }
            radioDao_Impl = this.b;
        }
        return radioDao_Impl;
    }
}
