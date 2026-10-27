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
        MusicWidgetPlan.Plan plan;
        if (mBar) {
            int shortSide = Math.min(Launcher.screenWidth, Launcher.screenHeight);
            plan = MusicWidgetPlan.planBar(w, h, barH, shortSide, density);
            applyBar(plan, w);
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
        applyText(title, plan, plan.gapPx);
        applyText(artist, plan, plan.gapPx);
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
            int gap = w - plan.columnPx - plan.coverPx;
            if (lp.leftMargin != gap) {
                lp.leftMargin = gap;
                column.setLayoutParams(lp);
            }
        }
        applyText(title, plan, plan.gapPx);
        applyText(artist, plan, plan.gapPx);
        if (buttons != null) {
            setBox(buttons, ViewGroup.LayoutParams.MATCH_PARENT, plan.buttonRowPx, plan.gapPx, 0);
        }
        sizeButtons(plan.buttonSidePx, R.id.music_prev_two, R.id.music_playpause_two,
                R.id.music_next_two, R.id.music_favorite_two);
    }

    /** One font for both rows; the second row is hidden by the widget in the one-line mode. */
    private void applyText(TextView view, MusicWidgetPlan.Plan plan, int gap) {
        if (view == null) {
            return;
        }
        setBox(view, ViewGroup.LayoutParams.MATCH_PARENT, plan.rowPx, gap, 0);
        if (Math.abs(view.getTextSize() - plan.textPx) > 0.5f) {
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, plan.textPx);
        }
        if (view.getGravity() != Gravity.CENTER) {
            view.setGravity(Gravity.CENTER);
        }
        if (!view.getIncludeFontPadding()) {
            view.setIncludeFontPadding(true);
        }
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
