package com.android.launcher66.settings;

import static com.android.launcher66.settings.Keys.CODE_INSPECTOR_TIMEOUT;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.ipc.IModuleCallback;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
    private static final int BATCH_SIZE = 50;
    private static final int CODES = 1200;
    private static final int MAX_EVENTS_PER_CODE = 5000;
    private static final int MAX_EVENTS = 200_000;

    /**
     * One update of a code: its time, ints[0] if there was one, and the rest of the payload as text. The
     * whole of ints too, when there is more than one number (the raw frames of a CAN box are decoded from it).
     */
    private static final class Event {
        final long t;
        final boolean hasInt;
        final int v;
        final String extra;
        final int[] ints;

        Event(long t, boolean hasInt, int v, String extra, int[] ints) {
            this.t = t;
            this.hasInt = hasInt;
            this.v = v;
            this.extra = extra;
            this.ints = ints;
        }

        boolean sameAs(Event o) {
            return hasInt == o.hasInt && v == o.v && extra.equals(o.extra);
        }
    }

    private final Object lock = new Object();
    /** Code -> its events, in order; guarded by lock. */
    private final SparseArray<ArrayList<Event>> events = new SparseArray<>();
    private int totalEvents;
    private int droppedEvents;
    private volatile boolean recording;
    private volatile long startTime;
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
    /** The GPS speed during the recording; filled on the main thread. */
    private final List<CanbusCodeEstimator.GpsFix> gpsFixes = Collections.synchronizedList(new ArrayList<>());
    private volatile DeviceLocation.Handle locationUpdates;
    private volatile boolean gpsRecorded;

    private final IModuleCallback.Stub rawCallback = new IModuleCallback.Stub() {
        @Override
        public void update(int updateCode, int[] ints, float[] flts, String[] strs) {
            record(updateCode, ints, flts, strs);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        codeInspectorServiceTimeout = Integer.parseInt(sharedPrefs.getString(CODE_INSPECTOR_TIMEOUT, "300"));
        skipCodes = getSkipCodes();
        skipZeroCodes = sharedPrefs.getBoolean(Keys.SKIP_ZERO_CODES, true);
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
        // No more data from now on
        recording = false;

        // Save data in background
        batchExecutor.execute(() -> {
            writeDataToFile();
            mainHandler.post(() ->
                Toast.makeText(this, R.string.code_inspector_toast, Toast.LENGTH_SHORT).show()
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
            for (int start = 0; start < CODES; start += BATCH_SIZE) {
                for (int code = start; code < Math.min(start + BATCH_SIZE, CODES); code++) {
                    DataCanbus.PROXY.unregister(rawCallback, code);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            batchExecutor.shutdown();
        });
    }

    /** Binder thread: every update of a registered code is recorded with the time it came. */
    private void record(int code, int[] ints, float[] flts, String[] strs) {
        if (!recording || code < 0 || code >= CODES) {
            return;
        }
        long now = System.currentTimeMillis();
        boolean hasInt = ints != null && ints.length > 0;
        Event event = new Event(now, hasInt, hasInt ? ints[0] : 0, describeExtra(ints, flts, strs),
                ints != null && ints.length > 1 ? ints.clone() : null);
        synchronized (lock) {
            if (!recording) {
                return;
            }
            if (totalEvents >= MAX_EVENTS) {
                droppedEvents++;
                return;
            }
            ArrayList<Event> list = events.get(code);
            if (list == null) {
                list = new ArrayList<>();
                events.put(code, list);
            }
            if (list.size() >= MAX_EVENTS_PER_CODE) {
                droppedEvents++;
                return;
            }
            list.add(event);
            totalEvents++;
        }
    }

    /** What the update carried besides ints[0]: {@code ints=68,1; flts=...; strs=...}, or an empty text. */
    private static String describeExtra(int[] ints, float[] flts, String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (ints != null && ints.length > 1) {
            sb.append("ints=");
            for (int i = 0; i < ints.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(ints[i]);
            }
        }
        if (flts != null && flts.length > 0) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append("flts=");
            for (int i = 0; i < flts.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(flts[i]);
            }
        }
        if (strs != null && strs.length > 0) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append("strs=");
            for (int i = 0; i < strs.length; i++) {
                if (i > 0) {
                    sb.append('|');
                }
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    private void writeDataToFile() {
        // A stable copy: from here on nothing is added
        SparseArray<ArrayList<Event>> snapshot = new SparseArray<>();
        int total;
        int dropped;
        synchronized (lock) {
            recording = false;
            for (int i = 0; i < events.size(); i++) {
                snapshot.put(events.keyAt(i), new ArrayList<>(events.valueAt(i)));
            }
            total = totalEvents;
            dropped = droppedEvents;
        }
        stopGps();
        List<CanbusCodeEstimator.GpsFix> fixes;
        synchronized (gpsFixes) {
            fixes = new ArrayList<>(gpsFixes);
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        String fileName = "CanbusCodes" + timestamp + ".txt";
        File directory = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "Launcher66_Canbus");

        if (!directory.exists() && !directory.mkdirs()) {
            Log.e(TAG, "Failed to create directory");
            return;
        }

        File file = new File(directory, fileName);

        // What the codes look like, for the guesses
        Map<Integer, List<CanbusCodeEstimator.Sample>> samples = new HashMap<>();
        int withData = 0;
        int unchanged = 0;
        int onlyZero = 0;
        for (int i = 0; i < snapshot.size(); i++) {
            int code = snapshot.keyAt(i);
            ArrayList<Event> list = snapshot.valueAt(i);
            if (list.isEmpty()) {
                continue;
            }
            withData++;
            if (isUnchanged(list)) {
                unchanged++;
            }
            if (sentOnlyZero(list)) {
                onlyZero++;
            }
            List<CanbusCodeEstimator.Sample> s = new ArrayList<>();
            for (Event e : list) {
                if (e.hasInt) {
                    s.add(new CanbusCodeEstimator.Sample(e.t, e.v));
                }
            }
            samples.put(code, s);
        }
        // The codes that carry the raw frames of a CAN box (found by what they hold, whatever their number) are
        // not values: their ints[0] is a frame header. They leave the guesses and get a section of their own.
        Map<Integer, CanbusFrames.Channel> channels = new TreeMap<>();
        try {
            Map<Integer, List<CanbusFrames.Event>> frameEvents = new HashMap<>();
            for (int i = 0; i < snapshot.size(); i++) {
                boolean payloads = false;
                for (Event e : snapshot.valueAt(i)) {
                    payloads |= e.ints != null;
                }
                if (!payloads) {
                    continue;       // only codes with updates of several numbers can carry frames
                }
                // An update of one number is part of a frame too: often just its checksum
                List<CanbusFrames.Event> list = new ArrayList<>();
                for (Event e : snapshot.valueAt(i)) {
                    if (e.ints != null) {
                        list.add(new CanbusFrames.Event(e.t, e.ints));
                    } else if (e.hasInt && e.extra.isEmpty()) {
                        list.add(new CanbusFrames.Event(e.t, new int[]{e.v}));
                    }
                }
                frameEvents.put(snapshot.keyAt(i), list);
            }
            channels.putAll(CanbusFrames.detect(frameEvents));
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not look for raw frames", e);
        }
        for (Integer code : channels.keySet()) {
            samples.remove(code);
        }
        CanbusCodeEstimator.Result guesses;
        try {
            guesses = CanbusCodeEstimator.estimate(samples, fixes);
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not guess the meaning of the codes", e);
            guesses = null;
        }
        // What the library says of this car, against what the recording shows; and the guesses, for the window
        String libraryLine = "";
        int carId = DataCanbus.DATA[1000];
        try {
            CanbusLibrary.CarCodes libraryCodes = CanbusLibrary.loadBlocking(this).codesFor(carId);
            if (libraryCodes != null) {
                libraryLine = CanbusCodeEstimator.libraryCodesLine(libraryCodes.fuel, libraryCodes.range, samples,
                        guesses);
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not compare the codes of the library", e);
        }
        saveGuesses(carId, guesses);
        List<String> frameLines = new ArrayList<>();
        try {
            frameLines = CanbusFrames.report(channels, samples);
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not describe the raw frames", e);
        }

        SimpleDateFormat lineTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Canbus reader, " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US)
                    .format(new Date(startTime)) + ", " + codeInspectorServiceTimeout + " s\n");
            writer.write(carLine() + "\n");
            int withBearing = 0;
            for (CanbusCodeEstimator.GpsFix f : fixes) {
                if (!Float.isNaN(f.bearing)) {
                    withBearing++;
                }
            }
            writer.write(gpsRecorded
                    ? "GPS speed: " + fixes.size() + " fixes, with bearing: " + withBearing + "\n"
                    : "GPS speed: not recorded (no location permission)\n");
            writer.write("Codes with data: " + withData + " (unchanged: " + unchanged
                    + (skipZeroCodes ? "; " + onlyZero + " sent only 0 and are left out" : "")
                    + "); events: " + total + "; dropped: " + dropped + "\n");
            if (!libraryLine.isEmpty()) {
                writer.write(libraryLine + "\n");
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
            if (!frameLines.isEmpty()) {
                for (String line : frameLines) {
                    writer.write(line + "\n");
                }
                writer.write("\n");
            }

            for (int code = 0; code < CODES; code++) {
                if (skipCodes.contains(code)) {
                    continue;
                }
                ArrayList<Event> list = snapshot.get(code);
                if (list == null || list.isEmpty()) {
                    continue;
                }
                if (skipZeroCodes && !channels.containsKey(code) && sentOnlyZero(list)) {
                    continue;
                }
                writer.write("CODE: " + code + "\n");
                if (isUnchanged(list)) {
                    writer.write(eventLine(lineTime, list.get(0)) + "\n");
                } else {
                    for (Event e : list) {
                        writer.write(eventLine(lineTime, e) + "\n");
                    }
                }
                writer.write("\n");
            }
            isDataWritten = true; // Mark data as saved
        } catch (IOException e) {
            Log.e(TAG, "File write failed", e);
        }
    }

    private static boolean isUnchanged(List<Event> list) {
        Event first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (!first.sameAs(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /** The best guesses for the Canbus codes window, over the ones of an earlier reading. Off the main thread. */
    private void saveGuesses(int carId, CanbusCodeEstimator.Result guesses) {
        if (carId == 0 || guesses == null) {
            return;
        }
        ReaderGuesses found = ReaderGuesses.of(guesses, startTime);
        if (found.isEmpty()) {
            return;
        }
        String key = ReaderGuesses.key(carId);
        ReaderGuesses older = ReaderGuesses.parse(sharedPrefs.getString(key, null));
        sharedPrefs.edit().putString(key, found.over(older).serialize()).apply();
    }

    /** Every update of the code was 0 with nothing else in it. An update without ints is not a 0. */
    private static boolean sentOnlyZero(List<Event> list) {
        for (Event e : list) {
            if (!e.hasInt || e.v != 0 || !e.extra.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static String eventLine(SimpleDateFormat format, Event e) {
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

    private void registerCodes() {
        for (int code = 0; code < CODES; code++) {
            if (!skipCodes.contains(code)) {
                DataCanbus.PROXY.register(rawCallback, code, 1);
            }
        }
    }

    /** The GPS speed during the recording, if the permission is there already (it is not asked for). */
    private void startGps() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        gpsRecorded = true;
        locationUpdates = DeviceLocation.requestUpdates(this, 1000L, this::onLocation, Looper.getMainLooper());
    }

    private void onLocation(Location location) {
        if (location != null && location.hasSpeed()) {
            gpsFixes.add(new CanbusCodeEstimator.GpsFix(System.currentTimeMillis(), location.getSpeed() * 3.6f,
                    location.hasBearing() ? location.getBearing() : Float.NaN));
        }
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
                    startTime = System.currentTimeMillis();
                    // The request first: a car that waits for it reports its fuel and range only after
                    requestDescription = sendRequest();
                    recording = true;
                    registerCodes();
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
