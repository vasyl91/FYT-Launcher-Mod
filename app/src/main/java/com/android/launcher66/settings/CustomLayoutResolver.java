package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Works out the layout actually used for the PiPs and widgets of one screen, from the rectangles
 * the user drew and the bars. The order in which the bars are given way to:
 * <ol>
 *   <li>the element is <b>moved</b> into free space (up for the bottom bar, left for the left
 *       bar), where free means no other element and no icon, folder or widget of the launcher
 *       database in the cells it would enter;</li>
 *   <li>what is still covered is <b>cut</b> (the edge at the bar), never below the minimum size;</li>
 *   <li>an element in the way is moved and cut in the same way, so it makes room - the bar's push
 *       travels through a chain of elements;</li>
 *   <li>only an element that cannot fit even then is <b>reset</b> - the caller puts it into free
 *       space.</li>
 * </ol>
 * The result is always computed from the user rectangles, never from an earlier result, so it
 * goes back to them when the bar shrinks or the left bar disappears, and the same input always
 * gives the same output.
 *
 * <p>Pure Java (no Android imports) so it is unit-tested on the JVM. Coordinates are the ones the
 * creator saves: the box the widgets live in, without the left bar and the status bar.
 */
public final class CustomLayoutResolver {

    /** No bar on this axis. */
    public static final int NO_LIMIT = Integer.MAX_VALUE;

    private static final int LEFT = 0;
    private static final int TOP = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = 3;

    private CustomLayoutResolver() {
    }

    /** One PiP, widget or stats window. {@code left..bottom} is the user rectangle. */
    public static final class Element {
        public final String key;
        public final int left;
        public final int top;
        public final int right;
        public final int bottom;
        public final int minWidth;
        public final int minHeight;
        /** PiP: a reset restarts its app, so it wins against a widget. */
        public final boolean pip;
        /** Stats window: never moved or cut, but nobody can move onto it. */
        public final boolean fixed;
        /** Never set (fresh start): always reset. */
        public final boolean empty;

        public Element(String key, int left, int top, int right, int bottom, int minWidth, int minHeight,
                       boolean pip, boolean fixed, boolean empty) {
            this.key = key;
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
            this.minWidth = minWidth;
            this.minHeight = minHeight;
            this.pip = pip;
            this.fixed = fixed;
            this.empty = empty;
        }
    }

    /** What the screen offers. */
    public static final class Env {
        /** Layout margin; elements keep at least {@code max(margin, 1)} between them. */
        public int margin = 5;
        /**
         * Left bar: the right edge may not pass {@code maxRight}. An element is affected when its
         * right edge is beyond {@code rightTrigger}.
         */
        public int maxRight = NO_LIMIT;
        public int rightTrigger = NO_LIMIT;
        /** Bottom bar, the same for the bottom edge. */
        public int maxBottom = NO_LIMIT;
        public int bottomTrigger = NO_LIMIT;
        /** The cell grid and the occupied cells ([column][row]) of this screen; null: do not move. */
        public GridGeometry grid;
        public boolean[][] occupied;
        /** Width CellLayout adds to x on this screen (left bar on page 0). */
        public int leftBarOffset;

        int gap() {
            return Math.max(margin, 1);
        }

        boolean canMove() {
            return grid != null && occupied != null && grid.isUsable();
        }
    }

    public static final class Result {
        /** {left, top, right, bottom} per element, in the order given. Meaningless where reset. */
        public final int[][] rects;
        public final boolean[] reset;

        Result(int[][] rects, boolean[] reset) {
            this.rects = rects;
            this.reset = reset;
        }
    }

    /**
     * @param elements in the order of Helpers.RECTANGLE_KEYS (ties are decided by it)
     */
    public static Result resolve(List<Element> elements, Env env) {
        int n = elements.size();
        int[][] r = new int[n][];
        boolean[] reset = new boolean[n];
        for (int i = 0; i < n; i++) {
            Element e = elements.get(i);
            r[i] = new int[] {e.left, e.top, e.right, e.bottom};
            reset[i] = e.empty;
        }

        resetOverlapping(elements, r, reset);
        resolveAxis(elements, r, reset, env, false);
        resolveAxis(elements, r, reset, env, true);
        return new Result(r, reset);
    }

    // ---------------------------------------------------------------- step 1: user rectangles

