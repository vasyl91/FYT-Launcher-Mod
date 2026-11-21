package com.android.launcher66.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.InputType;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.android.launcher66.R;
import com.syu.weather.WeatherKey;

/**
 * The row of the settings for an OpenWeather key of the user's own (WeatherKey has the rule).
 *
 * <p>The row shows whether the built-in key or the user's is in use (of the user's only the last four
 * characters). Its dialog has one field: an empty field goes back to the built-in key, a key is stored, and
 * anything that is not a key is refused with a message and leaves what was stored. The weather takes the key
 * at its next request.
 */
final class WeatherKeyRow {

    private final PreferenceFragmentCompat fragment;
    private final SharedPreferences prefs;
    private AlertDialog dialog;

    WeatherKeyRow(PreferenceFragmentCompat fragment, SharedPreferences prefs) {
        this.fragment = fragment;
        this.prefs = prefs;
    }

    void bind() {
        Preference row = fragment.findPreference(Keys.OPENWEATHER_API_KEY);
        if (row == null) {
            return;
        }
        showState(row);
        row.setOnPreferenceClickListener(preference -> {
            show(row);
            return true;
        });
    }

    /** The open dialog, kept across a turn of the screen (SettingsDialogMemory); null when none. */
    AlertDialog openDialog() {
        return dialog;
    }

    /** With the fragment's view: a dialog must not outlive it. */
    void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = null;
    }

    private void showState(Preference row) {
        String shown = WeatherKey.shown(prefs.getString(Keys.OPENWEATHER_API_KEY, ""));
        row.setSummary(shown != null ? shown : fragment.getString(R.string.openweather_key_summary));
    }

    private void show(Preference row) {
        Context context = fragment.requireContext();
        EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        input.setImeOptions(EditorInfo.IME_ACTION_DONE);
        input.setSingleLine(true);
        input.setText(prefs.getString(Keys.OPENWEATHER_API_KEY, ""));
        SettingsDialogs.styleField(input);

        dismiss();
        dialog = SettingsDialogs.builder(context)
                .setTitle(R.string.openweather_key_title)
                .setView(input)
                .setPositiveButton(R.string.set_btn, (d, which) -> save(row, input))
                .setNegativeButton(R.string.cancel_btn, (d, which) -> d.dismiss())
                .create();
        final AlertDialog shown = dialog;
        input.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save(row, input);
                shown.dismiss();
            }
            return false;
        });
        // One field: the keyboard opens with the dialog (DialogKeyboard)
        DialogKeyboard.openFor(shown, input);
        shown.show();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 80, 0);
        Button negative = shown.getButton(DialogInterface.BUTTON_NEGATIVE);
        if (negative != null) {
            negative.setLayoutParams(params);
        }
        ViewGroup.LayoutParams inputParams = input.getLayoutParams();
        if (inputParams instanceof ViewGroup.MarginLayoutParams) {
            int padding = SettingsActivity.dialogPadding;
            ((ViewGroup.MarginLayoutParams) inputParams).setMargins(padding, padding, padding, padding);
            input.setLayoutParams(inputParams);
        }
    }

    private void save(Preference row, EditText input) {
        String typed = input.getText().toString().trim();
        if (typed.isEmpty()) {
            prefs.edit().remove(Keys.OPENWEATHER_API_KEY).apply();
        } else if (WeatherKey.valid(typed)) {
            prefs.edit().putString(Keys.OPENWEATHER_API_KEY, typed).apply();
        } else {
            Toast.makeText(fragment.requireContext(), R.string.openweather_key_invalid, Toast.LENGTH_LONG).show();
            return;
        }
        showState(row);
    }
}
