package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BadgeCountsTest {

    private static BadgeCounts.Entry n(String pkg, int number) {
        return new BadgeCounts.Entry(pkg, number, false, false, false, true);
    }

    @Test
    void aNotificationCountsItsOwnNumberOrOne() {
        assertEquals(4, BadgeCounts.countOf(n("a", 4)));
        assertEquals(1, BadgeCounts.countOf(n("a", 0)));
        assertEquals(1, BadgeCounts.countOf(n("a", -3)));
    }

    @Test
    void theSummaryOfAGroupAndTheOnesThatCannotBeSwipedAwayAreLeftOut() {
        assertEquals(0, BadgeCounts.countOf(new BadgeCounts.Entry("a", 5, true, false, false, true)));
        assertEquals(0, BadgeCounts.countOf(new BadgeCounts.Entry("a", 5, false, true, false, true)));
        assertEquals(0, BadgeCounts.countOf(new BadgeCounts.Entry("a", 5, false, false, true, true)));
        assertEquals(0, BadgeCounts.countOf(new BadgeCounts.Entry("a", 5, false, false, false, false)));
        assertEquals(0, BadgeCounts.countOf(new BadgeCounts.Entry(null, 5, false, false, false, true)));
    }

    @Test
    void theNumberOfAnAppIsTheSumOfItsNotifications() {
        Map<String, Integer> counts = BadgeCounts.count(Arrays.asList(
                n("mail", 3), n("mail", 0), n("chat", 1),
                new BadgeCounts.Entry("chat", 9, true, false, false, true),
                new BadgeCounts.Entry("music", 1, false, true, false, true)));
        assertEquals(4, (int) counts.get("mail"));
        assertEquals(1, (int) counts.get("chat"));
        assertTrue(!counts.containsKey("music"));
    }

    @Test
    void theChangedPackagesAreThoseWhoseNumberIsNotTheSame() {
        Map<String, Integer> before = new HashMap<>();
        before.put("a", 2);
        before.put("b", 1);
        before.put("c", 5);
        Map<String, Integer> after = new HashMap<>();
        after.put("a", 3);
        after.put("c", 5);
        after.put("d", 1);
        assertEquals(new HashSet<>(Arrays.asList("a", "b", "d")), BadgeCounts.changed(before, after));
        assertTrue(BadgeCounts.changed(after, after).isEmpty());
    }

    @Test
    void aNumberAboveNinetyNineReadsNinetyNinePlus() {
        assertEquals("4", BadgeCounts.label(4));
        assertEquals("99", BadgeCounts.label(99));
        assertEquals("99+", BadgeCounts.label(100));
        assertEquals("99+", BadgeCounts.label(5000));
    }
}