    /** Two user rectangles that overlap or touch: one of them is reset, not both. */
    private static void resetOverlapping(List<Element> els, int[][] r, boolean[] reset) {
        for (int i = 0; i < els.size(); i++) {
            if (reset[i] || els.get(i).fixed) continue;
            for (int j = i + 1; j < els.size(); j++) {
                if (reset[j] || els.get(j).fixed) continue;
                if (!overlapsOrTouches(r[i], r[j])) continue;
                // A widget gives way to a PiP (resetting a PiP restarts its app); equals: the later one.
                int loser = els.get(i).pip && !els.get(j).pip ? j
                        : !els.get(i).pip && els.get(j).pip ? i : j;
                reset[loser] = true;
                if (loser == i) break;
            }
        }
    }

    static boolean overlapsOrTouches(int[] a, int[] b) {
        return !(a[RIGHT] < b[LEFT] || b[RIGHT] < a[LEFT] || a[BOTTOM] < b[TOP] || b[BOTTOM] < a[TOP]);
    }

    // ---------------------------------------------------------------- step 2: one axis

    /**
     * Moves, cuts and where needed resets along one axis. The vertical case: the bottom bar pushes
     * up. The horizontal one is the same with x for y: the left bar pushes to the left in the
     * coordinates of the box (on the screen the element stays to the right of the bar).
     */
    private static void resolveAxis(List<Element> els, int[][] r, boolean[] reset, Env env, boolean vertical) {
        final int lo = vertical ? TOP : LEFT;
        final int hi = vertical ? BOTTOM : RIGHT;
        final int limit = vertical ? env.maxBottom : env.maxRight;
        final int trigger = vertical ? env.bottomTrigger : env.rightTrigger;
        if (limit == NO_LIMIT) return;

        final int n = els.size();
        final int gap = env.gap();
        final boolean canMove = env.canMove();

        // Feasibility: reset the element the bar pushes out, one at a time, until the rest fits.
        int[][] s;
        int[] keep;
        int[] min;
        while (true) {
            s = copy(r);
            keep = new int[n];
            min = new int[n];
            computeReach(els, s, reset, env, vertical, canMove, keep, min);
            int worst = -1;
            for (int i = 0; i < n; i++) {
                if (reset[i] || els.get(i).fixed || s[i][hi] <= trigger) continue;
                if (min[i] + minLength(els.get(i), s[i], vertical) <= limit) continue;
                if (worst < 0 || s[i][hi] >= s[worst][hi]) {
                    worst = i;
                }
            }
            if (worst < 0) break;
            reset[worst] = true;
        }

        // From the bar upwards: move, then cut, then the elements in the way do the same.
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        final int[][] start = s;
        java.util.Arrays.sort(order, (a, b) -> start[a][hi] != start[b][hi]
                ? Integer.compare(start[b][hi], start[a][hi]) : Integer.compare(b, a));

        int[] newLo = new int[n];
        int[] newHi = new int[n];
        for (int i = 0; i < n; i++) {
            newLo[i] = s[i][lo];
            newHi[i] = s[i][hi];
        }
        for (int e : order) {
            Element el = els.get(e);
            if (reset[e] || el.fixed) continue;

            int allowed = s[e][hi] > trigger ? limit : NO_LIMIT;
            for (int a = 0; a < n; a++) {
                if (reset[a] || !above(s, e, a, vertical)) continue;
                allowed = Math.min(allowed, newLo[a] - spacing(s, e, a, vertical, gap));
            }
            if (s[e][hi] <= allowed) continue;

            int length = s[e][hi] - s[e][lo];
            int minLen = minLength(el, s[e], vertical);
            int over = s[e][hi] - allowed;
            // 1. move as far as the room above allows
            int to = canMove ? Math.max(s[e][lo] - over, keep[e]) : s[e][lo];
            int end = to + length;
            // 2. cut what still reaches past, never below the minimum
            if (end > allowed) {
                end = to + Math.max(minLen, allowed - to);
            }
            // 3. at the minimum and still too low: move further, the ones above make room
            if (end > allowed) {
                to = allowed - minLen;
                end = allowed;
            }
            newLo[e] = to;
            newHi[e] = end;
        }
        for (int i = 0; i < n; i++) {
            if (reset[i] || els.get(i).fixed) continue;
            r[i][lo] = newLo[i];
            r[i][hi] = newHi[i];
        }
    }

