package org.apache.http.impl.conn.tsccm;

import java.util.Date;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class WaitingThread {
    public WaitingThread(Condition cond, RouteSpecificPool pool) {
        throw new RuntimeException("Stub!");
    }

    public final Condition getCondition() {
        throw new RuntimeException("Stub!");
    }

    public final RouteSpecificPool getPool() {
        throw new RuntimeException("Stub!");
    }

    public final Thread getThread() {
        throw new RuntimeException("Stub!");
    }

    public boolean await(Date deadline) throws InterruptedException {
        throw new RuntimeException("Stub!");
    }

    public void wakeup() {
        throw new RuntimeException("Stub!");
    }

    public void interrupt() {
        throw new RuntimeException("Stub!");
    }
}
