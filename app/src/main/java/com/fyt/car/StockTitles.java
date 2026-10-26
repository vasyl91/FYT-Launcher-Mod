package com.fyt.car;

/**
 * Titles of tracks that are not all files of this device. The widgets took the title from the
 * file name with {@code substring(0, lastIndexOf("."))}, which throws for a name without a dot
 * and is wrong for a stream's URL. No Android classes in here.
 */
public final class StockTitles {

    private StockTitles() {
    }

    /** A file of this device: an absolute path, not a URL ("http://", "stock-radio:/"). */
    public static boolean isLocalFile(String path) {
        return path != null && path.length() > 1 && path.charAt(0) == '/' && path.charAt(1) != '/';
    }

    /**
     * The title to show.
     *
     * @param fromFileName whether the user chose the file name as the title ("fyt_data" off)
     * @param path         the track's path or URL
     * @param metadata     the title the player reported
     * @return the file's name without its extension (all of it when there is none) for a local
     *         file under {@code fromFileName}; otherwise the player's title
     */
    public static String displayTitle(boolean fromFileName, String path, String metadata) {
        if (fromFileName && isLocalFile(path)) {
            String name = path.substring(path.lastIndexOf('/') + 1);
            int dot = name.lastIndexOf('.');
            if (dot > 0) {
                name = name.substring(0, dot);
            }
            if (!name.isEmpty()) {
                return name;
            }
        }
        return metadata != null ? metadata : "";
    }

    /** The file name without its extension, null if the path is no local file. */
    public static String fileBaseName(String path) {
        return isLocalFile(path) ? displayTitle(true, path, null) : null;
    }
}
