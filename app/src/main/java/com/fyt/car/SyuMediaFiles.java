package com.fyt.car;

import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.fyt.car.SyuMediaReadPolicy.Outcome;
import com.syu.util.WindowHostVdClient;
import com.syu.vdhost.HostFilePolicy;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

/**
 * Reads the few files of com.syu.media (the 7870's player) that the launcher shows: the cover of the
 * song a phone plays over Bluetooth, the logos of the stock radio and the icon pack of the online
 * radio. Background threads only: it opens files and may start {@code su}.
 *
 * <p>The ways, in this order, until one works:
 * <ol>
 *   <li>the file itself. On the 7870 SELinux is permissive and com.syu.media, an ordinary app uid,
 *       reads these files itself, so this works in either version;</li>
 *   <li>as the system (uid 1000): the same read; the uid is in the log;</li>
 *   <li>root: {@code su -c cat}, only where root is there;</li>
 *   <li>the VD host (the Magisk daemon or Shizuku), its readFile() of protocol 3, only where the host knows it.</li>
 * </ol>
 * What worked is remembered per family of paths, so that {@code su} is not asked for every cover, and
 * that way is tried first (and never twice in one round). Only paths HostFilePolicy allows are read, by
 * any of the ways. A file that is not there is not a refusal (see {@link SyuMediaReadPolicy}): the first
 * way that finds it missing ends the round, and nothing is held off. A path that every way was refused
 * is not tried again for 30 s, except the Bluetooth cover, which is looked for again a few times after
 * each track change. The pictures are at most 2 MB and are read into memory; the icon pack is at most
 * 64 MB and is copied in a stream. The log has one line per family and way:
 * {@code SyuMediaFiles: <family> via <direct|system|root|shizuku|daemon> -> ok|fail}.
 */
final class SyuMediaFiles {

    private static final String TAG = "SyuMediaFiles";

    static final String FAMILY_BT_COVER = "bt-cover";
    static final String FAMILY_RADIO_LOGO = "radio-logo";
    static final String FAMILY_ICON_PACK = "icon-pack";

    private static final long ROOT_TIMEOUT_MS = 3_000L;
    /** A copy of the icon pack through su: tens of MB can take longer than a picture. */
    private static final long ROOT_COPY_TIMEOUT_MS = 20_000L;
    private static final long NEGATIVE_MS = 30_000L;

    private SyuMediaFiles() {
    }

    /** The bytes of a file and when it was last modified (ms; 0 if the way cannot tell). */
    static final class Data {
        final byte[] bytes;
        final long lastModifiedMs;
        final String via;

        Data(byte[] bytes, long lastModifiedMs, String via) {
            this.bytes = bytes;
            this.lastModifiedMs = lastModifiedMs;
            this.via = via;
        }
    }

    /** A file that was copied: how long it is and by which way. */
    static final class Copied {
        final long bytes;
        final String via;

        Copied(long bytes, String via) {
            this.bytes = bytes;
            this.via = via;
        }
    }

    /** An open file of one way. close() ends the way (the process of su, the descriptor of the host). */
    private static final class Source implements Closeable {
        final InputStream in;
        final long modifiedMs;
        final String via;
        private final BooleanSupplier complete;
        private final Runnable onClose;

        Source(InputStream in, long modifiedMs, String via, BooleanSupplier complete, Runnable onClose) {
            this.in = in;
            this.modifiedMs = modifiedMs;
            this.via = via;
            this.complete = complete;
            this.onClose = onClose;
        }

        /** Whether the way ended without an error, once its stream is read to the end. */
        boolean complete() {
            return complete == null || complete.getAsBoolean();
        }

        @Override
        public void close() {
            try {
                in.close();
            } catch (IOException ignored) {
                // nothing left to do
            }
            if (onClose != null) {
                onClose.run();
            }
        }
    }

    /** What a way found: the outcome, and the file when it is open. */
    private static final class Opened {
        final Outcome outcome;
        final Source source;

        private Opened(Outcome outcome, Source source) {
            this.outcome = outcome;
            this.source = source;
        }

        static Opened of(Outcome outcome) {
            return new Opened(outcome, null);
        }

        static Opened of(Source source) {
            return new Opened(Outcome.OK, source);
        }
    }

    /** What is done with an open file; false when it could not be taken (too long, a write failed). */
    private interface Sink {
        boolean take(Source source) throws IOException;
    }

    /** What worked for a family: "direct", "root" or "host" (see SyuMediaReadPolicy.wayOf). */
    private static final Map<String, String> sWorked = new ConcurrentHashMap<>();
    private static final Set<String> sLogged = ConcurrentHashMap.newKeySet();
    private static final Map<String, Long> sFailedAt = new ConcurrentHashMap<>();

