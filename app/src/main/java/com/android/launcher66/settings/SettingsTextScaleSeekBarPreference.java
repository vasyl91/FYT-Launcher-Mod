package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.R;

/**
 * The slider of "Settings text size" (SettingsTextScale): 70 to 150 per cent in steps of 10. The value shows in the title row
 * while the finger moves ({@link Listener#onMoved}); it is stored and taken when the finger is lifted
 * ({@link Listener#onChosen}), since the settings are made again for it.
 */
public class SettingsTextScaleSeekBarPreference extends Preference {

    /** Told while the slider moves and when it is let go. */
    public interface Listener {
        void onMoved(int percent);

        void onChosen(int percent);
    }

    private Listener listener;

    public SettingsTextScaleSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_autohide);
        setPersistent(false);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    /** The value stored now. */
    public int getValue() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        return SettingsTextScale.percent(prefs.getInt(SettingsTextScale.KEY, SettingsTextScale.DEFAULT));
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.autohide_seekbar);
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(SettingsTextScale.maxProgress());
        seekBar.setProgress(SettingsTextScale.progress(getValue()));
        seekBar.setEnabled(isEnabled());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (fromUser && listener != null) {
                    listener.onMoved(SettingsTextScale.fromProgress(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                int percent = SettingsTextScale.fromProgress(bar.getProgress());
                if (percent == getValue()) {
                    return;
                }
                prefs.edit().putInt(SettingsTextScale.KEY, percent).apply();
                if (listener != null) {
                    listener.onChosen(percent);
                }
            }
        });
    }
}
