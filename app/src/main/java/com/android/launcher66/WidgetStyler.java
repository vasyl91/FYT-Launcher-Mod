package com.android.launcher66;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.android.launcher66.settings.Keys;
import com.fyt.widget.DigitClock;


/**
 * Puts the look chosen in the settings (WidgetStyle) on the widgets and the bar that are on the screen now: one place,
 * called when the views are created and from the one preference listener of Launcher when a setting of look changes
 * (R2). Nothing depends on the screen being rebuilt: the first page's widgets, the custom widgets and the PiP
 * placeholders of every page, the music and radio widgets, the digits of the clock, the bar and its window. Main
 * thread only.
 */
public final class WidgetStyler {

    private WidgetStyler() {
    }

    /**
     * Whether a preference is a setting of look, which is put on the screen at once: the colours of the texts and
     * buttons, and the background of the widgets and of each bar, the choice as well as the user's own colour.
     * The bars' backgrounds were missing here, so a new one showed in the windows of the bars (they are built
     * again at every return to the home screen) but on the first page only after its rebuild, which can be
     * skipped.
     */
    static boolean isLookSetting(String key) {
        return Keys.WIDGETS_TINT_COLOR.equals(key) || Keys.BAR_TINT_COLOR.equals(key)
                || Keys.WIDGETS_SELECTED_BACKGROUND.equals(key)
                || Keys.WIDGETS_CUSTOM_BACKGROUND_COLOR.equals(key)
                || Keys.BAR_SELECTED_BACKGROUND.equals(key)
                || Keys.BAR_CUSTOM_BACKGROUND_COLOR.equals(key)
                || Keys.VERTICAL_BAR_SELECTED_BACKGROUND.equals(key)
                || Keys.VERTICAL_BAR_CUSTOM_BACKGROUND_COLOR.equals(key);
    }

    /** "Widget text and button color": the chosen colour, or ViewTint.NONE while none was chosen. */
    public static int widgetsTint(SharedPreferences prefs) {
        return prefs.contains(Keys.WIDGETS_TINT_COLOR) ? prefs.getInt(Keys.WIDGETS_TINT_COLOR, ViewTint.NONE)
                : ViewTint.NONE;
    }

    /** "Horizontal bar text and button color": the chosen colour, or ViewTint.NONE while none was chosen. */
    public static int barTint(SharedPreferences prefs) {
        return prefs.contains(Keys.BAR_TINT_COLOR) ? prefs.getInt(Keys.BAR_TINT_COLOR, ViewTint.NONE)
                : ViewTint.NONE;
    }

    /** The look the settings give now. */
    static WidgetStyle current(SharedPreferences prefs) {
        return WidgetStyle.of(widgetsTint(prefs), barTint(prefs),
                BarBackground.choice(prefs, Keys.WIDGETS_SELECTED_BACKGROUND, BarBackground.WIDGETS_DEFAULT));
    }

    /** The background of a widget: the chosen one, or bg_custom, the default the layouts give. */
    static void setBackground(View view, WidgetStyle style) {
        if (view == null) {
            return;
        }
        // A picture, or the user's own colour in the shape of the pictures (BarBackground)
        view.setBackground(BarBackground.drawable(view.getContext(), style.backgroundChoice(), R.drawable.bg_custom,
                RoundedColorDrawable.WIDGET_CORNERS));
    }

    /**
     * @param reason what asked for it, for the log
     */
    static void apply(Launcher launcher, String reason) {
        if (launcher == null || launcher.mPrefs == null) {
            return;
        }
        WidgetStyle style = current(launcher.mPrefs);
        int[] count = {0};
        launcher.mMusicWidget.applyStyle(style, count);
        launcher.mRadioWidget.applyStyle(style, count);
        Workspace workspace = launcher.mWorkspace;
        if (workspace != null) {
            for (int i = 0; i < workspace.getChildCount(); i++) {
                View page = workspace.getChildAt(i);
                if (page instanceof CellLayout) {
                    ((CellLayout) page).applyWidgetStyle(style, count);
                }
            }
            workspace.applyBarStyle(style, count);
            applyClocks(workspace, style.tint(WidgetStyle.Role.WIDGET_TEXT), count);
        }
        Log.i(Launcher.TAG, "Widget style applied (" + reason + "): " + style + ", " + count[0] + " views");
    }

    /** The digits of every clock below this view. */
    private static void applyClocks(View view, int tint, int[] count) {
        if (view instanceof DigitClock) {
            ((DigitClock) view).applyStyle(tint);
            count[0]++;
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                applyClocks(group.getChildAt(i), tint, count);
            }
        }
    }
}
