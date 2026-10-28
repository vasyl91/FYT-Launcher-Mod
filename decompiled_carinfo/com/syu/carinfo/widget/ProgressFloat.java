package com.syu.carinfo.widget;

import android.os.SystemClock;

@SuppressWarnings({"deprecation", "unchecked"})
public class ProgressFloat {
    private float mCurVal;
    private long mLastMillis;
    private boolean mNeedInvalid;
    private float mTargetVal;

    public boolean needInvalid() {
        return this.mNeedInvalid;
    }

    public void setCurVal(float curVal) {
        this.mCurVal = curVal;
    }

    public float getCurVal() {
        return this.mCurVal;
    }

    public boolean setTargetVal(float targetVal) {
        this.mTargetVal = targetVal;
        return this.mCurVal != this.mTargetVal;
    }

    public float getTargetVal() {
        return this.mTargetVal;
    }

    public boolean calcCurVal(float maxProgress, int maxMillis, float targetVal) {
        this.mTargetVal = targetVal;
        return calcCurVal(maxProgress, maxMillis);
    }

    public boolean calcCurVal(float maxProgress, int maxMillis) {
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
            float distance = (pass * maxProgress) / maxMillis;
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
