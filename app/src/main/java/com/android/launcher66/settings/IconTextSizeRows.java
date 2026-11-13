package com.android.launcher66.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.android.launcher66.LauncherAppState;
import com.android.launcher66.R;

/**
 * The two rows that set the size of the text under the icons: in the app drawer and on the home screen.
 * They stood under "Miscellaneous" on the first screen of the settings and now stand with the rows and
 * columns under "Home screen layout" on the second one. Their keys and what is stored under them are the
 * same as before, so a size that was set stays set; only the code that shows the rows moved here, out of
 * the fragment of the first screen.
 */
final class IconTextSizeRows {

    private static final String TAG = "IconTextSizeRows";

    private final PreferenceFragmentCompat fragment;
    private final SharedPreferences prefs;
    private final Helpers helpers;
    private AlertDialog dialog;

    IconTextSizeRows(PreferenceFragmentCompat fragment, SharedPreferences prefs, Helpers helpers) {
        this.fragment = fragment;
        this.prefs = prefs;
        this.helpers = helpers;
    }

    /** Shows the stored sizes in the two rows and opens the dialog on a tap. */
    void bind() {
        bind(Keys.ALL_APPS_TEXT_SIZE, "18", R.string.all_apps_textSize_str, true);
        bind(Keys.WORKSPACE_TEXT_SIZE, "28", R.string.workspace_textSize_str, false);
    }

    /** With the fragment's view: a dialog must not outlive it. */
    void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = null;
    }

    private void bind(String key, String fallback, int title, boolean drawer) {
        Preference row = fragment.findPreference(key);
        if (row == null) {
            return;
        }
        row.setSummary(prefs.getString(key, fallback));
        row.setOnPreferenceClickListener(preference -> {
            show(row, key, fallback, title, drawer);
            return true;
        });
    }

    private void show(Preference row, String key, String fallback, int title, boolean drawer) {
        Context context = fragment.requireContext();
        EditText input = new EditText(context);
        input.setFilters(new InputFilter[] {new InputFilterMinMax("0", "50")});
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        input.setImeOptions(EditorInfo.IME_ACTION_DONE);
        input.setText(row.getSummary());
        input.setTextColor(ContextCompat.getColor(context, R.color.black));

        dismiss();
        dialog = new AlertDialog.Builder(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert)
                .setTitle(title)
                .setView(input)
                .setPositiveButton(R.string.set_btn, (d, which) -> save(row, key, fallback, drawer, input))
                .setNegativeButton(R.string.cancel_btn, (d, which) -> d.dismiss())
                .create();
        final AlertDialog shown = dialog;
        input.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save(row, key, fallback, drawer, input);
                shown.dismiss();
            }
            return false;
        });
        shown.show();

        // As the other number dialogs of the settings: the buttons apart, the field with a margin
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
        input.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT);
        }
        input.setSelection(input.getText().length());
    }

    private void save(Preference row, String key, String fallback, boolean drawer, EditText input) {
        String value = input.getText().toString();
        if (value.isEmpty()) {
            value = fallback;
        }
        if (drawer) {
            helpers.allAppsTextSizeChanged(true);
            try {
                LauncherAppState.getInstance().getDynamicGrid().getDeviceProfile()
                        .updateIconTextSize(Integer.parseInt(value));
            } catch (RuntimeException e) {
                // The stored text is what the launcher reads at its next start; this was only the running one
                Log.w(TAG, "The drawer's text size could not be applied at once: " + e);
            }
        } else {
            helpers.workspaceTextSizeChanged(true);
        }
        row.setSummary(value);
        prefs.edit().putString(key, value).apply();
    }
}
