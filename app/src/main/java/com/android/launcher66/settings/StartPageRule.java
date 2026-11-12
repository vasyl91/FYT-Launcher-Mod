package com.android.launcher66.settings;

/**
 * The start page ("Set the start page") always names a page that exists.
 *
 * <p>The rule, in three places:
 * <ul>
 *   <li>the settings accept a number only from 1 to the number of pages; a number past the last page is
 *       refused and the stored value stays ({@link #accepts});</li>
 *   <li>the home screen never trusts the stored text: a missing, broken or out-of-range value means the first
 *       page ({@link #effective});</li>
 *   <li>when the pages are planned at a load and the stored page is no longer there (pages were removed), the
 *       preference itself is put back to the first page, so the wrong number does not come back after a
 *       restart ({@code WorkspaceScreenPlan}).</li>
 * </ul>
 * Pages are counted from 1, as the user types them; page 1 is the user page. Pure Java, so that it has a test.
 */
public final class StartPageRule {

    /** The page used when the stored one cannot be. */
    public static final int FIRST_PAGE = 1;

    private StartPageRule() {
    }

    /** Whether the typed number is a page of a home screen with {@code pageCount} pages. */
    public static boolean accepts(int typed, int pageCount) {
        return typed >= FIRST_PAGE && typed <= Math.max(FIRST_PAGE, pageCount);
    }

    /**
     * The page to start on, from the stored text.
     *
     * @param stored    the preference's text, may be null or not a number
     * @param pageCount the number of pages that exist
     */
    public static int effective(String stored, int pageCount) {
        int page = parse(stored);
        return accepts(page, pageCount) ? page : FIRST_PAGE;
    }

    /** The number in the text, or 0 when there is none. */
    public static int parse(String stored) {
        if (stored == null) {
            return 0;
        }
        try {
            return Integer.parseInt(stored.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * The pages the settings may offer during one visit: those the launcher has, and those that the
     * elements switched on in this visit will create when the settings are left.
     *
     * @param launcherPages      the pages of the launcher as last loaded
     * @param highestElementPage the highest page of an element that is switched on, 0 if none
     */
    public static int knownPages(int launcherPages, int highestElementPage) {
        return Math.max(FIRST_PAGE, Math.max(launcherPages, highestElementPage));
    }
}
