package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    DiskCacheWriteLocker() {
    }

    void acquire(String str) {
        WriteLock writeLockObtain;
        synchronized (this) {
            writeLockObtain = this.locks.get(str);
            if (writeLockObtain == null) {
                writeLockObtain = this.writeLockPool.obtain();
                this.locks.put(str, writeLockObtain);
            }
            writeLockObtain.interestedThreads++;
        }
        writeLockObtain.lock.lock();
    }

    void release(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.checkNotNull(this.locks.get(str));
            if (writeLock.interestedThreads < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
            }
            writeLock.interestedThreads--;
            if (writeLock.interestedThreads == 0) {
                WriteLock writeLockRemove = this.locks.remove(str);
                if (!writeLockRemove.equals(writeLock)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLockRemove + ", safeKey: " + str);
                }
                this.writeLockPool.offer(writeLockRemove);
            }
        }
        writeLock.lock.unlock();
    }

    private static class WriteLock {
        int interestedThreads;
        final Lock lock = new ReentrantLock();

        WriteLock() {
        }
    }

    private static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool = new ArrayDeque();

        WriteLockPool() {
        }

        WriteLock obtain() {
            WriteLock writeLockPoll;
            synchronized (this.pool) {
                writeLockPoll = this.pool.poll();
            }
            return writeLockPoll == null ? new WriteLock() : writeLockPoll;
        }

        void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }
}
