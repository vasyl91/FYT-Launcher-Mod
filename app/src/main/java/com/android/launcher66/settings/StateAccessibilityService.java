package com.android.launcher66.settings;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class StateAccessibilityService extends AccessibilityService {

    private static final String TAG = "StateAccessibilityService";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) { 
        int eventType = event.getEventType();
        String packageName = event.getPackageName() != null ? event.getPackageName().toString() : "null";
        if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            Intent intent = new Intent(Keys.ACCESIBILITY_SERVICE);
            Bundle extras = new Bundle();
            extras.putString("package_name", packageName);
            intent.putExtras(extras);
            this.sendBroadcast(intent);
        }
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "Accessibility service interrupted");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "Accessibility service connected");
    }
}