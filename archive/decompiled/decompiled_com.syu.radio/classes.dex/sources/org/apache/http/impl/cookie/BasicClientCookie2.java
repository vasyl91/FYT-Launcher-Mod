package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.cookie.SetCookie2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    public BasicClientCookie2(String name, String value) {
        super((String) null, (String) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public int[] getPorts() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setPorts(int[] ports) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public String getCommentURL() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setCommentURL(String commentURL) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setDiscard(boolean discard) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public boolean isExpired(Date date) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie
    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
