package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.AppsGrid;
import com.android.launcher66.CreatorPrefs;
import com.android.launcher66.R;

/**
 * The slider for the rows or the columns of the app drawer's pages, the same as the one of the home screen's grid
 * ({@link GridSeekBarPreference}) with the limits and the keys of the drawer ({@link AppsGrid}): the cells along the long and
 * the short edge of the screen are stored, and the slider reads and writes the edge its word means in the orientation the settings are shown in.
 */
public class AppsGridSeekBarPreference extends Preference {

    public interface OnValueChangeListener {
        void onValueChanged(int value);
    }

    private OnValueChangeListener listener;

    public AppsGridSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_autohide);
        setPersistent(false);
    }

    public void setOnValueChangeListener(OnValueChangeListener listener) {
        this.listener = listener;
    }

    private boolean longEdge() {
        boolean rows = Keys.ALL_APPS_GRID_ROWS.equals(getKey());
        return rows != WorkspaceGrids.landscape(getContext());
    }

    private int min() {
        return longEdge() ? AppsGrid.MIN_LONG : AppsGrid.MIN_SHORT;
    }

    private int max() {
        return longEdge() ? AppsGrid.MAX_LONG : AppsGrid.MAX_SHORT;
    }

    /** The number the slider shows: the rows or the columns of a page of the drawer. */
    public int getValue() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        return longEdge()
                ? AppsGrid.clampLong(CreatorPrefs.of(prefs).getInt(Keys.ALL_APPS_GRID_LONG, AppsGrid.DEFAULT_LONG))
                : AppsGrid.clampShort(CreatorPrefs.of(prefs).getInt(Keys.ALL_APPS_GRID_SHORT, AppsGrid.DEFAULT_SHORT));
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        SeekBar seekBar = (SeekBar) holder.findViewById(R.id.autohide_seekbar);
        seekBar.setOnSeekBarChangeListener(null);
        seekBar.setMax(max() - min());
        seekBar.setProgress(getValue() - min());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                int value = progress + min();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                        .putInt(longEdge() ? Keys.ALL_APPS_GRID_LONG : Keys.ALL_APPS_GRID_SHORT, value).apply();
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
}
