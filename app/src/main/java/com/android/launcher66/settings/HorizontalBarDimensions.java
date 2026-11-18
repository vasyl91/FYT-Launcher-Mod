package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.launcher66.Launcher;

import java.util.WeakHashMap;

/**
 * Single source of truth for the height of the user-layout horizontal bar
 * (custom_layout_one_user*, custom_layout_two_user*, creator*).
 *
 * <p><b>Feature guard.</b> With {@link Keys#RESIZABLE_HORIZONTAL_BAR} off nothing changes: the XML
 * keeps sizing the bar and {@link #getMultiplier} returns the very same double literals the old
 * code used (0.142 portrait, 0.1638 landscape), so every derived height is bit-identical.
 *
 * <p><b>Shortest edge rule.</b> Portrait: {@code screenWidth * multiplier}. Landscape:
 * {@code (screenHeight - statusBarHeight) * multiplier}. Each caller passes the status bar term it
 * has always used (Helpers never subtracted it and passes 0).
 *
 * <p><b>ConstraintLayout.</b> The XML sizes the bar with layout_constraintDimensionRatio (portrait)
 * and layout_constraintHeight_percent (landscape). {@link #applyExactHeight} clears both before it
 * pins an exact pixel height, and {@link #getXmlSpec} remembers the inflated spec of a view, so
 * derived heights can be re-applied any number of times without compounding.
 *
 * <p>Methods that touch views must be called on the main thread.
 */
public final class HorizontalBarDimensions {

    private static final String TAG = "HorizontalBarDimensions";

    /** Legacy multipliers. Kept as double literals so the fallback matches the old code exactly. */
    public static final double LEGACY_MULTIPLIER_PORTRAIT = 0.142;
    public static final double LEGACY_MULTIPLIER_LANDSCAPE = 0.1638;

    /** Defaults of {@link Keys#HORIZONTAL_BAR_HEIGHT_PORT} / {@link Keys#HORIZONTAL_BAR_HEIGHT_LAND}. */
    public static final float DEFAULT_MULTIPLIER_PORTRAIT = 0.142f;
    public static final float DEFAULT_MULTIPLIER_LANDSCAPE = 0.1638f;

    /**
     * Accepted range for user multipliers (values outside are clamped): 8 % - 20 % of the shorter
     * screen edge, the range of the "Horizontal bar height" slider (HorizontalBarHeightSeekBarPreference
     * derives its bounds from these). Below it icons and text become unusable, above it the left
     * bar and the workspace run out of room.
     */
    public static final float MIN_MULTIPLIER = 0.08f;
    public static final float MAX_MULTIPLIER = 0.20f;

    /** Inflated size rules per view, captured before the first override. Main thread only. */
    private static final WeakHashMap<View, XmlSizeSpec> sXmlSpecs = new WeakHashMap<>();

    private HorizontalBarDimensions() {
    }

    // ---------------------------------------------------------------------------------------
    // Guard and multipliers
    // ---------------------------------------------------------------------------------------

    public static boolean isPortrait(@NonNull Context context) {
        // Same test as the legacy code: anything that is not portrait uses the landscape rule.
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
    }

    public static boolean isResizable(@Nullable SharedPreferences prefs) {
        return prefs != null && prefs.getBoolean(Keys.RESIZABLE_HORIZONTAL_BAR, false);
    }

    /** Preference key holding the user multiplier for the given orientation. */
    @NonNull
    public static String getHeightKey(boolean portrait) {
        return portrait ? Keys.HORIZONTAL_BAR_HEIGHT_PORT : Keys.HORIZONTAL_BAR_HEIGHT_LAND;
    }

    /** Default user multiplier for the given orientation (the legacy bar height). */
    public static float getDefaultMultiplier(boolean portrait) {
        return portrait ? DEFAULT_MULTIPLIER_PORTRAIT : DEFAULT_MULTIPLIER_LANDSCAPE;
    }

