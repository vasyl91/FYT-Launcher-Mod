package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.R;

/**
 * Slider for the width of the vertical bar, under the "Resizable vertical bar" switch, as
 * HorizontalBarHeightSeekBarPreference sits under "Resizable horizontal bar" and looks the same.
 *
 * <p>Range: 4 % .. 10 % of the screen's longer edge in 0.1 % steps (VerticalBarDimensions). The share is kept
 * per orientation under Keys.VERTICAL_BAR_WIDTH_PORT / _LAND, whichever matches the current configuration;
 * nothing is stored under this preference's own key, and nothing at all until the user moves the slider. The
 * step nearest to a default stands for the exact default, which gives the width the bar has always had.
 *
 * <p>Every real change goes through callChangeListener() first, so the fragment sees it; binding the row is
 * never a change.
 */
public class VerticalBarWidthSeekBarPreference extends Preference {

    private boolean portrait;
    private float share;

    public VerticalBarWidthSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_autohide);
        setPersistent(false);
        portrait = HorizontalBarDimensions.isPortrait(context);
        share = VerticalBarDimensions.defaultShare(portrait);
    }

    @Override
    public void onAttached() {
        super.onAttached();
        readValue();
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        readValue();
        View view = holder.findViewById(R.id.autohide_seekbar);
        if (!(view instanceof SeekBar)) {
            return;
        }
        SeekBar seekBar = (SeekBar) view;
        // A recycled row still carries the previous listener; setProgress() must not count as a change
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(VerticalBarDimensions.MAX_STEP - VerticalBarDimensions.MIN_STEP);
        seekBar.setKeyProgressIncrement(1);
        seekBar.setProgress(VerticalBarDimensions.toStep(share) - VerticalBarDimensions.MIN_STEP);
        seekBar.setContentDescription(getContext().getString(R.string.vertical_bar_width_seekbar));
        describeValue(seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                float value = VerticalBarDimensions.fromStep(progress + VerticalBarDimensions.MIN_STEP, portrait);
                if (!updateValue(value)) {
                    bar.setProgress(VerticalBarDimensions.toStep(share) - VerticalBarDimensions.MIN_STEP);
                }
                describeValue(bar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {}

            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });
    }

    /** Reads the value again, after the orientation changed without the screen being made again. */
    public void refresh() {
        readValue();
        notifyChanged();
    }

    /** The share shown, for the current orientation (0.071f = 7.1 %). */
    public float getShare() {
        return share;
    }

    private boolean updateValue(float value) {
        if (value == share || !callChangeListener(value)) {
            return false;
        }
        share = value;
        getPrefs().edit().putFloat(VerticalBarDimensions.widthKey(portrait), value).apply();
        return true;
    }

    private void readValue() {
        portrait = HorizontalBarDimensions.isPortrait(getContext());
        share = readShare(getPrefs(), portrait);
    }

    /** The share stored for the orientation, within the range; the default when nothing usable is stored. */
    public static float readShare(@NonNull SharedPreferences prefs, boolean portrait) {
        float defaultValue = VerticalBarDimensions.defaultShare(portrait);
        try {
            return VerticalBarDimensions.sanitize(prefs.getFloat(VerticalBarDimensions.widthKey(portrait),
                    defaultValue), portrait);
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    private void describeValue(@NonNull SeekBar seekBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            seekBar.setStateDescription(HorizontalBarHeightSeekBarPreference.formatPercent(share));
        }
    }

    @NonNull
    private SharedPreferences getPrefs() {
        SharedPreferences prefs = getSharedPreferences();
        return prefs != null ? prefs : PreferenceManager.getDefaultSharedPreferences(getContext());
    }
}
