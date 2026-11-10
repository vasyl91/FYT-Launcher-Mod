package com.lsec.core.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.lsec.core.util.data.FinalChip;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MySharePreference2 {
    private SharedPreferences mSp;
    private String mStrPath;

    public void init(Context context, String name) {
        this.mSp = context.getSharedPreferences(name, 0);
        this.mStrPath = "/data/data/" + context.getPackageName() + "/shared_prefs/" + name + ".xml";
    }

    public int getIntValue(String tag, int defaultValue) {
        if (this.mSp != null) {
            return this.mSp.getInt(tag, defaultValue);
        }
        return defaultValue;
    }

    public boolean getBooleanValue(String tag, boolean defaultValue) {
        if (this.mSp != null) {
            return this.mSp.getBoolean(tag, defaultValue);
        }
        return defaultValue;
    }

    public String getStringValue(String tag) {
        return this.mSp != null ? this.mSp.getString(tag, FinalChip.BSP_PLATFORM_Null) : FinalChip.BSP_PLATFORM_Null;
    }

    public Set<String> getStringSet(String key, Set<String> defValues) {
        if (this.mSp != null) {
            return this.mSp.getStringSet(key, defValues);
        }
        return defValues;
    }

    public void saveStringSet(String key, Set<String> value) throws Throwable {
        if (this.mSp != null) {
            SharedPreferences.Editor editor = this.mSp.edit();
            editor.putStringSet(key, value);
            commit(editor);
        }
    }

    public void saveIntValue(String tag, int value) throws Throwable {
        if (getIntValue(tag, value + 1) != value && this.mSp != null) {
            SharedPreferences.Editor editor = this.mSp.edit();
            editor.putInt(tag, value);
            commit(editor);
        }
    }

    public void saveBooleanValue(String tag, boolean value) throws Throwable {
        if (getBooleanValue(tag, !value) != value && this.mSp != null) {
            SharedPreferences.Editor editor = this.mSp.edit();
            editor.putBoolean(tag, value);
            commit(editor);
        }
    }

    public void saveStringValue(String tag, String msg) throws Throwable {
        if (getStringValue(tag) != msg && this.mSp != null) {
            SharedPreferences.Editor editor = this.mSp.edit();
            editor.putString(tag, msg);
            commit(editor);
        }
    }

    public void sync() throws Throwable {
        if (Build.VERSION.SDK_INT < 24) {
            File file = new File(this.mStrPath);
            FileInputStream fis = null;
            try {
                try {
                    FileInputStream fis2 = new FileInputStream(file);
                    try {
                        fis2.getFD().sync();
                        if (fis2 != null) {
                            try {
                                fis2.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fis = fis2;
                        e.printStackTrace();
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fis = fis2;
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void commit(SharedPreferences.Editor editor) throws Throwable {
        if (editor != null) {
            editor.commit();
            sync();
        }
    }

    public void clear() throws Throwable {
        if (this.mSp != null) {
            SharedPreferences.Editor editor = this.mSp.edit();
            editor.clear();
            commit(editor);
        }
    }
}
