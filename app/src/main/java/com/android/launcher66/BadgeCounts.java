package com.android.launcher66;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * How many notifications an app's badge counts, and what the badge says.
 *
 * <p>The rules (the owner's, 2026-11-25): an app's number is the sum of its notifications' own numbers
 * ({@code Notification.number} above 0), a notification with none counting as one. Left out: the summary of a
 * group of notifications (its members are counted), the ones that cannot be swiped away (ongoing, a foreground
 * service's) and those of a channel that shows no badge. A number above 99 reads "99+". Pure Java, so that it has a
 * test; NotificationListener makes {@link Entry} of each notification.
 */
final class BadgeCounts {

    /** What the count needs of a notification. */
    static final class Entry {
        final String packageName;
        final int number;
        final boolean groupSummary;
        final boolean ongoing;
        final boolean foregroundService;
        final boolean canShowBadge;

        Entry(String packageName, int number, boolean groupSummary, boolean ongoing, boolean foregroundService,
              boolean canShowBadge) {
            this.packageName = packageName;
            this.number = number;
            this.groupSummary = groupSummary;
            this.ongoing = ongoing;
            this.foregroundService = foregroundService;
            this.canShowBadge = canShowBadge;
        }
    }

    private BadgeCounts() {
    }

    /** What one notification adds to its app's badge. */
    static int countOf(Entry entry) {
        if (entry.packageName == null || entry.groupSummary || entry.ongoing || entry.foregroundService
                || !entry.canShowBadge) {
            return 0;
        }
        return entry.number > 0 ? entry.number : 1;
    }

    /** The number of every package that has one: the apps with nothing to count are not in the map. */
    static Map<String, Integer> count(List<Entry> entries) {
        Map<String, Integer> counts = new HashMap<>();
        for (Entry entry : entries) {
            int n = countOf(entry);
            if (n > 0) {
                Integer old = counts.get(entry.packageName);
                counts.put(entry.packageName, (old == null ? 0 : old) + n);
            }
        }
        return counts;
    }

    /** The packages whose number is not the same in the two maps (0 for a package that is not in one). */
    static Set<String> changed(Map<String, Integer> before, Map<String, Integer> after) {
        Set<String> changed = new HashSet<>();
        for (Map.Entry<String, Integer> e : before.entrySet()) {
            Integer now = after.get(e.getKey());
            if (now == null || !now.equals(e.getValue())) {
                changed.add(e.getKey());
            }
        }
        for (String pkg : after.keySet()) {
            if (!before.containsKey(pkg)) {
                changed.add(pkg);
            }
        }
        return changed;
    }

    /** What the badge says. */
    static String label(int count) {
        return count > 99 ? "99+" : String.valueOf(count);
    }
}
