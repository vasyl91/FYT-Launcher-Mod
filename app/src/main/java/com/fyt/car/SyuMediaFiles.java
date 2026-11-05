package com.fyt.car;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.util.WindowHostVdClient;
import com.syu.vdhost.HostFilePolicy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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
 *   <li>root: {@code su -c cat} (at most 2 MB, 3 s), only where root is there;</li>
 *   <li>the VD host (the Magisk daemon or Shizuku), its readFile() of protocol 3, only where the host knows it.</li>
 * </ol>
 * What worked is remembered per family of paths, so that {@code su} is not asked for every cover. Only
 * paths HostFilePolicy allows are read, by any of the ways. A path that could not be read by any is not
 * tried again for 30 s. The log has one line per family and way:
 * {@code SyuMediaFiles: <family> via <direct|system|root|shizuku|daemon> -> ok|fail}.
 */
final class SyuMediaFiles {

    private static final String TAG = "SyuMediaFiles";

    static final String FAMILY_BT_COVER = "bt-cover";
    static final String FAMILY_RADIO_LOGO = "radio-logo";
    static final String FAMILY_ICON_PACK = "icon-pack";

    private static final long ROOT_TIMEOUT_MS = 3_000L;
    private static final long NEGATIVE_MS = 30_000L;
    private static final long MAX_BYTES = HostFilePolicy.MAX_BYTES;

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

    /** What worked for a family: "direct", "system", "root", "shizuku" or "daemon". */
    private static final Map<String, String> sWorked = new ConcurrentHashMap<>();
    private static final Set<String> sLogged = ConcurrentHashMap.newKeySet();
    private static final Map<String, Long> sFailedAt = new ConcurrentHashMap<>();

    /** @return the file, or null when none of the ways reads it */
    static Data read(String family, String path) {
        if (path == null || !HostFilePolicy.pathAllowed(path)) {
            return null;
        }
        Long failed = sFailedAt.get(path);
        if (failed != null && System.currentTimeMillis() - failed < NEGATIVE_MS) {
            return null;
        }
        String first = sWorked.get(family);
        Data data = null;
        if (first != null) {
            data = tryWay(first, path);
        }
        if (data == null) {
            for (String way : new String[]{"direct", "root", "host"}) {
                data = tryWay(way, path);
                if (data != null) {
                    break;
                }
            }
        }
        if (data == null) {
            sFailedAt.put(path, System.currentTimeMillis());
            logOnce(family, "any", false);
            return null;
        }
        sFailedAt.remove(path);
        sWorked.put(family, data.via);
        logOnce(family, data.via, true);
        return data;
    }

    /**
     * Copies a file to {@code dest} (for the icon pack, which PackageManager has to open as a file). Same
     * ways as {@link #read}. @return whether dest now holds the file
     */
    static boolean copyTo(String family, String path, File dest) {
        Data data = read(family, path);
        if (data == null) {
            return false;
        }
        File dir = dest.getParentFile();
        if (dir != null && !dir.isDirectory() && !dir.mkdirs()) {
            return false;
        }
        File tmp = new File(dest.getPath() + ".tmp");
        try (FileOutputStream out = new FileOutputStream(tmp)) {
            out.write(data.bytes);
        } catch (IOException e) {
            Log.w(TAG, "could not write " + dest + ": " + e);
            return false;
        }
        if (dest.exists() && !dest.delete()) {
            return false;
        }
        return tmp.renameTo(dest);
    }

    private static Data tryWay(String way, String path) {
        try {
            switch (way) {
                case "direct":
                case "system":
                    return direct(path);
                case "root":
                    return root(path);
                case "shizuku":
                case "daemon":
                case "host":
                    return host(path);
                default:
                    return null;
            }
        } catch (IOException | RuntimeException | android.os.RemoteException e) {
            return null;
        }
    }

    /** The file itself; "system" in the log when the launcher runs as uid 1000. */
    private static Data direct(String path) throws IOException {
        File file = new File(path);
        if (!file.isFile() || file.length() > MAX_BYTES) {
            return null;
        }
        long modified = file.lastModified();
        try (InputStream in = new FileInputStream(file)) {
            byte[] bytes = readAll(in);
            if (bytes == null) {
                return null;
            }
            boolean system = Process.myUid() == Process.SYSTEM_UID || LauncherApplication.hasSystemPrivileges();
            return new Data(bytes, modified, system ? "system" : "direct");
        }
    }

    /** {@code su -c cat}: the path is one HostFilePolicy allows and has no character a shell would read. */
    private static Data root(String path) throws IOException {
        if (!WindowHostVdClient.hasRoot() || !path.matches("[A-Za-z0-9._/ -]+") || path.contains(" ")) {
            return null;
        }
        java.lang.Process p = new ProcessBuilder("su", "-c", "stat -c %Y " + path + " && cat " + path)
                .redirectErrorStream(false)
                .start();
        // su can wait for a root grant that nobody answers: read under a watchdog that ends the process
        final java.lang.Process proc = p;
        Thread watchdog = new Thread(() -> {
            try {
                Thread.sleep(ROOT_TIMEOUT_MS);
                proc.destroy();
            } catch (InterruptedException e) {
                // finished in time
            }
        }, "SyuMediaFilesRoot");
        watchdog.setDaemon(true);
        watchdog.start();
        try {
            byte[] all;
            try (InputStream in = p.getInputStream()) {
                all = readAll(in, MAX_BYTES + 32);
            }
            if (!p.waitFor(ROOT_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                p.destroy();
                return null;
            }
            if (p.exitValue() != 0 || all == null) {
                return null;
            }
            int nl = -1;
            for (int i = 0; i < all.length && i < 24; i++) {
                if (all[i] == '\n') {
                    nl = i;
                    break;
                }
            }
            if (nl <= 0) {
                return null;
            }
            long seconds = Long.parseLong(new String(all, 0, nl).trim());
            byte[] bytes = java.util.Arrays.copyOfRange(all, nl + 1, all.length);
            return bytes.length > MAX_BYTES ? null : new Data(bytes, seconds * 1000L, "root");
        } catch (NumberFormatException e) {
            return null;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            watchdog.interrupt();
            p.destroy();
        }
    }

    /** The VD host (protocol 3). */
    private static Data host(String path) throws IOException, android.os.RemoteException {
        if (!WindowHostVdClient.supportsOptionalCalls()) {
            return null;
        }
        ParcelFileDescriptor pfd = WindowHostVdClient.readFile(path);
        if (pfd == null) {
            return null;
        }
        try (ParcelFileDescriptor.AutoCloseInputStream in = new ParcelFileDescriptor.AutoCloseInputStream(pfd)) {
            long modified = 0L;
            try {
                modified = Os.fstat(pfd.getFileDescriptor()).st_mtime * 1000L;
            } catch (Exception e) {
                // the way cannot tell: 0
            }
            byte[] bytes = readAll(in);
            return bytes == null ? null : new Data(bytes, modified, WindowHostVdClient.hostSourceName());
        }
    }

    private static byte[] readAll(InputStream in) throws IOException {
        return readAll(in, MAX_BYTES);
    }

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

    private static void logOnce(String family, String via, boolean ok) {
        if (sLogged.add(family + "|" + via + "|" + ok)) {
            Log.i(TAG, family + " via " + via + " -> " + (ok ? "ok" : "fail") + " (uid " + Process.myUid() + ")");
        }
    }
}
