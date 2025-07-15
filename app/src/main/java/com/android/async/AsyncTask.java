package com.android.async;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<INPUT, PROGRESS, OUTPUT> {
    private final AtomicBoolean cancelled = new AtomicBoolean();
    private Future<OUTPUT> outputFuture;
    private volatile Status mStatus = Status.PENDING;
    private FutureTask<OUTPUT> futureTask;

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static final Executor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(20, 128, 1,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    protected AsyncTask() {}

    @SafeVarargs
    public final AsyncTask<INPUT, PROGRESS, OUTPUT> execute(INPUT... input) {
        return executeOnExecutor(AsyncWorker.getInstance().getExecutorService(), input);
    }

    @SafeVarargs
    public final AsyncTask<INPUT, PROGRESS, OUTPUT> executeOnExecutor(Executor executor, INPUT... params) {
        if (mStatus != Status.PENDING) {
            switch (mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Task has already been executed.");
                default:
                    throw new IllegalStateException("Task is in an unknown state.");
            }
        }
        mStatus = Status.RUNNING;
        onPreExecute();

        futureTask = new FutureTask<>(() -> {
            try {
                OUTPUT output = doInBackground(params);
                AsyncWorker.getInstance().getHandler().post(() -> {
                    onPostExecute(output);
                    mStatus = Status.FINISHED;
                });
                return output;
            } catch (Exception e) {
                AsyncWorker.getInstance().getHandler().post(() -> {
                    onBackgroundError(e);
                    mStatus = Status.FINISHED;
                });
                throw e;
            }
        });

        executor.execute(futureTask);
        outputFuture = futureTask;

        return this;
    }

    public OUTPUT get() throws Exception {
        if (outputFuture == null) {
            throw new TaskNotExecutedException();
        } else {
            return outputFuture.get();
        }
    }

    public OUTPUT get(long timeout, TimeUnit timeUnit) throws Exception {
        if (outputFuture == null) {
            throw new TaskNotExecutedException();
        } else {
            return outputFuture.get(timeout, timeUnit);
        }
    }

    @SafeVarargs
    public final void publishProgress(final PROGRESS... progress) {
        AsyncWorker.getInstance().getHandler().post(() -> {
            onProgress(progress);
            if (onProgressListener != null) {
                onProgressListener.onProgress(progress);
            }
        });
    }

    protected abstract  void onProgress(final PROGRESS[] progress);

    public void cancel() {
        cancelled.set(true);
        futureTask.cancel(true);
    }

    public void cancel(boolean bool) {
        cancelled.set(bool);
        futureTask.cancel(bool);
    }

    public boolean isCancelled() {
        return cancelled.get();
    }

    protected void onCancelled() {
        AsyncWorker.getInstance().getHandler().post(() -> {
            if (onCancelledListener != null) {
                onCancelledListener.onCancelled();
            }
        });
    }

    protected void onPreExecute() {}

    protected abstract OUTPUT doInBackground(INPUT[] input) throws Exception;

    protected void onPostExecute(OUTPUT output) {}

    protected abstract void onBackgroundError(Exception e);

    // Updated listener interface
    private OnProgressListener<PROGRESS> onProgressListener;
    public interface OnProgressListener<PROGRESS> {
        void onProgress(PROGRESS[] progress);
    }

    public void setOnProgressListener(OnProgressListener<PROGRESS> onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    private OnCancelledListener onCancelledListener;
    public interface OnCancelledListener {
        void onCancelled();
    }

    public void setOnCancelledListener(OnCancelledListener onCancelledListener) {
        this.onCancelledListener = onCancelledListener;
    }

    public Status getStatus() {
        return mStatus;
    }
}