    /**
     * The spec, one-to-one:
     * <pre>
     * portrait:  multiplier = resizableHorizontalBar ? getFloat(HORIZONTAL_BAR_HEIGHT_PORT, 0.142f) : 0.142f
     * landscape: multiplier = resizableHorizontalBar ? getFloat(HORIZONTAL_BAR_HEIGHT_LAND, 0.1638f) : 0.1638f
     * </pre>
     * returned as a double: the disabled path returns the exact legacy literal, the enabled path the
     * sanitised user value (see {@link #getConfiguredMultiplier}).
     */
    public static double getMultiplier(@Nullable SharedPreferences prefs, boolean portrait) {
        boolean resizableHorizontalBar = isResizable(prefs);
        if (!resizableHorizontalBar) {
            return portrait ? LEGACY_MULTIPLIER_PORTRAIT : LEGACY_MULTIPLIER_LANDSCAPE;
        }
        // Float.toString() gives the shortest decimal that identifies the float ("0.142"), so the
        // default preference maps to exactly the legacy double and the heights match the fallback
        // to the pixel. A plain widening cast would yield 0.14200000464916229 instead.
        return Double.parseDouble(Float.toString(getConfiguredMultiplier(prefs, portrait)));
    }

    /**
     * The user multiplier stored for the given orientation, sanitised the same way the launcher
     * reads it, whether or not the feature is switched on (the settings slider shows this value).
     * The default for that orientation if nothing usable is stored.
     */
    public static float getConfiguredMultiplier(@Nullable SharedPreferences prefs, boolean portrait) {
        float defaultValue = getDefaultMultiplier(portrait);
        if (prefs == null) {
            return defaultValue;
        }
        return readMultiplier(prefs, getHeightKey(portrait), defaultValue);
    }

    /**
     * Configured bar height relative to the legacy bar. Exactly 1f when the feature is off, and
     * also when it is on but the user kept the default value.
     */
    public static float getHeightScale(@Nullable SharedPreferences prefs, boolean portrait) {
        double legacy = portrait ? LEGACY_MULTIPLIER_PORTRAIT : LEGACY_MULTIPLIER_LANDSCAPE;
        return (float) (getMultiplier(prefs, portrait) / legacy);
    }

