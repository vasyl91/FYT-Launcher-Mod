package com.fyt.skin.data;

import android.app.Application;
import android.content.SharedPreferences;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class SkinPathDataSource {
    private static final String KEY_SKIN_PATH = "skin-path";
    private static final String SKIN_SHARED = "skin-peeler-lib";
    private static Application mApplication;
    private final SharedPreferences mPref;

    public static void init(Application application) {
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

    /* synthetic */ SkinPathDataSource(SkinPathDataSource skinPathDataSource) {
        this();
    }

    private static class Holder {
        private static SkinPathDataSource instance = new SkinPathDataSource(null);

        private Holder() {
        }
    }
}
