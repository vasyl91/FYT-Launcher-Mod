package com.syu.radio.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.android.fmradio.FmUtils;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.data.FinalChip;
import com.lsec.core.util.db.DBHelper;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Radio_Info {
    public static final String AMFM = "amfm";
    public static final String AREA = "area";
    public static final String CITY = "city";
    public static final String FREQ = "freq";
    public static final String ID = "id";
    public static final String LOGO = "logo";
    public static final String NAME = "name";
    public static final String NET = "net";
    public static List<SparseArray<String>> mListInfo = new ArrayList();
    private static final int version = 2;
    public SQLiteDatabase mDB;
    private DBHelper mHelper;

    public Radio_Info(Context context) {
        if (App_Radio.bRuRadioName) {
            this.mHelper = new DBHelper(context, "radio.db", "create table RadioInfo (id integer primary key autoincrement, freq integer, area integer, name varchar(20), amfm varchar(20), net integer, city varchar(20), logo varchar(20)) ", "drop table if exists RadioInfo", 2);
        } else {
            this.mHelper = new DBHelper(context, "radio.db", "create table RadioInfo (id integer primary key autoincrement, freq integer, area integer, name varchar(20), amfm varchar(20), net integer, city varchar(20)) ", "drop table if exists RadioInfo", 2);
        }
        this.mDB = this.mHelper.getWritableDatabase();
    }

    public void beginTransaction() {
        this.mDB.beginTransaction();
    }

    public void endTransaction() {
        this.mDB.endTransaction();
    }

    public void setTransactionSuccessful() {
        this.mDB.setTransactionSuccessful();
    }

    public void add(SparseArray<String> map) {
        if (App_Radio.bRuRadioName) {
            this.mDB.execSQL("insert into RadioInfo(freq, area, name, amfm, net, city, logo) values(?, ?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(map.get(FinalRadioCtrl.Item_Txt_Freq))), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Area))), map.get(FinalRadioCtrl.Item_Txt_Name), map.get(FinalRadioCtrl.Item_Txt_Unit), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Net))), map.get(FinalRadioCtrl.Item_City), map.get(FinalRadioCtrl.Item_Logo)});
        } else {
            this.mDB.execSQL("insert into RadioInfo(freq, area, name, amfm, net, city) values(?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(map.get(FinalRadioCtrl.Item_Txt_Freq))), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Area))), map.get(FinalRadioCtrl.Item_Txt_Name), map.get(FinalRadioCtrl.Item_Txt_Unit), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Net))), map.get(FinalRadioCtrl.Item_City)});
        }
    }

    public void update(SparseArray<String> map) {
        int id = FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Index));
        if (queryNetAttr(id) != FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Net))) {
            add(map);
        } else if (App_Radio.bRuRadioName) {
            this.mDB.execSQL("update RadioInfo set freq = ?, area = ?, name = ?, amfm = ?, net = ?, city = ?, logo = ? where id = ?", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(map.get(FinalRadioCtrl.Item_Txt_Freq))), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Area))), map.get(FinalRadioCtrl.Item_Txt_Name), map.get(FinalRadioCtrl.Item_Txt_Unit), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Net))), map.get(FinalRadioCtrl.Item_City), map.get(FinalRadioCtrl.Item_Logo), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Index)))});
        } else {
            this.mDB.execSQL("update RadioInfo set freq = ?, area = ?, name = ?, amfm = ?, net = ?, city = ? where id = ?", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(map.get(FinalRadioCtrl.Item_Txt_Freq))), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Area))), map.get(FinalRadioCtrl.Item_Txt_Name), map.get(FinalRadioCtrl.Item_Txt_Unit), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Net))), map.get(FinalRadioCtrl.Item_City), Integer.valueOf(FuncUtils.myParseInt(map.get(FinalRadioCtrl.Item_Index)))});
        }
    }

    public void delete(Integer id) {
        this.mDB.execSQL("delete from RadioInfo where id = ?", new Object[]{id});
    }

    public void delete() {
        this.mDB.execSQL("delete from RadioInfo");
    }

    public void deleteFromNet() {
        this.mDB.execSQL("delete from RadioInfo where net = ?", new Object[]{1});
    }

    public List<SparseArray<String>> query(Integer area) throws Throwable {
        Cursor cursor = null;
        List<SparseArray<String>> infoList = null;
        if (FmUtils.mBand >= 1 && FmUtils.mBand <= 3) {
            Radio_IpcObj.mTextHZ = "MHz";
        } else if (FmUtils.mBand >= 4 && FmUtils.mBand <= 5) {
            Radio_IpcObj.mTextHZ = "kHz";
        }
        try {
            try {
                Log.d("loggg", " * 00 *Radio Info query area = " + area + " bRuRadioName = " + App_Radio.bRuRadioName);
                if (App_Radio.bRuRadioName) {
                    cursor = this.mDB.rawQuery("select id,freq,area,name,amfm,net,city,logo from RadioInfo where area = ? and amfm like ? order by cast(freq as int), net", new String[]{String.valueOf(area), Radio_IpcObj.mTextHZ});
                } else {
                    cursor = this.mDB.rawQuery("select id,freq,area,name,amfm,net,city from RadioInfo where area = ? and amfm like ? order by cast(freq as int), net", new String[]{String.valueOf(area), Radio_IpcObj.mTextHZ});
                }
                Log.d("loggg", " * 01 *Radio Info query cursor.getCount = " + cursor.getCount() + " App_Radio.mCity = " + App_Radio.mCity);
                if (cursor.moveToFirst()) {
                    List<SparseArray<String>> infoList2 = new ArrayList<>();
                    try {
                        Log.d("loggg", " * 02 *Radio Info query infoList mCity= " + App_Radio.mCity);
                        do {
                            String city = cursor.getString(6);
                            if (TextUtils.isEmpty(city) || city.equals(App_Radio.mCity)) {
                                boolean bAdd = true;
                                int iSize = infoList2.size();
                                int iNetAttr = cursor.getInt(5);
                                String strFreq = IpcUtil.int2freqStr(FuncUtils.myParseInt(cursor.getString(1)));
                                if (iSize > 0) {
                                    SparseArray<String> mapLast = infoList2.get(iSize - 1);
                                    String strFreqLast = mapLast.get(FinalRadioCtrl.Item_Txt_Freq);
                                    if (strFreqLast != null && strFreqLast.equals(strFreq)) {
                                        if (iNetAttr != 0) {
                                            bAdd = false;
                                        } else {
                                            infoList2.remove(iSize - 1);
                                        }
                                    }
                                }
                                Log.d("loggg", " * 04 *Radio Info query bAdd = " + bAdd + " App_Radio.mCity = " + App_Radio.mCity);
                                if (bAdd) {
                                    SparseArray<String> map = new SparseArray<>();
                                    map.put(FinalRadioCtrl.Item_Index, Integer.toString(cursor.getInt(cursor.getColumnIndex("id"))));
                                    map.put(FinalRadioCtrl.Item_Txt_Freq, strFreq);
                                    map.put(FinalRadioCtrl.Item_Area, Integer.toString(cursor.getInt(2)));
                                    map.put(FinalRadioCtrl.Item_Txt_Name, cursor.getString(3));
                                    map.put(FinalRadioCtrl.Item_Txt_Unit, cursor.getString(4));
                                    map.put(FinalRadioCtrl.Item_Net, Integer.toString(cursor.getInt(5)));
                                    map.put(FinalRadioCtrl.Item_City, city);
                                    if (App_Radio.bRuRadioName) {
                                        map.put(FinalRadioCtrl.Item_Logo, cursor.getString(7));
                                    }
                                    Log.d("loggg", " * 05 *Radio Info query bAdd = " + bAdd + " App_Radio.mCity = " + App_Radio.mCity);
                                    infoList2.add(map);
                                }
                            }
                        } while (cursor.moveToNext());
                        infoList = infoList2;
                    } catch (Exception e) {
                        e = e;
                        infoList = infoList2;
                        e.printStackTrace();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
            return infoList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int queryFreq(SparseArray<String> map) {
        int id = 0;
        Cursor cursor = null;
        try {
            cursor = this.mDB.rawQuery("select id from RadioInfo where freq like ? and area = ? and net = 0", new String[]{"%" + IpcUtil.freqStr2Int(map.get(FinalRadioCtrl.Item_Txt_Freq)) + "%", map.get(FinalRadioCtrl.Item_Area)});
            if (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
            }
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
            if (id == 0) {
                cursor = this.mDB.rawQuery("select id from RadioInfo where freq like ? and area = ? and city = ? and net = 1", new String[]{"%" + IpcUtil.freqStr2Int(map.get(FinalRadioCtrl.Item_Txt_Freq)) + "%", map.get(FinalRadioCtrl.Item_Area), App_Radio.mCity});
                if (cursor.moveToNext()) {
                    id = cursor.getInt(cursor.getColumnIndex("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return id;
    }

    public String queryFreq(String freq) {
        if (mListInfo == null) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        for (SparseArray<String> map : mListInfo) {
            if (map.get(FinalRadioCtrl.Item_Txt_Freq).equals(freq)) {
                String name = map.get(FinalRadioCtrl.Item_Txt_Name);
                return name;
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public String queryLogo(String freq) {
        if (mListInfo == null) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        for (SparseArray<String> map : mListInfo) {
            if (map.get(FinalRadioCtrl.Item_Txt_Freq).equals(freq)) {
                String name = map.get(FinalRadioCtrl.Item_Logo);
                return name;
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public int queryName(SparseArray<String> map) {
        int id = 0;
        Cursor cursor = null;
        try {
            cursor = this.mDB.rawQuery("select id from RadioInfo where name like ? and area = ? and net = 0", new String[]{map.get(FinalRadioCtrl.Item_Txt_Name), map.get(FinalRadioCtrl.Item_Area)});
            if (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
            }
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
            if (id == 0) {
                cursor = this.mDB.rawQuery("select id from RadioInfo where name like ? and area = ? and city = ? and net = 1", new String[]{map.get(FinalRadioCtrl.Item_Txt_Name), map.get(FinalRadioCtrl.Item_Area), App_Radio.mCity});
                if (cursor.moveToNext()) {
                    id = cursor.getInt(cursor.getColumnIndex("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return id;
    }

    public int queryNetAttr(int id) {
        int iNetAttr = 0;
        Cursor cursor = null;
        try {
            cursor = this.mDB.rawQuery("select net from RadioInfo where id = ? ", new String[]{String.valueOf(id)});
            if (cursor.moveToNext()) {
                iNetAttr = cursor.getInt(cursor.getColumnIndex(NET));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return iNetAttr;
    }
}
