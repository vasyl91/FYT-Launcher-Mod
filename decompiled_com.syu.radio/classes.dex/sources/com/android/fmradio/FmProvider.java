package com.android.fmradio;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FmProvider extends ContentProvider {
    private static final String DATABASE_NAME = "FmRadio.db";
    private static final int DATABASE_VERSION = 1;
    private static final int STATION_FREQ = 1;
    private static final String TABLE_NAME = "StationList";
    private static final UriMatcher URI_MATCHER = new UriMatcher(-1);
    private SQLiteDatabase mSqlDb = null;
    private DatabaseHelper mDbHelper = null;

    static {
        URI_MATCHER.addURI(FmStation.AUTHORITY, FmStation.STATION, 1);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, FmProvider.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE StationList(_id INTEGER PRIMARY KEY AUTOINCREMENT,_index INTEGER UNIQUE,frequency INTEGER ,strength INTEGER DEFAULT 0);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS StationList");
            onCreate(db);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rows = 0;
        try {
            this.mSqlDb = this.mDbHelper.getWritableDatabase();
            switch (URI_MATCHER.match(uri)) {
                case 1:
                    rows = this.mSqlDb.delete(TABLE_NAME, selection, selectionArgs);
                    getContext().getContentResolver().notifyChange(uri, null);
                    break;
            }
            return rows;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        try {
            this.mSqlDb = this.mDbHelper.getWritableDatabase();
            ContentValues v = new ContentValues(values);
            long rowId = this.mSqlDb.insert(TABLE_NAME, null, v);
            Uri rowUri = ContentUris.appendId(FmStation.Station.CONTENT_URI.buildUpon(), rowId).build();
            getContext().getContentResolver().notifyChange(rowUri, null);
            return rowUri;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mDbHelper = new DatabaseHelper(getContext());
        return this.mDbHelper != null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        try {
            SQLiteDatabase db = this.mDbHelper.getReadableDatabase();
            qb.setTables(TABLE_NAME);
            Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
            if (c != null) {
                c.setNotificationUri(getContext().getContentResolver(), uri);
                return c;
            }
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int rows = 0;
        try {
            this.mSqlDb = this.mDbHelper.getWritableDatabase();
            switch (URI_MATCHER.match(uri)) {
                case 1:
                    rows = this.mSqlDb.update(TABLE_NAME, values, selection, selectionArgs);
                    getContext().getContentResolver().notifyChange(uri, null);
                    break;
            }
            return rows;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }
}
