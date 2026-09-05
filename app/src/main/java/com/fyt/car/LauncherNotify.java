package com.fyt.car;

import android.util.Log;

public class LauncherNotify {

    private static final String TAG = "LauncherNotify";

    public static final DataNotifier NOTIFIER_MUSIC = new DataNotifier();
    public static final DataNotifier NOTIFIER_VIDEO = new DataNotifier();
    public static final DataNotifier NOTIFY_MAINSTATE = new DataNotifier();
    public static final DataNotifier NOTIFY_RADIO_BAND = new DataNotifier();
    public static final DataNotifier NOTIFY_RADIO_FREQ = new DataNotifier();
    public static final DataNotifier NOTIFIER_BTAV = new DataNotifier();
    public static final DataNotifier NOTIFIER_DVR = new DataNotifier();
    public static final DataNotifier NOTIFIER_NAVIVIEW = new DataNotifier();
    public static final DataNotifier NOTIFIER_NAVISTATE = new DataNotifier();

    private static final DataNotifier[] ALL = {
            NOTIFIER_MUSIC,
            NOTIFIER_VIDEO,
            NOTIFY_MAINSTATE,
            NOTIFY_RADIO_BAND,
            NOTIFY_RADIO_FREQ,
            NOTIFIER_BTAV,
            NOTIFIER_DVR,
            NOTIFIER_NAVIVIEW,
            NOTIFIER_NAVISTATE,
    };

    /** Every notification channel, for iteration during cleanup. */
    public static DataNotifier[] all() {
        return ALL.clone();
    }

    /**
     * Removes the given owner's listeners from every channel. Call from onDestroy() as a
     * last line of defence: these fields are static, so any IUiRefresher left registered
     * keeps its this$0 alive for the lifetime of the process. In the heap dump that read
     * NOTIFIER_MUSIC -> DataNotifier.REFRESHERS -> Launcher$11 -> Launcher.
     *
     * @return total number of entries removed
     */
    public static int releaseAllFor(Object owner) {
        if (owner == null) {
            return 0;
        }
        int removed = 0;
        for (DataNotifier notifier : ALL) {
            try {
                removed += notifier.removeUiRefreshersOf(owner);
            } catch (Throwable t) {
                Log.w(TAG, "releaseAllFor failed for one channel", t);
            }
        }
        if (removed > 0) {
            Log.i(TAG, "releaseAllFor(" + owner.getClass().getSimpleName()
                    + "): swept " + removed + " stale refresher(s)");
        }
        return removed;
    }

    /** Diagnostics: total listener count across all channels. */
    public static int totalRefresherCount() {
        int total = 0;
        for (DataNotifier notifier : ALL) {
            total += notifier.getUiRefresherCount();
        }
        return total;
    }
}
