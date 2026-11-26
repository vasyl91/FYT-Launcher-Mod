package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The accent colour of the settings reaches what is coloured with the default accent: a text, a switch, a progress, a
 * background, a check box; and again when the colour is changed, and not when "Stock layout" is on.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class AccentPainterTest {

    private static final int RED = 0xffd32f2f;
    private static final int GREEN = 0xff2e7d32;

    private static Context context() {
        return new ContextThemeWrapper(RuntimeEnvironment.getApplication(),
                androidx.appcompat.R.style.Theme_AppCompat);
    }

    private static int checkedColor(ColorStateList list) {
        return list.getColorForState(new int[] {android.R.attr.state_checked}, list.getDefaultColor());
    }

    private static int uncheckedColor(ColorStateList list) {
        return list.getColorForState(new int[0], list.getDefaultColor());
    }

    @Test
    public void aTextInTheDefaultAccentTakesTheChosenOneAndTheNextChoiceToo() {
        Context context = context();
        LinearLayout root = new LinearLayout(context);
        TextView accent = new TextView(context);
        accent.setTextColor(ThemeAccent.DEFAULT);
        TextView other = new TextView(context);
        other.setTextColor(0xff123456);
        root.addView(accent);
        root.addView(other);

        AccentPainter.paint(root, RED);
        assertEquals(RED, accent.getCurrentTextColor());
        assertEquals(0xff123456, other.getCurrentTextColor());
        // it is found again though it no longer has the default colour
        AccentPainter.paint(root, GREEN);
        assertEquals(GREEN, accent.getCurrentTextColor());
        assertEquals(0xff123456, other.getCurrentTextColor());
    }

    @Test
    public void aViewTaggedAccentIsColouredWhateverItsColourIs() {
        Context context = context();
        TextView tagged = new TextView(context);
        tagged.setTextColor(0xff000000);
        tagged.setTag(RuntimeEnvironment.getApplication().getString(R.string.tag_accent));
        AccentPainter.paint(tagged, RED);
        assertEquals(RED, tagged.getCurrentTextColor());
    }

    @Test
    public void everySwitchIsInTheAccentOnAndGreyOff() {
        Context context = context();
        SwitchCompat toggle = new SwitchCompat(context);
        AccentPainter.paintSwitch(toggle, RED);
        assertEquals(RED, checkedColor(toggle.getThumbTintList()));
        assertEquals(0xffececec, uncheckedColor(toggle.getThumbTintList()));
        int trackOn = checkedColor(toggle.getTrackTintList());
        assertEquals("the track on is the accent lighter, half transparent", 0x80, trackOn >>> 24);
        assertEquals(ThemeAccent.lighter(RED) & 0x00ffffff, trackOn & 0x00ffffff);
        assertEquals(0x60808080, uncheckedColor(toggle.getTrackTintList()));
        // a switch anywhere in a tree is painted, whatever its colours are
        FrameLayout root = new FrameLayout(context);
        SwitchCompat inner = new SwitchCompat(context);
        root.addView(inner);
        AccentPainter.paint(root, GREEN);
        assertEquals(GREEN, checkedColor(inner.getThumbTintList()));
        AccentPainter.paint(root, RED);
        assertEquals(RED, checkedColor(inner.getThumbTintList()));
    }

    @Test
    public void aProgressInTheDefaultAccentAndABackgroundOfIt() {
        Context context = context();
        FrameLayout root = new FrameLayout(context);
        SeekBar seek = new SeekBar(context);
        seek.setProgressTintList(ColorStateList.valueOf(ThemeAccent.DEFAULT));
        View box = new View(context);
        box.setBackgroundColor(ThemeAccent.DEFAULT);
        View shape = new View(context);
        GradientDrawable fill = new GradientDrawable();
        fill.setColor(ThemeAccent.DEFAULT);
        shape.setBackground(fill);
        View untouched = new View(context);
        untouched.setBackgroundColor(0xff445566);
        root.addView(seek);
        root.addView(box);
        root.addView(shape);
        root.addView(untouched);

        AccentPainter.paint(root, RED);
        assertEquals(RED, seek.getProgressTintList().getDefaultColor());
        assertEquals(RED, ((ColorDrawable) box.getBackground()).getColor());
        assertEquals(RED, ((GradientDrawable) shape.getBackground()).getColor().getDefaultColor());
        assertEquals(0xff445566, ((ColorDrawable) untouched.getBackground()).getColor());
        AccentPainter.paint(root, GREEN);
        assertEquals(GREEN, seek.getProgressTintList().getDefaultColor());
        assertEquals(GREEN, ((ColorDrawable) box.getBackground()).getColor());
    }

    @Test
    public void aCheckBoxIsInTheAccentWhenChecked() {
        Context context = context();
        CheckBox box = new CheckBox(context);
        AccentPainter.paint(box, RED);
        ColorStateList tint = androidx.core.widget.CompoundButtonCompat.getButtonTintList(box);
        assertEquals(RED, checkedColor(tint));
        assertTrue(uncheckedColor(tint) != RED);
    }

    @Test
    public void theAccentIsTheChosenOneWithTheCreatorOnAndTheDefaultWithTheStockLayout() {
        Context app = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(app);
        prefs.edit().clear().putInt(ThemeAccent.KEY, RED).putBoolean(Keys.USER_LAYOUT, true).commit();
        TextView text = new TextView(context());
        text.setTextColor(ThemeAccent.DEFAULT);
        AccentPainter.paint(text);
        assertEquals(RED, text.getCurrentTextColor());
        // "Stock layout": the default comes back
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        AccentPainter.paint(text);
        assertEquals(ThemeAccent.DEFAULT, text.getCurrentTextColor());
    }
}
