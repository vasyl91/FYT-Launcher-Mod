package com.fyt.skin;

import static com.fyt.skin.SkinUtils.getResources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.content.ContextCompat;

public class SkinResources {
    private final Resources appResources;
    protected boolean isDefaultSkin = true;
    private final Context mContext;
    private String mSkinPkgName;
    private Resources skinResources;

    protected SkinResources(Context context) {
        this.mContext = context;
        this.appResources = context.getResources();
    }

    public void applySkin(Resources resources, String pkgName) {
        this.skinResources = resources;
        this.mSkinPkgName = pkgName;
        this.isDefaultSkin = TextUtils.isEmpty(pkgName) || resources == null;
    }

    public int getIdentifier(int resid) {
        if (!this.isDefaultSkin) {
            String resName = this.appResources.getResourceEntryName(resid);
            String resType = this.appResources.getResourceTypeName(resid);
            return this.skinResources.getIdentifier(resName, resType, this.mSkinPkgName);
        }
        return resid;
    }

    public void reset() {
        this.mSkinPkgName = "";
        this.skinResources = null;
        this.isDefaultSkin = true;
    }

    public int getColor(int resid) {
        if (this.isDefaultSkin) {
            return ContextCompat.getColor(mContext, resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return ContextCompat.getColor(mContext, resid);
        }
        return ContextCompat.getColor(mContext, skinid);
    }

    public ColorStateList getColorStateList(int resid) {
        if (this.isDefaultSkin) {
            return mContext.getColorStateList(resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return mContext.getColorStateList(resid);
        }
        return mContext.getColorStateList(skinid);
    }

    public Drawable getDrawable(int resid) {
        if (this.isDefaultSkin) {
            return ContextCompat.getDrawable(mContext, resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return ContextCompat.getDrawable(mContext, resid);
        }
        String r = getResources().getResourceEntryName(resid);
        Log.i("inf", r);
        return ContextCompat.getDrawable(mContext, skinid);
    }

    public Bitmap getBitmap(int resid) {
        if (this.isDefaultSkin) {
            return BitmapFactory.decodeResource(this.appResources, resid);
        }
        int skinid = getIdentifier(resid);
        if (skinid == 0) {
            return BitmapFactory.decodeResource(this.appResources, resid);
        }
        return BitmapFactory.decodeResource(this.skinResources, skinid);
    }

    public Object getBackground(int resid) {
        String resourceTypeName = this.appResources.getResourceTypeName(resid);
        return resourceTypeName.equals("color") ? Integer.valueOf(getColor(resid)) : getDrawable(resid);
    }

    public String getString(int resid) {
        String string;
        try {
            if (this.isDefaultSkin) {
                string = this.appResources.getString(resid);
            } else {
                int skinid = getIdentifier(resid);
                if (skinid == 0) {
                    string = this.appResources.getString(skinid);
                } else {
                    string = this.skinResources.getString(skinid);
                }
            }
            return string;
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    public boolean isDefaultRes() {
        return this.isDefaultSkin;
    }

    public Typeface getTypeface(int resid) {
        Typeface createFromAsset;
        String skinTypefacePath = getString(resid);
        if (TextUtils.isEmpty(skinTypefacePath)) {
            return Typeface.DEFAULT;
        }
        try {
            if (this.isDefaultSkin) {
                createFromAsset = Typeface.createFromAsset(this.appResources.getAssets(), skinTypefacePath);
            } else {
                createFromAsset = Typeface.createFromAsset(this.skinResources.getAssets(), skinTypefacePath);
            }
            return createFromAsset;
        } catch (RuntimeException e) {
            return Typeface.DEFAULT;
        }
    }
}
