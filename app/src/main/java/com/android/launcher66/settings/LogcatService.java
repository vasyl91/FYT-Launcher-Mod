package com.android.launcher66.settings;

import static com.android.launcher66.settings.Keys.LOGCAT_SERVICE_TIMEOUT;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogcatService extends Service {

    private static final String TAG = "LogcatService";
    private static final String LOG_FILE_SUFFIX = ".txt";

    private java.lang.Process logcatProcess;
    private FileWriter fileWriter;
    private volatile boolean isRunning = false; // Made volatile for visibility
    private int myPid;
    private int logcatTimeout;
    private AsyncTask<Void, Void, Void> loggingTask;
    private final Helpers helpers = new Helpers();
    private CountDownTimer countDownTimer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        logcatTimeout = Integer.parseInt(sharedPrefs.getString(LOGCAT_SERVICE_TIMEOUT, "30"));
        myPid = Process.myPid();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service started, PID: " + myPid);
        startLoggingTask();
        return START_NOT_STICKY; 
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");

        new Handler(Looper.getMainLooper()).post(() -> {
            Toast.makeText(LogcatService.this, R.string.logcat_service_run_toast, Toast.LENGTH_LONG).show();
        });

        // Signal background thread to stop
        isRunning = false;
        if (logcatProcess != null) {
            logcatProcess.destroyForcibly();
        }

        // Clean up components
        cancelCountdownTimer();
        cancelLoggingTask();

        helpers.setLogcatRunBoolean(false);
        helpers.setCountDownLogcat(0);
        Log.i(TAG, "Log capturing stopped");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; 
    }

    private void startLoggingToFile() {
        // Check storage permission
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "WRITE_EXTERNAL_STORAGE permission not granted");
            return;
        }

        BufferedReader dumpReader = null;
        BufferedReader bufferedReader = null;
        try {
            // Create log directory
            File downloadsDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), 
                "Launcher66_Logs"
            );
            if (!downloadsDir.exists() && !downloadsDir.mkdirs()) {
                Log.e(TAG, "Failed to create log directory");
                return;
            }

            // Create log file
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss", Locale.getDefault())
                .format(new Date());
            File logFile = new File(downloadsDir, timestamp + LOG_FILE_SUFFIX);
            fileWriter = new FileWriter(logFile, true);

            // STEP 1: First, dump existing logs (including startup logs)
            Log.i(TAG, "Dumping existing logs...");
            String[] dumpCommand = new String[]{"logcat", "-d", "-v", "threadtime"};
            java.lang.Process dumpProcess = Runtime.getRuntime().exec(dumpCommand);
            dumpReader = new BufferedReader(
                new InputStreamReader(dumpProcess.getInputStream()));

            String line;
            int dumpCount = 0;
            while ((line = dumpReader.readLine()) != null) {
                if (line.contains(String.valueOf(myPid)) && 
                    !line.contains("ContextImpl") && 
                    !line.contains("Unisoc_Location")) {
                    fileWriter.write(line + "\n");
                    dumpCount++;
                }
            }
            dumpReader.close();
            fileWriter.flush();
            Log.i(TAG, "Dumped " + dumpCount + " existing log lines");

            // STEP 2: Now start continuous logging (without clearing buffer)
            Log.i(TAG, "Starting continuous log capture...");
            String[] command = new String[]{"logcat", "-v", "threadtime"};
            logcatProcess = Runtime.getRuntime().exec(command);
            bufferedReader = new BufferedReader(
                new InputStreamReader(logcatProcess.getInputStream()));

            // Read logcat output continuously
            isRunning = true;
            while (isRunning && (line = bufferedReader.readLine()) != null) {
                if (line.contains(String.valueOf(myPid)) && 
                    !line.contains("ContextImpl") && 
                    !line.contains("Unisoc_Location")) {
                    fileWriter.write(line + "\n");
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Log capture error: " + e.getMessage());
        } finally {
            // Ensure resources are closed
            try {
                if (dumpReader != null) dumpReader.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing dump reader", e);
            }
            closeResources(bufferedReader, fileWriter, logcatProcess);
        }
    }

    private void closeResources(BufferedReader reader, FileWriter writer, java.lang.Process process) {
        try {
            if (reader != null) reader.close();
        } catch (IOException e) {
            Log.e(TAG, "Error closing reader", e);
        }
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            Log.e(TAG, "Error closing writer", e);
        }
        if (process != null) {
            process.destroyForcibly();
        }
    }

    public void startLoggingTask() {
        loggingTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onProgress(Void[] progress) {

            }

            @Override
            protected void onPreExecute() {
                helpers.setLogcatRunBoolean(true);
            }

            @Override
            protected Void doInBackground(Void... params) {
                // Start UI countdown
                new Handler(Looper.getMainLooper()).post(() -> {
                    countDownTimer = new CountDownTimer(
                        (long)logcatTimeout * 1000, 1000) {
                            
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int seconds = (int) (millisUntilFinished / 1000);
                            helpers.setCountDownLogcat(seconds);
                        }

                        @Override
                        public void onFinish() {
                            helpers.setCountDownLogcat(0);
                            isRunning = false;
                            if (logcatProcess != null) {
                                logcatProcess.destroy();
                            }
                        }
                    }.start();
                });

                // Start log capture immediately
                startLoggingToFile();
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                // Stop service after completion
                stopSelf();
            }

            @Override
            protected void onBackgroundError(Exception e) {
                Log.e(TAG, "Background error: " + e.getMessage());
            }
        }.execute();
    }

    private void cancelCountdownTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void cancelLoggingTask() {
        if (loggingTask != null && !loggingTask.isCancelled()) {
            loggingTask.cancel(true); 
        }
    }
}