package com.android.launcher66.settings;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.android.async.AsyncTask;
import com.android.launcher66.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

import ru.solrudev.ackpine.DisposableSubscriptionContainer;
import ru.solrudev.ackpine.installer.PackageInstaller;
import ru.solrudev.ackpine.installer.parameters.InstallParameters;
import ru.solrudev.ackpine.session.Failure;
import ru.solrudev.ackpine.session.Session;

public class VersionChecker {

    private static final String TAG = "VersionChecker";
    private static final String GITHUB_RELEASES_URL = "https://github.com/vasyl91/FYT-Launcher-Mod/releases/latest";

    private AsyncTask<Void, Void, String> checkTask;
    private AsyncTask<Void, Integer, File> downloadTask;
    private DisposableSubscriptionContainer installSubscriptions;

    /**
     * Callbacks behind a reference that can be cleared. This is the leak from the
     * LeakCanary report:
     *   Thread 'pool-4-thread-1'
     *     -> VersionChecker$1 (anonymous AsyncTask, Java Local on the thread's stack)
     *       -> VersionChecker$1.val$callback
     *         -> SettingsFragmentFirst$2
     *           -> SettingsFragmentFirst$2.this$0  == SettingsFragmentFirst
     *
     * The callback used to be captured directly in the synthetic val$callback field, so
     * while doInBackground() sat on HttpURLConnection (up to 10 s connect + 10 s read,
     * and an interrupt does not break that) the destroyed fragment stayed reachable from
     * the pool thread's stack, with no way for cancelCheck() to break the chain.
     *
     * The task now only sees an AtomicReference, which cancelCheck() clears immediately.
     */
    private final AtomicReference<VersionCheckCallback> checkCallbackRef = new AtomicReference<>();
    private final AtomicReference<DownloadCallback> downloadCallbackRef = new AtomicReference<>();

    /** Open connections, closed on cancel so the pool thread is released. */
    private final AtomicReference<HttpURLConnection> checkConnectionRef = new AtomicReference<>();
    private final AtomicReference<HttpURLConnection> downloadConnectionRef = new AtomicReference<>();

    public interface VersionCheckCallback {
        void onUpdateAvailable(String latestVersion);
        void onUpToDate();
        void onError(String error);
    }

    public interface DownloadCallback {
        void onDownloadStarted(String fileName);
        void onDownloadProgress(int progress);
        void onDownloadComplete();
        void onDownloadError(String error);
    }

    // =====================================================================================
    // VERSION CHECK
    // =====================================================================================

