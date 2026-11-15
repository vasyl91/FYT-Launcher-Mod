package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * What every string file must keep, whatever its language (the translations are written by the session that
 * adds a string, not by native speakers, so what a machine can check is checked here):
 * <ul>
 * <li>the file is well-formed and names no key twice;</li>
 * <li>a translated key exists in the English file (a key that was removed there is removed everywhere);</li>
 * <li>a translation has the same format arguments as the English text, so that formatting it cannot throw
 * or drop a value;</li>
 * <li>a translation is not empty where the English text is not.</li>
 * </ul>
 * The quality of the language itself is not something a test can tell.
 */
class StringResourcesTest {

    private static final Pattern ARGUMENT = Pattern.compile("%(?:\\d+\\$)?(?:\\.\\d+)?[sdf]");

    private static Map<String, String> base;
    private static final Map<String, Map<String, String>> translations = new TreeMap<>();
    private static final List<String> problems = new ArrayList<>();

    @BeforeAll
    static void readAllFiles() throws Exception {
        File res = new File("src/main/res");
        if (!res.isDirectory()) {
            res = new File("app/src/main/res");
        }
        assertTrue(res.isDirectory(), "the resources are found from " + new File(".").getAbsolutePath());
        base = read(new File(res, "values/strings.xml"), "values");
        File[] folders = res.listFiles();
        assertTrue(folders != null);
        for (File folder : folders) {
            String name = folder.getName();
            File file = new File(folder, "strings.xml");
            if (!name.startsWith("values-") || !file.isFile()) {
                continue;
            }
            translations.put(name.substring("values-".length()), read(file, name));
        }
    }

    private static Map<String, String> read(File file, String folder) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        NodeList strings = document.getDocumentElement().getElementsByTagName("string");
        Map<String, String> texts = new LinkedHashMap<>();
        for (int i = 0; i < strings.getLength(); i++) {
            Element element = (Element) strings.item(i);
            String key = element.getAttribute("name");
            if (texts.put(key, element.getTextContent()) != null) {
                problems.add(folder + ": " + key + " is there twice");
            }
        }
        return texts;
    }

    private static List<String> arguments(String text) {
        List<String> found = new ArrayList<>();
        Matcher matcher = ARGUMENT.matcher(text.replace("%%", ""));
        while (matcher.find()) {
            found.add(matcher.group());
        }
        Collections.sort(found);
        return found;
    }

    @Test
    void theLauncherHasItsFiftyNineLanguages() {
        assertEquals(58, translations.size(), "58 translations beside the English file: " + translations.keySet());
    }

    @Test
    void noFileNamesAKeyTwice() {
        assertEquals(Collections.emptyList(), problems);
    }

    @Test
    void aTranslatedKeyExistsInTheEnglishFile() {
        List<String> stray = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> language : translations.entrySet()) {
            for (String key : language.getValue().keySet()) {
                if (!base.containsKey(key)) {
                    stray.add(language.getKey() + ": " + key);
                }
            }
        }
        assertEquals(Collections.emptyList(), stray);
    }

    @Test
    void aTranslationHasTheFormatArgumentsOfTheEnglishText() {
        List<String> wrong = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> language : translations.entrySet()) {
            for (Map.Entry<String, String> text : language.getValue().entrySet()) {
                String english = base.get(text.getKey());
                if (english != null && !arguments(english).equals(arguments(text.getValue()))) {
                    wrong.add(language.getKey() + ": " + text.getKey() + " has " + arguments(text.getValue())
                            + ", the English text " + arguments(english));
                }
            }
        }
        assertEquals(Collections.emptyList(), wrong);
    }

    @Test
    void aTranslationIsNotEmpty() {
        List<String> empty = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> language : translations.entrySet()) {
            for (Map.Entry<String, String> text : language.getValue().entrySet()) {
                String english = base.get(text.getKey());
                if (english != null && !english.trim().isEmpty() && text.getValue().trim().isEmpty()) {
                    empty.add(language.getKey() + ": " + text.getKey());
                }
            }
        }
        assertEquals(Collections.emptyList(), empty);
    }

    @Test
    void theArgumentsOfATextAreRead() {
        assertEquals(java.util.Arrays.asList("%1$d", "%2$s"), arguments("Page %1$d of %2$s, 100%%"));
        assertFalse(arguments("Alpha: %1$d%%").isEmpty());
        assertTrue(arguments("100%% sure").isEmpty());
    }
}
