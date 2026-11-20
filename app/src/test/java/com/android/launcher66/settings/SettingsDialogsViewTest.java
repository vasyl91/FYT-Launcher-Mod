package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import android.content.DialogInterface;
import android.os.Looper;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

/**
 * A dialog of the settings has the colours of the settings (the owner, 2026-11-20): their dark surface, white
 * text, the settings' blue for the buttons, and a field with white text and a grey hint.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class SettingsDialogsViewTest {

    @Test
    public void aDialogOfTheSettingsIsDarkWithWhiteTextAndBlueButtons() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsActivity activity = controller.get();
        AlertDialog dialog = SettingsDialogs.builder(activity)
                .setTitle("Margins")
                .setMessage("The margin of the elements")
                .setPositiveButton(android.R.string.ok, null)
                .create();
        dialog.show();
        shadowOf(Looper.getMainLooper()).idle();

        TypedValue surface = new TypedValue();
        dialog.getContext().getTheme().resolveAttribute(android.R.attr.colorBackgroundFloating, surface, true);
        assertEquals(ContextCompat.getColor(activity, R.color.dark_surface), surface.data);

        TextView message = dialog.findViewById(android.R.id.message);
        assertEquals(ContextCompat.getColor(activity, R.color.white), message.getCurrentTextColor());
        assertEquals(ContextCompat.getColor(activity, R.color.colorAccent),
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).getCurrentTextColor());

        EditText field = new EditText(activity);
        SettingsDialogs.styleField(field);
        assertEquals(ContextCompat.getColor(activity, R.color.white), field.getCurrentTextColor());
        assertEquals(ContextCompat.getColor(activity, R.color.gray_medium), field.getCurrentHintTextColor());

        dialog.dismiss();
        controller.pause().stop().destroy();
    }
}
