package com.android.launcher66.settings;

/**
 * What the launcher notes beside the copy it keeps of a wallpaper it set itself: the id the system gave that
 * wallpaper.
 *
 * <p>The rule: the copy stands for the wallpaper only while that very wallpaper is still set. The system
 * gives every wallpaper a new id when it is set, by whomever. So the copy is used when the id of the
 * wallpaper now is the one noted with the copy, and not otherwise: a wallpaper set since by another app, or
 * through the system's own picker, has another id, and the old copy would show a picture that is no longer
 * on the screen. An id that is not positive is no id (the system gives -1 where it cannot tell).
 * Pure Java, so that it has a test.
 */
final class OwnWallpaperRecord {

    private OwnWallpaperRecord() {
    }

    /** The text kept in the id file. */
    static String format(int wallpaperId) {
        return Integer.toString(wallpaperId);
    }

    /** The id in the text of the id file, or -1 for anything else. */
    static int parse(String text) {
        if (text == null) {
            return -1;
        }
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * @param notedId   the id noted with the copy
     * @param currentId the id of the wallpaper that is set now
     */
    static boolean stillSet(int notedId, int currentId) {
        return notedId > 0 && notedId == currentId;
    }
}
