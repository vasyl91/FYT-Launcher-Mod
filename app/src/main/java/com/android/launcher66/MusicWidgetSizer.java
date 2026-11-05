package com.android.launcher66;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.flexbox.FlexboxLayout;

/**
 * Sizes the children of a music widget (home screen or bottom bar) from the size the widget has,
 * following the plan MusicWidgetPlan makes: the cover, the two text rows (one font for both), the
 * progress bar and the square buttons. It listens for the widget's layout, so a resize in the
 * layout wizard or a changed bar height is followed.
 *
 * Setting the children's sizes lays the widget out again, so the work is skipped when the inputs
 * are those of the last time (no layout loop), and the layout listener only schedules it.
 */
final class MusicWidgetSizer implements View.OnLayoutChangeListener {

    interface Callback {
        /** The widget went to (or left) the one-line mode. Called for the first plan as well. */
        void onCompactChanged(boolean bar, boolean compact);
    }

    private static final String TAG = "MusicWidgetSizer";

    /** As Workspace.BAR_TEXT_MIN_PARENT_FRACTION: a bar below this share of its height is mid-layout. */
    private static final float BAR_TRANSIENT_FRACTION = 0.25f;

    /** Share of the width left on each side of the home screen's progress bar. */
    private static final float PROGRESS_MARGIN = 0.1f;

    private final View mRoot;
    private final boolean mBar;
    private final Callback mCallback;
    private final Runnable mApply = this::applyScheduled;
    private boolean mScheduled;

    private int mLastW = -1;
    private int mLastH = -1;
    private int mLastBarH = -1;
    private int mLastMaxText = -1;
    private Boolean mLastCompact;
    private String mLastPlan;
    /** Px per sp, as of the last plan: the floor of the one line's text size. */
    private float mDensity = 1f;

    private MusicWidgetSizer(View root, boolean bar, Callback callback) {
        mRoot = root;
        mBar = bar;
        mCallback = callback;
    }

    /**
     * Starts sizing {@code root}. A sizer the root already has is replaced, not added to, so a
     * rebind of the same view does not stack listeners.
     */
    static MusicWidgetSizer attach(View root, boolean bar, Callback cb) {
        if (root == null) {
            return null;
        }
        Object old = root.getTag(R.id.music_buttons);
        if (old instanceof MusicWidgetSizer) {
            root.removeOnLayoutChangeListener((MusicWidgetSizer) old);
        }
        MusicWidgetSizer sizer = new MusicWidgetSizer(root, bar, cb);
        root.setTag(R.id.music_buttons, sizer);
        root.addOnLayoutChangeListener(sizer);
        root.post(sizer.mApply);
        return sizer;
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom,
            int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (right - left == oldRight - oldLeft && bottom - top == oldBottom - oldTop) {
            return;
        }
        schedule();
    }

    private void schedule() {
        if (!mScheduled) {
            mScheduled = true;
            mRoot.post(mApply);
        }
    }

    private void applyScheduled() {
        mScheduled = false;
        apply(false);
    }

    /** Sizes again even when the inputs are the same as the last time (after a wake, say). */
    void refresh() {
        apply(true);
    }

