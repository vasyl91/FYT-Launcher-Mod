package com.android.launcher66;

/**
 * How the widgets and the bar look under the settings "Widget text and button color", "Horizontal bar text and button
 * color" (each a colour of the user's choice, or none: the look the views have by themselves) and "Choose background
 * for widgets". Pure Java, so that the rule has a test.
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

    /** No colour chosen: the views keep their own (ViewTint.NONE). */
    static final int NO_TINT = 0;
    /** The colour the old on/off setting "black" stood for. */
    static final int BLACK = 0xFF000000;

    private final int widgetsTint;
    private final int barTint;
    private final String background;
    private final BackgroundChoice choice;

    private WidgetStyle(int widgetsTint, int barTint, String background, BackgroundChoice choice) {
        this.widgetsTint = widgetsTint;
        this.barTint = barTint;
        this.background = background;
        this.choice = choice;
    }

    /** @param widgetsBackground the stored name of the chosen background, null or "bg_custom" for the default */
    static WidgetStyle of(int widgetsTint, int barTint, String widgetsBackground) {
        return of(widgetsTint, barTint,
                BackgroundChoice.of(widgetsBackground, DEFAULT_BACKGROUND_RESOURCE, false, 0));
    }

    /** @param widgetsBackground the background chosen for the widgets: a picture or the user's own colour */
    static WidgetStyle of(int widgetsTint, int barTint, BackgroundChoice widgetsBackground) {
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
        return new WidgetStyle(widgetsTint, barTint, name, widgetsBackground);
    }

    /** The background of the widgets as chosen, for the one place that draws it (BarBackground). */
    BackgroundChoice backgroundChoice() {
        return choice;
    }

    /** The colour for this role, or {@link #NO_TINT} for the one the view has by itself. */
    int tint(Role role) {
        switch (role) {
            case WIDGET_TEXT:
            case WIDGET_BUTTON:
            case WIDGET_PROGRESS:
                return widgetsTint;
            default:
                return barTint;
        }
    }

    /**
     * What the old settings become, once: "black" on was the colour black, and "black" off ("White" in the
     * settings) was no colour at all, the views' own look, which is kept as no tint so that nothing changes on
     * the screen.
     */
    static int tintOfLegacyBlack(boolean black) {
        return black ? BLACK : NO_TINT;
    }

    /**
     * Whether something drawn beside this tint should be dark too (the strip of the edge handle is black or
     * white): only a chosen colour that is itself dark.
     */
    static boolean isDark(int tint) {
        if (tint == NO_TINT) {
            return false;
        }
        int r = (tint >> 16) & 0xFF;
        int g = (tint >> 8) & 0xFF;
        int b = tint & 0xFF;
        return (r * 299 + g * 587 + b * 114) / 1000 < 128;
    }

    private static String name(int tint) {
        return tint == NO_TINT ? "default" : String.format("#%06X", tint & 0xFFFFFF);
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
        return "widgets " + name(widgetsTint) + ", bar " + name(barTint) + ", background " + background;
    }
}
