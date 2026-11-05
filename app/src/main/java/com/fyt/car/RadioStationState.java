package com.fyt.car;

import java.util.List;

/**
 * What com.syu.media's list of FM stations says of the station tuned in, free of android.* so that it can be
 * tested on the JVM. The list is content://com.syu.radio/city_station, a table of the stations the user keeps
 * or edited, per city ("DEF" or the city chosen in the app). The launcher does not know which city is chosen
 * (that is in the app's private preferences), so a row of the frequency in any city counts: the station is a
 * favorite if one of them is.
 */
final class RadioStationState {

    /** A row of the table, the columns the launcher asks for. */
    static final class Row {
        final int favorite;
        final String coverPath;
        final String title;

        Row(int favorite, String coverPath, String title) {
            this.favorite = favorite;
            this.coverPath = coverPath;
            this.title = title;
        }
    }

    /** The state could not be read (another firmware, the app not running ...): the heart stays grey. */
    static final RadioStationState UNKNOWN = new RadioStationState(null, null, null);

    /** true / false once the table was read; null when it could not be. */
    final Boolean favorite;
    /** The cover_path of a row of the station (a favorite's first), null if none has one. */
    final String coverPath;
    final String title;

    private RadioStationState(Boolean favorite, String coverPath, String title) {
        this.favorite = favorite;
        this.coverPath = coverPath;
        this.title = title;
    }

    /** The state of a frequency from the rows of the table that have it (none: not a favorite). */
    static RadioStationState of(List<Row> rows) {
        if (rows == null) {
            return UNKNOWN;
        }
        boolean favorite = false;
        String cover = null;
        String title = null;
        for (Row row : rows) {
            boolean isFavorite = row.favorite == 1;
            favorite |= isFavorite;
            boolean hasCover = row.coverPath != null && !row.coverPath.trim().isEmpty();
            if (hasCover && (cover == null || isFavorite)) {
                cover = row.coverPath.trim();
            }
            boolean hasTitle = row.title != null && !row.title.trim().isEmpty();
            if (hasTitle && (title == null || isFavorite)) {
                title = row.title.trim();
            }
        }
        return new RadioStationState(favorite, cover, title);
    }
}
