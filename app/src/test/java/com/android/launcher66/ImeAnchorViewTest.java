package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * The keyboard's anchor (ImeAnchor) lies above every window of the bars' layer: it is added again after each of them,
 * may take the input method (both FLAG_NOT_FOCUSABLE and FLAG_ALT_FOCUSABLE_IM) and takes no touch. Android 10 and
 * older only.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class ImeAnchorViewTest {

    /** A window manager that keeps the order of its windows, as within one layer the system does. */
    private static final class Recorder implements WindowManager {
        final List<View> windows = new ArrayList<>();
        final List<LayoutParams> params = new ArrayList<>();

        @Override
        public void addView(View view, ViewGroup.LayoutParams p) {
            windows.add(view);
            params.add((LayoutParams) p);
        }

        @Override
        public void updateViewLayout(View view, ViewGroup.LayoutParams p) {
        }

        @Override
        public void removeView(View view) {
            removeViewImmediate(view);
        }

        @Override
        public void removeViewImmediate(View view) {
            int i = windows.indexOf(view);
            if (i >= 0) {
                windows.remove(i);
                params.remove(i);
            }
        }

        @Override
        public Display getDefaultDisplay() {
            return null;
        }
    }

    @After
    public void clear() {
        ImeAnchor.remove();
        ImeAnchor.sSdk = android.os.Build.VERSION.SDK_INT;
    }

    private static WindowManager.LayoutParams bar() {
        return new WindowManager.LayoutParams(100, 50, BarWindows.EVERY_PAGE_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
    }

    @Test
    public void theAnchorIsAboveEveryBarAddedAndMayTakeTheInputMethod() {
        ImeAnchor.sSdk = 29;   // the 7862's Android 10
        Context context = RuntimeEnvironment.getApplication();
        Recorder wm = new Recorder();
        View vertical = new View(context);
        View horizontal = new View(context);
        BarWindows.addEveryPageBar(wm, vertical, bar(), "vertical");
        BarWindows.addEveryPageBar(wm, horizontal, bar(), "horizontal");

        assertTrue(ImeAnchor.isUp());
        assertEquals("the two bars and one anchor", 3, wm.windows.size());
        assertEquals("the bars in their order", vertical, wm.windows.get(0));
        assertEquals(horizontal, wm.windows.get(1));
        WindowManager.LayoutParams anchor = wm.params.get(2);
        assertEquals("the last added of the bars' layer: the highest", BarWindows.EVERY_PAGE_TYPE, anchor.type);
        int focus = anchor.flags & (WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        assertEquals("it may be the keyboard's target",
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, focus);
        assertTrue("it takes no touch", (anchor.flags & WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE) != 0);
        assertEquals(1, anchor.width);
        assertEquals(1, anchor.height);
    }

    @Test
    public void onAndroidElevenAndLaterNothingIsAdded() {
        ImeAnchor.sSdk = 30;
        Recorder wm = new Recorder();
        BarWindows.addEveryPageBar(wm, new View(RuntimeEnvironment.getApplication()), bar(), "vertical");
        assertEquals(1, wm.windows.size());
        assertFalse(ImeAnchor.isUp());
    }

    @Test
    public void onlyOnAndroidTenAndOlder() {
        assertTrue(ImeAnchor.wanted(26));
        assertTrue(ImeAnchor.wanted(29));
        assertFalse(ImeAnchor.wanted(30));
        assertFalse(ImeAnchor.wanted(36));
    }
}
