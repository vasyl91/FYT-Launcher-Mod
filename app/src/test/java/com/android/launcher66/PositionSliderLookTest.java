package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.SeekBar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The music widget's position slider: its line and its knob lie in the middle of the row and the knob and the
 * played part have the colour of the widget's tint, now and after a change of it in the settings.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class PositionSliderLookTest {

    private static SeekBar slider(int rowPx) {
        Context context = RuntimeEnvironment.getApplication();
        SeekBar slider = new SeekBar(context);
        slider.setProgressDrawable(context.getDrawable(R.drawable.music_position_track));
        slider.setMax(PositionSlider.MAX);
        slider.setProgress(400);
        PositionSliderLook.size(slider, rowPx);
        return slider;
    }

    private static void layout(SeekBar slider, int width, int height) {
        slider.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
        slider.layout(0, 0, width, height);
    }

    private static int knobColor(SeekBar slider) {
        return ((GradientDrawable) slider.getThumb()).getColor().getDefaultColor();
    }

    @Test
    public void theLineAndTheKnobAreInTheMiddleOfTheRowAndThinnerThanTheKnob() {
        SeekBar slider = slider(60);
        layout(slider, 800, 60);
        Rect line = slider.getProgressDrawable().getBounds();
        Rect knob = slider.getThumb().getBounds();
        assertEquals(30, line.centerY(), 1);
        assertEquals(30, knob.centerY(), 1);
        int knobPx = SliderGeometry.knobPx(60);
        assertEquals(knobPx, knob.height(), 1);
        // the line is a quarter of the knob, at least 2 dp: thinner than the knob
        assertTrue("the line " + line.height() + " is thinner than the knob " + knob.height(),
                line.height() < knob.height());
        int expectedLine = SliderGeometry.linePx(knobPx, RuntimeEnvironment.getApplication().getResources()
                .getDisplayMetrics().density);
        assertEquals(expectedLine, line.height(), 1);
    }

    @Test
    public void theKnobIsWhiteWithoutATintAndHasTheTintWithOne() {
        SeekBar slider = slider(60);
        assertEquals(0xffffffff, knobColor(slider));
        PositionSliderLook.tint(slider, 0xff00aa55);
        assertEquals(0xff00aa55, knobColor(slider));
        PositionSliderLook.tint(slider, 0xffcc3300);
        assertEquals(0xffcc3300, knobColor(slider));
        PositionSliderLook.tint(slider, ViewTint.NONE);
        assertEquals(0xffffffff, knobColor(slider));
    }

    @Test
    public void aNewKnobAfterAResizeKeepsTheTint() {
        SeekBar slider = slider(40);
        PositionSliderLook.tint(slider, 0xff112233);
        PositionSliderLook.size(slider, 80);
        assertEquals(0xff112233, knobColor(slider));
        assertEquals(SliderGeometry.knobPx(80), slider.getThumb().getIntrinsicWidth());
    }

    @Test
    public void aKnobThatIsHiddenStaysHiddenWhenTheSliderIsSizedAgain() {
        SeekBar slider = slider(40);
        slider.getThumb().setAlpha(0);
        PositionSliderLook.size(slider, 80);
        assertEquals(0, slider.getThumb().getAlpha());
    }
}
