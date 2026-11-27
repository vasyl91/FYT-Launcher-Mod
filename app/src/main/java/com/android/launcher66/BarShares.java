package com.android.launcher66;

/**
 * How the room of the widget bar is shared between its elements when some of them are hidden or smaller.
 *
 * <p>The elements are the app drawer's button {@code D}, the apps list {@code A}, the music widget {@code M}, the
 * date {@code T} (landscape only) and the weather {@code W}. Each has a usual share of the bar's width. An element
 * that is hidden, or an apps list that is fitted to its icons and so is narrower, gives its room away by the owner's
 * rules (2026-11-25, D-87), and a hidden element gets nothing:
 *
 * <table>
 *   <caption>who gets the room</caption>
 *   <tr><td>T (date)</td><td>M, all of it</td></tr>
 *   <tr><td>W (weather)</td><td>M, all of it</td></tr>
 *   <tr><td>A (hidden, or the room a fitted list leaves)</td><td>T 10 %, W 10 %, M the rest</td></tr>
 *   <tr><td>D (the drawer's button)</td><td>T 10 %, W 10 %, A 40 %, M 40 %</td></tr>
 *   <tr><td>M (music)</td><td>T 10 %, W 10 %, A 80 %</td></tr>
 * </table>
 *
 * The donors are taken in the order T, W, A, M, D, each giving the share it had. A part meant for an element that
 * is not there goes to the "rest" of the same rule when that is there (M for the rules of T, W and A, A for the
 * rule of M, M and A equally for the rule of D); when no element of the rule is there, equally to every element
 * that is. A share that no rule names goes equally to the elements that are shown. The total does not change.
 * One element left gets the whole bar; none left is {@link Result#empty()}. Pure Java, so that it has a test.
 */
public final class BarShares {

    enum Element { DRAWER, APPS, MUSIC, DATE, WEATHER }

    private static final Element[] DONORS = {Element.DATE, Element.WEATHER, Element.APPS, Element.MUSIC, Element.DRAWER};

    /** The widths of the elements after the sharing; 0 for one that is not shown. */
    static final class Result {
        private final float[] mShare = new float[Element.values().length];
        private final boolean[] mShown = new boolean[Element.values().length];

        float share(Element element) {
            return mShare[element.ordinal()];
        }

        boolean shown(Element element) {
            return mShown[element.ordinal()];
        }

        int shownCount() {
            int n = 0;
            for (boolean shown : mShown) {
                n += shown ? 1 : 0;
            }
            return n;
        }

        /** No element is left: the bar has nothing to show. */
        boolean empty() {
            return shownCount() == 0;
        }

        float total() {
            float sum = 0f;
            for (float s : mShare) {
                sum += s;
            }
            return sum;
        }
    }

    private BarShares() {
    }

    /**
     * Whether the widget bar has nothing left to show with these hidden (the settings then turn "Display horizontal
     * bar" off and say so, round 29).
     */
    public static boolean empty(boolean portrait, boolean drawerHidden, boolean appsHidden, boolean musicHidden,
                                boolean dateHidden, boolean weatherHidden) {
        return of(portrait, drawerHidden, appsHidden, appsHidden ? 0f : usual(Element.APPS, portrait), musicHidden,
                dateHidden, weatherHidden).empty();
    }

    // The usual shares are the constraintWidth_percent of custom_layout_two_user in layout-land and layout-port; they
    // are repeated here so that this class needs no other (BarSharesUsualTest holds them to BarCapacity and
    // WidgetBarPlan, which keep the figures the layouts are checked against).
    static final float DRAWER_LAND = 0.09f;
    static final float DRAWER_PORT = 0.10f;
    static final float APPS_LAND = 0.4395f;
    static final float APPS_PORT = 0.4385f;
    static final float MUSIC_LAND = 0.28f;
    static final float MUSIC_PORT = 0.295f;
    static final float DATE_LAND = 0.05f;
    static final float WEATHER_LAND = 0.12f;
    static final float WEATHER_PORT = 0.15f;

    /** The share an element has when nothing is hidden. */
    static float usual(Element element, boolean portrait) {
        switch (element) {
            case DRAWER:
                return portrait ? DRAWER_PORT : DRAWER_LAND;
            case APPS:
                return portrait ? APPS_PORT : APPS_LAND;
            case MUSIC:
                return portrait ? MUSIC_PORT : MUSIC_LAND;
            case DATE:
                return portrait ? 0f : DATE_LAND;
            default:
                return portrait ? WEATHER_PORT : WEATHER_LAND;
        }
    }

