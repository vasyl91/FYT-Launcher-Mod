package com.android.launcher66;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * The strip of the app drawer's tabs (F6), above or below the apps, with a grey line of 1 dp between it and the apps.
 *
 * <p>The rules (the owner's, 2026-11-25; the numbers are in {@link DrawerTabGeometry}):
 * <ul>
 *   <li>The selected tab's name is in the accent colour and bold, with an underline of 2 dp under it that is 80% of
 *       the tab wide and centred; the others are white and plain. With the strip above the apps the foot of the
 *       underline is the foot of the grey line, with the strip below them the head of the underline is the head of the
 *       line: in both cases the underline lies against the line, on the side of the names.</li>
 *   <li>The underline slides to the tab chosen (200 ms), and follows the finger while a page is dragged
 *       ({@link #followPosition}).</li>
 *   <li>2 tabs show side by side in portrait and 4 in landscape; more scroll the bar sideways, which changes no
 *       selection. A name that is longer than its tab runs as a marquee.</li>
 *   <li>A tap on a tab that is not selected selects it; a tap on the selected one asks for its dialog.</li>
 * </ul>
 */
public final class DrawerTabStrip extends LinearLayout {

    /** What the strip tells the drawer. */
    public interface Listener {
        /** A tab that was not selected was tapped; it is selected now. */
        void onTabSelected(int id);

        /** The tab that was selected was tapped. */
        void onSelectedTabTapped(int id);
    }

    private static final long SLIDE_MS = 200L;

    private final HorizontalScrollView mScroll;
    private final LinearLayout mRow;
    private final View mLine;
    private final Paint mUnderline = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final List<Integer> mIds = new ArrayList<>();
    private final List<TextView> mViews = new ArrayList<>();
    private final float mDensity;
    private ValueAnimator mSlide;
    private Listener mListener;
    private int mSelected;
    private float mPosition;
    private boolean mOnTop = true;
    private int mAccent = 0xff4285f4;
    private int mTabWidth;

    public DrawerTabStrip(Context context) {
        this(context, null);
    }

    public DrawerTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        mDensity = context.getResources().getDisplayMetrics().density;
        mScroll = new HorizontalScrollView(context);
        mScroll.setHorizontalScrollBarEnabled(false);
        mScroll.setOverScrollMode(OVER_SCROLL_NEVER);
        mScroll.setFillViewport(true);
        mRow = new LinearLayout(context);
        mRow.setOrientation(HORIZONTAL);
        mScroll.addView(mRow, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mScroll.setOnScrollChangeListener((v, x, y, oldX, oldY) -> invalidate());
        mLine = new View(context);
        mLine.setBackgroundColor(context.getResources().getColor(R.color.settings_divider, null));
        mUnderline.setStyle(Paint.Style.FILL);
        setBarOnTop(true);
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    /** The accent colour of the selected name and of the underline. */
    public void setAccent(int accent) {
        mAccent = accent;
        mUnderline.setColor(accent);
        styleTabs();
        invalidate();
    }

    /**
     * Puts the strip's grey line on the side of the apps: with the strip above them the line is under it, with the strip
     * below them the line is over it.
     */
    public void setBarOnTop(boolean onTop) {
        mOnTop = onTop;
        removeAllViews();
        int height = stripHeight();
        LayoutParams scroll = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        LayoutParams line = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Math.max(1, Math.round(mDensity)));
        if (onTop) {
            addView(mScroll, scroll);
            addView(mLine, line);
        } else {
            addView(mLine, line);
            addView(mScroll, scroll);
        }
        invalidate();
    }

    public boolean isBarOnTop() {
        return mOnTop;
    }

    private int stripHeight() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return DrawerTabGeometry.stripHeight(dm.widthPixels, dm.heightPixels);
    }

    private boolean portrait() {
        return getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE;
    }

    /** The tabs, in their order, with the names to show; {@code selectedIndex} is the one that is selected. */
    public void setTabs(List<Integer> ids, List<String> names, int selectedIndex) {
        cancelSlide();
        mIds.clear();
        mIds.addAll(ids);
        mViews.clear();
        mRow.removeAllViews();
        for (int i = 0; i < ids.size(); i++) {
            final int index = i;
            TextView view = new TextView(getContext());
            view.setText(names.get(i));
            view.setGravity(Gravity.CENTER);
            view.setSingleLine(true);
            view.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            view.setMarqueeRepeatLimit(-1);
            view.setSelected(true);   // a marquee runs on a view that is selected or focused
            view.setPadding(Math.round(8 * mDensity), 0, Math.round(8 * mDensity), 0);
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            view.setOnClickListener(v -> tapped(index));
            mViews.add(view);
            mRow.addView(view, new LinearLayout.LayoutParams(Math.max(1, mTabWidth), ViewGroup.LayoutParams.MATCH_PARENT));
        }
        mSelected = Math.max(0, Math.min(selectedIndex, Math.max(0, ids.size() - 1)));
        mPosition = mSelected;
        sizeTabs(getWidth());
        styleTabs();
        invalidate();
    }

    /** The view of a tab's name, for the tests. */
    TextView tabView(int index) {
        return mViews.get(index);
    }

    public int selectedIndex() {
        return mSelected;
    }

    public int count() {
        return mIds.size();
    }

    private void tapped(int index) {
        if (index < 0 || index >= mIds.size()) {
            return;
        }
        int id = mIds.get(index);
        if (index == mSelected) {
            if (mListener != null) {
                mListener.onSelectedTabTapped(id);
            }
            return;
        }
        select(index, true);
        if (mListener != null) {
            mListener.onTabSelected(id);
        }
    }

    /** Selects a tab; the underline slides to it, or is put there at once. */
    public void select(int index, boolean animate) {
        if (index < 0 || index >= mIds.size()) {
            return;
        }
        mSelected = index;
        styleTabs();
        showTab(index);
        cancelSlide();
        if (!animate || mPosition == index) {
            mPosition = index;
            invalidate();
            return;
        }
        mSlide = ValueAnimator.ofFloat(mPosition, index);
        mSlide.setDuration(SLIDE_MS);
        mSlide.addUpdateListener(a -> {
            mPosition = (Float) a.getAnimatedValue();
            invalidate();
        });
        mSlide.start();
    }

    /**
     * The underline at a place between the tabs (a page dragged by a finger: {@code position} is the tab's index and the
     * part of the way to the next); the selection itself does not change.
     */
    public void followPosition(float position) {
        cancelSlide();
        mPosition = DrawerTabGeometry.clampPosition(position, mIds.size());
        invalidate();
    }

    /** The place of the underline now, in tabs. */
    public float underlinePosition() {
        return mPosition;
    }

    float underlineLeft() {
        return DrawerTabGeometry.underlineLeft(mPosition, mTabWidth) - mScroll.getScrollX();
    }

    float underlineWidth() {
        return DrawerTabGeometry.underlineWidth(mTabWidth);
    }

    int tabWidth() {
        return mTabWidth;
    }

    /** The bar scrolled so that a tab is whole in it (a swipe or a tap on a tab at the edge). */
    private void showTab(int index) {
        int to = DrawerTabGeometry.scrollToShow(index, mTabWidth, mScroll.getScrollX(), Math.max(1, getWidth()), mIds.size());
        if (to != mScroll.getScrollX()) {
            mScroll.smoothScrollTo(to, 0);
        }
    }

    private void cancelSlide() {
        if (mSlide != null) {
            mSlide.cancel();
            mSlide = null;
        }
    }

    private void styleTabs() {
        for (int i = 0; i < mViews.size(); i++) {
            TextView view = mViews.get(i);
            boolean on = i == mSelected;
            view.setTextColor(on ? mAccent : Color.WHITE);
            view.setTypeface(null, on ? Typeface.BOLD : Typeface.NORMAL);
        }
    }

    private void sizeTabs(int barWidth) {
        if (barWidth <= 0) {
            return;
        }
        mTabWidth = DrawerTabGeometry.tabWidth(barWidth, mIds.size(), portrait());
        for (TextView view : mViews) {
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params != null && params.width != mTabWidth) {
                params.width = mTabWidth;
                view.setLayoutParams(params);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        sizeTabs(w);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        sizeTabs(MeasureSpec.getSize(widthMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mIds.isEmpty() || mTabWidth <= 0) {
            return;
        }
        float thick = 2f * mDensity;
        float left = underlineLeft();
        float right = left + underlineWidth();
        // above the apps: the foot of the underline is the foot of the line; below them its head is the head of the line
        float bottom = mOnTop ? getHeight() : thick;
        canvas.save();
        canvas.clipRect(0, 0, getWidth(), getHeight());
        canvas.drawRect(left, bottom - thick, right, bottom, mUnderline);
        canvas.restore();
    }

    @Override
    protected void onDetachedFromWindow() {
        cancelSlide();
        super.onDetachedFromWindow();
    }
}
