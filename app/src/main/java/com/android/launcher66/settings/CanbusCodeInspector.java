package com.android.launcher66.settings;

import static com.android.launcher66.settings.SettingsFragmentSecond.CODE_INSPECTOR_TIMEOUT;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CanbusCodeInspector extends Service {

    /** Service that saves canbus codes' messages ranging from 0 to 1199 and saves them for 30 seconds to the text file 
     *  marked with the timestamp in dir Download/CanbusCodes.
     *  This feature might be helpful in deciphering the codes that are not included in the canbus framework within this app.
     */
    private static final String TAG = "CanbusCodeInspector";
    private static final int BATCH_SIZE = 50;
    private final SparseArray<String[]> codeData = new SparseArray<>();
    private volatile long startTime;
    private int codeInspectorServiceTimeout;
    private AsyncTask<Void, Void, Void> schedulerTask;
    private final Helpers helpers = new Helpers();
    private CountDownTimer countDownTimer;
    private ScheduledExecutorService scheduler;
    private final ExecutorService batchExecutor = Executors.newSingleThreadExecutor();
    private volatile boolean isDataWritten = false; // Track if data has been saved
    private SharedPreferences sharedPrefs;
    private Set<Integer> skipCodes;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        codeInspectorServiceTimeout = Integer.parseInt(sharedPrefs.getString(CODE_INSPECTOR_TIMEOUT, "30"));
        skipCodes = getSkipCodes();

        // Initialize data structure for codes
        for (int code = 0; code <= 1199; code++) {
            codeData.put(code, new String[codeInspectorServiceTimeout]);
        }

        // Register listeners for all codes
        for (int code = 0; code <= 1199; code++) {
            addNotify(code);
        }
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
        
        // Save data if not already written
        if (!isDataWritten) {
            freezeAndSaveData();
        }
        
        helpers.setCodeInspectorBoolean(false);
        helpers.setCountDownInspector(0);
        
        // Unregister listeners in batches off main thread
        unregisterListenersInBatches();
    }

    private void freezeAndSaveData() {
        // Unregister listeners first to prevent new data
        unregisterListenersImmediately();
        
        // Save data in background
        batchExecutor.execute(() -> {
            writeDataToFile();
            new Handler(Looper.getMainLooper()).post(() -> 
                Toast.makeText(this, R.string.code_inspector_toast, Toast.LENGTH_SHORT).show()
            );
        });
    }

    private void unregisterListenersImmediately() {
        for (int code = 0; code <= 1199; code++) {
            removeNotify(code);
        }
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

    private void unregisterListenersInBatches() {
        batchExecutor.execute(() -> {
            for (int start = 0; start <= 1199; start += BATCH_SIZE) {
                final int batchStart = start;
                final int batchEnd = Math.min(start + BATCH_SIZE, 1200);
                
                new Handler(Looper.getMainLooper()).post(() -> {
                    for (int code = batchStart; code < batchEnd; code++) {
                        removeNotify(code);
                    }
                });
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            batchExecutor.shutdown();
        });
    }

    private void writeDataToFile() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        String fileName = "CanbusCodes" + timestamp + ".txt";
        File directory = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "Launcher66_Canbus");

        if (!directory.exists() && !directory.mkdirs()) {
            Log.e(TAG, "Failed to create directory");
            return;
        }

        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file)) {
            for (int code = 0; code <= 1199; code++) {
                if (skipCodes.contains(code)) {
                    continue;
                }
                String[] messages = codeData.get(code);
                boolean codeHasData = false;

                for (int sec = 0; sec < codeInspectorServiceTimeout; sec++) {
                    if (messages != null && messages[sec] != null && !messages[sec].isEmpty()) {
                        codeHasData = true;
                        break;
                    }
                }

                if (!codeHasData) continue;

                writer.write("Code " + code + ":\n");
                for (int sec = 1; sec <= codeInspectorServiceTimeout; sec++) {
                    if (messages == null) continue;
                    String msg = messages[sec - 1];
                    if (msg != null && !msg.isEmpty()) {
                        writer.write(sec + ": " + msg + "\n");
                    }
                }
                writer.write("\n");
            }
            isDataWritten = true; // Mark data as saved
        } catch (IOException e) {
            Log.e(TAG, "File write failed", e);
        }
    } 

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private final IUiNotify mNotifyCanbus = (updateCode, ints, flts, strs) -> {
        if (updateCode < 0 || updateCode > 1199) return;

        long currentTime = System.currentTimeMillis();
        int second = (int) ((currentTime - startTime) / 1000) + 1;

        if (second < 1 || second > codeInspectorServiceTimeout) return;

        String message = String.valueOf(DataCanbus.DATA[updateCode]);
        String[] secondsArray = codeData.get(updateCode);
        if (secondsArray != null) {
            secondsArray[second - 1] = message;
        }
    };

    private void addNotify(int code) {
        DataCanbus.NOTIFY_EVENTS[code].addNotify(mNotifyCanbus, 1);
    }

    private void removeNotify(int code) {
        DataCanbus.NOTIFY_EVENTS[code].removeNotify(mNotifyCanbus);
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
                    int cmdInt = intent.getIntExtra("cmdInt", 0);
                    int cmdArr = intent.getIntExtra("cmdArr", 0);
                    DataCanbus.PROXY.cmd(cmdInt, new int[]{cmdArr}, null, null);
                    startTime = System.currentTimeMillis();

                    new Handler(Looper.getMainLooper()).post(() -> {
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
        new Handler(Looper.getMainLooper()).post(() -> {
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