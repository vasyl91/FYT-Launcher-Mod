package com.android.launcher66;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.os.UserManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

/**
 * The launcher asks the system whether the user has unlocked the device (direct boot, DirectBootPlan): a locked
 * user gets the wallpaper start, an unlocked one the whole start.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class DirectBootStateTest {

    @Test
    public void theUnlockedStateFollowsTheUserManager() {
        Context context = RuntimeEnvironment.getApplication();
        UserManager users = (UserManager) context.getSystemService(Context.USER_SERVICE);

        Shadows.shadowOf(users).setUserUnlocked(false);
        assertFalse(LauncherApplication.isUserUnlocked(context));
        assertTrue(DirectBootPlan.atStart(LauncherApplication.isUserUnlocked(context))
                == DirectBootPlan.Start.WALLPAPER_ONLY);

        Shadows.shadowOf(users).setUserUnlocked(true);
        assertTrue(LauncherApplication.isUserUnlocked(context));
        assertTrue(DirectBootPlan.atStart(LauncherApplication.isUserUnlocked(context))
                == DirectBootPlan.Start.FULL);
    }
}
