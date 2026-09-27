package com.android.launcher66.settings;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;

import java.util.ArrayList;

/**
 * Touch handling shared by the layout creator canvases (DrawViewFirstScreen,
 * DrawViewOtherScreens and DrawViewAppStats).
 *
 * <p>On ACTION_DOWN it decides once what the finger grabbed: a whole rectangle (move) or one or
 * two of its edges (resize; two edges make a corner). The rules:
 * <ul>
 *   <li>Every edge of a resizable rectangle has a handle band on both sides of its line.</li>
 *   <li>The outer part is at most {@link #OUTER_BAND_DP}. A touch between rectangles belongs to
 *       the nearest one, so the gap between two neighbours is split in half and a band never
 *       reaches into a neighbour, however small the gap is.</li>
 *   <li>The inner part makes up what the outer part lacks to {@link #TOTAL_BAND_DP}, but takes at
 *       most {@link #INNER_MAX_FRACTION} of the rectangle's size across that edge. The middle 80%
 *       of a rectangle therefore always moves it, whatever its size.</li>
 *   <li>Near the ends of an edge (up to {@link #CORNER_REACH_DP}, at most a third of the edge) the
 *       band grabs the corner, i.e. both edges.</li>
 *   <li>Rectangles that cannot be resized by dragging have no handles: inside and within the
 *       outer band they are moved.</li>
 * </ul>
 * All sizes are physical: dp values are divided by the effective scale of the view, because
 * DrawViewFirstScreen scales itself down to fit the creator.
 *
 * <p>While dragging, the grabbed edge (or the moved rectangle) keeps the offset it had to the
 * finger on ACTION_DOWN, so nothing jumps under the finger. The grabbed edges are highlighted from
 * ACTION_DOWN until {@link #end()} is called on ACTION_UP / ACTION_CANCEL.
 */
public final class RectangleTouchHelper {

    public static final int EDGE_NONE = 0;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_TOP = 1 << 1;
    public static final int EDGE_RIGHT = 1 << 2;
    public static final int EDGE_BOTTOM = 1 << 3;

    private static final int LEFT_OR_RIGHT = EDGE_LEFT | EDGE_RIGHT;
    private static final int TOP_OR_BOTTOM = EDGE_TOP | EDGE_BOTTOM;

    /** Largest part of a handle band outside the rectangle. */
    private static final float OUTER_BAND_DP = 24f;
    /** What the outer and the inner part of a handle band add up to when there is room. */
    private static final float TOTAL_BAND_DP = 48f;
    /** Largest share of the rectangle's size one inner band may take (10% per side = 80% middle). */
    private static final float INNER_MAX_FRACTION = 0.10f;
    /** How far from a corner, along an edge, the band grabs the corner instead of the edge. */
    private static final float CORNER_REACH_DP = 40f;
    /** Upper limit of the corner reach as a share of the edge, so a short edge can be grabbed alone. */
    private static final float CORNER_MAX_EDGE_FRACTION = 1f / 3f;

    /** Yellow line with a black outline: visible on every rectangle colour, never read as the red overlap glare. */
    private static final float HIGHLIGHT_LINE_DP = 3f;
    private static final float HIGHLIGHT_OUTLINE_DP = 6f;
    private static final int HIGHLIGHT_LINE_COLOR = 0xFFFFEB3B;
    private static final int HIGHLIGHT_OUTLINE_COLOR = 0xFF000000;

    private static final class Target {
        String key;
        final RectF rect = new RectF();
        boolean resizable;
    }

    // Reused between touches, so ACTION_DOWN does not allocate once the list has grown.
    private final ArrayList<Target> targets = new ArrayList<>();
    private int targetCount = 0;

    private String activeKey = null;
    private int activeEdges = EDGE_NONE;
    private float grabOffsetX = 0f;
    private float grabOffsetY = 0f;

    private final Paint highlightLine = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint highlightOutline = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RectangleTouchHelper() {
        highlightLine.setStyle(Paint.Style.STROKE);
        highlightLine.setStrokeCap(Paint.Cap.SQUARE);
        highlightLine.setColor(HIGHLIGHT_LINE_COLOR);
        highlightOutline.setStyle(Paint.Style.STROKE);
        highlightOutline.setStrokeCap(Paint.Cap.SQUARE);
        highlightOutline.setColor(HIGHLIGHT_OUTLINE_COLOR);
    }

