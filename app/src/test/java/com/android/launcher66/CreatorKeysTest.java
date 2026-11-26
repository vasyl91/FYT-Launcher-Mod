package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * "Stock layout" turns off the creator's settings, so the set of the creator's keys must not miss a row: the test
 * reads the screen's XML and compares it with {@link CreatorKeys#XML_KEYS}.
 */
class CreatorKeysTest {

    private static final String ANDROID = "http://schemas.android.com/apk/res/android";

    /** The unit tests run in the module's folder (app/); a run from the repository's root is found too. */
    private static File creatorXml() {
        File[] candidates = {
                new File("src/main/res/xml/creator_preferences.xml"),
                new File("app/src/main/res/xml/creator_preferences.xml")
        };
        for (File f : candidates) {
            if (f.isFile()) {
                return f;
            }
        }
        throw new IllegalStateException("creator_preferences.xml not found from " + new File(".").getAbsolutePath());
    }

    private static Set<String> keysInXml() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().parse(creatorXml());
        Set<String> keys = new HashSet<>();
        collect(doc.getDocumentElement(), keys);
        return keys;
    }

    private static void collect(Element element, Set<String> keys) {
        String key = element.getAttributeNS(ANDROID, "key");
        if (key != null && !key.isEmpty()) {
            keys.add(key);
        }
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element) {
                collect((Element) node, keys);
            }
        }
    }

    @Test
    void everyKeyOfTheCreatorsScreenIsInTheSetAndTheSetHasNoOther() throws Exception {
        Set<String> xml = keysInXml();
        Set<String> missing = new HashSet<>(xml);
        missing.removeAll(CreatorKeys.XML_KEYS);
        assertTrue(missing.isEmpty(), "rows of creator_preferences.xml missing from CreatorKeys.XML_KEYS: " + missing);
        Set<String> gone = new HashSet<>(CreatorKeys.XML_KEYS);
        gone.removeAll(xml);
        assertTrue(gone.isEmpty(), "keys of CreatorKeys.XML_KEYS no longer in creator_preferences.xml: " + gone);
    }

    @Test
    void theLaunchersOwnSwitchAndOtherSettingsAreNotTheCreators() {
        assertFalse(CreatorKeys.contains("user_layout"));
        assertFalse(CreatorKeys.contains("badges_enabled"));
        assertFalse(CreatorKeys.contains(null));
        assertTrue(CreatorKeys.contains("workspace_grid_long"));
        assertTrue(CreatorKeys.contains("bar_tint_color"));
        assertTrue(CreatorKeys.contains("horizontal_bar_top"));
        assertEquals(CreatorKeys.XML_KEYS.size() + CreatorKeys.STORED_ELSEWHERE.size(),
                countAll());
    }

    private static int countAll() {
        Set<String> all = new HashSet<>(CreatorKeys.XML_KEYS);
        all.addAll(CreatorKeys.STORED_ELSEWHERE);
        return all.size();
    }
}
