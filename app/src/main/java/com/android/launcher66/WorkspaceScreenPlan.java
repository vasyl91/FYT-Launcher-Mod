package com.android.launcher66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.LongSupplier;

/**
 * Decides which home screens exist, in what order, and on which of them every custom element lives.
 *
 * <p>The pages are numbered from 1 in the preferences: page 1 is the user page with the bottom bar
 * ({@link #USER_PAGE_ID}, it is not in the screens table), page 2 is the first screen of the table and
 * so on. An empty page that no enabled element asks for disappears and the pages behind it move down,
 * and so do the numbers kept in the preferences. A page asked for behind the end gets a new screen at
 * the end, with no empty pages in between. The class is plain Java: the model feeds it with what it read
 * from the database and the views only carry out the result.
 */
public final class WorkspaceScreenPlan {
    /** Id of the user page, the same value as {@code Workspace.CUSTOM_CONTENT_SCREEN_ID1}. */
    public static final long USER_PAGE_ID = -302L;

    private WorkspaceScreenPlan() { }

    /** A page number kept in a preference that has to change from {@link #from} to {@link #to}. */
    public static final class PrefChange {
        public final String key;
        public final int from;
        public final int to;

        public PrefChange(String key, int from, int to) {
            this.key = key;
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof PrefChange)) {
                return false;
            }
            PrefChange other = (PrefChange) o;
            return from == other.from && to == other.to && Objects.equals(key, other.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, from, to);
        }

        @Override
        public String toString() {
            return key + " " + from + "->" + to;
        }
    }

    /** What the planner decides from. The collections are copied. */
    public static final class Input {
        final List<Long> order;
        final Set<Long> screensWithContent;
        final Set<Long> keep;
        final Map<CustomElement, Integer> requestedPages;
        final Map<String, Integer> pageRefs;
        final boolean createMissing;
        final LongSupplier newScreenId;

        /**
         * @param order the screens in their order, without the user page
         * @param screensWithContent the screens that hold an icon, a folder or a widget
         * @param keep the screens that stay for now even if they are empty
         * @param requestedPages the page, from 1, of every <em>enabled</em> element
         * @param pageRefs preferences that follow the pages ({@code start_page}, the pinned PiP) but
         *                 do not keep a page on their own
         * @param createMissing whether a page asked for behind the end gets a new screen
         * @param newScreenId source of the ids for the new screens, used only with {@code createMissing}
         */
        public Input(List<Long> order, Set<Long> screensWithContent, Set<Long> keep,
                     Map<CustomElement, Integer> requestedPages, Map<String, Integer> pageRefs,
                     boolean createMissing, LongSupplier newScreenId) {
            this.order = order == null ? new ArrayList<>() : new ArrayList<>(order);
            this.screensWithContent = screensWithContent == null
                    ? new HashSet<>() : new HashSet<>(screensWithContent);
            this.keep = keep == null ? new HashSet<>() : new HashSet<>(keep);
            this.requestedPages = requestedPages == null
                    ? new EnumMap<>(CustomElement.class) : new EnumMap<>(requestedPages);
            this.pageRefs = pageRefs == null ? new LinkedHashMap<>() : new LinkedHashMap<>(pageRefs);
            this.createMissing = createMissing;
            this.newScreenId = newScreenId;
        }
    }

    /** The outcome of {@link #plan(Input)}. */
    public static final class Result {
        /** The screens that remain, in order, without the user page. */
        public final List<Long> order;
        /** Screens of the input that disappear. */
        public final List<Long> removed;
        /** Ids handed out for the new screens. */
        public final List<Long> created;
        /** The final page, from 1, of every element that got one. */
        public final EnumMap<CustomElement, Integer> elementPages;
        /** The screen of every element that got a page; {@link #USER_PAGE_ID} for page 1. */
        public final EnumMap<CustomElement, Long> elementScreens;
        public final List<PrefChange> prefChanges;
        private final List<Long> inputOrder;

        Result(List<Long> order, List<Long> removed, List<Long> created,
               EnumMap<CustomElement, Integer> elementPages,
               EnumMap<CustomElement, Long> elementScreens, List<PrefChange> prefChanges,
               List<Long> inputOrder) {
            this.order = Collections.unmodifiableList(order);
            this.removed = Collections.unmodifiableList(removed);
            this.created = Collections.unmodifiableList(created);
            this.elementPages = elementPages;
            this.elementScreens = elementScreens;
            this.prefChanges = Collections.unmodifiableList(prefChanges);
            this.inputOrder = inputOrder;
        }

        /** Whether the list of the screens differs from the one the planner got. */
        public boolean orderChanged() {
            return !order.equals(inputOrder);
        }

        public boolean changed() {
            return orderChanged() || !removed.isEmpty() || !created.isEmpty() || !prefChanges.isEmpty();
        }

        /** One line for the log. */
        public String describe() {
            StringBuilder pages = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<CustomElement, Integer> entry : elementPages.entrySet()) {
                if (!first) {
                    pages.append(", ");
                }
                first = false;
                pages.append(entry.getKey().label).append('=').append(entry.getValue());
            }
            pages.append('}');
            return "order=" + order + " removed=" + removed + " created=" + created
                    + " pages=" + pages + " prefs=" + prefChanges;
        }
    }

    /**
     * An immutable view of the plan for the main thread and the settings, which must not query the
     * database. {@link #order} is without the user page.
     */
    public static final class Snapshot {
        public static final Snapshot EMPTY = new Snapshot(null, null, null, false);

        public final List<Long> order;
        public final Set<Long> screensWithContent;
        public final Map<CustomElement, Long> elementScreens;
        private final boolean ready;

        public Snapshot(List<Long> order, Set<Long> screensWithContent,
                        Map<CustomElement, Long> elementScreens) {
            this(order, screensWithContent, elementScreens, true);
        }

        private Snapshot(List<Long> order, Set<Long> screensWithContent,
                         Map<CustomElement, Long> elementScreens, boolean ready) {
            this.order = order == null
                    ? Collections.<Long>emptyList()
                    : Collections.unmodifiableList(new ArrayList<>(order));
            this.screensWithContent = screensWithContent == null
                    ? Collections.<Long>emptySet()
                    : Collections.unmodifiableSet(new HashSet<>(screensWithContent));
            EnumMap<CustomElement, Long> copy = new EnumMap<>(CustomElement.class);
            if (elementScreens != null) {
                copy.putAll(elementScreens);
            }
            this.elementScreens = Collections.unmodifiableMap(copy);
            this.ready = ready;
        }

        /** Whether the model has published a plan yet. */
        public boolean isReady() {
            return ready;
        }

        /** Number of pages, the user page included. */
        public int pageCount() {
            return order.size() + 1;
        }

        /** Whether the page (counted from 0, so 0 is the user page) holds anything. */
        public boolean pageHasContent(int pageIndex) {
            if (pageIndex == 0) {
                return true;
            }
            int slot = pageIndex - 1;
            return slot >= 0 && slot < order.size() && screensWithContent.contains(order.get(slot));
        }
    }

    /** One page while planning; a null id is a page that does not exist yet. */
    private static final class Page {
        final Long id;
        boolean keep;

        Page(Long id) {
            this.id = id;
        }
    }

    public static Result plan(Input input) {
        List<Page> pages = new ArrayList<>();
        pages.add(new Page(USER_PAGE_ID));
        Set<Long> seen = new HashSet<>();
        for (Long id : input.order) {
            if (id != null && id >= 0 && seen.add(id)) {
                pages.add(new Page(id));
            }
        }

        // A page number below 1 is a broken preference: page 1 is the lowest there is.
        EnumMap<CustomElement, Integer> original = new EnumMap<>(CustomElement.class);
        EnumMap<CustomElement, Integer> wanted = new EnumMap<>(CustomElement.class);
        int highest = 0;
        for (Map.Entry<CustomElement, Integer> entry : input.requestedPages.entrySet()) {
            int page = entry.getValue() == null ? 1 : entry.getValue();
            original.put(entry.getKey(), page);
            page = Math.max(1, page);
            wanted.put(entry.getKey(), page);
            highest = Math.max(highest, page);
        }
        if (input.createMissing) {
            while (pages.size() < highest) {
                pages.add(new Page(null));
            }
        }

        int total = pages.size();
        pages.get(0).keep = true;
        for (Page page : pages) {
            if (page.id != null && (input.screensWithContent.contains(page.id)
                    || input.keep.contains(page.id))) {
                page.keep = true;
            }
        }
        for (int wantedPage : wanted.values()) {
            if (wantedPage <= total) {
                pages.get(wantedPage - 1).keep = true;
            }
        }

        // removedBefore[i] is the number of pages that disappear before the page with the index i.
        int[] removedBefore = new int[total + 1];
        for (int i = 0; i < total; i++) {
            removedBefore[i + 1] = removedBefore[i] + (pages.get(i).keep ? 0 : 1);
        }

        List<PrefChange> changes = new ArrayList<>();
        EnumMap<CustomElement, Integer> elementPages = new EnumMap<>(CustomElement.class);
        for (Map.Entry<CustomElement, Integer> entry : wanted.entrySet()) {
            int page = entry.getValue();
            if (page > total) {
                // createMissing is off: the page does not exist and nothing is invented for it.
                continue;
            }
            int now = page - removedBefore[page - 1];
            elementPages.put(entry.getKey(), now);
            int before = original.get(entry.getKey());
            if (now != before) {
                changes.add(new PrefChange(entry.getKey().screenKey, before, now));
            }
        }

        for (Map.Entry<String, Integer> ref : input.pageRefs.entrySet()) {
            int value = ref.getValue() == null ? 0 : ref.getValue();
            if (value < 1 || value > total) {
                continue;
            }
            // A removed page counts itself, so the start page of a removed page moves to the nearest
            // page that stays before it.
            int now = Math.max(1, value - removedBefore[value]);
            if (now != value) {
                changes.add(new PrefChange(ref.getKey(), value, now));
            }
        }

        List<Long> order = new ArrayList<>();
        List<Long> removed = new ArrayList<>();
        List<Long> created = new ArrayList<>();
        List<Long> kept = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            Page page = pages.get(i);
            if (!page.keep) {
                if (page.id != null) {
                    removed.add(page.id);
                }
                continue;
            }
            long id;
            if (page.id != null) {
                id = page.id;
            } else {
                id = input.newScreenId.getAsLong();
                created.add(id);
            }
            kept.add(id);
            if (id != USER_PAGE_ID) {
                order.add(id);
            }
        }

        EnumMap<CustomElement, Long> elementScreens = new EnumMap<>(CustomElement.class);
        for (Map.Entry<CustomElement, Integer> entry : elementPages.entrySet()) {
            elementScreens.put(entry.getKey(), kept.get(entry.getValue() - 1));
        }
        return new Result(order, removed, created, elementPages, elementScreens, changes,
                new ArrayList<>(input.order));
    }

    /**
     * Page numbers after the pages have been reordered. Both lists hold every page, the user page at
     * index 0. Every reference is a page number from 1 kept in the preference with the given key; it
     * follows its screen to the new place.
     */
    public static List<PrefChange> remapAfterReorder(List<Long> oldPages, List<Long> newPages,
                                                     Map<String, Integer> refs) {
        List<PrefChange> changes = new ArrayList<>();
        if (oldPages == null || newPages == null || refs == null) {
            return changes;
        }
        for (Map.Entry<String, Integer> ref : refs.entrySet()) {
            int value = ref.getValue() == null ? 0 : ref.getValue();
            if (value < 1 || value > oldPages.size()) {
                continue;
            }
            int index = newPages.indexOf(oldPages.get(value - 1));
            if (index < 0) {
                continue;
            }
            if (index + 1 != value) {
                changes.add(new PrefChange(ref.getKey(), value, index + 1));
            }
        }
        return changes;
    }
}
