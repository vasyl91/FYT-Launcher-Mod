package com.bumptech.glide.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class GlideSuppliers {

    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> GlideSupplier<T> memorize(final GlideSupplier<T> glideSupplier) {
        return new GlideSupplier<T>() { // from class: com.bumptech.glide.util.GlideSuppliers.1
            private volatile T instance;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public T get() {
                if (this.instance == null) {
                    synchronized (this) {
                        if (this.instance == null) {
                            this.instance = (T) Preconditions.checkNotNull(glideSupplier.get());
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}