    /** @return the file, or null when it is not there or none of the ways reads it */
    static Data read(String family, String path) {
        final Data[] out = new Data[1];
        final long max = SyuMediaReadPolicy.maxBytes(family);
        run(family, path, source -> {
            byte[] bytes = readAll(source.in, max);
            if (bytes == null || !source.complete()) {
                return false;
            }
            out[0] = new Data(bytes, source.modifiedMs, source.via);
            return true;
        });
        return out[0];
    }

    /**
     * Copies a file to {@code dest} (for the icon pack, which PackageManager has to open as a file),
     * in a stream, so that a pack of tens of MB is never in memory. Same ways as {@link #read}.
     * @return what was copied, null when dest does not hold the file now
     */
    static Copied copyTo(String family, String path, File dest) {
        final Copied[] out = new Copied[1];
        final long max = SyuMediaReadPolicy.maxBytes(family);
        run(family, path, source -> {
            File dir = dest.getParentFile();
            if (dir != null && !dir.isDirectory() && !dir.mkdirs()) {
                return false;
            }
            File tmp = new File(dest.getPath() + ".tmp");
            long copied;
            try (FileOutputStream file = new FileOutputStream(tmp)) {
                copied = copy(source.in, file, max);
            } catch (IOException e) {
                Log.w(TAG, "could not write " + tmp + ": " + e);
                copied = -1L;
            }
            if (copied < 0L || !source.complete()) {
                tmp.delete();
                return false;
            }
            if (dest.exists() && !dest.delete()) {
                tmp.delete();
                return false;
            }
            if (!tmp.renameTo(dest)) {
                tmp.delete();
                return false;
            }
            out[0] = new Copied(copied, source.via);
            return true;
        });
        return out[0];
    }

    /** Asks the ways, one after the other, until one of them hands the file to the sink. */
    private static void run(String family, String path, Sink sink) {
        if (path == null || !HostFilePolicy.pathAllowed(path)) {
            return;
        }
        Long failed = sFailedAt.get(path);
        if (failed != null && System.currentTimeMillis() - failed < NEGATIVE_MS) {
            return;
        }
        long max = SyuMediaReadPolicy.maxBytes(family);
        List<Outcome> outcomes = new ArrayList<>();
        for (String way : SyuMediaReadPolicy.order(sWorked.get(family))) {
            String via = null;
            Outcome outcome;
            Opened opened = open(way, family, path, max);
            if (opened.source == null) {
                outcome = opened.outcome;
            } else {
                try (Source source = opened.source) {
                    outcome = sink.take(source) ? Outcome.OK : Outcome.DENIED;
                    via = source.via;
                } catch (IOException | RuntimeException e) {
                    outcome = Outcome.DENIED;
                }
            }
            if (outcome == Outcome.OK) {
                sFailedAt.remove(path);
                sWorked.put(family, SyuMediaReadPolicy.wayOf(via));
                logOnce(family, via, true);
                return;
            }
            outcomes.add(outcome);
            if (outcome == Outcome.MISSING) {
                // An answer, not a refusal: su and the host would only find the same.
                logOnce(family, "missing", true);
                return;
            }
        }
        if (SyuMediaReadPolicy.holdOff(family, outcomes)) {
            sFailedAt.put(path, System.currentTimeMillis());
        }
        logOnce(family, "any", false);
    }

    private static Opened open(String way, String family, String path, long max) {
        try {
            switch (way) {
                case "direct":
                    return direct(path, max);
                case "root":
                    return root(path, max, SyuMediaReadPolicy.maxBytes(family) > HostFilePolicy.MAX_BYTES
                            ? ROOT_COPY_TIMEOUT_MS : ROOT_TIMEOUT_MS);
                case "host":
                    return host(path);
                default:
                    return Opened.of(Outcome.DENIED);
            }
        } catch (IOException | RuntimeException | android.os.RemoteException e) {
            return Opened.of(Outcome.DENIED);
        }
    }

    /** The file itself; "system" in the log when the launcher runs as uid 1000. */
    private static Opened direct(String path, long max) {
        StructStat stat;
        try {
            stat = Os.stat(path);
        } catch (ErrnoException e) {
            // ENOENT is a file that is not there; EACCES (a folder the app may not enter) is not an answer.
            return Opened.of(SyuMediaReadPolicy.fromErrno(e.errno));
        }
        if (!OsConstants.S_ISREG(stat.st_mode)) {
            return Opened.of(Outcome.MISSING);
        }
        if (stat.st_size > max) {
            return Opened.of(Outcome.DENIED);
        }
        try {
            FileInputStream in = new FileInputStream(path);
            boolean system = Process.myUid() == Process.SYSTEM_UID || LauncherApplication.hasSystemPrivileges();
            return Opened.of(new Source(in, stat.st_mtime * 1000L, system ? "system" : "direct", null, null));
        } catch (IOException e) {
            return Opened.of(Outcome.DENIED);
        }
    }

