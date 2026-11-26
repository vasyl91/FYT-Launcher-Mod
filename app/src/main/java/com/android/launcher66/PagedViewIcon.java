package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.core.content.ContextCompat;

/**
 * An icon on a PagedView, specifically for items in the launcher's paged view (with compound
 * drawables on the top).
 */
public class PagedViewIcon extends androidx.appcompat.widget.AppCompatTextView {
    /** A simple callback interface to allow a PagedViewIcon to notify when it has been pressed */
    public static interface PressedCallback {
        void iconPressed(PagedViewIcon icon);
    }

    @SuppressWarnings("unused")
    private static final String TAG = "PagedViewIcon";
    private static final float PRESS_ALPHA = 0.4f;

    private PagedViewIcon.PressedCallback mPressedCallback;
    private boolean mLockDrawableState = false;

    private Bitmap mIcon;

    public PagedViewIcon(Context context) {
        this(context, null);
    }

    public PagedViewIcon(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagedViewIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onFinishInflate() {
        super.onFinishInflate();

        // Ensure we are using the right text size
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        setTextSize(TypedValue.COMPLEX_UNIT_SP, grid.labelTextSizeSp());
    }

    public void applyFromApplicationInfo(AppInfo info, boolean scaleUp,
            PagedViewIcon.PressedCallback cb) {
        mIcon = info.iconBitmap;
        mPressedCallback = cb;
        setCompoundDrawables(null, Utilities.createIconDrawable(mIcon),
                null, null);
        setText(info.title);
        setTag(info);
        // White, or the colour of "App drawer: Set icon text color" (a creator setting: not with the stock layout)
        setTextColor(IconTextColor.drawer(androidx.preference.PreferenceManager.getDefaultSharedPreferences(getContext()),
                0xffffffff));
    }

    public void lockDrawableState() {
        mLockDrawableState = true;
    }

    public void resetDrawableState() {
        mLockDrawableState = false;
        post(new Runnable() {
            @Override
            public void run() {
                refreshDrawableState();
            }
        });
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();

        // We keep in the pressed state until resetDrawableState() is called to reset the press
        // feedback
        if (isPressed()) {
            setAlpha(PRESS_ALPHA);
            if (mPressedCallback != null) {
                mPressedCallback.iconPressed(this);
            }
        } else if (!mLockDrawableState) {
            setAlpha(1f);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        drawContent(canvas);
        drawBadge(canvas);
    }

    // ---- the notification badge of the app drawer's icons (H1: BadgeModel, BadgeViews)

    private BadgeDrawable mBadge;
    private final BadgeViews.Host mBadgeHost = new BadgeViews.Host() {
        @Override
        public boolean showsPackage(java.util.Set<String> packages) {
            String pkg = badgePackage();
            return pkg != null && packages.contains(pkg);
        }

        @Override
        public void refreshBadge() {
            invalidate();
        }
    };

    private String badgePackage() {
        Object tag = getTag();
        return tag instanceof AppInfo ? BadgeViews.packageOf(((AppInfo) tag).intent) : null;
    }

    private void drawBadge(Canvas canvas) {
        BadgeModel model = BadgeModel.get();
        int count = model.count(badgePackage());
        android.graphics.drawable.Drawable icon = getCompoundDrawables()[1];
        if (count <= 0 || icon == null) {
            return;
        }
        if (mBadge == null) {
            mBadge = new BadgeDrawable(getContext());
        }
        int w = icon.getBounds().width();
        int h = icon.getBounds().height();
        int x = getScrollX() + getCompoundPaddingLeft()
                + (getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight() - w) / 2;
        int y = getScrollY() + getPaddingTop();
        mBadge.setBounds(x, y, x + w, y + h);
        // the colour of the number is the drawer's own text colour
        mBadge.set(count, model.style(getContext()), getCurrentTextColor());
        mBadge.draw(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        BadgeViews.register(mBadgeHost);
    }

    @Override
    protected void onDetachedFromWindow() {
        BadgeViews.unregister(mBadgeHost);
        super.onDetachedFromWindow();
    }

    private void drawContent(Canvas canvas) {
        // If text is transparent, don't draw any shadow
        if (getCurrentTextColor() == ContextCompat.getColor(getContext(), android.R.color.transparent)) {
            getPaint().clearShadowLayer();
            super.draw(canvas);
            return;
        }

        // We enhance the shadow by drawing the shadow twice
        getPaint().setShadowLayer(BubbleTextView.SHADOW_LARGE_RADIUS, 0.0f,
                BubbleTextView.SHADOW_Y_OFFSET, BubbleTextView.SHADOW_LARGE_COLOUR);
        super.draw(canvas);
        canvas.save();
        canvas.clipRect(getScrollX(), getScrollY() + getExtendedPaddingTop(),
                getScrollX() + getWidth(),
                getScrollY() + getHeight());
        getPaint().setShadowLayer(BubbleTextView.SHADOW_SMALL_RADIUS, 0.0f, 0.0f,
                BubbleTextView.SHADOW_SMALL_COLOUR);
        super.draw(canvas);
        canvas.restore();
    }
}
