package com.android.launcher66;

/**
 * How many bytes of widget previews the drawer keeps in memory, and how much of them it gives back when the
 * system asks for memory (WidgetPreviewLoader).
 *
 * <p>The rules:
 * <ul>
 *   <li>The previews are counted in bytes (Bitmap.getAllocationByteCount()), not in number: one preview of a
 *       large widget can weigh as much as twenty small ones. The budget is a sixteenth of what the process may
 *       use (Runtime.maxMemory()), at least {@link #MIN_BYTES}; past it the preview used longest ago goes.</li>
 *   <li>A preview is kept under its size and its name together ({@link #key}): the list of widgets and the
 *       pages of the drawer ask for previews of different sizes, and one must never get the other's.</li>
 *   <li>A trim of memory ({@link #keepAfterTrim}): from "running low" (10) on, which includes the launcher's
 *       screen being hidden (20) and every level of a process in the background, nothing is kept; at
 *       "running moderate" (5) half is kept. A preview shown on the screen stays on it either way: its view
 *       holds it, and the cache only forgets it.</li>
 * </ul>
 * The levels are ComponentCallbacks2's; they are written out here so that this class stays plain Java.
 */
public final class PreviewCachePolicy {

    /** ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE. */
    static final int RUNNING_MODERATE = 5;
    /** ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW. */
    static final int RUNNING_LOW = 10;

    /** The least budget, for a process with very little memory: a page of previews still fits in it. */
    static final int MIN_BYTES = 2 * 1024 * 1024;

    private PreviewCachePolicy() {
    }

    /** @return the bytes of previews kept for a process that may use maxMemory bytes */
    public static int budgetBytes(long maxMemory) {
        long budget = maxMemory / 16;
        return (int) Math.max(MIN_BYTES, Math.min(Integer.MAX_VALUE, budget));
    }

    /** @return the key of the preview of this name at this size ("WIDTHxHEIGHT") */
    public static String key(String size, String name) {
        return size + "/" + name;
    }

    /**
     * @param level the level of onTrimMemory()
     * @param bytes the bytes of previews kept now
     * @return the bytes that may stay kept after it
     */
    public static int keepAfterTrim(int level, int bytes) {
        if (level >= RUNNING_LOW) {
            return 0;
        }
        if (level >= RUNNING_MODERATE) {
            return bytes / 2;
        }
        return bytes;
    }
}
