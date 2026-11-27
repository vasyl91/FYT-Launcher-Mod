package com.android.launcher66;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The tabs of the app drawer: what they are called, which apps they hold, and which apps the main tab shows.
 *
 * <p>The rules (the owner's, 2026-11-25), all of them held here and tested:
 * <ul>
 *   <li>There is always the main tab, id {@link #MAIN}: first in the list, never deleted, never moved; it may be
 *       renamed. The other tabs have an order of their own, a name (blank means the default "Tab&lt;n&gt;", n being the
 *       tab's place in the list, the main tab being 1), a set of apps and the flag "keep apps in the main tab".</li>
 *   <li>A hidden app is in no tab of the drawer.</li>
 *   <li>With {@link Repeat#ALL} the main tab shows every app that is not hidden, whatever other tabs have it: the apps
 *       repeat everywhere, and "keep apps in the main tab" does nothing ({@link #keepApplies}). With
 *       {@link Repeat#EXCEPT_MAIN} and {@link Repeat#NONE} the main tab shows the apps that are in no other tab, and
 *       the apps of the tabs that keep their apps in the main tab (the owner, 2026-11-27).</li>
 *   <li>With {@code ALL} and {@code EXCEPT_MAIN} an app may be in several of the other tabs; with {@code NONE} in
 *       one at most, and the list an app is picked from leaves out the apps of the other tabs
 *       ({@link #candidates}). Switching to {@code NONE} keeps an app in the first tab that has it.</li>
 *   <li>A name is any text of at most {@link #MAX_NAME} characters; a longer one is cut. A name of nothing but blanks
 *       and invisible characters is no name: it adds no tab and changes none.</li>
 *   <li>Deleting a tab gives its apps back to where the rules put them (the main tab, if they are in no other tab);
 *       an app that is no longer installed leaves the model at the next {@link #prune}.</li>
 * </ul>
 * The model is kept as one string in the preferences ({@link #serialize}, {@link #parse}). Pure Java, so that it has
 * a test.
 */
public final class DrawerTabs {

    /** The main tab's id. */
    public static final int MAIN = 0;
    /** The longest name of a tab, in characters (the field's InputFilter holds the same). */
    public static final int MAX_NAME = 50;

    /** How an app may be in several tabs ("Apps in several tabs"); the stored values are the names in lower case. */
    public enum Repeat {
        ALL, EXCEPT_MAIN, NONE;

        public String value() {
            switch (this) {
                case EXCEPT_MAIN: return "except_main";
                case NONE: return "none";
                default: return "all";
            }
        }

        public static Repeat parse(String value) {
            if ("except_main".equals(value)) {
                return EXCEPT_MAIN;
            }
            return "none".equals(value) ? NONE : ALL;
        }
    }

    /** One tab. The main tab holds no apps of its own: what it shows is computed. */
    static final class Tab {
        final int id;
        String name;                       // null or blank: the default
        boolean keepInMain;
        final Set<String> packages = new LinkedHashSet<>();

        Tab(int id) {
            this.id = id;
        }
    }

    private final Tab main = new Tab(MAIN);
    private final List<Tab> others = new ArrayList<>();
    private final Set<String> hidden = new LinkedHashSet<>();
    private Repeat repeat = Repeat.ALL;
    private int nextId = 1;

    // ------------------------------------------------------------------ names

    /** Whether a name is nothing: blanks, control and invisible characters only. */
    public static boolean isBlank(String name) {
        if (name == null) {
            return true;
        }
        for (int i = 0; i < name.length(); ) {
            int cp = name.codePointAt(i);
            i += Character.charCount(cp);
            int type = Character.getType(cp);
            boolean invisible = Character.isWhitespace(cp) || Character.isSpaceChar(cp)
                    || type == Character.FORMAT || type == Character.CONTROL || type == Character.UNASSIGNED
                    || type == Character.NON_SPACING_MARK || type == Character.ENCLOSING_MARK;
            if (!invisible) {
                return false;
            }
        }
        return true;
    }

    /** The name as it is kept: trimmed, cut to {@link #MAX_NAME} characters without cutting a pair; null for no name. */
    public static String cleanName(String name) {
        if (isBlank(name)) {
            return null;
        }
        String trimmed = name.trim();
        if (trimmed.length() <= MAX_NAME) {
            return trimmed;
        }
        int end = MAX_NAME;
        if (Character.isHighSurrogate(trimmed.charAt(end - 1))) {
            end--;
        }
        return trimmed.substring(0, end).trim();
    }

    /** The tab's place in the list, 1 for the main tab. */
    public int positionOf(int id) {
        if (id == MAIN) {
            return 1;
        }
        for (int i = 0; i < others.size(); i++) {
            if (others.get(i).id == id) {
                return i + 2;
            }
        }
        return -1;
    }

    /**
     * What a tab is called.
     *
     * @param mainDefault the main tab's default name ("Apps")
     * @param tabPattern  the other tabs' default name with the place in it ("Tab%1$d")
     */
    public String nameOf(int id, String mainDefault, String tabPattern) {
        Tab tab = find(id);
        if (tab == null) {
            return "";
        }
        String custom = tab.name == null ? null : cleanName(tab.name);
        if (custom != null) {
            return custom;
        }
        return id == MAIN ? mainDefault : String.format(tabPattern, positionOf(id));
    }

    // ------------------------------------------------------------------ the tabs

    private Tab find(int id) {
        if (id == MAIN) {
            return main;
        }
        for (Tab tab : others) {
            if (tab.id == id) {
                return tab;
            }
        }
        return null;
    }

    /** The ids of the tabs in their order, the main tab first. */
    public List<Integer> ids() {
        List<Integer> ids = new ArrayList<>();
        ids.add(MAIN);
        for (Tab tab : others) {
            ids.add(tab.id);
        }
        return ids;
    }

    public int count() {
        return 1 + others.size();
    }

    /** Whether the drawer shows a strip of tabs: with only the main tab it looks as without tabs. */
    public boolean hasStrip() {
        return count() >= 2;
    }

    /** Adds a tab at the end. Returns its id, or -1 when the name is blank (nothing is added). */
    public int add(String name, boolean keepInMain) {
        String clean = cleanName(name);
        if (clean == null) {
            return -1;
        }
        Tab tab = new Tab(nextId++);
        tab.name = clean;
        tab.keepInMain = keepInMain;
        others.add(tab);
        return tab.id;
    }

    /** Renames a tab (the main tab too); a blank name changes nothing. Returns whether it changed. */
    public boolean rename(int id, String name) {
        String clean = cleanName(name);
        Tab tab = find(id);
        if (clean == null || tab == null || clean.equals(tab.name)) {
            return false;
        }
        tab.name = clean;
        return true;
    }

    public boolean keepInMain(int id) {
        Tab tab = find(id);
        return tab != null && id != MAIN && tab.keepInMain;
    }

    /** Sets the flag of another tab; the main tab has none. */
    public void setKeepInMain(int id, boolean keep) {
        Tab tab = find(id);
        if (tab != null && id != MAIN) {
            tab.keepInMain = keep;
        }
    }

    /** Deletes a tab but the main one. Its apps are in the tabs the rules put them in (see the class). */
    public boolean delete(int id) {
        if (id == MAIN) {
            return false;
        }
        for (int i = 0; i < others.size(); i++) {
            if (others.get(i).id == id) {
                others.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Moves a tab in the list of all the tabs (the main tab is at 0): the main tab does not move and nothing
     * moves to before it.
     */
    public boolean move(int from, int to) {
        if (from <= 0 || from > others.size() || to <= 0) {
            return false;
        }
        int target = Math.min(to, others.size());
        if (target == from) {
            return false;
        }
        others.add(target - 1, others.remove(from - 1));
        return true;
    }

    // ------------------------------------------------------------------ the rules for the apps

    public Repeat repeat() {
        return repeat;
    }

    /** Sets the rule; {@code NONE} keeps an app that is in several tabs in the first one that has it. */
    public void setRepeat(Repeat value) {
        repeat = value == null ? Repeat.ALL : value;
        if (repeat == Repeat.NONE) {
            Set<String> seen = new LinkedHashSet<>();
            for (Tab tab : others) {
                tab.packages.removeAll(seen);
                seen.addAll(tab.packages);
            }
        }
    }

    /** Whether "keep apps in the main tab" does anything with the rule now: not with ALL, where every app is there. */
    public boolean keepApplies() {
        return repeat != Repeat.ALL;
    }

    public Set<String> hidden() {
        return hidden;
    }

    public boolean isHidden(String pkg) {
        return hidden.contains(pkg);
    }

    /** Sets the hidden apps. */
    public void setHidden(Collection<String> packages) {
        hidden.clear();
        hidden.addAll(packages);
    }

    /** The apps picked for a tab (the main tab has none of its own). */
    public Set<String> packagesOf(int id) {
        Tab tab = find(id);
        return tab == null || id == MAIN ? new LinkedHashSet<String>() : new LinkedHashSet<>(tab.packages);
    }

    /**
     * Sets the apps of a tab. With the rule {@code NONE} an app that another tab has is not taken; the others
     * stay as they were.
     */
    public void setPackages(int id, Collection<String> packages) {
        Tab tab = find(id);
        if (tab == null || id == MAIN) {
            return;
        }
        tab.packages.clear();
        for (String pkg : packages) {
            if (repeat == Repeat.NONE && inAnotherTab(pkg, id)) {
                continue;
            }
            tab.packages.add(pkg);
        }
    }

    private boolean inAnotherTab(String pkg, int id) {
        for (Tab other : others) {
            if (other.id != id && other.packages.contains(pkg)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The apps a tab's list of apps offers, in the order of {@code all}: every app that is not hidden (and the hidden
     * ones too when they are asked for); with the rule {@code NONE} not the apps of the other tabs, but those of this one.
     */
    public List<String> candidates(int id, List<String> all, boolean showHidden) {
        List<String> result = new ArrayList<>();
        for (String pkg : all) {
            if (isHidden(pkg) && !showHidden) {
                continue;
            }
            if (repeat == Repeat.NONE && inAnotherTab(pkg, id)) {
                continue;
            }
            result.add(pkg);
        }
        return result;
    }

    /**
     * The apps a tab shows in the drawer, in the order of {@code all} (the apps installed, in the drawer's order).
     * Hidden apps are never shown.
     */
    public List<String> appsOf(int id, List<String> all) {
        List<String> result = new ArrayList<>();
        if (find(id) == null) {
            return result;
        }
        Set<String> inOthers = new LinkedHashSet<>();
        Set<String> kept = new LinkedHashSet<>();
        for (Tab tab : others) {
            inOthers.addAll(tab.packages);
            if (tab.keepInMain && keepApplies()) {
                kept.addAll(tab.packages);
            }
        }
        Set<String> own = packagesOf(id);
        for (String pkg : all) {
            if (isHidden(pkg)) {
                continue;
            }
            boolean show;
            if (id == MAIN) {
                show = repeat == Repeat.ALL || !inOthers.contains(pkg) || kept.contains(pkg);
            } else {
                show = own.contains(pkg);
            }
            if (show) {
                result.add(pkg);
            }
        }
        return result;
    }

    /** The tabs that keep their apps in the main tab, for the lines under the rule (only where it applies). */
    public List<Integer> tabsKeepingInMain() {
        List<Integer> ids = new ArrayList<>();
        if (!keepApplies()) {
            return ids;
        }
        for (Tab tab : others) {
            if (tab.keepInMain) {
                ids.add(tab.id);
            }
        }
        return ids;
    }

    /** Drops the apps that are not installed any more from the tabs and from the hidden ones. */
    public void prune(Set<String> installed) {
        hidden.retainAll(installed);
        for (Tab tab : others) {
            tab.packages.retainAll(installed);
        }
    }

    // ------------------------------------------------------------------ the stored form

    private static String enc(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String dec(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            return "";
        }
    }

    /** One line for the rule and the main tab's name, one for the hidden apps and one for each other tab. */
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("v1\t").append(repeat.value()).append('\t').append(nextId).append('\t')
                .append(main.name == null ? "" : enc(main.name)).append('\n');
        sb.append("hidden");
        for (String pkg : hidden) {
            sb.append('\t').append(enc(pkg));
        }
        sb.append('\n');
        for (Tab tab : others) {
            sb.append("tab\t").append(tab.id).append('\t').append(tab.keepInMain ? 1 : 0).append('\t')
                    .append(tab.name == null ? "" : enc(tab.name));
            for (String pkg : tab.packages) {
                sb.append('\t').append(enc(pkg));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /** The model of a stored string; an empty or a damaged one is the model with only the main tab. */
    public static DrawerTabs parse(String stored) {
        DrawerTabs model = new DrawerTabs();
        if (stored == null || stored.isEmpty()) {
            return model;
        }
        String[] lines = stored.split("\n");
        for (String line : lines) {
            String[] f = line.split("\t", -1);
            try {
                if (f[0].equals("v1") && f.length >= 4) {
                    model.repeat = Repeat.parse(f[1]);
                    model.nextId = Math.max(1, Integer.parseInt(f[2]));
                    String name = dec(f[3]);
                    model.main.name = cleanName(name);
                } else if (f[0].equals("hidden")) {
                    for (int i = 1; i < f.length; i++) {
                        if (!f[i].isEmpty()) {
                            model.hidden.add(dec(f[i]));
                        }
                    }
                } else if (f[0].equals("tab") && f.length >= 4) {
                    Tab tab = new Tab(Integer.parseInt(f[1]));
                    if (tab.id <= MAIN || model.find(tab.id) != null) {
                        continue;
                    }
                    tab.keepInMain = "1".equals(f[2]);
                    tab.name = cleanName(dec(f[3]));
                    for (int i = 4; i < f.length; i++) {
                        if (!f[i].isEmpty()) {
                            tab.packages.add(dec(f[i]));
                        }
                    }
                    model.others.add(tab);
                    model.nextId = Math.max(model.nextId, tab.id + 1);
                }
            } catch (NumberFormatException e) {
                // a damaged line is left out
            }
        }
        if (model.repeat == Repeat.NONE) {
            model.setRepeat(Repeat.NONE);   // an old multiple membership is cut to the first tab
        }
        return model;
    }
}
