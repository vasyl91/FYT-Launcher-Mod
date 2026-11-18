package com.android.launcher66;

import static org.junit.Assert.assertTrue;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.HorizontalBarDimensions;
import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The first page's horizontal bar on the A55 in portrait (the page 1080 x 2116), with the weather hidden: the
 * music widget is widened and its XML height follows its width. Sized as the launcher sizes it, whether
 * "Resizable horizontal bar" is on or off, it is never taller than the bar (HorizontalBarDimensions.applyBarSizes).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = Application.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class HorizontalBarSizesViewTest {

    private static final int PAGE_WIDTH = 1080;
    private static final int PAGE_HEIGHT = 2116;
    /** The default bar on the A55: 14.2 % of the shorter edge. */
    private static final int BAR = (int) (1080 * 0.142);

    private static View inflateBar(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean(Keys.WIDGET_BAR_NO_WEATHER, true).commit();
        LayoutInflater inflater = LayoutInflater.from(context);
        FrameLayout parent = new FrameLayout(context);
        View bar = inflater.inflate(R.layout.custom_layout_two_user, parent, false);
        WidgetBarLayout.apply(bar, inflater, prefs, true);
        parent.addView(bar, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return bar;
    }

    private static void layOut(View bar) {
        View root = (View) bar.getParent();
        root.measure(View.MeasureSpec.makeMeasureSpec(PAGE_WIDTH, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(PAGE_HEIGHT, View.MeasureSpec.EXACTLY));
        root.layout(0, 0, PAGE_WIDTH, PAGE_HEIGHT);
    }

    @Test
    public void leftToItsXmlTheWidenedMusicWidgetIsTallerThanTheBar() {
        // what the bar was with "Resizable horizontal bar" off before 2026-11-18
        View bar = inflateBar(RuntimeEnvironment.getApplication());
        layOut(bar);
        View background = bar.findViewById(R.id.iv_list_bg);
        View music = bar.findViewById(R.id.rl_music_two);
        assertTrue("music " + music.getHeight() + " in a bar of " + background.getHeight(),
                music.getHeight() > background.getHeight());
    }

    @Test
    public void theMusicWidgetIsNeverTallerThanTheBar() {
        Context context = RuntimeEnvironment.getApplication();
        View bar = inflateBar(context);
        Float factor = HorizontalBarDimensions.applyBarSizes(bar, BAR, PAGE_WIDTH, PAGE_HEIGHT, new boolean[1]);
        assertTrue("the bar can be sized", factor != null);
        layOut(bar);
        View background = bar.findViewById(R.id.iv_list_bg);
        View music = bar.findViewById(R.id.rl_music_two);
        assertTrue("the bar has its height: " + background.getHeight(), Math.abs(background.getHeight() - BAR) <= 1);
        assertTrue("music " + music.getHeight() + " in a bar of " + background.getHeight(),
                music.getHeight() > 0 && music.getHeight() <= background.getHeight());
    }
}
