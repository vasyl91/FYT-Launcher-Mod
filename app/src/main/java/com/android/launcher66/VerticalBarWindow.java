package com.android.launcher66;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;
import com.android.recycler.VerticalAppListAdapter;


/**
 * The vertical bar of the pages that have no bar of their own ('Vertical bar on every page'): the same
 * bar, in a window above the pages. It lists the apps through the adapter of the first page's bar, so a
 * tap and a long press do what they do there, and it does not move while the pages do (the first page's
 * own bar leaves with its page, and the window is up from the first moment of the move, in the same
 * place, so that it covers that bar without a jump).
 *
 * <p>The window exists for as long as the mode is on, in standby (invisible, takes no touch) while the
 * first page rests, so that showing it is a change of alpha and of touchability: no inflation and no
 * addView in the middle of a gesture. {@link PersistentBarWindow} decides when; this class builds,
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

    VerticalBarWindow(Launcher launcher, Runnable onButton) {
        this.launcher = launcher;
        this.onButton = onButton;
        this.prefs = launcher.mPrefs != null ? launcher.mPrefs
                : PreferenceManager.getDefaultSharedPreferences(launcher);
    }

    boolean exists() {
        return root != null;
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
     * @return false if it could not be added (no permission for windows over other apps)
     */
    boolean build(int[] frame, int cornerSize, boolean cornerTop, boolean withCorner, boolean right,
                  boolean standby, int displayWidth) {
        if (root != null) {
            return true;
        }
        Context context = launcher;
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null) {
            return false;
        }
        LauncherAppBars bars = launcher.mAppBars;
        VerticalAppListAdapter adapter = bars.mVerticalAppListAdapter;
        root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);

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

        params = new WindowManager.LayoutParams(frame[2], frame[3],
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
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
            windowManager.addView(root, params);
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
        ViewTint.tintImage(arrow, prefs.getBoolean(Keys.BLACK_BAR, false));
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
    void setArrowTint(boolean black) {
        ViewTint.tintImage(arrow, black);
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
