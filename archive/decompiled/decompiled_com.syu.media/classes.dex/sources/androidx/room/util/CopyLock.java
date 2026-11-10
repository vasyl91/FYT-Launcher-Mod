package androidx.room.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CopyLock {
    private static final Map<String, Lock> sThreadLocks = new HashMap();
    private final File mCopyLockFile;
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final Lock mThreadLock;

    public CopyLock(String name, File lockDir, boolean processLock) {
        File file = new File(lockDir, name + ".lck");
        this.mCopyLockFile = file;
        this.mThreadLock = getThreadLock(file.getAbsolutePath());
        this.mFileLevelLock = processLock;
    }

    public void lock() {
        this.mThreadLock.lock();
        if (this.mFileLevelLock) {
            try {
                FileChannel channel = new FileOutputStream(this.mCopyLockFile).getChannel();
                this.mLockChannel = channel;
                channel.lock();
            } catch (IOException e) {
                throw new IllegalStateException("Unable to grab copy lock.", e);
            }
        }
    }

    public void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.mThreadLock.unlock();
    }

    private static Lock getThreadLock(String key) {
        Lock reentrantLock;
        Map<String, Lock> map = sThreadLocks;
        synchronized (map) {
            reentrantLock = map.get(key);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(key, reentrantLock);
            }
        }
        return reentrantLock;
    }
}
