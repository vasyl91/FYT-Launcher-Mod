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
 * The slider for the corner radius of the notification badges, of the same look as the one under "Auto-hide horizontal bar":
 * 0 is a square, 100 a circle (the radius is half the badge's height; BadgeGeometry.radius), 50 by default. It keeps the
 * value under {@link Keys#BADGES_CORNER}. A disabled row (the badges are off) shows the slider and does not move.
 */
public class BadgeCornerSeekBarPreference extends Preference {

    public static final int DEFAULT = 50;

    public BadgeCornerSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_autohide);
        setPersistent(false);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.autohide_seekbar);
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(100);
        seekBar.setProgress(prefs.getInt(Keys.BADGES_CORNER, DEFAULT));
        seekBar.setEnabled(isEnabled());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (fromUser) {
                    prefs.edit().putInt(Keys.BADGES_CORNER, progress).apply();
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
}
