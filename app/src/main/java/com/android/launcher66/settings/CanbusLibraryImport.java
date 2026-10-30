package com.android.launcher66.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.OpenableColumns;
import android.util.AtomicFile;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Imports a canbus library file the user built (canbus_library/README.md): reads and checks it as a whole,
 * merges it into the library the user has imported so far (the file wins a conflict), saves the result and
 * writes a report to Download/Launcher66_Canbus. It runs on the library's own thread; the listener is called
 * on the main thread. A cancel before saving starts leaves everything as it was.
 */
final class CanbusLibraryImport {

    private static final String TAG = "CanbusLibraryImport";

    /** The share of the progress bar each phase takes: validation 0-70 %, merging 70-90 %, saving 90-100 %. */
    static final int VALIDATE_END = 70;
    static final int MERGE_END = 90;

    enum Kind { SUCCESS, FAILED, CANCELLED }

    interface Listener {
        /** What is going on: the percent of the bar, and the line being read (0 outside the validation). */
        void onProgress(int phase, int percent, int line, int totalLines);

        /** Saving has begun: from here the import can no longer be cancelled. */
        void onSaving();

        void onFinished(Outcome outcome);
    }

    static final int PHASE_READ = 0;
    static final int PHASE_VALIDATE = 1;
    static final int PHASE_MERGE = 2;
    static final int PHASE_SAVE = 3;

    static final class Outcome {
        Kind kind;
        /** The first error with its line, for a failure. */
        String firstError = "";
        int added;
        int duplicates;
        int replaced;
        /** Where the report is: the folder as the user finds it, and the file; null if it could not be saved. */
        String reportFolder;
        String reportFile;

        String reportPath() {
            return reportFolder == null ? null : reportFolder + "/" + reportFile;
        }
    }

    static final class Job {
        private boolean cancelled;
        private boolean saving;

        /** Ignored once saving has begun. */
        synchronized void cancel() {
            if (!saving) {
                cancelled = true;
            }
        }

        synchronized boolean isCancelled() {
            return cancelled;
        }

        synchronized boolean isSaving() {
            return saving;
        }

        /** False if the import was cancelled; else saving begins and cancelling no longer works. */
        synchronized boolean beginSaving() {
            if (cancelled) {
                return false;
            }
            saving = true;
            return true;
        }
    }

    private CanbusLibraryImport() {
    }

    /** Starts the import of the file {@code uri} points to. */
    static Job start(Context context, Uri uri, Listener listener) {
        final Context app = context.getApplicationContext();
        final Job job = new Job();
        CanbusLibrary.executor().execute(() -> {
            Outcome outcome;
            try {
                outcome = run(app, uri, job, listener);
            } catch (RuntimeException e) {
                Log.e(TAG, "The import failed", e);
                outcome = new Outcome();
                outcome.kind = Kind.FAILED;
                outcome.firstError = String.valueOf(e);
            }
            final Outcome result = outcome;
            new Handler(Looper.getMainLooper()).post(() -> listener.onFinished(result));
        });
        return job;
    }

    /** Removes the imported libraries (the file) and makes the next use read the built-in one. */
    static void reset(Context context, Runnable onMainThreadDone) {
        final Context app = context.getApplicationContext();
        CanbusLibrary.executor().execute(() -> {
            File file = CanbusLibrary.userFile(app);
            if (file.exists() && !file.delete()) {
                Log.w(TAG, "Could not delete " + file);
            }
            new AtomicFile(file).delete();
            CanbusLibrary.invalidate();
            CanbusLibrary.loadBlocking(app);
            CanbusClasses.refresh();
            new Handler(Looper.getMainLooper()).post(onMainThreadDone);
        });
    }

    private static void post(Listener listener, int phase, int percent, int line, int totalLines) {
        new Handler(Looper.getMainLooper()).post(() -> listener.onProgress(phase, percent, line, totalLines));
    }

