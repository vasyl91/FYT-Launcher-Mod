package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.AccentPainter;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.ThemeAccent;
import com.android.launcher66.colorpicker.ColorPicker;

/**
 * The screen "Notification badges" (H2): the number of notifications on the icons (BadgeModel, BadgeDrawable).
 *
 * <p>One category, in this order: "Enable notification badges"; a preview, the launcher's icon in the size of the icons of
 * the home screen with a badge of "4" made from the settings below it (each change shows at once); the corner; the size
 * (a slider, 15 to 35 per cent of the seen icon); the corner radius (a slider, 0 a square, 100 a circle); the colour of
 * the badge (the accent while none was chosen); the outline.
 * With the first switch off everything below it is dimmed (SettingsRowDim) and does not respond, and is still seen. The settings are
 * the launcher's own and not the creator's: they work with the stock layout too (CreatorKeys has none). Back goes to
 * "Launcher settings".
 */
public class NotificationBadgesFragment extends PreferenceFragmentCompat {

    private static final String[] BELOW = {
            Keys.BADGES_PREVIEW, Keys.BADGES_POSITION, Keys.BADGES_SIZE_TITLE, Keys.BADGES_SIZE_PERCENT,
            Keys.BADGES_CORNER_TITLE, Keys.BADGES_CORNER,
            Keys.BADGES_COLOR, Keys.BADGES_OUTLINE
    };

    private SharedPreferences sharedPrefs;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                SettingsScrollMemory.betweenScreens();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new SettingsFragmentFirst()).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    /** The rows are drawn dimmed while they are off (SettingsRowDim). */
    @NonNull
    @Override
    protected RecyclerView.Adapter onCreateAdapter(@NonNull androidx.preference.PreferenceScreen preferenceScreen) {
        return new DimmingPreferenceAdapter(preferenceScreen);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        addPreferencesFromResource(R.xml.badge_preferences);
        Preference enabled = findPreference(Keys.BADGES_ENABLED);
        if (enabled != null) {
            enabled.setOnPreferenceChangeListener((preference, value) -> {
                setBelowEnabled(Boolean.TRUE.equals(value));
                return true;
            });
        }
        Preference color = findPreference(Keys.BADGES_COLOR);
        if (color != null) {
            color.setOnPreferenceClickListener(preference -> {
                showColorPicker();
                return true;
            });
        }
        setBelowEnabled(sharedPrefs.getBoolean(Keys.BADGES_ENABLED, true));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // The accent of the settings on every row as it is attached (ThemeAccent)
        AccentPainter.attach(getListView());
        setDivider(null);
        setDividerHeight(0);
        if (!LauncherApplication.isFytDevice()) {
            PreferenceScaleHelper.applySystemBarInsets(getListView());
        }
        // A colour picker the screen brought back stores its colour as before
        view.post(() -> ColorPickerTargets.rebind(getParentFragmentManager(), sharedPrefs,
                requireContext().getApplicationContext()));
    }

    private void setBelowEnabled(boolean enabled) {
        for (String key : BELOW) {
            Preference row = findPreference(key);
            if (row != null) {
                row.setEnabled(enabled);
            }
        }
    }

    /** "Badge color": the colour picker in its text mode; "Default" forgets the colour and the accent comes back. */
    private void showColorPicker() {
        int current = sharedPrefs.contains(Keys.BADGES_COLOR) ? sharedPrefs.getInt(Keys.BADGES_COLOR, Color.WHITE)
                : ThemeAccent.color(requireContext());
        ColorPicker picker = ColorPicker.newTextInstance(current, true);
        picker.enableAutoClose();
        ColorPickerTargets.bindTint(picker, sharedPrefs, Keys.BADGES_COLOR);
        picker.show(getParentFragmentManager(), ColorPickerTargets.TAG_BADGE);
    }
}
