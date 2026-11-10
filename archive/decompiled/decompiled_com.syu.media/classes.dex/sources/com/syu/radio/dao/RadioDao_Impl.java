package com.syu.radio.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.syu.radio.Radio;
import com.syu.radio.entities.RadioStation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class RadioDao_Impl extends RadioDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;

    public RadioDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new EntityInsertionAdapter<RadioStation>(roomDatabase) { // from class: com.syu.radio.dao.RadioDao_Impl.1
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RadioStation radioStation) {
                if (radioStation.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, radioStation.getId().intValue());
                }
                if (radioStation.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, radioStation.getTitle());
                }
                if (radioStation.getFreq() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, radioStation.getFreq().intValue());
                }
                if (radioStation.getCity() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, radioStation.getCity());
                }
                if (radioStation.getCover() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, radioStation.getCover());
                }
                if (radioStation.getUrl() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, radioStation.getUrl());
                }
                supportSQLiteStatement.bindLong(7, radioStation.getOnline() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, radioStation.getFavorite() ? 1L : 0L);
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `city_station` (`_id`,`title`,`freq`,`city`,`cover_path`,`url`,`online`,`favorite`) VALUES (?,?,?,?,?,?,?,?)";
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<RadioStation>(roomDatabase) { // from class: com.syu.radio.dao.RadioDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RadioStation radioStation) {
                if (radioStation.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, radioStation.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `city_station` WHERE `_id` = ?";
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<RadioStation>(roomDatabase) { // from class: com.syu.radio.dao.RadioDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RadioStation radioStation) {
                if (radioStation.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, radioStation.getId().intValue());
                }
                if (radioStation.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, radioStation.getTitle());
                }
                if (radioStation.getFreq() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, radioStation.getFreq().intValue());
                }
                if (radioStation.getCity() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, radioStation.getCity());
                }
                if (radioStation.getCover() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, radioStation.getCover());
                }
                if (radioStation.getUrl() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, radioStation.getUrl());
                }
                supportSQLiteStatement.bindLong(7, radioStation.getOnline() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, radioStation.getFavorite() ? 1L : 0L);
                if (radioStation.getId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, radioStation.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `city_station` SET `_id` = ?,`title` = ?,`freq` = ?,`city` = ?,`cover_path` = ?,`url` = ?,`online` = ?,`favorite` = ? WHERE `_id` = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.syu.radio.dao.RadioDao
    public void delete(RadioStation... radioStationArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(radioStationArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.radio.dao.RadioDao
    public RadioStation findStationByFreq(int i) {
        boolean z = true;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE freq = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.a.assertNotSuspendingTransaction();
        RadioStation radioStation = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            if (cursorQuery.moveToFirst()) {
                RadioStation radioStation2 = new RadioStation();
                radioStation2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                radioStation2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                radioStation2.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                radioStation2.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                radioStation2.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    string = cursorQuery.getString(columnIndexOrThrow6);
                }
                radioStation2.setUrl(string);
                radioStation2.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                    z = false;
                }
                radioStation2.setFavorite(z);
                radioStation = radioStation2;
            }
            return radioStation;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.radio.dao.RadioDao
    public RadioStation findStationByFreqAndCity(int i, String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE freq = ? AND (city LIKE ? || '%' Or city = 'DEF')", 2);
        long j = i;
        boolean z = true;
        roomSQLiteQueryAcquire.bindLong(1, j);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.a.assertNotSuspendingTransaction();
        RadioStation radioStation = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            if (cursorQuery.moveToFirst()) {
                RadioStation radioStation2 = new RadioStation();
                radioStation2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                radioStation2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                radioStation2.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                radioStation2.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                radioStation2.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    string = cursorQuery.getString(columnIndexOrThrow6);
                }
                radioStation2.setUrl(string);
                radioStation2.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                    z = false;
                }
                radioStation2.setFavorite(z);
                radioStation = radioStation2;
            }
            return radioStation;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.radio.dao.RadioDao
    public Flow<List<RadioStation>> getAllStations() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Radio.TABLE}, new Callable<List<RadioStation>>() { // from class: com.syu.radio.dao.RadioDao_Impl.4
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioStation> call() {
                Cursor cursorQuery = DBUtil.query(RadioDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioStation radioStation = new RadioStation();
                        radioStation.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        radioStation.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioStation.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        radioStation.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioStation.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioStation.setUrl(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        boolean z = true;
                        radioStation.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                        if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                            z = false;
                        }
                        radioStation.setFavorite(z);
                        arrayList.add(radioStation);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.radio.dao.RadioDao
    public RadioStation getExistsRadioStation(int i, String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE freq = ? AND city = ? LIMIT 1", 2);
        long j = i;
        boolean z = true;
        roomSQLiteQueryAcquire.bindLong(1, j);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.a.assertNotSuspendingTransaction();
        RadioStation radioStation = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            if (cursorQuery.moveToFirst()) {
                RadioStation radioStation2 = new RadioStation();
                radioStation2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                radioStation2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                radioStation2.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                radioStation2.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                radioStation2.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    string = cursorQuery.getString(columnIndexOrThrow6);
                }
                radioStation2.setUrl(string);
                radioStation2.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                    z = false;
                }
                radioStation2.setFavorite(z);
                radioStation = radioStation2;
            }
            return radioStation;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.radio.dao.RadioDao
    public Flow<List<RadioStation>> getFavorites() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE favorite = 1", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Radio.TABLE}, new Callable<List<RadioStation>>() { // from class: com.syu.radio.dao.RadioDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioStation> call() {
                Cursor cursorQuery = DBUtil.query(RadioDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioStation radioStation = new RadioStation();
                        radioStation.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        radioStation.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioStation.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        radioStation.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioStation.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioStation.setUrl(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        boolean z = true;
                        radioStation.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                        if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                            z = false;
                        }
                        radioStation.setFavorite(z);
                        arrayList.add(radioStation);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.radio.dao.RadioDao
    public Flow<List<RadioStation>> getFavoritesWithCity(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE favorite = 1  AND (city LIKE ? || '%' Or city = 'DEF')", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Radio.TABLE}, new Callable<List<RadioStation>>() { // from class: com.syu.radio.dao.RadioDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioStation> call() {
                Cursor cursorQuery = DBUtil.query(RadioDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioStation radioStation = new RadioStation();
                        radioStation.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        radioStation.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioStation.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        radioStation.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioStation.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioStation.setUrl(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        boolean z = true;
                        radioStation.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                        if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                            z = false;
                        }
                        radioStation.setFavorite(z);
                        arrayList.add(radioStation);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.radio.dao.RadioDao
    public List<RadioStation> getStationsByCity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE city LIKE ? || '%' Or city = 'DEF' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                RadioStation radioStation = new RadioStation();
                radioStation.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                radioStation.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                radioStation.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                radioStation.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                radioStation.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                radioStation.setUrl(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                radioStation.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                radioStation.setFavorite(cursorQuery.getInt(columnIndexOrThrow8) != 0);
                arrayList.add(radioStation);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.radio.dao.RadioDao
    public Flow<List<RadioStation>> getStationsByCityFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM city_station WHERE city LIKE ? || '%' Or city = 'DEF' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Radio.TABLE}, new Callable<List<RadioStation>>() { // from class: com.syu.radio.dao.RadioDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioStation> call() {
                Cursor cursorQuery = DBUtil.query(RadioDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.CITY);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.COVER);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.URL);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Radio.ONLINE);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioStation radioStation = new RadioStation();
                        radioStation.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        radioStation.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioStation.setFreq(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        radioStation.setCity(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioStation.setCover(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioStation.setUrl(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        boolean z = true;
                        radioStation.setOnline(cursorQuery.getInt(columnIndexOrThrow7) != 0);
                        if (cursorQuery.getInt(columnIndexOrThrow8) == 0) {
                            z = false;
                        }
                        radioStation.setFavorite(z);
                        arrayList.add(radioStation);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.radio.dao.RadioDao
    public void insert(RadioStation... radioStationArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((Object[]) radioStationArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.radio.dao.RadioDao
    public void update(RadioStation... radioStationArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.d.handleMultiple(radioStationArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
