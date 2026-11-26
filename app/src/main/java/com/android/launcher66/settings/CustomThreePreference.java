package com.android.launcher66.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.R;

/**
 * CustomNestedNoSwitchPreference for more than two options: the same nested row without a switch,
 * whose tap steps to the next of android:entries / android:entryValues (wrapping around) instead of
 * opening a list dialog. The summary shows the current entry.
 */
public class CustomThreePreference extends ListPreference {

    public CustomThreePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.preference_no_switch);
    }

    @Override
    protected void onClick() {
        CharSequence[] values = getEntryValues();
        if (values == null || values.length == 0) return;

        int next = (findIndexOfValue(getValue()) + 1) % values.length;
        String value = values[next].toString();
        if (callChangeListener(value)) {
            setValue(value);
        }
    }

    @Override
    public CharSequence getSummary() {
        CharSequence entry = getEntry();
        return entry != null ? entry : super.getSummary();
    }
}
