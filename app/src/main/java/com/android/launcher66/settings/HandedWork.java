package com.android.launcher66.settings;

/**
 * A piece of work started on a settings screen, and the screen that shows it now; free of android.* so that it has a
 * test. One per kind of work for the whole process (the download of an update, the save of a wallpaper, the import
 * of the CAN bus library): there is one settings activity.
 *
 * <p>The rule (the owner, 2026-11-21): <b>work started in the settings goes on through a turn of the screen, and its
 * progress and its end go to the screen that is there now</b>, which shows the work's dialog again with the last
 * progress. On a phone or a tablet a turn creates the settings again (SettingsActivity.onConfigurationChanged calls
 * recreate()); the work belonged to the old screen, so a download was cancelled with it, and a save or an import went
 * on with nothing to show it.
 * <ul>
 *   <li>while the old screen is gone and the new one is not there yet, the progress is kept for the new one;</li>
 *   <li>work the user sent to the background shows no dialog on a new screen, and its end is a toast;</li>
 *   <li>the settings left for good: the work does what it did before (a download is cancelled; a save or an import
 *       ends without a screen).</li>
 * </ul>
 * The work's callbacks hold no screen of their own: they ask this for the screen of now, so a screen that is gone is
 * not kept alive by them. Main thread only.
 *
 * @param <J> the work: what can be cancelled or asked about
 * @param <S> a screen
 */
public final class HandedWork<J, S> {

    private J job;
    private String what;
    private int[] progress;
    private boolean background;
    private S screen;

    /** The work begins on that screen; what it is for (a version, a time of day) comes back with it. */
    public void start(J job, String what, S screen) {
        this.job = job;
        this.what = what;
        this.progress = null;
        this.background = false;
        this.screen = screen;
    }

    public boolean running() {
        return job != null;
    }

    /** The work; null when none runs. */
    public J job() {
        return job;
    }

    public String what() {
        return what;
    }

    /** The work's last progress, for a screen that comes later. */
    public void progress(int... values) {
        if (job != null) {
            progress = values != null ? values.clone() : null;
        }
    }

    /** The last progress; null before the first. */
    public int[] lastProgress() {
        return progress != null ? progress.clone() : null;
    }

    /** The user sent the work to the background: no screen shows its dialog any more. */
    public void toBackground() {
        if (job != null) {
            background = true;
        }
    }

    public boolean inBackground() {
        return background;
    }

    /** The screen that shows the work now; null when there is none. */
    public S screen() {
        return screen;
    }

    /** A screen goes (for a turn, or for good): the work goes on, and nothing shows it until a screen joins. */
    public void leave(S gone) {
        if (screen == gone) {
            screen = null;
        }
    }

    /** A new screen shows the work from now on; the work, or null when none runs. */
    public J join(S screen) {
        if (job == null) {
            return null;
        }
        this.screen = screen;
        return job;
    }

    /** The work is over (done, failed or cancelled): nothing is kept. */
    public void end() {
        job = null;
        what = null;
        progress = null;
        background = false;
        screen = null;
    }
}
