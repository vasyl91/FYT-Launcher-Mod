package com.android.launcher66;

/**
 * How far the picture of a bar's background is turned for the edge the bar is on.
 *
 * <p>The rule: a background follows its bar. The pictures of the horizontal bar are drawn for a bar at the
 * bottom, with their upper edge towards the screen. At the top the picture is turned by 180 degrees, so the
 * same edge still faces the screen. On the vertical bar the same pictures are turned by 90 degrees clockwise on
 * the left and by 90 degrees counter-clockwise on the right. The vertical bar's own picture (hotseat_bg) is
 * drawn upright for a bar on the left: there it is not turned, and on the right it is turned by 180 degrees,
 * which is the same half turn between the two sides as for the other pictures.
 *
 * <p>Only the picture turns. The bar, its icons and its texts are not transformed (RotatedDrawable draws the
 * picture turned inside the background's own bounds). A background of one colour looks the same from every
 * side and is not turned. Pure Java, so that it has a test.
 */
public final class BackgroundAngle {

    /** The edge of the screen a bar is on. */
    public enum Side { BOTTOM, TOP, LEFT, RIGHT }

    private BackgroundAngle() {
    }

    /**
     * @param upright the picture is higher than wide: it was drawn for the vertical bar on the left
     * @return degrees clockwise: 0, 90, 180 or 270
     */
    public static int degrees(Side side, boolean upright) {
        switch (side) {
            case TOP:
                return 180;
            case LEFT:
                return upright ? 0 : 90;
            case RIGHT:
                return upright ? 180 : 270;
            default:
                return 0;
        }
    }

    public static Side horizontal(boolean top) {
        return top ? Side.TOP : Side.BOTTOM;
    }

    public static Side vertical(boolean right) {
        return right ? Side.RIGHT : Side.LEFT;
    }

    /** A quarter turn swaps the width and the height of what is drawn. */
    public static boolean swapsSides(int degrees) {
        return degrees % 180 != 0;
    }
}
