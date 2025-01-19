package com.android.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class AsyncTask<INPUT, PROGRESS, OUTPUT> {

    public enum Status {
        /**
         * Indicates that the task has not been executed yet.
         */
        PENDING,
        /**
         * Indicates that the task is running.
         */
        RUNNING,
        /**
         * Indicates that has finished.
         */
        FINISHED,
    }

    private volatile Status mStatus = Status.PENDING;

    private boolean cancelled = false;

    public static final Executor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(20, 128, 1,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public AsyncTask() {

    }

    /**
     * @see #execute(Object[])
     */
    public AsyncTask<INPUT, PROGRESS, OUTPUT> execute() {
        return execute((INPUT) null);
    }

    /**
     * Starts is all
     * @param input Data you want to work with in the background
     */
    public AsyncTask<INPUT, PROGRESS, OUTPUT> execute(final INPUT input) {
        onPreExecute();

        ExecutorService executorService = AsyncWorker.getInstance().getExecutorService();
        executorService.execute(() -> {
            try {
                final OUTPUT output = doInBackground(input);
                AsyncWorker.getInstance().getHandler().post(() -> onPostExecute(output));
            } catch (final Exception e) {
                e.printStackTrace();

                AsyncWorker.getInstance().getHandler().post(() -> onBackgroundError(e));
            }
        });

        return this;
    }

    /**
     * Starts is all
     * @param input Data you want to work with in the background
     */
    public AsyncTask<INPUT, PROGRESS, OUTPUT> execute(final INPUT[] input) {
        onPreExecute();

        ExecutorService executorService = AsyncWorker.getInstance().getExecutorService();
        executorService.execute(() -> {
            try {
                final OUTPUT output = doInBackground(input);
                AsyncWorker.getInstance().getHandler().post(() -> onPostExecute(output));
            } catch (final Exception e) {
                e.printStackTrace();

                AsyncWorker.getInstance().getHandler().post(() -> onBackgroundError(e));
            }
        });

        return this;
    }

    /**
     * Starts is all
     * @param input Data you want to work with in the background
     */
    public AsyncTask<INPUT, PROGRESS, OUTPUT> execute(Executor executor, final INPUT input) {
        onPreExecute();

        executor.execute(() -> {
            try {
                final OUTPUT output = doInBackground(input);
                AsyncWorker.getInstance().getHandler().post(() -> onPostExecute(output));
            } catch (final Exception e) {
                e.printStackTrace();

                AsyncWorker.getInstance().getHandler().post(() -> onBackgroundError(e));
            }
        });

        return this;
    }

    /**
     * Starts is all
     * @param input Data you want to work with in the background
     */
    public AsyncTask<INPUT, PROGRESS, OUTPUT> execute(Executor executor, final INPUT[] input) {
        onPreExecute();

        executor.execute(() -> {
            try {
                final OUTPUT output = doInBackground(input);
                AsyncWorker.getInstance().getHandler().post(() -> onPostExecute(output));
            } catch (final Exception e) {
                e.printStackTrace();

                AsyncWorker.getInstance().getHandler().post(() -> onBackgroundError(e));
            }
        });

        return this;
    }

    /**
     * Call to publish progress from background
     * @param progress  Progress made
     */
    protected void publishProgress(final PROGRESS progress) {
        AsyncWorker.getInstance().getHandler().post(() -> {
            onProgress(progress);

            if (onProgressListener != null) {
                onProgressListener.onProgress(progress);
            }
        });
    }

    public void onProgress(final PROGRESS progress) {
        mStatus = Status.RUNNING;
    }

    public void onProgress(final PROGRESS[] progress) {
        mStatus = Status.RUNNING;
    }

    /**
     * Call to cancel background work
     */
    public void cancel(boolean bool) {
        cancelled = bool;
    }

    /**
     *
     * @return Returns true if the background work should be cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Call this method after cancelling background work
     */
    protected void onCancelled() {
        AsyncWorker.getInstance().getHandler().post(() -> {
            if (onCancelledListener != null) {
                onCancelledListener.onCancelled();
            }
        });
    }

    /**
     * Work which you want to be done on UI thread before {@link #doInBackground(Object[])}
     */
    protected void onPreExecute() {

    }

    /**
     * Work on background
     * @param input Input data
     * @return      Output data
     * @throws Exception    Any uncought exception which occurred while working in background. If
     * any occurs, {@link #onBackgroundError(Exception)} will be executed (on the UI thread)
     */
    protected abstract OUTPUT doInBackground(INPUT input) throws Exception;

    /**
     * Work on background
     * @param input Input data
     * @return      Output data
     * @throws Exception    Any uncought exception which occurred while working in background. If
     * any occurs, {@link #onBackgroundError(Exception)} will be executed (on the UI thread)
     */
    protected abstract OUTPUT doInBackground(INPUT[] input) throws Exception;

    /**
     * Work which you want to be done on UI thread after {@link #doInBackground(Object[])}
     * @param output    Output data from {@link #doInBackground(Object[])}
     */
    protected void onPostExecute(OUTPUT output) {
        mStatus = Status.FINISHED;
    }

    /**
     * Triggered on UI thread if any uncought exception occurred while working in background
     * @param e Exception
     * @see #doInBackground(Object[])
     */
    protected abstract void onBackgroundError(Exception e);

    private OnProgressListener<PROGRESS> onProgressListener;
    public interface OnProgressListener<PROGRESS> {
        void onProgress(PROGRESS progress);
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

    /**
     * Returns the current status of this task.
     *
     * @return The current status.
     */
    public final Status getStatus() {
        return mStatus;
    }
}