    public void checkForUpdate(final String currentVersion, VersionCheckCallback callback) {
        checkCallbackRef.set(callback);

        checkTask = new AsyncTask<Void, Void, String>() {
            private Exception exception;

            @Override
            protected void onProgress(Void[] progress) {
                //
            }

            @Override
            protected String doInBackground(Void... params) {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(GITHUB_RELEASES_URL);
                    connection = (HttpURLConnection) url.openConnection();
                    checkConnectionRef.set(connection);
                    connection.setInstanceFollowRedirects(false);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("User-Agent", "Update-Checker/1.0");
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);

                    int responseCode = connection.getResponseCode();

                    // Handle redirect manually to ensure we get the final URL
                    if (responseCode == HttpURLConnection.HTTP_MOVED_PERM ||
                        responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                        String location = connection.getHeaderField("Location");

                        // Check if the redirect location contains a valid tag
                        if (location == null || !location.contains("/tag/")) {
                            throw new IOException("Invalid redirect location");
                        }

                        // Extract version from redirect URL
                        String[] parts = location.split("/tag/v?");
                        if (parts.length < 2) {
                            throw new IOException("Invalid version tag format");
                        }
                        return parts[1].split("/")[0];
                    }

                    throw new IOException("Unexpected response code: " + responseCode);
                } catch (IOException e) {
                    exception = e;
                    return null;
                } finally {
                    // disconnect() used to run only on the redirect path; any other
                    // response left the connection sitting in the keep-alive pool.
                    checkConnectionRef.compareAndSet(connection, null);
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }

            @Override
            protected void onPostExecute(String latestVersion) {
                VersionCheckCallback cb = checkCallbackRef.get();
                if (cb == null) {
                    return;
                }

                if (exception != null) {
                    cb.onError("Error checking version: " + exception.getMessage());
                    return;
                }

                if (latestVersion == null) {
                    cb.onError("Failed to get version information");
                    return;
                }

                try {
                    if (isNewerVersion(currentVersion, latestVersion)) {
                        cb.onUpdateAvailable(latestVersion);
                    } else {
                        cb.onUpToDate();
                    }
                } catch (NumberFormatException e) {
                    cb.onError("Invalid version format: " + latestVersion);
                }
            }

            @Override
            protected void onBackgroundError(Exception e) {
                VersionCheckCallback cb = checkCallbackRef.get();
                if (cb != null) {
                    cb.onError("Error checking version: " + e.getMessage());
                }
            }

            private boolean isNewerVersion(String current, String latest) {
                String[] currentParts = current.split("\\.");
                String[] latestParts = latest.split("\\.");
                boolean isDebug = BuildConfig.DEBUG;

                int maxLength = Math.max(currentParts.length, latestParts.length);
                for (int i = 0; i < maxLength; i++) {
                    int currentNum = (i < currentParts.length) ? Integer.parseInt(currentParts[i]) : 0;
                    int latestNum = (i < latestParts.length) ? Integer.parseInt(latestParts[i]) : 0;

                    if (latestNum == currentNum && isDebug) return true;
                    if (latestNum > currentNum) return true;
                    if (latestNum < currentNum) return false;
                }
                return false;
            }
        }.execute();
    }

    public void cancelCheck() {
        // Order matters: drop the callback reference (and with it the Fragment) first,
        // then try to stop the task itself.
        checkCallbackRef.set(null);
        closeQuietly(checkConnectionRef.getAndSet(null));
        if (checkTask != null && !checkTask.isCancelled()) {
            checkTask.cancel(true);
        }
        checkTask = null;
    }

    // =====================================================================================
    // DOWNLOAD + INSTALL
    // =====================================================================================

    public void downloadAndInstallApk(final Context context, final String latestVersion,
                                      DownloadCallback callback) {
        // The task outlives the caller, so never hold on to an Activity context.
        final Context appContext = context.getApplicationContext();
        downloadCallbackRef.set(callback);

        downloadTask = new AsyncTask<Void, Integer, File>() {
            private Exception exception;
            private String downloadUrl;

            @Override
            protected void onPreExecute() {
                downloadUrl = GITHUB_RELEASES_URL.replace("/releases/latest",
                        "/releases/download/v" + latestVersion + "/update" + latestVersion + ".apk");
            }

            @Override
            protected File doInBackground(Void... params) {
                HttpURLConnection connection = null;
                InputStream input = null;
                FileOutputStream output = null;
                try {
                    URL url = new URL(downloadUrl);
                    connection = (HttpURLConnection) url.openConnection();
                    downloadConnectionRef.set(connection);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("User-Agent", "Update-Checker/1.0");
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);
                    int lenghtOfFile = connection.getContentLength();

                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        throw new IOException("Server returned HTTP " + responseCode);
                    }

                    DownloadCallback started = downloadCallbackRef.get();
                    if (started != null) {
                        started.onDownloadStarted("update" + latestVersion);
                    }

                    input = connection.getInputStream();
                    File outputFile = new File(appContext.getExternalFilesDir(null),
                            "update" + latestVersion + ".apk");
                    output = new FileOutputStream(outputFile);

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long total = 0;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        // The download loop never checked for cancellation, so the file
                        // kept streaming after the settings screen was closed.
                        if (isCancelled()) {
                            return null;
                        }
                        total += bytesRead;
                        if (lenghtOfFile > 0) {
                            publishProgress((int) ((total * 100) / lenghtOfFile));
                        }
                        output.write(buffer, 0, bytesRead);
                    }

                    return outputFile;
                } catch (IOException e) {
                    exception = e;
                    return null;
                } finally {
                    closeQuietly(output);
                    closeQuietly(input);
                    downloadConnectionRef.compareAndSet(connection, null);
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }

            @Override
            protected void onProgress(Integer[] values) {
                DownloadCallback cb = downloadCallbackRef.get();
                if (cb != null && values != null && values.length > 0) {
                    cb.onDownloadProgress(values[0]);
                }
            }

            @Override
            protected void onPostExecute(File apkFile) {
                DownloadCallback cb = downloadCallbackRef.get();
                if (cb == null) {
                    return;
                }
                if (exception != null) {
                    cb.onDownloadError("Download failed: " + exception.getMessage());
                    return;
                }
                if (apkFile == null) {
                    return;
                }

                installApk(appContext, apkFile);
                cb.onDownloadComplete();
            }

            @Override
            protected void onBackgroundError(Exception e) {
                DownloadCallback cb = downloadCallbackRef.get();
                if (cb != null) {
                    cb.onDownloadError("Background error: " + e.getMessage());
                }
            }
        }.execute();
    }

    private void installApk(Context context, File apkFile) {
        DownloadCallback cb = downloadCallbackRef.get();

        try (RandomAccessFile raf = new RandomAccessFile(apkFile, "r")) {
            if (raf.readInt() != 0x504B0304) { // ZIP magic number
                if (cb != null) cb.onDownloadError("Invalid APK file (corrupted download)");
                apkFile.delete();
                return;
            }
        } catch (IOException e) {
            if (cb != null) cb.onDownloadError("APK validation failed: " + e.getMessage());
            return;
        }

        if (!apkFile.exists()) {
            if (cb != null) cb.onDownloadError("File does not exist!");
            return;
        }
        if (apkFile.length() <= 0) {
            if (cb != null) cb.onDownloadError("File is empty or too small!");
            return;
        }

        try {
            Uri apkUri = FileProvider.getUriForFile(context,
                    context.getPackageName() + ".fileprovider", apkFile);
            var packageInstaller = PackageInstaller.getInstance(context);
            cancelInstall(); // do not orphan a previous subscription container
            installSubscriptions = new DisposableSubscriptionContainer();
            var parameters = new InstallParameters.Builder(apkUri).build();
            var session = packageInstaller.createSession(parameters);
            Session.TerminalStateListener.bind(session, installSubscriptions)
                    .addOnCancelListener(sessionId -> Log.i(TAG, "Install cancelled"))
                    .addOnSuccessListener(sessionId -> Log.i(TAG, "Install success"))
                    .addOnFailureListener((sessionId, failure) -> {
                        DownloadCallback current = downloadCallbackRef.get();
                        if (current == null) {
                            return;
                        }
                        if (failure instanceof Failure.Exceptional f) {
                            current.onDownloadError("Installation failed: " + f.getException());
                        } else {
                            current.onDownloadError("Installation failed: " + failure.getMessage());
                        }
                    });
        } catch (Exception e) {
            if (cb != null) cb.onDownloadError("Installation failed: " + e.getMessage());
            apkFile.delete(); // Clean up invalid file
        }
    }

    public void cancelDownload() {
        downloadCallbackRef.set(null);
        closeQuietly(downloadConnectionRef.getAndSet(null));
        if (downloadTask != null && !downloadTask.isCancelled()) {
            downloadTask.cancel(true);
        }
        downloadTask = null;
    }

    public void cancelInstall() {
        if (installSubscriptions != null) {
            installSubscriptions.dispose();
            installSubscriptions = null;
        }
    }

    /** One call to clean everything up, for onDestroyView(). */
    public void cancelAll() {
        cancelCheck();
        cancelDownload();
        cancelInstall();
    }

    private static void closeQuietly(HttpURLConnection connection) {
        if (connection != null) {
            try {
                connection.disconnect();
            } catch (Throwable ignored) {
            }
        }
    }

    private static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable ignored) {
            }
        }
    }
}
