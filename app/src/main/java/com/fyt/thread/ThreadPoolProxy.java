package com.fyt.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolProxy {
    private int mCorePoolSize;
    private ThreadPoolExecutor mExecutor;
    private long mKeepAliveTime;
    private int mMaximumPoolSize;

    public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        this.mCorePoolSize = corePoolSize;
        this.mMaximumPoolSize = maximumPoolSize;
        this.mKeepAliveTime = keepAliveTime;
    }

    public void execute(Runnable task) {
        initThreadPoolExecutor();
        this.mExecutor.execute(task);
    }

    public Future<?> submit(Runnable task) {
        initThreadPoolExecutor();
        return this.mExecutor.submit(task);
    }

    private synchronized void initThreadPoolExecutor() {
        if (this.mExecutor == null || this.mExecutor.isShutdown() || this.mExecutor.isTerminated()) {
            TimeUnit unit = TimeUnit.MILLISECONDS;
            BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
            ThreadFactory threadFactory = Executors.defaultThreadFactory();
            RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
            this.mExecutor = new ThreadPoolExecutor(this.mCorePoolSize, this.mMaximumPoolSize, this.mKeepAliveTime, unit, workQueue, threadFactory, handler);
        }
    }

    public void remove(Runnable task) {
        if (this.mExecutor != null) {
            this.mExecutor.remove(task);
        }
    }
}
