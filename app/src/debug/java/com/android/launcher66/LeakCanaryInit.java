package com.android.launcher66;

import leakcanary.LeakCanary;

final class LeakCanaryInit {
    static void init() {
        LeakCanary.setConfig(
            LeakCanary.getConfig().newBuilder()
                .retainedVisibleThreshold(1)
                .build()
        );
    }
}