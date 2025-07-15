package com.android.launcher66.settings;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.android.async.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import ru.solrudev.ackpine.DisposableSubscriptionContainer;
import ru.solrudev.ackpine.installer.PackageInstaller;
import ru.solrudev.ackpine.installer.parameters.InstallParameters;
import ru.solrudev.ackpine.session.Failure;
import ru.solrudev.ackpine.session.Session;

public class VersionChecker {
    private AsyncTask<Void, Void, String> checkTask;
    private AsyncTask<Void, Integer, File> downloadTask;
    private static final String GITHUB_RELEASES_URL = "https://github.com/vasyl91/FYT-Launcher-Mod/releases/latest";
    private DisposableSubscriptionContainer installSubscriptions;

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

    public void checkForUpdate(String currentVersion, VersionCheckCallback callback) {
        checkTask = new AsyncTask<Void, Void, String>() {
            private Exception exception;

            @Override
            protected void onProgress(Void[] progress) {
                //
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url = new URL(GITHUB_RELEASES_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
                        connection.disconnect();
                        
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
                }
            }

            @Override
            protected void onPostExecute(String latestVersion) {
                if (exception != null) {
                    callback.onError("Error checking version: " + exception.getMessage());
                    return;
                }

                if (latestVersion == null) {
                    callback.onError("Failed to get version information");
                    return;
                }

                try {
                    if (isNewerVersion(currentVersion, latestVersion)) {
                        callback.onUpdateAvailable(latestVersion);
                    } else {
                        callback.onUpToDate();
                    }
                } catch (NumberFormatException e) {
                    callback.onError("Invalid version format: " + latestVersion);
                }
            }

            @Override
            protected void onBackgroundError(Exception e) {
                callback.onError("Error checking version: " + e.getMessage());
            }

            private boolean isNewerVersion(String current, String latest) {
                String[] currentParts = current.split("\\.");
                String[] latestParts = latest.split("\\.");

                int maxLength = Math.max(currentParts.length, latestParts.length);
                for (int i = 0; i < maxLength; i++) {
                    int currentNum = (i < currentParts.length) ? Integer.parseInt(currentParts[i]) : 0;
                    int latestNum = (i < latestParts.length) ? Integer.parseInt(latestParts[i]) : 0;
                    
                    if (latestNum > currentNum) return true;
                    if (latestNum < currentNum) return false;
                }
                return false;
            }
        }.execute();
    }

    public void cancelCheck() {
        if (checkTask != null && !checkTask.isCancelled()) {
            checkTask.cancel(true); 
        }
    }

    public void cancelInstall() {
        if (installSubscriptions != null) {
            installSubscriptions.dispose();
            installSubscriptions = null;
        }
    }

    public void downloadAndInstallApk(Context context, String latestVersion, DownloadCallback callback) {
        downloadTask = new AsyncTask<Void, Integer, File>() {
            private Exception exception;
            private String downloadUrl;

            @Override
            protected void onPreExecute() {
                downloadUrl = GITHUB_RELEASES_URL.replace("/releases/latest", "/releases/download/v" + latestVersion + "/update" + latestVersion + ".apk");
            }

            @Override
            protected File doInBackground(Void... params) {
                try {
                    URL url = new URL(downloadUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("User-Agent", "Update-Checker/1.0");
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);
                    int lenghtOfFile = connection.getContentLength();

                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        throw new IOException("Server returned HTTP " + responseCode);
                    }

                    callback.onDownloadStarted("update" + latestVersion);

                    InputStream input = connection.getInputStream();
                    File outputFile = new File(context.getExternalFilesDir(null), "update" + latestVersion + ".apk");
                    FileOutputStream output = new FileOutputStream(outputFile);

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long total = 0;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        total += bytesRead;
                        publishProgress(Integer.valueOf(""+(int)((total*100)/lenghtOfFile)));
                        output.write(buffer, 0, bytesRead);
                    }

                    output.close();
                    input.close();
                    return outputFile;
                } catch (IOException e) {
                    exception = e;
                    return null;
                }
            }

            @Override
            protected void onProgress(Integer... values) {
                callback.onDownloadProgress(values[0]);
            }

            @Override
            protected void onPostExecute(File apkFile) {
                if (exception != null) {
                    callback.onDownloadError("Download failed: " + exception.getMessage());
                    return;
                }

                installApk(context, apkFile);
                callback.onDownloadComplete();
            }

            @Override
            protected void onBackgroundError(Exception e) {
                callback.onDownloadError("Background error: " + e.getMessage());
            }

            private void installApk(Context context, File apkFile) {
                try (RandomAccessFile raf = new RandomAccessFile(apkFile, "r")) {
                    if (raf.readInt() != 0x504B0304) { // ZIP magic number
                        callback.onDownloadError("Invalid APK file (corrupted download)");
                        apkFile.delete();
                        return;
                    }
                } catch (IOException e) {
                    callback.onDownloadError("APK validation failed: " + e.getMessage());
                    return;
                }

                if (!apkFile.exists()) {
                    callback.onDownloadError("File does not exist!");
                    return;
                }
                if (apkFile.length() <= 0) {
                    callback.onDownloadError("File is empty or too small!");
                    return;
                }

               try {
                    Uri apkUri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", apkFile);
                    var packageInstaller = PackageInstaller.getInstance(context);
                    installSubscriptions = new DisposableSubscriptionContainer(); // Initialize
                    var parameters = new InstallParameters.Builder(apkUri).build();
                    var session = packageInstaller.createSession(parameters);
                    Session.TerminalStateListener.bind(session, installSubscriptions)
                            .addOnCancelListener(sessionId -> System.out.println("Cancelled"))
                            .addOnSuccessListener(sessionId -> System.out.println("Success"))
                            .addOnFailureListener((sessionId, failure) -> {
                                if (failure instanceof Failure.Exceptional f) {
                                    callback.onDownloadError("Installation failed: " + f.getException());
                                } else {
                                    callback.onDownloadError("Installation failed: " + failure.getMessage());
                                }
                            });
                } catch (Exception e) {
                    callback.onDownloadError("Installation failed: " + e.getMessage());
                    apkFile.delete(); // Clean up invalid file
                }
            }
        }.execute();
    }

    public void cancelDownload() {
        if (downloadTask != null && !downloadTask.isCancelled()) {
            downloadTask.cancel(true); 
        }
    }
}