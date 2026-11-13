package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Which ways of getting the home screen's wallpaper are worth trying on this device, in their order.
 *
 * <p>The launcher needs the picture in two places: as the backdrop of the background selectors, and to save
 * it as the day or the night wallpaper. The rules:
 * <ul>
 *   <li>the best way that needs the least comes first, and a later one is tried only when the earlier ones
 *       gave nothing: the system's own API; then the privileged host (the root module, or Shizuku); then no
 *       picture at all, where the user is shown the wallpaper's colours and can pick an image;</li>
 *   <li>it is always the home screen's wallpaper that is asked for, never the lock screen's;</li>
 *   <li>the API is used only where it gives the real picture. Up to Android 12 that needs the storage
 *       permission. From Android 13 an app built for it gets the picture only with access to all files (or
 *       as a system app); without it the API throws, or on Android 13 gives the built-in wallpaper in place
 *       of the user's, so it is not asked at all;</li>
 *   <li>the old storage permission is requested only where it still exists and helps: below Android 13. On
 *       13 and later it can never be granted to this app, and asking for it on every opening of a selector
 *       was pointless. Access to all files is not requested for a backdrop.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class WallpaperAccess {

    /** Android 13: READ_EXTERNAL_STORAGE no longer exists for an app built for it. */
    static final int ANDROID_13 = 33;

    /** A way of getting the wallpaper. */
    enum Level {
        /** WallpaperManager, with FLAG_SYSTEM. */
        SYSTEM_API,
        /** The privileged host's readHomeWallpaper(). */
        HOST,
        /** No picture: the wallpaper's colours, and the "Pick wallpaper" button. */
        USER_PICKS
    }

    private WallpaperAccess() {
    }

    /**
     * @param sdk             Build.VERSION.SDK_INT
     * @param systemApp       the launcher runs as the system (it holds the system's wallpaper permission)
     * @param storageGranted  READ_EXTERNAL_STORAGE is granted (it can be, below Android 13)
     * @param allFilesAccess  the user gave the launcher access to all files
     * @param hostAvailable   a privileged host other than the launcher itself is attached
     * @return the ways to try, in order; the last one is always {@link Level#USER_PICKS}
     */
    static List<Level> levels(int sdk, boolean systemApp, boolean storageGranted, boolean allFilesAccess,
                              boolean hostAvailable) {
        List<Level> levels = new ArrayList<>();
        if (apiGivesThePicture(sdk, systemApp, storageGranted, allFilesAccess)) {
            levels.add(Level.SYSTEM_API);
        }
        if (hostAvailable) {
            levels.add(Level.HOST);
        }
        levels.add(Level.USER_PICKS);
        return levels;
    }

    static boolean apiGivesThePicture(int sdk, boolean systemApp, boolean storageGranted, boolean allFilesAccess) {
        if (systemApp) {
            return true;
        }
        return sdk < ANDROID_13 ? storageGranted : allFilesAccess;
    }

    /** Whether asking the user for the old storage permission can help to read the wallpaper. */
    static boolean storagePermissionHelps(int sdk, boolean systemApp) {
        return !systemApp && sdk < ANDROID_13;
    }
}
