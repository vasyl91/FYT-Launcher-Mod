package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The order of the creator's screen as the owner gave it (round 28): the categories, and the rows of "App drawer" in
 * the order the brief lists them (F1). Read from the screen's XML, so that a row cannot be put elsewhere unnoticed.
 */
class CreatorScreenOrderTest {

    private static final String ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String APP = "http://schemas.android.com/apk/res-auto";

    private static File creatorXml() {
        for (String path : new String[] {"src/main/res/xml/creator_preferences.xml", "app/src/main/res/xml/creator_preferences.xml"}) {
            File f = new File(path);
            if (f.isFile()) {
                return f;
            }
        }
        throw new IllegalStateException("creator_preferences.xml not found");
    }

    private static Element root() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().parse(creatorXml());
        return doc.getDocumentElement();
    }

    private static List<Element> children(Element parent) {
        List<Element> list = new ArrayList<>();
        NodeList nodes = parent.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                list.add((Element) node);
            }
        }
        return list;
    }

    private static String keyOf(Element e) {
        String key = e.getAttributeNS(ANDROID, "key");
        return key == null || key.isEmpty() ? e.getAttributeNS(APP, "key") : key;
    }

    @Test
    void theCategoriesAreInTheOrderOfTheScreen() throws Exception {
        List<String> categories = new ArrayList<>();
        for (Element e : children(root())) {
            if (e.getTagName().equals("PreferenceCategory")) {
                categories.add(keyOf(e));
            }
        }
        assertEquals(Arrays.asList("home_layout_category", "widgets_category", "bars_category", "all_apps_category",
                "stats_category", "canbus_reader"), categories);
    }

    @Test
    void theAppDrawerCategoryHasItsRowsInTheOrderOfTheBrief() throws Exception {
        for (Element e : children(root())) {
            if ("all_apps_category".equals(keyOf(e))) {
                List<String> rows = new ArrayList<>();
                for (Element row : children(e)) {
                    rows.add(keyOf(row));
                }
                assertEquals(Arrays.asList("all_apps_grid_rows_title", "all_apps_grid_rows", "all_apps_grid_columns_title",
                        "all_apps_grid_columns", "all_apps_textSize", "all_apps_text_color", "all_apps_search",
                        "all_apps_scroll", "drawer_tabs"), rows);
                return;
            }
        }
        assertTrue(false, "no App drawer category");
    }

    @Test
    void theDrawersTextSizeLeftTheHomeScreenLayout() throws Exception {
        for (Element e : children(root())) {
            if ("home_layout_category".equals(keyOf(e))) {
                for (Element row : children(e)) {
                    assertTrue(!"all_apps_textSize".equals(keyOf(row)), "the drawer's text size is under App drawer now");
                }
            }
        }
    }
}
