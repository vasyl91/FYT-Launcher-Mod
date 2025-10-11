package com.fyt.skin;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.android.launcher66.LauncherApplication;
import com.fyt.skin.data.SkinPathDataSource;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SkinManager {
    private static SkinResources mSkinRes;
    private static LauncherApplication sApp;
    private String mPackageName;
    private Resources mResources;
    private SkinFactory mSkinFactory;
    private String property = "initial";
    private final PropertyChangeSupport mPropertyChangeSupport = new PropertyChangeSupport(this);

    public static LauncherApplication getContext() {
        return sApp;
    }

    public static void init(LauncherApplication application) {
        sApp = application;
        application.registerActivityLifecycleCallbacks(new SkinActivityLifecycleCallbacks());
        SkinPathDataSource.init(application);
        mSkinRes = new SkinResources(application);
    }

    boolean loadSkin(String path) {
        File file = new File(path);
        if (TextUtils.isEmpty(path) || !file.exists()) {
            return false;
        }
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
            method.setAccessible(true);
            method.invoke(assetManager, path);
            Resources resources = sApp.getResources();
            this.mResources = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            PackageManager mPm = sApp.getPackageManager();
            PackageInfo info = mPm.getPackageArchiveInfo(path, 1);
            this.mPackageName = info.packageName;
            mSkinRes.applySkin(this.mResources, this.mPackageName);
            String old = property;
            property = path;
            mPropertyChangeSupport.firePropertyChange("mProperty", old, path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    void clearSkin() {
        SkinPathDataSource.getInstance().saveSkinPath(null);
        mSkinRes.reset();
        this.mResources = sApp.getResources();
        this.mPackageName = sApp.getPackageName();
        String packageName = String.valueOf(this.mPackageName);
        String old = property;
        property = packageName;
        mPropertyChangeSupport.firePropertyChange("mProperty", old, packageName);
    }

    Resources getSkinRes(String path) {
        Resources resources = sApp.getResources();
        if (!TextUtils.isEmpty(path)) {
            try {
                AssetManager assetManager = AssetManager.class.newInstance();
                Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
                method.setAccessible(true);
                method.invoke(assetManager, path);
                Resources skinRes = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                return skinRes;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return resources;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return resources;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return resources;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return resources;
            }
        }
        return resources;
    }

    Resources getResources() {
        return this.mResources;
    }

    String getPackageName() {
        return this.mPackageName;
    }

    int getIdentifier(int id) {
        return mSkinRes.getIdentifier(id);
    }

    Drawable getDrawable(int resid) {
        return mSkinRes.getDrawable(resid);
    }

    Bitmap getBitmap(int resid) {
        return mSkinRes.getBitmap(resid);
    }

    SkinResources getSkinResources() {
        return mSkinRes;
    }

    SkinAttribute getSkinAttr() {
        return this.mSkinFactory.getSkinAttribute();
    }

    public static SkinManager getInstance() {
        return Holder.instance;
    }

    public void addObserver(PropertyChangeListener listener) {
        mPropertyChangeSupport.addPropertyChangeListener("mProperty", listener);
        if (listener instanceof SkinFactory) {
            this.mSkinFactory = (SkinFactory) listener;
        }
    }

    public void deleteObserver(PropertyChangeListener listener) {
        mPropertyChangeSupport.removePropertyChangeListener("mProperty", listener);
    }

    private SkinManager() {
    }

    SkinManager(SkinManager skinManager) {
        this();
    }

    private static class Holder {
        private static final SkinManager instance = new SkinManager(null);

        private Holder() {
        }
    }
}
