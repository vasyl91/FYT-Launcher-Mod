package com.android.launcher66;

import android.os.Handler;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class Alarm implements Runnable {
    private OnAlarmListener mAlarmListener;
    private long mAlarmTriggerTime;
    private boolean mWaitingForCallback;
    private boolean mAlarmPending = false;
    private Handler mHandler = new Handler();

    public void setOnAlarmListener(OnAlarmListener alarmListener) {
        this.mAlarmListener = alarmListener;
    }

    public void setAlarm(long millisecondsInFuture) {
        long currentTime = System.currentTimeMillis();
        this.mAlarmPending = true;
        this.mAlarmTriggerTime = currentTime + millisecondsInFuture;
        if (!this.mWaitingForCallback) {
            this.mHandler.postDelayed(this, this.mAlarmTriggerTime - currentTime);
            this.mWaitingForCallback = true;
        }
    }

    public void cancelAlarm() {
        this.mAlarmTriggerTime = 0L;
        this.mAlarmPending = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWaitingForCallback = false;
        if (this.mAlarmTriggerTime != 0) {
            long currentTime = System.currentTimeMillis();
            if (this.mAlarmTriggerTime > currentTime) {
                this.mHandler.postDelayed(this, Math.max(0L, this.mAlarmTriggerTime - currentTime));
                this.mWaitingForCallback = true;
            } else {
                this.mAlarmPending = false;
                if (this.mAlarmListener != null) {
                    this.mAlarmListener.onAlarm(this);
                }
            }
        }
    }

    public boolean alarmPending() {
        return this.mAlarmPending;
    }
}
