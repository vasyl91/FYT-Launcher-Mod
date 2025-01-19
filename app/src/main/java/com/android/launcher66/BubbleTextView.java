package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.fyt.skin.SkinUtils;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;
import com.syu.log.LogPreview;
import com.syu.util.FytPackage;
import java.util.ArrayList;
import java.util.Iterator;
import share.ResValue;

public class BubbleTextView extends AppCompatTextView {
    static final float PADDING_H = 8.0f;
    static final float PADDING_V = 3.0f;
    static final int SHADOW_LARGE_COLOUR = -587202560;
    static final int SHADOW_SMALL_COLOUR = -872415232;
    static final float SHADOW_Y_OFFSET = 2.0f;
    private AttributeSet mAttributeSet;
    private Drawable mBackground;
    private boolean mBackgroundSizeChanged;
    private boolean mDidInvalidateForPressedState;
    private int mFocusedGlowColor;
    private int mFocusedOutlineColor;
    private boolean mIsTextVisible;
    private CheckLongPressHelper mLongPressHelper;
    private HolographicOutlineHelper mOutlineHelper;
    private int mPressedGlowColor;
    private Bitmap mPressedOrFocusedBackground;
    private int mPressedOutlineColor;
    private int mPrevAlpha;
    private boolean mShadowsEnabled;
    private boolean mStayPressed;
    private final Canvas mTempCanvas;
    private final Rect mTempRect;
    private int mTextColor;
    static float SHADOW_LARGE_RADIUS = LauncherApplication.shadow_Large_Radius;
    static float SHADOW_SMALL_RADIUS = LauncherApplication.shadow_Small_Radius;

    public BubbleTextView(Context context) {
        this(context, null);
    }

