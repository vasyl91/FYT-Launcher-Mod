package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceViewHolder;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("RestrictedApi")
public class CustomPreferenceColorAdapter extends PreferenceGroupAdapter {
    private final Map<String, Integer> titleColors = new HashMap<>();
    private final Map<String, Integer> summaryColors = new HashMap<>();

    public CustomPreferenceColorAdapter(PreferenceFragmentCompat fragment) {
        super(fragment.getPreferenceScreen());
    }

    public void setPreferenceTitleColor(String key, int color) {
        titleColors.put(key, color);
        notifyItemChanged(getPosition(key));
    }

    public void setPreferenceSummaryColor(String key, int color) {
        summaryColors.put(key, color);
        notifyItemChanged(getPosition(key));
    }

    private int getPosition(String key) {
        for (int i = 0; i < getItemCount(); i++) {
            Preference pref = getItem(i);
            if (pref != null && key.equals(pref.getKey())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Preference preference = getItem(position);
        applyCustomColors(holder.itemView, preference.getKey());
    }

    private void applyCustomColors(View view, String key) {
        TextView titleView = view.findViewById(android.R.id.title);
        TextView summaryView = view.findViewById(android.R.id.summary);

        if (titleColors.containsKey(key) && titleView != null) {
            titleView.setTextColor(titleColors.get(key));
        }
        if (summaryColors.containsKey(key) && summaryView != null) {
            summaryView.setTextColor(summaryColors.get(key));
        }
    }
}