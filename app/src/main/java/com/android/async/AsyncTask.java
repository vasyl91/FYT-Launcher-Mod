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

                // FutureTask.cancel(true) only stops a task that has not started yet;
                // a running doInBackground() blocked on I/O ignores the interrupt.
                // Without this check onPostExecute() ran despite cancel(), and the
                // callback held its (already destroyed) Fragment until the request ended.
                if (cancelled.get()) {
                    mStatus = Status.FINISHED;
                    dispatchCancelled();
                    return output;
                }

                AsyncWorker.getInstance().getHandler().post(() -> {
                    if (!cancelled.get()) {
                        onPostExecute(output);
                    }
                    mStatus = Status.FINISHED;
                });
                return output;
            } catch (Exception e) {
                if (cancelled.get()) {
                    mStatus = Status.FINISHED;
                    dispatchCancelled();
                    throw e;
                }
                AsyncWorker.getInstance().getHandler().post(() -> {
                    if (!cancelled.get()) {
                        onBackgroundError(e);
                    }
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
        if (cancelled.get()) {
            return;
        }
        AsyncWorker.getInstance().getHandler().post(() -> {
            if (cancelled.get()) {
                return;
            }
            onProgress(progress);
            OnProgressListener<PROGRESS> listener = onProgressListener;
            if (listener != null) {
                listener.onProgress(progress);
            }
        });
    }

    protected abstract  void onProgress(final PROGRESS[] progress);

    public void cancel() {
        cancel(true);
    }

    public void cancel(boolean mayInterruptIfRunning) {
        // cancel(boolean) used to do cancelled.set(bool), so cancel(false) *cleared* the
        // flag instead of setting it. Cancelling always sets true; the argument only
        // controls whether the worker thread is interrupted.
        boolean wasCancelled = cancelled.getAndSet(true);
        FutureTask<OUTPUT> task = futureTask;
        if (task != null) {
            // Guards against an NPE when cancel() beats executeOnExecutor().
            task.cancel(mayInterruptIfRunning);
        }
        if (!wasCancelled) {
            dispatchCancelled();
        }
        // Listeners can hold an Activity/Fragment and are useless once cancelled, while
        // the task itself may stay blocked on I/O for a long time yet.
        onProgressListener = null;
    }

    public boolean isCancelled() {
        return cancelled.get();
    }

    private void dispatchCancelled() {
        AsyncWorker.getInstance().getHandler().post(() -> {
            OnCancelledListener listener = onCancelledListener;
            onCancelledListener = null;
            if (listener != null) {
                listener.onCancelled();
            }
        });
    }

    protected void onCancelled() {
        dispatchCancelled();
    }

    protected void onPreExecute() {}

    protected abstract OUTPUT doInBackground(INPUT[] input) throws Exception;

    protected void onPostExecute(OUTPUT output) {}

    protected abstract void onBackgroundError(Exception e);

    // Updated listener interface
    private volatile OnProgressListener<PROGRESS> onProgressListener;
    public interface OnProgressListener<PROGRESS> {
        void onProgress(PROGRESS[] progress);
    }

    public void setOnProgressListener(OnProgressListener<PROGRESS> onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    private volatile OnCancelledListener onCancelledListener;
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
