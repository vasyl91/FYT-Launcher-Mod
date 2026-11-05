package com.lsec.core.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DBHelper extends SQLiteOpenHelper {
    String mStrSqlCreate;
    String mStrSqlDrop;

    public DBHelper(Context context, String name, String strCreate, String strDrop, int version) {
        super(context, name, (SQLiteDatabase.CursorFactory) null, version);
        this.mStrSqlCreate = strCreate;
        this.mStrSqlDrop = strDrop;
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.mStrSqlCreate);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(this.mStrSqlDrop);
        onCreate(db);
    }
}
