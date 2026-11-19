package com.android.launcher66;

import static org.junit.Assert.assertEquals;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The first page's vertical bar takes the width the launcher counts with (Launcher.calculatedVerticalBarWidth,
 * VerticalBarDimensions) in portrait, where its layout gives a share of its height, and in landscape, where it
 * gives a share of the layout's width: the width "Resizable vertical bar" sets is the width on the screen.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = Application.class)
public class VerticalBarWidthViewTest {

    private static int barWidth(int pageWidth, int pageHeight, int width) {
        Context context = RuntimeEnvironment.getApplication();
        FrameLayout parent = new FrameLayout(context);
        View page = LayoutInflater.from(context).inflate(R.layout.custom_layout_one_user_vertical, parent, false);
        parent.addView(page, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        BarConstraints.apply((ConstraintLayout) page, R.id.iv_list_bg, 0, false, false, false, width);
        parent.measure(View.MeasureSpec.makeMeasureSpec(pageWidth, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(pageHeight, View.MeasureSpec.EXACTLY));
        parent.layout(0, 0, pageWidth, pageHeight);
        return page.findViewById(R.id.rl_vertical_bar).getWidth();
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void inLandscapeTheBarHasTheWidthGiven() {
        assertEquals(142, barWidth(2000, 1128, 142));     // the 7862 without the option: as before
        assertEquals(200, barWidth(2000, 1128, 200));     // 10 % of the longer edge
        assertEquals(80, barWidth(2000, 1128, 80));       // 4 %
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port-mdpi")
    public void inPortraitTheBarHasTheWidthGiven() {
        assertEquals(142, barWidth(1080, 2116, 142));
        assertEquals(234, barWidth(1080, 2116, 234));
    }
}
