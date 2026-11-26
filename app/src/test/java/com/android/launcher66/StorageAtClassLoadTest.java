package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * No class reads storage when it loads (DirectBootPlan): no static field initializer and no static block of the
 * app's Java sources opens a preference file, a database or a file. Before the user's first unlock that storage is
 * credential encrypted and Android refuses it with an exception; a static read in Helpers hung the A55 at boot
 * (the owner, 2026-11-26), because the Launcher activity loads that class before onCreate().
 */
class StorageAtClassLoadTest {

    /** The calls that read the app's credential encrypted storage. */
    private static final Pattern STORAGE = Pattern.compile(
            "\\b(getSharedPreferences|getDefaultSharedPreferences|getFilesDir|getCacheDir|getDatabasePath"
                    + "|openFileInput|openFileOutput|openOrCreateDatabase|getNoBackupFilesDir|getDataDir)\\s*\\(");

    /** A static field with an initializer, up to the end of its statement. */
    private static final Pattern STATIC_FIELD = Pattern.compile(
            "\\bstatic\\s+(?:final\\s+)?[\\w<>\\[\\],.?\\s]+?\\s+\\w+\\s*=([^;]*);");

    private static final Pattern STATIC_BLOCK = Pattern.compile("\\bstatic\\s*\\{");

    @Test
    void noStaticInitializerReadsStorage() throws IOException {
        List<String> found = new ArrayList<>();
        Path root = Paths.get("src/main/java");
        try (Stream<Path> files = Files.walk(root)) {
            for (Path file : (Iterable<Path>) files::iterator) {
                if (!file.toString().endsWith(".java")) {
                    continue;
                }
                String code = withoutComments(new String(Files.readAllBytes(file), StandardCharsets.UTF_8));
                Matcher field = STATIC_FIELD.matcher(code);
                while (field.find()) {
                    String init = field.group(1);
                    // A lambda's or an anonymous class's body runs later, not when the class loads
                    if (init.contains("->") || init.matches("(?s).*\\bnew\\s+[\\w.<>]+\\s*\\([^)]*\\)\\s*\\{.*")) {
                        continue;
                    }
                    if (STORAGE.matcher(init).find()) {
                        found.add(root.relativize(file) + ": static field " + field.group(0).trim());
                    }
                }
                Matcher block = STATIC_BLOCK.matcher(code);
                while (block.find()) {
                    String body = braces(code, block.end() - 1);
                    if (STORAGE.matcher(body).find()) {
                        found.add(root.relativize(file) + ": static block reads storage");
                    }
                }
            }
        }
        assertTrue(found.isEmpty(), "Storage read when a class loads (refused before the first unlock):\n"
                + String.join("\n", found));
    }

    /** The text of the block that opens at {@code open} (a '{'), braces counted. */
    private static String braces(String code, int open) {
        int depth = 0;
        for (int i = open; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '{') {
                depth++;
            } else if (c == '}' && --depth == 0) {
                return code.substring(open, i + 1);
            }
        }
        return code.substring(open);
    }

    /** Comments out of the way (a commented example must not count); strings are kept. */
    private static String withoutComments(String code) {
        return code.replaceAll("(?s)/\\*.*?\\*/", " ").replaceAll("(?m)//[^\\n\"]*$", "");
    }
}
