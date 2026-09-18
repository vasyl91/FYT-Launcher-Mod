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

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

public class CreatorFirstScreen extends Fragment {

    // Fragment that opens DrawViewFirstScreen.java where user can create the layout

    private static final String TAG = "CreatorFirstScreen";

    /** Smallest share of its scaled size the confirm text may auto-shrink to. */
    private static final float CONFIRM_TEXT_MIN_FRACTION = 0.5f;

    private Helpers helpers;
    private SharedPreferences sharedPrefs;
    private ConstraintLayout layout;
    private DrawViewFirstScreen canvas;
    private OnBackPressedCallback backPressedCallback;
    private OneShotPreDrawCheck arrowControlsFit;

    public static boolean pip = false;
    public static boolean dualPip = false;
    public static boolean firstPip = false;
    public static boolean secondPip = false;
    public static boolean thirdPip = false;
    public static boolean fourthPip = false;
    public static boolean date = false;
    public static boolean music = false;
    public static boolean radio = false;
    public static boolean stats = false; 

    public CreatorFirstScreen() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helpers = new Helpers();
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
        
        View rootView;
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        boolean leftBar = sharedPrefs.getBoolean(Keys.LEFT_BAR, false);
        pip = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, false);
        dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);
        firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
        String firstPkg = sharedPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        String secondPkg = sharedPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        String thirdPkg = sharedPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        String fourthPkg = sharedPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        String pipFirstName = getAppNameFromPackage(firstPkg);
        String pipSecondName = getAppNameFromPackage(secondPkg);
        date = sharedPrefs.getBoolean(Keys.USER_DATE, true);
        music = sharedPrefs.getBoolean(Keys.USER_MUSIC, true);
        radio = sharedPrefs.getBoolean(Keys.USER_RADIO, true); 
        stats = sharedPrefs.getBoolean(Keys.USER_STATS, true);        
        if (leftBar) {           
            rootView = inflater.inflate(R.layout.creator_left, container, false);
        } else {
            rootView = inflater.inflate(R.layout.creator, container, false);
        }
        layout = rootView.findViewById(R.id.creator_first_screen);
        canvas = new DrawViewFirstScreen(inflater, rootView, mContext);
        // After the canvas: its constructor gives the bar controls their base sizes, which the
        // resizable bar then scales. No-op while Keys.RESIZABLE_BOTTOM_BAR is off.
        applyResizableBottomBar(rootView, mContext);
        if (pip && dualPip && !firstPip && !secondPip && compareScreens(Keys.PIP_DUAL_SCREEN)) {
            String pipDualName;
            if (TextUtils.isEmpty(pipFirstName) || TextUtils.isEmpty(pipSecondName)) {
                pipDualName = (mContext.getString(R.string.pref_dual_pip_title));
            } else {
                pipDualName = pipFirstName + " / " + pipSecondName;
            }
            canvas.addRectangle(pipDualName, "pipDual", "#55FFFFFF", true); 
        }
        if (pip && firstPip && !dualPip && compareScreens(Keys.PIP_FIRST_SCREEN)) {
            if (TextUtils.isEmpty(pipFirstName)) {
                pipFirstName = (mContext.getString(R.string.pref_first_pip_title));
            }
            canvas.addRectangle(pipFirstName, "pipFirst", "#55FFFFFF", true); 
        }
        if (pip && secondPip && !dualPip && compareScreens(Keys.PIP_SECOND_SCREEN)) {
            if (TextUtils.isEmpty(pipSecondName)) {
                pipSecondName = (mContext.getString(R.string.pref_second_pip_title));
            }
            canvas.addRectangle(pipSecondName, "pipSecond", "#55FFFFFF", true); 
        }
        if (pip && thirdPip && compareScreens(Keys.PIP_THIRD_SCREEN)) {
            String pipThirdName = getAppNameFromPackage(thirdPkg);
            if (TextUtils.isEmpty(pipThirdName)) {
                pipThirdName = (mContext.getString(R.string.pref_third_pip_title));
            }
            canvas.addRectangle(pipThirdName, "pipThird", "#55FFFFFF", true); 
        }
        if (pip && fourthPip && compareScreens(Keys.PIP_FOURTH_SCREEN)) {
            String pipFourthName = getAppNameFromPackage(fourthPkg);
            if (TextUtils.isEmpty(pipFourthName)) {
                pipFourthName = (mContext.getString(R.string.pref_fourth_pip_title));
            }
            canvas.addRectangle(pipFourthName, "pipFourth", "#55FFFFFF", true); 
        }
        if (date && compareScreens(Keys.DATE_SCREEN)) {
            canvas.addRectangle("Date", "date", "#ff4285f4", true);
        }
        if (music && compareScreens(Keys.MUSIC_SCREEN)) {
            canvas.addRectangle("Music", "music", "#FFBB86FC", true); 
        }
        if (radio && compareScreens(Keys.RADIO_SCREEN)) {
            canvas.addRectangle("Radio", "radio", "#e2e732", true);
        }
        if (stats && compareScreens(Keys.STATS_SCREEN)) {
            canvas.addRectangle("Stats", "stats", "#0ca7f5", false);
        }
        if (layout != null) {
            layout.addView(canvas);
        }
        return rootView;
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
    // Resizable bottom bar
    // -------------------------------------------------------------------------------------------

    /**
     * Gives the creator preview the same bottom bar height the launcher uses.
     *
     * Keys.RESIZABLE_BOTTOM_BAR off: nothing is touched, creator*.xml keeps sizing the bar
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
    private void applyResizableBottomBar(@NonNull View rootView, @NonNull Context context) {
        boolean resizableBottomBar = sharedPrefs.getBoolean(Keys.RESIZABLE_BOTTOM_BAR, false);
        if (!resizableBottomBar) {
            return;
        }

        boolean portrait = BottomBarDimensions.isPortrait(context);
        Point screen = BottomBarDimensions.resolveScreenSize(context);
        int statusBarHeight = portrait ? 0 : BottomBarDimensions.getStatusBarHeight(context.getResources());
        int barHeight = BottomBarDimensions.computeBarHeight(
                sharedPrefs, portrait, screen.x, screen.y, statusBarHeight);
        int legacyBarHeight = BottomBarDimensions.computeLegacyBarHeight(
                portrait, screen.x, screen.y, statusBarHeight);
        if (barHeight <= 0 || legacyBarHeight <= 0) {
            Log.w(TAG, "Resizable bottom bar skipped: unknown screen size " + screen);
            return;
        }

        // 1. Bar containers: exact pixel height, conflicting XML ratio / percent cleared.
        BottomBarDimensions.applyExactHeight(rootView.findViewById(R.id.creator_bar), barHeight);
        // Portrait layouts hang the left bar (rl_left_bar), the auto-hide width guide and the
        // auto-hide bar on this invisible view, which has its own "H,0.142" ratio. Resizing it is
        // what makes all three follow through their existing constraints. (Absent in landscape.)
        BottomBarDimensions.applyExactHeight(rootView.findViewById(R.id.guideline_bottom_bar_height), barHeight);
        if (!portrait) {
            // Landscape gives the auto-hide bar its own layout_constraintHeight_percent. In portrait
            // it is constrained between the guideline above and the parent, so it needs nothing.
            BottomBarDimensions.applyExactHeight(rootView.findViewById(R.id.creator_bar_auto_hide), barHeight);
        }
        // Landscape rl_left_bar is constrained to the top of creator_bar - it follows as well.

        // 2. Children with absolute sizes (given by DrawViewFirstScreen) scale with the bar.
        float scale = (float) barHeight / legacyBarHeight;
        if (Math.abs(scale - 1f) < 0.001f) {
            return;
        }
        scaleArrowControls(rootView, scale);
        scaleSelectionTexts(rootView, scale);
        scaleConfirmText(rootView.findViewById(R.id.confirm_layout), scale);

        // 3. Growing can overflow the fixed-width controls area; shrinking never can.
        if (scale > 1f) {
            fitArrowControlsToWidth(rootView);
        }
        Log.d(TAG, "Resizable bottom bar: " + barHeight + "px (legacy " + legacyBarHeight
                + "px), controls x" + scale);
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
            Log.e("CreatorFirstScreen", "Error getting app name", e);
        }
        return "";
    }

    private boolean compareScreens(String pipScreenKey) {
        int pipScreen = sharedPrefs.getInt(pipScreenKey, 1) - 1;
        int screen = 0;
        if (screen == pipScreen) {
            return true;
        } else {
            return false;
        }
    }
}