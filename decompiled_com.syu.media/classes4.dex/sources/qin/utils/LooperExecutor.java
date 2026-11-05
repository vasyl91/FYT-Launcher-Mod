package qin.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class LooperExecutor extends AbstractExecutorService {
    public final Handler a;

    public LooperExecutor(Looper looper) {
        this.a = null;
        this.a = new Handler(looper);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.a.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.a.post(runnable);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    public void removeTask(Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return null;
    }

    public LooperExecutor(String str) {
        this.a = null;
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
    }

    public void execute(Runnable runnable, int i) {
        if (i <= 0) {
            execute(runnable);
        } else {
            this.a.postDelayed(runnable, i);
        }
    }
}
