package com.android.launcher66;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.SeekBar;

import androidx.core.content.ContextCompat;

/**
 * The look of the music widget's position slider: a thin rounded line and a round knob, both centred in the slider's
 * row, the part played and the knob in the colour of the widget's progress (the user's tint, or white), the part
 * not played yet in translucent white.
 *
 * <p>The rules (the owner's, 2026-11-25): the line is a quarter of the knob thick and never thinner than 2 dp
 * ({@link SliderGeometry}), as the slider's minimum and maximum height, which puts it, like the knob, in the middle of
 * the row; the colour is {@code WidgetStyle.Role.WIDGET_PROGRESS} of the settings, or {@code music_track_played}
 * without one; a change of that colour in the settings shows at once ({@link #tint}). Whether the knob shows
 * (a slider that only shows the position has none) is LauncherMusicWidget's: its alpha is kept. Main thread only.
 */
final class PositionSliderLook {

    private PositionSliderLook() {
    }

    /** The colour of the played part and of the knob: the tint kept in the slider, or the colour of the played line. */
    static int colorOf(SeekBar slider) {
        Object tint = slider.getTag(R.id.position_slider_tint);
        if (tint instanceof Integer && (Integer) tint != ViewTint.NONE) {
            return (Integer) tint;
        }
        return ContextCompat.getColor(slider.getContext(), R.color.music_track_played);
    }

    /** The widget's tint for the played part and the knob; {@link ViewTint#NONE} gives the colours of the line back. */
    static void tint(SeekBar slider, int tint) {
        if (slider == null) {
            return;
        }
        slider.setTag(R.id.position_slider_tint, tint);
        ViewTint.tintProgress(slider, tint);
        Drawable knob = slider.getThumb();
        if (knob instanceof GradientDrawable) {
            ((GradientDrawable) knob).setColor(colorOf(slider));
            slider.invalidate();
        }
    }

    /**
     * Sizes the line and the knob for a row of {@code rowPx}: the knob (the padding lets it reach both ends) and the
     * line as the slider's height limits. Cheap when the sizes are the same as before.
     */
    static void size(SeekBar slider, int rowPx) {
        Context context = slider.getContext();
        int side = SliderGeometry.knobPx(rowPx);
        int line = SliderGeometry.linePx(side, context.getResources().getDisplayMetrics().density);
        if (slider.getMinHeight() != line || slider.getMaxHeight() != line) {
            slider.setMinHeight(line);
            slider.setMaxHeight(line);
        }
        Drawable old = slider.getThumb();
        if (old != null && old.getIntrinsicWidth() == side) {
            return;
        }
        GradientDrawable knob = new GradientDrawable();
        knob.setShape(GradientDrawable.OVAL);
        knob.setSize(side, side);
        knob.setColor(colorOf(slider));
        knob.setAlpha(old != null ? old.getAlpha() : 255);
        slider.setThumb(knob);
        slider.setPadding(side / 2, 0, side / 2, 0);
    }
}
