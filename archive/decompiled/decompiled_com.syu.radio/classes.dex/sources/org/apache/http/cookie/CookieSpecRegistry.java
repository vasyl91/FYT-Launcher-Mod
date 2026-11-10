package org.apache.http.cookie;

import java.util.List;
import java.util.Map;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public final class CookieSpecRegistry {
    public CookieSpecRegistry() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void register(String name, CookieSpecFactory factory) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void unregister(String id) {
        throw new RuntimeException("Stub!");
    }

    public synchronized CookieSpec getCookieSpec(String name, HttpParams params) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    public synchronized CookieSpec getCookieSpec(String name) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    public synchronized List<String> getSpecNames() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setItems(Map<String, CookieSpecFactory> map) {
        throw new RuntimeException("Stub!");
    }
}
