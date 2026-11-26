package com.android.launcher66;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The list of apps with a checkbox on the screens "Select apps" (the apps of one tab) and "Hide apps" (the hidden
 * ones), without anything of Android, so that its rules have a test.
 *
 * <p>The rules (the owner's, 2026-11-25):
 * <ul>
 *   <li>The list of a tab offers the apps {@link DrawerTabs#candidates} names, in the drawer's order: with the rule
 *       "do not allow" not the apps of another tab. A hidden app is on it only with "Show hidden apps". An app picked
 *       for the tab that the list leaves out stays picked.</li>
 *   <li>The list of the hidden apps offers the apps that are not hidden, and with "Show hidden apps" the hidden ones
 *       too. <b>Without it an app that was ticked stays on the list</b> until the option is turned on and off, or
 *       until the screen is opened again: it is not taken away from under the finger that ticked it.</li>
 *   <li>"Show hidden apps" works on the lists only; the drawer never shows a hidden app.</li>
 * </ul>
 * A tick changes the model it was given; storing it ({@link DrawerTabsStore#save}) is up to the caller.
 */
public final class DrawerAppList {

    /** The id that stands for "the hidden apps" where a tab's id is expected. */
    public static final int HIDDEN = -1;

    /** An app of the list: the package the model keeps it under, and the name the list shows. */
    public static final class App {
        public final String pkg;
        public final String label;

        public App(String pkg, String label) {
            this.pkg = pkg;
            this.label = label;
        }
    }

    private final DrawerTabs model;
    private final int tab;
    private final List<App> all;
    private boolean showHidden;
    /** The list of the hidden apps: those ticked while the hidden ones are not shown. */
    private final Set<String> pinned = new LinkedHashSet<>();

    /**
     * @param model the model the ticks change
     * @param tab   the id of a tab, or {@link #HIDDEN}
     * @param all   the apps installed, one per package, in the drawer's order
     */
    public DrawerAppList(DrawerTabs model, int tab, List<App> all) {
        this.model = model;
        this.tab = tab;
        this.all = new ArrayList<>(all);
    }

    public boolean isHiddenList() {
        return tab == HIDDEN;
    }

    public boolean showHidden() {
        return showHidden;
    }

    /** "Show hidden apps": the apps kept on the list by a tick go with it. */
    public void setShowHidden(boolean show) {
        if (show != showHidden) {
            pinned.clear();
        }
        showHidden = show;
    }

    /** The apps on the list now. */
    public List<App> rows() {
        List<App> rows = new ArrayList<>();
        if (isHiddenList()) {
            for (App app : all) {
                if (showHidden || !model.isHidden(app.pkg) || pinned.contains(app.pkg)) {
                    rows.add(app);
                }
            }
            return rows;
        }
        List<String> packages = new ArrayList<>();
        for (App app : all) {
            packages.add(app.pkg);
        }
        Set<String> offered = new LinkedHashSet<>(model.candidates(tab, packages, showHidden));
        for (App app : all) {
            if (offered.contains(app.pkg)) {
                rows.add(app);
            }
        }
        return rows;
    }

    public boolean isChecked(String pkg) {
        return isHiddenList() ? model.isHidden(pkg) : model.packagesOf(tab).contains(pkg);
    }

    /** Ticks an app that is not ticked, and the reverse. */
    public void toggle(String pkg) {
        if (isHiddenList()) {
            Set<String> hidden = new LinkedHashSet<>(model.hidden());
            if (!hidden.remove(pkg)) {
                hidden.add(pkg);
                if (!showHidden) {
                    pinned.add(pkg);
                }
            }
            model.setHidden(hidden);
            return;
        }
        // The whole set is rewritten from the current one, so that the apps this list does not show stay as they are
        Set<String> packages = model.packagesOf(tab);
        if (!packages.remove(pkg)) {
            packages.add(pkg);
        }
        model.setPackages(tab, packages);
    }
}
