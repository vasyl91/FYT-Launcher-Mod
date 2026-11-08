package com.android.launcher66;

/**
 * How the widgets and the bar look under the settings "Widget text and button color" (black or default), "Bar text and
 * button color" and "Choose background for widgets". Pure Java, so that the rule has a test.
 *
 * <p>R2: a setting of look works on the views that are already on the screen, through one place in the code
 * ({@link WidgetStyler}); it does not depend on the screen being rebuilt; the colour is set in both directions; and
 * no code changes a colour filter of a drawable from the resources (its state is shared by every user of the
 * resource), the colour is a property of the view ({@link ViewTint}).
 */
final class WidgetStyle {

    /** What a colour is for. The widgets' ones follow "Widget text and button color", the bar's "Bar ...". */
    enum Role { WIDGET_TEXT, WIDGET_BUTTON, WIDGET_PROGRESS, BAR_TEXT, BAR_BUTTON }

    /** The background of the widgets when none was chosen: bg_custom, the one the layouts give them. */
    static final String DEFAULT_BACKGROUND = "DEFAULT";
    /** The resource of the default background. */
    static final String DEFAULT_BACKGROUND_RESOURCE = "bg_custom";

    private final boolean blackWidgets;
    private final boolean blackBar;
    private final String background;

    private WidgetStyle(boolean blackWidgets, boolean blackBar, String background) {
        this.blackWidgets = blackWidgets;
        this.blackBar = blackBar;
        this.background = background;
    }

    /** @param widgetsBackground the stored name of the chosen background, null or "bg_custom" for the default */
    static WidgetStyle of(boolean blackWidgets, boolean blackBar, String widgetsBackground) {
        boolean isDefault = widgetsBackground == null || widgetsBackground.isEmpty()
                || DEFAULT_BACKGROUND_RESOURCE.equals(widgetsBackground);
        return new WidgetStyle(blackWidgets, blackBar, isDefault ? DEFAULT_BACKGROUND : widgetsBackground);
    }

    /** Whether the colour for this role is black; else it is the default one the view had. */
    boolean black(Role role) {
        switch (role) {
            case WIDGET_TEXT:
            case WIDGET_BUTTON:
            case WIDGET_PROGRESS:
                return blackWidgets;
            default:
                return blackBar;
        }
    }

    /** The name of the resource of the chosen background, or {@link #DEFAULT_BACKGROUND}. */
    String background() {
        return background;
    }

    boolean defaultBackground() {
        return DEFAULT_BACKGROUND.equals(background);
    }

    @Override
    public String toString() {
        return "widgets " + (blackWidgets ? "black" : "default") + ", bar " + (blackBar ? "black" : "default")
                + ", background " + background;
    }
}
