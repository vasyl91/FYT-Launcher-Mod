package com.android.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class AdvancedAsyncTask<INPUT, PROGRESS, OUTPUT> {
    private boolean cancelled = false;
    private Future<OUTPUT> outputFuture;

    public AdvancedAsyncTask() {

    }

    /**
     * @see #execute(Object)
     */
    public AdvancedAsyncTask<INPUT, PROGRESS, OUTPUT> execute() {
        return execute(null);
    }

    /**
     * Starts is all
     * @param input Data you want to work with in the background
     */
    public AdvancedAsyncTask<INPUT, PROGRESS, OUTPUT> execute(final INPUT input) {
        onPreExecute();

        ExecutorService executorService = AsyncWorker.getInstance().getExecutorService();
        outputFuture = executorService.submit(() -> {
            try {
                final OUTPUT output = doInBackground(input);
                AsyncWorker.getInstance().getHandler().post(() -> onPostExecute(output));
                return output;
            } catch (Exception e) {
                AsyncWorker.getInstance().getHandler().post(() -> onBackgroundError(e));
                throw e;
            }
        });

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

    protected void onProgress(final PROGRESS progress) {

    }

    /**
     * Call to cancel background work
     */
    public void cancel() {
        cancelled = true;
    }

    /**
     *
     * @return Returns true if the background work should be cancelled
     */
    protected boolean isCancelled() {
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
     * Work which you want to be done on UI thread before {@link #doInBackground(Object)}
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
     * Work which you want to be done on UI thread after {@link #doInBackground(Object)}
     * @param output    Output data from {@link #doInBackground(Object)}
     */
    protected void onPostExecute(OUTPUT output) {

    }

    /**
     * Triggered on UI thread if any uncought exception occurred while working in background
     * @param e Exception
     * @see #doInBackground(Object)
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
}