    /**
     * @param appsActual the apps list's own width: its usual share, a smaller one when it is fitted to its icons,
     *                   ignored when it is hidden
     */
    static Result of(boolean portrait, boolean drawerHidden, boolean appsHidden, float appsActual,
                     boolean musicHidden, boolean dateHidden, boolean weatherHidden) {
        Result result = new Result();
        boolean[] shown = result.mShown;
        shown[Element.DRAWER.ordinal()] = !drawerHidden;
        shown[Element.APPS.ordinal()] = !appsHidden;
        shown[Element.MUSIC.ordinal()] = !musicHidden;
        shown[Element.DATE.ordinal()] = !dateHidden && !portrait;
        shown[Element.WEATHER.ordinal()] = !weatherHidden;

        float[] share = result.mShare;
        float[] give = new float[share.length];
        for (Element e : Element.values()) {
            float usual = usual(e, portrait);
            if (!shown[e.ordinal()]) {
                // hidden, or not in this orientation: all of its usual share is given away
                give[e.ordinal()] = usual;
            } else if (e == Element.APPS) {
                float actual = Math.max(0f, Math.min(usual, appsActual));
                share[e.ordinal()] = actual;
                give[e.ordinal()] = usual - actual;
            } else {
                share[e.ordinal()] = usual;
            }
        }
        if (result.shownCount() == 0) {
            for (int i = 0; i < share.length; i++) {
                share[i] = 0f;
            }
            return result;
        }
        for (Element donor : DONORS) {
            float amount = give[donor.ordinal()];
            if (amount > 0f) {
                distribute(donor, amount, shown, share);
            }
        }
        return result;
    }

    /** One part of a rule: an element and its share of what the donor gives, in parts of one. */
    private static void distribute(Element donor, float amount, boolean[] shown, float[] share) {
        switch (donor) {
            case DATE:
            case WEATHER:
                toRest(amount, new Element[] {Element.MUSIC}, shown, share);
                break;
            case APPS:
                part(amount * 0.10f, Element.DATE, new Element[] {Element.MUSIC}, shown, share);
                part(amount * 0.10f, Element.WEATHER, new Element[] {Element.MUSIC}, shown, share);
                toRest(amount * 0.80f, new Element[] {Element.MUSIC}, shown, share);
                break;
            case DRAWER:
                part(amount * 0.10f, Element.DATE, new Element[] {Element.MUSIC, Element.APPS}, shown, share);
                part(amount * 0.10f, Element.WEATHER, new Element[] {Element.MUSIC, Element.APPS}, shown, share);
                toRest(amount * 0.40f, new Element[] {Element.APPS}, new Element[] {Element.MUSIC, Element.APPS},
                        shown, share);
                toRest(amount * 0.40f, new Element[] {Element.MUSIC}, new Element[] {Element.MUSIC, Element.APPS},
                        shown, share);
                break;
            default:   // MUSIC
                part(amount * 0.10f, Element.DATE, new Element[] {Element.APPS}, shown, share);
                part(amount * 0.10f, Element.WEATHER, new Element[] {Element.APPS}, shown, share);
                toRest(amount * 0.80f, new Element[] {Element.APPS}, shown, share);
                break;
        }
    }

    /** A named part: to its element if it is shown, else to the rest of the rule. */
    private static void part(float amount, Element to, Element[] rest, boolean[] shown, float[] share) {
        if (shown[to.ordinal()]) {
            share[to.ordinal()] += amount;
        } else {
            toRest(amount, rest, shown, share);
        }
    }

    private static void toRest(float amount, Element[] rest, boolean[] shown, float[] share) {
        toRest(amount, rest, rest, shown, share);
    }

    /**
     * The part {@code to} (of an element of the rule) that is given to {@code to} if it is shown, else equally to
     * the elements of {@code rest} that are, else equally to every element that is shown.
     */
    private static void toRest(float amount, Element[] to, Element[] rest, boolean[] shown, float[] share) {
        int n = 0;
        for (Element e : to) {
            n += shown[e.ordinal()] ? 1 : 0;
        }
        if (n > 0) {
            for (Element e : to) {
                if (shown[e.ordinal()]) {
                    share[e.ordinal()] += amount / n;
                }
            }
            return;
        }
        n = 0;
        for (Element e : rest) {
            n += shown[e.ordinal()] ? 1 : 0;
        }
        if (n > 0) {
            for (Element e : rest) {
                if (shown[e.ordinal()]) {
                    share[e.ordinal()] += amount / n;
                }
            }
            return;
        }
        int all = 0;
        for (boolean s : shown) {
            all += s ? 1 : 0;
        }
        if (all == 0) {
            return;
        }
        for (Element e : Element.values()) {
            if (shown[e.ordinal()]) {
                share[e.ordinal()] += amount / all;
            }
        }
    }
}
