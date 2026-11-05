package com.android.launcher66;

/**
 * How the music widget of the widget bar writes the title and the artist, and where the buttons
 * go: the user's choices and what is really used. Kept free of views so that the rules can be
 * tested. 'Title and artist' has three choices, the last two both mean "one line":
 * <ul>
 *   <li>{@link Text#TWO_LINES}: the title above the artist;</li>
 *   <li>{@link Text#ARTIST_TITLE}: one line, "artist - title";</li>
 *   <li>{@link Text#TITLE_ARTIST}: one line, "title - artist".</li>
 * </ul>
 * The choice works the same in both layouts (the buttons beside the text, and the usual one with the
 * text above a row of buttons).
 */
public final class WidgetBarLines {

    public enum Text {
        TWO_LINES("two"), ARTIST_TITLE("artist_title"), TITLE_ARTIST("title_artist");

        public final String value;

        Text(String value) {
            this.value = value;
        }

        /** Both of the one-line choices. */
        public boolean oneLine() {
            return this != TWO_LINES;
        }
    }

    private WidgetBarLines() {
    }

    /**
     * The choice as it is stored. {@code legacyOneLine} is the old on/off switch (one line, always
     * "artist - title"), which counts until the string is stored; an unknown string is two lines.
     */
    public static Text parse(String stored, boolean legacyOneLine) {
        if (stored == null) {
            return legacyOneLine ? Text.ARTIST_TITLE : Text.TWO_LINES;
        }
        for (Text text : Text.values()) {
            if (text.value.equals(stored)) {
                return text;
            }
        }
        return Text.TWO_LINES;
    }

    /** 'Buttons in one line' counts only in the layout with the buttons beside the text. */
    public static boolean buttonsInOneRow(boolean switchOn, boolean buttonsBeside) {
        return switchOn && buttonsBeside;
    }
}
