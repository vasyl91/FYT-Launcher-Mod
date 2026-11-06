package com.android.launcher66.settings;

import static com.android.launcher66.settings.Keys.CODE_INSPECTOR_TIMEOUT;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CanbusCodeInspector extends Service {

    /**
     * The canbus code reader. It registers for the codes 0..1199 straight with com.syu.ms (not through
     * DataCanbus.NOTIFY_EVENTS, which knows only the codes the callback of the car registered, and for a car
     * the launcher has no callback for only code 0), records every update of every code with its time for
     * the time set, and writes them to Download/Launcher66_Canbus. The file starts with guesses of what the
     * codes are (see {@link CanbusCodeEstimator}). It sends the car nothing but the request its fuel screen
     * sends when it opens, and only if the library knows the car.
     */
    private static final String TAG = "CanbusCodeInspector";

    /** The recording of the codes and of the GPS speed (shared with the automatic check). */
    private CanbusRecorder recorder;
    private volatile String requestDescription = CanbusLibrary.NONE;
    private int codeInspectorServiceTimeout;
    private AsyncTask<Void, Void, Void> schedulerTask;
    private final Helpers helpers = new Helpers();
    private CountDownTimer countDownTimer;
    private ScheduledExecutorService scheduler;
    private final ExecutorService batchExecutor = Executors.newSingleThreadExecutor();
    private volatile boolean isDataWritten = false; // Track if data has been saved
    private SharedPreferences sharedPrefs;
    private Set<Integer> skipCodes;
    /** Leave the codes that only sent 0 out of the file (the setting; read when the reader starts). */
    private boolean skipZeroCodes = true;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private volatile DeviceLocation.Handle locationUpdates;
    private volatile boolean gpsRecorded;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        codeInspectorServiceTimeout = Integer.parseInt(sharedPrefs.getString(CODE_INSPECTOR_TIMEOUT, "300"));
        skipCodes = getSkipCodes();
        skipZeroCodes = sharedPrefs.getBoolean(Keys.SKIP_ZERO_CODES, true);
        recorder = new CanbusRecorder(skipCodes);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started");
        runSchedulerTask(intent);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");

        // Shutdown components in optimized order
        shutdownScheduler();
        cancelCountdownTimer();
        cancelSchedulerTask();
        stopGps();

        // Save data if not already written
        if (!isDataWritten) {
            freezeAndSaveData();
        }

        helpers.setCodeInspectorBoolean(false);
        helpers.setCountDownInspector(0);

        // Unregister the callback off the main thread
        unregisterCodesInBatches();
    }

    private void freezeAndSaveData() {
        // Save data in background; writeDataToFile() stops the recording first
        batchExecutor.execute(() -> {
            writeDataToFile();
            mainHandler.post(() ->
                // The service may be destroyed by now: its own context is not used for the toast
                Toast.makeText(getApplicationContext(), R.string.code_inspector_toast, Toast.LENGTH_SHORT).show()
            );
        });
    }

    private void shutdownScheduler() {
        if (scheduler != null) {
            scheduler.shutdownNow();
        }
    }

    private void cancelCountdownTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void unregisterCodesInBatches() {
        batchExecutor.execute(() -> {
            recorder.unregisterCodesInBatches();
            // The recording was written by the task queued before this one
            recorder.release();
            batchExecutor.shutdown();
        });
    }

    private void writeDataToFile() {
        // A stable copy: from here on nothing is added
        CanbusRecorder.Snapshot snapshot = recorder.freeze();
        stopGps();
        List<CanbusCodeEstimator.GpsFix> fixes = recorder.fixes();
        long startTime = recorder.startTime();
        int carId = DataCanbus.DATA[1000];

        // The analysis and the guesses for the Canbus codes window first: a folder that cannot be made must not
        // cost the service the codes the reader found
        CanbusAnalysis.Result analysis = CanbusAnalysis.analyse(this, snapshot.events, fixes, carId);
        CanbusAnalysis.saveGuesses(sharedPrefs, carId, analysis.guesses, startTime);
        CanbusService.readerGuessesChanged();

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        String fileName = "CanbusCodes" + timestamp + ".txt";
        File directory = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), CanbusLibraryImport.CANBUS_DIR_NAME);

        if (!directory.exists() && !directory.mkdirs()) {
            Log.e(TAG, "Failed to create directory");
            return;
        }

        File file = new File(directory, fileName);
        CanbusCodeEstimator.Result guesses = analysis.guesses;
        Map<Integer, CanbusFrames.Channel> channels = analysis.channels;

        SimpleDateFormat lineTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Canbus reader, " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US)
                    .format(new Date(startTime)) + ", " + codeInspectorServiceTimeout + " s\n");
            writer.write(carLine() + "\n");
            int withBearing = 0;
            int withAltitude = 0;
            for (CanbusCodeEstimator.GpsFix f : fixes) {
                if (!Float.isNaN(f.bearing)) {
                    withBearing++;
                }
                if (!Double.isNaN(f.altitude)) {
                    withAltitude++;
                }
            }
            writer.write(gpsRecorded
                    ? "GPS speed: " + fixes.size() + " fixes, with bearing: " + withBearing + ", with altitude: "
                            + withAltitude + "\n"
                    : "GPS speed: not recorded (no location permission)\n");
            writer.write("Codes with data: " + analysis.withData + " (unchanged: " + analysis.unchanged
                    + (skipZeroCodes ? "; " + analysis.onlyZero + " sent only 0 and are left out" : "")
                    + "); events: " + snapshot.total + "; dropped: " + snapshot.dropped + "\n");
            if (!analysis.libraryLine.isEmpty()) {
                writer.write(analysis.libraryLine + "\n");
            }
            writer.write("\nLikely meanings (best guesses, may be wrong):\n");
            if (guesses != null) {
                for (CanbusCodeEstimator.Guess g : guesses.guesses) {
                    writer.write(g + "\n");
                }
                String notFound = guesses.notFoundLine();
                if (!notFound.isEmpty()) {
                    writer.write(notFound + "\n");
                }
                if (!guesses.addOnLines.isEmpty()) {
                    writer.write("\n");
                    for (String line : guesses.addOnLines) {
                        writer.write(line + "\n");
                    }
                }
            }
            writer.write("\n");
            if (!analysis.frameLines.isEmpty()) {
                for (String line : analysis.frameLines) {
                    writer.write(line + "\n");
                }
                writer.write("\n");
            }

            for (int code = 0; code < CanbusRecorder.CODES; code++) {
                if (skipCodes.contains(code)) {
                    continue;
                }
                ArrayList<CanbusRecorder.Event> list = snapshot.events.get(code);
                if (list == null || list.isEmpty()) {
                    continue;
                }
                if (skipZeroCodes && !channels.containsKey(code) && CanbusRecorder.sentOnlyZero(list)) {
                    continue;
                }
                writer.write("CODE: " + code + "\n");
                if (CanbusRecorder.isUnchanged(list)) {
                    writer.write(eventLine(lineTime, list.get(0)) + "\n");
                } else {
                    for (CanbusRecorder.Event e : list) {
                        writer.write(eventLine(lineTime, e) + "\n");
                    }
                }
                writer.write("\n");
            }
            // The fixes, to check the grade of the road on the next recordings; no latitude or longitude
            if (gpsRecorded && !fixes.isEmpty()) {
                writer.write("GPS:\n");
                for (CanbusCodeEstimator.GpsFix f : fixes) {
                    writer.write(CanbusCodeEstimator.gpsLine(lineTime, f) + "\n");
                }
                writer.write("\n");
            }
            isDataWritten = true; // Mark data as saved
        } catch (IOException e) {
            Log.e(TAG, "File write failed", e);
        }
    }

    private static String eventLine(SimpleDateFormat format, CanbusRecorder.Event e) {
        String time = format.format(new Date(e.t));
        String value = e.hasInt ? String.valueOf(e.v) : "-";
        return time + ": " + value + (e.extra.isEmpty() ? "" : " [" + e.extra + "]");
    }

    /** {@code Car: id 163 (protocol 163, car 0), class ..., callback Callback_0163_..., request: 70:51; 29:0} */
    private String carLine() {
        int id = DataCanbus.DATA[1000];
        String className = "-";
        try {
            String name = CanbusLibrary.loadBlocking(this).classNameFor(id, LauncherApplication.isPortrait(),
                    CanbusClasses.readFile("/sys/fytver/fyt_bin_version"));
            if (name != null) {
                className = name;
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not look the class of the car up", e);
        }
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        return "Car: id " + id + " (protocol " + (id & 0xFFFF) + ", car " + (id >>> 16) + "), class " + className
                + ", callback " + (callback == null ? "none" : callback.getClass().getSimpleName())
                + ", request: " + requestDescription;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /** The request of the car's fuel screen, if the library has one for it; "none" otherwise. */
    private String sendRequest() {
        try {
            return CanbusLibrary.sendForCar(getApplicationContext(), DataCanbus.DATA[1000]).get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.w(TAG, "The request of the car was not sent", e);
            return CanbusLibrary.NONE;
        }
    }

    /** The GPS speed during the recording, if the permission is there already (it is not asked for). */
    private void startGps() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        gpsRecorded = true;
        locationUpdates = DeviceLocation.requestUpdates(this, 1000L, recorder::addFix, Looper.getMainLooper());
    }

    private void stopGps() {
        final DeviceLocation.Handle handle = locationUpdates;
        locationUpdates = null;
        if (handle != null) {
            mainHandler.post(handle::remove);
        }
    }

    public void runSchedulerTask(Intent intent) {
        schedulerTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onProgress(Void[] progress) {
                //
            }

            @Override
            protected Void doInBackground(Void... params) {
                if (intent != null) {
                    helpers.setCodeInspectorBoolean(true);
                    // The automatic check gives way to a reader started by hand
                    CanbusService.readerStarted();
                    // The request first: a car that waits for it reports its fuel and range only after
                    requestDescription = sendRequest();
                    recorder.begin(System.currentTimeMillis());
                    recorder.registerCodes();
                    mainHandler.post(CanbusCodeInspector.this::startGps);

                    mainHandler.post(() -> {
                        countDownTimer = new CountDownTimer(((long)codeInspectorServiceTimeout * 1000), 1000) {
                            public void onTick(long millisUntilFinished) {
                                int remainingSeconds = (int) (millisUntilFinished / 1000);
                                helpers.setCountDownInspector(remainingSeconds);
                            }

                            public void onFinish() {
                                helpers.setCountDownInspector(0);
                            }
                        }.start();
                    });

                    scheduler = Executors.newSingleThreadScheduledExecutor();
                    scheduler.schedule(() -> {
                        try {
                            writeDataToFile();
                        } catch (Exception e) {
                            Log.e(TAG, "Error writing file", e);
                        } finally {
                            stopScheduler();
                        }
                    }, ((long)codeInspectorServiceTimeout * 1000), TimeUnit.MILLISECONDS);
                }
                return null;
            }

            @Override
            protected void onBackgroundError(Exception e) {
                Log.e(TAG, "Error during examining canbus codes: " + e.getMessage());
            }
        }.execute();
    }

    private void stopScheduler() {
        mainHandler.post(() -> {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            Toast.makeText(CanbusCodeInspector.this, R.string.code_inspector_toast, Toast.LENGTH_LONG).show();
            stopSelf();
        });
    }

    public void cancelSchedulerTask() {
        if (schedulerTask != null && !schedulerTask.isCancelled()) {
            schedulerTask.cancel(true);
        }
    }

    private Set<Integer> getSkipCodes() {
        Set<String> defaultSet = Collections.emptySet();
        Set<String> stringSet = sharedPrefs.getStringSet("skip_codes", defaultSet);

        Set<Integer> skipCodesSet = new HashSet<>();
        for (String codeStr : stringSet) {
            try {
                skipCodesSet.add(Integer.parseInt(codeStr));
            } catch (NumberFormatException e) {
                // Skip invalid entries
            }
        }
        return skipCodesSet;
    }
}
