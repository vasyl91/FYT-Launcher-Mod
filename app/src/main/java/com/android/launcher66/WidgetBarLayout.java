package com.android.launcher66;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.android.launcher66.settings.Keys;

/**
 * Hides the date and the weather of the widget bar when the settings say so, and gives their room
 * to the music widget; fits the apps list to its icons and gives its room to the widgets
 * (WidgetBarPlan has the rules). With the app drawer button or the music widget hidden (round 29) every element's
 * width comes from the one rule of BarShares instead; without them hidden nothing of that path runs, so the bar is as
 * it was. One piece of code for the four layouts (custom_layout_two_user and
 * custom_layout_two_user_vertical, in layout-land and layout-port), for the bar of the first page and
 * for the overlay of the auto-hide bar.
 *
 * <p>It runs on a freshly inflated bar, before any view of the music widget is looked up and
 * bound: when the buttons go beside the text the music widget is replaced by its wide variant
 * (music_bar_content_wide), whose views have the same ids. A change of the settings rebuilds the
 * bar anyway. Main thread only.
 */
final class WidgetBarLayout {

    private WidgetBarLayout() {
    }

    static boolean dateHidden(SharedPreferences prefs, boolean portrait) {
        return WidgetBarPlan.dateHidden(prefs.getBoolean(Keys.WIDGET_BAR_NO_DATE, false), portrait);
    }