    private static Outcome run(Context app, Uri uri, Job job, Listener listener) {
        final long started = System.currentTimeMillis();
        Outcome outcome = new Outcome();
        String fileName = null;
        long size = -1;
        ContentResolver resolver = app.getContentResolver();
        try (Cursor c = resolver.query(uri, null, null, null, null)) {
            if (c != null && c.moveToFirst()) {
                int nameAt = c.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                int sizeAt = c.getColumnIndex(OpenableColumns.SIZE);
                if (nameAt >= 0 && !c.isNull(nameAt)) {
                    fileName = c.getString(nameAt);
                }
                if (sizeAt >= 0 && !c.isNull(sizeAt)) {
                    size = c.getLong(sizeAt);
                }
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not read the name and size of the file", e);
        }
        if (fileName == null) {
            fileName = String.valueOf(uri.getLastPathSegment());
        }
        final String shownName = fileName;
        // Some document providers report 0 for a file that is not empty
        final long fileSize = size > 0 ? size : -1;

        post(listener, PHASE_READ, 0, 0, 0);
        CanbusLibrary.Library effectiveBefore = CanbusLibrary.loadBlocking(app);
        CanbusLibrary.Library overlay = CanbusLibrary.overlayBlocking(app);
        final int totalLines = countLines(resolver, uri);
        if (job.isCancelled()) {
            outcome.kind = Kind.CANCELLED;
            return outcome;
        }

        // 1. Read and check the whole file
        CanbusLibrary.ParseResult parsed;
        try (InputStream in = resolver.openInputStream(uri)) {
            if (in == null) {
                throw new IOException("the file cannot be opened");
            }
            Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            CanbusLibrary.ProgressSink sink = new CanbusLibrary.ProgressSink() {
                @Override
                public void onBytes(long read, long total) {
                    long max = total > 0 ? total : Math.max(read, 1);
                    post(listener, PHASE_VALIDATE, (int) (VALIDATE_END * Math.min(read, max) / max), 0, totalLines);
                }

                @Override
                public void onLine(int line) {
                    post(listener, PHASE_VALIDATE, -1, line, totalLines);
                }
            };
            parsed = CanbusLibrary.parse(reader, fileSize, sink, job::isCancelled);
        } catch (CanbusLibrary.CancelledException e) {
            outcome.kind = Kind.CANCELLED;
            return outcome;
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "Could not read the file", e);
            List<CanbusLibrary.Error> errors = new ArrayList<>();
            errors.add(new CanbusLibrary.Error(0, "could not read the file: " + e.getMessage()));
            parsed = new CanbusLibrary.ParseResult(null, errors, 0, 0, -1, null, null, 0);
        }
        if (job.isCancelled()) {
            outcome.kind = Kind.CANCELLED;
            return outcome;
        }
        if (!parsed.ok()) {
            outcome.kind = Kind.FAILED;
            outcome.firstError = parsed.errors.get(0).toString();
            writeReport(app, outcome, false, started, shownName, fileSize, parsed, null, effectiveBefore, null);
            return outcome;
        }

        // 2. Merge into what was imported before, and into the built-in library
        post(listener, PHASE_MERGE, VALIDATE_END, 0, 0);
        CanbusLibrary.MergeResult merged = overlay.mergedWith(parsed.library);
        CanbusLibrary.Library newOverlay = merged.library;
        outcome.added = merged.added();
        outcome.duplicates = merged.duplicates();
        outcome.replaced = merged.replaced();
        post(listener, PHASE_MERGE, MERGE_END, 0, 0);

        // 3. Save: from here on there is no cancelling
        if (!job.beginSaving()) {
            outcome.kind = Kind.CANCELLED;
            return outcome;
        }
        new Handler(Looper.getMainLooper()).post(listener::onSaving);
        post(listener, PHASE_SAVE, MERGE_END, 0, 0);
        AtomicFile atomic = new AtomicFile(CanbusLibrary.userFile(app));
        FileOutputStream out = null;
        try {
            out = atomic.startWrite();
            OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            writer.write(newOverlay.serialize());
            writer.flush();
            atomic.finishWrite(out);
        } catch (IOException | RuntimeException e) {
            Log.e(TAG, "Could not save the imported library", e);
            if (out != null) {
                atomic.failWrite(out);
            }
            outcome.kind = Kind.FAILED;
            outcome.firstError = "could not save the library: " + e.getMessage();
            List<CanbusLibrary.Error> errors = new ArrayList<>();
            errors.add(new CanbusLibrary.Error(0, outcome.firstError));
            writeReport(app, outcome, false, started, shownName, fileSize,
                    new CanbusLibrary.ParseResult(null, errors, parsed.duplicatesInFile, parsed.recordLines,
                            parsed.declaredRecords, parsed.declaredCrc, parsed.computedCrc, parsed.version),
                    null, effectiveBefore, null);
            return outcome;
        }
        CanbusLibrary.invalidate();
        CanbusLibrary.Library effectiveAfter = CanbusLibrary.loadBlocking(app);
        CanbusClasses.refresh();
        post(listener, PHASE_SAVE, 100, 0, 0);

        outcome.kind = Kind.SUCCESS;
        writeReport(app, outcome, true, started, shownName, fileSize, parsed, merged, effectiveBefore, effectiveAfter);
        return outcome;
    }

    /** The lines of the file, to show "line X of Y"; 0 if it cannot be counted. */
    private static int countLines(ContentResolver resolver, Uri uri) {
        try (InputStream in = resolver.openInputStream(uri)) {
            if (in == null) {
                return 0;
            }
            byte[] buffer = new byte[16 * 1024];
            int lines = 0;
            long total = 0;
            int last = '\n';
            int n;
            while ((n = in.read(buffer)) > 0) {
                total += n;
                if (total > CanbusLibrary.MAX_BYTES + buffer.length) {
                    return 0;
                }
                for (int i = 0; i < n; i++) {
                    if (buffer[i] == '\n') {
                        lines++;
                    }
                }
                last = buffer[n - 1];
            }
            return last == '\n' ? lines : lines + 1;
        } catch (IOException | RuntimeException e) {
            return 0;
        }
    }

