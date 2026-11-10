package com.bumptech.glide.util.pool;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    private StateVerifier() {
    }

    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }
    }

    private static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        DebugStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) {
                throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        void setRecycled(boolean z) {
            if (z) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }
    }
}
