package com.android.launcher66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The order of the horizontal bar's elements from left to right, chosen in the settings ("Bars", the owner,
 * 2026-11-20), one for portrait and one for landscape (Keys.HORIZONTAL_BAR_ORDER_PORT / _LAND). Nothing stored is
 * the order the bar always had: the app drawer button, the apps, the music, the date, the weather.
 *
 * <p>The rules:
 * <ul>
 *   <li>The stored order holds every element once; one the settings hide keeps its place in it, so it comes back
 *       where it was ({@link #merge}).</li>
 *   <li>The bar shows the elements its settings and orientation leave ({@link #shown}): without the widget bar
 *       only the app drawer button and the apps, in portrait no date (its layout has none), no date, weather or
 *       apps where they are hidden (the apps only with the widget bar).</li>
 *   <li>The first element shown lies at the bar's left edge; each next one is chained between the one before it
 *       and the one after it, the last to the bar's right edge ({@link #anchors}). That is exactly how the bar's
 *       window laid out the old order (Workspace.forceOriginalSizesLayoutTwo), so the default order lies where it
 *       did, and the page's own bar now lies exactly as the window.</li>
 * </ul>
 *
 * <p>Plain Java, tested; BarOrderLayout applies it to the views.
 */
public final class BarOrder {

    public enum Element {
        DRAWER("drawer"), APPS("apps"), MUSIC("music"), DATE("date"), WEATHER("weather");

        public final String stored;

        Element(String stored) {
            this.stored = stored;
        }

        static Element of(String stored) {
            for (Element e : values()) {
                if (e.stored.equals(stored)) {
                    return e;
                }
            }
            return null;
        }
    }

    /** The order the bar always had. */
    public static final List<Element> DEFAULT = Collections.unmodifiableList(java.util.Arrays.asList(Element.values()));

    /** Where one element is tied on the left and on the right: another element, or the bar's edge (null). */
    public static final class Anchor {
        public final Element element;
        /** The element before it; null: the bar's left edge. */
        public final Element start;
        /** Whether its right side is tied at all (the first element's is not). */
        public final boolean endTied;
        /** The element after it; null with {@link #endTied}: the bar's right edge. */
        public final Element end;

        Anchor(Element element, Element start, boolean endTied, Element end) {
            this.element = element;
            this.start = start;
            this.endTied = endTied;
            this.end = end;
        }

        @Override
        public String toString() {
            return element + "[" + (start == null ? "|" : start) + " .. "
                    + (!endTied ? "-" : end == null ? "|" : end) + "]";
        }
    }

    private BarOrder() {
    }

    /** The stored order: known elements in their order, each once, the missing ones after them in the default order. */
    public static List<Element> parse(String stored) {
        List<Element> order = new ArrayList<>();
        if (stored != null) {
            for (String part : stored.split(",")) {
                Element e = Element.of(part.trim());
                if (e != null && !order.contains(e)) {
                    order.add(e);
                }
            }
        }
        for (Element e : DEFAULT) {
            if (!order.contains(e)) {
                order.add(e);
            }
        }
        return order;
    }

    public static String format(List<Element> order) {
        StringBuilder out = new StringBuilder();
        for (Element e : order) {
            if (out.length() > 0) {
                out.append(',');
            }
            out.append(e.stored);
        }
        return out.toString();
    }

    /**
     * The elements the bar shows, in their order.
     *
     * @param widgetBar the widget bar is on (else the bar holds only the app drawer button and the apps)
     * @param portrait  the portrait bar, which has no date
     * @param noDate    "hide the date"
     * @param noWeather "hide the weather"
     * @param noApps    "hide the apps", which counts only with the widget bar
     */
    public static List<Element> shown(List<Element> order, boolean widgetBar, boolean portrait, boolean noDate,
                                      boolean noWeather, boolean noApps) {
        return shown(order, widgetBar, portrait, noDate, noWeather, noApps, false);
    }

    /**
     * As above; {@code noMusic}: "Hide the music widget" (round 29), which counts only with the widget bar. A hidden
     * drawer button stays in the order at no width (WidgetBarLayout.drawerHidden): the others are tied to it.
     */
    public static List<Element> shown(List<Element> order, boolean widgetBar, boolean portrait, boolean noDate,
                                      boolean noWeather, boolean noApps, boolean noMusic) {
        List<Element> shown = new ArrayList<>();
        for (Element e : order) {
            if (e == Element.DRAWER || e == Element.APPS && !(widgetBar && noApps)
                    || widgetBar && (e == Element.MUSIC && !noMusic
                    || e == Element.DATE && !portrait && !noDate
                    || e == Element.WEATHER && !noWeather)) {
                shown.add(e);
            }
        }
        return shown;
    }

    /**
     * The whole order after the shown elements were put in a new order: they take the places the shown elements had,
     * in their new order; the hidden ones stay where they were.
     */
    public static List<Element> merge(List<Element> full, List<Element> reorderedShown) {
        List<Element> merged = new ArrayList<>(full);
        int next = 0;
        for (int i = 0; i < merged.size() && next < reorderedShown.size(); i++) {
            if (reorderedShown.contains(merged.get(i))) {
                merged.set(i, reorderedShown.get(next++));
            }
        }
        return merged;
    }

    /** Where each shown element is tied (see the rules). */
    public static List<Anchor> anchors(List<Element> shown) {
        List<Anchor> anchors = new ArrayList<>();
        for (int i = 0; i < shown.size(); i++) {
            Element start = i == 0 ? null : shown.get(i - 1);
            boolean endTied = i > 0;
            Element end = i + 1 < shown.size() ? shown.get(i + 1) : null;
            anchors.add(new Anchor(shown.get(i), start, endTied, end));
        }
        return anchors;
    }
}