    public BubbleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPrevAlpha = -1;
        this.mTempCanvas = new Canvas();
        this.mTempRect = new Rect();
        this.mShadowsEnabled = true;
        init(attrs);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        setTextSize(0, grid.iconTextSize);
    }

    private void init(AttributeSet attrs) {
        this.mAttributeSet = attrs;
        this.mLongPressHelper = new CheckLongPressHelper(this);
        this.mBackground = getBackground();
        this.mOutlineHelper = HolographicOutlineHelper.obtain(getContext());
        int color = ContextCompat.getColor(getContext(), R.color.outline_color);
        this.mPressedGlowColor = color;
        this.mPressedOutlineColor = color;
        this.mFocusedGlowColor = color;
        this.mFocusedOutlineColor = color;
        setShadowLayer(SHADOW_LARGE_RADIUS, 0.0f, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
    }

    public void applyFromShortcutInfo(ShortcutInfo info, IconCache iconCache) {
        Bitmap b = info.getIcon(iconCache);
        LauncherAppState app = LauncherAppState.getInstance();
        app.getDynamicGrid().getDeviceProfile();
        switch (LauncherApplication.sApp.getResources().getInteger(R.integer.appNameAlign)) {
            case 0:
                setCompoundDrawables(Utilities.createIconDrawable(b), null, null, null);
                break;
            case 1:
                setCompoundDrawables(null, Utilities.createIconDrawable(b), null, null);
                break;
            case 2:
                setCompoundDrawables(null, null, Utilities.createIconDrawable(b), null);
                break;
            case 3:
                setCompoundDrawables(null, null, null, Utilities.createIconDrawable(b));
                break;
        }
        int padding = LauncherApplication.sApp.getResources().getInteger(R.integer.bubbletextview_padding);
        setCompoundDrawablePadding(padding);
        if ("com.syu.voice.VoiceLaunch".equals(info.intent.getComponent().getClassName()) || "com.syu.voice.Launch".equals(info.intent.getComponent().getClassName())) {
            String voicename = SystemProperties.get("syu.voicename");
            String voicenewname = SystemProperties.get("persist.syu.voice.newname");
            LogPreview.show("voicename:" + voicename);
            LogPreview.show("voicenewname:" + voicenewname);
            if (!TextUtils.isEmpty(voicenewname)) {
                setText("车助理·" + voicenewname);
            } else if (!TextUtils.isEmpty(voicename)) {
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
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_shortname) && getText().length() > 6) {
            setText(String.valueOf(getText().toString().substring(0, 3)) + "...");
        }
        setTag(info);
        setTag(R.id.str_tag, info.getIntent().getComponent().getPackageName());
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

    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        if (getLeft() != left || getRight() != right || getTop() != top || getBottom() != bottom) {
            this.mBackgroundSizeChanged = true;
        }
        return super.setFrame(left, top, right, bottom);
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return who == this.mBackground || super.verifyDrawable(who);
    }

    @Override
    public void setTag(Object tag) {
        if (tag != null) {
            LauncherModel.checkItemInfo((ItemInfo) tag);
        }
        super.setTag(tag);
    }

    @Override
    protected void drawableStateChanged() {
        if (isPressed()) {
            if (!this.mDidInvalidateForPressedState) {
                setCellLayoutPressedOrFocusedIcon();
            }
        } else {
            boolean backgroundEmptyBefore = this.mPressedOrFocusedBackground == null;
            if (!this.mStayPressed) {
                this.mPressedOrFocusedBackground = null;
            }
            setFocusable(false);
            if (isFocused()) {
                if (getLayout() == null) {
                    this.mPressedOrFocusedBackground = null;
                } else {
                    this.mPressedOrFocusedBackground = createGlowingOutline(this.mTempCanvas, this.mFocusedGlowColor, this.mFocusedOutlineColor);
                }
                this.mStayPressed = false;
                setCellLayoutPressedOrFocusedIcon();
            }
            boolean backgroundEmptyNow = this.mPressedOrFocusedBackground == null;
            if (!backgroundEmptyBefore && backgroundEmptyNow) {
                setCellLayoutPressedOrFocusedIcon();
            }
        }
        Drawable d = this.mBackground;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
        super.drawableStateChanged();
    }

    private void drawWithPadding(Canvas destCanvas, int padding) {
        Rect clipRect = this.mTempRect;
        getDrawingRect(clipRect);
        clipRect.bottom = (getExtendedPaddingTop() - 3) + getLayout().getLineTop(0);
        destCanvas.save();
        destCanvas.scale(getScaleX(), getScaleY(), (getWidth() + padding) / 2, (getHeight() + padding) / 2);
        destCanvas.translate((-getScrollX()) + (padding / 2), (-getScrollY()) + (padding / 2));
        destCanvas.clipRect(clipRect);
        draw(destCanvas);
        destCanvas.restore();
    }

    private Bitmap createGlowingOutline(Canvas canvas, int outlineColor, int glowColor) {
        int padding = this.mOutlineHelper.mMaxOuterBlurRadius;
        Bitmap b = Bitmap.createBitmap(getWidth() + padding, getHeight() + padding, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(b);
        drawWithPadding(canvas, padding);
        this.mOutlineHelper.applyExtraThickExpensiveOutlineWithBlur(b, canvas, glowColor, outlineColor);
        canvas.setBitmap(null);
        return b;
    }

    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        switch (event.getAction()) {
            case 0:
                if (this.mPressedOrFocusedBackground == null) {
                    this.mPressedOrFocusedBackground = createGlowingOutline(this.mTempCanvas, this.mPressedGlowColor, this.mPressedOutlineColor);
                }
                if (isPressed()) {
                    this.mDidInvalidateForPressedState = true;
                    setCellLayoutPressedOrFocusedIcon();
                } else {
                    this.mDidInvalidateForPressedState = false;
                }
                this.mLongPressHelper.postCheckForLongPress();
                break;
            case 1:
            case 3:
                if (!isPressed()) {
                    this.mPressedOrFocusedBackground = null;
                }
                this.mLongPressHelper.cancelLongPress();
                break;
        }
        return result;
    }

    void setStayPressed(boolean stayPressed) {
        this.mStayPressed = stayPressed;
        if (!stayPressed) {
            this.mPressedOrFocusedBackground = null;
        }
        setCellLayoutPressedOrFocusedIcon();
    }

    void setCellLayoutPressedOrFocusedIcon() {
        ShortcutAndWidgetContainer parent;
        if ((getParent() instanceof ShortcutAndWidgetContainer) && (parent = (ShortcutAndWidgetContainer) getParent()) != null) {
            CellLayout layout = (CellLayout) parent.getParent();
            if (this.mPressedOrFocusedBackground == null) {
                this.mPressedOrFocusedBackground = createGlowingOutline(this.mTempCanvas, this.mPressedGlowColor, this.mPressedOutlineColor);
            }
            layout.setPressedOrFocusedIcon(this);
        }
    }

    void clearPressedOrFocusedBackground() {
        this.mPressedOrFocusedBackground = null;
        setCellLayoutPressedOrFocusedIcon();
    }

    Bitmap getPressedOrFocusedBackground() {
        return this.mPressedOrFocusedBackground;
    }

    int getPressedOrFocusedBackgroundPadding() {
        return this.mOutlineHelper.mMaxOuterBlurRadius / 2;
    }

    @Override
    public void draw(Canvas canvas) {
        if (!this.mShadowsEnabled) {
            super.draw(canvas);
            return;
        }
        Drawable background = this.mBackground;
        if (background != null) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (this.mBackgroundSizeChanged) {
                background.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
                this.mBackgroundSizeChanged = false;
            }
            if ((scrollX | scrollY) == 0) {
                background.draw(canvas);
            } else {
                canvas.translate(scrollX, scrollY);
                background.draw(canvas);
                canvas.translate(-scrollX, -scrollY);
            }
        }
        if (getCurrentTextColor() == ContextCompat.getColor(getContext(), android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }
        getPaint().setShadowLayer(SHADOW_LARGE_RADIUS, 0.0f, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
        super.draw(canvas);
        canvas.save();
        canvas.clipRect(getScrollX(), getScrollY() + getExtendedPaddingTop(), getScrollX() + getWidth(), getScrollY() + getHeight());
        getPaint().setShadowLayer(SHADOW_SMALL_RADIUS, 0.0f, 0.0f, SHADOW_SMALL_COLOUR);
        super.draw(canvas);
        canvas.restore();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mBackground != null) {
            this.mBackground.setCallback(this);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mBackground != null) {
            this.mBackground.setCallback(null);
        }
    }

    @Override
    public void setTextColor(int color) {
        this.mTextColor = color;
    }

    public void setShadowsEnabled(boolean enabled) {
        this.mShadowsEnabled = enabled;
        getPaint().clearShadowLayer();
        invalidate();
    }

    public void setTextVisibility(boolean visible) {
        getResources();
        this.mIsTextVisible = visible;
    }

    public boolean isTextVisible() {
        return this.mIsTextVisible;
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        if (this.mPrevAlpha != alpha) {
            this.mPrevAlpha = alpha;
            super.onSetAlpha(alpha);
            return true;
        }
        return true;
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        this.mLongPressHelper.cancelLongPress();
    }
}
