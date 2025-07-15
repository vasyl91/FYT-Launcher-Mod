package com.android.launcher66.settings;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CanbusCommandLogger extends Service {

    private static final String TAG = "CanbusCommandLogger";
    private static final String CODE_LOGGER_TIMEOUT = "code_logger_timeout";
    private static final String STARTING_CMD_INT = "starting_cmd_int";
    private static final String STARTING_CMD_ARR = "starting_cmd_arr";
    private static final String MAX_CMD_INT = "max_cmd_int";
    private static final String MAX_CMD_ARR = "max_cmd_arr";
    private static final String OMIT_DIGITS = "omit_digits";
    private static final int MAX_LOG_ENTRIES = 1000;
    private static final long MAX_FILE_SIZE = (long) 5 * 1024 * 1024;
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private final ScheduledExecutorService scanScheduler = Executors.newScheduledThreadPool(10);
    private final Helpers helpers = new Helpers();
    private final Map<String, ScheduledFuture<?>> pendingTimers = new ConcurrentHashMap<>();
    private final Map<String, CountDownLatch> completionLatches = new ConcurrentHashMap<>();
    private final Map<String, LogGroup> logGroups = new HashMap<>();
    private static CanbusCommandLogger instance;
    private SharedPreferences sharedPrefs;
    private Set<Integer> skipCodes;
    private AsyncTask<Void, Void, Void> loggingTask;
    private BufferedWriter writer;
    private ExecutorService commandExecutor;
    private File currentLogFile;
    private HandlerThread loggerThread;
    private Handler writeHandler;
    private RemoteModuleProxy originalProxy;
    private ScheduledExecutorService timerExecutor;
    private String endingTimerKey;
    private int lastCmdInt;
    private int lastCmdArr;
    private int startingCmdInt;
    private int startingCmdArr;
    private int maxCmdInt;
    private int maxCmdArr;
    private int TIMER_DURATION;
    private long estimatedLoggingDuration;
    private boolean isRunning = false;
    private boolean omitDigits = false;

    private static class LogGroup {
        String header;
        Map<String, String> entries = new LinkedHashMap<>();
        
        LogGroup(int cmdInt, int cmdArr, int dataCode) {
            this.header = "CMD: " + cmdInt + ", " + cmdArr + "; CODE: " + dataCode;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.d(TAG, "Service created");
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        skipCodes = getSkipCodes();
        startingCmdInt = Integer.parseInt(sharedPrefs.getString(STARTING_CMD_INT, "0"));
        startingCmdArr = Integer.parseInt(sharedPrefs.getString(STARTING_CMD_ARR, "0"));
        maxCmdInt = Integer.parseInt(sharedPrefs.getString(MAX_CMD_INT, "10"));
        maxCmdArr = Integer.parseInt(sharedPrefs.getString(MAX_CMD_ARR, "10"));
        TIMER_DURATION = Integer.parseInt(sharedPrefs.getString(CODE_LOGGER_TIMEOUT, "1")) * 1000;
        omitDigits = sharedPrefs.getBoolean(OMIT_DIGITS, false);
        int totalCommands = (maxCmdInt - startingCmdInt) * (maxCmdArr - startingCmdArr);
        estimatedLoggingDuration = (long) totalCommands * TIMER_DURATION;
        endingTimerKey = (maxCmdInt - 1) + "-" + (maxCmdArr - 1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started"); 
        startLoggingTask();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startLoggingTask() {
        if (isRunning) return;
        isRunning = true;
        
        loggingTask = new AsyncTask<>() {
            @Override
            protected void onProgress(Void[] progress) {
                //
            }

            @Override
            protected Void doInBackground(Void... voids) {
                helpers.setCodeLoggerBoolean(true);
                initLogger();
                wrapProxy();
                startLoggingProcess();
                return null;
            }

            @Override
            protected void onBackgroundError(Exception e) {
                //
            }
        };
        
        loggingTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }  

    private void initLogger() {
        Log.d(TAG, "Initializing logger");
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        String fileName = "CanbusLogger_" + timestamp + ".txt";
        File logDir = new File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "Launcher66_Canbus"
        );

        if (!logDir.exists() && !logDir.mkdirs()) {
            Log.e(TAG, "Failed to create directory");
            return;
        }
        
        currentLogFile = new File(logDir, fileName);
        
        try {
            // Create handler infrastructure
            loggerThread = new HandlerThread("CanLoggerWorker");
            loggerThread.start();
            writeHandler = new Handler(loggerThread.getLooper());
            
            // Initialize file writer
            writer = new BufferedWriter(new FileWriter(currentLogFile, true));
        } catch (IOException e) {
            Log.e(TAG, "File write failed", e);
        }
    }    
        
    private void wrapProxy() {
        Log.d(TAG, "Wrapping PROXY");
        originalProxy = DataCanbus.PROXY;
        DataCanbus.PROXY = new WrapperProxy(this, originalProxy);
    }

    void startLoggingProcess() {
        timerExecutor = Executors.newSingleThreadScheduledExecutor();
        commandExecutor = Executors.newSingleThreadExecutor();
        
        commandExecutor.execute(() -> {
            // first loop
            for (int cmdInt = startingCmdInt; cmdInt < maxCmdInt; cmdInt++) {
                // second loop
                for (int cmdArr = startingCmdArr; cmdArr < maxCmdArr; cmdArr++) {
                    if (Thread.currentThread().isInterrupted()) {
                        Log.d(TAG, "Command processing interrupted");
                        return;
                    }
                    processCommand(cmdInt, cmdArr);
                }
            }
            timerExecutor.shutdown();
            commandExecutor.shutdown();
        });
    }

    private void processCommand(int cmdInt, int cmdArr) {
        DataCanbus.PROXY.cmdAsync(cmdInt, new int[]{cmdArr}, null, null);
        setupListenersAndWaitForActivity(cmdInt, cmdArr);
    }

    private void setupListenersAndWaitForActivity(int cmdInt, int cmdArr) {
        String timerKey = cmdInt + "-" + cmdArr;
        CountDownLatch completionLatch = new CountDownLatch(1);
        completionLatches.put(timerKey, completionLatch);
        List<DataListener> listeners = new ArrayList<>();
        
        // Create a map to track previous values per data code for this command
        Map<Integer, Integer> previousValues = new ConcurrentHashMap<>();

        // Start timer immediately for this command
        startActivityTimer(timerKey);
        
        // Start listener setup thread
        new Thread(() -> {
            // third loop
            for (int code = 0; code < 150; code++) {
                if (skipCodes.contains(code)) {
                    continue;
                }

                if (Thread.currentThread().isInterrupted()) break;
                
                final int codeFinal = code;
                DataListener listener = new DataListener(codeFinal) {
                    @Override
                    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
                        if (updateCode != codeFinal) return;
                        
                        int valueNew = DataCanbus.DATA[updateCode];
                        if (valueNew == -1 || valueNew == 0) return;

                        // Get previous value for this specific code
                        Integer prevValue = previousValues.get(codeFinal);
                        if (prevValue != null && prevValue == valueNew) {
                            return; // Skip duplicate values
                        }
                        
                        // Store new value as previous for this code
                        previousValues.put(codeFinal, valueNew);

                        // skipping if the user chooses to omit single figures
                        if (omitDigits && isSingleFigure(valueNew)) {
                            return;
                        }

                        logImmediately(cmdInt, cmdArr, updateCode, valueNew);
                    }
                };
                
                DataCanbus.NOTIFY_EVENTS[codeFinal].addNotify(listener, 1);
                listeners.add(listener);
            }
        }).start();

        try {
            // Update estimated duration
            estimatedLoggingDuration -= TIMER_DURATION;
            helpers.setCountDownLogger((int) estimatedLoggingDuration / 1000);
            Log.d(TAG, "Estimated duration: " + estimatedLoggingDuration / 1000);
            
            // Wait for timer to complete
            completionLatch.await();
            Log.d(TAG, "Completed command: " + timerKey);
            
            if (timerKey.equals(endingTimerKey)) {
                Log.d(TAG, "Finished logging");
                runOnUiThread(() -> Toast.makeText(
                    LauncherApplication.sApp,
                    R.string.code_logger_toast,
                    Toast.LENGTH_SHORT
                ).show());
                stopLogging();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Cleanup resources
            completionLatches.remove(timerKey);
            
            // Cancel and remove pending timer
            ScheduledFuture<?> timer = pendingTimers.remove(timerKey);
            if (timer != null) {
                timer.cancel(false);
            }
            
            // Remove listeners
            for (DataListener listener : listeners) {
                try {
                    DataCanbus.NOTIFY_EVENTS[listener.getCode()].removeNotify(listener);
                } catch (Exception e) {
                    Log.e(TAG, "Error removing listener", e);
                }
            }
        }
    }

    public static boolean isSingleFigure(int number) {
        return number >= -9 && number <= 9;
    }

    private void startActivityTimer(String timerKey) {
        try {
            ScheduledFuture<?> timer = timerExecutor.schedule(() -> {
                // Skip if command already cleaned up
                if (!completionLatches.containsKey(timerKey)) {
                    Log.d(TAG, "Skipping completed command: " + timerKey);
                    return;
                }
                Log.d(TAG, "Activity window ended for " + timerKey);
                CountDownLatch latch = completionLatches.get(timerKey);
                if (latch != null) latch.countDown();
            }, TIMER_DURATION, TimeUnit.MILLISECONDS);
            
            pendingTimers.put(timerKey, timer);
        } catch (RejectedExecutionException e) {
            Log.e(TAG, "Timer start failed", e);
            CountDownLatch latch = completionLatches.get(timerKey);
            if (latch != null) latch.countDown();
        }
    }

    private void logImmediately(int cmdInt, int cmdArr, int code, int value) {
        String msg = "cmdInt=" + cmdInt + ", cmdArr=" + cmdArr + 
                     " → code=" + code + ", value=" + value;
        Log.d(TAG, msg);
        logData(code, value);
    }

    private synchronized void logCommand(int cmdInt, int cmdArr) {
        lastCmdInt = cmdInt;
        lastCmdArr = cmdArr;
        Log.d(TAG, "Command logged: " + cmdInt + ", " + cmdArr);
    }

    public synchronized void logData(int dataCode, int value) {
        if (!isRunning) {
            Log.w(TAG, "logData called but service not running");
            return;
        }

        long currentTime = System.currentTimeMillis();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(currentTime));
        Log.d(TAG, "Data received: code=" + dataCode + ", value=" + value);
        
        // Create log task
        Runnable logTask = () -> {
            synchronized (CanbusCommandLogger.this) {
                String groupKey = lastCmdInt + "_" + lastCmdArr + "_" + dataCode;
                
                // Get or create log group
                LogGroup group = logGroups.computeIfAbsent(
                    groupKey, 
                    k -> new LogGroup(lastCmdInt, lastCmdArr, dataCode)
                );
                
                // Add log entry
                group.entries.put(timestamp, String.valueOf(value));
                
                // Flush if group is large
                if (group.entries.size() >= MAX_LOG_ENTRIES) {
                    flushGroup(groupKey);
                }
            }
        };
        
        // Post to write handler thread
        if (writeHandler != null) {
            writeHandler.post(logTask);
        } else {
            Log.w(TAG, "Write handler not available, queueing task");
            // Initialize write handler if possible
            if (loggerThread != null && loggerThread.isAlive()) {
                writeHandler = new Handler(loggerThread.getLooper());
                writeHandler.post(logTask);
            }
        }
    }

    private void flushGroup(String groupKey) {
        synchronized (logGroups) {
            LogGroup group = logGroups.remove(groupKey);
            if (group == null || writer == null) return;

            try {
                writer.write(group.header + "\n");
                for (Map.Entry<String, String> entry : group.entries.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
                writer.write("\n");
                writer.flush();
                checkFileSizeAndRotate();
            } catch (IOException e) {
                Log.e(TAG, "Failed to write log group", e);
            }
        }
    }

    private void checkFileSizeAndRotate() {
        if (currentLogFile == null || !currentLogFile.exists()) return;
        
        try {
            if (currentLogFile.length() > MAX_FILE_SIZE) {
                // Close current resources
                writer.close();
                
                // Start new file
                initLogger();
                Log.i(TAG, "Rotated log file due to size limit");
            }
        } catch (IOException e) {
            Log.e(TAG, "File rotation failed", e);
        }
    }

    // Public static method to stop logging from external classes
    public static void stopLogging() {
        if (instance != null) {
            instance.stopLoggingInternal();
        }
    }

    private void stopLoggingInternal() {
        if (!isRunning) return;
        isRunning = false;

        if (commandExecutor != null) commandExecutor.shutdownNow();
        if (timerExecutor != null) timerExecutor.shutdownNow();
        MAIN_HANDLER.removeCallbacksAndMessages(null);

        // Flush all remaining groups
        synchronized (logGroups) {
            new ArrayList<>(logGroups.keySet()).forEach(this::flushGroup);
            logGroups.clear();
        }

        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            Log.e(TAG, "Failed to close writer", e);
        }
        
        if (loggerThread != null) {
            loggerThread.quitSafely();
        }
        
        if (scanScheduler != null) {
            scanScheduler.shutdownNow();
        }

        if (loggingTask != null && !loggingTask.isCancelled()) {
            loggingTask.cancel(true);
        }

        if (originalProxy != null) {
            DataCanbus.PROXY = originalProxy;
            originalProxy = null;
        }

        // Stop the service
        stopSelf();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Service destroyed");
        runOnUiThread(() -> Toast.makeText(
            LauncherApplication.sApp,
            R.string.code_logger_toast,
            Toast.LENGTH_SHORT
        ).show());
        stopLoggingInternal();

        if (originalProxy != null) {
            DataCanbus.PROXY = originalProxy;
        }

        helpers.setCodeLoggerBoolean(false);
        helpers.setCountDownLogger(0);

        instance = null;
        super.onDestroy();
    }
    
    private void runOnUiThread(Runnable action) {
        new Handler(Looper.getMainLooper()).post(action);
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

    private static class DataListener implements IUiNotify {
        public final int dataCode;

        DataListener(int code) {
            this.dataCode = code;
        }

        public int getCode() {
            return dataCode;
        }

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {      
            // overriden in setupListenersAndWaitForActivity
        }
    }  

    private static class WrapperProxy extends RemoteModuleProxy {
        private final WeakReference<CanbusCommandLogger> serviceRef;
        private final RemoteModuleProxy original;

        WrapperProxy(CanbusCommandLogger service, RemoteModuleProxy original) {
            this.serviceRef = new WeakReference<>(service);
            this.original = original;
            setRemoteModule(original); // Delegate to original proxy
        }

        @Override
        public void cmdAsync(int cmdCode, int[] ints, float[] flts, String[] strs) {
            CanbusCommandLogger service = serviceRef.get();
            if (service != null) {
                int param = (ints != null && ints.length > 0) ? ints[0] : -1;
                service.logCommand(cmdCode, param);
            }
            original.cmdAsync(cmdCode, ints, flts, strs);
        }
    }
}