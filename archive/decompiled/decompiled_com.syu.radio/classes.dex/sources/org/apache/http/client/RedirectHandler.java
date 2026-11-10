package org.apache.http.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface RedirectHandler {
    URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException;

    boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext);
}
