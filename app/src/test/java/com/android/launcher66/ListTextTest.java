package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ListTextTest {

    @Test
    void namesAreQuotedAndJoinedAsTheLanguageDoes() {
        List<String> q = ListText.quoted(Arrays.asList("Tab2", "Tab5", "Tab8"), "“%1$s”");
        assertEquals("“Tab2”, “Tab5” and “Tab8”", ListText.join(q, ", ", "%1$s and %2$s"));
        assertEquals("„Tab2”, „Tab5” i „Tab8”",
                ListText.join(ListText.quoted(Arrays.asList("Tab2", "Tab5", "Tab8"), "„%1$s”"), ", ", "%1$s i %2$s"));
        assertEquals("「A」、「B」と「C」",
                ListText.join(ListText.quoted(Arrays.asList("A", "B", "C"), "「%1$s」"), "、", "%1$sと%2$s"));
    }

    @Test
    void oneNameIsItselfAndTwoAreJoinedByTheLastJoiner() {
        assertEquals("“A”", ListText.join(ListText.quoted(Collections.singletonList("A"), "“%1$s”"), ", ", "%1$s and %2$s"));
        assertEquals("A and B", ListText.join(Arrays.asList("A", "B"), ", ", "%1$s and %2$s"));
        assertEquals("", ListText.join(Collections.emptyList(), ", ", "%1$s and %2$s"));
    }

    @Test
    void aNameWithAPercentSignIsKeptAsItIs() {
        assertEquals("“50% off”", ListText.quoted(Collections.singletonList("50% off"), "“%1$s”").get(0));
        assertEquals("100% and 50%", ListText.join(Arrays.asList("100%", "50%"), ", ", "%1$s and %2$s"));
    }
}
