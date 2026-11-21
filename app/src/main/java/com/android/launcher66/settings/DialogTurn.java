package com.android.launcher66.settings;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * The plain dialogs of a settings screen across a turn of the screen: what goes into SettingsDialogMemory (which
 * has the rule) and how it comes out again.
 */
final class DialogTurn {

    private DialogTurn() {
    }

    /**
     * Call in onDestroyView before the dialogs are dismissed. Only when the view goes for a turn (the activity is
     * changing its configuration): the first of the keys whose dialog shows is kept, with what it was opened for
     * and the texts of its fields. List a dialog that opens over another one before that one.
     */
    static void keep(Fragment fragment, int screen, String[] keys, Function<String, Dialog> dialogs,
                     Function<String, String> args) {
        Activity activity = fragment.getActivity();
        if (activity == null || !activity.isChangingConfigurations()) {
            return;
        }
        for (String key : keys) {
            Dialog dialog = dialogs.apply(key);
            if (dialog != null && dialog.isShowing()) {
                SettingsDialogMemory.keep(screen, key, args.apply(key), texts(dialog));
                return;
            }
        }
    }

    /** Opens a row's dialog the way a tap on the row does; false when there is no such row. */
    static boolean tap(Preference row) {
        if (row == null || row.getOnPreferenceClickListener() == null) {
            return false;
        }
        row.getOnPreferenceClickListener().onPreferenceClick(row);
        return true;
    }

    /** The dialog opened again: its fields get the kept texts, in order; the cursor at the end of each. */
    static void fill(Dialog dialog, List<String> texts) {
        if (dialog == null || texts == null || texts.isEmpty()) {
            return;
        }
        List<EditText> fields = fields(dialog);
        for (int i = 0; i < fields.size() && i < texts.size(); i++) {
            EditText field = fields.get(i);
            field.setText(texts.get(i));
            field.setSelection(field.getText().length());
        }
    }

    /** The texts of a dialog's fields, in the order the fields have in it. */
    static List<String> texts(Dialog dialog) {
        List<String> out = new ArrayList<>();
        for (EditText field : fields(dialog)) {
            out.add(field.getText().toString());
        }
        return out;
    }

    private static List<EditText> fields(Dialog dialog) {
        List<EditText> out = new ArrayList<>();
        Window window = dialog.getWindow();
        if (window != null) {
            collect(window.getDecorView(), out);
        }
        return out;
    }

    private static void collect(View view, List<EditText> out) {
        if (view instanceof EditText) {
            out.add((EditText) view);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                collect(group.getChildAt(i), out);
            }
        }
    }
}
