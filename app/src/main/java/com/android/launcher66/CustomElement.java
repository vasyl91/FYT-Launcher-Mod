package com.android.launcher66;

import com.android.launcher66.settings.Keys;

/**
 * The nine elements the launcher puts on the home pages by itself: the date, music and radio widgets,
 * the five PiP placeholders and the statistics placeholder. They are listed in the order they are placed.
 *
 * <p>The model, the strip of the empty screens and {@code CellLayout} used to carry their own copies of
 * the "is it switched on" defaults and they did not agree. The defaults live only here and match
 * {@code res/xml/creator_preferences.xml}. The class is plain Java so the page planning can be tested on
 * the JVM; the preferences are read by {@link CustomElementPrefs}.
 */
public enum CustomElement {
    DATE("date", Keys.USER_DATE, true, Keys.DATE_SCREEN, "date"),
    MUSIC("music", Keys.USER_MUSIC, true, Keys.MUSIC_SCREEN, "music"),
    RADIO("radio", Keys.USER_RADIO, true, Keys.RADIO_SCREEN, "radio"),
    PIP_DUAL("dual", Keys.PIP_DUAL, false, Keys.PIP_DUAL_SCREEN, Keys.PIP_DUAL_KEY),
    PIP_FIRST("first", Keys.PIP_FIRST, false, Keys.PIP_FIRST_SCREEN, Keys.PIP_FIRST_KEY),
    PIP_SECOND("second", Keys.PIP_SECOND, false, Keys.PIP_SECOND_SCREEN, Keys.PIP_SECOND_KEY),
    PIP_THIRD("third", Keys.PIP_THIRD, false, Keys.PIP_THIRD_SCREEN, Keys.PIP_THIRD_KEY),
    PIP_FOURTH("fourth", Keys.PIP_FOURTH, false, Keys.PIP_FOURTH_SCREEN, Keys.PIP_FOURTH_KEY),
    STATS("stats", Keys.USER_STATS, false, Keys.STATS_SCREEN, "stats");

    /** Name used in the logs, as the {@code pipType} and as the prefix of the geometry preferences. */
    public final String label;
    /** Preference that switches the element on. */
    public final String enabledKey;
    /** Value of {@link #enabledKey} when the user has never touched it. */
    public final boolean defaultEnabled;
    /** Preference with the number of the page, counted from 1, where the element lives. */
    public final String screenKey;
    /** Prefix of the preferences with the corners of the element. */
    public final String geometryPrefix;

    CustomElement(String label, String enabledKey, boolean defaultEnabled, String screenKey,
                  String geometryPrefix) {
        this.label = label;
        this.enabledKey = enabledKey;
        this.defaultEnabled = defaultEnabled;
        this.screenKey = screenKey;
        this.geometryPrefix = geometryPrefix;
    }

    public boolean isPip() {
        return this != DATE && this != MUSIC && this != RADIO && this != STATS;
    }

    /** The element with this {@link #label}, or null when there is none. */
    public static CustomElement fromLabel(String label) {
        if (label == null) {
            return null;
        }
        for (CustomElement element : values()) {
            if (element.label.equals(label)) {
                return element;
            }
        }
        return null;
    }

    /** The element whose page is kept in this preference, or null when there is none. */
    public static CustomElement fromScreenKey(String screenKey) {
        if (screenKey == null) {
            return null;
        }
        for (CustomElement element : values()) {
            if (element.screenKey.equals(screenKey)) {
                return element;
            }
        }
        return null;
    }
}
