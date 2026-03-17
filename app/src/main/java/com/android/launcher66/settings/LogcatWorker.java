package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class LogcatWorker {
    private static final String TAG = "LogcatWorker";
    private static final String LOG_FILE_SUFFIX = ".txt";
    private static final String LOG_DIR_NAME = "Launcher66_Logs";
    private static final String STREAM_BUFFER = "main";

    // Hard static reference so GC never collects the running instance
    private static volatile LogcatWorker sInstance;
    @SuppressWarnings("FieldCanBeLocal")
    private static Thread sRunningThread; // prevents GC kill

    public static LogcatWorker get() {
        if (sInstance == null) {
            synchronized (LogcatWorker.class) {
                if (sInstance == null) sInstance = new LogcatWorker();
            }
        }
        return sInstance;
    }

    private HandlerThread thread;
    private Handler handler;

    private volatile boolean running;
    private volatile Process logcatProcess;

    private BufferedWriter fileWriter;
    private int timeoutSeconds;

    private final Object lock = new Object();

    private volatile boolean isRunning = false; // Made volatile for visibility
    private AsyncTask<Void, Void, Void> loggingTask;
    private final Helpers helpers = new Helpers();
    private CountDownTimer countDownTimer;

    private LogcatWorker() {}

    public void start(Context context) {
        Log.e(TAG, "start() called");
        Context appCtx = context.getApplicationContext();

        synchronized (lock) {
            if (running) {
                Log.e(TAG, "start() ignored - already running");
                return;
            }

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(appCtx);
            timeoutSeconds = parseIntSafe(prefs.getString(Keys.LOGCAT_SERVICE_TIMEOUT, "30"), 30);
            Log.e(TAG, "start() timeoutSeconds=" + timeoutSeconds);

            running = true;

            thread = new HandlerThread("LogcatWorker");
            thread.start();
            handler = new Handler(thread.getLooper());

            helpers.setLogcatRunBoolean(true);

            handler.post(() -> startLoggingTask(appCtx));
        }
    }    

    public void startLoggingTask(Context appCtx) {
        loggingTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onProgress(Void[] progress) {

            }

            @Override
            protected void onPreExecute() {
                //
            }

            @Override
            protected Void doInBackground(Void... params) {
                // Start UI countdown
                new Handler(Looper.getMainLooper()).post(() -> {
                    countDownTimer = new CountDownTimer(
                        (long)timeoutSeconds * 1000, 1000) {
                            
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int seconds = (int) (millisUntilFinished / 1000);
                            helpers.setCountDownLogcat(seconds);
                        }

                        @Override
                        public void onFinish() {
                            helpers.setCountDownLogcat(0);
                            isRunning = false;
                        }
                    }.start();
                });

                // Start log capture
                runLogging(appCtx);
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                if (logcatProcess != null) {
                    logcatProcess.destroy();
                    logcatProcess = null;
                }
            }

            @Override
            protected void onBackgroundError(Exception e) {
                Log.e(TAG, "Background error: " + e.getMessage());
                if (logcatProcess != null) {
                    logcatProcess.destroy();
                    logcatProcess = null;
                }
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

    public void stop(boolean showToast, Context contextForToast) {
        Log.e(TAG, "stop() called showToast=" + showToast, new Throwable("stop() call stack"));
        synchronized (lock) {
            running = false;

            try {
                if (logcatProcess != null) logcatProcess.destroy();
            } catch (Throwable t) {
                Log.e(TAG, "Error stopping logcat process", t);
            }

            if (thread != null) {
                try { thread.quitSafely(); } catch (Throwable ignored) {}
            }

            thread = null;
            handler = null;
            logcatProcess = null;

            try {
                if (fileWriter != null) fileWriter.close();
            } catch (Throwable t) {
                Log.e(TAG, "Error closing writer", t);
            }
            fileWriter = null;
        }

        // Clean up components
        cancelCountdownTimer();
        cancelLoggingTask();

        helpers.setLogcatRunBoolean(false);
        helpers.setCountDownLogcat(0);

        if (showToast && contextForToast != null) {
            new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(
                    LauncherApplication.sApp,
                    R.string.logcat_service_run_toast,
                    Toast.LENGTH_LONG
            ).show());
        }
    }

    public void stop() {
        stop(false, null);
    }

    private void runLogging(Context ctx) {
        Log.e(TAG, "runLogging ENTERED thread=" + Thread.currentThread().getName());
        sRunningThread = Thread.currentThread();

        boolean fileOpened = false;
        BufferedReader reader = null;
        Process proc = null;

        final int myPid = android.os.Process.myPid();
        final long deadline = System.currentTimeMillis() + (long) timeoutSeconds * 1000L;
        Log.e(TAG, "runLogging pid=" + myPid + " deadline in " + timeoutSeconds + "s");

        try {
            if (ContextCompat.checkSelfPermission(ctx, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG, "WRITE_EXTERNAL_STORAGE permission not granted");
                return;
            }

            File downloadsDir = new File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    LOG_DIR_NAME
            );
            if (!downloadsDir.exists() && !downloadsDir.mkdirs()) {
                Log.e(TAG, "Failed to create log directory");
                return;
            }

            // Safe filename - no colons
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss", Locale.getDefault())
                    .format(new Date());
            File logFile = new File(downloadsDir, timestamp + LOG_FILE_SUFFIX);
            Log.e(TAG, "Opening log file: " + logFile.getAbsolutePath());

            fileWriter = new BufferedWriter(new FileWriter(logFile, true), 8192);
            fileOpened = true;
            Log.e(TAG, "Log file opened successfully");

            fileWriter.write("===== STREAM (PID=" + myPid + ", buffer=" + STREAM_BUFFER + ") =====\n");
            fileWriter.flush();

            int restartCount = 0;

            while (running && (timeoutSeconds <= 0 || System.currentTimeMillis() < deadline)) {
                restartCount++;
                Log.e(TAG, "logcat restart #" + restartCount + " running=" + running
                        + " remaining=" + ((deadline - System.currentTimeMillis()) / 1000) + "s");
                writeLine("----- logcat start #" + restartCount + " -----");

                proc = new ProcessBuilder("logcat", "-b", STREAM_BUFFER, "-v", "threadtime")
                        .redirectErrorStream(true)
                        .start();
                logcatProcess = proc;
                Log.e(TAG, "logcat process started, pid=" + proc.toString());

                reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                String line;
                boolean sawAny = false;

                while (running && (line = reader.readLine()) != null) {
                    if (timeoutSeconds > 0 && System.currentTimeMillis() >= deadline) {
                        Log.e(TAG, "Deadline reached inside read loop");
                        break;
                    }
                    if (lineHasPid(line, myPid) && shouldWriteAppLine(line)) {
                        fileWriter.write(line);
                        fileWriter.write('\n');
                        fileWriter.flush();
                        sawAny = true;
                    }
                }

                Log.e(TAG, "Inner read loop exited. running=" + running
                        + " sawAny=" + sawAny
                        + " threadInterrupted=" + Thread.currentThread().isInterrupted());

                closeQuietly(reader);
                reader = null;

                int exit = -1;
                try { proc.destroyForcibly(); } catch (Throwable ignored) {}  // force kill FIRST
                try { exit = proc.waitFor(); } catch (Throwable ignored) {}   // now safe to wait
                try { proc.destroy(); } catch (Throwable ignored) {}
                proc = null;
                try { logcatProcess.destroy(); } catch (Throwable ignored) {}
                logcatProcess = null;

                writeLine("----- logcat ended (EOF). exit=" + exit + " sawAny=" + sawAny + " -----");
                fileWriter.flush();

                if (!running) {
                    Log.e(TAG, "Exiting restart loop: running=false");
                    break;
                }
                if (timeoutSeconds > 0 && System.currentTimeMillis() >= deadline) {
                    Log.e(TAG, "Exiting restart loop: deadline reached");
                    break;
                }

                try {
                    Thread.sleep(250);
                } catch (InterruptedException ie) {
                    Log.e(TAG, "INTERRUPTED during sleep isInterrupted="
                            + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            Log.e(TAG, "Outer while loop exited. running=" + running
                    + " time_remaining=" + ((deadline - System.currentTimeMillis()) / 1000) + "s");

        } catch (Throwable t) {
            Log.e(TAG, "runLogging EXCEPTION", t);
            try {
                if (fileWriter != null) {
                    fileWriter.write("===== EXCEPTION =====\n");
                    fileWriter.write(Log.getStackTraceString(t));
                    fileWriter.write('\n');
                    fileWriter.flush();
                }
            } catch (Throwable ignored) {}
        } finally {
            Log.e(TAG, "runLogging FINALLY fileOpened=" + fileOpened + " running=" + running);
            running = false;

            closeQuietly(reader);

            try { if (proc != null) proc.destroyForcibly(); } catch (Throwable ignored) {}
            try { if (fileWriter != null) fileWriter.flush(); } catch (Throwable ignored) {}
            try { if (fileWriter != null) fileWriter.close(); } catch (Throwable ignored) {}

            fileWriter = null;
            logcatProcess = null;
            sRunningThread = null;

            Log.e(TAG, "Log capturing stopped, fileOpened=" + fileOpened);

            // Clean up components
            cancelCountdownTimer();
            cancelLoggingTask();

            helpers.setLogcatRunBoolean(false);
            helpers.setCountDownLogcat(0);

            if (fileOpened) {
                new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(
                        ctx,
                        R.string.logcat_service_run_toast,
                        Toast.LENGTH_LONG
                ).show());
            }
        }
    }

    private boolean shouldWriteAppLine(String line) {
        if (line == null) return false;
        if (line.contains("gralloc")) return false;
        if (line.contains("ResourcesManager")) return false;
        if (line.contains("OpenGLRenderer")) return false;
        if (line.contains("StrictMode")) return false;
        if (line.contains("Unisoc_Location")) return false;
        return true;
    }

    private static boolean lineHasPid(String threadtimeLine, int pid) {
        String needle = " " + pid + " ";
        return threadtimeLine != null && (threadtimeLine.contains(needle)
                || threadtimeLine.contains(" " + pid + "  "));
    }

    private void writeLine(String s) throws Exception {
        if (fileWriter == null) return;
        fileWriter.write(s);
        fileWriter.write('\n');
    }

    private static void closeQuietly(java.io.Closeable c) {
        try { if (c != null) c.close(); } catch (Throwable ignored) {}
    }

    private static int parseIntSafe(String s, int fallback) {
        try {
            return Integer.parseInt(s);
        } catch (Throwable ignored) {
            return fallback;
        }
    }
}