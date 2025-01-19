package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.fyt.skin.SkinUtils;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;
import com.syu.util.FytPackage;
import java.util.ArrayList;
import java.util.Iterator;
import share.ResValue;

public class PagedViewIcon extends androidx.appcompat.widget.AppCompatTextView {
    private static final float PRESS_ALPHA = 0.4f;
    private static final String TAG = "PagedViewIcon";
    private AttributeSet mAttributeSet;
    private Bitmap mIcon;
    private boolean mLockDrawableState;
    private PressedCallback mPressedCallback;

    public interface PressedCallback {
        void iconPressed(PagedViewIcon pagedViewIcon);
    }

    public PagedViewIcon(Context context) {
        this(context, null);
    }

    public PagedViewIcon(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagedViewIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mLockDrawableState = false;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.mAttributeSet = attrs;
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        setTextSize(0, grid.iconTextSize);
    }

    public void applyFromApplicationInfo(AppInfo info, boolean scaleUp, PressedCallback cb) {
        this.mIcon = info.iconBitmap;
        this.mPressedCallback = cb;
        switch (LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign)) {
            case 0:
                setCompoundDrawables(Utilities.createIconDrawable(this.mIcon), null, null, null);
                break;
            case 1:
                setCompoundDrawables(null, Utilities.createIconDrawable(this.mIcon), null, null);
                break;
            case 2:
                setCompoundDrawables(null, null, Utilities.createIconDrawable(this.mIcon), null);
                break;
            case 3:
                setCompoundDrawables(null, null, null, Utilities.createIconDrawable(this.mIcon));
                break;
        }
        int padding = LauncherApplication.sApp.getResources().getInteger(R.integer.pagetextview_padding);
        setCompoundDrawablePadding(padding);
        if ("com.syu.voice.VoiceLaunch".equals(info.componentName.getClassName()) || "com.syu.voice.Launch".equals(info.componentName.getClassName())) {
            String voicename = SystemProperties.get("syu.voicename");
            String voicenewname = SystemProperties.get("persist.syu.voice.newname");
            if (voicenewname != null && !voicenewname.equals("")) {
                setText("车助理·" + voicenewname);
            } else if (voicename != null && !voicename.equals("")) {
                setText("车助理·" + voicename);
            } else {
                setText(info.title);
            }
        } else if ("com.syu.music".equals(info.intent.getComponent().getPackageName())) {
            setText(getResources().getString(R.string.car_music));
        } else if ("com.syu.video.main.VideoListActivity".equals(info.intent.getComponent().getClassName())) {
            setText(getResources().getString(R.string.car_video));
        } else if (FytPackage.eqACTION.equals(info.intent.getComponent().getPackageName())) {
            String eqName = getStr(ResValue.getInstance().app_eq_name, info.title.toString());
            setText(eqName);
        } else {
            setText(info.title);
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_shortname) && getText().length() > 4) {
            setText(String.valueOf(getText().toString().substring(0, 3)) + "...");
        }
        setTag(info);
        setTag(R.id.str_tag, info.getPackageName());
        addResourceId(this, info.getIconResid());
    }

    private void addResourceId(View view, int resid) {
        ArrayList<SkinView> skinViews = SkinUtils.getSkinAttr().getSkinViews();
        Iterator<SkinView> it = skinViews.iterator();
        while (it.hasNext()) {
            SkinView skinView = it.next();
            if (skinView.getView() == view) {
                for (SkinAttrParms sap : skinView.getParms()) {
                    if (sap.getAttrName().equals("drawableTop")) {
                        sap.setId(resid);
                    }
                    if (sap.getAttrName().equals("tag")) {
                        sap.setId(R.id.str_tag);
                    }
                }
                return;
            }
        }
    }

    private String getStr(int resid, String title) {
        String appName = "";
        try {
            appName = getResources().getString(resid);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(appName)) {
            return title;
        }
        String title2 = appName;
        return title2;
    }

    public void lockDrawableState() {
        this.mLockDrawableState = true;
    }

    public void resetDrawableState() {
        this.mLockDrawableState = false;
        post(new Runnable() { 
            @Override
            public void run() {
                PagedViewIcon.this.refreshDrawableState();
            }
        });
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setFocusable(false);
        if (isPressed()) {
            setAlpha(PRESS_ALPHA);
            if (this.mPressedCallback != null) {
                this.mPressedCallback.iconPressed(this);
                return;
            }
            return;
        }
        if (!this.mLockDrawableState) {
            setAlpha(1.0f);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (getCurrentTextColor() == ContextCompat.getColor(getContext(), android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }
        getPaint().setShadowLayer(BubbleTextView.SHADOW_LARGE_RADIUS, 0.0f, 2.0f, -587202560);
        super.draw(canvas);
        canvas.save();
        getPaint().setShadowLayer(BubbleTextView.SHADOW_SMALL_RADIUS, 0.0f, 0.0f, -872415232);
        super.draw(canvas);
        canvas.restore();
    }
}