    // ---------------------------------------------------------------------------------------------
    // The report
    // ---------------------------------------------------------------------------------------------

    private static void writeReport(Context app, Outcome outcome, boolean success, long started, String fileName,
                                    long fileSize, CanbusLibrary.ParseResult parsed, CanbusLibrary.MergeResult merged,
                                    CanbusLibrary.Library before, CanbusLibrary.Library after) {
        long now = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
        sb.append("Canbus library import - ").append(success ? "success" : "failed").append('\n');
        sb.append("Time: ").append(time.format(new Date(now))).append('\n');
        sb.append("File: ").append(fileName).append(" (").append(fileSize > 0 ? fileSize + " bytes" : "size unknown").append(")\n");
        sb.append("Result: ").append(success ? "success, the library was updated"
                : "failed, the library is unchanged").append('\n');
        sb.append("Duration: ").append(now - started).append(" ms\n\n");

        sb.append("Header: ").append(parsed.version > 0 ? "canbus_library " + parsed.version : "none").append('\n');
        sb.append("Footer: declared ").append(parsed.declaredRecords >= 0 ? parsed.declaredRecords + " records" : "none")
                .append(parsed.declaredCrc != null ? ", CRC32 " + parsed.declaredCrc : "")
                .append("; counted ").append(parsed.recordLines).append(" records")
                .append(parsed.computedCrc != null ? ", CRC32 " + parsed.computedCrc : "").append('\n');
        sb.append("Records in the file: ").append(parsed.recordLines).append(" lines, duplicates inside the file: ")
                .append(parsed.duplicatesInFile).append("\n\n");

        if (merged != null) {
            sb.append("Merged with the libraries imported before (the file wins a conflict):\n");
            appendCounts(sb, "C (screen classes, per car)", merged.classes);
            appendCounts(sb, "R (fuel pages, per car and page)", merged.requests);
            appendCounts(sb, "N (no request, per car)", merged.noRequest);
            appendCounts(sb, "S (fuel and range codes, per car)", merged.codes);
            sb.append('\n');
        }
        if (before != null) {
            sb.append("Cars with a class: ").append(before.carsWithClass());
            if (after != null) {
                sb.append(" -> ").append(after.carsWithClass());
            }
            sb.append('\n');
            sb.append("Cars with a request: ").append(before.carsWithRequest());
            if (after != null) {
                sb.append(" -> ").append(after.carsWithRequest());
            }
            sb.append("\n\n");
        }
        if (merged != null && !merged.replacements.isEmpty()) {
            sb.append("Replaced records (old -> new):\n");
            for (CanbusLibrary.Replacement r : merged.replacements) {
                sb.append("  ").append(r).append('\n');
            }
            sb.append('\n');
        }
        if (!success) {
            sb.append("Errors (").append(parsed.errors.size()).append("):\n");
            for (CanbusLibrary.Error e : parsed.errors) {
                sb.append("  ").append(e).append('\n');
            }
        }

        OutputDir out = outputDir(app);
        if (out == null) {
            return;
        }
        String stamp = new SimpleDateFormat(LogFileName.NAME_PATTERN, Locale.US).format(new Date(now));
        File file = uniqueFile(out.dir, "canbus_library_" + (success ? "success" : "failed") + "_" + stamp);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            Log.w(TAG, "Could not save the report", e);
            return;
        }
        outcome.reportFolder = out.shown;
        outcome.reportFile = file.getName();
    }

    /** The folder the reports and the exports go to, and how it is shown to the user. */
    static final class OutputDir {
        final File dir;
        final String shown;

        OutputDir(File dir, String shown) {
            this.dir = dir;
            this.shown = shown;
        }
    }

    /** The folder of the canbus files: the reports, the export and the code reader's recordings. */
    static final String CANBUS_DIR_NAME = "Launcher66_Canbus";

    /** Download/Launcher66_Canbus when it is usable, else the app's own folder; null if there is none. */
    static OutputDir outputDir(Context app) {
        File dir = LogcatWorker.usablePublicDir(app, CANBUS_DIR_NAME);
        boolean publicDir = dir != null;
        if (dir == null) {
            dir = LogcatWorker.resolveFallbackDir(app, CANBUS_DIR_NAME);
        }
        if (dir == null) {
            return null;
        }
        return new OutputDir(dir, publicDir ? "Download/" + dir.getName() : dir.getAbsolutePath());
    }

    /** {@code <base>.txt} in {@code dir}, or {@code <base>_N.txt} if that exists. */
    static File uniqueFile(File dir, String base) {
        File file = new File(dir, base + LogFileName.TXT);
        for (int n = 1; file.exists() && n < 1000; n++) {
            file = new File(dir, base + "_" + n + LogFileName.TXT);
        }
        return file;
    }

    private static void appendCounts(StringBuilder sb, String label, CanbusLibrary.Counts c) {
        sb.append("  ").append(label).append(": new ").append(c.added).append(", duplicate ").append(c.duplicate)
                .append(", replaced ").append(c.replaced).append('\n');
    }
}
