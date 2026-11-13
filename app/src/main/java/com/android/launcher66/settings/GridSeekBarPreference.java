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
import com.android.launcher66.WorkspaceGrid;

/**
 * The slider for the rows or the columns of the home screen, of the same look as the one under
 * "Auto-hide horizontal bar".
 *
 * <p>What is stored is not "rows" and "columns" but the cells along the long and along the short edge of
 * the screen (WorkspaceGrid): rows are the short edge in landscape and the long one in portrait. The slider
 * therefore reads and writes the edge its word means in the orientation the settings are shown in, and the
 * same screen keeps the same grid when it is turned. It keeps nothing under its own key.
 */
public class GridSeekBarPreference extends Preference {

    /** The key of the slider for the rows; any other key is the slider for the columns. */
    public static final String ROWS = "workspace_grid_rows";
    public static final String COLUMNS = "workspace_grid_columns";

    public interface OnValueChangeListener {
        void onValueChanged(int value);
    }

    private OnValueChangeListener listener;

    public GridSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.seekbar_preference_autohide);
        setPersistent(false);
    }

    public void setOnValueChangeListener(OnValueChangeListener listener) {
        this.listener = listener;
    }

    /** Whether this slider sets the long edge of the screen, in the orientation the settings are shown in. */
    private boolean longEdge() {
        boolean rows = ROWS.equals(getKey());
        return rows != WorkspaceGrids.landscape(getContext());
    }

    private int min() {
        return longEdge() ? WorkspaceGrid.MIN_LONG : WorkspaceGrid.MIN_SHORT;
    }

    private int max() {
        return longEdge() ? WorkspaceGrid.MAX_LONG : WorkspaceGrid.MAX_SHORT;
    }

    /** The number the slider shows: the rows or the columns of a page without bars. */
    public int getValue() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        return longEdge() ? WorkspaceGrids.longCells(prefs) : WorkspaceGrids.shortCells(prefs);
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
                        .putInt(longEdge() ? Keys.WORKSPACE_GRID_LONG : Keys.WORKSPACE_GRID_SHORT, value)
                        .apply();
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
