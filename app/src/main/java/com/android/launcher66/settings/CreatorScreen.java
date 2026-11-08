package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.android.launcher66.BarConstraints;
import com.android.launcher66.CreatorBars;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

/**
 * The fragment of the layout creator, for every page of the home screen (see {@link DrawViewScreen} for what
 * is the same on every page and what differs). The page travels in the arguments Bundle, which the system saves
 * itself: a Fragment must have a public no-arg constructor, and one that took the page made FragmentManager
 * throw InstantiationException on state restore (rotation, theme change, return after process death).
 */
public class CreatorScreen extends Fragment {

    private static final String TAG = "CreatorScreen";
    private static final String ARG_PAGE = "page";

    /** Smallest share of its scaled size the confirm text may auto-shrink to. */
    private static final float CONFIRM_TEXT_MIN_FRACTION = 0.5f;

    private Helpers helpers;
    private SharedPreferences sharedPrefs;
    private ConstraintLayout layout;
    private DrawViewScreen canvas;
    private OnBackPressedCallback backPressedCallback;
    private OneShotPreDrawCheck arrowControlsFit;
    /** 0 for the first page. */
    private int mPage;
    private CreatorPage mCreatorPage;

    public CreatorScreen() {
        super();
    }

    /** @param page the page, 0 for the first */
    public static CreatorScreen newInstance(int page) {
        CreatorScreen fragment = new CreatorScreen();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helpers = new Helpers();
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            AppCompatActivity act = (AppCompatActivity) getActivity();
            if (act != null && act.getSupportActionBar() != null) {
                act.getSupportActionBar().hide();
            }
        } catch (Exception ignore) {}
        
