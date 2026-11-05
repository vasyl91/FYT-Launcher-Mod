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
 * one), it is a regular file and it is at most {@link #MAX_BYTES} long.
 */
public final class HostFilePolicy {

    /** The longest file the host hands out. */
    public static final long MAX_BYTES = 2L * 1024 * 1024;

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
        return isRegularFile && length >= 0 && length <= MAX_BYTES && pathAllowed(canonical);
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
