package com.syu.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r10 = this;
            r8 = 1000(0x3e8, double:4.94E-321)
        L2:
            long r1 = android.os.SystemClock.uptimeMillis()
            monitor-enter(r10)
            java.util.ArrayList<java.lang.Runnable> r6 = r10.ticks     // Catch: java.lang.Throwable -> L37
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L37
        Ld:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L37
            if (r7 != 0) goto L29
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L37
            long r6 = android.os.SystemClock.uptimeMillis()
            long r4 = r6 - r1
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 >= 0) goto L2
            long r6 = r8 - r4
            java.lang.Thread.sleep(r6)     // Catch: java.lang.InterruptedException -> L24
            goto L2
        L24:
            r0 = move-exception
            r0.printStackTrace()
            goto L2
        L29:
            java.lang.Object r3 = r6.next()     // Catch: java.lang.Throwable -> L37
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L37
            com.syu.util.HandlerNotRemove r7 = com.syu.util.HandlerNotRemove.getInstance()     // Catch: java.lang.Throwable -> L37
            r7.post(r3)     // Catch: java.lang.Throwable -> L37
            goto Ld
        L37:
            r6 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L37
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.util.SecondTickThread.run():void");
    }
}
