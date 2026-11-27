package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class VerticalDragTest {

    @Test
    void anIconOfTheShownDrawerIsDraggedWhateverThePagerIsDoing() {
        // nothing about the pager's pages or its dragging state is asked
        assertNull(VerticalDrag.refusal(true, true, false, true, true, false));
    }

    @Test
    void eachRefusalHasItsReason() {
        assertEquals("not a touch", VerticalDrag.refusal(false, true, false, true, true, false));
        assertEquals("the drawer is not shown", VerticalDrag.refusal(true, false, false, true, true, false));
        assertEquals("the drawer is opening or closing", VerticalDrag.refusal(true, true, true, true, true, false));
        assertEquals("dragging is not allowed now", VerticalDrag.refusal(true, true, false, false, true, false));
        assertEquals("not an app's icon", VerticalDrag.refusal(true, true, false, true, false, false));
        assertEquals("another drag is under way", VerticalDrag.refusal(true, true, false, true, true, true));
    }
}
