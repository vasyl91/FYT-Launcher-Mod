package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The strip of the drawer's tabs (F6): the selected tab in the accent and bold, the underline at 80% of the tab, a tap
 * that selects or asks for the dialog, the underline following a dragged page, the line on the side of the apps.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class DrawerTabStripTest {

    private static final int ACCENT = 0xffff8800;

    private static DrawerTabStrip strip(int width, String... names) {
        Context context = RuntimeEnvironment.getApplication();
        DrawerTabStrip strip = new DrawerTabStrip(context);
        strip.setAccent(ACCENT);
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            ids.add(i);
        }
        strip.setTabs(ids, Arrays.asList(names), 0);
        strip.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(400, View.MeasureSpec.AT_MOST));
        strip.layout(0, 0, width, strip.getMeasuredHeight());
        return strip;
    }

    private static final class Recorder implements DrawerTabStrip.Listener {
        final List<Integer> selected = new ArrayList<>();
        final List<Integer> tapped = new ArrayList<>();

        @Override
        public void onTabSelected(int id) {
            selected.add(id);
        }

        @Override
        public void onSelectedTabTapped(int id) {
            tapped.add(id);
        }
    }

    @Test
    public void inPortraitTwoTabsShowAndTheUnderlineIsEightyPercentOfOneCentred() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools", "Games");
        assertEquals(500, strip.tabWidth());
        assertEquals(50f, strip.underlineLeft(), 0.01f);
        assertEquals(400f, strip.underlineWidth(), 0.01f);
    }

    @Test
    @Config(qualifiers = "w800dp-h480dp-land")
    public void inLandscapeFourTabsShow() {
        DrawerTabStrip strip = strip(1000, "A", "B", "C", "D", "E", "F");
        assertEquals(250, strip.tabWidth());
    }

    @Test
    public void theSelectedNameIsInTheAccentAndBoldAndTheOthersAreWhiteAndPlain() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools");
        assertEquals(ACCENT, strip.tabView(0).getCurrentTextColor());
        assertEquals(Typeface.BOLD, strip.tabView(0).getTypeface().getStyle());
        assertEquals(Color.WHITE, strip.tabView(1).getCurrentTextColor());
        assertFalse(strip.tabView(1).getTypeface() != null && strip.tabView(1).getTypeface().isBold());
    }

    @Test
    public void aTapOnATabThatIsNotSelectedSelectsItAndTellsTheListener() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools", "Games");
        Recorder recorder = new Recorder();
        strip.setListener(recorder);
        strip.tabView(2).performClick();
        assertEquals(Arrays.asList(2), recorder.selected);
        assertEquals(2, strip.selectedIndex());
        assertEquals(ACCENT, strip.tabView(2).getCurrentTextColor());
        assertEquals(Color.WHITE, strip.tabView(0).getCurrentTextColor());
        assertTrue(recorder.tapped.isEmpty());
    }

    @Test
    public void aTapOnTheSelectedTabAsksForItsDialogAndSelectsNothing() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools");
        Recorder recorder = new Recorder();
        strip.setListener(recorder);
        strip.tabView(0).performClick();
        assertEquals(Arrays.asList(0), recorder.tapped);
        assertTrue(recorder.selected.isEmpty());
    }

    @Test
    public void selectingWithoutAnimationPutsTheUnderlineThereAtOnce() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools", "Games");
        strip.select(1, false);
        assertEquals(1f, strip.underlinePosition(), 0f);
        assertEquals(550f, strip.underlineLeft(), 0.01f);
    }

    @Test
    public void aDraggedPageMovesTheUnderlineBetweenTheTabsWithoutChangingTheSelection() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools", "Games");
        strip.followPosition(0.5f);
        assertEquals(0.5f, strip.underlinePosition(), 0f);
        assertEquals(300f, strip.underlineLeft(), 0.01f);
        assertEquals(0, strip.selectedIndex());
        strip.followPosition(-0.3f);
        assertEquals(0f, strip.underlinePosition(), 0f);
        strip.followPosition(5f);
        assertEquals(2f, strip.underlinePosition(), 0f);
    }

    @Test
    public void theGreyLineIsOnTheSideOfTheApps() {
        DrawerTabStrip strip = strip(1000, "Apps", "Tools");
        assertTrue(strip.isBarOnTop());
        // above the apps: the names, then the line
        assertEquals(2, strip.getChildCount());
        View lastOnTop = strip.getChildAt(1);
        assertFalse("the line, not the names", lastOnTop instanceof android.widget.HorizontalScrollView);
        strip.setBarOnTop(false);
        assertFalse(strip.isBarOnTop());
        // below the apps: the line first
        assertSame(lastOnTop, strip.getChildAt(0));
    }

    @Test
    public void aNameLongerThanItsTabRunsAsAMarquee() {
        DrawerTabStrip strip = strip(1000, "A very long name of a tab that does not fit", "Tools");
        assertEquals(android.text.TextUtils.TruncateAt.MARQUEE, strip.tabView(0).getEllipsize());
        assertTrue(strip.tabView(0).isSelected());
    }
}
