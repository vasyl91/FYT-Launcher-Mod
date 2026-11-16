package com.android.launcher66;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;
import com.android.recycler.VerticalAppListAdapter;


/**
 * The vertical bar on every page ('Vertical bar on every page'), the first one too: the same bar as the
 * first page's, in a window above the pages. It lists the apps through the adapter of the first page's bar,
 * so a tap and a long press do what they do there, and it does not move while the pages do; the first
 * page's own bar is hidden meanwhile (PageBarSwap).
 *
 * <p>The window exists for as long as the mode is on and the launcher's window is there, in standby
 * (invisible, takes no touch) while something else takes the bar's place (the overview, a drag, a folder),
 * so that showing it again is a change of alpha and of touchability: no inflation and no addView.
 * {@link PersistentBarWindow} decides when; this class builds,
 * places and shows. When the page has the collapsed bar's button (auto-hide, the vertical bar and the
 * handle on the same side) the window takes the corner of the horizontal bar as well and draws the button
 * there.
 *
 * <p>What a window cannot do, as for the horizontal bar's window: an app dragged from the home screen
 * is not dropped on it, and the page is not swiped by a finger that starts on it. Main thread only.
 */
final class VerticalBarWindow {

    private static final String TAG = "VerticalBarWindow";
    private static final float BUTTON_ALPHA = 0.5f;

    private final Launcher launcher;
    private final Runnable onButton;
    private final android.content.SharedPreferences prefs;
    private WindowManager windowManager;
    private LinearLayout root;
    private RecyclerView recycler;
    private View corner;
    private ImageView arrow;
    private WindowManager.LayoutParams params;
    private boolean shown;
    /** {x, y, w, h} the window was put at, on the screen, and whether that is the right edge. */
    private int[] expected;
    private boolean expectedRight;
    private boolean placementChecked;
    /** The shift applied once because the window lay elsewhere than put (see checkPlacement()). */
    private int correction;
    private boolean cornerOnTop;
    /** The bar's own view and the picture of the corner, kept to give them a new background (BarBackground). */
    private View barView;
    private ImageView cornerBackground;
    private boolean onRight;
    /**
     * The part of the window's height the bar leaves to the first page's horizontal bar (VerticalBarCorner):
     * transparent, its touches handed to the launcher's window. At the top or at the bottom of the window.
     */
    private int cornerInset;
    private boolean cornerInsetTop;
    private int cornerInsetTarget;
    private ValueAnimator cornerAnimator;
    /** How long the bar takes to grow into the corner or to give it back. */
    private static final long CORNER_MS = 180;

    VerticalBarWindow(Launcher launcher, Runnable onButton) {
        this.launcher = launcher;
        this.onButton = onButton;
        this.prefs = launcher.mPrefs != null ? launcher.mPrefs
                : PreferenceManager.getDefaultSharedPreferences(launcher);
    }

    boolean exists() {
        return root != null;
    }

    /** The window's view, for a picture of the bar while the pages are small (PageBarGhost); null without a window. */
    android.view.View view() {
        return root;
    }

    boolean isShown() {
        return root != null && shown;
    }

    /**
     * Adds the window. In standby it is invisible and takes no touch.
     *
     * @param frame      {x, y, width, height} on the screen
     * @param cornerSize height of the part for the collapsed bar's button (the height of the horizontal
     *                   bar), 0 when the horizontal bar cannot be collapsed here
     * @param cornerTop  the button part is above the bar (the horizontal bar is at the top)
     * @param withCorner the page has the button now, so the window takes the corner
     * @param right      the bar is at the right edge
     * @param displayWidth the width of the display, for the offset from the right edge
     * @return false if it could not be added (the launcher's window is not there)
     */
    boolean build(int[] frame, int cornerSize, boolean cornerTop, boolean withCorner, boolean right,
                  boolean standby, int displayWidth) {
        if (root != null) {
            return true;
        }
        Context context = launcher;
        // The launcher's own window manager: a panel is added to the launcher's window (BarWindows)
        windowManager = launcher.getWindowManager();
        if (windowManager == null) {
            return false;
        }
        LauncherAppBars bars = launcher.mAppBars;
        VerticalAppListAdapter adapter = bars.mVerticalAppListAdapter;
        root = new CornerPassLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);
        applyCornerInset();

