package com.android.launcher66;

import android.content.SharedPreferences;

import com.android.launcher66.settings.Keys;

import java.util.Collection;
import java.util.HashSet;

/**
 * Where the drawer's tabs are kept: one string in the launcher's preferences under {@link Keys#DRAWER_TABS}, the
 * text of {@link DrawerTabs#serialize}.
 *
 * <p>The rule (D-85, "Stock layout"): the tabs, the hidden apps and the rule for apps in several tabs belong to the
 * layout creator ({@code drawer_tabs} is a key of its screen). A read goes through {@link CreatorPrefs}, so with the
 * stock layout the model is the one with only the main tab and nothing hidden, while what the user set is kept and
 * comes back with the creator. A write is {@code apply()}: no disk work on the main thread.
 */
public final class DrawerTabsStore {

    private DrawerTabsStore() {
    }

    /**
     * The model now.
     *
     * @param installed the packages of the apps that are installed: the model forgets the others (an uninstalled app
     *                  leaves it at the next read); {@code null} or empty (the list of apps is not loaded yet) forgets
     *                  nothing, so that a start before the list is ready cannot wipe the tabs
     */
    public static DrawerTabs load(SharedPreferences prefs, Collection<String> installed) {
        DrawerTabs model = DrawerTabs.parse(CreatorPrefs.of(prefs).getString(Keys.DRAWER_TABS, ""));
        if (installed != null && !installed.isEmpty()) {
            model.prune(new HashSet<>(installed));
        }
        return model;
    }

    /** Stores the model; the next read of every part of the launcher sees it. */
    public static void save(SharedPreferences prefs, DrawerTabs model) {
        prefs.edit().putString(Keys.DRAWER_TABS, model.serialize()).apply();
    }
}
