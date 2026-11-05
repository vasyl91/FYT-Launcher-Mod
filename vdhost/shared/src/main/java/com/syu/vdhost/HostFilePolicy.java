package com.syu.vdhost;

import java.util.Locale;

/**
 * Which files the host reads for the launcher (VdHostProtocol.Proxy.readFile), free of android.* so
 * that it can be tested on the JVM. The host runs as the system, root or shell: it must hand out
 * nothing but the few files the launcher needs and cannot open itself.
 *
 * <ul>
 *   <li>images in /data/blink/: the cover of the song a phone plays over Bluetooth, which com.syu.media
 *       gets as a path from com.syu.ms (code 51 of module 2); /data/blink/ is the Bluetooth app's;</li>
 *   <li>.png logos in /storage/emulated/0/radio_logo/ (one folder of a city below it is allowed): the
 *       station logos of the stock radio;</li>
 *   <li>the icon pack of the online radio, /odm/app/cabinet.data (an APK).</li>
 * </ul>
 *
 * A file is read only if the path is canonical (the caller passes File.getCanonicalPath() of the path
 * it was given: a link, "..", or a path that is not absolute is a different path from its canonical
 * one), it is a regular file and it is at most {@link #maxBytes(String)} long: 2 MB, and 64 MB for
 * the icon pack, which is an APK of its own.
 */
public final class HostFilePolicy {

    /** The longest file the host hands out, the icon pack apart. */
    public static final long MAX_BYTES = 2L * 1024 * 1024;

    /**
     * The longest icon pack. It is an APK with the drawables of the online radio's stations and
     * can be well over 2 MB; the caller copies it in a stream, so it is not held in memory.
     */
    public static final long ICON_PACK_MAX_BYTES = 64L * 1024 * 1024;

    public static final String BLINK_DIR = "/data/blink/";
    public static final String RADIO_LOGO_DIR = "/storage/emulated/0/radio_logo/";
    public static final String ICON_PACK = "/odm/app/cabinet.data";

    private HostFilePolicy() {
    }

    /**
     * @param requested the path the caller asked for
     * @param canonical its canonical path (links resolved), null when that could not be had
     * @param isRegularFile whether canonical is a regular file
     * @param length its size in bytes
     */
    public static boolean allowed(String requested, String canonical, boolean isRegularFile, long length) {
        if (requested == null || canonical == null || !requested.equals(canonical)) {
            return false;
        }
        return isRegularFile && length >= 0 && length <= maxBytes(canonical) && pathAllowed(canonical);
    }

    /**
     * The decision after the file is open: the host opens the path with O_NOFOLLOW and looks at
     * the descriptor it holds (fstat and the link of /proc/self/fd/N), not at the path, which
     * another app with access to the storage can change between a check and the open. A link,
     * a directory, a file over the limit and a descriptor that is another path than the one
     * asked for are all refused.
     *
     * @param requested the path the caller asked for
     * @param openedPath where the open descriptor leads (readlink of /proc/self/fd/N), null when unknown
     * @param isRegularFile fstat(): whether the descriptor is a regular file
     * @param length fstat(): its size in bytes
     */
    public static boolean allowedOpened(String requested, String openedPath, boolean isRegularFile, long length) {
        if (requested == null || openedPath == null) {
            return false;
        }
        // The path itself must be one of the allowed ones; what the descriptor leads to may be
        // the same file under another name of the shared storage.
        if (!requested.equals(openedPath) && !sameSharedStorageFile(requested, openedPath)) {
            return false;
        }
        return isRegularFile && length >= 0 && length <= maxBytes(requested) && pathAllowed(requested);
    }

    private static final String SHARED_STORAGE = "/storage/emulated/";

    /**
     * Whether {@code opened} is {@code requested} under another name of the shared storage. The
     * host (a Magisk daemon) may live in another mount namespace than the apps, and then a file
     * asked for as /storage/emulated/&lt;u&gt;/x resolves, in /proc/self/fd, to the backing path of the
     * same storage: /data/media/&lt;u&gt;/x, /mnt/user/&lt;u&gt;/emulated/&lt;u&gt;/x,
     * /mnt/pass_through/&lt;u&gt;/emulated/&lt;u&gt;/x, or /storage/self/primary/x. The rest of the path must be
     * identical; any other target is no alias.
     */
    public static boolean sameSharedStorageFile(String requested, String opened) {
        if (requested == null || opened == null || !requested.startsWith(SHARED_STORAGE)) {
            return false;
        }
        int userEnd = requested.indexOf('/', SHARED_STORAGE.length());
        if (userEnd < 0) {
            return false;
        }
        String user = requested.substring(SHARED_STORAGE.length(), userEnd);
        if (!isDigits(user)) {
            return false;
        }
        String rest = requested.substring(userEnd);   // starts with '/'
        if (rest.length() < 2) {
            return false;
        }
        if (opened.equals(requested)) {
            return true;
        }
        return opened.equals("/data/media/" + user + rest)
                || opened.equals("/mnt/user/" + user + "/emulated/" + user + rest)
                || opened.equals("/mnt/pass_through/" + user + "/emulated/" + user + rest)
                || opened.equals("/storage/self/primary" + rest);
    }

    private static boolean isDigits(String text) {
        if (text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) < '0' || text.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    /** The longest file the host hands out for this path. */
    public static long maxBytes(String path) {
        return ICON_PACK.equals(path) ? ICON_PACK_MAX_BYTES : MAX_BYTES;
    }

    /** The path alone, for a canonical one. */
    public static boolean pathAllowed(String path) {
        if (path == null || path.indexOf('\0') >= 0 || path.contains("/../") || path.endsWith("/..")) {
            return false;
        }
        if (path.equals(ICON_PACK)) {
            return true;
        }
        if (path.startsWith(BLINK_DIR)) {
            String name = path.substring(BLINK_DIR.length());
            return isPlainName(name) && hasExtension(name, IMAGE_EXTENSIONS);
        }
        if (path.startsWith(RADIO_LOGO_DIR)) {
            String rest = path.substring(RADIO_LOGO_DIR.length());
            int slash = rest.indexOf('/');
            String name = slash < 0 ? rest : rest.substring(slash + 1);
            // at most one folder (the city) between radio_logo and the file
            boolean oneLevel = slash < 0 || (isPlainName(rest.substring(0, slash)) && name.indexOf('/') < 0);
            return oneLevel && isPlainName(name) && name.endsWith(".png");
        }
        return false;
    }

    private static final String[] IMAGE_EXTENSIONS = {".jpg", ".jpeg", ".png", ".webp", ".bmp", ".gif"};

    private static boolean isPlainName(String name) {
        return !name.isEmpty() && name.indexOf('/') < 0 && !name.equals(".") && !name.equals("..");
    }

    private static boolean hasExtension(String name, String[] extensions) {
        String lower = name.toLowerCase(Locale.ROOT);
        for (String e : extensions) {
            if (lower.endsWith(e)) {
                return true;
            }
        }
        return false;
    }
}
