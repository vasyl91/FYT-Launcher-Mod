package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.LoadTask mTask;
    long mUpdateThrottle;

    public abstract D loadInBackground();

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private CountDownLatch done = new CountDownLatch(1);
        D result;
        boolean waiting;

        LoadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.content.ModernAsyncTask
        public D doInBackground(Void... voidArr) {
            this.result = (D) AsyncTaskLoader.this.onLoadInBackground();
            return this.result;
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void onPostExecute(D data) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            } finally {
                this.done.countDown();
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void onCancelled() {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, this.result);
            } finally {
                this.done.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.waiting = AsyncTaskLoader.DEBUG;
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    public AsyncTaskLoader(Context context) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
    }

    public void setUpdateThrottle(long delayMS) {
        this.mUpdateThrottle = delayMS;
        if (delayMS != 0) {
            this.mHandler = new Handler();
        }
    }

    @Override // android.support.v4.content.Loader
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask();
        executePendingTask();
    }

    public boolean cancelLoad() {
        boolean cancelled = DEBUG;
        if (this.mTask != null) {
            if (this.mCancellingTask != null) {
                if (this.mTask.waiting) {
                    this.mTask.waiting = DEBUG;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.waiting) {
                this.mTask.waiting = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                cancelled = this.mTask.cancel(DEBUG);
                if (cancelled) {
                    this.mCancellingTask = this.mTask;
                }
                this.mTask = null;
            }
        }
        return cancelled;
    }

    public void onCanceled(D data) {
    }

    void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle > 0) {
                long now = SystemClock.uptimeMillis();
                if (now < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                    this.mTask.waiting = true;
                    this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                    return;
                }
            }
            this.mTask.executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
        }
    }

    void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask task, D data) {
        onCanceled(data);
        if (this.mCancellingTask == task) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask task, D data) {
        if (this.mTask != task) {
            dispatchOnCancelled(task, data);
            return;
        }
        if (isAbandoned()) {
            onCanceled(data);
            return;
        }
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(data);
    }

    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask task = this.mTask;
        if (task != null) {
            try {
                ((LoadTask) task).done.await();
            } catch (InterruptedException e) {
            }
        }
    }

    @Override // android.support.v4.content.Loader
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        if (this.mTask != null) {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(this.mTask);
            writer.print(" waiting=");
            writer.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(this.mCancellingTask);
            writer.print(" waiting=");
            writer.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0) {
            writer.print(prefix);
            writer.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, writer);
            writer.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), writer);
            writer.println();
        }
    }
}
