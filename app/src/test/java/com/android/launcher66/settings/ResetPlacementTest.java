package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.android.launcher66.settings.CustomLayoutResolver.Bounds;
import com.android.launcher66.settings.CustomLayoutResolver.Env;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ResetPlacementTest {

    // 2000 x 1000 box, margin 5, cells of 200 x 200 without a gap, 10 columns x 5 rows
    private final Bounds bounds = new Bounds(5, 5, 1995, 995);

    private Env env(boolean known) {
        Env env = new Env();
        env.margin = 5;
        if (known) {
            env.grid = new GridGeometry(0, 0, 200, 200, 10, 5);
            env.occupied = new boolean[10][5];
        }
        return env;
    }

    private static List<int[]> rects(int[]... r) {
        return new ArrayList<>(Arrays.asList(r));
    }

    @Test
    void theSizeItHadIsUsedWhenItFitsAtTheDefault() {
        int[] p = CustomLayoutResolver.placeReset(new int[] {600, 300}, new int[] {400, 200},
                new int[] {5, 5}, rects(), env(true), bounds);
        assertArrayEquals(new int[] {5, 5, 600, 300}, p);
    }

    @Test
    void theResetSizeIsUsedWhenTheOldOneFitsNowhere() {
        // a wall of obstacles leaves only a 400 x 200 slot at the top
        List<int[]> wall = rects(new int[] {5, 215, 1995, 995});
        int[] p = CustomLayoutResolver.placeReset(new int[] {600, 600}, new int[] {400, 200},
                new int[] {5, 5}, wall, env(true), bounds);
        assertArrayEquals(new int[] {5, 5, 400, 200}, p);
    }

    @Test
    void aFreeDefaultPositionIsKept() {
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {400, 200},
                new int[] {700, 300}, rects(new int[] {5, 5, 400, 200}), env(true), bounds);
        assertArrayEquals(new int[] {700, 300, 400, 200}, p);
    }

    @Test
    void anOccupiedDefaultMovesToTheFirstFreeCornerTopToBottomThenLeftToRight() {
        // the default is taken by an obstacle; the first free corner is right of it at the top
        int[] taken = {700, 300, 1100, 500};
        int[] other = {5, 5, 405, 205};
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {400, 200},
                new int[] {700, 300}, rects(taken, other), env(true), bounds);
        // y=5 is the first row and x=5 is taken by 'other'; the next corner is right of it (405 + gap)
        assertArrayEquals(new int[] {410, 5, 400, 200}, p);
    }

    @Test
    void theGapToTheObstaclesIsKept() {
        // the obstacle ends at 405: with a gap of 5 the next element may start at 410, not at 406
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {300, 200},
                new int[] {406, 5}, rects(new int[] {5, 5, 405, 205}), env(true), bounds);
        assertArrayEquals(new int[] {410, 5, 300, 200}, p);
    }

    @Test
    void occupiedCellsOfTheDatabaseAreAvoided() {
        Env env = env(true);
        env.occupied[0][0] = true; // an icon in the top left cell
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {150, 150},
                new int[] {5, 5}, rects(), env, bounds);
        // not (5,5): cell (0,0) is taken; the first free corner is on the grid line of column 1
        assertArrayEquals(new int[] {200, 5, 150, 150}, p);
    }

    @Test
    void theVerticalBarOffsetShiftsTheGridLines() {
        Env env = env(true);
        env.verticalBarOffset = 100;
        env.occupied[0][0] = true;
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {80, 80},
                new int[] {5, 5}, rects(), env, bounds);
        // x=5 is column 0 once the 100 px bar is added (105 / 200): taken; column 1 starts at 200 - 100
        assertArrayEquals(new int[] {100, 5, 80, 80}, p);
    }

    @Test
    void nothingFreeKeepsTheDefaultInTheResetSize() {
        List<int[]> all = rects(new int[] {5, 5, 1995, 995});
        int[] p = CustomLayoutResolver.placeReset(new int[] {600, 300}, new int[] {400, 200},
                new int[] {50, 60}, all, env(true), bounds);
        assertArrayEquals(new int[] {50, 60, 400, 200}, p);
    }

    @Test
    void withoutAKnownGridTheDefaultIsKept() {
        int[] p = CustomLayoutResolver.placeReset(new int[] {600, 300}, new int[] {400, 200},
                new int[] {50, 60}, rects(new int[] {0, 0, 2000, 1000}), env(false), bounds);
        assertArrayEquals(new int[] {50, 60, 400, 200}, p);
    }

    @Test
    void thePlaceStaysAboveTheBar() {
        Bounds bar = new Bounds(5, 5, 1995, 600);
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {400, 300},
                new int[] {5, 5}, rects(new int[] {5, 5, 405, 305}), env(true), bar);
        assertArrayEquals(new int[] {410, 5, 400, 300}, p);
    }

    @Test
    void withoutAKnownGridTheObstaclesAreStillAvoided() {
        int[] p = CustomLayoutResolver.placeReset(null, new int[] {300, 200},
                new int[] {5, 5}, rects(new int[] {5, 5, 405, 205}), env(false), bounds);
        assertArrayEquals(new int[] {410, 5, 300, 200}, p);
    }

    @Test
    void onAPageWithoutBarsTheResetGoesBesideThePip() {
        // The page of the log: date and radio on the left, the third PiP in the middle, and the music
        // widget (270 x 324), reset to a default position that lies on the PiP.
        int[] date = {5, 5, 405, 105};
        int[] radio = {5, 115, 605, 515};
        int[] third = {500, 5, 1500, 800};
        List<int[]> others = rects(date, radio, third);
        int[] p = CustomLayoutResolver.placeReset(new int[] {270, 324}, new int[] {270, 324},
                new int[] {600, 300}, others, env(true), bounds);
        int[] placed = {p[0], p[1], p[0] + p[2], p[1] + p[3]};
        assertArrayEquals(new int[] {270, 324}, new int[] {p[2], p[3]});
        for (int[] o : others) {
            boolean apart = placed[2] + 5 <= o[0] || o[2] + 5 <= placed[0]
                    || placed[3] + 5 <= o[1] || o[3] + 5 <= placed[1];
            org.junit.jupiter.api.Assertions.assertTrue(apart,
                    Arrays.toString(placed) + " overlaps " + Arrays.toString(o));
        }
    }
}
