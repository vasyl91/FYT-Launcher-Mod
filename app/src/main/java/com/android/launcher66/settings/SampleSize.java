package com.android.launcher66.settings;

/**
 * How much smaller a picture is decoded (BitmapFactory.Options.inSampleSize) so that it is no bigger in memory
 * than the screen it is shown on needs. A wallpaper photo can be many times the size of a head unit's screen,
 * and decoded whole it takes tens of megabytes for a backdrop.
 *
 * <p>The rule: the largest power of two that still leaves the decoded picture covering the size asked, its width
 * at least the width asked and its height at least the height asked. So a picture is never made smaller than
 * the screen and nothing is drawn enlarged; a picture no bigger than twice the screen is decoded whole. A size
 * that is not known (zero or less) gives 1: the whole picture, as before.
 *
 * <p>The decoder may round a side up rather than down; the rule counts with the side rounded down, so the
 * result covers the size asked either way.
 */
public final class SampleSize {

    private SampleSize() {
    }

    /**
     * @param width   the picture's width in pixels
     * @param height  the picture's height in pixels
     * @param coverWidth  the width the decoded picture must still cover
     * @param coverHeight the height the decoded picture must still cover
     * @return a power of two, at least 1
     */
    public static int toCover(int width, int height, int coverWidth, int coverHeight) {
        if (width <= 0 || height <= 0 || coverWidth <= 0 || coverHeight <= 0) {
            return 1;
        }
        int sample = 1;
        // Doubled while the next step still covers both sides; the limit keeps the shift from overflowing
        while (sample < (1 << 20) && width / (sample * 2) >= coverWidth && height / (sample * 2) >= coverHeight) {
            sample *= 2;
        }
        return sample;
    }

    /**
     * The same, for a picture that must cover a screen in both of its orientations: a wallpaper is set once and
     * shown whichever way the screen is turned, so both sides must cover the screen's longer side.
     */
    public static int toCoverTurned(int width, int height, int screenWidth, int screenHeight) {
        int longer = Math.max(screenWidth, screenHeight);
        return toCover(width, height, longer, longer);
    }
}
