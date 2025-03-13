package com.fyt.skin.data;

import android.content.SharedPreferences;

import com.android.launcher66.Launcher;

public class SkinPathDataSource {
    private static final String KEY_SKIN_PATH = "skin-path";
    private static final String SKIN_SHARED = "skin-peeler-lib";
    private static Launcher mApplication;
    private final SharedPreferences mPref;

    public static void init(Launcher application) {
        mApplication = application;
    }

    public void saveSkinPath(String path) {
        this.mPref.edit().putString(KEY_SKIN_PATH, path).apply();
    }

    public String getSkinPath() {
        return this.mPref.getString(KEY_SKIN_PATH, null);
    }

    public static SkinPathDataSource getInstance() {
        return Holder.instance;
    }

    private SkinPathDataSource() {
        this.mPref = mApplication.getSharedPreferences(SKIN_SHARED, 0);
    }

    SkinPathDataSource(SkinPathDataSource skinPathDataSource) {
        this();
    }

    private static class Holder {
        private static final SkinPathDataSource instance = new SkinPathDataSource(null);

        private Holder() {
        }
    }
}
