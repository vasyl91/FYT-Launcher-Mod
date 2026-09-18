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

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Slider for the resizable bottom bar, shown under the "Resizable bottom bar" switch the same way
 * AutoHideSeekBarPreference sits under "Auto-hide bottom bar".
 *
 * Range: 8 % - 20 % of the shorter screen edge (BottomBarDimensions.MIN/MAX_MULTIPLIER), in
 * 0.1 % steps - roughly one pixel per step on head-unit screens.
 *
 * The value is kept per orientation: it is read from and written to Keys.BOTTOM_BAR_HEIGHT_PORT or
 * Keys.BOTTOM_BAR_HEIGHT_LAND, whichever matches the current configuration, as the float
 * multiplier BottomBarDimensions expects (14.2 % -> 0.142f). Nothing is stored under this
 * preference's own key.
 *
 * The defaults (14.2 % portrait, 16.38 % landscape) are not all on the 0.1 % grid, so the step
 * nearest to a default stands for the exact default: the bar can always be put back to precisely
 * its original size. Nothing is written until the user actually moves the slider.
 *
 * Every real change goes through callChangeListener() first, so the fragment's
 * OnPreferenceChangeListener sees it (and may veto it); binding the row never counts as a change.
 */
public class BottomBarHeightSeekBarPreference extends Preference {

    /** One step is 1/1000 of the shorter screen edge, i.e. 0.1 %. */
    private static final int STEPS_PER_UNIT = 1000;
    static final int MIN_STEP = Math.round(BottomBarDimensions.MIN_MULTIPLIER * STEPS_PER_UNIT);
    static final int MAX_STEP = Math.round(BottomBarDimensions.MAX_MULTIPLIER * STEPS_PER_UNIT);

    private boolean portrait;
    private float multiplier;

    public BottomBarHeightSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Same row layout as the auto-hide timeout slider, so both sliders look alike.
        setLayoutResource(R.layout.seekbar_preference_autohide);
        // The value lives under the per-orientation keys, never under this preference's key.
        setPersistent(false);
        portrait = BottomBarDimensions.isPortrait(context);
        multiplier = BottomBarDimensions.getDefaultMultiplier(portrait);
    }

    @Override
    public void onAttached() {
        super.onAttached();
        readValue();
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        View rootView = holder.itemView;
        // Apply relative padding (start, top, end, bottom) - same as AutoHideSeekBarPreference
        rootView.setPaddingRelative(
                SettingsActivity.nestedPaddingStart / 2,
                rootView.getPaddingTop(),
                SettingsActivity.nestedPaddingEnd,
                rootView.getPaddingBottom()
        );

        // The orientation may have changed since the last bind: show the value stored for this one.
        readValue();

        View view = holder.findViewById(R.id.autohide_seekbar);
        if (!(view instanceof SeekBar)) {
            return;
        }
        SeekBar seekBar = (SeekBar) view;
        // Detach first: a recycled row still carries the previous listener, and the setProgress()
        // below must not look like a user change (it would mark the bar settings as changed).
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(MAX_STEP - MIN_STEP); // Adjust range for SeekBar
        seekBar.setKeyProgressIncrement(1);  // D-pad / rotary controllers move one 0.1 % step
        seekBar.setProgress(toStep(multiplier) - MIN_STEP); // Map value to SeekBar progress
        seekBar.setContentDescription(getContext().getString(R.string.bottom_bar_height_seekbar));
        describeValue(seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                float value = fromStep(progress + MIN_STEP, portrait); // Map progress back to the multiplier
                if (!updateValue(value)) {
                    // Rejected by the change listener: put the thumb back on the stored value
                    // (a no-op if the value simply did not change).
                    bar.setProgress(toStep(multiplier) - MIN_STEP);
                }
                describeValue(bar);
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {}

            @Override
            public void onStopTrackingTouch(SeekBar bar) {}
        });
    }

    /** Multiplier currently shown, for the current orientation (0.142f = 14.2 %). */
    public float getMultiplier() {
        return multiplier;
    }

    /** Whether the shown value belongs to the portrait key (otherwise the landscape key). */
    public boolean isPortrait() {
        return portrait;
    }

    /**
     * Re-reads the value, e.g. after the orientation changed without the screen being recreated.
     */
    public void refresh() {
        readValue();
        notifyChanged();
    }

    /**
     * Puts the current orientation back to its original bar height; the counterpart of
     * AutoHideSeekBarPreference.resetPosition().
     */
    public void resetToDefault() {
        readValue();
        if (updateValue(BottomBarDimensions.getDefaultMultiplier(portrait))) {
            notifyChanged();
        }
    }

    /** "16.38 %" in the default locale (decimal separator and percent style follow the locale). */
    @NonNull
    public static String formatPercent(float multiplier) {
        return formatPercent(multiplier, Locale.getDefault());
    }

    @NonNull
    static String formatPercent(float multiplier, @NonNull Locale locale) {
        NumberFormat format = NumberFormat.getPercentInstance(locale);
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(2);
        // Through the shortest decimal of the float, so 0.1638f prints as 16.38, not 16.379999...
        return format.format(Double.parseDouble(Float.toString(multiplier)));
    }

    /** Slider step for a multiplier (0.163f -> 163), clamped to the slider range. */
    static int toStep(float value) {
        return clampStep(Math.round(value * STEPS_PER_UNIT));
    }

    /**
     * Multiplier for a slider step (163 -> 0.163f). The step nearest to the orientation's default
     * returns that exact default (164 -> 0.1638f in landscape).
     */
    static float fromStep(int step, boolean portrait) {
        int clamped = clampStep(step);
        float defaultValue = BottomBarDimensions.getDefaultMultiplier(portrait);
        if (clamped == toStep(defaultValue)) {
            return defaultValue;
        }
        return clamped / (float) STEPS_PER_UNIT;
    }

    private static int clampStep(int step) {
        return Math.max(MIN_STEP, Math.min(MAX_STEP, step));
    }

    /**
     * Stores a new value for the current orientation, after the change listener accepted it.
     *
     * @return true if the value changed; false if it was the same already or was rejected.
     */
    private boolean updateValue(float value) {
        if (value == multiplier || !callChangeListener(value)) {
            return false;
        }
        multiplier = value;
        getPrefs().edit()
                .putFloat(BottomBarDimensions.getHeightKey(portrait), value) // Save the value
                .apply();
        return true;
    }

    private void readValue() {
        portrait = BottomBarDimensions.isPortrait(getContext());
        multiplier = BottomBarDimensions.getConfiguredMultiplier(getPrefs(), portrait);
    }

    /** Lets TalkBack read "16.38 %" instead of the raw slider position. */
    private void describeValue(@NonNull SeekBar seekBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            seekBar.setStateDescription(formatPercent(multiplier));
        }
    }

    @NonNull
    private SharedPreferences getPrefs() {
        // The same file the switches persist to (the PreferenceManager's); the launcher reads it
        // as the default shared preferences.
        SharedPreferences prefs = getSharedPreferences();
        return prefs != null ? prefs : PreferenceManager.getDefaultSharedPreferences(getContext());
    }
}
