package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import android.content.SharedPreferences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SessionPrefsTest {

    private final SessionPrefs prefs = SessionPrefs.get();

    @BeforeEach
    void clear() {
        prefs.edit().clear().apply();
    }

    @Test
    void valuesAreVisibleOnlyAfterApply() {
        SharedPreferences.Editor editor = prefs.edit().putBoolean("pipsAdded", true);
        assertFalse(prefs.getBoolean("pipsAdded", false));
        editor.apply();
        assertTrue(prefs.getBoolean("pipsAdded", false));
    }

    @Test
    void typesAreKeptApart() {
        prefs.edit().putInt("counter", 3).putString("canbus_class", "x").commit();
        assertEquals(3, prefs.getInt("counter", 0));
        assertEquals(0L, prefs.getLong("counter", 0L));            // wrong type -> default
        assertEquals("x", prefs.getString("canbus_class", "empty"));
    }

    @Test
    void clearRunsBeforeThePutsOfTheSameEdit() {
        prefs.edit().putBoolean("a", true).apply();
        prefs.edit().putBoolean("b", true).clear().apply();
        assertFalse(prefs.contains("a"));
        assertTrue(prefs.getBoolean("b", false));
    }

    @Test
    void removeAndNullStringDropTheKey() {
        prefs.edit().putString("s", "v").putInt("i", 1).apply();
        prefs.edit().remove("i").putString("s", null).apply();
        assertFalse(prefs.contains("i"));
        assertNull(prefs.getString("s", null));
    }

    @Test
    void aReusedEditorStartsEmptyAfterApply() {
        // Helpers keeps one static editor for all its setters.
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("x", true).apply();
        prefs.edit().putBoolean("x", false).apply();
        editor.putInt("y", 1).apply();                              // must not bring x=true back
        assertFalse(prefs.getBoolean("x", true));
        assertEquals(1, prefs.getInt("y", 0));
    }
}
