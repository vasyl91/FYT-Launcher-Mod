package com.android.launcher66;

/**
 * What a layout creator draws of the bars on a page, so that it looks as the home screen does. The rules are
 * those of {@link BarLayout} (and so of the home screen); this only turns them into the parts the creator
 * shows. Pure Java, so that it has a test.
 *
 * <ul>
 *   <li>the band of the horizontal bar, at the top or at the bottom; with auto-hide it is collapsed and shown
 *       again by the double tap, as on the home screen the bar is;</li>
 *   <li>the band of the vertical bar ({@link BarLayout#verticalBarBand()}): it ends at the horizontal bar only
 *       where the corner is taken, else it has the whole height;</li>
 *   <li>the collapsed bar's button, in the corner of the vertical bar, only where the vertical bar and the handle
 *       are on the same side (auto-hide); the arrow is turned on the right;</li>
 *   <li>the edge handle's strip, at the handle's side and in the band of the horizontal bar, where an auto-hide
 *       bar has no button (the handle stands for it). It is a picture: it reserves nothing, because the real handle
 *       lets every touch through.</li>
 * </ul>
 * Coordinates are those of the layout the {@link BarLayout} was made for: {left, top, right, bottom}.
 */
public final class CreatorBars {

    /** The handle's visible strip as a share of the longer screen edge (HorizontalBarEdgeHandle's). */
    public static final float STRIP_WIDTH_FRACTION = HorizontalBarEdgeHandle.STRIP_WIDTH_FRACTION;

    public final boolean horizontalBand;
    /** The horizontal bar is the auto-hide one: a double tap collapses it and shows it again. */
    public final boolean collapsible;
    public final boolean top;
    public final int[] horizontalBandRect;
    public final int[] verticalBand;
    /** The vertical bar has the whole height: the corner is free. */
    public final boolean verticalFullHeight;
    /** The button's rectangle, or null. */
    public final int[] button;
    /** Degrees: 180 with the vertical bar on the right. */
    public final float arrowRotation;
    /** The handle's strip, or null. */
    public final int[] handle;
    public final boolean handleRight;

    private CreatorBars(BarLayout layout, boolean autoHide) {
        horizontalBand = layout.horizontalOnPage;
        collapsible = autoHide && layout.horizontalOnPage;
        top = layout.top;
        horizontalBandRect = layout.horizontalOnPage
                ? new int[] {0, layout.horizontalBarTop(), layout.rootWidth, layout.horizontalBarBottom()}
                : new int[] {0, 0, 0, 0};
        verticalBand = layout.verticalBarBand();
        verticalFullHeight = layout.verticalBar && !layout.cornerTaken();
        boolean button = autoHide && layout.horizontalOnPage && layout.buttonShown();
        this.button = button ? layout.collapsedButton() : null;
        arrowRotation = layout.right ? 180f : 0f;
        handleRight = layout.handleRight;
        if (autoHide && layout.horizontalOnPage && !layout.buttonShown()) {
            int strip = Math.max(1, Math.round(Math.max(layout.rootWidth, layout.rootHeight)
                    * STRIP_WIDTH_FRACTION));
            int left = layout.handleRight ? layout.rootWidth - strip : 0;
            handle = new int[] {left, layout.horizontalBarTop(), left + strip, layout.horizontalBarBottom()};
        } else {
            handle = null;
        }
    }

    /**
     * @param layout   the bars on the page the creator is for
     * @param autoHide "Auto-hide horizontal bar"
     */
    public static CreatorBars of(BarLayout layout, boolean autoHide) {
        return new CreatorBars(layout, autoHide);
    }
}
