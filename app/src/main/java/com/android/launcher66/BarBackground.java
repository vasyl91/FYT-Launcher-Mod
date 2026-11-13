package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.android.launcher66.settings.Keys;

import java.lang.reflect.Field;

/**
 * The background of a bar or of the widgets as the settings give it: the one place that turns a stored choice
 * (BackgroundChoice) into what is drawn. The first page's bars, the windows of the bars on the other pages, the
 * corner of the vertical bar's window and the band of the creators all ask here, so they cannot differ.
 *
 * <p>A picture is the resource of that name, and the component's default picture when the name is unknown. The
 * user's own colour is drawn in the shape of the pictures it stands in for (RoundedColorDrawable). A bar's
 * picture is turned for the edge the bar is on (BackgroundAngle, RotatedDrawable); a colour is not. Main thread
 * only.
 */
public final class BarBackground {

    /** The pictures the components have when nothing was chosen. */
    public static final String HORIZONTAL_DEFAULT = "app_list_bg";
    public static final String VERTICAL_DEFAULT = "hotseat_bg";
    public static final String WIDGETS_DEFAULT = "bg_custom";

    private BarBackground() {
    }

    /** The choice stored under a component's key, with the colour stored beside it. */
    public static BackgroundChoice choice(SharedPreferences prefs, String choiceKey, String defaultPicture) {
        String colorKey = BackgroundChoice.colorKey(choiceKey);
        boolean hasColor = prefs.contains(colorKey);
        return BackgroundChoice.of(prefs.getString(choiceKey, null), defaultPicture, hasColor,
                hasColor ? prefs.getInt(colorKey, 0) : 0);
    }

    /**
     * The background of the horizontal bar.
     *
     * @param top the bar is at the top of the screen: its picture is turned by 180 degrees
     */
    public static Drawable horizontal(Context context, SharedPreferences prefs, boolean top) {
        return turned(drawable(context, choice(prefs, Keys.BAR_SELECTED_BACKGROUND, HORIZONTAL_DEFAULT),
                R.drawable.app_list_bg, RoundedColorDrawable.BAR_CORNERS), BackgroundAngle.horizontal(top));
    }

    /**
     * The background of the vertical bar.
     *
     * @param right the bar is at the right edge: a picture of the horizontal bar is turned by 90 degrees
     *              counter-clockwise there and clockwise on the left
     */
    public static Drawable vertical(Context context, SharedPreferences prefs, boolean right) {
        return turned(drawable(context, choice(prefs, Keys.VERTICAL_BAR_SELECTED_BACKGROUND, VERTICAL_DEFAULT),
                R.drawable.hotseat_bg, RoundedColorDrawable.NO_CORNERS), BackgroundAngle.vertical(right));
    }

    /** The picture turned for its side; a colour, or a picture that needs no turn, as it is. */
    private static Drawable turned(Drawable background, BackgroundAngle.Side side) {
        if (background == null || background instanceof RoundedColorDrawable) {
            return background;
        }
        boolean upright = background.getIntrinsicHeight() > background.getIntrinsicWidth();
        int degrees = BackgroundAngle.degrees(side, upright);
        return degrees == 0 ? background : new RotatedDrawable(background, degrees);
    }

    /** The background of a widget or of a PiP's placeholder. */
    public static Drawable widgets(Context context, SharedPreferences prefs) {
        return drawable(context, choice(prefs, Keys.WIDGETS_SELECTED_BACKGROUND, WIDGETS_DEFAULT),
                R.drawable.bg_custom, RoundedColorDrawable.WIDGET_CORNERS);
    }

    /**
     * @param fallback   the picture drawn when the chosen one is not among the resources
     * @param cornerShare the rounding of the user's colour (RoundedColorDrawable)
     * @return null for no background
     */
    public static Drawable drawable(Context context, BackgroundChoice choice, int fallback, float cornerShare) {
        switch (choice.kind) {
            case NONE:
                return null;
            case CUSTOM:
                return new RoundedColorDrawable(choice.color, cornerShare);
            default:
                int resource = resource(choice.picture);
                return ContextCompat.getDrawable(context, resource != 0 ? resource : fallback);
        }
    }

    /** The drawable resource of that name, 0 when there is none. */
    public static int resource(String name) {
        if (name == null) {
            return 0;
        }
        try {
            Field field = R.drawable.class.getDeclaredField(name);
            return field.getInt(null);
        } catch (Exception e) {
            return 0;
        }
    }
}
