package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * Resource ids are numbered by name within a type, and they move whenever a resource is added or
 * removed. Code that adds to one (R.drawable.icon_bg + 1) meant "the next file I know of", and
 * after a clean-up it silently picked another drawable: a white tile with a gear under every app
 * icon. Name the resource, or keep the ids in an array.
 */
class ResourceIdArithmeticTest {

    private static final Pattern ARITHMETIC = Pattern.compile(
            "(?<![\\w.])R\\.[a-z]+\\.\\w+\\s*[-+]\\s*[\\w(]|[\\w)]\\s*[-+]\\s*R\\.[a-z]+\\.\\w+");

    @Test
    void noCodeDoesArithmeticOnAResourceId() throws IOException {
        // Gradle runs the tests in the module's directory
        Path root = Paths.get("src/main/java");
        List<String> found = new ArrayList<>();
        try (Stream<Path> files = Files.walk(root)) {
            for (Path file : (Iterable<Path>) files::iterator) {
                String name = file.toString().replace('\\', '/');
                // The fake R of another app (com.syu.canbus) is plain constants, not ours
                if (!name.endsWith(".java") && !name.endsWith(".kt") || name.endsWith("com/syu/canbus/R.java")) {
                    continue;
                }
                List<String> lines = Files.readAllLines(file);
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i).trim();
                    if (line.startsWith("//") || line.startsWith("*") || line.startsWith("/*")) {
                        continue;
                    }
                    if (ARITHMETIC.matcher(line).find()) {
                        found.add(name + ":" + (i + 1) + ": " + line);
                    }
                }
            }
        }
        assertTrue(found.isEmpty(), "Arithmetic on resource ids:\n" + String.join("\n", found));
    }
}
