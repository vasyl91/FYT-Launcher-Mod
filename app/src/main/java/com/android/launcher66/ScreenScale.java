package com.android.launcher66;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;

/**
 * Sizes that are the same share of the screen on every device, away from FYT units.
 *
 * FYT units keep their own density: the layouts were made there. Elsewhere the settings, and the
 * launcher's dialogs and labels that should look like them, run at a density worked out from the
 * screen's shorter side, so a dp is the same share of the screen whatever its size and density.
 * The shares are the ones a 1080 x 2340 phone at 440 dpi got from the fixed factors used before
 * (0.5 of its density in portrait, 0.75 in landscape), which looked right there.
 */
public final class ScreenScale {

    /** The shorter screen side, in the scaled dp: 1080 px at 220 dpi (portrait), 330 dpi (landscape). */
    private static final float SHORT_SIDE_DP_PORTRAIT = 785f;
    private static final float SHORT_SIDE_DP_LANDSCAPE = 524f;
    /** Portrait text is half again as large as the rest: at the scaled dp alone it was too small. */
    private static final float TEXT_SCALE_PORTRAIT = 1.5f;

    /** The reference phone, for the sizes worked out from the screen in pixels. */
    public static final int REFERENCE_SHORT_SIDE_PX = 1080;
    public static final int REFERENCE_LONG_SIDE_PX = 2340;

    /**
     * How much larger than they lay out widgets are drawn on the FYT unit they were tuned on
     * (2000 x 1200 at 240 dpi: a shorter side of 800 dp). At 1 they looked too small there.
     */
    private static final float WIDGET_SCALE_FYT = 1.75f;
    private static final float FYT_SHORT_SIDE_DP = 800f;

    private static Boolean sApplies;

    private ScreenScale() {
    }

    /** Whether anything is scaled: everywhere but on FYT units. */
    public static boolean applies() {
        Boolean applies = sApplies;
        if (applies == null) {
            applies = !LauncherApplication.isFytDevice();
            sApplies = applies;
        }
        return applies;
    }

    private static boolean isPortrait(Resources res) {
        return res.getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    /** The scaled density for a screen of dm's size; 0 when the size is unknown. */
    public static int densityDpi(DisplayMetrics dm, boolean portrait) {
        int shortSide = Math.min(dm.widthPixels, dm.heightPixels);
        if (shortSide <= 0) return 0;
        float shortSideDp = portrait ? SHORT_SIDE_DP_PORTRAIT : SHORT_SIDE_DP_LANDSCAPE;
        return Math.round(shortSide * 160f / shortSideDp);
    }

    /** The scaled density over the screen's own; 1 on FYT units. */
    public static float factor(Resources res) {
        if (!applies()) return 1f;
        int own = Resources.getSystem().getDisplayMetrics().densityDpi;
        int scaled = densityDpi(res.getDisplayMetrics(), isPortrait(res));
        return own > 0 && scaled > 0 ? scaled / (float) own : 1f;
    }

    /** factor() for text, which portrait makes larger; 1 on FYT units. */
    public static float textFactor(Resources res) {
        float factor = factor(res);
        return applies() && isPortrait(res) ? factor * TEXT_SCALE_PORTRAIT : factor;
    }

    /**
     * The widgets' scale: on FYT units the tuned one, elsewhere the one that makes a dp of a
     * widget the same share of the screen as there. A widget lays out in its cells' pixels over
     * this scale and is drawn this much larger, so the share goes with scale / shorter side in
     * dp. A 1080 px phone at 450 dpi (384 dp) comes to about 0.84.
     */
    public static float widgetScale() {
        if (!applies()) return WIDGET_SCALE_FYT;
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
        int shortSide = Math.min(dm.widthPixels, dm.heightPixels);
        if (shortSide <= 0 || dm.density <= 0) return WIDGET_SCALE_FYT;
        return WIDGET_SCALE_FYT * (shortSide / dm.density) / FYT_SHORT_SIDE_DP;
    }

    /**
     * The configuration for res at the scaled density, or null on FYT units or when the screen
     * size is unknown. The user's own font scale is kept.
     */
    public static Configuration scaledConfiguration(Resources res) {
        if (!applies()) return null;
        DisplayMetrics dm = res.getDisplayMetrics();
        boolean portrait = isPortrait(res);
        int dpi = densityDpi(dm, portrait);
        if (dpi <= 0) return null;

        Configuration config = new Configuration(res.getConfiguration());
        config.densityDpi = dpi;
        if (portrait) config.fontScale = config.fontScale * TEXT_SCALE_PORTRAIT;
        // The same pixels, in the new dp.
        config.screenWidthDp = Math.round(dm.widthPixels * 160f / dpi);
        config.screenHeightDp = Math.round(dm.heightPixels * 160f / dpi);
        config.smallestScreenWidthDp = Math.min(config.screenWidthDp, config.screenHeightDp);
        return config;
    }

    /**
     * An activity's context at the scaled density, with the activity's theme and extraTheme (0:
     * none) on top, for views inflated in it (a dialog's content, say); the activity itself on
     * FYT units. The theme is built again from its resource: one taken over from the activity
     * would resolve its dimensions at the screen's own density.
     */
    public static Context wrapThemed(Context activity, int extraTheme) {
        Configuration config = scaledConfiguration(activity.getResources());
        if (config == null) return activity;
        ContextThemeWrapper scaled = new ContextThemeWrapper(activity, themeOf(activity));
        scaled.applyOverrideConfiguration(config);
        if (extraTheme != 0) scaled.getTheme().applyStyle(extraTheme, true);
        return scaled;
    }

    private static int themeOf(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            try {
                int theme = activity.getPackageManager()
                        .getActivityInfo(activity.getComponentName(), 0).getThemeResource();
                if (theme != 0) return theme;
            } catch (PackageManager.NameNotFoundException ignore) {
                // the application's theme then
            }
        }
        return context.getApplicationInfo().theme;
    }
}
