package com.android.launcher66.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;

import com.android.launcher66.R;

public class CustomSwitchPreference extends SwitchPreferenceCompat {

    private Switch switchWidget;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public CustomSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.nested_preference_category_switch); 
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        switchWidget = (Switch) holder.findViewById(R.id.switchWidget);
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