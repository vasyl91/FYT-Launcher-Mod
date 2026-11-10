package com.bumptech.glide.load.data;

import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> DEFAULT_FACTORY = new DataRewinder.Factory<Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder<Object> build(Object obj) {
            return new DefaultRewinder(obj);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };
    private final Map<Class<?>, DataRewinder.Factory<?>> rewinders = new HashMap();

    public synchronized void register(DataRewinder.Factory<?> factory) {
        this.rewinders.put(factory.getDataClass(), factory);
    }

    public synchronized <T> DataRewinder<T> build(T t) {
        DataRewinder.Factory<?> factory;
        Preconditions.checkNotNull(t);
        factory = this.rewinders.get(t.getClass());
        if (factory == null) {
            for (DataRewinder.Factory<?> factory2 : this.rewinders.values()) {
                if (factory2.getDataClass().isAssignableFrom(t.getClass())) {
                    factory = factory2;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = DEFAULT_FACTORY;
        }
        return (DataRewinder<T>) factory.build(t);
    }

    private static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object data;

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }

        DefaultRewinder(Object obj) {
            this.data = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public Object rewindAndGet() {
            return this.data;
        }
    }
}
