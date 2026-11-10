package com.syu.utils;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TimeOutExecutor extends ThreadPoolExecutor {
    public final int a;
    public final TimeUnit b;
    public final ExecutorService c;
    public final ConcurrentHashMap d;

    public class TimeOutCancelTask implements Runnable {
        public final Future a;
        public final AtomicBoolean b = new AtomicBoolean(false);

        public TimeOutCancelTask(Future future) {
            this.a = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.get() || this.a.isDone()) {
                return;
            }
            try {
                Future future = this.a;
                TimeOutExecutor timeOutExecutor = TimeOutExecutor.this;
                future.get(timeOutExecutor.a, timeOutExecutor.b);
            } catch (Exception unused) {
                this.a.cancel(true);
            }
        }

        public void setCanceled(boolean z) {
            this.b.set(z);
        }
    }

    public class TimeoutTread implements Runnable {
        public final Thread a;

        public TimeoutTread(TimeOutExecutor timeOutExecutor, Thread thread) {
            this.a = thread;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.interrupt();
        }
    }

    public TimeOutExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i3, TimeUnit timeUnit2) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.c = Executors.newFixedThreadPool(1);
        this.d = new ConcurrentHashMap();
        this.a = i3;
        this.b = timeUnit2;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        TimeOutCancelTask timeOutCancelTask = (TimeOutCancelTask) this.d.remove(runnable);
        if (timeOutCancelTask != null) {
            timeOutCancelTask.setCanceled(true);
        }
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof FutureTask) {
            TimeOutCancelTask timeOutCancelTask = new TimeOutCancelTask((Future) runnable);
            this.d.put(runnable, timeOutCancelTask);
            this.c.execute(timeOutCancelTask);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        this.c.shutdown();
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        this.c.shutdownNow();
        return super.shutdownNow();
    }

    public TimeOutExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler, int i3, TimeUnit timeUnit2) {
        super(i, i2, j, timeUnit, blockingQueue, rejectedExecutionHandler);
        this.c = Executors.newFixedThreadPool(1);
        this.d = new ConcurrentHashMap();
        this.a = i3;
        this.b = timeUnit2;
    }

    public TimeOutExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, int i3, TimeUnit timeUnit2) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.c = Executors.newFixedThreadPool(1);
        this.d = new ConcurrentHashMap();
        this.a = i3;
        this.b = timeUnit2;
    }

    public TimeOutExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, int i3, TimeUnit timeUnit2) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.c = Executors.newFixedThreadPool(1);
        this.d = new ConcurrentHashMap();
        this.a = i3;
        this.b = timeUnit2;
    }
}