        Context mContext = getContext();
        if (mContext == null) {
            return null;
        }

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mCreatorPage = CreatorPage.of(mPage, snapshot(sharedPrefs));
        final CreatorBars bars = mCreatorPage.bars;
        View rootView = inflater.inflate(R.layout.creator_screen, container, false);
        layout = rootView.findViewById(R.id.creator_screen);
        // The horizontal bar at the top: the controls go to the top and the canvas spans the whole height, so that
        // the coordinates stay those of the launcher's box (the band of the bar is kept free by the top inset)
        if (bars.top && rootView instanceof ConstraintLayout) {
            BarConstraints.apply((ConstraintLayout) rootView, R.id.creator_bar, R.id.creator_screen, true, false);
        }
        canvas = new DrawViewScreen(inflater, rootView, mContext, mPage);
        // The vertical bar's band beside the canvas, and the button or the handle's strip: both under the controls
        float verticalShare = 0f;
        if (rootView instanceof ConstraintLayout) {
            verticalShare = geometry(mContext).verticalBarShare();
            if (mCreatorPage.verticalOnPage) {
                CreatorBarBand.add(mContext, sharedPrefs, (ConstraintLayout) rootView, layout, bars, verticalShare,
                        mPage);
            }
            CreatorBarMarks marks = CreatorBarMarks.install((ConstraintLayout) rootView,
                    rootView.findViewById(R.id.creator_bar), bars, verticalShare);
            canvas.setBarMarks(marks, bars);
        }
        // After the canvas: its constructor gives the bar controls their base sizes, which the
        // resizable bar then scales. No-op while Keys.RESIZABLE_HORIZONTAL_BAR is off.
        applyResizableHorizontalBar(rootView, mContext);
        for (String key : mCreatorPage.elements) {
            addRectangle(mContext, key);
        }
        if (layout != null) {
            layout.addView(canvas);
        }
        return rootView;
    }

    /** The settings the creator of a page reads, as CreatorPage takes them. */
    private static CreatorPage.Snapshot snapshot(SharedPreferences prefs) {
        return new CreatorPage.Snapshot() {
            @Override
            public boolean bool(String key) {
                return prefs.getBoolean(key, false);
            }

            @Override
            public boolean boolOr(String key, boolean defaultValue) {
                return prefs.getBoolean(key, defaultValue);
            }

            @Override
            public int screenOf(String screenKey) {
                return prefs.getInt(screenKey, 1);
            }
        };
    }

    /** The rectangle of an element on this page: its name, colour and whether it is resizable as the canvas has always had them. */
    private void addRectangle(Context context, String key) {
        switch (key) {
            case "pipDual": {
                String first = getAppNameFromPackage(sharedPrefs.getString(Keys.PIP_FIRST_PACKAGE, ""));
                String second = getAppNameFromPackage(sharedPrefs.getString(Keys.PIP_SECOND_PACKAGE, ""));
                String name = TextUtils.isEmpty(first) || TextUtils.isEmpty(second)
                        ? context.getString(R.string.pref_dual_pip_title) : first + " / " + second;
                canvas.addRectangle(name, key, "#55FFFFFF", true);
                break;
            }
            case "pipFirst":
                canvas.addRectangle(pipName(context, Keys.PIP_FIRST_PACKAGE, R.string.pref_first_pip_title), key,
                        "#55FFFFFF", true);
                break;
            case "pipSecond":
                canvas.addRectangle(pipName(context, Keys.PIP_SECOND_PACKAGE, R.string.pref_second_pip_title), key,
                        "#55FFFFFF", true);
                break;
            case "pipThird":
                canvas.addRectangle(pipName(context, Keys.PIP_THIRD_PACKAGE, R.string.pref_third_pip_title), key,
                        "#55FFFFFF", true);
                break;
            case "pipFourth":
                canvas.addRectangle(pipName(context, Keys.PIP_FOURTH_PACKAGE, R.string.pref_fourth_pip_title), key,
                        "#55FFFFFF", true);
                break;
            case "date":
                canvas.addRectangle("Date", key, "#ff4285f4", true);
                break;
            case "music":
                canvas.addRectangle("Music", key, "#FFBB86FC", true);
                break;
            case "radio":
                canvas.addRectangle("Radio", key, "#e2e732", true);
                break;
            case "stats":
                canvas.addRectangle("Stats", key, "#0ca7f5", false);
                break;
            default:
                break;
        }
    }

    private String pipName(Context context, String packageKey, int fallbackTitle) {
        String name = getAppNameFromPackage(sharedPrefs.getString(packageKey, ""));
        return TextUtils.isEmpty(name) ? context.getString(fallbackTitle) : name;
    }

    /**
     * The geometry the launcher's box has and the preview is made in proportion to: the box the bar and the
     * widgets live in, the horizontal bar in it, and the vertical bar's width.
     */
    private final class Geometry {
        final int rootWidth;
        final int rootHeight;
        final int barHeight;
        final int legacyBarHeight;
        final int verticalBarWidth;
        final boolean portrait;

        Geometry(Context context) {
            portrait = HorizontalBarDimensions.isPortrait(context);
            Point screen = HorizontalBarDimensions.resolveScreenSize(context);
            int statusBarHeight = HorizontalBarDimensions.getStatusBarHeight(context.getResources());
            // The box the launcher gives the bar and the widgets, and the bar inside it - exactly the
            // geometry Helpers checks the saved positions against.
            rootWidth = HorizontalBarDimensions.getBarRootWidth(screen.x);
            rootHeight = HorizontalBarDimensions.getBarRootHeight(screen.y, statusBarHeight);
            barHeight = HorizontalBarDimensions.computeBarHeight(sharedPrefs, portrait, rootWidth, rootHeight, 0);
            legacyBarHeight = HorizontalBarDimensions.computeLegacyBarHeight(portrait, rootWidth, rootHeight, 0);
            // The launcher shifts everything on a page with the vertical bar by Launcher.calculatedVerticalBarWidth
            // (CellLayout placeholders, PiP panes), so the canvas has to leave exactly that room. In
            // portrait the bar is 7.1 % of its HEIGHT, not of the width.
            verticalBarWidth = com.android.launcher66.Launcher.calculatedVerticalBarWidth > 0
                    ? com.android.launcher66.Launcher.calculatedVerticalBarWidth
                    : (int) HorizontalBarDimensions.computeVerticalBarWidth(portrait, rootWidth, rootHeight, legacyBarHeight);
        }

        boolean known() {
            return rootWidth > 0 && rootHeight > 0 && barHeight > 0 && legacyBarHeight > 0;
        }

        /** The vertical bar's width as a share of the box's: the band keeps it whatever room the creator has. */
        float verticalBarShare() {
            return rootWidth > 0 ? Math.min(0.5f, verticalBarWidth / (float) rootWidth) : 0.071f;
        }
    }

    private Geometry geometry(Context context) {
        return new Geometry(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backPressedCallback = new OnBackPressedCallback(true) {
            @Override 
            public void handleOnBackPressed() {
                if (helpers != null) {
                    helpers.setBackFromCreator(true);
                }
                if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
                    requireActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(android.R.id.content, new SettingsFragmentSecond())
                            .commit();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), backPressedCallback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // The width check holds the bar views until it has run - drop it with the view.
        if (arrowControlsFit != null) {
            arrowControlsFit.remove();
            arrowControlsFit = null;
        }

        // Cleared in finally, not inside the try: when removeAllViews() threw, layout and
        // canvas stayed attached to the fragment, and mContext == SettingsActivity with them.
        try {
            if (layout != null) {
                layout.setOnClickListener(null);
                layout.setOnTouchListener(null);
                layout.removeAllViews();
            }
            if (canvas != null) {
                canvas.setOnClickListener(null);
                canvas.setOnTouchListener(null);
                canvas.clearAnimation();
            }
        } catch (Exception ignore) {
        } finally {
            layout = null;
            canvas = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        
        // Clean up callback
        if (backPressedCallback != null) {
            backPressedCallback.remove();
            backPressedCallback = null;
        }
        
        // Clear references
        helpers = null;
        sharedPrefs = null;
    }

    // -------------------------------------------------------------------------------------------
    // Resizable horizontal bar
    // -------------------------------------------------------------------------------------------

    /**
     * Lines the creator preview up with the launcher: the canvas gets the launcher's free area as
     * its coordinate space (scaled to fit the settings window, which can be smaller), and the bar
     * gets the configured height.
     *
     * Keys.RESIZABLE_HORIZONTAL_BAR off: nothing is touched, creator*.xml keeps sizing the bar
     * (layout_constraintHeight_percent="0.1638" in landscape, layout_constraintDimensionRatio="H,0.142"
     * in portrait).
     *
     * On:
     *  1. The bar containers get the exact pixel height of the shortest-edge rule (portrait: screen
     *     width, landscape: screen height minus status bar), with their XML ratio/percent cleared.
     *  2. Everything inside the bar that has an absolute size scales by newHeight / legacyHeight:
     *     the arrow buttons and their labels, the selection texts and the confirm text. Containers
     *     that are match_parent or a percentage of creator_bar (creator_selection, creator_buttons,
     *     buttons_left/right, confirm_layout) follow the new height by themselves.
     *  3. When the controls grew, a one-shot check after layout shrinks them back if they no longer
     *     fit the width of creator_buttons (the XML only fixes their share of the width).
     */
    private void applyResizableHorizontalBar(@NonNull View rootView, @NonNull Context context) {
        Geometry geo = geometry(context);
        if (!geo.known()) {
            Log.w(TAG, "Bar geometry unknown (" + geo.rootWidth + "x" + geo.rootHeight + "), leaving the XML alone");
            return;
        }
        final boolean portrait = geo.portrait;
        final int rootWidth = geo.rootWidth;
        final int rootHeight = geo.rootHeight;
        final int barHeight = geo.barHeight;
        final int legacyBarHeight = geo.legacyBarHeight;
        final CreatorBars bars = mCreatorPage.bars;

        // 1. The canvas mirrors the launcher's free area 1:1 - that is the space the positions are
        //    saved in - and scales itself into whatever room the creator screen has. The settings
        //    window can be smaller than the launcher's (system bars), and without this the canvas
        //    silently became a different coordinate space than the launcher's.
        int verticalBarWidth = mCreatorPage.verticalOnPage ? geo.verticalBarWidth : 0;
        int workspaceWidth = rootWidth - verticalBarWidth;
        // With auto-hide the workspace keeps the full height, and so does a page that has no horizontal bar; only the
        // collapsed button is reserved. (a bar at the top leaves the canvas the whole height too, its band is kept
        // free by the topInset)
        final boolean autoHideHorizontalBar = bars.collapsible;
        final boolean fullHeight = autoHideHorizontalBar || !mCreatorPage.horizontalOnPage;
        int workspaceHeight = fullHeight || bars.top ? rootHeight : rootHeight - barHeight;
        View canvasArea = rootView.findViewById(R.id.creator_screen);
        if (fullHeight) {
            // The auto-hide bar lies on top of the workspace instead of reserving room for it, so
            // the preview keeps the full height and the bar covers its bottom - as in the launcher.
            // It also means the preview does not jump when the bar is toggled with a double tap.
            spanToParentBottom(canvasArea);
        }
        if (canvasArea != null) {
            // The preview keeps the launcher's proportions, so a strip can be left beside it;
            // painting it in the canvas colour keeps it from looking like another bar.
            canvasArea.setBackgroundColor(DrawViewScreen.CANVAS_BACKGROUND_COLOR);
        }
        if (canvas != null) {
            canvas.setTopInset(bars.top && mCreatorPage.horizontalOnPage && !autoHideHorizontalBar ? barHeight : 0);
            canvas.setWorkspaceArea(workspaceWidth, workspaceHeight);
        }
        Log.d(TAG, "Bar geometry: box " + rootWidth + "x" + rootHeight + ", bar " + barHeight
                + "px, canvas area " + workspaceWidth + "x" + workspaceHeight + ", page " + (mPage + 1));

        boolean resizableHorizontalBar = sharedPrefs.getBoolean(Keys.RESIZABLE_HORIZONTAL_BAR, false);
        if (!resizableHorizontalBar) {
            return; // creator*.xml keeps sizing the bar itself
        }

        // 2. Bar containers: exact pixel height, conflicting XML ratio / percent cleared.
        HorizontalBarDimensions.applyExactHeight(rootView.findViewById(R.id.creator_bar), barHeight);
        // (the collapsed bar's button and the handle's strip take the height of this bar themselves, CreatorBarMarks)

        // 3. Children with absolute sizes (given by DrawViewScreen) scale with the bar.
        float scale = (float) barHeight / legacyBarHeight;
        if (Math.abs(scale - 1f) < 0.001f) {
            return;
        }
        scaleArrowControls(rootView, scale);
        scaleSelectionTexts(rootView, scale);
        scaleConfirmText(rootView.findViewById(R.id.confirm_layout), scale);

        // 4. Growing can overflow the fixed-width controls area; shrinking never can.
        if (scale > 1f) {
            fitArrowControlsToWidth(rootView);
        }
        Log.d(TAG, "Resizable horizontal bar: " + barHeight + "px (legacy " + legacyBarHeight
                + "px), controls x" + scale);
    }

    /**
     * Lets the view fill its parent down to the bottom edge instead of stopping at the bar above
     * it (creator*.xml constrains it to creator_bar).
     */
    private static void spanToParentBottom(@Nullable View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof ConstraintLayout.LayoutParams)) {
            return;
        }
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) params;
        if (lp.bottomToBottom == ConstraintLayout.LayoutParams.PARENT_ID
                && lp.bottomToTop == ConstraintLayout.LayoutParams.UNSET) {
            return;
        }
        lp.bottomToTop = ConstraintLayout.LayoutParams.UNSET;
        lp.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        view.setLayoutParams(lp);
    }

    /** Arrow buttons (up/down/left/right) and their labels inside creator_buttons. */
    private static void scaleArrowControls(@NonNull View rootView, float scale) {
        int[] buttonIds = {
                R.id.top_up, R.id.top_down, R.id.bottom_up, R.id.bottom_down,
                R.id.left_to_left, R.id.left_to_right, R.id.right_to_left, R.id.right_to_right
        };
        for (int id : buttonIds) {
            scaleViewSize(rootView.findViewById(id), scale);
        }
        int[] labelIds = {
                R.id.top_button_string, R.id.bottom_button_string,
                R.id.left_button_string, R.id.right_button_string
        };
        for (int id : labelIds) {
            scaleTextSize(rootView.findViewById(id), scale);
        }
    }

    /** "Selected widget" caption and the marquee with the rectangle name (creator_selection). */
    private static void scaleSelectionTexts(@NonNull View rootView, float scale) {
        scaleTextSize(rootView.findViewById(R.id.selected_widget_string), scale);
        scaleTextSize(rootView.findViewById(R.id.rectangle_name), scale);
    }

    /**
     * confirm_layout is a fixed share of the bar (15% wide, 80% high): its height follows the bar
     * on its own, its width does not. The text scales with the bar and may shrink to stay inside.
     */
    private static void scaleConfirmText(@Nullable TextView confirm, float scale) {
        if (confirm == null) {
            return;
        }
        scaleTextSize(confirm, scale);
        int maxPx = Math.round(confirm.getTextSize());
        int minPx = Math.max(1, Math.round(maxPx * CONFIRM_TEXT_MIN_FRACTION));
        if (maxPx > minPx) {
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                    confirm, minPx, maxPx, 1, TypedValue.COMPLEX_UNIT_PX);
        }
    }

    /**
     * After the first layout: if the scaled controls are wider than creator_buttons, scale them
     * down to fit and skip that frame, so an overlapping state is never drawn.
     */
    private void fitArrowControlsToWidth(@NonNull View rootView) {
        final ViewGroup controls = rootView.findViewById(R.id.creator_buttons);
        if (controls == null) {
            return;
        }
        if (arrowControlsFit != null) {
            arrowControlsFit.remove();
        }
        arrowControlsFit = new OneShotPreDrawCheck(controls, () -> {
            arrowControlsFit = null;
            int available = controls.getWidth() - controls.getPaddingLeft() - controls.getPaddingRight();
            int needed = 0;
            for (int i = 0; i < controls.getChildCount(); i++) {
                View child = controls.getChildAt(i);
                if (child.getVisibility() != View.GONE) {
                    needed += child.getMeasuredWidth();
                }
            }
            if (available <= 0 || needed <= available) {
                return true;
            }
            // 2% headroom: per-view rounding must not leave the controls a pixel too wide, as
            // there is no second check.
            float fit = (available * 0.98f) / needed;
            Log.d(TAG, "Bar controls need " + needed + "px of " + available + "px, scaling by " + fit);
            scaleArrowControls(controls, fit);
            return false; // cancel this frame, the next one is laid out with the fitted sizes
        });
    }

    private static void scaleViewSize(@Nullable View view, float scale) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            return;
        }
        boolean changed = false;
        if (params.width > 0) {
            int width = Math.max(1, Math.round(params.width * scale));
            changed = width != params.width;
            params.width = width;
        }
        if (params.height > 0) {
            int height = Math.max(1, Math.round(params.height * scale));
            changed |= height != params.height;
            params.height = height;
        }
        if (changed) {
            view.setLayoutParams(params);
        }
    }

    private static void scaleTextSize(@Nullable TextView textView, float scale) {
        if (textView == null) {
            return;
        }
        float sizePx = textView.getTextSize();
        if (sizePx > 0f) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizePx * scale);
        }
    }

    /**
     * Pre-draw hook that runs once and may cancel the frame. It unregisters itself after running
     * or when the view is detached first (e.g. the fragment is left before the first draw), so it
     * can never keep the fragment's views alive in the window's ViewTreeObserver.
     */
    private static final class OneShotPreDrawCheck
            implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        interface Action {
            /** @return false to cancel the current frame. */
            boolean run();
        }

        private final View view;
        private final Action action;
        private ViewTreeObserver observer;
        private boolean removed;

        OneShotPreDrawCheck(@NonNull View view, @NonNull Action action) {
            this.view = view;
            this.action = action;
            this.observer = view.getViewTreeObserver();
            observer.addOnPreDrawListener(this);
            view.addOnAttachStateChangeListener(this);
        }

        @Override
        public boolean onPreDraw() {
            remove();
            return action.run();
        }

        void remove() {
            if (removed) {
                return;
            }
            removed = true;
            if (observer.isAlive()) {
                observer.removeOnPreDrawListener(this);
            } else {
                // Registered before attach: that observer was merged into the window's one.
                view.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override
        public void onViewAttachedToWindow(@NonNull View v) {
            observer = v.getViewTreeObserver();
        }

        @Override
        public void onViewDetachedFromWindow(@NonNull View v) {
            remove();
        }
    }

    private static String getAppNameFromPackage(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return "";
        }
        
        try {
            Context appContext = LauncherApplication.sApp;
            if (appContext != null) {
                PackageManager packageManager = appContext.getPackageManager();
                ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 0);
                return packageManager.getApplicationLabel(appInfo).toString();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Log.e("CreatorScreen", "Error getting app name", e);
        }
        return "";
    }
}
