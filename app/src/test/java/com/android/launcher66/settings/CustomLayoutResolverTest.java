package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CustomLayoutResolver.Element;
import com.android.launcher66.settings.CustomLayoutResolver.Env;
import com.android.launcher66.settings.CustomLayoutResolver.Result;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CustomLayoutResolverTest {

    private static final int NO = CustomLayoutResolver.NO_LIMIT;

    private static Element widget(String key, int l, int t, int r, int b, int minW, int minH) {
        return new Element(key, l, t, r, b, minW, minH, false, false);
    }

    private static Element pip(String key, int l, int t, int r, int b, int minW, int minH) {
        return new Element(key, l, t, r, b, minW, minH, true, false);
    }

    private static Element empty(String key) {
        return new Element(key, 0, 0, 0, 0, 100, 100, false, true);
    }

    /** Horizontal bar from y=1000 with a margin of 5. */
    private static Env horizontalBar(boolean withGrid) {
        Env env = new Env();
        env.margin = 5;
        env.maxBottom = PipEdgeTrim.maxBottom(1000, 5); // 995
        env.bottomTrigger = 999;
        if (withGrid) {
            env.grid = new GridGeometry(0, 0, 100, 100, 20, 10);
            env.occupied = new boolean[20][10];
        }
        return env;
    }

    private static Result resolve(Env env, Element... elements) {
        return CustomLayoutResolver.resolve(Arrays.asList(elements), env);
    }

    // ------------------------------------------------------------ move, then cut

    @Test
    void freeSpaceAboveMovesTheElementByTheWholeOverlapWithoutResizingIt() {
        Result r = resolve(horizontalBar(true), pip("pipFirst", 100, 700, 400, 1040, 200, 200));
        assertFalse(r.reset[0]);
        assertArrayEquals(new int[] {100, 655, 400, 995}, r.rects[0]);
    }

    @Test
    void withoutAKnownGridNothingMovesAndTheBottomEdgeIsCut() {
        Result r = resolve(horizontalBar(false), pip("pipFirst", 100, 700, 400, 1040, 200, 200));
        assertArrayEquals(new int[] {100, 700, 400, 995}, r.rects[0]);
    }

    @Test
    void anElementBelowTheBarComesBackAboveIt() {
        Result r = resolve(horizontalBar(true), widget("date", 100, 1010, 400, 1200, 300, 150));
        assertArrayEquals(new int[] {100, 805, 400, 995}, r.rects[0]);
    }

    @Test
    void anElementThatIsNotUnderTheBarIsLeftAlone() {
        Result r = resolve(horizontalBar(true), widget("date", 100, 700, 400, 990, 300, 150));
        assertArrayEquals(new int[] {100, 700, 400, 990}, r.rects[0]);
    }

    // ------------------------------------------------------------ database cells

    @Test
    void anOccupiedCellInTheColumnsStopsTheMoveAtTheRowBoundary() {
        Env env = horizontalBar(true);
        // pitch 100: columns 1..3, an icon in column 2 on row 5 -> the top may not go above row 6
        env.occupied[2][5] = true;
        Result r = resolve(env, pip("pipFirst", 100, 800, 400, 1240, 200, 100));
        assertEquals(600, r.rects[0][1]);
        assertEquals(995, r.rects[0][3]);
    }

    @Test
    void theBoundaryFollowsThePaddingAndTheGapBetweenTheCells() {
        Env env = horizontalBar(true);
        env.grid = new GridGeometry(10, 20, 108, 86, 20, 10);
        env.occupied = new boolean[20][10];
        env.occupied[2][5] = true;
        Result r = resolve(env, pip("pipFirst", 118, 800, 400, 1500, 200, 100));
        assertEquals(20 + 6 * 86, r.rects[0][1]);
    }

    @Test
    void cellsUnderTheStartingPositionAreNotAnObstacle() {
        Env env = horizontalBar(true);
        env.occupied[2][8] = true; // under the element as the user drew it: the launcher moves it
        env.occupied[2][5] = true;
        Result r = resolve(env, pip("pipFirst", 100, 800, 400, 1240, 200, 100));
        assertEquals(600, r.rects[0][1]);
    }

    @Test
    void anOccupiedCellOutsideTheColumnsIsNotAnObstacle() {
        Env env = horizontalBar(true);
        env.occupied[7][5] = true;
        Result r = resolve(env, pip("pipFirst", 100, 700, 400, 1040, 200, 100));
        assertEquals(655, r.rects[0][1]);
    }

    // ------------------------------------------------------------ chains

    @Test
    void theElementAboveIsPushedUpToo() {
        Result r = resolve(horizontalBar(true),
                widget("date", 100, 400, 400, 690, 200, 100),
                widget("music", 100, 700, 400, 1040, 200, 200));
        assertArrayEquals(new int[] {100, 360, 400, 650}, r.rects[0]);
        assertArrayEquals(new int[] {100, 655, 400, 995}, r.rects[1]);
    }

    @Test
    void whenTheOneAboveHasNoRoomLeftTheLowerOneIsCut() {
        Result r = resolve(horizontalBar(true),
                widget("date", 100, 5, 400, 600, 200, 100),
                widget("music", 100, 640, 400, 1040, 200, 200));
        assertArrayEquals(new int[] {100, 5, 400, 600}, r.rects[0]);
        assertArrayEquals(new int[] {100, 605, 400, 995}, r.rects[1]);
    }

    @Test
    void atItsMinimumTheLowerOneMakesTheOneAboveGiveWay() {
        Result r = resolve(horizontalBar(true),
                widget("date", 100, 5, 400, 780, 200, 100),
                widget("music", 100, 790, 400, 1100, 200, 250));
        assertFalse(r.reset[0] || r.reset[1]);
        assertArrayEquals(new int[] {100, 745, 400, 995}, r.rects[1]); // at its minimum height
        assertArrayEquals(new int[] {100, 5, 400, 740}, r.rects[0]);   // cut, top stays
    }

    @Test
    void anElementThatCannotFitEvenThenIsResetAndTheOneAboveIsLeftAlone() {
        Result r = resolve(horizontalBar(true),
                widget("date", 100, 5, 400, 600, 200, 100),
                widget("music", 100, 640, 400, 1640, 200, 900));
        assertFalse(r.reset[0]);
        assertTrue(r.reset[1]);
        assertArrayEquals(new int[] {100, 5, 400, 600}, r.rects[0]);
    }

    @Test
    void ofSeveralThatCannotFitTheLowestIsResetFirstAndTheRestIsRecalculated() {
        Result r = resolve(horizontalBar(true),
                pip("pipFirst", 100, 100, 400, 1300, 200, 1000),   // cannot fit
                widget("music", 600, 700, 900, 1050, 200, 400));    // can, once it is alone
        assertTrue(r.reset[0]);
        assertFalse(r.reset[1]);
        assertArrayEquals(new int[] {600, 645, 900, 995}, r.rects[1]);
    }

    // ------------------------------------------------------------ vertical bar

    private static Env verticalBar(boolean withGrid, int offset) {
        Env env = new Env();
        env.margin = 5;
        env.maxRight = 1200;
        env.rightTrigger = 1200;
        env.verticalBarOffset = offset;
        if (withGrid) {
            env.grid = new GridGeometry(0, 0, 100, 100, 20, 10);
            env.occupied = new boolean[20][10];
        }
        return env;
    }

    @Test
    void thePushOfTheVerticalBarMovesTheElementLeftInTheBox() {
        Result r = resolve(verticalBar(true, 142), widget("radio", 800, 100, 1300, 300, 300, 100));
        assertArrayEquals(new int[] {700, 100, 1200, 300}, r.rects[0]);
    }

    @Test
    void anIconOnTheLeftStopsTheMoveAtTheColumnBoundaryOfTheScreen() {
        Env env = verticalBar(true, 142);
        env.occupied[5][1] = true;
        Result r = resolve(env, widget("radio", 800, 100, 1900, 300, 300, 100));
        // the column after the icon starts at x=600 on the screen, 142 less in the box
        assertEquals(600 - 142, r.rects[0][0]);
        assertEquals(1200, r.rects[0][2]);
    }

    @Test
    void bothBarsAreAppliedHorizontalFirst() {
        Env env = horizontalBar(true);
        env.maxRight = 1200;
        env.rightTrigger = 1200;
        Result r = resolve(env, pip("pipDual", 800, 700, 1300, 1040, 300, 200));
        assertArrayEquals(new int[] {700, 655, 1200, 995}, r.rects[0]);
    }

    // ------------------------------------------------------------ overlaps, resets

    // The minimum of these widgets is their whole rectangle, so no part beside the PiP is big enough.
    @Test
    void aWidgetOverlappingAPipIsResetWhenItCannotBeCut() {
        Result r = resolve(new Env(),
                pip("pipFirst", 100, 100, 500, 400, 200, 200),
                widget("date", 400, 300, 800, 500, 400, 200));
        assertFalse(r.reset[0]);
        assertTrue(r.reset[1]);
        assertFalse(r.cut[1]);
    }

    @Test
    void ofTwoWidgetsTheLaterOneIsResetWhenItCannotBeCut() {
        Result r = resolve(new Env(),
                widget("date", 100, 100, 500, 400, 400, 300),
                widget("music", 400, 300, 800, 500, 400, 200));
        assertFalse(r.reset[0]);
        assertTrue(r.reset[1]);
    }

    @Test
    void onlyOneOfTwoOverlappingElementsIsResetWhenItCannotBeCut() {
        Result r = resolve(new Env(),
                pip("pipFirst", 100, 100, 500, 400, 200, 200),
                pip("pipSecond", 400, 300, 800, 500, 400, 200),
                widget("date", 450, 320, 700, 450, 250, 130));
        int resets = 0;
        for (boolean b : r.reset) if (b) resets++;
        assertEquals(2, resets); // pipSecond (later PiP) and the widget; pipFirst stays
        assertFalse(r.reset[0]);
    }

    @Test
    void aWidgetOverlappingAPipIsCutBesideIt() {
        Result r = resolve(new Env(),
                pip("pipFirst", 100, 100, 500, 400, 200, 200),
                widget("date", 400, 300, 800, 500, 200, 100));
        assertFalse(r.reset[0]);
        assertFalse(r.reset[1]);
        assertTrue(r.cut[1]);
        assertFalse(r.cut[0]);
        assertEquals(0, r.conflictWith[1]);
        // the biggest part is the one right of the PiP, a gap of 5 away from it
        assertArrayEquals(new int[] {505, 300, 800, 500}, r.rects[1]);
        assertArrayEquals(new int[] {100, 100, 500, 400}, r.rects[0]);
    }

    @Test
    void theCutKeepsTheGapToEveryKeptElement() {
        int[][] kept = {{100, 100, 300, 300}, {600, 100, 800, 300}};
        Result r = resolve(new Env(),
                pip("pipFirst", kept[0][0], kept[0][1], kept[0][2], kept[0][3], 100, 100),
                pip("pipSecond", kept[1][0], kept[1][1], kept[1][2], kept[1][3], 100, 100),
                widget("music", 250, 50, 650, 350, 100, 100));
        assertTrue(r.cut[2]);
        assertArrayEquals(new int[] {305, 50, 595, 350}, r.rects[2]);
        for (int[] k : kept) {
            boolean apart = r.rects[2][2] + 5 <= k[0] || k[2] + 5 <= r.rects[2][0]
                    || r.rects[2][3] + 5 <= k[1] || k[3] + 5 <= r.rects[2][1];
            assertTrue(apart, Arrays.toString(r.rects[2]) + " too close to " + Arrays.toString(k));
        }
    }

    @Test
    void theCutKeepsTheLargestFreePart() {
        // below the PiP is 850 x 295, right of it 495 x 400
        Result r = resolve(new Env(),
                pip("pipFirst", 100, 100, 400, 300, 100, 100),
                widget("music", 50, 200, 900, 600, 100, 100));
        assertArrayEquals(new int[] {50, 305, 900, 600}, r.rects[1]);
    }

    @Test
    void aCutNeverGoesBelowTheMinimum() {
        // the biggest free part is 295 wide, the widget needs 300
        Result r = resolve(new Env(),
                pip("pipFirst", 100, 100, 500, 400, 200, 200),
                widget("date", 400, 300, 800, 500, 300, 200));
        assertTrue(r.reset[1]);
        assertFalse(r.cut[1]);
    }

    @Test
    void theSameInputGivesTheSameCut() {
        Element[] user = {
                pip("pipFirst", 100, 100, 500, 400, 200, 200),
                widget("date", 400, 300, 800, 500, 200, 100)};
        Result a = resolve(new Env(), user);
        Result b = resolve(new Env(), user);
        assertTrue(Arrays.deepEquals(a.rects, b.rects));
        assertArrayEquals(a.cut, b.cut);
        assertArrayEquals(a.reset, b.reset);
    }

    @Test
    void anElementThatWasNeverSetIsReset() {
        Result r = resolve(new Env(), empty("date"), widget("music", 100, 100, 400, 400, 200, 100));
        assertTrue(r.reset[0]);
        assertFalse(r.reset[1]);
    }

    // ------------------------------------------------------------ reversibility

    @Test
    void theLayoutGoesBackToTheUserRectanglesWhenTheBarShrinks() {
        Element[] user = {
                widget("date", 100, 400, 400, 690, 200, 100),
                widget("music", 100, 700, 400, 1040, 200, 200)};
        Result tall = resolve(horizontalBar(true), user);
        assertFalse(Arrays.equals(new int[] {100, 700, 400, 1040}, tall.rects[1]));

        Env low = new Env();
        low.margin = 5;
        low.maxBottom = PipEdgeTrim.maxBottom(1300, 5);
        low.bottomTrigger = 1299;
        low.grid = horizontalBar(true).grid;
        low.occupied = new boolean[20][10];
        Result small = resolve(low, user);
        assertArrayEquals(new int[] {100, 400, 400, 690}, small.rects[0]);
        assertArrayEquals(new int[] {100, 700, 400, 1040}, small.rects[1]);

        Result none = resolve(new Env(), user);
        assertArrayEquals(new int[] {100, 700, 400, 1040}, none.rects[1]);
    }

    @Test
    void theSameInputGivesTheSameLayout() {
        Element[] user = {
                widget("date", 100, 5, 400, 780, 200, 100),
                widget("music", 100, 790, 400, 1100, 200, 250),
                pip("pipFirst", 600, 700, 1000, 1100, 200, 200)};
        Result a = resolve(horizontalBar(true), user);
        Result b = resolve(horizontalBar(true), user);
        assertTrue(Arrays.deepEquals(a.rects, b.rects));
        assertArrayEquals(a.reset, b.reset);
    }

    @Test
    void withAZeroMarginElementsNeverTouch() {
        Env env = horizontalBar(true);
        env.margin = 0;
        env.maxBottom = PipEdgeTrim.maxBottom(1000, 0); // 999
        Result r = resolve(env,
                widget("date", 100, 400, 400, 690, 200, 100),
                widget("music", 100, 700, 400, 1040, 200, 200));
        assertTrue(r.rects[0][3] < r.rects[1][1], Arrays.toString(r.rects[0]) + " " + Arrays.toString(r.rects[1]));
        assertEquals(999, r.rects[1][3]);
    }

    @Test
    void nothingChangesWithoutABar() {
        List<Element> user = new ArrayList<>();
        user.add(widget("date", 100, 400, 400, 690, 200, 100));
        Result r = CustomLayoutResolver.resolve(user, new Env());
        assertArrayEquals(new int[] {100, 400, 400, 690}, r.rects[0]);
    }

    // ------------------------------------------------------------ the horizontal bar at the top

    private static Env topBar() {
        Env env = new Env();
        env.margin = 5;
        env.minTop = 100 + 5;           // a bar of 100 px at the top
        env.minTopBottomLimit = 1000 - 5;
        return env;
    }

    @Test
    void anElementUnderTheTopBarIsMovedDownAndKeepsItsSize() {
        Result r = resolve(topBar(), widget("date", 100, 20, 400, 220, 100, 100));
        assertFalse(r.reset[0]);
        assertArrayEquals(new int[] {100, 105, 400, 305}, r.rects[0]);
    }

    @Test
    void anElementBelowTheTopBarIsLeftAlone() {
        Result r = resolve(topBar(), widget("date", 100, 300, 400, 500, 100, 100));
        assertArrayEquals(new int[] {100, 300, 400, 500}, r.rects[0]);
    }

    @Test
    void movedDownTooFarItIsCutAtTheBottomThenResetWhenItCannotBe() {
        Result cut = resolve(topBar(), widget("date", 100, 20, 400, 1000, 100, 100));
        assertFalse(cut.reset[0]);
        assertEquals(105, cut.rects[0][1]);
        assertEquals(995, cut.rects[0][3]);
        Result reset = resolve(topBar(), widget("radio", 100, 20, 400, 980, 100, 900));
        assertTrue(reset.reset[0]);
    }

    // ------------------------------------------------------------ step 1: overlapping user rectangles (R3)

    private static Env room(int margin, int left, int top, int right, int bottom) {
        Env env = new Env();
        env.margin = margin;
        env.bounds = new CustomLayoutResolver.Bounds(left, top, right, bottom);
        return env;
    }

    @Test
    void rectanglesThatOnlyTouchStayAsDrawnAtMarginZeroAndFive() {
        for (int margin : new int[] {0, 5}) {
            Env env = room(margin, 5, 5, 1995, 995);
            Result r = resolve(env,
                    pip("pipFirst", 100, 100, 348, 300, 100, 100),
                    widget("music", 348, 100, 600, 300, 100, 100),
                    widget("date", 100, 300, 348, 400, 100, 50));   // below the PiP, sharing its edge
            for (int i = 0; i < 3; i++) {
                assertFalse(r.reset[i]);
                assertFalse(r.cut[i]);
                assertFalse(r.moved[i]);
            }
            assertArrayEquals(new int[] {100, 100, 348, 300}, r.rects[0]);
            assertArrayEquals(new int[] {348, 100, 600, 300}, r.rects[1]);
            assertArrayEquals(new int[] {100, 300, 348, 400}, r.rects[2]);
        }
    }

    @Test
    void aWidgetOnAWidgetIsMovedByTheShortestWayInItsOwnSize() {
        Env env = room(5, 5, 5, 1995, 995);
        Result r = resolve(env,
                widget("date", 100, 100, 500, 300, 200, 100),
                widget("music", 400, 150, 800, 350, 200, 100));
        assertFalse(r.reset[1]);
        assertFalse(r.cut[1]);
        assertTrue(r.moved[1]);
        // to the right of the first one (dx = 105) is nearer than below it (dy = 155)
        assertArrayEquals(new int[] {505, 150, 905, 350}, r.rects[1]);
        assertArrayEquals(new int[] {100, 100, 500, 300}, r.rects[0]);
    }

    @Test
    void aPipWinsAgainstAWidgetWhateverTheOrder() {
        Env env = room(5, 5, 5, 1995, 995);
        Result r = resolve(env,
                widget("music", 100, 100, 500, 300, 200, 100),
                pip("pipFirst", 300, 100, 700, 300, 200, 100));
        assertArrayEquals(new int[] {300, 100, 700, 300}, r.rects[1]);
        assertFalse(r.moved[1]);
        assertTrue(r.moved[0]);
        assertEquals(400, r.rects[0][2] - r.rects[0][0]);
        assertEquals(200, r.rects[0][3] - r.rects[0][1]);
    }

    @Test
    void withNowhereToGoItIsCutToTheRoomBesideTheOther() {
        Env env = room(5, 5, 5, 800, 320);
        Result r = resolve(env,
                widget("date", 100, 100, 500, 300, 200, 100),
                widget("music", 400, 120, 800, 320, 200, 100));
        assertFalse(r.reset[1]);
        assertFalse(r.moved[1]);
        assertTrue(r.cut[1]);
        assertArrayEquals(new int[] {505, 120, 800, 320}, r.rects[1]);
    }

    @Test
    void whenItCannotBeCutItIsReset() {
        Env env = room(5, 5, 5, 800, 320);
        Result r = resolve(env,
                widget("date", 100, 100, 500, 300, 400, 200),
                widget("music", 400, 120, 800, 320, 400, 200));
        assertTrue(r.reset[1]);
        assertFalse(r.cut[1]);
        assertFalse(r.moved[1]);
    }

    @Test
    void aMovedElementStaysInTheRoomAndOutOfTheCellsOfTheDatabase() {
        Env env = room(5, 5, 5, 1995, 995);
        env.grid = new GridGeometry(0, 0, 100, 100, 20, 10);
        env.occupied = new boolean[20][10];
        // an icon in column 5, rows 1..3: the move to the right of the first widget (x = 505) would enter it
        for (int row = 1; row <= 3; row++) {
            env.occupied[5][row] = true;
        }
        Result r = resolve(env,
                widget("date", 100, 100, 500, 300, 200, 100),
                widget("music", 400, 150, 800, 350, 200, 100));
        assertTrue(r.moved[1]);
        int[] moved = r.rects[1];
        assertEquals(400, moved[2] - moved[0]);
        assertEquals(200, moved[3] - moved[1]);
        assertTrue(moved[0] >= 5 && moved[1] >= 5 && moved[2] <= 1995 && moved[3] <= 995);
        int[] cells = env.grid.cellsOf(moved[0], moved[1], moved[2], moved[3], 0);
        for (int c = cells[0]; c <= cells[2]; c++) {
            for (int row = cells[1]; row <= cells[3]; row++) {
                assertFalse(env.occupied[c][row], "cell " + c + "," + row);
            }
        }
        // and the gap to the first one is kept
        assertTrue(moved[0] >= 505 || moved[1] >= 305);
    }

    @Test
    void theSameInputGivesTheSameResult() {
        Env env = room(5, 5, 5, 1995, 995);
        Result a = resolve(env,
                widget("date", 100, 100, 500, 300, 200, 100),
                widget("music", 400, 150, 800, 350, 200, 100),
                pip("pipFirst", 450, 200, 900, 400, 200, 100));
        Result b = resolve(env,
                widget("date", 100, 100, 500, 300, 200, 100),
                widget("music", 400, 150, 800, 350, 200, 100),
                pip("pipFirst", 450, 200, 900, 400, 200, 100));
        assertTrue(Arrays.deepEquals(a.rects, b.rects));
        assertArrayEquals(a.moved, b.moved);
        assertArrayEquals(a.cut, b.cut);
        assertArrayEquals(a.reset, b.reset);
    }
}
