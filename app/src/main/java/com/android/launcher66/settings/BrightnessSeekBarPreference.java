package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import android.widget.SeekBar;

import com.android.launcher66.R;

public class BrightnessSeekBarPreference extends Preference {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 255;
    private static final int DEFAULT_VALUE = 0;

    private int currentValue;

    public interface OnSeekBarProgressChangeListener {
        void onProgressChanged(int progress);
    }

    private OnSeekBarProgressChangeListener progressChangeListener;

    public BrightnessSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_brightness); // Custom layout for the SeekBar
    }

    @Override
    protected void onSetInitialValue(Object defaultValue) {
        super.onSetInitialValue(defaultValue);
        currentValue = getPersistedInt(DEFAULT_VALUE);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.brightness_seekbar);
        seekBar.setMax(MAX_VALUE - MIN_VALUE); // Adjust range for SeekBar
        seekBar.setProgress(currentValue - MIN_VALUE); // Map value to SeekBar progress

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentValue = progress + MIN_VALUE; // Map progress back to actual value
                persistInt(currentValue); // Save the value
                callChangeListener(currentValue); // Notify listeners

                // Notify the external listener
                if (progressChangeListener != null) {
                    progressChangeListener.onProgressChanged(currentValue);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public int getValue() {
        return currentValue;
    }

    // Method to set the external listener
    public void setOnSeekBarProgressChangeListener(OnSeekBarProgressChangeListener listener) {
        this.progressChangeListener = listener;
    }
}