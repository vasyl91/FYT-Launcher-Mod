package com.syu.util;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class SecondTickThread extends Thread {
    private static final SecondTickThread INSTANCE = new SecondTickThread();
    private ArrayList<Runnable> ticks = new ArrayList<>();

    public static SecondTickThread getInstance() {
        return INSTANCE;
    }

    private SecondTickThread() {
        setName("SecondTickThread");
        start();
    }

    public synchronized void addTick(Runnable tick) {
        if (tick != null) {
            if (!this.ticks.contains(tick)) {
                this.ticks.add(tick);
            }
        }
    }

    public synchronized void removeTick(Runnable tick) {
        if (tick != null) {
            this.ticks.remove(tick);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            long startMllis = SystemClock.uptimeMillis();
            synchronized (this) {
                Iterator<Runnable> it = this.ticks.iterator();
                while (it.hasNext()) {
                    Runnable tick = it.next();
                    HandlerNotRemove.getInstance().post(tick);
                }
            }
            long useMllis = SystemClock.uptimeMillis() - startMllis;
            if (useMllis < 1000) {
                try {
                    Thread.sleep(1000 - useMllis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