        FrameLayout bar = new FrameLayout(context);
        barView = bar;
        onRight = right;
        applyBackground(bar);
        recycler = new RecyclerView(context);
        Launcher.EvenVerticalLayoutManager manager =
                new Launcher.EvenVerticalLayoutManager(context.getApplicationContext(), bars.leftCapacity());
        manager.setFollowsCapacity(false);
        recycler.setLayoutManager(manager);
        recycler.setItemAnimator(null);
        if (adapter != null) {
            recycler.setAdapter(adapter);
        }
        bars.installLeftRecyclerDecorations(recycler);
        bar.addView(recycler, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        // The part for the button is always there when the bar can be collapsed, and is shown by the frame:
        // the window then does not have to be built again when the page changes
        cornerOnTop = cornerTop;
        if (cornerSize > 0) {
            corner = buildCorner(context, cornerTop);
            corner.setVisibility(withCorner ? View.VISIBLE : View.GONE);
            if (cornerTop) {
                root.addView(corner, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cornerSize));
            }
        }
        root.addView(bar, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));
        if (cornerSize > 0 && !cornerTop) {
            root.addView(corner, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cornerSize));
        }
        if (arrow != null) {
            arrow.setRotation(right ? 180f : 0f);
        }

        // A sub-panel of the launcher's window: over the panes, under every floating button (BarWindows)
        params = new WindowManager.LayoutParams(frame[2], frame[3],
                BarWindows.EVERY_PAGE_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | (standby ? WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE : 0),
                PixelFormat.TRANSLUCENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            params.layoutInDisplayCutoutMode =
                    WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        // From the edge the bar is on: the side is kept whatever the other edge's arithmetic is
        params.gravity = Gravity.TOP | (right ? Gravity.RIGHT : Gravity.LEFT);
        params.x = VerticalWindowFrame.offset(new VerticalWindowFrame.Frame(frame[0], frame[1], frame[2], frame[3]),
                displayWidth, right);
        params.y = frame[1];
        params.windowAnimations = 0;
        expected = frame.clone();
        expectedRight = right;
        placementChecked = false;
        root.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> checkPlacement());
        params.setTitle(TAG);
        root.setAlpha(standby ? 0f : 1f);
        shown = !standby;
        try {
            BarWindows.addEveryPageBar(windowManager, root, params, "Vertical bar window");
        } catch (RuntimeException e) {
            Log.w(TAG, "The vertical bar window could not be added", e);
            root = null;
            recycler = null;
            corner = null;
            arrow = null;
            return false;
        }
        return true;
    }

    private View buildCorner(Context context, boolean top) {
        FrameLayout cornerView = new FrameLayout(context);
        ImageView background = new ImageView(context);
        background.setScaleType(ImageView.ScaleType.FIT_XY);
        // The corner is the collapsed horizontal bar's: its background, turned as that bar's is
        background.setImageDrawable(BarBackground.horizontal(context, prefs, top));
        cornerBackground = background;
        cornerView.addView(background, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        arrow = new ImageView(context);
        arrow.setScaleType(ImageView.ScaleType.FIT_CENTER);
        arrow.setImageResource(R.drawable.show_bar);
        arrow.setAlpha(BUTTON_ALPHA);
        ViewTint.tintImage(arrow, WidgetStyler.barTint(prefs));
        FrameLayout.LayoutParams arrowParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        int pad = Math.round(context.getResources().getDisplayMetrics().density * 8);
        arrow.setPadding(pad, pad, pad, pad);
        cornerView.addView(arrow, arrowParams);
        cornerView.setOnClickListener(v -> {
            if (onButton != null) {
                onButton.run();
            }
        });
        return cornerView;
    }

    private void applyBackground(View bar) {
        bar.setBackground(BarBackground.vertical(bar.getContext(), prefs, onRight));
    }

    /**
     * The place and the size, when they changed.
     *
     * @param frame      {x, y, width, height} on the screen
     * @param withCorner the page has the button now: the corner is part of the window
     */
    /**
     * The bar leaves {@code inset} px of the window's height to the first page's horizontal bar, or none
     * (VerticalBarCorner). The window keeps its frame; only the bar inside it grows or shrinks.
     *
     * @param top     the corner is at the top of the window (the horizontal bar is at the top)
     * @param animate in a short animation (while the pages move), else at once
     * @return whether the inset is to change
     */
    boolean setCornerInset(int inset, boolean top, boolean animate) {
        int target = Math.max(0, inset);
        if (target == cornerInsetTarget && top == cornerInsetTop) {
            return false;
        }
        cornerInsetTarget = target;
        cornerInsetTop = top;
        if (cornerAnimator != null) {
            cornerAnimator.cancel();
            cornerAnimator = null;
        }
        if (!animate || root == null || !root.isAttachedToWindow() || !shown) {
            cornerInset = target;
            applyCornerInset();
            return true;
        }
        ValueAnimator animator = ValueAnimator.ofInt(cornerInset, target);
        animator.setDuration(CORNER_MS);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(a -> {
            cornerInset = (int) a.getAnimatedValue();
            applyCornerInset();
        });
        cornerAnimator = animator;
        animator.start();
        return true;
    }

    private void applyCornerInset() {
        if (root != null) {
            root.setPadding(0, cornerInsetTop ? cornerInset : 0, 0, cornerInsetTop ? 0 : cornerInset);
        }
    }

    /**
     * The picture of the bar for the pages after the first while they are small (PageBarGhost): at the whole
     * height of the window, as the bar is on those pages. On the first page the bar leaves the corner to that
     * page's horizontal bar (VerticalBarCorner); recorded as it is, the picture was shorter by the corner on the
     * pages that have no horizontal bar (the owner, A55, 2026-11-16). The bar is laid out at the whole height,
     * recorded and laid out again with its inset in one step on the main thread: no frame is drawn in between,
     * so nothing changes on the screen.
     */
    PageBarGhost.Shot recordAtFullHeight() {
        if (root == null) {
            return null;
        }
        if (cornerInset <= 0) {
            return PageBarGhost.record(root);
        }
        int width = root.getWidth();
        int height = root.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        root.setPadding(0, 0, 0, 0);
        layoutNow(width, height);
        try {
            return PageBarGhost.record(root);
        } finally {
            applyCornerInset();
            layoutNow(width, height);
        }
    }

    private void layoutNow(int width, int height) {
        root.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
        root.layout(root.getLeft(), root.getTop(), root.getLeft() + width, root.getTop() + height);
    }

    /** The window's left and right edge on the screen, as last put; null before it is built. */
    int[] horizontalEdges() {
        return expected == null ? null : new int[] {expected[0], expected[0] + expected[2]};
    }

    /**
     * The window's root: a touch that starts in the corner the bar leaves free is the first page's horizontal
     * bar's, which lies under it, and goes to the launcher's window with its coordinates moved, as the edge handle
     * hands touches on (HorizontalBarEdgeHandle).
     */
    private final class CornerPassLayout extends LinearLayout {
        private boolean passing;

        CornerPassLayout(Context context) {
            super(context);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            int action = event.getActionMasked();
            if (action == MotionEvent.ACTION_DOWN) {
                passing = cornerInset > 0 && (cornerInsetTop ? event.getY() < cornerInset
                        : event.getY() >= getHeight() - cornerInset);
            }
            if (!passing) {
                return super.dispatchTouchEvent(event);
            }
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                passing = false;
            }
            View target = launcher.getWindow() == null ? null : launcher.getWindow().getDecorView();
            if (target == null || !target.isAttachedToWindow()) {
                return true;
            }
            int[] windowAt = new int[2];
            int[] targetAt = new int[2];
            getLocationOnScreen(windowAt);
            target.getLocationOnScreen(targetAt);
            MotionEvent copy = MotionEvent.obtain(event);
            copy.offsetLocation(windowAt[0] - targetAt[0], windowAt[1] - targetAt[1]);
            try {
                target.dispatchTouchEvent(copy);
            } finally {
                copy.recycle();
            }
            return true;
        }
    }

    void setFrame(int[] frame, boolean withCorner, boolean right, int displayWidth) {
        if (root == null || params == null) {
            return;
        }
        if (corner != null) {
            int visibility = withCorner ? View.VISIBLE : View.GONE;
            if (corner.getVisibility() != visibility) {
                corner.setVisibility(visibility);
            }
        }
        int gravity = Gravity.TOP | (right ? Gravity.RIGHT : Gravity.LEFT);
        int x = VerticalWindowFrame.offset(new VerticalWindowFrame.Frame(frame[0], frame[1], frame[2], frame[3]),
                displayWidth, right);
        expected = frame.clone();
        expectedRight = right;
        if (params.gravity == gravity && params.x == x + correction && params.y == frame[1]
                && params.width == frame[2] && params.height == frame[3]) {
            return;
        }
        params.gravity = gravity;
        params.x = x + correction;
        params.y = frame[1];
        params.width = frame[2];
        params.height = frame[3];
        update();
    }

    /**
     * Once, after the first layout: where the window really is on the screen, against where it was put. A window
     * that lies elsewhere (on the other side, say) is moved by the difference, once, and the log says so.
     */
    private void checkPlacement() {
        if (placementChecked || root == null || params == null || expected == null || !root.isAttachedToWindow()
                || root.getWidth() <= 0) {
            return;
        }
        placementChecked = true;
        int[] at = new int[2];
        root.getLocationOnScreen(at);
        int dx = expected[0] - at[0];
        int dy = expected[1] - at[1];
        Log.i(TAG, "Persistent vertical bar window is at " + at[0] + "," + at[1] + " on the screen");
        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            Log.w(TAG, "Persistent vertical bar window placed at " + at[0] + "," + at[1] + " instead of "
                    + expected[0] + "," + expected[1] + ", moved by " + dx + "," + dy);
            correction += expectedRight ? -dx : dx;
            params.x += expectedRight ? -dx : dx;
            params.y += dy;
            update();
        }
    }

    /** A background chosen while the window is up: the bar's, and the horizontal bar's in the corner. */
    void refreshBackgrounds() {
        if (barView != null) {
            applyBackground(barView);
        }
        if (cornerBackground != null) {
            cornerBackground.setImageDrawable(
                    BarBackground.horizontal(cornerBackground.getContext(), prefs, cornerOnTop));
        }
    }

    /** The colour of the arrow follows "Bar text and button color" (WidgetStyler). */
    void setArrowTint(int tint) {
        ViewTint.tintImage(arrow, tint);
    }

    /** The button's arrow points to the middle of the screen: turned on the right. */
    void setArrowRotation(float degrees) {
        if (arrow != null) {
            arrow.setRotation(degrees);
        }
    }

    void setShown(boolean value) {
        if (root == null) {
            return;
        }
        shown = value;
        root.animate().cancel();
        root.setAlpha(value ? 1f : 0f);
        setTouchable(value);
    }

    /**
     * The first step of putting the window away: it counts as put away and takes no touch at once, but is
     * still seen until {@link #finishPark()}, so that the first page can draw its own bar under it first
     * (PageBarSwap).
     */
    void park() {
        if (root == null) {
            return;
        }
        shown = false;
        setTouchable(false);
    }

    /** The second step: the window is invisible, unless it was shown again since {@link #park()}. */
    void finishPark() {
        if (root == null || shown) {
            return;
        }
        root.animate().cancel();
        root.setAlpha(0f);
    }

    /** Fades the button part (not the bar) with the bar's reveal and return. */
    void setButtonShown(boolean visible, long durationMs) {
        if (corner == null) {
            return;
        }
        corner.animate().cancel();
        float alpha = visible ? 1f : 0f;
        if (durationMs <= 0) {
            corner.setAlpha(alpha);
        } else {
            corner.animate().alpha(alpha).setDuration(durationMs).start();
        }
        corner.setClickable(visible);
    }

    /** The first page's list changed: the window's recycler follows it. */
    void rebindAdapter() {
        if (recycler == null) {
            return;
        }
        VerticalAppListAdapter adapter = launcher.mAppBars.mVerticalAppListAdapter;
        if (adapter != null && recycler.getAdapter() != adapter) {
            recycler.setAdapter(adapter);
        }
    }

    void remove() {
        if (root == null) {
            return;
        }
        root.animate().cancel();
        if (cornerAnimator != null) {
            cornerAnimator.cancel();
            cornerAnimator = null;
        }
        cornerInset = 0;
        cornerInsetTarget = 0;
        try {
            if (recycler != null) {
                recycler.setAdapter(null);
            }
            windowManager.removeViewImmediate(root);
        } catch (RuntimeException e) {
            Log.w(TAG, "Removing the vertical bar window failed", e);
        }
        root = null;
        recycler = null;
        corner = null;
        arrow = null;
        barView = null;
        cornerBackground = null;
        params = null;
        shown = false;
    }

    private void setTouchable(boolean touchable) {
        if (params == null) {
            return;
        }
        int flags = touchable
                ? params.flags & ~WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                : params.flags | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        if (flags == params.flags) {
            return;
        }
        params.flags = flags;
        update();
    }

    private void update() {
        try {
            windowManager.updateViewLayout(root, params);
        } catch (RuntimeException e) {
            Log.w(TAG, "Updating the vertical bar window failed", e);
        }
    }
}
