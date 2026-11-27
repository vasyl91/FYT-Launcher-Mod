package com.android.launcher66;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The widgets and shortcuts of the widget list, grouped by the app they belong to.
 *
 * <p>The rules (the owner's, 2026-11-25, D-89): one group for each app, in the alphabetical order of the app's name
 * (the collator of the language, so that accents sort as people expect); in a group the widgets and the shortcuts each in
 * the order of their names. A group knows how many widgets and shortcuts it has (for "1 widget, 3 shortcuts"). The search
 * keeps the groups whose app name or one of whose entries' names matches what was typed (AppSearch: no capitals, no
 * accents); when the app's name matches, all of its entries stay, else only the entries that match. Pure Java, so that
 * it has a test; the list's adapter puts the real widget and shortcut infos in {@link Entry#payload}.
 */
final class WidgetGroups {

    /** A widget or a shortcut of an app. */
    static final class Entry {
        final String packageName;
        final String appLabel;
        final String label;
        final boolean shortcut;
        final Object payload;

        Entry(String packageName, String appLabel, String label, boolean shortcut, Object payload) {
            this.packageName = packageName;
            this.appLabel = appLabel == null ? "" : appLabel;
            this.label = label == null ? "" : label;
            this.shortcut = shortcut;
            this.payload = payload;
        }
    }

    /** The widgets and the shortcuts of one app. */
    static final class Group {
        final String packageName;
        final String appLabel;
        final List<Entry> widgets = new ArrayList<>();
        final List<Entry> shortcuts = new ArrayList<>();

        Group(String packageName, String appLabel) {
            this.packageName = packageName;
            this.appLabel = appLabel;
        }

        int widgetCount() {
            return widgets.size();
        }

        int shortcutCount() {
            return shortcuts.size();
        }
    }

    private WidgetGroups() {
    }

    /** The groups for the entries, filtered by {@code query} (blank: all of them), in the order described above. */
    static List<Group> group(List<Entry> entries, Locale locale, String query) {
        final Collator collator = Collator.getInstance(locale == null ? Locale.getDefault() : locale);
        collator.setStrength(Collator.SECONDARY);
        Map<String, Group> byPackage = new LinkedHashMap<>();
        boolean filtering = !AppSearch.normalize(query).isEmpty();
        for (Entry entry : entries) {
            boolean appMatches = !filtering || AppSearch.matches(entry.appLabel, query);
            if (!appMatches && !AppSearch.matches(entry.label, query)) {
                continue;
            }
            Group group = byPackage.get(entry.packageName);
            if (group == null) {
                group = new Group(entry.packageName, entry.appLabel);
                byPackage.put(entry.packageName, group);
            }
            (entry.shortcut ? group.shortcuts : group.widgets).add(entry);
        }
        Comparator<Entry> byLabel = new Comparator<Entry>() {
            @Override
            public int compare(Entry a, Entry b) {
                return collator.compare(a.label, b.label);
            }
        };
        List<Group> groups = new ArrayList<>(byPackage.values());
        for (Group group : groups) {
            Collections.sort(group.widgets, byLabel);
            Collections.sort(group.shortcuts, byLabel);
        }
        Collections.sort(groups, new Comparator<Group>() {
            @Override
            public int compare(Group a, Group b) {
                int c = collator.compare(a.appLabel, b.appLabel);
                return c != 0 ? c : a.packageName.compareTo(b.packageName);
            }
        });
        return groups;
    }

    /**
     * The line under an app's name: "Widgets: 1, Shortcuts: 3" from the language's two patterns, a count of none left
     * out.
     */
    static String counts(int widgets, int shortcuts, String widgetsPattern, String shortcutsPattern, String separator) {
        StringBuilder text = new StringBuilder();
        if (widgets > 0) {
            text.append(String.format(widgetsPattern, widgets));
        }
        if (shortcuts > 0) {
            if (text.length() > 0) {
                text.append(separator);
            }
            text.append(String.format(shortcutsPattern, shortcuts));
        }
        return text.toString();
    }

    /** A picture's size {width, height} scaled down, never up, to lie within a box, its proportions kept. */
    static int[] fitIn(int width, int height, int maxWidth, int maxHeight) {
        if (width <= 0 || height <= 0) {
            return new int[] {Math.max(1, maxWidth), Math.max(1, maxHeight)};
        }
        float scale = Math.min(1f, Math.min(maxWidth / (float) width, maxHeight / (float) height));
        return new int[] {Math.max(1, Math.round(width * scale)), Math.max(1, Math.round(height * scale))};
    }

    /**
     * The padding on each side of a list whose rows are {@code share} as wide as a box over it and centred under it, in a
     * list as wide as the view the box is in.
     */
    static int sidePadding(int listWidth, int boxWidth, float share) {
        return Math.max(0, Math.round((listWidth - boxWidth * share) / 2f));
    }

    /** The names of the groups, for the letter scroller (LetterIndex). */
    static List<String> titles(List<Group> groups) {
        List<String> titles = new ArrayList<>(groups.size());
        for (Group group : groups) {
            titles.add(group.appLabel);
        }
        return titles;
    }
}
