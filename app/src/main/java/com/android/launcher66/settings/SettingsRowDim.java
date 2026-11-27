package com.android.launcher66.settings;

import android.view.View;
import android.view.ViewGroup;

/**
 * The look of a settings row that is off ({@code Preference.isEnabled()} false: switched off by the row above it, by a
 * dependency, or by "Stock layout").
 *
 * <p>The rules (the owner on the A55, 2026-11-27: the rows below "Enable notification badges" did not look off):
 * <ul>
 *   <li>A row that is off is drawn at {@link #DIMMED} of its opacity, whole: its title, summary, icon, preview and
 *       controls alike. A row that is on is drawn at full opacity. Android dims text through the disabled state of its
 *       colour, but the settings' theme gives the text plain colours (white, grey) and the rows of their own layout
 *       draw their own buttons, so nothing changed when a row went off.</li>
 *   <li>The opacity is set on the row's children, not on the row: RecyclerView's item animator sets the row's own
 *       opacity when it shows a change (a change of the switch above rebinds the rows below) and leaves it at 1.</li>
 *   <li>Every row of a list of settings is bound through {@link DimmingPreferenceAdapter}, which applies this on each
 *       bind, so a row that is reused shows its own state.</li>
 *   <li>A category's title is never dimmed ({@link #looksOn}): androidx.preference's {@code PreferenceCategory} says it is
 *       not enabled whatever its rows are, since it cannot be tapped, and its title went grey (the owner, 2026-11-27).</li>
 * </ul>
 */
public final class SettingsRowDim {

    /** The opacity of a row that is off, as Material's disabled content. */
    public static final float DIMMED = 0.38f;

    private SettingsRowDim() {
    }

    /** Whether a row is drawn as on: a row that is enabled, and a category's title always. */
    public static boolean looksOn(androidx.preference.Preference preference) {
        return preference == null || preference instanceof androidx.preference.PreferenceCategory
                || preference.isEnabled();
    }

    /** The opacity of a row's content. */
    public static float alpha(boolean enabled) {
        return enabled ? 1f : DIMMED;
    }

    /** Draws the row as on or off. */
    public static void apply(View row, boolean enabled) {
        if (row == null) {
            return;
        }
        float alpha = alpha(enabled);
        if (row instanceof ViewGroup && ((ViewGroup) row).getChildCount() > 0) {
            ViewGroup group = (ViewGroup) row;
            for (int i = 0; i < group.getChildCount(); i++) {
                group.getChildAt(i).setAlpha(alpha);
            }
        } else {
            // A row of one view has no children to carry it; an animation of a change may reset it, the next bind not
            row.setAlpha(alpha);
        }
    }
}