    // ---------------------------------------------------------------------------------------------
    // Rectangles that can be grabbed
    // ---------------------------------------------------------------------------------------------

    /** Forgets the rectangles given for the previous touch. */
    public void clearTargets() {
        targetCount = 0;
    }

    /**
     * Adds a rectangle that can be grabbed. Add them in drawing order, bottom-most first, so the
     * top-most one wins where rectangles overlap.
     */
    public void addTarget(String key, RectF rect, boolean resizable) {
        if (key == null || rect == null || rect.isEmpty()) return;
        Target target;
        if (targetCount < targets.size()) {
            target = targets.get(targetCount);
        } else {
            target = new Target();
            targets.add(target);
        }
        target.key = key;
        target.rect.set(rect);
        target.resizable = resizable;
        targetCount++;
    }

    // ---------------------------------------------------------------------------------------------
    // Gesture
    // ---------------------------------------------------------------------------------------------

    /**
     * Starts a gesture at (x, y), in the view's own coordinates.
     *
     * @return false if the touch is not on or near any rectangle.
     */
    public boolean begin(View view, float x, float y) {
        end();
        if (targetCount == 0) return false;

        final float dp = viewPxPerDp(view);

        // 1. On a rectangle: the top-most one owns the touch.
        for (int i = targetCount - 1; i >= 0; i--) {
            Target target = targets.get(i);
            if (!target.rect.contains(x, y)) continue;
            int edges = target.resizable
                    ? edgesInside(i, x, y, dp, view.getWidth(), view.getHeight())
                    : EDGE_NONE;
            start(target, edges, x, y);
            return true;
        }

        // 2. Next to rectangles: the nearest one, if the touch is within its outer band.
        Target nearest = null;
        float nearestDistance = Float.MAX_VALUE;
        for (int i = targetCount - 1; i >= 0; i--) {
            Target target = targets.get(i);
            float distance = distanceToRect(target.rect, x, y);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearest = target;
            }
        }
        if (nearest == null || nearestDistance > OUTER_BAND_DP * dp) return false;

