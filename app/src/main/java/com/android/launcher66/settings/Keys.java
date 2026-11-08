package com.android.launcher66.settings;

public final class Keys {
    private Keys() { throw new AssertionError("No instances."); }

    public static final String PIP_REMOVED = "pip_removed";
    public static final String RECREATE = "recreate_view";
    public static final String ACCESIBILITY_SERVICE = "accesibility_service";
    public static final String USER_LAYOUT = "user_layout";
    public static final String USER_INIT_LAYOUT = "user_init_layout";
    public static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    public static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    public static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    public static final String ALL_APPS = "all_apps";
    public static final String ALL_APPS_VISIBLE = "all_apps_visible";
    public static final String STATS_APP_FOREGROUND = "stats_app_foreground";
    public static final String UPDATE_USER_PAGE = "update_user_page";
    public static final String PIP_STARTED = "pip_started";
    public static final String LIST_OPEN = "list_open";
    public static final String LIST_CLOSE = "list_close";
    public static final String OVERVIEW_MODE_OPEN = "overview_mode_open";
    public static final String OVERVIEW_MODE_CLOSE = "overview_mode_close";
    public static final String NIGHT_MODE = "night_mode"; 
    public static final String NIGHT_MODE_LIGHTS = "night_mode_lights";
    public static final String DOWNLOAD_PERCENTAGE = "download_percentage";
    public static final String STATUSBAR = "transparent_statusbar";
    public static final String CREATOR_FIRST = "launcher_creator_first";

    public static final String FAVORITE_CACHE = "favorite_cache";
    public static final String OAUTH_FOR_YOUTUBE_REVANCED = "oauth_for_youtube_revanced";
    public static final String YOUTUBE_REVANCED_KIDS = "youtube_revanced_kids";
    public static final String COPY_PATCH_URL = "copy_patch_url";
    public static final String DEVICE_CHIPSET = "device_chipset";
    public static final String DEVICE_CHIPSET_RULES = "device_chipset_rules";
    public static final String SPOTIFY_CLIENT_ID = "spotify_client_id";
    public static final String OAUTH_FOR_SPOTIFY = "oauth_for_spotify";
    public static final String SPOTIFY_LOGOUT = "spotify_logout";
    public static final String SPOTIFY_ACCESS_TOKEN = "spotify_access_token";
    public static final String SPOTIFY_REFRESH_TOKEN = "spotify_refresh_token";
    public static final String SPOTIFY_TOKEN_EXPIRY = "spotify_token_expiry";
    public static final String SPOTIFY_CODE_VERIFIER = "spotify_code_verifier";
    public static final String SPOTIFY_AUTH_STATE = "spotify_auth_state";
    public static final String SPOTIFY_COPY_URI = "spotify_copy_uri";
    public static final String SPOTIFY_INSTRUCTION = "spotify_instruction";
    public static final String FYT_DATA = "fyt_data"; 

    public static final String DEVICE_SETTINGS = "device_settings";
    public static final String NOTIFICATION_SETTINGS = "notification_settings";
    public static final String ACCESSIBILITY_SETTINGS = "accessibility_settings";
    public static final String WALLPAPER_PICKER = "wallpaper_picker"; 
    public static final String WALLPAPER_PICKER_SOURCE = "wallpaper_picker_source"; 
    public static final String ALL_APPS_TEXT_SIZE = "all_apps_textSize"; 
    public static final String WORKSPACE_TEXT_SIZE = "workspace_textSize";
    /** Before it was split into LAUNCHER_HOME_WAKE and LAUNCHER_HOME_COLD_START; only migrated. */
    public static final String LAUNCHER_HOME = "launcher_home";
    public static final String LAUNCHER_HOME_WAKE = "launcher_home_wake";
    public static final String LAUNCHER_HOME_COLD_START = "launcher_home_cold_start";
    public static final String COLD_START_LAST_APP_DELAY = "cold_start_last_app_delay";
    public static final String AUTOSTART_APPS = "autostart_apps";
    public static final String AUTOSTART_APPS_BY_BOOT_COMPLETED = "autostart_apps_by_boot_completed";
    public static final String DEFAULT_WALLPAPERS = "default_wallpapers";
    public static final String SAVE_DAY_WALLPAPER = "save_day_wallpaper";    
    public static final String SAVE_NIGHT_WALLPAPER = "save_night_wallpaper";
    public static final String BRIGHTNESS_PREF = "brightness";
    public static final String DAY_SEEK_BAR = "day_seek_bar";
    public static final String NIGHT_SEEK_BAR = "night_seek_bar";
    public static final String SUNRISE_CORRECTION = "sunrise_correction";
    public static final String SUNSET_CORRECTION = "sunset_correction";
    public static final String RESET_NIGHT_MODE = "reset_night_mode";
    public static final String LOGCAT_LOCATIONS_INFO = "logcat_locations_info";
    public static final String LOGCAT_SERVICE = "logcat_service";
    public static final String LOGCAT_FULL = "logcat_full";
    public static final String BOOT_LOGCAT = "boot_logcat";
    public static final String LOGCAT_SERVICE_WAKE = "logcat_service_wake";
    public static final String LOGCAT_SERVICE_RUN = "logcat_service_run";
    /** Where the user left the stop logcat button, see LogcatStopButton. */
    public static final String LOGCAT_STOP_X = "logcat_stop_button_x";
    public static final String LOGCAT_STOP_Y = "logcat_stop_button_y";
    public static final String LOGCAT_STOP_SAVED = "logcat_stop_button_saved";
    public static final String LOGCAT_SERVICE_TIMEOUT = "logcat_service_timeout";
    public static final String APP_VERSION_UPDATE = "app_version_update";
    public static final String SHIZUKU_DOWNLOAD = "shizuku_download";

