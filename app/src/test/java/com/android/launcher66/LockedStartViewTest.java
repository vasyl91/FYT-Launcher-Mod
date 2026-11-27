package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.UserManager;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

/**
 * The Launcher activity made before the user's first unlock (DirectBootPlan) reads no storage: not in its field
 * initializers, which run before onCreate(), and not in the locked start. With a locked storage that throws, as
 * Android's does, the activity is made, shown and closed. A read there hung the A55 at boot (2026-11-26).
 *
 * <p>What it cannot see: a read when a class loads. The test application starts unlocked and has loaded those
 * classes before the test locks the storage (the old Helpers passes here); StorageAtClassLoadTest covers them.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = LockedTestApplication.class)
public class LockedStartViewTest {

    private static UserManager users() {
        return (UserManager) RuntimeEnvironment.getApplication().getSystemService(Context.USER_SERVICE);
    }

    @After
    public void unlock() {
        LockedTestApplication.sLocked = false;
        shadowOf(users()).setUserUnlocked(true);
    }

    @Test
    public void theLauncherBeforeTheUnlockShowsTheWallpaperOnlyAndReadsNoStorage() {
        shadowOf(users()).setUserUnlocked(false);
        LockedTestApplication.sLocked = true;

        ActivityController<Launcher> controller = Robolectric.buildActivity(Launcher.class);
        controller.create().start().resume();
        shadowOf(Looper.getMainLooper()).idle();

        ViewGroup content = controller.get().findViewById(android.R.id.content);
        assertEquals("one empty view over the wallpaper", 1, content.getChildCount());
        assertTrue(content.getChildAt(0) instanceof FrameLayout);
        assertEquals(0, ((ViewGroup) content.getChildAt(0)).getChildCount());

        controller.pause().stop().destroy();
    }

    @Test
    public void theUnlockEndsTheWallpaperOnlyHomeInsteadOfMakingItAgain() {
        shadowOf(users()).setUserUnlocked(false);
        LockedTestApplication.sLocked = true;
        ActivityController<Launcher> controller = Robolectric.buildActivity(Launcher.class);
        controller.create().start().resume();
        shadowOf(Looper.getMainLooper()).idle();

        // The user unlocks: the storage is readable again, the broadcast comes
        LockedTestApplication.sLocked = false;
        shadowOf(users()).setUserUnlocked(true);
        RuntimeEnvironment.getApplication().sendBroadcast(new Intent(Intent.ACTION_USER_UNLOCKED));
        shadowOf(Looper.getMainLooper()).idle();

        // It ends, and the system starts the home the user chose; made again in place it crashed on the A55
        assertTrue("the wallpaper-only home ends at the unlock", controller.get().isFinishing());
        controller.pause().stop().destroy();
    }
}
