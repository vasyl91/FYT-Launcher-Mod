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
 * the look follows every change.
 */
@SuppressLint("RestrictedApi")
public class DimmingPreferenceAdapter extends PreferenceGroupAdapter {

    public DimmingPreferenceAdapter(@NonNull PreferenceGroup group) {
        super(group);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Preference preference = getItem(position);
        SettingsRowDim.apply(holder.itemView, preference == null || preference.isEnabled());
    }
}
