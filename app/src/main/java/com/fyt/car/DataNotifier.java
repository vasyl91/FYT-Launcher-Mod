package com.fyt.car;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataNotifier implements Runnable {

    private static final String TAG = "DataNotifier";

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    /**
     * Copy-on-write because run() calls onRefresh() while iterating, and a listener that
     * unregisters itself from its own callback would otherwise throw
     * ConcurrentModificationException and abort the loop for everyone after it.
     *
     * This list is reachable from the static LauncherNotify fields, so every entry lives
     * as long as the process. Whatever goes in here must be taken out in the owner's
     * onDestroy() - see removeUiRefreshersOf() / LauncherNotify.releaseAllFor().
     */
    private final CopyOnWriteArrayList<IUiRefresher> REFRESHERS = new CopyOnWriteArrayList<>();

    /** Guards the data fields only; never held across an onRefresh() callback. */
    private final Object mDataLock = new Object();

    private byte[] mByts;
    private float[] mFlts;
    private int[] mInts;
    private long[] mLngs;
    private String[] mStrs;
    private String mSource;

    public void set(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
        boolean changed;
        synchronized (this.mDataLock) {
            changed = !Arrays.equals(this.mInts, ints)
                    || !Arrays.equals(this.mFlts, flts)
                    || !Arrays.equals(this.mStrs, strs)
                    || !Arrays.equals(this.mByts, byts)
                    || !Arrays.equals(this.mLngs, lngs);

            this.mInts = ints;
            this.mFlts = flts;
            this.mStrs = strs;
            this.mByts = byts;
            this.mLngs = lngs;
            this.mSource = source;
        }

        if (changed) {
            // Collapse bursts (e.g. player progress ticks) into a single UI pass.
            HANDLER.removeCallbacks(this);
            HANDLER.post(this);
        }
    }

    public void addUiRefresher(IUiRefresher refresher, boolean refresh) {
        if (refresher == null) {
            return;
        }
        if (!this.REFRESHERS.addIfAbsent(refresher)) {
            return;
        }
        if (refresh) {
            dispatch(refresher);
        }
    }

    public void refrseh(IUiRefresher refresher) {
        if (refresher != null) {
            dispatch(refresher);
        }
    }

    public void removeUiRefresher(IUiRefresher refresher) {
        if (refresher != null) {
            this.REFRESHERS.remove(refresher);
        }
    }

    /** Bulk unregister, for use from onDestroy(). */
    public void removeUiRefreshers(IUiRefresher... refreshers) {
        if (refreshers == null) {
            return;
        }
        for (IUiRefresher refresher : refreshers) {
            removeUiRefresher(refresher);
        }
    }

    /**
     * Removes every listener owned by the given Activity/Fragment/Service, matching
     * anonymous and inner classes on the synthetic this$0 and lambdas on their captured
     * f$N / arg$N fields.
     *
     * Safety net, not a replacement for an explicit removeUiRefresher(): it only sweeps
     * up what the normal path missed, e.g. a registration made from a broadcast receiver
     * that was never followed by onPause().
     *
     * @return number of entries removed
     */
    public int removeUiRefreshersOf(Object owner) {
        if (owner == null || this.REFRESHERS.isEmpty()) {
            return 0;
        }
        int removed = 0;
        for (IUiRefresher refresher : this.REFRESHERS) {
            if (isOwnedBy(refresher, owner) && this.REFRESHERS.remove(refresher)) {
                removed++;
            }
        }
        return removed;
    }

    /** Clears every listener on this channel. */
    public void clearUiRefreshers() {
        this.REFRESHERS.clear();
    }

    /**
     * @deprecated misleading signature: the argument was ignored and every listener on
     * the channel was dropped, including other owners'. Use removeUiRefresher() for one,
     * or clearUiRefreshers() when clearing all of them is really what you want.
     */
    @Deprecated
    public void clearUiRefresher(IUiRefresher refresher) {
        clearUiRefreshers();
    }

    public int getUiRefresherCount() {
        return this.REFRESHERS.size();
    }

    @Override
    public void run() {
        if (this.REFRESHERS.isEmpty()) {
            return;
        }
        int[] ints;
        long[] lngs;
        float[] flts;
        String[] strs;
        byte[] byts;
        String source;
        synchronized (this.mDataLock) {
            ints = this.mInts;
            lngs = this.mLngs;
            flts = this.mFlts;
            strs = this.mStrs;
            byts = this.mByts;
            source = this.mSource;
        }
        for (IUiRefresher refresher : this.REFRESHERS) {
            try {
                refresher.onRefresh(ints, lngs, flts, strs, byts, source);
            } catch (Throwable t) {
                Log.w(TAG, "onRefresh failed for " + refresher.getClass().getName(), t);
            }
        }
    }

    private void dispatch(IUiRefresher refresher) {
        int[] ints;
        long[] lngs;
        float[] flts;
        String[] strs;
        byte[] byts;
        String source;
        synchronized (this.mDataLock) {
            ints = this.mInts;
            lngs = this.mLngs;
            flts = this.mFlts;
            strs = this.mStrs;
            byts = this.mByts;
            source = this.mSource;
        }
        try {
            refresher.onRefresh(ints, lngs, flts, strs, byts, source);
        } catch (Throwable t) {
            Log.w(TAG, "onRefresh failed for " + refresher.getClass().getName(), t);
        }
    }

    private static boolean isOwnedBy(Object refresher, Object owner) {
        if (refresher == owner) {
            return true;
        }
        Class<?> c = refresher.getClass();
        while (c != null && c != Object.class) {
            Field[] fields;
            try {
                fields = c.getDeclaredFields();
            } catch (Throwable t) {
                return false;
            }
            for (Field f : fields) {
                if (!f.isSynthetic()) {
                    continue;
                }
                String name = f.getName();
                boolean capture = name.startsWith("this$")
                        || name.startsWith("f$")
                        || name.startsWith("arg$")
                        || name.startsWith("val$");
                if (!capture) {
                    continue;
                }
                try {
                    f.setAccessible(true);
                    if (f.get(refresher) == owner) {
                        return true;
                    }
                } catch (Throwable ignored) {
                }
            }
            c = c.getSuperclass();
        }
        return false;
    }
}
