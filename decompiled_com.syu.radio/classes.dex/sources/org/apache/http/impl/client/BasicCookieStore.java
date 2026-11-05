package org.apache.http.impl.client;

import java.util.Date;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicCookieStore implements CookieStore {
    public BasicCookieStore() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized void addCookie(Cookie cookie) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void addCookies(Cookie[] cookies) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized List<Cookie> getCookies() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized boolean clearExpired(Date date) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized void clear() {
        throw new RuntimeException("Stub!");
    }
}
