package com.android.launcher66.settings;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Handler;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The automatic canbus code check: while the car is driven, the launcher records the canbus codes like
 * the code reader does, so that a unit whose codes the library does not know (or has wrong) gets the
 * speed, RPM, fuel and range codes of its car without the owner starting the reader. It lives in
 * the process of {@link CanbusService}, which hands it the GPS fixes; the rules are in
 * {@link CanbusAutoCheckPolicy}.
 *
 * <p>It starts 2 minutes after the car was first seen moving (a GPS speed above 5 km/h), provided it
 * moved within the last 30 seconds when that time comes; it runs for the code reader's recording time
 * (300 s unless set otherwise) and stops without a result when the unit sleeps or ACC goes off, the
 * car changes, the service ends or the reader is started by hand. At the end the guesses go where the
 * reader's go (the Canbus codes window shows them) and, as {@link AutoCodes}, for the service. It
 * writes no file and shows nothing: one line in the log says what it found.
 *
 * <p>All entry points are for the main thread; the binder calls and the analysis run on a background
 * thread of its own.
 */
final class CanbusAutoCheck {

    private static final String TAG = "CanbusAutoCheck";

    private final Context app;
    private final SharedPreferences prefs;
    private final Handler main;
    private final ExecutorService worker = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "CanbusAutoCheck");
        t.setDaemon(true);
        return t;
    });

    /** The car the state below is of; 0 = none read yet. */
    private int stateCarId;
    private CanbusAutoCheckPolicy.Record state = CanbusAutoCheckPolicy.Record.NONE;
    /** When a GPS fix last showed the car moving (wall clock), 0 = not since the last check. */
    private long lastMovingAt;
    private boolean permissionLogged;
    private Runnable startTask;
    private Runnable endTask;
    /** The recording in progress; null while there is none. */
    private CanbusRecorder recorder;
    private int recordingCarId;
    private boolean destroyed;

    CanbusAutoCheck(Context context, Handler main) {
        this.app = context.getApplicationContext();
        this.prefs = PreferenceManager.getDefaultSharedPreferences(this.app);
        this.main = main;
    }

    /** A fix from the service's location updates. */
    void onLocation(Location location) {
        if (destroyed || location == null || !location.hasSpeed()) {
            return;
        }
        double kmh = location.getSpeed() * 3.6;
        long now = System.currentTimeMillis();
        if (recorder != null) {
            recorder.addFix(location);
            return;
        }
        if (!CanbusAutoCheckPolicy.isMoving(kmh)) {
            return;
        }
        lastMovingAt = now;
        if (startTask == null && conditionsMet(false)) {
            startTask = this::start;
            main.postDelayed(startTask, CanbusAutoCheckPolicy.START_DELAY_MS);
            Log.i(TAG, "movement seen, the check starts in " + CanbusAutoCheckPolicy.START_DELAY_MS / 1000 + " s");
        }
    }

    /** The car (its id in DataCanbus) was set or changed. */
    void onCarChanged(int carId) {
        if (recorder != null && carId != recordingCarId) {
            interrupt("the car changed");
        }
    }

    /** The unit goes to sleep or ACC goes off, a code reader starts, ...: a check in progress is dropped. */
    void interrupt(String why) {
        cancelStart();
        if (recorder == null) {
            return;
        }
        final CanbusRecorder dropped = recorder;
        final int carId = recordingCarId;
        recorder = null;
        if (endTask != null) {
            main.removeCallbacks(endTask);
            endTask = null;
        }
        dropped.discard();
        setState(carId, state.ended(CanbusAutoCheckPolicy.State.INTERRUPTED, System.currentTimeMillis()));
        Log.i(TAG, "interrupted car=" + carId + " (" + why + ")");
        worker.execute(() -> {
            dropped.unregisterCodesInBatches();
            dropped.release();
        });
    }

    void destroy() {
        interrupt("the service ended");
        destroyed = true;
        worker.shutdown();
    }

    private void cancelStart() {
        if (startTask != null) {
            main.removeCallbacks(startTask);
            startTask = null;
        }
    }

    /** Whether the check may run now; the lack of the GPS permission is said once. */
    private boolean conditionsMet(boolean forStart) {
        int carId = DataCanbus.DATA[1000];
        if (carId <= 0 || !LauncherApplication.isFytDevice()) {
            return false;
        }
        boolean layout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean stats = prefs.getBoolean(Keys.USER_STATS, false);
        boolean reader = new Helpers().codeInspectorBoolean();
        loadState(carId);
        if (!CanbusAutoCheckPolicy.mayRun(true, layout, stats, carId, reader, state)) {
            return false;
        }
        if (ContextCompat.checkSelfPermission(app, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (!permissionLogged) {
                permissionLogged = true;
                Log.i(TAG, "no location permission, the check does not run");
            }
            return false;
        }
        return true;
    }

    /** The state of the car from the settings; what it was when the service started if it was running then. */
    private void loadState(int carId) {
        if (stateCarId == carId) {
            return;
        }
        stateCarId = carId;
        state = CanbusAutoCheckPolicy.afterRestart(CanbusAutoCheckPolicy.Record.parse(
                prefs.getString(Keys.CANBUS_AUTO_CHECK_PREFIX + carId, null)));
    }

    private void setState(int carId, CanbusAutoCheckPolicy.Record record) {
        stateCarId = carId;
        state = record;
        prefs.edit().putString(Keys.CANBUS_AUTO_CHECK_PREFIX + carId, record.serialize()).apply();
    }

    /** The delay has passed: start if the car still moves and nothing changed. */
    private void start() {
        startTask = null;
        long now = System.currentTimeMillis();
        if (destroyed || !CanbusAutoCheckPolicy.movedRecently(lastMovingAt, now)) {
            Log.i(TAG, "the car does not move any more, waiting for the next movement");
            lastMovingAt = 0L;
            return;
        }
        if (!conditionsMet(true)) {
            return;
        }
        final int carId = DataCanbus.DATA[1000];
        setState(carId, state.started(now));
        recordingCarId = carId;
        final CanbusRecorder rec = new CanbusRecorder(Collections.<Integer>emptySet());
        recorder = rec;
        int seconds = timeoutSeconds();
        Log.i(TAG, "started car=" + carId + " attempt=" + state.attempts + " for " + seconds + " s");
        worker.execute(() -> {
            // The request first: a car that waits for it reports its fuel and range only after
            try {
                CanbusLibrary.sendForCar(app, carId).get(5, TimeUnit.SECONDS);
            } catch (Exception e) {
                Log.w(TAG, "The request of the car was not sent: " + e);
            }
            rec.begin(System.currentTimeMillis());
            rec.registerCodes();
        });
        endTask = () -> finish(rec, carId);
        main.postDelayed(endTask, seconds * 1000L);
    }

    private int timeoutSeconds() {
        try {
            return Math.max(60, Integer.parseInt(prefs.getString(Keys.CODE_INSPECTOR_TIMEOUT, "300")));
        } catch (NumberFormatException e) {
            return 300;
        }
    }

    /** The recording time has passed. */
    private void finish(CanbusRecorder rec, int carId) {
        endTask = null;
        if (rec != recorder) {
            return;
        }
        recorder = null;
        if (DataCanbus.DATA[1000] != carId) {
            rec.discard();
            setState(carId, state.ended(CanbusAutoCheckPolicy.State.INTERRUPTED, System.currentTimeMillis()));
            Log.i(TAG, "interrupted car=" + carId + " (the car changed)");
            worker.execute(() -> {
                rec.unregisterCodesInBatches();
                rec.release();
            });
            return;
        }
        final CanbusAutoCheckPolicy.Record before = state;
        worker.execute(() -> analyse(rec, carId, before));
    }

    /** Background thread. */
    private void analyse(CanbusRecorder rec, int carId, CanbusAutoCheckPolicy.Record before) {
        List<CanbusCodeEstimator.GpsFix> fixes = rec.fixes();
        CanbusRecorder.Snapshot snapshot = rec.freeze();
        rec.unregisterCodesInBatches();
        rec.release();
        long drivingMs = drivingMs(fixes);
        CanbusAutoCheckPolicy.State outcome = CanbusAutoCheckPolicy.outcome(drivingMs, fixes.size());
        long now = System.currentTimeMillis();
        try {
            if (outcome == CanbusAutoCheckPolicy.State.DONE) {
                CanbusAnalysis.Result result = CanbusAnalysis.analyse(app, snapshot.events, fixes, carId);
                ReaderGuesses kept = CanbusAnalysis.saveGuesses(prefs, carId, result.guesses, rec.startTime());
                ReaderGuesses found = ReaderGuesses.of(result.guesses, rec.startTime());
                AutoCodes codes = AutoCodes.of(found.fuel, found.range, result.libraryPairs, result.samples);
                prefs.edit().putString(AutoCodes.key(carId), codes.serialize()).apply();
                Log.i(TAG, "done car=" + carId + " speed=" + found.speed + " rpm=" + found.rpm + " fuel=" + found.fuel
                        + " range=" + found.range + " librarySilent=fuel:" + codes.fuelSilent + ",range:"
                        + codes.rangeSilent + " notFound=["
                        + (result.guesses == null ? "?" : result.guesses.notFoundLine().replace("Not found: ", ""))
                        + "]" + (kept == null ? "" : " kept=" + kept.codesText()));
            } else {
                Log.i(TAG, "failed car=" + carId + " driving=" + drivingMs / 1000 + " s fixes=" + fixes.size()
                        + ", it runs again at the next drive");
            }
        } catch (RuntimeException e) {
            outcome = CanbusAutoCheckPolicy.State.FAILED;
            Log.w(TAG, "The check could not be analysed", e);
            FytCompat.report("canbus.autocheck", e);
        }
        final CanbusAutoCheckPolicy.State end = outcome;
        main.post(() -> {
            if (!destroyed) {
                setState(carId, before.ended(end, now));
                CanbusService.readerGuessesChanged();
            }
        });
    }

    /** The time between the first and the last fix above the moving speed. */
    static long drivingMs(List<CanbusCodeEstimator.GpsFix> fixes) {
        long first = -1L;
        long last = -1L;
        for (CanbusCodeEstimator.GpsFix f : fixes) {
            if (CanbusAutoCheckPolicy.isMoving(f.kmh)) {
                if (first < 0) {
                    first = f.t;
                }
                last = f.t;
            }
        }
        return first < 0 ? 0L : last - first;
    }
}
