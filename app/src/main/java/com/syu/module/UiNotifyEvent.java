package com.syu.module;

import android.os.Handler;
import android.os.Looper;

import com.android.launcher66.settings.FytCompat;

import java.util.ArrayList;
import java.util.List;

public final class UiNotifyEvent implements Runnable {
    /** The area of a failing listener in the compat reports; the code is appended only when one fails. */
    private static final String NOTIFY_AREA = "canbus.notify ";
    public static final Handler HANDLER_UI = new Handler(Looper.getMainLooper());
    private final ArrayList<IUiNotify> mUiNotifies = new ArrayList<>();
    private int mUpdateCode;

    public UiNotifyEvent() {
    }

    public UiNotifyEvent(int updateCode) {
        this.mUpdateCode = updateCode;
    }

    public int getUpdateCode() {
        return this.mUpdateCode;
    }

    public void setUpdateCode(int updateCode) {
        this.mUpdateCode = updateCode;
    }

    public synchronized int size() {
        return this.mUiNotifies.size();
    }

    public synchronized void addNotify(IUiNotify notify) {
        if (notify != null) {
            if (!this.mUiNotifies.contains(notify)) {
                this.mUiNotifies.add(notify);
            }
        }
    }

    public void addNotify(IUiNotify notify, int onNotify) {
        if (notify != null) {
            synchronized (this) {
                if (!this.mUiNotifies.contains(notify)) {
                    this.mUiNotifies.add(notify);
                }
            }
            if (onNotify == 1) {
                final int code = this.mUpdateCode;
                FytCompat.run(NOTIFY_AREA, code, () -> notify.onNotify(code, null, null, null));
            }
        }
    }

    /** A copy of the listeners, so that they are called outside the lock and may remove themselves. */
    private synchronized List<IUiNotify> snapshot() {
        return new ArrayList<>(this.mUiNotifies);
    }

    /** Calls every listener; one that fails is reported and the rest still get the event. */
    private void dispatch(int[] ints, float[] flts, String[] strs) {
        final int code = this.mUpdateCode;
        for (IUiNotify notify : snapshot()) {
            try {
                notify.onNotify(code, ints, flts, strs);
            } catch (RuntimeException | LinkageError e) {
                // The name of the area is built here, not before every call: this runs for every
                // listener of every event.
                FytCompat.report(NOTIFY_AREA + code, e);
            }
        }
    }

    public synchronized void removeNotify(IUiNotify notify) {
        if (notify != null) {
            this.mUiNotifies.remove(notify);
        }
    }

    public synchronized void clearNotifies() {
        this.mUiNotifies.clear();
    }

    public synchronized void onNotify() {
        if (this.mUiNotifies.size() > 0) {
            HANDLER_UI.post(this);
        }
    }

    public synchronized void onNotify(int[] ints, float[] flts, String[] strs) {
        if (this.mUiNotifies.size() > 0) {
            HANDLER_UI.post(new NofityData(ints, flts, strs));
        }
    }

    private class NofityData implements Runnable {
        public float[] flts;
        public int[] ints;
        public String[] strs;

        public NofityData(int[] ints, float[] flts, String[] strs) {
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        @Override
        public void run() {
            UiNotifyEvent.this.dispatch(this.ints, this.flts, this.strs);
        }
    }

    @Override
    public void run() {
        dispatch(null, null, null);
    }
}
