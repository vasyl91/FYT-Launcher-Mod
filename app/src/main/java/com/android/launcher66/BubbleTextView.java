package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.syu.log.LogPreview;
import com.syu.util.FytPackage;

import share.ResValue;

/**
 * TextView that draws a bubble behind the text. We cannot use a LineBackgroundSpan
 * because we want to make the bubble taller than the text and TextView's clip is
 * too aggressive.
 */
public class BubbleTextView extends androidx.appcompat.widget.AppCompatTextView {
    static final float SHADOW_LARGE_RADIUS = 4.0f;
    static final float SHADOW_SMALL_RADIUS = 1.75f;
    static final float SHADOW_Y_OFFSET = 2.0f;
    static final int SHADOW_LARGE_COLOUR = 0xDD000000;
    static final int SHADOW_SMALL_COLOUR = 0xCC000000;
    static final float PADDING_H = 8.0f;
    static final float PADDING_V = 3.0f;

    private int mPrevAlpha = -1;

    private HolographicOutlineHelper mOutlineHelper;
    private final Canvas mTempCanvas = new Canvas();
    private final Rect mTempRect = new Rect();
    private boolean mDidInvalidateForPressedState;
    private Bitmap mPressedOrFocusedBackground;
    private int mFocusedOutlineColor;
    private int mFocusedGlowColor;
    private int mPressedOutlineColor;
    private int mPressedGlowColor;

    private int mTextColor;
    private boolean mShadowsEnabled = true;
    private boolean mIsTextVisible;

    private boolean mBackgroundSizeChanged;
    private Drawable mBackground;

    private boolean mStayPressed;
    private CheckLongPressHelper mLongPressHelper;

    public BubbleTextView(Context context) {
        this(context, null);
        init();
    }

