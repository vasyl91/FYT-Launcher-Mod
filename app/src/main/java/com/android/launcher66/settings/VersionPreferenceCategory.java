package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;

/**
 * The version category: its summary (how the launcher runs here, and the build) shows line by
 * line, in the title's colour and font, as part of the heading rather than as a row below it.
 * The category's own summary is a single line in a secondary colour.
 */
public class VersionPreferenceCategory extends PreferenceCategory {

    public VersionPreferenceCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        if (!(holder.findViewById(android.R.id.title) instanceof TextView title)
                || !(holder.findViewById(android.R.id.summary) instanceof TextView summary)) {
            return;
        }
        summary.setSingleLine(false);
        summary.setMaxLines(Integer.MAX_VALUE);
        summary.setEllipsize(null);
        summary.setTextColor(title.getTextColors());
        summary.setTextSize(TypedValue.COMPLEX_UNIT_PX, title.getTextSize());
        summary.setTypeface(title.getTypeface());
    }
}
