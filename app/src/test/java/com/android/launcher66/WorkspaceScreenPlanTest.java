package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.Keys;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

class WorkspaceScreenPlanTest {

    private static final long USER = WorkspaceScreenPlan.USER_PAGE_ID;

    private static List<Long> ids(long... values) {
        Long[] boxed = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
            boxed[i] = values[i];
        }
        return Arrays.asList(boxed);
    }

    private static Set<Long> set(long... values) {
        return new HashSet<>(ids(values));
    }

    private static EnumMap<CustomElement, Integer> pages(Object... pairs) {
        EnumMap<CustomElement, Integer> map = new EnumMap<>(CustomElement.class);
        for (int i = 0; i < pairs.length; i += 2) {
            map.put((CustomElement) pairs[i], (Integer) pairs[i + 1]);
        }
        return map;
    }

    private static WorkspaceScreenPlan.Input input(List<Long> order, Set<Long> content,
                                                  Map<CustomElement, Integer> requested) {
        return new WorkspaceScreenPlan.Input(order, content, Collections.<Long>emptySet(), requested,
                Collections.<String, Integer>emptyMap(), false, null);
    }

    private static WorkspaceScreenPlan.Input creating(List<Long> order, Set<Long> content,
                                                     Map<CustomElement, Integer> requested,
                                                     AtomicLong next) {
        return new WorkspaceScreenPlan.Input(order, content, Collections.<Long>emptySet(), requested,
                Collections.<String, Integer>emptyMap(), true, next::getAndIncrement);
    }

    private static WorkspaceScreenPlan.Input withRefs(List<Long> order, Set<Long> content,
                                                     Map<CustomElement, Integer> requested,
                                                     Map<String, Integer> refs) {
        return new WorkspaceScreenPlan.Input(order, content, Collections.<Long>emptySet(), requested,
                refs, false, null);
    }

    @Test
    void theLayoutFromTheOwnersLogStaysAsItIs() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3, 4, 5, 6), set(3, 6),
                pages(CustomElement.PIP_DUAL, 1, CustomElement.PIP_THIRD, 1, CustomElement.STATS, 1,
                        CustomElement.PIP_FOURTH, 3, CustomElement.DATE, 4, CustomElement.MUSIC, 4,
                        CustomElement.RADIO, 4)));
        assertEquals(ids(3, 4, 5, 6), result.order);
        assertTrue(result.removed.isEmpty());
        assertTrue(result.created.isEmpty());
        assertTrue(result.prefChanges.isEmpty());
        assertFalse(result.changed());
        assertEquals(USER, (long) result.elementScreens.get(CustomElement.PIP_DUAL));
        assertEquals(USER, (long) result.elementScreens.get(CustomElement.PIP_THIRD));
        assertEquals(USER, (long) result.elementScreens.get(CustomElement.STATS));
        assertEquals(4L, (long) result.elementScreens.get(CustomElement.PIP_FOURTH));
        assertEquals(5L, (long) result.elementScreens.get(CustomElement.DATE));
        assertEquals(5L, (long) result.elementScreens.get(CustomElement.MUSIC));
        assertEquals(5L, (long) result.elementScreens.get(CustomElement.RADIO));
    }

    @Test
    void anEmptyPageBeforeAPageWithAnElementIsRemovedAndTheElementMovesDown() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3, 4, 5), set(3), pages(CustomElement.MUSIC, 4)));
        assertEquals(ids(4), result.removed);
        assertEquals(ids(3, 5), result.order);
        assertEquals(3, (int) result.elementPages.get(CustomElement.MUSIC));
        assertEquals(5L, (long) result.elementScreens.get(CustomElement.MUSIC));
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.MUSIC_SCREEN, 4, 3)), result.prefChanges);
    }

    @Test
    void withoutAnElementOnThePageBothEmptyPagesAreRemoved() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3, 4, 5), set(3), pages()));
        assertEquals(ids(4, 5), result.removed);
        assertEquals(ids(3), result.order);
        assertTrue(result.prefChanges.isEmpty());
    }

    @Test
    void aPageBehindTheEndGetsANewScreenAtTheEnd() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(creating(
                ids(3), set(3), pages(CustomElement.MUSIC, 4), new AtomicLong(10)));
        assertEquals(ids(3, 10), result.order);
        assertEquals(ids(10), result.created);
        assertTrue(result.removed.isEmpty());
        assertEquals(3, (int) result.elementPages.get(CustomElement.MUSIC));
        assertEquals(10L, (long) result.elementScreens.get(CustomElement.MUSIC));
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.MUSIC_SCREEN, 4, 3)), result.prefChanges);
    }

    @Test
    void twoElementsBehindTheEndGetTwoNewScreensWithoutAGapBetweenThem() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(creating(
                ids(3), set(3), pages(CustomElement.MUSIC, 3, CustomElement.RADIO, 5),
                new AtomicLong(10)));
        assertEquals(ids(3, 10, 11), result.order);
        assertEquals(ids(10, 11), result.created);
        assertEquals(3, (int) result.elementPages.get(CustomElement.MUSIC));
        assertEquals(4, (int) result.elementPages.get(CustomElement.RADIO));
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.RADIO_SCREEN, 5, 4)), result.prefChanges);
    }

    @Test
    void withoutCreateMissingAPageBehindTheEndGetsNothing() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3), set(3), pages(CustomElement.MUSIC, 4)));
        assertEquals(ids(3), result.order);
        assertTrue(result.created.isEmpty());
        assertTrue(result.prefChanges.isEmpty());
        assertNull(result.elementScreens.get(CustomElement.MUSIC));
        assertNull(result.elementPages.get(CustomElement.MUSIC));
        assertFalse(result.changed());
    }

    @Test
    void aScreenToKeepSurvivesWhileEmpty() {
        WorkspaceScreenPlan.Input input = new WorkspaceScreenPlan.Input(ids(3, 4), set(3), set(4),
                pages(), Collections.<String, Integer>emptyMap(), false, null);
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input);
        assertEquals(ids(3, 4), result.order);
        assertTrue(result.removed.isEmpty());
    }

    @Test
    void aSwitchedOffElementDoesNotKeepAPage() {
        // The disabled element is simply not among the requested pages, so its preference is untouched.
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3, 4), set(3), pages(CustomElement.MUSIC, 2)));
        assertEquals(ids(3), result.order);
        assertEquals(ids(4), result.removed);
        assertTrue(result.prefChanges.isEmpty());
    }

    @Test
    void theStartPageFollowsTheRemovedPages() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.START_PAGE, 4);
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(withRefs(
                ids(3, 4, 5), set(3, 5), pages(), refs));
        // page 3 (screen 4) is gone, so page 4 becomes page 3
        assertEquals(ids(4), result.removed);
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.START_PAGE, 4, 3)), result.prefChanges);
    }

    @Test
    void aRemovedStartPageMovesToTheNearestPageBeforeIt() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.START_PAGE, 3);
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(withRefs(
                ids(3, 4, 5), set(3, 5), pages(), refs));
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.START_PAGE, 3, 2)), result.prefChanges);
    }

    @Test
    void aStartPageOutsideTheRangeIsLeftAlone() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.START_PAGE, 9);
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(withRefs(
                ids(3, 4, 5), set(3), pages(), refs));
        assertTrue(result.prefChanges.isEmpty());
    }

    @Test
    void thePinnedPipPageMovesLikeTheStartPage() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.PINNED_PIP_SCREEN, 4);
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(withRefs(
                ids(3, 4, 5), set(3, 5), pages(), refs));
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.PINNED_PIP_SCREEN, 4, 3)), result.prefChanges);
    }

    @Test
    void aPageRefDoesNotKeepAPageAlive() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.START_PAGE, 3);
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(withRefs(
                ids(3, 4), set(3), pages(), refs));
        assertEquals(ids(4), result.removed);
    }

    @Test
    void duplicatesAndNegativeIdsInTheInputAreDropped() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3, 3, -201, 4), set(3, 4), pages()));
        assertEquals(ids(3, 4), result.order);
        assertTrue(result.orderChanged());
        assertTrue(result.changed());
        assertTrue(result.removed.isEmpty());
    }

    @Test
    void planningAPlannedLayoutAgainChangesNothing() {
        EnumMap<CustomElement, Integer> requested = pages(CustomElement.MUSIC, 4, CustomElement.DATE, 6);
        WorkspaceScreenPlan.Result first = WorkspaceScreenPlan.plan(creating(
                ids(3, 4, 5), set(3), requested, new AtomicLong(20)));

        EnumMap<CustomElement, Integer> after = new EnumMap<>(requested);
        after.putAll(first.elementPages);
        WorkspaceScreenPlan.Result second = WorkspaceScreenPlan.plan(creating(
                first.order, set(3), after, new AtomicLong(30)));
        assertFalse(second.changed());
        assertEquals(first.order, second.order);
        assertEquals(first.elementScreens, second.elementScreens);
    }

    @Test
    void aPageBelowOneBecomesPageOne() {
        WorkspaceScreenPlan.Result result = WorkspaceScreenPlan.plan(input(
                ids(3), set(3), pages(CustomElement.DATE, 0)));
        assertEquals(1, (int) result.elementPages.get(CustomElement.DATE));
        assertEquals(USER, (long) result.elementScreens.get(CustomElement.DATE));
        assertEquals(Collections.singletonList(
                new WorkspaceScreenPlan.PrefChange(Keys.DATE_SCREEN, 0, 1)), result.prefChanges);
    }

    @Test
    void reorderingTheScreensMakesTheElementsAndTheStartPageFollowTheirScreens() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.MUSIC_SCREEN, 4);
        refs.put(Keys.START_PAGE, 2);
        List<WorkspaceScreenPlan.PrefChange> changes = WorkspaceScreenPlan.remapAfterReorder(
                ids(USER, 3, 4, 5), ids(USER, 5, 3, 4), refs);
        assertEquals(Arrays.asList(
                new WorkspaceScreenPlan.PrefChange(Keys.MUSIC_SCREEN, 4, 2),
                new WorkspaceScreenPlan.PrefChange(Keys.START_PAGE, 2, 3)), changes);
    }

    @Test
    void reorderingLeavesAReferenceInPlaceWhenItsScreenDidNotMove() {
        Map<String, Integer> refs = new LinkedHashMap<>();
        refs.put(Keys.RADIO_SCREEN, 1);
        assertTrue(WorkspaceScreenPlan.remapAfterReorder(
                ids(USER, 3, 4), ids(USER, 4, 3), refs).isEmpty());
    }

    @Test
    void theSnapshotCountsThePagesAndKnowsWhichOnesHoldSomething() {
        WorkspaceScreenPlan.Snapshot snapshot = new WorkspaceScreenPlan.Snapshot(
                ids(3, 4, 5), set(4), Collections.<CustomElement, Long>emptyMap());
        assertTrue(snapshot.isReady());
        assertEquals(4, snapshot.pageCount());
        assertTrue(snapshot.pageHasContent(0));
        assertFalse(snapshot.pageHasContent(1));
        assertTrue(snapshot.pageHasContent(2));
        assertFalse(snapshot.pageHasContent(3));
        assertFalse(snapshot.pageHasContent(4));
        assertFalse(snapshot.pageHasContent(-1));
    }

    @Test
    void theEmptySnapshotIsNotReady() {
        assertFalse(WorkspaceScreenPlan.Snapshot.EMPTY.isReady());
        assertEquals(1, WorkspaceScreenPlan.Snapshot.EMPTY.pageCount());
    }

    @Test
    void theElementsKnowTheirKeysAndDefaults() {
        assertEquals(CustomElement.PIP_THIRD, CustomElement.fromLabel("third"));
        assertEquals(CustomElement.STATS, CustomElement.fromScreenKey(Keys.STATS_SCREEN));
        assertNull(CustomElement.fromLabel("nope"));
        assertTrue(CustomElement.PIP_DUAL.isPip());
        assertFalse(CustomElement.STATS.isPip());
        assertTrue(CustomElement.DATE.defaultEnabled);
        assertFalse(CustomElement.PIP_FIRST.defaultEnabled);
    }
}
