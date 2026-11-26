package com.android.launcher66.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.android.launcher66.AccentPainter;
import com.android.launcher66.R;
import com.android.launcher66.ThemeAccent;

/**
 * The look of the settings' dialogs.
 *
 * <p>The rule: <b>every dialog of the settings has the colours of the settings</b> (the owner, 2026-11-20): their
 * dark surface ({@code dark_surface}) in a frame of the dividers' grey, white text, grey secondary text and hints,
 * and the settings' blue ({@code colorAccent}) for the buttons and the active field. The theme is
 * {@code R.style.SettingsDialog}; every dialog is built with {@link #builder(Context)} (or that theme, for a plain
 * Dialog), so there is one place for it. They were light AppCompat dialogs over the dark settings before.
 *
 * <p>A field made with the settings' own context (not the dialog's) takes its colours from
 * {@link #styleField(EditText)}, since that context's theme is not the dialog's.
 */
public final class SettingsDialogs {

    /** The theme of a settings dialog, also for a plain {@code Dialog} (ProgressDialog). */
    public static final int THEME = R.style.SettingsDialog;

    private SettingsDialogs() {
    }

    /** A builder of a settings dialog; inflate its views with {@code builder.getContext()}. */
    public static AlertDialog.Builder builder(Context context) {
        return new AccentBuilder(context);
    }

    /** The builder of a settings dialog: the dialog it makes is painted with the accent when it is shown (AccentPainter). */
    private static final class AccentBuilder extends AlertDialog.Builder {
        AccentBuilder(Context context) {
            super(context, THEME);
        }

        @Override
        public AlertDialog create() {
            AlertDialog dialog = super.create();
            AccentPainter.watch(dialog);
            return dialog;
        }
    }

    /** A field of a settings dialog: white text, grey hint, the settings' blue for its line. */
    public static void styleField(EditText field) {
        Context context = field.getContext();
        field.setTextColor(ContextCompat.getColor(context, R.color.white));
        field.setHintTextColor(ContextCompat.getColor(context, R.color.gray_medium));
        field.setBackgroundTintList(ColorStateList.valueOf(ThemeAccent.color(context)));
    }
}
