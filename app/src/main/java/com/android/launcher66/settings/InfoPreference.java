package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/**
 * A row that only explains something: it is not selectable and its summary shows in full. The
 * AndroidX preference layout caps a summary at ten lines and ellipsizes it, which cut the log
 * legend short on a narrow screen (the legend has long lines of its own, one per kind of
 * report), so this row lifts the cap the same way {@link VersionPreferenceCategory} does.
 */
public class InfoPreference extends Preference {

    public InfoPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        if (holder.findViewById(android.R.id.summary) instanceof TextView summary) {
            summary.setSingleLine(false);
            summary.setMaxLines(Integer.MAX_VALUE);
            summary.setEllipsize(null);
        }
    }
}
