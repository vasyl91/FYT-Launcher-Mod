package com.syu.radio.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.data.FinalChip;
import com.lsec.core.util.db.DBHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Radio_FreqBk {
    public static final String FREQ = "freq";
    public static final String ID = "id";
    public static final String PATH = "path";
    private static final int version = 1;
    public SQLiteDatabase mDB;
    private DBHelper mHelper;

    public Radio_FreqBk(Context context) {
        this.mHelper = new DBHelper(context, "radio_freqbk.db", "create table Radio_FreqBk (id integer primary key autoincrement, freq integer, path varchar(512)) ", "drop table if exists Radio_FreqBk", 1);
        this.mDB = this.mHelper.getWritableDatabase();
    }

    public int queryFreq(String strFreq) {
        int id = 0;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDB.rawQuery("select id from Radio_FreqBk where freq like ? ", new String[]{"%" + IpcUtil.freqStr2Int(strFreq) + "%"});
                if (cursor.moveToNext()) {
                    id = cursor.getInt(cursor.getColumnIndex("id"));
                }
                if (cursor != null) {
                    cursor.close();
                    cursor = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public String queryFreqBk(String strFreq) {
        String strRet = FinalChip.BSP_PLATFORM_Null;
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDB.rawQuery("select id,freq,path from Radio_FreqBk where freq like ? ", new String[]{"%" + IpcUtil.freqStr2Int(strFreq) + "%"});
                if (cursor.moveToNext()) {
                    strRet = cursor.getString(2);
                }
                if (cursor != null) {
                    cursor.close();
                    cursor = null;
                }
            } finally {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return strRet;
    }

    public void add(String strFreq, String strBk) {
        int id = queryFreq(strFreq);
        if (id > 0) {
            this.mDB.execSQL("update Radio_FreqBk set freq = ?, path = ?, where id = ?", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(strFreq)), strBk, Integer.valueOf(id)});
        } else {
            this.mDB.execSQL("insert into Radio_FreqBk(freq, path) values(?, ?)", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(strFreq)), strBk});
        }
    }
}
