package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.launcher66.settings.Keys;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The frames of the widgets placed freely (D6): kept in memory and written with apply(), read back from the file, gone
 * with the widget; and the setting that turns them on is a creator setting.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class WidgetFramesTest {

    private Context context;

    @Before
    public void setUp() {
        context = RuntimeEnvironment.getApplication();
        context.getSharedPreferences(WidgetFrames.PREFS, Context.MODE_PRIVATE).edit().clear().commit();
        androidx.preference.PreferenceManager.getDefaultSharedPreferences(context).edit().clear().commit();
    }

    @Test
    public void aFrameIsKeptAndWrittenAndGoneWithItsWidget() {
        WidgetFrame frame = new WidgetFrame(0.1f, 0.2f, 0.6f, 0.7f);
        WidgetFrames.put(context, 4711, frame);
        WidgetFrame read = WidgetFrames.get(context, 4711);
        assertNotNull(read);
        assertEquals(0.6f, read.right, 0.0001f);
        SharedPreferences file = context.getSharedPreferences(WidgetFrames.PREFS, Context.MODE_PRIVATE);
        assertEquals(frame.format(), file.getString("4711", null));
        WidgetFrames.remove(context, 4711);
        assertNull(WidgetFrames.get(context, 4711));
        assertNull(file.getString("4711", null));
    }

    @Test
    public void aFrameHeldWhileDraggingIsNotWritten() {
        WidgetFrames.hold(4712, new WidgetFrame(0f, 0f, 0.5f, 0.5f));
        assertNotNull(WidgetFrames.get(context, 4712));
        assertNull(context.getSharedPreferences(WidgetFrames.PREFS, Context.MODE_PRIVATE).getString("4712", null));
        WidgetFrames.remove(context, 4712);
    }

    @Test
    public void freePlacementIsOffByDefaultAndOffWithTheStockLayout() {
        SharedPreferences prefs = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
        assertEquals(false, FreeformWidgets.enabled(context));
        prefs.edit().putBoolean(Keys.WIDGET_FREEFORM, true).putBoolean(Keys.USER_LAYOUT, false).commit();
        assertEquals("the stock layout ignores it", false, FreeformWidgets.enabled(context));
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        assertEquals(true, FreeformWidgets.enabled(context));
    }
}
