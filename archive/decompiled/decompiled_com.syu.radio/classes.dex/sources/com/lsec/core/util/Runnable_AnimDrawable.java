package com.lsec.core.util;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Runnable_AnimDrawable implements Runnable {
    private AnimationDrawable animationDrawable;
    private int delay;
    private int iCntFrame;
    private View v;
    public boolean bRunning = true;
    private int index = 0;

    public void stopRun() {
        this.bRunning = false;
    }

    public Runnable_AnimDrawable(View v, AnimationDrawable animationDrawable, int delay) {
        this.delay = 80;
        this.iCntFrame = 0;
        this.v = v;
        this.animationDrawable = animationDrawable;
        this.delay = delay;
        if (animationDrawable != null) {
            this.iCntFrame = animationDrawable.getNumberOfFrames();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bRunning && this.v != null && this.iCntFrame > 0) {
            this.v.setBackground(this.animationDrawable.getFrame(this.index));
            if (this.index < this.iCntFrame - 1) {
                this.index++;
            } else {
                this.index = 0;
            }
            HandlerUI.getInstance().removeCallbacks(this);
            HandlerUI.getInstance().postDelayed(this, this.delay);
        }
    }
}
