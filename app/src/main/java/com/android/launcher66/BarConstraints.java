package com.android.launcher66;

import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

/**
 * Puts the horizontal bar at the top and the vertical bar at the right edge of a layout that is written
 * for the bar at the bottom and the vertical bar on the left (the layouts of the home screen, of the
 * bar's window and of the creators). One function after the inflation, so that there is one XML for the
 * four combinations.
 *
 * <p>The children of the root are of two kinds: the bar (the view with the id {@code barId} and the views
 * that hang on its top or bottom edge: the button of all apps, the list, the widgets on the bar) and the
 * content (everything else: the vertical bar, the map, the date ... , all of which end at the bar). The bar
 * is moved to the other edge by itself; the content is mirrored. At the top the content is mirrored
 * vertically, on the right horizontally; the bar's own arrangement from left to right is left alone.
 *
 * <p>The percentages and ratios of the XML are not touched.
 */
public final class BarConstraints {

    private static final int PARENT = ConstraintLayout.LayoutParams.PARENT_ID;
    private static final int UNSET = ConstraintLayout.LayoutParams.UNSET;

    private BarConstraints() {
    }

    /**
     * @param barId         the horizontal bar: R.id.iv_list_bg of a page, R.id.creator_bar of a creator
     * @param fullHeightId  a child that spans the whole height at the top too (the canvas of a creator,
     *                      whose coordinates are those of the box), or 0
     * @param top           the horizontal bar at the top
     * @param right         the vertical bar at the right edge
     */
    public static void apply(ConstraintLayout root, int barId, int fullHeightId, boolean top, boolean right) {
        if (root == null || (!top && !right)) {
            return;
        }
        for (int i = 0; i < root.getChildCount(); i++) {
            View child = root.getChildAt(i);
            ViewGroup.LayoutParams raw = child.getLayoutParams();
            if (!(raw instanceof ConstraintLayout.LayoutParams)) {
                continue;
            }
            ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) raw;
            if (child instanceof Guideline) {
                boolean horizontalLine = lp.orientation == ConstraintLayout.LayoutParams.HORIZONTAL;
                if (horizontalLine ? top : right) {
                    flipGuideline(lp);
                    child.setLayoutParams(lp);
                }
                continue;
            }
            boolean bar = isBar(child, lp, barId);
            if (top) {
                if (bar) {
                    moveBarToTop(child, lp, barId);
                } else if (child.getId() == fullHeightId && fullHeightId != 0) {
                    lp.bottomToTop = UNSET;
                    lp.bottomToBottom = PARENT;
                } else {
                    flipVertically(lp);
                }
            }
            if (right && !bar) {
                flipHorizontally(lp);
            } else if (right && child.getId() == barId) {
                // The collapsed bar shrinks to the width of the vertical bar: at the vertical bar's side
                lp.leftToLeft = PARENT;
                lp.rightToRight = PARENT;
                lp.horizontalBias = 1f;
            }
            child.setLayoutParams(lp);
        }
        root.requestLayout();
    }

    /** The bar itself, or a view that hangs on the edge of the bar (not one that ends at its edge). */
    private static boolean isBar(View child, ConstraintLayout.LayoutParams lp, int barId) {
        return child.getId() == barId || lp.topToTop == barId || lp.bottomToBottom == barId;
    }

    private static void moveBarToTop(View child, ConstraintLayout.LayoutParams lp, int barId) {
        if (child.getId() == barId) {
            lp.bottomToBottom = UNSET;
            lp.topToTop = PARENT;
        } else if (lp.bottomToBottom == PARENT) {
            // the list of the bar: from the top of the bar to the bottom of the bar
            lp.bottomToBottom = barId;
        }
    }

    private static void flipVertically(ConstraintLayout.LayoutParams lp) {
        int topToTop = lp.topToTop;
        int topToBottom = lp.topToBottom;
        lp.topToTop = lp.bottomToBottom;
        lp.bottomToBottom = topToTop;
        lp.topToBottom = lp.bottomToTop;
        lp.bottomToTop = topToBottom;
        lp.verticalBias = 1f - lp.verticalBias;
        int margin = lp.topMargin;
        lp.topMargin = lp.bottomMargin;
        lp.bottomMargin = margin;
        int gone = lp.goneTopMargin;
        lp.goneTopMargin = lp.goneBottomMargin;
        lp.goneBottomMargin = gone;
    }

    private static void flipHorizontally(ConstraintLayout.LayoutParams lp) {
        int leftToLeft = lp.leftToLeft;
        int leftToRight = lp.leftToRight;
        lp.leftToLeft = lp.rightToRight;
        lp.rightToRight = leftToLeft;
        lp.leftToRight = lp.rightToLeft;
        lp.rightToLeft = leftToRight;
        int startToStart = lp.startToStart;
        int startToEnd = lp.startToEnd;
        lp.startToStart = lp.endToEnd;
        lp.endToEnd = startToStart;
        lp.startToEnd = lp.endToStart;
        lp.endToStart = startToEnd;
        lp.horizontalBias = 1f - lp.horizontalBias;
        int margin = lp.leftMargin;
        lp.leftMargin = lp.rightMargin;
        lp.rightMargin = margin;
        int gone = lp.goneLeftMargin;
        lp.goneLeftMargin = lp.goneRightMargin;
        lp.goneRightMargin = gone;
        gone = lp.goneStartMargin;
        lp.goneStartMargin = lp.goneEndMargin;
        lp.goneEndMargin = gone;
    }

    /** A guideline of the content: its distance from the start becomes the same distance from the end. */
    private static void flipGuideline(ConstraintLayout.LayoutParams lp) {
        if (lp.guidePercent >= 0f) {
            lp.guidePercent = 1f - lp.guidePercent;
        } else {
            int begin = lp.guideBegin;
            lp.guideBegin = lp.guideEnd;
            lp.guideEnd = begin;
        }
    }
}
