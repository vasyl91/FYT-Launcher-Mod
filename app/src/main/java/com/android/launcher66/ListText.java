package com.android.launcher66;

import java.util.ArrayList;
import java.util.List;

/**
 * Names in a sentence: each quoted as the language quotes, joined as the language joins a list ("“Tab2”, “Tab5” and
 * “Tab8”").
 *
 * <p>The rules: one name is itself; two are joined by the language's last joiner ({@code "%1$s and %2$s"}); more are
 * joined by its separator ({@code ", "}) up to the last one, which the last joiner adds. The quote, the separator and the
 * joiner are strings of each language ({@code drawer_tab_quoted}, {@code list_separator}, {@code list_last}). Pure Java, so
 * that it has a test.
 */
public final class ListText {

    private ListText() {
    }

    /** Each name in the quote pattern ({@code "“%1$s”"}). */
    public static List<String> quoted(List<String> names, String quotePattern) {
        List<String> result = new ArrayList<>(names.size());
        for (String name : names) {
            result.add(String.format(quotePattern, name));
        }
        return result;
    }

    /** The names joined; an empty text for none. */
    public static String join(List<String> names, String separator, String lastPattern) {
        if (names.isEmpty()) {
            return "";
        }
        if (names.size() == 1) {
            return names.get(0);
        }
        StringBuilder head = new StringBuilder(names.get(0));
        for (int i = 1; i < names.size() - 1; i++) {
            head.append(separator).append(names.get(i));
        }
        return String.format(lastPattern, head.toString(), names.get(names.size() - 1));
    }
}
