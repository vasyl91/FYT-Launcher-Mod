package com.android.launcher66.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Saves the library the launcher really uses (the built-in one merged with the imported ones) to a file in
 * Download/Launcher66_Logs, where the import's reports go, so that it can be compared with another library
 * (canbus_library/README.md, section 4). It runs on the library's own thread; the listener is called on the
 * main thread.
 */
final class CanbusLibraryExport {

    private static final String TAG = "CanbusLibraryExport";

    static final class Result {
        /** The folder as the user finds it and the file name; null when the export failed. */
        String folder;
        String file;
        /** Why it failed; null on success. */
        String error;

        boolean ok() {
            return error == null;
        }

        String path() {
            return folder + "/" + file;
        }
    }

    interface Listener {
        void onFinished(Result result);
    }

    private CanbusLibraryExport() {
    }

    static void start(Context context, Listener listener) {
        final Context app = context.getApplicationContext();
        CanbusLibrary.executor().execute(() -> {
            Result result;
            try {
                result = run(app);
            } catch (RuntimeException e) {
                Log.e(TAG, "The export failed", e);
                result = new Result();
                result.error = String.valueOf(e);
            }
            final Result done = result;
            new Handler(Looper.getMainLooper()).post(() -> listener.onFinished(done));
        });
    }

    private static Result run(Context app) {
        Result result = new Result();
        CanbusLibrary.Library library = CanbusLibrary.loadBlocking(app);
        long now = System.currentTimeMillis();
        String text = CanbusLibrary.exportText(library, now);
        CanbusLibraryImport.OutputDir out = CanbusLibraryImport.outputDir(app);
        if (out == null) {
            result.error = "no folder to save to";
            return result;
        }
        String name = CanbusLibrary.exportFileName(now);
        File file = CanbusLibraryImport.uniqueFile(out.dir, name.substring(0, name.length() - LogFileName.TXT.length()));
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(text);
        } catch (IOException e) {
            Log.w(TAG, "Could not save the export", e);
            if (file.exists() && !file.delete()) {
                Log.w(TAG, "Could not delete the partial file " + file);
            }
            result.error = e.getMessage() != null ? e.getMessage() : e.toString();
            return result;
        }
        result.folder = out.shown;
        result.file = file.getName();
        return result;
    }
}
