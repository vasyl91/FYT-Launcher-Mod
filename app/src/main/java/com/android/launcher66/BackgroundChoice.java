package com.android.launcher66;

/**
 * What a "Choose background for ..." setting holds: one of the pictures, the user's own colour, or nothing.
 *
 * <p>The rules:
 * <ul>
 *   <li>every component (the widgets, the horizontal bar, the vertical bar, the statistics window) has its own
 *       choice and its own colour, under its own two keys; one never reads another's;</li>
 *   <li>the choice is stored as text under the component's key, as it always was: the name of a picture, or
 *       {@link #CUSTOM} for the user's colour, or {@link #NONE} for no background (where that is offered);</li>
 *   <li>the colour is stored apart from the choice ({@link #colorKey}), with its transparency, and stays when a
 *       picture is chosen again, so that the colour tile of the selector remains;</li>
 *   <li>a choice that cannot be shown (nothing stored, or "custom" without a colour) is the component's
 *       default picture.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
public final class BackgroundChoice {

    /** The stored text for the user's own colour. No picture can have this name: pictures are resources. */
    public static final String CUSTOM = "custom";
    /** The stored text for no background at all. */
    public static final String NONE = "none";

    public enum Kind { PICTURE, CUSTOM, NONE }

    public final Kind kind;
    /** The name of the picture's resource, for {@link Kind#PICTURE}. */
    public final String picture;
    /** The colour with its transparency, for {@link Kind#CUSTOM}. */
    public final int color;

    private BackgroundChoice(Kind kind, String picture, int color) {
        this.kind = kind;
        this.picture = picture;
        this.color = color;
    }

    /**
     * @param stored         the text under the component's key, or null
     * @param defaultPicture the picture the component has when nothing was chosen
     * @param hasColor       whether a colour is stored for the component
     * @param color          that colour
     */
    public static BackgroundChoice of(String stored, String defaultPicture, boolean hasColor, int color) {
        if (stored == null || stored.isEmpty()) {
            return new BackgroundChoice(Kind.PICTURE, defaultPicture, 0);
        }
        if (NONE.equals(stored)) {
            return new BackgroundChoice(Kind.NONE, null, 0);
        }
        if (CUSTOM.equals(stored)) {
            return hasColor ? new BackgroundChoice(Kind.CUSTOM, null, color)
                    : new BackgroundChoice(Kind.PICTURE, defaultPicture, 0);
        }
        return new BackgroundChoice(Kind.PICTURE, stored, 0);
    }

    /**
     * The key of a component's colour, from the key of its choice: "bar_selected_background" gives
     * "bar_custom_background_color". One rule for every component, so no two can share a colour.
     */
    public static String colorKey(String choiceKey) {
        String suffix = "_selected_background";
        String stem = choiceKey != null && choiceKey.endsWith(suffix)
                ? choiceKey.substring(0, choiceKey.length() - suffix.length()) : String.valueOf(choiceKey);
        return stem + "_custom_background_color";
    }

    @Override
    public String toString() {
        switch (kind) {
            case CUSTOM:
                return "colour #" + String.format("%08X", color);
            case NONE:
                return "none";
            default:
                return String.valueOf(picture);
        }
    }
}
