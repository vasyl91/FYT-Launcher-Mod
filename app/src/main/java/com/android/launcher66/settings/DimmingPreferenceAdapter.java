package com.android.launcher66.settings;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceViewHolder;

/**
 * The adapter of the settings' lists: the rows of androidx.preference, each drawn dimmed while it is off
 * ({@link SettingsRowDim}). A row that goes off or on is rebound by androidx.preference ({@code notifyChanged}), so
 * the look follows every change. With "Settings text size" above 100 every title and summary wraps without a limit
 * (SettingsTextScale): a larger text is never cut.
 */
@SuppressLint("RestrictedApi")
public class DimmingPreferenceAdapter extends PreferenceGroupAdapter {

    /** Whether the rows' titles and summaries wrap without a limit ("Settings text size" above 100). */
    private final boolean mWrapAll;

    public DimmingPreferenceAdapter(@NonNull PreferenceGroup group) {
        super(group);
        mWrapAll = SettingsTextScale.factor(androidx.preference.PreferenceManager
                .getDefaultSharedPreferences(group.getContext().getApplicationContext())
                .getInt(SettingsTextScale.KEY, SettingsTextScale.DEFAULT)) > 1f;
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Preference preference = getItem(position);
        SettingsRowDim.apply(holder.itemView, preference == null || preference.isEnabled());
        if (mWrapAll) {
            // With a larger text no title or summary is cut: it wraps (SettingsTextScale)
            wrap(holder.findViewById(android.R.id.title));
            wrap(holder.findViewById(android.R.id.summary));
        }
    }

    private static void wrap(android.view.View view) {
        if (view instanceof android.widget.TextView) {
            android.widget.TextView text = (android.widget.TextView) view;
            text.setSingleLine(false);
            text.setMaxLines(Integer.MAX_VALUE);
            text.setEllipsize(null);
        }
    }
}