    public static final String DISPLAY_PIP = "display_pip";
    public static final String USER_DATE = "user_date";
    public static final String USER_MUSIC = "user_music";
    public static final String USER_RADIO = "user_radio";
    public static final String USER_STATS = "user_stats";
    public static final String STATS_DISPLAY = "stats_display";
    public static final String DATE_SCREEN = "date_screen";
    public static final String MUSIC_SCREEN = "music_screen";
    public static final String RADIO_SCREEN = "radio_screen";
    public static final String STATS_SCREEN = "stats_screen";
    public static final String STATS_WIDTH = "stats_width";
    /** The text size (px, float) of the statistics window, the same in its three sizes, worked out once. */
    public static final String STATS_FONT_PX = "stats_font_px";
    /** The width (px, int) of the large and the medium statistics window, worked out once. */
    public static final String STATS_WIDTH_LARGE_PX = "stats_width_large_px";
    public static final String STATS_WIDTH_MEDIUM_PX = "stats_width_medium_px";
    /** What the three values above were worked out for (language, screen, font scale); they change with it. */
    public static final String STATS_GEOMETRY_TAG = "stats_geometry_tag";
    public static final String STATS_WIDTH_SELECTOR = "stats_width_selector";
    public static final String STATS_CODES = "stats_codes";
    /** The canbus code of the speed for the fuel estimate; "0" or none = the code reader's, else the GPS. */
    public static final String SPEED_CODE = "speed_code_int";
    public static final String MAIN_SCREEN_STATS = "main_screen_stats";
    public static final String COLOR_PICKER = "color_picker";
    public static final String STATS_BG = "stats_bg";
    /** boolean: we raised maximum_obscuring_opacity_for_touch for the stats window (StatsOverlayAlpha) */
    public static final String STATS_OBSCURING_RAISED = "stats_obscuring_raised";
    /** String: the limit before we raised it; no key = the setting did not exist */
    public static final String STATS_OBSCURING_ORIGINAL = "stats_obscuring_original";
    public static final String BG_DRAWABLE = "bg_drawable";
    public static final String BG_COLOR = "bg_color";
    public static final String BG_COLOR_PICKER = "bg_color_picker";
    public static final String ALPHA_SEEK_BAR = "alpha_seek_bar";
    public static final String APP_LIST = "app_list";
    public static final String APP_STATS_WIDTH = "app_stats_width";
    public static final String APP_STATS_WIDTH_SELECTOR = "app_stats_width_selector";
    public static final String APP_STATS_COORDINATES = "app_stats_coordinates";
    public static final String DISPLAY_CANBUS_READER = "display_canbus_reader";
    public static final String CODES_GUIDE = "codes_guide";
    public static final String SKIP_CODES = "skip_codes";
    public static final String CANBUS_LIBRARY_IMPORT = "canbus_library_import";
    public static final String CANBUS_LIBRARY_EXPORT = "canbus_library_export";
    public static final String CANBUS_LIBRARY_RESET = "canbus_library_reset";
    public static final String EXTRA_STATS_CODES = "extra_stats_codes";
    /** The car's mass (kg) and engine displacement (cm³) for the estimate of the consumption; the names of their fields. */
    public static final String VEHICLE_MASS = "vehicle_mass_code_int";
    public static final String ENGINE_DISPLACEMENT = "engine_displacement_code_int";
    public static final String CMD_INT = "cmdInt_code_int";
    public static final String CMD_ARR = "cmdArr_code_int";
    public static final String CODE_INSPECTOR = "code_inspector";
    public static final String CODE_INSPECTOR_DATA = "code_inspector_data";
    public static final String SKIP_ZERO_CODES = "skip_zero_codes";
    public static final String CODE_INSPECTOR_TIMEOUT = "code_inspector_timeout";
    /** Per car (+ car id): the state of the automatic code check, see CanbusAutoCheckPolicy. */
    public static final String CANBUS_AUTO_CHECK_PREFIX = "canbus_auto_check_";
    /** Per car (+ car id): the fuel and range codes the automatic check found, see AutoCodes. */
    public static final String AUTO_CODES_PREFIX = "auto_codes_";
    // The horizontal and vertical bars were the bottom bar and the left bar: the stored values of their
    // preferences are those former names (users' data), only the names in the code changed.
    public static final String VERTICAL_BAR = "left_bar";
    public static final String WIDGET_BAR = "widget_bar";
    /** The album cover is not shown in the widget bar and the title, artist and buttons take its room. */
    public static final String WIDGET_BAR_NO_COVER = "widget_bar_no_cover";
    /** The date is not shown in the widget bar and the music widget takes its room (landscape only). */
    public static final String WIDGET_BAR_NO_DATE = "widget_bar_no_date";
    /** The weather is not shown in the widget bar and the music widget takes its room. */
    public static final String WIDGET_BAR_NO_WEATHER = "widget_bar_no_weather";
    /**
     * With the date or the weather hidden, the buttons of the music widget are beside the title and
     * artist in two rows (on), or below them as usual (off).
     */
    public static final String WIDGET_BAR_BUTTONS_BESIDE = "widget_bar_buttons_beside";
    /** The texts of the widget bar are as large as the room allows (the usual size otherwise). */
    public static final String WIDGET_BAR_LARGE_TEXT = "widget_bar_large_text";
    /**
     * Old boolean (one line "artist - title"); migrated to WIDGET_BAR_LINE_MODE, once, by
     * LauncherApplication.
     */
    public static final String WIDGET_BAR_ONE_LINE = "widget_bar_one_line";
    /**
     * How the music widget of the bar writes the title and the artist: "two" (the title above the
     * artist), "artist_title" or "title_artist" (one line); see WidgetBarLines.
     */
    public static final String WIDGET_BAR_LINE_MODE = "widget_bar_line_mode";
    /** The buttons of the music widget beside the text are in one row of four (two rows of two otherwise). */
    public static final String WIDGET_BAR_BUTTONS_ONE_LINE = "widget_bar_buttons_one_line";
    public static final String WIDGETS_BACKGROUND = "choose_widgets_background";
    public static final String BAR_BACKGROUND = "choose_bar_background";
    public static final String WIDGETS_SELECTED_BACKGROUND = "widgets_selected_background";
    public static final String BAR_SELECTED_BACKGROUND = "bar_selected_background";
    public static final String VERTICAL_BAR_BACKGROUND = "choose_vertical_bar_background";
    public static final String VERTICAL_BAR_SELECTED_BACKGROUND = "vertical_bar_selected_background";
    public static final String BLACK_BAR = "black_bar";
    public static final String BLACK_WIDGETS = "black_widgets";
    public static final String START_PAGE = "start_page";
    public static final String LAYOUT_MARGIN = "layout_margin";
    /** The horizontal bar is on every page of the home screen, not only on the first (HorizontalBarPlacement). */
    /** The horizontal bar is at the top of the screen (the stored key is new, it has no former name). */
    public static final String HORIZONTAL_BAR_TOP = "horizontal_bar_top";
    /** The auto-hide handle is on the right edge of the screen (opened with a swipe to the left). */
    public static final String EDGE_HANDLE_RIGHT = "edge_handle_right";
    /** The vertical bar is at the right edge of the screen. */
    public static final String VERTICAL_BAR_RIGHT = "vertical_bar_right";
    public static final String HORIZONTAL_BAR_EVERY_PAGE = "bottom_bar_every_page";
    public static final String AUTO_HIDE_HORIZONTAL_BAR = "auto_hide_bottom_bar";
    public static final String AUTO_HIDE_TIMEOUT = "auto_hide_timeout";
    public static final String RESIZABLE_HORIZONTAL_BAR = "resizable_bottom_bar";
    public static final String HORIZONTAL_BAR_HEIGHT = "bottom_bar_height"; 
    public static final String HORIZONTAL_BAR_HEIGHT_PORT = "bottom_bar_height_port";
    public static final String HORIZONTAL_BAR_HEIGHT_LAND = "bottom_bar_height_land";

