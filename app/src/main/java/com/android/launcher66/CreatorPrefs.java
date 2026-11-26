package com.android.launcher66;

import android.content.SharedPreferences;

import com.android.launcher66.settings.Keys;

/**
 * The preferences as the launcher reads the layout creator's settings: with "Stock layout" on, every key of
 * the creator ({@link CreatorKeys}) gives the default the caller passes, whatever is stored.
 *
 * <p>The rule (D-85): "Stock layout" is {@code USER_LAYOUT == false}; then the creator's settings do not apply, those
 * of this round included (the colour of the theme, the gestures, the free widgets, the drawer, the bars shown).
 * Other keys, the launcher's own settings among them (the badges), are read as they are stored. The wrapper
 * only reads; it is made where a setting is read ({@code CreatorPrefs.of(prefs).getBoolean(...)}). The stored
 * values are kept: they apply again when the creator is turned on.
 */
public final class CreatorPrefs {

    private final SharedPreferences mPrefs;

    private CreatorPrefs(SharedPreferences prefs) {
        mPrefs = prefs;
    }

    public static CreatorPrefs of(SharedPreferences prefs) {
        return new CreatorPrefs(prefs);
    }

    /** Whether the creator's settings apply now. */
    public boolean creatorOn() {
        return mPrefs.getBoolean(Keys.USER_LAYOUT, false);
    }

    private boolean ignored(String key) {
        return CreatorKeys.contains(key) && !creatorOn();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return ignored(key) ? defValue : mPrefs.getBoolean(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return ignored(key) ? defValue : mPrefs.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return ignored(key) ? defValue : mPrefs.getLong(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return ignored(key) ? defValue : mPrefs.getFloat(key, defValue);
    }

    public String getString(String key, String defValue) {
        return ignored(key) ? defValue : mPrefs.getString(key, defValue);
    }

    /** Whether a value is stored and applies: false for a creator key with the stock layout on. */
    public boolean contains(String key) {
        return !ignored(key) && mPrefs.contains(key);
    }
}
