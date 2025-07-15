package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

public class CustomPreference extends Preference {

    public CustomPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        View view = holder.itemView;
        if (view instanceof LinearLayout) {
            view.setPaddingRelative(SettingsActivity.nestedPaddingStart, view.getPaddingTop(), SettingsActivity.nestedPaddingEnd, view.getPaddingBottom());
        }
    }
}