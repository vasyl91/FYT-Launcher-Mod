package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.android.launcher66.AccentPainter;
import com.android.launcher66.DrawerAppList;
import com.android.launcher66.DrawerTabs;
import com.android.launcher66.DrawerTabsStore;
import com.android.launcher66.R;

/**
 * The dialogs of the drawer's tabs, used by the tab creator ({@link DrawerTabsFragment}) and by the drawer itself (a tap
 * on the tab that is selected): "Add drawer tab" (D2), "Edit drawer tab" (D1) and the question before a tab is deleted.
 *
 * <p>The rules (the owner, 2026-11-25):
 * <ul>
 *   <li>The name is any text of at most {@link DrawerTabs#MAX_NAME} characters (the field cuts what is pasted). A name of
 *       nothing visible adds no tab and changes none.</li>
 *   <li>"Keep apps in main app tab" is a checkbox and its text in one row: a tap on either changes it. The main tab has
 *       no such row. With a rule for apps in several tabs that makes the flag do nothing
 *       ({@link DrawerTabs#keepApplies}) the row is dimmed and says why.</li>
 *   <li>Edit has "Select apps" on the left (for the main tab "Hide apps") and Cancel and OK on the right. OK stores the name
 *       and the flag; the dialog closed in any other way, by a tap outside it or by Back, is Cancel.</li>
 *   <li>Every change is stored at once ({@link DrawerTabsStore#save}, {@code apply()}) and the {@link Host} told.</li>
 * </ul>
 */
public final class DrawerTabDialogs {

    /** Who shows the dialogs: told when the model changed, and asked to open a list of apps. */
    public interface Host {
        /** The model was changed and stored. */
        void changed();

        /** "Select apps" of a tab, or "Hide apps" ({@link DrawerAppList#HIDDEN}) of the main tab, was pressed. */
        void openApps(int tab);
    }

    private DrawerTabDialogs() {
    }

    /** "Add drawer tab": a name and the flag; OK adds the tab when the name is something. */
    public static AlertDialog showAdd(Context context, DrawerTabs model, SharedPreferences prefs, Host host) {
        AlertDialog.Builder builder = SettingsDialogs.builder(context);
        View view = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_drawer_tab, null);
        Fields fields = new Fields(view, model, false);
        AlertDialog dialog = builder.setTitle(R.string.add_drawer_tab)
                .setView(view)
                .setPositiveButton(android.R.string.ok, (d, which) -> {
                    if (model.add(fields.name(), fields.keep()) >= 0) {
                        DrawerTabsStore.save(prefs, model);
                        host.changed();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        show(dialog, fields);
        return dialog;
    }

    /** "Edit drawer tab": the name and the flag of a tab, and the way to its list of apps. */
    public static AlertDialog showEdit(Context context, DrawerTabs model, SharedPreferences prefs, int tab, Host host) {
        AlertDialog.Builder builder = SettingsDialogs.builder(context);
        View view = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_drawer_tab, null);
        boolean main = tab == DrawerTabs.MAIN;
        Fields fields = new Fields(view, model, main);
        fields.setName(model.nameOf(tab, context.getString(R.string.drawer_tab_main),
                context.getString(R.string.drawer_tab_default)));
        fields.setKeep(model.keepInMain(tab));
        AlertDialog dialog = builder.setTitle(R.string.edit_drawer_tab)
                .setView(view)
                .setPositiveButton(android.R.string.ok, (d, which) -> {
                    boolean changed = model.rename(tab, fields.name());
                    if (!main && model.keepApplies() && fields.keep() != model.keepInMain(tab)) {
                        model.setKeepInMain(tab, fields.keep());
                        changed = true;
                    }
                    if (changed) {
                        DrawerTabsStore.save(prefs, model);
                        host.changed();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .setNeutralButton(main ? R.string.hide_apps : R.string.select_apps,
                        (d, which) -> host.openApps(main ? DrawerAppList.HIDDEN : tab))
                .create();
        show(dialog, fields);
        return dialog;
    }

    /** The question before a tab is deleted; its apps go back where the rules put them. */
    public static AlertDialog confirmDelete(Context context, DrawerTabs model, SharedPreferences prefs, int tab, Host host) {
        String name = model.nameOf(tab, context.getString(R.string.drawer_tab_main),
                context.getString(R.string.drawer_tab_default));
        AlertDialog dialog = SettingsDialogs.builder(context)
                .setTitle(R.string.delete_drawer_tab_title)
                .setMessage(context.getString(R.string.delete_drawer_tab_message, name))
                .setPositiveButton(R.string.delete_drawer_tab_button, (d, which) -> {
                    if (model.delete(tab)) {
                        DrawerTabsStore.save(prefs, model);
                        host.changed();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
        return dialog;
    }

    private static void show(AlertDialog dialog, Fields fields) {
        if (dialog.getWindow() != null) {
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                    | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
        dialog.show();
        AccentPainter.paint(fields.root);
        fields.name.requestFocus();
        fields.name.selectAll();
    }

    /** The views of the dialog and what they hold. */
    private static final class Fields {
        final View root;
        final EditText name;
        final CheckBox check;
        private final boolean applies;

        Fields(View root, DrawerTabs model, boolean main) {
            this.root = root;
            name = root.findViewById(R.id.drawer_tab_name);
            check = root.findViewById(R.id.drawer_tab_keep_check);
            View row = root.findViewById(R.id.drawer_tab_keep_row);
            TextView note = root.findViewById(R.id.drawer_tab_keep_note);
            TextView text = root.findViewById(R.id.drawer_tab_keep_text);
            if (SettingsActivity.dialogTextView > 0) {
                float size = SettingsActivity.dialogTextView;
                name.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
            }
            // a longer name that is typed or pasted is cut to the longest there is
            name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DrawerTabs.MAX_NAME)});
            applies = model.keepApplies();
            if (main) {
                row.setVisibility(View.GONE);
            } else if (!applies) {
                row.setAlpha(0.5f);
                row.setEnabled(false);
                check.setEnabled(false);
                note.setVisibility(View.VISIBLE);
            } else {
                row.setOnClickListener(v -> check.toggle());
            }
        }

        String name() {
            return name.getText().toString();
        }

        void setName(String text) {
            name.setText(text);
        }

        boolean keep() {
            return check.isChecked();
        }

        void setKeep(boolean keep) {
            check.setChecked(keep);
        }
    }
}
