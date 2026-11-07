package com.android.launcher66;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.android.launcher66.settings.Keys;

/**
 * Hides the date and the weather of the widget bar when the settings say so, and gives their room
 * to the music widget. One piece of code for the four layouts (custom_layout_two_user and
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

    static boolean coverHidden(SharedPreferences prefs) {
        return prefs.getBoolean(Keys.WIDGET_BAR_NO_COVER, false);
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

    static boolean buttonsInOneRow(SharedPreferences prefs, boolean portrait) {
        return WidgetBarLines.buttonsInOneRow(prefs.getBoolean(Keys.WIDGET_BAR_BUTTONS_ONE_LINE, false),
                buttonsBeside(prefs, portrait));
    }

    /** @return whether the bar was changed (some widget or the cover is hidden) */
    static boolean apply(View bar, LayoutInflater inflater, SharedPreferences prefs, boolean portrait) {
        boolean noDate = dateHidden(prefs, portrait);
        boolean noWeather = weatherHidden(prefs);
        boolean noCover = coverHidden(prefs);
        if (!WidgetBarPlan.wide(noDate, noWeather, noCover) || !(bar instanceof ConstraintLayout)) {
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
        if (!WidgetBarPlan.widensMusic(noDate, noWeather)) {
            return true;
        }

        // The music widget ends where the last widget that is left begins, or at the bar's edge.
        boolean dateLeft = date != null && !noDate;
        boolean weatherLeft = weather != null && !noWeather;
        ConstraintSet set = new ConstraintSet();
        set.clone(root);
        set.constrainPercentWidth(R.id.rl_music_two, WidgetBarPlan.musicShare(portrait, noDate, noWeather));
        int musicId = R.id.rl_music_two;
        if (dateLeft) {
            set.connect(musicId, ConstraintSet.RIGHT, R.id.bar_widget_date, ConstraintSet.LEFT);
            set.connect(R.id.bar_widget_date, ConstraintSet.LEFT, musicId, ConstraintSet.RIGHT);
            if (!weatherLeft) {
                set.connect(R.id.bar_widget_date, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID,
                        ConstraintSet.RIGHT);
            }
        } else if (weatherLeft) {
            set.connect(musicId, ConstraintSet.RIGHT, R.id.bar_widget_weather, ConstraintSet.LEFT);
            set.connect(R.id.bar_widget_weather, ConstraintSet.LEFT, musicId, ConstraintSet.RIGHT);
        } else {
            set.connect(musicId, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        }
        set.applyTo(root);
        return true;
    }
}