    /**
     * {@code su -c cat}: the path is one HostFilePolicy allows and has no character a shell would read.
     * The first line of the output is the file's mtime (stat), the rest is the file.
     */
    private static Opened root(String path, long max, long timeoutMs) throws IOException {
        if (!WindowHostVdClient.hasRoot() || !path.matches("[A-Za-z0-9._/ -]+") || path.contains(" ")) {
            return Opened.of(Outcome.DENIED);
        }
        final java.lang.Process proc = new ProcessBuilder("su", "-c", "stat -c %Y " + path + " && cat " + path)
                .redirectErrorStream(false)
                .start();
        // su can wait for a root grant that nobody answers: read under a watchdog that ends the process
        final Thread watchdog = new Thread(() -> {
            try {
                Thread.sleep(timeoutMs);
                proc.destroy();
            } catch (InterruptedException e) {
                // finished in time
            }
        }, "SyuMediaFilesRoot");
        watchdog.setDaemon(true);
        watchdog.start();
        final Runnable end = () -> {
            watchdog.interrupt();
            proc.destroy();
        };
        InputStream in = proc.getInputStream();
        try {
            StringBuilder line = new StringBuilder();
            int c;
            while ((c = in.read()) >= 0 && c != '\n' && line.length() < 24) {
                line.append((char) c);
            }
            if (c != '\n') {
                // stat failed (or su did): the error says whether the file is not there
                Outcome outcome = Outcome.DENIED;
                if (proc.waitFor(timeoutMs, TimeUnit.MILLISECONDS)) {
                    byte[] error = readAll(proc.getErrorStream(), 512L);
                    if (error != null && new String(error).contains("No such file")) {
                        outcome = Outcome.MISSING;
                    }
                }
                end.run();
                return Opened.of(outcome);
            }
            long seconds = Long.parseLong(line.toString().trim());
            BooleanSupplier complete = () -> {
                try {
                    return proc.waitFor(timeoutMs, TimeUnit.MILLISECONDS) && proc.exitValue() == 0;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            };
            return Opened.of(new Source(in, seconds * 1000L, "root", complete, end));
        } catch (NumberFormatException e) {
            end.run();
            return Opened.of(Outcome.DENIED);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            end.run();
            return Opened.of(Outcome.DENIED);
        } catch (IOException | RuntimeException e) {
            end.run();
            throw e;
        }
    }

    /** The VD host (protocol 3). It does not say why it refuses, so a refusal is a denial. */
    private static Opened host(String path) throws IOException, android.os.RemoteException {
        if (!WindowHostVdClient.supportsOptionalCalls()) {
            return Opened.of(Outcome.DENIED);
        }
        ParcelFileDescriptor pfd = WindowHostVdClient.readFile(path);
        if (pfd == null) {
            return Opened.of(Outcome.DENIED);
        }
        long modified = 0L;
        try {
            modified = Os.fstat(pfd.getFileDescriptor()).st_mtime * 1000L;
        } catch (Exception e) {
            // the way cannot tell: 0
        }
        return Opened.of(new Source(new ParcelFileDescriptor.AutoCloseInputStream(pfd), modified,
                WindowHostVdClient.hostSourceName(), null, null));
    }

    /** @return the bytes, null when the stream is longer than the limit */
    private static byte[] readAll(InputStream in, long limit) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int n;
        while ((n = in.read(buffer)) > 0) {
            out.write(buffer, 0, n);
            if (out.size() > limit) {
                return null;
            }
        }
        return out.toByteArray();
    }

    /** @return the number of bytes copied, -1 when the stream is longer than the limit */
    private static long copy(InputStream in, FileOutputStream out, long limit) throws IOException {
        byte[] buffer = new byte[64 * 1024];
        long total = 0L;
        int n;
        while ((n = in.read(buffer)) > 0) {
            total += n;
            if (total > limit) {
                return -1L;
            }
            out.write(buffer, 0, n);
        }
        return total;
    }

    private static void logOnce(String family, String via, boolean ok) {
        if (sLogged.add(family + "|" + via + "|" + ok)) {
            if ("missing".equals(via)) {
                Log.i(TAG, family + " -> the file is not there (uid " + Process.myUid() + ")");
            } else {
                Log.i(TAG, family + " via " + via + " -> " + (ok ? "ok" : "fail") + " (uid " + Process.myUid() + ")");
            }
        }
    }
}
