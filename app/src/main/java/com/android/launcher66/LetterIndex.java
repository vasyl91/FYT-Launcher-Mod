package com.android.launcher66;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The letters of a sorted list of titles, for the fast scroller of the app drawer and of the widget list.
 *
 * <p>The rule: a title's letter is its first character as a person reads it, with no accent and in capitals
 * ("Ćma" and "cma" are both C), and a title that starts with a digit, a symbol or nothing is "#". The scroller's
 * alphabet is the letters that the list has, in the order in which they first appear in it, so that it matches
 * the list whatever order the list's collator gives (an app that starts with a digit may sort first or last).
 * A position of the list has a letter, a letter has the first position that carries it, and a place along
 * the scroller (0 at its top, 1 at its bottom) has a letter. Pure Java, so that it has a test.
 */
final class LetterIndex {

    /** The letter of titles that start with no letter. */
    static final String OTHER = "#";

    private LetterIndex() {
    }

    /** The capital letter a title is filed under, without its accent; {@link #OTHER} for a digit, a symbol or none. */
    static String letterOf(String title) {
        if (title == null) {
            return OTHER;
        }
        String trimmed = title.trim();
        for (int i = 0; i < trimmed.length(); ) {
            int cp = trimmed.codePointAt(i);
            i += Character.charCount(cp);
            String base = baseOf(new String(Character.toChars(cp)));
            if (base.isEmpty()) {
                continue;   // a mark alone, an invisible character: look at the next one
            }
            int first = base.codePointAt(0);
            if (Character.isLetter(first)) {
                return base.substring(0, Character.charCount(first)).toUpperCase(Locale.ROOT);
            }
            return OTHER;
        }
        return OTHER;
    }

    /** The character without its marks: "Ć" is "C", "ł" is "l" (the letters that do not decompose are mapped). */
    private static String baseOf(String character) {
        String mapped = special(character);
        String decomposed = Normalizer.normalize(mapped, Normalizer.Form.NFD);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < decomposed.length(); ) {
            int cp = decomposed.codePointAt(i);
            i += Character.charCount(cp);
            int type = Character.getType(cp);
            if (type == Character.NON_SPACING_MARK || type == Character.COMBINING_SPACING_MARK
                    || type == Character.ENCLOSING_MARK || type == Character.FORMAT) {
                continue;
            }
            sb.appendCodePoint(cp);
        }
        return sb.toString();
    }

    /** Letters that Unicode does not take apart into a base and a mark. */
    private static String special(String c) {
        switch (c) {
            case "ł": return "l";
            case "Ł": return "L";
            case "đ": return "d";
            case "Đ": return "D";
            case "ø": return "o";
            case "Ø": return "O";
            case "ð": return "d";
            case "Ð": return "D";
            case "ħ": return "h";
            case "Ħ": return "H";
            case "ı": return "i";
            default: return c;
        }
    }

    /** The letters the list has, each once, in the order they first appear in it. */
    static List<String> alphabet(List<String> titles) {
        List<String> letters = new ArrayList<>();
        for (String title : titles) {
            String letter = letterOf(title);
            if (!letters.contains(letter)) {
                letters.add(letter);
            }
        }
        return letters;
    }

    /** The first position of the list whose letter is {@code letter}; -1 when the list has none. */
    static int positionOf(List<String> titles, String letter) {
        for (int i = 0; i < titles.size(); i++) {
            if (letterOf(titles.get(i)).equals(letter)) {
                return i;
            }
        }
        return -1;
    }

    /** The letter of the title at {@code position}; the first title's for a position before the list, the last's after it. */
    static String letterAt(List<String> titles, int position) {
        if (titles.isEmpty()) {
            return OTHER;
        }
        int p = Math.max(0, Math.min(position, titles.size() - 1));
        return letterOf(titles.get(p));
    }

    /**
     * The letter at a place along the scroller: 0 is its top, 1 its bottom; the alphabet is cut into equal
     * parts, one for each letter. Out of range is the nearest end. Null for an empty alphabet.
     */
    static String letterAtFraction(List<String> alphabet, float fraction) {
        if (alphabet.isEmpty()) {
            return null;
        }
        float f = Math.max(0f, Math.min(1f, fraction));
        int index = Math.min(alphabet.size() - 1, (int) (f * alphabet.size()));
        return alphabet.get(index);
    }

    /** The place (0..1) of the middle of a letter's part of the scroller; 0 for a letter the alphabet does not have. */
    static float fractionOfLetter(List<String> alphabet, String letter) {
        int index = alphabet.indexOf(letter);
        if (index < 0 || alphabet.isEmpty()) {
            return 0f;
        }
        return (index + 0.5f) / alphabet.size();
    }
}
