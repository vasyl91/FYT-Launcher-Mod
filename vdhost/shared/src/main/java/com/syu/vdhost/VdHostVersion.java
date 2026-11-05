package com.syu.vdhost;

/**
 * Which host protocol versions the launcher works with, free of android.* so that it can be tested on
 * the JVM. A host older than the launcher but not older than {@link VdHostProtocol#MIN_VERSION} still
 * hosts the panes (everything up to the transactions of version 2); the calls added later are made
 * only when {@link #supportsOptionalCalls} says the host knows them, as a host that does not know a
 * call answers it with an empty reply -- no exception, just nothing.
 */
public final class VdHostVersion {

    /** The version that added readFile(), allowAppOp() and allowNotificationListener(). */
    public static final int OPTIONAL_CALLS_SINCE = 3;

    private VdHostVersion() {
    }

    /** Whether a host of this version is taken by a launcher that speaks {@code current}, down to {@code min}. */
    public static boolean accepts(int hostVersion, int min, int current) {
        return hostVersion >= min && hostVersion <= current;
    }

    public static boolean supportsOptionalCalls(int hostVersion) {
        return hostVersion >= OPTIONAL_CALLS_SINCE;
    }
}
