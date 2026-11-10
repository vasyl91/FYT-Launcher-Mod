package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractCookieSpec implements CookieSpec {
    public AbstractCookieSpec() {
        throw new RuntimeException("Stub!");
    }

    public void registerAttribHandler(String name, CookieAttributeHandler handler) {
        throw new RuntimeException("Stub!");
    }

    protected CookieAttributeHandler findAttribHandler(String name) {
        throw new RuntimeException("Stub!");
    }

    protected CookieAttributeHandler getAttribHandler(String name) {
        throw new RuntimeException("Stub!");
    }

    protected Collection<CookieAttributeHandler> getAttribHandlers() {
        throw new RuntimeException("Stub!");
    }
}
