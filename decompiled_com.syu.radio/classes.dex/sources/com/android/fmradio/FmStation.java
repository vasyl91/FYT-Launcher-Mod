package com.android.fmradio;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.BaseColumns;
import com.lsec.core.frame.app.MyApplication;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FmStation {
    public static final String AUTHORITY = "com.syu.radio";
    public static final String[] COLUMNS = {"_id", Station.INDEX, Station.FREQUENCY, Station.STRENGTH};
    public static final String CURRENT_AmSensitivity = "current_amsens";
    public static final String CURRENT_AutoSens = "current_autosens";
    public static final String CURRENT_BAND = "current_band";
    public static final String CURRENT_Context = "current_context";
    public static final String CURRENT_FmSensitivity = "current_fmsens";
    public static final String CURRENT_ForceMono = "current_forcemono";
    public static final String CURRENT_IndexRadio = "current_index";
    public static final String CURRENT_Loc = "current_loc";
    public static final String CURRENT_LongClickType = "current_longclick";
    public static final String CURRENT_RdsEnable = "current_rdsenable";
    public static final String CURRENT_STATION = "curent_station";
    public static final String STATION = "station";

    public static final class Station implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.syu.radio/station");
        public static final String FREQUENCY = "frequency";
        public static final String INDEX = "_index";
        public static final String STRENGTH = "strength";
    }

    public static int getCurrentStation() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        int currentStation = prefs.getInt(CURRENT_STATION, FmUtils.getDefaultStation());
        if (FmUtils.isValidStation(currentStation)) {
            return currentStation;
        }
        int station = currentStation * 10;
        if (!FmUtils.isValidStation(station)) {
            station = FmUtils.getDefaultStation();
        }
        saveCurrentStation(station);
        return station;
    }

    public static void saveCurrentStation(int station) {
        FmUtils.mCurStation = station;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_STATION, FmUtils.mCurStation);
        editor.commit();
    }

    public static int getCurrentBand() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        int currentStation = prefs.getInt(CURRENT_BAND, 1);
        return currentStation;
    }

    public static void saveCurrentBand() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_BAND, FmUtils.mBand);
        editor.commit();
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    public static int getCurrentForceMono() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        int currentStation = prefs.getInt(CURRENT_ForceMono, 0);
        return currentStation;
    }

    public static void setCurrentForceMono(int forcemono) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_ForceMono, forcemono);
        editor.commit();
    }

    public static int getCurrentIndexRadio(int band) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        int currentStation = prefs.getInt(CURRENT_IndexRadio + band, 0);
        return currentStation;
    }

    public static void setCurrentIndexRadio(int band, int indexRadio) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_IndexRadio + band, indexRadio);
        editor.commit();
    }

    public static boolean getLoc() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        boolean bLoc = prefs.getBoolean(CURRENT_Loc, false);
        return bLoc;
    }

    public static void setLoc(boolean bLoc) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(CURRENT_Loc, bLoc);
        editor.commit();
    }

    public static boolean getAutoSenstivity() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        boolean bAutoSens = prefs.getBoolean(CURRENT_AutoSens, true);
        return bAutoSens;
    }

    public static void setAutoSenstivity(boolean bAutoSens) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(CURRENT_AutoSens, bAutoSens);
        editor.commit();
    }

    public static int getFmSensitivity() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        int sens = prefs.getInt(CURRENT_FmSensitivity, FmUtils.getDefaultFmSens());
        return sens;
    }

    public static void setFmSensitivity(int fmSens) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_FmSensitivity, fmSens);
        editor.commit();
    }

    public static int getAmSensitivity() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        int sens = prefs.getInt(CURRENT_AmSensitivity, FmUtils.getDefaultAmSens());
        return sens;
    }

    public static void setAmSensitivity(int amSens) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(CURRENT_AmSensitivity, amSens);
        editor.commit();
    }

    public static boolean getLongClick() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        boolean bLongClick = prefs.getBoolean(CURRENT_LongClickType, true);
        return bLongClick;
    }

    public static void setLongClick(boolean bLongClick) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyApplication.myApp);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(CURRENT_LongClickType, bLongClick);
        editor.commit();
    }

    public static void insertStationToDb(int index, FmChannel fmChannel) {
        ContentValues values = new ContentValues(3);
        values.put(Station.INDEX, Integer.valueOf(index));
        values.put(Station.FREQUENCY, Integer.valueOf(fmChannel.station));
        values.put(Station.STRENGTH, Integer.valueOf(fmChannel.strength));
        MyApplication.myApp.getContentResolver().insert(Station.CONTENT_URI, values);
    }

    public static int updateStationToDb(int index, int station) {
        ContentValues values = new ContentValues(1);
        values.put(Station.FREQUENCY, Integer.valueOf(station));
        return MyApplication.myApp.getContentResolver().update(Station.CONTENT_URI, values, "_index=?", new String[]{String.valueOf(index)});
    }

    public static void cleanAllStations() {
        MyApplication.myApp.getContentResolver().delete(Station.CONTENT_URI, null, null);
    }
}