    /**
     * Reads a user multiplier. The spec stores a float; a String (EditText/List preference) and an
     * integer in thousandths (e.g. a SeekBarPreference with min 80 / max 200) are tolerated as well.
     * Unreadable values fall back to the default, everything is clamped to
     * [{@link #MIN_MULTIPLIER}, {@link #MAX_MULTIPLIER}].
     */
    private static float readMultiplier(@NonNull SharedPreferences prefs, @NonNull String key,
                                        float defaultValue) {
        float value;
        try {
            value = prefs.getFloat(key, defaultValue);
        } catch (ClassCastException notAFloat) {
            Object stored = prefs.getAll().get(key);
            if (stored instanceof Integer || stored instanceof Long) {
                value = ((Number) stored).longValue() / 1000f;
            } else if (stored instanceof String) {
                try {
                    value = Float.parseFloat(((String) stored).trim());
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            } else {
                value = defaultValue;
            }
            Log.w(TAG, key + " is stored as "
                    + (stored == null ? "null" : stored.getClass().getSimpleName())
                    + " instead of a float, read as " + value);
        }
        if (Float.isNaN(value) || Float.isInfinite(value) || value <= 0f) {
            value = defaultValue;
        }
        return Math.max(MIN_MULTIPLIER, Math.min(MAX_MULTIPLIER, value));
    }

    // ---------------------------------------------------------------------------------------
    // Shortest edge rule
    // ---------------------------------------------------------------------------------------

    /**
     * Bar height in px: portrait {@code screenWidth * m}, landscape
     * {@code (screenHeight - statusBarHeight) * m}, with m from {@link #getMultiplier}.
     */
    public static int computeBarHeight(@Nullable SharedPreferences prefs, boolean portrait,
                                       int screenWidth, int screenHeight, int statusBarHeight) {
        return heightFor(getMultiplier(prefs, portrait), portrait,
                screenWidth, screenHeight, statusBarHeight);
    }

    /** Same formula with the hardcoded legacy multipliers, whatever the preferences say. */
    public static int computeLegacyBarHeight(boolean portrait, int screenWidth, int screenHeight,
                                             int statusBarHeight) {
        return heightFor(portrait ? LEGACY_MULTIPLIER_PORTRAIT : LEGACY_MULTIPLIER_LANDSCAPE,
                portrait, screenWidth, screenHeight, statusBarHeight);
    }

    private static int heightFor(double multiplier, boolean portrait, int screenWidth,
                                 int screenHeight, int statusBarHeight) {
        if (portrait) {
            return (int) (screenWidth * multiplier);
        }
        return (int) ((screenHeight - statusBarHeight) * multiplier);
    }

    /**
     * Width of the vertical bar as the layouts draw it (see {@link PipEdgeTrim#computeVerticalBarWidth}).
     * Landscape matches the old per-class formulas to the pixel; portrait follows the XML ratio
     * "W,0.071", which is relative to the bar's height, not to the screen width.
     */
    public static float computeVerticalBarWidth(boolean portrait, int rootWidth, int rootHeight,
                                            int barHeight) {
        return PipEdgeTrim.computeVerticalBarWidth(portrait, rootWidth, rootHeight, barHeight);
    }

    /** Same lookup as {@code Launcher.getStatusBarHeight()}, usable without a Launcher instance. */
    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    public static int getStatusBarHeight(@NonNull Resources res) {
        // The system's own resources: the settings activity runs at a reference density on
        // non-FYT devices (SettingsActivity.attachBaseContext()), the status bar does not.
        Resources sys = Resources.getSystem();
        int resourceId = sys.getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? sys.getDimensionPixelSize(resourceId) : 0;
    }

    // ---------------------------------------------------------------------------------------
    // Geometry of the bar as it is really drawn
    // ---------------------------------------------------------------------------------------

    /** Size of the box the bar lives in, published by Workspace after layout; 0 = not measured. */
    private static volatile int sBarRootWidth;
    private static volatile int sBarRootHeight;

    /**
     * Publishes the size of the box the bar and the user widgets share (user_layout /
     * user_layout_left, which fill the inflated custom_layout_*_user*). The widget positions the
     * creator stores are relative to that box and the bar sits at its bottom edge, so this - not
     * the screen size - is the coordinate space the overlap checks have to work in. The two differ
     * by the system bars, which is exactly the band where a bar made taller stopped counting as
     * overlapping.
     */
    public static void publishBarRootSize(int width, int height) {
        if (width > 0 && height > 0) {
            boolean changed = width != sBarRootWidth || height != sBarRootHeight;
            sBarRootWidth = width;
            sBarRootHeight = height;
            if (changed) {
                rememberBox(width, height);
            }
        }
    }

    /**
     * The rule: until the launcher has measured the box in this process, its size is the one measured last in
     * this orientation, kept in the preferences; only the very first time is it taken from the screen. The screen
     * without the status bar is not the box: the navigation bar is not in it either (2251 instead of 2116 px on
     * the A55), and an element the creator or the layout of the elements placed by that height lay partly under
     * the navigation bar (the owner, 2026-11-16).
     */
    private static void rememberBox(int width, int height) {
        Context app = com.android.launcher66.LauncherApplication.sApp;
        if (app == null) {
            return;
        }
        String key = width > height ? Keys.BAR_ROOT_BOX_LANDSCAPE : Keys.BAR_ROOT_BOX_PORTRAIT;
        androidx.preference.PreferenceManager.getDefaultSharedPreferences(app).edit()
                .putString(key, width + "x" + height).apply();
    }

    /** {width, height} measured last in the current orientation, or null (see rememberBox()). */
    @Nullable
    private static int[] rememberedBox() {
        Context app = com.android.launcher66.LauncherApplication.sApp;
        if (app == null) {
            return null;
        }
        boolean landscape = app.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        String value = androidx.preference.PreferenceManager.getDefaultSharedPreferences(app)
                .getString(landscape ? Keys.BAR_ROOT_BOX_LANDSCAPE : Keys.BAR_ROOT_BOX_PORTRAIT, null);
        if (value == null) {
            return null;
        }
        int x = value.indexOf('x');
        try {
            int w = Integer.parseInt(value.substring(0, x));
            int h = Integer.parseInt(value.substring(x + 1));
            return w > 0 && h > 0 ? new int[] {w, h} : null;
        } catch (RuntimeException e) {
            return null;
        }
    }

    /**
     * Height of that box: measured once the launcher has laid the bar out, else the one measured last in this
     * orientation (rememberBox()), otherwise the screen height minus the status bar.
     */
    public static int getBarRootHeight(int screenHeight, int statusBarHeight) {
        int measured = sBarRootHeight;
        if (measured > 0) {
            return measured;
        }
        int[] remembered = rememberedBox();
        return remembered != null ? remembered[1] : Math.max(0, screenHeight - statusBarHeight);
    }

    /** Width of that box: measured when available, else the one measured last, otherwise the screen width. */
    public static int getBarRootWidth(int screenWidth) {
        int measured = sBarRootWidth;
        if (measured > 0) {
            return measured;
        }
        int[] remembered = rememberedBox();
        return remembered != null ? remembered[0] : screenWidth;
    }

    /**
     * The screen size the launcher's bar maths is based on ({@code Launcher.screenWidth/Height}).
     * Falls back to the real display size when those statics are not initialised (settings
     * restored without the launcher), and swaps them when they were taken in the other
     * orientation - they are only refreshed in {@code Launcher.onCreate()}.
     */
    @NonNull
    public static Point resolveScreenSize(@NonNull Context context) {
        int width = Launcher.screenWidth;
        int height = Launcher.screenHeight;
        if (width <= 0 || height <= 0) {
            Point real = getRealDisplaySize(context);
            width = real.x;
            height = real.y;
        }
        boolean portrait = isPortrait(context);
        if (width > 0 && height > 0 && portrait == (width > height)) {
            int swap = width;
            width = height;
            height = swap;
        }
        return new Point(width, height);
    }

    @NonNull
    @SuppressWarnings("deprecation") // getDefaultDisplay()/getRealSize() only below API 30
    private static Point getRealDisplaySize(@NonNull Context context) {
        Point size = new Point();
        try {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (wm != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    Rect bounds = wm.getMaximumWindowMetrics().getBounds();
                    size.set(bounds.width(), bounds.height());
                } else {
                    wm.getDefaultDisplay().getRealSize(size);
                }
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Real display size unavailable", e);
        }
        if (size.x <= 0 || size.y <= 0) {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            size.set(dm.widthPixels, dm.heightPixels);
        }
        return size;
    }

    // ---------------------------------------------------------------------------------------
    // ConstraintLayout overrides
    // ---------------------------------------------------------------------------------------

    /**
     * Removes the XML height rules that would fight a fixed height: the
     * layout_constraintDimensionRatio (it keeps re-deriving the height from the width) and
     * layout_constraintHeight_percent. Width rules are left alone. Does not request a layout.
     *
     * @return true if anything was changed.
     */
    public static boolean clearConflictingHeightRules(@NonNull ConstraintLayout.LayoutParams lp) {
        boolean changed = false;
        if (lp.dimensionRatio != null) {
            // ConstraintLayout re-parses this string on every hierarchy update; null = no ratio.
            lp.dimensionRatio = null;
            changed = true;
        }
        if (lp.matchConstraintDefaultHeight != ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD) {
            lp.matchConstraintDefaultHeight = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD;
            changed = true;
        }
        if (lp.matchConstraintPercentHeight != 1f) {
            lp.matchConstraintPercentHeight = 1f;
            changed = true;
        }
        return changed;
    }

    /**
     * Pins a view to an exact pixel height (conflicting XML height rules are cleared first for
     * ConstraintLayout children). Only calls {@code setLayoutParams()} when something changed,
     * so repeated calls with the same value do not trigger layout passes.
     *
     * @return true if the LayoutParams changed.
     */
    public static boolean applyExactHeight(@Nullable View view, int heightPx) {
        if (view == null || heightPx <= 0) {
            return false;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            return false;
        }
        boolean changed = false;
        if (params instanceof ConstraintLayout.LayoutParams) {
            changed = clearConflictingHeightRules((ConstraintLayout.LayoutParams) params);
        }
        if (params.height != heightPx) {
            params.height = heightPx;
            changed = true;
        }
        if (changed) {
            view.setLayoutParams(params);
        }
        return changed;
    }

    /**
     * Height = the view's XML height x {@code factor}, capped at {@code maxHeightPx} (ignored if
     * <= 0). Views whose XML height cannot be derived without a layout pass are left alone.
     *
     * @return true if the LayoutParams changed.
     */
    public static boolean applyScaledHeight(@Nullable View view, float factor, int rootWidth,
                                            int rootHeight, int maxHeightPx) {
        XmlSizeSpec spec = getXmlSpec(view);
        if (spec == null) {
            return false;
        }
        float xmlHeight = spec.resolveHeight(rootWidth, rootHeight);
        if (!(xmlHeight > 0f)) {
            return false;
        }
        int height = Math.max(1, Math.round(xmlHeight * factor));
        if (maxHeightPx > 0) {
            height = Math.min(height, maxHeightPx);
        }
        return applyExactHeight(view, height);
    }

    /**
     * Sizes the first page's horizontal bar and what is in it to a bar of {@code barHeight} px: the background
     * exactly, the list, the music widget, the date and the weather scaled from their XML sizes and never taller
     * than the bar, the buttons' icons likewise. The rule: this runs whether "Resizable horizontal bar" is on or
     * off; off, the bar has the default height and the factor is about 1. Until 2026-11-18 it ran only when the
     * setting was on, and off the music widget kept the height the XML gives it from its own width: in portrait,
     * widened because the weather was hidden, 216 px in a bar of 153 px on the A55, so its title and artist were
     * sized for that and lay partly above the bar (the owner).
     *
     * @param barRoot    the layout root with the bar (the first page's custom_layout_*_user*)
     * @param rootWidth  the width the XML percentages of the bar refer to
     * @param rootHeight the height they refer to
     * @return whether anything changed, or null when the bar cannot be sized (no bar, no XML size)
     */
    @Nullable
    public static Float applyBarSizes(@NonNull View barRoot, int barHeight, int rootWidth, int rootHeight,
                                      boolean[] changedOut) {
        View barBackground = barRoot.findViewById(com.android.launcher66.R.id.iv_list_bg);
        XmlSizeSpec barSpec = getXmlSpec(barBackground);
        if (barSpec == null) {
            return null;
        }
        float xmlBarHeight = barSpec.resolveHeight(rootWidth, rootHeight);
        if (barHeight <= 0 || !(xmlBarHeight > 0f)) {
            return null;
        }
        float factor = barHeight / xmlBarHeight;
        boolean changed = applyExactHeight(barBackground, barHeight);
        changed |= applyScaledHeight(barRoot.findViewById(com.android.launcher66.R.id.recycler_view), factor,
                rootWidth, rootHeight, barHeight);
        changed |= applyScaledHeight(barRoot.findViewById(com.android.launcher66.R.id.rl_music_two), factor,
                rootWidth, rootHeight, barHeight);
        // Only present in the landscape widget bar; findViewById() returns null otherwise.
        changed |= applyScaledHeight(barRoot.findViewById(com.android.launcher66.R.id.bar_widget_date), factor,
                rootWidth, rootHeight, barHeight);
        changed |= applyScaledHeight(barRoot.findViewById(com.android.launcher66.R.id.bar_widget_weather), factor,
                rootWidth, rootHeight, barHeight);
        changed |= applyScaledIconHeight(barRoot.findViewById(com.android.launcher66.R.id.rl_allapps), factor,
                rootWidth, rootHeight, barHeight);
        changed |= applyScaledIconHeight(barRoot.findViewById(com.android.launcher66.R.id.show_bar), factor,
                rootWidth, rootHeight, barHeight);
        if (changedOut != null && changedOut.length > 0) {
            changedOut[0] = changed;
        }
        return factor;
    }

    /**
     * For fitCenter icon buttons (rl_allapps, show_bar) the visible icon is
     * min(box width, box height). The box width is kept - the horizontal budget of the bar, and
     * AppListAdapter's tile maths, stay valid - and the height becomes the scaled icon size, so
     * the icon follows the bar. With factor 1 the visible icon is exactly the XML one.
     *
     * @return true if the LayoutParams changed.
     */
    public static boolean applyScaledIconHeight(@Nullable View view, float factor, int rootWidth,
                                                int rootHeight, int maxHeightPx) {
        XmlSizeSpec spec = getXmlSpec(view);
        if (spec == null) {
            return false;
        }
        float xmlWidth = spec.resolveWidth(rootWidth);
        float xmlHeight = spec.resolveHeight(rootWidth, rootHeight);
        if (!(xmlWidth > 0f) || !(xmlHeight > 0f)) {
            return false;
        }
        int height = Math.max(1, Math.round(Math.min(xmlWidth, xmlHeight) * factor));
        if (maxHeightPx > 0) {
            height = Math.min(height, maxHeightPx);
        }
        return applyExactHeight(view, height);
    }

    /**
     * The size rules {@code view} was inflated with. Captured on the first call and remembered
     * (weakly) afterwards, so call this before overriding anything on the view.
     *
     * @return null for views that are not ConstraintLayout children.
     */
    @Nullable
    public static XmlSizeSpec getXmlSpec(@Nullable View view) {
        if (view == null) {
            return null;
        }
        XmlSizeSpec spec = sXmlSpecs.get(view);
        if (spec != null) {
            return spec;
        }
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof ConstraintLayout.LayoutParams)) {
            return null;
        }
        spec = new XmlSizeSpec((ConstraintLayout.LayoutParams) params,
                view.getResources().getConfiguration().orientation);
        sXmlSpecs.put(view, spec);
        return spec;
    }

    /**
     * Parses layout_constraintDimensionRatio the way ConstraintLayout does and returns height per
     * width when the ratio drives the HEIGHT ("H,0.142" -> 0.142, "H,16:9" -> 9/16).
     * Anything else ("W,...", or no side given) returns NaN: those cannot be resolved without the
     * other dimension, and none of the bar views use them.
     */
    static float parseHeightPerWidth(@Nullable String ratio) {
        if (ratio == null) {
            return Float.NaN;
        }
        String value = ratio.trim();
        int comma = value.indexOf(',');
        if (comma <= 0 || comma >= value.length() - 1
                || !value.substring(0, comma).trim().equalsIgnoreCase("H")) {
            return Float.NaN;
        }
        value = value.substring(comma + 1).trim();
        try {
            int colon = value.indexOf(':');
            if (colon >= 0) {
                if (colon == 0 || colon >= value.length() - 1) {
                    return Float.NaN;
                }
                float nominator = Float.parseFloat(value.substring(0, colon).trim());
                float denominator = Float.parseFloat(value.substring(colon + 1).trim());
                return (nominator > 0f && denominator > 0f) ? denominator / nominator : Float.NaN;
            }
            float plain = Float.parseFloat(value);
            return plain > 0f ? plain : Float.NaN;
        } catch (NumberFormatException e) {
            return Float.NaN;
        }
    }

    /** Size rules of a ConstraintLayout child as inflated from XML. */
    public static final class XmlSizeSpec {
        private final int width;
        private final int height;
        private final float percentWidth;    // NaN unless layout_constraintWidth_percent
        private final float percentHeight;   // NaN unless layout_constraintHeight_percent
        private final float heightPerWidth;  // NaN unless an "H,..." dimension ratio
        /** Orientation the view was inflated for. */
        public final int orientation;

        XmlSizeSpec(@NonNull ConstraintLayout.LayoutParams lp, int orientation) {
            this.width = lp.width;
            this.height = lp.height;
            this.percentWidth = (lp.width == 0
                    && lp.matchConstraintDefaultWidth == ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT)
                    ? lp.matchConstraintPercentWidth : Float.NaN;
            this.percentHeight = (lp.height == 0
                    && lp.matchConstraintDefaultHeight == ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT)
                    ? lp.matchConstraintPercentHeight : Float.NaN;
            this.heightPerWidth = parseHeightPerWidth(lp.dimensionRatio);
            this.orientation = orientation;
        }

        /** Width in a parent {@code rootWidth} wide; NaN if it depends on constraints/content. */
        public float resolveWidth(int rootWidth) {
            if (!Float.isNaN(percentWidth)) {
                return percentWidth * rootWidth;
            }
            if (width > 0) {
                return width;
            }
            if (width == ViewGroup.LayoutParams.MATCH_PARENT) {
                return rootWidth;
            }
            return Float.NaN;
        }

        /** Height in a rootWidth x rootHeight parent; NaN if it depends on constraints/content. */
        public float resolveHeight(int rootWidth, int rootHeight) {
            if (!Float.isNaN(heightPerWidth)) {
                return heightPerWidth * resolveWidth(rootWidth); // NaN propagates
            }
            if (!Float.isNaN(percentHeight)) {
                return percentHeight * rootHeight;
            }
            if (height > 0) {
                return height;
            }
            if (height == ViewGroup.LayoutParams.MATCH_PARENT) {
                return rootHeight;
            }
            return Float.NaN;
        }
    }

    /**
     * The height of the horizontal bar in the launcher's box (below the status bar), the same sum the
     * creator of the first page makes. 0 when the screen is not known.
     */
    public static int boxBarHeight(Context context, SharedPreferences prefs) {
        boolean portrait = isPortrait(context);
        Point screen = resolveScreenSize(context);
        int statusBarHeight = getStatusBarHeight(context.getResources());
        int rootWidth = getBarRootWidth(screen.x);
        int rootHeight = getBarRootHeight(screen.y, statusBarHeight);
        if (rootWidth <= 0 || rootHeight <= 0) {
            return 0;
        }
        return Math.max(0, computeBarHeight(prefs, portrait, rootWidth, rootHeight, 0));
    }
}
