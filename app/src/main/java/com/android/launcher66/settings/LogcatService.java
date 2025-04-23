package com.android.launcher66.settings;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogcatService extends Service {

    /**
     * this service starts in LauncherApplication.java which usually happens on system start
     * and saves logs in Download/launcher_logs
     * might be useful for debugging on device that is not connected to the PC
    */   

    private static final String TAG = "LogcatService";
    private static final String LOG_FILE_SUFFIX = ".txt";

    private java.lang.Process logcatProcess;
    private FileWriter fileWriter;
    private boolean isRunning = false;
    private int myPid;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
        myPid = Process.myPid(); // Get the process ID of this application
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service started, PID: " + myPid);
        isRunning = true;

        // Check for WRITE_EXTERNAL_STORAGE permission
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "WRITE_EXTERNAL_STORAGE permission not granted. Cannot save logs.");
            stopSelf();
            return START_NOT_STICKY;
        }

        new Thread(() -> {
            try {
                // Get the Download directory
                File downloadsDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "launcher_logs"); // Download/launcher_logs
                if (!downloadsDir.exists()) {
                    if (!downloadsDir.mkdirs()) {
                        Log.e(TAG, "Failed to create Download directory");
                        stopSelf();
                        return;
                    }
                }

                // Create a unique log file name with timestamp
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss", Locale.getDefault());
                String timestamp = sdf.format(new Date());
                File logFile = new File(downloadsDir, timestamp + LOG_FILE_SUFFIX);

                fileWriter = new FileWriter(logFile, true); // Append to the file

                // Command to read logs for the specific app's process
                String[] command = new String[]{"logcat", "-v", "threadtime"};
                logcatProcess = Runtime.getRuntime().exec(command);

                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(logcatProcess.getInputStream()));

                String line;
                while (isRunning && (line = bufferedReader.readLine()) != null) {
                    // Filter logs by the app's PID
                    if (line.contains(String.valueOf(myPid)) && !line.contains("ContextImpl") && !line.contains("Unisoc_Location")) {
                        fileWriter.write(line);
                        fileWriter.write("\n");
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, "Error capturing logs: " + e.getMessage());
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        Log.e(TAG, "Error closing log file: " + e.getMessage());
                    }
                }
                if (logcatProcess != null) {
                    logcatProcess.destroy();
                }
                isRunning = false;
                Log.i(TAG, "Log capturing stopped");
                stopSelf();
            }
        }).start();

        return START_NOT_STICKY; 
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");
        isRunning = false; 
        if (logcatProcess != null) {
            logcatProcess.destroy();
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing log file on destroy: " + e.getMessage());
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; 
    }
}