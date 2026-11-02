package com.android.launcher66;

import android.content.SharedPreferences;

import com.android.launcher66.settings.Keys;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

/** Reads and writes the page numbers of the custom elements for {@link WorkspaceScreenPlan}. */
public final class CustomElementPrefs {
    private CustomElementPrefs() { }

    /** The page, from 1, of every element that is switched on. */
    public static EnumMap<CustomElement, Integer> requestedPages(SharedPreferences prefs) {
        EnumMap<CustomElement, Integer> pages = new EnumMap<>(CustomElement.class);
        for (CustomElement element : CustomElement.values()) {
            if (prefs.getBoolean(element.enabledKey, element.defaultEnabled)) {
                pages.put(element, readInt(prefs, element.screenKey, 1));
            }
        }
        return pages;
    }

    /**
     * The preferences that follow the pages without holding one: the start page and the pinned PiP.
     * A missing or broken value is left out.
     */
    public static LinkedHashMap<String, Integer> pageRefs(SharedPreferences prefs) {
        LinkedHashMap<String, Integer> refs = new LinkedHashMap<>();
        if (prefs.contains(Keys.START_PAGE)) {
            try {
                String value = prefs.getString(Keys.START_PAGE, "");
                if (value != null && !value.trim().isEmpty()) {
                    refs.put(Keys.START_PAGE, Integer.parseInt(value.trim()));
                }
            } catch (NumberFormatException | ClassCastException ignored) {
                // a broken start page is left alone, the launcher falls back to the first page
            }
        }
        if (prefs.contains(Keys.PINNED_PIP_SCREEN)) {
            refs.put(Keys.PINNED_PIP_SCREEN, readInt(prefs, Keys.PINNED_PIP_SCREEN, 1));
        }
        return refs;
    }

    /**
     * Writes the changes in one edit. A change is applied only while the preference still has the value
     * it was planned from, so planning the same layout twice does not shift the pages twice.
     */
    public static void apply(SharedPreferences prefs, List<WorkspaceScreenPlan.PrefChange> changes) {
        if (changes == null || changes.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editor = null;
        for (WorkspaceScreenPlan.PrefChange change : changes) {
            boolean isStartPage = Keys.START_PAGE.equals(change.key);
            int current;
            if (isStartPage) {
                try {
                    current = Integer.parseInt(prefs.getString(change.key, "").trim());
                } catch (NumberFormatException | ClassCastException e) {
                    continue;
                }
            } else {
                current = readInt(prefs, change.key, 1);
            }
            if (current != change.from) {
                continue;
            }
            if (editor == null) {
                editor = prefs.edit();
            }
            if (isStartPage) {
                editor.putString(change.key, String.valueOf(change.to));
            } else {
                editor.putInt(change.key, change.to);
            }
        }
        if (editor != null) {
            editor.apply();
        }
    }

    private static int readInt(SharedPreferences prefs, String key, int fallback) {
        try {
            return prefs.getInt(key, fallback);
        } catch (ClassCastException e) {
            return fallback;
        }
    }
}
