package com.android.launcher66;

import java.util.ArrayList;
import java.util.List;

import leakcanary.LeakCanary;
import shark.AndroidReferenceMatchers;
import shark.ReferenceMatcher;

final class LeakCanaryInit {


    /**
     * Binder stub created by the framework in NotificationListenerService.onBind()
     * and passed to NotificationManagerService. It is held by a native global
     * reference on the system side, and its this$0 points back to our service
     * and survives Service#onDestroy(). It cannot be released from the app side.
     */
    private static final String NLS_WRAPPER =
            "android.service.notification.NotificationListenerService$NotificationListenerWrapper";

    static void init() {
        List<ReferenceMatcher> matchers =
                new ArrayList<>(AndroidReferenceMatchers.Companion.getAppDefaults());

        // The pattern targets ONE edge: the this$0 field on the framework wrapper.
        // Every other path to NotificationListener (static instance, uncleared
        // callback, scheduled Runnable) is still reported as an APPLICATION LEAK.
        matchers.add(AndroidReferenceMatchers.Companion.instanceFieldLeak(
                NLS_WRAPPER,
                "this$0",
                "AOSP: NotificationListenerWrapper is held by a native global reference "
                        + "in NotificationManagerService. The framework, not the app.",
                buildMirror -> true
        ));

        LeakCanary.setConfig(
                LeakCanary.getConfig().newBuilder()
                        .retainedVisibleThreshold(1)
                        .referenceMatchers(matchers)
                        .build()
        );
    }
}