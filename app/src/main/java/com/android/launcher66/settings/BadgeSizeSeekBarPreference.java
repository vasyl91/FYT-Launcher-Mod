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
 * The slider for the size of the notification badges, of the same look as the corner's: the badge's height as a share of the
 * icon as it is seen, from 15 to 35 per cent, 25 by default (BadgeGeometry; the owner, 2026-11-27, instead of "small",
 * "medium" and "large"). It keeps the value under {@link Keys#BADGES_SIZE_PERCENT}, at every step, so that the preview and
 * the icons follow the finger. A disabled row (the badges are off) shows the slider and does not move.
 */
public class BadgeSizeSeekBarPreference extends Preference {


    public BadgeSizeSeekBarPreference(Context context, AttributeSet attrs) {
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
        seekBar.setMin(com.android.launcher66.BadgeGeometry.MIN_PERCENT);
        seekBar.setMax(com.android.launcher66.BadgeGeometry.MAX_PERCENT);
        seekBar.setProgress(com.android.launcher66.BadgeGeometry.percent(
                prefs.getInt(Keys.BADGES_SIZE_PERCENT, com.android.launcher66.BadgeGeometry.DEFAULT_PERCENT)));
        seekBar.setEnabled(isEnabled());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (fromUser) {
                    prefs.edit().putInt(Keys.BADGES_SIZE_PERCENT, progress).apply();
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
