package com.syu.carinfo.widget;

import android.os.SystemClock;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ProgressInt {
    private int mCurVal;
    private long mLastMillis;
    private boolean mNeedInvalid;
    private int mTargetVal;

    public boolean needInvalid() {
        return this.mNeedInvalid;
    }

    public void setCurVal(int curVal) {
        this.mCurVal = curVal;
    }

    public int getCurVal() {
        return this.mCurVal;
    }

    public boolean setTargetVal(int targetVal) {
        this.mTargetVal = targetVal;
        return this.mCurVal != this.mTargetVal;
    }

    public int getTargetVal() {
        return this.mTargetVal;
    }

    public boolean calcCurVal(int maxProgress, int maxMillis, int targetVal) {
        this.mTargetVal = targetVal;
        return calcCurVal(maxProgress, maxMillis);
    }

    public boolean calcCurVal(int maxProgress, int maxMillis) {
        if (this.mCurVal == this.mTargetVal) {
            this.mNeedInvalid = false;
        } else {
            long curMillis = SystemClock.uptimeMillis();
            if (!this.mNeedInvalid) {
                this.mNeedInvalid = true;
                this.mLastMillis = curMillis - 33;
            }
            int pass = (int) (curMillis - this.mLastMillis);
            this.mLastMillis = curMillis;
            int distance = ((pass * maxProgress) + (maxMillis >> 1)) / maxMillis;
            if (Math.abs(this.mCurVal - this.mTargetVal) < distance) {
                this.mCurVal = this.mTargetVal;
                this.mNeedInvalid = false;
            } else if (this.mCurVal > this.mTargetVal) {
                this.mCurVal -= distance;
            } else {
                this.mCurVal += distance;
            }
        }
        return this.mNeedInvalid;
    }
}
