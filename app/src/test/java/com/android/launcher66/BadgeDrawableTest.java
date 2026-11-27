package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The badge of an icon (H1): an icon with the number 4 has it in its corner, inside the icon's rectangle; with the
 * badges off, or no notifications, nothing is drawn. The look comes from the settings.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class BadgeDrawableTest {

    private static BadgeStyle style(boolean enabled, BadgeGeometry.Position position) {
        return new BadgeStyle(enabled, position, 25, 50, 0xff4285f4, false);
    }

    private static BadgeDrawable badge(int count, BadgeStyle style) {
        BadgeDrawable drawable = new BadgeDrawable(RuntimeEnvironment.getApplication());
        drawable.setBounds(new Rect(100, 200, 200, 300));
        drawable.set(count, style, 0xffffffff);
        return drawable;
    }

    @Test
    public void anIconWithFourNotificationsHasTheBadgeInItsTopRightCorner() {
        BadgeDrawable drawable = badge(4, style(true, BadgeGeometry.Position.TOP_RIGHT));
        assertTrue(drawable.isShown());
        float[] r = drawable.badgeRect();
        assertNotNull(r);
        assertEquals("flush with the right edge", 200f, r[2], 0.01f);
        assertEquals("flush with the top edge", 200f, r[1], 0.01f);
        assertEquals("a quarter of the icon's height", 25f, r[3] - r[1], 0.01f);
        assertTrue("inside the icon", r[0] >= 100f && r[3] <= 300f);
    }

    @Test
    public void theCornerFollowsTheSetting() {
        float[] bottomLeft = badge(4, style(true, BadgeGeometry.Position.BOTTOM_LEFT)).badgeRect();
        assertEquals(100f, bottomLeft[0], 0.01f);
        assertEquals(300f, bottomLeft[3], 0.01f);
    }

    @Test
    public void withTheBadgesOffOrNothingToCountNothingIsDrawn() {
        assertFalse(badge(4, style(false, BadgeGeometry.Position.TOP_RIGHT)).isShown());
        assertNull(badge(4, style(false, BadgeGeometry.Position.TOP_RIGHT)).badgeRect());
        assertNull(badge(0, style(true, BadgeGeometry.Position.TOP_RIGHT)).badgeRect());
    }

    @Test
    public void aNumberAbove99ReadsNinetyNinePlusAndIsStillInsideTheIcon() {
        BadgeDrawable drawable = badge(150, style(true, BadgeGeometry.Position.TOP_RIGHT));
        assertEquals("99+", BadgeCounts.label(150));
        float[] r = drawable.badgeRect();
        assertTrue("the badge is as high as for any number", Math.abs((r[3] - r[1]) - 25f) < 0.01f);
        assertTrue("and inside the icon", r[0] >= 100f && r[2] <= 200f);
    }

    @Test
    public void theBadgeIsSizedAndPlacedByTheSeenIconNotByThePicturesSquare() {
        // a round icon that fills the middle 60 % of its square (20 % margin each side)
        BadgeDrawable drawable = badge(4, style(true, BadgeGeometry.Position.TOP_RIGHT));
        drawable.setVisible(new float[] {0.2f, 0.2f, 0.8f, 0.8f});
        float[] r = drawable.badgeRect();
        assertEquals("a quarter of the 60 px the icon is seen", 15f, r[3] - r[1], 0.01f);
        assertEquals("in the seen icon's corner", 180f, r[2], 0.01f);
        assertEquals(220f, r[1], 0.01f);
    }

    @Test
    public void theSeenPartOfAPictureIsItsPixelsThatAreNotTransparent() {
        android.graphics.Bitmap bitmap = android.graphics.Bitmap.createBitmap(10, 10, android.graphics.Bitmap.Config.ARGB_8888);
        for (int x = 2; x < 8; x++) {
            for (int y = 3; y < 9; y++) {
                bitmap.setPixel(x, y, 0xff00ff00);
            }
        }
        float[] seen = IconBounds.of(new android.graphics.drawable.BitmapDrawable(
                RuntimeEnvironment.getApplication().getResources(), bitmap));
        assertNotNull(seen);
        assertEquals(0.2f, seen[0], 0.001f);
        assertEquals(0.3f, seen[1], 0.001f);
        assertEquals(0.8f, seen[2], 0.001f);
        assertEquals(0.9f, seen[3], 0.001f);
    }

    @Test
    public void theStyleIsReadFromTheSettings() {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().clear().commit();
        BadgeStyle defaults = BadgeStyle.load(context);
        assertTrue(defaults.enabled);
        assertEquals(BadgeGeometry.Position.TOP_RIGHT, defaults.position);
        assertEquals(25, defaults.sizePercent);
        assertEquals(50, defaults.corner);
        assertFalse(defaults.outline);
        assertEquals("the accent while no colour was chosen", ThemeAccent.color(context), defaults.color);
        prefs.edit().putBoolean(Keys.BADGES_ENABLED, false).putString(Keys.BADGES_POSITION, "bottom_left")
                .putInt(Keys.BADGES_SIZE_PERCENT, 33).putInt(Keys.BADGES_CORNER, 0)
                .putInt(Keys.BADGES_COLOR, 0x00ff0000).putBoolean(Keys.BADGES_OUTLINE, true).commit();
        BadgeStyle chosen = BadgeStyle.load(context);
        assertFalse(chosen.enabled);
        assertEquals(BadgeGeometry.Position.BOTTOM_LEFT, chosen.position);
        assertEquals(33, chosen.sizePercent);
        assertEquals(0, chosen.corner);
        assertEquals("opaque", 0xffff0000, chosen.color);
        assertTrue(chosen.outline);
    }
}
