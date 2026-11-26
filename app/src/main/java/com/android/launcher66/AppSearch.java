package com.android.launcher66;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * The filter of the search field of the app drawer and of the widget list.
 *
 * <p>The rule: a name matches when it contains what was typed, ignoring capitals and accents ("zolc" finds
 * "Żółć", "MAPS" finds "Google Maps"), as it is typed, with every change of the text. An empty text or one of
 * blanks shows everything. The order of the list is kept. Pure Java, so that it has a test.
 */
final class AppSearch {

    private AppSearch() {
    }

    /** The text as it is compared: no accents, no capitals, no blanks at the ends. */
    static String normalize(String text) {
        if (text == null) {
            return "";
        }
        StringBuilder mapped = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'ł': case 'Ł': mapped.append('l'); break;
                case 'đ': case 'Đ': case 'ð': case 'Ð': mapped.append('d'); break;
                case 'ø': case 'Ø': mapped.append('o'); break;
                case 'ħ': case 'Ħ': mapped.append('h'); break;
                case 'ı': mapped.append('i'); break;
                default: mapped.append(c);
            }
        }
        String decomposed = Normalizer.normalize(mapped, Normalizer.Form.NFD);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < decomposed.length(); ) {
            int cp = decomposed.codePointAt(i);
            i += Character.charCount(cp);
            int type = Character.getType(cp);
            if (type == Character.NON_SPACING_MARK || type == Character.COMBINING_SPACING_MARK
                    || type == Character.ENCLOSING_MARK) {
                continue;
            }
            sb.appendCodePoint(cp);
        }
        return sb.toString().toLowerCase(Locale.ROOT).trim();
    }

    /** Whether a name matches what was typed. */
    static boolean matches(String name, String query) {
        String wanted = normalize(query);
        return wanted.isEmpty() || normalize(name).contains(wanted);
    }

    /** The items whose name matches, in their order. The same list when nothing is typed. */
    static <T> List<T> filter(List<T> items, Function<T, String> name, String query) {
        if (normalize(query).isEmpty()) {
            return items;
        }
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (matches(name.apply(item), query)) {
                result.add(item);
            }
        }
        return result;
    }
}