        int edges = nearest.resizable ? edgesOutside(nearest.rect, x, y, dp) : EDGE_NONE;
        start(nearest, edges, x, y);
        return true;
    }

    /** Ends the gesture; also turns the edge highlight off. */
    public void end() {
        activeKey = null;
        activeEdges = EDGE_NONE;
        grabOffsetX = 0f;
        grabOffsetY = 0f;
    }

    public boolean isActive() {
        return activeKey != null;
    }

    /** True while one or two edges are being dragged, false while a whole rectangle is moved. */
    public boolean isResizing() {
        return activeKey != null && activeEdges != EDGE_NONE;
    }

    public String getActiveKey() {
        return activeKey;
    }

    /** Combination of the EDGE_* flags being dragged; EDGE_NONE while moving. */
    public int getActiveEdges() {
        return activeEdges;
    }

    /**
     * Where the moved rectangle goes for the finger at (x, y): it keeps the offset it had to the
     * finger on ACTION_DOWN and stays inside [minX, maxX] x [minY, maxY].
     */
    public void move(float x, float y, RectF current,
                     float minX, float minY, float maxX, float maxY, RectF out) {
        out.set(current);
        out.offset(Math.round(x + grabOffsetX - current.left), Math.round(y + grabOffsetY - current.top));

        float dx = 0f;
        float dy = 0f;
        if (out.left < minX) dx += minX - out.left;
        if (out.right > maxX) dx -= out.right - maxX;
        if (out.top < minY) dy += minY - out.top;
        if (out.bottom > maxY) dy -= out.bottom - maxY;
        out.offset(dx, dy);
    }

    /**
     * The rectangle with the grabbed edge(s) moved to the finger at (x, y), keeping the offset
     * they had on ACTION_DOWN, the minimum size and the [minX, maxX] x [minY, maxY] bounds.
     */
    public void resize(float x, float y, RectF current, float minWidth, float minHeight,
                       float minX, float minY, float maxX, float maxY, RectF out) {
        out.set(current);
        float targetX = Math.round(clamp(x + grabOffsetX, minX, maxX));
        float targetY = Math.round(clamp(y + grabOffsetY, minY, maxY));

        if ((activeEdges & EDGE_LEFT) != 0) {
            out.left = Math.min(targetX, out.right - minWidth);
        } else if ((activeEdges & EDGE_RIGHT) != 0) {
            out.right = Math.max(targetX, out.left + minWidth);
        }
        if ((activeEdges & EDGE_TOP) != 0) {
            out.top = Math.min(targetY, out.bottom - minHeight);
        } else if ((activeEdges & EDGE_BOTTOM) != 0) {
            out.bottom = Math.max(targetY, out.top + minHeight);
        }

        // The minimum size can push the rectangle past a margin; shift it back as a whole,
        // the same way the previous corner and edge drags did.
        float dx = 0f;
        float dy = 0f;
        if (out.left < minX) dx = minX - out.left;
        if (out.right > maxX) dx = Math.min(dx, maxX - out.right);
        if (out.top < minY) dy = minY - out.top;
        if (out.bottom > maxY) dy = Math.min(dy, maxY - out.bottom);
        out.offset(dx, dy);
    }

    /** Draws the grabbed edge(s) of the resized rectangle; does nothing while moving. */
    public void drawHighlight(Canvas canvas, View view, RectF rect) {
        if (!isResizing() || rect == null || rect.isEmpty()) return;
        float dp = viewPxPerDp(view);
        highlightOutline.setStrokeWidth(HIGHLIGHT_OUTLINE_DP * dp);
        highlightLine.setStrokeWidth(HIGHLIGHT_LINE_DP * dp);
        // All outlines first, so at a corner the second outline does not cover the first line.
        drawActiveEdges(canvas, rect, highlightOutline);
        drawActiveEdges(canvas, rect, highlightLine);
    }

    // ---------------------------------------------------------------------------------------------
    // Hit testing
    // ---------------------------------------------------------------------------------------------

    private void start(Target target, int edges, float x, float y) {
        activeKey = target.key;
        activeEdges = edges;
        RectF r = target.rect;
        if (edges == EDGE_NONE) {
            grabOffsetX = r.left - x;
            grabOffsetY = r.top - y;
            return;
        }
        if ((edges & EDGE_LEFT) != 0) grabOffsetX = r.left - x;
        else if ((edges & EDGE_RIGHT) != 0) grabOffsetX = r.right - x;
        if ((edges & EDGE_TOP) != 0) grabOffsetY = r.top - y;
        else if ((edges & EDGE_BOTTOM) != 0) grabOffsetY = r.bottom - y;
    }

    /** Edges grabbed by a touch inside the resizable target at index. */
    private int edgesInside(int index, float x, float y, float dp, int viewWidth, int viewHeight) {
        RectF r = targets.get(index).rect;
        int edges = EDGE_NONE;
        if (x - r.left < innerBand(index, EDGE_LEFT, dp, viewWidth, viewHeight)) {
            edges |= EDGE_LEFT;
        } else if (r.right - x < innerBand(index, EDGE_RIGHT, dp, viewWidth, viewHeight)) {
            edges |= EDGE_RIGHT;
        }
        if (y - r.top < innerBand(index, EDGE_TOP, dp, viewWidth, viewHeight)) {
            edges |= EDGE_TOP;
        } else if (r.bottom - y < innerBand(index, EDGE_BOTTOM, dp, viewWidth, viewHeight)) {
            edges |= EDGE_BOTTOM;
        }
        return extendToCorner(r, edges, x, y, dp);
    }

    /** Edges grabbed by a touch outside a resizable rectangle, already known to be within its band. */
    private static int edgesOutside(RectF r, float x, float y, float dp) {
        int edges = EDGE_NONE;
        if (x < r.left) edges |= EDGE_LEFT;
        else if (x >= r.right) edges |= EDGE_RIGHT;
        if (y < r.top) edges |= EDGE_TOP;
        else if (y >= r.bottom) edges |= EDGE_BOTTOM;
        return extendToCorner(r, edges, x, y, dp);
    }

    /** Turns a single-edge hit near one of the edge's ends into a corner hit. */
    private static int extendToCorner(RectF r, int edges, float x, float y, float dp) {
        boolean onSide = (edges & LEFT_OR_RIGHT) != 0;
        boolean onTopOrBottom = (edges & TOP_OR_BOTTOM) != 0;
        if (onSide == onTopOrBottom) return edges; // nothing grabbed, or already a corner

        float reach = CORNER_REACH_DP * dp;
        if (onSide) {
            float along = Math.min(reach, r.height() * CORNER_MAX_EDGE_FRACTION);
            if (y - r.top < along) edges |= EDGE_TOP;
            else if (r.bottom - y < along) edges |= EDGE_BOTTOM;
        } else {
            float along = Math.min(reach, r.width() * CORNER_MAX_EDGE_FRACTION);
            if (x - r.left < along) edges |= EDGE_LEFT;
            else if (r.right - x < along) edges |= EDGE_RIGHT;
        }
        return edges;
    }

    /** Width of the handle band inside the target at index, along the given edge. */
    private float innerBand(int index, int edge, float dp, int viewWidth, int viewHeight) {
        RectF r = targets.get(index).rect;
        float across = (edge & LEFT_OR_RIGHT) != 0 ? r.width() : r.height();
        float outer = outerBand(index, edge, dp, viewWidth, viewHeight);
        return Math.max(0f, Math.min(TOTAL_BAND_DP * dp - outer, across * INNER_MAX_FRACTION));
    }

    /**
     * Width of the handle band outside the target at index, along the given edge: at most
     * OUTER_BAND_DP, at most the room to the canvas edge, and at most half of the gap to any
     * rectangle facing that edge (0 when they touch or overlap).
     */
    private float outerBand(int index, int edge, float dp, int viewWidth, int viewHeight) {
        RectF r = targets.get(index).rect;
        float room;
        switch (edge) {
            case EDGE_LEFT:   room = r.left; break;
            case EDGE_RIGHT:  room = viewWidth - r.right; break;
            case EDGE_TOP:    room = r.top; break;
            default:          room = viewHeight - r.bottom; break;
        }
        room = Math.min(room, OUTER_BAND_DP * dp);

        for (int j = 0; j < targetCount; j++) {
            if (j == index) continue;
            RectF o = targets.get(j).rect;
            float gap;
            switch (edge) {
                case EDGE_LEFT:
                    if (o.top >= r.bottom || o.bottom <= r.top || o.left >= r.left) continue;
                    gap = r.left - o.right;
                    break;
                case EDGE_RIGHT:
                    if (o.top >= r.bottom || o.bottom <= r.top || o.right <= r.right) continue;
                    gap = o.left - r.right;
                    break;
                case EDGE_TOP:
                    if (o.left >= r.right || o.right <= r.left || o.top >= r.top) continue;
                    gap = r.top - o.bottom;
                    break;
                default:
                    if (o.left >= r.right || o.right <= r.left || o.bottom <= r.bottom) continue;
                    gap = o.top - r.bottom;
                    break;
            }
            room = Math.min(room, Math.max(0f, gap) / 2f);
        }
        return Math.max(0f, room);
    }

    private static float distanceToRect(RectF r, float x, float y) {
        float dx = Math.max(Math.max(r.left - x, 0f), x - r.right);
        float dy = Math.max(Math.max(r.top - y, 0f), y - r.bottom);
        return (float) Math.hypot(dx, dy);
    }

    // ---------------------------------------------------------------------------------------------
    // Drawing and units
    // ---------------------------------------------------------------------------------------------

    private void drawActiveEdges(Canvas canvas, RectF r, Paint paint) {
        if ((activeEdges & EDGE_LEFT) != 0) canvas.drawLine(r.left, r.top, r.left, r.bottom, paint);
        if ((activeEdges & EDGE_TOP) != 0) canvas.drawLine(r.left, r.top, r.right, r.top, paint);
        if ((activeEdges & EDGE_RIGHT) != 0) canvas.drawLine(r.right, r.top, r.right, r.bottom, paint);
        if ((activeEdges & EDGE_BOTTOM) != 0) canvas.drawLine(r.left, r.bottom, r.right, r.bottom, paint);
    }

    /** View pixels per physical dp, taking the scale of the view and of its parents into account. */
    private static float viewPxPerDp(View view) {
        float density = view.getResources().getDisplayMetrics().density;
        float scale = 1f;
        View current = view;
        while (current != null) {
            float s = Math.min(Math.abs(current.getScaleX()), Math.abs(current.getScaleY()));
            if (s > 0f) scale *= s;
            ViewParent parent = current.getParent();
            current = parent instanceof View ? (View) parent : null;
        }
        return density / scale;
    }

    private static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(value, max));
    }
}
