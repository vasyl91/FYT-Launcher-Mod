package android.support.v4.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class Pools {

    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    private Pools() {
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int maxPoolSize) {
            if (maxPoolSize <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[maxPoolSize];
        }

        @Override // android.support.v4.util.Pools.Pool
        public T acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int i = this.mPoolSize - 1;
            T t = (T) this.mPool[i];
            this.mPool[i] = null;
            this.mPoolSize--;
            return t;
        }

        @Override // android.support.v4.util.Pools.Pool
        public boolean release(T instance) {
            if (isInPool(instance)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.mPoolSize >= this.mPool.length) {
                return false;
            }
            this.mPool[this.mPoolSize] = instance;
            this.mPoolSize++;
            return true;
        }

        private boolean isInPool(T instance) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == instance) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int maxPoolSize) {
            super(maxPoolSize);
            this.mLock = new Object();
        }

        @Override // android.support.v4.util.Pools.SimplePool, android.support.v4.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // android.support.v4.util.Pools.SimplePool, android.support.v4.util.Pools.Pool
        public boolean release(T element) {
            boolean zRelease;
            synchronized (this.mLock) {
                zRelease = super.release(element);
            }
            return zRelease;
        }
    }
}
