package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.VisibleForTesting;
import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.BarLayouts;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.WorkspaceGrids;

/**
 * The settings that a touch and a drag ask about on every move, read once and kept (KeptReading) until any
 * setting changes. The search for a cell while an item is dragged (CellLayout.findNearestArea and the
 * reorder that calls it again and again) asked the preferences for the bars' sides and the auto-hide bar's
 * corner cell hundreds of times for one move of the finger, and the home screen's gestures asked for their
 * switches at every touch.
 *
 * <p>The rules: a value here is worked out by the same code as before (WorkspaceGrids, BarLayouts,
 * DrawerAccess), so it is the same value; it is forgotten on every change of the default preferences, whatever
 * the key, so no key can be missed. The preferences keep their listeners only weakly, so the listener is held
 * here. The preferences are those of the application of the context asked with; another application (a test)
 * brings its own.
 */
public final class TouchSettings {

    private static final Object LOCK = new Object();
    private static Context sApp;
    private static SharedPreferences sPrefs;

    private static final SharedPreferences.OnSharedPreferenceChangeListener FORGET = (prefs, key) -> forgetAll();

    private static final KeptReading<Boolean> CORNER_FIRST_PAGE =
            new KeptReading<>(() -> WorkspaceGrids.cornerCell(prefs(), true));
    private static final KeptReading<Boolean> CORNER_OTHER_PAGE =
            new KeptReading<>(() -> WorkspaceGrids.cornerCell(prefs(), false));
    private static final KeptReading<BarLayout> BAR_SIDES = new KeptReading<>(() -> {
        SharedPreferences prefs = prefs();
        return BarLayouts.sides(prefs, prefs.getBoolean(Keys.VERTICAL_BAR, false));
    });
    private static final KeptReading<Boolean> SWIPE_UP = new KeptReading<>(() -> {
        SharedPreferences prefs = prefs();
        CreatorPrefs creator = CreatorPrefs.of(prefs);
        boolean stored = creator.getBoolean(Keys.SWIPE_UP_APP_DRAWER, false);
        // Without the horizontal bar (and its drawer button) the swipe is the way to the drawer (DrawerAccess)
        return DrawerAccess.swipeUpActive(stored, creator.getBoolean(Keys.DISPLAY_HORIZONTAL_BAR, true),
                prefs.getBoolean(Keys.USER_LAYOUT, false) && creator.getBoolean(Keys.HORIZONTAL_BAR_NO_DRAWER, false));
    });
    private static final KeptReading<Boolean> SWIPE_DOWN = new KeptReading<>(() ->
            CreatorPrefs.of(prefs()).getBoolean(Keys.SWIPE_DOWN_NOTIFICATIONS, false));

    private TouchSettings() {
    }

    /** WorkspaceGrids.cornerCell(): the auto-hide bar's handle keeps the corner cell of the page shown. */
    public static boolean cornerCell(Context context, boolean firstPage) {
        attach(context);
        return (firstPage ? CORNER_FIRST_PAGE : CORNER_OTHER_PAGE).get();
    }

    /** BarLayouts.sides() with the vertical bar as it is set: the sides of the bars and of the handle. */
    public static BarLayout barSides(Context context) {
        attach(context);
        return BAR_SIDES.get();
    }

    /** Whether a swipe up opens the app drawer (HomeGestures). */
    public static boolean swipeUp(Context context) {
        attach(context);
        return SWIPE_UP.get();
    }

    /** Whether a swipe down opens the notifications (HomeGestures). */
    public static boolean swipeDown(Context context) {
        attach(context);
        return SWIPE_DOWN.get();
    }

    private static void attach(Context context) {
        Context app = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (LOCK) {
            if (app != sApp) {
                use(app, PreferenceManager.getDefaultSharedPreferences(app));
            }
        }
    }

    /** These preferences for this application from now on (and a test's counting ones). */
    @VisibleForTesting
    static void use(Context app, SharedPreferences prefs) {
        synchronized (LOCK) {
            if (sPrefs != null) {
                sPrefs.unregisterOnSharedPreferenceChangeListener(FORGET);
            }
            sApp = app;
            sPrefs = prefs;
            prefs.registerOnSharedPreferenceChangeListener(FORGET);
            forgetAll();
        }
    }

    private static SharedPreferences prefs() {
        synchronized (LOCK) {
            return sPrefs;
        }
    }

    private static void forgetAll() {
        CORNER_FIRST_PAGE.forget();
        CORNER_OTHER_PAGE.forget();
        BAR_SIDES.forget();
        SWIPE_UP.forget();
        SWIPE_DOWN.forget();
    }
}