    static boolean weatherHidden(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.WIDGET_BAR_NO_WEATHER, false);
    }

    /**
     * "Hide the app drawer button" (round 29, E2 of round 28; a creator setting): the button takes no room and no tap,
     * and its room is shared by BarShares. It stays VISIBLE at no width, since the auto-hide bar tells by it whether the
     * bar is shown, and the order of the bar ties the elements to it.
     */
    static boolean drawerHidden(SharedPreferences prefs) {
        return prefs != null && prefs.getBoolean(Keys.USER_LAYOUT, false)
                && CreatorPrefs.of(prefs).getBoolean(Keys.HORIZONTAL_BAR_NO_DRAWER, false);
    }

    /** "Hide the music widget" (round 29, E3 of round 28): the widget bar shows no music widget, its room shared. */
    static boolean musicHidden(SharedPreferences prefs) {
        return prefs != null && prefs.getBoolean(Keys.USER_LAYOUT, false) && prefs.getBoolean(Keys.WIDGET_BAR, false)
                && CreatorPrefs.of(prefs).getBoolean(Keys.WIDGET_BAR_NO_MUSIC, false);
    }

    /** The elements' shares by the one rule (BarShares), with what is hidden now. */
    static BarShares.Result barShares(SharedPreferences prefs, boolean portrait) {
        int[] icons = appIcons(prefs, portrait);
        boolean noApps = appsHidden(prefs);
        float apps = WidgetBarPlan.appsShare(portrait, noApps, fitApps(prefs), icons[0], icons[1]);
        return BarShares.of(portrait, drawerHidden(prefs), noApps, apps, musicHidden(prefs), dateHidden(prefs, portrait),
                weatherHidden(prefs));
    }

    /**
     * How much wider than usual the apps list is with the drawer button or the music widget hidden (BarShares), for the
     * number of icons it has room for (BarCapacity); 1 otherwise. Counted at the list's usual width, not fitted: the
     * room is what decides the fitting.
     */
    static float appsWidthFactor(SharedPreferences prefs, boolean portrait) {
        if (!(drawerHidden(prefs) || musicHidden(prefs)) || appsHidden(prefs)) {
            return 1f;
        }
        float usual = WidgetBarPlan.usualApps(portrait);
        BarShares.Result r = BarShares.of(portrait, drawerHidden(prefs), false, usual, musicHidden(prefs),
                dateHidden(prefs, portrait), weatherHidden(prefs));
        return usual > 0f ? Math.max(1f, r.share(BarShares.Element.APPS) / usual) : 1f;
    }

    /** The drawer button out of the way: no width, no tap (see drawerHidden). */
    private static void hideDrawer(ConstraintLayout root, ConstraintSet set) {
        View drawer = root.findViewById(R.id.rl_allapps);
        if (drawer == null) {
            return;
        }
        // setOnClickListener() makes a view clickable, even with null: first, then not clickable
        drawer.setOnClickListener(null);
        drawer.setClickable(false);
        drawer.setFocusable(false);
        set.constrainPercentWidth(R.id.rl_allapps, 0f);
        set.constrainWidth(R.id.rl_allapps, 0);
    }

    /**
     * The bar without the widgets (custom_layout_one_user) with "Hide the app drawer button": the apps list gets the
     * button's room as well.
     */
    static void applyPlain(View bar, SharedPreferences prefs) {
        if (!drawerHidden(prefs) || !(bar instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout root = (ConstraintLayout) bar;
        View drawer = root.findViewById(R.id.rl_allapps);
        View apps = root.findViewById(R.id.recycler_view);
        if (drawer == null || apps == null
                || !(drawer.getLayoutParams() instanceof ConstraintLayout.LayoutParams)
                || !(apps.getLayoutParams() instanceof ConstraintLayout.LayoutParams)) {
            return;
        }
        float total = ((ConstraintLayout.LayoutParams) drawer.getLayoutParams()).matchConstraintPercentWidth
                + ((ConstraintLayout.LayoutParams) apps.getLayoutParams()).matchConstraintPercentWidth;
        ConstraintSet set = new ConstraintSet();
        set.clone(root);
        hideDrawer(root, set);
        set.constrainPercentWidth(R.id.recycler_view, Math.min(1f, total));
        set.applyTo(root);
    }

    /**
     * The widget bar with the drawer button or the music widget hidden: every element's width by the one rule
     * (BarShares), the hidden ones out of the way.
     */
    private static boolean applyShared(ConstraintLayout root, LayoutInflater inflater, SharedPreferences prefs,
                                       boolean portrait) {
        boolean noDate = dateHidden(prefs, portrait);
        boolean noWeather = weatherHidden(prefs);
        boolean noApps = appsHidden(prefs);
        boolean noMusic = musicHidden(prefs);
        BarShares.Result r = barShares(prefs, portrait);
        View date = root.findViewById(R.id.bar_widget_date);
        View weather = root.findViewById(R.id.bar_widget_weather);
        View apps = root.findViewById(R.id.recycler_view);
        ViewGroup music = root.findViewById(R.id.rl_music_two);
        if (noDate && date != null) {
            date.setVisibility(View.GONE);
        }
        if (noWeather && weather != null) {
            weather.setVisibility(View.GONE);
        }
        if (noApps && apps != null) {
            apps.setVisibility(View.GONE);
        }
        if (music != null) {
            if (noMusic) {
                music.setVisibility(View.GONE);
            } else {
                if (buttonsBeside(prefs, portrait)) {
                    music.removeAllViews();
                    inflater.inflate(R.layout.music_bar_content_wide, music, true);
                }
                View cover = music.findViewById(R.id.iv_album_bg_two);
                if (coverHidden(prefs) && cover != null) {
                    cover.setVisibility(View.GONE);
                }
            }
        }
        ConstraintSet set = new ConstraintSet();
        set.clone(root);
        if (r.shown(BarShares.Element.DRAWER)) {
            set.constrainPercentWidth(R.id.rl_allapps, r.share(BarShares.Element.DRAWER));
        } else {
            hideDrawer(root, set);
        }
        if (!noApps && apps != null) {
            set.constrainPercentWidth(R.id.recycler_view, r.share(BarShares.Element.APPS));
        }
        if (!noMusic && music != null) {
            set.constrainPercentWidth(R.id.rl_music_two, r.share(BarShares.Element.MUSIC));
        }
        if (date != null && r.shown(BarShares.Element.DATE)) {
            set.constrainPercentWidth(R.id.bar_widget_date, r.share(BarShares.Element.DATE));
        }
        if (weather != null && r.shown(BarShares.Element.WEATHER)) {
            set.constrainPercentWidth(R.id.bar_widget_weather, r.share(BarShares.Element.WEATHER));
        }
        if (portrait) {
            // As high as at their usual width ("H,"), so the bar and the icons keep their height
            if (!noApps && apps != null) {
                set.setDimensionRatio(R.id.recycler_view, "H," + WidgetBarPlan.keptRatio(
                        WidgetBarPlan.APPS_RATIO_PORT, WidgetBarPlan.usualApps(true), r.share(BarShares.Element.APPS)));
            }
            if (weather != null && r.shown(BarShares.Element.WEATHER)) {
                set.setDimensionRatio(R.id.bar_widget_weather, "H," + WidgetBarPlan.keptRatio(
                        WidgetBarPlan.WEATHER_RATIO_PORT, WidgetBarPlan.usualWeather(true),
                        r.share(BarShares.Element.WEATHER)));
            }
        }
        set.applyTo(root);
        return true;
    }

    static boolean coverHidden(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.WIDGET_BAR_NO_COVER, false);
    }

    /** "Hide the apps": the bar shows no apps list (WidgetBarPlan.appsHidden: only in the user layout's widget bar). */
    static boolean appsHidden(SharedPreferences prefs) {
        return prefs != null && WidgetBarPlan.appsHidden(prefs.getBoolean(Keys.USER_LAYOUT, false),
                prefs.getBoolean(Keys.WIDGET_BAR, false), prefs.getBoolean(Keys.WIDGET_BAR_NO_APPS, false));
    }

    /**
     * What the bar's apps list is when it is shown: VISIBLE, or GONE while it is hidden. Every place that shows the
     * list again (its setup, the end of the auto-hide, the return to the home screen) asks this, so a hidden list
     * stays hidden.
     */
    static int appsListVisibility(SharedPreferences prefs) {
        return appsHidden(prefs) || !horizontalDisplayed(prefs) ? View.GONE : View.VISIBLE;
    }

    /**
     * "Display horizontal bar" (a creator setting, on by default): off, nothing of the bar is shown, its apps list
     * neither, which the bars' set-up and the home screen's recovery showed again (the owner on the A55, 2026-11-27).
     */
    static boolean horizontalDisplayed(SharedPreferences prefs) {
        return prefs == null || CreatorPrefs.of(prefs).getBoolean(Keys.DISPLAY_HORIZONTAL_BAR, true);
    }

    /** "Fit the apps to their icons" (only with the widget bar, where this class is used). */
    static boolean fitApps(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.WIDGET_BAR_FIT_APPS, false);
    }

    /** The apps list's icons now: {shown, room}, as the launcher counts them (BarCapacity, BarIconCount). */
    static int[] appIcons(SharedPreferences prefs, boolean portrait) {
        int room = BarCapacity.bottomCapacity(prefs,
                portrait ? Configuration.ORIENTATION_PORTRAIT : Configuration.ORIENTATION_LANDSCAPE, true, true);
        int shown = BarIconCount.shown(BarCapacity.chosen(prefs, true, portrait), room);
        return new int[] {shown, room};
    }

    /** The widths of the bar's elements with these settings, for the page's bar and for the window. */
    static WidgetBarPlan.Shares shares(SharedPreferences prefs, boolean portrait) {
        int[] icons = appIcons(prefs, portrait);
        float apps = WidgetBarPlan.appsShare(portrait, appsHidden(prefs), fitApps(prefs), icons[0], icons[1]);
        return WidgetBarPlan.shares(portrait, dateHidden(prefs, portrait), weatherHidden(prefs), apps);
    }

    static boolean buttonsBeside(SharedPreferences prefs, boolean portrait) {
        return WidgetBarPlan.buttonsBeside(dateHidden(prefs, portrait), weatherHidden(prefs),
                coverHidden(prefs), prefs.getBoolean(Keys.WIDGET_BAR_BUTTONS_BESIDE, true));
    }

    /** The title and artist as the user arranged them, in whichever layout the bar has. */
    static WidgetBarLines.Text lineText(SharedPreferences prefs) {
        return WidgetBarLines.parse(prefs.getString(Keys.WIDGET_BAR_LINE_MODE, null),
                prefs.getBoolean(Keys.WIDGET_BAR_ONE_LINE, false));
    }

    /**
     * Puts the two lines of the bar's music widget in the order the user chose (WidgetBarLines): the artist's
     * line above the title's, or back below it. The views themselves change places, so each text keeps its
     * own color and everything bound to it. In one line the second view is hidden and the order does not
     * show. Called after {@link #apply}, which may have replaced the music widget by its wide variant.
     */
    static void arrangeLines(View bar, SharedPreferences prefs) {
        if (bar == null) {
            return;
        }
        View title = bar.findViewById(R.id.tv_musicName_two);
        View artist = bar.findViewById(R.id.tv_artist_two);
        if (title == null || artist == null || title.getParent() != artist.getParent()
                || !(title.getParent() instanceof ViewGroup)) {
            return;
        }
        ViewGroup column = (ViewGroup) title.getParent();
        boolean artistAbove = lineText(prefs).artistAbove();
        boolean artistIsAbove = column.indexOfChild(artist) < column.indexOfChild(title);
        if (artistAbove == artistIsAbove) {
            return;
        }
        View upper = artistAbove ? artist : title;
        View lower = artistAbove ? title : artist;
        int at = column.indexOfChild(lower);
        column.removeView(upper);
        column.addView(upper, at);
    }

    static boolean buttonsInOneRow(SharedPreferences prefs, boolean portrait) {
        return WidgetBarLines.buttonsInOneRow(prefs.getBoolean(Keys.WIDGET_BAR_BUTTONS_ONE_LINE, false),
                buttonsBeside(prefs, portrait));
    }

    /** @return whether the bar was changed (some widget or the cover is hidden, or the apps list fitted) */
    static boolean apply(View bar, LayoutInflater inflater, SharedPreferences prefs, boolean portrait) {
        if ((drawerHidden(prefs) || musicHidden(prefs)) && bar instanceof ConstraintLayout) {
            // The drawer button or the music widget hidden: the one rule for every element (BarShares)
            return applyShared((ConstraintLayout) bar, inflater, prefs, portrait);
        }
        boolean noDate = dateHidden(prefs, portrait);
        boolean noWeather = weatherHidden(prefs);
        boolean noCover = coverHidden(prefs);
        WidgetBarPlan.Shares shares = shares(prefs, portrait);
        if (!(WidgetBarPlan.wide(noDate, noWeather, noCover) || shares.appsChanged)
                || !(bar instanceof ConstraintLayout)) {
            return false;
        }
        ConstraintLayout root = (ConstraintLayout) bar;
        View date = root.findViewById(R.id.bar_widget_date);
        View weather = root.findViewById(R.id.bar_widget_weather);
        ViewGroup music = root.findViewById(R.id.rl_music_two);
        if (music == null) {
            return false;
        }
        if (noDate && date != null) {
            date.setVisibility(View.GONE);
        }
        if (noWeather && weather != null) {
            weather.setVisibility(View.GONE);
        }
        View apps = root.findViewById(R.id.recycler_view);
        boolean noApps = appsHidden(prefs);
        if (noApps && apps != null) {
            apps.setVisibility(View.GONE);
        }

        // With the buttons beside the text the wide variant of the music widget replaces the
        // usual one. Otherwise the usual layout stays and has the whole width the widget has.
        if (buttonsBeside(prefs, portrait)) {
            music.removeAllViews();
            inflater.inflate(R.layout.music_bar_content_wide, music, true);
        }
        // The cover is gone in either layout. The width of the music widget does not change: the
        // cover is no widget of the bar, its room goes to the text and the buttons inside it.
        View cover = music.findViewById(R.id.iv_album_bg_two);
        if (noCover && cover != null) {
            cover.setVisibility(View.GONE);
        }
        if (!WidgetBarPlan.widensMusic(noDate, noWeather) && !shares.appsChanged) {
            return true;
        }

        // The music widget gets the room of the widgets that are hidden, and the apps list's room goes to the
        // widgets. Where they lie, and what they are tied to, is the order of the bar's elements (BarOrderLayout,
        // after this).
        ConstraintSet set = new ConstraintSet();
        set.clone(root);
        set.constrainPercentWidth(R.id.rl_music_two, shares.music);
        if (shares.appsChanged) {
            if (!noApps) {
                set.constrainPercentWidth(R.id.recycler_view, shares.apps);
            }
            if (date != null && !noDate) {
                set.constrainPercentWidth(R.id.bar_widget_date, shares.date);
            }
            if (weather != null && !noWeather) {
                set.constrainPercentWidth(R.id.bar_widget_weather, shares.weather);
            }
            if (portrait) {
                // The list and the weather are as high as their own width says ("H,"): the height of their usual
                // width, so the bar and the icons keep their height (HorizontalBarDimensions reads the ratio)
                if (!noApps) {
                    set.setDimensionRatio(R.id.recycler_view, "H," + WidgetBarPlan.keptRatio(
                            WidgetBarPlan.APPS_RATIO_PORT, WidgetBarPlan.usualApps(true), shares.apps));
                }
                if (weather != null && !noWeather) {
                    set.setDimensionRatio(R.id.bar_widget_weather, "H," + WidgetBarPlan.keptRatio(
                            WidgetBarPlan.WEATHER_RATIO_PORT, WidgetBarPlan.usualWeather(true), shares.weather));
                }
            }
        }
        set.applyTo(root);
        return true;
    }
}
