package com.fyt.car;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DataNotifier implements Runnable {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private final ArrayList<IUiRefresher> REFRESHERS = new ArrayList<>();
    private byte[] mByts;
    private float[] mFlts;
    private int[] mInts;
    private long[] mLngs;
    private String[] mStrs;
    private String mSource;

    public synchronized void set(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
        boolean equal = true;
        if (1 != 0) {
            if (!Arrays.equals(this.mInts, ints)) {
                equal = false;
            }
        }
        if (equal && !Arrays.equals(this.mFlts, flts)) {
            equal = false;
        }
        if (equal && !Arrays.equals(this.mStrs, strs)) {
            equal = false;
        }
        if (equal && !Arrays.equals(this.mByts, byts)) {
            equal = false;
        }
        if (equal && !Arrays.equals(this.mLngs, lngs)) {
            equal = false;
        }
        this.mInts = ints;
        this.mFlts = flts;
        this.mStrs = strs;
        this.mByts = byts;
        this.mLngs = lngs;
        this.mSource = source;
        if (!equal) {
            HANDLER.post(this);
        }
    }

    public synchronized void addUiRefresher(IUiRefresher refresher, boolean refresh) {
        if (refresher != null) {
            if (!this.REFRESHERS.contains(refresher)) {
                this.REFRESHERS.add(refresher);
                if (refresh) {
                    refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts, this.mSource);
                }
            }
        }
    }

    public synchronized void refrseh(IUiRefresher refresher) {
        if (refresher != null) {
            refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts, this.mSource);
        }
    }

    public synchronized void removeUiRefresher(IUiRefresher refresher) {
        if (refresher != null) {
            this.REFRESHERS.remove(refresher);
        }
    }

    public synchronized void clearUiRefresher(IUiRefresher refresher) {
        this.REFRESHERS.clear();
    }

    @Override
    public synchronized void run() {
        Iterator<IUiRefresher> it = this.REFRESHERS.iterator();
        while (it.hasNext()) {
            IUiRefresher refresher = it.next();
            refresher.onRefresh(this.mInts, this.mLngs, this.mFlts, this.mStrs, this.mByts, this.mSource);
        }
    }
}
