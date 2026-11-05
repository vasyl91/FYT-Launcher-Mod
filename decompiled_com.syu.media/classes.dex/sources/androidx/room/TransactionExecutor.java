package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    TransactionExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable command) {
        this.mTasks.offer(new Runnable() { // from class: androidx.room.TransactionExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    command.run();
                } finally {
                    TransactionExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    synchronized void scheduleNext() {
        Runnable runnablePoll = this.mTasks.poll();
        this.mActive = runnablePoll;
        if (runnablePoll != null) {
            this.mExecutor.execute(runnablePoll);
        }
    }
}
