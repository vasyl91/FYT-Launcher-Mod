package com.android.launcher66.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.R;

public class CustomSwitchPreference extends SwitchPreferenceCompat {

    private SwitchCompat switchWidget;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public CustomSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.nested_preference_category_switch); 
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        View rootView = holder.itemView;
        if (rootView instanceof LinearLayout) {
            // Apply relative padding (start, top, end, bottom)
            rootView.setPaddingRelative(
                SettingsActivity.nestedPaddingStart,
                rootView.getPaddingTop(),
                SettingsActivity.nestedPaddingEnd,
                rootView.getPaddingBottom()
            );
        }

        switchWidget = (SwitchCompat) holder.findViewById(R.id.switchWidget);
        if (switchWidget != null) {
            switchWidget.setChecked(isChecked());

            switchWidget.setFocusable(false);
            switchWidget.setClickable(false);

            switchWidget.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (callChangeListener(isChecked)) {
                    handler.post(setCheckedRunnable);
                }
            });
        }
    }

    private Runnable setCheckedRunnable = new Runnable() { 
        @Override
        public void run() {
            switchWidget.setChecked(switchWidget.isChecked());
        }
    };

    @Override
    protected void onClick() {
        super.onClick();
        if (switchWidget != null) {
            switchWidget.setChecked(!switchWidget.isChecked());
        }
    }
}