package com.fyt.car;

import com.syu.vdhost.HostFilePolicy;

import java.util.ArrayList;
import java.util.List;

/**
 * The decisions of {@link SyuMediaFiles}, free of android.* so that they can be tested on the JVM.
 *
 * <p>What a way found for a file is one of three things. {@link Outcome#OK}: the bytes came.
 * {@link Outcome#MISSING}: the file is not there, which is an answer, not a refusal, so the other
 * ways (a {@code su}, a call to the host) would only find the same and are not asked. The cover of
 * a song a phone plays over Bluetooth is written about a second after the track changes, so
 * "missing" is the normal state at the first look. {@link Outcome#DENIED}: the way could not
 * read it (no permission, a failure): the next way may. {@link Outcome#TOO_LARGE}: the file is
 * there but over the limit of its family, which every way would refuse for the same reason (the
 * host has the same limit), so it ends the round like a missing file does.
 */
final class SyuMediaReadPolicy {

    enum Outcome { OK, MISSING, DENIED, TOO_LARGE }

    /**
     * Whether an outcome is an answer for the file, so that the other ways are not asked. A way
     * that merely could not read it (DENIED) leaves the next one to try.
     */
    static boolean endsRound(Outcome outcome) {
        return outcome == Outcome.MISSING || outcome == Outcome.TOO_LARGE;
    }

    /** The ways, in the order they are tried when nothing is remembered. */
    static final String[] WAYS = {"direct", "root", "host"};

    private static final int EPERM = 1;
    private static final int ENOENT = 2;
    private static final int EACCES = 13;
    private static final int ENOTDIR = 20;

    private SyuMediaReadPolicy() {
    }

    /**
     * What an errno of stat() or open() says about a file. Linux numbers, the same on every
     * Android: ENOENT and ENOTDIR (a part of the path is a file) mean it is not there; EACCES and
     * EPERM, and any other errno, mean this way cannot tell.
     */
    static Outcome fromErrno(int errno) {
        if (errno == ENOENT || errno == ENOTDIR) {
            return Outcome.MISSING;
        }
        return Outcome.DENIED;
    }

    /**
     * The ways to try now: the one that worked for the family first, then the others. A way is
     * never in the list twice, so one that is remembered and fails is not asked again in the same
     * round (a {@code su} that is not granted cost 3 s each time).
     */
    static List<String> order(String remembered) {
        List<String> ways = new ArrayList<>();
        if (remembered != null) {
            ways.add(remembered);
        }
        for (String way : WAYS) {
            if (!ways.contains(way)) {
                ways.add(way);
            }
        }
        return ways;
    }

    /** The way a name in the log stands for: direct, system, root, or the host's (shizuku, daemon). */
    static String wayOf(String via) {
        if ("direct".equals(via) || "system".equals(via)) {
            return "direct";
        }
        if ("root".equals(via)) {
            return "root";
        }
        return "host";
    }

    /**
     * Whether a path is not tried again for a while. Only when every way was asked and none read
     * the file: a path some way found missing is asked again at the next look (it may be written
     * by then), and the cover of a Bluetooth song is never held off, because it is looked for
     * again at 1.5, 3 and 6 s after the track changed.
     */
    static boolean holdOff(String family, List<Outcome> outcomes) {
        if (SyuMediaFiles.FAMILY_BT_COVER.equals(family) || outcomes.isEmpty()) {
            return false;
        }
        for (Outcome o : outcomes) {
            if (o != Outcome.DENIED) {
                return false;
            }
        }
        return true;
    }

    /** The longest file of the family: 64 MB for the icon pack, 2 MB for the pictures. */
    static long maxBytes(String family) {
        return SyuMediaFiles.FAMILY_ICON_PACK.equals(family)
                ? HostFilePolicy.ICON_PACK_MAX_BYTES : HostFilePolicy.MAX_BYTES;
    }
}