    public BubbleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public BubbleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        int iWorkspaceTextSize = Integer.parseInt(prefs.getString("workspace_textSize", String.valueOf(Launcher.textSizeWorkspace)));
        setTextSize(0, iWorkspaceTextSize);
        setTextColor(ContextCompat.getColor(getContext(), R.color.workspace_icon_text_color));
    }

    private void init() {
        mLongPressHelper = new CheckLongPressHelper(this);
        mBackground = getBackground();

        mOutlineHelper = HolographicOutlineHelper.obtain(getContext());

        mFocusedOutlineColor = mFocusedGlowColor = mPressedOutlineColor = mPressedGlowColor =
                ContextCompat.getColor(getContext(), R.color.outline_color);

        setShadowLayer(SHADOW_LARGE_RADIUS, 0.0f, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
    }

    public void applyFromShortcutInfo(ShortcutInfo info, IconCache iconCache) {
        Bitmap b = info.getIcon(iconCache);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();

        setCompoundDrawables(null,
                Utilities.createIconDrawable(b), null, null);

        setCompoundDrawablePadding((int) ((grid.folderIconSizePx - grid.iconSizePx) / 2f));

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
        setText(info.title);
        setTag(info);
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
            mBackgroundSizeChanged = true;
        }
        return super.setFrame(left, top, right, bottom);
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mBackground || super.verifyDrawable(who);
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
            // In this case, we have already created the pressed outline on ACTION_DOWN,
            // so we just need to do an invalidate to trigger draw
            if (!mDidInvalidateForPressedState) {
                setCellLayoutPressedOrFocusedIcon();
            }
        } else {
            // Otherwise, either clear the pressed/focused background, or create a background
            // for the focused state
            final boolean backgroundEmptyBefore = mPressedOrFocusedBackground == null;
            if (!mStayPressed) {
                mPressedOrFocusedBackground = null;
            }
            if (isFocused()) {
                if (getLayout() == null) {
                    // In some cases, we get focus before we have been layed out. Set the
                    // background to null so that it will get created when the view is drawn.
                    mPressedOrFocusedBackground = null;
                } else {
                    mPressedOrFocusedBackground = createGlowingOutline(
                            mTempCanvas, mFocusedGlowColor, mFocusedOutlineColor);
                }
                mStayPressed = false;
                setCellLayoutPressedOrFocusedIcon();
            }
            final boolean backgroundEmptyNow = mPressedOrFocusedBackground == null;
            if (!backgroundEmptyBefore && backgroundEmptyNow) {
                setCellLayoutPressedOrFocusedIcon();
            }
        }

        Drawable d = mBackground;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
        super.drawableStateChanged();
    }

    /**
     * Draw this BubbleTextView into the given Canvas.
     *
     * @param destCanvas the canvas to draw on
     * @param padding the horizontal and vertical padding to use when drawing
     */
    private void drawWithPadding(Canvas destCanvas, int padding) {
        final Rect clipRect = mTempRect;
        getDrawingRect(clipRect);

        // adjust the clip rect so that we don't include the text label
        clipRect.bottom =
            getExtendedPaddingTop() - (int) BubbleTextView.PADDING_V + getLayout().getLineTop(0);

        // Draw the View into the bitmap.
        // The translate of scrollX and scrollY is necessary when drawing TextViews, because
        // they set scrollX and scrollY to large values to achieve centered text
        destCanvas.save();
        destCanvas.scale(getScaleX(), getScaleY(),
                (getWidth() + padding) / 2, (getHeight() + padding) / 2);
        destCanvas.translate(-getScrollX() + padding / 2, -getScrollY() + padding / 2);
        destCanvas.clipRect(clipRect);
        draw(destCanvas);
        destCanvas.restore();
    }

    /**
     * Returns a new bitmap to be used as the object outline, e.g. to visualize the drop location.
     * Responsibility for the bitmap is transferred to the caller.
     */
    private Bitmap createGlowingOutline(Canvas canvas, int outlineColor, int glowColor) {
        final int padding = mOutlineHelper.mMaxOuterBlurRadius;
        final Bitmap b = Bitmap.createBitmap(
                getWidth() + padding, getHeight() + padding, Bitmap.Config.ARGB_8888);

        canvas.setBitmap(b);
        drawWithPadding(canvas, padding);
        mOutlineHelper.applyExtraThickExpensiveOutlineWithBlur(b, canvas, glowColor, outlineColor);
        canvas.setBitmap(null);

        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Call the superclass onTouchEvent first, because sometimes it changes the state to
        // isPressed() on an ACTION_UP
        boolean result = super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // So that the pressed outline is visible immediately when isPressed() is true,
                // we pre-create it on ACTION_DOWN (it takes a small but perceptible amount of time
                // to create it)
                if (mPressedOrFocusedBackground == null) {
                    mPressedOrFocusedBackground = createGlowingOutline(
                            mTempCanvas, mPressedGlowColor, mPressedOutlineColor);
                }
                // Invalidate so the pressed state is visible, or set a flag so we know that we
                // have to call invalidate as soon as the state is "pressed"
                if (isPressed()) {
                    mDidInvalidateForPressedState = true;
                    setCellLayoutPressedOrFocusedIcon();
                } else {
                    mDidInvalidateForPressedState = false;
                }

                mLongPressHelper.postCheckForLongPress();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                // If we've touched down and up on an item, and it's still not "pressed", then
                // destroy the pressed outline
                if (!isPressed()) {
                    mPressedOrFocusedBackground = null;
                }

                mLongPressHelper.cancelLongPress();
                break;
        }
        return result;
    }

    void setStayPressed(boolean stayPressed) {
        mStayPressed = stayPressed;
        if (!stayPressed) {
            mPressedOrFocusedBackground = null;
        }
        setCellLayoutPressedOrFocusedIcon();
    }

    void setCellLayoutPressedOrFocusedIcon() {
        if (getParent() instanceof ShortcutAndWidgetContainer) {
            ShortcutAndWidgetContainer parent = (ShortcutAndWidgetContainer) getParent();
            if (parent != null) {
                CellLayout layout = (CellLayout) parent.getParent();
                layout.setPressedOrFocusedIcon((mPressedOrFocusedBackground != null) ? this : null);
            }
        }
    }

    void clearPressedOrFocusedBackground() {
        mPressedOrFocusedBackground = null;
        setCellLayoutPressedOrFocusedIcon();
    }

    Bitmap getPressedOrFocusedBackground() {
        return mPressedOrFocusedBackground;
    }

    int getPressedOrFocusedBackgroundPadding() {
        return mOutlineHelper.mMaxOuterBlurRadius / 2;
    }

    @Override
    public void draw(Canvas canvas) {
        if (!mShadowsEnabled) {
            super.draw(canvas);
            return;
        }

        final Drawable background = mBackground;
        if (background != null) {
            final int scrollX = getScrollX();
            final int scrollY = getScrollY();

            if (mBackgroundSizeChanged) {
                background.setBounds(0, 0,  getRight() - getLeft(), getBottom() - getTop());
                mBackgroundSizeChanged = false;
            }

            if ((scrollX | scrollY) == 0) {
                background.draw(canvas);
            } else {
                canvas.translate(scrollX, scrollY);
                background.draw(canvas);
                canvas.translate(-scrollX, -scrollY);
            }
        }

        // If text is transparent, don't draw any shadow
        if (getCurrentTextColor() == ContextCompat.getColor(getContext(), android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }

        // We enhance the shadow by drawing the shadow twice
        getPaint().setShadowLayer(SHADOW_LARGE_RADIUS, 0.0f, SHADOW_Y_OFFSET, SHADOW_LARGE_COLOUR);
        super.draw(canvas);
        canvas.save(Canvas.CLIP_SAVE_FLAG);
        canvas.clipRect(getScrollX(), getScrollY() + getExtendedPaddingTop(),
                getScrollX() + getWidth(),
                getScrollY() + getHeight());
        getPaint().setShadowLayer(SHADOW_SMALL_RADIUS, 0.0f, 0.0f, SHADOW_SMALL_COLOUR);
        super.draw(canvas);
        canvas.restore();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mBackground != null) mBackground.setCallback(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mBackground != null) mBackground.setCallback(null);
    }

    @Override
    public void setTextColor(int color) {
        mTextColor = color;
        super.setTextColor(color);
    }

    public void setShadowsEnabled(boolean enabled) {
        mShadowsEnabled = enabled;
        getPaint().clearShadowLayer();
        invalidate();
    }

    public void setTextVisibility(boolean visible) {
        if (visible) {
            super.setTextColor(mTextColor);
        } else {
            super.setTextColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        }
        mIsTextVisible = visible;
    }

    public boolean isTextVisible() {
        return mIsTextVisible;
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        if (mPrevAlpha != alpha) {
            mPrevAlpha = alpha;
            super.onSetAlpha(alpha);
        }
        return true;
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();

        mLongPressHelper.cancelLongPress();
    }
}