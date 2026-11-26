package com.android.launcher66;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The preference keys that belong to the layout creator: every key of {@code res/xml/creator_preferences.xml}, and the
 * keys that rows of that screen store under names of their own.
 *
 * <p>The rule (the owner's, 2026-11-25, D-85): "Stock layout" turns off everything from LAYOUT CREATOR, the new
 * settings of every round included. The values of these keys are stored, and come back when the creator is
 * turned on again, but while the stock layout is on the launcher reads the default of each ({@link CreatorPrefs}).
 * Every new row of the creator's screen must be here: {@code CreatorKeysTest} compares this set with the XML
 * and fails when a row is missing, so that no setting can slip past "Stock layout". Pure Java, so that it has a test.
 */
public final class CreatorKeys {

    /**
     * Keys that rows of the creator's screen store under other names than their own (their own key is that of a row
     * that stores nothing, a title, a note, or a button). Each line says which row.
     */
    static final Set<String> STORED_ELSEWHERE = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            // "Rows" and "Columns": cells along the long and the short edge (GridSeekBarPreference)
            "workspace_grid_long", "workspace_grid_short",
            // the colour rows of "Choose background for ..." and "Set ... text and button color"
            "widgets_selected_background", "bar_selected_background", "vertical_bar_selected_background",
            "stats_selected_background",
            "widgets_custom_background_color", "bar_custom_background_color",
            "vertical_bar_custom_background_color", "stats_custom_background_color",
            "widgets_tint_color", "bar_tint_color",
            // the horizontal bar's height and the vertical bar's width, the icons on the bars, the order of the
            // horizontal bar's elements: each stored per orientation
            "bottom_bar_height_port", "bottom_bar_height_land",
            "vertical_bar_width_port", "vertical_bar_width_land",
            "horizontal_bar_icons_port", "horizontal_bar_icons_land",
            "vertical_bar_icons_port", "vertical_bar_icons_land",
            "horizontal_bar_order_port", "horizontal_bar_order_land"
    )));

    /** The keys of the creator screen's XML, as the test finds them there (kept in step by CreatorKeysTest). */
    static final Set<String> XML_KEYS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            "workspace_grid_rows_title", "workspace_grid_rows", "workspace_grid_rows_note",
            "workspace_grid_columns_title", "workspace_grid_columns", "workspace_grid_columns_note",
            "transparent_statusbar", "start_page", "all_apps_textSize", "workspace_textSize", "theme_accent_color",
            "display_pip",
            "restart_pip", "fab_overlay_button", "fab_overlay_button_left", "fab_overlay_button_right",
            "extended_divider", "cover_splash_mode", "swipe_detector", "user_date", "user_music", "user_radio",
            "choose_widgets_background", "choose_widgets_tint", "layout_margin", "horizontal_bar_top",
            "bottom_bar_every_page", "auto_hide_bottom_bar", "auto_hide_timeout", "edge_handle_right",
            "resizable_bottom_bar", "bottom_bar_height", "horizontal_bar_icons_title", "horizontal_bar_icons",
            "choose_bar_background", "choose_bar_tint", "horizontal_bar_order", "widget_bar", "widget_bar_no_cover",
            "widget_bar_no_date", "widget_bar_no_weather", "widget_bar_no_apps", "widget_bar_fit_apps",
            "widget_bar_buttons_beside", "widget_bar_buttons_one_line", "widget_bar_line_mode",
            "widget_bar_large_text", "left_bar", "vertical_bar_right", "vertical_bar_every_page",
            "resizable_vertical_bar", "vertical_bar_width", "vertical_bar_icons_title", "vertical_bar_icons",
            "choose_vertical_bar_background", "user_stats", "stats_display", "stats_codes", "extra_stats_codes",
            "main_screen_stats", "choose_stats_background", "color_picker", "app_list", "app_stats_coordinates",
            "display_canbus_reader", "codes_guide", "skip_codes", "canbus_library_import", "canbus_library_export",
            "canbus_library_reset", "code_inspector", "code_inspector_data", "skip_zero_codes"
    )));

    private CreatorKeys() {
    }

    /** Whether a key belongs to the layout creator. */
    public static boolean contains(String key) {
        return key != null && (XML_KEYS.contains(key) || STORED_ELSEWHERE.contains(key));
    }
}
