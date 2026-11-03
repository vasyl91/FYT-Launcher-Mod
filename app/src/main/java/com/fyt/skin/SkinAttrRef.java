package com.fyt.skin;

/**
 * Parses the attribute values that skins understand. FYT skins only handle numeric resource
 * references ({@code @<id>} and {@code ?<id>}, as rewritten by the platform's aapt); every other
 * value, such as a literal {@code android:tag="boxFit"}, is not a skin reference and must be ignored
 * instead of aborting the layout inflation.
 */
public final class SkinAttrRef {

    private SkinAttrRef() {
    }

    /**
     * Returns the numeric id of a {@code @<digits>} or {@code ?<digits>} reference, or {@code null}
     * for anything else (literals, colors, {@code @null}, named references, overflowing numbers).
     */
    public static Integer resourceRef(String value) {
        if (value == null || value.length() < 2) {
            return null;
        }
        char prefix = value.charAt(0);
        if (prefix != '@' && prefix != '?') {
            return null;
        }
        for (int i = 1; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c < '0' || c > '9') {
                return null;
            }
        }
        try {
            return Integer.valueOf(value.substring(1));
        } catch (NumberFormatException e) {
            // More digits than an int holds, so it cannot be a resource id.
            return null;
        }
    }

    /** True when the value refers to a theme attribute ({@code ?<id>}) rather than a resource. */
    public static boolean isThemeRef(String value) {
        return value != null && value.startsWith("?");
    }
}
