package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.R;

public class AlphaSeekBarPreference extends Preference {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 255;
    private static final int DEFAULT_VALUE = 255;

    private int currentValue;

    public interface OnSeekBarProgressChangeListener {
        void onProgressChanged(int progress);
    }

    private OnSeekBarProgressChangeListener progressChangeListener;

    public AlphaSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_alpha);
    }

    @Override
    protected void onSetInitialValue(Object defaultValue) {
        super.onSetInitialValue(defaultValue);
        currentValue = getPersistedInt(DEFAULT_VALUE);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.alpha_seekbar);
        if (seekBar == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(MAX_VALUE - MIN_VALUE); // Adjust range for SeekBar
        seekBar.setProgress(currentValue - MIN_VALUE); // Map value to SeekBar progress

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
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

    public void resetPosition(int resetValue) {
        int newValue = Math.max(MIN_VALUE, Math.min(resetValue, MAX_VALUE));
        if (newValue != currentValue) {
            currentValue = newValue;
            persistInt(currentValue);
            notifyChanged(); 
            callChangeListener(currentValue); 
            if (progressChangeListener != null) {
                progressChangeListener.onProgressChanged(currentValue); 
            }
        }
    }
}