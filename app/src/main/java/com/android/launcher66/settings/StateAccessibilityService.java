package com.android.launcher66.settings;

import com.android.launcher66.SysCalls;
import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class StateAccessibilityService extends AccessibilityService {

    private static final String TAG = "StateAccessibilityService";

    /*
     * Only TYPE_WINDOW_STATE_CHANGED is used, and since accessibility_service_config.xml asks for
     * that type alone, it is the only one delivered. It used to be typeAllMask: every click,
     * scroll, text and content change of every app on screen -- the PiP panes' YouTube and maps
     * included -- was an IPC from system_server into the launcher's process, to be dropped here.
     */
    private String mLastPackage;
    private long mLastSentAt;
    /** Repeats are let through after this long, so a receiver started meanwhile still learns it. */
    private static final long REPEAT_SUPPRESS_MS = 5000L;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) { 
        int eventType = event.getEventType();
        String packageName = event.getPackageName() != null ? event.getPackageName().toString() : "null";
        if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            // The task stack reports the foreground app already (system privileges); a second
            // source would only contradict it.
            if (ForegroundAppTracker.isActive()) {
                return;
            }
            // A dialog or a fragment of the app already in front: the foreground app is unchanged,
            // and every broadcast is a call into ActivityManager (112 of them in a cold boot capture).
            long now = SystemClock.uptimeMillis();
            if (packageName.equals(mLastPackage) && now - mLastSentAt < REPEAT_SUPPRESS_MS) {
                return;
            }
            mLastPackage = packageName;
            mLastSentAt = now;
            Intent intent = new Intent(Keys.ACCESIBILITY_SERVICE);
            Bundle extras = new Bundle();
            extras.putString("package_name", packageName);
            intent.putExtras(extras);
            SysCalls.sendBroadcast(this, intent);
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