package com.android.launcher66;

/**
 * Whether a title, an artist or an album that a player gives is a value or a placeholder for none.
 *
 * <p>The rule: the value is trimmed; empty, the word {@code null}, {@code Unknown} and {@code <unknown>}
 * (the placeholders of Android's media scanner and of the players, in any case) mean that the track gave no
 * value. The comparison is with the whole value, never with a part of it: a search for the word inside it
 * took "Unknown Pleasures", "The Unknown" or "Null and Void" for no title. The same rule as {@code validTag}
 * of Display-Media-Titles, from which it is copied. Pure Java, so that it has a test.
 */
public final class TitleTag {

    private TitleTag() {
    }

    /** The trimmed value, or null for an empty one or a placeholder. */
    public static String valid(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty() || trimmed.equals("null") || trimmed.equalsIgnoreCase("Unknown")
                || trimmed.equalsIgnoreCase("<unknown>")) {
            return null;
        }
        return trimmed;
    }

    /** Whether the value is a title (or an artist, an album) and no placeholder. */
    public static boolean isValue(String value) {
        return valid(value) != null;
    }
}