    /**
     * For every element the highest position it can reach when the elements above it only get out
     * of the way ({@code keep}: they keep their size) and when they are cut to their minimum
     * ({@code min}). Elements are taken from the top, so the ones above are done first.
     */
    private static void computeReach(List<Element> els, int[][] s, boolean[] reset, Env env,
                                     boolean vertical, boolean canMove, int[] keep, int[] min) {
        final int lo = vertical ? TOP : LEFT;
        final int hi = vertical ? BOTTOM : RIGHT;
        final int n = els.size();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        java.util.Arrays.sort(order, (a, b) -> s[a][lo] != s[b][lo]
                ? Integer.compare(s[a][lo], s[b][lo]) : Integer.compare(a, b));

        for (int e : order) {
            if (reset[e]) continue;
            Element el = els.get(e);
            if (el.fixed || !canMove) {
                keep[e] = s[e][lo];
                min[e] = s[e][lo];
                continue;
            }
            int floor = Math.min(env.margin, s[e][lo]);
            int base = Math.max(floor, ceilingFromGrid(s[e], env, vertical));
            int k = base;
            int m = base;
            for (int b = 0; b < n; b++) {
                if (reset[b] || !above(s, b, e, vertical)) continue;
                int sp = spacing(s, b, e, vertical, env.gap());
                k = Math.max(k, keep[b] + (s[b][hi] - s[b][lo]) + sp);
                m = Math.max(m, min[b] + minLength(els.get(b), s[b], vertical) + sp);
            }
            keep[e] = Math.min(k, s[e][lo]);
            min[e] = Math.min(m, s[e][lo]);
        }
    }

