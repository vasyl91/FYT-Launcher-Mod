package com.android.launcher66;

import android.content.SharedPreferences;

/**
 * The test application with storage that can be locked, as before the user's first unlock: while {@link #sLocked} is
 * set, a preference file cannot be opened, as Android refuses it for credential encrypted storage (DirectBootPlan).
 */
public class LockedTestApplication extends TestLauncherApplication {

    /** Set by a test for the time the user is "locked". */
    static volatile boolean sLocked;

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        if (sLocked) {
            throw new IllegalStateException("SharedPreferences in credential encrypted storage are not available"
                    + " until after the user is unlocked (test: " + name + ")");
        }
        return super.getSharedPreferences(name, mode);
    }
}
