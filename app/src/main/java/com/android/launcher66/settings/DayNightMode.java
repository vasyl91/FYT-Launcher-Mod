package com.android.launcher66.settings;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.util.Log;

import androidx.preference.PreferenceManager;

/**
 * Runs at the sunrise/sunset scheduled by SunTask.
 *
 * The job only marks the moment. It no longer decides what to show and no longer touches the
 * wallpaper itself. The previous version flipped the wallpaper on its own, which caused:
 *  - day -> black -> day after a wake: its write was not recorded in SunTask's bookkeeping
 *    (wallpaperState / wallpaperId) and went to system+lock instead of system only, so the next
 *    SunTask run saw "not applied" and set the same wallpaper again;
 *  - a wrong wallpaper after a long sleep: the flip was based on the last stored day flag, not on
 *    the current time, and a job left pending over the sleep fired late, right after the wake;
 *  - no brightness switch: brightness was chosen from the same stale flag, so the job kept the
 *    previous one (night brightness with the day wallpaper at sunrise).
 *
 * Now it starts a SunTask, which works out day/night from the current time, applies wallpaper and
 * brightness through the same checked path as every other refresh and schedules the next job.
 */
public class DayNightMode extends JobService {

    private static final String TAG = "DayNightMode";

    @Override
    public boolean onStartJob(JobParameters params) {
        Context context = getApplicationContext();
        if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean(Keys.NIGHT_MODE, false)) {
            Log.i(TAG, "Job started, night mode is off - nothing to do");
            return false;
        }

        Log.i(TAG, "Job started, refreshing day/night state");
        if (!NightModeService.startSunTaskForSavedLocation(context, "DayNightMode job")) {
            Log.w(TAG, "No saved location, cannot refresh day/night state");
        }

        // Nothing is kept running inside the job: SunTask outlives it and schedules the next job
        // under the same ID, which would stop this run if it were still active.
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        // onStartJob() never keeps the job running, so there is nothing to stop.
        // The SunTask is not tied to the job and must not be cancelled from here.
        return false;
    }
}