    /**
     * Highest lo edge at which the element does not enter a cell of the database items above (or
     * to the left of) the cells it covers now. The cells it covers now are not an obstacle: the
     * launcher moves what is there for a custom element anyway.
     */
    private static int ceilingFromGrid(int[] rect, Env env, boolean vertical) {
        GridGeometry g = env.grid;
        boolean[][] occ = env.occupied;
        int off = env.leftBarOffset;
        if (vertical) {
            int c0 = g.colOf(rect[LEFT] + off);
            int c1 = g.colOf(rect[RIGHT] - 1 + off);
            for (int row = g.rowOf(rect[TOP]) - 1; row >= 0; row--) {
                for (int c = c0; c <= c1; c++) {
                    if (occ[c][row]) return g.rowStart(row + 1);
                }
            }
        } else {
            int r0 = g.rowOf(rect[TOP]);
            int r1 = g.rowOf(rect[BOTTOM] - 1);
            for (int col = g.colOf(rect[LEFT] + off) - 1; col >= 0; col--) {
                for (int row = r0; row <= r1; row++) {
                    if (occ[col][row]) return g.colStart(col + 1) - off;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    /** {@code b} is in the way of a move of {@code a} along the axis: it lies before it and shares its band. */
    private static boolean above(int[][] s, int b, int a, boolean vertical) {
        if (a == b) return false;
        int lo = vertical ? TOP : LEFT;
        int hi = vertical ? BOTTOM : RIGHT;
        int olo = vertical ? LEFT : TOP;
        int ohi = vertical ? RIGHT : BOTTOM;
        return s[b][olo] < s[a][ohi] && s[a][olo] < s[b][ohi] && s[b][hi] <= s[a][lo];
    }

    /** The space kept between two elements; never more than they had to start with. */
    private static int spacing(int[][] s, int b, int a, boolean vertical, int gap) {
        int lo = vertical ? TOP : LEFT;
        int hi = vertical ? BOTTOM : RIGHT;
        return Math.min(gap, s[a][lo] - s[b][hi]);
    }

    /** Minimum length along the axis; an element drawn smaller than its minimum keeps its size. */
    private static int minLength(Element el, int[] rect, boolean vertical) {
        if (el.fixed) {
            return vertical ? rect[BOTTOM] - rect[TOP] : rect[RIGHT] - rect[LEFT];
        }
        return vertical ? Math.min(el.minHeight, rect[BOTTOM] - rect[TOP])
                : Math.min(el.minWidth, rect[RIGHT] - rect[LEFT]);
    }

    private static int[][] copy(int[][] r) {
        int[][] c = new int[r.length][];
        for (int i = 0; i < r.length; i++) c[i] = r[i].clone();
        return c;
    }

    // ---------------------------------------------------------------- reset into free space

    /** The room an element may be put into on its screen. */
    public static final class Bounds {
        public final int minLeft;
        public final int minTop;
        public final int maxRight;
        public final int maxBottom;

        public Bounds(int minLeft, int minTop, int maxRight, int maxBottom) {
            this.minLeft = minLeft;
            this.minTop = minTop;
            this.maxRight = maxRight;
            this.maxBottom = maxBottom;
        }
    }

    /**
     * Where a reset element goes: the first free place, not the fixed default one. Free means
     * inside the bounds, at least {@code gap} from the {@code obstacles} (the elements that stay,
     * the ones reset before and the stats window) and in no cell of the launcher database.
     *
     * <p>The size it had is tried first, then the size of a reset. For each size the old default
     * position comes first, then the corners that touch the margins or the obstacles (and the
     * lines of the cell grid, where an empty part of a page starts), top to bottom, left to right.
     * When the occupied cells are not known nothing can be verified, and the default is kept as
     * before; when nothing is free it is the default too, in the size of a reset - the launcher
     * then moves the standard items away from it.
     *
     * @param currentSize {width, height} of the element before, or null (never set)
     * @param resetSize   {width, height} of a reset
     * @param defaultPos  {x, y} the fixed default
     * @param obstacles   {left, top, right, bottom} each
     * @return {x, y, width, height}
     */
    public static int[] placeReset(int[] currentSize, int[] resetSize, int[] defaultPos,
                                   List<int[]> obstacles, Env env, Bounds bounds) {
        int[] fallback = {defaultPos[0], defaultPos[1], resetSize[0], resetSize[1]};
        if (!env.canMove()) return fallback;

        List<int[]> sizes = new ArrayList<>();
        if (currentSize != null) {
            // Drawn bigger than the room: as big as the room is, but never under the minimum of a reset
            sizes.add(new int[] {
                    Math.max(resetSize[0], Math.min(currentSize[0], bounds.maxRight - bounds.minLeft)),
                    Math.max(resetSize[1], Math.min(currentSize[1], bounds.maxBottom - bounds.minTop))});
        }
        sizes.add(resetSize);

        for (int[] size : sizes) {
            if (fits(defaultPos[0], defaultPos[1], size, obstacles, env, bounds)) {
                return new int[] {defaultPos[0], defaultPos[1], size[0], size[1]};
            }
            for (int[] at : candidates(obstacles, env, bounds)) {
                if (fits(at[0], at[1], size, obstacles, env, bounds)) {
                    return new int[] {at[0], at[1], size[0], size[1]};
                }
            }
        }
        return fallback;
    }

    private static boolean fits(int x, int y, int[] size, List<int[]> obstacles, Env env, Bounds b) {
        int right = x + size[0];
        int bottom = y + size[1];
        if (x < b.minLeft || y < b.minTop || right > b.maxRight || bottom > b.maxBottom) return false;
        int gap = env.gap();
        for (int[] o : obstacles) {
            boolean apart = right + gap <= o[LEFT] || o[RIGHT] + gap <= x
                    || bottom + gap <= o[TOP] || o[BOTTOM] + gap <= y;
            if (!apart) return false;
        }
        int[] cells = env.grid.cellsOf(x, y, right, bottom, env.leftBarOffset);
        for (int c = cells[0]; c <= cells[2]; c++) {
            for (int rw = cells[1]; rw <= cells[3]; rw++) {
                if (env.occupied[c][rw]) return false;
            }
        }
        return true;
    }

    private static List<int[]> candidates(List<int[]> obstacles, Env env, Bounds b) {
        java.util.TreeSet<Integer> xs = new java.util.TreeSet<>();
        java.util.TreeSet<Integer> ys = new java.util.TreeSet<>();
        int gap = env.gap();
        xs.add(b.minLeft);
        ys.add(b.minTop);
        for (int[] o : obstacles) {
            xs.add(o[RIGHT] + gap);
            ys.add(o[BOTTOM] + gap);
        }
        for (int c = 0; c < env.grid.countX; c++) {
            xs.add(env.grid.colStart(c) - env.leftBarOffset);
        }
        for (int rw = 0; rw < env.grid.countY; rw++) {
            ys.add(env.grid.rowStart(rw));
        }
        List<int[]> list = new ArrayList<>();
        for (int y : ys) {           // top to bottom
            for (int x : xs) {       // left to right
                list.add(new int[] {x, y});
            }
        }
        return list;
    }

    /** Indexes of the elements that were not reset, in order. */
    public static List<Integer> kept(Result result) {
        List<Integer> kept = new ArrayList<>();
        for (int i = 0; i < result.reset.length; i++) {
            if (!result.reset[i]) kept.add(i);
        }
        return kept;
    }
}
