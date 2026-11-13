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
    private final BackgroundChoice choice;

    private WidgetStyle(boolean blackWidgets, boolean blackBar, String background, BackgroundChoice choice) {
        this.blackWidgets = blackWidgets;
        this.blackBar = blackBar;
        this.background = background;
        this.choice = choice;
    }

    /** @param widgetsBackground the stored name of the chosen background, null or "bg_custom" for the default */
    static WidgetStyle of(boolean blackWidgets, boolean blackBar, String widgetsBackground) {
        return of(blackWidgets, blackBar,
                BackgroundChoice.of(widgetsBackground, DEFAULT_BACKGROUND_RESOURCE, false, 0));
    }

    /** @param widgetsBackground the background chosen for the widgets: a picture or the user's own colour */
    static WidgetStyle of(boolean blackWidgets, boolean blackBar, BackgroundChoice widgetsBackground) {
        String name;
        if (widgetsBackground.kind == BackgroundChoice.Kind.CUSTOM) {
            name = BackgroundChoice.CUSTOM;
        } else if (widgetsBackground.kind == BackgroundChoice.Kind.NONE) {
            name = BackgroundChoice.NONE;
        } else {
            String picture = widgetsBackground.picture;
            boolean isDefault = picture == null || picture.isEmpty() || DEFAULT_BACKGROUND_RESOURCE.equals(picture);
            name = isDefault ? DEFAULT_BACKGROUND : picture;
        }
        return new WidgetStyle(blackWidgets, blackBar, name, widgetsBackground);
    }

    /** The background of the widgets as chosen, for the one place that draws it (BarBackground). */
    BackgroundChoice backgroundChoice() {
        return choice;
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

    /**
     * The name of the resource of the chosen background, {@link #DEFAULT_BACKGROUND}, or the stored word for the
     * user's own colour ({@link BackgroundChoice#CUSTOM}).
     */
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