    public static final String PIP_DUAL = "pip_dual";
    public static final String PIP_FIRST = "pip_first";
    public static final String PIP_SECOND = "pip_second";
    public static final String PIP_THIRD = "pip_third";
    public static final String PIP_FOURTH = "pip_fourth";
    public static final String RESTART_PIP = "restart_pip";
    public static final String PIP_DUAL_KEY = "pipDual";
    public static final String PIP_FIRST_KEY = "pipFirst";
    public static final String PIP_SECOND_KEY = "pipSecond";
    public static final String PIP_THIRD_KEY = "pipThird";
    public static final String PIP_FOURTH_KEY = "pipFourth";
    public static final String PIP_FIRST_MODE  = "pip_first_mode";
    public static final String PIP_SECOND_MODE = "pip_second_mode";
    public static final String PIP_THIRD_MODE  = "pip_third_mode";
    public static final String PIP_FOURTH_MODE = "pip_fourth_mode";
    public static final String PIP_DUAL_SCREEN = "pip_dual_screen"; 
    public static final String PIP_FIRST_SCREEN = "pip_first_screen"; 
    public static final String PIP_SECOND_SCREEN = "pip_second_screen"; 
    public static final String PIP_THIRD_SCREEN = "pip_third_screen"; 
    public static final String PIP_FOURTH_SCREEN = "pip_fourth_screen"; 
    public static final String PINNED_PIP_SCREEN = "pinned_pip_screen";
    public static final String PIP_FIRST_PACKAGE = "pip_first_package";
    public static final String PIP_SECOND_PACKAGE = "pip_second_package";
    public static final String PIP_THIRD_PACKAGE = "pip_third_package";
    public static final String PIP_FOURTH_PACKAGE = "pip_fourth_package";
    public static final String FAB_OVERLAY_BUTTON = "fab_overlay_button";
    public static final String FAB_OVERLAY_BUTTON_LEFT = "fab_overlay_button_left";
    public static final String FAB_OVERLAY_BUTTON_RIGHT = "fab_overlay_button_right";
    public static final String BLOCK_FLOATING_BUTTON = "block_floating_button";
    public static final String EXTENDED_DIVIDER = "extended_divider";
    /** Old boolean (true = icon colour, false = night mode); migrated to COVER_SPLASH_MODE. */
    public static final String COVER_SPLASH = "cover_splash";
    public static final String COVER_SPLASH_MODE = "cover_splash_mode";
    public static final String COVER_SPLASH_ICON = "icon";
    public static final String COVER_SPLASH_NIGHT_MODE = "night_mode";
    public static final String COVER_SPLASH_BLACK = "black";
    public static final String COVER_SPLASH_TRANSPARENT = "transparent";
    public static final String SWIPE_DETECTOR = "swipe_detector";

    public static final String RECYCLER_APP = "recycler_app";
    public static final String RECYCLER_APP_MAP = "recycler_app_map";
    public static final String ALLAPPS = "ALLAPPS";
    public static final String FUELSTATS = "FUELSTATS";

    public static final String KEY_FAB_X = "fab_x";
    public static final String KEY_FAB_Y = "fab_y";
    public static final String KEY_POSITION_SAVED = "position_saved";
    public static final String KEY_FAB_X_LEFT = "fab_x_left";
    public static final String KEY_FAB_Y_LEFT = "fab_y_left";
    public static final String KEY_POSITION_SAVED_LEFT = "position_saved_left";
    public static final String KEY_FAB_X_RIGHT = "fab_x_right";
    public static final String KEY_FAB_Y_RIGHT = "fab_y_right";
    public static final String KEY_POSITION_SAVED_RIGHT = "position_saved_right";
    /** The note about com.syu.media's screen (syu_media_favorite_note) has been shown once, ever. */
    public static final String SYU_MEDIA_FAVORITE_NOTE_SHOWN = "syu_media_favorite_note_shown";
    public static final String SHOW_FAB = "show_fab";
    public static final String HIDE_FAB = "hide_fab";
}