    private void apply(boolean force) {
        if (!mRoot.isAttachedToWindow() || !mRoot.isLaidOut()) {
            return;
        }
        int w = mRoot.getWidth() - mRoot.getPaddingLeft() - mRoot.getPaddingRight();
        int h = mRoot.getHeight() - mRoot.getPaddingTop() - mRoot.getPaddingBottom();
        if (w <= 0 || h <= 0) {
            return;
        }
        Launcher launcher = launcherOf(mRoot.getContext());
        int barH = launcher != null ? launcher.getBottomBarHeight() : 0;
        if (mBar && barH > 0 && h < barH * BAR_TRANSIENT_FRACTION) {
            return; // mid-layout (a wake, a rotation), a real one follows
        }
        DisplayMetrics dm = mRoot.getResources().getDisplayMetrics();
        int maxText = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                Launcher.textSizeTitle, dm));
        if (!force && w == mLastW && h == mLastH && barH == mLastBarH && maxText == mLastMaxText) {
            return;
        }
        mLastW = w;
        mLastH = h;
        mLastBarH = barH;
        mLastMaxText = maxText;

        float density = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 1f, dm);
        mDensity = density;
        MusicWidgetPlan.Plan plan;
        if (mBar) {
            View buttons = mRoot.findViewById(R.id.music_bar_buttons);
            android.content.SharedPreferences prefs = androidx.preference.PreferenceManager
                    .getDefaultSharedPreferences(mRoot.getContext());
            boolean largeText = prefs.getBoolean(com.android.launcher66.settings.Keys.WIDGET_BAR_LARGE_TEXT, false);
            // The user's choice on every bar height (it used to follow the height of the bar)
            boolean oneLine = prefs.getBoolean(com.android.launcher66.settings.Keys.WIDGET_BAR_ONE_LINE, false);
            // The cover and the space behind it are sized from the widget's usual width, the one it
            // has with the date and the weather shown, so they do not move when those are hidden.
            boolean portrait = mRoot.getResources().getConfiguration().orientation
                    == android.content.res.Configuration.ORIENTATION_PORTRAIT;
            int baseW = MusicWidgetPlan.usualWidth(w, WidgetBarPlan.baseShare(portrait),
                    WidgetBarPlan.musicShare(portrait, WidgetBarLayout.dateHidden(prefs, portrait),
                            WidgetBarLayout.weatherHidden(prefs)));
            if (buttons instanceof FlexboxLayout) {
                // The wide layout (WidgetBarLayout): the buttons are a block beside the text.
                plan = MusicWidgetPlan.planBarWide(w, h, baseW, density, largeText, oneLine);
                applyBarWide(plan, w);
            } else {
                plan = MusicWidgetPlan.planBar(w, h, baseW, density, largeText, oneLine);
                applyBar(plan, w);
            }
        } else {
            plan = MusicWidgetPlan.planHome(w, h, density, maxText);
            applyHome(plan, w);
        }

        String planText = plan.toString();
        if (!planText.equals(mLastPlan)) {
            mLastPlan = planText;
            Log.d(TAG, (mBar ? "bar " : "home ") + w + "x" + h + " -> " + planText);
        }
        if (mLastCompact == null || mLastCompact != plan.compact) {
            if (mLastCompact != null || plan.compact) {
                Log.i(TAG, (mBar ? "bar" : "home") + " widget " + w + "x" + h
                        + (plan.compact ? " goes to one text row" : " back to two text rows"));
            }
            mLastCompact = plan.compact;
            if (mCallback != null) {
                mCallback.onCompactChanged(mBar, plan.compact);
            }
        }
    }

    private void applyHome(MusicWidgetPlan.Plan plan, int w) {
        View cover = mRoot.findViewById(R.id.iv_album_bg);
        TextView title = mRoot.findViewById(R.id.tv_musicName);
        TextView artist = mRoot.findViewById(R.id.tv_artist);
        View progress = mRoot.findViewById(R.id.music_progress);
        View buttons = mRoot.findViewById(R.id.music_buttons);

        if (cover != null) {
            setVisibility(cover, plan.cover ? View.VISIBLE : View.GONE);
            setBox(cover, plan.coverPx, plan.coverPx, plan.gapPx, 0);
        }
        applyText(title, plan);
        applyText(artist, plan);
        if (progress != null) {
            setBox(progress, ViewGroup.LayoutParams.MATCH_PARENT, plan.progressPx, plan.gapPx,
                    (int) (w * PROGRESS_MARGIN));
        }
        if (buttons != null) {
            setBox(buttons, ViewGroup.LayoutParams.MATCH_PARENT, plan.buttonRowPx, plan.gapPx, 0);
        }
        sizeButtons(plan.buttonSidePx, R.id.music_prev, R.id.music_playpause, R.id.music_next,
                R.id.music_favorite);
    }

    private void applyBar(MusicWidgetPlan.Plan plan, int w) {
        View cover = mRoot.findViewById(R.id.iv_album_bg_two);
        View column = mRoot.findViewById(R.id.music_bar_column);
        TextView title = mRoot.findViewById(R.id.tv_musicName_two);
        TextView artist = mRoot.findViewById(R.id.tv_artist_two);
        View buttons = mRoot.findViewById(R.id.music_bar_buttons);

        if (cover != null) {
            setBox(cover, plan.coverPx, plan.coverPx, 0, 0);
        }
        if (column != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) column.getLayoutParams();
            int gap = plan.coverGapPx;
            if (lp.leftMargin != gap) {
                lp.leftMargin = gap;
                column.setLayoutParams(lp);
            }
        }
        applyText(title, plan);
        applyText(artist, plan);
        if (buttons != null) {
            setBox(buttons, ViewGroup.LayoutParams.MATCH_PARENT, plan.buttonRowPx, plan.gapPx, 0);
        }
        sizeButtons(plan.buttonSidePx, R.id.music_prev_two, R.id.music_playpause_two,
                R.id.music_next_two, R.id.music_favorite_two);
    }

    /**
     * The bar with the buttons beside the text: the cover, the column of text between it and the
     * block of buttons, and the block, a FlexboxLayout of 2 x 2 cells (50% wide each).
     */
    private void applyBarWide(MusicWidgetPlan.Plan plan, int w) {
        View cover = mRoot.findViewById(R.id.iv_album_bg_two);
        View column = mRoot.findViewById(R.id.music_bar_column);
        TextView title = mRoot.findViewById(R.id.tv_musicName_two);
        TextView artist = mRoot.findViewById(R.id.tv_artist_two);
        View buttons = mRoot.findViewById(R.id.music_bar_buttons);

        if (cover != null) {
            setBox(cover, plan.coverPx, plan.coverPx, 0, 0);
        }
        if (column != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) column.getLayoutParams();
            int gap = plan.coverGapPx;
            if (lp.leftMargin != gap) {
                lp.leftMargin = gap;
                column.setLayoutParams(lp);
            }
        }
        applyText(title, plan);
        applyText(artist, plan);
        if (buttons != null && buttons.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) buttons.getLayoutParams();
            if (lp.width != plan.buttonBlockPx || lp.weight != 0f) {
                lp.width = plan.buttonBlockPx;
                lp.weight = 0f;
                buttons.setLayoutParams(lp);
            }
        }
        // Always 2 x 2: prev and next above play/pause and favorite. Only the sizes are set here.
        int[] cells = {R.id.constraint_layout_prev_two, R.id.constraint_layout_next_two,
                R.id.constraint_layout_playpause_two, R.id.constraint_layout_favorite_two};
        for (int i = 0; i < cells.length; i++) {
            View cell = mRoot.findViewById(cells[i]);
            if (cell == null || !(cell.getLayoutParams() instanceof FlexboxLayout.LayoutParams)) {
                continue;
            }
            FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) cell.getLayoutParams();
            if (lp.getFlexBasisPercent() != 0.5f || lp.getOrder() != i || lp.height != plan.buttonRowPx) {
                lp.setFlexBasisPercent(0.5f);
                lp.setOrder(i);
                lp.height = plan.buttonRowPx;
                cell.setLayoutParams(lp);
            }
        }
        sizeButtons(plan.buttonSidePx, R.id.music_prev_two, R.id.music_playpause_two,
                R.id.music_next_two, R.id.music_favorite_two);
    }

    /**
     * One font for both rows; the second row is hidden by the widget in the one-line mode. The
     * one line has no margin on top and the height of its whole room, so the column centres it,
     * and no font padding, so that the letters (not the padding) are centred; its size comes from
     * the box of the font this view really has.
     */
    private void applyText(TextView view, MusicWidgetPlan.Plan plan) {
        if (view == null) {
            return;
        }
        float textPx = plan.textPx;
        if (plan.oneLine && mBar) {
            textPx = plan.withFontRatio(fontRatio(view), mDensity).textPx;
        }
        setBox(view, ViewGroup.LayoutParams.MATCH_PARENT, plan.rowPx, plan.rowTopPx, 0);
        if (Math.abs(view.getTextSize() - textPx) > 0.5f) {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, textPx);
        }
        if (view.getGravity() != Gravity.CENTER) {
            view.setGravity(Gravity.CENTER);
        }
        boolean fontPadding = !(plan.oneLine && mBar);
        if (view.getIncludeFontPadding() != fontPadding) {
            view.setIncludeFontPadding(fontPadding);
        }
    }

    /** (descent - ascent) / size of the font of a view: the height of its box per unit of size. */
    private static float fontRatio(TextView view) {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setTypeface(view.getTypeface());
        paint.setTextSize(100f);
        android.graphics.Paint.FontMetrics fm = paint.getFontMetrics();
        return (fm.descent - fm.ascent) / 100f;
    }

    private void sizeButtons(int side, int... ids) {
        for (int id : ids) {
            View button = mRoot.findViewById(id);
            if (button == null) {
                continue;
            }
            ViewGroup.LayoutParams lp = button.getLayoutParams();
            if (lp instanceof ConstraintLayout.LayoutParams
                    && (lp.width != side || lp.height != side)) {
                lp.width = side;
                lp.height = side;
                button.setLayoutParams(lp);
            }
        }
    }

    /** Size and top margin (and the same margin on both sides) of a child of a LinearLayout. */
    private static void setBox(View view, int width, int height, int topMargin, int sideMargin) {
        ViewGroup.LayoutParams raw = view.getLayoutParams();
        if (!(raw instanceof LinearLayout.LayoutParams)) {
            return;
        }
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) raw;
        if (lp.width != width || lp.height != height || lp.topMargin != topMargin
                || lp.leftMargin != sideMargin || lp.rightMargin != sideMargin) {
            lp.width = width;
            lp.height = height;
            lp.topMargin = topMargin;
            lp.leftMargin = sideMargin;
            lp.rightMargin = sideMargin;
            view.setLayoutParams(lp);
        }
    }

    private static void setVisibility(View view, int visibility) {
        if (view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    private static Launcher launcherOf(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Launcher) {
                return (Launcher) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
