package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.BarIconCount;
import com.android.launcher66.R;

/**
 * The slider of the number of app icons on a bar (the key says which: Keys.HORIZONTAL_BAR_ICONS or
 * Keys.VERTICAL_BAR_ICONS), of the same look as the sliders of the grid, with its title row above it.
 *
 * <p>It runs from 1 to the most the bar has room for, which the screen works out (BarIconLimits) and gives it
 * with {@link #setRange}; with nothing chosen it stands at that most. A move stores the number for the bar and
 * the current orientation (BarIconCount.key); nothing is stored under its own key.
 */
public class BarIconsSeekBarPreference extends Preference {

    public interface OnValueChangeListener {
        void onValueChanged(int value);
    }

    private OnValueChangeListener listener;
    private int max = 1;
    private int value = 1;

    public BarIconsSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_autohide);
        setPersistent(false);
    }

    public void setOnValueChangeListener(OnValueChangeListener listener) {
        this.listener = listener;
    }

    /** Whether this is the horizontal bar's slider. */
    public boolean horizontal() {
        return Keys.HORIZONTAL_BAR_ICONS.equals(getKey());
    }

    /** The slider's end and the number it shows; the row is bound again only when one of them changed. */
    public void setRange(int newMax, int newValue) {
        int m = Math.max(1, newMax);
        int v = Math.max(1, Math.min(newValue, m));
        if (m == max && v == value) {
            return;
        }
        max = m;
        value = v;
        notifyChanged();
    }

    public int getValue() {
        return value;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.autohide_seekbar);
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(max - 1);
        seekBar.setProgress(value - 1);
        seekBar.setEnabled(max > 1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                value = progress + 1;
                boolean portrait = HorizontalBarDimensions.isPortrait(getContext());
                getPrefs().edit().putInt(BarIconCount.key(horizontal(), portrait), value).apply();
                if (listener != null) {
                    listener.onValueChanged(value);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar bar) {
            }
        });
    }

    @NonNull
    private SharedPreferences getPrefs() {
        SharedPreferences prefs = getSharedPreferences();
        return prefs != null ? prefs : PreferenceManager.getDefaultSharedPreferences(getContext());
    }
}
