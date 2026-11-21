package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The dialog of a settings screen that was open when the screen turned, free of android.* so that it has a test.
 * One place for the whole process: there is one settings activity.
 *
 * <p>The rule (the owner, 2026-11-21): <b>a dialog that is open when the screen turns is open again after the
 * turn, with what the user typed into it.</b> On a phone or a tablet the settings are created again for the other
 * orientation (SettingsActivity.onConfigurationChanged calls recreate(): each orientation has its own density). A
 * DialogFragment comes back by itself with the new screen; a plain dialog belongs to the old screen and went with
 * it, so it had to be opened again by hand. Now:
 * <ul>
 *   <li>the old screen, as its view goes for the turn, keeps which dialog was open (the key it is opened with: the
 *       row's key, or a name of its own for a dialog no row opens), what it was opened for (a version, a message,
 *       a time of day), and the texts of its fields in their order;</li>
 *   <li>the new screen of the same number opens that dialog the way a tap on its row does, and puts the texts back
 *       into its fields;</li>
 *   <li>it is given once; another screen takes nothing, and the settings opened afresh forget it.</li>
 * </ul>
 * A FYT unit turns without a new activity (configChanges), so its dialogs simply stay. Main thread only.
 */
public final class SettingsDialogMemory {

    /** A kept dialog. */
    public static final class Kept {
        public final int screen;
        /** The key the dialog is opened with. */
        public final String dialog;
        /** What it was opened for; null when nothing. */
        public final String arg;
        /** The texts of its fields, in the order the fields have in the dialog. */
        public final List<String> fields;

        Kept(int screen, String dialog, String arg, List<String> fields) {
            this.screen = screen;
            this.dialog = dialog;
            this.arg = arg;
            this.fields = fields;
        }
    }

    private static Kept sKept;

    private SettingsDialogMemory() {
    }

    /** A screen's view goes for a turn with this dialog open. */
    public static void keep(int screen, String dialog, String arg, List<String> fields) {
        if (dialog == null) {
            return;
        }
        List<String> copy = fields != null ? new ArrayList<>(fields) : new ArrayList<>();
        sKept = new Kept(screen, dialog, arg, Collections.unmodifiableList(copy));
    }

    /** A screen is new: the dialog kept for that screen, given once; null when there is none. */
    public static Kept takeFor(int screen) {
        Kept kept = sKept;
        sKept = null;
        if (kept == null || kept.screen != screen) {
            return null;
        }
        return kept;
    }

    /** The settings are opened afresh: nothing is kept. */
    public static void forget() {
        sKept = null;
    }
}
