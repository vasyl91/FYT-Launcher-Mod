package com.android.async;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncWorker {
    private static final AsyncWorker instance = new AsyncWorker();
    private static final int NUMBER_OF_THREADS = 4;

    private ExecutorService executorService;
    protected Handler handler;

    private AsyncWorker() {
        executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        handler = new Handler(Looper.getMainLooper());
    }

    public static AsyncWorker getInstance() {
        return instance;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public Handler getHandler() {
        return handler;
    }
}
